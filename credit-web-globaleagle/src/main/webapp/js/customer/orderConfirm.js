function changePrice(type){
    if(type==1){
        $("#orderLevel").val("1");
        $("#price").text(dbprice);
    }
    else{
        $("#orderLevel").val("2");
        $("#price").text(newprice);
    }
}

function addOrder(){
    var senddata = {
        "companyNo":companyNo,
        "companyName":companyName,
        "countryId":countryId,
        "price":$("#price").text(),
        "orderLevel":$("#orderLevel").val()
    };
    $.ajax({
        type:"POST",
        url:basePath+"customer/addOrder.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.show({
                title: '确定',
                message: data.resultDes+",确定返回我的订单",
                buttons: [{
                    label: '确定',
                    action: function() {
                        window.location.href=basePath+"customer/orderList.jsp";
                    }
                }, {
                    label: '取消',
                    action: function(dialog) {
                        dialog.close();
                    }
                }]
            });
        }
    });
}
//function addCart(){
//    var senddata = {
//        "companyNo":companyNo,
//        "companyName":companyName,
//        "countryId":countryId,
//        "price":$("#price").text(),
//        "orderLevel":$("#orderLevel").val()
//    };
//    $.ajax({
//        type:"POST",
//        url:basePath+"customer/addCart.do",
//        dataType:"json",
//        contentType:"application/json",
//        data:JSON.stringify(senddata),
//        success:function(data){
//            BootstrapDialog.show({
//                title: '确定',
//                message: data.resultDes+",确定返回我的购物车",
//                buttons: [{
//                    label: '确定',
//                    action: function() {
//                        window.location.href=basePath+"customer/cartList.jsp";
//                    }
//                }, {
//                    label: '取消',
//                    action: function(dialog) {
//                        dialog.close();
//                    }
//                }]
//            });
//        }
//    });
//}