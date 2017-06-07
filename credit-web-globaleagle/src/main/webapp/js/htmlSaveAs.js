var test;
var email;
var customerId;
var crefoNo;
var orderDetailId;
function download1(pathDataFile) {
    // BootstrapDialog.alert("该功能正在调试，即将开放！");
    // window.open(basePath + "customer/downloadPDF.do?country=" + country + "&companyId=" + companyId + "&orderDetailId=" + orderDetailId);
    // alert("192.168.1.40:22122"+pathDataFile);
    if (pathDataFile==""||pathDataFile==null){
        BootstrapDialog.alert("PDF正在生成中！");
    }else {
        window.open("http://192.168.1.40:8888/"+pathDataFile);
    }

}

function downloadChinatwo() {
    BootstrapDialog.alert("该功能正在调试，即将开放！");

    // window.open("http://27.115.108.106:8090/Export/GlobaHawkPDFCompleteAction_two.do?method=downPDF&crefoNo=" + crefoNo + "&accountNumber=" + customerId);
}
function sendEmail(country, companyId, orderDetailId) {
    BootstrapDialog.alert("该功能正在调试，即将开放！");
    //
    // $("#sendBtn").attr("disabled", "disabled");
    // var htmlView = {
    //     "crefoNo": crefoNo,
    //     "email": email,
    //     "companyId": companyId,
    //     "orderDetailId": orderDetailId,
    //     "country": country
    //
    // };
    // BootstrapDialog.alert("发送报告成功");
    // $.ajax({
    //     type: "POST",
    //     url: basePath + "report/sendEmail.do",
    //     dataType: "json",
    //     contentType: "application/json",
    //     data: JSON.stringify(htmlView),
    //     success: function (data) {
    //         // if (data == "true" || data == true) {
    //         //     BootstrapDialog.alert("发送报告成功");
    //         // } else {
    //         //     BootstrapDialog.alert("发送报告失败");
    //         // }
    //         $("#sendBtn").removeAttr("disabled");
    //     }
    // });
}

function sendChinaEmail(country, companyId, orderDetailId,level) {
    BootstrapDialog.alert("该功能正在调试，即将开放！");
    //
    // $("#sendBtn").attr("disabled", "disabled");
    // var htmlView = {
    //     "email": email,
    //     "companyId": companyId,
    //     "orderDetailId": orderDetailId,
    //     "country": country,
    //     "level": level
    // };
    // BootstrapDialog.alert("发送报告成功");
    // $.ajax({
    //     type: "POST",
    //     url: basePath + "report/sendChinaEmail.do",
    //     dataType: "json",
    //     contentType: "application/json",
    //     data: JSON.stringify(htmlView),
    //     success: function (data) {
    //         // if (data == "true" || data == true) {
    //         //     BootstrapDialog.alert("发送报告成功");
    //         // } else {
    //         //     BootstrapDialog.alert("发送报告失败");
    //         // }
    //         $("#sendBtn").removeAttr("disabled");
    //     }
    // });
}



function fake_click(obj) {
    var ev = document.createEvent("MouseEvents");
    ev.initMouseEvent(
        "click", true, false, window, 0, 0, 0, 0, 0
        , false, false, false, false, 0, null
    );
    obj.dispatchEvent(ev);
}

function export_raw(name, data) {
    var urlObject = window.URL || window.webkitURL || window;

    var export_blob = new Blob([data]);

    var save_link = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
    save_link.href = urlObject.createObjectURL(export_blob);
    save_link.download = name;
    fake_click(save_link);
}

function submitColInfo(dataType,id){
    var colType = $('#colType').val();
    var colCourt = $('#colCourt').val();
    var colCaseNo = $('#colCaseNo').val();
    var colSortTimeString = $('#colSortTimeString').val();
    var colTitle = $('#colTitle').val();
    var colBody = $('#colBody').val();
    //alert(colType+'---'+colCourt+'---'+colCaseNo+'---'+colSortTimeString+'---'+colTitle+'---'+colBody);
    var colTopic = '';
    if(colBody == null || colBody == undefined || $.trim(colBody) == ''){
        colTopic = colTitle;
    }else{
        colTopic = colBody;
    }
    var colView =  {
        "colType": colType,
        "colCourt": colCourt,
        "colCaseNo": colCaseNo,
        "colSortTimeString": colSortTimeString,
        "colTopic": colTopic,
        "colOrderDetailId":orderDetailId,
        "dataType":dataType,
        "id":id
    };
    $.ajax({
        method: "POST",
        url:basePath+"customer/addcollection.do",
        cache:false,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(colView),
        success : function(data) {
            if(data=='true'||data==true){
                BootstrapDialog.alert('数据收藏成功');
                if(colListGrid) {
                    colListGridChange = true;
                }
            }
        }
    });
}

var colListGrid = undefined;
var colListGridChange = false;

function loadColInfo(){
    $('#myColModal').modal('show');
    if(!colListGrid) {
        colListGrid = $("#colListGrid").bootgrid({
            ajaxSettings: {
                method: "POST",
                cache: false
            },
            selection: false,
            multiSelect: false,
            ajax: true,
            post: getParams,
            url: basePath + "customer/loadColList.do",
            formatters: {
                "operate": function (column, row) {
                    var but = "";
                    but += "   <table><tr><td><button class='btn btn-sm btn-primary btn-block' onclick='deletecColInfo(" + row.id + ");'>删除</button></td></tr></table>";
                    return but;
                },
                "createDate": function (column, row) {
                    var str = moment(row.createDate).format('YYYY-MM-DD');
                    return str;
                },
                "content": function (column, row) {
                    var but = "";
                    but += "   <table><tr><td><button class='btn btn-sm btn-primary btn-block' onclick='loadContent(" + row.id + ");'>详细内容</button></td></tr></table>";
                    return but;
                }
            }
        });
    }
    if(colListGridChange){
        colListGrid.bootgrid("reload");
    }
}

function getParams(){
    return {
        orderDetailId: orderDetailId
    }
}

function loadContent(id) {
    $.ajax({
        method: "POST",
        url:basePath+"customer/selContentById.do",
        cache:false,
        dataType : 'json',
        data:{
            'id':id
        },
        success : function(data) {
            BootstrapDialog.alert(data);
        }
    });
}

function deletecColInfo(id) {
    $.ajax({
        method: "POST",
        url: basePath + "customer/deletecColInfo.do",
        cache: false,
        dataType: "json",
        data: {
            'id':id
        },
        success : function(data) {
            BootstrapDialog.alert("删除成功");
            colListGrid.bootgrid("reload");
        }
    });
}

