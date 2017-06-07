//package test;
//
//import com.alibaba.fastjson.JSON;
//import com.mika.credit.common.entity.CityInfo;
//import com.mika.credit.common.entity.ProvinceInfo;
//import com.mika.credit.common.entity.ResponseResult;
//import com.mika.credit.common.entity.report.cn.IndustryClassBig;
//import com.mika.credit.common.entity.report.cn.IndustryClassMiddle;
//import com.mika.credit.common.entity.report.cn.IndustryClassSmall;
//import com.mika.credit.facade.front.cn.dao.*;
//import com.mika.credit.facade.front.cn.service.IndustryClassService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
///**
// * Created by dong jian hua on 2017/2/17.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-activemq.xml" })
//public class daoTest {
//
//    @Autowired
//    IndustryClassBigDao industryClassBigDao;
//    @Autowired
//    IndustryClassMiddleDao industryClassMiddleDao;
//    @Autowired
//    IndustryClassSmallDao industryClassSmallDao;
//    @Autowired
//    IndustryClassService industryClassService;
//    @Autowired
//    CityInfoDao cityInfoDao;
//    @Autowired
//    ProvinceInfoDao provinceInfoDao;
//
//    @Test
//    public  void industryClassBigDaoTest(){
//        IndustryClassBig industryClassBig = new IndustryClassBig();
//        industryClassBig.setName("12");
//        industryClassBig.setCode("54");
//        int insert = industryClassBigDao.insert(industryClassBig);
//        System.out.println("insert======>" +insert);
//
//    }
//
//    @Test
//    public  void industryClassMiddleDaoTest(){
//        IndustryClassMiddle industryClassMiddle = new IndustryClassMiddle();
//        industryClassMiddle.setCode("21");
//        industryClassMiddle.setName("25");
//        industryClassMiddle.setBigId(14L);
//        int insert = industryClassMiddleDao.insert(industryClassMiddle);
//        System.out.println("insert======>" +insert);
//
//    }
//
//    @Test
//    public  void industryClassSmallDaoTest(){
//        IndustryClassSmall industryClassSmall = new IndustryClassSmall();
//        industryClassSmall.setName("25");
//        industryClassSmall.setCode("56");
//        industryClassSmall.setBigId(14L);
//        industryClassSmall.setMiddleId(39L);
//        int insert = industryClassSmallDao.insert(industryClassSmall);
//        System.out.println("insert======>" +insert);
//
//    }
//
//    @Test
//    public  void cityInfoDaoTest(){
//        CityInfo cityInfo = new CityInfo();
//        cityInfo.setPopulation(25L);
//        cityInfo.setNominalGdpTotal(56L);
//        cityInfo.setNominalGdpPerCapita(14L);
//        cityInfo.setArea(39L);
//        cityInfo.setCity("58");
//        cityInfo.setCityEN("69");
//        cityInfo.setfId(1);
//        cityInfo.setMetropolitanArea("56");
//        cityInfo.setMetropolitanAreaEN("86");
//        int insert = cityInfoDao.insert(cityInfo);
//        System.out.println("insert======>" +insert);
//
//    }
//
//    @Test
//    public  void provinceInfoDaoTest(){
//        ProvinceInfo provinceInfo = new ProvinceInfo();
//        provinceInfo.setArea(20L);
//        provinceInfo.setMetropolitanArea("56");
//        provinceInfo.setMetropolitanAreaEn("14L");
//        provinceInfo.setNominalGdpPerCapita(39L);
//        provinceInfo.setNominalGdpTotal(52L);
//        provinceInfo.setPopulation(23L);
//        provinceInfo.setProvince("58");
//        provinceInfo.setProvinceEn("59");
//        int insert = provinceInfoDao.insert(provinceInfo);
//        System.out.println("insert======>" +insert);
//
//    }
//
//    @Test
//    public  void findAllTest(){
//        ResponseResult<List> all = industryClassService.findAll();
//        System.out.println("insert======>" + JSON.toJSONString(all));
//    }
//
//    @Test
//    public  void findIndustryClassBigTest(){
//        ResponseResult<List> all = industryClassService.findIndustryClassBig();
//        System.out.println("all=====>" + JSON.toJSONString(all));
//    }
//
//
//}
