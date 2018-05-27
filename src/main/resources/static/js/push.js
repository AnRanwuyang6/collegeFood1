// magic!don't touch!
var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};
$(function(){
    $('.tshide').hide();
    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii',
        autoclose: true,
        todayBtn: true,
        pickerPosition: "bottom-left"
    });

    initFunction();
});

//初始化事件
function  initFunction() {
    //推送类型
    $('#typeOfPush').change(function(){
        if($(this).val()=="1"){
            $('.tshide').hide();
            $('.tscontent').show();
        }else if($(this).val()=="2"){
            $('.tscontent').hide();
            $('.tshide').show();
            // querydata(opts.current_page + 1,opts.items_per_page);
        }
    });
    //语言下拉
    $('#languageSelect').change(function(){
        var langeCode=$(this).val();
        var menuSelect=$('#menuSelect');
        // alert(langeCode);
        $.ajax({
            type: 'POST',
            url: "/menulist/"+langeCode,
            success:function(data){
                if(data.code=="0000"){
                    // alert(data.code);
                    // alert(data.data[0].cMenuName);
                    menuSelect.empty();
                    for(var i=0;i<data.data.length;i++){
                        // if(i==0){
                        //     // $('div.text').text(data.data[i].cMenuName);
                        // }
                        var option=$("<option>").val(data.data[i].cMenuId).text(data.data[i].cMenuName);
                        menuSelect.append(option);
                    }

                }

            }
        });
        // querydata(opts.current_page + 1,opts.items_per_page);
        //initNews()；
    });
    //菜单下拉
    $('#menuSelect').change(function(){
         querydata(opts.current_page ,opts.items_per_page);
        //initNews();
    });

    //推送
    $(".pushBtn").click(function(){
        var pushType=$('#typeOfPush').val();
        var pushDevice=$('#pushdevice').val();
        var pushUser=$('#pushuser').val();
        var pushTime=$('#pushtime').val();
        var pushContent=$('#pushcontent').val();
        var pushLangeuage=$('#languageSelect').val();
        var pushMenu=$('#menuSelect').val();
        var pushArticle=$('input:radio[name="fruit"]:checked').val();

        if(pushType=='1'){
            $.ajax({
                type: 'POST',
                url: "/pushData",
                dataType:'json',
                data: {
                    title:"11",
                    pushTypeTextContent:pushContent,
                    pushType:pushType,
                    deviceType:pushDevice,
                    tag:"1",
                    pushTime:pushTime
                },
                success:function(data){
                    if(data.code=="0000"){
                        alert("推送成功");
                        }
                    if(data.code=="0001"){
                        alert("推送失败！");
                    }
                    }
            });

        }else if(pushType=='2'){
            if(pushArticle==""||pushArticle==null){
                alert("请选择文章");
            }else{
               // alert(pushArticle);
                var obj=eval('(' + pushArticle + ')');
                $.ajax({
                    type: 'POST',
                    url: "/pushData",
                    dataType:'json',
                    data: {
                        title:obj.newsTitle,
                        content:pushArticle,
                        pushType:pushType,
                        deviceType:pushDevice,
                        tag:"1",
                        pushTime:pushTime
                    },
                    success:function(data){
                        if(data.code=="0000"){
                            alert("推送成功");
                        }
                        if(data.code=="0001"){
                            alert("推送失败！");
                        }
                    }
                });
            }

        }else{

        }
    });
}
//请求文章
function initNews(){
    $.ajax({
        type: "POST",
        url: "http://116.62.89.99/portal/dubboaction.act",
        contentType: "text/plain;charset=UTF-8",
        data: "{interfaceId:\"newslist_02\", index:\"0\", c_language_id:\"" + $("#languageSelect").val() + "\", c_menu_id:\"" + $("#menuSelect").val()+"\"}",
        success: function(data){
            data = $.parseJSON(data);
            if(data.newslist_02!=null&&data.newslist_02.content.voList[0].total!=0){
                $("#news").empty();
                $.each(data.newslist_02.content.voList, function(index, item){
                    $.each(item.returnEntrie, function(index2, item2){
                        $("#news").append("<div class='field' style='min-height: 60px;'>"+"<div class='ui radio checkbox' style='padding-left: 0px;width: 100%;'>"+"<input type='radio' style='margin-left: 0px;' name='fruit' value='" + JSON.stringify(item2) + "'/>"+"<label style='font-size: 14px;'><a href='"+item2.newsHttp+"' style='font-size: 14px;' target='_blank'>"+ item2.newsTitle +"</a>"+"<br>"+ item2.newsFrom + "&nbsp;&nbsp;" + item2.newsTime +  "</label> </div> </div>");
                    });
                });
            }else{

            }

        }
    });

}
function querydata(page,size) {
    //var url = 'http://116.62.89.99/portal/dubboaction.act';
    var totalCount=0;
    var pageSum=0;
    $.ajax({
        url:'http://116.62.89.99/portal/dubboaction.act',
        type: 'post',
        contentType: 'text/plain;charset=UTF-8',
        dataType: 'json',
        data: "{interfaceId:\"newslist_02\", index:\"0\", c_language_id:\"" + $("#languageSelect").val() + "\", c_menu_id:\"" + $("#menuSelect").val()+"\"}",
        success: function (data) {
            //加载内容到页面中
            if (data.newslist_02 != null && data.newslist_02.content.voList[0].total != 0) {
                $("#news").empty();
                $.each(data.newslist_02.content.voList, function (index, item) {
                    $.each(item.returnEntrie, function (index2, item2) {
                        // totalCount+=data.newslist_02.content.voList[index2].total;
                        // pageSum+=data.newslist_02.content.voList[index2].size;
                        $("#news").append("<div class='field'>" + "<div class='ui radio checkbox' style='padding-left: 0px;width: 100%;height:inherit;'>" + "<input type='radio' style='margin-left: 0px;' name='fruit' value='" + JSON.stringify(item2) + "'/>" + "<label style='font-size: 14px;'><a href='" + item2.newsHttp + "' target='_blank'>" + item2.newsTitle + "</a>" + "<br>" + item2.newsFrom + "&nbsp;&nbsp;" + item2.newsTime + "</label> </div> </div>");
                    });
                });
            } else {

            }
            //mybatis需要将data.data.number 减 1，JPA不需要做操作
            // opts.current_page =pageSum;
            // //每次成功请求后会重新初始化分页控件
            // $('#page').pagination(totalCount, opts);
        }
    });
    }