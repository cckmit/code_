<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<html>
<head>
    <title>Full search - my message</title>
    <jsp:include page="../include/include.jsp"/>
    <script src="<%=basePath%>/js/customer/myInformation.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body>
<jsp:include page="../include/top.jsp"/>
<div id="banner">
<div class="container">
    <div class="row">
        <%-- 		<jsp:include page="${basePath}../include/customer/left.jsp"/>
--%>
        <div class="well bs-component">
            <form class="form-horizontal">
            <fieldset>
                <legend style="margin: 0;padding: 10px 0 15px 0;margin-bottom: 30px;">My Account
                    <c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
                        <i class="fa fa-check-square" style="color: green"></i>
                    </c:if>
                </legend>
                <div class="form-group">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">User Name</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="code" class="form-control"
                                       value="${c.getEmail()}" disabled>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">Balance</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" class="form-control" id="balance"
                                       value="${c.getBalance()}" disabled>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">Name</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="name" class="form-control"
                                       value="${c.getName()}">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">ID</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="idcard" class="form-control"
                                       value="${c.getIdcard()}">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">Gender</label>
                            <div class="col-lg-10" style="width: 400px">
                                <select name="select" id="sex" class="form-control">
                                    <option value="">Gender Selection</option>
                                    <option value="Sir"
                                            <c:if test="${c.getSex()=='先生'}">
                                                selected = "selected"
                                            </c:if>
                                    >Sir</option>
                                    <option value="Ma'am"
                                            <c:if test="${c.getSex()=='女士'}">
                                                selected = "selected"
                                            </c:if>
                                    >Ma'am</option>
                                </select>
                                <%--<input type="text" id="sex" class="form-control" maxlength="1"--%>
                                <%--value="${c.getSex()}">--%>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">Address</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="addr" class="form-control"
                                       value="${c.getAddr()}">
                            </div>
                        </div>
                    </div>

                </div>

                <div class="form-group">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">*Phone</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="phone" class="form-control"
                                       value="${c.getPhone()}">
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label"
                                   style="width: 150px">E-mail</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="email" class="form-control"
                                       value="${c.getEmail()}" disabled>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="form-group">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">*Company Name</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="companyNameA" class="form-control"
                                       value="${c.getCompanyName()}">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">*Company Address</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="companyAddress" class="form-control"
                                       value="${c.getCompanyAddress()}">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label"
                                   style="width: 150px">*Company Tel</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="companyPhone" class="form-control"
                                       value="${c.getCompanyPhone()}" >
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">*Title</label>
                            <div class="col-lg-10" style="width: 400px">
                                <select name="select" id="position" class="form-control">
                                    <option >Select position</option>
                                    <option value="Board of directors"
                                            <c:if test="${c.getPosition()=='Board of directors'}">
                                                selected = "selected"
                                            </c:if>
                                    >Board of directors</option>
                                    <option value="Management layer"
                                            <c:if test="${c.getPosition()=='Management layer'}">
                                                selected = "selected"
                                            </c:if>
                                    >Management layer</option>
                                    <option value="Other"
                                            <c:if test="${c.getPosition()=='Other'}">
                                                selected = "selected"
                                            </c:if>
                                    >Other
                                    </option>

                                </select>
                                <%--<input type="text" id="position" class="form-control"--%>
                                       <%--value="${c.getPosition()}">--%>
                            </div>
                        </div>
                    </div>
                </div>






                <div class="form-group">
                    <div class="col-lg-12 text-center">
                        <button type="button" class="btn btn-primary"  onclick="modify();">Save</button>
                        <button type="button" class="btn btn-primary"  onclick="authCompanyCommit();"
                        <c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
                            disabled
                        </c:if>
                        >Submit</button>
                    </div>
                </div>



                <div class="form-group">
                    <div class="col-lg-12 text-center">
                        <a class="btn" style="color: rgb(231,76,60);text-transform:none;" href="<%=basePath%>toApproveCompany.do" >
                            <h4 style="margin-bottom: 10px;">Free Registration of Companies,</h4>
                            <h4>Recommended for you.</h4>
                        </a>
                    </div>
                </div>
            </fieldset>
            </form>
        </div>

    </div>
</div>
</div>

<jsp:include page="../include/bottom.jsp"/>

</body>
</html>

