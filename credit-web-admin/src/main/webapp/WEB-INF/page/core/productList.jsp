<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="商品列表"/>
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
                            <label class="col-lg-1 col-sm-2 control-label">产品名称</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="name2" name="name" class="form-control" placeholder="产品名称">
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">价格</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="price2" name="price" class="form-control" placeholder="价格">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">产品类型</label>
                            <div class="col-lg-5 col-sm-4">
                                    <select id="productType2" name="productType" class="input-large form-control">
                                        <option value="">全部</option>
                                        <option value="1">中国报告</option>
                                        <option value="2">外国报告</option>
                                        <option value="3">自定义报告</option>
                                    </select>
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">产品来源</label>
                            <div class="col-lg-5 col-sm-4">
                                    <select id="source2" name="source" class="input-large form-control">
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
                        <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false" >ID</th>
                        <th data-column-id="name" data-type="string" data-width="15%">产品名称</th>
                        <th data-column-id="productType" data-formatter="productType" data-type="string" data-width="15%">产品类型</th>
                        <th data-column-id="source" data-formatter="source" data-type="string" data-width="15%">产品来源</th>
                        <th data-column-id="desc" data-type="string" data-width="15%">产品描述</th>
                        <th data-column-id="price" data-type="float" data-width="10%">价格</th>
                        <th data-column-id="createTime" data-formatter="createTime" data-type="string" data-width="15%">创建时间</th>
                        <%--<th data-column-id="operate" data-formatter="operate" data-type="string" data-width="100">--%>
                            <%--操作--%>
                        <%--</th>--%>
                    </tr>
                    </thead>
                </table>
            </div>
        </section>
                </div>
            </div>
    </div>

</section>



<div id="addProductModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content" style="width:1000px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="continentModalLabel">添加产品</h4>
            </div>
            <div class="modal-body">
                <form id="addProductForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">产品名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入产品名称" required>
                        </div>
                        <label for="price" class="col-sm-2 control-label">产品价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="price" name="price" placeholder="请输入产品价格" required>
                        </div>
                    </div>
                    <div class="form-group">
                            <label class="col-sm-2 control-label">产品类型</label>
                            <div class="col-sm-4">
                                <select id="productType" name="productType" class="input-large form-control" required>
                                        <option></option>
                                        <option value="1">中国报告</option>
                                        <option value="2">外国报告</option>
                                        <option value="3">自定义报告</option>
                                </select>
                            </div>
                        <label  class="col-sm-2 control-label">产品来源</label>
                        <div class="col-sm-4">
                                <select id="source" name="source" class="input-large form-control" required>
                                    <option></option>
                                    <option value="1">全球鹰</option>
                                    <option value="2">全搜</option>
                                    <option value="3">估估</option>
                                    <option value="4">CPM</option>
                                </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="desc" class="col-sm-2 control-label">产品描述</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="desc" name="desc" placeholder="请输入产品描述" >
                        </div>
                        <label for="createPerson" class="col-sm-2 control-label">创建人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="createPerson" name="name" value="${sessionScope.managerName}" disabled>
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<div id="tagList">--%>
                            <%--<label class="col-sm-2 control-label">包含模块:</label>--%>
                            <%--<br/>--%>
                            <%--<c:forEach items="${modules}" var="module">--%>
                                <%--<input type="checkbox" class="productModules" name="productModules.moduleId" value="${module.id}">${module.name}--%>
                            <%--</c:forEach>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="addProductList();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<div id="upProductModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content" style="width:1000px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="continentModalLabel1">修改产品信息</h4>
            </div>
            <div class="modal-body">
                <form id="upProductForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="id1" name="id">
                    <input type="hidden" id="createPerson1" name="createPerson">
                    <input type="hidden" id="createTime1" name="createTime">
                    <div class="form-group">
                        <label for="name1" class="col-sm-2 control-label">产品名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name1" name="name" placeholder="请输入产品名称" required>
                        </div>
                        <label for="price1" class="col-sm-2 control-label">产品价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="price1" name="price" placeholder="请输入产品价格" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">产品类型</label>
                        <div class="col-sm-4">
                                <select id="productType1" name="productType" class="input-large form-control" required>
                                    <option></option>
                                    <option value="1">中国报告</option>
                                    <option value="2">外国报告</option>
                                    <option value="3">自定义报告</option>
                                </select>
                        </div>
                        <label  class="col-sm-2 control-label">产品来源</label>
                        <div class="col-sm-4">
                                <select id="source1" name="source" class="input-large form-control" required>
                                    <option></option>
                                    <option value="1">全球鹰</option>
                                    <option value="2">全搜</option>
                                    <option value="3">估估</option>
                                    <option value="4">CPM</option>
                                </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="desc1" class="col-sm-2 control-label">产品描述</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="desc1" name="desc" placeholder="请输入产品描述">
                        </div>
                        <label for="lastUpdatePerson1" class="col-sm-2 control-label">更新人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="lastUpdatePerson1" name="lastUpdatePerson" value="${sessionScope.managerName}" disabled>
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<div id="tagList1">--%>
                        <%--<label class="col-sm-2 control-label">包含模块:</label><br/><br>--%>
                        <%--<c:forEach items="${modules}" var="module">--%>
                            <%--<c:set var="b" value="0"/>--%>
                            <%--<c:forEach items="${productModules}" var="productModule">--%>
                                <%--<c:if test="${productModule.id eq module.id}">--%>
                                    <%--<c:set var="b" value="1"/>--%>
                                    <%--<input type="checkbox" class="productModules1" name="productModules.moduleId" value="${module.id}" checked>${module.name}--%>
                                    <%--&lt;%&ndash;<c:set var="exitId" value="0"></c:set>&ndash;%&gt;--%>
                                <%--</c:if>--%>
                            <%--</c:forEach>--%>
                            <%--<c:if test="${b ==0}">--%>
                                <%--<input type="checkbox" class="productModules1" name="productModules.moduleId" value="${module.id}">${module.name}--%>
                            <%--</c:if>--%>
                        <%--</c:forEach>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <hr/>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="upProductList();">保存</button>
                        </div>
                    </div>

<jsp:include page="../include/script.jsp" flush="false"/>
</form>
</div>
</div>
</div>
</div>


<script src="${pageContext.request.contextPath}/js/core/productList.js"></script>
</body>
</html>

