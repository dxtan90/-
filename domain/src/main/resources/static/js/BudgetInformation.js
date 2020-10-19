let selectAction = function () {
    //设置选中框
    $("#pageSelect").val(1).attr("selected",true);
    getInfo();
};
let pageAction = function () {
    //设置当前页数
    $("#now_page").text("第"+$("#pageSelect").val()+"页");
    getInfo();
};
//判断出入账类型
function isOut(){
    let type = $("#actionTypeInfo").val();
    if("入账"===type){
        $("#RyNameL").attr("readonly","readonly");
        $("#RyNameL").css("background-color","grey");
    }else{
        $("#RyNameL").removeAttr("readonly");
        $("#RyNameL").css("background-color","white");
    }

};
function getInfo() {
                    let inout = $("#inoutSelect").val();
                    let time = $("#timeSelect").val();
                    let person = $("#personSelect").val();
                    let page = $("#pageSelect").val();

                    let t = {
                        "inout":inout,
                        "time":time,
                        "person":person,
                        "page":page
                    }
                    $.ajax({
                        url:"/Admin/budgetInformation/selectInfo",
                        data:JSON.stringify(t),
                        contentType: "application/json;charset=UTF-8",
                        dataType: 'json',
                        responseType:'json',
                        type: "post",
                        success:function (data) {
                            changeInfo(data,page);
                        }
                    });
                }
$("#inoutSelect").on("change", selectAction);
$("#timeSelect").on("change", selectAction);
$("#personSelect").on("change", selectAction);
$("#pageSelect").on("change", pageAction);

$("#pre").on("click",function () {
    let currentPage = $("#pageSelect").val();
    if(currentPage!=1){
        let now  = parseInt(currentPage)-1;
        $("#pageSelect").val(now).attr("selected",true);
        $("#now_page").text("第"+$("#pageSelect").val()+"页");
        getInfo();
    }
});


$("#next").on("click",function () {
    let currentPage = $("#pageSelect").val();
    let max = $("#pageSelect").children("option").length;
    if(currentPage!=max){
        let now  = parseInt(currentPage)+1;
        console.log(now);
        $("#pageSelect").val(now).attr("selected",true);

        $("#now_page").text("第"+$("#pageSelect").val()+"页");
        getInfo();
    }
});

$("#first").on("click",function () {
    let currentPage = $("#pageSelect").val();
    if(currentPage!=1){
        $("#pageSelect").val(1).attr("selected",true);

        $("#now_page").text("第"+$("#pageSelect").val()+"页");
        getInfo();
    }
});

$("#last").on("click",function () {
    let currentPage = $("#pageSelect").val();
    let max = $("#pageSelect").children("option").length;
    if(currentPage!=max){
        $("#pageSelect").val(max).attr("selected",true);

        $("#now_page").text("第"+$("#pageSelect").val()+"页");
        getInfo();
    }
});

function  changeInfo(data,page) {
    $(".showInfoTr").remove();
    $(".select_page").remove();
    console.log(data);
    let pages = data["pages"];

    changeStatus(page,pages);
    //设置总页数
    $("#max_page").text("共"+pages+"页");
    for(let i=1;i<=pages;i++){
        let option = $("<option>",{
            class:"select_page",
            text:i
        })
        $("#pageSelect").append(option);
    }
    $("#pageSelect").val(page).attr("selected",true);

    for(let d in data["layInfo"]){
        let obj = data["layInfo"][d];
        let tr = $("<tr>",{
            class:"showInfoTr"
        });
        let td1 = $("<td>",{
            text:obj["source"]
        });
        let td2 = $("<td>",{
            text:obj["ssum"]
        });
        let td3 = $("<td>",{
            text:obj["indate"]
        });
        let td4 = $("<td>",{
            text:obj["ryname"]
        });
        let td5 = $("<td>");

        let a = $("<button>",{
            text:"详细信息",
            class:"ec_main_button_vo_item_point",
            value:obj["id"]+" "+obj["in"]
        });
        td5.append(a);
        tr.append(td1);
        tr.append(td2);
        tr.append(td3);
        tr.append(td4);
        tr.append(td5);
        $("#tableShow").append(tr);
    }
    //给每个button添加点击事件
    $(".ec_main_button_vo_item_point").on("click",function () {
        clickUrl(this.value);
    })
}

