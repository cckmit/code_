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
	<meta charset="UTF-8">
	<title>全球鹰首页</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shouye.css" media="screen">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" media="screen">
	<%--<script type="text/javascript" src="${pageContext.request.contextPath}js/jquery-1.11.0.js" ></script>--%>
</head>
<body>

<!--banner图start-->
<div class="page-banner-outline">
	<!--图片-->
	<div class="page-banner-outline-img">
		<img src="images/img/index.png" alt="加载失败" title="全球鹰" />
	</div>
	<jsp:include page="./include/include.jsp"/>
	<jsp:include page="${basePath}include/top.jsp"/>
	<!--seach-->
	<div class="page-banner-inline">
		<div class="page-banner-inline-in">
			<div class="page-banner-content-top">
				<h1>全球3亿企业信用数据查询平台</h1>
				<div class="page-banner-content-topdiv">
					<form id="form" action="<%=basePath%>toSearchCompanyList.do" method="post">
						<select name="countryName" oninput="OnInput(event)" class="page-input-first" id="bsSuggest">
							<!--这个option的选项要从数据库 取出来  要他们做接口给你-->
							<option value="">选择国家</option>
							<option value="中国">中国</option>
							<option value="英国">英国</option>
							<option value="美国">美国</option>
							<option value="德国">德国</option>
							<option value="法国">法国</option>
							<option value="西班牙">西班牙</option>
							<option value="挪威">挪威</option>
							<option value="荷兰">荷兰</option>
							<option value="卢森堡">卢森堡</option>
							<option value="丹麦">丹麦</option>
							<option value="比利时">比利时</option>
							<option value="意大利">意大利</option>
							<option value="墨西哥">墨西哥</option>
							<option value="瑞典">瑞典</option>
							<option value="韩国">韩国</option>
							<option value="葡萄牙">葡萄牙</option>
							<option value="亚洲">更多国家</option>
						</select>
						<input class="page-input-two" name="companyName" id="inputLarge" type="text" placeholder="输入目标公司名称/目标公司注册码" value="" style="height:38px;padding-left: 8px;"/>
						<input type="submit" value="搜索"  class="page-cont-inp-sub" style="height:36px;"/>
					</form>
				</div>
				<h2>搜索你需要的国家</h2>
			</div>
			<!--tablist-->
			<div class="page-banner-content-table">
				<div class="tabbox-content">
					<div class="tabbox-content-first">
						<ul>
							<li>
								<a href="#" onclick="selCountry('中国')"><img src="images/img/中国.png" alt="加载错误" width="23" height="16" title="全球鹰"/>中国 | CN</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('英国')"><img src="images/img/英国.png" alt="加载错误" width="23" height="16" title="全球鹰"/>英国 | GB</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('美国')"><img src="images/img/美国.png" alt="加载错误" width="23" height="16" title="全球鹰"/>美国 | US</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('德国')"><img src="images/img/德国.png" alt="加载错误" width="23" height="16" title="全球鹰"/>德国 | DE</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('法国')"><img src="images/img/法国.png" alt="加载错误" width="23" height="16" title="全球鹰"/>法国 | FR</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('西班牙')"><img src="images/img/西班牙.png" alt="加载错误" width="23" height="16" title="全球鹰"/>西班牙 | ES</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('挪威')"><img src="images/img/挪威-NOR.png" alt="加载错误" width="23" height="16" title="全球鹰"/>挪威 | NOR</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('荷兰')"><img src="images/img/荷兰-NL.jpg" alt="加载错误" width="23" height="16" title="全球鹰"/>荷兰 | NL</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('卢森堡')"><img src="images/img/卢森堡-LUX.jpg" alt="加载错误" width="23" height="16" title="全球鹰"/>卢森堡 | LUX</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('丹麦')"><img src="images/img/丹麦-DEN.jpg" alt="加载错误" width="23" height="16" title="全球鹰"/>丹麦 | DEN</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('比利时')"><img src="images/img/比利时-BEL.jpg" alt="加载错误" width="23" height="16" title="全球鹰"/>比利时 | EEL</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('意大利')"><img src="images/img/意大利.png" alt="加载错误" width="23" height="16" title="全球鹰"/>意大利 | IT</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('墨西哥')"><img src="images/img/墨西哥.png" alt="加载错误" width="23" height="16" title="全球鹰"/>墨西哥 | MX</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('瑞典')"><img src="images/img/瑞典-SWE.jpg" alt="加载错误" width="23" height="16" title="全球鹰"/>瑞典 | SWE</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('韩国')"><img src="images/img/韩国.png" alt="加载错误" width="23" height="16" title="全球鹰"/>韩国 | KR</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('葡萄牙')"><img src="images/img/葡萄牙-POR.jpg" alt="加载错误" width="23" height="16" title="全球鹰"/>葡萄牙 | POR</a>
							</li>
							<li>
								<a href="#" onclick="selCountry('亚洲')"><img src="images/img/亚洲.png" alt="加载错误" width="23" height="16" title="全球鹰"/>更多国家</a>
							</li>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- banner图结束 -->
