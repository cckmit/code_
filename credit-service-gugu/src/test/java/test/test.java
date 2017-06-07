package test;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.gugu.model.*;
import com.mika.credit.facade.gugu.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-dubbo-provider.xml","classpath:spring-dubbo-consumer.xml" })
public class test {

    @Autowired
    private BusinessCardService businessCardService;
    @Autowired
    private CardNoteService cardNoteService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private IconRecordService iconRecordService;
    @Autowired
    private InformService informService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private ShareRecordService shareRecordService;
    @Autowired
    private UserService userService;
    @Autowired
    private VersionService versionService;

    @Test
    public void testBusinessCardService() {
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();

        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testCardNoteService() {
        Long startTime = System.currentTimeMillis();
        CardNote cardNote = new CardNote();


        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testFeedbackService() {
        Long startTime = System.currentTimeMillis();
        Feedback feedback = new Feedback();

        feedbackService.addFeedback(JSON.toJSONString(feedback));

        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testHelpService() {
        Long startTime = System.currentTimeMillis();


        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testIconRecordService() {
        Long startTime = System.currentTimeMillis();
        IconRecord iconRecord = new IconRecord();

        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testInformService() {
        Long startTime = System.currentTimeMillis();
        Inform inform = new Inform();

        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testRegionService() {
        Long startTime = System.currentTimeMillis();


        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testShareRecordService() {
        Long startTime = System.currentTimeMillis();


        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testUserService() {
        Long startTime = System.currentTimeMillis();
        Users users = new Users();
//		users.setUserName("mike.gu@3acredit.cn");
//		users.setPwd("123456");
//		users.setTel("18621940318");
//		users.setEmail("273210563@qq.com");
//		String json = JSON.toJSONString(users);
//		String result = userService.userRegister(json);
        HashMap hashMap = new HashMap();
        hashMap.put("userName","mike.gu@3acredit.cn");
        hashMap.put("pwd","123456789");

        String json = JSON.toJSONString(hashMap);
//		String result = userService.sendVerificationCode(json);

        String result = userService.changeUserPwd(json);

        System.out.println("testUserService="+result);

        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }

    @Test
    public void testVersionService() {
        Long startTime = System.currentTimeMillis();
        Versions versions = new Versions();

        Long entTime = System.currentTimeMillis();
        System.out.println("耗费时间==="+(entTime-startTime));
    }
}
