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
    <link href="${pageContext.request.contextPath}/frame/js/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">

</head>



<body class="mainFrame">

<div class="wrapper">
    <section class="panel">

        <header class="panel-heading">
            用户查询
            <button class="btn btn-sm btn-primary" onclick="query();">查询</button>
            <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
        </header>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="row">
                    <div class="form-group">
                        <label class="col-lg-1 col-sm-2 control-label">登录名</label>
                        <div class="col-lg-5 col-sm-4">
                            <input id="username" name="username" type="text" class="form-control"
                                   placeholder="登录名"/>
                        </div>
                        <label class="col-lg-1 col-sm-2 control-label">创建日期</label>
                        <div class="col-lg-5 col-sm-4">
                            <input type="date" id="createTime" name="createTime" class="form-control" placeholder="创建日期">
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
                    用户&nbsp;
                    <button class="btn btn-sm btn-info" onclick="addCManager()"><i class="fa fa-plus"></i></button>
                </header>
                <div class="panel-body" style="display: block;">
                    <table id="grid-data" class="table table-hover general-table">
                        <thead>
                        <tr>
                            <th data-column-id="id" data-width="5%" data-type="string" data-visible="false">ID</th>
                            <th data-column-id="username" data-width="10%" data-type="string">登录名</th>
                            <th data-column-id="name" data-width="10%" data-type="string">姓名</th>
                            <th data-column-id="email" data-width="15%" data-type="string">邮箱</th>
                            <th data-column-id="mobile" data-width="15%" data-type="string">手机号码</th>
                            <th data-column-id="loginCount" data-width="10%" data-type="string">登陆次数</th>
                            <th data-column-id="createTime" data-width="15%" data-formatter="formatCreateTime">创建时间</th>
                            <th data-column-id="operate" data-width="20%" data-formatter="operate"
                                data-sortable="false">操作
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


