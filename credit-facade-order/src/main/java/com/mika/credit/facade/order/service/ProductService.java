package com.mika.credit.facade.order.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetailViewQuery;
import com.mika.credit.common.entity.order.Product;
import com.mika.credit.common.entity.order.ProductModule;

/**
 * Created by zj001 on 2017/3/2.
 *
 * @author zj001
 */
public interface ProductService {

    /**
     * 查询产品
     *
     * @param grid    分页条件
     * @param example 查询条件
     * @return 分页查询产品结果
     */
    BootGrid<Product> findProducts(BootGrid<Product> grid, Product example);

    /**
     * 查询该客户对应产品
     *
     * @param grid    分页条件
     * @param product 报告类型
     * @param view    视图条件
     * @return 该客户对应产品查询结果
     */
    BootGrid<Product> findCustomerProducts(BootGrid<Product> grid, OrderDetailViewQuery view, Product product);

    /**
     * 根据产品id查询产品
     *
     * @param productId 产品id
     * @return 查询产品结果
     */
    ResponseResult<Product> findProductById(Integer productId);

    /**
     * 保存产品
     *
     * @param record 需要保存的产品
     * @return 保存产品结果
     */
    ResponseResult<Product> saveProduct(Product record);

    /**
     * 修改产品
     *
     * @param record 需要修改的产品
     * @return 修改产品结果
     */
    ResponseResult<Product> updateProduct(Product record);

    /**
     * 修改产品模块
     *
     * @param record 需要修改的产品
     * @return
     */
    ResponseResult<Product> updateProductWithModule(Product record);

    /**
     * 删除产品
     *
     * @param record 需要删除的产品
     * @return 删除产品结果
     */
    ResponseResult<Product> deleteProduct(Product record);

    /**
     * 根据id删除产品
     *
     * @param productId 产品id
     * @return 删除产品结果
     */
    ResponseResult<Product> deleteProduct(Integer productId);

    /**
     * 查询产品详情模块
     *
     * @param grid    分页条件
     * @param example 查询产品模块条件
     * @return 分页查询结果
     */
    BootGrid<ProductModule> findProductModule(BootGrid<ProductModule> grid, ProductModule example);

    /**
     * 根据产品id查询产品模块
     *
     * @param productId 产品id
     * @return 查询产品模块结果
     */
    BootGrid<ProductModule> findProductModule(BootGrid<ProductModule> grid, Integer productId);

    /**
     * 修改产品模块
     *
     * @param record 需要修改的产品模块
     * @return 修改产品模块结果
     */
    ResponseResult<ProductModule> updateProductModule(ProductModule record);

    /**
     * 删除产品模块
     *
     * @param record 需要删除的产品模块
     * @return 删除产品模块结果
     */
    ResponseResult<ProductModule> deleteProductModule(ProductModule record);

    /**
     * 根据id删除产品模块
     *
     * @param productModuleId 产品模块id
     * @return 删除产品模块结果
     */
    ResponseResult<ProductModule> deleteProductModule(Integer productModuleId);
}
