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
    <title>Full Search - ReginAndCountry</title>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    $(document).ready(function () {
        $("#basicLi").addClass("nav-active");
        $("#regionAndCountryLi").addClass("active");
    });
</script>
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/bootstrapValidator.min.js"></script>
    <link type="text/css" src="<%=basePath%>frame/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/manager/regionAndCountry.js"></script>
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
            <section class="panel">
                <header class="panel-heading">
                    选择一个区域
                    <button class="btn btn-sm btn-info" onclick="editContinent(-1)"><i class="fa fa-plus"></i></button>
                    <button class="btn btn-sm btn-warning" onclick="editContinent()"><i class="fa fa-edit"></i></button>
                    <button class="btn btn-sm btn-danger" onclick="continentDel()"><i class="fa fa-minus"></i></button>
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
                </header>
                <div class="panel-body selRegion" style="display: block;" id="selRegion">
                </div>
            </section>

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            国家查询
                            <button class="btn btn-sm btn-primary" onclick="query();">查询</button>
                            <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form">
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-lg-1 col-sm-2 control-label">中文名</label>
                                        <div class="col-lg-3 col-sm-2">
                                            <input id="cnName" type="text" style="width: 200px" class="form-control" placeholder="中文名"/>
                                        </div>
                                        <label class="col-lg-1 col-sm-2 control-label">英文名</label>
                                        <div class="col-lg-3 col-sm-2">
                                            <input id="enName" type="text" style="width: 200px" class="form-control" placeholder="英文名"/>
                                        </div>
                                        <label class="col-lg-1 col-sm-2 control-label">是否启用</label>
                                        <div class="col-lg-3 col-sm-2">
                                            <select id="isEnable" style="width: 120px" class="form-control">
                                                <option></option>
                                                <option value="是">是</option>
                                                <option value="否">否</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            国家列表
                            <button class="btn btn-sm btn-info" onclick="editCountry(-1)"><i class="fa fa-plus"></i></button>
                        </header>
                        <div class="panel-body">
                            <table id="grid-data" class="table table-hover general-table">
                            <thead>
                            <tr>
                                <th data-column-id="id" data-type="numeric" data-identifier="true" data-order="asc" data-visible="false">ID</th>
                                <th data-column-id="code" data-type="string" data-width="10%">编码</th>
                                <th data-column-id="cnName" data-formatter="createDate" data-type="string" data-width="30%">
                                    中文名
                                </th>
                                <th data-column-id="enName" data-type="string" data-width="30%">英文名</th>
                                <th data-column-id="isEnable" data-type="string" data-width="10%">是否启用</th>
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
<div id="continentModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="continentModalLabel">区域编辑</h4>
            </div>
            <div class="modal-body">
                <form id="continentForm" class="form-horizontal" role="form">
                    <input type="hidden" id="idContinent" name="id">
                    <div class="form-group">
                        <label for="enNameContinent" class="col-sm-2 control-label">英文名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="enNameContinent" name="enName" placeholder="请输入英文名" data-bv-notempty data-bv-notempty-message="请输入英文名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cnNameContinent" class="col-sm-2 control-label">中文名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cnNameContinent" name="cnName" placeholder="请输入中文名" data-bv-notempty data-bv-notempty-message="请输入中文名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="isEnableContinent" class="col-sm-2 control-label">是否启用</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="isEnableContinent" name="isEnable" data-bv-notempty data-bv-notempty-message="请选择是否启用">
                                <option value="是" selected="selected">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="continentSave();">保存</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>
