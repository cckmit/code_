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
	<jsp:include page="./include/include.jsp"/>
	<title>全球鹰-首页</title>
	<link rel="shortcut icon" href="<%=basePath%>images/index/favicon.ico"
		  type="image/x-icon" />
	<style type="text/css">
		body {
			background-repeat: no-repeat;
		}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body class="intro">
<jsp:include page="${basePath}include/top.jsp"/>


<div class=" banner">
	<div class="slider">
		<div class="callbacks_container">
			<ul class="rslides" id="slider">
				<li>
					<div class="banner1">
						<div class="caption">
							<h3>在线查询2亿全球企业信用信息</h3>
							<p>提供超过180个国家风险信用服务</p>
						</div>
					</div>
				</li>
				<li>
					<div class="banner2">
						<div class="caption">
							<h3>一站式的风险管控及解决方案</h3>
							<p>整合全球多种信控服务</p>
						</div>
					</div>
				</li>
				<li>
					<div class="banner3">
						<div class="caption">
							<h3>数据 服务 解决方案</h3>
							<p>我们为企业的发展竭尽所能</p>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>


<div style="max-width: 100%">
	<div style="color: white; z-index: 1000; position: relative; bottom: 130px;left: 50%;margin-left:-300px; width:200px;">
		<div class="banner-info">
			<form id="form" action="<%=basePath%>simple/cpmSearchCompanyList.do" method="post">
				<table height="59" border="0" align="center" cellpadding="0" cellspacing="0">
					<tbody>
					<tr>
						<td style="padding-right: 10px;">
							<div class="input-group" style="height:46px; width: 140px;">
								<select name="countryName" class="form-control input-lg searchCountry">
									<option value="中国" selected>中国</option>
									<option value="英国">英国</option>
									<option value="美国">美国</option>
									<option value="德国">德国</option>
									<option value="法国">法国</option>
									<option value="比利时">比利时</option>
									<option value="丹麦">丹麦</option>
									<option value="西班牙">西班牙</option>
									<option value="意大利">意大利</option>
									<option value="韩国">韩国</option>
									<option value="卢森堡">卢森堡</option>
									<option value="墨西哥">墨西哥</option>
									<option value="荷兰">荷兰</option>
									<option value="挪威">挪威</option>
									<option value="葡牙萄">葡萄牙</option>
									<option value="瑞典">瑞典</option>
								</select>
							</div>

						</td>
						<td style="padding-right: 10px;">
							<input class="form-control input-lg" name="companyName" id="inputLarge" type="text" style=" width:360px" placeholder="输入目标公司名称/目标公司注册码" onfocus="this.value = '';"
								   onblur="if (this.value == '') {this.value = '输入目标公司名称/目标公司注册码';}" required>
						</td>
						<td>
							<input type="submit" value="搜索">
						</td>
					</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</div>

<!--
<div class="tabbigbox">
	<div class="tabbox">
		<div class="tab" style="background:#a2d4ed; text-align:center">
			<h6>常用国家</h6>
		</div>
		<div class="content">
			<ul>
				<li>
					<div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('中国')"><img src="<%=basePath%>images/index/guojia_01.png">中国 | CN</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('美国')"><img src="<%=basePath%>images/index/guojia_02.png">美国 | US</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('日本')"><img src="<%=basePath%>images/index/guojia_jp.png">日本 | JP</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('德国')"><img src="<%=basePath%>images/index/guojia_11.png">德国 | DE</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('法国')"><img src="<%=basePath%>images/index/guojia_09.png">法国 | FR</a>
						</div>
					</div>
					<div class="guojia_elie">
						<div class="guojia_1">
							<a href="#" onclick="selCountry('英国')"><img src="<%=basePath%>images/index/guojia_03.png">英国 | GB</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('巴西')"><img src="<%=basePath%>images/index/guojia_br.png">巴西 | BR</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('印度')"><img src="<%=basePath%>images/index/guojia_ia.png">印度 | IN</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('俄罗斯')"><img src="<%=basePath%>images/index/guojia_10.png">俄罗斯 | RU</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('意大利')"><img src="<%=basePath%>images/index/guojia_06.png">意大利 | IT</a>
						</div>
					</div>
					<div class="guojia_sanlie">
						<div class="guojia_1">
							<a href="#" onclick="selCountry('加拿大')"><img src="<%=basePath%>images/index/guojia_ca.png">加拿大 | CA</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('澳大利亚')"><img src="<%=basePath%>images/index/guojia_au.png">澳洲 | AU</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('西班牙')"><img src="<%=basePath%>images/index/guojia_es.png">西班牙 | ES</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('韩国')"><img src="<%=basePath%>images/index/guojia_kr.png">韩国 | KR</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('墨西哥')"><img src="<%=basePath%>images/index/guojia_15.png">墨西哥 | MX</a>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
