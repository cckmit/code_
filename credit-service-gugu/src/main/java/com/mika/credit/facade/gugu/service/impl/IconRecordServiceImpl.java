package com.mika.credit.facade.gugu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.IconRecordMapper;
import com.mika.credit.facade.gugu.model.IconRecord;
import com.mika.credit.facade.gugu.service.IconRecordService;
import com.mika.credit.facade.gugu.util.UploadFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by Mike on 2017/4/13.
 */

@Service("iconRecordService")
public class IconRecordServiceImpl implements IconRecordService {
    private static Logger logger = Logger.getLogger(IconRecordServiceImpl.class);

    @Autowired
    private IconRecordMapper iconRecordMapper;

    @Override
    public String getCustomIconList(String data) {
        logger.debug("进入用户已定制图标的方法！");
        ResponseResult<List<IconRecord>> responseResult = new ResponseResult<>();
        IconRecord iconRecord = JSON.parseObject(data,IconRecord.class);

        if(StringUtil.isNotNull(iconRecord)&&StringUtil.isNotNull(iconRecord.getUserId())&&StringUtil.isNotNull(iconRecord.getIconType())){
            List<IconRecord> iconRecords = iconRecordMapper.selectByPrimaryKeySelective(iconRecord);
            //如果没有定制，取默认
            if(iconRecords.size()< 1 ){
                IconRecord record = new IconRecord();
                record.setIconType(iconRecord.getIconType());
                record.setUserId(0);
                List<IconRecord> iconRecordList = iconRecordMapper.selectByPrimaryKeySelective(record);
                for(IconRecord icon : iconRecordList){
                    icon.setUserId(iconRecord.getUserId());
                    icon.setUpdateTime(new Date());
                    icon.setId(null);
                    iconRecordMapper.insert(icon);
                    iconRecords.add(icon);
                }
            }
            responseResult.setContent(iconRecords);
            responseResult.setCode(true);
            responseResult.setMsg("获取客户定制图标成功");
        }else {
            responseResult.setCode(false);
            responseResult.setMsg("获取客户定制图标失败");
        }
        logger.info("获取客户定制图标方法的返回结果:" + JSON.toJSONString(responseResult));
        return JSON.toJSONString(responseResult);

    }

    @Override
    public String saveOrUpdateCustomerIcon(String data,String path) {
        logger.debug("进入编辑用户定制图标的方法！");
        Boolean flag = true;
        ResponseResult<IconRecord> responseResult = new ResponseResult<>();
        List<IconRecord> iconRecord = JSON.parseArray(data,IconRecord.class);
        if (iconRecord.size()>0){
            for(IconRecord icon : iconRecord){
                if(StringUtil.isNotNull(icon)&&StringUtil.isNotNull(icon.getId())){
                    icon.setUpdateTime(new Date());
                    iconRecordMapper.updateByPrimaryKeySelective(icon);
                }else{
                    flag=false;
                }
            }
            if (flag){
                responseResult.setCode(true);
                responseResult.setMsg("编辑客户定制图标成功");
            }else{
                responseResult.setCode(false);
                responseResult.setMsg("编辑客户定制图标失败");
            }
        }else{
            responseResult.setCode(false);
            responseResult.setMsg("编辑客户定制图标失败");
        }
        logger.info("编辑用户定制图标方法的返回结果:" + JSON.toJSONString(responseResult));
        return JSON.toJSONString(responseResult);
    }


}