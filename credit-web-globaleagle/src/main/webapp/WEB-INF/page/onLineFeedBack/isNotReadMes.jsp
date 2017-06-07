<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>消息提醒</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    </head>
<body>
	<div id="answerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content"  style="width:820px">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="countryModalLabel">未读消息提醒</h4>
                </div>
                <div style="height: 500px;">
                    <p></p>

                <table width="800" border="2" cellspacing="0" cellpadding="0" align="center">
                    <tr>
                        <td width="250" height="40" align="center">用户名字</td>
                        <td align="center">问题URL</td>
                        <td width="80" align="center">未读消息</td>
                        <td width="60" align="center">&nbsp;</td>
                    </tr>
                    <tbody id="msgTBody">
                    <%--<tr>
                        <td align="center">USER1</td>
                        <td>URL://</td>
                        <td align="center">(1)</td>
                        <td>
                            <input type="submit" name="button" id="answer" value="回复" />
                        </td>
                    </tr>--%>
                    </tbody>
                </table><div style="height: 75px;">
                    <a name="bottom"></a></div></div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="${basePath}/WEB-INF/page/onLineFeedBack/feedBack.jsp"/>
</body>
</html>
