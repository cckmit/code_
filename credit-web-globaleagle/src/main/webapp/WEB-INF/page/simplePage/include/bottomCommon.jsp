<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%--<%@ page import="com.IT3acredit.GlobalEagle.admin.model.HelpCate" %>--%>
<%--<%@ page import="com.IT3acredit.GlobalEagle.admin.dao.HelpCateMapper" %>--%>
<%--<%@ page import="com.IT3acredit.GlobalEagle.util.SpringContextUtils" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script>
	var basePath = '<%=basePath%>';
	function fastAddOrder() {
		var fastCountry  = $('#fastCountry').val();
		var fastCompanyName = $('#fastCompanyName').val();
		window.location.href=basePath+"user/toFastAddOrder.do?country="+fastCountry+"&fastCompanyName="+fastCompanyName;

	}
</script>

<div class="footerWrapper" id="footer1">
	<div class="item footer bottom-menu bottom-menu-large bottom-menu-inverse">
		<div class="container">
			<div class="col-md-4">
					<%--<from>--%>
					<%--<h5 class="title">快捷订购</h5>--%>
					<%--<ul class="bottom-links">--%>
						<%--<li style="padding-bottom:8px;padding-top:5px">--%>
							<%--<div class="input-group" style="height:10px; width: 140px;">--%>
								<%--<select class="form-control input searchCountry">--%>
									<%--<option value="中国" selected="selected">中国</option>--%>
									<%--<option value="英国">英国</option>--%>
									<%--<option value="美国">美国</option>--%>
									<%--<option value="德国">德国</option>--%>
									<%--<option value="法国">法国</option>--%>
									<%--<option value="比利时">比利时</option>--%>
									<%--<option value="丹麦">丹麦</option>--%>
									<%--<option value="西班牙">西班牙</option>--%>
									<%--<option value="意大利">意大利</option>--%>
									<%--<option value="韩国">韩国</option>--%>
									<%--<option value="卢森堡">卢森堡</option>--%>
									<%--<option value="墨西哥">墨西哥</option>--%>
									<%--<option value="荷兰">荷兰</option>--%>
									<%--<option value="挪威">挪威</option>--%>
									<%--<option value="葡牙萄">葡萄牙</option>--%>
									<%--<option value="瑞典">瑞典</option>--%>
								<%--</select>--%>
							<%--</div>--%>
						<%--</li>--%>
						<%--<li style="padding-bottom:8px">--%>
							<%--<input class="form-control input" id="fastCompanyName" style="font-size:12px; width:80%" placeholder="目标公司名称" autocomplete="off" required type="text"></li>--%>
						<%--<li>--%>
							<%--<input class="btn btn-primary " value="下一步" type="button"  style="width:70px">--%>
							<%--<span style="padding-left:10px">选择国家并输入目标公司名称</span></li>--%>
					<%--</ul>--%>
				<%--</div>--%>
			<%--</from>--%>

			<%--<div class="col-md-2">--%>
				<%--<h5 class="title">信用服务</h5>--%>
				<%--<ul class="bottom-links">--%>
					<%--<li><a href="<%=basePath%>toIndexAddition1.do">实地认证服务</a></li>--%>
					<%--<li><a href="<%=basePath%>toIndexAddition2.do">全球应收帐管理</a></li>--%>
					<%--<li><a href="<%=basePath%>toIndexAddition3.do">全球司法服务</a></li>--%>
					<%--<li><a href="<%=basePath%>toIndexAddition4.do">尽职调查服务</a></li>--%>
					<%--<li><a href="<%=basePath%>toIndexAddition5.do">商业咨询服务</a></li>--%>
					<%--<li><a href="<%=basePath%>toIndexAddition6.do">数据API服务</a></li>--%>
				<%--</ul>--%>
			</div>
			<div class="col-md-4">
				<h5 class="title">网站相关</h5>
				<ul class="bottom-links">
					<li><a href="<%=basePath%>simple/toIndexAddition7.do">搜索及订购服务</a></li>
					<li class="active"><a href="<%=basePath%>simple/toIndexAddition8.do">关于我们</a></li>
					<li><a href="<%=basePath%>simple/toIndexAddition9.do">工作机会</a></li>
					<li><a href="<%=basePath%>simple/toIndexAddition10.do">样本下载</a></li>
					<li><a href="<%=basePath%>simple/toIndexAddition11.do">隐私及保密</a></li>
					<li><a href="<%=basePath%>simple/toIndexAddition12.do">法律声明</a></li>
				</ul>
			</div>
			<%--<div class="col-md-4">--%>
				<%--<h5 class="title">帮助及支持</h5>--%>
				<%--<ul class="bottom-links">--%>
					<%--<%--%>
						<%--HelpCateMapper h = (HelpCateMapper) SpringContextUtils.getBean("helpCateMapper");--%>
						<%--if(h == null){--%>

						<%--}--%>
						<%--else{--%>
						    <%--System.out.println(h);--%>
<%--//							HelpCate c = h.queryById(new Integer(1));--%>
							<%--List<HelpCate> cates = h.queryAll();--%>
							<%--pageContext.setAttribute("cates", cates);--%>
						<%--}--%>

					<%--%>--%>
					<%--<c:forEach items="${cates}" var="cate">--%>
						<%--<li><a href="#fakelink" onclick="toHelp(${cate.id})">${cate.name}</a></li>--%>
					<%--</c:forEach>--%>
				<%--</ul>--%>
			<%--</div>--%>
			<div class="col-md-4">
				<h5 class="title">联系方式</h5>
				<ul class="bottom-links">
					<li><a href="#fakelink">热线：400-7729-029</a></li>
					<li><a href="#fakelink">电话：021-3638-6226</a></li>

					<li><a href="#fakelink">邮箱：info@global-eagle.cn</a></li>
					<li><a href="#fakelink">在线QQ：2140890079</a></li>

					<li><a href="#fakelink">估估信用&nbsp;&nbsp;<span class="label label-small label-primary">New</span></a></li>
					<li><a href="#fakelink">地址：上海市静安区愚园路168好环球世界大厦26层</a></li>
				</ul>
			</div>
			<legend>&nbsp;</legend>
			<div class="col-md-8" style="font-size:12px">Global Eagle 全球鹰 | Copyright © 2016 Golbal-Eagle.cn 保留所有权利 </div> <div  class="col-md-4" align="right"  style="font-size:12px"><a href="http://www.miitbeian.gov.cn/" target="_blank">沪ICP备15022071号</a></div>
		</div>
	</div>
	<!-- /.item -->
</div>
