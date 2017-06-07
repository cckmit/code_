package test;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.entity.pay.PayBackBean;
import com.mika.credit.common.fastdfs.FastDFSClient;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.order.service.impl.OrderServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by dell on 2017/3/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml", "classpath:spring-mybatis.xml", "classpath:spring-activemq.xml"})
//加载配置文件
public class OrderTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Test
    public void test01() {
        ResponseResult<OrderDetail> result = orderService.reloadData(134L);
        System.out.println(result.getMsg());
    }

    @Test
    public void test02() {
        ResponseResult<OrderDetail> result = orderServiceImpl.findOrderDetailByIdWithData(134L);
        try {
            orderServiceImpl.saveData(result.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        ResponseResult<Orders> result = orderServiceImpl.deleteOrder(139L);
        System.out.println(result.getMsg());
    }

    @Test
    public void test04() throws IOException {
        ResponseResult<OrderDetail> result = orderServiceImpl.findOrderDetailByIdWithData(144L);
        String data = orderServiceImpl.saveData(result.getContent());
    }

    @Test
    public void test05() throws IOException {
        PayBackBean payBackBean = new PayBackBean();
        payBackBean.setOrderNo("GE15B0F24B0D5");
        payBackBean.setAmount(new BigDecimal(99));
        payBackBean.setPayMethod(0);
        ResponseResult<Orders> paid = orderService.paid(payBackBean);
        System.out.println(paid.getMsg());
    }

    @Test
    public void test06() {
        ResponseResult<OrderDetail> result = orderService.reloadData(233L);
        System.out.println(result.getMsg());
    }

    @Test
    public void test07() {
        List<OrderDetail> details = orderService.findOrderDetailByOrderId(281L);
        StringBuilder sb=new StringBuilder();
        details.forEach(orderDetail -> sb.append(orderDetail.getPrice()));
        System.out.println(new BigDecimal(sb.toString()));
    }


    @Test
    public void test08() {
        System.out.println("fileData="+getData("group1/M00/00/05/wKgBKE7ZSLCATBl-AACMpk-fX5I227.txt"));
        System.out.println("end");
    }

    private String getData(String dataUrl) {
        InputStream in = null;
        try {
            if (StringUtils.isNotBlank(dataUrl)) {
                InputStream stream = FastDFSClient.downloadFile(dataUrl);//从文件系统获取data数据
                if (stream != null) {
                    in = new BufferedInputStream(stream);
                    byte[] bytes = new byte[1024 * 10];
                    int len = 0;
                    StringBuilder data = new StringBuilder();
                    while ((len = in.read(bytes)) != -1) {
                        data.append(new String(bytes, 0, len));
                    }
                    return data.toString();
                }
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
