package com.mika.credit.web.gugu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.ShareRecord;
import com.mika.credit.facade.gugu.service.ShareRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebOtherController {

	private static final Logger log = Logger
			.getLogger(WebOtherController.class);

	@Autowired
	ShareRecordService shareRecordService;

	@RequestMapping(value = "/other/toShare.do")
	public String toShare(HttpServletRequest request , HttpServletResponse response, ModelMap map,
			 String data) throws Exception {
		JSONObject jsonObject = JSON.parseObject(data);
		
		String  businessCardJson = jsonObject.getString("businessCard");
		 
		String  shareRecordId = jsonObject.getString("shareRecordId");
		
		BusinessCard card = new BusinessCard();
		if(null != businessCardJson && !businessCardJson.equals("")){
			 card = JSON.parseObject(businessCardJson, BusinessCard.class);
		}
		
		ShareRecord shareRecord = new ShareRecord();
		if(null != shareRecord && !shareRecord.equals("")){
			 shareRecord = shareRecordService.getShareRecordById(Integer.parseInt(shareRecordId));
		}
		
		map.put("card", card);
		map.put("shareRecord", shareRecord);
		
		return "/other/share";
		
	}

	

}
