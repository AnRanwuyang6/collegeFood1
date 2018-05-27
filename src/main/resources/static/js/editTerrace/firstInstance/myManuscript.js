var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};

$(function() {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_02').attr("class", "nav-item start active open");
    $('.edit_02_02').attr("class", "nav-item start active open");

    showDate();

    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });

    queryData(opts.current_page + 1, opts.items_per_page);

    $("#manuStatusSelect").change(function(){
        queryData(opts.current_page + 1, opts.items_per_page);
    });

    $("#deleteSubmit").click(function () {
        $("#deleteSubmit").addClass("disabled");
        deleteManu();
    })

    $("#submit").click(function () {
        $("#submit").addClass("disabled")
        submitManu();
    })
});

var queryData = function(page,size){
    $.ajax({
        url:"/firstInstance/getMyManuPage",
        type:"post",
        data:{
            "page":page,
            "size":size,
            "beginTime": $("#beginTime").val(),
            "endTime": $("#endTime").val(),
            "searchName": $("#searchNameInput").val(),
            "manuStatus":$("#manuStatusSelect").val()
        },
        success:function(data){
            if (data.code == "0000"){
                var html = '';
                $("#content").empty();

                var n = data.data.list;
                for (i in n) {
                    html += '<tr>'
                    html += ('<td style="width: 60px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 60px;" title="'+n[i].orderId+'">' + n[i].orderId + '</td>')
                    html += ('<td style="width: 100px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 100px;" title="'+n[i].manuName+'"><a onclick="toInfoPage(\''+n[i].id+'\');">'+ n[i].manuName +'</a></td>')
                    html += ('<td style="width: 120px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 120px;" title="'+n[i].manuUrl+'">'+ n[i].manuUrl +'</td>')
                    html += ('<td nowrap="nowrap">'+ n[i].tSubmitTimeStr +'</td>')
                    html += ('<td>')
                    if (n[i].manuStatus == '0') {
                        html += ('待提交')
                    } else if (n[i].manuStatus == '1') {
                        html += ('审核中')
                    } else if (n[i].manuStatus == '2') {
                        html += ('待一审')
                    } else if (n[i].manuStatus == '3') {
                        html += ('待二审')
                    } else if (n[i].manuStatus == '4') {
                        html += ('待终审')
                    } else if (n[i].manuStatus == '5') {
                        html += ('等待迁移')
                    } else if (n[i].manuStatus == '6') {
                        html += ('等待发布')
                    } else if (n[i].manuStatus == '7') {
                        html += ('已发布')
                    } else if (n[i].manuStatus == '8') {
                        html += ('打回')
                    } else if (n[i].manuStatus == '9') {
                        html += ('废弃')
                    }else if (n[i].manuStatus == 'a'){
                        html += ('审批单完成')
                    }
                    html += ('</td>')
                    html += ('<td nowrap="nowrap" style="text-align: center">')
                    if(n[i].manuStatus == '0'){
                        html += ('<div class="ui button" onclick="toEditManu(\''+n[i].id+'\');">编辑</div><div class="ui red button" onclick="del(\''+n[i].id+'\');">删除</div><div class="ui primary button" onclick="submitInList(\''+n[i].id+'\')">提交</div>')
                    }else if(n[i].manuStatus == '8'){
                        html += ('<div class="ui button" onclick="toEditManu(\''+n[i].id+'\');">编辑</div><div class="ui primary button" onclick="submitInList(\''+n[i].id+'\')">提交</div>')
                    }else{
                        html += ('<div class="ui button" onclick="toInfoPage(\''+n[i].id+'\');">查看</div>')
                    }
                    html += ('</td>')
                    html += '</tr>'
                }
                $("#content").append(html);
            }else{
                cautionModal(data.message);
            }
            //mybatis需要将data.data.number 减 1，JPA不需要做操作
            opts.current_page = data.data.pageNum - 1
            //每次成功请求后会重新初始化分页控件
            $('#page').pagination(data.data.total, opts);
        }
    })
}

var toInfoPage = function (id) {
    window.location.href="/firstInstance/toInfoPage?id="+id;
}

var toAdd = function(){
    window.location.href = "/firstInstance/toAddManu";
};

var toSearch = function () {
    queryData(opts.current_page + 1, opts.items_per_page);
};

var del = function (id) {
    $("#hidDeleteId").val(id);
    $("#deleteModal").modal('setting', 'closable', false).modal('show');
}

var deleteManu = function () {
    $.ajax({
        url:"/firstInstance/del",
        type:"post",
        data:{
            "id":$("#hidDeleteId").val()
        },
        success:function (data) {
            if (data.code == "0000"){
                $("#deleteSubmit").removeClass("disabled");
                $("#deleteModal").modal('hide')
                queryData(opts.current_page + 1, opts.items_per_page);
            }else{
                cautionModal(data.message)
                $("#deleteModal").modal('hide')
                $("#deleteSubmit").removeClass("disabled");
            }
        }
    })
}

var submitInList = function (id) {
    $("#hidSubmitId").val(id)
    $("#submitModal").modal('setting', 'closable', false).modal('show');
}

var submitManu = function(){
    $.ajax({
        url:"/firstInstance/submitById",
        type:"post",
        data:{
            "id":$("#hidSubmitId").val()
        },
        success:function (data) {
            if(data.code == "0000"){
                cautionModal("提交成功")
                queryData(opts.current_page + 1, opts.items_per_page);
                $("#submit").removeClass("disabled")
            }else{
                cautionModal(data.message)
                $("#submit").removeClass("disabled")
            }
        }
    })
}

var toEditManu = function (id) {
    window.location.href = "/firstInstance/toEditManu?id="+id
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
};

