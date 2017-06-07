/**
 * Created by dell on 2017/4/7.
 */
var _deptId = "";//默认查询所有机构类别
var _corpId = "";//默认查询所有机构
$(function () {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParam,
        url: basePath + "/core/usersList.do",
        formatters: {
            "operate": function (column, row) {
                var but = "<button class=\"btn btn-sm btn-primary \" onclick=\"updManager('" + row.id + "');\">修改</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary \" onclick=\"deleteManager('" + row.id + "');\">删除</button>";
                return but;
            },
            "formatCreateTime": function (column, row) {
                var str = " ";
                if (row.createTime != null) {
                    str = moment(row.createTime).format('YYYY-MM-DD');
                }
                return str;
            }
        }
    });
});

function getParam() {
    var time = $("#createTime").val();

    if (time != undefined && time != '') {
        time += " 00:00:00";
    }
    return {
        createTime: time,
        username: $("#username").val()
    }
}

$(function () {
    $("#addCountryForm1").validate();
    $("#updManagerForm1").validate();
    loadCorps();
    loadGroups();
    loadDepts();
})

function changeCorp(btn) {
    _corpId = btn;
    loadDepts();
}

//初始化机构，查找所有
function loadCorps() {
    $.post(basePath + '/core/corpList.do', {}, function (data) {
        var map = $.parseJSON(data);
        buildCorps(map.rows);
    });
}

//初始化组，查找所有
function loadGroups() {
    $.post(basePath + '/core/groupList.do', {}, function (data) {
        var map = $.parseJSON(data);
        buildGroups(map.rows);
    });
}

//查找机构对应的部门，并按默认值选中
function loadDepts() {
    $.post(basePath + '/core/deptList.do',
        {
            "corp.id": _corpId
        },
        function (data) {
            var map = $.parseJSON(data);
            buildDepts(map.rows);
        });
}

//构建机构选择器
function buildCorps(rows) {
    $("#selCorpDept1").empty();
    $("#selCorpDept2").empty();
    $("#selCorpDept1").append("<option value='' >所有机构</option>");
    $("#selCorpDept2").append("<option value=''>所有机构</option>");
    $.each(rows, function (i, row) {
        $("#selCorpDept1").append("<option value='" + row.id + "'>" + row.name + "</option>");
        $("#selCorpDept2").append("<option value='" + row.id + "'>" + row.name + "</option>");
    });
}

//构建组选择器
function buildGroups(rows) {
    $("#selGroup1").empty();
    $("#selGroup2").empty();
    $.each(rows, function (i, row) {
        $("#selGroup1").append("<option value='" + row.id + "' text='" + row.name + "'>" + row.name + "</option>");
        $("#selGroup2").append("<option value='" + row.id + "' text='" + row.name + "'>" + row.name + "</option>");
    });
    $("#selGroup1").selectpicker("refresh");
    $("#selGroup2").selectpicker("refresh");
}

//构建部门选择器
function buildDepts(rows) {
    $("#selDept1").empty();
    $("#selDept2").empty();
    $("#selDept1").append("<option value=''>请选择</option>");
    $("#selDept2").append("<option value=''>请选择</option>");
    $.each(rows, function (i, row) {
        $("#selDept1").append("<option value='" + row.id + "'>" + row.name + "</option>");
        $("#selDept2").append("<option value='" + row.id + "'>" + row.name + "</option>");
    });
}


function updManager(id) {
    var senddata = {
        'id': id
    }
    $.ajax({
        type: "POST",
        url: basePath + "/core/getUsers.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(senddata),
        success: function (data) {
            // var maps = $.parseJSON(data);
            var map = data.content;
            $("#id2").val(map.id);
            $("#username2").val(map.username);
            $("#locked2").val(map.locked);
            $("#name2").val(map.name);
            $("#idcard2").val(map.idcard);
            $("#phone2").val(map.phone);
            $("#addr2").val(map.addr);
            $("#email2").val(map.email);
            $("#createBy2").val(map.createBy);
            $("#sex2").val(map.sex);
            $("#birthday2").val(map.birthday);
            $("#mobile2").val(map.mobile);
            $("#otherContact2").val(map.otherContact);
            $("#sosPerson2").val(map.sosPerson);
            $("#sosMobile2").val(map.sosMobile);
            $("#bornPlace2").val(map.bornPlace);
            $("#selCorpDept2").val((map.corp == undefined) ? '' : map.corp.id);
            $("#selDept2").val((map.dept == undefined) ? '' : map.dept.id);
            var groupArr = map.groups;
            if (groupArr != undefined) {
                var tmpArr = new Array();
                $.each(groupArr, function (i, v) {
                    tmpArr.push(v.id);
                });
                if (tmpArr.length > 0) {
                    $('#selGroup2').selectpicker('val', tmpArr);
                }
            }
        }
    });
    $('#updManagerModal').modal('show');
}


