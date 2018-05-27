    // magic!don't touch!
    var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
    };
    var channelVal="";
    var setting = {};  // zTree 的参数配置，后面详解
    var zNodes = [   // zTree 的数据属性，此处使用标准json格式
        {
            name: "test1", open: true, children: [
            { name: "test1_1" }, { name: "test1_2" }]
        },
        {
            name: "test2", open: true, children: [
            { name: "test2_1" }, { name: "test2_2" }]
        }
    ];

    $(function(){
        $.fn.zTree.init($("#ztree"), setting, zNodes);
        $('.comment_00').attr("class", "nav-item start active open");

        $('.comment_02').attr("class", "nav-item start active open");

        initFunction();
        $('#channelSelect').dropdown();
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
            $('#add').modal('hide')
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


    })

    var initFunction = function () {
        channelVal=$('#channelSelect').val();
        $('#channelSelect').change(function () {
        channelVal = $(this).val();
        queryData(opts.current_page + 1,opts.items_per_page);
    });

    }
    var add = function(){
        $('#addModal').modal('setting', 'closable', false).modal('show')
        if($('.modal').hasClass('scrolling')===false) {
            $('#addModal').addClass('scrolling');
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


    var queryData = function(page,size){
    var url = '/dynamic/list/'
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data:{
            // 需要传到后台的值，可带参进行分页
            page: page,
            size: size,
            channel:$('#channelSelect').val()
        },
        success: function(data){
            //加载内容到页面中
            var html = '';
            $('#content').text(html)
            if(data.code == '0000'){
                var content = data.data.list
                for (i in content){
                    html += '<tr>'
                    html += ('<td nowrap="nowrap">'+content[i].menuName+'</td>')
                    html += ('<td><div class="ui button" style="width: 60px" onclick="view(\''+content[i].menuImage+'\')">查看</div></td>')
                    html += ('<td nowrap="nowrap">'+content[i].menuUrl+'</td>')
                    html += ('<td nowrap="nowrap">')

                    if(content[i].status == '1'){
                        html += ('未开始')
                    }else{
                       if(content[i].status=='2'){
                           html += ('进行中')
                       }
                       else{
                           html += ('已结束')
                       }
                    }
                    html += ('</td>')
                    html += ('<td nowrap="nowrap">')
                    html += ('<div class="ui primary button" onclick="edit(\''+content[i].id+'\')">修改</div>')
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
        var url = "/dynamic/add";
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:$('#addDynamicForm').serialize(),
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
        var url = "/dynamic/delete/" + id;
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

    var view = function(url) {
        if (url == "") {
            cautionModal("暂没有缩略图")
        } else {
            window.open(url)
        }
    }

    var edit = function(id){
        var url = "/dynamic/" + id;
        $.ajax({
            url:url,
            type: 'post',
            dataType: 'json',
            success: function(data){
                $('#edit').modal('setting', 'closable', false).modal('show')
                if($('.modal').hasClass('scrolling')===false) {
                    $('#edit').addClass('scrolling');
                }
                if(data.code == '0000'){
                    var result = data.data;
                    $('#idEdit').val(result.id);
                    $('#edit_menuName').val(result.dynamicName);
                    $('#edit_channelSelect').dropdown('set selected',result.channel);
                    $('#edit_statusSelect').dropdown('set selected',result.status);
                    $('#edit_BeginTime').val(result.dynmicBeginTime);
                    $('#edit_EndTime').val(result.dynamicEndTime);
                    $('#edit_dynamicImage').val(result.dynamicImage);
                    $('#edit_dynamicUrl').val(result.dynamicUrl);
                    $('#edit_dynamicIntro').val(result.dynamicIntro);
                   /* $('#edit').modal('setting','closeable',false).modal({backdrop: 'static', keyboard: false}).modal('show');
                    if($('.modal').hasClass('scrolling')===false) {
                        $('#edit').addClass('scrolling');*/
                }else {
                    cautionModal(data.message)
                }
            }
        })
    }

    var editSubmit = function () {
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
    }
