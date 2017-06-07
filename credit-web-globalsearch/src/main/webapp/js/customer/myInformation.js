function modify(){
    var senddata = {
        "name":$('#name').val(),
        "idcard":$('#idcard').val(),
        "phone":$('#phone').val(),
        "addr":$('#addr').val(),
        "sex":$('#sex').val(),
        "balance":$('#balance').val(),
        "companyName":$('#companyNameA').val(),
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
                BootstrapDialog.alert("Application has been submitted, please later");
            }else{
                BootstrapDialog.alert("You have submitted your application, please do not repeat it");
            }
            // self.location.reload();
        }
    });
}

