var s = 20, t;
var progressArr = new Array();
var g_isChinaOrder;
$(function() {
    $("#orderDetailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath + "customer/orderDetailList.do",
        formatters: {
            "operate": function (column, row) {
                var def = new Date() - row.createTime;
                var second = def / 1000;//秒
                var id = row.id;
                if (row.status == 0){
                    return "";
                }
                var but;
                but = "<table class='operateTable'><tr>";
                if (row.countryName != "中国") {
                    if (row.productType != 3) {
                        but += "<td>";
                        if (second > 30) {
                            // 打开报告按钮比的显示
                            but += "<td><button class=\"btn btn-xs btn-primary\" onclick=\"download(" + row.id + ",'" + row.companyNo + "','" + row.orderId + "');\">数据库报告</button></td>";
                        }
                        else {
                            progressArr.push({
                                id: id,
                                second: second,
                                companyNo: row.companyNo,
                                orderId: row.orderId,
                                countryName: row.countryName,
                                hasShow: false
                            });
                            //滚动条显示
                            but += "<div class='progress progress-striped active' style='width: 170px;'>";
                            but += "<div class='progress-bar progress-bar-primary' id='progressBar" + id + "' data-transitiongoal='" + (second / 30 * 100) + "' role='progressbar' aria-valuemin='0' aria-valuemax='100'></div>";
                            but += "</div>";
                        }
                        but += "</td>";
                    }
                } else {
                    but += "<td>";
                    if (second > 30) {
                        // 打开报告按钮比的显示
                        but += "<td><button class=\"btn btn-xs btn-primary btn-block\" onclick=\"downloadChina(" + row.id + ",'" + row.crefoNo + "','" + row.orderId + "');\">数据库报告</button></td>";
                    }
                    else {
                        progressArr.push({
                            id: id,
                            second: second,
                            companyNo: row.crefoNo,
                            orderId: row.orderId,
                            countryName: row.countryName,
                            hasShow: false
                        });
                        //滚动条显示
                        but += "<div class='progress progress-striped active' style='width: 170px;'>";
                        but += "<div class='progress-bar progress-bar-primary' id='progressBar" + id + "' data-transitiongoal='" + (second / 30 * 100) + "' role='progressbar' aria-valuemin='0' aria-valuemax='100'></div>";
                        but += "</div>";
                    }
                    but += "</td>";
                }
                if (row.uploadFilePath != "" && row.uploadFilePath != undefined) {
                    but += "<td><button class=\"btn btn-xs btn-success\" onclick=\"downloadFull(" + row.id + ",'" + row.pathFile + "');\">完整报告</button></td>";
                }
                but += "</tr></table>";
                return but;
            },
            "createTime": function (column, row) {
                var str = moment(row.createTime).format('YYYY-MM-DD HH:mm:ss');
                return str;
            },
            "productId": function (column, row) {
                var str;
                if (row.productId == 1) {
                    str = "数据库报告";
                } else if (row.productId == 2) {
                    str = "数据库完整报告";
                } else if (row.productId == 3) {
                    str = "完整版报告";
                } else if (row.productId == 4) {
                    str = "完整版报告-加急";
                }else if (row.productId == 5) {
                    str = "数据库报告";
                }else if (row.productId == 6) {
                    str = "完整版报告";
                }else if (row.productId == 7) {
                    str = "完整版报告-加急";
                }
                return str;
            }
        }
    });
    $("#orderDetailGrid").bootgrid().on("loaded.rs.jquery.bootgrid", function (e) {
        var data = $("#orderDetailGrid").bootgrid("getCurrentRows");
        var i = 1;
        var countries = Array();
        countries[0] = "<option></option>";
        $.each(data,function(){
            var country = "";
            var flag = 0;
            for(var j=0;j<countries.length;j++){
                if($("#countryId").val()==this.countryId){
                    country = "<option value='"+this.countryId+"' selected='true'>"+this.countryName+"</option>";
                }
                else{
                    country = "<option value='"+this.countryId+"'>"+this.countryName+"</option>";
                }
                if(countries[j]==country){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                countries[i] = country;
                i++;
            }
        });
        $("#countryId").empty();
        $.each(countries,function(){
            $("#countryId").append(this);
        });
        initProgress();
    });
    // $("#createDateFrom").datepicker({
    //     autoSize: true,
    //     changeYear: true,
    //     changeMonth: true,
    //     dateFormat: "yy-mm-dd"
    // });
    // $("#createDateTo").datepicker({
    //     autoSize: true,
    //     changeYear: true,
    //     changeMonth: true,
    //     dateFormat: "yy-mm-dd"
    // });
});

function  initProgress() {
    $.each(progressArr, function (i, v) {
        var second = new Number(v.second);
        var obj = ($('#progressBar' + v.id));
        obj.progressbar({"value":second/30*100});
    });
    changeProgressBar();
}
var ss = 1;
function changeProgressBar() {
    if(ss<30){
        $.each(progressArr, function(i, v){
            if(v.hasShow){
                return true;
            }
            var obj = $('#progressBar' + v.id);
            var xx =  new Number(obj.attr('data-transitiongoal')) + 100/30;
            if(xx < 0){
                return true;
            }
            if(xx > 100){
                //去后台检查是否下载成功，如果成功，则显示报告按钮
                if (v.countryName=="中国"){
                    obj.parent().after("<button class=\"btn btn-xs btn-primary btn-block\" onclick=\"downloadChina("+v.id+",'"+v.crefoNo+"','"+v.orderId+"');\">数据库报告</button>");
                }else{
                    obj.parent().after("<button class=\"btn btn-xs btn-primary\" onclick=\"download("+v.id+",'"+v.companyNo+"','"+v.orderId+"');\">数据库报告</button>");
                }
                obj.parent().hide();
                v.hasShow = true;
            }
            obj.progressbar({"value":xx});
            obj.attr("data-transitiongoal", xx);
        });
        ss++;
        var t = setTimeout(changeProgressBar,1000);
    }
}

function getParams(){
    return {
        companyName: $("#companyNameQuery").val(),
        createDateFrom: $("#createDateFrom").val(),
        createDateTo: $("#createDateTo").val(),
        productId:$("#productId").val(),
        status:$("#status").val()
    }
}

function query(){
    $("#orderDetailGrid").bootgrid("reload");
}
function download(id,companyNo,orderId){
    window.open( basePath+'/customer/openReport.do?&orderDetailId='+id);
}
function downloadChina(id,crefoNo,orderId){
    window.open(basePath+'/customer/openReport.do?&orderDetailId='+id);
}

function downloadFull(id,url){
    window.open(basePath+url);
}


function deleteOrder(id){
    var senddata = {
        "id":id
    };
    $.ajax({
        type:"POST",
        url:basePath+"customer/deleteOrder.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.msg);
            $("#orderDetailGrid").bootgrid("reload");
        }
    });
}
function formatCurrency(num) {
    if (num==null||num==""){
        return "";
    }
    num = num.toString().replace(/\$|\,/g,'');
    if(isNaN(num))
        num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num*100+0.50000000001);
    cents = num%100;
    num = Math.floor(num/100).toString();
    if(cents<10)
        cents = "0" + cents;
    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
        num = num.substring(0,num.length-(4*i+3))+','+
            num.substring(num.length-(4*i+3));
    return (((sign)?'':'-') + num + '.' + cents);
}


function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}