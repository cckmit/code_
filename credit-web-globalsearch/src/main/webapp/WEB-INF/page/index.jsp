<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="include/include.jsp"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>cnBIZsearch | China Company Infomation | China Credit Report </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <style>
        .navbar-holder-dark {
            padding: 20px 20px 200px 20px;
            background: #333333;
        }
    </style>

</head>
<body>

<jsp:include page="${basePath}include/topIndex.jsp"/>
<script type="text/javascript">
    function changeXxl() {
        var select=$("#select").val();
        if (select=='Companies'){
            $('#companyName').attr('placeholder','Enter Chinese company name or Reg ID');
        }else {
            $('#companyName').attr('placeholder','Enter Product and Service');
        }
    }
    function searchHY() {
        var data = {
            'nameEn':$("#chnName").val()
        }
        $("#nameEn").empty();
        $.ajax({
            type:"POST",
            url:basePath+"searchList.do",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(data){
                if (data.code){
                    $.each(data.result, function (i, row) {
                        $("#nameEn").append("<option value='" + row.nameEn + "'>" + row.nameEn + "</option>");
                    });
                }
            }
        });
    }
</script>

<div class="container">

    <div class="bs-docs-section">

        <div class="row" style="height:100%;">
            <div class="col-lg-12"  style="height:100%;width:100%">

                <div id="featureCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <!-- 搜索框 -->
                        <div style="z-index: 9000; height:50px; position: absolute; bottom: 50px;left: 50%;margin-left: -310px">
                            <form id="form"  action="<%=basePath%>toSearchCompanyList.do" method="post"  >
                                <table width="620px" align="center">
                                    <tr>
                                        <td width="180px">
                                            <select class="form-control input-lg fxq-index-select" id="select" name="type" style="width:120px;padding-left: 8px">
                                                <option selected="selected" value="Companies" onclick="changeXxl()">Companies</option>
                                                <option value="Products" onclick="changeXxl()">Products</option>
                                            </select>
                                        </td>
                                        <td width="440px" style="padding: 0 20px"><input class="form-control input-lg" id="companyName" name="companyName" type="text" style=" width:440px" placeholder="Enter Chinese company name or Reg ID"></td>
                                        <td width="100px"><a type="button" class="btn btn-primary btn-lg" onclick="fullSearchCompanyIndex();">Search </a></td></tr></table>
                            </form>
                        </div>
                        <div class="item active">
                            <img src="<%=basePath%>images/site/index1.jpg">
                            <div class="carousel-caption">
                                <h3>
                                    Instant search of 45,000,000+ active Chinese companies
                                </h3>
                                <p style="width: 800px;font-size: 24px;">
                                    <i>Cover 100% Chinese manufactures and service companies<br>
                                        Cover all large companies and SME's</i>
                                </p>
                            </div>
                            <div class="carousel-caption-bg">

                            </div>
                        </div>
                        <!-- End Item -->
                        <div class="item">
                            <img src="<%=basePath%>images/site/index3.jpg">
                            <div class="carousel-caption">
                                <h3 style="text-shadow: none;color: #2C3E50;">
                                    Various business information products
                                </h3>
                                <p style="width: 800px;text-shadow: none;color: #3E556A;font-size: 24px;">
                                   <i> Help you to verify your Chinese trading partners<br>
                                       Protect your trade credit effectively and efficiently</i>
                                </p>
                            </div>
                            <div class="carousel-caption-bg">

                            </div>
                        </div>
                        <!-- End Item -->
                        <div class="item">
                            <img src="<%=basePath%>images/site/index4.jpg">
                            <div class="carousel-caption">
                                <h3>
                                    Proactively monitor your business partners
                                </h3>
                                <p style="width: 800px;font-size: 24px;">
                                    <i>We help you verify the company's operational status and confirm that your contact
                                        person is authorized to make decisions or conclude contracts on behalf the company.</i>
                                </p>
                            </div>
                            <div class="carousel-caption-bg">

                            </div>
                        </div>
                        <!-- End Item -->
                        <div class="item">
                            <img src="<%=basePath%>images/site/index04.jpg">
                            <div class="carousel-caption">
                                <h3 style="text-shadow: none;color: #2C3E50;">
                                    Provide various management services around O2C
                                </h3>
                                <p style="width: 800px;text-shadow: none;color: #3E556A;font-size: 24px;">
                                    <i>Promote healthy trade<br>
                                        Improve management efficiency</i>
                                </p>
                            </div>
                            <div class="carousel-caption-bg">

                            </div>
                        </div>
                        <!-- End Item -->
                    </div>
                    <!-- End Carousel Inner -->
                    <ul class="nav nav-pills nav-justified">
                        <li data-target="#featureCarousel" data-slide-to="0" class="active" style="width: 25%;float:left;margin:0">
                            <a href="#" style="font-weight: bold;font-size: 18px;">Find Companies
                                <small style="font-weight: normal;font-size: 14px;">Pinpoint your target
                                </small>
                            </a>
                        </li>
                        <li data-target="#featureCarousel" data-slide-to="1" style="width: 25%;float:left;margin:0">
                            <a href="#" style="font-weight: bold;font-size: 18px;">Business Verification
                                <small style="font-weight: normal;font-size: 14px;">Manage internal control</small>
                            </a>
                        </li>
                        <li data-target="#featureCarousel" data-slide-to="2" style="width: 25%;float:left;margin:0">
                            <a href="#" style="font-weight: bold;font-size: 18px;">Monitoring
                                <small style="font-weight: normal;font-size: 14px;">Process risk management</small>
                            </a>
                        </li>
                        <li data-target="#featureCarousel" data-slide-to="3" style="width: 25%;float:left;margin:0">
                            <a href="#" style="font-weight: bold;font-size: 18px;">O2C Solutions
                                <small style="font-weight: normal;font-size: 14px;">Value Added Customer Service</small>
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- End Carousel -->


            </div>
        </div>
        <br>



        <div class="row">
            <div class="col-lg-12">
            </div>
        </div>
        <div class="row">
            <%--第一块 行业搜索--%>
            <div class="col-lg-4">
                <div class="bs-component">
                    <ul class="list-group">
                        <li class="list-group-item active">
                            Search by Industry

                        </li>
                        <%--行业搜索--%>
                        <li class="list-group-item" style="position: relative;padding: 6px;overflow: hidden;">
                            <input type="text" placeholder="Industry Search" class="form-control input-sm" id="chnName" name="nameEn" style="float: left;width: 49%;">

                            <select name="nameEn" id="nameEn" class="form-control fxq-new-select select-index" style="width: 49%;height: 30px;float: right;
                                    background:url('<%=basePath%>images/site/down.png') no-repeat 140px center/25px 25px #fff!important;">

                            </select>

                            <i class="fa fa-search" style="color: #898989;position: absolute;left: 150px;top: 13px;cursor: pointer;" onclick="searchHY()"></i>
                        </li>
                        <a href="${pageContext.request.contextPath}/toIndustrySearch.do">
                            <li class="list-group-item" style="height: 43px;border-bottom: 0;">
                                Search Products by Category
                                <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Belts">Belts</a>,--%>
                                <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Bicycle">Bicycle</a>,--%>
                                <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Key">Key</a>,--%>
                                <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Cables">Cables</a>--%>
                                <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Knife">Knife</a>,--%>
                                <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Coal">Coal</a>--%>
                            </li></a>
                        <a href="${pageContext.request.contextPath}/customer/toIndexAddition6.do">
                        <li class="list-group-item" style="height: 43px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
                            Industry Analysis
                            <i class="fa fa-bar-chart" style="color: #2c3e50;margin-left: 10px;"></i>
                            <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Beans">Beans</a>,--%>
                            <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Dairy">Dairy</a>,--%>
                            <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Jeans">Jeans</a>,--%>
                            <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Towel">Towel</a>,--%>
                            <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Truck">Truck</a>,--%>
                            <%--<a href="${pageContext.request.contextPath}/toSearchCompanyList.do?type=Products&companyName=Memory">Memory</a>--%>
                        </li></a>

                    </ul>

                </div>
            </div>
            <%--第二块 联系我们--%>
            <div class="col-lg-4">
                <div class="bs-component">
                    <div class="list-group">
                        <div href="#" class="list-group-item active">
                            Customer Support
                            <%--<a href="mailto:1046625003@qq.com" style="float: right;color: #fff;text-decoration: underline;">Email</a>--%>
                        </div>
                        <a href="#" class="list-group-item">
                            Tel：4007 729 029 (9:00-18:00)
                        </a>
                        <a href="#" class="list-group-item">
                            E-mail Address:info@cnbizsearch.com
                        </a>
                        <a href="<%=basePath%>help.do">
                        <div class="list-group-item" >
                            Frequently Asked Question
                        </div></a>

                    </div>

                </div>
            </div>
            <%--第三块 回馈--%>
            <div class="col-lg-4">
                <div class="bs-component">
                    <div class="list-group">
                        <a href="#" class="list-group-item" style="padding-bottom:8px;background:url('<%=basePath%>images/site/report3.png') no-repeat center/100% 100%;">
                                <h4 class="list-group-item-heading">New Credit Report Just 10's</h4>
                                <p class="list-group-item-text" style="width: 270px;height: 40px;">
                                Get the latest credit report in China only need 10 seconds.</p>

                        </a>
                        <a href="#" class="list-group-item" style="padding-bottom:8px;background:url('<%=basePath%>images/site/report2.png') no-repeat center/100% 100%;">
                            <%--<div style="width: 100%;height: 100%;position: absolute;top: 0;left: 0;z-index: 2;background-color: rgba(255,255,255,0.4);"></div>--%>
                            <h4 class="list-group-item-heading">3 Report Types</h4>
                            <p class="list-group-item-text" style="width: 270px;height: 40px;overflow:hidden;">Donec id elit non mi porta gravida at eget metus. Maecenas sed
                                diam eget risus varius blandit.</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<jsp:include page="${basePath}include/bottom.jsp"/>


