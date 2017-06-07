<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="false">
        <jsp:param name="title" value="客户管理"/>
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
                <form id="selectCountryForm1" class="form-horizontal" role="form">
                    <div class="row">
                        <input type="hidden" id="id3" name="id">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">昵称</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="name3" name="name" class="form-control" placeholder="昵称">
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">email</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="email3" name="email" class="form-control" placeholder="email">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">用户等级</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="levelId3" name="levelId" class="input-large form-control">
                                    <option value="">全部</option>
                                    <option value="1">普通客户</option>
                                    <option value="3">大客户</option>
                                </select>
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">是否认证</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="checkStatus3" name="checkStatus" class="input-large form-control">
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



        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
        <div class="wrapper">

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            客户&nbsp;<button class="btn btn-sm btn-info" onclick="addManager()"><i class="fa fa-plus"></i></button>
                        </header>

                        <div class="panel-body">
                            <table id="grid-data" class="table-hover general-table">
                                <thead>
                                <tr>
                                    <th data-column-id="id" data-type="numeric" data-identifier="true" data-order="asc" >ID</th>
                                    <th data-column-id="name" data-type="string" data-width="15%">昵称</th>
                                    <th data-column-id="email" data-type="string" data-width="20%">email</th>
                                    <th data-column-id="levelId" data-formatter="levelId" data-type="string" data-width="15%">用户等级</th>
                                    <th data-column-id="checkStatus" data-type="string" data-width="10%">是否认证</th>
                                    <th data-column-id="createTime" data-formatter="createTime" data-width="20%">创建时间</th>
                                    <th data-column-id="operate" data-formatter="operate" data-type="string" data-width="150">
                                        操作
                                    </th>
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

<div id="addManagerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content"  style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="addCountryModalLabel">添加客户</h4>
            </div>
            <div class="modal-body">
                <form id="addCountryForm1" class="form-horizontal validateForm" >
                    <div class="form-group">
                        <label for="name1" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name1" name="name" placeholder="请输入昵称" required>
                        </div>
                        <label for="pwd1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="pwd1" name="passwd" placeholder="请输入密码" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email1" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" id="email1" name="email"  placeholder="请输入邮箱" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户等级</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="levelId1" name="levelId" required>
                                <option value="1" selected>普通客户</option>
                                <option value="3">大客户</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否认证：</label>
                        <div class="col-sm-4">
                            <input type="radio" class="chupdManagerMeckStatus1" name="checkStatus" value="是">是
                            <input type="radio" class="checkStatus1" name="checkStatus" value="否" checked="checked">否
                        </div>
                    </div>
                        <div class="form-group">
                            <div class="col-sm-offset-5 col-sm-2 text-center">
                                <button class="btn btn-sm btn-primary form-control" id="hasNoCheck1" type="button" onclick="addManagerList()">保存 </button>
                            </div>
                        </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<div id="updManagerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content"  style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="uodManagerModalLabel">修改客户</h4>
            </div>
            <div class="modal-body">
                <form id="updManagerForm1" class="form-horizontal validateForm" >
                    <input type="hidden" id="id" name="id">
                    <input type="hidden" id="passwd2" name="name">
                    <div class="form-group">
                        <label for="name2" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name2" name="name" placeholder="请输入昵称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email2" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email2" name="email" disabled="disabled" placeholder="邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户等级</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="levelId2" name="levelId" required>
                                <option value="1" >普通客户</option>
                                <option value="3">大客户</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否认证：</label>
                        <div class="col-sm-4">
                            <input type="radio"  name="checkStatus" value="是">是
                            <input type="radio"  name="checkStatus" value="否">否
                        </div>
                    </div>

                        <hr>
                        <div class="form-group">
                            <div class="col-sm-offset-5 col-sm-2 text-center">
                                <button class="btn btn-sm btn-primary form-control" id="hasNoCheck2" type="button" onclick="updManagerList()">保存 </button>
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
<script src="${pageContext.request.contextPath}/js/core/customerListGE.js"></script>
</body>
</html>