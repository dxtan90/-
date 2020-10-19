
let addShowL = function () {
    //清空原有信息
    clearInfo();
    $("#main").css("opacity","0.3");
    $("#addBudgetInfo").css("display","block");
    //将事务设置为添加信息
    $("#addInfoForm").attr("action","/Admin/budgetInformation/addInfo");
    $("#inputDate").val(getCurrent());
};
let addCancel = function (){
    $("#main").css("opacity","1");
    $("#addBudgetInfo").css("display","none");
};



let checkInfo = function(){
    let type = $("#actionTypeInfo").val();
    let pass = true;
    if($("#itemId").val()==''){
        pass=false;
        alert("经费明细编号不为空");
    }
    if($("#sum").val()==''){
        pass=false;
        alert("金额不能为空");
    }
    if($("#ryName").val()==''){
        pass=false;
        alert("经办人不能为空");
    }
    if(type==="出账"&&$("#ryNameL")==''){
        pass=false;
        alert("批准人不能为空");
    }
    console.log(pass)
    if($("#source")==''){
        pass=false;
        alert("使用摘要/用度方向不能为空");
    }

    if(pass){
        $("#addInfoForm").submit();
    }
};
//判断类型
let typeFunc =function(){
    isOut();
}

$("#budgetAddInfo_actionButton").on("click",addShowL);
$("#addInfoCancel").on("click",addCancel);
$("#actionTypeInfo").on("change",typeFunc);
$("#submitInfo").on("click",checkInfo);


function getCurrent() {
    let now = new Date;
    let year = now.getFullYear();
    let month = now.getMonth()+1;
    let day = now.getDate();
    let hour = now.getHours();
    let min = now.getMinutes();
    let sec = now.getSeconds();

    if(month<10)month="0"+month;
    if(day<10)day="0"+day;
    if(hour<10)hour="0"+hour;
    if(min<10)min="0"+min;
    if(sec<10)sec="0"+sec;
    return year+"/"+month+"/"+day+" "+hour+":"+min+":"+sec;
}