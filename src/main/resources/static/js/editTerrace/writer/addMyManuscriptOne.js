var ue;

$(function () {
    console.log("")
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_01').attr("class", "nav-item start active open");
    $('.edit_01_01').attr("class", "nav-item start active open");
    showDate();

    $('#add_select').dropdown();

    ue = UE.getEditor('editor');
    ue.ready(function () {
        $("#edui1").css("z-index",1)
    })

    //转换时间显示格式
    reDate();

    $("#ueId").mouseleave(function(){
        var sumwords = countWords(ue.getContent());
        $("#countWordsId").html(sumwords)
        $("#countWordsId").val(sumwords)
    });

    $("#add_select").change(function () {
        $(window).bind('beforeunload',function(){
            return '确定放弃本次编辑吗?';
        });
    })

    $("div .row").find(".form-control").keydown(function () {
        $(window).bind('beforeunload',function(){
            return '确定放弃本次编辑吗?';
        });
    })

    $("div .row").find("#ueId").click(function () {
        $(window).bind('beforeunload',function(){
            return '确定放弃本次编辑吗?';
        });
    })

    $("#submit").click(function () {
      submit();
    })

    $("#previewId").click(function () {
        var title = $("#add_title").val()
        var content = ue.getContent()
        var urls = [];
        var objInput = document.getElementById("tBId").getElementsByTagName("input");
        for (i = 0; i < objInput.length; i++) {
            urls.push(objInput[i].value);
        }
        window.open("/writer/previewMyManuInAdd?title="+title+"&content="+content+"&urls="+urls.join(","),"_blank");
    })
});

//计算富文本字数
var countWords = function(content){
    var content = content;
    content = content.replace(/<\/?.+?>/g,"");
    content = content.replace(/ /g,"");//去除html便签
    content = content.replace(/&nbsp;+/g,"");//去除空格
    content = content.replace(/^\s+|\s+$/g,"");//去前后空格
    var sumWords = content.replace(/[\u0391-\uFFE5]/g,"aa").length/2;//字数
    if (sumWords==0){
        return "--";
    }else{
        return parseInt(sumWords);
    }
}

//取消修改内容摘要
var cancel = function () {
    //改变按钮状态
    $("#caBtn").attr("class","ui green button");
    $("#caBtn").val("修改");
    //显示span
    $("#contentAbstract").show();
    //隐藏textarea
    $("#contentAbstractDiv").css('display','none')
}

//取消（f返回上个页面）
var view = function(){
    window.history.back(-1);
}

//长整型时间戳转时间格式
//yyyy/mm/dd hh:MM
var reDate = function () {
    var date = $("#publishTime").text();
    date = new Date(parseInt(date));
    var year = date.getFullYear();
    var month = date.getMonth()+1;
    if(month < 10){
        month = "0"+month;
    }
    var day = date.getDate();
    if(day < 10){
        day = "0"+day;
    }
    var hour = date.getHours();
    if(hour < 10){
        hour = "0"+hour;
    }
    var min = date.getMinutes();
    if(min < 10){
        min = "0" + min;
    }
    var dateStr = year+"-"+month+"-"+day+"  "+hour+":"+min;
    $("#publishTime").text(dateStr);
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
};


var toAddUrl = function () {
    var trs, td, count;

    count = $("#urlTable").find("tbody tr").length;
    //当添加第二个div的时候，第一个删除按钮显示
    if (count == 1) {
        $("#deleteUrl0").attr("class", "ui primary button");
    }

    td = "<td>";
    td += "<input class='form-control'>";
    td += "</td>";
    td += "<td>";
    td += "<div id='deleteUrl" + count + "' class='ui primary button' onclick='toDeleteUrl(this);'>删除</div>";
    td += "</td>";
    td += "<td>";
    td += "<div id='addUrl" + count + "' class='ui primary button' onclick='toAddUrl();'>新增一条</div>";
    td += "</td>";
    trs = "";
    trs += "<tr>" + td + "</tr>";
    //将div添加到最后一个
    $("#urlTable").find("tbody tr:last").after(trs);

    //将除了最后一个add按钮全部隐藏
    $("#urlTable").find("tbody tr").find("td:eq(2)").find("div").not($("#addUrl" + count)).attr("class", "ui primary button hidden");
};

