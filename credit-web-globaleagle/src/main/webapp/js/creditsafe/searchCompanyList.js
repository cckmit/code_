$(function() {
    $('.progress .progress-bar').progressbar();
    $("#progress-bar").hide();
    $("#searchCompanyListGrid").hide();
    $("#searchCompanyDetail").hide();
    $("#searchfail").hide();
    if(countryName != undefined && countryName!="" &&companyName != undefined && companyName!=""){
        $("#progress-bar").show();
        search();
    }else{
        BootstrapDialog.alert("城市名称和公司名称不能为空.");
    }
});
function addSlashes (str) {
	if (str==""||str==null||str=="undefined"||str==undefined) {
	    return "";
	}
    return str.replace(/[\\"']/g, '\\$&');

}
function search(){
    var data = {
        'countryName' : countryName,
        'companyName' : companyName
    }
    $.ajax({
        type:"POST",
        url:basePath+"searchCompanyList.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        timeout: 1500000,
        success:function(data){
            $("#progress-bar").hide();
            if(data.code){
                var companies = data.content.CompaniesInfo;
                var html = "";
                var count = 0;
                if(companies && companies.length > 0){
                    count = companies.length;
                    if(countryName=="中国"){
                        $.each(companies,function(){
                            html += "<tr>\n";
                            html += "<td>"+(this.reg!=undefined?this.reg:"") +"</td>\n";
                            html += "<td>"+this.nameCN+"";
                            if (this.nameUsed==undefined||this.nameUsed==""||this.nameUsed=="undefined"){
                            }else{
                                html += "<br><small>曾用名："+this.nameUsed+"</small>";
                            }
                            html += "</td>\n";
                            if(this.status==1){
                                html += '<td><span class="label label-success" style="line-height:2;">'+"存续"+'</span></td>';
                            }else if(this.status==2){
                                html += '<td><span class="label label-info" style="line-height:2;">'+"未营业"+'</span></td>';
                            }else if(this.status==3){
                                html += '<td><span class="label label-warning" style="line-height:2;">'+"注销"+'</span></td>';
                            }else if(this.status==4){
                                html += '<td><span class="label label-warning" style="line-height:2;">'+"营业执照被吊销"+'</span></td>';
                            }else if(this.status==5){
                                html += '<td><span class="label label-danger" style="line-height:2;">'+"破产"+'</span></td>';
                            }else if(this.status==6){
                                html += '<td><span class="label label-danger" style="line-height:2;">'+"接受破产管理"+'</span></td>';
                            }else if(this.status==7){
                                html += '<td><span class="label label-danger" style="line-height:2;">'+"暂停营业"+'</span></td>';
                            }else if(this.status==8){
                                html += '<td><span class="label label-danger" style="line-height:2;">'+"歇业"+'</span></td>';
                            }else if(this.status==9){
                                html += '<td><span class="label label-warning" style="line-height:2;">'+"迁出"+'</span></td>';
                            }else if(this.status==10){
                                html += '<td><span class="label label-warning" style="line-height:2;">'+"Move out"+'</span></td>';
                            }else{
                                html += '<td>'+"&nbsp;"+'</td>';
                            }
                            html += "<td>"+countryName+" "+ (this.provinceCN!=undefined?this.provinceCN:"") +"</td>\n";
                            html += '<td><span class="label label-warning" style="line-height:2;">';
                            if (this.stockCode==undefined||this.stockCode==null||this.stockCode==""){
                            }else{
                                var stockJudge = this.stockCode.split("",1);
                                if(stockJudge==0||stockJudge==6){
                                    html +="主板";
                                }else if(stockJudge==3){
                                    html +="创业板";
                                }else if(stockJudge==4||stockJudge==8){
                                    html +="新三板";
                                }else{

                                }
                                html +="&nbsp;"+this.stockCode+"&nbsp;";
                                html +=(this.remark!=undefined?this.remark:"");
                            }
                            html += '</span></td>';
                            var url = basePath+"/user/reportChoose.do?companyNo="+this.crefoNo+"&companyName="+this.nameCN+"&countryName="+countryName;
                            html += "<td><table class='operateTable'><tr><td><button class=\"btn btn-sm btn-primary btn-block\" onclick=\"window.location.href='"+url+"'\">详细内容</button></td></tr></table></td>\n";
                            html += "</tr>\n";


                        });
                    }else{
                        $.each(companies,function(){
                            html += "<tr>\n";
                            html += "<td>" + (this.registrationNumber ? this.registrationNumber : "" )+"</td>\n";
                            if(this.vatNumber==undefined){
                                html +="<td>"+"</td>\n";
                            }else {
                                html += "<td>" +this.vatNumber+"</td>\n";
                            }
                            html +="<td>"+this.name+"</td><td style='padding-top: 12px;'>";
                            if (this.status=="Active") {
                                html += "<span class='btn btn-xs btn-success'>"+this.status+"</span></td>"	;
                            }
                            else if(this.status=="NonActive"){
                                html += "<span class='btn btn-xs btn-danger'>"+this.status+"</span></td>"	;
                            }else{
                                html += "<span class='btn btn-xs btn-warning'>"+"Unknow"+"</span></td>"	;
                            }

                            html += " <td>" + (this.dateOfLatestAccounts ? this.dateOfLatestAccounts : "") + "</td>\n";


                            html += "<td>"+countryName+" " + (this.address.city ? this.address.city : "")+ "</td>\n";

                            if(this.address.simpleValue==""||this.address.simpleValue==null){
                                html += " <td>" + (this.address.street ? this.address.street : "") + "</td>\n";
                            }else{
                                html += " <td>" + (this.address.simpleValue ? this.address.simpleValue : "") + "</td>\n";
                            }
                            //this.address.province+"</td>\n";
                            var url = basePath+"/user/reportChoose.do?companyNo="+this.id+"&companyName="+this.name+"&countryName="+countryName;
                            var urlV3 = basePath+"/customer/requestCompanyDetailV3.do?companyNo="+this.id+"&companyName="+this.name+"&countryId="+data.content.countryNo;
                            //判断是否用户为等级3
                            if (customerInfo!=null){
                                if (customerLevel==3||customerLevel=="3"){
                                    html += "<td><table class='operateTable'><tr><td><button class=\"btn btn-xs btn-primary btn-block\" onclick=\"v3DetailButton('"+urlV3+"')\">详细内容</button></td></tr></table></td>\n";
                                }else{
                                    html += "<td><table class='operateTable'><tr><td><button class=\"btn btn-xs btn-primary btn-block\" onclick=\"window.location.href='"+url+"'\">详细内容</button></td></tr></table></td>\n";
                                }
                            }else{
                                html += "<td><table class='operateTable'><tr><td><button class=\"btn btn-xs btn-primary btn-block\" onclick=\"window.location.href='"+url+"'\">详细内容</button></td></tr></table></td>\n";
                            }
                            html += "</tr>\n";
                        });
                    }
                    $("#searchCompanyListGrid").show();
                }else{
                    $("#searchfail").show();
                    $("#searchCompanyDetail").show();
                    BootstrapDialog.alert("无搜索结果，请更换关键词");
                }
                $("#companySize").html(count);
                $("#result").append(html);
            }
            else{
                BootstrapDialog.alert("数据获取失败,稍候重试");
            }
        },
        complete : function(XMLHttpRequest,status){ //请求完成后最终执行参数
            if(status=='timeout'){//超时,status还有success,error等值的情况
                $("#progress-bar").hide();
                BootstrapDialog.alert("响应超时,稍候重试");
            }
        }
    });
}

function v3DetailButton (url) {
    BootstrapDialog.show({
        title: '订单确认',
        message: "确认是否订购此报告",
        buttons: [{
            label: '确定',
            action: function(dialog) {
                dialog.close();
                window.open(url);
            }
        }, {
            label: '取消',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });
}