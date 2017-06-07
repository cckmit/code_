$(function() {
    $("#cartListGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        selection: true,
        multiSelect: true,
        ajax: true,
        post: getParams,
        url: basePath+"user/cartList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but = "";
                but += "   <table class='operateTable'><tr><td><button class='btn btn-sm btn-primary btn-block' onclick='deleteCart("+row.id+");'>删除</button></td></tr></table>";
                //alert();
                return but;
            },
            "createDate": function(column, row)
            {
                var str=moment(row.createDate).format('YYYY-MM-DD');
                return str;
            },
            "orderLevel": function(column, row)
            {
           	 var str;
         	if (row.orderLevel == 1) {
         		str = "数据库报告";
				} else if(row.orderLevel == 2){
					str = "完整性报告";
				} else if(row.orderLevel == 3){
                str = "数据库完整报告";
            }
             return str;
            },
            "totalPrice": function (column, row) {
                var str="";
                if(row.totalPrice!=null && row.totalPrice!=undefined){
                    str="CNY "+row.totalPrice.toFixed(2);
                }
                return str;
            }
        }
    });
    $("#cartListGrid").bootgrid()
        .on("loaded.rs.jquery.bootgrid", function (e)
        {
            var data = $("#cartListGrid").bootgrid("getCurrentRows");
            var i = 1;
            var countries = Array();
            countries[0] = "<option></option>";
            $.each(data,function(){
                var country = "";
                var flag = 0;
                for(var j=0;j<countries.length;j++){
                    if($("#countryId").val()==this.countryId){
                        country = "<option value='"+this.countryId+"' selected='true'>"+this.countryName+"</option>";
                    }
                    else{
                        country = "<option value='"+this.countryId+"'>"+this.countryName+"</option>";
                    }
                    if(countries[j]==country){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    countries[i] = country;
                    i++;
                }
            });
            $("#countryId").empty();
            $.each(countries,function(){
                $("#countryId").append(this);
            });
            
            
        })
    .on("selected.rs.jquery.bootgrid", function(e, rows)
    {
    	
    	$("#totalPrice").html(calTotalPrice().amount.toFixed(2));
    	$("#totalCount").html(calTotalPrice().count);

    }).on("deselected.rs.jquery.bootgrid", function(e, rows)
    {
    	
    	$("#totalPrice").html(calTotalPrice().amount.toFixed(2));
    	$("#totalCount").html(calTotalPrice().count);
    });
});

function calTotalPrice(){
	var allRows = $("#cartListGrid").bootgrid('getCurrentRows');
    var selected = $("#cartListGrid").bootgrid('getSelectedRows');   
    var amount = 0;
	var count = 0;
    $.each(selected,function(){
        for(var i=0;i<allRows.length;i++){
            if(allRows[i].id == this){
            	amount += allRows[i].totalPrice;
            	count++;                
            }

        }
    });	
	var result = new Object();
	result.amount = amount;
	result.count = count;
	return result;
}

function getParams(){
    return {
        companyName: $("#companyName").val(),
        countryId:$("#countryId").val()
    }
}
function query(){
    $("#cartListGrid").bootgrid('reload');
    //location.reload();
}

function addOrder(){
    var allRows = $("#cartListGrid").bootgrid('getCurrentRows');
    var selected = $("#cartListGrid").bootgrid('getSelectedRows');    
    if(selected==""){
        BootstrapDialog.alert("请先选择报告!");
        return;
    }
    var total = 0;
    $.each(selected,function(){
        for(var i=0;i<allRows.length;i++){
            if(allRows[i].id == this){
                total += allRows[i].totalPrice;
                break;
            }

        }
    });
    var ids = $("#cartListGrid").bootgrid('getSelectedRows');
//    var ids = "["+ids+"]";

//    alert(ids);    
//    email = $("#email").val()
    var price = calTotalPrice().amount;
    var count = calTotalPrice().count;

    window.location.href=basePath+"/user/addOrderFromCart.do?ids="+ids+"&price="+price+"&count="+count;
//    $('#rechargeModal').modal('show');
//    BootstrapDialog.show({
//        title: '提示',
//        message: '订单价格:'+total+"元,是否要下该订单?",
//        buttons: [{
//            label: '下单',
//            action: function(dialog) {
//                confirmEmail(dialog,total);
//            }
//        }, {
//            label: '返回',
//            action: function(dialog) {
//                dialog.close();
//            }
//        }]
//    });
}

function confirmEmail(orderdialog,total){
    BootstrapDialog.show({
        title: 'Email地址确认',
        message: "请确认Email地址:<input type='text' id='email' name='email' value='"+ email +"'/>",
        buttons: [{
            label: '提交',
            action: function(dialog) {
                checkBalance(total,ok,cancel,orderdialog);
                dialog.close();
                ajaxAddOrder();
            }
        }, {
            label: '退出',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });
}

function ok(dialog){
    ids = $("#cartListGrid").bootgrid('getSelectedRows'),
    email = $("#email").val()
    dialog.close();
//    ajaxAddOrder();
    $("#cartListGrid").bootgrid('reload');
//    window.location.href="";
//    window.open(basePath+'customer/addOrderFromCart.do?ids='+ids+'&&email='+email);
}

function cancel(dialog){
    BootstrapDialog.show({
        title: '错误',
        message: '账户余额不足! 是否立即充值!',
        buttons: [{
            label: '充值',
            action: function(dialog) {
                dialog.close();
                $('#rechargeModal').modal('show');
            }
        }, {
            label: '返回',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });
}

function ajaxAddOrder(){
    var data = {
        ids:$("#cartListGrid").bootgrid('getSelectedRows'),
        email:$("#email").val()
    };
    //alert(JSON.stringify(senddata));
    $.ajax({
        type:"POST",
        url:basePath+"customer/addOrderFromCart.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(data){
            $("#cartListGrid").bootgrid('reload');
        }
    });
}

function deleteCart(id){
    BootstrapDialog.show({
        message: "是否删除该购物车",
        buttons: [{
            label: '提交',
            action: function(dialog) {
                var senddata = {
                        "id":id
                    };
                    $.ajax({
                        type:"POST",
                        url:basePath+"user/deleteCart.do",
                        dataType:"json",
                        contentType:"application/json",
                        data:JSON.stringify(senddata),
                        success:function(data){
                            BootstrapDialog.alert(data.msg);
                            $("#cartListGrid").bootgrid('reload');
                        }
                    });
                dialog.close();
            }
        }, {
            label: '退出',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });

    
}
function deleteSelectedCart(){
    BootstrapDialog.show({
        message: "是否删除该购物车",
        buttons: [{
            label: '提交',
            action: function(dialog) {
            	
            	
         var data = $("#cartListGrid").bootgrid('getSelectedRows');
       	    $.ajax({
       	        type:"POST",
       	        url:basePath+"user/deleteCarts.do",
       	        dataType:"json",
       	        contentType:"application/json",
       	        data:JSON.stringify(data),
       	        success:function(data){
       	            BootstrapDialog.alert(data.msg);
       	        	$("#totalPrice").html(0.00);
       	        	$("#totalCount").html(0);
       	            $("#cartListGrid").bootgrid('reload');
       	        }
       	    });
                dialog.close();
                
            }
        }, {
            label: '退出',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });
}


