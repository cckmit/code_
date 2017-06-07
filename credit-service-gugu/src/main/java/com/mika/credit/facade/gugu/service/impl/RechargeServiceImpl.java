package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.RechargeLogMapper;
import com.mika.credit.facade.gugu.dao.UsersMapper;
import com.mika.credit.facade.gugu.model.RechargeLog;
import com.mika.credit.facade.gugu.service.RechargeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by dong jian hua on 2017/4/18.
 */
@Service("rechargeService")
public class RechargeServiceImpl implements RechargeService {
    private static Logger logger = Logger.getLogger(RechargeServiceImpl.class);

    @Autowired
    private RechargeLogMapper rechargeLogMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public String rechargeList(String data) {
        logger.debug("进入获取充值列表的方法！");
        BootGrid<RechargeLog> bootGrid = new BootGrid<>();
        RechargeLog rechargeLog = new RechargeLog();
        JSONObject jsonObject = JSON.parseObject(data);
        String userId = jsonObject.getString("userId");
        String pageNo = jsonObject.getString("pageNo");
        String pageSize = jsonObject.getString("pageSize");
        if (StringUtil.isNotNull(userId)&&StringUtil.isNotNull(pageNo)&&StringUtil.isNotNull(pageSize)){
            rechargeLog.setUserId(Integer.parseInt(userId));
            bootGrid.setCurrent(Integer.parseInt(pageNo));
            bootGrid.setRowCount(Integer.parseInt(pageSize));
            PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            List<RechargeLog> rechargeLogs = rechargeLogMapper.selectByPrimaryKeySelective(rechargeLog);
            bootGrid.setRows(rechargeLogs);
            bootGrid.setTotal(rechargeLogs.size());
            bootGrid.setResult(true);
            bootGrid.setResultDes("获取充值列表成功！");
        }else{
            bootGrid.setResult(false);
            bootGrid.setResultDes("获取充值列表失败，参数不能为空！");
        }
        logger.info("获取充值列表方法的返回结果：" + JSON.toJSONString(bootGrid));
        return JSON.toJSONString(bootGrid);
    }


    @Override
    public String rechargeAmount(String data) {
        logger.debug("进入用户充值的方法！");
        ResponseResult<RechargeLog> result = new ResponseResult<>();
        RechargeLog record  = JSON.parseObject(data,RechargeLog.class);
        if(null != record && null != record.getUserId()){
            RechargeLog rechargeLog = rechargeLogMapper.selectByPrimaryKey(record.getId());
//            String ip = Tool.getIP(request);
//            rechargeLog.setLoginIp(ip);
            int updateRecharge = rechargeLogMapper.updateByPrimaryKeySelective(rechargeLog);
            if(updateRecharge>0){
                result.setCode(true);
                result.setMsg("充值成功");
                result.setContent(rechargeLog);
            }
        }else{
            result.setCode(false);
            result.setMsg("充值失败");
        }
        logger.info("用户充值方法的返回结果：" + JSON.toJSONString(result));
        return JSONObject.toJSONString(result);
    }
}
