// 客户列表
$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath+"/basic/customerList.do",
        formatters: {
            "operate": function(column, row)
            {
                var checkStatus = row.checkStatus;
                var label = "通过认证";
                if(checkStatus == '是'){
                    label = "取消认证";
                }else{
                    checkStatus = "否";
                }
                var but = "<button class=\"btn btn-sm btn-primary\" onclick=\"editCheckStatus("+row.id+",'" + checkStatus + "');\">" + label + "</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary\" onclick=\"editCustomer("+row.id+");\">详情</button>";
                // but +="&nbsp;<button class=\"btn btn-sm btn-primary\" onclick=\"deleteCustomer("+row.id+");\">删除</button>";
                return but;
            },
            "formatCreateTime": function(column, row)
            {
                var str=" ";
                if(row.createTime!=null){
                    str=moment(row.createTime).format('YYYY-MM-DD');
                }
                return str;
            },
            "level": function(column, row)
            {
                var str=" ";
                if(row.levelId=='1'||row.levelId==1){
                    str="普通用户";
                }else if(row.levelId=='3'||row.levelId==3){
                    str="vip3大客户";
                }
                return str;
            }
        }
    });
});

function getParams(){
    var time=$("#createTime1").val();

    if(time != undefined && time != ''){
        time += " 00:00:00";
    }
    return {
        createTime: time,
        checkStatus:$("#checkStatus1").val()
    }
}

function query(){
    $("#grid-data").bootgrid("reload");
}
// 详细信息
function manageCustomer(id){
    var senddata={
        'id':id
    }
    $.ajax({
        type:"POST",
        url:basePath+"/basic/getCustomerInfoGE.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                var object = data.resultcontent;

                //object.createTime.format('YYYY-MM-DD HH:mm:ss');
                $('#id').val(object.id);
                $('#code').val(object.code);
                $('#name').val(object.name);
                $('#createTime').val(object.createTime);
                $('#levelId').val(object.levelId);
                $('#balance').val(object.balance);
                $('#idcard').val(object.idcard);
                $('#mobile').val(object.mobile);
                $('#email').val(object.email);
//                $('#sex').val(object.sex);
                $('#myModal').modal('show');
            }
            else{
//            	添加输入框：
                $('#id').val();
                $('#code').val();
                $('#name').val();
                $('#createTime').val();
                $('#levelId').val();
                $('#balance').val();
                $('#idcard').val();
                $('#mobile').val();
                $('#email').val();
                $('#myModal1').modal('show');

            }
        }
    });

}