<div id="countryModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content"  style="width:1000px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="countryModalLabel">国家详情</h4>
            </div>
            <div class="modal-body">
                <form id="countryForm" class="form-horizontal" role="form">
                    <input type="hidden" id="idCountry" name="id">
                    <div class="form-group">
                        <label for="codeCountry" class="col-sm-2 control-label">编码</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="codeCountry" name="code" placeholder="请输入编码" data-bv-notempty data-bv-notempty-message="请输入编码">
                        </div>
                        <label for="enNameCountry" class="col-sm-2 control-label">英文名</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="enNameCountry" name="enName" placeholder="请输入英文名" data-bv-notempty data-bv-notempty-message="请输入英文名">
                        </div>
                        <label for="cnNameCountry" class="col-sm-2 control-label">中文名</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="cnNameCountry" name="cnName" placeholder="请输入中文名" data-bv-notempty data-bv-notempty-message="请输入中文名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="continentIdCountry" class="col-sm-2 control-label">所属区域</label>
                        <div class="col-sm-2">
                            <select id="continentIdCountry" name="continentId" class="form-control" data-bv-notempty data-bv-notempty-message="请选择所属区域">

                            </select>
                        </div>
                        <label for="isEnableCountry" class="col-sm-2 control-label">是否启用</label>
                        <div class="col-sm-2">
                            <select id="isEnableCountry" name="isEnable" class="form-control" data-bv-notempty data-bv-notempty-message="请选择是否启用">
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <hr/>
                    <h4>在线价格</h4>
                    <div class="form-group">
                        <label for="cnyCountry" class="col-sm-2 control-label">人民币</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="cnyCountry" placeholder="请输入人民币">
                        </div>
                        <label for="usdCountry" class="col-sm-2 control-label">美元</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="usdCountry" placeholder="请输入美元">
                        </div>
                        <label for="eurCountry" class="col-sm-2 control-label">欧元</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="eurCountry" placeholder="请输入欧元">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cnyDCountry" class="col-sm-2 control-label">人民币（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="cnyDCountry" placeholder="请输入人民币">
                        </div>
                        <label for="usdDCountry" class="col-sm-2 control-label">美元（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="usdDCountry" placeholder="请输入美元">
                        </div>
                        <label for="eurDCountry" class="col-sm-2 control-label">欧元（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="eurDCountry" placeholder="请输入欧元">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="normalDays" class="col-sm-2 control-label">普通制作时间</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="normalDays" placeholder="请输入普通制作天数">
                        </div>
                        <label for="fastDays" class="col-sm-2 control-label">加急制作时间</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="fastDays" placeholder="请输入加急制作天数">
                        </div>
                    </div>
                    <hr/>
                    <h4>完整版在线价格</h4>
                    <div class="form-group">
                        <label for="cnyCountry" class="col-sm-2 control-label">人民币</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="cnyFullCountry" placeholder="请输入人民币">
                        </div>
                        <label for="usdCountry" class="col-sm-2 control-label">美元</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="usdFullCountry" placeholder="请输入美元">
                        </div>
                        <label for="eurCountry" class="col-sm-2 control-label">欧元</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="eurFullCountry" placeholder="请输入欧元">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cnyDCountry" class="col-sm-2 control-label">人民币（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="cnyFullDCountry" placeholder="请输入人民币">
                        </div>
                        <label for="usdDCountry" class="col-sm-2 control-label">美元（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="usdFullDCountry" placeholder="请输入美元">
                        </div>
                        <label for="eurDCountry" class="col-sm-2 control-label">欧元（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="eurFullDCountry" placeholder="请输入欧元">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="normalDays" class="col-sm-2 control-label">普通制作时间</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="normalFullDays" placeholder="请输入普通制作天数">
                        </div>
                        <label for="fastDays" class="col-sm-2 control-label">加急制作时间</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="fastFullDays" placeholder="请输入加急制作天数">
                        </div>
                    </div>
                    <hr/>
                    <h4>离线价格</h4>
                    <div class="form-group">
                        <label for="cnyOffCountry" class="col-sm-2 control-label">人民币</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="cnyOffCountry" placeholder="请输入人民币">
                        </div>
                        <label for="usdOffCountry" class="col-sm-2 control-label">美元</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="usdOffCountry" placeholder="请输入美元">
                        </div>
                        <label for="eurOffCountry" class="col-sm-2 control-label">欧元</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="eurOffCountry" placeholder="请输入欧元">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cnyOffDCountry" class="col-sm-2 control-label">人民币（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="cnyOffDCountry" placeholder="请输入人民币">
                        </div>
                        <label for="usdOffDCountry" class="col-sm-2 control-label">美元（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="usdOffDCountry" placeholder="请输入美元">
                        </div>
                        <label for="eurOffDCountry" class="col-sm-2 control-label">欧元（加急）</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="eurOffDCountry" placeholder="请输入欧元">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="normalOffDays" class="col-sm-2 control-label">普通制作时间</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="normalOffDays" placeholder="请输入普通制作天数">
                        </div>
                        <label for="fastOffDays" class="col-sm-2 control-label">加急制作时间</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="fastOffDays" placeholder="请输入加急制作天数">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" type="button" onclick="countrySave();">保存</button>
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
