package com.mika.credit.facade.gugu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.BusinessCardMapper;
import com.mika.credit.facade.gugu.dao.ShareRecordMapper;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.ShareRecord;
import com.mika.credit.facade.gugu.service.ShareRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mike on 2017/4/13.
 */

@Service("shareRecordService")
public class ShareRecordServiceImpl implements ShareRecordService {
    private static Logger logger = Logger.getLogger(ShareRecordServiceImpl.class);

    @Autowired
    ShareRecordMapper shareRecordMapper;

    @Autowired
    BusinessCardMapper businessCardMapper;

    @Override
    public String shareRecord(String data, String path,String webPath) {
        logger.debug("进入分享的方法！");
        ResponseResult<String> responseResult = new ResponseResult<>();
        ShareRecord shareRecord = new ShareRecord();
        JSONObject jsonObject = JSON.parseObject(data);
        String cardId = jsonObject.getString("cardId");
        String shareplatform = jsonObject.getString("shareplatform");
        if (StringUtil.isNotNull(cardId)&&StringUtil.isNotNull(shareplatform)){
            BusinessCard businessCard = businessCardMapper.selectByPrimaryKey(Integer.parseInt(cardId));
            shareRecord.setCreateTime(new Date());
            shareRecord.setSharePlatform(shareplatform);
            //String path = UploadFile.uploadMufile(file);
            if (StringUtil.isNotNull(path)){
                shareRecord.setPhotoPath(path);
                shareRecordMapper.insert(shareRecord);
                Map<String, Object> map = new HashMap<>();
                map.put("businessCard", businessCard);
                map.put("shareRecordId", shareRecord.getId());
                JSONObject jsonObjects = new JSONObject();
                jsonObjects.putAll(map);
                String sharePath = webPath+"other/toShare.do?data="+jsonObjects.toString();
                responseResult.setCode(true);
                responseResult.setContent(sharePath);
                responseResult.setMsg("分享成功");
            }else{
                responseResult.setCode(false);
                responseResult.setMsg("上传图片失败");
            }
        }else{
            responseResult.setCode(false);
            responseResult.setMsg("参数不能为空");
        }
        logger.info("分享方法的返回结果："+ JSON.toJSONString(responseResult));
        return JSON.toJSONString(responseResult);
    }

    @Override
    public ShareRecord getShareRecordById(Integer id) {
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(id);
        return shareRecord;
    }
}