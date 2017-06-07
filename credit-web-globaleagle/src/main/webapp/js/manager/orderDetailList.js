var s = 20, t;
var progressArr = new Array();
var g_isChinaOrder;
$(function() {
    //$('.progress .progress-bar').progressbar();
    $("#orderDetailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath + "customer/orderDetailListIsPay.do",
        formatters: {
            "operate": function(column, row)
            {
                var def = new Date() - row.createDate;
                var second = def /1000;//秒
                var id = row.id;
                if (row.orderStatusId == 0)
                    return "";
                var but;
                but = "<table class='operateTable'><tr>";
                if (row.isChinaOrder=="否") {
                    if (row.isCustomOrder=="否"){
                        but += "<td>";
                        if(second > 30){
                            // 打开报告按钮比的显示
                            but += "<button class=\"btn btn-xs btn-primary\" onclick=\"download("+id+",'"+row.companyNo+"','"+row.orderId+"');\">数据库报告</button>";
                        }
                        else{
                            progressArr.push({
                                id:id,
                                second:second,
                                companyNo:row.companyNo,
                                orderId:row.orderId,
                                isChinaOrder:row.isChinaOrder,
                                crefoNo:row.crefoNo
                            });
                            //滚动条显示
                            but +="<div class='progress progress-striped active' style='width: 170px;'>";
                            but += "<div class='progress-bar progress-bar-primary' id='progressBar" + id + "' data-transitiongoal='"+(second/30*100)+"' role='progressbar' aria-valuemin='0' aria-valuemax='100'></div>";
                            but +="</div>";
                        }

                        but +="</td>";
                    }
                } else{
                    but += "<td>";
                    if(second > 30){
                        // 打开报告按钮比的显示
                        but += "<button class=\"btn btn-xs btn-primary btn-block\" onclick=\"downloadChina("+id+",'"+row.crefoNo+"','"+row.orderId+"');\">数据库报告</button>";
                    }
                    else{
                        progressArr.push({
                            id:id,
                            second:second,
                            companyNo:row.companyNo,
                            orderId:row.orderId,
                            isChinaOrder:row.isChinaOrder,
                            crefoNo:row.crefoNo
                        });
                        //滚动条显示
                        but +="<div class='progress progress-striped active' style='width: 170px;'>";
                        but += "<div class='progress-bar progress-bar-primary' id='progressBar" + id + "' data-transitiongoal='"+(second/30*100)+"' role='progressbar' aria-valuemin='0' aria-valuemax='100'></div>";
                        but +="</div>";
                    }

                    but +="</td>";
                }
                if(row.uploadFilePath!="" && row.uploadFilePath!=undefined){
                    but += "<td><button class=\"btn btn-xs btn-success\" onclick=\"downloadFull("+id+",'"+row.uploadFilePath+"');\">完整报告</button></td>";
                }
                but += "</tr></table>";
                return but;
            },
            "createDate": function(column, row)
            {
                var str=moment(row.createDate).format('YYYY-MM-DD hh:mm:ss');
                return str;
            },
            "orderStatusId": function(column, row)
            {

                var str;
                if (row.orderStatusId == 1) {
                    str = "<span class=\"btn btn-xs btn-info\">制作中</span>";
                } else if(row.orderStatusId == 2){
                    str = "<span class=\"btn btn-xs btn-success\">已完成</span>";
                }else if(row.orderStatusId == 0){
                    str = "<span class=\"btn btn-xs btn-warning\">已取消</span>";
                }

                return str;
            }
            ,
            "orderLevel": function(column, row)
            {

                var str;
                if (row.orderLevel == 1) {
                    str = "数据库报告";
                } else if(row.orderLevel == 2){
                    str = "完整性报告";
                }else if(row.orderLevel == 3){
                    str = "数据库完整报告";
                }

                return str;
            }
            ,"totalPrice": function(column, row)
            {

                var str;
                str="cny "+row.totalPrice+".00"
                return str;
            } ,
            "orderNo": function(column, row)
            {

                var str = "<a href='"+basePath + "customer/toOrderList.do?orderNo="+row.orderNo+"'>"+row.orderNo +"</a>"   ;

                return str;
            },
            "totalPrice": function(column, row)
            {

                var str;
                str="CNY "+formatCurrency(row.totalPrice);
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
            if(v.isFinished){
                return true;
            }
            var obj = $('#progressBar' + v.id);
            var xx =  new Number(obj.attr('data-transitiongoal')) + 100/30;
            if(xx < 0){
                return true;
            }
            if(xx > 100){
                //去后台检查是否下载成功，如果成功，则显示报告按钮
                if (v.isChinaOrder=="是"){
                    obj.parent().after("<button class=\"btn btn-xs btn-primary btn-block\" onclick=\"downloadChina("+v.id+",'"+v.crefoNo+"','"+v.orderId+"');\">数据库报告</button>");
                }else{
                    obj.parent().after("<button class=\"btn btn-xs btn-primary\" onclick=\"download("+v.id+",'"+v.companyNo+"','"+v.orderId+"');\">数据库报告</button>");
                }
                obj.parent().hide();
                v.isFinished = true;
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
        orderLevel:$("#orderLevel").val(),
        orderStatusId:$("#orderStatusId").val()
    }
}

function query(){
    $("#orderDetailGrid").bootgrid("reload");
}
function download(id,companyNo,orderId){
    window.open( basePath+'/customer/requestCompanyDetail.do?companyId='+companyNo+'&orderDetailId='+id+'&orderId='+orderId);
    modifyIsRead(id);
}
function downloadChina(id,crefoNo,orderId){
    window.open(basePath+'/customer/html/viewReportV1.do?crefoNo='+crefoNo+'&orderDetailId='+id+'&orderId='+orderId);
    modifyIsRead(id);
}

function downloadFull(id,url){
    window.open(basePath+url);
    modifyIsRead(id);
}

function modifyIsRead(id){
    var senddata = {
        id:id
    };
    $.ajax({
        type:"POST",
        url:basePath+"customer/modifyOrderDetailIsRead.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(!data.result){
                BootstrapDialog.alert(data.msg);
            }
        }
    });
    location.reload();
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