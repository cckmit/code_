package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.ScanningCardExtendMapper;
import com.mika.credit.facade.gugu.dao.ScanningCardMapper;
import com.mika.credit.facade.gugu.model.ScanningCard;
import com.mika.credit.facade.gugu.model.ScanningCardExtend;
import com.mika.credit.facade.gugu.service.ScanningCardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/4/17.
 */
@Service("scanningCardService")
public class ScanningCardServiceImpl implements ScanningCardService {
    private static Logger logger = Logger.getLogger(ScanningCardServiceImpl.class);

    @Autowired
    private ScanningCardMapper scanningCardMapper;

    @Autowired
    private ScanningCardExtendMapper scanningCardExtendMapper;

    @Override
    public String add(String json) {
        logger.debug("进入新增扫描名片方法！");
        ResponseResult<ScanningCard> result = new ResponseResult<>();
        ScanningCard scanningCard = JSON.parseObject(json, ScanningCard.class);     //json参数转化为对象
        if(StringUtil.isNotNull(scanningCard)&&StringUtil.isNotNull(scanningCard.getUserId())){
            //&&StringUtil.isNotNull(scanningCard.getCarduuId())
            if (scanningCardMapper.selectByPrimaryKeySelective(scanningCard).size() > 0) {
                result.setCode(false);
                result.setMsg("该扫描名片已存在，添加失败！");
            } else {
                scanningCard.setCreateTime(new Date());    //新建时间
                scanningCard.setUpdateTime(new Date());
                int change = scanningCardMapper.insertSelective(scanningCard);
                if (change > 0) {
                    List<ScanningCardExtend> scanningCardExtends = scanningCard.getScanningCardExtends();
                    if (StringUtil.isNotNull(scanningCardExtends)) {
                        logger.info("进入新增扫描拓展名片方法！");
                        for (ScanningCardExtend scanningCardExtend : scanningCardExtends) {       //遍历插入拓展信息
                            if (StringUtil.isNotNull(scanningCardExtend.getType())) {              //判断必需字段
                                scanningCardExtend.setScanningCardId(scanningCard.getId());              //设置cardId
                                scanningCardExtendMapper.insertSelective(scanningCardExtend);
                            }
                        }
                    }
                    result.setContent(scanningCard);
                    result.setCode(true);
                    result.setMsg("新增扫描名片成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("新增扫描名片失败！");
                }
            }
        }else{
            result.setCode(false);
            result.setMsg("新增扫描名片失败！");
        }
        logger.info("新增扫描名片方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updateByPrimaryKeySelective(String json) {
        logger.debug("进入更新扫描名片方法！");
        ResponseResult<ScanningCard> result = new ResponseResult<>();
        ScanningCard scanningCard = JSON.parseObject(json, ScanningCard.class);     //json参数转化为对象
        if(StringUtil.isNotNull(scanningCard) && StringUtil.isNotNull(scanningCard.getId())) {
            if (scanningCardMapper.selectByPrimaryKey(scanningCard.getId()) == null) {
                result.setCode(false);
                result.setMsg("该扫描名片不存在，更新失败！");
            } else {
                scanningCard.setUpdateTime(new Date());
                int change = scanningCardMapper.updateByPrimaryKeySelective(scanningCard);
                if (change > 0) {
                    List<ScanningCardExtend> scanningCardExtends = scanningCard.getScanningCardExtends();
                    if (StringUtil.isNotNull(scanningCardExtends)) {
                        ScanningCardExtend scanningCardExtend = new ScanningCardExtend();
                        scanningCardExtend.setScanningCardId(scanningCard.getId());
                        scanningCardExtendMapper.deleteSelective(scanningCardExtend);    //删除当前扫描名片下的名片拓展再进行添加
                        for (ScanningCardExtend scanningCardExtend1 : scanningCardExtends) {       //遍历插入拓展信息
                            if (StringUtil.isNotNull(scanningCardExtend1.getType())) {              //判断必需字段
                                scanningCardExtend1.setScanningCardId(scanningCard.getId());              //设置cardId
                                scanningCardExtendMapper.insertSelective(scanningCardExtend1);
                            }
                        }
                    }
                    result.setCode(true);
                    result.setMsg("更新扫描名片成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("更新扫描名片失败！");
                }
            }
        }else{
            result.setCode(false);
            result.setMsg("扫描名片信息为空或id为空！");
        }
        logger.info("更新扫描名片方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteByPrimaryKey(String json) {
        logger.debug("进入删除扫描名片方法！");
        ResponseResult<ScanningCard> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                if (scanningCardMapper.selectByPrimaryKey(id) == null) {
                    result.setCode(false);
                    result.setMsg("该扫描名片不存在，删除失败！");
                } else {
                    ScanningCardExtend scanningCardExtend = new ScanningCardExtend();
                    scanningCardExtend.setScanningCardId(id);
                    scanningCardExtendMapper.deleteSelective(scanningCardExtend);    //删除当前扫描名片下的名片拓展
                    int change = scanningCardMapper.deleteByPrimaryKey(id);
                    if (change > 0) {
                        result.setCode(true);
                        result.setMsg("删除扫描名片成功！");
                    } else {
                        result.setCode(false);
                        result.setMsg("删除扫描名片失败！");
                    }
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要删除的扫描名片！");
            }
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空！");
        }
        logger.info("删除扫描名片方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKey(String json) {
        logger.debug("进入根据id查找扫描名片方法！");
        ResponseResult<ScanningCard> result = new ResponseResult<>();
        JSONObject jsonObject = JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject) && StringUtil.isNotNull(jsonObject.getString("id"))) {
            String id1 = jsonObject.getString("id");
            Integer id = Integer.parseInt(id1);
            if (id != null && id != 0) {
                ScanningCard scanningCard1 = scanningCardMapper.selectByPrimaryKey(id);
                if (scanningCard1 != null) {
                    ScanningCardExtend scanningCardExtend = new ScanningCardExtend();
                    scanningCardExtend.setScanningCardId(id);
                    List<ScanningCardExtend> scanningCardExtends = scanningCardExtendMapper.selectByPrimaryKeySelective(scanningCardExtend);//查找当前扫描名片的拓展名片
                    scanningCard1.setScanningCardExtends(scanningCardExtends);
                    result.setCode(true);
                    result.setMsg("查找扫描名片成功！");
                    result.setContent(scanningCard1);
                } else {
                    result.setCode(false);
                    result.setMsg("查找扫描名片失败！");
                }
            } else {
                result.setCode(false);
                result.setMsg("请选择要查找的扫描名片！");
            }
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空！");
        }
        logger.info("根据id查找扫描名片方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String selectByPrimaryKeySelective(String json) {
        logger.debug("进入根据条件查找扫描名片方法！");
        BootGrid<ScanningCard> bootGrid=new BootGrid<>();
        JSONObject jsonObject = JSONObject.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)) {
            String current = jsonObject.getString("pageNo");
            String rowCount = jsonObject.getString("pageSize");
            bootGrid.setCurrent(Integer.parseInt(current));
            bootGrid.setRowCount(Integer.parseInt(rowCount));
            PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            String scanningCardd = jsonObject.getString("scanningCard");
            ScanningCard scanningCard = JSON.parseObject(scanningCardd, ScanningCard.class);     //json参数转化为对象
            List<ScanningCard> scanningCards = scanningCardMapper.selectByPrimaryKeySelective(scanningCard);//获取查询到的所有数据，再遍历查出所有名片拓展信息，进行二次封装
            List<ScanningCard> scanningCardList = new ArrayList<>();
            for (ScanningCard scanningCard1 : scanningCards) {
                ScanningCardExtend scanningCardExtend = new ScanningCardExtend();
                scanningCardExtend.setScanningCardId(scanningCard1.getId());
                List<ScanningCardExtend> scanningCardExtends = scanningCardExtendMapper.selectByPrimaryKeySelective(scanningCardExtend);//查找当前扫描名片的拓展名片
                scanningCard1.setScanningCardExtends(scanningCardExtends);
                scanningCardList.add(scanningCard1);
            }
            bootGrid.setRows(scanningCardList);
            bootGrid.setTotal(scanningCardList.size());
            bootGrid.setResult(true);
            bootGrid.setResultDes("获取扫描名片列表成功！");
        }else{
            bootGrid.setResult(false);
            bootGrid.setResultDes("传入参数为空！");
        }
        logger.info("根据条件查找扫描名片方法的返回结果："+JSON.toJSONString(bootGrid));
        return JSON.toJSONString(bootGrid);
    }

    @Override
    public String updatePic(String json, String path) {
        logger.debug("进入上传头像图片方法！");
        ResponseResult<ScanningCard> result = new ResponseResult<>();
        ScanningCard scanningCard = JSON.parseObject(json, ScanningCard.class);     //json参数转化为对象
        if(StringUtil.isNotNull(scanningCard)&&StringUtil.isNotNull(scanningCard.getUserId())) {
            //上传图片
           // String path = UploadFile.uploadMufile(file);
            if (StringUtil.isNotNull(path)){
                scanningCard.setUpdateTime(new Date());
                scanningCard.setPhotoPath(path);           //设置头像路径
                if (StringUtil.isNotNull(scanningCard.getId())){
                    scanningCardMapper.updateByPrimaryKeySelective(scanningCard);
                }else {
                    scanningCardMapper.insert(scanningCard);
                }
                result.setContent(scanningCard);
                result.setCode(true);
                result.setMsg("上传头像成功");
            }else {
                result.setCode(false);
                result.setMsg("上传头像失败");
            }
        }else {
            result.setCode(false);
            result.setMsg("编辑头像失败");
        }
        logger.info("上传头像图片方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }
}
