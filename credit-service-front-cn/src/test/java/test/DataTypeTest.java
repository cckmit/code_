package test;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.report.cn.DataType;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.front.cn.dao.DataTypeDao;
import com.mika.credit.facade.front.cn.service.FullReportService;
import com.mika.credit.facade.front.cn.util.Tool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by aixingwen on 2017/3/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-redis.xml" })
public class DataTypeTest {
    @Autowired
    FullReportService fullReportService;
    @Autowired
    DataTypeDao dataTypeDao;


    @Test
    public  void Test(){
        /*List<DataType> list = dataTypeDao.findByCode("Post");
        for(int i = 0 ;i<list.size();i++){
            DataType data = list.get(i);
            System.out.println("data=="+data.getCodeName());
        }*/
        String str = "在营（开业）";
        str = Tool.Symbolconversion(str);
        System.out.println("str=="+str);
        str = Tool.EnterpriseStatusStr(str);
        System.out.println("str=="+str);
    }

}
