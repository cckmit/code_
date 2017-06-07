var _helpCateId = 1;//默认查询第一个分类
$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath+"manager/helpList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"editHelp("+row.id+");\">编辑</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary\" onclick=\"helpDel("+row.id+");\">删除</button>";
                return but;
            }
        }
    });
});

$(document).ready(function () {
    $("#helpCateForm").bootstrapValidator('validate');
    $("#helpForm").bootstrapValidator('validate');
    loadHelpCates();
});

function changeHelpCate(btn){
    _helpCateId = $(btn).attr("value");
    $("a[name='helpCateBtn']").parent().removeClass("active");
    $(btn).parent().addClass("active");
    $("#grid-data").bootgrid("reload");
}

function getParams(){
    return {
        "source":1,
        "cate.id": _helpCateId
    }
}

function query(){
    $("#grid-data").bootgrid("reload");
}

//初始化区域按钮，并按默认值选中
function loadHelpCates(){
    $.post(basePath + 'manager/helpCateList.do',{},function (data) {
        var map = $.parseJSON(data);
        buildHelpCates(map.rows);
    });
}
//构建分类导航及选择器
function buildHelpCates(rows){
    $("#selHelpCate").empty();
    $("#selCate").empty();
    $("#selHelpCate").append("<li><a id='allHelpCate' name='helpCateBtn' value='0' href='#' onclick='changeHelpCate(this)'>所有分类</a></li>");
    $.each(rows, function (i, row) {
        $("#selHelpCate").append("<li><a name='helpCateBtn' value='" + row.id + "' href='#' onclick='changeHelpCate(this)'>" + row.name + "</a></li>");
        $("#selCate").append("<option value='" + row.id + "'>" + row.name + "</option>");
    });
    $("a[value='" + _helpCateId + "']").parent().addClass("active");
}

function editHelpCate(id){
    $("#helpCateForm").data('bootstrapValidator').destroy();
    $("#helpCateForm").bootstrapValidator('resetForm', true);
    if(!id){
        id =  _helpCateId;
    }
    if(id == 0){
        BootstrapDialog.alert("请先选择一个分类");
        return;
    }
    if(id > 0){
        var btn = $("a[value='" + id + "']");
        var name = btn.html();

        $("#idHelpCate").val(id);
        $("#nameHelpCate").val(name);
    }
    $('#helpCateModal').modal('show');
}

function helpCateSave() {
    if(!$("#helpCateForm").data('bootstrapValidator').validate().isValid())
        return;
    var id = $("#idHelpCate").val();
    var name = $("#nameHelpCate").val();
    $.post(basePath + 'manager/helpCateSave.do',
        {
            id: id,
            name: name,
            "source":1
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.result){
                BootstrapDialog.alert("保存成功！");
                buildHelpCates(map.rows);
            }else{
                BootstrapDialog.alert("保存失败！");
            }
        }
    );
    $('#helpCateModal').modal('hide');
}

function helpCateDel(id) {
    if(!id){
        id =  _helpCateId;
    }
    if(id == 0){
        BootstrapDialog.alert("请先选择一个分类");
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + 'manager/helpCateDel.do',
                {
                    id: id,
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        //删除成功后选择第一个分类，不是所有
                        var li = $("#allHelpCate").parent().next();
                        if(li){
                            _helpCateId = li.first().attr("value");
                        }else {
                            _helpCateId = 0;
                        }
                        buildHelpCates(map.rows);
                        BootstrapDialog.alert("删除成功！");
                        query();
                    } else {
                        BootstrapDialog.alert("删除失败！<br/>" + map.resultDes);
                    }
                }
            );
        }
    });
    $('#helpCateModal').modal('hide');
}

function editHelp(id){
    $("#helpForm").data('bootstrapValidator').destroy();
    $("#helpForm").bootstrapValidator('resetForm', true);
    if(id > 0){//加载帮助信息
        $.post(basePath + 'manager/getHelp.do',{id:id},function(data){
            var map = $.parseJSON(data);
            $("#idHelp").val(map.id);
            $("#selCate").val(map.cate.id);
            $("#titleHelp").val(map.title);
            CKEDITOR.instances.contentHelp.setData(base64Decode(map.content));
        });
    }else{
        $('#selCate').val(_helpCateId);
        CKEDITOR.instances.contentHelp.setData("");
    }
    $('#helpModal').modal('show');
}
function helpSave() {
    if(!$("#helpForm").data('bootstrapValidator').validate().isValid())
        return;
    $.post(basePath + 'manager/helpSave.do',
        {
            id: $("#idHelp").val(),
            title: $("#titleHelp").val(),
            content: base64Encode(CKEDITOR.instances.contentHelp.getData()),
            "cate.id": $("#selCate").val(),
            "source":1
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.result){
                BootstrapDialog.alert("保存成功！");
                query();
            }else{
                BootstrapDialog.alert("保存失败！");
            }
        }
    );
    $('#helpModal').modal('hide');
}

function helpDel(id) {
    if(id < 1){
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + 'manager/helpDel.do',
                {
                    id: id,
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        BootstrapDialog.alert("删除成功！");
                        query();
                    } else {
                        BootstrapDialog.alert("删除失败！<br/>" + map.resultDes);
                    }
                }
            );
        }
    });
    $('#continentModal').modal('hide');
}