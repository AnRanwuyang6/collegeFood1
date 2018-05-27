var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};

$(function() {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_03').attr("class", "nav-item start active open");
    $('.edit_03_01').attr("class", "nav-item start active open");

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
    });

    $("#submit").click(function () {
        $("#submit").addClass("disabled");
        var id = $("#hidSubmitId").val();
        window.location.href = '/secondInstance/transferManuscriptById?id=' + id;
    })
});

var queryData = function(page,size){
    $.ajax({
        url:"/secondInstance/getMyManuPage",
        type:"post",
        data:{
            "page":page,
            "size":size,
            "beginTime": $("#beginTime").val(),
            "endTime": $("#endTime").val(),
            "searchContent": $("#searchContentInput").val(),
            "manuStatus":$("#manuStatusSelect").val()
        },
        success:function(data){
            if (data.code == "0000"){
                var html = '';
                $("#content").empty();

                var n = data.data.list;
                for (i in n) {
                    html += '<tr>';
                    html += ('<td style="width: 60px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 60px;" title="'+n[i].orderId+'">' + n[i].orderId + '</td>');
                    html += ('<td style="width: 100px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 100px;" title="'+n[i].manuName+'"><a onclick="toDetailPage(\''+n[i].id+'\');">'+ n[i].manuName +'</a></td>');
                    html += ('<td style="width: 120px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 120px;" title="'+n[i].manuUrl+'">'+ n[i].manuUrl +'</td>');
                    html += ('<td nowrap="nowrap">'+ n[i].tSubmitTimeStr +'</td>');
                    html += ('<td>');
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
                    html += ('</td>');
                    html += ('<td nowrap="nowrap" style="text-align: center">');
                    if(n[i].manuStatus == '0'){
                        html += ('<div class="ui button" onclick="toEditManu(\''+n[i].id+'\');">编辑</div><div class="ui red button" onclick="del(\''+n[i].id+'\');">删除</div><div class="ui primary button" onclick="submitInList(\''+n[i].id+'\')">提交</div>')
                    }else if(n[i].manuStatus == '8'){
                        html += ('<div class="ui button" onclick="toEditManu(\''+n[i].id+'\');">编辑</div><div class="ui primary button" onclick="submitInList(\''+n[i].id+'\')">提交</div>')
                    }else{
                        html += ('<div class="ui button" onclick="toDetailPage(\''+n[i].id+'\');">查看</div>')
                    }
                    html += ('</td>');
                    html += '</tr>'
                }
                $("#content").append(html);
            }else{
                cautionModal(data.message);
            }
            //mybatis需要将data.data.number 减 1，JPA不需要做操作
            opts.current_page = data.data.pageNum - 1;
            //每次成功请求后会重新初始化分页控件
            $('#page').pagination(data.data.total, opts);
        }
    })
};

var toDetailPage = function (id) {
    window.location.href="/secondInstance/toManuDetail?id="+id;
};

var toAdd = function(){
    window.location.href = "/secondInstance/toAddManu";
};

var toSearch = function () {
    if ($("#beginTime") == null || $("#beginTime") == "") {
        alert("请选择开始日期!");
    }
    if ($("#endTime") == null || $("#endTime") == "") {
        alert("请选择结束日期!");
    }
    queryData(opts.current_page + 1, opts.items_per_page);
};

var del = function (id) {
    $("#hidDeleteId").val(id);
    $("#deleteModal").modal('setting', 'closable', false).modal('show');
};

var deleteManu = function () {
    $.ajax({
        url:"/secondInstance/deleteManu",
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
                $("#deleteSubmit").removeClass("disabled");
                $("#deleteModal").modal('hide')
                cautionModal(data.message)
            }
        }
    })
};

var submitInList = function (id) {
    $("#hidSubmitId").val(id);
    $("#submitModal").modal('setting', 'closable', false).modal('show');
};

var toEditManu = function (id) {
    window.location.href = "/secondInstance/toEditManu?id="+id
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
};