function editCheckStatus(id, oldStatus){
    // BootstrapDialog.alert("in editCheckStatus");
    var info = "认证";
    var checkStatus = "是";
    if(oldStatus == "是"){
        info = "取消认证";
        checkStatus = "否";
    }
    var senddata={
        'id':id,
        "checkStatus": checkStatus
    }
    $.ajax({
        type:"POST",
        url:basePath+"/basic/modifyCertify.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                BootstrapDialog.alert(info + "成功");
                $("#grid-data").bootgrid("reload");
            }
            else{
                BootstrapDialog.alert(info + "失败");
            }
        }
    });
}
// 是否启用
function editEnable(){
    var oldEnable = $("#enable").val();
    alert("oldEnable: "+ oldEnable);
    alert($("#id").val());
    var t;
    var info = "启用";
    var enable;
    if(oldEnable == "true"){
        info = "取消启用";
        alert("取消启用");
        enable = false;
        oldEnable = "false";
        t = "未启用";
    }else{
        enable = true;
        alert("启用");
        oldEnable = "true";
        t = "已启用";
    }
    var senddata={
        'id':$("#id").val(),
        "enable": enable,
    }
    $.ajax({
        type:"POST",
        url:basePath+"customer/modifyEnable.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.result){
                BootstrapDialog.alert(info + "成功");
//				$("p").html(t);
                $("#isEnable").text(t);
                $("#enable").val(oldEnable);
//				$("#customerModal").bootgrid("reload");
            }
            else{
                BootstrapDialog.alert(info + "失败");
            }
        }
    });
}
// 修改
function modify(){
    var senddata = {
        id: $("#id").val(),
        code: $("#code").val(),
        name: $("#name").val(),
        theme: $("#theme").val(),
        idcard: $("#idcard").val(),
        phone: $("#phone").val(),

        addr: $("#addr").val(),
        email: $("#email").val(),
        createTime: $("#createTime").val(),
        loginCount: $("#loginCount").val(),
        lastTime: $("#lastTime").val(),
        enable: $("#enable").val(),
        createBy: $("#createBy").val(),
        sex: $("#sex").val(),

        birthday: $("#birthday").val(),
        mobile: $("#mobile").val(),
        otherContact: $("#otherContact").val(),
        sosPerson: $("#sosPerson").val(),
        sosMobile: $("#sosMobile").val(),
        bornPlace: $("#bornPlace").val(),
        levelId: $("#levelId").val(),
        balance: $("#balance").val(),

        companyName: $("#companyName").val(),
        companyAddress: $("#companyAddress").val(),
        companyPhone: $("#companyPhone").val(),
        position: $("#position").val(),
        checkStatus: $("#checkStatus").val(),
    }
    $.ajax({
        type:"POST",
        url:basePath+"customer/modifyCustomerInfo.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.result){
                var object = data.resultcontent;

                BootstrapDialog.alert(data.resultDes);
                $("#grid-data").bootgrid("reload");
                $('#customerModal').modal('hide');
            }
            else{
                BootstrapDialog.alert(data.resultDes);
            }

        }
    });
}
// 删除客户
function deleteCustomer(id){
    alert("delete"+id);
    var senddata = {
        "id":id
    };
    $.ajax({
        type:"POST",
        url:basePath+"/basic/deleteCustomer.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.msg);
            $("#grid-data").bootgrid("reload");
        }
    });
}
// 改变颜色
function changeColor(){
    if($("#companyNameStatus").val() == '1'||$("#companyNameStatus").val() == 1){
        $("#cnStatusDiv").toggleClass("has-error").removeClass("has-error");
        $("#cnStatusDiv").toggleClass("has-warning").removeClass("has-warning");

        $("#cnStatusDiv").toggleClass("has-success").addClass("has-success");
    }else if($("#companyNameStatus").val() == '0'||$("#companyNameStatus").val() == 0){
        $("#cnStatusDiv").toggleClass("has-error").removeClass("has-error");
        $("#cnStatusDiv").toggleClass("has-warning").addClass("has-warning");
    }else if($("#companyNameStatus").val() == '-1'||$("#companyNameStatus").val() == -1){
        $("#cnStatusDiv").toggleClass("has-error").addClass("has-error");
    }

    if($("#companyAddressStatus").val() == '1'||$("#companyAddressStatus").val() == 1){
        $("#caStatusDiv").toggleClass("has-error").removeClass("has-error");
        $("#caStatusDiv").toggleClass("has-warning").removeClass("has-warning");

        $("#caStatusDiv").toggleClass("has-success").addClass("has-success");
    }else if($("#companyAddressStatus").val() == '0'||$("#companyAddressStatus").val() == 0){
        $("#caStatusDiv").toggleClass("has-error").removeClass("has-error");

        $("#caStatusDiv").toggleClass("has-warning").addClass("has-warning");
    }else if($("#companyAddressStatus").val() == '-1'||$("#companyAddressStatus").val() == -1){
        $("#caStatusDiv").toggleClass("has-error").addClass("has-error");
    }

    if($("#companyPhoneStatus").val() == '1'||$("#companyPhoneStatus").val() == 1){
        $("#cpStatusDiv").toggleClass("has-error").removeClass("has-error");
        $("#cpStatusDiv").toggleClass("has-warning").removeClass("has-warning");

        $("#cpStatusDiv").toggleClass("has-success").addClass("has-success");
    }else if($("#companyPhoneStatus").val() == '0'||$("#companyPhoneStatus").val() == 0){
        $("#cpStatusDiv").toggleClass("has-error").removeClass("has-error");

        $("#cpStatusDiv").toggleClass("has-warning").addClass("has-warning");
    }else if($("#companyPhoneStatus").val() == '-1'||$("#companyPhoneStatus").val() == -1){
        $("#cpStatusDiv").toggleClass("has-error").addClass("has-error");
    }

    if($("#positionStatus").val() == '1'||$("#positionStatus").val() == 1){
        $("#positionDiv").toggleClass("has-error").removeClass("has-error");
        $("#positionDiv").toggleClass("has-warning").removeClass("has-warning");

        $("#positionDiv").toggleClass("has-success").addClass("has-success");
    }else if($("#positionStatus").val() == '0'||$("#positionStatus").val() == 0){
        $("#positionDiv").toggleClass("has-error").removeClass("has-error");

        $("#positionDiv").toggleClass("has-warning").addClass("has-warning");
    }else if($("#positionStatus").val() == '-1'||$("#positionStatus").val() == -1){
        $("#positionDiv").toggleClass("has-error").addClass("has-error");
    }
}


