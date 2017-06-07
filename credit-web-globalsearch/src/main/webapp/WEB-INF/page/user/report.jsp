<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../include/include.jsp"/>
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
        function addOrder() {
            var productId = $("input[name='optionsRadios']:checked").val();
            if(productId == undefined || "" == productId || null == productId) {
                BootstrapDialog.alert("You have already purchased this product");
            }else{
                $("#addOrderSubmit").submit();
            }
        }
        function tishi() {
            BootstrapDialog.alert("Please order this product");
        }
        $(function () {
            var str = $('#statusID').text();
            if (str == 0) {
                $('#statusID').text("Cancel");
            } else if (str == 1) {
                $('#statusID').text("No Payment");
            } else if (str == 2) {
                $('#statusID').text("Under Investigation");
            } else if (str == 3) {
                $('#statusID').text("To Be Assigned");
            } else if (str == 4) {
                $('#statusID').text("InDevelopment");
            } else if (str == 5) {
                $('#statusID').text("Check Pending");
            } else if (str == 6) {
                $('#statusID').text("In Review");
            } else if (str == 7) {
                $('#statusID').text("To Be Released");
            } else if (str == 8) {
                $('#statusID').text("Achieve");
            };
            var cid=$("#cid").val();
            var cname=$("#cname").val();
            var collectionCompany=$("#collectionCompany").val();
            if(cid==undefined||cid==null||cid==""){
                $("#fa-star").hide();
            }else{
                $("#fa-star").show();
                if(collectionCompany==cname){
                    $("#fa-star i").addClass("fxq-star");
                }
            }
        });
        function fastar() {
           var senddata = {
               "customerId":$("#cid").val(),
               "collectionCompany":$("#cname").val()
            };
           BootstrapDialog.show({
               title: 'Collection',
               message: "Are you sure?",
               buttons: [{
                    label: 'submit',
                    action: function (dialog) {
                       if($("#fa-star i").hasClass("fxq-star")){
                            $.ajax({
                               type: "POST",
                                url: basePath + "customer/delCollection.do",
                                dataType: "json",
                               contentType: "application/json",
                               data: JSON.stringify(senddata),
                               success: function (data) {
                                    BootstrapDialog.alert("Cancel the collection success");
                                    dialog.close();
                                   $("#fa-star i").removeClass("fxq-star");
                               }
                            });
                       }else{
                          $.ajax({
                               type: "POST",
                               url: basePath + "customer/collectionSave.do",
                              dataType: "json",
                               contentType: "application/json",
                               data: JSON.stringify(senddata),
                               success: function (data) {
                                  BootstrapDialog.alert("Collection of success");
                                   dialog.close();
                                    $("#fa-star i").addClass("fxq-star");
                                }
                          });
                       }
                    }
               }, {
                    label: 'cancel',
                   action: function (dialog) {
                        dialog.close();
                    }
               }]
           });
        };
    $(function(){
        $(".fxq-pack-up").click(function(){
            $(".fxq-pack-con").slideUp();
            $(".fxq-drop-down").css("display","block");
        })
        $(".fxq-drop-down").click(function(){
            $(".fxq-drop-down").css("display","none");
            $(".fxq-pack-con").slideDown();
        })

    });
    var companyName="${companyName}";
    var province="${province.getProvinceEN()}";
    var city="${city.getCityEN()}";
        function creditAdditional2() {
            window.open(basePath + "customer/toIndexAddition2.do?companyName="+companyName+"&province="+province+"&city="+city);
        }
        function creditAdditional3() {
            window.open(basePath + "customer/toIndexAddition3.do?companyName="+companyName);
        }
        function creditAdditional4() {
            window.open(basePath + "customer/toIndexAddition4.do?companyName="+companyName);
        }
        function creditAdditional5() {
            window.open(basePath + "customer/toIndexAddition5.do?companyName="+companyName+"&province="+province+"&city="+city);
        }
        function creditAdditional6() {
            window.open(basePath + "customer/toIndexAddition6.do?companyName="+companyName);
        }
    </script>


</head>
<body>
<jsp:include page="../include/top.jsp"/>