<div class="clear"></div>
<!-- 内容块	start -->
<div class="page-content-outline">
	<div class="page-content-inline">
		<!--    一       -->
		<div class="page-content-inline-one">
			<div class="page-content-inline-one-img" style="padding: 85px 0 0px 0;">
				<img src="images/img/index01.png" alt="加载失败" title="全球鹰" />
			</div>
			<div class="page-content-inline-one-cont">
				<h3  style="font-size:18px;font-family:'Microsoft Yahei';">4007 729 029</h3>
				<p style="font-size:12px;font-family:'Microsoft Yahei';">
					"工作日9:00 - 18:00提供中文热线服务"<br />
					"或发送邮箱，24小时内回复"
				</p>
				<button type="button" class="page-cont-btnone" style="margin-left: -90px;font-size:12px;font-family:'Microsoft Yahei';" onclick="openOutlook()">info@global-eagle.cn</button>
			</div>
		</div>
		<!--        二                -->
		<div class="page-content-inline-one">
			<div class="page-content-inline-one-img" style="padding: 85px 0 0px 0;">
				<img src="images/img/index02.png" alt="加载失败" title="全球鹰" />
			</div>
			<div class="page-content-inline-one-cont">
				<h3  style="font-size:18px;font-family:'Microsoft Yahei';">免费注册及认证企业</h3>
				<p style="font-size:12px;font-family:'Microsoft Yahei';">
					"免费注册并按照要求填写您的企业信息"<br />
					"认证完成后，享受更多优惠信息"
				</p>
				<button type="button" class="page-cont-btntwo" style="font-size:12px;font-family:'Microsoft Yahei';" onclick="toApproveCompany()">会员注册及企业认证</button>
			</div>
		</div>
		<!--     三      -->
		<div class="page-content-inline-one">
			<div class="page-content-inline-one-img" style="padding: 85px 0 0px 0;">
				<img src="images/img/index03.png" alt="加载失败" title="全球鹰" />
			</div>
			<div class="page-content-inline-one-cont">
				<h3  style="font-size:18px;font-family:'Microsoft Yahei';">估估信用</h3>
				<p style="font-size:12px;font-family:'Microsoft Yahei';">
					"随时随地的移动端风险防范工具"<br />
					"您身边的风险防火墙"
				</p>
				<button type="button" class="page-cont-btnthree" style="background-color: #c0c0c0;font-size:12px;font-family:'Microsoft Yahei';">即将开放下载</button>
			</div>
		</div>
	</div>
</div>
<!-- 尾部代码start -->
<jsp:include page="include/bottomCommon.jsp"/>
<!--  尾部结束end  -->

</body>
</html>
<script type="text/javascript">
    function selCountry(country){
        if (country!="中国"&&country!="英国"&&country!="美国"&&country!="德国"&&country!="法国"&&country!="比利时"&&country!="丹麦"&&country!="西班牙"&&country!="意大利"&&country!="韩国"&&country!="卢森堡"&&country!="墨西哥"&&country!="荷兰"&&country!="挪威"&&country!="葡萄牙"&&country!="瑞典"){
            $("#searchA").html("定制").removeClass('btn-primary').addClass('btn-success');
        }else{
            $("#searchA").html("定制").removeClass('btn-success').addClass('btn-primary');
        }
        if (country=="中国"||country=="英国"||country=="美国"||country=="德国"||country=="法国"||country=="比利时"||country=="丹麦"||country=="西班牙"||country=="意大利"||country=="韩国"||country=="卢森堡"||country=="墨西哥"||country=="荷兰"||country=="挪威"||country=="葡萄牙"||country=="瑞典"){
            $("#searchA").html("搜索");
        }
        $("#selCountry").html(country);
        $("#bsSuggest").val(country);
    }
    function OnInput(event) {
        if (event.target.value!="中国"&&event.target.value!="英国"&&event.target.value!="美国"&&event.target.value!="德国"&&event.target.value!="法国"&&event.target.value!="比利时"&&event.target.value!="丹麦"&&event.target.value!="西班牙"&&event.target.value!="意大利"&&event.target.value!="韩国"&&event.target.value!="卢森堡"&&event.target.value!="墨西哥"&&event.target.value!="荷兰"&&event.target.value!="挪威"&&event.target.value!="葡萄牙"&&event.target.value!="瑞典") {
            $("#searchA").html("定制").removeClass('btn-primary').addClass('btn-success');
        }else{
            $("#searchA").html("定制").removeClass('btn-success').addClass('btn-primary');
        }
        if (event.target.value=="中国"||event.target.value=="英国"||event.target.value=="美国"||event.target.value=="德国"||event.target.value=="法国"||event.target.value=="比利时"||event.target.value=="丹麦"||event.target.value=="西班牙"||event.target.value=="意大利"||event.target.value=="韩国"||event.target.value=="卢森堡"||event.target.value=="墨西哥"||event.target.value=="荷兰"||event.target.value=="挪威"||event.target.value=="葡萄牙"||event.target.value=="瑞典"){
            $("#searchA").html("搜索");
        }
    }
    //		这个接口是"绝对路径"所以现在可以线下提交数据,要是相对路径 就不行了 要到线上才行
//    var basePath = 'http://www.global-eagle.cn:80/';
    function fastAddOrder() {
        var fastCountry  = $('#yCountry').val();
        var fastCompanyName = $('#ycompany').val();
        window.location.href=basePath+"user/toFastAddCart.do?country="+fastCountry+"&fastCompanyName="+fastCompanyName;
    }
    function openOutlook() {
        window.open("mailto:info@global-eagle.cn?subject=" + "标题" + "&body="+ "内容");
    }
    function toApproveCompany(){
        window.location.href=basePath+"toApproveCompany.do";
    }

</script>