<div class="tabbigbox">
	<div class="tabbox">
		<div class="tab" style="background:#a2d4ed; text-align:center">
			<h6>更多国家</h6>
		</div>
		<div class="content">
			<ul>
				<li>
					<div>
						<div class="guojia_1">
						<a href="#" onclick="selCountry('日本')"><img src="<%=basePath%>images/index/guojia_jp.png">日本 | JP</a>
					</div>
					<div class="guojia_1">
						<a href="#" onclick="selCountry('澳大利亚')"><img src="<%=basePath%>images/index/guojia_au.png">澳洲 | AU</a>
					</div>
					<div class="guojia_1">
						<a href="#" onclick="selCountry('韩国')"><img src="<%=basePath%>images/index/guojia_kr.png">韩国 | KR</a>
					</div>
					<div class="guojia_1">
						<a href="#" onclick="selCountry('巴西')"><img src="<%=basePath%>images/index/guojia_br.png">巴西 | BR</a>
					</div>
					<div class="guojia_1">
						<a href="#" onclick="selCountry('香港')"><img src="<%=basePath%>images/index/guojia_hk.png">香港 | HK</a>
					</div>
				</div>
					<div class="guojia_elie">
						<div class="guojia_1">
							<a href="#" onclick="selCountry('印度')"><img src="<%=basePath%>images/index/guojia_ia.png">印度 | IN</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('新加坡')"><img src="<%=basePath%>images/index/guojia_sg.png">新加坡 | SG</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('意大利')"><img src="<%=basePath%>images/index/guojia_06.png">意大利 | IT</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('加拿大')"><img src="<%=basePath%>images/index/guojia_ca.png">加拿大 | CA</a></div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('南非')"><img src="<%=basePath%>images/index/guojia_za.png">南非 | ZA</a>
						</div>
					</div>
					<div class="guojia_sanlie">
						<div class="guojia_1">
							<a href="#" onclick="selCountry('亚洲')"><img src="<%=basePath%>images/index/guojia_91.png">更多亚洲国家</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('中东')"><img src="<%=basePath%>images/index/guojia_92.png">更多中东国家</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('欧洲')"><img src="<%=basePath%>images/index/guojia_93.png">更多欧洲国家</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('美洲')"><img src="<%=basePath%>images/index/guojia_94.png">更多美洲国家</a>
						</div>
						<div class="guojia_1">
							<a href="#" onclick="selCountry('非洲')"><img src="<%=basePath%>images/index/guojia_95.png">更多非洲国家</a>
						</div>
					</div>

				</li>
			</ul>
		</div>
	</div>
