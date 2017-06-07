<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="${basePath}../include/include.jsp"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Full Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <style>
        .navbar-holder-dark {
            padding: 20px 20px 200px 20px;
            background: #333333;
        }
    </style>
    <script type="text/javascript">
        function payfor(orderId) {

            var orderChoose = $('#methodId').val();
            if (orderChoose == null || orderChoose == "") {
                BootstrapDialog.alert("Please select the payment method");
                return false;
            }
            if($("#xxl-check").is(':checked')) {
                confirmEmail(orderId);
            }else {
                BootstrapDialog.alert("Please agree to permit");
            }

        }

        function clickhelp(){
            BootstrapDialog.alert("If you need assistance, please contact us at +8621-36386226, or email us at support@cnbizsearch.com. We will reply to you within 24 hours.")
        }

        function chooseMethod(img, id) {
            $("img[name='payMethod']").each(function (i, n) {
                $(this).css("border", "1px solid #ddd");
            });
            $(img).css("border", "1px solid #1a9fde");
            $('#methodId').val(id);
            $("#payConfirm").removeClass("disabled");
        }
        function downloadChina(id,orderId){
            window.open(basePath+'/customer/openReport.do?orderDetailId='+id+'&orderId='+orderId);
        }


        function confirmEmail(orderId) {
            var amountId=$("#amountId").text();
            var orderChoose = $('#methodId').val();
            if (orderChoose == 2) {
                var balance = $("#balanceMessage").text();
                if(parseFloat(balance) < parseFloat(amountId)){
                    BootstrapDialog.alert("Your account balance is insufficient");
                    dialog.close();
                } else {
                    window.location.href = "${pageContext.request.contextPath}/customer/balancePayment.do?orderId=" + orderId;
                }
            }else {
                if (amountId=="19.00"){
                    $("#productAmount").val("a");
                }else if (amountId=="69.00"){
                    $("#productAmount").val("b");
                }else {
                    $("#productAmount").val("c");
                }
                $("#formPaypal").submit();
            };
//           BootstrapDialog.show({
//                title: 'Confirm',
//                message: "Please confirm the order information.",
//                buttons: [{
//                    label: 'submit',
//                   action: function (dialog) {
//
//                   }
//                },{
//                    label: 'cancel',
//                    action: function (dialog) {
//                        dialog.close();
//                    }
//                }]
//            });
        }
        $(function(){
            $(".fxq-how").click(function(){
                $(".fxq-how-alert").show()
            })
            $(".fxq-close").click(function(){
                $(".fxq-how-alert").hide()
            })
        })
    </script>

</head>
<body>
<jsp:include page="../include/top.jsp"/>



<div class="fxq-how-alert">
    <h5>How to pay?</h5>
    <p style="border-top: 1px solid #eee;padding-top: 10px;margin-bottom: 20px;">
        Currently, you can pay using PayPal. More payment options will be available on cnBIZsearch in the near future.
    </p>
    <h5>How to recharge?</h5>
    <p  style="border-top: 1px solid #eee;padding-top: 10px;margin-bottom: 20px;">
        You can call the phone number 4007 729 029 to recharge and get more discounts.
    </p>
    <table>
        <tr>
            <td align="right" width="50%" style="padding-right: 15px;">
                <a href="#">Send to Mailbox:email address</a>
            </td>
            <td align="left" width="50%" style="padding-left: 15px;">
                <button class="fxq-close">Close</button>
            </td>
        </tr>
    </table>
</div>

