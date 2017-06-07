$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        post: getParams,
        url: basePath + "/core/quickOrderList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"showDetail("+row.id+");\">详情</button>";
                but += " <button class=\"btn btn-sm btn-primary\" onclick=\"del("+row.id+");\">删除</button>";
                return but;
            },
            "createTime": function(column, row)
            {
                var str="";
                if(row.createTime!=null) {
                    str = moment(row.createTime).format('YYYY-MM-DD hh:mm:ss');
                }
                return str;
            },
            // "status": function(column, row)
            // {
            //     var str;
            //     if (row.status == 0) {
            //         str = "取消";
            //     } else if(row.status == 1){
            //         str = "新订单";
            //     } else if(row.status == 2){
            //         str = "确认中";
            //     } else if(row.status == 3){
            //         str = "制作中";
            //     }else if(row.status == 4){
            //         str = "完成";
            //     }
            //     return str;
            // },
            "source": function(column, row)
            {
                var str;
                if (row.source == 1) {
                    str = "全球鹰";
                } else if(row.source == 2){
                    str = "全搜";
                } else if(row.source == 3){
                    str = "估估";
                } else if(row.source == 4){
                    str = "CPM";
                }
                return str;
            },
            "hasPay": function(column, row)
            {
                var str;
                if (row.hasPay == false) {
                    str = "未支付";
                } else if(row.hasPay ==true) {
                    str = "已支付";
                }
                return str;
            },
        }
    });
});

function showDetail(id){
    var senddata={
        'id':id
    }
    $.ajax({
        type:"POST",
        url:basePath+"/core/getQuickOrder.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                var map = data.content;
                $("#id").val(map.id);
                 $("#no").val(map.no);
                $("#createUserId").val(map.createUserId);
                 $("#createUserName").val(map.createUserName);
                $("#productId").val(map.productId);
                $("#createTime").val(map.createTime);
                $("#finishTime").val(map.finishTime);
                $("#source").val(map.source);
                $("#expectTime").val(map.expectTime);
                $("#updateTime").val(map.updateTime);
                $("#customerName").val(map.customerName);
                $("#customerNo").val(map.customerNo);
                $("#customerEmail").val(map.customerEmail);
                $("#amount").val(map.amount);
                $("#amountActual").val(map.amountActual);
                $("#currency").val(map.currency);
                $("#hasPay").val(map.hasPay);
                $("#payMethod").val(map.payMethod);
                $("#companyArea").val(map.companyArea);
                $("#companyCountry").val(map.companyCountry);
                $("#companyName").val(map.companyName);
                $("#companyPhone").val(map.companyPhone);
                $("#companyAddress").val(map.companyAddress);
                $("#companyWebsite").val(map.companyWebsite);
                $("#imgUrl").val(map.imgUrl);
                $("#otherInfo").val(map.otherInfo);
                $("#remark").val(map.remark);
                $("#customerId").val(map.customerId);
                $('#quickOrderModal').modal('show');
            }
            else{
//           	添加页面：
//		    	   alert("add...")
                $("#id").val();
                $("#no").val();
                $("#createUserId").val();
                $("#createUserName").val();
                $("#productId").val();
                $("#createTime").val();
                $("#source").val();
                $("#expectTime").val();
                $("#updateTime").val();
                $("#customerName").val();
                $("#customerNo").val();
                $("#customerEmail").val();
                $("#amount").val();
                $("#amountActual").val();
                $("#currency").val();
                $("#hasPay").val();
                $("#payMethod").val();
                $("#companyArea").val();
                $("#companyCountry").val();
                $("#companyName").val();
                $("#companyPhone").val();
                $("#companyAddress").val();
                $("#companyWebsite").val();
                $("#imgUrl").val();
                $("#otherInfo").val();
                $("#remark").val();
                $("#customerId").val();
                $("#finishTime").val();
                $('#quickOrderModal').modal('show');
            }
        }
    });
}

