/**
 * Created by dell on 2017/3/21.
 */
$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        // rowCount:5,
        ajax: true,
        post: getParams,
        url: basePath+"/core/moduleList.do",
        formatters: {
            "operate": function (column, row) {
                var but = "";
                but += "<button class=\"btn btn-sm btn-primary \" onclick=\"upModule(" + row.id + ",'" + row.name + "','"  + row.enable + "');\">修改</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary \" onclick=\"deleteModule(" + row.id + ");\">删除</button>";
                return but;
            },
            "enable": function (column, row) {
                var str;
                if (row.enable ==true) {
                    str = "是";
                } else if (row.enable == false) {
                    str = "否";
                }
                return str;
            }
        }
    });
});

$(function () {
    $("#addProductForm").validate();
    $("#upProductForm").validate();
});

function getParams() {
    return {

    };
}

// 删除产品
function deleteModule(id) {
    if(id < 1){
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            var senddata = {
                "id":id
            };
            $.ajax({
                type:"POST",
                url:basePath+"/core/delModule.do",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(senddata),
                success:function(data){
                    if(data.code){
                        BootstrapDialog.alert(data.msg);
                        query();
                    }else{
                        BootstrapDialog.alert(data.msg);
                    }
                }
            });
        }
    });
}

function query(){
    $("#grid-data").bootgrid("reload");
}

function addModule(){
    $('#addModuleModal').modal('show');
}


function addModuleList() {
    if(!$("#addModuleForm").valid())
        return false;
    var senddata={
        'name':$("#name").val(),
        'enable':$('#enable').val()
    }

    $.ajax({
        type: "POST",
        url: basePath + "/core/addModule.do",
        dataType: "json",
        contentType: "application/json",
        data:JSON.stringify(senddata),
        success: function (data) {
            if(data.code){
                BootstrapDialog.alert(data.msg);
                query();
            }else{
                BootstrapDialog.alert(data.msg);
            }
        }
    });
    $('#addModuleModal').modal('hide');
}

function upModule(id,name,enable){
    $('#id1').val(id);
    $('#name1').val(name);
    $("#enable1").val(enable);
    $('#upModuleModal').modal('show');
}

function upModuleList() {
    if (!$("#upModuleForm").valid())
        return false;
    var senddata = {
        'id': $('#id1').val(),
        'name': $("#name1").val(),
        'enable':$('#enable1').val()
    }
    $.ajax({
        type: "POST",
        url: basePath + "/core/upModule.do",
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
    $('#upModuleModal').modal('hide');
}