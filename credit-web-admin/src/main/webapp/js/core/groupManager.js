/**
 * Created by dell on 2017/4/28.
 */
var _groupId = "";//默认查询所有系统

$(document).ready(function () {
    $("#groupForm").validate();
    loadGroups();
    loadResources();
});

function changeGroup(btn) {
    _groupId = $(btn).attr("value");
    $("a[name='groupBtn']").parent().removeClass("active");
    $(btn).parent().addClass("active");
    if (_groupId == "") {
        buildSources();
    } else {
        loadSource();
    }
}

//初始化组，查找所有
function loadGroups() {
    $.post(basePath + '/core/groupList.do', {}, function (data) {
        var map = $.parseJSON(data);
        buildGroups(map.rows);
    });
}

//初始化系统，查找所有
function loadResources() {
    $.post(basePath + '/core/resourceList.do', {}, function (data) {
        var map = $.parseJSON(data);
        buildResources(map.rows);
    });
}

//查找系统对应的类别，并按默认值选中
function loadSource() {
    var map = null;
    $.post(basePath + '/core/getGroup.do',
        {
            id: _groupId
        },
        function (data) {
            map = $.parseJSON(data);
            buildSources(map.content);
        });
}

//构建组导航
function buildGroups(rows) {
    $("#selGroup").empty();
    $("#selGroup").append("<li><a id='allGroup' name='groupBtn' value='' href='#' onclick='changeGroup(this)'>所有组</a></li>");
    $.each(rows, function (i, row) {
        $("#selGroup").append("<li><a name='groupBtn' value='" + row.id + "'code='" + row.code + "' href='#' onclick='changeGroup(this)'>" + row.name + "</a></li>");
    });
    $("a[value='" + _groupId + "']").parent().addClass("active");
}

//构建资源多选框
function buildResources(rows) {
    $("#selSource").empty();
    $("#resource").empty();
    $("#selSource").append("<li>所有资源</li>");
    $.each(rows, function (i, row) {
        $("#selSource").append("<li><input type='checkbox' name='resource.id' value='" + row.id + "'>" + row.name + "</li>");
        $("#resource").append("<input type='checkbox' name='resource.id' value='" + row.id + "'>" + row.name + "&nbsp");
    });
}

//构建资源默认选中多选框
function buildSources(rows) {
    $("input:checkbox").each(function () {
        if ($(this).is(":checked")) {
            $(this).removeAttr("checked");
        }
    });
    var r = rows.resources;
    //alert(r);
    $.each(r, function (i, row) {
        $("input:checkbox").each(function () {
            // alert(row.id);
            var h = $(this).val();
            // alert(h);
            if (row.id == $(this).val()) {
                $(this).attr("checked", true);
            }
        });
    });
}

function editGroup(id) {
    if (id == "") {
        BootstrapDialog.alert("请先选择一个组");
        return;
    }
    if (id != null && id != undefined) {
        var btn = $("a[value='" + id + "']");
        var name = btn.html();
        var code = btn.attr("code");
        $("#code").val(code);
        $("#id").val(id);
        $("#name").val(name);
    }else{
        $("input:checkbox").each(function () {
            if ($(this).is(":checked")) {
                $(this).removeAttr("checked");
            }
        })
        $("#code").val("");
        $("#id").val("");
        $("#name").val("");
    }
    $('#groupModal').modal('show');
}

function groupSave() {
    if (!$("#groupForm").valid())
        return false;
    var id = $("#id").val();
    var name = $("#name").val();
    var code = $("#code").val();
    var $check_boxes = $("#groupForm input:checkbox");
    var resources = new Array();
    $check_boxes.each(function () {
        if ($(this).is(":checked")) {
            resources.push({id: $(this).val()});
        }
    });
    $.ajax({
        type: "POST",
        url: basePath + "/core/groupSave.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            id: id,
            name: name,
            code: code,
            resources: resources
        }),
        success: function (data) {
            if (data.result) {
                BootstrapDialog.alert("保存成功！");
                buildGroups(data.rows);
                loadSource();
            } else {
                BootstrapDialog.alert("保存失败！");
            }
        }
    });
    $('#groupModal').modal('hide');
}

function groupDel(id) {
    if (!id) {
        id = _groupId;
    }
    if (id == "") {
        BootstrapDialog.alert("请先选择一个组");
        return;
    }
    BootstrapDialog.confirm("确定删除吗？", function (result) {
        if (result) {
            $.post(basePath + '/core/groupDel.do',
                {
                    id: id
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        _groupId = "";
                        buildGroups(map.rows);
                        buildSources();
                        BootstrapDialog.alert("删除成功！");
                    } else {
                        BootstrapDialog.alert("删除失败！<br/>" + map.resultDes);
                    }
                }
            );
        }
    });
}