
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="用户管理"/>
    </jsp:include>
</head><body class="mainFrame">
<div class="wrapper">
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
                                        <input id="codeName" name="codeName" type="text" style="width: 200px" class="form-control" placeholder="登录名"/>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </section>
</div>
        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
        <div class="wrapper">

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            管理员&nbsp;<button class="btn btn-sm btn-info" onclick="addManager()"><i class="fa fa-plus"></i></button>
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
</section>





<div id="addManagerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content"  style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="addCountryModalLabel">添加管理员</h4>
            </div>
            <div class="modal-body">
                <form id="addCountryForm1" class="form-horizontal validateForm" >
                    <div class="form-group">
                        <label for="code1" class="col-sm-2 control-label">登录名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="code1" name="code" placeholder="请输入登录名" required>
                        </div>
                        <label for="pwd1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="pwd1" name="pwd" placeholder="密码" required>
                        </div>
                        <hr/>
                        <label for="name1" class="col-sm-2 control-label">名字</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name1" name="name" placeholder="名字" required>
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
                <form id="updManagerForm1" class="form-horizontal validateForm" >
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">名字</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" placeholder="名字" required>
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

<jsp:include page="../include/script.jsp" flush="false"/>

<script src="${pageContext.request.contextPath}/js/core/managerManager.js"></script>
</body>
</html>
