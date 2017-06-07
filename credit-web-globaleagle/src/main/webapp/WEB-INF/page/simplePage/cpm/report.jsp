<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String type = request.getParameter("type");
    if(type==null||type.equals("")){
        type = "1";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>${companyName}</title>
    <script src="${pageContext.request.contextPath}/js/htmlSaveAs.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <script src="<%=basePath%>frame/jquery-1.10.2.min.js"></script>


    <style>
        .btn-update {
            margin-top: -5px;
        }
    </style>
    <script type="text/javascript">
        var sendUrl = '';
        $(document).ready(function () {
            test = document.getElementsByTagName('html')[0].outerHTML;
            email = "${email}";
            crefoNo = "${crefoNo}";
            customerId = "${customerId}";
            sendUrl = "<%=basePath%>customer/html/viewReportV1.do" ;
        });
        function searchCompany(companyName) {
            window.open(basePath + "toSearchCompanyList.do?countryName=中国&companyName=" + companyName,"_blank");
//            window.location.href = basePath+"toSearchCompanyList.do?countryName=中国&companyName="+companyName;
        }

        function credit() {
            window.open(basePath + "toIndexAddition1.do?country=" + '${cnName}' + "&companyName=" + '${companyName}' + "&companyPhone=" + '${basic.tel}' + "&companyWebsite=" + '${basic.website}' + "&companyEmail=" + '${basic.email}' + "&companyAdd=" + '${basic.addressCN}',"_blank");
        }

        function screen(choose) {
            if (choose == 1) {
                checkOff();
                $("#allZxgg").attr("checked", true);
                $("tr[name='裁判文书']").show();
                $("tr[name='法院公告']").show();
                $("tr[name='开庭公告']").show();
                $("tr[name='执行公告']").show();
                $("tr[name='案件流程']").show();

            } else if (choose == 2) {
                allHide();
                checkOff();
                $("#pjws").attr("checked", true);
                $("tr[name='裁判文书']").show();

            } else if (choose == 3) {
                allHide();

                checkOff();
                $("#fygg").attr("checked", true);
                $("tr[name='法院公告']").show();

            } else if (choose == 4) {
                allHide();

                checkOff();
                $("#ktjl").attr("checked", true);
                $("tr[name='开庭公告']").show();

            } else if (choose == 5) {
                allHide();

                checkOff();
                $("#zxjl").attr("checked", true);
                $("tr[name='执行公告']").show();

            } else if (choose == 6) {
                allHide();

                checkOff();
                $("#ajlc").attr("checked", true);
                $("tr[name='案件流程']").show();

            } else {
                allHide();
                checkOff();
            }
        }

        function checkOff() {
            $("#allZxgg").attr("checked", false);
            $("#pjws").attr("checked", false);
            $("#fygg").attr("checked", false);
            $("#ktjl").attr("checked", false);
            $("#zxjl").attr("checked", false);
            $("#ajlc").attr("checked", false);
        }

        function allHide() {
            $("tr[name='裁判文书']").hide();
            $("tr[name='法院公告']").hide();
            $("tr[name='开庭公告']").hide();
            $("tr[name='执行公告']").hide();
            $("tr[name='案件流程']").hide();
        }

        function allShow() {
            $("tr[name='裁判文书']").show();
            $("tr[name='法院公告']").show();
            $("tr[name='开庭公告']").show();
            $("tr[name='执行公告']").show();
            $("tr[name='案件流程']").show();
        }


        function judicialDetail(dataType,id){
            var senddata = {
                "dataType":dataType,
                "id":id
            };
            $.ajax({
                type:"POST",
                url:basePath+"customer/judicialDetail.do",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(senddata),
                success:function(data){
                    BootstrapDialog.alert(data);
                }
            });
        }
    </script>

</head>
<body>

<jsp:include page="../include/report/top2.jsp"/>

<div class="container">


    <div class="row">

        <div class="bs-component">
            <ul class="nav nav-tabs">
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=1&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#home" data-toggle="tab">公司概况</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=2&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab02" data-toggle="tab">法律注册</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=3&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab03" data-toggle="tab">股东结构</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=4&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab04" data-toggle="tab">关联公司</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=5&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab05" data-toggle="tab">财务数据</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=6&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab06" data-toggle="tab">司法信息</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=7&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab07" data-toggle="tab">负面信息</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=8&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab08" data-toggle="tab">运营信息</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/html/viewReportV1.do?type=9&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab09" data-toggle="tab">其他信息</a></li>
                <li class="dropdown">
                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="dropdown" href="#">
                        公共信息 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>simple/customer/html/viewReportV1.do?type=11&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#dropdown1" data-toggle="tab">媒体记录</a></li>
                        <li><a href="<%=basePath%>simple/customer/html/viewReportV1.do?type=12&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#dropdown2" data-toggle="tab">ICP备案</a></li>
                        <li><a href="<%=basePath%>simple/customer/html/viewReportV1.do?type=13&crefoNo=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#dropdown3" data-toggle="tab">专利及资质</a></li>

                    </ul>
                </li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <%
                    if(type.equals("1")){
                %>
                <div class="tab-pane fade active in" id="home">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="12%" class="formleft"><strong>注册名称</strong></td>
                            <td width="38%" class="formright">
                                <div align="left">${companyName}</div>
                            </td>
                            <td width="12%" class="formright">&nbsp;</td>
                            <td width="38%" class="formright">
                                <div align="left"></div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>英文名称</strong></td>
                            <td class="formright">
                                <div align="left">${basic.nameEN}</div>
                            </td>
                            <td class="formright">&nbsp;</td>
                            <td class="formright">
                                <div align="left"></div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>贸易名称</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                            <td class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft">&nbsp;</td>
                            <td class="formright">&nbsp;</td>
                            <td class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>运营地址</strong></td>
                            <td class="formright">${basic.addressCN}${basic.streetCN} </td>
                            <td class="formleft"><strong>邮编</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basic.zip}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>省份/城市</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                            <td class="formleft"><strong>电话</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basic.tel}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>网址</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basic.website}</div>
                            </td>
                            <td class="formleft"><strong>邮箱</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basic.email}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft">&nbsp;</td>
                            <td class="formright">&nbsp;</td>
                            <td class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        </tbody>
                    </table>
                    <img style="display:block;width:100%;"
                         src="${pageContext.request.contextPath}/images/creditRatingCN/<c:if test="${empty credit.resultSolvency}">0</c:if>${credit.resultSolvency}.jpg"/>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="12%" class="formleft">&nbsp;</td>
                            <td width="38%" class="formright">&nbsp;</td>
                            <td width="12%" class="formleft">&nbsp;</td>
                            <td width="38%" valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>企业现状</strong></td>
                            <td class="formright">
                                <div align="left">${reg.entstatus}</div>
                            </td>
                            <td class="formleft"><strong>风险评级</strong></td>
                            <td valign="top" class="formright">${credit.creditRating}</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>统一征信码</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${reg.creditcode}</div>
                            </td>
                            <td class="formleft"><strong>偿还指数</strong></td>
                            <td valign="top" class="formright">${credit.resultSolvency}</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>行业代码</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${reg.chinaIndustrycode}</div>
                            </td>
                            <td valign="top" class="formleft"><strong>信用额度</strong></td>
                            <td valign="top" class="formright">${credit.resultRecommended} （元）</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("2")){
                %>
                <div class="tab-pane fade active in" id="tab02">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="12%" class="formleft"><strong>法定代表人</strong></td>
                            <td width="38%" class="formright">${reg.legalNameCN}</td>
                            <td width="12%" class="formleft"><strong>企业现状</strong></td>
                            <td width="38%" valign="top" class="formright">
                                <div align="left">${reg.entstatus}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>企业性质</strong></td>
                            <td valign="top" class="formright">${reg.entOwnership}</td>
                            <td class="formleft"><strong>企业类型</strong></td>
                            <td valign="top" class="formright">${reg.enttype}</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>注册资本</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${reg.regCapital}</div>
                            </td>
                            <td class="formleft"><strong>统一征信码</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${reg.creditcode}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>注册日期</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${reg.establishDate}</div>
                            </td>
                            <td class="formleft"><strong>经营期限</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${reg.deadline}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>注册地址</strong></td>
                            <td class="formright">
                                <div align="left">${reg.addressCN}</div>
                            </td>
                            <td class="formleft"><strong>注册登记机关</strong></td>
                            <td valign="top" class="formright">${reg.registrationCN}</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>经营范围</strong></td>
                            <td colspan="3" valign="top" class="formright">
                                <div align="left">${reg.businessScopeCN}</div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">
                                <div align="left"></div>
                            </td>
                            <td valign="top" class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">
                                <table class="table table-hover table-bordered table-responsive">
                                    <thead>
                                    <tr>
                                        <th width="12%">变更日期</th>
                                        <th width="18%">变更类型</th>
                                        <th width="35%">变更前</th>
                                        <th width="35%">变更后</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${not empty changeList}">
                                        <c:forEach items="${changeList}" var="list">
                                            <tr>
                                                <td>${list.changeDate}</td>
                                                <td>${list.changeType}</td>
                                                <td>${list.beforeCN}</td>
                                                <td>${list.afterCN}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${ empty changeList}">
                                        <tr>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                        </tr>
                                    </c:if>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        </tbody>
                    </table>


                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("3")){
                %>
                <div class="tab-pane fade active in" id="tab03">


                    <table class="table table-hover table-bordered table-responsive">
                        <tbody>
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>股权</th>
                            <th>出资额</th>
                            <th>出资日期</th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>


                        <c:if test="${not empty shareList}">
                            <c:forEach items="${shareList}" var="list">
                                <tr>
                                    <td width="40%"><p><strong>${list.nameCN}</strong></p>

                                    </td>
                                    <td width="10%">${list.shares} </td>
                                    <td width="25%">${list.subconam} </td>
                                    <td width="15%">${list.condate} </td>
                                    <td width="10%">
                                        <div align="left">
                                            <div title="Page 4">
                                                <div>
                                                    <div>
                                                        <div>
                                                            <c:if test="${list.nameCN.length()>5}">
                                                                <p><strong>
                                                                    <button type="button" class="btn btn-xs btn-primary"
                                                                            onclick="searchCompany('${list.nameCN}')">
                                                                        查询该公司
                                                                    </button>
                                                                    <br>
                                                                </strong></p>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty shareList}"> </c:if>
                        </tbody>
                    </table>

                    <table class="table table-hover table-bordered table-responsive">
                        <tbody>
                        <thead>
                        <tr style="background: #fffccc">
                            <th><strong style="color: brown">${reg.year} </strong></th>
                            <th>实缴日期</th>
                            <th>实缴金额</th>
                            <th>认缴日期</th>
                            <th>认缴金额</th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>


                        <c:if test="${not empty shareReportList}">
                            <c:forEach items="${shareReportList}" var="list">
                                <tr>
                                    <td width="40%"><p><strong>${list.nameCN}</strong></p>

                                    </td>
                                    <td width="10%">${list.condate} </td>
                                    <td width="15%">${list.subconam} </td>
                                    <td width="10%">${list.rjczrq} </td>
                                    <td width="15%">${list.rjcze} </td>
                                    <td width="10%">
                                        <div align="left">
                                            <div title="Page 4">
                                                <div>
                                                    <div>
                                                        <div>
                                                            <c:if test="${list.nameCN.length()>5}">
                                                                <p><strong>
                                                                    <button type="button" class="btn btn-xs btn-primary"
                                                                            onclick="searchCompany('${list.nameCN}')">
                                                                        查询该公司
                                                                    </button>
                                                                    <br>
                                                                </strong></p>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty shareReportList}"> </c:if>
                        </tbody>
                    </table>

                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("4")){
                %>
                <div class="tab-pane fade active in" id="tab04">
                    <div class="row">

                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingOne">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                           aria-expanded="true"
                                           aria-controls="collapseOne">
                                            企业对外投资(${entinvList.size()}) </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="tab-pane fade active in" role="tabpanel"
                                     aria-labelledby="headingOne">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">出资比列</th>
                                                <th width="15%">注册资本</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司类型</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${not empty entinvList}">
                                                <c:forEach items="${entinvList}"  var="list" varStatus="status">
                                                    <tr>
                                                        <td><span
                                                                class="formleft"><strong>${list.entNameCn}</strong></span>
                                                        </td>
                                                        <td>${list.fundedRatio}</td>
                                                        <td>${list.regCapCur} ${list.regCap}</td>
                                                        <td>${list.esDate}</td>
                                                        <td>${list.entType}</td>
                                                        <td>${list.entStatus}</td>
                                                        <td><c:if test="${list.entNameCn.length()>5}">
                                                            <button type="button" class="btn btn-xs btn-primary"
                                                                    onclick="searchCompany('${list.entNameCn}')">查询该公司
                                                            </button>
                                                        </c:if></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${ empty changeList}">
                                                <tr>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingFour">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseFour"
                                           aria-expanded="false" aria-controls="collapseFour">
                                            企业分支机构（${relatedList.size()}）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseFour" class="tab-pane fade active in" role="tabpanel"
                                     aria-labelledby="headingFour">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">注册号码</th>
                                                <th width="15%">电话</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司性质</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${not empty relatedList}">
                                                <c:forEach items="${relatedList}" var="list" varStatus="status">
                                                    <tr>
                                                        <td><span
                                                                class="formleft"><strong>${list.nameCN}</strong></span>
                                                        </td>
                                                        <td>${list.reg}</td>
                                                        <td>${list.tel}</td>
                                                        <td>${list.establishDate}</td>
                                                        <td>${list.entNature}</td>
                                                        <td>${list.entStatus}</td>
                                                        <td><c:if test="${list.nameCN.length()>5}">
                                                            <button type="button" class="btn btn-xs btn-primary"
                                                                    onclick="searchCompany('${list.nameCN}')">查询该公司
                                                            </button>
                                                        </c:if></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${ empty relatedList}">
                                                <tr>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingTwo">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseTwo"
                                           aria-expanded="false" aria-controls="collapseTwo">
                                            法人对外投资（${frinvList.size()}）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="tab-pane fade active in" role="tabpanel"
                                     aria-labelledby="headingTwo">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">出资比列</th>
                                                <th width="15%">注册资本</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司类型</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${not empty frinvList}">
                                                <c:forEach items="${frinvList}" var="list" varStatus="status">
                                                    <tr>
                                                        <td><span
                                                                class="formleft"><strong>${list.entNameCn}</strong></span>
                                                        </td>
                                                        <td>${list.fundedRatio}</td>
                                                        <td>${list.regCapCur} ${list.regCap}</td>
                                                        <td>${list.esDate}</td>
                                                        <td>${list.entType}</td>
                                                        <td>${list.entStatus}</td>
                                                        <td><c:if test="${list.entNameCn.length()>5}">
                                                            <button type="button" class="btn btn-xs btn-primary"
                                                                    onclick="searchCompany('${list.entNameCn}')">查询该公司
                                                            </button>
                                                        </c:if></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${ empty changeList}">
                                                <tr>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingThree">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseThree"
                                           aria-expanded="false" aria-controls="collapseThree">
                                            法人在外任职（${frpositList.size()}）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseThree" class="tab-pane fade active in" role="tabpanel"
                                     aria-labelledby="headingThree">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">出资比列</th>
                                                <th width="15%">注册资本</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司类型</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${not empty frpositList}">
                                                <c:forEach items="${frpositList}" var="list" varStatus="status">
                                                    <tr>
                                                        <td><span
                                                                class="formleft"><strong>${list.entNameCn}</strong></span>
                                                        </td>
                                                        <td>${list.fundedRatio}</td>
                                                        <td>${list.regCapCur} ${list.regCap}</td>
                                                        <td>${list.esDate}</td>
                                                        <td>${list.entType}</td>
                                                        <td>${list.entStatus}</td>
                                                        <td><c:if test="${list.entNameCn.length()>5}">
                                                            <button type="button" class="btn btn-xs btn-primary"
                                                                    onclick="searchCompany('${list.entNameCn}')">查询该公司
                                                            </button>
                                                        </c:if></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${ empty changeList}">
                                                <tr>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("5")){
                %>
                <div class="tab-pane fade active in" id="tab05">

                    <table width="100%" border="0" cellspacing="0" cellpadding="0"
                           class="table table-striped table-responsive">
                        <tbody>
                        <tr>
                            <td valign="top" width="23%" class="formleft"><strong>年份</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">${list.year}</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td width="20%" valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>

                        <tr>
                            <td valign="top" class="formleft"><strong>资产合计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">${list.totaLliabilities}</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>

                        <tr>
                            <td valign="top" class="formleft"><strong>实收资本</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">${list.paidUpCapital}</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>主营业务收入</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">${list.turnover}</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>利润总额</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">${list.profitBeforeTax}</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>

                        </tbody>
                    </table>


                    <p>备注：单位（千元），货币（人民币）</p>
                    <div class="row">

                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading01">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse01"
                                           aria-expanded="true"
                                           aria-controls="collapse01">
                                            资产表
                                            <c:if test="${level == '1'}">
                                                （需升级至数据完整报告）
                                            </c:if>
                                        </a>
                                    </h4>
                                </div>
                                <c:if test="${level != '1'}">
                                    <div id="collapse01" class="tab-pane fade active in" role="tabpanel"
                                         aria-labelledby="heading01">
                                        <div class="panel-body">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0"
                                                   class="table table-striped table-responsive">
                                                <tbody>
                                                <tr>
                                                    <td valign="top" width="23%" class="formleft"><strong>年份</strong>
                                                    </td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.year}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td width="20%" valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>流动资产</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>货币资金</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.cashAndBank}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>短期投资</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.shortTermInvestment}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>应收票据</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.billReceivable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>应收账款</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.accountReceivable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>其它应收款</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.otherReceivable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>预付款项</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.advancesToSuppliers}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>存货</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.inventory}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>待摊费用</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.toBeAppointedExpense}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>其它流动资产</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.otherCurrentAssets}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>流动资产合计</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalCurrentAssets}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> </strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>非流动资产</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>长期投资</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalLongTermInvestment}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>固定资产净值</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.fixedAssetsNetValue}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>在建工程</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.projectsUnderConstruction}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>无形资产</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.intangibleAssets}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>长期待摊费用</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.longTermToBeAppointedExpense}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>其它长期资产</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.otherLongTermAssets}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>其它资产</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.otherAssets}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>递延税款借项</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.deferredTaxDebit}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>非流动资产合计</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalNonCurrentAssets}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>资产合计</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalAssets}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading02">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse02"
                                           aria-expanded="false" aria-controls="collapse02">
                                            负债及股东权益
                                            <c:if test="${level == '1'}">
                                                （需升级至数据完整报告）
                                            </c:if>
                                        </a>
                                    </h4>
                                </div>
                                <c:if test="${level != '1'}">
                                    <div id="collapse02" class="tab-pane fade active in" role="tabpanel"
                                         aria-labelledby="heading02">
                                        <div class="panel-body">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0"
                                                   class="table table-striped table-responsive">
                                                <tbody>
                                                <tr>
                                                    <td valign="top" width="23%" class="formleft"><strong>年份</strong>
                                                    </td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.year}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td width="20%" valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>流动负债</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>短期贷款</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.shortTermLoans}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>应付票据</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.notePayable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>应付帐款</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.accountsPayable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>预收账款</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.advancesFromClients}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>应付工资</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.salariesPayable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>应付福利费</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.welfarePayable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>应付税金</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.taxesPayable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>其它应付款</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.otherAccountsPayable}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>预提费用</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.accruedExpenses}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>其它流动负债</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.otherCurrentLiabilities}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>流动负债合计</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalCurrentLiabilites}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong></strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>非流动负债</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>长期负债</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalLongTermLiabilities}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>递延税款贷项</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.deferredTaxCredit}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>其它负债</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.otherLiabilities}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>非流动负债合计</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalNonCurrentLiabilities}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong></strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>负债合计</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totaLliabilities}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong></strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>股东权益</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>实收资本</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.paidUpCapital}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>资本公积</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.capitalReserve}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>盈余公积</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.surplusReserve}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>未分配利润</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.undistributedProfit}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>所有者权益合计</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalShareholdersEquity}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong></strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right"></div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>负债及所有者权益总计</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.totalLiabilitiesEquities}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading03">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse03"
                                           aria-expanded="false" aria-controls="collapse03">
                                            损益表
                                            <c:if test="${level == '1'}">
                                                （需升级至数据完整报告）
                                            </c:if>
                                        </a>
                                    </h4>
                                </div>
                                <c:if test="${level != '1'}">
                                    <div id="collapse03" class="tab-pane fade active in" role="tabpanel"
                                         aria-labelledby="heading03">
                                        <div class="panel-body">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0"
                                                   class="table table-striped table-responsive">
                                                <tbody>
                                                <tr>
                                                    <td valign="top" width="23%" class="formleft"><strong>年份</strong>
                                                    </td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.year}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td width="20%" valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>主营业务收入</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.turnover}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>减: 主营业务成本</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.costsOfGoodsSold}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>减: 主营业务税金及附加</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.salesTax}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>主营业务利润</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.grossProfit}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>加: 其它业务利润</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.otherOperatingProfits}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>减: 营业费用</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.salesExpense}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>减: 管理费用</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.managementExpense}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>减: 财务费用</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.financeExpense}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>营业利润</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.operatingProfit}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>加: 投资损益</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.investmentProfit}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>加: 补贴收入</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.allowanceIncomes}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>减: 资产减值损失</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.assetsDevaluation}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>加: 营业外收入</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.nonOperatingIncome}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>减: 营业外支出</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.nonOperatingExpense}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>利润总额</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.profitBeforeTax}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>减: 所得税</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.incomeTax}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>净利润</strong></td>
                                                    <c:if test="${not empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">${list.netIncome}</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${empty financiallist}">
                                                        <c:forEach items="${financiallist}" var="list">
                                                            <td valign="top" class="formright">
                                                                <div align="right">-</div>
                                                            </td>
                                                        </c:forEach>
                                                    </c:if>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>


                    </div>
                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("6")){
                %>
                <div class="tab-pane fade active in" id="tab06">
                    <div class="row">

                        <p>数据显示：
                            <label style="width: 120px">
                                <input type="checkbox" checked id="allZxgg" onclick="screen(1)" style="width: 20px; height: 20px;"> 全部
                            </label>
                            <label style="width: 150px">
                                <input type="checkbox" id="pjws" onclick="screen(2)" style="width: 20px; height: 20px;"> 裁判文书
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="fygg" onclick="screen(3)" style="width: 20px; height: 20px;"> 法院公告&nbsp;
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="ktjl" onclick="screen(4)" style="width: 20px; height: 20px;"> 开庭记录&nbsp;
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="zxjl" onclick="screen(5)" style="width: 20px; height: 20px;"> 执行记录&nbsp;
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="ajlc" onclick="screen(6)" style="width: 20px; height: 20px;"> 案件流程&nbsp;
                            </label>

                            <%--<label>--%>
                            <%--<input type="checkbox"> 我的记录--%>
                            <%--</label>--%>
                        </p>
                        <%--<legend></legend>--%>

                        <table class="display table table-bordered table-striped" id="dynamic-table" style="width:100%">
                            <tbody>
                            <c:if test="${not empty zxggListPage.data}">
                                <c:forEach items="${zxggListPage.data}" var="list">
                                    <tr name="${list.dataType}">
                                        <td>${list.sortTimeString}</td><td>
                                        <table class="table table-hover table-bordered table-responsive">
                                                <%--name="${list.dataType}"--%>
                                            <tr>
                                                <td width="6%" bgcolor="#eef1f3">类型</td>
                                                <td width="12%">${list.dataType}</td>
                                                <td width="6%" bgcolor="#eef1f3">法院</td>
                                                <td width="19%">${list.court}</td>
                                                <td width="6%" bgcolor="#eef1f3">案号</td>
                                                <td width="26%">${list.caseNo}</td>
                                                <td width="6%" bgcolor="#eef1f3">日期</td>
                                                <td width="19%">${list.sortTimeString}</td>
                                            </tr>
                                            <tr>
                                                <td bgcolor="#eef1f3">简介&nbsp;</td>
                                                <c:if test="${list.dataType=='裁判文书'}">
                                                    <td colspan="5">${list.title}</td>
                                                </c:if>
                                                <c:if test="${list.dataType!='裁判文书'}">
                                                    <td colspan="5">${list.body}</td>
                                                </c:if>
                                                <td><label>
                                                        <%--<input type="checkbox">&nbsp;收藏--%>
                                                    <button type="button" class="btn btn-prime btn-sm">收藏</button>
                                                </label></td>
                                                <c:if test="${list.dataType=='裁判文书'}">
                                                    <td><button type="button" class="btn btn-success btn-sm" onclick="judicialDetail('cpws','${list.cpwsId}')">详细内容</button></td>
                                                </c:if>
                                                <c:if test="${list.dataType=='法院公告'}">
                                                    <td><button type="button" class="btn btn-success btn-sm" onclick="judicialDetail('fygg','${list.fyggId}')">详细内容</button></td>
                                                </c:if>
                                                <c:if test="${list.dataType=='开庭记录'}">
                                                    <td><button type="button" class="btn btn-success btn-sm" onclick="judicialDetail('ktgg','${list.ktggId}')">详细内容</button></td>
                                                </c:if>
                                                <c:if test="${list.dataType=='执行公告'}">
                                                    <td><button type="button" class="btn btn-success btn-sm" onclick="judicialDetail('zxgg','${list.zxggId}')">详细内容</button></td>
                                                </c:if>
                                                <c:if test="${list.dataType=='案件流程'}">
                                                    <td><button type="button" class="btn btn-success btn-sm" onclick="judicialDetail('ajlc','${list.ajlcId}')">详细内容</button></td>
                                                </c:if>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </td></tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>

                    </div>
                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("7")){
                %>
                <div class="tab-pane fade active in" id="tab07">
                    <table class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <th width="17%">失信记录</th>
                            <th width="17%">欠税记录</th>
                            <th width="17%">工商异常</th>
                            <th width="17%">网贷黑名单</th>
                            <th width="17%">催收记录</th>
                            <th width="15%">其他负面信息</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><strong><span
                                    class="formleft">${sxggListPage.shixinCount}条记录</span></strong></td>
                            <td><strong>0条记录</strong></td>
                            <td><strong>0条记录</strong></td>
                            <td><strong>${sxggListPage.wdhmdCount}条记录</strong></td>
                            <td><strong>0条记录</strong></td>
                            <td><strong>${sxggListPage.bgtCount}条记录</strong></td>
                        </tr>
                        </tbody>
                    </table>
                    <p>备注：记录不代表所有记录，存在时间误差
                    </p>

                    <c:if test="${not empty sxggListPage.data}">
                        <c:forEach items="${sxggListPage.data}" var="list">
                            <tr name="${list.dataType}">
                                <td>${list.sortTimeString}</td><td>
                                <table class="table table-hover table-bordered table-responsive">
                                        <%--name="${list.dataType}"--%>
                                    <tr>
                                        <td width="6%" bgcolor="#eef1f3">类型</td>
                                        <td width="12%">${list.dataType}</td>
                                        <td width="6%" bgcolor="#eef1f3">法院</td>
                                        <td width="19%">${list.court}</td>
                                        <td width="6%" bgcolor="#eef1f3">案号</td>
                                        <td width="26%">${list.caseNo}</td>
                                        <td width="6%" bgcolor="#eef1f3">日期</td>
                                        <td width="19%">${list.sortTimeString}</td>
                                    </tr>
                                    <tr>
                                        <td bgcolor="#eef1f3">简介&nbsp;</td>
                                        <td colspan="5">${list.body}</td>
                                        <td><label>
                                                <%--<input type="checkbox">&nbsp;收藏--%>
                                            <button type="button" class="btn btn-prime btn-sm">收藏</button>
                                        </label></td>
                                        <td><button type="button" class="btn btn-prime bt">详细内容</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </td></tr>
                        </c:forEach>
                    </c:if>
                    <p>&nbsp; </p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("8")){
                %>
                <div class="tab-pane fade active in" id="tab08">

                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading11">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse11"
                                       aria-expanded="true"
                                       aria-controls="collapse11">
                                        人员结构（${manageList.size()}） </a>
                                </h4>
                            </div>
                            <div id="collapse11" class="tab-pane fade active in" role="tabpanel"
                                 aria-labelledby="heading11">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th bgcolor="#eef1f7"><strong>员工人数</strong></th>
                                            <th>${empLoyee_1}</th>
                                            <th>${empLoyee_2}</th>
                                        </tr>
                                        <tr>
                                            <th width="40%" bgcolor="#eef1f7">姓名</th>
                                            <th width="40%" bgcolor="#eef1f7" colspan="2">职位</th>
                                            <%--<th width="20%" bgcolor="#eef1f7">性别</th>--%>
                                        </tr>
                                        </tr>
                                        <tbody>
                                        <c:if test="${not empty manageList}">
                                            <c:forEach items="${manageList}"  var="list" varStatus="status">
                                                <tr>
                                                    <td><span
                                                            class="formleft"><strong>${list.nameCN}</strong></span>
                                                    </td>
                                                    <td  colspan="2">${list.position}</td>
                                                        <%--<td>-</td>--%>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${ empty manageList}">
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                            </tr>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading12">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse12"
                                       aria-expanded="true"
                                       aria-controls="collapse12">
                                        运营场所信息 </a>
                                </h4>
                            </div>
                            <div id="collapse12" class="tab-pane fade active in" role="tabpanel"
                                 aria-labelledby="heading12">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tbody>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">场所描述</td>
                                            <td width="40%" bgcolor="#eef1f7">${operatings_cpm.premiseCN}</td>
                                            <td width="10%" bgcolor="#eef1f7">场地规模</td>
                                            <td width="10%" bgcolor="#eef1f7">${operatings_cpm.size}㎡</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">地点类型</td>
                                            <td width="40%" bgcolor="#eef1f7">${operatings_cpm.Locationtype}</td>
                                            <td width="10%" bgcolor="#eef1f7">所有权</td>
                                            <td width="10%" bgcolor="#eef1f7">${operatings_cpm.ownership}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="operating">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse30"
                                       aria-expanded="true"
                                       aria-controls="collapse12">
                                        运营现状 </a>
                                </h4>
                            </div>
                            <div id="collapse30" class="tab-pane fade active in" role="tabpanel"
                                 aria-labelledby="heading12">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tbody>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">主营描述</td>
                                            <td width="90%" bgcolor="#eef1f7" colspan="3">${operatings_cpm.mainDiscriptionCN}</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">产能规模</td>
                                            <td width="90%" bgcolor="#eef1f7" colspan="3">${operatings_cpm.productionCN}</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">来自目标公司</td>
                                            <td width="90%" bgcolor="#eef1f7"  colspan="3">${operatings_cpm.infoCN}</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">进口比例</td>
                                            <td width="40%" bgcolor="#eef1f7">${operatings_cpm.imports}%</td>
                                            <td width="10%" bgcolor="#eef1f7">进口地</td>
                                            <td width="10%" bgcolor="#eef1f7">${operatings_cpm.importAreaCN}</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">出口比例</td>
                                            <td width="40%" bgcolor="#eef1f7">${operatings_cpm.exports}%</td>
                                            <td width="10%" bgcolor="#eef1f7">出口地</td>
                                            <td width="10%" bgcolor="#eef1f7">${operatings_cpm.exportAreaCN}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading13">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse13"
                                       aria-expanded="true"
                                       aria-controls="collapse13">
                                        银行信息（${bankList.size()}） </a>
                                </h4>
                            </div>
                            <div id="collapse13" class="tab-pane fade active in" role="tabpanel"
                                 aria-labelledby="heading13">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th width="40%" bgcolor="#eef1f7">名称</th>
                                            <th width="30%" bgcolor="#eef1f7">账号</th>
                                            <th width="30%" bgcolor="#eef1f7">银行评价</th>
                                        </tr>
                                        <tbody>
                                        <c:if test="${not empty bankList}">
                                            <c:forEach items="${bankList}"  var="list" varStatus="status">
                                                <tr>
                                                    <td><span
                                                            class="formleft"><strong>${list.nameCN}</strong></span>
                                                    </td>
                                                    <td>${list.account}</td>
                                                    <td>${list.commentCN}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${ empty bankList}">
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                            </tr>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading14">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse14"
                                       aria-expanded="true"
                                       aria-controls="collapse14">
                                        客户信息（${clientList.size()}） </a>
                                </h4>
                            </div>
                            <div id="collapse14" class="tab-pane fade active in" role="tabpanel"
                                 aria-labelledby="heading14">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th width="60%" bgcolor="#eef1f7">姓名</th>
                                            <th width="40%" bgcolor="#eef1f7">电话</th>
                                        </tr>
                                        <tbody>
                                        <c:if test="${not empty clientList}">
                                            <c:forEach items="${clientList}" var="list" varStatus="status">
                                                <tr>
                                                    <td><span
                                                            class="formleft"><strong>${list.nameCN}</strong></span>
                                                    </td>
                                                    <td>${list.tel}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${ empty clientList}">
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                            </tr>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading15">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse15"
                                       aria-expanded="true"
                                       aria-controls="collapse15">
                                        供应商信息（${suppliersList.size()}） </a>
                                </h4>
                            </div>
                            <div id="collapse15" class="tab-pane fade active in" role="tabpanel"
                                 aria-labelledby="heading15">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th width="60%" bgcolor="#eef1f7">姓名</th>
                                            <th width="40%" bgcolor="#eef1f7">电话</th>
                                        </tr>
                                        <tbody>
                                        <c:if test="${not empty suppliersList}">
                                            <c:forEach items="${suppliersList}" var="list" varStatus="status">
                                                <tr>
                                                    <td><span
                                                            class="formleft"><strong>${list.nameCN}</strong></span>
                                                    </td>
                                                    <td>${list.tel}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${ empty suppliersList}">
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                            </tr>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading16">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse16"
                                       aria-expanded="true"
                                       aria-controls="collapse16">
                                        海关信息（${customeList.size()}） </a>
                                </h4>
                            </div>
                            <div id="collapse16" class="tab-pane fade active in" role="tabpanel"
                                 aria-labelledby="heading15">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th width="10%" bgcolor="#eef1f7">海关编码</th>
                                            <th width="40%" bgcolor="#eef1f7">管理类别</th>
                                            <th width="10%" bgcolor="#eef1f7">报关类别</th>
                                            <th width="40%" bgcolor="#eef1f7">注册有效日期</th>
                                        </tr>
                                        <tbody>
                                        <c:if test="${not empty customeList}">
                                            <c:forEach items="${customeList}"  var="list" varStatus="status">
                                                <tr>
                                                    <td><span
                                                            class="formleft"><strong>${list.code}</strong></span>
                                                    </td>
                                                    <td>${list.ManagementCategoriesCN}</td>
                                                    <td>${list.CustomsCollectionsCN}</td>
                                                    <td>${list.regdata}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${ empty customeList}">
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                            </tr>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>

                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("11")){
                %>
                <div class="tab-pane fade active in" id="dropdown1">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty mediaList}">
                            <c:forEach items="${mediaList}" var="list">
                                <tr>
                                    <td class="formleft"><strong>${list.date}</strong></td>
                                    <td width="77%"  class="formright"><div align="left">标题：${list.title} <br>
                                        详情：<a target="_blank" href="${list.source}" >${list.title}</a><br>
                                    </div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty mediaList}">
                            <tr>
                                <td class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">标题：- <br>
                                    详情：-<br>
                                    信息来源：-<br>
                                    内容：-<br>
                                </div></td>
                            </tr>
                        </c:if>

                        </tbody>
                    </table>
                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("12")){
                %>
                <div class="tab-pane fade active in" id="dropdown2">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty websiteList}">
                            <c:forEach items="${websiteList}" var="list">
                                <tr>
                                    <td width="23%"  class="formleft"><strong>${list.website}</strong></td>
                                    <td width="77%"  class="formright"><div align="left">
                                        注册时间：${list.registrationTime}<br>
                                        公司性质网站备案/许可证号：${list.licenseKey}</div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty websiteList}">
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td width="77%"  class="formright"><div align="left">网址：-<br>
                                    注册时间：-<br>
                                    公司性质网站备案/许可证号：-</div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
                <%
                    }
                %>
                <%
                    if(type.equals("13")){
                %>
                <div class="tab-pane fade active in" id="dropdown3">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty brandsList}">
                            <c:forEach items="${brandsList}" var="list">
                                <tr>
                                    <td width="23%" class="formleft"><strong>${list.patentName}</strong></td>
                                    <td width="77%"  class="formright"><div align="left">
                                        申请日期：${list.applicationDate}<br>
                                        发布日期：${list.releaseDate}<br>
                                        类型：${list.type}<br>
                                        申请号：${list.applicationNumber}<br>
                                        主分类号：${list.classificationNumber}</div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty brandsList}">
                            <tr>
                                <td width="23%" class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">
                                    申请日期：- <br>
                                    发布日期：-<br>
                                    类型：-<br>
                                    申请号：-<br>
                                    主分类号：-</div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
                <% } %>
            </div>
        </div>


    </div>


    <c:if test="${message=='false'}">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title" style="font-family:苹方">
                    提示
                </h3>
            </div>
            <div class="panel-body text-center">
                <h4>数据正在传输中，请稍候再试！</h4>
            </div>
        </div>
    </c:if>