</div>
-->
<section class="light-content services" style=" margin-top:40px">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-sm-4">
				<div class="service-box-wrap">
					<div class="service-icon-wrap" align="center">
						<img src="<%=basePath%>images/index/index01.png" width="40px" height="40px" >
					</div> <!-- /.service-icon-wrap -->
					<div class="service-cnt-wrap" align="center">
						<h3 class="index-big">4007 729 029</h3>
						<p class="index-p">工作日9:00 - 18:00提供中文热线服务<br>
							或发送邮箱，24小时内回复
						<div style="width:200px"><a href="mailto:info@global-eagle.cn"><input class="index" type='button' value="info@global-eagle.cn"></a>
						</div>
					</div> <!-- /.service-cnt-wrap -->
				</div> <!-- /.service-box-wrap -->
			</div> <!-- /.col-md-4 -->

			<div class="col-md-4 col-sm-4">
				<div class="service-box-wrap">
					<div class="service-icon-wrap"  align="center">
						<img src="<%=basePath%>images/index/index02.png" width="40px" height="40px" >

					</div> <!-- /.service-icon-wrap -->
					<div class="service-cnt-wrap"  align="center">
						<h3 class="index-big">认证企业免费</h3>
						<p class="index-p">注册并按照要求填写您的企业信息<br>
							认证完成后，可免费体验</p>
						<div style="width:100px"><button type="button" class="btn btn-disabled ">
							注册及认证        </button>
						</div>
					</div> <!-- /.service-cnt-wrap -->
				</div> <!-- /.service-box-wrap -->
			</div> <!-- /.col-md-4 -->

			<div class="col-md-4 col-sm-4">
				<div class="service-box-wrap">
					<div class="service-icon-wrap"  align="center">
						<img src="<%=basePath%>images/index/index03.png" width="40px" height="40px" >
					</div> <!-- /.service-icon-wrap -->
					<div class="service-cnt-wrap"  align="center">
						<h3 class="index-big">估估信用</h3>
						<p class="index-p">随时随地的移动端风险防范工具<br>
							您身边的风险防火墙</p>
						<button type="button" class="btn btn-disabled ">
							即将开放下载        </button>
					</div>
					<!-- /.service-cnt-wrap -->
				</div> <!-- /.service-box-wrap -->
			</div> <!-- /.col-md-4 -->

		</div>

		<div class="row"><!-- /.col-md-4 --><!-- /.col-md-4 --><!-- /.col-md-4 -->

		</div> <!-- /.row -->
	</div> <!-- /.container -->
</section>
<br><br>
<!-- /.our-team -->
<jsp:include page="${basePath}./include/bottomCommon.jsp"/>
<!-- /.site-footer -->


<!-- Scripts -->
<%--  	<script src="<%=basePath%>js/index/min/plugins.min.js"></script>
	<script src="<%=basePath%>js/index/min/medigo-custom.min.js"></script>  --%>
<script>
	$(function(){
		$('.tabbox .content ul').width(1200*$('.tabbox .content li').length+'px');
		$(".tabbox .tab a").mouseover(function(){
			$(this).addClass('on').siblings().removeClass('on');
			var index = $(this).index();
			number = index;
			var distance = -1200*index;
			$('.tabbox .content ul').stop().animate({
				left:distance
			});
		});

		var auto = 0;  //等于1则自动切换，其他任意数字则不自动切换
		if(auto ==1){
			var number = 0;
			var maxNumber = $('.tabbox .tab a').length;
			function autotab(){
				number++;
				number == maxNumber? number = 0 : number;
				$('.tabbox .tab a:eq('+number+')').addClass('on').siblings().removeClass('on');
				var distance = -1200*number;
				$('.tabbox .content ul').stop().animate({
					left:distance
				});
			}
			var tabChange = setInterval(autotab,3000);
			//鼠标悬停暂停切换
			$('.tabbox').mouseover(function(){
				clearInterval(tabChange);
			});
			$('.tabbox').mouseout(function(){
				tabChange = setInterval(autotab,3000);
			});
		}
	});
</script>
<%--<script src="js/jquery.min.js"></script>--%>

<%--<script src="${pageContext.request.contextPath}/js/responsiveslides.min.js"></script>--%>
<script>
	$(function () {
		$("#slider").responsiveSlides({
			auto: true,
			speed: 800,
			namespace: "callbacks",
			pager: true,
		});
	});
</script>


</body>
</html>
