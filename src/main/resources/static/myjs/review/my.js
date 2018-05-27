    // magic!don't touch!
    var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
    };
    $(function(){

        $('.review_00').attr("class", "nav-item start active open");

        $('.review_02').attr("class", "nav-item start active open");

        showDate();
        //进入页面时加载第一页数据 并初始化分页控件
        queryData()

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


    var queryData = function(){
    var url = '/Review/findByUser'
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data:{
        },
        success: function(data){
            //加载内容到页面中
            var html = '';
            $('#content').text(html)
            if(data.code == '0000'){
                var content = data.data
                for (i in content){
                    html += '<tr>'
                    html += ('<td style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;" title="'+content[i].id+'">'+content[i].id+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].nickName+'</td>')
                    if(content[i].type=='1'){
                        html += ('<td nowrap="nowrap">供应商</td>')
                    }else{
                        html += ('<td nowrap="nowrap">采购商</td>')
                    }
                    html += ('<td nowrap="nowrap">'+content[i].str2+'</td>')
                    html += ('<td nowrap="nowrap">')
                    html += ('<div class="ui  button" id="updateBtn" onclick="view(\''+content[i].imageUrl+'\')">查看</div>')
                    html += ('</td>')
                    html += ('<td nowrap="nowrap">'+content[i].str1+'</td>')
                    html += ('<td nowrap="nowrap">')
                    if(content[i].status == '0'){
                        html += ('未审核')
                    }else if(content[i].status == '1'){
                        html += ('<p style="color:green;">通过</p>')
                    }else{
                        html += ('<p style="color:red;">驳回</p>')
                    }
                    html += ('</td>')
                    /*html += ('<td nowrap="nowrap">')
                    if(content[i].status == '1'){
                        html +=('<div class="ui red button" onclick="alertFlag(\''+content[i].id+'\')">下线</div>')
                    }else{
                        html +=('<div class="ui green button" onclick="alertFlag(\''+content[i].id+'\')">上线</div>')
                    }
                    html += ('<div class="ui green button" id="updateBtn" onclick="edit(\''+content[i].id+'\')">修改</div>')
                    html += ('<div class="ui red button" id="deleteBtn" onclick="delConfirm(\''+content[i].id+'\')">删除</div>')
                    html += ('</td>')*/
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
