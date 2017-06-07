package test;


import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.record.model.Record;
import com.mika.credit.facade.record.service.RecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-dubbo-provider.xml","classpath:spring-dubbo-consumer.xml" })
public class test {

    @Autowired
    RecordService recordService;

    @Test
    public void testRecordService() {
        Long startTime = System.currentTimeMillis();
        Record record = new Record();
        record.setCreateTime(new Date());
        record.setNameCn("商安信11111");
        record.setNameEn("3acredit");
        record.setSource("3");
        record.setCountryCode("12");
        record.setIsSuccess(true);
        record.setOrderNo("123456");
        record.setUrl("147852369");
        record.setRemark("备注");
        ResponseResult<Record> recordResponseResult = recordService.saveRecord(record);
        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }
}
