package com.mika.credit.web.globaleagle.controller.core.nomal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globaleagle.core.model.CollectionInfo;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.service.CollectionInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 司法信息收藏
 */
@SuppressWarnings({"ALL", "CheckStyle"})
@Controller
public class CollectionInfoController {
	private static Logger logger = Logger.getLogger(CollectionInfoController.class);
    @Autowired
    private CollectionInfoService collectionInfoService;

	@RequestMapping(value = "/customer/addcollection",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String addcollection(@RequestBody String json,HttpServletRequest request) {
		logger.info("添加司法信息方法开始...");
		Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
		JSONObject jsonObject = JSON.parseObject(json);
		String dataType = jsonObject.getString("dataType");
		String id = jsonObject.getString("id");
		JSONObject senddata = new JSONObject();
		senddata.put("dataType",dataType);
		senddata.put("id",id);
		String colOrderDetailId = jsonObject.getString("colOrderDetailId");
		Integer cusId = customer.getId();
		Integer orderDetailId = Integer.parseInt(colOrderDetailId);
		String type = jsonObject.getString("colType");
		String court = jsonObject.getString("colCourt");
		String caseNo = jsonObject.getString("colCaseNo");
		Date creatDate = jsonObject.getDate("colSortTimeString");
		String topic = jsonObject.getString("colTopic");
		CollectionInfo colInfo = new CollectionInfo();
		colInfo.setCustomerId(cusId);
		colInfo.setOrderDetailId(orderDetailId);
//		colInfo.setContent(colContent);
		colInfo.setType(type);
		colInfo.setCourt(court);
		colInfo.setCaseNo(caseNo);
		colInfo.setTopic(topic);
		colInfo.setCreateDate(creatDate);
		int result = collectionInfoService.insertCol(colInfo);
		if(result == 1) {
			return "true";
		 } else {
			return "false";
		}
	}

	@RequestMapping(value = "/customer/loadColList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String loadColList(BootGrid<CollectionInfo> grid, String orderDetailId, HttpServletRequest request) {
		logger.info("查询司法信息方法开始...");
		BootGrid<CollectionInfo> result = new BootGrid<CollectionInfo>();
		Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
		Integer cusId = customer.getId();
		Integer orderDetailIdInt = Integer.parseInt(orderDetailId);
		CollectionInfo colInfo = new CollectionInfo();
		colInfo.setCustomerId(cusId);
		colInfo.setOrderDetailId(orderDetailIdInt);
		result = this.collectionInfoService.loadColInfo(grid,colInfo);
		String json = JSON.toJSONString(result);
		return json;
	}

	@RequestMapping(value = "/customer/selContentById",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String selContentById(String id, HttpServletRequest request) {
		logger.info("根据id查询司法信息方法开始...");
		Integer idInt = Integer.parseInt(id);
		String content = collectionInfoService.selContentById(idInt);
		return JSON.toJSONString(content);
	}


	/**
	 * 删除司法信息 AJAX
	 * @param
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/customer/deletecColInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String deleteByPrimaryKey(String id) {
		logger.info("删除司法信息方法开始...");
		Integer intid = Integer.parseInt(id);
		Map<String, Object> result = collectionInfoService.deleteByPrimaryKey(intid);
		return JSON.toJSONString(result);
	}
}