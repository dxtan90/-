let selectAction = function () {
    //设置选中框
    $("#pageSelect").val(1).attr("selected",true);
    getInfo();
}
let pageAction = function () {
    //设置当前页数
    $("#now_page").text("第"+$("#pageSelect").val()+"页");
    getInfo();
}
function getInfo() {
    let inout = $("#inoutSelect").val();
    let time = $("#timeSelect").val();
    let page = $("#pageSelect").val();

    let t = {
        "inout":inout,
        "time":time,
        "page":page
    }
    $.ajax({
        url:"/Admin/FourQuery/selectInfo",
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
    $(".table_main_tr").remove();
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
        let tr = $("<tr>",{
            class:"table_main_tr"
        });
        let td1 = $("<td>",{
            text:data["layInfo"][d]["id"],
            class:"table_th_td"
        });
        let td2 = $("<td>",{
            text:data["layInfo"][d]["indate"],
            class:"table_th_td"
        });
        let td3 = $("<td>",{
            text:data["layInfo"][d]["itemid"],
            class:"table_th_td"
        });
        let td4 = $("<td>",{
            text:data["layInfo"][d]["ssum"],
            class:"table_th_td"
        });
        let td5 = $("<td>",{
            text:data["layInfo"][d]["ryname"],
            class:"table_th_td"
        });
        let td6 = $("<td>",{
            text:data["layInfo"][d]["rynamel"],
            class:"table_th_td"
        });
        let td7 = $("<td>",{
            text:data["layInfo"][d]["source"],
            class:"table_th_td"
        });
        let td8 = $("<td>",{
            text:data["layInfo"][d]["memo"],
            class:"table_th_td"
        });
        tr.append(td1);
        tr.append(td2);
        tr.append(td3);
        tr.append(td4);
        tr.append(td5);
        tr.append(td6);
        tr.append(td7);
        tr.append(td8);
        $("#tableShow").append(tr);

    }
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