function upQuickOrder() {
    var senddata = {
        id: $("#id").val(),
        no:$("#no").val(),
        createUserId:$("#createUserId").val(),
        createUserName:$("#createUserName").val(),
        productId:$("#productId").val(),
        createTime:$("#createTime").val(),
        finishTime:$("#finishTime").val(),
        source:$("#source").val(),
        expectTime:$("#expectTime").val(),
        updateTime:$("#updateTime").val(),
        customerName:$("#customerName").val(),
        customerNo:$("#customerNo").val(),
        customerEmail:$("#customerEmail").val(),
        amount:$("#amount").val(),
        amountActual:$("#amountActual").val(),
        currency:$("#currency").val(),
        hasPay:$("#hasPay").val(),
        payMethod:$("#payMethod").val(),
        companyArea:$("#companyArea").val(),
        companyCountry:$("#companyCountry").val(),
        companyName:$("#companyName").val(),
        companyPhone:$("#companyPhone").val(),
        companyAddress:$("#companyAddress").val(),
        companyWebsite:$("#companyWebsite").val(),
        imgUrl:$("#imgUrl").val(),
        otherInfo:$("#otherInfo").val(),
        remark:$("#remark").val(),
        customerId:$("#customerId").val()
    }
    $.ajax({
        type:"POST",
        url:basePath+"/core/upQuickOrder.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                BootstrapDialog.alert(data.msg);
                $('#quickOrderModal').modal('hide');
                query();
            }
            else{
                BootstrapDialog.alert(data.msg);
            }
        }
    });
}

function saveOrder() {
    var senddata = {
        id: $("#id").val(),
        no:$("#no").val(),
        createUserId:$("#createUserId").val(),
        createUserName:$("#createUserName").val(),
        productId:$("#productId").val(),
        createTime:$("#createTime").val(),
        finishTime:$("#finishTime").val(),
        source:$("#source").val(),
        expectTime:$("#expectTime").val(),
        updateTime:$("#updateTime").val(),
        customerName:$("#customerName").val(),
        customerNo:$("#customerNo").val(),
        customerEmail:$("#customerEmail").val(),
        amount:$("#amount").val(),
        amountActual:$("#amountActual").val(),
        currency:$("#currency").val(),
        hasPay:$("#hasPay").val(),
        payMethod:$("#payMethod").val(),
        companyArea:$("#companyArea").val(),
        companyCountry:$("#companyCountry").val(),
        companyName:$("#companyName").val(),
        companyPhone:$("#companyPhone").val(),
        companyAddress:$("#companyAddress").val(),
        companyWebsite:$("#companyWebsite").val(),
        imgUrl:$("#imgUrl").val(),
        otherInfo:$("#otherInfo").val(),
        remark:$("#remark").val(),
        customerId:$("#customerId").val()
    }
    $.ajax({
        type:"POST",
        url:basePath+"/core/addOrder.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                BootstrapDialog.alert(data.msg);
            }
            else{
                BootstrapDialog.alert(data.msg);
            }
        }
    });
}

function del(id){
    BootstrapDialog.show({
        title:'删除框',
        message:'是否确认删除',
        buttons: [{
            label: '确定',
            action: function(dialog) {
                dialog.close();
                $.ajax({
                    method: "POST",
                    url:basePath+"/core/delQucikOrder.do",
                    cache:false,
                    dataType : 'json',
                    data:{
                        'id':id
                    },
                    success : function(data) {
                        BootstrapDialog.alert(data.msg);
                        $('#grid-data').bootgrid("reload");
                    }
                });
            }
        }, {
            label: '取消',
            action: function(dialog) {
                dialog.close();
            }
        }]
    })
};

function getParams(){
    return {
        no: $("#no1").val(),
        status:$("#status1").val(),
        source:$("#source1").val()
    }
}


function query(){
    $("#grid-data").bootgrid("reload");
}

function jump(){
    var senddata = {
        imgUrl:$("#imgUrl").val()
    };
    $.ajax({
        type:"POST",
        url:basePath+"/core/imgUrl.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                $("#companyImg").attr("src", basePath + data.content);
                $("#imgModal").modal("show");
            }else{
                BootstrapDialog.alert(data.msg);
            }
        }
    });

    // if(imgUrl!=null || imgUrl != undefined){
   //  else{
   //  alert(imgUrl);
   //  alert("公司信息图片地址为null！");
   // }
}
