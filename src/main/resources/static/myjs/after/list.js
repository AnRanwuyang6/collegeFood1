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

        $('.comment_01').attr("class", "nav-item start active open");

        initFunction();
        $('#typeSelect').dropdown();
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
        queryData(opts.current_page + 1,opts.items_per_page);

    })

    var initFunction = function () {
        typeVal=$('#channelSelect').val();
        $('#typeSelect').change(function () {
            typeVal = $(this).val();
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
    var url = '/afterNews/listAjax'
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data:{
            // 需要传到后台的值，可带参进行分页
            page: page,
            size: size,
            newsType:$('#typeSelect').val()
        },
        success: function(data){
            //加载内容到页面中
            var html = '';
            $('#content').text(html)
            if(data.code == '0000'){
                var content = data.data.list
                for (i in content){
                    html += '<tr>'
                    html += ('<td style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;" title="'+content[i].tArticleTitle+'">'+content[i].tArticleTitle+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].tArticleKeywords+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].userName+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].str2+'</td>')
                    html += ('<td nowrap="nowrap">')

                    if(content[i].str1 == '1'){
                        html += ('推荐')
                    }else{
                        html += ('未推荐')
                    }
                    html += ('<td nowrap="nowrap">')

                    if(content[i].status == '1'){
                        html += ('上线')
                    }else{
                        html += ('下线')
                       }
                    html += ('</td>')
                    html += ('<td nowrap="nowrap">')
                    if(content[i].status == '1'){
                        html += ('<div class="ui red button" onclick="alertFlag(\''+content[i].id+'\')">下线</div>')
                    }else{
                        html += ('<div class="ui green button" onclick="alertFlag(\''+content[i].id+'\')">上线</div>')
                    }
                    if(content[i].str1 == '1'){
                        html += ('<div class="ui red button" id="deleteBtn" onclick="recommend(\''+content[i].id+'\')">撤销</div>')
                    }else{
                        html += ('<div class="ui green button" id="deleteBtn" onclick="recommend(\''+content[i].id+'\')">推荐</div>')
                    }
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
        var url = "/afterNews/delete/" + id;
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

    var alertFlag=function(id){
        var url = "/afterNews/alertFlag/" + id;
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
