package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.*;
import com.mika.credit.common.fastdfs.FastDFSClient;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.order.service.QuickOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/**
 * Created by dell on 2017/3/19.
 */
@Controller
public class QuickOrderController {

    @Autowired
    private QuickOrderService quickOrderService;

    @Autowired
    private OrderService orderService;



    /**
     * 后台快速订购列表 AJAX
     * @return
     */
    @RequestMapping(value = "/core/quickOrderList" ,method = RequestMethod.POST, produces = "texCt/html;charset=UTF-8")
    public @ResponseBody String quickOrderList(QuickOrderQuery quickOrderQuery, BootGrid<QuickOrder> grid) {
        //Customer customer = new Customer();
        BootGrid<QuickOrder> result = quickOrderService.findQuickOrders(grid,quickOrderQuery);
        result.setResult(true);
        return JSON.toJSONString(result);
    }

    /**
     * 快速订购详情
     * @return
     */
    @RequestMapping(value = "/core/getQuickOrder" ,method = RequestMethod.POST, produces = "texCt/html;charset=UTF-8")
    public @ResponseBody String getQuickOrder(@RequestBody QuickOrder quickOrder) {
        //Customer customer = new Customer();
        ResponseResult<QuickOrder> result = quickOrderService.findQuickOrderById(quickOrder.getId());
//        String imgUrl = result.getContent().getImgUrl();
        return JSON.toJSONString(result);
    }

    /**
     * 删除快速订购订单 AJAX
     * @return
     */
    @RequestMapping(value = "/core/delQucikOrder" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String delQucikOrder(@RequestBody QuickOrder quickOrder) {
        System.out.printf("del：-----"+quickOrder.getId());
        ResponseResult<QuickOrder> result=quickOrderService.deleteQuickOrder(quickOrder.getId());     //把Integer类型转成Long类型
        return JSON.toJSONString(result);
    }

    /**
     * 新增普通订单 AJAX
     * @return
     */
    @RequestMapping(value = "/core/addOrder" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String addOrder(@RequestBody QuickOrder quickOrder) {
        ResponseResult<Orders> result=null;
        if(quickOrder.getNo()==null || (quickOrder.getNo()).equals("")){
            result=new ResponseResult<>();
            result.setCode(false);
            result.setMsg("快速订购订单为null，生成订单失败！");
        }else {
            Orders orders = new Orders();    //订单
            orders.setNo(quickOrder.getNo());
            orders.setCreateUserId(quickOrder.getCreateUserId());
            orders.setCreateUserName(quickOrder.getCreateUserName());
            orders.setSource(quickOrder.getSource());
            orders.setCustomerName(quickOrder.getCustomerName());
            orders.setCustomerId(quickOrder.getCustomerId());
            orders.setCustomerNo(quickOrder.getCustomerNo());
            orders.setCustomerEmail(quickOrder.getCustomerEmail());
            orders.setAmount(quickOrder.getAmount());
            orders.setAmountActual(quickOrder.getAmountActual());
            orders.setCurrency(quickOrder.getCurrency());
            orders.setHasPay(quickOrder.getHasPay());
            orders.setPayMethod(quickOrder.getPayMethod());
            OrderDetail orderDetail = new OrderDetail();     //创建订单明细
            orderDetail.setProductId(quickOrder.getProductId());
            orderDetail.setExpectTime(quickOrder.getExpectTime());
            orderDetail.setUpdateTime(quickOrder.getUpdateTime());
            orderDetail.setFinishTime(quickOrder.getFinishTime());
            orderDetail.setCompanyName(quickOrder.getCompanyName());
            orderDetail.setRemark(quickOrder.getRemark());
            List<OrderDetail> orderDetails = new ArrayList<>();
            orderDetails.add(orderDetail);
            orders.setOrderDetails(orderDetails);
            result = orderService.saveOrder(orders);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 修改快速订购订单 AJAX
     * @return
     */
    @RequestMapping(value = "/core/upQuickOrder" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String upQuickOrder(@RequestBody QuickOrder quickOrder) {
        ResponseResult<QuickOrder> result=quickOrderService.updateFinish(quickOrder);
        return JSON.toJSONString(result);

    }

    /**
     * 封装图片地址 AJAX
     * @return
     */
    @RequestMapping(value = "/core/imgUrl" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String imgUrl(@RequestBody Map map,HttpServletRequest request) {
        String imgUrl=(String)map.get("imgUrl");
        Map<String,Object> result = new HashMap<String,Object>();
        if( (imgUrl != null ||  !imgUrl.equals("")) && imgUrl.contains(".")) {    //判断是否为null，且包含“.”
            String realPath = request.getSession().getServletContext().getRealPath("/upload/pic/");  //文件目录
            File f = new File(realPath);
            if (!f.exists()) {
                f.mkdirs();
            }
            String img = imgUrl.substring(imgUrl.lastIndexOf("."), imgUrl.length());
            String imgPath =  System.currentTimeMillis() + img;    //文件名
            String imgPaths = realPath+imgPath;                 //文件地址
            //  String imgPath=realPath+imgUrl;
            InputStream in = FastDFSClient.downloadFile(imgUrl);
            if(in!=null && !in.equals("")) {
                FileOutputStream out = null;
                File file = new File(realPath,imgPath);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdir();
                }
                byte[] bytes = new byte[1024 * 10];
                int len = 0;
                try {
                    out = new FileOutputStream(file);
                    while ((len = in.read(bytes)) != -1) {
                        out.write(bytes, 0, len);
                    }
                    result.put("content","/upload/pic/"+imgPath);
                    result.put("msg","获取公司信息图片成功！！");
                    result.put("code",true);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                            in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                result.put("msg","获取公司信息图片失败！！");
                result.put("code",false);
            }
        }else{
            result.put("msg","公司信息图片地址为空！！");
            result.put("code",false);
        }
        return JSON.toJSONString(result);
    }
}
