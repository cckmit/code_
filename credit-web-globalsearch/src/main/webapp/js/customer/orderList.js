$(function () {
    $("#orderGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath + "customer/orderList.do",
        formatters: {
            "createTime": function (column, row) {
                var str = moment(row.createTime).format('YYYY-MM-DD');
                return str;
            },
            "amount": function (column, row) {
                var str;
                if (row.hasPay) {
                    str = row.amount + ".00";
                    // str = "<button class=\"btn btn-sm btn-success fxq-btn-success\">yes</button>";
                } else {
                    str = row.amount + ".00";
                    str += " &nbsp;<button class=\"btn btn-xs btn-primary fxq-btn-no \" onclick=\"orderPay(" + row.id + ");\">Pay Now</button>";
                }
                return str;
            },
            // "detailCount": function (column, row) {
            //     var str;
            //     if (row.hasPay) {
            //         str = " <button class=\"btn btn-sm btn-success fxq-btn-success \" onclick=\"showDetail(" + row.id + ",'" + row.hasPay + "');\">报告列表&nbsp;<span class='badge'>  " + row.detailCount + "</span></button>";
            //     } else {
            //         str = " <button class=\"btn btn-xs \" disabled>报告列表&nbsp;<span class='badge'>  " + row.detailCount + "</span></button>";
            //     }
            //     return str;
            // },
            // "hasPay": function (column, row) {
            //     var str;
            //     if (row.hasPay) {
            //         str = "<button class=\"btn btn-sm btn-success fxq-btn-success\">yes</button>";
            //     } else {
            //         str = "<button class=\"btn btn-xs btn-warning fxq-btn-no\">no</button><button class=\"btn btn-xs btn-primary fxq-btn-no \" onclick=\"orderPay(" + row.id + ");\">payment</button>";
            //     }
            //     return str;
            // },
            "status": function(column, row) {
                var str;
                str = "<p class='fxq-status'>";
                if (row.status == 0) {
                    str += "Cancel";
                } else if(row.status == 1){
                    str += "Unpaid";
                }else if(row.status == 2){
                    str += "Under Investigation";
                }else if(row.status == 3){
                    str += "To Be Assigned";
                }else if(row.status == 4){
                    str += "<span style='color:#af0a18'>Order in Process</span>";
                }else if(row.status == 5){
                    str += "Check Pending";
                }else if(row.status == 6){
                    str += "In Review";
                }else if(row.status == 7){
                    str += "To Be Released";
                }else if(row.status == 8){
                    str += "<span style='color:#1abc9c'>Order Finished</span>";
                }
                str += "</p>";
                return str;
            },
            "operate": function(column, row)
            {
                var but='';
                //but += "<button class=\"btn btn-success fxq-btn-cancel\" onclick=\"deleteOrder("+row.id+");\">cancel</button>";
                 but += "&nbsp;&nbsp;<button class=\"btn btn-success fxq-btn-detailed\" onclick=\"showDetail("+row.id+");\">details</button>";
                return but;
            }
        }
    });
});

function orderPay(id) {
    window.location.href = basePath + "customer/toCustomerPay.do?orderId=" + id;
}

function getParams() {
    return {
        no: $("#no").val(),
        status: $("#status").val()
    }
}

function getOrderDetailParams(id) {
    return {
        orderId: id
    }
}
function showDetail(id) {
    //清除数据
    $("#detailGrid").bootgrid("destroy");
        $("#detailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getOrderDetailParams(id),
        url: basePath + "customer/orderDetailList.do",
        formatters: {
            "operate": function (column, row) {
                // if (gIsPay == "否")
                //     return "After payment to download";
                if (row.status == 0)
                    return "";
                var but;
                but = "<table class='operateTable'><tr>";
                but += "<td><button class=\"btn btn-success\" onclick=\"downloadChina(" + row.id + ",'" + row.crefoNo + "','" + row.orderId + "');\">View Report</button></td>";
                if (row.pathFile != "" && row.pathFile != undefined) {
                    but += "<td><button class=\"btn btn-success\" onclick=\"downloadFull(" + row.id + ",'" + row.pathFile + "');\">full report</button></td>";
                }
                but += "</tr></table>";
                return but;
            },
            "createTime": function (column, row) {
                var str = moment(row.createTime).format('YYYY-MM-DD');
                return str;
            },
            "status": function(column, row) {
                var str;
                if (row.status == 0) {
                    str = "Cancel";
                } else if(row.status == 1){
                    str = "Unpaid";
                }else if(row.status == 2){
                    str = "Under Investigation";
                }else if(row.status == 3){
                    str = "To Be Assigned";
                }else if(row.status == 4){
                    str = "Order in Process";
                }else if(row.status == 5){
                    str = "Check Pending";
                }else if(row.status == 6){
                    str = "In Review";
                }else if(row.status == 7){
                    str = "To Be Released";
                }else if(row.status == 8){
                    str = "Order Finished";
                }
                return str;
            },
            "productType": function (column, row) {

                var str;
                if (row.productType == 1) {
                    str = "e-Check Report";
                } else if (row.productType == 2) {
                    str = "e-Compat Report";
                } else if (row.productType == 3) {
                    str = "e-Report";
                }

                return str;
            },
            "price": function (column, row) {

                var str;
                str = "USD " + formatCurrency(row.price);
                return str;
            }
        }
    });

    // $("#createTime").datepicker({
    //     autoSize: true,
    //     changeYear: true,
    //     changeMonth: true,
    //     dateFormat: "yy-mm-dd"
    // });
    // $("#finishTime").datepicker({
    //     autoSize: true,
    //     changeYear: true,
    //     changeMonth: true,
    //     dateFormat: "yy-mm-dd"
    // });
    $('#detailModal').modal('show');
    $("#detailGrid").bootgrid("reload");
}
function query() {
    $("#orderGrid").bootgrid("reload");
}
function download(id, companyNo, orderId) {
    window.open(basePath + 'requestCompanyDetail.do?companyId=' + companyNo + '&orderDetailId=' + id + '&orderId=' + orderId);

}
function downloadChina(id, crefoNo, orderId) {
    window.open(basePath + '/customer/openReport.do?orderDetailId=' + id + '&orderId=' + orderId);
}

function downloadFull(url) {
    window.open(basePath + url);
}


//取消订单
function deleteOrder(id) {
    var senddata = {
        "id": id
    };

    BootstrapDialog.show({
        title: 'Order cancellation confirmation',
        message: "Please confirm whether or not to cancel the order",
        buttons: [{
            label: 'submit',
            action: function (dialog) {
                $.ajax({
                    type: "POST",
                    url: basePath + "customer/deleteOrder.do",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(senddata),
                    success: function (data) {
                        BootstrapDialog.alert("Cancel Successful");
                        $("#orderGrid").bootgrid("reload");
                        dialog.close();
                    }
                });
            }
        }, {
            label: 'cancel',
            action: function (dialog) {
                dialog.close();
            }
        }]
    });
}

function formatCurrency(num) {
    num = num.toString().replace(/\$|\,/g, '');
    if (isNaN(num))
        num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    cents = num % 100;
    num = Math.floor(num / 100).toString();
    if (cents < 10)
        cents = "0" + cents;
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
        num = num.substring(0, num.length - (4 * i + 3)) + ',' +
            num.substring(num.length - (4 * i + 3));
    return (((sign) ? '' : '-') + num + '.' + cents);
}



