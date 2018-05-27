// magic!don't touch!
var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};

var judgeDate = function () {
    var beginTime = dateToString(document.getElementById('beginTime').value);
    var endTime = dateToString(document.getElementById('endTime').value);
    if (parseInt(beginTime) > parseInt(endTime)) {
        document.getElementById('beginTime').value = '';
        document.getElementById('endTime').value = '';
        cautionModal('开始日期不能大于结束日期！')
    }
};

var dateToString = function (date) {
    var result = '';
    var arrays = date.toString().split('-');
    for (var i = 0, size = arrays.length; i < size; i++) {
        result += arrays[i];
    }
    return result;
};

$(function () {
    $('.sh_00').attr("class", "nav-item start active open");
    $('.sh_01').attr("class", "nav-item start active open");
    showDate();

    $('.form_datetime').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    })
    //进入页面时加载第一页数据 并初始化分页控件
    queryData(opts.current_page + 1, opts.items_per_page);

    $("#praiseButton").click(function () {
        queryData( opts.current_page + 1, opts.items_per_page);

    })
})
var changeState = function (str) {
    if (str == null || str == "null") {
        return "";
    } else {
        return str;
    }
}

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
}
var queryData = function(page,size){
    var url = '/Review/listAjax'
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data:{
            // 需要传到后台的值，可带参进行分页
            page: page,
            size: size,
            beginTime:$("#beginTime").val(),
            endTime:$("#endTime").val()
        },
        beforeSend:function(){

            if($("#beginTime").val()==""&&$("#endTime").val()!=""){
                document.getElementById('endTime').value = '';
                cautionModal("请输入正确的时间范围");
                return false;
            }
            return true;
        },
        success: function(data){
            //加载内容到页面中
            var html = '';
            $('#content').text(html)
            if(data.code == '0000'){
                var content = data.data.list
                for (i in content){
                    html += '<tr>'
                  /*  html += ('<td style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;" title=\''+content[i].articleId+'\'><a href="'+content[i].newsHttp+'" target="_blank">'+content[i].articleId+'</td>')*/
                    html += ('<td nowrap="nowrap">'+content[i].nickName+'</td>')
                    html += ('<td style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;" title=\''+content[i].str1+'\'>'+content[i].str1+'</td>')
                    html +='<td nowrap="nowrap">'
                    html += ('<div class="ui  button" onclick="view(\''+content[i].imageUrl+'\')">查看</div>')
                    html +=('</td>')
                    html += ('<td nowrap="nowrap">'+content[i].str2+'</td>')
                    html += ('<td nowrap="nowrap">')
                    if(content[i].status == '0'){
                        html += ('未审核')
                    }else if(content[i].status == '1'){
                        html += ('通过')
                    }else{
                        html += ('驳回')
                    }
                    html += ('</td>')
                    html += ('<td nowrap="nowrap">')
                   html += ('<div class="ui green button" id="updateBtn" onclick="edit(\''+content[i].id+'\')">通过</div>')
                   html += ('<div class="ui red button" id="deleteBtn" onclick="delConfirm(\''+content[i].id+'\')">驳回</div>')
                   html += ('</td>')
                    html += '</tr>'
                }
                $('#content').append(html)
            }else{
                alert(data.message)
            }
            //mybatis需要将data.data.pageNum 减 1，JPA不需要做操作
            opts.current_page = data.data.pageNum - 1;
            //每次成功请求后会重新初始化分页控件
            $('#page').pagination(data.data.total,opts);
        }
    });
}
//查看图片
var view=function (url) {
    window.open(url);
}
