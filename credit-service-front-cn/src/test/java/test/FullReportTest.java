package test;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.front.cn.dao.FullReportDao;
import com.mika.credit.facade.front.cn.service.FullReportService;
import com.mika.credit.facade.front.cn.util.Tool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by aixingwen on 2017/3/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-activemq.xml","classpath:spring-dubbo-consumer.xml","classpath:spring-dubbo-provider.xml" })
public class FullReportTest {
    @Autowired
    FullReportService fullReportService;
    @Autowired
    FullReportDao fullReportDao;

    @Test
    public  void Test(){
        Long startTime = System.currentTimeMillis();
        String name = "广州市安在贸易有限公司";
        FullReport report = new  FullReport();
        report.setNameCN(name);

       // report = fullReportService.getFullReport(report);
        //report = fullReportService.getGlobalAllReport(report);
       // fullReportService.saveFullReport(report);
        report = fullReportService.getGlobalAllReport(report);
        String str = JSON.toJSONString(report);
        System.out.println("str=="+str);
        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));


      /*  FullReport fullReport = new FullReport();
        report.setNameCN(Tool.replaceSymbol(report.getNameCN()));
        fullReport = fullReportDao.findByName("商安信");

        fullReport = fullReportDao.findByName(report.getNameCN());
        System.out.println("fullReport=="+fullReport.getNameCN());*/
    }

}
