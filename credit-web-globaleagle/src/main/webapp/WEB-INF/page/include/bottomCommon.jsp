<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<script>
    var basePath = '<%=basePath%>';
    function fastAddOrder() {
        var fastCountry = $('#fastCountry').val();
        var fastCompanyName = $('#fastCompanyName').val();
        window.location.href = basePath + "user/toFastAddOrder.do?country=" + fastCountry + "&fastCompanyName=" + fastCompanyName;

    }
</script>

<div class="footerWrapper" id="footer1">
    <div class="item footer bottom-menu bottom-menu-large bottom-menu-inverse">
        <div class="container" style="border-bottom: none;">
            <div class="col-md-4">
                <h5 class="title" style="color: #373d41;font-weight: bold;margin-bottom: 18px;">快捷订购</h5>
                <ul class="bottom-links">
                    <li style="padding-bottom:8px;padding-top:5px">
                        <div class="input-group" style="height:46px; width: 140px;">
                            <input type="text" class="form-control input searchCountry" id="fastCountry"
                                   style="font-size:12px; width:80%;margin-bottom: 12px;cursor: text;"
                                   placeholder="国家名称" autocomplete="off" required>
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li style="padding-bottom:0px;margin-bottom: 12px;"><input type="text" class="form-control input"
                                                                               id="fastCompanyName"
                                                                               style="font-size:12px; width:80%;cursor: text;"
                                                                               placeholder="目标公司名称" autocomplete="off"
                                                                               required></li>
                    <li>
                        <button type="button" class="btn btn-primary " style="display: inline-block;"
                                onclick="fastAddOrder()">
                            下一步
                        </button>
                        <span style="padding-left:10px;display: inline-block;color: #73777a;"> * 输入国家名称及目标公司名称</span>
                    </li>
                </ul>
            </div>

            <div class="col-md-2">
                <h5 class="title" style="color: #373d41;font-weight: bold;margin-bottom: 18px;">信用服务</h5>
                <ul class="bottom-links" style="padding-top: 5px;">
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition1.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">实地认证服务</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition2.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">全球应收帐管理</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition3.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">全球司法服务</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition4.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">尽职调查服务</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition5.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">商业咨询服务</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition6.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">数据API服务</a>
                    </li>
                </ul>
            </div>
            <div class="col-md-2">
                <h5 class="title" style="color: #373d41;font-weight: bold;margin-bottom: 18px;">网站相关</h5>
                <ul class="bottom-links" style="padding-top: 5px;">
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition7.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">搜索及订购服务协议</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;" class="active"><a
                            href="<%=basePath%>toIndexAddition8.do"
                            style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">关于我们</a></li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition9.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">工作机会</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition10.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">样本下载</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition11.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">隐私及保密</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="<%=basePath%>toIndexAddition12.do"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">法律声明</a>
                    </li>
                </ul>
            </div>
            <div class="col-md-2">
                <h5 class="title" style="color: #373d41;font-weight: bold;margin-bottom: 18px;">帮助及支持</h5>
                <ul class="bottom-links" style="padding-top: 5px;" id="helpCateSupport">
                    <%--<%--%>
                    <%--HelpService h = (HelpService) SpringContextUtils.getBean("helpService");--%>
                    <%--if(h == null){--%>
                    <%--}--%>
                    <%--else{--%>
                    <%--System.out.println(h);--%>
                    <%--List<HelpCate> cates = h.getHelpCates().getRows();--%>
                    <%--pageContext.setAttribute("cates", cates);--%>
                    <%--}--%>
                    <%--%>--%>
                    <%--<c:forEach items="${cates}" var="cate">--%>
                    <%--<li style="height:16px;margin-bottom: 8px;"><a href="#fakelink" onclick="toHelp(${cate.id})" style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">${cate.name}</a></li>--%>
                    <%--</c:forEach>--%>
                </ul>
            </div>
            <div class="col-md-2">
                <h5 class="title" style="color: #373d41;font-weight: bold;margin-bottom: 18px;">联系方式</h5>
                <ul class="bottom-links" style="padding-top: 5px;">
                    <li style="height:16px;margin-bottom: 8px;"><a href="#fakelink"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">热线：400-7729-029</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="#fakelink"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">电话：021-3638-6226</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="#fakelink"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">邮箱：info@global-eagle.cn</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="#fakelink"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">在线QQ：2140890079</a>
                    </li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="#fakelink"
                                                                   style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">估估信用&nbsp;&nbsp;<span
                            class="label label-small label-primary">New</span></a></li>
                    <li style="height:16px;margin-bottom: 8px;"><a href="#fakelink"
                                                                   style="font-size: 12px;height:18px;line-height: 18px;color:#73777a;">地址：上海市静安区愚园路168号环球世界大厦26层</a>
                    </li>
                </ul>
            </div>
            <%--<legend>&nbsp;</legend>--%>
            <%--<div class="col-md-8" style="font-size:12px">Global Eagle 全球鹰 | Copyright © 2016 Golbal-Eagle.cn 保留所有权利 </div> <div  class="col-md-4" align="right"  style="font-size:12px"><a href="http://www.miitbeian.gov.cn/" target="_blank">沪ICP备15022071号</a></div>--%>
        </div>
    </div>
    <!-- /.item -->
