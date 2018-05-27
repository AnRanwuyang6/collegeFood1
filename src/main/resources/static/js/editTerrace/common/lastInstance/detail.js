/**
 * Created by yangzy on 2017/12/11.
 */
window.onload = function () {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_04').attr("class", "nav-item start active open");
    $('.edit_04_01').attr("class", "nav-item start active open");

    showDate();

    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });

    $("[data-toggle='popover']").popover();

    //编辑
    $("#editBtn").click(function () {
        var id = $("#previewId").val();
        window.location.href = '/lastInstance/toEditExamine?id='+id;
    })

    //废弃
    $("#throwBtn").click(function () {
        $("#abandonedModal").modal('setting', 'closable', false).modal('show');
        if($('.modal').hasClass('scrolling')===false) {
            $('#abandonedModal').addClass('scrolling');
        }
    })

    //废弃
    $("#abandonedSubmit").click(function () {
        $("#abandonedSubmit").addClass("disabled")
        var id = $("#previewId").val()
        var view = $("#remarks").val()
        window.location.href = '/lastInstance/scrapManu?id='+id+"&view="+view;
    })

    //打回
    $("#backBtn").click(function () {
        $("#rebackModal").modal('setting', 'closable', false).modal('show');
        if($('.modal').hasClass('scrolling')===false) {
            $('#rebackModal').addClass('scrolling');
        }
    })

    //打回
    $("#rebackSubmit").click(function () {
        $("#abandonedSubmit").addClass("disabled")
        var id = $("#previewId").val()
        var view = $("#rebackView").val()
        window.location.href = '/lastInstance/revokeManu?id='+id+"&view="+view;
    })

    //通过
    $("#submitBtn").click(function () {
        $("#passModal").modal('setting', 'closable', false).modal('show');
        if($('.modal').hasClass('scrolling')===false) {
            $('#passModal').addClass('scrolling');
        }
    })

    //通过
    $("#pass").click(function () {
        $("#pass").addClass("disabled")
        var id = $("#previewId").val()
        var url='/lastInstance/passManu?id='+id;
        var payCode = $("#payTypeId").html()
        if($("#userTyprId").val()!="2" &&$("#userTyprId").val()!="3" && $("#moneySelect").val() != undefined) {
            var manuSum = $("#moneySelect").val()
            if(manuSum != null){
                url += "&manuSum="+manuSum+"&payCode="+payCode;
            }
        }
        window.location.href = url;
    })

    //计算稿费
    if($("#sumId").val()!=null &&$("#sumId").val()!="0"&&$("#sumId").val()!="") {
        $("select.dropdown").dropdown("set selected", [$("#sumId").val()]);
        if ($("#sumId").val() == 0) {
            $("#payTypeId").text("BYP1");
        } else if($("#sumId").val()==20){
            $("#payTypeId").text("BYP1");
        }else if($("#sumId").val()==30){
            $("#payTypeId").text("BYP2");
        }else if($("#sumId").val()==40){
            $("#payTypeId").text("BYP4");
        }else if($("#sumId").val()==50){
            $("#payTypeId").text("BYP4");
        }else if($("#sumId").val()==60){
            $("#payTypeId").text("BYP5");
        }else if($("#sumId").val()==70){
            $("#payTypeId").text("BYP6");
        }else if($("#sumId").val()==80){
            $("#payTypeId").text("BYP7");
        }else if($("#sumId").val()==90){
            $("#payTypeId").text("BYP8");
        }else if($("#sumId").val()==100){
            $("#payTypeId").text("BYP9");
        }else if($("#sumId").val()==120){
            $("#payTypeId").text("BYP10");
        }else if($("#sumId").val()==200){
            $("#payTypeId").text("BYP12");
        }
    }else{
        if ($("#wordsId").val() == 0) {
            $("select.dropdown").dropdown("set selected", ['0']);
            $("#payTypeId").text("BYP1");
        }else if ($("#wordsId").val() <= 300  && $("#wordsId").val() > 0) {
            $("select.dropdown").dropdown("set selected", ['20']);
            $("#payTypeId").text("BYP1");
        } else if (300 < $("#wordsId").val() && $("#wordsId").val() <= 400) {
            $("select.dropdown").dropdown("set selected", ['30']);
            $("#payTypeId").text("BYP2");
        } else if (400 < $("#wordsId").val()&& $("#wordsId").val() <= 500) {
            $("select.dropdown").dropdown("set selected", ['40']);
            $("#payTypeId").text("BYP3");
        } else if (500 < $("#wordsId").val()&& $("#wordsId").val() <= 600) {
            $("select.dropdown").dropdown("set selected", ['50']);
            $("#payTypeId").text("BYP4");
        } else if (600 < $("#wordsId").val()&& $("#wordsId").val() <= 700) {
            $("select.dropdown").dropdown("set selected", ['60']);
            $("#payTypeId").text("BYP5");
        } else if (700 < $("#wordsId").val()&& $("#wordsId").val() <= 900) {
            $("select.dropdown").dropdown("set selected", ['70']);
            $("#payTypeId").text("BYP6");
        } else if (900 < $("#wordsId").val()&& $("#wordsId").val() <= 1000) {
            $("select.dropdown").dropdown("set selected", ['80']);
            $("#payTypeId").text("BYP7");
        } else if (1000 < $("#wordsId").val() && $("#wordsId").val()<= 1100) {
            $("select.dropdown").dropdown("set selected", ['90']);
            $("#payTypeId").text("BYP8");
        } else if (1100 < $("#wordsId").val()&& $("#wordsId").val() <= 1300) {
            $("select.dropdown").dropdown("set selected", ['100']);
            $("#payTypeId").text("BYP9");
        } else if (1300 < $("#wordsId").val()&& $("#wordsId").val() <= 1500) {
            $("select.dropdown").dropdown("set selected", ['120']);
            $("#payTypeId").text("BYP10");
        } else if (1500 < $("#wordsId").val()) {
            $("select.dropdown").dropdown("set selected", ['200']);
            $("#payTypeId").text("BYP12");
        }
    };
    $("#moneySelect").dropdown();
    $('#moneySelect').change(function () {
        if($("#moneySelect").val()==0){
            $("#payTypeId").text("");
        }else if($("#moneySelect").val()==20){
            $("#payTypeId").text("BYP1");
        }else if($("#moneySelect").val()==30){
            $("#payTypeId").text("BYP2");
        }else if($("#moneySelect").val()==40){
            $("#payTypeId").text("BYP4");
        }else if($("#moneySelect").val()==50){
            $("#payTypeId").text("BYP4");
        }else if($("#moneySelect").val()==60){
            $("#payTypeId").text("BYP5");
        }else if($("#moneySelect").val()==70){
            $("#payTypeId").text("BYP6");
        }else if($("#moneySelect").val()==80){
            $("#payTypeId").text("BYP7");
        }else if($("#moneySelect").val()==90){
            $("#payTypeId").text("BYP8");
        }else if($("#moneySelect").val()==100){
            $("#payTypeId").text("BYP9");
        }else if($("#moneySelect").val()==120){
            $("#payTypeId").text("BYP10");
        }else if($("#moneySelect").val()==200){
            $("#payTypeId").text("BYP12");
        }
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

var previewManu = function () {
    var id = $('#previewId').val();
    window.open("/lastInstance/preview?id="+id,"_blank");
}