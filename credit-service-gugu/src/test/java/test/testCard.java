package test;

import com.alibaba.fastjson.JSON;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.service.BusinessCardService;
import com.mika.credit.facade.gugu.service.MessageQuestionService;
import com.mika.credit.facade.messagebox.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dell on 2017/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-dubbo-provider.xml","classpath:spring-dubbo-consumer.xml" })
public class testCard {

    @Autowired
    private BusinessCardService businessCardService;

    @Autowired
    private MessageQuestionService messageQuestionService;

    @Test
    public void test1(){
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard=new BusinessCard();
        businessCard.setCardCompany("商安信");
        businessCard.setCardName("顾师傅");
        businessCard.setCardPhone("110");
        businessCard.setUserId(10);
        String result=businessCardService.add(JSON.toJSONString(businessCard));
        Long entTime = System.currentTimeMillis();
//        System.out.printf("返回结果："+result);
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public  void testMessageQuestion(){
        Long startTime=System.currentTimeMillis();
        Message message=new Message();
        message.setFromId("9");
        message.setToId("6");
        message.setContent("好想睡觉！！！");
        String result=messageQuestionService.sendMessage(JSON.toJSONString(message));

        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }
}
