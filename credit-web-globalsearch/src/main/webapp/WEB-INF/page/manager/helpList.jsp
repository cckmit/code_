<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
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
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/bootstrapValidator.min.js"></script>
    <link type="text/css" src="<%=basePath%>frame/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/manager/helpList.js"></script>
    <!--导入ckEditor-->
    <jsp:include page="${basePath}../include/ckEditor.jsp" flush="true"/>
    <title>Full Search - Help</title>
    <script type="text/javascript">
        var basePath = "<%=basePath%>";
        $(document).ready(function(){
            $("#docLi").addClass("nav-active");
            $("#helpLi").addClass("active");

            //设置高度和宽度，初始化在线编辑器
            CKEDITOR.config.width = '100%';
            CKEDITOR.config.height = '400px';
            initCKEditor("contentHelp","");//编辑器ID，初始化内容
        });
    </script>
</head>
<body class="sticky-header">

<section>
    <jsp:include page="${basePath}../include/manager/left.jsp" flush="true"/>
    <div class="main-content">
        <jsp:include page="${basePath}../include/manager/top.jsp" flush="true"/>
        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>文档中心</li>
                <li class="active">帮助文档</li>
            </ul>
        </div>
        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-4">
                    <section class="panel">
                        <header class="panel-heading">
                            帮助分类
                            <button class="btn btn-sm btn-info" onclick="editHelpCate(-1)"><i class="fa fa-plus"></i></button>
                            <button class="btn btn-sm btn-warning" onclick="editHelpCate()"><i class="fa fa-edit"></i></button>
                            <button class="btn btn-sm btn-danger" onclick="helpCateDel()"><i class="fa fa-minus"></i></button>
                        </header>
                        <div class="panel-body" style="display: block;">
                            <ul class="nav nav-pills nav-stacked" id="selHelpCate">
                            </ul>
                        </div>
                    </section>
                </div>
                <div class="col-lg-9 col-md-8 col-sm-8">

                    <section class="panel">
                        <header class="panel-heading">帮助列表
                            <button class="btn btn-sm btn-info" onclick="editHelp(-1)"><i class="fa fa-plus"></i></button>
                        </header>
                        <div class="panel-body" style="display: block;">
                            <table id="grid-data" class="table table-hover general-table">
                                <thead>
                                <tr>
                                    <th data-column-id="id" data-type="numeric" data-identifier="true" data-order="asc" data-visible="false">ID</th>
                                    <th data-column-id="title" data-type="string" data-width="100%">标题</th>
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
<div id="helpCateModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="helpCateModalLabel">分类编辑</h4>
            </div>
            <div class="modal-body">
                <form id="helpCateForm" class="form-horizontal" role="form">
                    <input type="hidden" id="idHelpCate" name="id">
                    <div class="form-group">
                        <label for="nameHelpCate" class="col-sm-2 control-label">分类名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nameHelpCate" name="enName" placeholder="请输入分类名" data-bv-notempty data-bv-notempty-message="请输入分类名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="helpCateSave();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>
<div id="helpModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 90%; height:90%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="countryModalLabel">帮助</h4>
            </div>
            <div class="modal-body">
                <form id="helpForm" class="form-horizontal" role="form">
                    <input type="hidden" id="idHelp" name="id">
                    <div class="form-group">
                        <label for="selCate" class="col-sm-2 control-label">所属分类</label>
                        <div class="col-sm-10">
                            <select name="cate.id" class="form-control" id="selCate" data-bv-notempty data-bv-notempty-message="请选择所属分类">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="titleHelp" class="col-sm-2 control-label">标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="titleHelp" name="title" placeholder="请输入标题" data-bv-notempty data-bv-notempty-message="请输入标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="contentHelp" class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-10">
                            <textarea cols="15" rows="40" class="form-control" id="contentHelp" name="content" placeholder="请输入内容" data-bv-notempty data-bv-notempty-message="请输入内容"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="helpSave();">保存</button>
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