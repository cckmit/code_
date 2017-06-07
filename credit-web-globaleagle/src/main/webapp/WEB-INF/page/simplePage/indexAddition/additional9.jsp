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
    <title>全球鹰-工作机会</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
     
  <div >
        <p class="lead">工作机会</p>
  </div>
     
  <div class="col-lg-8" style=" line-height:24px">
       

               <p>欢迎加入我们，与我们一起参与信用中国的建设。</p>
<h4>JAVA开发技术员</h4>
               <ul>
                 <LI>岗位职责：</LI>
                 <LI>1. 负责移动端和PC相关产品的HTML/CSS代码编写</LI>
                 <LI>2. 按照UI原型还原静态HTML和CSS样式，兼容各种主流浏览器</LI>
                 <LI>3. 参与制定页面重构的标准及优化，学习能力强</LI>
               </ul>
               <BR>
               <ul>
                 <LI>任职要求：</LI>
                 <LI>1. 精通JAVA、J2EE常用框架</LI>
                 <LI>2. 精通STRUTS、SPRING、SPRING MVC框架,了解HIBERNATE优先</LI>
                 <LI>3. 熟练使用JS、JQUERY、JSP等页面开发相关技术</LI>
                 <LI>4. 熟练使用ECLIPSE、Myeclipse等开发工具，精通TOMCAT等应用服务器</LI>
                 <LI>5. 熟悉服务器操作系统、主流数据库(mysql优先)</LI>
                 <LI>6. 懂Lucene、Solr更好</LI>
               </ul>
               <p>&nbsp;</p>
               <h4>UI设计师</h4>

               <ul>
                 <LI>岗位职责：</LI>
                 <LI>1. 根据公司项目规划，完成项目（PC端/移动端）界面设计，调整页面布局</LI>
                 <LI>2. 具备良好合作态度及团队精神，并富有工作激情、创造力和责任感</LI>
                 <LI>3. 良好的项目管理和沟通表达能力，具备较强推进和优化项目的能力</LI>
               </ul>
               <BR>
               <ul>
                 <LI>任职要求：</LI>
                 <LI>1. 具有扎实的美术功底，有美术设计经验，熟悉多种风格手机界面设计，精通DIV+CSS，html5</LI>
                 <LI>2. 具有良好的艺术触觉及想象力，对色彩、整体风格有良好的感觉，对界面美感有较强驾驭和品评能力</LI>
                 <LI>3. 熟悉用户体验，并从用户体验的角度对用户流程、用户界面进行设计策划</LI>
                 <LI>4. 学历要求大专及以上，并要求至少1年以上工作经验</LI>
               </ul>
              
    <h4>文案编辑</h4>

               <ul>
                 <LI>岗位职责：</LI>
                 <LI>1. 负责网站相关栏目/频道的信息搜集、编辑、审校等工作</LI>
                 <LI>2. 编写网站宣传资料及相关产品资料，稿件思路清晰，能够完成稿件写作思路规划</LI>
                 <LI>3. 组织策划推广活动，并参与执行，加强与内部相关部门和组织外部的沟通与协作</LI>
                 <LI>4. 协助项目经理进行创意提案，保证工作的顺利推进</LI>
                 <LI>5. 独立撰写各类稿件（新闻稿、综述稿、评论稿、专访稿等）、策划方案、报告等</LI>
               </ul>
               <BR>
    <ul>
                 <LI>任职要求：</LI>
                 <LI>1. 新闻学、传播学、中文、经济管理类相关专业，大学本科以上学历</LI>
                 <LI>2. 有媒体编辑领域从业经验者优先</LI>
                 <LI>3. 能够准确捕捉产品亮点，具备恰如其分的文字表现能力</LI>
                 <LI>4. 熟悉专业创意方法，思维敏捷，洞察力强，文字功底扎实，语言表达能力强</LI>
                 <LI>5. 能独立完成项目、广告等推广文案的撰写</LI>
    </ul>
    <h4>区域销售经理</h4>
    <ul>
      <LI>岗位职责：</LI>
      <LI>1. 根据公司设定的市场策略在所辖区域展开营销工作，对目标客户进行产品介绍，方案沟通，达成合作签约</LI>
      <LI>2. 开发客户资源，管理和维护客户关系，深度拓展潜在营销机会</LI>
      <LI>3. 收集市场信息，进行客户分层管理，维护提升存量客户贡献度</LI>
      <LI>4. 完成各项业务或产品销售任务，及时反馈市场销售信息</LI>
    </ul>
    <BR>
    <ul>
      <LI>任职要求：</LI>
      <LI>1. 大学本科（含）以上学历</LI>
      <LI>2. 有企业信用管理、企业供应链管理、商业信用评级、商业信用保险从业经验优先；有各类企业客户资源者优先</LI>
      <LI>3. 具有较强的营销能力，勇于接受挑战，具有坚忍不拔的精神</LI>
      <LI>4. 有一定文字综合能力、风险识别能力、团队协作能力和问题解决能力；诚实守信，具有良好的职业道德</LI>
    </ul>
    <h4>报告文员</h4>
    <ul>
      <LI>岗位职责：</LI>
      <LI>1. 负责网站相关栏目/频道的信息搜集、编辑、审校等工作</LI>
      <LI>2. 编写网站宣传资料及相关产品资料，稿件思路清晰，能够完成稿件写作思路规划</LI>
      <LI>3. 组织策划推广活动，并参与执行，加强与内部相关部门和组织外部的沟通与协作</LI>
      <LI>4. 协助项目经理进行创意提案，保证工作的顺利推进</LI>
      <LI>5. 独立撰写各类稿件（新闻稿、综述稿、评论稿、专访稿等）、策划方案、报告等</LI>
    </ul>
    <BR>
    <ul>
      <LI>任职要求：</LI>
      <LI>1. 新闻学、传播学、中文、经济管理类相关专业，大学本科以上学历</LI>
      <LI>2. 有媒体编辑领域从业经验者优先</LI>
      <LI>3. 能够准确捕捉产品亮点，具备恰如其分的文字表现能力</LI>
      <LI>4. 熟悉专业创意方法，思维敏捷，洞察力强，文字功底扎实，语言表达能力强</LI>
      <LI>5. 能独立完成项目、广告等推广文案的撰写</LI>
    </ul>
    <p>&nbsp;</p>
    <h4>财务经理</h4>
    <ul>
      <LI>岗位职责：</LI>
      <LI>1. 负责公司的日常账务，包括原始凭证的复核、归档和录入，完成相关财务报表的制作</LI>
      <LI>2. 负责公司月季年度财务预算，并检查每周的现金流量预算</LI>
      <LI>3. 负责公司报税事项，包括增值税发票的进项税认证，营业税和增值税发票的开具，每月的纳税申报</LI>
      <LI>4. 负责每月税务公布，年度税务结算，所得税清算与和税务当局事件的办理和沟通</LI>
      <LI>5. 负责公司会计凭证、账簿报表、财务计划和重要经济合同等会计相关资料的审核、归档和登记编号装订</LI>
      <LI>6.  协调公司其他关联企业的业务及账务处理，制作公司合并报表</LI>
      <LI>7. 管控公司现金流，协调公司开户银行关系</LI>
      <LI>8. 精通和熟练操作用友财务软件</LI>
    </ul>
    <BR>
    <ul>
      <LI>任职要求：</LI>
      <LI>1. 会计、财务专业，本科及以上学历</LI>
      <LI>2. 至少5年以上会计经验，有上市公司财务经理或财务主管工作经历者优先</LI>
      <LI>3. 良好的书面及口语英语水平</LI>
      <LI>4. 注册会计师或具有会计事务所工作经营者优先</LI>
      <LI>5. 熟悉新会计准则和国家相关财务法规，并可熟练操作财务管理软件和相关办公软件</LI>
    </ul>
    <p>&nbsp;</p>

    <p>&nbsp;</p>
    </div>
  <div class="col-lg-4">
    <div class="bs-component">
      <ul class="nav nav-pills nav-stacked">
        <li><a href="toIndexAddition8.do">关于我们</a></li>
        <li  class="active"><a href="toIndexAddition9.do">工作机会</a></li>
        <li><a href="toIndexAddition10.do">样本下载</a></li>
        <li ><a href="toIndexAddition11.do">隐私及保密</a></li>
        <li><a href="toIndexAddition12.do">法律声明</a></li>
        <li  ><a href="toIndexAddition7.do">用户协议</a></li>
      </ul>
    </div>
  </div>
</div>

<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
</body>
</html>