var checkin, checkout;
$(document).ready(function() {
    $('#rangeDate').daterangepicker({
        locale : {
            applyLabel : '确定',
            cancelLabel : '取消',
            fromLabel : '起始时间',
            toLabel : '结束时间',
            customRangeLabel : '自定义',
            daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
            monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
                '七月', '八月', '九月', '十月', '十一月', '十二月' ],
            firstDay : 1
        },
        "showDropdowns": true,
        "autoUpdateInput": false,
        "showCustomRangeLabel": false
    }, function(start, end, label) {
        var starts=moment(start).format('YYYY-MM-DD');
        var ends=moment(end).format('YYYY-MM-DD');
        $("#rangeDateValue").val(starts+"  -  "+ends);
        $("#queryDateStart").val(starts);
        $("#queryDateEnd").val(ends);
        console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
    });

    //$('.progress .progress-bar').progressbar();
    $("#orderDetailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath + "/core/accountStatementList.do",
        formatters: {
            "createTime": function(column, row)
            {
                var str="";
                if(row.createTime!=null) {
                    str = moment(row.createTime).format('YYYY-MM-DD hh:mm:ss');
                }
                return str;
            },
            "productId": function(column, row)
            {
                var str;
                if (row.productId == 1) {
                    str = "中国报告";
                } else if(row.productId == 2){
                    str = "外国报告";
                }else if(row.productId == 3){
                    str = "自定义报告";
                }
                return str;
            },
        }
    });
});


function getParams(){
    if($("#rangeDateValue").val() ==null || $("#rangeDateValue").val() == ""){
        $("#queryDateStart").val("");
        $("#queryDateEnd").val("");
    }
    return {
        createDateFrom: $("#queryDateStart").val(),
        createDateTo: $("#queryDateEnd").val()
    }
}

function query(){
    $("#orderDetailGrid").bootgrid("reload");
}

function emptyRangeDate(){
    $("#rangeDateValue").val("");
}