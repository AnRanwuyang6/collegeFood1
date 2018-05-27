/**
 * Created by yangzy on 2017/11/24.
 */
window.onload = function () {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_01').attr("class", "nav-item start active open");
    $('.edit_01_02').attr("class", "nav-item start active open");

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
var checkEmpty = function () {
    var inputs = $('.input');
    for(var i=0,size=inputs.length;i<size;i++){
        var input = inputs[i];
        var value = input.value;
        if(value==''||value==null){
            $(input).css('background-color', '#fde7e5');
            var text = input.parentNode.previousSibling.previousSibling.firstChild.nextSibling.firstChild.nextSibling.innerText;
            $(input).attr('placeholder', text+'不能为空...');
            $(input).attr('class', 'form-control error');
        }
    }
}

var checkError = function () {
    var errors = $('.error');
    if(errors.length>0){
        return true;
    }
    return false;
}

var onfocusCheck = function (event) {
    var input = event.srcElement || event.target;
    $(input).removeAttr('style');
    var text = input.parentNode.previousSibling.previousSibling.firstChild.nextSibling.firstChild.nextSibling.innerText;
    $(input).attr('placeholder', '请输入'+text+'...');
    $(input).attr('class', 'form-control input');
    if('phone'==input.name){
        $('#checkPhone').css('display', 'none');
        $('#checkPhone').removeAttr('class');
    }
    if('certificate'==input.name){
        $('#certificateCheck').css('display', 'none');
        $('#certificateCheck').removeAttr('class');
    }
    if('account'==input.name){
        $('#accountCheck').css('display', 'none');
        $('#accountCheck').removeAttr('class');
    }
    if('protocolNum'==input.name){
        $('#protocolNumCheck').css('display', 'none');
        $('#protocolNumCheck').removeAttr('class');
    }
}

//手机号验证
var checkPhone = function (event) {
    var input = event.srcElement || event.target;
    var value = input.value;
    if(value!='' && value!=null){
        if(!(/^1[34578]\d{9}$/.test(value))){
            $('#checkPhone').css('display', 'inline');
            $('#checkPhone').attr('class', 'error');
        }
    }
}

//身份证验证
var certificateCheck = function (event) {
    var input = event.srcElement || event.target;
    var code = input.value;
    if(code!='' && code!=null){
        var result = identityCodeValid(code);
        if(!result){
            $('#certificateCheck').css('display', 'inline');
            $('#certificateCheck').attr('class', 'error');
        }
    }
}

var identityCodeValid = function (code) {
    var result = true;
    var reg = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/;
    if(!reg.test(code)){
        result = false;
    }
    return result;
}

//校验银行账号
var accountCheck = function (event) {
    var input = event.srcElement || event.target;
    var account = input.value;
    if(account!='' && account!=null){
        var result = accountValid(account);
        if(!result){
            $('#accountCheck').css('display', 'inline');
            $('#accountCheck').attr('class', 'error');
        }
    }
}

//校验劳务协议号长度
var protocolNumCheck = function (event) {
    var input = event.srcElement || event.target;
    var account = input.value;
    if(account!='' && account!=null){
        if(account.length>18){
            $('#protocolNumCheck').css('display', 'inline');
            $('#protocolNumCheck').attr('class', 'error');
        }
    }
}

var accountValid = function (account) {
    if(account.length<16 || account.length>19)
        return false;
    var numCheck = /^\d*$/;
    if(!numCheck.exec(account))
        return false;
    var cardBin = "10,18,30,35,37,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,58,60,62,65,68,69,84,87,88,94,95,98,99";
    if(cardBin.indexOf(account.substring(0, 2)) == -1)
        return false;
    if(!identityAccountValid(account))
        return false;
    return true;
}

var identityAccountValid = function (account) {
    var lastNum = account.substr(account.length-1, 1);
    var front15or18Num = account.substr(0, account.length-1);
    var arrays = new Array();
    for(var i=front15or18Num.length-1;i>-1;i--){
        arrays.push(front15or18Num.substr(i, 1));
    }
    var oddLtNine = new Array();
    var oddRtNine = new Array();
    var evenNum = new Array();
    for(var j=0;j<arrays.length;j++){
        if((j+1)%2==1) {
            if (parseInt(arrays[j]) * 2 < 9)
                oddLtNine.push(parseInt(arrays[j]) * 2);
            else
                oddRtNine.push(parseInt(arrays[j]) * 2);
        }else
            evenNum.push(arrays[j]);
    }
    var oddRtNine_child_one = new Array();
    var oddRtNine_child_two = new Array();
    for(var h=0;h<oddRtNine.length;h++){
        oddRtNine_child_one.push(parseInt(oddRtNine[h])%10);
        oddRtNine_child_two.push(parseInt(oddRtNine[h])/10);
    }
    var sum_oddLtNine = 0;
    var sum_evenNum = 0;
    var sum_oddLtNine_one = 0;
    var sum_oddLtNine_two = 0;
    var sum_total = 0;
    for(var m=0;m<oddLtNine.length;m++){
        sum_oddLtNine = sum_oddLtNine + parseInt(oddLtNine[m]);
    }
    for(var n=0;n<evenNum.length;n++){
        sum_evenNum = sum_evenNum + parseInt(evenNum[n]);
    }
    for(var p=0;p<oddRtNine_child_one.length;p++){
        sum_oddLtNine_one = sum_oddLtNine_one + parseInt(oddRtNine_child_one[p]);
        sum_oddLtNine_two = sum_oddLtNine_two + parseInt(oddRtNine_child_two[p]);
    }
    sum_total = parseInt(sum_oddLtNine) + parseInt(sum_evenNum) + parseInt(sum_oddLtNine_one) + parseInt(sum_oddLtNine_two);
    var k = parseInt(sum_total)%10==0?10:parseInt(sum_total)%10;
    var luhm = 10 - k;
    if(lastNum==luhm && lastNum.length!=0)
        return true;
    else
        return false;
}
//end 验证

var savePersonal = function () {
    checkEmpty();
    if(checkError()){
        return;
    }
    saveInformation();
}

var saveInformation = function () {
    var url = '/personal/save';
    $.ajax({
        url:url,
        type:'post',
        dataType:'json',
        data:{
            'manuUser':$("input[name='manuUser']").val(),
            'pseudonym':$("input[name='pseudonym']").val(),
            'phone':$("input[name='phone']").val(),
            'address':$("input[name='address']").val(),
            'protocolNum':$("input[name='protocolNum']").val(),
            'certificateNum':$("input[name='certificate']").val(),
            'payeeName':$("input[name='payeeName']").val(),
            'openAddress':$("input[name='openAddress']").val(),
            'depositBankInformation':$("input[name='depositBankInformation']").val(),
            'accountNumber':$("input[name='account']").val()
        },
        success:function (data) {
            if(data.code=='0000'){
                cautionModal("成功");
            }else{
                cautionModal(data.message);
            }
        }
    });
}

var quit = function () {
    var inputs = $('input');
    for(var i=0,size=inputs.length;i<size;i++){
        var input = inputs[i];
        $(input).removeAttr('style');
        var text = input.parentNode.previousSibling.previousSibling.firstChild.nextSibling.firstChild.nextSibling.innerText;
        $(input).attr('placeholder', '请输入'+text+'...');
        $(input).attr('class', 'form-control input');
        var value = '';
        $(input).val(value);
        if('phone'==input.name){
            $('#checkPhone').css('display', 'none');
            $('#checkPhone').removeAttr('class');
        }
        if('certificate'==input.name){
            $('#certificateCheck').css('display', 'none');
            $('#certificateCheck').attr('class');
        }
        if('account'==input.name){
            $('#accountCheck').css('display', 'none');
            $('#accountCheck').attr('class');
        }
    }
}