<script>
    $(document).ready( function() {

        $('.navbar .dropdown, .dropdown-submenu').hover(function() {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
            //$(this).find('.dropdown-menu').show().removeClass('flipOutY').addClass('animated flipInY');
            //$(this).find('.dropdown-menu').show().removeClass('bounceOut').addClass('animated bounceIn');
            //$(this).find('.dropdown-menu').first().show();


        }, function() {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(100).slideUp();
            //$(this).find('.dropdown-menu').removeClass('flipInY').addClass('animated flipOutY').fadeOut();
            //$(this).find('.dropdown-menu').removeClass('bounceIn').addClass('animated bounceOut').fadeOut();
            //$(this).find('.dropdown-menu').first().hide();

        });

        $('#featureCarousel').carousel({
            interval:   4000
        });

        var clickEvent = false;
        $('#featureCarousel').on('click', '.nav a', function() {
            clickEvent = true;
            $('.nav li').removeClass('active');
            $(this).parent().addClass('active');
        }).on('slid.bs.carousel', function(e) {
            if(!clickEvent) {
                var count = $('#featureCarousel .nav').children().length -1;
                var current = $('#featureCarousel .nav li.active');
                current.removeClass('active').next().addClass('active');
                var id = parseInt(current.data('slide-to'));

                if(count == id) {
                    $('#featureCarousel .nav li').first().addClass('active');
                }
            }
            clickEvent = false;
        });
    });
</script>

</body>
</html>