var currCate = "0";
$(function() {
    $("#helpListGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        selection: false,
        multiSelect: false,
        ajax: true,
        post: getParams,
        url: basePath+"helpList.do",
        formatters: {

            "title": function(column, row)
            {
                // alert(row.id);
                return "<a style='display: block;' href=\"javascript:void(0);\" onclick=\"viewHelp(" + row.id + ");\" data-toggle=\"modal\" data-target=\"#myModal\">" + row.title + "</a>";
            },
            "cateName": function(column, row)
            {
                if(row.cate != undefined)
                return row.cate.name;
            }
        }
    });
    $.post(
        basePath + "manager/helpCateList.do",
        {},
        function (data) {
            data = JSON.parse(data);
            $('#helpCateSupportMenu').empty();   //清空helpCateSupport里面的所有内容
            var htmlCate ="";
            htmlCate += '<a name="cateA" value="0" href="javascript:void(0);" onclick="changeHelpCate(this);" class="list-group-item active">全部内容 </a>';
            var helpCates = data.rows;
            for (var i = 0; i < helpCates.length; i++) {
                var cate = helpCates[i];
                htmlCate += '<a name="cateA" value="'+cate.id+'" href="javascript:void(0);" onclick="changeHelpCate(this);" class="list-group-item">'+cate.name+'</a>';
            }
            $('#helpCateSupportMenu').html(htmlCate);
        }
    );

    $("a[name='cateA']").removeClass("active");
    $("a[value=" + currCate + "]").addClass("active");
    query();


});

function getParams(){
    return {
        "cate.id": currCate,
        title:$("#queryTitle").val()
    }
}
function query(){
    $("#helpListGrid").bootgrid('reload');
}
function changeHelpCate(a) {
    currCate = $(a).attr("value");
    $("a[name='cateA']").removeClass("active");
    $(a).addClass("active");
    query();
}

function viewHelp(id){
    //var sendData = {"id" : id};
    // alert(id);
    $.ajax({
        type:"POST",
        url:basePath+"getHelp.do?id="+id,
        dataType:"json",
        contentType:"application/json",
        success:function(data){
            $("#helpTitle").html(data.title);
            $("#helpContent").html(base64Decode(data.content));
            $('#myModal').modal('show')
        }
    });
}