// 改变颜色
function removeColor(){
    if($("#companyNameStatus").val() == '1'||$("#companyNameStatus").val() == 1){
        $("#cnStatusDiv").toggleClass("has-success").removeClass("has-success");
    }else if($("#companyNameStatus").val() == '0'||$("#companyNameStatus").val() == 0){
        $("#cnStatusDiv").toggleClass("has-warning").removeClass("has-warning");
    }else if($("#companyNameStatus").val() == '-1'||$("#companyNameStatus").val() == -1){
        $("#cnStatusDiv").toggleClass("has-error").removeClass("has-error");
    }
    if($("#companyAddressStatus").val() == '1'||$("#companyAddressStatus").val() == 1){
        $("#caStatusDiv").toggleClass("has-success").removeClass("has-success");
    }else if($("#companyAddressStatus").val() == '0'||$("#companyAddressStatus").val() == 0){
        $("#caStatusDiv").toggleClass("has-warning").removeClass("has-warning");
    }else if($("#companyAddressStatus").val() == '-1'||$("#companyAddressStatus").val() == -1){
        $("#caStatusDiv").toggleClass("has-error").removeClass("has-error");
    }
    if($("#companyPhoneStatus").val() == '1'||$("#companyPhoneStatus").val() == 1){
        $("#cpStatusDiv").toggleClass("has-success").removeClass("has-success");
    }else if($("#companyPhoneStatus").val() == '0'||$("#companyPhoneStatus").val() == 0){
        $("#cpStatusDiv").toggleClass("has-warning").removeClass("has-warning");
    }else if($("#companyPhoneStatus").val() == '-1'||$("#companyPhoneStatus").val() == -1){
        $("#cpStatusDiv").toggleClass("has-error").removeClass("has-error");
    }
    if($("#positionStatus").val() == '1'||$("#positionStatus").val() == 1){
        $("#positionDiv").toggleClass("has-success").removeClass("has-success");
    }else if($("#positionStatus").val() == '0'||$("#positionStatus").val() == 0){
        $("#positionDiv").toggleClass("has-warning").removeClass("has-warning");
    }else if($("#positionStatus").val() == '-1'||$("#positionStatus").val() == -1){
        $("#positionDiv").toggleClass("has-error").removeClass("has-error");
    }
}

