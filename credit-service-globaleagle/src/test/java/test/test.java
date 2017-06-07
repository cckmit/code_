package test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-dubbo-provider.xml","classpath:spring-dubbo-consumer.xml","classpath:spring-mybatis.xml" })
public class test {

//    @Autowired
//    private OrderDetailManagerService orderDetailManagerService;

	@org.junit.Test
	public void test() {
//        Long startTime = System.currentTimeMillis();
//        orderDetailManagerService.recaptureReportData(68);
//        Long entTime = System.currentTimeMillis();
//        System.out.println("耗费时间==="+(entTime-startTime));

    }
}