function changeStatus(page,pages) {
    if(page==1){
        $("#first").css("color","grey");
        $("#pre").css("color","grey");

        $("#last").css("color","blue");
        $("#next").css("color","blue");
    }else if(page==pages){
        $("#first").css("color","blue");
        $("#pre").css("color","blue");
        $("#last").css("color","grey");
        $("#next").css("color","grey");
    }else{
        $("#first").css("color","blue");
        $("#pre").css("color","blue");
        $("#last").css("color","blue");
        $("#next").css("color","blue");
    }
}
//点击查看详细界面生成请求
function clickUrl(value) {
   let split = value.split(" ");
   let id = split[0];
   let type = "true"===split[1]?"in":"out";

    let t = {
        "id":id,
        "type":type,
    }
    $.ajax({
        url:"/Admin/budgetInformation/findInfo",
        data:JSON.stringify(t),
        contentType: "application/json;charset=UTF-8",
        dataType: 'json',
        responseType:'json',
        type: "post",
        success:function (data) {
            bondsInfo(data);
            $("#look_info_box").css("display","block");
            $("#main").css("opacity","0.3");
        }
    });
}
//将信息绑定到信息界面
function bondsInfo(data) {
    let type = data["in"]?"入账":"出账";
    $("#look_info_type").text(type);
    $("#look_info_itemId").text(data["itemid"]);
    $("#look_info_sum").text(data["sum"]);
    $("#look_info_date").text(data["indate"]);
    $("#look_info_ryName").text(data["ryname"]);
    $("#look_info_ryNameL").text(data["rynamel"]);
    $("#look_info_source").text(data["source"]);
    $("#look_info_memo").text(data["memo"]);
    $("#look_info_id").val(data["id"]);
    deleteBonds();
}
//将更新数据绑定到更新面板上
function bondsUpdateInfo(){
    $("#updateInfo_id").val($("#look_info_id").val());
    $("#itemId").val($("#look_info_itemId").text());
    $("#sum").val( $("#look_info_sum").text());
    $("#ryName").val($("#look_info_ryName").text());
    $("#ryNameL").val( $("#look_info_ryNameL").text());
    $("#inputDate").val($("#look_info_date").text());
    $("#Source").val($("#look_info_source").text());
    $("#memo").text( $("#look_info_memo").text());
    $("#actionTypeInfo").val($("#look_info_type").text());
}
//将添加面板数据清空
function clearInfo(){
    $("#updateInfo_id").val("");
    $("#itemId").val("");
    $("#sum").val("");
    $("#ryName").val("");
    $("#ryNameL").val("");
    $("#inputDate").val("");
    $("#Source").val("");
    $("#memo").text("");
}
//返回按钮事件
$("#disappear").on("click",function () {
    $("#look_info_box").css("display","none");
    $("#main").css("opacity","1");
});
//更新按钮事件
$("#updateInfo").on("click",function () {
    $("#look_info_box").css("display","none");
    $("#addBudgetInfo").css("display","block");
    //将事务设置为添加信息
    $("#addInfoForm").attr("action","/Admin/budgetInformation/updateInfo");
    bondsUpdateInfo();
    isOut();
});
//删除地址绑定
function deleteBonds() {
    let deleteUrl = "/Admin/budgetInformation/deleteInfo?id="+ $("#look_info_id").val()+"&type="+$("#look_info_type").text();
    $("#deleteInfoHref").attr("href",deleteUrl);
}