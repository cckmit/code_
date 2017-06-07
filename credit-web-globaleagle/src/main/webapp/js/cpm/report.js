$(document).ready(function() {
    var tables = $('#dynamic-table').dataTable({
        "dom":'<"top"i>',
        "searching": false,
        "aoColumns": [
            { "bSearchable": false, "bSortable": true, "bVisible":false},
            { "bSearchable": false, "bSortable": false}
        ],
        "aaSorting": [[0, "desc"]] //默认排序
    });
} );
