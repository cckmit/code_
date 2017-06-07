<%@ page import="com.mika.credit.common.entity.order.OrderStatusEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="快速订购列表"/>
    </jsp:include>
</head>

<body class="mainFrame">
<section>
    <div class="wrapper">
        <section class="panel">

            <header class="panel-heading">
                查询条件
                <button class="btn btn-sm btn-info" onclick="query();">查询</button>
                <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
            </header>
            <div class="panel-body" style="display: block;">
                <form class="form-horizontal" role="form">
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">订单编号</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="no1" name="no" class="form-control" placeholder="订单编号">
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">订单状态</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="status1" name="status" class="input-large form-control">
                                    <option value="">所有状态</option>
                                    <option value="0">取消</option>
                                    <option value="1">新订单</option>
                                    <option value="2">确认中</option>
                                    <option value="3">制作中</option>
                                    <option value="4">已完成</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">订单来源</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="source1" name="source" class="input-large form-control">
                                    <option value="">全部</option>
                                    <option value="1">全球鹰</option>
                                    <option value="2">全搜</option>
                                    <option value="3">估估</option>
                                    <option value="4">CPM</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>

        <div class="row">
            <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        查询结果
                        <%--<button class="btn btn-sm btn-info" onclick="addProduct()"><i class="fa fa-plus"></i></button>--%>
                        <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                            </span>
                    </header>
                    <div class="panel-body">
                        <table id="grid-data" class="table-hover general-table">
                            <thead>
                            <tr>
                                <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                <th data-column-id="no" data-type="string" data-width="15%">订单号</th>
                                <th data-column-id="customerEmail" data-type="string" data-width="10%">客户email</th>
                                <th data-column-id="amount" data-type="float" data-width="10%">应付金额</th>
                                <th data-column-id="hasPay" data-formatter="hasPay"  data-type="string" data-width="10%">是否支付</th>
                                <th data-column-id="source" data-formatter="source" data-type="string" data-width="10%">订单来源</th>
                                <th data-column-id="statusNameCN" data-type="string" data-width="10%">状态</th>
                                <th data-column-id="createTime" data-formatter="createTime" data-type="string" data-width="15%">创建日期</th>
                                <th data-column-id="operate" data-formatter="operate" data-type="string" data-width="10%">操作</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </section>
            </div>
        </div>

    </div>

</section>

