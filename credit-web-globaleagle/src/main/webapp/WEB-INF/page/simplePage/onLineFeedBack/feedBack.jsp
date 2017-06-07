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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>在线问答</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<style type="text/css">
		.form-control {
			display: block;
			width: 640px;
			height: 100px;
		}
		.send {
			position:relative;
			width:auto;
			display:inline-block;
			*display:inline;
			*zoom:1;
			background:#efefef;
			border-radius:5px; /* 圆角 */
			margin:5px 0 10px 0px;
		}

		.arrow {
			position:absolute;
			top:10px;
			left:-16px; /* 圆角的位置需要细心调试哦 */
			height:0;
			font-size:0;
			border:solid 8px;
			border-color:#fff #efefef #fff #fff;
		}
		.send1 {
			position:relative;
			width:auto;
			display:inline-block;
			*display:inline;
			*zoom:1;
			background:#D3EDFB;
			border-radius:5px; /* 圆角 */
			margin:5px 0 10px 0px;
		}
		.arrow1 {
			position:absolute;
			top:10px;
			right:-16px; /* 圆角的位置需要细心调试哦 */
			height:0;
			font-size:0;
			border:solid 8px;
			border-color:#Fff #fff #fff #D3EDFB;
		}
		.left{text-align:left; margin:5px 20px 0 20px;}
		.right{color:#666; font-family :arial; font-size:12px; text-align:right; margin:0 20px 0 20px;}
	</style>
    <script language="javascript">
        window.location ="#bottom";//自动跳转到锚点处
    </script>
    </head>
<body>
	<div id="aqModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content"  style="width:820px">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="countryModalLabel">在线问答</h4>
                </div>
                <div class="modal-body">
                    <div style="padding:0 20px 0 20px; width:760px; height: 420px;">
                        <div id="scrolldIV" style="overflow:auto; width: 760px; height: 400px; background:#FFF; overflow-x: hidden; border:medium double  #CCC;" >
                            <table id="contentTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                               <%-- <tr>
                                    <td width="80px" valign="top"><div style="float:right; background:url(<%=basePath%>/images/left.png); width:38px; height:35px; margin:10px 20px 0px 0;"></div></td>
                                    <td align="left"><div class="send"><div class="arrow"></div><p class="left"></p>
                                        <p class="right">2014-09-15 15:06</p>
                                    </div></td>
                                    <td width="80px"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td align="right"><div class="send1"><p class="left" id="fromContent"></p>
                                        <p class="right">2014-09-15 15:06</p>
                                        <div class="arrow1"></div></div></td>
                                    <td valign="top"><div style="float:right; background:url(<%=basePath%>/images/right.png); width:38px; height:35px; margin:10px 20px 0px 0;"></div></td>
                                </tr>--%>
                            </table>
                        </div>
                    </div>
                    <div style="padding:0 20px 0 20px; width:760px; height: 80px; ">
                        <div style="width:760px; height:80px; background:#fff;">
                            <div style="display: block; float:left; width:640px; height:80px;">
                                <textarea class="form-control" rows="3" id="textContent"></textarea></div>
                            <div style="display: block; float:right; width:100px; height:80px;">
                                <input  type="button" value="发送"  id="sendInfo" style="width:80px; height:80px; background-color: #66CC00;color: #fff;"></div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function add()
        {
            var now = new Date();
            var div = document.getElementById('scrolldIV');

            div.scrollTop = div.scrollHeight;
        }
        window.onload =
            function sc(){
                var div = document.getElementById("scrolldIV");
                div.scrollTop = div.scrollHeight;
            }
    </script>
</body>
</html>