<div id="banner">
    <div class="container">
        <div class="row">
            <p style="float: right;margin-left: -15px;cursor: pointer;" onclick="clickhelp()">If you need assistance, please contact us.</p>
        </div>

        <div class="row">
            <div class="well bs-component">
                <div class="row" style="padding:0 40px;">
                <div class="row">
                    <%--历史订单对比  差价计算--%>
                        <ul style="overflow: hidden;">
                            <li style="float: left;font-size: 18px;"> Order Details</li>
                            <li style="float: right;text-decoration: underline;cursor: pointer;" class="fxq-pay-view">View previous orders on the subject</li>
                        </ul>
                    <table class="table table-striped table-responsive" style="border-bottom: 1px solid #ddd;">
                        <tr>
                            <th>Subject Name</th>
                            <th>Order Type</th>
                            <th>Delivery Time</th>
                            <th>Price</th>
                            <th>Discount<i class="fa fa-question-circle fxq-q-click" style="cursor: pointer;margin-left: 5px;"></i></th>
                            <th>Amount(USD)</th>
                        </tr>
                        <tr>
                            <td class="fxq-basic-hover" style="position: relative;cursor: pointer;">
                                ${orderDetail.companyName}
                                <div class="fxq-basic">
                                    <div class="fxq-basic-sjx1"></div>
                                    <div class="fxq-basic-sjx2"></div>
                                    <table>
                                        <tr>
                                            <td><strong style="display: inline-block;width: 160px;">Chinese Name</strong></td>
                                            <td>${companyBasicInfo.companyName}</td>
                                        </tr>
                                        <tr>
                                            <td ><strong>Reg ID</strong></td>
                                            <td>${companyBasicInfo.registrationId}</td>
                                        </tr>
                                        <tr>
                                            <td ><strong>Location</strong></td>
                                            <td>${companyBasicInfo.localEn}</td>
                                        </tr>
                                        <tr>
                                            <td ><strong>Website</strong></td>
                                            <td>${companyBasicInfo.url}</td>
                                        </tr>
                                        <tr>
                                            <td  style="padding-right: 8px;"><strong>Headquater Address</strong></td>
                                            <td>${companyBasicInfo.mainAddressEn}</td>
                                        </tr>


                                    </table>
                                </div>
                            </td>
                            <td>${orderDetail.productName}</td>
                            <td>${orderDetail.expectHour} hour</td>
                            <td style="text-decoration: line-through;color: #af0a18;">${order.getAmount()}</td>
                            <td style="color: #64a51d;">${order.getAmount()-order.getAmountActual()}</td>
                            <td>${order.getAmountActual()}</td>
                        </tr>
                        <tr>
                            <td colspan="5" style="font-size: 18px;color: #af0a18;padding-right: 80px;" align="right">Total:</td>
                            <td  style="font-size: 18px;font-weight: bold;" id="amountId">${order.getAmountActual()}</td>
                        </tr>
                    </table>

                        <c:if test="${not empty orderDetailView}">
                            <table class="table table-striped table-responsive fxq-pay-table">
                                <tr>
                                    <th>Subject Name</th>
                                    <th>Order Type</th>
                                    <th>Order Date</th>
                                    <th>Price</th>
                                    <th>Operation</th>
                                </tr>
                                <% int i=0;
                                %>
                                <c:forEach var="list" items="${orderDetailView}" begin="0" end="4">
                                    <tr>
                                        <td style="min-width: 360px;_width: 360px;">${list.companyName}</td>
                                        <td>${list.productName}</td>
                                        <td><fmt:formatDate value="${list.createTime}"></fmt:formatDate></td>
                                        <td>${list.amountActual}</td>
                                        <td><button type="button" class="btn btn-success fxq-btn-success fxq-time" onclick="downloadChina(${list.id},${list.orderId})">View This Report</button></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                        <c:if test="${empty orderDetailView}">
                            <table class="table table-striped table-responsive fxq-pay-table">
                                <tr>
                                    <th>Subject Name</th>
                                    <th>Order Type</th>
                                    <th>Order Date</th>
                                    <th>Price</th>
                                    <th>Operation</th>
                                </tr>
                                <tr>
                                    <td>-</td>
                                    <td>-</td>
                                    <td>-</td>
                                    <td>-</td>
                                    <td>-</td>
                                </tr>
                            </table>
                        </c:if>



                </div>


                <div class="row fxq-row" style="margin-top: 10px;">

                    <input type="hidden" id="methodId" name="methodId" class="form-control" placeholder="支付方式" required
                           autofocus>
                    <legend style="margin: 0;margin-bottom:20px;padding: 0 0 10px;">Please choose payment method</legend>
                    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12 pull-left" style="width:100%;padding-left:0">
                        <img id="img2" name="payMethod" alt="账户余额" onclick="chooseMethod(this,2);" class="img-thumbnail"
                             style="width: auto; height: 120px;" src="<%=basePath%>images/payfor/ps_fullsearch.png">
                        <%--<form id="formPaypal" action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top" style="display: inline-block;">--%>
                            <%--<input type="hidden" name="cmd" value="_s-xclick">--%>
                            <%--<input type="hidden" name="hosted_button_id" value="XASZGUTAUV55Q">--%>
                            <img id="img3" name="payMethod" alt="PayPal" onclick="chooseMethod(this,1);" class="img-thumbnail"
                                 style="width: auto; height: 120px;margin-left: 15px;" src="<%=basePath%>images/payfor/ps_paypal.png">
                        <%--</form>--%>

                        <form  id="formPaypal" action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_blank" hidden  >
                            <input type="hidden" name="cmd" value="_s-xclick">

                            <%--<input type="hidden" name="hosted_button_id" value="DLTDZDJJ5NLMJ">--%>

                            <input type="hidden" name="hosted_button_id" value="CZC8HZN776Q22">

                            <%--<input type="hidden" name="on0" value="测试">--%>
                            <input id="productAmount" type="hidden" name="os0">


                        </form>


                        <br><br>
                        Account balance：<lable id="balanceMessage">${balance}</lable>

                    </div>

                        <div class="fxq-how">How to Pay？How to Recharge？</div>
                        <br>
                        <%--<div class="col-lg-2 col-md-3 col-sm-6 col-xs-12 pull-left">--%>
                            <%--<img id="img1" name="payMethod" alt="支付宝" onclick="chooseMethod(this,1);" class="img-thumbnail"--%>
                                 <%--style="width: 450px; height: 120px;" src="<%=basePath%>images/payfor/ps_paypal.png">--%>
                        <%--</div>--%>

                        <div>
                            <input id="xxl-check" type="checkbox"  style="margin-right: 10px;">
                            <div style="display: inline-block;width: 840px;vertical-align: top;">
                                I have legitimate reason to conduct a lawful investigation of the credit worthiness of the subject company. We certify that we have read and accept all the Terms and Conditions of cnBIZsearch.com.
                            </div>
                            <br>
                            <button id="payConfirm" class="btn btn-warming btn-danger fxq-pay-hover disabled"
                                    style=" background:#1ABC9C;width:160px;height: 50px;float: right;margin-top: -40px;margin-right: 15px;" onclick="payfor(${order.getId()})">Submit
                            </button>
                        </div>

                    </div>


                <hr/>
                <p style="margin-left: -15px">
                    If you need assistance, please contact us at +8621-36386226, or email us at support@cnbizsearch.com.
                    We will reply to you within 24 hours.
                </p>

                <%--<div class="row" style="padding: 20px 0">--%>

                    <%--<div class="col-lg-12 text-center">--%>
                        <%--<button id="payConfirm" class="btn btn-warming btn-danger disabled"--%>
                                <%--style=" width:160px;height: 50px" onclick="payfor(${order.getId()})">Determine payment--%>
                        <%--</button>--%>
                    <%--</div>--%>
                <%--</div>--%>

            </div>
        </div>
    </div>
