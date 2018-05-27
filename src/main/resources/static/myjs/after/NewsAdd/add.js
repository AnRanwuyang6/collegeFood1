    // magic!don't touch!
    var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
    };
    var typeVal="";
    $(function(){

        $('.comment_00').attr("class", "nav-item start active open");

        $('.comment_03').attr("class", "nav-item start active open");

        $('#typeSelect').dropdown();
        showDate();
        //进入页面时加载第一页数据 并初始化分页控件
        $('#addCancel').on('click',function () {
            $('#add').modal('hide')
        })
        $('#SaveSubmit').on('click',function(){
            addSubmit();
        })

    })

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
    var addSubmit = function () {
        var url = "/afterNews/insert";
        var content=CKEDITOR.instances.newsContentAdd.getData();
        $("#tArticleContents").val(content);
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:$('#newsAddForm').serialize(),
            beforeSend:function () {
                if($("#typeSelect").val()==""){
                    alert("文章类型不能为空")
                    return false
                }
                if($("#tArticleTitleAdd").val()==""){
                    alert("文章标题不能为空")
                    return false
                }
                if($("#tArticleKeywordsAdd").val()==""){
                    alert("关键词不能为空")
                    return false
                }
                if($("#tArticleContents").val()==""){
                    alert("内容不能为空")
                    return false
                }

                return true;
            },
            success:function (data) {
                if(data.code=='0000'){
                    cautionModal("操作成功");
                }else {
                    alert(data.message);
                }
            }
        });
    }
