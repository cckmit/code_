package test;

import com.mika.credit.facade.front.cn.dao.BasicDataDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dell on 2017/2/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-jpa.xml","classpath:spring-dubbo-provider.xml" })
public class TestBasicData {

    @Autowired
    BasicDataDao basicDateDao;

//    @Test
//    public void Test(){
//            List<BasicData> companyStatusList = basicDateDao.findByDtidAndCode(32,1);
//            if(companyStatusList.size()>0){
//                System.out.println("companyStatusList.get(0).getValueCN()=="+companyStatusList.get(0).getValueCN());
//            }
//
//    }

}
