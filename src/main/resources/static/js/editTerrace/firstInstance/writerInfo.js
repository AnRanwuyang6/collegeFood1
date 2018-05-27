var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};

$(function() {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_02').attr("class", "nav-item start active open");
    $('.edit_02_01').attr("class", "nav-item start active open");

    showDate();

    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });

    queryData(opts.current_page + 1, opts.items_per_page);

    $("#searchBtn").click(function(){
        queryData(opts.current_page + 1, opts.items_per_page);
    })

    $("#addUserSubmit").click(function(){
        addWriter();
    })

    $("#editUserPWDSubmit").click(function(){
        resetPWD();
    })

    $("#add_user_name").blur(function(){
        validateName();
    })
})

var queryData = function(page,size){
    $.ajax({
        url:"/firstInstance/getWriterPage",
        type:"post",
        data:{
            "page":page,
            "size":size,
            "condition":$("#searchInput").val()
        },
        success:function(data){
            if (data.code == "0000"){
                var html = '';
                $("#content").empty();

                var n = data.data.list;
                for (i in n) {
                    html += '<tr>'
                    html += ('<td style="width: 60px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 60px;" title="'+n[i].id+'">' + n[i].id + '</td>')
                    html += ('<td>'+ n[i].manuUserName +'</td>')
                    html += ('<td>')
                    if(n[i].manuUser == null){
                        html += ""
                    }else{
                        html += n[i].manuUser
                    }
                    html += ('</td>')
                    html += ('<td style="width: 60px;">')
                    if(n[i].pseudonym == null){
                        html += ('<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 60px;" title=""></td>')
                    }else{
                        html += ('<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 60px;" title="'+n[i].pseudonym+'">'+n[i].pseudonym+'</td>')
                    }
                    html += ('<td>'+ n[i].phone +'</td>')
                    if($("#isIndustryHiddenId").val() != 1) {
                        html += ('<td>' + n[i].sumManu + '</td>')
                    }
                    html += ('<td>'+ n[i].sumMoney +'</td>')
                    html += ('<td nowrap="nowrap"><div class="ui button" onclick="toInfo(\''+n[i].id+'\');">查看</div><div class="ui button" onclick="toResetPWD(\''+n[i].manuUserName+'\');">重置密码</div></td>')
                    html += '</tr>'
                }
                $("#content").append(html);
            }else{
                cautionModal(data.message)
            }
            //mybatis需要将data.data.number 减 1，JPA不需要做操作
            opts.current_page = data.data.pageNum - 1
            //每次成功请求后会重新初始化分页控件
            $('#page').pagination(data.data.total, opts);
        }
    })
}

var toAdd = function(){
    $("#add_user_name").val("")
    $("#add_user_phone").val("")
    $("#passVNId").html("")
    $("#errorVNId").html("")
    $("#errorId").html("")
    $("#addUserModal").modal('setting', 'closable', false).modal('show');
}

var addWriter = function(){

    $("#addUserSubmit").addClass("disabled")

    $.ajax({
        url:"/firstInstance/addWriter",
        type:"post",
        data:{
            "name":$("#add_user_name").val(),
            "phone":$("#add_user_phone").val()
        },
        beforeSend:function(){
            $("#errorId").html("")
            if ($("#add_user_name").val() == "" ||$("#add_user_name").val()==null){
                $("#errorId").html("用户名不能为空");
                $("#addUserSubmit").removeClass("disabled")
                return false;
            }
            if (!(/^[A-Za-z0-9]+$/.test($("#add_user_name").val()))){
                $("#errorId").html("用户名应由数字、字母组成");
                $("#addUserSubmit").removeClass("disabled")
                return false;
            }
            if ($("#add_user_phone").val() == "" ||$("#add_user_phone").val()==null){
                $("#errorId").html("手机号不能为空")
                $("#addUserSubmit").removeClass("disabled")
                return false;
            }
            if(!(/^1[34578]\d{9}$/.test($("#add_user_phone").val()))){
                $("#errorId").html("手机号格式不正确")
                $("#addUserSubmit").removeClass("disabled")
                return false;
            }
            return true;
            $("#errorId").html("")
        },
        success:function(data){
            if(data.code == "0000"){
                $("#addUserModal").modal("hide")
                cautionModal("添加成功");
                queryData(opts.current_page + 1, opts.items_per_page);
                $("#addUserSubmit").removeClass("disabled")
            }else{
                cautionModal(data.message);
                $("#addUserSubmit").removeClass("disabled")
            }

        }
    })
}

var toResetPWD = function(username){
    $("#pwdHidId").val(username);

    $("#editUserPWDModal").modal('setting', 'closable', false).modal('show');
}

var resetPWD = function(){
    $.ajax({
        url:"/firstInstance/resetPWD",
        type:"post",
        data:{
            "username":$("#pwdHidId").val()
        },
        success:function (data) {
            if(data.code == "0000"){
                cautionModal("重置密码已发送")
                $("#editUserPWDModal").modal("hide");
            }else{
                cautionModal(data.message);
            }
        }
    })
}

var toInfo = function (id) {
    $.ajax({
        url:"/firstInstance/selectWriterInfo",
        type:"post",
        data:{
            "id":id
        },
        success:function (data) {
            if (data.code == "0000"){
                var info = data.data;
                $("#nameInfo").html(info.manuUser);
                $("#protocolNumInfo").html(info.protocolNum);
                $("#certificateNumInfo").html(info.certificateNum);
                $("#phoneInfo").html(info.phone);
                $("#addressInfo").html(info.address);
                $("#payeeNameInfo").html(info.payeeName);
                $("#openAddrInfo").html(info.openAddress);
                $("#depositBankInfo").html(info.depositBankInformation);
                $("#accountNumInfo").html(info.accountNumber);

                $("#userInfoModal").modal('setting', 'closable', false).modal('show');
            }else{
                cautionModal(data.message)
            }
        }
    })
}

var validateName = function () {
    $.ajax({
        url:"/firstInstance/validateName",
        type:"post",
        data:{
            "name":$("#add_user_name").val()
        },
        beforeSend:function () {
            if ($("#add_user_name").val() == "" ||$("#add_user_name").val()==null){
                return false;
            }
            return true;
        },
        success:function (data) {
            if(data.code == "0000"){
                $("#passVNId").html("")
                $("#errorVNId").html("")
                // $("#passVNId").html("用户名可以使用")
                $("#errorId").html("")
            }else{
                $("#passVNId").html("")
                $("#errorVNId").html("")
                $("#errorVNId").html(data.message)
            }
        }
    })
}

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