/**
 * Created by dell on 2017/4/7.
 */
var _corpTypeId = "";//默认查询所有机构类别
var _corpId = "";//默认查询所有机构

$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath+"/core/deptList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"editDept('"+row.id+"');\">编辑</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary\" onclick=\"deptDel('"+row.id+"');\">删除</button>";
                return but;
            }
        }
    });


    // //设置高度和宽度，初始化在线编辑器
    // CKEDITOR.config.width = '100%';
    // CKEDITOR.config.height = '400px';
    // initCKEditor("contentCorp","");//编辑器ID，初始化内容
});

$(document).ready(function () {
    $("#corpTypeForm").validate();
    $("#corpForm").validate();
    $("#deptForm").validate();
    loadCorpTypes();
    loadCorps();
});

function changeCorpType(btn){
    _corpTypeId = $(btn).attr("value");
    $("button[name='corpTypeBtn']").removeClass("btn-info");
    $(btn).addClass("btn-info");
    loadCorps();
    query();
}

function changeCorp(btn){
    _corpId = $(btn).attr("value");
    $("a[name='corpBtn']").parent().removeClass("active");
    $(btn).parent().addClass("active");
    $("#grid-data").bootgrid("reload");
}

function getParams(){
    return {
        "corp.id":_corpId,
        "corpType.id": _corpTypeId
    }
}

function query(){
    $("#grid-data").bootgrid("reload");
}

//初始化机构类别，查找所有
function loadCorpTypes(){
    $.post(basePath + '/core/corpTypeList.do',{},function (data) {
        var map = $.parseJSON(data);
        buildCorpTypes(map.rows);
    });
}

//查找机构类别对应的机构，并按默认值选中
function loadCorps(){
    $.post(basePath + '/core/corpList.do',
        {
           "corpType.id": _corpTypeId
        },
        function (data) {
        var map = $.parseJSON(data);
        buildCorps(map.rows);
    });
}

//查找select机构类别对应的机构
function loadCorpse(id){
    $.post(basePath + '/core/corpList.do',
        {
            "corpType.id": id
        },
        function (data) {
            var map = $.parseJSON(data);
            buildCorpSelect(map.rows);
        });
}

//构建机构类别按钮及选择器
function buildCorpTypes(rows){
    $("#selCorpType").empty();
    $("#selType").empty();
    $("#selCorpTypeDept").empty();
    $("#selCorpType").append("<button id='allCorpType' name='corpTypeBtn' value='' class='btn btn-lg btn-default' onclick='changeCorpType(this)'>所有机构类别</button>");
    $("#selCorpTypeDept").append("<option value='' >所有机构类别</option>");
    $.each(rows, function (i, row) {
        $("#selCorpType").append("<button name='corpTypeBtn' value='" + row.id + "' code='" + row.code  + "' class='btn btn-lg btn-default' onclick='changeCorpType(this)'>" + row.name + "</button>");
        $("#selType").append("<option value='" + row.id + "'>" + row.name + "</option>");
        $("#selCorpTypeDept").append("<option value='" + row.id + "'>" + row.name + "</option>");
    });
    $("button[value='" + _corpTypeId + "']").addClass("btn-info");
}

//构建机构导航及选择器
function buildCorps(rows){
    $("#selCorp").empty();
    $("#selCorp").append("<li><a id='allCorp' name='corpBtn' value='' href='#' onclick='changeCorp(this)'>所有机构</a></li>");
    $.each(rows, function (i, row) {
        $("#selCorp").append("<li><a name='corpBtn' value='" + row.id + "' href='#' onclick='changeCorp(this)'>" + row.name + "</a></li>");
        // $("#selCorpDept").append("<option value='" + row.id + "'>" + row.name + "</option>");
    });
    $("a[value='" + _corpId + "']").parent().addClass("active");
    buildCorpSelect(rows);
}

function buildCorpSelect(rows){
    $("#selCorpDept").empty();
    $.each(rows, function (i, row) {
        $("#selCorpDept").append("<option value='" + row.id + "'>" + row.name + "</option>");
    });
};

function editCorpType(id){
    //$("#corpTypeForm").data('bootstrapValidator').destroy();
    // $("#corpTypeForm").bootstrapValidator('resetForm', true);
    // if(!id){
    //     id =  _corpTypeId;
    // }
    if(id == ""){
        BootstrapDialog.alert("请先选择一个机构类别");
        return;
    }
    if(id != null && id != undefined){
        var btn = $("button[value='" + id + "']");
        var name = btn.html();
        var code= btn.attr("code");
        $("#codeCorpType").val(code);
        $("#codeCorpType").attr('disabled',"true");
        // $("#codeCorpType").removeAttr('required');
        $("#idCorpType").val(id);
        $("#nameCorpType").val(name);
    }else{
        $("#codeCorpType").val("");
        $("#idCorpType").val("");
        $("#nameCorpType").val("");
    }
    $('#corpTypeModal').modal('show');
}

