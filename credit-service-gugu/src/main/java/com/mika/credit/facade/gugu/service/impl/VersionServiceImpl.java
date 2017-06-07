package com.mika.credit.facade.gugu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.VersionsMapper;
import com.mika.credit.facade.gugu.model.Versions;
import com.mika.credit.facade.gugu.service.VersionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/4/13.
 */

@Service("versionService")
public class VersionServiceImpl implements VersionService {

    private static Logger logger = Logger.getLogger(VersionService.class);

    @Autowired
    private VersionsMapper versionsMapper;

    @Override
    public String getVersionInfo(String data) {
        logger.debug("进入获取最新版本的方法！");
        ResponseResult<Versions> responseResult = new ResponseResult<>();
        Versions versions = new Versions();
        JSONObject jsonObject = JSON.parseObject(data);
        String versiontype = jsonObject.getString("versiontype");
        if (StringUtil.isNotNull(versiontype)){
            versions.setVersionType(versiontype);
            List<Versions> versionsList = versionsMapper.selectByPrimaryKeySelective(versions);
            if (versionsList.size()>0){
                versions = versionsList.get(0);
                responseResult.setCode(true);
                responseResult.setMsg("获取APP版本成功！");
                responseResult.setContent(versions);
            }else{
                responseResult.setCode(false);
                responseResult.setMsg("获取APP版本失败，无新版本！");
            }
        }else{
            responseResult.setCode(false);
            responseResult.setMsg("获取APP版本失败，参数不能为空！");
        }
        logger.info("获取最新版本方法的返回结果："+ JSON.toJSONString(responseResult));
        return JSON.toJSONString(responseResult);

    }
}