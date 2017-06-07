package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.Module;
import com.mika.credit.common.entity.order.Product;
import com.mika.credit.common.entity.order.ProductModule;
import com.mika.credit.facade.order.service.ModuleService;
import com.mika.credit.facade.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModuleService moduleService;

    /**
     * 后台商品信息列表 AJAX
     * @return
     */
    @RequestMapping(value = "/core/productList" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String productList(Product product, BootGrid<Product> grid) {
        BootGrid<Product> result = productService.findProducts(grid,product);
        result.setResult(true);
        return JSON.toJSONString(result);
    }

    /**
     * 商品详情
     * @return
     */
    @RequestMapping(value = "/core/getProduct" ,method = RequestMethod.POST, produces = "texCt/html;charset=UTF-8")
    public @ResponseBody String getProduct(@RequestBody Product product) {
//        Map<String, Object> map = new HashMap<>();
//        BootGrid bootGrid = new BootGrid<>();
//        bootGrid.setCurrent(1);
//        bootGrid.setRowCount(Integer.MAX_VALUE);
//        Module module=new Module();
//        List<Module> modules=moduleService.findModules(bootGrid,module).getRows();    //得到Module所有信息
//        map.put("modules",modules);
        ResponseResult<Product> responseResult= productService.findProductById(product.getId());
//        Boolean code=responseResult.getCode();
//        if(code){
//            Product product1=responseResult.getContent();
//            map.put("product",product1);
//            List<ProductModule> productModules= productService.findProductModule(bootGrid,product.getId()).getRows();    //得到当前产品所有模块
//            map.put("productModules",productModules);
//            map.put("code",code);
//        }else{
//            map.put("code",code);
//        }
        return JSON.toJSONString(responseResult);
    }

    /**
     * 删除商品AJAX
     * @return
     */
    @RequestMapping(value = "/core/delProduct" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String delProduct(@RequestBody Product product) {
        System.out.printf("del：-----"+product.getId());
        ResponseResult<Product> result=productService.deleteProduct(product.getId());     //把Integer类型转成Long类型
        return JSON.toJSONString(result);
    }

    /**
     * 新增商品 AJAX
     * @return
     */
    @RequestMapping(value = "/core/addProduct" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String addProduct(@RequestBody Product product) {
        ResponseResult<Product> result=productService.saveProduct(product);
        return JSON.toJSONString(result);
    }

    /**
     * 修改商品 AJAX
     * @return
     */
    @RequestMapping(value = "/core/upProduct" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String upProduct(@RequestBody Product product) {
        ResponseResult<Product> result=productService.updateProduct(product);
        return JSON.toJSONString(result);

    }

}
