package com.mika.credit.facade.gugu.service.impl;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.FeedbackMapper;
import com.mika.credit.facade.gugu.model.Feedback;
import com.mika.credit.facade.gugu.service.FeedbackService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Mike on 2017/4/13.
 */

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    private static Logger logger = Logger.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public String addFeedback(String data) {
        logger.debug("进入新增反馈的方法！");
        ResponseResult<Feedback> responseResult = new ResponseResult<>();
        Feedback feedback = JSON.parseObject(data,Feedback.class);
        if (StringUtil.isNotNull(feedback)) {
            feedback.setCreateDate(new Date());
            feedbackMapper.insert(feedback);
            responseResult.setCode(true);
            responseResult.setMsg("新增反馈信息成功!");
        }else{
            responseResult.setCode(false);
            responseResult.setMsg("新增反馈信息失败!");
        }
        logger.info("新增反馈方法的返回结果："+ JSON.toJSONString(responseResult));
            return JSON.toJSONString(responseResult);
    }


}