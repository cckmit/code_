package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mika.credit.facade.gugu.dao.BusinessCardExtendMapper;
import com.mika.credit.facade.gugu.dao.CardNoteMapper;
import com.mika.credit.facade.gugu.model.BusinessCardExtend;
import com.mika.credit.facade.gugu.model.CardNote;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.gugu.dao.BusinessCardMapper;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.service.BusinessCardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/4/12.
 */

@Service("businessCardService")
public class BusinessCardServiceImpl implements BusinessCardService {

    private static Logger logger = Logger.getLogger(BusinessCardServiceImpl.class);

    @Autowired
    private BusinessCardMapper businessCardMapper;

    @Autowired
    private CardNoteMapper cardNoteMapper;

    @Autowired
    private BusinessCardExtendMapper businessCardExtendMapper;

    @Override
    public String add(String json) {
        logger.debug("进入新增名片信息方法！");
        ResponseResult<BusinessCard> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(json, BusinessCard.class);     //json参数转化为对象
        if (businessCard != null) {
            if (StringUtil.isNotNull(businessCard.getCardCompany())) {
                if (StringUtil.isNotNull(businessCard.getCardName())) {
                    if (StringUtil.isNotNull(businessCard.getCardPhone())) {
                        if (StringUtil.isNotNull(businessCard.getUserId())) {
                            if (businessCardMapper.selectByPrimaryKeySelective(businessCard).size() > 0) {
                                result.setCode(false);
                                result.setMsg("该名片已存在，添加失败！");
                            } else {
                                businessCard.setBusinessCardNo(UtilGenerateID.generateID("GU"));      //设置随机编码
                                businessCard.setCreateDate(new Date());   //设置创建时间
                                businessCard.setUpdateTime(new Date());
                                businessCard.setCardNote("0");      //名片下的备注数量
                                int change = businessCardMapper.insertSelective(businessCard);
                                if (change > 0) {
                                    List<BusinessCardExtend> businessCardExtends = businessCard.getBusinessCardExtends();
                                    if (StringUtil.isNotNull(businessCardExtends)) {
                                        logger.info("进入新增名片拓展方法！");
                                        for (BusinessCardExtend businessCardExtend : businessCardExtends) {       //遍历插入拓展信息
                                            if (StringUtil.isNotNull(businessCardExtend.getType())) {              //判断必需字段
                                                businessCardExtend.setCardId(businessCard.getId());              //设置cardId
                                                businessCardExtendMapper.insertSelective(businessCardExtend);
                                            }
                                        }
                                    }
                                    result.setContent(businessCard);
                                    result.setCode(true);
                                    result.setMsg("新增名片信息成功！");
                                } else {
                                    result.setCode(false);
                                    result.setMsg("新增名片信息失败！");
                                }
                            }
                        } else {
                            result.setCode(false);
                            result.setMsg("用户id不能为空！");
                        }
                    } else {
                        result.setCode(false);
                        result.setMsg("手机号码不能为空！");
                    }
                } else {
                    result.setCode(false);
                    result.setMsg("名片名称不能为空！");
                }
            } else {
                result.setCode(false);
                result.setMsg("公司名称不能为空！");
            }
        } else {
            result.setCode(false);
            result.setMsg("名片信息不能为空！");
        }
        logger.info("新增名片信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updatePic(String json, String path) {
        logger.debug("进入上传头像方法！");
        ResponseResult<BusinessCard> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(json, BusinessCard.class);     //json参数转化为对象
        if (StringUtil.isNotNull(businessCard) && StringUtil.isNotNull(businessCard.getCardCompany()) && StringUtil.isNotNull(businessCard.getCardName()) && StringUtil.isNotNull(businessCard.getCardPhone()) && StringUtil.isNotNull(businessCard.getUserId()) && StringUtil.isNotNull(businessCard.getBusinessCardNo())) {
            //上传图片
           // String path = UploadFile.uploadMufile(file);
            if (StringUtil.isNotNull(path)) {
                businessCard.setUpdateTime(new Date());
                businessCard.setPhotoPath(path);           //设置头像路径
                if (StringUtil.isNotNull(businessCard.getId())) {
                    businessCardMapper.updateByPrimaryKeySelective(businessCard);
                } else {
                    businessCardMapper.insert(businessCard);
                }
                result.setContent(businessCard);
                result.setCode(true);
                result.setMsg("上传头像成功");
            } else {
                result.setCode(false);
                result.setMsg("上传头像失败");
            }
        } else {
            result.setCode(false);
            result.setMsg("编辑头像失败");
        }
        logger.info("上传头像图片方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteByPrimaryKey(String json) {
        logger.debug("进入删除名片信息方法！");
        ResponseResult<BusinessCard> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if (StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                if (businessCardMapper.selectByPrimaryKey(id) == null) {
                    result.setCode(false);
                    result.setMsg("该名片信息不存在，删除失败！");
                } else {
                    CardNote cardNote = new CardNote();
                    cardNote.setBusinessCardId(id);     //当前名片信息下的名片备注
                    BusinessCardExtend businessCardExtend = new BusinessCardExtend();
                    businessCardExtend.setCardId(id);   //当前名片信息下的名片扩展
                    cardNoteMapper.deleteSelective(cardNote);
                    businessCardExtendMapper.deleteSelective(businessCardExtend);
                    int change = businessCardMapper.deleteByPrimaryKey(id);
                    if (change > 0) {
                        result.setCode(true);
                        result.setMsg("删除名片信息成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("删除名片信息失败！");
                    }
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要删除的名片！");
            }
        } else {
            result.setCode(false);
            result.setMsg("传入的参数为空！");
        }
        logger.info("删除名片信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKey(String json) {
        logger.debug("进入根据id查询名片信息方法！");
        ResponseResult<BusinessCard> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if (StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                BusinessCard businessCard1 = businessCardMapper.selectByPrimaryKey(id);
                if (businessCard1 != null) {
                    CardNote cardNote = new CardNote();
                    cardNote.setBusinessCardId(businessCard1.getId());     //当前名片信息下的名片备注
                    List<CardNote> cardNote1 = cardNoteMapper.selectByPrimaryKeySelective(cardNote);
                    businessCard1.setCardNotes(cardNote1);
                    BusinessCardExtend businessCardExtend = new BusinessCardExtend();
                    businessCardExtend.setCardId(businessCard1.getId());   //当前名片信息下的名片扩展
                    List<BusinessCardExtend> businessCardExtends = businessCardExtendMapper.selectByPrimaryKeySelective(businessCardExtend);
                    businessCard1.setBusinessCardExtends(businessCardExtends);
                    result.setCode(true);
                    result.setMsg("查找名片信息成功！");
                    result.setContent(businessCard1);
                } else {
                    result.setCode(false);
                    result.setMsg("查找名片信息失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要查找的名片！");
            }
        } else {
            result.setCode(false);
            result.setMsg("传入的参数为空！");
        }
        logger.info("根据id查询名片信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String addList(String json) {
        logger.debug("进入批量新增名片信息方法！");
        ResponseResult<BusinessCard> result = new ResponseResult<>();
        try {
            logger.info("批量新增名片信息方法的返回结果："+JSON.toJSONString(result));
            return addListRealize(json);
        } catch (Exception e) {
            result.setCode(false);
            result.setMsg("批量新增名片失败，请检查名片必填信息和是否已存在！");
            logger.error("批量新增名片失败，请检查名片必填信息和是否已存在！"+e);
            return JSON.toJSONString(result);
        }
    }

    public String addListRealize(String json) {
        ResponseResult<BusinessCard> result = new ResponseResult<>();
        List<BusinessCard> businessCards = JSON.parseArray(json, BusinessCard.class);     //json参数转化为对象数组
        if (StringUtil.isNotNull(businessCards) && businessCards.size() > 0) {
            for (BusinessCard businessCard : businessCards) {
                if (StringUtil.isNotNull(businessCard.getCardCompany()) && StringUtil.isNotNull(businessCard.getCardName()) && StringUtil.isNotNull(businessCard.getCardPhone()) && StringUtil.isNotNull(businessCard.getUserId())) {
                    if (businessCardMapper.selectByPrimaryKeySelective(businessCard).size() > 0) {
                        result.setCode(false);
                        result.setMsg("该名片已存在，添加失败！");
                        throw new RuntimeException();
                    } else {
                        businessCard.setBusinessCardNo(UtilGenerateID.generateID("GU"));      //设置随机编码
                        businessCard.setCreateDate(new Date());   //设置创建时间
                        businessCard.setUpdateTime(new Date());
                        businessCard.setCardNote("0");      //名片下的备注数量
                        int change = businessCardMapper.insertSelective(businessCard);
                        if (change > 0) {
                            List<BusinessCardExtend> businessCardExtends = businessCard.getBusinessCardExtends();
                            if (StringUtil.isNotNull(businessCardExtends)) {
                                for (BusinessCardExtend businessCardExtend : businessCardExtends) {       //遍历插入拓展信息
                                    if (StringUtil.isNotNull(businessCardExtend.getType())) {              //判断必需字段
                                        businessCardExtend.setCardId(businessCard.getId());              //设置cardId
                                        businessCardExtendMapper.insertSelective(businessCardExtend);
                                    }
                                }
                            }
                            result.setCode(true);
                            result.setMsg("批量新增名片信息成功！");
                        } else {
                            result.setCode(false);
                            result.setMsg("新增名片信息失败！");
                            logger.info("新增名片信息失败！");
                            throw new RuntimeException();
                        }
                    }
                } else {
                    result.setCode(false);
                    result.setMsg("请填写名片必填信息！");
                    logger.info("请填写名片必填信息！");
                    throw new RuntimeException();
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("名片信息参数不能为空！");
            logger.info("名片信息参数不能为空！");
            throw new RuntimeException();
        }
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKeySelective(String json) {
        logger.debug("进入条件查询名片信息方法！");
        ResponseResult<List> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(json, BusinessCard.class);     //json参数转化为对象
        List<BusinessCard> businessCards = businessCardMapper.selectByPrimaryKeySelective(businessCard);
        List<BusinessCard> businessCards1 = new ArrayList<>();
        for (BusinessCard businessCard1 : businessCards) {
            BusinessCardExtend businessCardExtend = new BusinessCardExtend();
            businessCardExtend.setCardId(businessCard1.getId());
            List<BusinessCardExtend> businessCardExtends = businessCardExtendMapper.selectByPrimaryKeySelective(businessCardExtend);
            CardNote cardNote = new CardNote();
            cardNote.setBusinessCardId(businessCard1.getId());
            List<CardNote> cardNotes = cardNoteMapper.selectByPrimaryKeySelective(cardNote);
            businessCard1.setCardNotes(cardNotes);
            businessCard1.setBusinessCardExtends(businessCardExtends);
            businessCards1.add(businessCard1);
        }
        result.setCode(true);
        result.setMsg("获取名片信息列表成功！");
        result.setContent(businessCards1);
        logger.info("条件查询名片信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updateByPrimaryKeySelective(String json) {
        logger.debug("进入更新名片信息方法！");
        ResponseResult<BusinessCard> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(json, BusinessCard.class);     //json参数转化为对象
        if (StringUtil.isNotNull(businessCard) && StringUtil.isNotNull(businessCard.getId())) {
            if (businessCardMapper.selectByPrimaryKey(businessCard.getId()) == null) {   //判断是否存在该名片信息
                result.setCode(false);
                result.setMsg("该名片信息不存在，更新失败！");
            } else {
                businessCard.setUpdateTime(new Date());
                int change = businessCardMapper.updateByPrimaryKeySelective(businessCard);
                if (change > 0) {
                    List<BusinessCardExtend> businessCardExtends = businessCard.getBusinessCardExtends();
                    if (StringUtil.isNotNull(businessCardExtends)) {
                        BusinessCardExtend businessCardExtend1 = new BusinessCardExtend();//设置查询条件
                        businessCardExtend1.setCardId(businessCard.getId());
                        businessCardExtendMapper.deleteSelective(businessCardExtend1); //删除该名片下的所有拓展名片再进行重新插入
                        for (BusinessCardExtend businessCardExtend : businessCardExtends) {       //遍历插入拓展信息
                            if (StringUtil.isNotNull(businessCardExtend.getType())) {
                                businessCardExtend.setCardId(businessCard.getId());              //设置cardId
                                businessCardExtendMapper.insertSelective(businessCardExtend);
                            }
                        }
                    }
                    BusinessCard businessCard1 = businessCardMapper.selectByPrimaryKey(businessCard.getId());
                    BusinessCardExtend businessCardExtend = new BusinessCardExtend();
                    businessCardExtend.setCardId(businessCard1.getId());
                    List<BusinessCardExtend> businessCardExtendList = businessCardExtendMapper.selectByPrimaryKeySelective(businessCardExtend);
                    CardNote cardNote = new CardNote();
                    cardNote.setBusinessCardId(businessCard1.getId());
                    List<CardNote> cardNotes = cardNoteMapper.selectByPrimaryKeySelective(cardNote);
                    businessCard1.setCardNotes(cardNotes);
                    businessCard1.setBusinessCardExtends(businessCardExtendList);
                    result.setContent(businessCard1);
                    result.setCode(true);
                    result.setMsg("更新名片信息成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("更新名片信息失败！");
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("名片信息为空或id为空！");
        }
        logger.info("更新名片信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }
}