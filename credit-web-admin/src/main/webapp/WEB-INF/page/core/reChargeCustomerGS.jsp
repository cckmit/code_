<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="充值管理"/>
    </jsp:include>
</head>

<body class="mainFrame">
<section>
    <div class="wrapper">
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            用户充值
                        </header>
                        <div class="panel-body">
                            <table id="grid-data" class="table-hover general-table">
                                <thead>
                                <tr>
                                    <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                    <th data-column-id="email" data-width="20%" data-type="string">登陆名</th>
                                    <th data-column-id="name" data-width="15%" data-type="string">姓名</th>
                                    <th data-column-id="createTime" data-width="15%" data-formatter="formatCreateTime">账号建立日期</th>
                                    <th data-column-id="levelId" data-width="15%" data-type="string" data-formatter="level">客户等级</th>
                                    <th data-column-id="balance" data-width="15%" data-type="float">余额</th>
                                    <th data-column-id="operate" data-width="20%" data-formatter="operate" data-sortable="false">操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </div>
</section>




<div id="customerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content"  style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="countryModalLabel">充值页面</h4>
            </div>
            <div class="modal-body">
                <form id="countryForm1" class="form-horizontal" role="form">
                    <input type="hidden" id="customerId" name="customerId">
                    <%--<input type="hidden" id="customerName" name="customerName">--%>
                    <%--<input type="hidden" id="balance" name="balance">--%>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email" name="email" disabled>
                        </div>
                        <label for="customerName" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="customerName" name="customerName" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="balance" class="col-sm-2 control-label">余额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="balance" name="balance" disabled>
                        </div>
                        <label for="amount" class="col-sm-2 control-label">充值金额</label>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" id="amount" name="amount" placeholder="请输入充值金额" required>
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-sm-4">--%>
                            <%--<label for="payMethod" class="col-sm-2 control-label">充值方式</label>--%>
                            <%--<div class="col-lg-5 col-sm-4">--%>
                                <%--<select id="payMethod" name="payMethod" class="input-large form-control" placeholder="请选择充值方式" required>--%>
                                    <%--<option value=""></option>--%>
                                    <%--<option value="3" selected>后台充值</option>--%>
                                    <%--<option value="1">支付宝</option>--%>
                                    <%--<option value="2">微信</option>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" id="isEnable" type="button" disabled></button>
                            <button class="btn btn-sm btn-primary" id="hasNoCheck" type="button" onclick="reChargeCustomer();">确定充值</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>


<jsp:include page="../include/script.jsp" flush="false"/>

<script src="${pageContext.request.contextPath}/js/core/reChargeCustomerGS.js"></script>
</body>
</html>
