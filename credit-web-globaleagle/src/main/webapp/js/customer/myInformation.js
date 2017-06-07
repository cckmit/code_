function modify(){
    var senddata = {
        "name":$('#name').val(),
        "idcard":$('#idcard').val(),
        "phone":$('#phone').val(),
        "addr":$('#addr').val(),
        "sex":$('#sex').val(),
        "balance":$('#balance').val(),
        "companyName":$('#companyName').val(),
        "companyAddress":$('#companyAddress').val(),
        "companyPhone":$('#companyPhone').val(),
        "position":$('#position').val()
    };
    $.ajax({
        type:"POST",
        url:basePath+"customer/changedInformation.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.msg);
        }
    });
}

function authCompanyCommit() {
    $.ajax({
        type:"POST",
        url:basePath+"customer/authCompanyCommit.do",
        contentType:"application/json",
        cache: false,
        success:function(data){
            if (data.result){
                BootstrapDialog.alert("已提交申请，请稍后");
            }else{
                BootstrapDialog.alert("您已提交申请，请勿重复提交");
            }
            // self.location.reload();
        }
    });
}

