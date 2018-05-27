    // magic!don't touch!
    var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
    };
    var status="";
    $(function(){

        $('.forumTopic_00').attr("class", "nav-item start active open");

        $('.forumTopic_01').attr("class", "nav-item start active open");

        $('#typeStatusSelect').dropdown();
        $('#add_str1').dropdown();
        $('#add_channelSelect').dropdown();

        $(".form_datetime").datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            autoclose: true,
            todayBtn: true,
            pickerPosition: "bottom-left"
        });
        showDate();
        //进入页面时加载第一页数据 并初始化分页控件
        $('#addCancel').on('click',function () {
            $('#addModalForm').modal('hide')
        })
        $('#addSubmit').on('click',function(){
            addSubmit();
        })
        $('#editCancel').on('click',function () {
            $('#edit').modal('hide')
        })
        $('#editSubmit').on('click',function(){
            editSubmit();
        })
        $('#fileuploadAdd').fileupload({
            url:'/file/uploadFile',
            dataType: 'json',
            add: function(e,data){
                var cautionContent = [];
                var acceptFileTypes = /(\.|\/)(gif|jpe?g|png)$/i;

                if(data.originalFiles[0]['type'].length && !acceptFileTypes.test(data.originalFiles[0]['type'])) {
                    cautionContent.push("请上传图片类型文件")
                }

                if(data.originalFiles[0]['size'] > (20 * 1024 * 1024)){
                    cautionContent.push("请上传大小不超过20MB的文件")
                }

                if (cautionContent.length > 0){
                    cautionModal(cautionContent.join('且'),'add')
                }else {
                    data.submit();
                }

            },
            done: function (e, data) {
                $('#add_topicImg').val(data.result.data);
            },

            progressall: function (e, data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('#processAdd').progress({
                    percent:progress
                })
            },
            fail:function(e,data){
                cautionModal(data.result.message)
            },

        });
        queryData();

    })



    var add = function(){
        if($('.modal').hasClass('scrolling')===false) {
            $('#addModalForm').addClass('scrolling');
        }
        $('#addModalForm').modal('setting', 'closable', false).modal('show')
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


    var queryData = function(){
    var url = '/forumTopic/listAjax'
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data:{
            // 需要传到后台的值，可带参进行分页
        },
        success: function(data){
            //加载内容到页面中
            var html = '';
            $('#content').text(html)
            if(data.code == '0000'){
                var content = data.data
                for (i in content){
                    html += '<tr>'
                    html += ('<td style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;" title="'+content[i].topicName+'">'+content[i].topicName+'</td>')
                    html+='<td nowrap="nowrap">'
                    html += ('<div class="ui  button" onclick="view(\''+content[i].topicImg+'\')">查看</div>')
                    html+=('</td>')
                    html += ('<td nowrap="nowrap">'+content[i].topicDescribe+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].creater+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].articleCount+'</td>')
                    html += ('<td nowrap="nowrap">')

                    if(content[i].topicStatus == '1'){
                        html += ('启用')
                    }else{
                        html += ('停用')
                    }
                    html += ('</td>')
                    html += ('<td nowrap="nowrap">')
                    if(content[i].topicStatus == '1'){
                        html += ('<div class="ui red button" onclick="alertFlag(\''+content[i].id+'\')">停用</div>')
                    }else{
                        html += ('<div class="ui green button" onclick="alertFlag(\''+content[i].id+'\')">启用</div>')
                    }
                    html += ('<div class="ui red button" id="deleteBtn" onclick="delConfirm(\''+content[i].id+'\')">删除</div>')
                    html += ('</td>')
                    html += '</tr>'
                }
                $('#content').append(html)
            }else{
                alert(data.message)
            }
        }
    });
    }
    //查看图片
    var view=function (url) {
        window.open(url);
    }
    var addSubmit = function () {
        var url = "/forumTopic/insert";
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:$('#addForm').serialize(),
            success:function (data) {
                if(data.code=='0000'){
                    cautionModal("操作成功");
                    $('#addModal').modal('hide');
                    queryData(opts.current_page + 1, opts.items_per_page)
                }else {
                    alert(data.message);
                }
            }
        });
    }
    var delConfirm = function (id) {
        var msg = "您真的确定要删除吗？\n\n请确认！";
        if (confirm(msg)==true){
            deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    /*删除功能*/
    var deleteById = function(id){
        var url = "/afterFoodType/delete/" + id;
        $.ajax({
            url:url,
            type:"post",
            dataType: 'json',
            success:function(data){
                if(data.code == "0000"){
                    queryData(opts.current_page + 1,opts.items_per_page);
                    cautionModal("删除成功");
                }else{
                    cautionModal(data.message);
                }
            }
        })

    }
     var addFood=function (url) {
         window.location.href=url;
     }
  /*  var editSubmit = function () {
        var url = "/dynamic/update";
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:$('#editDynamicForm').serialize(),
            success:function (data) {
                if(data.code=='0000'){
                    cautionModal("操作成功");
                    $('#addModal').modal('hide');
                    queryData(opts.current_page + 1, opts.items_per_page)
                }else {
                    alert(data.message);
                }
            }
        });
    }*/

    var alertFlag=function(id){
        var url = "/forumTopic/alertFlag/" + id;
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            success:function (data) {
                if(data.code=='0000'){
                    cautionModal("操作成功");
                    queryData(opts.current_page + 1, opts.items_per_page)
                }else {
                    alert(data.message);
                }
            }
        });
    }

    var recommend=function(id){
        var url = "/afterNews/recommend/" + id;
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            success:function (data) {
                if(data.code=='0000'){
                    cautionModal("操作成功");
                    queryData(opts.current_page + 1, opts.items_per_page)
                }else {
                    alert(data.message);
                }
            }
        });
    }
