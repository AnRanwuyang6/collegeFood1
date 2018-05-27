/**
 * Created by yangzy on 2017/11/22.
 */
var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};

window.onload = function () {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_02').attr("class", "nav-item start active open");
    $('.edit_02_04').attr("class", "nav-item start active open");

    showDate();

    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });
};

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

//start 验证
var getObj = function (event) {
    var obj = event.srcElement || event.target;
    return obj;
}

var checkEmpty = function (obj, value) {
    if(!(''!=value && null!=value)){
        if(obj.id=='oldPwd'){
            obj.placeholder = '旧密码不能为空...';
            obj.parentNode.className = 'ui input error';
        }
        if(obj.id=='newPwd'){
            obj.placeholder = '新密码不能为空...';
            obj.parentNode.className = 'ui input error';
        }
        if(obj.id=='checkPwd'){
            obj.placeholder = '确认新密码不能为空...';
            obj.parentNode.className = 'ui input error';
        }
        return false;
    }
    return true;
}

var checkOldPwd = function (value) {
    var url = "/security/checkOldPwd";
    $.ajax({
        url:url,
        async:false,
        type:'post',
        dataType:'json',
        data:{
            'oldPwd':value
        },
        success:function (data) {
            if(data.code=='0000'){
                var result = data.data;
                if(result=='0'){
                    $('#check_1').css('display', 'none');
                    $('#check_1').attr('class', 'ui input');
                }else{
                    $('#check_1').css('display', 'inline');
                    $('#check_1').attr('class', 'ui input error');
                }
            }else{
                cautionModal(data.message);
            }
        }
    });
}

var blurOldPwd = function (event) {
    var obj = getObj(event);
    var value = obj.value;
    var result = checkEmpty(obj, value);
    if(result){
        checkOldPwd(value);
    }else{
        $('#check_1').css('display', 'none');
        $('#check_1').attr('class', 'ui input');
    }
    checkInput();
}

var blurNewPwd = function (event) {
    var obj = getObj(event);
    var value = obj.value;
    var result = checkEmpty(obj, value);
    if(result){
        if(value.length<6){
            $('#check_2').attr('class', 'ui input error');
            $('#check_2').css('display', 'inline');
        }else{
            $('#check_2').attr('class', 'ui input');
            $('#check_2').css('display', 'none');
            var checkPwd = $('#checkPwd').val();
            if(checkPwd!='' && checkPwd!= null){
                if(value!=checkPwd){
                    $('#check_3').attr('class', 'ui input error');
                    $('#check_3').css('display', 'inline');
                }else{
                    $('#check_3').attr('class', 'ui input');
                    $('#check_3').css('display', 'none');
                }
            }
        }
    }else{
        $('#check_2').attr('class', 'ui input');
        $('#check_2').css('display', 'none');
    }
    checkInput();
}

var blurCheckPwd = function (event) {
    var obj = getObj(event);
    var value = obj.value;
    var result = checkEmpty(obj, value);
    if(result){
        var newPwd = $('#newPwd').val();
        if(newPwd!='' && newPwd!=null){
            if(value != newPwd){
                $('#check_3').attr('class', 'ui input error');
                $('#check_3').css('display', 'inline');
            }else{
                $('#check_3').attr('class', 'ui input');
                $('#check_3').css('display', 'none');
            }
        }
    }else{
        $('#check_3').attr('class', 'ui input');
        $('#check_3').css('display', 'none');
    }
    checkInput();
}

var focusCheck = function (event) {
    var obj = getObj(event);
    if(obj.id=='oldPwd'){
        obj.placeholder = '请输入旧密码...';
        obj.parentNode.className = 'ui input';
    }
    if(obj.id=='newPwd'){
        obj.placeholder = '请输入新密码...';
        obj.parentNode.className = 'ui input';
    }
    if(obj.id=='checkPwd'){
        obj.placeholder = '请再次输入新密码...';
        obj.parentNode.className = 'ui input';
    }
}

var checkInput = function () {
    var errorArray = $('.error');
    if(errorArray.length==0){
        $('#submitButton').removeAttr('disabled');
        $('#submitButton').attr('class', 'ui primary button');
    }else{
        $('#submitButton').attr('disabled', 'disabled');
        $('#submitButton').attr('class', 'ui button');
    }
}
//end 验证

var savePwd = function () {
    var url = "/security/save";
    var newPwd = $('#newPwd').val();
    $.ajax({
        url:url,
        type:'post',
        dataType:'json',
        data:{
            'newPwd':newPwd
        },
        success:function (data) {
            if(data.code=='0000'){
                var html = '';
                $("#oldPwd").val(html)
                $("#newPwd").val(html)
                $("#checkPwd").val(html)
                cautionModal("操作成功");
            }else{
                cautionModal(data.message);
            }
        }
    });
}

var quit = function () {
    var text = '';
    $('#oldPwd').html(text);
    $('#newPwd').html(text);
    $('#checkPwd').html(text);
}