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
    <title>Full Search - CustomerList</title>
    <script type="text/javascript">
        var basePath = "<%=basePath%>";
        $(document).ready(function () {
            $("#docLi").addClass("nav-active");
            $("#customerLi").addClass("active");
        });
    </script>
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/bootstrapValidator.min.js"></script>
    <link type="text/css" src="<%=basePath%>frame/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/manager/customerList.js"></script>
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
                <li>基础设置</li>
                <li class="active">区域和国家</li>
            </ul>
        </div>
        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
        <div class="wrapper">

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            客户管理
                        </header>
                        <div class="panel-body">
                            <table id="grid-data" class="table-hover general-table">
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
        <!--body wrapper end-->
        <jsp:include page="${basePath}../include/manager/bottom.jsp" flush="true"/>
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
                        <label for="email" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email" name="email" disabled  placeholder="请输入用户名">
                        </div>

                        <label for="sex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sex" name="sex" disabled  placeholder="性别">

                        </div>
                        <%--<label for="birthday" class="col-sm-2 control-label">出生年月</label>--%>
                        <%--<div class="col-sm-2">--%>
                            <%--<input type="text" class="form-control" disabled id="birthday" placeholder="请输入出生年月">--%>
                        <%--</div>--%>
                    </div>
                    <div class="form-group">
                        <label for="idcard" class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="idcard" name="theme" disabled>
                        </div>
                        <%--<label for="addr" class="col-sm-2 control-label">居住地</label>--%>
                        <%--<div class="col-sm-2">--%>
                            <%--<input type="text" class="form-control" id="addr" disabled >--%>
                        <%--</div>--%>
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
                        <div class="col-sm-3">
                            <div id="cnStatusDiv" class="input-group">
                                <input type="text" class="form-control" id="companyName" disabled>
                                <div class="input-group-btn">
                                    <label for="companyNameStatus" class="sr-only col-sm-2 control-label">是否启用</label>
                                    <div>
                                        <select id="companyNameStatus" name="companyNameStatus" onchange="changeColor()" class="form-control">
                                            <option value="-1">不通过</option>
                                            <option value="0">待审</option>
                                            <option value="1">通过</option>
                                        </select>
                                    </div></div>
                                <!-- <div class="input-group-btn">
                                  <button type="button" class="btn btn-default dropdown-toggle form-control" data-toggle="dropdown"><i class="fa fa-bars"></i> <span class="caret"></span></button>
                                  <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                    <li><a href="#">通过</a></li>
                                    <li><a href="#">待审</a></li>
                                    <li><a href="#">不通过</a></li>
                                  </ul>
                                </div> --><!-- /btn-group -->
                            </div><!-- /input-group -->
                        </div>

                        <label for="companyAddress" class="col-sm-2 control-label">公司地址</label>
                        <div class="col-sm-3">
                            <div id="caStatusDiv" class="input-group">
                                <input type="text" class="form-control" id="companyAddress" disabled placeholder="请输入公司地址">
                                <div class="input-group-btn">
                                    <label for="companyAddressStatus" class="sr-only col-sm-2 control-label">是否启用</label>
                                    <div>
                                        <select id="companyAddressStatus" name="companyAddressStatus" onchange="changeColor()" class="form-control">
                                            <option value="-1">不通过</option>
                                            <option value="0">待审</option>
                                            <option value="1">通过</option>
                                        </select>
                                    </div></div>
                                <!-- <div class="input-group-btn">
                                  <button type="button" class="btn btn-default dropdown-toggle form-control" data-toggle="dropdown"><i class="fa fa-bars"></i> <span class="caret"></span></button>
                                  <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                    <li><a href="#">通过</a></li>
                                    <li><a href="#">待审</a></li>
                                    <li><a href="#">不通过</a></li>
                                  </ul>
                                </div> -->
                            </div>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="companyPhone" class="col-sm-2 control-label">公司电话</label>
                        <div class="col-sm-3">
                            <div id="cpStatusDiv" class="input-group">
                                <input type="text" class="form-control" id="companyPhone" disabled placeholder="请输入公司电话">
                                <div class="input-group-btn">
                                    <label for="companyPhoneStatus" class="sr-only col-sm-2 control-label">是否启用</label>
                                    <div>
                                        <select id="companyPhoneStatus" name="companyPhoneStatus" onchange="changeColor()" class="form-control">
                                            <option value="-1">不通过</option>
                                            <option value="0">待审</option>
                                            <option value="1">通过</option>
                                        </select>
                                    </div></div>
                            </div>
                        </div>
                        <label for="position" class="col-sm-2 control-label">职位</label>
                        <div class="col-sm-3">
                            <div id="positionDiv" class="input-group">
                                <input type="text" class="form-control" id="position" disabled placeholder="请输入职位">
                                <div class="input-group-btn">
                                    <div>
                                        <select id="positionStatus" name="positionStatus" onchange="changeColor()" class="form-control">
                                            <option value="-1">不通过</option>
                                            <option value="0">待审</option>
                                            <option value="1">通过</option>
                                        </select>
                                    </div></div>
                            </div>
                        </div>
                    </div>
                    <hr/>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <%--onclick="editEnable();"--%>
                            <button class="btn btn-sm btn-primary" id="isEnable" type="button" disabled></button>
                            <button class="btn btn-sm btn-primary" id="hasNoCheck" type="button" onclick="editCheckStatus_query();">确定 </button>
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