</div>
<br><br>
<jsp:include page="../include/bottom.jsp"/>


<script>
    $(document).ready(function () {

        $('.navbar .dropdown, .dropdown-submenu').hover(function () {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
            //$(this).find('.dropdown-menu').show().removeClass('flipOutY').addClass('animated flipInY');
            //$(this).find('.dropdown-menu').show().removeClass('bounceOut').addClass('animated bounceIn');
            //$(this).find('.dropdown-menu').first().show();


        }, function () {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(100).slideUp();
            //$(this).find('.dropdown-menu').removeClass('flipInY').addClass('animated flipOutY').fadeOut();
            //$(this).find('.dropdown-menu').removeClass('bounceIn').addClass('animated bounceOut').fadeOut();
            //$(this).find('.dropdown-menu').first().hide();

        });

        $('#featureCarousel').carousel({
            interval: 4000
        });

        var clickEvent = false;
        $('#featureCarousel').on('click', '.nav a', function () {
            clickEvent = true;
            $('.nav li').removeClass('active');
            $(this).parent().addClass('active');
        }).on('slid.bs.carousel', function (e) {
            if (!clickEvent) {
                var count = $('#featureCarousel .nav').children().length - 1;
                var current = $('#featureCarousel .nav li.active');
                current.removeClass('active').next().addClass('active');
                var id = parseInt(current.data('slide-to'));

                if (count == id) {
                    $('#featureCarousel .nav li').first().addClass('active');
                }
            }
            clickEvent = false;
        });



        var f1=1;
        $(".fxq-pay-view").click(function(){
            if(f1==1){
                $(".fxq-pay-table").slideDown("fast");
                f1=2;
            }else{
                f1=1;
                $(".fxq-pay-table").slideUp("fast");
            }
        });

        $(".fxq-q-click").click(function(){
            $(".fxq-pay-table").slideDown();
            f1=2;
        })
    });
</script>

</body>
</html>