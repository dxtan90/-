$(document).ready(function(){
    $("#resetButton").on("click",function(){
        $("#resetPassword").css('display','block');
    });
    $("#cancelReset").on("click",function () {
        $("#resetPassword").css('display','none');
    });
});
function check() {
    var puts = document.getElementsByClassName("psw_input");
    for(var i=0;i<3;i++){
        if(puts[i].value===""){
            alert("您还有未填项待填写！");
            return false;
        }
    }
    if(puts[1].value !== puts[2].value){
        alert("您输入的两次密码不一致！");
        return false;
    }else if(puts[0].value === puts[1].value){
        alert("新密码不能与旧密码相同！");
        return false;
    }
    return true;
}