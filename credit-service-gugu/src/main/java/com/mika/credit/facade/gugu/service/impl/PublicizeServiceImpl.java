package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.BusinessCardMapper;
import com.mika.credit.facade.gugu.dao.PublicizeFlagMapper;
import com.mika.credit.facade.gugu.dao.PublicizeMapper;
import com.mika.credit.facade.gugu.dao.PublicizePhotoMapper;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.Publicize;
import com.mika.credit.facade.gugu.model.PublicizeFlag;
import com.mika.credit.facade.gugu.model.PublicizePhoto;
import com.mika.credit.facade.gugu.service.PublicizeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/4/23.
 */
@Service("publicizeService")
public class PublicizeServiceImpl implements PublicizeService {

    private static Logger logger = Logger.getLogger(PublicizeServiceImpl.class);

    @Autowired
    private BusinessCardMapper businessCardMapper;

    @Autowired
    private PublicizeMapper publicizeMapper;

    @Autowired
    private PublicizeFlagMapper publicizeFlagMapper;

    @Autowired
    private PublicizePhotoMapper publicizePhotoMapper;

    @Override
    public String addPublicize(String json, String path) {
        logger.debug("进入新增企业推广信息方法！");
        ResponseResult<Publicize> result = new ResponseResult<>();
        Publicize publicize = JSON.parseObject(json, Publicize.class);     //json参数转化为对象
        if (publicize != null) {
            if (StringUtil.isNotNull(publicize.getUserId())) {
                if (StringUtil.isNotNull(publicize.getCardId())) {
                    BusinessCard businessCard=businessCardMapper.selectByPrimaryKey(publicize.getCardId());
                    if(StringUtil.isNotNull(businessCard)) {
                        if(StringUtil.isNotNull(businessCard.getVerificationScore()) && (businessCard.getVerificationScore()) >= 60) {
                            publicize.setDelFlag("1");     //设置删除标志为可查询
                            if (publicizeMapper.selectByPrimaryKeySelective(publicize).size() > 0) {
                                result.setCode(false);
                                result.setMsg("该企业推广信息已存在，添加失败！");
                            } else {
                                //上传图片
                                //String path = UploadFile.uploadMufile(file);
                                if (StringUtil.isNotNull(path)) {
                                    publicize.setPhotoPath(path);           //设置图像路径
                                    logger.info("上传头像图片！");
                                }
                                publicize.setCreateDate(new Date());   //设置推广时间
                                publicize.setUpdateTime(new Date());
                                publicize.setViewCount("0");      //浏览次数
                                int change = publicizeMapper.insertSelective(publicize);
                                if (change > 0) {
                                    result.setContent(publicize);
                                    result.setCode(true);
                                    result.setMsg("新增企业推广信息成功！");
                                } else {
                                    result.setCode(false);
                                    result.setMsg("新增企业推广信息失败！");
                                }
                            }
                        }else{
                            result.setCode(false);
                            result.setMsg("该名片核实分数没达到可添加推广信息的条件，不能添加推广信息！");
                        }
                    }else{
                        result.setCode(false);
                        result.setMsg("该名片不存在！");
                    }
                } else {
                    result.setCode(false);
                    result.setMsg("名片id不能为空！");
                }
            } else {
                result.setCode(false);
                result.setMsg("用户id不能为空！");
            }
        } else {
            result.setCode(false);
            result.setMsg("企业推广信息不能为空！");
        }
        logger.info("新增企业推广信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updateSelectivePublicize(String json, String path) {
        logger.debug("进入更新企业推广信息方法！");
         ResponseResult<Publicize> result = new ResponseResult<>();
        Publicize publicize = JSON.parseObject(json, Publicize.class);     //json参数转化为对象
        if (StringUtil.isNotNull(publicize)) {
            Publicize publicize1 = publicizeMapper.selectByPrimaryKey(publicize.getId());     //得到要更新的推广信息对象，判断是否为已删除信息，已删除信息不能进行更新
            if (StringUtil.isNotNull(publicize1)) {
                if ("1".equals(publicize1.getDelFlag())) {     //判断是否已删除
                    publicize.setUpdateTime(new Date());
                    //上传图片
                   // String path = UploadFile.uploadMufile(file);      //上传图片
                    if (StringUtil.isNotNull(path)) {
                        publicize.setPhotoPath(path);           //设置图像路径
                        logger.info("上传头像图片！");
                    }
                    int change = publicizeMapper.updateByPrimaryKeySelective(publicize);
                    if (change > 0) {
                        Publicize publicize2=publicizeMapper.selectByPrimaryKey(publicize.getId());//返回更新的推广信息
                        result.setContent(publicize2);
                        result.setCode(true);
                        result.setMsg("更新企业推广信息成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("更新企业推广信息失败！");
                    }
                } else {
                    result.setCode(false);
                    result.setMsg("需要更新的企业推广信息已删除，更新失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("需要更新的企业推广信息不存在，更新失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("更新的企业推广信息不能为空！");
        }
        logger.info("更新企业推广信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteByPrimaryKeyPublicize(String json) {
        logger.debug("进入删除企业推广信息方法！");
        ResponseResult<Publicize> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id")) ) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                Publicize publicize = publicizeMapper.selectByPrimaryKey(id);    //查询当前id的推广信息并把删除标志改成“0”代表删除，“1”是不删除
                if (StringUtil.isNotNull(publicize)) {      //判断要删除的企业推广信息是否存在
                    publicize.setDelFlag("0");         //变成已删除的标志，“1”代表没删除
                    int change = publicizeMapper.updateByPrimaryKeySelective(publicize);
                    if (change > 0) {
                        result.setCode(true);
                        result.setMsg("删除企业推广信息成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("删除企业推广信息失败！");
                    }
                } else {
                    result.setCode(false);
                    result.setMsg("您要删除的企业推广信息不存在，删除失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要删除的企业推广信息！");
            }
        }else{
            result.setCode(false);
            result.setMsg("传入信息为空！");
        }
        logger.info("删除企业推广信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKeyPublicize(String json) {
        logger.debug("进入根据id查询企业推广信息方法！");
        ResponseResult<Publicize> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id")) ) {
        String id1 = jsonObject.getString("id");
        Integer id = Integer.parseInt(id1);
        if (id != null && id != 0) {
            Publicize publicize = publicizeMapper.selectByPrimaryKey(id);
            if (publicize != null) {
                if ("1".equals(publicize.getDelFlag())) {      //判断当前查找的推广信息删除标志是否是“1”，“1”表示没删除
                    Integer count = Integer.parseInt(publicize.getViewCount());
                    if (count != null && count != 0) {
                        publicize.setViewCount((count + 1) + "");
                    } else {
                        publicize.setViewCount(1 + "");
                    }
                    publicizeMapper.updateByPrimaryKeySelective(publicize);
                    result.setCode(true);
                    result.setMsg("查找企业推广信息成功！");
                    result.setContent(publicize);
                } else {
                    result.setCode(false);
                    result.setMsg("查找的企业推广信息已删除，查找失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("查找企业推广信息失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("请选择要查找的企业推广信息！");
        }
        }else{
            result.setCode(false);
            result.setMsg("传入信息为空！");
        }
        logger.info("根据id查询企业推广信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectSelectivePublicize(String json) {
        logger.debug("进入根据条件查询企业推广信息方法！");
        BootGrid<Publicize> bootGrid = new BootGrid<>();
        JSONObject jsonObject = JSONObject.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)) {
            String current = jsonObject.getString("pageNo");
            String rowCount = jsonObject.getString("pageSize");
            bootGrid.setCurrent(Integer.parseInt(current));
            bootGrid.setRowCount(Integer.parseInt(rowCount));
            PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            String publicizeString = jsonObject.getString("publicize");
            Publicize publicize = JSON.parseObject(publicizeString, Publicize.class);     //json参数转化为对象
            publicize.setDelFlag("1");     //设置删除标志为可查询
            List<Publicize> publicizes = publicizeMapper.selectByPrimaryKeySelective(publicize);
            bootGrid.setRows(publicizes);
            bootGrid.setTotal(publicizes.size());
            for (Publicize publicize1 : publicizes) {
                Integer count = Integer.parseInt(publicize1.getViewCount());
                if (count != null && count != 0) {
                    publicize1.setViewCount((count + 1) + "");
                } else {
                    publicize1.setViewCount(1 + "");
                }
                publicizeMapper.updateByPrimaryKeySelective(publicize1);
            }
            bootGrid.setResult(true);
            bootGrid.setResultDes("获取企业推广信息列表成功！");
        }else{
            bootGrid.setResult(false);
            bootGrid.setResultDes("传入信息为空！");
        }
        logger.info("根据条件查询企业推广信息方法的返回结果："+JSON.toJSONString(bootGrid));
        return JSON.toJSONString(bootGrid);
    }

    @Override
    public String addPublicizeFlag(String json) {
        logger.debug("进入新增企业推广标签方法！");
        ResponseResult<PublicizeFlag> result = new ResponseResult<>();
        PublicizeFlag publicizeFlag = JSON.parseObject(json, PublicizeFlag.class);     //json参数转化为对象
        if (publicizeFlag != null) {
            if (publicizeFlagMapper.selectByPrimaryKeySelective(publicizeFlag).size() > 0) {
                result.setCode(false);
                result.setMsg("该企业推广标签已存在，添加失败！");
            } else {
                int change = publicizeFlagMapper.insertSelective(publicizeFlag);
                if (change > 0) {
                    result.setContent(publicizeFlag);
                    result.setCode(true);
                    result.setMsg("新增企业推广标签成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("新增企业推广标签失败！");
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("企业推广标签不能为空！");
        }
        logger.info("新增企业推广标签方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updateSelectivePublicizeFlag(String json) {
        logger.debug("进入更新企业推广标签方法！");
        ResponseResult<PublicizeFlag> result = new ResponseResult<>();
        PublicizeFlag publicizeFlag = JSON.parseObject(json, PublicizeFlag.class);     //json参数转化为对象
        if (StringUtil.isNotNull(publicizeFlag) && StringUtil.isNotNull(publicizeFlag.getId())) {
            if (publicizeFlagMapper.selectByPrimaryKey(publicizeFlag.getId()) == null) {
                result.setCode(false);
                result.setMsg("该企业推广标签不存在，更新失败！");
            } else {
                int change = publicizeFlagMapper.updateByPrimaryKeySelective(publicizeFlag);
                if (change > 0) {
                    PublicizeFlag publicizeFlag1=publicizeFlagMapper.selectByPrimaryKey(publicizeFlag.getId());
                    result.setContent(publicizeFlag1);
                    result.setCode(true);
                    result.setMsg("更新企业推广标签成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("更新企业推广标签失败！");
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("企业推广标签为空或id为空！");
        }
        logger.info("更新企业推广标签方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteByPrimaryKeyPublicizeFlag(String json) {
        logger.debug("进入删除企业推广标签方法！");
        ResponseResult<PublicizeFlag> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                if (publicizeFlagMapper.selectByPrimaryKey(id) == null) {
                    result.setCode(false);
                    result.setMsg("该企业推广标签不存在，更新失败！");
                } else {
                    int change = publicizeFlagMapper.deleteByPrimaryKey(id);
                    if (change > 0) {
                        result.setCode(true);
                        result.setMsg("删除企业推广标签成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("删除企业推广标签失败！");
                    }
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要删除的企业推广标签！");
            }
        }else{
            result.setCode(false);
            result.setMsg("传入信息为空！");
        }
        logger.info("删除企业推广标签方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKeyPublicizeFlag(String json) {
        logger.debug("进入根据ID查询企业推广标签方法！");
        ResponseResult<PublicizeFlag> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                PublicizeFlag publicizeFlag = publicizeFlagMapper.selectByPrimaryKey(id);
                if (publicizeFlag != null) {
                    result.setCode(true);
                    result.setMsg("查找企业推广信息成功！");
                    result.setContent(publicizeFlag);
                } else {
                    result.setCode(false);
                    result.setMsg("查找企业推广信息失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要查找的企业推广信息！");
            }
        }else{
        result.setCode(false);
        result.setMsg("传入信息为空！");
    }
        logger.info("根据id查找企业推广标签方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectSelectivePublicizeFlag(String json) {
        logger.debug("进入根据条件查找企业推广标签方法！");
        ResponseResult<List> result = new ResponseResult<>();
        PublicizeFlag publicizeFlag = JSON.parseObject(json, PublicizeFlag.class);     //json参数转化为对象
        List<PublicizeFlag> publicizeFlags = publicizeFlagMapper.selectByPrimaryKeySelective(publicizeFlag);
        result.setCode(true);
        result.setMsg("获取企业推广标签列表成功！");
        result.setContent(publicizeFlags);
        logger.info("根据条件查找企业推广标签方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updatePic(String json, String path) {
        logger.debug("进入上传企业推广图像方法！");
        ResponseResult<PublicizePhoto> result = new ResponseResult<>();
        PublicizePhoto publicizePhoto = JSON.parseObject(json, PublicizePhoto.class);     //json参数转化为对象
        if (StringUtil.isNotNull(publicizePhoto) && StringUtil.isNotNull(publicizePhoto.getPublicizeId())) {
            List<PublicizePhoto> publicizePhotos = publicizePhotoMapper.selectByPrimaryKeySelective(publicizePhoto);
            //上传图片
            //String path = UploadFile.uploadMufile(file);
            if (StringUtil.isNotNull(path)) {
                if (publicizePhotos.size()>0){
                    publicizePhoto = publicizePhotos.get(0);
                    publicizePhoto.setPhotoPath(path);
                    publicizePhoto.setUpdateTime(new Date());
                    publicizePhotoMapper.updateByPrimaryKeySelective(publicizePhoto);
                }else{
                    publicizePhoto.setUpdateTime(new Date());
                    publicizePhoto.setPhotoPath(path);
                    publicizePhotoMapper.insert(publicizePhoto);
                }
                result.setContent(publicizePhoto);
                result.setCode(true);
                result.setMsg("上传推广图像成功");
            } else {
                result.setCode(false);
                result.setMsg("上传推广图像失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("编辑推广图像失败");
        }
        logger.info("上传企业推广图像方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteByPrimaryKeyPublicizePhoto(String json) {
        logger.debug("进入删除企业推广图像方法！");
        ResponseResult<PublicizePhoto> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                if (publicizePhotoMapper.selectByPrimaryKey(id) == null) {
                    result.setCode(false);
                    result.setMsg("推广图像不存在，删除失败！");
                } else {
                    int change = publicizePhotoMapper.deleteByPrimaryKey(id);
                    if (change > 0) {
                        result.setCode(true);
                        result.setMsg("删除推广图像成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("删除推广图像失败！");
                    }
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要删除的推广图像！");
            }
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空！");
        }
        logger.info("删除企业推广图像方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKeyPublicizePhoto(String json) {
        logger.debug("进入根据id查询企业推广图像方法！");
        ResponseResult<PublicizePhoto> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
        String id1 = jsonObject.getString("id");
        Integer id = Integer.parseInt(id1);
        if (id != null && id != 0) {
            PublicizePhoto publicizePhoto = publicizePhotoMapper.selectByPrimaryKey(id);
            if (publicizePhoto != null) {
                result.setCode(true);
                result.setMsg("查找推广图像成功！");
                result.setContent(publicizePhoto);
            } else {
                result.setCode(false);
                result.setMsg("查找推广图像失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("请选择要查找的推广图像！");
        }
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空！");
        }
        logger.info("根据id查找企业推广图像方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectSelectivePublicizePhoto(String json) {
        logger.debug("进入根据条件查询企业推广图像方法！");
        ResponseResult<List> result = new ResponseResult<>();
        PublicizePhoto publicizePhoto = JSON.parseObject(json, PublicizePhoto.class);     //json参数转化为对象
        List<PublicizePhoto> publicizePhotos = publicizePhotoMapper.selectByPrimaryKeySelective(publicizePhoto);
        result.setCode(true);
        result.setMsg("获取推广图像列表成功！");
        result.setContent(publicizePhotos);
        logger.info("根据条件查询企业推广图像方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }
}
