$(function () {
    $('.edit_00').attr("class", "nav-item start active open");
    $('.edit_03').attr("class", "nav-item start active open");
    $('.edit_03_01').attr("class", "nav-item start active open");

    showDate();

    //预览
    $("#previewBtn").click(function () {
        var id = $("#hiddenId").val();
        window.open('/secondInstance/previewMyManu?id=' + id), "_blank";
    });

    //编辑
    $("#editBtn").click(function () {
        var id = $("#hiddenId").val();
        window.location.href = "/secondInstance/toEditManu?id=" + id;
    });

    //通过(迁移)
    $("#moveBtn").click(function () {
        $("#passModal").modal('setting', 'closable', false).modal('show');
        if ($('.modal').hasClass('scrolling') === false) {
            $('#passModal').addClass('scrolling');
        }
    });

    //通过(迁移)
    $("#pass").click(function () {
        $("#pass").addClass("disabled");
        var id = $("#hiddenId").val();
        window.location.href = '/secondInstance/transferMyManu?id=' + id;
    });

    //废弃
    $("#throwBtn").click(function () {
        $("#abandonedModal").modal('setting', 'closable', false).modal('show');
        if ($('.modal').hasClass('scrolling') === false) {
            $('#abandonedModal').addClass('scrolling');
        }
    });

    //废弃
    $("#abandonedSubmit").click(function () {
        $("#abandonedSubmit").addClass("disabled");
        var id = $("#hiddenId").val();
        var view = $("#remarks").val();
        window.location.href = '/secondInstance/scrapManu?id=' + id + "&view=" + view;
    });

    //三审
    $("#lastBtn").click(function () {
        $("#lastModal").modal('setting', 'closable', false).modal('show');
        if ($('.modal').hasClass('scrolling') === false) {
            $('#lastModal').addClass('scrolling');
        }
    });

    //三审
    $("#lastSubmit").click(function () {
        $("#lastSubmit").addClass("disabled");
        var id = $("#hiddenId").val();
        window.location.href = '/secondInstance/submitById?id=' + id;
    })

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