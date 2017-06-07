<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="资源管理"/>
    </jsp:include>
    <script type="text/javascript">
    </script>
</head>
<input id="prodactId" type="hidden" name="prodactId"/>
<body class="mainFrame">

<div class="page-heading">
    <ul class="breadcrumb">
        <li>资源管理</li>
    </ul>
</div>
<!-- page heading end-->
<!--body wrapper start   主体内容放在wrapper层内-->
<div class="wrapper">

    <section class="panel">
        <header class="panel-heading">
            选择一个系统
            <button class="btn btn-sm btn-info" onclick="editSystem()"><i class="fa fa-plus"></i></button>
            <button class="btn btn-sm btn-warning" onclick="editSystem(_systemId)"><i class="fa fa-edit"></i></button>
            <button class="btn btn-sm btn-danger" onclick="systemDel()"><i class="fa fa-minus"></i></button>
            <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
        </header>
        <div class="panel-body selRegion" style="display: block;" id="selSystem">
        </div>
    </section>

    <div class="row">
        <div class="col-lg-3 col-md-4 col-sm-4">
            <section class="panel">
                <header class="panel-heading">
                    类别
                    <button class="btn btn-sm btn-info" onclick="editCategory()"><i class="fa fa-plus"></i></button>
                    <button class="btn btn-sm btn-warning" onclick="editCategory(_categoryId)"><i class="fa fa-edit"></i></button>
                    <button class="btn btn-sm btn-danger" onclick="categoryDel()"><i class="fa fa-minus"></i></button>
                </header>
                <div class="panel-body" style="display: block;">
                    <ul class="nav nav-pills nav-stacked" id="selCategory">
                    </ul>
                </div>
            </section>
        </div>

        <div class="col-lg-9 col-md-8 col-sm-8">
            <section class="panel">
                <header class="panel-heading">资源列表
                    <button class="btn btn-sm btn-info" onclick="editResource()"><i class="fa fa-plus"></i></button>
                </header>
                <div class="panel-body" style="display: block;">
                    <table id="grid-data" class="table table-hover general-table">
                        <thead>
                        <tr>
                            <th data-column-id="id" data-type="string" data-identifier="true" data-visible="false">ID</th>
                            <th data-column-id="sort" data-type="numeric" data-width="10%">序号</th>
                            <th data-column-id="name" data-type="string" data-width="15%">显示名</th>
                            <th data-column-id="perms" data-type="string" data-width="20%">资源名</th>
                            <th data-column-id="icon" data-type="string" data-width="15%">图标样式名</th>
                            <th data-column-id="type" data-formatter="type" data-type="string" data-width="10%">类型</th>
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
<div id="systemModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="systemModalLabel">系统编辑</h4>
            </div>
            <div class="modal-body">
                <form id="systemForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="idSystem" name="id">
                    <div class="form-group">
                        <label for="nameSystem" class="col-sm-2 control-label">系统名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nameSystem" name="name" placeholder="请输入系统名" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="systemSave();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<div id="categoryModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 90%; height:90%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="categoryModalLabel">分类编辑</h4>
            </div>
            <div class="modal-body">
                <form id="categoryForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="idCategory" name="id">
                    <div class="form-group">
                        <label for="sortCategory" class="col-sm-2 control-label">*序号</label>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" id="sortCategory" name="sort" placeholder="请输入序号" required>
                        </div>
                        <label for="nameCategory" class="col-sm-2 control-label">*分类名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nameCategory" name="name" placeholder="请输入分类名称" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="selSystemCategory" class="col-sm-2 control-label">*所属系统</label>
                        <div class="col-sm-10">
                            <select name="system.id" class="form-control" id="selSystemCategory" data-bv-notempty required>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="categorySave();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<div id="resourceModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 90%; height:90%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="resourceModalLabel">资源编辑</h4>
            </div>
            <div class="modal-body">
                <form id="resourceForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="idResource" name="id">
                    <div class="form-group">
                        <label for="sortResource" class="col-sm-2 control-label">*序号</label>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" id="sortResource" name="sort" placeholder="请输入序号" required>
                        </div>
                        <label for="nameResource" class="col-sm-2 control-label">*显示名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nameResource" name="name" placeholder="请输入显示名" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="iconResource" class="col-sm-2 control-label">图标样式名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="iconResource" name="icon" placeholder="请输入图标样式名" required>
                        </div>
                        <label for="permsResource" class="col-sm-2 control-label">资源名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="permsResource" name="perms" placeholder="资源名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="selSystemResource" class="col-sm-2 control-label">*所属系统</label>
                        <div class="col-sm-4">
                            <select name="system.id" class="form-control" id="selSystemResource" onchange="loadCategoryse(this.options[this.options.selectedIndex].value)" data-bv-notempty required>
                            </select>
                        </div>
                        <label for="selCategoryResource" class="col-sm-2 control-label">*所属类别</label>
                        <div class="col-sm-4">
                            <select name="category.id" class="form-control" id="selCategoryResource" data-bv-notempty>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资源类型</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="typeResource" name="type">
                                <option value=""></option>
                                <option value="1">菜单</option>
                                <option value="2">按钮</option>
                            </select>
                        </div>
                        <label for="urlResource" class="col-sm-2 control-label">*资源链接</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="urlResource" name="url" placeholder="请输入资源链接" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="resourceSave();">保存</button>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/core/resourceManager.js"></script>
</body>
</html>
