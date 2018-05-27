var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};

$(function () {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_03').attr("class", "nav-item start active open");
    $('.edit_03_03').attr("class", "nav-item start active open");
    $('.edit_03_03_02').attr("class", "nav-item start active open");

    showDate();

    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });

    queryData(opts.current_page + 1, opts.items_per_page);

    $("#deptId").change(function () {
        queryData(opts.current_page + 1, opts.items_per_page);
    });

    $("#searchBtn").click(function () {
        queryData(opts.current_page + 1, opts.items_per_page);
    });

    $("#addEmployeeSubmit").click(function () {
        addEmployee();
    });

    $("#resetEmployeePWDSubmit").click(function () {
        resetPWD();
    });

    $("#editEmployeeSubmit").click(function () {
        updateEmployee();
    });

    $("#deleteEmployeeSubmit").click(function () {
        deleteEmployee();
    });

    $("#add_employee_user_name").blur(function () {
        validateName();
    });
});

var showDate = function () {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
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
    var mydate = year + '-' + month + '-' + day;
    var myday = '今天是星期' + str;
    $("#day").text(myday);
    $("#data").text(mydate);
};

var queryData = function (page, size) {
    $.ajax({
        url: "/secondInstance/getEmployeePage",
        type: "post",
        data: {
            "page": page,
            "size": size,
            "searchContent": $("#searchContentInput").val(),
            "deptId": $("#deptId").val()
        },
        success: function (data) {
            if (data.code == "0000") {
                var html = '';
                $("#content").empty();

                var n = data.data.list;
                for (i in n) {
                    html += '<tr>';
                    html += ('<td style="width: 60px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 60px;" title="'+n[i].id+'">' + n[i].id + '</td>');
                    html += ('<td >' + n[i].username + '</td>');
                    html += ('<td >' + n[i].name + '</td>');
                    html += ('<td >' + n[i].mobilePhone + '</td>');
                    html += ('<td>');
                    if (n[i].deptId == '2') {
                        html += ('一审编辑');
                    } else if (n[i].deptId == '3') {
                        html += ('二审主编');
                    } else if (n[i].deptId == '4') {
                        html += ('终审');
                    }
                    html += ('</td>');
                    html += ('<td nowrap="nowrap">');
                    html += ('<div class="ui button" onclick="toUpdateEmployee(\'' + n[i].username + '\', \'' + n[i].name + '\', \'' + n[i].mobilePhone + '\', \'' + n[i].deptId + '\');">修改</div>');
                    html += ('<div class="ui button" onclick="toDelete(\'' + n[i].id + '\', \'' + n[i].username + '\');">删除</div>');
                    html += ('<div class="ui button" onclick="toResetPWD(\'' + n[i].username + '\');">重置密码</div></td>');
                    html += ('</td>');
                    html += '</tr>';
                }
                $("#content").append(html);
            } else {
                cautionModal(data.message)
            }
            //mybatis需要将data.data.number 减 1，JPA不需要做操作
            opts.current_page = data.data.pageNum - 1;
            //每次成功请求后会重新初始化分页控件
            $('#page').pagination(data.data.total, opts);
        }
    })
};

var toSearch = function () {
    queryData(opts.current_page + 1, opts.items_per_page);
};

var toAdd = function () {
    $("#add_employee_user_name").val("");
    $("#add_employee_name").val("");
    $("#add_employee_phone").val("");
    $("#add_employee_role").val(2);
    $("#errorAddId").html("");
    $("#passAddEmployeeId").html("");
    $("#errorAddEmployeeId").html("");
    $("#addEmployeeModal").modal('setting', 'closable', false).modal('show');
};

var addEmployee = function () {
    $.ajax({
        url: "/secondInstance/addEmployee",
        type: "post",
        data: {
            "userName": $("#add_employee_user_name").val(),
            "name": $("#add_employee_name").val(),
            "mobilePhone": $("#add_employee_phone").val(),
            "deptId": $("#add_employee_role").val()
        },
        beforeSend: function () {
            $("#errorAddId").html("");
            if ($("#add_employee_user_name").val() == "" || $("#add_employee_user_name").val() == null) {
                $("#errorAddId").html("用户名不能为空");
                return false;
            }
            if ($("#errorAddEmployeeId").html() == "用户名已注册") {
                $("#errorAddId").html("用户名已注册");
                return false;
            }
            if ($("#add_employee_name").val() == "" || $("#add_employee_name").val() == null) {
                $("#errorAddId").html("姓名不能为空");
                return false;
            }
            if ($("#add_employee_phone").val() == "" || $("#add_employee_phone").val() == null) {
                $("#errorAddId").html("手机号不能为空");
                return false;
            }
            if (!(/^1[34578]\d{9}$/.test($("#add_employee_phone").val()))) {
                $("#errorAddId").html("手机号格式不正确");
                return false;
            }
            return true;
            $("#errorAddId").html("");
            $("#addEmployeeSubmit").addClass("disabled")
        },
        success: function (data) {
            if (data.code == "0000") {
                $("#addEmployeeModal").modal("hide");
                cautionModal("添加成功");
                queryData(opts.current_page + 1, opts.items_per_page);
                $("#addEmployeeSubmit").removeClass("disabled")
            } else {
                cautionModal(data.message);
                $("#addEmployeeSubmit").removeClass("disabled")
            }
        }
    })
};

