function fnFormatDetails ( oTable, nTr )
{
    var aData = oTable.fnGetData( nTr );
    var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
    sOut += '<tr><td>Rendering engine:</td><td>'+aData[1]+' '+aData[4]+'</td></tr>';
    sOut += '<tr><td>Link to source:</td><td>Could provide a link here</td></tr>';
    sOut += '<tr><td>Extra info:</td><td>And any further details here (images etc)</td></tr>';
    sOut += '</table>';

    return sOut;
}

$(document).ready(function() {

    $('#dynamic-table').dataTable( {
        "oLanguage": {
            "sSearchPlaceHolder": "名称 管理员 状态",
        },
        // "sAjaxSource": basePath + "/sys/appList.do",
        // "bServerSide" : true, // 异步请求必须设置
        // "sServerMethod": "POST",
        // "fnServerParams": function ( aoData ) {
        //     aoData.push( { "name": "11", "value": "11" } );
        //     aoData.push( { "name": "22", "value": "22" } );
        //     aoData.push( { "name": "33", "value": "33" } );
        // },
//
        // "sUrl": basePath + "/app/do.do",
        // "aoData": {
        //     t:"p"
        // },
        // "fnCallback":function(){
        //     alert("success!");
        // },
        // "aoColumns": [
        //     { "sTitle": "管理员",   "mData": "user.username", "sClass":"" },
        //     { "sTitle": "创建日期",   "mData": "createDate" }
        // ],
        "aoColumns": [
            { "sTitle": "appId", "bSearchable": false, "bSortable": false},
            { "sTitle": "名称", "bSearchable": true},
            { "sTitle": "管理员", "bSearchable": true},
            { "sTitle": "创建日期", "bSearchable": false},
            { "sTitle": "激活日期", "bSearchable": false},
            { "sTitle": "状态", "bSearchable": true, "bVisible": false},
            { "sTitle": "状态", "bSearchable": false},
            { "sTitle": "操作", "bSearchable": false, "bSortable": false}
        ],
        "searching": false,
        "aaSorting": [[0, "asc"]], //默认排序
        // "aoColumnDefs": [//和aoColums类似，但他可以给指定列附近爱属性
        //     {"bSortable": false, "aTargets": [1, 3, 6, 7, 8, 9]},  //这句话意思是第1,3,6,7,8,9列（从0开始算） 不能排序
        //     {"bSearchable": false, "aTargets": [1, 2, 3, 4, 5, 6, 7, 8, 9]} //bSearchable 这个属性表示是否可以全局搜索，其实在服务器端分页中是没用的
        // ],
        // "createdRow": function ( row, data, index ) {//格式化行
        //     if ( data['opNum'] > 1000 ) {//操作次数大于1000的变红显示
        //         $('td', row).eq(1).css('font-weight',"bold").css("color","red");
        //     }
        // },
        // "aaSorting": [[ 4, "desc" ]]
    } ).fnDraw(false);

    /*
     * Insert a 'details' column to the table
     */
    var nCloneTh = document.createElement( 'th' );
    var nCloneTd = document.createElement( 'td' );
    nCloneTd.innerHTML = '<img src=' + basePath + '"/images/details_open.png">';
    nCloneTd.className = "center";

    $('#hidden-table-info thead tr').each( function () {
        this.insertBefore( nCloneTh, this.childNodes[0] );
    } );

    $('#hidden-table-info tbody tr').each( function () {
        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
    } );

    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#hidden-table-info').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] }
        ],
        "aaSorting": [[1, 'asc']]
    });

    /* Add event listener for opening and closing details
     * Note that the indicator for showing which row is open is not controlled by DataTables,
     * rather it is done here
     */
    $(document).on('click','#hidden-table-info tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        if ( oTable.fnIsOpen(nTr) )
        {
            /* This row is already open - close it */
            this.src = basePath + "/images/details_open.png";
            oTable.fnClose( nTr );
        }
        else
        {
            /* Open this row */
            this.src = basePath + "/images/details_close.png";
            oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
        }
    } );
} );