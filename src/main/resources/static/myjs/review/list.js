    // magic!don't touch!
    var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
    };
    var foodStatus="";
    $(function(){

        $('.review_00').attr("class", "nav-item start active open");

        $('.review_01').attr("class", "nav-item start active open");

        showDate();
        //进入页面时加载第一页数据 并初始化分页控件
        $('#SaveSubmit').on('click',function(){
            addSubmit();
        })

        //
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
                $('#add_imgUrl').val(data.result.data);
                $('#myimg').attr('src',data.result.data);
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
        $('#fileuploadEdit').fileupload({
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
                $('#edit_foodUrl').val(data.result.data);
                $('#myimg2').attr('src',data.result.data);
            },

            progressall: function (e, data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('#processEdit').progress({
                    percent:progress
                })
            },
            fail:function(e,data){
                cautionModal(data.result.message)
            },

        });

    })

    var initFunction = function () {
        foodStatus=$('#foodType').val();
        $('#foodType').change(function () {
            foodStatus = $(this).val();
        /*queryData(opts.current_page + 1,opts.items_per_page);*/
            queryData(1,10);
    });

    }
    var add = function(){
        $('#addModal').modal('setting', 'closable', false).modal('show')
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


    var queryData = function(page,size){
    var url = '/foodInfor/listAjax'
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data:{
            // 需要传到后台的值，可带参进行分页
            page: page,
            size: size,
            foodStatus:$('#foodType').val(),
            typeId:$('#typeId').val()
        },
        success: function(data){
            //加载内容到页面中
            var html = '';
            $('#content').text(html)
            if(data.code == '0000'){
                var content = data.data.list
                for (i in content){
                    html += '<tr>'
                    /*html += ('<td style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;" title="'+content[i].tArticleTitle+'">'+content[i].tArticleTitle+'</td>')*/
                    html += ('<td nowrap="nowrap">'+content[i].foodName+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].foodPrice+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].foodTypeName+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].str3+'</td>')
                    html += ('<td nowrap="nowrap">')
                    html += ('<div class="ui  button" id="updateBtn" onclick="view(\''+content[i].foodUrl+'\')">查看</div>')
                    html += ('</td>')
                    html += ('<td nowrap="nowrap">'+content[i].foodDescribe+'</td>')
                    html += ('<td nowrap="nowrap">')
                    if(content[i].status == '1'){
                        html += ('上线')
                    }else{
                        html += ('下线')
                    }
                    html += ('</td>')
                    html += ('<td nowrap="nowrap">')
                    if(content[i].status == '1'){
                        html +=('<div class="ui red button" onclick="alertFlag(\''+content[i].id+'\')">下线</div>')
                    }else{
                        html +=('<div class="ui green button" onclick="alertFlag(\''+content[i].id+'\')">上线</div>')
                    }
                    html += ('<div class="ui green button" id="updateBtn" onclick="edit(\''+content[i].id+'\')">修改</div>')
                    html += ('<div class="ui red button" id="deleteBtn" onclick="delConfirm(\''+content[i].id+'\')">删除</div>')
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

    var addSubmit = function () {
        var url = "/Review/insert";
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:$('#reviewForme').serialize(),
            success:function (data) {
                if(data.code=='0000'){
                    cautionModal("操作成功");
                    window.location.href='/Review/list'
                }else {
                    alert(data.message);
                }
            }
        });
    }
    //查看图片
    var view=function (url) {
        window.open(url);
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
        var url = "/foodInfor/delete/" + id;
        $.ajax({
            url:url,
            type:"post",
            dataType: 'json',
            success:function(data){
                if(data.code == "0000"){
                    queryData(opts.current_page + 1,opts.items_per_page);
                }else{
                    cautionModal(data.message);
                }
            }
        })

    }
    var edit = function(id){
        var url = "/foodInfor/" + id;
        $.ajax({
            url:url,
            type: 'post',
            dataType: 'json',
            success: function(data){
                $('#editModal').modal('setting', 'closable', false).modal('show')
                if($('.modal').hasClass('scrolling')===false) {
                    $('#editModal').addClass('scrolling');
                }
                if(data.code == '0000'){
                    var result = data.data;
                    $('#idEdit').val(result.id);
                    $('#edit_foodName').val(result.foodName);
                    $('#edit_foodPrice').val(result.foodPrice);
                    $('#edit_str2').val(result.str2);
                    $('#edit_foodDescribe').val(result.foodDescribe);
                    $('#edit_foodUrl').val(result.foodUrl);
                    $('#myimg2').attr('src',result.foodUrl);
                }else {
                    cautionModal(data.message)
                }
            }
        })
    }
    var editSubmit = function () {
        var url = "/foodInfor/update";
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:$('#editForm').serialize(),
            success:function (data) {
                if(data.code=='0000'){
                    cautionModal("操作成功");
                    $('#addModal').modal('hide');
                    queryData(opts.current_page + 1, opts.items_per_page)
                }else {
                    alert("66666");
                }
            }
        });
    }

    var alertFlag=function(id){
        var url = "/foodInfor/alertFlag/" + id;
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
