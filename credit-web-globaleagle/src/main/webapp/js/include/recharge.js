function checkBalance(amount,ok,cancel,dialog){
    var data={
        price:amount
    };
    $.ajax({
        type:"POST",
        url:basePath+"customer/checkBalance.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(data){
            if(data.code){
                if($.isFunction(ok)){
                    ok(dialog);
                }
            }
            else{
                if($.isFunction(cancel)){
                    cancel(dialog);
                }
            }
        }
    });
}

function addRecharge(){
    var senddata={
        amount:$("#amount").val(),
        methodId:$("#methodId").val()
    }
    $.ajax({
        type:"POST",
        url:basePath+"customer/addRecharge.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            var msg = "支付方式:"+$("#methodId").val()+"充值金额:"+$("#amount").val()+"充值成功";
            BootstrapDialog.alert(msg);
            $('#rechargeModal').modal('hide');
        },
        error : function() {
            var msg = "支付方式:"+$("#methodId").val()+"充值金额:"+$("#amount").val()+"充值失败";
            BootstrapDialog.alert(msg);
        }
    });
}

function chooseMethod(id){
    for(var i=1;i<5;i++){
        $('#img'+i).hide();
    }
    $('#img'+id).show();
    $('#methodId').val(id);
}
