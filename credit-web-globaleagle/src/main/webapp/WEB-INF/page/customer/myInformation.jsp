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
    <title>全球鹰-我的信息</title>
    <jsp:include page="../include/include.jsp"/>
    <script src="<%=basePath%>js/customer/myInformation.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div id="banner">
<div class="container">
    <div class="row">
        <%-- 		<jsp:include page="${basePath}../include/customer/left.jsp"/>
--%>
        <div class="well bs-component">
            <form class="form-horizontal">
            <fieldset>
                <legend>个人信用信息
                    <c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
                        <i class="fa fa-check-square" style="color: green"></i>
                    </c:if>
                </legend>
                <div class="form-group">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">用户名</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="code" class="form-control"
                                       value="${c.getEmail()}" disabled>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">余额</label>
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
                            <label class="col-lg-2 control-label" style="width: 150px">姓名</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="name" class="form-control"
                                       value="${c.getName()}">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">身份证</label>
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
                            <label class="col-lg-2 control-label" style="width: 150px">性别</label>
                            <div class="col-lg-10" style="width: 400px">
                                <select name="select" id="sex" class="form-control">
                                    <option value="">选择性别</option>
                                    <option value="先生"
                                            <c:if test="${c.getSex()=='先生'}">
                                                selected = "selected"
                                            </c:if>
                                    >先生</option>
                                    <option value="女士"
                                            <c:if test="${c.getSex()=='女士'}">
                                                selected = "selected"
                                            </c:if>
                                    >女士</option>
                                </select>
                                <%--<input type="text" id="sex" class="form-control" maxlength="1"--%>
                                <%--value="${c.getSex()}">--%>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">居住地址</label>
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
                            <label class="col-lg-2 control-label" style="width: 150px">*手机号</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="phone" class="form-control"
                                       value="${c.getPhone()}">
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label"
                                   style="width: 150px">e-mail</label>
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
                            <label class="col-lg-2 control-label"
                                   style="width: 150px">*公司名</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="companyName" class="form-control"
                                       value="${c.getCompanyName()}" >
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">*公司地址</label>
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
                                   style="width: 150px">*公司电话</label>
                            <div class="col-lg-10" style="width: 400px">
                                <input type="text" id="companyPhone" class="form-control"
                                       value="${c.getCompanyPhone()}" >
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">*职位</label>
                            <div class="col-lg-10" style="width: 400px">
                                <select name="select" id="position" class="form-control">
                                    <option >选择职位</option>
                                    <option value="董事会"
                                            <c:if test="${c.getPosition()=='董事会'}">
                                                selected = "selected"
                                            </c:if>
                                    >董事会</option>
                                    <option value="管理层"
                                            <c:if test="${c.getPosition()=='管理层'}">
                                                selected = "selected"
                                            </c:if>
                                    >管理层</option>
                                    <option value="其他"
                                            <c:if test="${c.getPosition()=='其他'}">
                                                selected = "selected"
                                            </c:if>
                                    >其他
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
                        <button type="button" class="btn btn-primary"  onclick="modify();">保存</button>
                        <button type="button" class="btn btn-primary"  onclick="authCompanyCommit();"
                        <c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
                            disabled
                        </c:if>
                        >递交个人认证</button>
                    </div>
                </div>



                <div class="form-group">
                    <div class="col-lg-12 text-center">
                        <a class="btn" style="color: rgb(231,76,60);" href="<%=basePath%>toApproveCompany.do" ><h3>免费认证企业，获取更优惠价格及更好的服务</h3></a>
                    </div>
                </div>
            </fieldset>
            </form>
        </div>

    </div>
</div>
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>

</body>
</html>

