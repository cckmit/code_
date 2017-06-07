package test;

import com.mika.credit.facade.front.cn.dao.FullReportDao;
import com.mika.credit.facade.front.cn.dao.ShareholderInfosDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Zhu Jun on 2017/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-activemq.xml" })
public class deleteTest {
    @Autowired
    ShareholderInfosDao shareholderInfosDao;
    @Autowired
    FullReportDao fullReportDao;


    @Test
    public  void Test(){
        int id = 118;
        int del = shareholderInfosDao.deleteById(id);
        System.out.println(del);
    }
}
