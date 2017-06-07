<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>全球鹰-快速订购</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>/js/user/fastAddCart.js"></script>
    <link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/fileinput.css">
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/fileinput.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/localization/fileinput/zh.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/ajaxfileupload.js"></script>
    <script type="text/javascript">
        var continents = ${continents};
        var country = "${country}";
        var continent = "${continent}";

        function payFo() {
            if (!checkForm()) {
                return;
            }
            if ($("#onCheckBox").attr("checked") == undefined && $("#offCheckBox").attr("checked") == undefined && $("#exCheckBox").attr("checked") == undefined) {
                BootstrapDialog.alert("请选择价格");
                return;
            }
            if ($("#clause").attr("checked") == undefined) {
                BootstrapDialog.alert("请接受法律条款");
                return;
            }
            if ("${sessionScope.customerInfo.levelId}" == 3) {
                BootstrapDialog.show({
                    title: '订单确认',
                    message: "确认是否订购此报告",
                    buttons: [{
                        label: '确定',
                        action: function () {
                            document.forms.from.action = "<%=basePath%>user/addOrderFromFast.do";
                            document.forms.from.submit();
                        }
                    }, {
                        label: '取消',
                        action: function (dialog) {
                            dialog.close();
                            return;
                        }
                    }]
                });
            } else {
                document.forms.from.action = "<%=basePath%>user/addOrderFromFast.do";
                document.forms.from.submit();
            }
        }
    </script>
