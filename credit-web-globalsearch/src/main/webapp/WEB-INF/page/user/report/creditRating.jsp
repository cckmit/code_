<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="tab-pane fade in" id="Credit_rating">
    <div class="slimScrollBar">
        <div class="scrollable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-hover table-striped table-responsive">
                <tbody>
                    <tr>
                        <td colspan="6" align="center" style="padding: 15px 0;background: #fff;"><img
                                src="${pageContext.request.contextPath}/images/creditRatingEN/0.jpg"
                                width="100%"
                                alt=""/>
                        </td>
                    </tr>
                    <tr >
                        <td ><strong>Solvency Index</strong></td>
                        <td>-</td>
                    </tr>
                    <tr>
                        <td ><strong>Risk Assessment</strong></td>
                        <td>-</td>
                    </tr>
                    <tr>
                        <td><strong>Recommended Line</strong></td>
                        <td >-</td>
                    </tr>

                    <tr>
                        <td colspan="6" style="color: #878787;font-size: 12px;font-style: italic">
                            Note:
                            <p style="width: 93%;float:right;padding-right: 20px;">
                                In accordance with “Measures of the Customs of the People's Republic of China for the
                                Classified Management of Enterprises” published on April 1st,2008, the followings are the
                                Company Category Definition by General Customs:
                                <br>AA: Excellent
                                <br>A: Good
                                <br>B: Average
                                <br>C: Fairly Poor
                                <br>D: Very Poor
                            </p>
                        </td>
                    </tr>

                </tbody>
            </table>

            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-hover table-striped table-responsive">
                <tbody>

                <tr>
                    <td style="color: #878787;font-size: 12px;font-style: italic;padding-top:10px">
                        Note:
                        <p style="width: 93%;float:right;padding-right: 20px;margin-bottom:0">
                            This is just a credit opinion formed based on the information collected in this report.
                            The actual credit decision would vary and determined by the user based on company’s credit policy,
                            risk management strategy, actual situation, and many other circumstances.
                            This report is just for your reference.
                        </p>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    $(function(){
        var num=1;
        $("#money").click(function(){

            if(num==1){
                $(this).text("$");
                num=2;
            }else if(num==2){
                $(this).text("€");
                num=3;
            }else{
                $(this).text("￥");
                num=1;
            }
        })
    })
</script>