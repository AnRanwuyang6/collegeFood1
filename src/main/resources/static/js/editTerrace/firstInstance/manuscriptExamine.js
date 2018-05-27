var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};

$(function() {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_02').attr("class", "nav-item start active open");
    $('.edit_02_03').attr("class", "nav-item start active open");

    showDate();

    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });

    $('#selectTime').dropdown();

    queryData(opts.current_page + 1, opts.items_per_page);

    $("#searchId").click(function(){
        queryData(opts.current_page + 1, opts.items_per_page);
    })

    $("#appointSelect").change(function(){
        queryData(opts.current_page + 1, opts.items_per_page);
    })

    $("#manuStatusSelect").change(function(){
        queryData(opts.current_page + 1, opts.items_per_page);
    })

})

var queryData = function(page,size){
    $.ajax({
        url:"/firstInstance/getExaminePage",
        type:"post",
        data:{
            "page":page,
            "size":size,
            "selectTime":$("#selectTime").val(),
            "start":$("#start").val(),
            "end":$("#end").val(),
            "condition":$.trim($("#condition").val()),
            "appointUserName":$("#appointSelect").val(),
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
                    html += ('<td style="width: 100px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 100px;" title="'+n[i].manuName+'"><a onclick="toDetail(\''+n[i].id+'\')">'+ n[i].manuName +'</a></td>')
                    html += ('<td >'+ n[i].manuUser +'</td>')
                    html += ('<td style="width: 100px;"><div title="'+n[i].tSubmitTimeStr+'">'+ n[i].tSubmitTimeStr +'</td>')
                    html += ('<td style="width: 100px;">'+ n[i].manuAppointUser +'</td>')
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
                    } else if (n[i].manuStatus == 'a') {
                        html += ('审批单完成')
                    }
                    html += ('</td>')
                    html += ('<td style="width: 100px;"><div title="'+n[i].tPublishTimeStr+'">'+ n[i].tPublishTimeStr +'</td>')
                    if($("#hiddenIsIndustryId").val() != 1) {
                        html += ('<td >')
                        if (n[i].manuSum == null) {
                            html += '--';
                        } else {
                            html += n[i].manuSum;
                        }
                        html += ('</td>')
                    }
                    html += ('<td >'+ n[i].wordCount +'</td>')
                    html += ('<td nowrap="nowrap"><div class="ui button" onclick="toDetail(\''+n[i].id+'\')">查看</div></td>')
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

var toDetail = function(id){
    window.location.href="/firstInstance/toDetail?id=" + id
}

var exportAll = function () {
    if ($("#selectTime").val() != 2) {
        alert("请选择发布时间");
    } else if ($("#start").val() == null || $("#start").val() == "") {
        alert("请选择开始日期");
    } else if ($("#end").val() == null || $("#end").val() == "") {
        alert("请选择结束日期");
    } else {
        var postData, url;
        postData = {};

        postData["beginTime"] = $("#start").val();
        postData["endTime"] = $("#end").val();
        postData["condition"] = $("#condition").val();

        url = "/firstInstance/exportManuscriptAll?";
        $.each(postData, function (i, item) {
            if (item != null && item != "") {
                url += "&" + i + "=" + item;
            }
        });

        location.href = url;
    }
}

var exportDetail = function () {
    if ($("#selectTime").val() != 2) {
        alert("请选择发布时间");
    } else if ($("#start").val() == null || $("#start").val() == "") {
        alert("请选择开始日期");
    } else if ($("#end").val() == null || $("#end").val() == "") {
        alert("请选择结束日期");
    } else {
        var postData, url;
        postData = {};

        postData["beginTime"] = $("#start").val();
        postData["endTime"] = $("#end").val();
        postData["condition"] = $("#condition").val();

        url = "/firstInstance/exportManuscriptDetail?";
        $.each(postData, function (i, item) {
            if (item != null && item != "") {
                url += "&" + i + "=" + item;
            }
        });

        location.href = url;
    }
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