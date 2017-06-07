/**
 * Created by dell on 2017/4/7.
 */
var _systemId = "";//默认查询所有系统
var _categoryId = "";//默认查询所有类别

$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath+"/core/resourceList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"editResource('"+row.id+"');\">编辑</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary\" onclick=\"resourceDel('"+row.id+"');\">删除</button>";
                return but;
            },
            "type": function (column, row) {
                var str;
                if (row.type ==1) {
                    str = "菜单";
                } else if (row.type == 2) {
                    str = "按钮";
                }
                return str;
            }
        }
    });
});

$(document).ready(function () {
    $("#systemForm").validate();
    $("#categoryForm").validate();
    $("#resourceForm").validate();
    loadSystems();
    loadCategorys();
});

function changeSystem(btn){
    _systemId = $(btn).attr("value");
    $("button[name='systemBtn']").removeClass("btn-info");
    $(btn).addClass("btn-info");
    loadCategorys();
    query();
}

function changeCategory(btn){
    _categoryId = $(btn).attr("value");
    $("a[name='categoryBtn']").parent().removeClass("active");
    $(btn).parent().addClass("active");
    $("#grid-data").bootgrid("reload");
}

function getParams(){
    return {
        "category.id":_categoryId,
        "system.id": _systemId
    }
}

function query(){
    $("#grid-data").bootgrid("reload");
}

//初始化系统，查找所有
function loadSystems(){
    $.post(basePath + '/core/systemList.do',{},function (data) {
        var map = $.parseJSON(data);
        buildSystems(map.rows);
    });
}

//查找系统对应的类别，并按默认值选中
function loadCategorys(){
    $.post(basePath + '/core/categoryList.do',
        {
            "system.id": _systemId
        },
        function (data) {
            var map = $.parseJSON(data);
            buildCategorys(map.rows);
        });
}

//select查找系统对应的类别
function loadCategoryse(id){
    $.post(basePath + '/core/categoryList.do',
        {
            "system.id": id
        },
        function (data) {
            var map = $.parseJSON(data);
            buildCategorySelect(map.rows);
        });
}
loadCategoryse

//构建系统按钮及选择器
function buildSystems(rows){
    $("#selSystem").empty();
    $("#selSystemCategory").empty();
    $("#selSystemResource").empty();
    $("#selSystem").append("<button id='allSystem' name='systemBtn' value='' class='btn btn-lg btn-default' onclick='changeSystem(this)'>所有系统</button>");
    $("#selSystemCategory").append("<option value='' ></option>");
    $("#selSystemResource").append("<option value='' >所有系统</option>");
    $.each(rows, function (i, row) {
        $("#selSystem").append("<button name='systemBtn' value='" + row.id + "' class='btn btn-lg btn-default' onclick='changeSystem(this)'>" + row.name + "</button>");
        $("#selSystemCategory").append("<option value='" + row.id + "'>" + row.name + "</option>");
        $("#selSystemResource").append("<option value='" + row.id + "'>" + row.name + "</option>");
    });
    $("button[value='" + _systemId + "']").addClass("btn-info");
}

//构建类别导航及选择器
function buildCategorys(rows){
    $("#selCategory").empty();
    $("#selCategory").append("<li><a id='allCategory' name='categoryBtn' value='' href='#' onclick='changeCategory(this)'>所有类别</a></li>");
    $.each(rows, function (i, row) {
        $("#selCategory").append("<li><a name='categoryBtn' value='" + row.id + "' href='#' onclick='changeCategory(this)'>" + row.name + "</a></li>");
    });
    $("a[value='" + _categoryId + "']").parent().addClass("active");
    buildCategorySelect(rows);
}

function buildCategorySelect(rows) {
    $("#selCategoryResource").empty();
    $.each(rows, function (i, row) {
        $("#selCategoryResource").append("<option value='" + row.id + "'>" + row.name + "</option>");
    });
}

function editSystem(id){
    if(id == ""){
        BootstrapDialog.alert("请先选择一个系统");
        return;
    }
    if(id != null && id != undefined){
        var btn = $("button[value='" + id + "']");
        var name = btn.html();
        $("#idSystem").val(id);
        $("#nameSystem").val(name);
    }else{
        $("#idSystem").val("");
        $("#nameSystem").val("");
    }
    $('#systemModal').modal('show');
}

function systemSave() {
    if(!$("#systemForm").valid())
        return false;
    var id = $("#idSystem").val();
    var name = $("#nameSystem").val();
    $.post(basePath + '/core/systemSave.do',
        {
            id: id,
            name: name
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.result){
                BootstrapDialog.alert("保存成功！");
                buildSystems(map.rows);
            }else{
                BootstrapDialog.alert("保存失败！");
            }
        }
    );
    $('#systemModal').modal('hide');
}