<div id="quickOrderModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content"  style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="countryModalLabel">快速订购详情</h4>
            </div>
            <div class="modal-body">
                <form id="quickOrderForm1" class="form-horizontal" role="form">
                    <input type="hidden" id="id" name="id">
                    <input type="hidden" id="createUserId" name="createUserId">
                    <div class="form-group">
                        <label for="no" class="col-sm-2 control-label">订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="no" name="no" disabled>
                        </div>
                        <label for="createUserName" class="col-sm-2 control-label">创建人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="createUserName" name="createUserName" disabled  >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="productId" class="col-sm-2 control-label">产品Id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="productId" name="productId" disabled>
                        </div>
                        <label for="createTime" class="col-sm-2 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="date" class="form-control" id="createTime" name="createTime" disabled >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="source" class="col-sm-2 control-label">订单来源</label>
                        <div class="col-sm-4">
                                <select id="source" name="source" class="input-large form-control">
                                    <option value=""></option>
                                    <option value="1">全球鹰</option>
                                    <option value="2">全搜</option>
                                    <option value="3">估估</option>
                                    <option value="4">CPM</option>
                                </select>
                        </div>
                        <label for="status" class="col-sm-2 control-label">订单状态</label>
                        <div class="col-sm-4">
                                <select id="status" name="status" class="input-large form-control">
                                    <option value=""></option>
                                    <option value="0">取消</option>
                                    <option value="1">新订单</option>
                                    <option value="2">确认中</option>
                                    <option value="3">制作中</option>
                                    <option value="4">已完成</option>
                                </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="updateTime" class="col-sm-2 control-label">更新时间</label>
                        <div class="col-sm-4">
                            <input type="date" class="form-control" id="updateTime" name="updateTime" disabled >
                        </div>
                        <label for="expectTime" class="col-sm-2 control-label">预计交付时间</label>
                        <div class="col-sm-4">
                            <input type="date" class="form-control" id="expectTime" name="expectTime">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="finishTime" class="col-sm-2 control-label">完成时间</label>
                        <div class="col-sm-4">
                            <input type="date" class="form-control" id="finishTime" name="finishTime">
                        </div>
                    </div>
                    <hr/>
                    <h4>客户信息</h4>
                    <div class="form-group">
                        <input type="hidden" id="customerId" name="customerId">
                        <label for="customerName" class="col-sm-2 control-label">客户昵称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="customerName" name="customerName" >
                        </div>
                        <label for="customerNo" class="col-sm-2 control-label">客户号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="customerNo" name="customerNo" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="customerEmail" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-4">
                        <input type="email" class="form-control" id="customerEmail" name="customerEmail"  placeholder="请输入邮箱">
                        </div>
                    </div>
                    <hr/>
                    <h4>支付信息</h4>
                    <div class="form-group">
                        <label for="amount" class="col-sm-2 control-label">应付金额</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="amount" name="amount" placeholder="请输入应付金额">
                        </div>
                        <label for="amountActual" class="col-sm-2 control-label">实付金额</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="amountActual" name="amountActual" placeholder="请输入实付金额">
                        </div>
                        <label for="currency" class="col-sm-2 control-label">币种</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="currency" name="currency"  disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="hasPay" class="col-sm-2 control-label">是否支付</label>
                        <div class="col-sm-4">
                            <div class="col-lg-5 col-sm-4">
                                <select id="hasPay" name="hasPay" class="input-large form-control" placeholder="请确认是否支付">
                                    <option value=""></option>
                                    <option value="false">未支付</option>
                                    <option value="true">已支付</option>
                                </select>
                            </div>
                        </div>
                        <label for="payMethod" class="col-sm-2 control-label">支付方式</label>
                        <div class="col-sm-4">
                            <div class="col-lg-5 col-sm-4">
                                <select id="payMethod" name="payMethod" class="input-large form-control" placeholder="请选择支付方式">
                                    <option value=""></option>
                                    <option value="0">账户余额</option>
                                    <option value="1">支付宝</option>
                                    <option value="2">微信</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <hr/>
                    <h4>企业信息</h4>
                    <div class="form-group">
                        <label for="companyArea" class="col-sm-2 control-label">订购企业所属洲或地区</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="companyArea" name="companyArea" placeholder="请输入所属洲或地区">
                        </div>
                        <label for="companyCountry" class="col-sm-2 control-label">订购企业所属国家</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="companyCountry" name="companyCountry" placeholder="请输入所属国家">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="companyName" class="col-sm-2 control-label">企业名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="companyName" name="companyName" placeholder="请输入企业名称">
                        </div>
                        <label for="companyPhone" class="col-sm-2 control-label">企业电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="companyPhone" name="companyPhone" placeholder="请输入企业电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="companyAddress" class="col-sm-2 control-label">企业地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="companyAddress" name="companyAddress" placeholder="请输入企业地址">
                        </div>
                        <label for="companyWebsite" class="col-sm-2 control-label">企业网站</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="companyWebsite" name="companyWebsite" placeholder="请输入企业网站">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="otherInfo" class="col-sm-2 control-label">其他信息</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="otherInfo" name="otherInfo" >
                        </div>
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="remark" name="remark" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            <button class="btn btn-sm btn-primary" type="button" onclick="jump();">公司信息图片地址</button>
                        </label>
                        <div class="col-sm-4">
                            <input type="hidden" class="form-control" id="imgUrl" name="imgUrl">
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<label for="imgUrl" class="col-sm-2 control-label">公司信息图片地址</label>--%>
                        <%--<div class="col-sm-4">--%>
                            <%--<input type="text" class="form-control" id="imgUrl" name="imgUrl" placeholder="请输入公司信息图片地址">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <hr/>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="upQuickOrder();">保存</button>
                            <button class="btn btn-sm btn-primary" id="hasNoCheck" type="button" onclick="saveOrder();">生成订单</button>
                        </div>
                    </div>
                    <hr/>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<div id="imgModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="imgModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="imgModalLabel">图片</h4>
            </div>
            <div class="modal-body">
                <img id="companyImg" src="" height="400"/>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/script.jsp" flush="false"/>

<script src="${pageContext.request.contextPath}/js/core/quickOrder.js"></script>
</body>
</html>

