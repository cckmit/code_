package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.front.cn.service.FullReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aixingwen on 2017/3/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-redis.xml" })
public class JsonTest {
    @Autowired
    FullReportService fullReportService;


    @Test
    public  void Test(){
        Map<String,String> map = new HashMap<>();
        map.put("nameCN","ss");
        String str = JSONObject.toJSONString(map);
        System.out.println("str=="+str);
        JSONObject jsonObject = JSONObject.parseObject(str);
        String NameCN = jsonObject.getString("nameCN");
        System.out.println("NameCN=="+NameCN);

    }

}
