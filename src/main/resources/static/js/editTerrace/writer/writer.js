/**
 * Created by yangzy on 2017/11/27.
 */
var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};

window.onload = function () {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_01').attr("class", "nav-item start active open");
    $('.edit_01_01').attr("class", "nav-item start active open");

    showDate();

    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });
    queryData(opts.current_page+1, opts.items_per_page);

    clickEvent();

    $("#toUserInfoSubmit").click(function () {
        window.location.href = '/personal/setting';
    })
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

var queryData = function (page, size) {
    var url = "/writer/list"
    $.ajax({
        url:url,
        type:'post',
        dataType:'json',
        data:{
            page:page,
            size:size,
            manuStatus:$('#selectManuStatus').val(),
            beginTime:$('#beginTime').val(),
            endTime:$('#endTime').val(),
            searchName:$('#manuName').val()
        },
        success:function (data) {
            var html = '';
            $('#tBody').html(html);
            if(data.code=='0000'){
                var n = data.data.list;
                for(i in n){
                    html += '<tr>'
                    html += ('<td style="width: 60px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 60px;" title="'+n[i].orderId+'">' + n[i].orderId + '</td>')
                    html += ('<td style="width: 100px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 100px;" title="'+n[i].manuName+'"><a onclick="toDetail(\''+n[i].id+'\');">'+ n[i].manuName +'</a></td>')
                    html += ('<td style="width: 120px;"><div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 120px;" title="'+n[i].manuUrl+'">'+ n[i].manuUrl +'</td>')
                    html += ('<td nowrap="nowrap">'+ n[i].tSubmitTimeStr +'</td>')
                    html += ('<td>')
                    if (n[i].manuStatus == '0') {
                        html += ('待提交')
                    } else if (n[i].manuStatus == '1') {
                        html += ('审核中')
                    } else if (n[i].manuStatus == '2') {
                        html += ('审核中')
                    } else if (n[i].manuStatus == '3') {
                        html += ('审核中')
                    } else if (n[i].manuStatus == '4') {
                        html += ('审核中')
                    } else if (n[i].manuStatus == '5') {
                        html += ('审核中')
                    } else if (n[i].manuStatus == '6') {
                        html += ('审核中')
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
                    if($("#isIndustryHiddenId").val() ==1) {

                    }else{
                        html += ('<td>')
                        if (n[i].manuSum == null || n[i].manuStatus=='1' || n[i].manuStatus=='2' || n[i].manuStatus=='3' || n[i].manuStatus=='4' || n[i].manuStatus=='5' || n[i].manuStatus=='6') {
                            html += "--"
                        } else {
                            html += n[i].manuSum
                        }
                        html += ('</td>')
                    }

                    html += ('<td nowrap="nowrap" style="text-align: center">')
                    if(n[i].manuStatus == '0'){
                        html += ('<div class="ui button" onclick="toEdit(\''+n[i].id+'\');">编辑</div><div class="ui red button" onclick="toDel(\''+n[i].id+'\');">删除</div><div class="ui primary button" onclick="toSubmit(\''+n[i].id+'\')">提交</div>')
                    }else if(n[i].manuStatus == '8'){
                        html += ('<div class="ui button" onclick="toEdit(\''+n[i].id+'\');">编辑</div><div class="ui primary button" onclick="toSubmit(\''+n[i].id+'\')">提交</div>')
                    }else{
                        html += ('<div class="ui button" onclick="toDetail(\''+n[i].id+'\');">查看</div>')
                    }
                    html += ('</td>')
                    html += '</tr>'
                }
                $('#tBody').html(html);
                opts.current_page = data.data.pageNum - 1;
                $('#page').pagination(data.data.total, opts);
            }else {
                cautionModal(data.message);
            }
        }
    });
}

var toEditManu = function (id) {
    window.location.href = "/writer/edit?id="+id
}

var selectEvent = function () {
    queryData(opts.current_page+1, opts.items_per_page);
}

var selectClick = function () {
    queryData(opts.current_page+1, opts.items_per_page);
}

var resetClick = function () {
    var html = '';
    $('#beginTime').val(html);
    $('#endTime').val(html);
    $('#manuName').val(html);
    queryData(opts.current_page+1, opts.items_per_page);
}

var toAdd = function(){
    $.ajax({
        url:'/writer/validate',
        type:"get",
        success:function (data) {
            if(data.code == '0000'){
                if (data.data == "1") {
                    window.location.href = "/writer/add";
                }else{
                    $("#toUserInfoModal").modal('setting', 'closable', false).modal('show');
                    if($('.modal').hasClass('scrolling')===false) {
                        $('#toUserInfoModal').addClass('scrolling');
                    }
                }
            }else{
                cautionModal(data.message);
            }
        }
    })
};

var toEdit = function(id){
    window.location.href = "/writer/edit?id="+id;
};

var toDetail = function (id) {
    window.location.href = "/writer/detail?id="+id;
};

var clickEvent = function () {
    $('#submit').click(function () {
        $('#submit').addClass('disabled');
        var url = '/writer/submitById';
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:{
                "id":$('#hidSubmitId').val()
            },
            success:function (data) {
                if(data.code=='0000'){
                    $('#submitModal').modal('hide');
                    queryData(opts.current_page+1, opts.items_per_page);
                    $('#submit').removeClass('disabled');
                }else {
                    cautionModal(data.message);
                }
            }
        });
    });

    $('#deleteSubmit').click(function () {
        $('#deleteSubmit').addClass('disabled');
        var url = '/writer/del';
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:{
                'id':$('#hidDeleteId').val()
            },
            success:function (data) {
                if(data.code=='0000'){
                    $('#deleteModal').modal('hide');
                    queryData(opts.current_page+1, opts.items_per_page);
                    $('#deleteSubmit').removeClass('disabled');
                }else {
                    cautionModal(data.message);
                }
            }
        });
    });
}

var toSubmit = function (id) {
    $('#hidSubmitId').val(id);
    $("#submitModal").modal('setting', 'closable', false).modal('show');
    if($('.modal').hasClass('scrolling')===false) {
        $('#submitModal').addClass('scrolling');
    }
}

var toDel = function (id) {
    $('#hidDeleteId').val(id);
    $('#deleteModal').modal('setting', 'closable', false).modal('show');
    if($('.modal').hasClass('scrolling')===false) {
        $('#deleteModal').addClass('scrolling');
    }
}