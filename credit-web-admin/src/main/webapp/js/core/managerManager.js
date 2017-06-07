// 客户列表
$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParam,
        url: basePath+"/core/managerList.do",
        // selection: false,
        // multiSelect: false,
        formatters: {
            "operate": function(column, row)
            {
                var but = "<button class=\"btn btn-sm btn-primary \" onclick=\"updManager("+row.id+",'"+row.name+"');\">修改</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary \" onclick=\"deleteManager("+row.id+");\">删除</button>";
                return but;
            },
            "formatCreateTime": function(column, row)
            {
                var str=" ";
                if(row.createTime!=null){
                    str=moment(row.createTime).format('YYYY-MM-DD');
                }
                return str;
            }
        }
    });
});

$(function () {
    $("#addCountryForm1").validate();
    $("#updManagerForm1").validate();
})

function updManager(id,name){
    $('#id').val(id);
    $('#name').val(name);
    $('#updManagerModal').modal('show');
}

function updManagerList(){
    var senddata = {
        id:$('#id').val(),
        code: $('#code').val(),
        name:$('#name').val()
    }
    $.ajax({
        type:"POST",
        url:basePath+"/core/modifyManager.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                BootstrapDialog.alert(data.msg);
                $('#updManagerModal').modal('hide');
                $("#grid-data").bootgrid("reload");
            }
            else{
                BootstrapDialog.alert(data.msg);
            }

        }
    });
}

function getParam(){
    return {
        code:$("#codeName").val()
    }
}

function queryCode() {
    $("#grid-data").bootgrid("reload");
}

function updManagerPwd(){
    if(!$("#updManagerForm1").valid())
        return false;
    var senddata = {
        id:$('#id').val(),
        name:$('#name').val()
    }
    $.ajax({
        type:"POST",
        url:basePath+"/core/updManagerPwd.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                BootstrapDialog.alert(data.msg);
                $('#updManagerModal').modal('hide');
                $("#grid-data").bootgrid("reload");
            }
            else{
                BootstrapDialog.alert(data.msg);
            }

        }
    });
}

// 删除客户
function deleteManager(id){
    var senddata = {
        "id":id
    };
    $.ajax({
        type:"POST",
        url:basePath+"/core/delManager.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if (!confirm("确认要删除？")) {
                window.event.returnValue = false;
            }else {
                BootstrapDialog.alert(data.msg);
                $("#grid-data").bootgrid("reload");
            }
        }
    });
}

function addManager(){
    $('#addManagerModal').modal('show');
}


function addManagerList() {
    if(!$("#addCountryForm1").valid())
        return false;
    var senddata = {
        'name': $("#name1").val(),
        'passwd': $("#pwd1").val(),
        'code': $("#code1").val()
    }
    $.ajax({
        type: "POST",
        url: basePath + "/core/addManager.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(senddata),
        success: function (data) {
            BootstrapDialog.alert(data.msg);
            $("#grid-data").bootgrid("reload");
            $('#addManagerModal').modal('hide');
            }
        });
    }






