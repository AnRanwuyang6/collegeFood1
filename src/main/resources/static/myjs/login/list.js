var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};
var flag;
$(function(){
    showDate()
    $("#loginSumbit").on('click',function () {
        loginSumbit();
    })
});

var showDate= function(){
    var date=new Date();
    var year=date.getFullYear();
    var month = date.getMonth()+1;
    var day = date.getDate();
    var str;
    var week = date.getDay();
    switch (week) {
        case 0:
            str = '日';
            break;
        case 1:
            str = '一';
            break;
        case 2:
            str = '二';
            break;
        case 3:
            str = '三';
            break;
        case 4:
            str = '四';
            break;
        case 5:
            str = '五';
            break;
        case 6:
            str = '六';
            break;
    }
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    var mydate =year+'-'+month+'-'+day ;
    var myday='今天是星期'+str;
    $("#day").text(myday);
    $("#data").text(mydate);
}


var loginSumbit=function () {
    var username=$("#username").val();
    var password=$("#password").val();
    $.ajax({
        url:'/login/in',
        type:'post',
        dataType:'json',
        async:false,
        data:{
            username:username,
            password:password
        },
        beforeSend:function(){
            if($("#username").val()==""){
                cautionModal("用户名不能为空")
                return false
            }
            if($("#password").val()==""){
                cautionModal("用户名不能为空")
                return false
            }

            return true;
        },
        success:function(data){
            if (data.code == '0000'){
                if(data.message=='用户不存在'){
                    alert(data.message);
                }else{
                    window.location.href="/test/html?pre="+data.message
                }

            }else{
                alert("失败")
            }
        }
    })
}
function checkMobile(){
    var phone =$("#phone").val();
    if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
        return false;
    }else{
        return true;
    }
}
var checkEmail=function () {
    var strEmail=$("#email").val();
    if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) {
        return true;
    } else{
        return false;
    }

}
var checkName=function () {
    var userName=$("#username").val()
    $.ajax({
        url:'/user/checkName',
        type:'post',
        dataType:'json',
        async:false,
        data:{
            userName:userName
        },
        success:function(data){
            if (data.code == '0000'){
                flag=data.data;
            }else{
                alert("失败")
            }
        }
    })
}

