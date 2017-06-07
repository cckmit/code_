<%@ page import="java.util.Date" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
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
            $("#userManagement").addClass("nav-active");
            $("#userManagementLi").addClass("active");
        });
    </script>
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/bootstrapValidator.min.js"></script>
    <link type="text/css" src="<%=basePath%>frame/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script type="text/javascript" src="<%=basePath%>js/manager/managerManager.js">
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
                <li>用户管理</li>
                <li class="active">用户列表</li>
            </ul>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        用户查询
                        <button class="btn btn-sm btn-primary" onclick="queryCode();">查询</button>
                        <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
                    </header>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-lg-1 col-sm-2 control-label">登录名</label>
                                    <div class="col-lg-3 col-sm-2">
                                        <input id="codeName" type="text" style="width: 200px" class="form-control" placeholder="登录名"/>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </section>
            </div>
        </div>
        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
        <div class="wrapper">

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            管理员<button class="btn btn-sm btn-info" onclick="addManager()"><i class="fa fa-plus"></i></button>
                        </header>

                        <div class="panel-body">
                            <table id="grid-data" class="table-hover general-table">
                                <thead>
                                <tr>
                                    <th data-column-id="id" data-width="5%" data-type="string" data-visible="true">ID</th>
                                    <th data-column-id="code" data-width="20%" data-type="string">登陆名</th>
                                    <th data-column-id="name" data-width="20%" data-formatter="string">姓名</th>
                                    <th data-column-id="createTime" data-width="10%" data-formatter="formatCreateTime">创建时间</th>
                                    <th data-column-id="operate" data-width="20%" data-formatter="operate" data-sortable="false">操作</th>
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
                <h4 class="modal-title" id="addCountryModalLabel">添加管理员</h4>
            </div>
            <div class="modal-body">
                <form id="addCountryForm1" class="form-horizontal" >
                    <div class="form-group">
                        <label for="code1" class="col-sm-2 control-label">登录名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="code1" name="code1" placeholder="请输入登录名" >
                        </div>
                        <label for="pwd1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="pwd1" name="pwd1" placeholder="密码"placeholder="请输入密码">
                        </div>
                        <hr/>
                        <label for="name1" class="col-sm-2 control-label">名字</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name1" name="name1" placeholder="名字"placeholder="请输入名字">
                        </div>
                        <hr>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="col-sm-12 text-center">
                                <button class="btn btn-sm btn-primary" id="hasNoCheck1" type="button" onclick="addManagerList()">添加 </button>
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
                <h4 class="modal-title" id="uodManagerModalLabel">修改管理员</h4>
            </div>
            <div class="modal-body">
                <form id="updManagerForm1" class="form-horizontal" >
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">名字</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" placeholder="名字"placeholder="请输入名字">
                        </div>
                        <br>
                        <br>
                        <br>
                        <br>


                        <div class="form-group">
                            <div class="col-sm-12 text-center">
                                <button class="btn btn-sm btn-primary" id="hasNoCheck2" type="button" onclick="updManagerList()">保存 </button>
                                <button class="btn btn-sm btn-primary" id="hasNoCheck3" type="button" onclick="updManagerPwd()">重置密码 </button>
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