<div id="addManagerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content" style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="addCountryModalLabel">添加用户</h4>
            </div>
            <div class="modal-body">
                <form id="addCountryForm1" class="form-horizontal validateForm">
                    <div class="form-group">
                        <label for="username1" class="col-sm-2 control-label">*登录名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="username1" name="username" placeholder="请输入登录名"
                                   required>
                        </div>
                        <label for="name1" class="col-sm-2 control-label">*名字</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name1" name="name" placeholder="请输入名字" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="selCorpDept1" class="col-sm-2 control-label">所属机构</label>
                        <div class="col-sm-4">
                            <select name="corp.id" class="form-control" id="selCorpDept1" onchange="changeCorp(this.options[this.options.selectedIndex].value)" data-bv-notempty>
                            </select>
                        </div>
                        <label for="selDept1" class="col-sm-2 control-label">所属部门</label>
                        <div class="col-sm-4">
                            <select name="dept.id" class="form-control" id="selDept1" data-bv-notempty>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email1" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" id="email1" name="email" placeholder="邮箱" required>
                        </div>
                        <label for="theme1" class="col-sm-2 control-label">主题</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="theme1" name="theme" placeholder="主题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="sex1" name="sex">
                                <option value="">请选择</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                        <label for="birthday1" class="col-sm-2 control-label">出生年月</label>
                        <div class="col-sm-4">
                            <input type="date" class="form-control" id="birthday1" name="birthday" placeholder="出生年月">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idcard1" class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="idcard1" name="idcard" placeholder="身份证号">
                        </div>
                        <label for="bornPlace1" class="col-sm-2 control-label">户籍</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bornPlace1" name="bornPlace" placeholder="户籍">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addr1" class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addr1" name="addr" placeholder="地址">
                        </div>
                        <label for="selGroup1" class="col-sm-2 control-label">组</label>
                        <div class="col-sm-4">
                            <select id="selGroup1" name="groups.id" class="selectpicker form-control" multiple>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile1" class="col-sm-2 control-label">手机号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mobile1" name="mobile" placeholder="手机号码">
                        </div>
                        <label for="phone1" class="col-sm-2 control-label">家庭电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="phone1" name="phone" placeholder="家庭电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sosPerson1" class="col-sm-2 control-label">紧急联系人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sosPerson1" name="sosPerson"
                                   placeholder="紧急联系人">
                        </div>
                        <label for="sosMobile1" class="col-sm-2 control-label">紧急联系人手机</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sosMobile1" name="sosMobile"
                                   placeholder="紧急联系人手机">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="otherContact1" class="col-sm-2 control-label">其它联系方式</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="otherContact1" name="otherContact"
                                   placeholder="其它联系方式">
                        </div>
                        <label for="createBy1" class="col-sm-2 control-label">创建人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="createBy1" name="createBy"value="${sessionScope.managerName}" disabled>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" id="hasNoCheck1" type="button"
                                    onclick="addManagerList()">添加
                            </button>
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
        <div class="modal-content" style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="uodManagerModalLabel">修改用户</h4>
            </div>
            <div class="modal-body">
                <form id="updManagerForm1" class="form-horizontal validateForm">
                    <input type="hidden" id="id2" name="id">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="username2" class="col-sm-2 control-label">*登录名</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="username2" name="username"
                                       placeholder="请输入登录名"
                                       required>
                            </div>
                            <label for="name2" class="col-sm-2 control-label">*名字</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="name2" name="name" placeholder="请输入名字"
                                       required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="selCorpDept2" class="col-sm-2 control-label">所属机构</label>
                            <div class="col-sm-4">
                                <select name="corp.id" class="form-control" id="selCorpDept2" onchange="changeCorp(this.options[this.options.selectedIndex].value)" data-bv-notempty required>
                                </select>
                            </div>
                            <label for="selDept2" class="col-sm-2 control-label">所属部门</label>
                            <div class="col-sm-4">
                                <select name="dept.id" class="form-control" id="selDept2" data-bv-notempty required>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email2" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="email2" name="email" disabled>
                            </div>
                            <label class="col-sm-2 control-label">是否锁定</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="locked2" name="locked">
                                    <option value="">请选择</option>
                                    <option value="true">是</option>
                                    <option value="false">否</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="sex2" name="sex">
                                    <option value="">请选择</option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                            <label for="birthday2" class="col-sm-2 control-label">出生年月</label>
                            <div class="col-sm-4">
                                <input type="date" class="form-control" id="birthday2" name="birthday"
                                       placeholder="出生年月">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bornPlace2" class="col-sm-2 control-label">户籍</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="bornPlace2" name="bornPlace"
                                       placeholder="户籍">
                            </div>
                            <label for="idcard2" class="col-sm-2 control-label">身份证号</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="idcard2" name="idcard" placeholder="身份证号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addr2" class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="addr2" name="addr" placeholder="地址">
                            </div>
                            <label for="selGroup2" class="col-sm-2 control-label">组</label>
                            <div class="col-sm-4">
                                <select id="selGroup2" name="groups.id" class="selectpicker form-control" multiple required>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mobile2" class="col-sm-2 control-label">手机号码</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="mobile2" name="mobile" placeholder="手机号码">
                            </div>
                            <label for="phone2" class="col-sm-2 control-label">家庭电话</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="phone2" name="phone" placeholder="家庭电话">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sosPerson2" class="col-sm-2 control-label">紧急联系人</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="sosPerson2" name="sosPerson"
                                       placeholder="紧急联系人">
                            </div>
                            <label for="sosMobile2" class="col-sm-2 control-label">紧急联系人手机</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="sosMobile2" name="sosMobile"
                                       placeholder="紧急联系人手机">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="otherContact2" class="col-sm-2 control-label">其它联系方式</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="otherContact2" name="otherContact"
                                       placeholder="其它联系方式">
                            </div>
                            <label for="createBy2" class="col-sm-2 control-label">创建人</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="createBy2" name="createBy" disabled="disabled">
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="col-sm-12 text-center">
                                <button class="btn btn-sm btn-primary" id="hasNoCheck2" type="button"
                                        onclick="updManagerList()">保存
                                </button>
                                <button class="btn btn-sm btn-primary" id="hasNoCheck3" type="button"
                                        onclick="updManagerPwd()">重置密码
                                </button>
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

<jsp:include page="../include/script.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/bootstrap-select/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/bootstrap-select/js/i18n/defaults-zh_CN.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/core/userManager.js"></script>
</body>
</html>
