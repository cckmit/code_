
function visitorAddOrder(){
	if (!checkForm()) {
		return;
	}
	var payMethod = $('input[name="optionsRadios"]:checked ').val();
	var email = $("#inputEmail").val();
    var data = {
            'email':$("#inputEmail").val()
        };
	$.ajax({
        type:"POST",
        url:basePath+"user/visitorAddOrder.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(data){
        	if (!data.code) {
                BootstrapDialog.alert(data.msg);
			}else{
        		if(payMethod == "option1") {
                    //支付宝接口
                    window.location.href = basePath + "user/toAlipay.do?id=" + data.content.id + "&emailAddress=" + email;
                }else if(payMethod == "option2"){
        			//微信
                    $.post(basePath + "/user/toWeixinPay.do",
                        {
                            "id": data.content.id,
                            "emailAddress": email
                        },
                        function (result) {
                            if (result == null || result == undefined || result == '') {
                                BootstrapDialog.alert("微信支付二维码获取失败，请稍后再试！");
                            } else {
                                $('#qrcode').empty();
                                $('#qrcode').qrcode(result);
                                $("#weixinPayModal").modal("show");
                                //开始不间断向后台查询支付结果
                                checkHasPay(data.content.id);
                            }
                        });
				}
			}}
    });
}
function checkHasPay(orderId) {
    $.post(
        basePath + "/user/checkHasPay.do",
        {
            id: orderId
        },
        function (data) {
            if(data == null || data == undefined || data == ''){
                //支付完成，跳转页面
                window.location.href = basePath + "/user/hasPay.do?id=" + orderId;
            }else{
                //未支付完成，继续
                window.setTimeout(function () {
                    checkHasPay(orderId);
                }, 3000);
            }
        }
    )
}


function isEmail(strEmail) {
	if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1){
		return true;
	}else{
        BootstrapDialog.alert("请输入正确email格式");
		return false;
	}
}
  function checkForm (){

		if ($("#inputEmail").val()==null||$("#inputEmail").val()=="") {
            BootstrapDialog.alert("email地址不为空");
			return false;
		}
		if ($("#inputEmailAgain").val()==null||$("#inputEmailAgain").val()=="") {
            BootstrapDialog.alert("确认email不为空");
			return false;
		}			
		if ($("#inputEmailAgain").val()!=$("#inputEmail").val()) {
            BootstrapDialog.alert("确认email地址不相等");
			return false;
		}
		if (!isEmail($("#inputEmail").val())) {
			return false;
		}
		return true;
 }
  
  function submitLogin (){
		if ($("#email").val()==null||$("#email").val()=="") {
          BootstrapDialog.alert("用户名地址不为空");
			return false;
		}
		if ($("#password").val()==null||$("#password").val()=="") {
          BootstrapDialog.alert("密码不为空");
			return false;
		}	
		if (!isEmail($("#email").val())) {
			return false;
		}
		return true;
}


