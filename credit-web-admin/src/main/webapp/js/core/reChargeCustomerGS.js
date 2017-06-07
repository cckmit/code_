// 客户列表
$(function () {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath + "/core/customerListGS.do",
        formatters: {
            "operate": function (column, row) {
                // var but = "<button class=\"btn btn-sm btn-primary\" onclick=\"recharge(" + row.id + ");\">" + "充值" + "</button>";
                var but = "&nbsp;<button class=\"btn btn-sm btn-primary\" onclick=\"editCustomer('" + row.id + "');\">充值</button>";

                return but;
            },
            "formatCreateTime": function (column, row) {
                var str = " ";
                if (row.createTime != null) {
                    str = moment(row.createTime).format('YYYY-MM-DD');
                }
                return str;
            },
            "level": function (column, row) {
                var str = " ";
                if (row.levelId == '1' || row.levelId == 1) {
                    str = "普通用户";
                } else if (row.levelId == '3' || row.levelId == 3) {
                    str = "vip3大客户";
                }
                return str;
            }
        }
    });
    $("#countryForm1").validate();
});


// 显示客户
function editCustomer(id) {
    var senddata = {
        'id': id
    };
    $.ajax({
        type: "POST",
        url: basePath + "/basic/getCustomerInfoGS.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(senddata),
        success: function (data) {
            if (data.code) {
                var map = data.content;
                if (map.enable == "是") {
                    $("#isEnable").text("已启用");
                } else {
                    $("#isEnable").text("未启用");
                }
//		    	  把字符串转为对象以便于取值
                $("#customerId").val(map.id);
                $("#email").val(map.email);
                $("#customerName").val(map.name);
                $("#balance").val(map.balance);

                $('#customerModal').modal('show');
            } else {
//           	添加页面：
                $("#customerId").val();
                $("#email").val();
                $("#customerName").val();
                $("#balance").val();
                $('#customerModal').modal('show');
            }
        }
    });
}


function getParams() {
    return {}
}

function query() {
    $("#grid-data").bootgrid("reload");
}


// 充值
function reChargeCustomer() {
    if(!$("#countryForm1").valid())
        return false;
    var senddata = {
        customerId: $("#customerId").val(),
        amount: $("#amount").val(),
        customerName:$("#customerName").val(),
        balance:$("#balance").val()
    };
    $.ajax({
        type: "POST",
        url: basePath + "/core/addRechargeGS.do",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(senddata),
        success: function (data) {
            if (data.code) {
                var object = data.content;
                BootstrapDialog.alert(data.msg);
                query();
            }
            else {
                BootstrapDialog.alert(data.msg);
            }
        }
    });
    $('#customerModal').modal('hide');
}




