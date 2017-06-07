/**
 * Created by Michael on 2016/12/29.
 */

function confirmOPw() {
    var oldPw = $('#oldPw').val();
    if($.trim(oldPw)=='' || oldPw==null){
        BootstrapDialog.alert("原密码不得为空");
    }else {
        var senddata = {
            'oldPw': oldPw
        }
        $.ajax({
            method: "POST",
            url: basePath + "/core/pwdExist.do",
            cache: false,
            dataType: 'json',
            contentType: "application/json",
            data:JSON.stringify(senddata),
            success: function (data) {
                if (data.code) {
                    BootstrapDialog.alert("请输入正确的原密码");
                }
            }
        });
    }
}

function checkInfo() {
    var new_pw = $('#new_pw').val();
    var re_pw = $('#re_pw').val();
    if($.trim(new_pw)=="" || $.trim(new_pw)==undefined ){
        BootstrapDialog.alert("请输入新密码！");
        return;
    }
    if($.trim(re_pw)=="" || $.trim(re_pw)==undefined){
        BootstrapDialog.alert("请确认密码！");
        return;
    }
    if($.trim(new_pw)!=$.trim(re_pw)){
        BootstrapDialog.alert("新密码和确认密码不同，请重新输入");
    }else{
        var senddata = {
            're_pw': re_pw
        }
        $.ajax({
            method: "POST",
            url: basePath + "/core/updPw.do",
            cache: false,
            dataType: 'json',
            contentType: "application/json",
            data:JSON.stringify(senddata),
            success: function (data) {
                if(data.code){
                    BootstrapDialog.show({
                        message: "提交成功",
                        buttons:[{
                            label: 'OK',
                            action: function(){
                                window.location.href = basePath + "/toLogin.do";
                            }
                        }]
                    });
                }
            }
        });
    }
}




    

