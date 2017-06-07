$(function() {

    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        url: basePath+"/core/rechargeList.do",
        formatters: {
            // "operate": function(column, row)
            // {
            //     var but = "<button class=\"btn btn-sm btn-primary btn-block\" onclick=\"ok("+row.id+");\">确认</button>";
            //     but +="<button class=\"btn btn-sm btn-primary btn-block\" onclick=\"cancel("+row.id+");\">取消</button>";
            //     return but;
            // },
            "finishTime": function(column, row)
            {
                var str="";
                if(row.finishTime!=null) {
                    str = moment(row.finishTime).format('YYYY-MM-DD HH:mm:ss');
                }
                return str;
            },
            "payMethod": function(column, row)
            {
                var str;

                if (row.payMethod == 8) {
                    str = "后台充值";
                } else if(row.payMethod == 1){
                    str = "支付宝";
                } else if(row.payMethod == 2){
                    str = "微信";
                }

                return str;
            },
            "appName": function(column, row)
            {
                var str;
                if (row.appName == 1) {
                    str = "全球鹰";
                } else if(row.appName == 2){
                    str = "全搜";
                } else if(row.appName == 3){
                    str = "估估";
                } else if(row.appName == 4){
                    str = "CPM";
                }
                return str;
            }
        }
    });
});
function ok(id){
    var senddata = {
        "id":id
    };
    $.ajax({
        type:"POST",
        url:basePath+"/core/okRecharge.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.msg);
            $("#grid-data").bootgrid("reload");
        }
    });
}

function cancel(id){
    var senddata = {
        "id":id
    };
    $.ajax({
        type:"POST",
        url:basePath+"/core/cancelRecharge.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.msg);
            $("#grid-data").bootgrid("reload");
        }
    });
}
