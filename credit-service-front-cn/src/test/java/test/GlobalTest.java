package test;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.front.cn.service.FullReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by aixingwen on 2017/2/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-activemq.xml" })
public class GlobalTest {

    @Autowired
    FullReportService fullReportService;

    @Test
    public void test(){
        Long startTime = System.currentTimeMillis();
        FullReport report = new FullReport();
        report.setNameCN("商安信（上海）企业管理咨询股份有限公司");
        report = fullReportService.getGlobalAllReport(report);
        // System.out.println("report.getKtgg().size()==="+report.getKtgg().size());
        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
        String str = JSON.toJSONString(report);
        System.out.println("str=="+str);
    }


}
