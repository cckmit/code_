$(function () {
    $("#collectionrGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        url: basePath + "customer/collectionList.do",
        formatters: {
            "collectionTime": function (column, row) {
                var str = moment(row.collectionTime).format('YYYY-MM-DD');
                return str;
            },
            "operate": function (column, row) {
                var but = '';
                but += "<button class=\"btn btn-success fxq-btn-cancel\" onclick=\"deleteCollection(" + row.id + ");\">Remove</button>";
                 but += "&nbsp;&nbsp;<button class=\"btn btn-success fxq-btn-detailed\" onclick=\"searchCollection('" + row.collectionCompany + "');\">Open</button>";
                return but;
            }
        }
    });
});
function searchCollection(collectionCompany) {
    window.open(basePath + "user/reportChoose.do?type=Companies&companyName=" + encodeURIComponent(collectionCompany));
};
function deleteCollection(id) {
    var senddata = {
        "id": id
    };

    BootstrapDialog.show({
        title: 'Cancel collection',
        message: "Are you sure you want to cancel the company?",
        buttons: [{
            label: 'submit',
            action: function (dialog) {
                $.ajax({
                    type: "POST",
                    url: basePath + "customer/delCollectionById.do",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(senddata),
                    success: function (data) {
                        BootstrapDialog.alert("Cancel Successful");
                        $("#collectionrGrid").bootgrid("reload");
                        dialog.close();
                    }
                });
            }
        }, {
            label: 'cancel',
            action: function (dialog) {
                dialog.close();
            }
        }]
    });
}





