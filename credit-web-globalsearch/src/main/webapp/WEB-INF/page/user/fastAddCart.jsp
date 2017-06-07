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
    <title>Full search - Quick order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>/js/user/fastAddCart.js"></script>
    <link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/fileinput.css">
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/fileinput.js"></script>
    <%--<script type="text/javascript" src="<%=basePath%>frame/bootstrap/localization/fileinput/zh.js"></script>--%>
    <script type="text/javascript" src="<%=basePath%>js/ajaxfileupload.js"></script>
    <script type="text/javascript">
        function payFo() {
            if (!checkForm()) {
                return;
            }
            if ($("#clause").is(':checked')) {

            }else {
                BootstrapDialog.alert("Please receive legal provisions");
                return;
            }
            if ("${sessionScope.customerInfo.levelId}" == 3) {
                BootstrapDialog.show({
                    title: 'acknowledgement of order',
                    message: "Confirm whether to subscribe to this report",
                    buttons: [{
                        label: 'Determine',
                        action: function () {
                            document.forms.from.action = "<%=basePath%>customer/addOrderFromFast.do";
                            document.forms.from.submit();
                        }
                    }, {
                        label: 'cancel',
                        action: function (dialog) {
                            dialog.close();
                            return;
                        }
                    }]
                });
            } else {
                document.forms.from.action = "<%=basePath%>customer/addOrderFromFast.do";
                document.forms.from.submit();
            }
        }
    </script>
</head>
<body>
<jsp:include page="${basePath}../include/top.jsp"/>
<div id="banner">
    <div class="container">
        <div class="row">
            <div class="well bs-component">
                <fieldset>
                    <legend>Credit report product description information</legend>
                    <div class="form-group">
                        <div class="col-lg-12">
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;The enterprise credit report is a professional report which collects the credit information of the enterprise under investigation, and objectively reflects the credit status of the enterprise under investigation.<br>
                                &nbsp;&nbsp;&nbsp;&nbsp;The enterprise credit report covers the basic information of the enterprise, the legal registration information, the ownership structure, the industrial and commercial change information, the historical background, the enterprise related information, the management present situation, the financial information, the judicial information and so on. Credit reports collected by the investigation and analysis of enterprise information, make corresponding financial profitability and solvency of the enterprise under investigation and judgment, credit risk rating, comprehensive, intuitive, real-time to reflect the surveyed company's credit status, for the customer to determine the credit status of enterprises surveyed to provide reference, to help customers quickly identify quality business partners to avoid the potential risk of the commercial.
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
                        <legend>Ordering Information</legend>
                        <div class="form-group">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">*Target Corp name：</label>
                                    <div class="col-lg-10" style="width: 400px">
                                        <input class="form-control" id="company_name"
                                               name="companyName" type="text" value="">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">*Target Corp Address：</label>
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
                                    <label class="col-lg-2 control-label" style="width: 165px">*Target Corp Phone：</label>

                                    <div class="col-lg-10" style="width: 400px">
                                        <input class="form-control" id="company_phone"
                                               name="companyPhone" type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="col-lg-2 control-label" style="width: 165px">Target Corp Website：</label>
                                    <div class="col-lg-10" style="width: 400px">
                                        <input class="form-control" id="company_website" name="companyWebsite"
                                               type="text">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group pull-left" style="padding-left:40px">
                            <label class="col-md-12 control-label">
                                Please fill in any other information you know about the company under investigation:</label>
                        </div>
                        <div class="col-lg-12" style="padding-left:35px">
                            <textarea id="txtOther" class="form-control" rows="3" name="remark"></textarea>
                        </div>


                        <legend>&nbsp;</legend>


                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-lg-12 control-label" style="width: 165px">Upload Picture:</label>
                                    <div style="padding-top: 7px;">
                                        <input id="cbUploadPic" type="checkbox" onclick="cbUploadPicClick();">
                                        <strong>If you can not enter Target Corp information, please choose to upload pictures</strong>
                                    </div>
                                </div>
                            </div>
                            <div id="uploadPic" class="col-md-offset-1 col-md-4">
                                <div class="form-group">
                                    <input id="uploadPicPath" name="imgUrl" class="form-control" type="hidden">
                                    <input id="file" type="file" name="file" class="file"
                                           data-allowed-file-extensions='["gif","jpg","png"]'>
                                </div>
                            </div>
                        </div>


                        <legend></legend>

                        <div>
                            <table class="table table-striped table-responsive">
                                <thead>
                                <tr>
                                    <th width="8%">Choice</th>
                                    <th width="12%">Price</th>
                                    <th width="15%">Report Type</th>
                                    <th width="10%">Making Time</th>
                                    <th width="21%">Service Content</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:if test="${products.getResult()}">
                                    <c:forEach var="product" items="${products.getRows()}" varStatus="status">
                                        <tr>
                                            <td>
                                                <input name="optionsRadios" value="${product.getId()}" checked type="radio">
                                            </td>
                                            <td>
                                                <strong> ${product.getCurrency()}${product.getPrice()}&nbsp;&nbsp;
                                                </strong>
                                            </td>
                                            <td>
                                                <strong>
                                                    <span class="hidden-xs label-lg">${product.getName()}</span>
                                                </strong>
                                            </td>
                                            <td>
                                                <c:if test="${product.getExpectHour()=='0'}">Instant</c:if>
                                                <c:if test="${product.getExpectHour()!='0'}">${product.getExpectHour()}&nbsp;Hours</c:if>
                                            </td>
                                            <td>
                                                <strong>
                                                    <span class="hidden-xs label-lg">${product.getDesc()}</span>
                                                </strong>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <tr>
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
                            <label for="textArea" class="col-lg-2 control-label title">Information Note：</label>

                            <div class="col-lg-7">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">Law and Provisions：</label><label
                                style="padding-top: 7px; padding-left: 15px; padding-right: 10px">
                            <input type="checkbox" id="clause"> <a onclick="statement()">I have read the disclaimer and agree to abide by all the terms and obligations</a>
                        </label>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <input type="button" class="btn btn-primary" value="Submit" onclick="payFo();">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="col-lg-4 col-lg-offset-1"></div>
    </div>

</div>

<jsp:include page="${basePath}../include/bottom.jsp"/>

</body>
</html>