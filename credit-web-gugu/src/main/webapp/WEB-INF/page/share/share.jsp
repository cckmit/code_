<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title> ${card.cardName } - ${card.cardCompany }</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/endpic.css">
<script type="text/javascript" src="<%=basePath %>js/offline.js"></script>
<script src="<%=basePath %>js/clipboard.min.js"></script>
<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">
</head>


<body class="s-bg-ddd pc no-3d" style="-webkit-user-select: none;">
    
    <section class="u-arrow">
        <p class="css_sprite01"></p>
    </section>
    <section class="p-ct transformNode-2d" style="height: 907px;">
        <div class="translate-back" style="height: 907px;">
            <div class="m-page m-fengye" data-page-type="info_pic3" data-statics="info_pic3" style="height:70%;">
			
                <div class="page-con lazy-finish" data-position="50% 50%" data-size="cover" style="background-image: url(<%=basePath %>image/01.jpg); background-size: cover; background-position: 50% 50%;"></div>
            </div>
            <div class="m-page m-bigTxt f-hide" data-page-type="bigTxt" data-statics="info_list" style="height:70%;">
                <div class="page-con j-txtWrap lazy-finish" data-position="50% 50%" data-size="cover" style="background-image: url(<%=basePath %>image/02.jpg); background-size: cover; background-position: 50% 50%;"></div>
            </div>
            <div class="m-page m-bigTxt f-hide" data-page-type="bigTxt" data-statics="info_list" style="height:70%;">
                <div class="page-con j-txtWrap lazy-finish" data-position="50% 50%" data-size="cover" style="background-image: url(<%=basePath %>image/03.jpg); background-size: cover; background-position: 50% 50%;">
				</div>				
            </div>
            <div class="m-page m-bigTxt f-hide" data-page-type="bigTxt" data-statics="info_list" style="height: 907px;">
                <div class="page-con j-txtWrap lazy-finish" data-position="50% 50%" data-size="cover" style="background-image: url(<%=basePath %>image/04.jpg); background-size: cover; background-position: 50% 50%;">
				</div>
            </div>
			<div class="m-page m-bigTxt f-hide" data-page-type="bigTxt" data-statics="info_list" style="height: 907px;">
                <div class="page-con j-txtWrap lazy-finish" data-position="50% 50%" data-size="cover" style="background-image: url(<%=basePath %>image/05.jpg); background-size: cover; background-position: 50% 50%;">
					<div style="margin:100px auto;" align="center" ><img src="${shareRecord.photoPath }"  width="308px" height="308px" >
					<!-- image/yzm.png -->
					<p style="text-align:center; font-size:24px;"> <br></p>
					<p style="text-align:center; font-size:24px;">扫描二维码添加估估信用名片</p><br>
					 <p style="text-align:center; font-size:24px;">口令码</p><br>
                  <p><script type="text/javascript">
function copyUrl()
{
var Url=document.getElementById("biao");
Url.select(); // 选择对象
document.execCommand("Copy"); // 执行浏览器复制命令
alert("已复制好，可贴粘。");
}
</script>
<textarea id="biao"  style="width:100%; height:40px; text-align:center; color:#963; font-size:20px; border:0;">${shareRecord.token }</textarea><br>
<br>
<button class="btn" data-clipboard-action="copy" data-clipboard-target="#biao" style="width:200px; height:40px; font-size:20px; color:#FFF; background:#C93; border-radius:10px;  border:none;" >点击复制口令</button></p>
                  </div>
					<div style="margin:100px 0 0 0;" align="center" ><a href="#"><img src="<%=basePath %>image/051.png" ></a></div>
					
				</div>
            </div>
			
        </div>
    </section>
    <section class="u-pageLoading">
        <img src="<%=basePath %>images/load.gif" alt="loading">    </section>
    <script src="<%=basePath %>js/init.mix.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=basePath %>js/coffee.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=basePath %>js/99_main.js" type="text/javascript" charset="utf-8"></script>

<script>
var clipboard = new Clipboard('.btn');
clipboard.on('success', function(e) {
    console.info('Action:', e.action);
    console.info('Text:', e.text);
    console.info('Trigger:', e.trigger);
alert("复制成功");
    e.clearSelection();
});

clipboard.on('error', function(e) {
    console.error('Action:', e.action);
    console.error('Trigger:', e.trigger);
});
</script>
	
	
</body>
</html>
