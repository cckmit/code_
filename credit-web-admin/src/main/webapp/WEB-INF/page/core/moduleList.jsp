<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="模块列表"/>
    </jsp:include>
</head>

<body class="mainFrame">
<section>
    <div class="wrapper">
        <div class="row">
            <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        查询结果
                        <button class="btn btn-sm btn-info" onclick="addModule()"><i class="fa fa-plus"></i></button>
                        <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                            </span>
                    </header>
                    <div class="panel-body">
                        <table id="grid-data" class="table-hover general-table">
                            <thead>
                            <tr>
                                <th data-column-id="id" data-type="numeric" data-order="asc">ID</th>
                                <th data-column-id="name" data-type="string" >模块名称</th>
                                <th data-column-id="enable" data-formatter="enable" data-type="string" >是否启用</th>
                                <th data-column-id="operate" data-formatter="operate" data-type="string">
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

</section>



<div id="addModuleModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="continentModalLabel">添加模块</h4>
            </div>
            <div class="modal-body">
                <form id="addModuleForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">模块名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入模块名称" required>
                        </div>
                        <label class="col-sm-2 control-label">是否启用</label>
                        <div class="col-sm-4">
                            <select id="enable" name="enable" class="input-large form-control" required>
                                <option></option>
                                <option value="true">是</option>
                                <option value="false">否</option>
                            </select>
                        </div>
                    </div>
                    <hr/>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="addModuleList();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<div id="upModuleModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="continentModalLabel1">修改模块信息</h4>
            </div>
            <div class="modal-body">
                <form id="upModuleForm" class="form-horizontal validateForm" role="form">
                    <input type="hidden" id="id1" name="id">
                    <input type="hidden" id="createPerson1" name="createPerson">
                    <input type="hidden" id="createTime1" name="createTime">
                    <div class="form-group">
                        <label for="name1" class="col-sm-2 control-label">模块名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name1" name="name" placeholder="请输入模块名称" required>
                        </div>
                        <label class="col-sm-2 control-label">是否启用</label>
                        <div class="col-sm-4">
                            <select id="enable1" name="enable" class="input-large form-control" required>
                                <option></option>
                                <option value="true">是</option>
                                <option value="false">否</option>
                            </select>
                        </div>
                    </div>
                    <hr/>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="upModuleList();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/script.jsp" flush="false"/>

<script src="${pageContext.request.contextPath}/js/core/moduleList.js"></script>
</body>
</html>