// 显示客户
function editCustomer(id){
    var senddata={
        'id':id
    }
    $.ajax({
        type:"POST",
        url:basePath+"/basic/getCustomerInfoGE.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                var map = data.content;
                // alert(map);
                // alert(map.enable);
                // if(map.enable == "是"){
                //     $("#isEnable").text("已启用");
                // }else{
                //     $("#isEnable").text("未启用");
                // }
                // if(map.checkStatusOption==null||map.checkStatusOption==""){
                //     $("#companyNameStatus").val(-1);
                //     $("#companyAddressStatus").val(-1);
                //     $("#companyPhoneStatus").val(-1);
                //     $("#positionStatus").val(-1);
                //     changeColor();
                // }else{
                //     var obj = JSON.parse(map.checkStatusOption);
                //     if(obj.data==null||obj.data==""){
                //         $("#companyNameStatus").val(-1);
                //         $("#companyAddressStatus").val(-1);
                //         $("#companyPhoneStatus").val(-1);
                //         $("#positionStatus").val(-1);
                //         changeColor();
                //     }else{
                //         $("#companyNameStatus").val(obj.data.companyNameStatus);
                //         $("#companyAddressStatus").val(obj.data.companyAddressStatus);
                //         $("#companyPhoneStatus").val(obj.data.companyPhoneStatus);
                //         $("#positionStatus").val(obj.data.positionStatus);
                //         changeColor();
                //     }
                // }
//		    	  把字符串转为对象以便于取值
                // alert(cs);
                $("#id").val(map.id);
                // $("#code").val(map.code);
                $("#name").val(map.name);
                // $("#theme").val(map.theme);
                $("#idcard").val(map.idcard);
                $("#phone").val(map.phone);
                $("#addr").val(map.addr);
                $("#email2").val(map.email);
                $("#email").val(map.email);
                $("#createTime").val(map.createTime);
                $("#loginCount").val(map.loginCount);
                $("#lastTime").val(map.lastTime);
                $("#enable").val(map.enable);
                $("#createBy").val(map.createBy);
                $("#sex").val(map.sex);
                $("#birthday").val(map.birthday);
                $("#mobile").val(map.mobile);
                $("#otherContact").val(map.otherContact);
                $("#sosPerson").val(map.sosPerson);
                $("#sosMobile").val(map.sosMobile);
                $("#bornPlace").val(map.bornPlace);
                $("#levelId").val(map.levelId);
                $("#balance").val(map.balance);
                $("#companyName").val(map.companyName);
                $("#companyAddress").val(map.companyAddress);
                $("#companyPhone").val(map.companyPhone);
                $("#position").val(map.position);



                $('#customerModal').modal('show');
            }
//             else{
// //           	添加页面：
// //		    	   alert("add...")
//                 $("#id").val(),
//                     $("#code").val(),
//                     $("#name").val(),
//                     $("#theme").val(),
//                     $("#idcard").val(),
//                     $("#phone").val(),
//
//                     $("#addr").val(),
//                     $("#email").val(),
//                     $("#create_time").val(),
//                     $("#login_count").val(),
//                     $("#last_time").val(),
//                     $("#enable").val(),
//                     $("#create_by").val(),
//                     $("#sex").val(),
//
//                     $("#birthday").val(),
//                     $("#mobile").val(),
//                     $("#other_contact").val(),
//                     $("#sos_person").val(),
//                     $("#sos_mobile").val(),
//                     $("#born_place").val(),
//                     $("#level_id").val(),
//                     $("#balance").val(),
//
//                     $("#company_name").val(),
//                     $("#company_address").val(),
//                     $("#company_phone").val(),
//                     $("#position").val(),
//                     $("#check_status").val(),
//                     $('#customerModal').modal('show');
//             }
        }
    });
}

function customerSave() {
    $.post(basePath + '/basic/customerSave.do',
        {
            email: $("#email").val(),
            createTime: $("#createTime").val(),
            balance: $("#balance").val(),
            id: $("#id").val(),
            code: $("#code").val(),
            name: $("#name").val(),
            theme: $("#theme").val(),
            idcard: $("#idcard").val(),
            phone: $("#phone").val(),
            addr: $("#addr").val(),

            loginCount: $("#loginCount").val(),
            lastTime: $("#lastTime").val(),
            enable: $("#enable").val(),
            createBy: $("#createBy").val(),
            sex: $("#sex").val(),

            birthday: $("#birthday").val(),
            mobile: $("#mobile").val(),
            otherContact: $("#otherContact").val(),
            sosPerson: $("#sosPerson").val(),
            sosMobile: $("#sosMobile").val(),
            bornPlace: $("#bornPlace").val(),
            levelId: $("#levelId").val(),

            companyName: $("#companyName").val(),
            companyAddress: $("#companyAddress").val(),
            companyPhone: $("#companyPhone").val(),
            position: $("#position").val(),
            checkStatus: $("#checkStatus").val(),
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.code){
                BootstrapDialog.alert("保存成功！");
                query();
            }else{
                BootstrapDialog.alert("保存失败！");
            }
        }
    );
    $('#customerModal1').modal('hide');
}

function editCheckStatus_query(){
    var companyNameStatus = $("#companyNameStatus").val();
    var companyAddressStatus = $("#companyAddressStatus").val();
    var companyPhoneStatus = $("#companyPhoneStatus").val();
    var positionStatus = $("#positionStatus").val();
    // if(companyNameStatus == companyAddressStatus == companyPhoneStatus == positionStatus == 1){
    var senddata={
        'id':$("#id").val(),
        "companyNameStatus":companyNameStatus,
        "companyAddressStatus":companyAddressStatus,
        "companyPhoneStatus":companyPhoneStatus,
        "positionStatus":positionStatus,
    }
    $.ajax({
        type:"POST",
        url:basePath+"/basic/editCheckStatus.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.msg);

        }
    });
    // }else{
    //     BootstrapDialog.alert("信息不全，未能通过审核");
    // }
}