</div>
<div class="page-foot-hr"
     style="width: 100%; margin: auto;padding: 10px 0px 20px 0px;line-height: inherit;border-top: 1px solid #e5e5e5;background-color: #efefef;clear: both;overflow: hidden;zoom: 1;">
    <p style="margin: auto;color: #73777a;width: 1170px;font-size: 12px;text-align: center;padding-top: 10px;">Global
        Eagle 全球鹰 | Copyright © 2016 Golbal-Eagle.cn 保留所有权利 </p>
    <%--<p style="margin: auto;color: #73777a;;width: 1170px;font-size: 12px;text-align: center;padding-top: 5px;">沪ICP备15022071号</p>--%>
    <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011302003405"
       style="margin: auto;font-size: 12px;width: 185px;padding-top: 5px;text-decoration:none;height:25px;line-height:25px;display: block;">
        <img src="<%=basePath%>/images/img/guohui.png" style="float:left;display: block;border: none;" alt="图片加载失败"/>
        <p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#73777a;font-size: 12px;">沪公网安备
            31011302003405号</p>
    </a>
</div>
<script type="text/javascript">
    $(function () {
//        alert(basePath);
        $.post(
            basePath + "manager/helpCateList.do",
            {},
            function (data) {
                data = JSON.parse(data);
                $('#helpCateSupport').empty();   //清空helpCateSupport里面的所有内容
                var html = '';
                var helpCates = data.rows;
                for (var i = 0; i < helpCates.length; i++) {
                    var cate = helpCates[i];
                    html += '<li style="height:16px;margin-bottom: 8px;"><a href="#fakelink" onclick="toHelp(' + cate.id + ')" style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">' + cate.name + '</a></li>';
                }
                $('#helpCateSupport').html(html);
            }
        );
//        $.ajax({
//            type:"POST",
//            url:basePath+"manager/helpCateList.do",
//            dataType:"json",
//            contentType:"application/json",
//            data:JSON.stringify(null),
//			success:function(data){
//                $('#helpCateSupport').empty();   //清空helpCateSupport里面的所有内容
//                var html = '';
//                if(data!=null){
//                    var helpCates = data.getRows();
//                    for(var i =0;i<helpCates.length;i++){
//                        var cate=helpCates[i];
//                        html+='<li style="height:16px;margin-bottom: 8px;"><a href="#fakelink" onclick="toHelp('+cate.id+')" style="font-size: 12px;height:16px;line-height: 16px;color:#73777a;">'+cate.name+'</a></li>';
//                    }
//                }
//                $('#helpCateSupport').html(html);
//            }
//        });
    });
</script>