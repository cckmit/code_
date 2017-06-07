$(function() {
    $("#fastAddLi").addClass("active");
    $("#file").fileinput({
        language : "zh",
        uploadUrl : encodeURI(encodeURI(basePath + "uploadPic.do")),
        //上传成功后执行自定义方法
        success_extra : function(data, textStatus) {
            if(textStatus == 'success' && !$.isEmptyObject(data)){
                $('#uploadPicPath').val(data.filePath);
                BootstrapDialog.alert("上传成功");
            }else {
                BootstrapDialog.alert("上传失败");
            }
        }
    });

    $.each(continents,function(i,item){
    	if (continent==null||continent==""|| continent=="undefined") {
            $("#continent").append("<option >"+item.cnName+"</option>");
        }else{
    		if (continent==item.cnName) {
		        $("#continent").append("<option selected='selected'>"+item.cnName+"</option>");
			}else{
		        $("#continent").append("<option >"+item.cnName+"</option>");
			}
        }
        $.each(item.countries,function(j,itemj){       
        	if (country==null||country==""||country=="undefined") {
	            $("#company_country").append("<option >"+itemj.cnName+"</option>");	           
			}else{		
				if (country==itemj.cnName) {
		            $("#company_country").append("<option selected='selected'>"+itemj.cnName+"</option>");
		            onCountry(itemj.cnName);
				}else{
		            $("#company_country").append("<option >"+itemj.cnName+"</option>");
				}
			}
        });
    });
    if ((continent!=null||continent!=""||continent!="undefined")&&(country==null||country==""||country=="undefined")){
        onContinentChange();
    }else{
        onContinentChange2(country1);
    }
    //设置图片状态
    cbUploadPicClick();
});

function cbUploadPicClick(){
    if($("#cbUploadPic").attr("checked")=="checked"){
        $("#uploadPic").show();
        $("#file").fileinput("enable");
        $("#company_address").attr("disabled",true);
        $("#company_phone").attr("disabled",true);
        $("#company_website").attr("disabled",true);
        $("#txtOther").attr("disabled",true);
    }
    else{
        $("#uploadPic").hide();
        $("#file").fileinput("disable");
        $("#company_address").attr("disabled",false);
        $("#company_phone").attr("disabled",false);
        $("#company_website").attr("disabled",false);
        $("#txtOther").attr("disabled",false);
    }


}


function onContinentChange(){
    var continent = $("#continent").val();
    $("#company_country").empty();
    $("#company_country").append("<option selected='selected'>请选择</option>");
    $.each(continents,function(i,item){
        if(item.cnName == continent){
            $.each(item.countries,function(j,itemj){
                $("#company_country").append("<option >"+itemj.cnName+"</option>");
            });
        }
    });
}

function onContinentChange2(country1){
    var continent = $("#continent").val();
    $("#company_country").empty();
    if (country1!=null||country1!=""){
        $("#company_country").append("<option selected='selected'>"+country+"</option>");
    }else{
        $("#company_country").append("<option selected='selected'>请选择</option>");
        $.each(continents,function(i,item){
            if(item.cnName == continent){
                $.each(item.countries,function(j,itemj){
                    $("#company_country").append("<option >"+itemj.cnName+"</option>");
                });
            }
        });
    }

}
function onCountryChange(value){
    var continent = $("#continent").val();
    $.each(continents,function(i,item){
        if(item.cnName == continent){
            $.each(item.countries,function(j,itemj){
                if(itemj.cnName == value){
                    $("#countryName1").html(itemj.cnName);
                    $("#countryName2").html(itemj.cnName);
                }
            });
        }
    });
}
function onCountry(value){
    $.each(continents,function(i,item){
            $.each(item.countries,function(j,itemj){
                if(itemj.cnName == value){
                    $("#countryName1").html(itemj.cnName);
                    $("#countryName2").html(itemj.cnName);
                }
            });
    });
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
    if ($("#company_country").val()=="请选择"||$("#company_country").val()=="") {
        BootstrapDialog.alert("国家不为空");
        return false;
    }
    if ($("#company_name").val()=="请选择"||$("#company_name").val()=="") {
        BootstrapDialog.alert("公司名不为空");
        return false;
    }
    if ($("#clause").attr("checked")==undefined) {
        BootstrapDialog.alert("请接受法律条款");
        return false;
    }
    if($("#cbUploadPic").attr("checked")!=undefined){
    	if ($('#uploadPicPath').val()==null||$('#uploadPicPath').val()=="") {
            BootstrapDialog.alert("上传文件不能为空");
            return false;  
		}
  
    }else{

    if ($("#company_address").val()==null||$("#company_address").val()=="") {
        BootstrapDialog.alert("公司地址不为空");
        return false;
    }
    if ($("#company_name").val()==null||$("#company_name").val()=="") {
        BootstrapDialog.alert("公司名不为空");
        return false;
    }
    if ($("#company_phone").val()==null||$("#company_phone").val()=="") {
        BootstrapDialog.alert("公司电话不为空");
        return false;
    }
    }
    return true;
}


function ajaxFileUpload(){
    //开始上传文件时显示一个图片,文件上传完成将图片隐藏
    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
    //执行上传文件操作的函数，使用encodeURI方法，防止传输中文字符的时候出现乱码
    var uploadUrl = encodeURI(encodeURI(basePath + "uploadPic.do"));
    $.ajaxFileUpload({
        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
        url:uploadUrl,
        secureuri:false,                       //是否启用安全提交,默认为false
        fileElementId:'file',           //文件选择框的id属性
        dataType:'text',                       //服务器返回的格式,可以是json或xml等
        success:function(data, status){       //服务器响应成功时的处理函数
            data = data.replace("<PRE>", '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre>text</pre>前后缀
            data = data.replace("</PRE>", '');
            data = data.replace("<pre>", '');
            data = data.replace("</pre>", ''); //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]
            //将String字符串转换成json
            var dataset = $.parseJSON(data);
            if(dataset.status == "OK"){
                 $('#uploadPicPath').val(dataset.filePath);
                $('#result').html("上传成功");
                BootstrapDialog.alert("上传成功");
            }else if ( dataset.status == "EMPTY"){
                $('#result').html("没有选择文件！");
                BootstrapDialog.alert("没有选择文件！");
            }else {
                $('#result').html('文件上传失败，请重试！！');
                BootstrapDialog.alert("文件上传失败，请重试！！");
            }
        },
        error:function(data, status, e){ //服务器响应失败时的处理函数
            console.log(e);
            console.log(data);
            BootstrapDialog.alert("文件上传失败，请重试！！");
        }
    });
}

function statement() {
    BootstrapDialog.show({
        title: '免责声明:  ',
        message: "&nbsp;&nbsp;"+'用户应对从本网站获取的所有内容自行加以判断，结合自身实际并依据谨慎原则作出相应决策，并承担因使用内容而引起的所有风险，全球鹰不对决策结果承担责任。'
        +'全球鹰提供产品所含内容仅供使用者参考使用，并不意味着为客户的商业风险提供担保，在任何情况下，对于客户的商业决策所造成的损失，本网站不承担用户的任何商业风险，也不承担由于非控因素和疏忽而引起的相应的损失和损害。'
    });
}


