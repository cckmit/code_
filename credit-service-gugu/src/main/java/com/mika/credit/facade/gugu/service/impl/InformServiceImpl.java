package com.mika.credit.facade.gugu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.InformMapper;
import com.mika.credit.facade.gugu.model.Inform;
import com.mika.credit.facade.gugu.service.InformService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/4/13.
 */

@Service("informService")
public class InformServiceImpl implements InformService {

    private static Logger logger = Logger.getLogger(InformService.class);

    @Autowired
    private InformMapper informMapper;


    @Override
    public Inform addInform(Inform inform) {
        logger.debug("进入新增通知的方法！");
        int a = informMapper.insert(inform);
        if (a > 0){
            logger.info("新增通知方法的返回结果："+inform);
            return inform;
        }
        logger.info("新增通知方法失败！");
        return null;
    }

    @Override
    public String getInformList(String data) {
        logger.info("进入获取通知列表的方法！");
        BootGrid<Inform> bootGrid = new BootGrid<>();
        JSONObject jsonObject = JSON.parseObject(data);
        Inform inform = new Inform();
        String userId = jsonObject.getString("userId");
        String pageNo = jsonObject.getString("pageNo");
        String pageSize = jsonObject.getString("pageSize");
        if (StringUtil.isNotNull(userId)&&StringUtil.isNotNull(pageNo)&&StringUtil.isNotNull(pageSize)){
            inform.setUserId(Integer.parseInt(userId));
            bootGrid.setCurrent(Integer.parseInt(pageNo));
            bootGrid.setRowCount(Integer.parseInt(pageSize));
            PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            List<Inform> informs = informMapper.selectByPrimaryKeySelective(inform);
            bootGrid.setRows(informs);
            bootGrid.setTotal(informs.size());
            bootGrid.setResult(true);
            bootGrid.setResultDes("获取通知列表成功！");
        }else{
            bootGrid.setResult(false);
            bootGrid.setResultDes("获取通知列表失败，参数不能为空！");
        }
        logger.info("获取通知列表方法的返回结果："+JSON.toJSONString(bootGrid));
        return JSON.toJSONString(bootGrid);
    }

    @Override
    public String isInformRead(String data) {
        logger.info("进入通知标记为已阅的方法！");
        ResponseResult<Inform> responseResult = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(data);
        String informId = jsonObject.getString("informId");
        if (StringUtil.isNotNull(informId)){
            Inform inform = informMapper.selectByPrimaryKey(Integer.parseInt(informId));
            if (StringUtil.isNotNull(inform)){
                //更新状态已读
                inform.setIsView("0");
                informMapper.updateByPrimaryKeySelective(inform);
                responseResult.setCode(true);
                responseResult.setMsg("通知标记为已阅成功！");
            }else{
                responseResult.setCode(false);
                responseResult.setMsg("通知标记为已阅，无该条通知！");
            }
        }else{
            responseResult.setCode(false);
            responseResult.setMsg("通知标记为已阅，参数不能为空！");
        }
        logger.info("通知标记为已阅方法的返回结果："+JSON.toJSONString(responseResult));
        return JSON.toJSONString(responseResult);
    }

    @Override
    public String deleteInform(String data) {
        logger.info("进入删除通知的方法！");
        ResponseResult<Inform> responseResult = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(data);
        String informId = jsonObject.getString("informId");
        if (StringUtil.isNotNull(informId)){
            Inform inform = informMapper.selectByPrimaryKey(Integer.parseInt(informId));
            if (StringUtil.isNotNull(inform)){
                //删除该条通知
                informMapper.deleteByPrimaryKey(inform.getId());
                responseResult.setCode(true);
                responseResult.setMsg("删除通知成功！");
            }else{
                responseResult.setCode(false);
                responseResult.setMsg("删除通知失败，无该条通知！");
            }
        }else{
            responseResult.setCode(false);
            responseResult.setMsg("删除通知失败，参数不能为空！");
        }
        logger.info("删除通知方法的返回结果："+JSON.toJSONString(responseResult));
        return JSON.toJSONString(responseResult);
    }

    @Override
    public String getInformInfo(String data) {
        logger.info("进入获取通知信息的方法！");
        ResponseResult<Inform> responseResult = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(data);
        String informId = jsonObject.getString("informId");
        if (StringUtil.isNotNull(informId)){
            Inform inform = informMapper.selectByPrimaryKey(Integer.parseInt(informId));
            if (StringUtil.isNotNull(inform)){
                responseResult.setContent(inform);
                responseResult.setCode(true);
                responseResult.setMsg("获取通知信息成功！");
            }else{
                responseResult.setCode(false);
                responseResult.setMsg("获取通知信息失败，无该条通知！");
            }
        }else{
            responseResult.setCode(false);
            responseResult.setMsg("获取通知信息失败，参数不能为空！");
        }
        logger.info("获取通知信息方法的返回结果："+JSON.toJSONString(responseResult));
        return JSON.toJSONString(responseResult);
    }


}