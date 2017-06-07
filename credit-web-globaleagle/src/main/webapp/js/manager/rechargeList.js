$(function() {

    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        url: basePath+"manager/rechargeList.do",
        formatters: {
            // "operate": function(column, row)
            // {
            //     var but = "<button class=\"btn btn-sm btn-primary btn-block\" onclick=\"ok("+row.id+");\">确认</button>";
            //     but +="<button class=\"btn btn-sm btn-primary btn-block\" onclick=\"cancel("+row.id+");\">取消</button>";
            //     return but;
            // },
            "createDate": function(column, row)
            {
                var str=moment(row.createDate).format('YYYY-MM-DD HH:mm:ss');
                return str;
            },
            "method": function(column, row)
            {
                var str
                if (row.methodId==1||row.methodId=="1"){
                    str="后台充值";
                }
                return str;
            }
        }
    });
});
function ok(id){
    var senddata = {
        "id":id
    }
    $.ajax({
        type:"POST",
        url:basePath+"manager/okRecharge.do",
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
    }
    $.ajax({
        type:"POST",
        url:basePath+"manager/cancelRecharge.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.msg);
            $("#grid-data").bootgrid("reload");
        }
    });
}
