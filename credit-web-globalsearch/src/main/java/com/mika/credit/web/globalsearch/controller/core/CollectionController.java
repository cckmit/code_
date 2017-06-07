package com.mika.credit.web.globalsearch.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.model.Collection;
import com.mika.credit.facade.globalsearch.core.model.Customer;
import com.mika.credit.facade.globalsearch.core.service.CollectionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller  
public class CollectionController {
    private static final Logger logger = Logger.getLogger(CollectionController.class);
    @Resource
    private CollectionService collectionService;
    /**
     * 分页查询收藏
     * @return
     */
    @RequestMapping(value = "/customer/collectionList" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getCollectionList(BootGrid<Collection> grid, Collection collection,@SessionAttribute("customerInfo") Customer customer) {
        logger.info("分页查询收藏开始...");
        collection.setCustomerId(customer.getId());
        BootGrid<Collection> result = collectionService.getCollection(grid,collection);
        return JSON.toJSONString(result);
    }
    /**
     * 添加收藏信息
     * @param collection
     * @return
     */
    @RequestMapping(value = "/customer/collectionSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String collectionSave(@RequestBody Collection collection) {
        logger.info("添加收藏开始...");
        ResponseResult<Collection> result = new ResponseResult<>();
        if (collection.getCustomerId()==null||collection.getCustomerId().equals("")&&collection.getCollectionCompany()==null||collection.getCollectionCompany().equals("")){
            result.setCode(false);
            result.setMsg("不能为空");
            return JSON.toJSONString(result);
        }else {
            collection.setCollectionTime(new Date());
            collectionService.add(collection);
            return JSON.toJSONString(result);
        }
    }

    /**
     * 根据客户ID查询是否收藏该公司
     * @param collection
     * @return
     */
    @RequestMapping(value = "/customer/getCollection",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String getCollection(@RequestBody Collection collection){
        logger.info("根据客户id查询该公司是否被收藏开始...");
        ResponseResult<Collection> result =collectionService.getCollectionByCidAndCname(collection);
            return JSON.toJSONString(result);
    }
    /**
     * 根据客户ID和收藏公司名删除收藏信息
     */
    @RequestMapping(value = "/customer/delCollection",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String delCollection(@RequestBody Collection collection) {
        logger.info("根据客户id和公司名删除收藏信息开始...");
        ResponseResult<Collection> result = null;
        result =collectionService.del(collection);
        return JSON.toJSONString(result);
    }
    /**
     * 根据id删除
     */
    @RequestMapping(value = "/customer/delCollectionById",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String delCollectionById(@RequestBody Collection collection) {
        logger.info("根据id删除收藏开始...");
        ResponseResult<Collection> result = null;
        result =collectionService.delById(collection.getId());
        return JSON.toJSONString(result);
    }
}  