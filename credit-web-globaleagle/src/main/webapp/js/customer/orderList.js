var s = 20, t;
var progressArr = new Array();
var gIsPay = "否";
var url = "";
$(function () {
    url = basePath + "customer/orderDetailList.do?id=1";
    $("#orderNo").val(orderNo);
    $("#orderGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        css: {
            selected: ""
        },
        ajax: true,
        post: getParams,
        url: basePath + "customer/orderList.do",
        formatters: {
            "operate": function (column, row) {
            },
            "createTime": function (column, row) {
                var str = moment(row.createTime).format('YYYY-MM-DD hh:mm:ss');
                return str;
            },

            "detailCount": function (column, row) {
                var str;
                if (row.hasPay) {
                    str = " <button class=\"btn btn-xs btn-primary \" onclick=\"showDetail(" + row.id + ",'" + row.hasPay + "');\">报告列表&nbsp;<span class='badge'>  " + row.detailCount + "</span></button>";
                } else {
                    str = " <button class=\"btn btn-xs \" disabled>报告列表&nbsp;<span class='badge'>  " + row.detailCount + "</span></button>";
                }
                return str;
            },
            "amount": function (column, row) {
                var str = "";
                if (row.amount != null && row.amount != undefined) {
                    str = "CNY " + formatCurrency(row.amount);
                }
                return str;
            },
            "amountActual": function (column, row) {
                var str = "";
                if (row.amountActual != null && row.amountActual != undefined) {
                    str = "CNY " + formatCurrency(row.amountActual);
                }
                return str;
            },
            "hasPay": function (column, row) {
                var str;
                if (row.hasPay) {
                    str = "<button class=\"btn btn-sm btn-success\">已支付</button>";
                } else {
                    str = "<button class=\"btn btn-xs btn-warning\">未支付</button> <button class=\"btn btn-xs btn-primary \" onclick=\"orderPay(" + row.id + ");\">立即支付</button>";
                }
                return str;
            },
        }
    });
    $("#detailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getDetailParams,
        url: getURL,
        formatters: {
            "operate": function (column, row) {
                var def = new Date() - row.createTime;
                var second = def / 1000;//秒
                var id = row.id;
                if (gIsPay == "否")
                    return "支付后才能下载";
                if (row.orderStatus == 0)
                    return "";
                var but;
                but = "<table class='operateTable'><tr>";


                if (row.countryName != "中国") {
                    if (row.productType != 3) {
                        but += "<td>";
                        if (second > 30) {
                            // 打开报告按钮比的显示
                            but += "<td><button class=\"btn btn-xs btn-primary\" onclick=\"download(" + row.id + ",'" + row.companyNo + "','" + row.orderId + "');\">数据库报告</button></td>";
                        }
                        else {
                            progressArr.push({
                                id: id,
                                second: second,
                                companyNo: row.companyNo,
                                orderId: row.orderId,
                                isChinaOrder: row.isChinaOrder,
                                crefoNo: row.crefoNo
                            });
                            //滚动条显示
                            but += "<div class='progress progress-striped active' style='width: 170px;'>";
                            but += "<div class='progress-bar progress-bar-primary' id='progressBar" + id + "' data-transitiongoal='" + (second / 30 * 100) + "' role='progressbar' aria-valuemin='0' aria-valuemax='100'></div>";
                            but += "</div>";
                        }

                        but += "</td>";
                    }
                } else {
                    but += "<td>";
                    if (second > 30) {
                        // 打开报告按钮比的显示
                        but += "<td><button class=\"btn btn-xs btn-primary btn-block\" onclick=\"downloadChina(" + row.id + ",'" + row.crefoNo + "','" + row.orderId + "');\">数据库报告</button></td>";
                    }
                    else {
                        progressArr.push({
                            id: id,
                            second: second,
                            companyNo: row.companyNo,
                            orderId: row.orderId,
                            isChinaOrder: row.isChinaOrder,
                            crefoNo: row.crefoNo
                        });
                        //滚动条显示
                        but += "<div class='progress progress-striped active' style='width: 170px;'>";
                        but += "<div class='progress-bar progress-bar-primary' id='progressBar" + id + "' data-transitiongoal='" + (second / 30 * 100) + "' role='progressbar' aria-valuemin='0' aria-valuemax='100'></div>";
                        but += "</div>";
                    }
                    but += "</td>";
                }
                if (row.uploadFilePath != "" && row.uploadFilePath != undefined) {
                    but += "<td><button class=\"btn btn-xs btn-success\" onclick=\"downloadFull(" + row.id + ",'" + row.uploadFilePath + "');\">完整报告</button></td>";
                }
                but += "</tr></table>";
                return but;
            },
            "createTime": function (column, row) {
                var str = moment(row.createTime).format('YYYY-MM-DD HH:mm:ss');
                return str;
            },
            "productType": function (column, row) {
                var str;
                if (row.productType == 1) {
                    str = "中国报告";
                } else if (row.productType == 2) {
                    str = "外国报告";
                } else if (row.productType == 3) {
                    str = "自定义报告";
                }
                return str;
            }
        }
    });
    $("#orderGrid").bootgrid().on("loaded.rs.jquery.bootgrid", function (e) {
        var data = $("#orderGrid").bootgrid("getCurrentRows");
        var i = 1;
        var countries = Array();
        countries[0] = "<option></option>";
        $.each(data, function () {
            var country = "";
            var flag = 0;
            for (var j = 0; j < countries.length; j++) {
                if ($("#countryId").val() == this.countryId) {
                    country = "<option value='" + this.countryId + "' selected='true'>" + this.countryName + "</option>";
                }
                else {
                    country = "<option value='" + this.countryId + "'>" + this.countryName + "</option>";
                }
                if (countries[j] == country) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                countries[i] = country;
                i++;
            }
        });
        $("#countryId").empty();
        $.each(countries, function () {
            $("#countryId").append(this);
        });
    });
    $("#detailGrid").bootgrid().on("loaded.rs.jquery.bootgrid", function (e) {
        initProgress();
    });
    $("#createDateFrom").datepicker({
        autoSize: true,
        changeYear: true,
        changeMonth: true,
        dateFormat: "yy-mm-dd"
    });
    $("#createDateTo").datepicker({
        autoSize: true,
        changeYear: true,
        changeMonth: true,
        dateFormat: "yy-mm-dd"
    });

});

