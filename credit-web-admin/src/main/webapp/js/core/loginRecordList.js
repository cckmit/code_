$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        url: basePath+"/core/managerList.do",
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


