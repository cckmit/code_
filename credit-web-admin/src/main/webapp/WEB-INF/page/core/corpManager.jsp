<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="机构管理"/>
    </jsp:include>
    <script type="text/javascript">
    </script>
</head>
<input id="prodactId" type="hidden" name="prodactId"/>
<body class="mainFrame">

<div class="page-heading">
    <ul class="breadcrumb">
        <li>组织机构</li>
        <li class="active">机构管理</li>
    </ul>
</div>
<div class="wrapper">

    <section class="panel">
        <header class="panel-heading">
            选择一个机构类别
            <button class="btn btn-sm btn-info" onclick="editCorpType()"><i class="fa fa-plus"></i></button>
            <button class="btn btn-sm btn-warning" onclick="editCorpType(_corpTypeId)"><i class="fa fa-edit"></i></button>
            <button class="btn btn-sm btn-danger" onclick="corpTypeDel()"><i class="fa fa-minus"></i></button>
            <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
        </header>
        <div class="panel-body selRegion" style="display: block;" id="selCorpType">
        </div>
    </section>

    <div class="row">
        <div class="col-lg-3 col-md-4 col-sm-4">
            <section class="panel">
                <header class="panel-heading">
                    机构
                    <button class="btn btn-sm btn-info" onclick="editCorp()"><i class="fa fa-plus"></i></button>
                    <button class="btn btn-sm btn-warning" onclick="editCorp(_corpId)"><i class="fa fa-edit"></i></button>
                    <button class="btn btn-sm btn-danger" onclick="corpDel()"><i class="fa fa-minus"></i></button>
                </header>
                <div class="panel-body" style="display: block;">
                    <ul class="nav nav-pills nav-stacked" id="selCorp">
                    </ul>
                </div>
            </section>
        </div>

        <div class="col-lg-9 col-md-8 col-sm-8">
            <section class="panel">
                <header class="panel-heading">部门列表
                    <button class="btn btn-sm btn-info" onclick="editDept()"><i class="fa fa-plus"></i></button>
                </header>
                <div class="panel-body" style="display: block;">
                    <table id="grid-data" class="table table-hover general-table">
                        <thead>
                        <tr>
                            <th data-column-id="id" data-type="string" data-identifier="true" data-order="asc" data-visible="false">ID</th>
                            <th data-column-id="code" data-type="string" data-width="20%">部门编码</th>
                            <th data-column-id="name" data-type="string" data-width="20%">部门名称</th>
                            <th data-column-id="pid" data-type="string" data-width="20%">上级机构</th>
                            <th data-column-id="chief" data-type="string" data-width="20%">负责人</th>
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
<div id="corpTypeModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="corpTypeModalLabel">机构类别编辑</h4>
            </div>
            <div class="modal-body">
                <form id="corpTypeForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="idCorpType" name="id">
                    <div class="form-group">
                        <label for="nameCorpType" class="col-sm-2 control-label">机构类别名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nameCorpType" name="name" placeholder="请输入机构类别名" required>
                        </div>
                        <label for="codeCorpType" class="col-sm-2 control-label">编码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="codeCorpType" name="code" placeholder="请输入编码" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="corpTypeSave();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>
<div id="corpModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 90%; height:90%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="corpModalLabel">机构编辑</h4>
            </div>
            <div class="modal-body">
                <form id="corpForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="idCorp" name="id">
                    <div class="form-group">
                        <label for="nameCorp" class="col-sm-2 control-label">*机构名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nameCorp" name="name" placeholder="请输入机构名称" required>
                        </div>
                        <label for="codeCorp" class="col-sm-2 control-label">*机构编码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="codeCorp" name="code" placeholder="请输入机构编码" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="selType" class="col-sm-2 control-label">*所属机构</label>
                        <div class="col-sm-4">
                            <select name="corpType.id" class="form-control" id="selType" data-bv-notempty required>
                            </select>
                        </div>
                        <label for="pidCorp" class="col-sm-2 control-label">上级机构</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="pidCorp" name="pid" placeholder="上级机构">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="levCorp" class="col-sm-2 control-label">级别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="levCorp" name="lev" placeholder="级别">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telCorp" class="col-sm-2 control-label">*电话号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="telCorp" name="tel" placeholder="请输入电话号码" required>
                        </div>
                        <label for="addrCorp" class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addrCorp" name="addr" placeholder="地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="artificialCorp" class="col-sm-2 control-label">法人代表</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="artificialCorp" name="artificial" placeholder="法人代表">
                        </div>
                        <label for="jobCorp" class="col-sm-2 control-label">主要职能</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="jobCorp" name="job" placeholder="主要职能">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="corpSave();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<div id="deptModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 90%; height:90%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="deptModalLabel">部门编辑</h4>
            </div>
            <div class="modal-body">
                <form id="deptForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="idDept" name="id">
                    <div class="form-group">
                        <label for="nameDept" class="col-sm-2 control-label">*部门名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nameDept" name="name" placeholder="请输入部门名称" required>
                        </div>
                        <label for="codeDept" class="col-sm-2 control-label">*部门编码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="codeDept" name="code" placeholder="请输入部门编码" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="selCorpTypeDept" class="col-sm-2 control-label">*所属机构类别</label>
                        <div class="col-sm-4">
                            <select name="corpType.id" class="form-control" id="selCorpTypeDept" onchange="loadCorpse(this.options[this.options.selectedIndex].value)" data-bv-notempty required>
                            </select>
                        </div>
                        <label for="selCorpDept" class="col-sm-2 control-label">*所属机构</label>
                        <div class="col-sm-4">
                            <select name="corp.id" class="form-control" id="selCorpDept" data-bv-notempty >
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="levDept" class="col-sm-2 control-label">级别</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="levDept" name="lev" placeholder="请输入级别">
                        </div>
                        <label for="pidDept" class="col-sm-2 control-label">上级机构</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="pidDept" name="pid" placeholder="上级机构">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="chiefDept" class="col-sm-2 control-label">负责人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="chiefDept" name="chief" placeholder="负责人">
                        </div>
                        <label for="jobDept" class="col-sm-2 control-label">主要职能</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="jobDept" name="job" placeholder="主要职能">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="deptSave();">保存</button>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/core/corpManager.js"></script>
</body>
</html>
