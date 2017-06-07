var _source=1;
// 客户列表
$(document).ready(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        // rowCount:5,
        ajax: true,
        post: getParams,
        url: basePath+"/core/customerListGE.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                   but += "<button class=\"btn btn-sm btn-primary \" onclick=\"updManager("+row.id+",'"+row.name+"','"+row.passwd+"','"+row.email+"','"+row.levelId+"','"+row.checkStatus+"');\">修改</button>";
                // but += "&nbsp;<button class=\"btn btn-sm btn-primary \" onclick=\"deleteManager("+row.id+");\">删除</button>";
                return but;
            },
            "createTime": function(column, row)
            {
                var str=" ";
                if(row.createTime!=null){
                    str=moment(row.createTime).format('YYYY-MM-DD');
                }
                return str;
            },
            "levelId": function(column, row)
            {
                var lev="";
                if(row.levelId!=null){
                    if(row.levelId==1){
                        lev="普通客户";
                    }
                    if(row.levelId==3){
                        lev="大客户";
                    }
                }
                return lev;
            }
        }
    });
    $("#addCountryForm1").validate();
    $("#updManagerForm1").validate();
});

function getParams(){
    return {
        name: $('#name3').val(),
        email:$('#email3').val(),
        levelId:$("#levelId3").val(),
        checkStatus:$("#checkStatus3").val()
    }
}


function updManager(id,name,passwd,email,levelId,checkStatus){
    $('#id').val(id);
    $('#name2').val(name);
    $('#passwd2').val(passwd);
    $('#email2').val(email);
    $("#levelId2").val(levelId);
    if(checkStatus!=null && checkStatus!="undefind"){
        if(checkStatus == "是"){
            $('#updManagerModal input:radio:first').attr('checked', 'true');
        }else{
            $('#updManagerModal input:radio:last').attr('checked', 'true');
        }
    }else{
        $('#updManagerModal input:radio:last').attr('checked', 'true');
    }
    $('#updManagerModal').modal('show');
}

function updManagerList(){
    if(!$("#updManagerForm1").valid())
        return false;
    var senddata = {
        id:$('#id').val(),
        name: $('#name2').val(),
        passwd:$('#passwd2').val(),
        email:$('#email2').val(),
        levelId:$("#levelId2").val(),
        checkStatus:$('#updManagerModal input[name="checkStatus"]:checked').val()
    };
    $.ajax({
        type:"POST",
        url:basePath+"/core/updateCustomerGE.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                BootstrapDialog.alert(data.msg);
                query();
            } else{
                BootstrapDialog.alert(data.msg);
            }
        }
});
    $('#updManagerModal').modal('hide');
}

//删除客户
function deleteManager(id) {
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
                url:basePath+"/core/delCustomerGE.do",
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

function addManager(){
    $('#addManagerModal').modal('show');
}


function addManagerList() {
    if(!$("#addCountryForm1").valid())
        return false;
    $.post(
        basePath + "/core/addCustomerGE.do",
        {
            "name":$("#name1").val(),
            "passwd":$("#pwd1").val(),
            "email":$("#email1").val(),
            "levelId":$("#levelId1").val(),
            "checkStatus":$('#addManagerModal input[name="checkStatus"]:checked').val()
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.code){
                BootstrapDialog.show({
                    title:'提示',
                    message:'保存成功',
                    buttons: [{
                        label: '确定',
                        action: function(dialog) {
                            dialog.close();
                            query();
                        }
                    }]
                });
            }else{
                BootstrapDialog.alert(map.msg);
            }
        }
    );
    $('#addManagerModal').modal('hide');
}