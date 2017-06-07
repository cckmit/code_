package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.BusinessCardMapper;
import com.mika.credit.facade.gugu.dao.FinancingMapper;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.Financing;
import com.mika.credit.facade.gugu.service.FinancingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/5/15.
 */
@Service("financingService")
public class FinancingServiceImpl implements FinancingService {
    private static Logger logger = Logger.getLogger(FinancingServiceImpl.class);

    @Autowired
    private BusinessCardMapper businessCardMapper;

    @Autowired
    private FinancingMapper financingMapper;

    @Override
    public String add(String json, String path) {
        logger.debug("进入新增融资服务的方法！");
        ResponseResult<Financing> result = new ResponseResult<>();
        Financing financing = JSON.parseObject(json, Financing.class);     //json参数转化为对象
        if (StringUtil.isNotNull(financing)) {
            if (StringUtil.isNotNull(financing.getUserName())){
                if (StringUtil.isNotNull(financing.getBusinessCardId())) {
                    if(StringUtil.isNotNull(financing.getMobileNum())) {
                        if(StringUtil.isNotNull(financing.getServiceType())) {
                            if(StringUtil.isNotNull(financing.getEnterpriseType())) {
                                BusinessCard businessCard=businessCardMapper.selectByPrimaryKey(financing.getBusinessCardId());
                                if(StringUtil.isNotNull(businessCard)) {   //查询传入的名片是否存在
                                    financing.setDelFlag("1");     //设置删除标志为可查询
                                    if (financingMapper.selectSelective(financing).size() > 0) {
                                        result.setCode(false);
                                        result.setMsg("该融资服务已存在，添加失败！");
                                    } else {
                                        financing.setUpdateTime(new Date());
                                        financing.setCreateTime(new Date());
                                        if (StringUtil.isNotNull(path)) {
                                            financing.setShowPhotoPath(path);           //设置图像路径
                                        }
                                        int change = financingMapper.insertSelective(financing);
                                        if (change > 0) {
                                            result.setContent(financing);
                                            result.setCode(true);
                                            result.setMsg("新增融资服务成功！");
                                        } else {
                                            result.setCode(false);
                                            result.setMsg("新增融资服务失败！");
                                        }
                                    }
                                }else{
                                    result.setCode(false);
                                    result.setMsg("该名片不存在！");
                                }
                            }else{
                                result.setCode(false);
                                result.setMsg("企业类型不能为空！");
                            }
                        }else{
                            result.setCode(false);
                            result.setMsg("服务类型不能为空！");
                        }
                    }else{
                        result.setCode(false);
                        result.setMsg("手机号不能为空！");
                    }
                } else {
                    result.setCode(false);
                    result.setMsg("名片ID不能为空！");
                }
            } else {
                result.setCode(false);
                result.setMsg("用户名不能为空！");
            }
        } else {
            result.setCode(false);
            result.setMsg("融资服务不能为空！");
        }
        logger.info("新增融资服务方法的返回结果："+ JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updateByPrimaryKeySelective(String json, String path) {
        logger.debug("进入更新融资服务的方法！");
        ResponseResult<Financing> result = new ResponseResult<>();
        Financing financing = JSON.parseObject(json, Financing.class);     //json参数转化为对象
        if (financing != null) {
            Financing financing1=financingMapper.selectByPrimaryKey(financing.getId());
            if (StringUtil.isNotNull(financing1)) {
                if("1".equals(financing1.getDelFlag())) {   //是否已删除
                    financing.setUpdateTime(new Date());
                    if (StringUtil.isNotNull(path)) {
                        financing.setShowPhotoPath(path);           //设置图像路径
                    }
                    int change = financingMapper.updateByPrimaryKeySelective(financing);
                    if (change > 0) {
                        Financing financing2 = financingMapper.selectByPrimaryKey(financing.getId());
                        result.setContent(financing2);
                        result.setCode(true);
                        result.setMsg("更新融资服务成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("更新融资服务失败！");
                    }
                }else{
                    result.setCode(false);
                    result.setMsg("需要更新的融资服务已删除，更新失败！");
                }
            }else{
                result.setCode(false);
                result.setMsg("需要更新的融资服务不存在，更新失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("融资服务不能为空！");
        }
        logger.info("更新融资服务方法的返回结果："+ JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteByPrimaryKey(String json) {
        logger.debug("进入删除融资服务的方法！");
        ResponseResult<Financing> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                Financing financing = financingMapper.selectByPrimaryKey(id);    //查询当前id的融资服务并把删除标志改成“0”代表删除，“1”是不删除
                if (StringUtil.isNotNull(financing)) {      //判断要删除的融资服务是否存在
                    financing.setDelFlag("0");         //变成已删除的标志，“1”代表没删除
                    int change = financingMapper.updateByPrimaryKeySelective(financing);
                    if (change > 0) {
                        result.setCode(true);
                        result.setMsg("删除融资服务成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("删除融资服务失败！");
                    }
                }else{
                    result.setCode(false);
                    result.setMsg("您要删除的融资服务不存在，删除失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要删除的融资服务！");
            }
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空！");
        }
        logger.info("删除融资服务方法的返回结果："+ JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKey(String json) {
        logger.debug("进入根据id查找融资服务的方法！");
        ResponseResult<Financing> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                Financing financing = financingMapper.selectByPrimaryKey(id);
                if (financing != null) {
                    if ("1".equals(financing.getDelFlag())) {      //判断当前查找的推广信息删除标志是否是“1”，“1”表示没删除
                        result.setCode(true);
                        result.setMsg("获取融资服务成功！");
                        result.setContent(financing);
                    } else {
                        result.setCode(false);
                        result.setMsg("查找的融资服务已删除，查找失败！");
                    }
                } else {
                    result.setCode(false);
                    result.setMsg("获取融资服务失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要查找的融资服务！");
            }
        }else {
            result.setCode(false);
            result.setMsg("传入的参数为空！");
        }
        logger.info("根据id查找融资服务方法的返回结果："+ JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectSelective(String json) {
        logger.debug("进入条件查找融资服务的方法！");
        BootGrid<Financing> bootGrid = new BootGrid<>();
        JSONObject jsonObject = JSONObject.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)) {
            String current = jsonObject.getString("pageNo");
            String rowCount = jsonObject.getString("pageSize");
            bootGrid.setCurrent(Integer.parseInt(current));
            bootGrid.setRowCount(Integer.parseInt(rowCount));
            PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            String financingString = jsonObject.getString("financing");
            Financing financing = JSON.parseObject(financingString, Financing.class);     //json参数转化为对象
            financing.setDelFlag("1");     //设置删除标志为可查询
            List<Financing> financings = financingMapper.selectSelective(financing);
            bootGrid.setRows(financings);
            bootGrid.setTotal(financings.size());
            bootGrid.setResult(true);
            bootGrid.setResultDes("获取融资服务列表成功！");
        }else{
            bootGrid.setResult(false);
            bootGrid.setResultDes("传入信息为空！");
        }
        logger.info("条件查找融资服务方法的返回结果："+ JSON.toJSONString(bootGrid));
        return JSON.toJSONString(bootGrid);
    }


}