</head>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div id="banner">
    <div class="container">
        <div class="row">
            <div class="well bs-component">
                <fieldset>
                    <legend>信用报告产品描述信息</legend>
                    <div class="form-group">
                        <div class="col-lg-12">
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;企业信用报告是通过全方位多渠道地采集被调查企业的信用信息，经综合评估后形成的客观反映被调查企业信用状况的专业报告。<br>
                                &nbsp;&nbsp;&nbsp;&nbsp;企业信用报告涵盖企业基本信息、法律注册信息、股权结构、工商变更信息、历史背景、企业关联信息、经营现状、财务信息、司法信息等内容。信用报告收集被调查企业信息，做出相应的财务分析、盈利能力和偿付能力判断，并对被调查企业进行信用风险评级，全面、直观、即时地反映被调查企业的信用状况，为客户判断被调查企业的信用状况提供参考，帮助客户迅速识别优质商业伙伴，规避潜在商业风险。
                            </p>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>

        <div class="row">
            <div class="well bs-component">
                <form class="form-horizontal"
                      action="<%=basePath%>user/fastAddCart.do" method="post"
                      onsubmit="return checkForm();" id="from">
                    <fieldset>
                        <legend>订购信息</legend>
                        <div class="form-group">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">*选择洲或区域：</label>
                                    <div class="col-lg-10" style="width: 400px">
                                        <select id="continent" class="form-control" onchange="onContinentChange();">
                                            <c:if test="${empty continent}">
                                                <option selected="selected">请选择</option>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">*选择所属国家：</label>
                                    <div class="col-lg-10" style="width: 400px">
                                        <select class="form-control" id="company_country" name="companyCountry"
                                                form="from" onchange="onCountry(this.value);">
                                            <c:if test="${empty country}">
                                                <option selected="selected">请选择</option>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">*目标公司名称：</label>

                                    <div class="col-lg-10" style="width: 400px">
                                        <input class="form-control" id="company_name"
                                               name="companyName" type="text" value="${fastCompanyName}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">*目标公司地址：</label>
                                    <div class="col-lg-10" style="width: 400px">
                                        <input class="form-control" id="company_address"
                                               name="companyAddress" type="text">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">*目标公司电话：</label>

                                    <div class="col-lg-10" style="width: 400px">
                                        <input class="form-control" id="company_phone"
                                               name="companyPhone" type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">目标公司网站：</label>
                                    <div class="col-lg-10" style="width: 400px">
                                        <input class="form-control" id="company_website" name="companyWebsite"
                                               type="text">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group pull-left" style="padding-left:40px">
                            <label class="col-md-12 control-label">
                                请填写你知道的有关被调查公司的其他讯息:</label>
                        </div>
                        <div class="col-lg-12" style="padding-left:35px">
                            <textarea id="txtOther" class="form-control" rows="3"></textarea>
                        </div>


                        <legend>&nbsp;</legend>


                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-lg-12 control-label" style="width: 165px">上传图片:</label>
                                    <div style="padding-top: 7px;">
                                        <input id="cbUploadPic" type="checkbox" onclick="cbUploadPicClick();">
                                        <strong>如无法输入目标公司信息，请选择上传图片</strong>
                                    </div>
                                </div>
                            </div>
                            <div id="uploadPic" class="col-md-offset-1 col-md-4">
                                <div class="form-group">
                                    <input id="uploadPicPath" name="uploadPicPath" class="form-control" type="hidden">
                                    <input id="file" type="file" name="file" class="file"
                                           data-allowed-file-extensions='["gif","jpg","png"]'>
                                    <%--<div class="col-lg-10" style="width: 500px">--%>
                                    <%--<div class="input-group">--%>
                                    <%--<div class="col-lg-5">--%>
                                    <%--</div>--%>
                                    <%--<div class="col-lg-4">--%>
                                    <%--</div>--%>

                                    <%--&lt;%&ndash;<span class="input-group-btn">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<input id="btnUpload" class="btn btn-primary btn-sm" type="button" value="上传" onclick="ajaxFileUpload();" disabled/>&ndash;%&gt;--%>

                                    <%--&lt;%&ndash;</span>&ndash;%&gt;--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                </div>
                            </div>
                        </div>


                        <legend></legend>

                        <div>
                            <table class="table table-striped table-responsive">
                                <thead>
                                <tr>
                                    <th width="8%">选择</th>
                                    <th width="12%">价格</th>
                                    <th width="15%">报告类型</th>
                                    <th width="10%">制作时间</th>
                                    <th width="7%">国家</th>
                                    <th width="7%">样本报告</th>
                                    <th width="21%">送达内容</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td bgcolor="#FFFFFF">
                                        <input name="choose" type="radio" value="offline"
                                               id="offCheckBox"></td>
                                    <td bgcolor="#FFFFFF">
                                        <strong>
                                            CNY <span
                                                id="offchoosePrice">${countryInfo.getOfflineOrderCnyPrice()}</span>
                                            <input  id="offchoosePriceHidden" type="hidden" name="offlinePrice"
                                                   value="${countryInfo.getOfflineOrderCnyPrice()}">
                                            <input id="offlineNormailDeliveryDaysHidden" type="hidden"
                                                   name="offlineNormailDeliveryDays"
                                                   value="${countryInfo.getOfflineNormailDeliveryDays()}">

                                        </strong></td>
                                    <td bgcolor="#FFFFFF">完整版报告</td>
                                    <td bgcolor="#FFFFFF"><span id="offlineNormailDeliveryDays"></span>个工作日</td>
                                    <td bgcolor="#FFFFFF"><span id="countryName1"></span></td>
                                    <td bgcolor="#FFFFFF"><a href="<%=basePath%>upload/demo/全球鹰样本报告.pdf">查看</a></td>
                                    <td bgcolor="#FFFFFF">一个PDF完整版报告</td>
                                </tr>
                                <tr>
                                    <td bgcolor="#FFFFFF">
                                        <input name="choose" type="radio" value="ex"
                                               id="exCheckBox"></td>
                                    <td bgcolor="#FFFFFF">
                                        <strong>
                                            CNY <span
                                                id="exchoosePrice">${countryInfo.getOfflineExpressDeliveryCnyPrice()}</span>
                                            <input id="exchoosePriceHidden" type="hidden" name="offlineExpressPrice"
                                                   value="${countryInfo.getOfflineExpressDeliveryCnyPrice()}">
                                            <input id=offlineExpressDeliveryDaysHidden" type="hidden"
                                                   name="offlineExpressDeliveryDays"
                                                   value="${countryInfo.getOfflineExpressDeliveryDays()}">


                                        </strong></td>
                                    <td bgcolor="#FFFFFF">完整版报告-加急</td>
                                    <td bgcolor="#FFFFFF"><span id="offlineExpressDeliveryDays"></span>个工作日</td>
                                    <td bgcolor="#FFFFFF"><span id="countryName2"></span></td>
                                    <td bgcolor="#FFFFFF"><a href="<%=basePath%>upload/demo/全球鹰样本报告.pdf">查看</a></td>
                                    <td bgcolor="#FFFFFF">一个PDF完整版报告</td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                                </tbody>
                            </table>


                        </div>


                        <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label title">信息备注：</label>

                            <div class="col-lg-7">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
                            </div>
                        </div>
                        <!-- 							<div class="form-group">
                            <label  class="col-lg-2 control-label">其他信息地址:</label>
                            <label
                                style="padding-top: 7px; padding-left: 15px; color: #5a7fa1">2015-10-13</label>
                <div class="checkbox"></div>
                        </div> -->
                        <!-- 							<div class="form-group">
                                                        <label class="col-lg-2 control-label">选择报告类型:</label>
                                                        <div class="col-lg-10">
                                                            <div class="radio">
                                                                <label> <input name="optionsRadios"
                                                                    id="optionsRadios1" value="option1" checked="checked"
                                                                    type="radio"> ¥ 1699.00
                                                                </label> <label style="padding-left: 14px; padding-right: 10px">
                                                                    完整版报告 （10个工作日 英文） <a href="#">查看报告样本</a>
                                                                </label>

                                                            </div>
                                                        </div>
                                                    </div> -->

                        <!-- 							<div class="form-group">
                                                        <label for="textArea" class="col-lg-2 control-label">信息备注：</label>

                                                        <div class="col-lg-10">
                                                            <textarea class="form-control" rows="3" id="textArea"></textarea>
                                                        </div>
                                                    </div> -->

                        <div class="form-group">
                            <label class="col-lg-2 control-label">法律及条款：</label><label
                                style="padding-top: 7px; padding-left: 15px; padding-right: 10px">
                            <input type="checkbox" id="clause"> <a onclick="statement()">解释商安信所有条款及所有法律义务</a>
                        </label>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <input type="submit" class="btn btn-danger" value="加入购物车"
                                <c:if test="${sessionScope.customerInfo.levelId ==3}">
                                       disabled
                                </c:if>
                                >
                                <input type="button" class="btn btn-primary" value="马上支付" onclick="payFo();">

                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="col-lg-4 col-lg-offset-1"></div>
    </div>

</div>

<jsp:include page="${basePath}../include/bottomCommon.jsp"/>


</body>
</html>