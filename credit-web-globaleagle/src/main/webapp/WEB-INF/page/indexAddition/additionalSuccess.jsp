<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>全球鹰-信用服务</title>
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript">
        function toPage(i) {
            //1返回购物车
            if (i==1) {
                window.location.href="${pageContext.request.contextPath}/toIndexAddition1.do";
            }else if(i==2){
                window.location.href="${pageContext.request.contextPath}/toIndexAddition2.do";
            }else if(i==3){
                window.location.href="${pageContext.request.contextPath}/toIndexAddition3.do";
            }else if(i==4){
                window.location.href="${pageContext.request.contextPath}/toIndexAddition4.do";
            }
        }
    </script>
</head>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<br>
<div id="banner">
    <div class="container">
        <div class="well bs-component">
            <legend>信用服务</legend>
            <div class="row">

                <!--startprint-->
                <div class="col-lg-12">
                    <h3 class="text-center">${msg}&nbsp;&nbsp;</h3><br>
                </div>
                <!--endprint-->
            </div>
            <div class="row">
                <div class="col-lg-12" style="padding: 30px 0;">
                    <table align="center">
                        <tr>
                            <td style="padding-right: 10px;">
                                <button class="btn btn-warming btn-success" style=" width:220px;height: 50px"
                                        onclick="toPage(1)">实地认证服务
                                </button>
                            </td>
                            <td style="padding-right: 10px;">
                                <button class="btn btn-warming btn-success" style=" width:220px;height: 50px"
                                        onclick="toPage(2)">全球应收帐管理
                                </button>
                            </td>
                            <td style="padding-right: 10px;">
                                <button class="btn btn-warming btn-success" style=" width:220px;height: 50px"
                                        onclick="toPage(3)">当地司法服务
                                </button>
                            </td>
                            <td style="padding-right: 10px;">
                                <button class="btn btn-warming btn-success" style=" width:220px;height: 50px"
                                        onclick="toPage(4)">净值调查服务
                                </button>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
</body>
</html>