//订单读秒
function initProgress() {
    if (progressArr.length < 1) {
        return;
    }
    $.each(progressArr, function (i, v) {
        var second = new Number(v.second);
        var obj = ($('#progressBar' + v.id));
        obj.progressbar({"value": second / 30 * 100});
    });
    changeProgressBar();
}
//订单读秒
var ss = 1;
function changeProgressBar() {
    if (ss < 30) {
        $.each(progressArr, function (i, v) {
            if (v.isFinished) {
                return true;
            }
            var obj = $('#progressBar' + v.id);
            var xx = new Number(obj.attr('data-transitiongoal')) + 100 / 30;
            if (xx < 0) {
                return true;
            }
            if (xx > 100) {
                //去后台检查是否下载成功，如果成功，则显示报告按钮
                if (v.isChinaOrder == "是") {
                    obj.parent().after("<button class=\"btn btn-xs btn-primary btn-block\" onclick=\"downloadChina(" + v.id + ",'" + v.crefoNo + "','" + v.orderId + "');\">数据库报告</button>");
                } else {
                    obj.parent().after("<button class=\"btn btn-xs btn-primary\" onclick=\"download(" + v.id + ",'" + v.companyNo + "','" + v.orderId + "');\">数据库报告</button>");
                }
                obj.parent().hide();
                v.isFinished = true;
            }
            obj.progressbar({"value": xx});
            obj.attr("data-transitiongoal", xx);
        });
        ss++;
        var t = setTimeout(changeProgressBar, 1000);
    }
}

function orderPay(id) {
    window.location.href = basePath + "customer/toCustomerPay.do?orderId=" + id;
}

function getParams() {
    return {
        no: $("#orderNo").val(),
        createDateFrom: $("#createDateFrom").val(),
        createDateTo: $("#createDateTo").val(),
        status: $("#orderStatus").val()
    }
}

function getURL() {
    return url;
}

function getDetailParams() {
    return {
        orderId: $("#orderId").val()
    }
}
function showDetail(id, isPay) {
    gIsPay = isPay;
    url = basePath + "customer/orderDetailList.do";
    $("#orderId").val(id);
    progressArr = new Array();
    $("#detailGrid").bootgrid("reload");
    $('#detailModal').modal('show');
}
function query() {
    $("#orderGrid").bootgrid("reload");
}
function download(id, companyNo, orderId) {
    window.open(basePath + '/customer/openReport.do?&orderDetailId='+id);

}
function downloadChina(id, crefoNo, orderId) {
    window.open(basePath + '/customer/openReport.do?&orderDetailId='+id);

}


function downloadFull(id, url) {
    window.open(basePath + url);
    modifyIsRead(id);

}

function modifyIsRead(id) {
    var senddata = {
        id: id
    };
    $.ajax({
        type: "POST",
        url: basePath + "customer/modifyOrderDetailIsRead.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(senddata),
        success: function (data) {
            if (!data.result) {
                BootstrapDialog.alert(data.msg);
            }
        }
    });
    location.reload();
}


//取消订单
function deleteOrder(id) {
    var senddata = {
        "id": id
    };

    BootstrapDialog.show({
        title: '订单取消确认',
        message: "请确认是否取消订单",
        buttons: [{
            label: '提交',
            action: function (dialog) {
                $.ajax({
                    type: "POST",
                    url: basePath + "customer/deleteOrder.do",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(senddata),
                    success: function (data) {
                        BootstrapDialog.alert(data.msg);
                        $("#orderGrid").bootgrid("reload");
                        dialog.close();
                    }
                });
            }
        }, {
            label: '退出',
            action: function (dialog) {
                dialog.close();
            }
        }]
    });
}

function formatCurrency(num) {
    if (num == null || num == "" || num == "undefined") {
        return "";
    }
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