function corpTypeSave() {
    if(!$("#corpTypeForm").valid())
        return false;
    var id = $("#idCorpType").val();
    var name = $("#nameCorpType").val();
    var code=$("#codeCorpType").val();
    $.post(basePath + '/core/corpTypeSave.do',
        {
            id: id,
            name: name,
            code:code
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.result){
                BootstrapDialog.alert("保存成功！");
                buildCorpTypes(map.rows);
            }else{
                BootstrapDialog.alert("保存失败！");
            }
        }
    );
    $('#corpTypeModal').modal('hide');
}

function corpTypeDel(id) {
    if(!id){
        id =  _corpTypeId;
    }
    if(id == ""){
        BootstrapDialog.alert("请先选择一个机构类别");
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + '/core/corpTypeDel.do',
                {
                    id: id
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        //删除成功后选择第一个区域，不是所有
                        var btn = $("#allCorpType").next();
                        if(btn){
                            _corpTypeId = btn.attr("value");
                        }else {
                            _corpTypeId = "";
                        }
                        buildCorpTypes(map.rows);
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

function editCorp(id){
    if(id == ""){
        BootstrapDialog.alert("请先选择一个机构");
        return;
    }
    if(id != null && id != undefined){//加载机构信息
        $.post(basePath + '/core/getCorp.do',{id:id},function(data){
            var maps = $.parseJSON(data);
            var map=maps.content;
            $("#idCorp").val(map.id);
            $("#selType").val((map.corpType == undefined) ? '' : map.corpType.id);
            $("#nameCorp").val(map.name);
            $("#codeCorp").val(map.code);
            $("#pidCorp").val(map.pid);
            $("#levCorp").val(map.lev);
            $("#telCorp").val(map.tel);
            $("#addrCorp").val(map.addr);
            $("#artificialCorp").val(map.artificial);
            $("#jobCorp").val(map.job);
        });
    }else{
        $("#idCorp").val("");
        $("#nameCorp").val("");
        $("#codeCorp").val("");
        $("#pidCorp").val("");
        $("#levCorp").val("");
        $("#telCorp").val("");
        $("#addrCorp").val("");
        $("#artificialCorp").val("");
        $("#jobCorp").val("");
        $('#selType').val(_corpTypeId);
    }
    $('#corpModal').modal('show');
}
function corpSave() {
    if(!$("#corpForm").valid())
        return false;
    $.post(basePath + '/core/corpSave.do',
        {
            id: $("#idCorp").val(),
            name:$("#nameCorp").val(),
            code:$("#codeCorp").val(),
            pid:$("#pidCorp").val(),
            lev:$("#levCorp").val(),
            tel:$("#telCorp").val(),
            addr: $("#addrCorp").val(),
            artificial: $("#artificialCorp").val(),
            job: $("#jobCorp").val(),
            // content: base64Encode(CKEDITOR.instances.contentCorp.getData()),
            "corpType.id": $("#selType").val()
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.code){
                BootstrapDialog.alert(map.msg);
                loadCorps();
            }else{
                BootstrapDialog.alert(map.msg);
            }
        }
    );
    $('#corpModal').modal('hide');
}

function corpDel(id) {
    if(!id){
        id =  _corpId;
    }
    if(id == ""){
        BootstrapDialog.alert("请先选择一个机构");
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + '/core/corpDel.do',
                {
                    id: id,
                    "corpType.id":_corpTypeId
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        //删除成功后选择第一个分类，不是所有
                        var li = $("#allCorp").parent().next();
                        if(li){
                            _corpId = li.first().attr("value");
                        }else {
                            _corpId = "";
                        }
                        buildCorps(map.rows);
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



function editDept(id){
    if(id != null && id != undefined && id!= ""){//加载部门信息
        $.post(basePath + '/core/getDept.do',{id:id},function(data){
            var maps = $.parseJSON(data);
            var map=maps.content;
            $("#idDept").val(map.id);
            $("#selCorpDept").val((map.corp == undefined) ? '' : map.corp.id);
            $("#selCorpTypeDept").val((map.corpType == undefined) ? '' : map.corpType.id);
            $("#nameDept").val(map.name);
            $("#codeDept").val(map.code);
            $("#pidDept").val(map.pid);
            $("#levDept").val(map.lev);
            $("#chiefDept").val(map.chief);
            $("#jobDept").val(map.job);
        });
    }else{
        $("#idDept").val("");
        $("#nameDept").val("");
        $("#codeDept").val("");
        $("#pidDept").val("");
        $("#levDept").val("");
        $("#chiefDept").val("");
        $("#jobDept").val("");
        $('#selCorpDept').val(_corpId);
        $("#selCorpTypeDept").val(_corpTypeId);
    }
    $('#deptModal').modal('show');
}

function deptSave() {
    if(!$("#deptForm").valid())
        return false;
    $.post(basePath + '/core/deptSave.do',
        {
            id: $("#idDept").val(),
            name:$("#nameDept").val(),
            code:$("#codeDept").val(),
            pid:$("#pidDept").val(),
            lev:$("#levDept").val(),
            chief: $("#chiefDept").val(),
            job: $("#jobDept").val(),
            "corp.id": $("#selCorpDept").val(),
            "corpType.id":$("#selCorpTypeDept").val()
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
    $('#deptModal').modal('hide');
}

function deptDel(id) {
    if(id== "" || id == null || id == undefined){
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + '/core/deptDel.do',
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