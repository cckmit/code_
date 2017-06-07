$(function() {

    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath+"manager/countryList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but = "<button class=\"btn btn-sm btn-primary btn-block\" onclick=\"manageCustomer("+row.id+");\">修改</button>";
                but += "<button class=\"btn btn-sm btn-primary btn-block\" onclick=\"deleteCustomer("+row.id+");\">删除</button>";
                return but;
            },
            "createDate": function(column, row)
            {
                var str=moment(row.createDate).format('YYYY-MM-DD HH:mm:ss');
                return str;
            }
        }
    });
});
function getParams(){
    return {

    }
}

function query(){
    $("#grid-data").bootgrid("reload");
}
function manageCustomer(id){
    var senddata={
        'id':id
    }
    $.ajax({
        type:"POST",
        url:basePath+"manager/getCustomerInfo.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.result){
                var object = data.resultcontent;
                $('#id').val(object.id);
                $('#code').val(object.code);
                $('#name').val(object.name);
                $('#idcard').val(object.idcard);
                $('#phone').val(object.phone);
                $('#addr').val(object.addr);
                $('#email').val(object.email);
                $('#sex').val(object.sex);
                $('#mobile').val(object.mobile);
                $('#myModal').modal('show');
            }
            else{

            }

        }
    });

}

function modify(){
    var senddata = {
        id:$('#id').val(),
        code: $('#code').val(),
        name:$('#name').val(),
        idcard:$('#idcard').val(),
        phone:$('#phone').val(),
        addr:$('#addr').val(),
        email:$('#email').val(),
        sex:$('#sex').val(),
        mobile:$('#mobile').val()
    }
    $.ajax({
        type:"POST",
        url:basePath+"manager/modifyCustomerInfo.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.result){
                BootstrapDialog.alert(data.resultDes);
                $("#grid-data").bootgrid("reload");
                $('#myModal').modal('hide');
            }
            else{
                BootstrapDialog.alert(data.resultDes);
            }

        }
    });
}

function deleteCustomer(id){
    alert("delete"+id);
    var senddata = {
        "id":id
    };
    $.ajax({
        type:"POST",
        url:basePath+"manager/deleteCustomer.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.resultDes);
            $("#grid-data").bootgrid("reload");
        }
    });
}
