package test;

import com.mika.credit.facade.front.cn.parse.impl.CpmImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dong jian hua on 2017/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-jpa.xml" })
public class cpmTest {

    @Autowired
    CpmImpl cpmImpl;

//    @Test
//    public  void Test(){
//        String name = "商安信（上海）企业管理咨询股份有限公司";
//        cpmImpl.getCpmList(name);
//    }


}
