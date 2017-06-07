$(function () {
    $("#orderDetailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath + "customer/orderDetailList.do",
        formatters: {
            "createTime": function (column, row) {
                var str = moment(row.createTime).format('YYYY-MM-DD');
                return str;
            },
            "status": function (column, row) {
                var str;
                if (row.status == 1) {
                    str = "<span class=\"btn btn-xs btn-info\">制作中</span>";
                } else if (row.status == 2) {
                    str = "<span class=\"btn btn-xs btn-success\">已完成</span>";
                } else if (row.status == 3) {
                    str = "<span class=\"btn btn-xs btn-success\">已送达</span>";
                } else if (row.status == 0) {
                    str = "<span class=\"btn btn-xs btn-warning\">已取消</span>";
                }
                return str;
            }
            ,
            "productId": function (column, row) {
                var str;
                if (row.productId == 1) {
                    str = "数据库报告";
                } else if (row.productId == 2) {
                    str = "数据库完整报告";
                } else if (row.productId == 3) {
                    str = "完整版报告";
                } else if (row.productId == 4) {
                    str = "完整版报告-加急";
                }
                return str;
            }
            ,
            "orderNo": function (column, row) {
                var str = "<a href='" + basePath + "customer/toOrderList.do?orderNo=" + row.orderNo + "'>" + row.orderNo + "</a>";
                return str;
            },
            "priceActual": function (column, row) {
                var str;
                str = formatCurrency(row.priceActual);
                return str;
            }
        }
    });
    $("#orderDetailGrid").bootgrid().on("loaded.rs.jquery.bootgrid", function (e) {
        var data = $("#orderDetailGrid").bootgrid("getCurrentRows");
        var count = 0;
        var amount = 0;
        $.each(data, function () {
            amount += this.priceActual;
            count++;
        });
        $("#strongTotalPrice").html("CNY&nbsp;"+amount);
        $("#strongTotalCount").html(count);
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
function getParams() {
    return {
        companyName: $("#companyNameQuery").val(),
        createDateFrom: $("#createDateFrom").val(),
        createDateTo: $("#createDateTo").val(),
        productId: $("#productId").val()
    }
}

function query() {
    $("#orderDetailGrid").bootgrid("reload");
}

function excelDown() {
    window.open(basePath + 'customer/orderDetailListExcelDown.do');
    $.ajax({
        type: "POST",
        url: basePath + "customer/orderDetailListExcelDown.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(getParams()),
        success: function (data) {

        }
    });
}


function formatCurrency(num) {
    if (num == null || num == "") {
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