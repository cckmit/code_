var progressArr = new Array();
var now = 30;
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
            "operate": function(column, row)
            {
                var def = new Date() - row.createTime;
                var second = def / 1000;//秒
                var a = parseInt(second);
                if (row.status == 0)
                    return "";
                var but;
                but = "<table class='operateTable'><tr>";

                if(second>now){

                    but += "<button id='dbReport"+row.id+"' class=\"btn btn-success fxq-btn-success fxq-time\" onclick=\"downloadChina("+row.id+",'"+row.createTime+"','"+row.orderId+"');\">View Report</button>";
                }else{

                    progressArr.push({
                        id: row.id,
                        second: second,
                        orderId: row.orderId,
                        createTime: row.createTime,
                        countryName: row.countryName,
                        hasShow: false
                    });
                    but += "<button type='button' id='dbReport"+row.id+"' class=\"btn btn-success fxq-btn-success fxq-time\"  onclick=\"downloadChina("+row.id+",'"+row.createTime+"','"+row.orderId+"');\" disabled>View Report("+(now-a)+")</button>";
                }
                but += "</tr></table>";

                return but;
            },

            "createTime": function(column, row)
            {
                var str=moment(row.createTime).format('YYYY-MM-DD');
                return str;
            },
            "status": function(column, row) {
                var str;
                if (row.status == 0) {
                    str = "<span style='font-weight: bold;'>Cancel</span>";
                } else if(row.status == 1){
                    str = "<span style='font-weight: bold;'>Unpaid</span>";
                }else if(row.status == 2){
                    str = "<span style='font-weight: bold;'>Under Investigation</span>";
                }else if(row.status == 3){
                    str = "<span style='font-weight: bold;'>To Be Assigned</span>";
                }else if(row.status == 4){
                    str = "<span style='color:#af0a18;font-weight: bold;'>Order in Process</span>";
                }else if(row.status == 5){
                    str = "<span style='font-weight: bold;'>Check Pending</span>";
                }else if(row.status == 6){
                    str = "<span style='font-weight: bold;'>In Review</span>";
                }else if(row.status == 7){
                    str = "<span style='font-weight: bold;'>To Be Released</span>";
                }else if(row.status == 8){
                    str = "<span style='color:#1abc9c;font-weight: bold;'>Order Finished</span>";
                }
                return str;
            },
            "productType": function(column, row)
            {

                var str;
                // alert(row.productType);
                if (row.productId == 8) {
                    str = "e-Check Report";
                } else if (row.productId == 9) {
                    str = "e-Compat Report";
                } else if (row.productId == 10) {
                    str = "e-Report";
                }

                return str;
            }
            ,"price": function(column, row)
        {

            var str;
            str="USD"+row.price+".00"
            return str;
        } ,
        "price": function(column, row)
        {
            var str;
            // str="CNY "+row.totalPrice.toFixed(2);formatCurrency
            str="USD"+formatCurrency(row.price);
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
        // $("#countryId").empty();
        // $.each(countries,function(){
        //     $("#countryId").append(this);
        // });
    });
    startTimer();
});
function startTimer() {
    var timehwnd=setInterval("Countdown()",1000);
}
function getParams(){
    return {
        companyName:$("#companyNameQuery").val(),
        productType:$("#productType").val(),
        status:$("#status").val()
    }

}

function query(){
    $("#orderDetailGrid").bootgrid("reload");
}


function downloadChina(id,createTime,orderId){
    // alert(1);
    window.open(basePath+'/customer/openReport.do?orderDetailId='+id+'&orderId='+orderId);
    modifyIsRead(id);

}
function Countdown(){
//     now--;
//     if(now == 0){
//         $("button[id='dbReport"+v.id+"']").html("<button id=dbReport class=\"btn btn-success fxq-btn-success fxq-time\" onclick=\"downloadChina("+row.id+",'"+row.createTime+"','"+row.orderId+"');\">View Report</button>");
// //        clearInterval(startTimer);
//     }else{
        $.each(progressArr, function(i, v){
            var def = new Date() - v.createTime;
            var second = def / 1000;//秒
            var a = parseInt(second);
            if ((now-a)<0){
                $("button[id='dbReport"+v.id+"']").html("View Report");
                $("button[id='dbReport"+v.id+"']").removeAttr("disabled");
            }else{
                $("button[id='dbReport"+v.id+"']").html("View Report("+(now-a)+")");
            }
        });

    // }
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

                BootstrapDialog.alert(data.resultDes);
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
            BootstrapDialog.alert(data.resultDes);
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
