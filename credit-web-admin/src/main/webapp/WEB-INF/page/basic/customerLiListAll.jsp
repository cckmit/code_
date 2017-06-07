<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="邮箱设置"/>
    </jsp:include>
</head>
<input id="prodactId" type="hidden" name="prodactId"/>
<body class="mainFrame">

<section>
        <div class="wrapper">
            <section class="panel">
                <header class="panel-heading">
                    查询条件
                    <button class="btn btn-sm btn-primary" onclick="query();">查询</button>
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
                </header>
                <div class="panel-body" style="display: block;">
                    <form class="form-horizontal" role="form">
                        <div class="row">
                            <div class="form-group">
                                <label class="col-lg-1 col-sm-2 control-label">账户建立日期</label>
                                <div class="col-lg-5 col-sm-4">
                                    <input type="date" id="createTime1" name="createTime" class="form-control" placeholder="账户建立日期">
                                </div>
                                <label class="col-lg-1 col-sm-2 control-label">是否认证</label>
                                <div class="col-lg-5 col-sm-4">
                                    <select id="checkStatus1" name="checkStatus" class="input-large form-control">
                                        <option value="">全部</option>
                                        <option value="是">是</option>
                                        <option value="否">否</option>
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
                            客户管理
                        </header>
                        <div class="panel-body">
                            <table id="grid-data" class="table table-hover general-table">
                                <thead>
                                <tr>
                                    <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                    <th data-column-id="email" data-width="20%" data-type="string">登陆名</th>
                                    <th data-column-id="name" data-width="20%" data-type="string">姓名</th>
                                    <th data-column-id="createTime" data-width="20%" data-formatter="formatCreateTime">账号建立日期</th>
                                    <th data-column-id="levelId" data-width="10%" data-type="string" data-formatter="level">客户等级</th>
                                    <th data-column-id="balance" data-width="10%" data-type="float">余额</th>
                                    <th data-column-id="operate" data-width="20%" data-formatter="operate" data-sortable="false">操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </section>
                </div>
            </div>
        </div>
</section>


<div id="customerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content"  style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="countryModalLabel">用户详情</h4>
            </div>
            <div class="modal-body">
                <form id="countryForm1" class="form-horizontal" role="form">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" disabled  placeholder="请输入用户名">
                        </div>

                        <label for="sex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sex" name="sex" disabled  placeholder="性别">

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idcard" class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="idcard" name="theme" disabled>
                        </div>
                        <label for="addr" class="col-sm-2 control-label">居住地</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addr" name="addr" disabled >
                        </div>
                    </div>
                    <hr/>
                    <h4>联系方式</h4>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">手机</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mobile" disabled >
                        </div>
                        <label for="email2" class="col-sm-2 control-label">e-mail</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email2" disabled>
                        </div>
                        <%--<label for="email" class="col-sm-2 control-label">邮箱</label>--%>
                        <%--<div class="col-sm-2">--%>
                        <%--<input type="text" class="form-control" id="email" name="email" disabled placeholder="请输入邮箱">--%>
                        <%--</div>--%>
                        <%--<label for="theme" class="col-sm-2 control-label">家庭电话</label>--%>
                        <%--<div class="col-sm-2">--%>
                        <%--<input type="text" class="form-control" id="theme" name="theme" disabled>--%>
                        <%--</div>--%>
                    </div>
                    <div class="form-group">
                        <label for="sosPerson" class="col-sm-2 control-label">紧急联系人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sosPerson" disabled >
                        </div>
                        <label for="sosMobile" class="col-sm-2 control-label">紧急联系人手机</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sosMobile" disabled >
                        </div>
                    </div>
                    <hr/>
                    <h4>公司信息</h4>
                    <div class="form-group">
                        <label for="companyName" class="col-sm-2 control-label">公司名称</label>
                        <div class="col-sm-4">
                                <input type="text" class="form-control" id="companyName" disabled>
                        </div>
                        <label for="companyAddress" class="col-sm-2 control-label">公司地址</label>
                        <div class="col-sm-4">
                                <input type="text" class="form-control" id="companyAddress" disabled>
                            </div>
                        </div>
                    <div class="form-group">
                        <label for="companyPhone" class="col-sm-2 control-label">公司电话</label>
                        <div class="col-sm-4">
                                <input type="text" class="form-control" id="companyPhone" disabled>
                        </div>
                        <label for="position" class="col-sm-2 control-label">职位</label>
                        <div class="col-sm-4">
                                <input type="text" class="form-control" id="position" disabled >
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

<jsp:include page="../include/script.jsp" flush="false"/>

<script src="${pageContext.request.contextPath}/js/basic/customerLiListAll.js"></script>
</body>
</html>