function updManagerList() {
    if (!$("#updManagerForm1").valid())
        return false;
    var groupsStr = $("#selGroup2").selectpicker("val");
    var groups = new Array();
    if (groupsStr != null && groupsStr != undefined) {
        $.each(groupsStr, function (i, row) {
            var s = {id: row};
            groups.push(s);
        });
    }
    var senddata = {
        id: $("#id2").val(),
        username: $("#username2").val(),
        locked: $("#locked2").val(),
        name: $("#name2").val(),
        idcard: $("#idcard2").val(),
        phone: $("#phone2").val(),
        addr: $("#addr2").val(),
        email: $("#email2").val(),
        createBy: $("#createBy2").val(),
        sex: $("#sex2").val(),
        birthday: $("#birthday2").val(),
        mobile: $("#mobile2").val(),
        otherContact: $("#otherContact2").val(),
        sosPerson: $("#sosPerson2").val(),
        sosMobile: $("#sosMobile2").val(),
        bornPlace: $("#bornPlace2").val(),
        corp: {id: $('#selCorpDept2').val()},
        dept: {id:$('#selDept2').val()},
        groups: groups
    };
    $.ajax({
        type: "POST",
        url: basePath + "/core/modifyUser.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(senddata),
        success: function (data) {
            var map = $.parseJSON(data);
            if (map.code) {
                BootstrapDialog.alert(map.msg);
                $('#updManagerModal').modal('hide');
                query();
            }
            else {
                BootstrapDialog.alert(map.msg);
            }
        }
    });
    $('#updManagerModal').modal('hide');
}


function query() {
    $("#grid-data").bootgrid("reload");
}

function updManagerPwd() {
    if (!$("#updManagerForm1").valid())
        return false;
    var groupsStr = $("#selGroup2").selectpicker("val");
    var groups = new Array();
    if (groupsStr != null && groupsStr != undefined) {
        $.each(groupsStr, function (i, row) {
            var s = {id: row};
            groups.push(s);
        });
    }
    var senddata = {
        id: $('#id2').val(),
        username: $('#username2').val(),
        locked: $('#locked2').val(),
        name: $('#name2').val(),
        idcard: $('#idcard2').val(),
        phone: $('#phone2').val(),
        addr: $('#addr2').val(),
        email: $('#email2').val(),
        createBy: $('#createBy2').val(),
        sex: $('#sex2').val(),
        birthday: $('#birthday2').val(),
        mobile: $('#mobile2').val(),
        otherContact: $('#otherContact2').val(),
        sosPerson: $('#sosPerson2').val(),
        sosMobile: $('#sosMobile2').val(),
        bornPlace: $('#bornPlace2').val(),
        corp: {id: $('#selCorpDept2').val()},
        dept: {id:$('#selDept2').val()},
        groups: groups
    }

    $.ajax({
        type: "POST",
        url: basePath + "/core/updUserPwd.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(senddata),
        success: function (data) {
            if (data.code) {
                BootstrapDialog.alert(data.msg);
                $('#updManagerModal').modal('hide');
                query();
            }
            else {
                BootstrapDialog.alert(data.msg);
            }
        }
    });
}

// 删除客户
function deleteManager(id) {
    if (id == "" || id == null || id == undefined) {
        return;
    }
    var senddata = {
        id: id
    };
    BootstrapDialog.confirm("确定删除吗？", function (result) {
        if (result) {

            $.ajax({
                type: "POST",
                url: basePath + "/core/delUser.do",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(senddata),
                success: function (data) {
                    if (data.code) {
                        BootstrapDialog.alert(data.msg);
                        query();
                    } else {
                        BootstrapDialog.alert(data.msg);
                    }
                }
            });
        }
    });
}

function addCManager() {
    // $("#id2").val('');
    // $("#username2").val('');
    // $("#locked2").val("");
    // $("#name2").val("");
    // $("#idcard2").val("");
    // $("#phone2").val("");
    // $("#addr2").val("");
    // $("#email2").val("");
    // $("#createBy2").val("");
    // $("#sex2").val("");
    // $("#birthday2").val("");
    // $("#mobile2").val("");
    // $("#otherContact2").val("");
    // $("#sosPerson2").val("");
    // $("#sosMobile2").val("");
    // $("#bornPlace2").val("");
    // $("#selCorpDept2").val("");
    // $("#selDept2").val("");
    $('#addManagerModal').modal('show');
}


function addManagerList() {
    if (!$("#addCountryForm1").valid())
        return false;
    // var data = $("#addCountryForm1").serializeArray();
    var groupsStr = $("#selGroup1").selectpicker("val");
    var groups = new Array();
    if (groupsStr != null && groupsStr != undefined) {
        $.each(groupsStr, function (i, row) {
            var s = {id: row};
            groups.push(s);
        });
    }
    var senddata = {
        username: $('#username1').val(),
        theme: $("#theme1").val(),
        name: $('#name1').val(),
        idcard: $('#idcard1').val(),
        phone: $('#phone1').val(),
        addr: $('#addr1').val(),
        email: $('#email1').val(),
        createBy: $('#createBy1').val(),
        sex: $('#sex1').val(),
        birthday: $('#birthday1').val(),
        mobile: $('#mobile1').val(),
        otherContact: $('#otherContact1').val(),
        sosPerson: $('#sosPerson1').val(),
        sosMobile: $('#sosMobile1').val(),
        bornPlace: $('#bornPlace1').val(),
        corp: {id: $('#selCorpDept1').val()},
        dept: {id:$('#selDept1').val()},
        groups: groups
    };
    $.ajax({
        type: "POST",
        url: basePath + "/core/addUser.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(senddata),
        success: function (data) {
            if (data.code) {
                BootstrapDialog.alert(data.msg);
                $("#grid-data").bootgrid("reload");
                $('#addManagerModal').modal('hide');
            } else {
                BootstrapDialog.alert(data.msg);
            }
        }
    });
}