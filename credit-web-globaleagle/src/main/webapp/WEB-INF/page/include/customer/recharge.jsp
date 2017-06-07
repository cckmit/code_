<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String patd = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + patd + "/";
%>
  <script src="<%=basePath%>js/include/recharge.js"></script>
<div id="rechargeModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="z-index: 9999">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">我要充值</h4>
      </div>
      <div class="modal-body">
        <label for="methodId" class="col-sm-2 control-label">支付方式</label>
        <div class="row">
          <div class="btn-group">
            <button type="button" class="btn btn-default" onclick="chooseMethod(1);">支付宝</button>
            <button type="button" class="btn btn-default" onclick="chooseMethod(2);">银联</button>
            <button type="button" class="btn btn-default" onclick="chooseMethod(3);">农行</button>
            <button type="button" class="btn btn-default" onclick="chooseMethod(4);">工商</button>
          </div>
        </div>
        <img id="img1" alt="支付宝" src="<%=basePath%>images/payfor/ps_alipay.png"  width="60" height="60" style="display: none;">
        <img id="img2" alt="银联" src="<%=basePath%>images/payfor/ps_unionpay.png"  width="60" height="60" style="display: none;">
        <img id="img3" alt="农行" src="<%=basePath%>images/payfor/ps_icbc.png"  width="60" height="60" style="display: none;">
        <img id="img4" alt="工商" src="<%=basePath%>images/payfor/ps_abc.png"  width="60" height="60" style="display: none;">
        <BR><BR>
        <input type="hidden" id="methodId" name="methodId" class="form-control" placeholder="支付方式" required autofocus>
        <label for="amount" class="col-sm-2 control-label">金额</label>
        <input type="text
                " id="amount" name="amount" class="form-control" placeholder="金额" required><BR>
        <button class="btn btn-lg btn-primary btn-block" onclick="addRecharge();">确定</button>
      </div>
      <div class="modal-footer">
      </div>

    </div>
  </div>
</div>