var toDeleteUrl = function (obj) {
    var count;

    //计算删除前的总行数
    count = $("#urlTable").find("tbody tr").length;

    //删除选中行
    $("#" + obj.id).parent().parent().remove();

    $("#urlTable").find("tr").each(function (i) {
        $(this).find("div:eq(0)").attr("id", "deleteUrl" + i);
    });//重新给delete排序

    $("#urlTable").find("tr").each(function (i) {
        $(this).find("div:eq(1)").attr("id", "addUrl" + i);
    });//重新给add排序

    //当只有一条的时候,delete隐藏
    if (count == 2) {
        $("#deleteUrl0").attr("class", "ui primary button hidden");
    }

    //显示最后一条add
    $("#addUrl" + (count - 2)).attr("class", "ui primary button");
};

var add_save = function () {

    $("#saveAddBtn").addClass("disabled")

    var wordscount = $("#countWordsId").val()
    if(wordscount=="--"){
        wordscount=0;
    }

    var urls = [];
    var objInput = document.getElementById("tBId").getElementsByTagName("input");
    for (i = 0; i < objInput.length; i++) {
        urls.push(objInput[i].value);
        console.log(objInput[i].value)
    }

    var industry = $("#hidddenIsIndustryId").val()
    var processName = '';
    if(industry == 1){
        processName = 'industryWriter';
    }else{
        processName = 'writer';
    }

    var url = '/writer/save';
    $.ajax({
        url:url,
        type:'post',
        dataType:'json',
        data:{
            'id':$('#operationId').val(),
            'appointMan':$('#option_'+$('#add_select').val()).text(),
            'appointManName':$('#add_select').val(),
            'title':$('#add_title').val(),
            'content':ue.getContent(),
            'wordCount':wordscount,
            'urls':urls.join(","),
            'processName':processName
        },
        beforeSend:function () {
            if ($.trim($("#add_select").val())==""){
                cautionModal("约稿人不能为空")
                $("#saveAddBtn").removeClass("disabled")
                return false;
            }
            if ($.trim($("#add_title").val())==""){
                cautionModal("标题不能为空")
                $("#saveAddBtn").removeClass("disabled")
                return false;
            }
            if ($.trim(ue.getContent())==""){
                cautionModal("内容不能为空")
                $("#saveAddBtn").removeClass("disabled")
                return false;
            }
            return true;
        },
        success:function (data) {
            if(data.code == "0000"){
                $(window).unbind('beforeunload');
                $("#saveAddBtn").removeClass("disabled")
                $('#operationId').val(data.data)
                cautionModal('保存成功');
            }else{
                cautionModal(data.message);
                $("#saveAddBtn").removeClass("disabled")
            }
        }
    });
}

var add_submit = function () {
    $("#submitModal").modal('setting', 'closable', false).modal('show');
    if($('.modal').hasClass('scrolling')===false) {
        $('#submitModal').addClass('scrolling');
    }
}

var submit = function () {
    $("#submit").addClass("disabled");

    var wordscount = $("#countWordsId").val()
    if(wordscount=="--"){
        wordscount=0;
    }

    var urls = [];
    var objInput = document.getElementById("tBId").getElementsByTagName("input");
    for (i = 0; i < objInput.length; i++) {
        urls.push(objInput[i].value);
        console.log(objInput[i].value)
    }

    var industry = $("#hidddenIsIndustryId").val()
    var processName = '';
    if(industry == 1){
        processName = 'industryWriter';
    }else{
        processName = 'writer';
    }

    var url = '/writer/submit';
    $.ajax({
        url:url,
        type:'post',
        dataType:'json',
        data:{
            'id':$('#operationId').val(),
            'appointMan':$('#option_'+$('#add_select').val()).text(),
            'appointManName':$('#add_select').val(),
            'title':$('#add_title').val(),
            'content':ue.getContent(),
            'wordCount':wordscount,
            'urls':urls.join(","),
            'processName':processName
        },
        beforeSend:function () {
            if ($.trim($("#add_select").val())==""){
                cautionModal("约稿人不能为空")
                $("#submit").removeClass("disabled");
                return false;
            }
            if ($.trim($("#add_title").val())==""){
                cautionModal("标题不能为空")
                $("#submit").removeClass("disabled");
                return false;
            }
            if ($.trim(ue.getContent())==""){
                cautionModal("内容不能为空")
                $("#submit").removeClass("disabled");
                return false;
            }
            return true;
        },
        success:function (data) {
            if(data.code == "0000"){
                $(window).unbind('beforeunload');
                $("#submit").removeClass("disabled");
                window.location.href = '/writer/index';
            }else{
                cautionModal(data.message);
                $("#submit").removeClass("disabled");
            }
        }
    });
}