var toResetPWD = function (username) {
    $("#hidResetEmployeePwdId").val(username);

    $("#resetEmployeePWDModal").modal('setting', 'closable', false).modal('show');
};

var resetPWD = function () {
    $.ajax({
        url: "/secondInstance/resetEmployeePWD",
        type: "post",
        data: {
            "username": $("#hidResetEmployeePwdId").val()
        },
        beforeSend: function () {
            $("#resetEmployeePWDSubmit").addClass("disabled")
        },
        success: function (data) {
            if (data.code == "0000") {
                cautionModal("重置密码已发送");
                queryData(opts.current_page + 1, opts.items_per_page);
                $("#resetEmployeePWDSubmit").removeClass("disabled");
            } else {
                cautionModal(data.message);
                $("#resetEmployeePWDSubmit").removeClass("disabled");
            }
        }
    })
};

var toUpdateEmployee = function (username, name, phone, deptId) {
    $("#update_employee_user_name").val(username).attr("disabled", "disabled");

    $("#update_employee_name").val(name).attr("disabled", "disabled");

    $("#update_employee_phone").val(phone);

    $("#update_employee_role").val(deptId);

    $("#errorUpdateId").html("");

    $("#editEmployeeModal").modal('setting', 'closable', false).modal('show');
};

var updateEmployee = function () {
    $.ajax({
        url: "/secondInstance/updateEmployee",
        type: "post",
        data: {
            "userName": $("#update_employee_user_name").val(),
            "mobilePhone": $("#update_employee_phone").val(),
            "deptId": $("#update_employee_role").val()
        },
        beforeSend: function () {
            $("#errorUpdateId").html("");
            if ($("#update_employee_phone").val() == "" || $("#update_employee_phone").val() == null) {
                $("#errorUpdateId").html("手机号不能为空");
                return false;
            }
            if ($("#update_employee_role").val() == "" || $("#update_employee_role").val() == null) {
                $("#errorUpdateId").html("角色不能为空");
                return false;
            }
            if (!(/^1[34578]\d{9}$/.test($("#update_employee_phone").val()))) {
                $("#errorUpdateId").html("手机号格式不正确");
                return false;
            }
            return true;
            $("#errorUpdateId").html("");
            $("#editEmployeeSubmit").addClass("disabled")
        },
        success: function (data) {
            if (data.code == "0000") {
                cautionModal("修改成功");
                queryData(opts.current_page + 1, opts.items_per_page);
                $("#editEmployeeSubmit").removeClass("disabled")
            } else {
                cautionModal(data.message);
                $("#editEmployeeSubmit").removeClass("disabled")
            }
        }
    })
};

var toDelete = function (id, userName) {
    $("#deleteEmployeeModal").modal('setting', 'closable', false).modal('show');
    $("#hidDeleteEmployeeId").val(id);
    $("#hidDeleteEmployeeUserName").val(userName);
};

var deleteEmployee = function () {
    $("#deleteEmployeeSubmit").addClass("disabled");
    $.ajax({
        url: "/secondInstance/deleteEmployee",
        type: "post",
        data: {
            "id": $("#hidDeleteEmployeeId").val(),
            "userName": $("#hidDeleteEmployeeUserName").val()
        },
        success: function (data) {
            if (data.code == "0000") {
                cautionModal("删除成功");
                queryData(opts.current_page + 1, opts.items_per_page);
                $("#deleteEmployeeSubmit").removeClass("disabled")
            } else {
                cautionModal(data.message);
                $("#deleteEmployeeSubmit").removeClass("disabled")
            }
        }
    })
};

var validateName = function () {
    $.ajax({
        url: "/secondInstance/validateName",
        type: "post",
        data: {
            "name": $("#add_employee_user_name").val()
        },
        beforeSend: function () {
            if ($("#add_employee_user_name").val() == "" || $("#add_employee_user_name").val() == null) {
                return false;
            }
            return true;
        },
        success: function (data) {
            if (data.code == "0000") {
                $("#passAddEmployeeId").html("");
                $("#errorAddEmployeeId").html("");
                $("#passAddEmployeeId").html("用户名可以使用")
            } else {
                $("#passAddEmployeeId").html("");
                $("#errorAddEmployeeId").html("");
                $("#errorAddEmployeeId").html(data.message)
            }
        }
    })
};