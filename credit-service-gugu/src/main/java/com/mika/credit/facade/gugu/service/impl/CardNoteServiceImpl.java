package com.mika.credit.facade.gugu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.BusinessCardMapper;
import com.mika.credit.facade.gugu.dao.CardNoteMapper;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.CardNote;
import com.mika.credit.facade.gugu.service.CardNoteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/4/13.
 */

@Service("cardNoteService")
public class CardNoteServiceImpl implements CardNoteService {
    private static Logger logger = Logger.getLogger(CardNoteServiceImpl.class);

    @Autowired
    private CardNoteMapper cardNoteMapper;

    @Autowired
    private BusinessCardMapper businessCardMapper;

    @Override
    public String add(String json) {
        logger.debug("进入新增名片备注方法！");
        ResponseResult<CardNote> result = new ResponseResult<>();
        CardNote cardNote = JSON.parseObject(json, CardNote.class);     //json参数转化为对象
        if (StringUtil.isNotNull(cardNote)) {
            if (StringUtil.isNotNull(cardNote.getUserId())) {
                if (StringUtil.isNotNull(cardNote.getBusinessCardId())) {
                    if (cardNoteMapper.selectByPrimaryKeySelective(cardNote).size() > 0) {
                        result.setCode(false);
                        result.setMsg("该名片备注已存在，添加失败！");
                    } else {
                        cardNote.setUpdateTime(new Date());
                        int change = cardNoteMapper.insertSelective(cardNote);
                        if (change > 0) {
                            CardNote cardNote1 = new CardNote();
                            cardNote1.setBusinessCardId(cardNote.getBusinessCardId());
                            int count = cardNoteMapper.selectByPrimaryKeySelective(cardNote1).size();   //当前备注所属的名片下共有多少备注
                            BusinessCard businessCard = businessCardMapper.selectByPrimaryKey(cardNote.getBusinessCardId());//查找并更新当前名片下的备注数量
                            businessCard.setCardNote(count + "");
                            businessCardMapper.updateByPrimaryKeySelective(businessCard);
                            result.setContent(cardNote);
                            result.setCode(true);
                            result.setMsg("新增名片备注成功！");
                        } else {
                            result.setCode(false);
                            result.setMsg("新增名片备注失败！");
                        }
                    }
                } else {
                    result.setCode(false);
                    result.setMsg("名片ID不能为空！");
                }
            } else {
                result.setCode(false);
                result.setMsg("用户ID不能为空！");
            }
        } else {
            result.setCode(false);
            result.setMsg("名片备注不能为空！");
        }
        logger.info("新增名片备注方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updateByPrimaryKeySelective(String json) {
        logger.debug("进入更新名片备注方法！");
        ResponseResult<CardNote> result = new ResponseResult<>();
        CardNote cardNote = JSON.parseObject(json, CardNote.class);     //json参数转化为对象
        if (cardNote != null) {
            if (cardNoteMapper.selectByPrimaryKey(cardNote.getId())== null) {
                result.setCode(false);
                result.setMsg("该名片备注不存在，更新失败！");
            } else {
                cardNote.setUpdateTime(new Date());
                int change = cardNoteMapper.updateByPrimaryKeySelective(cardNote);
                if (change > 0) {
                    result.setCode(true);
                    result.setMsg("更新名片备注成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("更新名片备注失败！");
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("名片备注不能为空！");
        }
        logger.info("更新名片备注方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteByPrimaryKey(String json) {
        logger.debug("进入删除名片备注方法！");
        ResponseResult<CardNote> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                CardNote cardNote1 = cardNoteMapper.selectByPrimaryKey(id);   //得到当前要删备注的所属名片
                if (!StringUtil.isNotNull(cardNote1)) {
                    result.setCode(false);
                    result.setMsg("该名片备注不存在，删除失败！");
                } else {
                    int change = cardNoteMapper.deleteByPrimaryKey(id);
                    if (change > 0) {
                        CardNote cardNote2 = new CardNote();
                        cardNote2.setBusinessCardId(cardNote1.getBusinessCardId());     //设置要查询当前名片id
                        int count = cardNoteMapper.selectByPrimaryKeySelective(cardNote2).size();   //当前名片id的所有数量
                        BusinessCard businessCard = businessCardMapper.selectByPrimaryKey(cardNote1.getBusinessCardId());   //查询名片id对象
                        businessCard.setCardNote(count + "");   //设置对应的名片下备注数量
                        businessCardMapper.updateByPrimaryKeySelective(businessCard);  //更新备注数量
                        result.setCode(true);
                        result.setMsg("删除名片备注成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("删除名片备注失败！");
                    }
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要删除的名片备注！");
            }
        }else{
        result.setCode(false);
        result.setMsg("传入的参数为空！");
    }
        logger.info("删除名片备注方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKey(String json) {
        logger.debug("进入根据id查询名片备注方法！");
        ResponseResult<CardNote> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                CardNote cardNote1 = cardNoteMapper.selectByPrimaryKey(id);
                if (cardNote1 != null) {
                    result.setCode(true);
                    result.setMsg("获取名片备注成功！");
                    result.setContent(cardNote1);
                } else {
                    result.setCode(false);
                    result.setMsg("获取名片备注失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要查找的名片备注！");
            }
        }else{
            result.setCode(false);
            result.setMsg("传入的参数为空！");
        }
        logger.info("根据id查询名片备注方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKeySelective(String json) {
        logger.debug("进入条件查询名片备注方法！");
        BootGrid<CardNote> bootGrid = new BootGrid<>();
        JSONObject jsonObject = JSONObject.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)) {
            String current = jsonObject.getString("pageNo");
            String rowCount = jsonObject.getString("pageSize");
            bootGrid.setCurrent(Integer.parseInt(current));
            bootGrid.setRowCount(Integer.parseInt(rowCount));
            PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            String cardNotes = jsonObject.getString("cardNote");
            CardNote cardNote = JSON.parseObject(cardNotes, CardNote.class);     //json参数转化为对象
            bootGrid.setRows(cardNoteMapper.selectByPrimaryKeySelective(cardNote));
            bootGrid.setTotal(cardNoteMapper.selectByPrimaryKeySelective(cardNote).size());
            bootGrid.setResult(true);
            bootGrid.setResultDes("获取名片备注列表成功！");
        }else{
            bootGrid.setResult(false);
            bootGrid.setResultDes("传入参数为空！");
        }
        logger.info("条件查询名片备注方法的返回结果："+JSON.toJSONString(bootGrid));
        return JSON.toJSONString(bootGrid);
    }
}
