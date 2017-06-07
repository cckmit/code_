package test;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.facade.translate.service.TranslateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
public class translateTest {
    @Autowired
    TranslateService translateService;

    //	@Autowired
//	FullReportService fullReportService;
    @Test
    public void test() {
        FullReport fullReport = new FullReport();
        //银行信息
        List<BankInfos> bankInfosList = new ArrayList<>();
        BankInfos bankInfos = new BankInfos();
        bankInfos.setNameCN("代购韩国电视");
        bankInfos.setCommentCN("萨达所大所多撒");
        bankInfos.setAddressCN("湿哒哒所大所大所大所");
        bankInfos.setInterviewedCN("超市超时成双成对");
        bankInfos.setNoteCN("撒打算打算打算");
        bankInfos.setPledgeCN("第三方第三方第三方的");
        bankInfosList.add(bankInfos);
        fullReport.setBankInfosList(bankInfosList);

        List<MediaRecords> mediaRecordsList = new ArrayList<>();
        MediaRecords mediaRecords = new MediaRecords();
        mediaRecords.setTitle("的国际化的股份合计的股份合计");
        mediaRecordsList.add(mediaRecords);
        fullReport.setMediaRecordsList(mediaRecordsList);
        //企业基本信息
        BasicInfos basicInfos = new BasicInfos();
        basicInfos.setAddressRecordCN("时代大厦");
        basicInfos.setNameCN("s阿斯达所大所大所");
        basicInfos.setBackgroundCN("但是撒大所大所");
        basicInfos.setBuildingCN("名称巨款");
        basicInfos.setStreetCN("UI饿哦一偶尔无给噢诶去");
        basicInfos.setBankRuptcyCN("UI噢诶哦呜诶欧文乌尔翁欧唯");
        basicInfos.setBusinessScopeCN("而黄金卡山东黄金");
        basicInfos.setEnterpriseStatusCN("更好地维护方科技文化风景");
        basicInfos.setLitigationInfoCN("比较好舍不得舍不得很舒服不会的");
        fullReport.setBasicInfos(basicInfos);

        //注册变更表信息
        List<ChangeInfos> changeInfosList = new ArrayList<>();
        ChangeInfos changeInfos = new ChangeInfos();
        for(int i=0; i<30; i++){
            changeInfos = new ChangeInfos();
            changeInfos.setBeforeCN("投资人类型:企业法人,姓名:成都科瑞德企业管理有限责任公司,证照类型:企业法人营业执照(公司),证照号码:,认缴出资额:1774.12,认缴出资额币种:人民币,认缴出资额日期:2005-4-15,出资比例:59.1373%,出资方式:实物,货币");
            changeInfos.setAfterCN("投资人类型:企业法人,姓名:成都科瑞德企业管理有限责任公司,证照类型:企业法人营业执照(公司),证照号码:,认缴出资额:1774.12,认缴出资额币种:人民币,认缴出资额日期:2015-12-31,出资比例:59.1373%,出资方式:其他");
            changeInfos.setChangeType("根深蒂固哈");
            changeInfosList.add(changeInfos);
        }
        fullReport.setChangeInfosList(changeInfosList);

        //分析评估
        CreditAssessments creditAssessments = new CreditAssessments();
        creditAssessments.setCreditAnalysisCN("发货事实是否合法");
        creditAssessments.setCreditOpinionCN("限价房都是违法");
        fullReport.setCreditAssessments(creditAssessments);

        //海关信息
        List<CustomHouse> customHouseList = new ArrayList<>();
        CustomHouse customHouse = new CustomHouse();
        customHouse.setCid("放假啊浪费就是了就是");
        customHouse.setNoteCN("分类考试大房间爱上");
        customHouse.setManagementCategoriesCN("发的散发搜房网而");
        customHouse.setCustomsCollectionsCN("房顶上的发生娃儿");
        customHouseList.add(customHouse);
        fullReport.setCustomHouseList(customHouseList);

        //企业对外投资信息
        List<Entinvinfos> entinvinfosList = new ArrayList<>();
        Entinvinfos entinvinfos = new Entinvinfos();
        entinvinfos.setEnterpriseNameCN(null);
        entinvinfos.setRegOrgCN("魔女啊啊的冯绍峰而为");
        entinvinfos.setAddressCN("出发的撒大范围而沃尔沃");
        entinvinfosList.add(entinvinfos);
        Entinvinfos entinvinfosTest = new Entinvinfos();
        entinvinfosTest.setEnterpriseNameCN("你你你");
        entinvinfosTest.setRegOrgCN("魔女啊啊的冯绍峰而为");
        entinvinfosTest.setAddressCN("出发的撒大范围而沃尔沃");
        entinvinfosList.add(entinvinfosTest);
        fullReport.setEntinvinfosList(entinvinfosList);


        //翻译执行公告
        List<Executive> executiveList = new ArrayList<>();
        Executive executive = new Executive();
        executive.setEntNameCN("咖啡黑灰色发放");
        executive.setEnforceNameCN("发生大活动方为人");
        executive.setEnterpriseCourtNameCN("都十分温柔");
        executive.setDocketNoCN("积分洒垃圾服务而无情人千万人");
        executive.setCaseStatusCN("日前微软曲奇");
        executiveList.add(executive);
        fullReport.setExecutiveList(executiveList);

        //财物说明
        List<FinancialFigures> financialFiguresList = new ArrayList<>();
        FinancialFigures financialFigures = new FinancialFigures();
        financialFigures.setNoteCN("为其任务区及其");
        financialFigures.setAuditorNameCN("大煞风景撒附件为偶尔去这小子");
        financialFigures.setAuditorCommentCN("独守空房继而网上地方撒");
        financialFiguresList.add(financialFigures);
        fullReport.setFinancialFiguresList(financialFiguresList);

        //法人对外投资信息
        List<Frinvinfos> frinvinfosList = new ArrayList<>();
        Frinvinfos frinvinfos = new Frinvinfos();
        frinvinfos.setEnterpriseNameCN("狂扫访问期间按附件三分为");
        frinvinfos.setRegOrgCN("为轻微哈啊首付款让我去");
        frinvinfos.setAddressCN("就是垃圾法拉发放");
        frinvinfos.setNameCN("大哥哈记得换手机");
        frinvinfosList.add(frinvinfos);
        fullReport.setFrinvinfosList(frinvinfosList);

        //法人其他任职信息
        List<Frpositioninfos> frpositioninfosList = new ArrayList<>();
        for(int i=0; i<20; i++){
            Frpositioninfos frpositioninfos = new Frpositioninfos();
            frpositioninfos.setNameCN("激动撒附件为群殴而金融区区");
            frpositioninfos.setEnterpriseNameCN("小米通讯技术有限公司苏州分公司");
            frpositioninfos.setRegOrgCN("解放军的萨芬叫我而去");
            frpositioninfos.setPositionCN("粉丝服务而无情二七");
            frpositioninfos.setAddressCN("玩儿去玩撒飞洒发");
            frpositioninfosList.add(frpositioninfos);
        }
        fullReport.setFrpositioninfosList(frpositioninfosList);

        //历史背景沿革
        List<HistoryInfos> historyInfosList = new ArrayList<>();
        HistoryInfos historyInfos = new HistoryInfos();
        historyInfos.setDetailCN("打飞机酸辣粉降温哦");
        historyInfosList.add(historyInfos);
        fullReport.setHistoryInfosList(historyInfosList);

        //开庭公告
        List<Ktgg> ktgglist = new ArrayList<>();
        Ktgg ktgg = new Ktgg();
        ktgg.setPlaintiffCN("地方撒了服务器二七王");
        ktgg.setCourtroomCN("没打死发呢玩儿去玩");
        ktgg.setCourthouseCN("挥发分黄伟文偶尔我去");
        ktgg.setCaseCauseCN("酷狗问我无人区");
        ktgg.setChiefJusticeCN("结无情人撒发大水");
        ktgg.setDocketNoCN("发电量是否家乐福");
        ktgg.setDefendantCN("了我就去散发委屈");
        ktgglist.add(ktgg);
        fullReport.setKtggList(ktgglist);

        //管理层信息
        List<Managements> managementsList = new ArrayList<>();
        Managements managements = new Managements();
        managements.setNameCN("司法服务热武器");
        managements.setExperienceCN("放假撒风景完全让我去");
        managements.setNoteCN("萨瓦迪卡我查");
        managementsList.add(managements);
        fullReport.setManagementsList(managementsList);

        //经营现状获取信息
        Operatings operatings = new Operatings();
        operatings.setMainDiscriptionCN("答复撒热无若无群二");
        operatings.setMainProductCN("咖啡馆挤压是否");
        operatings.setProductionCN("还是废物如发生");
        operatings.setActivityOneCN("公司的风格也都发我");
        operatings.setActivityTwoCN("合法化的味儿");
        operatings.setActivityThreeCN("近段时间法法师");
        operatings.setInfoCN("范德萨个人业务");
        operatings.setPurchaseDomesticCN("工地工人突入");
        operatings.setPurchaseInternationlCN("大概多少共同一伙人");
        operatings.setSaleDomesticCN("给对方火热突然");
        operatings.setSaleInternationlCN("刚发的各人员惹怒");
        operatings.setImportAreaCN("鬼地方个有人讨厌特然");
        operatings.setExportAreaCN("范德萨发文啊让他梵蒂冈");
        operatings.setPurchaseTermCN("更符合人体也");
        operatings.setSaleTermCN("过分的话就会同意让他");
        operatings.setCertificationCN("东方高手都很疼");
        operatings.setPremiseCN("火凤凰教育投入");
        operatings.setLocationCN("发放为广大工人也");
        operatings.setIndustryCertificationCN("的说法都是个人头");
        operatings.setMainBrandCN("沃尔沃强大发生问题·");
        operatings.setMainPatentCN("单身公害维尔亚的撒");
        operatings.setDealershipCN("部门分管教育他发");
        fullReport.setOperatings(operatings);

        //其他信息
        List<OtherInfos> otherInfosList = new ArrayList<>();
        OtherInfos otherInfos = new OtherInfos();
        otherInfos.setNameCN("白癜风的腾飞");
        otherInfos.setDetailsCN("高富帅大好人");
        otherInfosList.add(otherInfos);
        fullReport.setOtherInfosList(otherInfosList);

        //支付款记录
        List<PaymentHistories> paymentHistoriesList = new ArrayList<>();
        PaymentHistories paymentHistories = new PaymentHistories();
        paymentHistories.setNameCN("发打发盛世嫡妃");
        paymentHistories.setCollectionCN("发的格纹很温柔");
        paymentHistories.setMainSuppliersCN("股份第三个问题");
        paymentHistories.setInterviewedCN("股份收到个问题问");
        paymentHistories.setPaymentCN("方大公司大股东发生过");
        paymentHistoriesList.add(paymentHistories);
        fullReport.setPaymentHistoriesList(paymentHistoriesList);

        //企业法律注册信息
        RegistrationInfos registrationInfos = new RegistrationInfos();
        registrationInfos.setStreetCN("古代诗歌的说法都是第三方");
        registrationInfos.setBuildingCN("范德萨发生地方都是");
        registrationInfos.setRegistrationCN("为热污染二额");
        registrationInfos.setBusinessScopeCN("额外若热无热无热无");
        registrationInfos.setDeadline("热污染翁认为");
        registrationInfos.setLegalPositionCN("同样容易让他与他人");
        registrationInfos.setLegalNameCN("犹太人英5有意义");
        registrationInfos.setNameCN("吾问无为谓无无无");
        fullReport.setRegistrationInfos(registrationInfos);

        //关联公司信息
        List<RelatedCompanies> relatedCompaniesList = new ArrayList<>();
        RelatedCompanies relatedCompanies = new RelatedCompanies();
        relatedCompanies.setNameCN("柔柔弱弱若若若若若若");
        relatedCompanies.setAddressCN("吞吞吐吐拖拖拖拖拖");
        relatedCompanies.setNoteCN("一月又一月晕晕晕晕晕");
        relatedCompaniesList.add(relatedCompanies);
        fullReport.setRelatedCompaniesList(relatedCompaniesList);

        //裁判文书
        List<Rulingdocuments> rulingdocumentsList = new ArrayList<>();
        Rulingdocuments rulingdocuments = new Rulingdocuments();
        rulingdocuments.setTitleCN("耶耶耶耶耶耶耶耶耶");
        rulingdocuments.setDocketNoCN("凄凄切切群群群群群群");
        rulingdocuments.setCourtNameCN("斤斤计较军军军军军军军军");
        rulingdocuments.setCaseTypeCN("哈哈呵呵或或或或或或或或或");
        rulingdocuments.setPlaintiffCN("哈哈呵呵或或或或");
        rulingdocuments.setDefendantCN("巴巴爸爸不不不不不不不不不不");
        rulingdocuments.setCaseStatusCN("男男女女女女女女");
        rulingdocuments.setNoteCN("坎坎坷坷扩扩扩扩扩");
        rulingdocumentsList.add(rulingdocuments);
        fullReport.setRulingdocumentsList(rulingdocumentsList);

        //股东信息
        List<ShareholderInfos> shareholderInfosList = new ArrayList<>();
        ShareholderInfos shareholderInfos = new ShareholderInfos();
        shareholderInfos.setNameCN("哦哦哦哦哦哦哦哦哦");
        shareholderInfos.setNoteCN("耶耶耶耶耶耶耶耶耶");
        shareholderInfos.setAddressCN("噼噼啪啪铺铺铺铺");
        shareholderInfos.setBusinessScopeCN("鹅鹅鹅饿鹅鹅鹅饿");
        shareholderInfosList.add(shareholderInfos);
        fullReport.setShareholderInfosList(shareholderInfosList);

        //股东链
        List<ShareholdersChain> shareholdersChainList = new ArrayList<>();
        ShareholdersChain shareholdersChain = new ShareholdersChain();
        shareholdersChain.setShareholdingNameCN("人人人人人人人");
        shareholdersChain.setBeShareholdingNameCN("停停停停停停停停");
        shareholdersChainList.add(shareholdersChain);
        fullReport.setShareholdersChainList(shareholdersChainList);

        //失信被执行人
        List<Sxgg> sxggList = new ArrayList<>();
        Sxgg sxgg = new Sxgg();
        sxgg.setEnforceeNameCN("密码密码木木木木");
        sxgg.setEntCourtNameCN("男男女女女女女女");
        sxgg.setEnforcementBasisNumberCN("灌灌灌灌灌过过");
        sxgg.setDocketNoCN("哈哈呵呵或或或或或");
        sxgg.setBasisUnitCN("斤斤计较斤斤计较");
        sxgg.setEffectiveObligationCN("啦啦啦啦啦绿绿");
        sxgg.setEnforceePerformCN("少时诵诗书所所所所");
        sxgg.setSpecificCircumstanceCN("啊啊啊啊啊啊啊啊");
        sxggList.add(sxgg);
        fullReport.setSxggList(sxggList);

        //贸易参考
        List<TradeReferences> tradeReferencesList = new ArrayList<>();
        TradeReferences tradeReferences = new TradeReferences();
        tradeReferences.setNameCN("少时诵诗书所所所所");
        tradeReferences.setNoteCN("鹅鹅鹅鹅鹅鹅饿");
        tradeReferencesList.add(tradeReferences);
        fullReport.setTradeReferencesList(tradeReferencesList);

        List<Brands> brandsList = new ArrayList<>();
        Brands brands = new Brands();
        brands.setPatentName("少时诵诗书所所所所");
        brands.setType("鹅鹅鹅鹅鹅鹅饿");
        brandsList.add(brands);
        fullReport.setBrandsList(brandsList);

        List<IcpWebsite> icpWebsiteList = new ArrayList<>();
        IcpWebsite icpWebsite = new IcpWebsite();
        icpWebsite.setLicenseKey("少时诵诗书所所所所");
        icpWebsiteList.add(icpWebsite);
        fullReport.setIcpWebsiteList(icpWebsiteList);


        fullReport = translateService.cnFullReportTranslate(fullReport);
        String report = (String) JSON.toJSONString(fullReport);
        System.out.println("report ======" + report);
    }

    public static String testFull() {
        InputStream in = null;
        try {
                InputStream stream = new FileInputStream("C:\\Users\\dong jian hua\\Desktop\\new_test.json");
                if (stream != null) {
                    in = new BufferedInputStream(stream);
                    byte[] bytes = new byte[1024 * 10];
                    int len = 0;
                    StringBuilder data = new StringBuilder();
                    while ((len = in.read(bytes)) != -1) {
                        data.append(new String(bytes, 0, len));
                    }
                    return data.toString();
                }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFullReport(){
        String fullReportJson = testFull();
        FullReport fullReport = (FullReport) JSON.parseObject(fullReportJson,FullReport.class);
        long start = System.currentTimeMillis();
        FullReport report = translateService.cnFullReportTranslate(fullReport);
        String reportData = (String) JSON.toJSONString(report);
        System.out.println("reportData ======" + reportData);
        long end = System.currentTimeMillis();
        System.out.println("花费时间" + (end - start));
    }
}
