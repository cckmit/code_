package test;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.front.cn.service.FullReportService;
import com.mika.credit.facade.front.cn.service.impl.FullReportServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dell on 2017/2/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-jpa.xml","classpath:spring-dubbo-provider.xml" })
public class mainTest {

    @Autowired
    FullReportService fullReportService;

    @Test
    public void Test(){
       Long startTime = System.currentTimeMillis();
        FullReport report = new FullReport();
        report.setNameCN("商安信（上海）企业管理咨询股份有限公司");
        //report.setNameCN("阿迪达斯(中国)有限公司");

       // report.setNameCN("浙江牛力机械制造有限公司");
        report = fullReportService.getFullReport(report);
       // System.out.println("report.getKtgg().size()==="+report.getKtgg().size());
        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
        String str = JSON.toJSONString(report);
        System.out.println("str=="+str);
       // fullReportServiceImpl.getFullReportlitigation(report);
      //  System.out.println("诉讼耗费时间==="+(entTime-startTime));
    }




}
