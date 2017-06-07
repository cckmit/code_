<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Full Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>/js/indexAddition/additional1.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    var continents = ${continents};
    var country = "${country}";
    var continent = "${continent}";
    function buttonClick() {
        BootstrapDialog.alert("该功能即将开放!");
    }
</script>
<body>
<jsp:include page="${basePath}../include/topIndex.jsp"/>
<div class="container">
    <div class="col-lg-12" style="height: 50px;background-color: #7ea8e1; text-align: center">
        <p class="lead" style="color: white">本功能正在调试，即将开放！</p>
    </div>
    <div>
        <p class="lead">全球商业认证服务</p>
        <p>全球鹰整合全球多个实地认证机构及当地运营公司，提供专业的商业认证服务。
            根据您的要求，实地审核目标企业的真实性、生产设备能力、品质管理等重要指标，并快速出具评估报告。
            帮助您全面直观地了解认证对象，鉴别和筛选优质的商业合作伙伴。</p></div>
    <div class="row">
        <div class="col-lg-4">
            <div class="bs-component">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th>电话认证</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>法律注册</td>
                    </tr>
                    <tr>
                        <td>电话确认</td>
                    </tr>
                    <tr>
                        <td>人员核实</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="bs-component">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th>实地认证</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>经营场所</td>
                    </tr>
                    <tr>
                        <td>生产设备能力</td>
                    </tr>
                    <tr>
                        <td>证书文件</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
        <div class="col-lg-4">
            <div class="bs-component">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th>特殊认证</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>技术及质量认证</td>
                    </tr>
                    <tr>
                        <td>生产环境及保护</td>
                    </tr>
                    <tr>
                        <td>社会责任（人权）</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
    </div>


    <div class="row">
        <div class="col-lg-12">
            <div class="well bs-component">
                <form class="form-horizontal" action="creditAdditional1.do" method="post">
                    <fieldset>
                        <legend>认证需求</legend>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">选择认证类型</label>

                            <div class="col-lg-2">
                                <div class="radio">
                                    <label>
                                        <input name="creditChoose" id="optionsRadios1" value="电话认证"
                                               checked="checked" type="radio">
                                        电话认证
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-2">

                                <div class="radio">
                                    <label>
                                        <input name="creditChoose" id="optionsRadios2" value="实地认证" type="radio">
                                        实地认证
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-3">

                                <div class="radio">
                                    <label>
                                        <input name="creditChoose" id="optionsRadios3" value="特殊认证" type="radio">
                                        特殊认证
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">选择国家地区</label>

                            <div class="col-lg-3">
                                <div class="radio">
                                    <select class="form-control" id="continent" name="continent" onchange="onContinentChange();" required>
                                        <option selected="selected" value="">选择洲/区域</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="radio">
                                    <select class="form-control" id="company_country" name="country" required>
                                        <option selected="selected" value="">选择国家/地区</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="companyName" class="col-lg-2 control-label">目标公司名称</label>
                            <div class="col-lg-10">
                                <input class="form-control" id="companyName" name="companyName" placeholder="公司名称" type="text" value="${creditServices.companyName}" required>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-lg-2 control-label">目标公司信息</label>
                            <div class="col-lg-3">
                                <div class="radio">
                                    <input class="form-control" id="companyPhone" name="companyPhone" placeholder="联系电话" type="text" value="${creditServices.companyPhone}" required>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="radio">
                                    <input class="form-control" id="companyWebsite" name="companyWebsite" placeholder="网址" type="text" value="${creditServices.companyName}" >
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="radio">
                                    <input class="form-control" id="companyEmail" name="companyEmail" placeholder="邮箱" type="text" value="${creditServices.companyEmail}" >
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="companyAddOther" class="col-lg-2 control-label">地址及其他信息</label>
                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="companyAddOther" name="companyAddOther">${creditServices.companyAddOther}</textarea>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="enableOrder" value="true"> 是否订制过目标企业商业资信报告
                                    </label>
                                </div>
                            </div>
                        </div>
                        <legend></legend>

                        <div class="form-group">
                            <label class="col-lg-2 control-label" for="name">您的信息</label>
                            <div class="col-lg-3">
                                <div class="radio">
                                    <input class="form-control" id="name" name="name" placeholder="姓名" type="text" value="${creditServices.name}" required>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="radio">
                                    <input class="form-control" id="phone" name="phone" placeholder="电话/手机" type="text" value="${creditServices.phone}" required>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="radio">
                                    <input class="form-control" id="email" name="email" placeholder="邮箱" type="text" value="${creditServices.email}" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="comment" class="col-lg-2 control-label">备注其他信息</label>
                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="comment" name="comment" ></textarea>
                                <div class="checkbox">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button type="reset" class="btn btn-default">重置表单</button>
                                <%--<button type="submit" class="btn btn-primary">提交表单</button>--%>
                                <button type="button" class="btn btn-primary" onclick="buttonClick()">提交表单</button>

                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

</div>

<jsp:include page="${basePath}../include/bottom.jsp"/>
</body>
</html>