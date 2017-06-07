<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>全球鹰-支付选择</title>
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/frame/jquery.qrcode.min.js"></script>
    <script type="text/javascript">
        function payfor(orderId) {
            var orderChoose = $('#methodId').val();
            if (orderChoose == null || orderChoose == "") {
                BootstrapDialog.alert("请选择支付方式");
                return false;
            }
            confirmEmail(orderId);
        }
        function chooseMethod(img, id) {
            $("img[name='payMethod']").each(function (i, n) {
                $(this).css("border", "1px solid #ddd");
            });
            $(img).css("border", "1px solid #1a9fde");
            $('#methodId').val(id);
            $("#payConfirm").removeClass("disabled");
        }

        function confirmEmail(orderId) {
            BootstrapDialog.show({
                title: '支付确认',
                message: "是否确定支付该订单",
                buttons: [{
                    label: '提交',
                    action: function (dialog) {
                        //余额 0 支付宝 1 微信2
                        var orderChoose = $('#methodId').val();
                        if (orderChoose == 1) {
                            window.open("${pageContext.request.contextPath}/customer/aliPayment.do?id=" + orderId);
                            //开始不间断向后台查询支付结果
                            checkHasPay(orderId);
                        } else if (orderChoose == 2) {
                            dialog.close();
                            $.post(basePath + "/customer/wxPayment.do",
                                {
                                    "orderId": orderId
                                },
                                function (data) {
                                    if (data == null || data == undefined || data == '') {
                                        BootstrapDialog.alert("微信支付二维码获取失败，请稍后再试！");
                                    } else {
                                        $('#qrcode').empty();
                                        $('#qrcode').qrcode(data);
                                        $("#weixinPayModal").modal("show");
                                        //开始不间断向后台查询支付结果
                                        checkHasPay(orderId);
                                    }
                                });
                        } else {
                            window.location.href = "${pageContext.request.contextPath}/customer/balancePayment.do?orderId=" + orderId;
                        }
                    }
                }, {
                    label: '退出',
                    action: function (dialog) {
                        dialog.close();
                    }
                }]
            });
        }

        function checkHasPay(orderId) {
            $.post(
                basePath + "/customer/checkHasPay.do",
                {
                    id: orderId
                },
                function (data) {
                    if (data == null || data == undefined || data == '') {
                        //支付完成，跳转页面
                        window.location.href = basePath + "/customer/hasPay.do?id=" + orderId;
                    } else {
                        //未支付完成，继续
                        window.setTimeout(function () {
                            checkHasPay(orderId);
                        }, 3000);
                    }
                }
            )
        }
    </script>
</head>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<br>
<div id="banner">
    <div class="container">


        <div class="row">
            <div class="well bs-component">
                <legend>选择订购方式</legend>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="bs-component">
                            <blockquote>
                                <c:if test="${not empty order}">
                                    <p>
                                        订单价格总额：
                                        <strong>
                                            CNY ${order.getAmount()}0 </strong> 报告数量:
                                        <strong>
                                                ${order.getDetailCount()}</strong>
                                        </strong>
                                    </p>
                                </c:if>
                            </blockquote>
                        </div>
                    </div>


                </div>


                <div class="row" style="margin-top: 10px;">
                    <input type="hidden" id="methodId" name="methodId" class="form-control" placeholder="支付方式" required
                           autofocus>
                    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12 pull-left">
                        <img id="img2" name="payMethod" alt="账户余额" onclick="chooseMethod(this,0);" class="img-thumbnail"
                             style="width: 450px; height: 120px;" src="<%=basePath%>images/payfor/ps_account.png">

                    </div>
                    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12 pull-left">
                        <img id="img1" name="payMethod" alt="支付宝" onclick="chooseMethod(this,1);" class="img-thumbnail"
                             style="width: 450px; height: 120px;" src="<%=basePath%>images/payfor/ps_alipay.png">
                    </div>
                    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12 pull-left">
                        <img id="img3" name="payMethod" alt="微信支付" onclick="chooseMethod(this,2);" class="img-thumbnail"
                             style="width: 450px; height: 120px;" src="<%=basePath%>images/payfor/ps_weixin.png">
                    </div>
                    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12 pull-left">&nbsp;</div>
                    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12 pull-left">&nbsp;</div>
                    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12 pull-left">&nbsp;</div>
                </div>
                <div style="padding:15px 0 0 10px">
                    帐户余额：${balance}
                </div>
                <hr/>
                <div class="row" style="padding: 20px 0">
                    <div class="col-lg-12 text-center">
                        <button id="payConfirm" class="btn btn-warming btn-danger disabled"
                                style=" width:160px;height: 50px" onclick="payfor(${order.getId()})">确定支付
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="${basePath}../include/bottomCommon.jsp"/>

    <div id="weixinPayModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="weixinPayModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="continentModalLabel">微信支付</h4>
                </div>
                <div class="modal-body text-center" style="background-color: grey">
                    <div class="row"
                         style="margin: 0 auto; width: 300px; height: 420px; background-color: white; padding-top: 15px;">
                        <div class="col-md-12 col-sm-12 col-xs-12 text-center">
                            <p style="color: red;">请在24小时内完成支付!</p>
                        </div>
                        <div class="col-md-12 col-sm-12 col-xs-12 text-center">
                            <div id="qrcode"></div>
                            <p></p>
                        </div>
                        <div class="col-md-12 col-sm-12 col-xs-12 text-center">
                            <img width="256" src="<%=basePath%>images/payfor/ps_weixin_tell.png" alt="请使用微信扫描二维码进行支付"/>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>