function systemDel(id) {
    if(!id){
        id =  _systemId;
    }
    if(id == ""){
        BootstrapDialog.alert("请先选择一个系统");
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + '/core/systemDel.do',
                {
                    id: id
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        //删除成功后选择第一个区域，不是所有
                        var btn = $("#allSystem").next();
                        if(btn){
                            _systemId = btn.attr("value");
                        }else {
                            _systemId = "";
                        }
                        buildSystems(map.rows);
                        BootstrapDialog.alert("删除成功！");
                        query();
                    } else {
                        BootstrapDialog.alert("删除失败！<br/>" + map.resultDes);
                    }
                }
            );
        }
    });
}

function editCategory(id){
    if(id == ""){
        BootstrapDialog.alert("请先选择一个类别");
        return;
    }
    if(id != null && id != undefined){//加载类别信息
        $.post(basePath + '/core/getCategory.do',{id:id},function(data){
            var maps = $.parseJSON(data);
            var map=maps.content;
            $("#sortCategory").val(map.sort);
            $("#idCategory").val(map.id);
            $("#nameCategory").val(map.name);
            $('#selSystemCategory').val((map.system == undefined) ? '' : map.system.id);
        });
    }else{
        $("#sortCategory").val("");
        $("#idCategory").val("");
        $("#nameCategory").val("");
        $('#selSystemCategory').val(_systemId);
    }
    $('#categoryModal').modal('show');
}

function categorySave() {
    if(!$("#categoryForm").valid())
        return false;
    $.post(basePath + '/core/categorySave.do',
        {
            id: $("#idCategory").val(),
            name:$("#nameCategory").val(),
            sort:$("#sortCategory").val(),
            "system.id": $("#selSystemCategory").val()
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.code){
                BootstrapDialog.alert(map.msg);
                loadCategorys();
            }else{
                BootstrapDialog.alert(map.msg);
            }
        }
    );
    $('#categoryModal').modal('hide');
}

function categoryDel(id) {
    if(!id){
        id =  _categoryId;
    }
    if(id == ""){
        BootstrapDialog.alert("请先选择一个类别");
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + '/core/categoryDel.do',
                {
                    id: id,
                    "system.id":_systemId
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        //删除成功后选择第一个分类，不是所有
                        var li = $("#allCategory").parent().next();
                        if(li){
                            _categoryId = li.first().attr("value");
                        }else {
                            _categoryId = "";
                        }
                        buildCategorys(map.rows);
                        BootstrapDialog.alert("删除成功！");
                        query();
                    } else {
                        BootstrapDialog.alert("删除失败！<br/>" + map.resultDes);
                    }
                }
            );
        }
    });
}



function editResource(id){
    if(id != null &&  id != undefined  && id!= ""){//加载资源信息
        $.post(basePath + '/core/getResource.do',{id:id},function(data){
            var maps = $.parseJSON(data);
            var map=maps.content;
            $("#idResource").val(map.id);
            $("#sortResource").val(map.sort);
            $("#typeResource").val(map.type);
            $("#nameResource").val(map.name);
            $("#iconResource").val(map.icon);
            $("#permsResource").val(map.perms);
            $("#urlResource").val(map.url);
            $("#selSystemResource").val((map.system == undefined) ? '' : map.system.id);
            $("#selCategoryResource").val((map.category == undefined) ? '' : map.category.id);
        });
    }else{
        $("#idResource").val("");
        $("#sortResource").val("");
        $("#typeResource").val("");
        $("#nameResource").val("");
        $("#iconResource").val("");
        $("#permsResource").val("");
        $("#urlResource").val("");
        $("#selSystemResource").val(_systemId);
        $('#selCategoryResource').val(_categoryId);
    }
    $('#resourceModal').modal('show');
}

function resourceSave() {
    if(!$("#resourceForm").valid())
        return false;
    $.post(basePath + '/core/resourceSave.do',
        {
            id: $("#idResource").val(),
            name:$("#nameResource").val(),
            sort:$("#sortResource").val(),
            type:$("#typeResource").val(),
            icon:$("#iconResource").val(),
            perms:$("#permsResource").val(),
            url: $("#urlResource").val(),
            "category.id": $("#selCategoryResource").val(),
            "system.id": $("#selSystemResource").val()
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.code){
                BootstrapDialog.alert(map.msg);
                query();
            }else{
                BootstrapDialog.alert(map.msg);
            }
        }
    );
    $('#resourceModal').modal('hide');
}

function resourceDel(id) {
    if(id== "" || id == null || id == undefined){
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(a) {
        if (a) {
            $.post(basePath + '/core/resourceDel.do',
                {
                    id: id
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.code) {
                        BootstrapDialog.alert(map.msg);
                        query();
                    } else {
                        BootstrapDialog.alert(map.msg);
                    }
                }
            );
        }
    });
}