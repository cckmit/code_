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
    <title>Full Search - LEGAL SERVICES</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>

</head>
<script type="text/javascript">

    var basePath = "<%=basePath%>";
    function buttonClick() {
        if ($('#companyName').val()==null||$('#companyName').val()==''){
            BootstrapDialog.alert("Company name cannot be empty");
            return false;
        }
        if ($('#keyword').val()==null||$('#keyword').val()==''){
            BootstrapDialog.alert("Keyword cannot be empty");
            return false;
        }
        if ($('#demand').val()==null||$('#demand').val()==''){
            BootstrapDialog.alert("Service requirements cannot be empty");
            return false;
        }
        var senddata = {
            "companyName":$('#companyName').val(),
            "keyword":$('#keyword').val(),
            "demand":$('#demand').val(),
            "type":' Legal Services'
        };
        $.ajax({
            type:"POST",
            url:basePath+"customer/creditServiceSave.do",
            contentType:"application/json",
            data:JSON.stringify(senddata),
            success:function(data){
//                BootstrapDialog.alert("Your information has been received and we will deal with it as soon as possible");
                $(".fxq-fun-alert").css({"transform":"translateY(50px)","opacity":"1"});
                $(document.body).css({
                    "overflow-x":"hidden",
                    "overflow-y":"hidden"
                });
            }
        });
    }

    function fxqclose() {
        $(".fxq-fun-alert").css({"transform":"translateY(-25%)","opacity":"0"});
        $(document.body).css({
            "overflow-x":"auto",
            "overflow-y":"auto"
        });
        $("#keyword").val("");
        $("#demand").val("");
    }
</script>
<body>
<jsp:include page="${basePath}../include/topIndex.jsp"/>

<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
    <%--<p class="lead">Global Accounts Receivable Management</p>--%>
    <div class="row" style="width: 1140px;overflow: hidden;margin-left: 0; -webkit-border-radius:5px; -moz-border-radius:5px;border-radius:5px;">
        <div class="span12">
            <div class="carousel-inner fxq-carousel-inner">
                <div class="item active">
                    <img alt="" src="<%=basePath%>images/site/f2.png" />
                    <div class="fxq-fun-title">
                        <h3>Everything You Need is Here</h3>
                        <p>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.
                        </p>
                    </div>
                    <div class="carousel-caption">
                        <div class="fxq-fun-sjx"></div>
                        <h4>
                            The Best Solution for Your Business Projects
                        </h4>
                        <p>
                            Qualitative PSD Template With Unlimited Possibilities
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="function-text">
        <h5>We Offer the Service</h5>
        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
        <div style="width: 96px;height: 3px;background: #183f6d;margin:0 auto;"></div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="well bs-component">
                <form class="form-horizontal">
                    <fieldset>
                        <legend style="margin: 0;padding: 10px 0 15px 0;margin-bottom: 30px;">Delegation Form</legend>
                        <%--目标公司--%>
                        <div class="form-group">
                            <label  class="col-lg-2 control-label">Company Name</label>

                            <div class="col-lg-10">
                                <input class="form-control"  placeholder="Company Name" type="text"name="companyName" id="companyName" value="${companyNameEN}">
                            </div>
                        </div>
                        <%--关键字--%>
                        <div class="form-group">
                            <label  class="col-lg-2 control-label">Keyword</label>
                            <div class="col-lg-10">
                                <input class="form-control"  placeholder="Please enter the keywords" type="text" id="keyword">
                            </div>
                        </div>
                        <%--需求--%>
                        <div class="form-group">
                            <label  class="col-lg-2 control-label">Your Requirement</label>
                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" placeholder="Please enter your requirement" id="demand"></textarea>
                            </div>
                        </div>

                        <%--按钮--%>
                        <div class="form-group">
                            <div class="col-lg-12 col-lg-offset-2" align="center" style="margin-left: 0;">
                                <a  class="btn btn-default" href="http://www.bierenscollectionattorneys.cn/" target="_blank">
                                    More Information...
                                </a>
                                <button type="button" onclick="buttonClick()" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<%--弹出框--%>
<div class="fxq-fun-alert" id="fxq-close">
    <div class="fxq-alert-head">Information</div>
    <div class="fxq-alert-body">Your information has been received and we will deal with it as soon as possible</div>
    <div class="fxq-alert-foot">
        <a class="btn btn-default fxq-alert-close" onclick="fxqclose()">Close</a>
        <a href="javascript:window.opener=null;window.open('','_self');window.close();" class="btn btn-default" >OK</a>
    </div>
</div>
<jsp:include page="${basePath}../include/bottom.jsp"/>
</body>
</html>