<div class="container" style="margin-top:40px">
    <div class="bs-docs-section">
        <%--<div class="row">--%>
            <%--<div class="col-lg-12">--%>
                <%--<div class="page-header">--%>
                    <%--<h1 id="fslider"></h1>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <form id="addOrderSubmit" action="<%=basePath%>customer/addOrder.do" method="post">
            <input id="cname" name="companyName" value="${companyName}" type="hidden">
            <input name="crefoNo" value="${crefoNo}" type="hidden">
            <input name="companyNameCN" value="${companyNameCN}" type="hidden">
            <input id="cid" name="customerId" value="${customerId}" type="hidden">
            <input id="collectionCompany" name="collectionCompany" value="${collectionCompany}" type="hidden">

            <div class="row">
                <div class="row">
                    <div class="col-lg-12">
                        <p class="lead" style="float: left">${companyName}</p>
                        <div style="float:right;margin:10px 30px 0 0;">
                            <span class="label ' + ${status eq 1 ? "label-success":"label-default"} + '">Active</span>&nbsp;
                            <c:if test="${not empty stockCode}">
                                <span class="label fxq-public">Public</span>&nbsp;
                            </c:if>
                            <span class="label fxq-A-set ' + ${a eq 1 ? "label-success fxq-A":"label-default"} + '">A<span class="fxq-A-full">Authentication</span></span>&nbsp;
                            <span class="label fxq-V-set ' + ${v eq 1 ? "label-success fxq-V":"label-default"} + '">V<span class="fxq-V-full">Verification</span></span>
                        </div>
                        <div style="clear:both"></div>
                    </div>
                </div>

                <div class="col-lg-12">
                    <div class="bs-component fxq-pack-con">
                        <div class="well" style="position:relative">
                            <%--&lt;%&ndash;编号&ndash;%&gt;--%>
                            <%--<ul style="position:absolute;left:30px;top:20px ;">--%>
                                <%--<li class="badge fxq-num-1" style="display:block;margin-bottom:5px">1</li>--%>
                                <%--<li class="badge fxq-num-2" style="display:block;margin-bottom:5px">2</li>--%>
                                <%--<li class="badge fxq-num-3" style="display:block;">3</li>--%>
                            <%--</ul>--%>
                            <table width="84%" border="0" cellspacing="0" cellpadding="0" style="float: left;">
                                <tbody>
                                <!--产品选择-->
                                <c:if test="${products.getResult()==false}">
                                <div class="col-lg-3">
                                    <div class="bs-component">
                                        <p>Order Date:&nbsp;
                                            <fmt:formatDate value="${order.getCreateTime()}"/> &nbsp;&nbsp;
                                            &nbsp;</p>
                                        <small id="statusID">${order.getStatus()}</small>
                                    </div>
                                </div>
                                </c:if>
                                <c:if test="${products.getResult()}">
                                    <c:forEach var="product" items="${products.getRows()}" varStatus="status">
                                        <tr>
                                            <td width="10%" align="center">
                                                <input name="optionsRadios" id="productId" value="${product.getId()}"  type="radio" style="margin-right:15px"
                                                    <c:if test="${product.getHasOrder()!='false'}">disabled</c:if>
                                                       <c:if test="${product.getHasOrder()=='false'}">checked</c:if>
                                                >
                                            </td>
                                            <td width="15%" align="left">
                                                <strong class="diffprice"> ${product.getCurrency()}${product.getPrice()}&nbsp;&nbsp;
                                                </strong>
                                            </td>
                                            <td width="20%" align="left">
                                                <strong>
                                                    <span class="hidden-xs label-lg">${product.getName()}</span>
                                                </strong>
                                            </td>
                                            <%--等级标记--%>
                                            <td width="37%" align="left">
                                                <strong>
                                                    <span class="hidden-xs label-lg">${product.getDesc()}
                                                    </span>
                                                </strong>
                                            </td>
                                            <td width="18%">
                                                <c:if test="${product.getExpectHour()=='0'}">Instant</c:if>
                                                <c:if test="${product.getExpectHour()!='0'}">${product.getExpectHour()}&nbsp;Hours</c:if>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty products.getResult()}">
                                    You have already ordered this product
                                </c:if>
                                </tbody>
                            </table>
                            <div style="width: 16%;float:right">
                                <button type="button" class="btn btn-success" onclick="addOrder()">
                                    Order This Company
                                </button>
                                <div style="float:right;margin-right:15px">
                                    <button type="button" class="fxq-pack-up">
                                        Hide This Bar<span style="font-size: 20px;text-decoration: none">↑</span>
                                    </button>
                                </div>
                            </div>
                            <div style="clear:both"></div>
                        </div>
                    </div>
                    <div class="fxq-drop-down">How to get this information?
                        <span style="font-size: 16px;text-decoration: none">↓</span>
                    </div>
                </div>


            </div>
        </form>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid" style="padding: 0;">
                <div class="navbar-header">
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2" style="padding: 0;">
                    <%--新增功能键--%>
                    <form class="navbar-form navbar-right" role="search" style="float:left!important;">
                        <div class="form-group">
                            <button type="button" class="fxq-new-but" onclick="creditAdditional2()" style="font-size: 12px">Field Verification</button>
                            <button type="button" class="fxq-new-but" onclick="creditAdditional3()" style="font-size: 12px"> Legal Services</button>
                            <button type="button" class="fxq-new-but" onclick="creditAdditional4()" style="font-size: 12px"> Due Diligence</button>
                            <button type="button" class="fxq-new-but" onclick="creditAdditional5()" style="font-size: 12px"> Debt Collection</button>
                            <button type="button" class="fxq-new-but" onclick="creditAdditional6()" style="font-size: 12px"> Industry Analysis</button>
                        </div>
                    </form>
                    <ul class="nav navbar-nav" style="float: right;">
                        <%--<li style="height: 100%;">--%>
                            <%--<button id="money" style="background: #fff;color: #008dd9;font-weight: bold;width: 20px;height: 20px;margin:15px 15px 0 0;-webkit-border-radius:50% ;-moz-border-radius: 50%;border-radius: 50%;">￥</button>--%>
                        <%--</li>--%>
                        <li>
                            <a href="#" class="fxq-nav-hover" onclick="tishi();">
                                <i class="fa fa-arrow-down"></i>
                                <div class="fxq-s-t">
                                    Download
                                    <div class="fxq-s-sjx"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="fxq-nav-hover"  onclick="tishi();" >
                                <i class="fa fa-share"></i>
                                <div class="fxq-s-t">
                                    Share
                                    <div class="fxq-s-sjx"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#"  class="fxq-nav-hover" onclick="tishi();">
                                <i class="fa fa-question-circle"></i>
                                <div class="fxq-s-t">
                                    Suggestion
                                    <div class="fxq-s-sjx"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#" id="fa-star" class="fxq-nav-hover" onclick="fastar()">
                                <i class="fa fa-star"></i>
                                <div class="fxq-s-t">
                                    Favorite
                                    <div class="fxq-s-sjx"></div>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="row" style="min-height:300px">
            <div class="col-lg-12">

                <div class="smart-body">

                    <ul class="nav nav-tabs default bordered">
                        <li class="active">
                            <a href="#Background" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-home"></i></span>
                                <span class="hidden-xs">Background</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Location" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-man"></i></span>
                                <span class="hidden-xs">Location</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Registration" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-man"></i></span>
                                <span class="hidden-xs">Registration
                                  <span class="badge">1</span>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#History" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-man"></i></span>
                                <span class="hidden-xs">History                                  <span class="badge">1</span>

                                </span>
                            </a>
                        </li>

                        <li>
                            <a href="#Related" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-man"></i></span>
                                <span class="hidden-xs">Related</span> <span class="badge">1</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Public_record" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-email"></i></span>
                                <span class="hidden-xs">Public Record</span> <span class="badge">2</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Performance" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-email"></i></span>
                                <span class="hidden-xs">Performance</span> <span class="badge">2</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Business" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-settings2"></i></span>
                                <span class="hidden-xs">Business</span> <span class="badge">3</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Credit_rating" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-settings2"></i></span>
                                <span class="hidden-xs">Credit Rating</span> <span class="badge">3</span>
                            </a>
                        </li>
                    </ul>


                    <div class="tab-content">
                        <jsp:include page="report/background.jsp"/>
                        <jsp:include page="report/location.jsp"/>
                        <jsp:include page="report/registration.jsp"/>
                        <jsp:include page="report/history.jsp"/>
                        <jsp:include page="report/management.jsp"/>
                        <jsp:include page="report/related.jsp"/>
                        <jsp:include page="report/performance.jsp"/>
                        <jsp:include page="report/publicRecord.jsp"/>
                        <jsp:include page="report/business.jsp"/>
                        <jsp:include page="report/creditRating.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${not empty cn}">
    <div style="padding: 5px 10px;border:1px solid #eee;margin-top: 10px;border-radius:4px;-webkit-border-radius:4px;-moz-border-radius:4px;-ms-border-radius:4px;">
        <div style="display: inline-block;vertical-align: top;margin-right: 10px;">Similar Companies you may find interested in:</div>
        <div style="display: inline-block;">
        <c:forEach items="${cn}" begin="0" end="2" var="list">
            <a href="/user/reportChoose.do?crefoNo=${list.crefoNo}&companyName=${list.nameEN}&companyNameCN=${list.nameCN}&status=${list.status}&stockCode=${list.stockCode}&a=${list.a}&v=${list.v}&reg=${list.reg}&typeId=${typeId}&cnId=${cnId}">
            ${list.nameEN}</a><br>
        </c:forEach>
        </div>
    </div>
    </c:if>
</div>
<br>
<br>


<jsp:include page="${basePath}../include/bottom.jsp"/>


</div>


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

    });
</script>

</body>
</html>