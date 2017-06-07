package test;

import com.mika.credit.facade.front.cn.parse.Qianhai;
import com.mika.credit.facade.front.cn.parse.Qianhai;
import com.mika.credit.facade.front.cn.service.impl.QianHaiInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dell on 2017/2/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-dubbo-provider.xml" })
public class qianhaiTest {

    @Autowired
    Qianhai qianhai;

    @Autowired
    QianHaiInfoServiceImpl qianHaiInfoServiceImpl;

    @Test
    public void test(){
       /* String name = "商安信（上海）企业管理咨询股份有限公司";
        qianhai.getQianhaiLIst(name);*/
        String name = "商安信（上海）企业管理咨询股份有限公司";

        String gldData = qianHaiInfoServiceImpl.sendQianHaiData(name,"");
        System.out.println("dd=="+gldData);


    }
}
