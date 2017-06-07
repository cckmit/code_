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

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="${basePath}../include/include.jsp"/>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>Full Search</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<style>
		.navbar-holder-dark {
			padding: 20px 20px 200px 20px;
			background: #333333;
		}
	</style>
	<script type="text/javascript">
		function productSearch(product) {
			$('#type').val("Products");

            $('#companyName').val(product);

            $('#form').submit();
        }
	</script>

</head>
<body>
<jsp:include page="${basePath}../include/top.jsp"/>

<div class="fxq-more-in">
	<div class="fxq-more-title">Products by Category</div>
	<div class="fxq-block"></div>
	<table class="fxq-more-table">
		<tr>
			<c:forEach var="industry_big" items="${industryBig}">
				<td class="fxq-floor-btn ">
					<div class="fxq-floor-text">${industry_big.getName()}</div>
					<div class="fxq-floor-mask"></div>
				</td>
				<%--fxq-more-table-td--%>
			</c:forEach>
			<td style="height:0;clear: both"></td>
		</tr>
	</table>
	<c:forEach var="industry_big" items="${industryAll}">
	<div class="fxq-floors">
		<div class="fxq-more-floor">
			
			<div class="fxq-more-floor-t">
			${industry_big.getName()}
				<%--新增 Industry leaders--%>
				<a href="#" style="float: right;font-size: 16px;text-decoration: underline;">Industry Leaders</a>
			</div>
			<div style="padding: 10px 30px;overflow: hidden;">

				<c:forEach var="industry_mid" items="${industry_big.getIndustryClassMiddle()}">
					<div class="fxq-floor-box">
						<div class="fxq-more-li-t">
							<a href="#" onclick="productSearch('${industry_mid.getName()}')">${industry_mid.getName()}</a>
						</div>
						<ul class="fxq-floor-ul">
							<c:forEach var="industry_sm" items="${industry_mid.getIndustryClassSmalls()}">
								<li>
									<a href="#" onclick="productSearch('${industry_sm.getName()}')">${industry_sm.getName()}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</c:forEach>

				<div style="clear: both"></div>
			</div>




		</div>
	</div>
	</c:forEach>

</div>
<div class="fxq-back-top">TOP</div>


<jsp:include page="${basePath}../include/bottom.jsp"/>


<script>
    $(function(){
        $(".fxq-floor-btn").each(function(i){
            $(this).css({"backgroundImage":"url('<%=basePath%>images/site/more"+(i+1)+".png')"})
		})

		$(".fxq-floor-text").eq(0).css({"lineHeight":"60px"}).end()
			.eq(2).css("lineHeight","60px").end()
			.eq(4).css("lineHeight","60px").end()
			.eq(6).css("lineHeight","60px").end()
			.eq(7).css("lineHeight","60px").end()
        	.eq(1).css({"lineHeight":"18px","paddingTop":"12px"}).end()
			.eq(3).css({"lineHeight":"18px","paddingTop":"12px"}).end()
			.eq(8).css({"lineHeight":"18px","paddingTop":"12px"}).end()
			.eq(9).css({"lineHeight":"18px","paddingTop":"12px"}).end()
			.eq(10).css({"lineHeight":"18px","paddingTop":"12px"}).end()
			.eq(11).css({"lineHeight":"18px","paddingTop":"12px"}).end()
			.eq(5).css({"lineHeight":"18px","paddingTop":"12px"});
        $(".fxq-floor-mask").eq(0).css({"display":"none"});
        $(".fxq-floor-text").eq(0).css({"color":"#000","textShadow":"none"});
        //点击跳到对应楼层
        $(".fxq-floor-btn").click(function(){
            //点击 btn 加选中效果
            var num=$(this).index();
            $(".fxq-floor-mask").eq(num).css({"display":"none"}).parent().siblings().find(".fxq-floor-mask").css({"display":"block"});
            $(".fxq-floor-text").eq(num).css({"color":"#000","textShadow":"none"}).parent().siblings().find(".fxq-floor-text").css({"color":"#fff","textShadow":"0 1px 2px #000"});
            // 元素距离文档顶部距离
            var reltop=$(".fxq-more-floor").eq(num).offset().top-130;
            $("html,body").animate({scrollTop:reltop});
        });
        // 滚动到一定高度btns固定
        $(window).scroll(function(){
            // 网页卷起的高度
            var ctop=$(window).scrollTop();
            // btn跟浏览器顶部的距离
            var btntop=$(".fxq-more-table").offset().top-ctop;
            if($(window).scrollTop()>btntop){
                $(".fxq-more-table").css({"position":"fixed", "top":0, "margin":0
                })
                $(".fxq-block").css("display","block");
                $(".fxq-back-top").css({"right":"150px","display":"block"});//backtop
            }else{
                $(".fxq-more-table").css({"position":"static", "margin-top":"20px"});
                $(".fxq-block").css("display","none");
                $(".fxq-back-top").css({"right":"150px","display":"none"});//backtop
            };

            // 当每块内容滚动到顶部时对应的btn呈现选中效果
            $(".fxq-more-floor").each(function(i){
                var floors=$(".fxq-more-floor").eq(i).offset().top;
                if($(window).scrollTop()>floors-150){
                    $(".fxq-floor-mask").eq(i).css({"display":"none"}).parent().siblings().find(".fxq-floor-mask").css({"display":"block"});
                    $(".fxq-floor-text").eq(i).css({"color":"#000","textShadow":"none"}).parent().siblings().find(".fxq-floor-text").css({"color":"#fff","textShadow":"0 1px 2px #000"});
                }
            })
        });

        $(".fxq-back-top").click(function(){
            $("html,body").animate({scrollTop:0});
        })

        $(".fxq-floor-ul").each(function(i){
            var bh=$(".fxq-floor-ul").eq(i).height();
            if(bh>240){
                $(this).css({"height":240,"overflow":"hidden"});
                $(this).after("<div class='fxq-floor-more'>MORE∨</div>");
                var flag=1;
                $($(".fxq-floor-ul").eq(i).siblings()).click(function(){
                    if(flag==1){
                        $(".fxq-floor-ul").eq(i).css({"height":"auto"});
                        $(this).html("LESS∧");
                        flag=0;
                    }else{
                        flag=1;
                        $(".fxq-floor-ul").eq(i).css({"height":240,"overflow":"hidden"});
                        $(this).html("MORE∨");
                    }
                })
            }else{

            }
        });
    })
</script>

</body>
</html>