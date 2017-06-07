$(function() {
    $("#rechargeGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        url: basePath+"customer/rechargeList.do",
        formatters: {
            "createDate": function(column, row)
            {
                var str=moment(row.createDate).format('YYYY-MM-DD HH:mm:ss');
                return str;
            }
        }
    });
});

