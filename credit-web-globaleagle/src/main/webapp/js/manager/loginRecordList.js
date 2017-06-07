$(function() {
    $("#rechargeGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        url: basePath+"manager/managerList.do",
        formatters: {
            "lastTime": function(column, row)
            {
                var str=" ";
                if(row.lastTime!=null){
                    str=moment(row.lastTime).format('YYYY-MM-DD HH:mm:ss');
                }
                return str;
            }
        }
    });
});


