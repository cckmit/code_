package com.mika.credit.facade.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.*;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.order.dao.*;
import com.mika.credit.facade.order.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;


/**
 * Created by dell on 2017/3/2.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductModuleMapper productDetailMapper;
    @Autowired
    private OrderDetailViewMapper orderDetailViewMapper;

    private static final Log logger = LogFactory.getLog(ProductServiceImpl.class);

    @Override
    public BootGrid<Product> findProducts(BootGrid<Product> grid, Product example) {
        logger.info("进入查询产品列表findProducts方法");
        if (grid != null && example != null) {
            Page<Object> page = PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
            grid.setRows(productMapper.queryList(example));//获得记录集合
            grid.setTotal((int) page.getTotal());//获得总记录数
            grid.setResult(true);
        }
        logger.info("查询产品列表findProducts方法结束,返回结果:"+ JSON.toJSONString(grid));
        return grid;
    }

    @Override
    public BootGrid<Product> findCustomerProducts(BootGrid<Product> grid, OrderDetailViewQuery view, Product example) {
        logger.info("进入查询产品列表findCustomerProducts方法");
        if (grid != null && example != null && view != null) {
            Page<Object> page = PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
            //查询该报告类型下所有报告
            List<Product> products = productMapper.queryList(example);
            //查询该用户对该企业下的最新订单(customerId,companyName)
            List<OrderDetailView> orderDetailViews = orderDetailViewMapper.queryListByOrderDetailQuery(view);
            if (view.getCustomerId() == null) {
                return this.findProducts(grid, example);
            }
            if (!CollectionUtils.isEmpty(orderDetailViews) && !CollectionUtils.isEmpty(products)) {
                OrderDetailView orderDetailView = orderDetailViews.get(0);
                //已完成超过七天,全显示;未超过七天显示高等级报告
                if (orderDetailView.getOrderStatus().equals(OrderStatusEnum.FINISHED.getStatusCode())) {
                    Date createTime = orderDetailView.getCreateTime();
                    Date now = new Date();
                    long weekTime = 7 * 24 * 60 * 60 * 1000;
                    if (createTime != null && now.getTime() - createTime.getTime() < weekTime) {
                        Integer productId = orderDetailView.getProductId();
                        Product product = productMapper.queryById(productId);
                        ListIterator<Product> iterator = products.listIterator();
                        for (Product pro : products) {
                            if (pro.getLevel() <= product.getLevel()) {
                                pro.setHasOrder(true);
                            }
                        }
                        //while (iterator.hasNext()) {
                        //    Product next = iterator.next();
                        //    if (next.getLevel() <= product.getLevel()) {
                        //        iterator.remove();
                        //    }
                        //}
                    }
                    //未完成且未取消,显示高等级报告
                } else if (!Objects.equals(orderDetailView.getOrderStatus(), OrderStatusEnum.CANCELED.getStatusCode())) {
                    Integer productId = orderDetailView.getProductId();
                    Product product = productMapper.queryById(productId);
                    ListIterator<Product> iterator = products.listIterator();
                    for (Product pro : products) {
                        if (pro.getLevel() <= product.getLevel()) {
                            pro.setHasOrder(true);
                        }
                    }
                    //while (iterator.hasNext()) {
                    //    Product next = iterator.next();
                    //    if (next.getLevel() <= product.getLevel()) {
                    //        iterator.remove();
                    //    }
                    //}

                }//已取消,全显示
            }
            grid.setRows(products);
            grid.setTotal((int) page.getTotal());
            grid.setResult(true);
        }
        logger.info("查询产品列表findCustomerProducts方法结束,返回结果:"+ JSON.toJSONString(grid));
        return grid;
    }

    @Override
    public ResponseResult<Product> findProductById(Integer productId) {
        logger.info("进入根据产品id查询产品findProductById方法");
        ResponseResult<Product> responseResult = new ResponseResult<>();
        if (productId != null) {
            Product product = productMapper.queryById(productId);
            if (product != null) {
                responseResult.setCode(true);
                responseResult.setContent(product);
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("无此产品");
        }
        logger.info("根据产品id查询产品findProductById方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Product> saveProduct(Product record) {
        logger.info("进入保存产品信息saveProduct方法");
        ResponseResult<Product> responseResult = new ResponseResult<>();
        if (record != null && !CollectionUtils.isEmpty(record.getProductModules())) {
            Date date = new Date();
            record.setCreateTime(date);
            record.setNo(UtilGenerateID.generateID("pro"));
            int saveProduct = productMapper.save(record);
            List<ProductModule> productBlocks = record.getProductModules();
            for (ProductModule productBlock : productBlocks) {
                productBlock.setProductId(record.getId());
            }
            int saveProductBlocks = productDetailMapper.saveBatch(productBlocks);
            if (saveProduct > 0 && saveProductBlocks > 0) {
                responseResult.setCode(true);
                responseResult.setMsg("商品信息保存成功！");
                responseResult.setContent(record);
            } else {
                responseResult.setCode(false);
                responseResult.setMsg("商品信息保存失败！");
            }
        } else {
            responseResult.setMsg("信息不全");
        }
        logger.info("保存产品信息saveProduct方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }


    @Override
    public ResponseResult<Product> updateProduct(Product record) {
        logger.info("进入更新产品信息updateProduct方法");
        ResponseResult<Product> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {

            int modify = productMapper.update(record);
            if (modify > 0) {
                responseResult.setCode(true);
                responseResult.setMsg("商品信息修改成功！");

            } else {
                responseResult.setCode(false);
                responseResult.setMsg("商品信息修改失败！");
            }
        } else {
            responseResult.setMsg("信息不全");
        }
        logger.info("更新产品信息updateProduct方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;

    }

    @Override
    public ResponseResult<Product> updateProductWithModule(Product record) {
        logger.info("进入更新产品信息updateProductWithModule方法");
        ResponseResult<Product> responseResult = new ResponseResult<>();
        boolean flag = true;
        if (record != null && record.getId() != null) {
            List<ProductModule> productBlocks = productDetailMapper.selectByProductId(record.getId());
            if (!CollectionUtils.isEmpty(productBlocks)) {
                for (ProductModule productBlock : productBlocks) {
                    flag &= productDetailMapper.update(productBlock) > 0;
                }
                flag &= productMapper.update(record) > 0;
                if (flag) {
                    responseResult.setCode(true);
                    responseResult.setMsg("商品模块信息修改成功！");
                } else {
                    responseResult.setCode(false);
                    responseResult.setMsg("商品模块信息修改失败！");
                }
            }
        }
        logger.info("更新产品信息updateProductWithModule方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }


    @Override
    public ResponseResult<Product> deleteProduct(Product record) {
        logger.info("进入删除产品信息deleteProduct方法");
        ResponseResult<Product> responseResult = new ResponseResult<>();
        boolean flag = true;
        if (record != null) {
            List<Product> products = productMapper.queryList(record);
            if (!CollectionUtils.isEmpty(products)) {
                for (Product product : products) {
                    flag &= productDetailMapper.deleteByProductId(product.getId()) > 0;
                }
            }
            flag &= productMapper.delete(record) > 0;

            if (flag) {
                responseResult.setCode(true);
                responseResult.setMsg("产品删除成功");
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("产品删除失败");
        }
        logger.info("删除产品信息deleteProduct方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<Product> deleteProduct(Integer productId) {
        logger.info("进入根据产品id删除产品信息deleteProduct方法");
        ResponseResult<Product> responseResult = new ResponseResult<>();
        if (productId != null) {
            Product product = new Product();
            product.setId(productId);
            return deleteProduct(product);
        }
        responseResult.setMsg("产品删除失败");
        logger.info("根据产品id删除产品信息deleteProduct方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public BootGrid<ProductModule> findProductModule(BootGrid<ProductModule> grid, ProductModule example) {
        logger.info("进入根据条件查询产品模块findProductModule方法");
        if (grid != null && example != null) {
            Page<Object> page = PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
            List<ProductModule> productModules = productDetailMapper.queryList(example);
            if (!CollectionUtils.isEmpty(productModules)) {
                grid.setRows(productModules);
                grid.setTotal((int) page.getTotal());
                grid.setResult(true);
            }
        }
        logger.info("根据条件查询产品模块findProductModule方法结束,返回结果:"+ JSON.toJSONString(grid));
        return grid;

    }

    @Override
    public BootGrid<ProductModule> findProductModule(BootGrid<ProductModule> grid, Integer productId) {
        logger.info("进入根据产品id查询产品模块findProductModule方法");
        if (grid != null && productId != null) {
            Page<Object> page = PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
            List<ProductModule> productBlocks = productDetailMapper.selectByProductId(productId);
            if (!CollectionUtils.isEmpty(productBlocks)) {
                grid.setRows(productBlocks);
                grid.setTotal((int) page.getTotal());
                grid.setResult(true);
            }
        }
        logger.info("根据产品id查询产品模块findProductModule方法结束,返回结果:"+ JSON.toJSONString(grid));
        return grid;
    }

    @Override
    public ResponseResult<ProductModule> updateProductModule(ProductModule record) {
        logger.info("进入更新产品模块updateProductModule方法");
        ResponseResult<ProductModule> responseResult = new ResponseResult<>();
        if (record != null && record.getId() != null) {
            int modify = productDetailMapper.update(record);
            if (modify > 0) {
                responseResult.setCode(true);
                responseResult.setMsg("商品模块信息修改成功！");
            } else {
                responseResult.setCode(false);
                responseResult.setMsg("商品模块信息修改失败！");
            }
        } else {
            responseResult.setMsg("无此模块");
        }
        logger.info("更新产品模块updateProductModule方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<ProductModule> deleteProductModule(ProductModule record) {
        logger.info("进入根据条件删除产品模块deleteProductModule方法");
        ResponseResult<ProductModule> responseResult = new ResponseResult<>();
        if (record != null) {
            int delete = productDetailMapper.delete(record);
            if (delete > 0) {
                responseResult.setMsg("删除产品明细成功");
                responseResult.setCode(true);
            } else {
                responseResult.setMsg("删除产品明细失败");
            }
        } else {
            responseResult.setMsg("无此产品");
        }
        logger.info("根据条件删除产品模块deleteProductModule方法,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public ResponseResult<ProductModule> deleteProductModule(Integer productBlockId) {
        logger.info("进入根据产品模块id删除产品模块deleteProductModule方法");
        ResponseResult<ProductModule> responseResult = new ResponseResult<>();
        Integer del = productDetailMapper.deleteById(productBlockId);
        if (del > 0) {
            responseResult.setCode(true);
            responseResult.setMsg("商品模块信息删除成功！");
        } else {
            responseResult.setCode(false);
            responseResult.setMsg("商品模块信息删除失败！");
        }
        logger.info("根据产品模块id删除产品模块deleteProductModule方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }
}
