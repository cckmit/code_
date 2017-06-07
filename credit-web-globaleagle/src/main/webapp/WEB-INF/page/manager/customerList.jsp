<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="${basePath}../include/manager/include.jsp" flush="true"/>
    <title>客户管理</title>
    <script type="text/javascript">
        var basePath = "<%=basePath%>";
        $(document).ready(function () {
            $("#customerManagement").addClass("nav-active");
            $("#customerManagementLi").addClass("active");
        });
    </script>
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/bootstrapValidator.min.js"></script>
    <link type="text/css" src="<%=basePath%>frame/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script type="text/javascript" src="<%=basePath%>/js/manager/customerList.js">
    </script>
    <style type="text/css">
        .selRegion button {
            margin-left: 20px;
        }
        #countryForm input {
            width: 150px;
        }
    </style>
</head>

<body class="sticky-header">

<section>
    <jsp:include page="${basePath}../include/manager/left.jsp" flush="true"/>
    <div class="main-content">
        <jsp:include page="${basePath}../include/manager/top.jsp" flush="true"/>
        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>客户管理</li>
                <li class="active">客户列表</li>
            </ul>
        </div>
        <div class="page-heading">查询条件 |
        <button class="btn btn-sm btn-primary" onclick="query();">查询</button>
        </div>
        <div class="modal-body">
                    <form id="selectCountryForm1" class="form-horizontal" >
                        <input type="hidden" id="id3" name="id">
                        <div class="form-group">
                            <label for="name3" class="col-sm-2 control-label">昵称</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="name3" name="name" >
                            </div>
                            <label for="email3" class="col-sm-2 control-label">email</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="email3" name="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户等级</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="levelId3" name="levelId" >
                                    <option></option>
                                    <option value="1" >普通客户</option>
                                    <option value="3">大客户</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">是否认证：</label>
                            <div class="col-sm-4">
                                <input type="radio"  name="checkStatus" value="是">是
                                <input type="radio"  name="checkStatus" value="否" >否
                            </div>
                        </div>
                    </form>
                </div>
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
                                    <th data-column-id="email" data-type="string" data-width="20%">
                                        email
                                    </th>
                                    <th data-column-id="levelId" data-formatter="levelId" data-type="string" data-width="15%">用户等级</th>
                                    <th data-column-id="checkStatus" data-type="string" data-width="10%">是否认证</th>
                                    <th data-column-id="createTime" data-formatter="createTime" data-type="string" data-width="20%">创建时间</th>
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
        <!--body wrapper end-->
        <jsp:include page="${basePath}../include/manager/bottom.jsp" flush="true"/>
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
                <form id="addCountryForm1" class="form-horizontal" >
                    <div class="form-group">
                        <label for="name1" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name1" name="name" placeholder="请输入昵称" >
                        </div>
                        <label for="pwd1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="pwd1" name="passwd" placeholder="密码" placeholder="请输入密码" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email1" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email1" name="email" placeholder="邮箱" placeholder="请输入邮箱" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户等级</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="levelId1" name="levelId" >
                                <option value="1" selected="selected">普通客户</option>
                                <option value="3">大客户</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否认证：</label>
                        <div class="col-sm-4">
                            <input type="radio" class="checkStatus1" name="checkStatus" value="是">是
                            <input type="radio" class="checkStatus1" name="checkStatus" value="否" checked="checked">否
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-sm-12 text-center">
                                <button class="btn btn-primary form-control" id="hasNoCheck1" type="submit" onclick="addManagerList()">保存 </button>
                            </div>
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
                <form id="updManagerForm1" class="form-horizontal" >
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
                            <select class="form-control" id="levelId2" name="levelId" >
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
                    <div class="form-group">
                        <hr>
                        <div class="form-group">
                            <div class="col-sm-12 text-center">
                                <button class="btn btn-primary form-control" id="hasNoCheck2" type="submit" onclick="updManagerList()">保存 </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
</body>
</html>