</div>
</div></div>


<p>&nbsp;</p>
<p>&nbsp;</p>

<footer>
    <div class="row" style=" background-color:#f2f2f2; padding-top:50px">
        <div class="container">

            <div class="row">

                <div class="col-lg-6">
                    <div class="bs-component">
                        <h5>法律声明</h5>
                        <p style="font-size:11px">未经全搜书面同意，本报告不得以任何形式或部分提供给第三人。
                            <br>
                            本报告仅供签约客户作为信用、保险、营销及其他商业决策时的参考因素之一，不能用于其它用途。
                            本报告某些信息来源于非全搜所能控制的渠道，除非特别注明，此类信息均未经复核，全搜不能保证所提供信息的准确性、完整性和时效性。全搜提供本报告并不意味着为客户的商业风险提供担保,在任何情况下，对于客户的商业决策所造成的损失，无论该商业决策的做出是否参考了本报告所载信息，全搜不承担使用者的任何商业风险，也不承担由于非控因素和疏忽而引起的相应的损失和损害。
                        </p>


                    </div>

                </div>
                <div class="col-lg-3">
                    <div class="bs-component">
                        <h5>支持及解决方案</h5>


                        <p style="font-size:11px">报告问题：report@global-eagle.cn
                            <br>
                            热线支持：4008 388 2938 9:00am-18:00pm<br>
                            帐户及充值问题<br>
                            优惠及折扣方案<br>
                            常见问题汇总<br>
                            联系方式<br>
                        </p>

                    </div>

                </div>


                <div class="col-lg-3">
                    <div class="bs-component">
                        <h5>更多服务</h5>


                        <p style="font-size:11px">报告问题：report@global-eagle.cn
                            <br>
                            热线支持：4008 388 2938 9:00am-18:00pm<br>
                            帐户及充值问题<br>
                            优惠及折扣方案<br>
                            常见问题汇总<br>
                            联系方式<br>
                        </p>

                    </div>

                </div>


            </div>

            <hr style="color:#000">
            <p>Global Eagle 全球鹰 </p>

        </div>
    </div>

</footer>


<script>
    $(document).ready(function () {

        $('.navbar .dropdown, .dropdown-submenu').hover(function () {
        }, function () {
        });
        var clickEvent = false;
        $('#featureCarousel').on('click', '.nav a', function () {
            clickEvent = true;
            $('.nav li').removeClass('active');
            $(this).parent().addClass('active');
        }).on('slid.bs.carousel', function (e) {
            if (!clickEvent) {
                var count = $('#featureCarousel .nav').children().length - 1;
                var current = $('#featureCarousel .nav li.active');
                current.removeClass('active').next().addClass('active');
                var id = parseInt(current.data('slide-to'));

                if (count == id) {
                    $('#featureCarousel .nav li').first().addClass('active');
                }
            }
            clickEvent = false;
        });
    });

</script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/frame/DataTables-1.10.12/media/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/data-tables/DT_bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/data-tables/DT_bootstrap.css" />
<link href="${pageContext.request.contextPath}/frame/DataTables-1.10.12/media/css/jquery.dataTables.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dataTables.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/cpm/report.js"></script>

</body>
</html>