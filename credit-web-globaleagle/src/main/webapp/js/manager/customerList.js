
// 客户列表
$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        // rowCount:5,
        ajax: true,
        post: getParams,
        url: basePath+"manager/customerList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                   but += "<button class=\"btn btn-sm btn-primary \" onclick=\"updManager("+row.id+",'"+row.name+"','"+row.passwd+"','"+row.email+"','"+row.levelId+"','"+row.checkStatus+"');\">修改</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary \" onclick=\"deleteManager("+row.id+");\">删除</button>";
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
});



$(function () {
    // $("#addCountryForm1").bootstrapValidator('validate');
    $('#addCountryForm1').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            passwd: {
                message: '密码验证失败',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    //      限制字符串长度
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: '密码长度必须位于3到20之间'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
                }
            }
        }
    });
    $('#updManagerForm1').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            levelId: {
                message: '用户等级验证失败',
                validators: {
                    notEmpty: {
                        message: '请选择用户等级'
                    }
                }
            },
            checkStatus: {
                validators: {
                    notEmpty: {
                        message: '请选择是否认证'
                    }
                }
            }
        }
    });
    $('#hasNoCheck1').click(function() {
        $('#addCountryForm1').bootstrapValidator('validate');
    });
    $('#hasNoCheck2').click(function() {
        $('#updManagerForm1').bootstrapValidator('validate');
    });

    // $("#updManagerForm1").bootstrapValidator('validate');
});

function getParams(){
    return {
        name: $('#name3').val(),
        email:$('#email3').val(),
        levelId:$("#levelId3").val(),
        checkStatus:$('#selectCountryForm1 input[name="checkStatus"]:checked').val()
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
    var senddata = {
        id:$('#id').val(),
        name: $('#name2').val(),
        passwd:$('#passwd2').val(),
        email:$('#email2').val(),
        levelId:$("#levelId2").val(),
        checkStatus:$('#updManagerModal input[name="checkStatus"]:checked').val()

}
    $.ajax({
        type:"POST",
        url:basePath+"manager/updateCustomer.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
                BootstrapDialog.alert("修改成功！");
                query();
        }
    });
    $('#updManagerModal').modal('hide');
}

// 删除客户
function deleteManager(id) {
    var senddata = {
        "id":id
    };
    $.ajax({
        type:"POST",
        url:basePath+"manager/delCustomer.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if (!confirm("确认要删除？")) {
                window.event.returnValue = false;
            }else {
                BootstrapDialog.alert("删除成功！");
                query();
            }
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

    var senddata={
        'name':$("#name1").val(),
        'passwd':$("#pwd1").val(),
        'email':$("#email1").val(),
        'levelId':$("#levelId1").val(),
        'checkStatus':$('#addManagerModal input[name="checkStatus"]:checked').val()
    }

    $.ajax({
        type: "POST",
        url: basePath + "manager/addCustomer.do",
        dataType: "json",
        contentType: "application/json",
        data:JSON.stringify(senddata),
        success: function (data) {
                BootstrapDialog.alert(data.msg);
                query();

        }
    });
    $('#addManagerModal').modal('hide');
}

