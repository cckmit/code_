<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="组管理"/>
    </jsp:include>
    <script type="text/javascript">
    </script>
</head>
<input id="prodactId" type="hidden" name="prodactId"/>
<body class="mainFrame">

<div class="page-heading">
    <ul class="breadcrumb">
        <li>组织机构</li>
        <li class="active">组管理</li>
    </ul>
</div>
<!-- page heading end-->
<!--body wrapper start   主体内容放在wrapper层内-->
<div class="wrapper">

    <div class="row">
        <div class="col-lg-3 col-md-4 col-sm-4">
            <section class="panel">
                <header class="panel-heading">
                    组
                    <button class="btn btn-sm btn-info" onclick="editGroup()"><i class="fa fa-plus"></i></button>
                    <button class="btn btn-sm btn-warning" onclick="editGroup(_groupId)"><i class="fa fa-edit"></i></button>
                    <button class="btn btn-sm btn-danger" onclick="groupDel()"><i class="fa fa-minus"></i></button>
                </header>
                <div class="panel-body" style="display: block;">
                    <ul class="nav nav-pills nav-stacked" id="selGroup">
                    </ul>
                </div>
            </section>
        </div>

        <div class="col-lg-9 col-md-8 col-sm-8">
            <section class="panel">
                <header class="panel-heading">资源列表
                </header>
                <div class="panel-body" style="display: block;">
                    <ul class="nav nav-pills nav-stacked" id="selSource">
                    </ul>
                </div>
            </section>
        </div>
    </div>
</div>
</div>
</section>
<div id="groupModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="groupModalLabel">组编辑</h4>
            </div>
            <div class="modal-body">
                <form id="groupForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">组名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入组名称" required>
                        </div>
                        <label for="code" class="col-sm-2 control-label">组编码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="code" name="code" placeholder="请输入组编码" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label/">资源</label>
                        <div class="panel-body" style="display: block;" id="resource">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="groupSave();">保存</button>
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
<jsp:include page="../include/ckEditor.jsp" flush="false"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/base64.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/core/groupManager.js"></script>
</body>
</html>
