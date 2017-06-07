package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.RechargeLog;
import com.mika.credit.facade.gugu.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by dong jian hua on 2017/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml", "classpath:spring-mybatis.xml", "classpath:spring-dubbo-provider.xml", "classpath:spring-dubbo-consumer.xml"})
public class CertificationTest {

    @Autowired
    private CertificationService certificationService;

    @Autowired
    private VerificationResultService verificationResultService;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private RechargeService rechargeService;

    @Autowired
    private GongShangService gongShangService;

    @Autowired
    private IndexDetailService indexDetailService;

    @Test
    public void test01() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long startTime = System.currentTimeMillis();
            Date date = sdf.parse("2017-04-03 10:00:01");
            //TODO 核实下单 201
            BusinessCard businessCard = new BusinessCard();
            JSONObject json = new JSONObject();
            businessCard.setId(4);
//            businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
            businessCard.setCardCompany("南龙集团有限公司");
            businessCard.setCardEmail("info@3ACredit.cn");
//            businessCard.setCardName("姚翔");
            businessCard.setCardName("吴琳玲");
//            businessCard.setCardName("李四");
            businessCard.setCardPosition("手机测试");
//            businessCard.setCardAddress("上海虹口区四川北路525号21楼");
            businessCard.setCardAddress("上海市宝山区逸仙路2333号K座12层");
            businessCard.setCardPhone("13774311477");//商安信
//            businessCard.setCardPhone("15821369435");//商安信
            businessCard.setAreaCode("021");
            businessCard.setCardTel("36386226");
            businessCard.setCardWebsite("http://www.3acredit.cn/");
            businessCard.setUserId(8);
            String addVerifyOrder = certificationService.addVerifyOrder(json.toJSONString(businessCard));
            long endTime = System.currentTimeMillis();
            System.out.println("核实下单耗时===》" +(endTime - startTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test02() {
        //TODO 认购(认证)下单 303
        JSONObject json = new JSONObject();
        BusinessCard businessCard = new BusinessCard();
        businessCard.setId(2);
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
//        businessCard.setCardCompany("中电投资国际管理有限公司");
//        businessCard.setCardCompany("王小丫哟偶限公司");
//        businessCard.setCardEmail("Stenven.yao@3acredit.com");
        businessCard.setCardName("姚翔");
//        businessCard.setCardName("郭晋");
        businessCard.setCardAddress("上海宝山区逸仙路281号B楼12层");
//        businessCard.setCardAddress("宝山");
        businessCard.setCardPhone("13774311477");
        businessCard.setAreaCode("021");
        businessCard.setCardTel("36386226");
        businessCard.setCardWebsite("www.3acredit.com");
        businessCard.setUserId(6);
        String addMobiletOrder = certificationService.addMobiletOrder(json.toJSONString(businessCard));
        System.out.println("认购(认证)===》" + addMobiletOrder);
    }

    @Test
    public void test0201() {
        //TODO 认证 304
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        String nameCN = "商安信(上海)企业管理咨询股份有限公司";
        String userId = "8";
        json.put("nameCN", nameCN);
        json.put("userId", userId);
        String addMobiletOrder = certificationService.addsubscribe(json.toString());
        System.out.println("认购(认证)===》" + addMobiletOrder);
    }

    @Test
    public void test03() {
        //TODO 订单列表
        JSONObject json = new JSONObject();
        json.put("cardId", "75");
//        json.put("orderId","560");
        String orderList = orderInfoService.orderList(json.toJSONString(json));
        System.out.println("订单列表===》" + orderList);
    }

    @Test
    public void test04() {
        //TODO 订单详情
        JSONObject json = new JSONObject();
        json.put("cardId", "75");
        json.put("orderId", "560");
        String orderDetail = orderInfoService.orderDetail(json.toJSONString());
        System.out.println("订单详情===》" + orderDetail);
    }

    @Test
    public void test05() {
        //TODO 获取认证信息 305
        JSONObject json = new JSONObject();
        json.put("certificationId", "80");
        json.put("userId", "33");
        String authInfo = verificationResultService.authInfo(json.toJSONString(json));
        System.out.println("获取认证信息===》" + authInfo);
    }

    @Test
    public void test06() {
        //TODO 获取最新认证信息
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setId(15);
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        businessCard.setCreditVerification("1");
        businessCard.setUpdateTime(new Date());
        businessCard.setOrderId(123456);
        businessCard.setUserId(28);
        String newAuthInfo = verificationResultService.newAuthInfo(json.toJSONString(businessCard));
        System.out.println("获取最新认证信息===》" + newAuthInfo);

    }

    @Test
    public void test07() {
        //TODO 认证列表(名片已认证) 306
        JSONObject json = new JSONObject();
//        json.put("userId","31");
        json.put("cardId", "87");
        String CardLitByCertification = verificationResultService.cardListByCertification(json.toJSONString());
        System.out.println("获取已认证的列表===》" + CardLitByCertification);
    }

    @Test
    public void test08() {
        //TODO 充值列表
        Long startTime = System.currentTimeMillis();
        JSONObject json = new JSONObject();
        String pageNo = "1";
        String pageSize = "10";
        String userId = "28";
        json.put("userId", userId);
        json.put("pageNo", pageNo);
        json.put("pageSize", pageSize);
        String isFlag = rechargeService.rechargeList(json.toJSONString());
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test09() {
        //TODO 充值金额 1102
        Long startTime = System.currentTimeMillis();
        JSONObject json = new JSONObject();
        RechargeLog record = new RechargeLog();
        record.setId(1);
        record.setUserId(28);
        record.setLogId(1);
        record.setUserId(323);
        record.setLoginIp("127.0.0.7");
        record.setRechargeDate(new Date());
        record.setRechargeMoney("1651");
        record.setCurrentMoney("1");
        record.setRechargeNum("131");
        record.setRechargeStatus("1");
        String isFlag = rechargeService.rechargeAmount(json.toJSONString(record));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test10() {
        //TODO 获取名片核实信息 202
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setId(136);
        businessCard.setVerficationId(148);
        String isFlag = verificationResultService.getVerificationResultInfo(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test11() {
        //TODO 获取工商信息 203
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
//        businessCard.setCardCompany("华为技术有限公司");
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangInfo(json.toJSONString(businessCard));
        if (StringUtil.isNotNull(isFlag)) {
            System.out.println("获取工商信息信息成功");
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test12() {
        //TODO 更新工商信息 204
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.updateGongshang(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test13() {
        //TODO 工商变更列表 204
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangList(json.toJSONString(businessCard));
        if (StringUtil.isNotNull(isFlag)) {
            System.out.println("更新工商信息成功");
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test14() {
        //TODO 工商股东列表 205
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.shareholderList(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test15() {
        //TODO 工商管理层列表 206
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangManagements(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test16() {
        //TODO 工商法院公告列表 207
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangLegalNotic(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test17() {
        //TODO 工商裁判文书列表 208
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangAdjudicationInfo(json.toJSONString(businessCard));
        if (StringUtil.isNotNull(isFlag)) {
            System.out.println("获取工商裁判文书列表成功");
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test18() {
        //TODO 工商被执行人列表 209
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangEnforce(json.toJSONString(businessCard));
        if (StringUtil.isNotNull(isFlag)) {
            System.out.println("获取工商被执行人列表成功");
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test19() {
        //TODO 工商失信被执行人列表 210
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangUncreditEnforce(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test20() {
        //TODO 工商失经营异常列表 211
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangBusinessAbnormity(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test21() {
        //TODO 工商新闻列表 212
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangNews(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test22() {
        //TODO 工商专利列表 213
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangPatent(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test23() {
        //TODO 工商注册列表 214
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangRegistrationinfo(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test24() {
        //TODO 工商网站列表 215
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangWebSite(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test25() {
        //TODO 工商年报列表 216
        Long startTime = System.currentTimeMillis();
        BusinessCard businessCard = new BusinessCard();
        JSONObject json = new JSONObject();
        businessCard.setCardCompany("商安信(上海)企业管理咨询股份有限公司");
        String isFlag = gongShangService.gongShangFinancial(json.toJSONString(businessCard));
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));
    }

    @Test
    public void test26() {
        //TODO 目标对象详情 1203
        Long startTime = System.currentTimeMillis();
        JSONObject json = new JSONObject();
        String nameCN = "八";
        json.put("cardCompany", nameCN);
        String isFlag = indexDetailService.searchRegistration(json.toJSONString());
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));

    }

    @Test
    public void test27() {
        //TODO 获取搜索目标工商信息 1203
        Long startTime = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
//        String nameCN = "长江联合金融租赁有限公司";
        String nameCN = "商安信(上海)企业管理咨询股份有限公司";
        jsonObject.put("cardCompany", nameCN);
        String isFlag = indexDetailService.searchRegistration(jsonObject.toJSONString());
        System.out.println("isFlag===>" + isFlag);
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));

    }

    @Test
    public void test28() {
        //TODO 获取搜索目标基本信息 1204
        Long startTime = System.currentTimeMillis();
        JSONObject json = new JSONObject();
        String nameCN = "长江联合金融租赁有限公司";
        json.put("cardCompany", nameCN);
        String isFlag = indexDetailService.basicInfoDetail(json.toJSONString());
        if (StringUtil.isNotNull(isFlag)) {
            System.out.println("获取目标基本对象信息成功");
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));

    }

    @Test
    public void test29() {
        //TODO 目标对象详情 1202
        Long startTime = System.currentTimeMillis();
        JSONObject json = new JSONObject();
//        String nameCN = "华为技术有限公司";
        String nameCN = "腾讯科技(深圳)有限公司";
        String type = "13";
        json.put("nameCN", nameCN);
        json.put("type", type);
        String isFlag = indexDetailService.targetRegistration(json.toJSONString());
        Long endTime = System.currentTimeMillis();
        System.out.println("End Tiem ===》" + (endTime - startTime));

    }

    @Test
    public void test30() {
        //TODO 商圈列表根据cardId查询认信息 307
        Long startTime = System.currentTimeMillis();
        JSONObject json = new JSONObject();
        String cardId = "90";
        json.put("cardId", cardId);
        String businessCircle = verificationResultService.cerificationInfo(json.toJSONString());
        Long endTime = System.currentTimeMillis();
        System.out.println("end time ===》" + (endTime - startTime));

    }

}
