package com.mika.credit.facade.verify.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.CreditCertification;
import com.mika.credit.facade.gugu.model.VerificationResult;
import com.mika.credit.facade.verify.dao.MobilephoneNameMapper;
import com.mika.credit.facade.verify.dao.TelephoneCompanynameMapper;
import com.mika.credit.facade.verify.model.MobilephoneName;
import com.mika.credit.facade.verify.model.TelephoneCompanyname;
import com.mika.credit.facade.verify.service.VerifyInfoService;
import com.mika.credit.facade.verify.util.DateUtil;
import com.mika.credit.facade.verify.util.Tool;
import com.mika.credit.facade.verify.util.VerifycationUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by dong jian hua on 2017/4/19.
 */
@Service("verifyInfoService")
public class VerifyInfoServiceImpl implements VerifyInfoService {
    private static Logger logger = Logger.getLogger(VerifyInfoServiceImpl.class);

    @Autowired
    TelephoneCompanynameMapper telephoneCompanynameMapper;
    @Autowired
    MobilephoneNameMapper mobilephoneNameMapper;


    @Override
    public ResponseResult<CreditCertification> getCreditCertification(FullReport fr) {
        ResponseResult<CreditCertification> creditCertifications = new ResponseResult<>();

        if (null == fr) {
            creditCertifications.setCode(false);
            creditCertifications.setMsg("数据为空，数据源出错！");
            logger.debug("数据为空，数据源出错！");
            return creditCertifications;
        }
        // 认证计算
        BasicInfos basicInfos = fr.getBasicInfos();
        RegistrationInfos registrationInfos = fr.getRegistrationInfos();
        List<FinancialRatios> financialRatios = fr.getFinancialRatiosList();
        CreditAssessments creditAssessments = fr.getCreditAssessments();
        Operatings operatings = fr.getOperatings();
        CreditCertification creditCertification = new CreditCertification();

        DecimalFormat myformat = new DecimalFormat();
        myformat.applyPattern("###,###,###,###.00");


        //诉讼
        Integer litigationSize = 0;
        if (StringUtil.isNotNull(fr.getAjlcList())) {
            litigationSize += fr.getAjlcList().size();
        }
        if (StringUtil.isNotNull(fr.getBgtList())) {
            litigationSize += fr.getBgtList().size();
        }
        if (StringUtil.isNotNull(fr.getSxggList())) {
            litigationSize += fr.getSxggList().size();
        }
        if (StringUtil.isNotNull(fr.getFyggList())) {
            litigationSize += fr.getFyggList().size();
        }
        if (StringUtil.isNotNull(fr.getExecutiveList())) {
            litigationSize += fr.getExecutiveList().size();
        }
        if (StringUtil.isNotNull(fr.getWdhmdList())) {
            litigationSize += fr.getWdhmdList().size();
        }
        if (StringUtil.isNotNull(fr.getKtggList())) {
            litigationSize += fr.getKtggList().size();
        }
        if (StringUtil.isNotNull(fr.getRulingdocumentsList())) {
            litigationSize += fr.getRulingdocumentsList().size();
        }
        creditCertification.setLitigationRecord(litigationSize.toString());


        //企业性质
        if (null != registrationInfos && StringUtil.isNotNull(registrationInfos.getEntOwnership())) {
            creditCertification.setCompanyProperty(registrationInfos.getEntOwnership());
        }
        //企业规模
        if (null != operatings && StringUtil.isNotNull(operatings.getCompanySizeCN())) {
            creditCertification.setCompanySize(operatings.getCompanySizeCN());
        }

        //所属行业
        if (null != basicInfos && StringUtil.isNotNull(basicInfos.getOutIndustry())) {
            if (basicInfos.getOutIndustry().equals("0")) {
                creditCertification.setIndustry("公司");
            } else if (basicInfos.getOutIndustry().equals("1")) {
                creditCertification.setIndustry("国标");
            } else {
                creditCertification.setIndustry("未知");
            }
        }

        //信用评级
        if (StringUtil.isNotNull(creditAssessments) && StringUtil.isNotNull(creditAssessments.getGlobalSolvency())) {
            creditCertification.setRepaymentIndex(creditAssessments.getGlobalSolvency());
        }

        //信用风险评级
        if (StringUtil.isNotNull(creditAssessments) && StringUtil.isNotNull(creditAssessments.getCreditRating())) {
            creditCertification.setCreditRiskEvaluation(creditAssessments.getCreditRating());
        }

        //注册资本,实缴资本
        if (StringUtil.isNotNull(registrationInfos.getPaidCapital())) {
            String resultKey = registrationInfos.getPaidCapital().replaceAll("\\s*", "");
            resultKey = resultKey.replaceAll("[(A-Za-z)]", "");
            BigDecimal money = new BigDecimal(resultKey);
            if (money.compareTo(new BigDecimal(100000)) == -1 || money.compareTo(new BigDecimal(100000)) == 0) {
                //X<=10W
                creditCertification.setRegCapitalScore("1");
            }
            if ((money.compareTo(new BigDecimal(10 * 10000)) == 1 && money.compareTo(new BigDecimal(100 * 10000)) == -1) || money.compareTo(new BigDecimal(100 * 10000)) == 0) {
                //10<X<=100W
                creditCertification.setRegCapitalScore("2");
            }
            if ((money.compareTo(new BigDecimal(100 * 10000)) == 1 && money.compareTo(new BigDecimal(500 * 10000)) == -1) || money.compareTo(new BigDecimal(500 * 10000)) == 0) {
                //100<X<=500W
                creditCertification.setRegCapitalScore("3");
            }
            if ((money.compareTo(new BigDecimal(100 * 10000)) == 1 && money.compareTo(new BigDecimal(1000 * 10000)) == -1) || money.compareTo(new BigDecimal(1000 * 10000)) == 0) {
                //500<X<=1000W
                creditCertification.setRegCapitalScore("4");
            }
            if ((money.compareTo(new BigDecimal(1000 * 10000)) == 1)) {
                //X>1000W
                creditCertification.setRegCapitalScore("5");
            }

            creditCertification.setRegCapital(myformat.format(money));
        }

        //销售成长率
        for (FinancialRatios financialRatio : financialRatios) {
            if (StringUtil.isNotNull(financialRatio) && StringUtil.isNotNull(financialRatio.getSalesGrowthRate())) {
                Double saleGrowth = Double.parseDouble(financialRatio.getSalesGrowthRate());
                if (saleGrowth <= -10) {
                    creditCertification.setSalesGrowthRateScore("1");
                    creditCertification.setSalesGrowthRate(String.valueOf(saleGrowth));
                    creditCertification.setSalesGrowthRateScope("减退");
                }
                if (saleGrowth > -10 && saleGrowth <= -5) {
                    creditCertification.setSalesGrowthRateScore("2");
                    creditCertification.setSalesGrowthRate(String.valueOf(saleGrowth));
                    creditCertification.setSalesGrowthRateScope("一般");
                }
                if (saleGrowth > -5 && saleGrowth <= 5) {
                    creditCertification.setSalesGrowthRateScore("3");
                    creditCertification.setSalesGrowthRate(String.valueOf(saleGrowth));
                    creditCertification.setSalesGrowthRateScope("成长");
                }

                if (saleGrowth > 5 && saleGrowth <= 10) {
                    creditCertification.setSalesGrowthRateScore("4");
                    creditCertification.setSalesGrowthRate(String.valueOf(saleGrowth));
                    creditCertification.setSalesGrowthRateScope("良好");
                }
                if (saleGrowth > 10) {
                    creditCertification.setSalesGrowthRateScore("5");
                    creditCertification.setSalesGrowthRate(String.valueOf(saleGrowth));
                    creditCertification.setSalesGrowthRateScope("强劲");
                }

            }

            //利润率
            if (StringUtil.isNotNull(financialRatio.getProfitMargin())) {
                Double profitMargin = Double.parseDouble(financialRatio.getProfitMargin());
                if (profitMargin <= 0) {
                    creditCertification.setProfitMarginScore("1");
                    creditCertification.setProfitMargin(String.valueOf(profitMargin));
                    creditCertification.setProfitMarginScope("亏损");
                }

                if (profitMargin > 0 && profitMargin <= 5) {
                    creditCertification.setProfitMarginScore("2");
                    creditCertification.setProfitMargin(String.valueOf(profitMargin));
                    creditCertification.setProfitMarginScope("一般");
                }

                if (profitMargin > 5 && profitMargin <= 20) {
                    creditCertification.setProfitMarginScore("3");
                    creditCertification.setProfitMargin(String.valueOf(profitMargin));
                    creditCertification.setProfitMarginScope("良好");
                }

                if (profitMargin > 20 && profitMargin <= 40) {
                    creditCertification.setProfitMarginScore("4");
                    creditCertification.setProfitMargin(String.valueOf(profitMargin));
                    creditCertification.setProfitMarginScope("较强");

                }

                if (profitMargin > 40) {
                    creditCertification.setProfitMarginScore("5");
                    creditCertification.setProfitMargin(String.valueOf(profitMargin));
                    creditCertification.setProfitMarginScope("强");
                }

            }
            //流动比率
            if (StringUtil.isNotNull(financialRatio.getCurrentRato())) {
                Double currentRato = Double.parseDouble(financialRatio.getCurrentRato());
                if (currentRato <= 0.8) {
                    creditCertification.setCurrentRatioScore("1");
                    creditCertification.setCurrentRatio(String.valueOf(currentRato));
                    creditCertification.setCurrentRatioScope("较低");
                }
                if (currentRato > 0.8 && currentRato <= 1.3) {
                    creditCertification.setCurrentRatioScore("2");
                    creditCertification.setCurrentRatio(String.valueOf(currentRato));
                    creditCertification.setCurrentRatioScope("尚可");
                }

                if (currentRato > 1.3 && currentRato <= 1.7) {
                    creditCertification.setCurrentRatioScore("3");
                    creditCertification.setCurrentRatio(String.valueOf(currentRato));
                    creditCertification.setCurrentRatioScope("一般");
                }

                if (currentRato > 1.7 && currentRato <= 2.5) {
                    creditCertification.setCurrentRatioScore("4");
                    creditCertification.setCurrentRatio(String.valueOf(currentRato));
                    creditCertification.setCurrentRatioScope("较好");
                }

                if (currentRato > 2.5) {
                    creditCertification.setCurrentRatioScore("5");
                    creditCertification.setCurrentRatio(String.valueOf(currentRato));
                    creditCertification.setCurrentRatioScope("佳");
                }

            }
            //资产负债率
            if (StringUtil.isNotNull(financialRatio.getDebtRatio())) {
                Double debtRatio = Double.parseDouble(financialRatio.getDebtRatio());
                if (debtRatio >= 95) {
                    creditCertification.setDebtRatioScore("1");
                    creditCertification.setDebtRatio(String.valueOf(debtRatio));
                    creditCertification.setDebtRatioScope("较差");
                }

                if (debtRatio >= 80 && debtRatio < 95) {
                    creditCertification.setDebtRatioScore("2");
                    creditCertification.setDebtRatio(String.valueOf(debtRatio));
                    creditCertification.setDebtRatioScope("较弱");
                }

                if (debtRatio >= 60 && debtRatio < 80) {
                    creditCertification.setDebtRatioScore("3");
                    creditCertification.setDebtRatio(String.valueOf(debtRatio));
                    creditCertification.setDebtRatioScope("一般");
                }

                if (debtRatio >= 40 && debtRatio < 60) {
                    creditCertification.setDebtRatioScore("4");
                    creditCertification.setDebtRatio(String.valueOf(debtRatio));
                    creditCertification.setDebtRatioScope("正常");
                }

                if (debtRatio < 40) {
                    creditCertification.setDebtRatioScore("5");
                    creditCertification.setDebtRatio(String.valueOf(debtRatio));
                    creditCertification.setDebtRatioScope("健康");
                }

            }
            break;
        }
        creditCertifications.setCode(true);
        creditCertifications.setContent(creditCertification);
        return creditCertifications;
    }

    @Override
    public ResponseResult<VerificationResult> getVerifyInfoModel(BusinessCard businessCard, FullReport fullReport) {
        ResponseResult<VerificationResult> verificationResultResponseResult = new ResponseResult<>();
        VerificationResult verificationResult = new VerificationResult();
        //核实计算
        Integer weight = 0;
        Integer complexScore = 0;

        //判断营业状态
        if (StringUtil.isNotNull(fullReport) && StringUtil.isNotNull(fullReport.getRegistrationInfos()) && StringUtil.isNotNull(businessCard)) {
        } else {
            verificationResultResponseResult.setCode(false);
            verificationResultResponseResult.setMsg("无法查询到该公司！");
            logger.debug("无法查询到该公司！");
            return verificationResultResponseResult;
        }


        RegistrationInfos registrationInfos = fullReport.getRegistrationInfos();

        //企业状态
        weight = VerifycationUtil.OperatingStatus(registrationInfos.getCompanyStatus(), weight, verificationResult);


        //注册年限
        if (StringUtil.isNotNull(registrationInfos.getEstablishDate())) {
            Integer weight_nianxian = VerifycationUtil.otherInfo(new DateUtil().conversionDate(registrationInfos.getEstablishDate()), weight);
            complexScore = complexScore + (weight_nianxian - weight);
            weight = weight_nianxian;
        }


        //注册资金
        try {
            if (StringUtil.isNotNull(registrationInfos.getRegCapital())) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                String resultKey = registrationInfos.getRegCapital().replaceAll("\\s*", "");
                resultKey = resultKey.replaceAll("[(A-Za-z)]", "");
                Number capital = numberFormat.parse(resultKey);
                Long regCapital = capital.longValue();
                Integer weight_zijin = VerifycationUtil.otherInfo(regCapital, weight);
                complexScore = complexScore + (weight_zijin - weight);
                weight = weight_zijin;
            }
        } catch (Exception e) {
            logger.error("格式化数字类型出错：numberFormat.parse(resultKey)");
            e.printStackTrace();
        }

        //注册区域
        Integer weight_quyu = VerifycationUtil.otherInfo(registrationInfos.getProvinceCode(), weight);
        complexScore = complexScore + (weight_quyu - weight);
        weight = weight_quyu;


        // 网址ICP备份
        List<IcpWebsite> websiteList = fullReport.getIcpWebsiteList();
        weight = VerifycationUtil.IcpwebsiteStatus(businessCard.getCardWebsite(), websiteList, weight, verificationResult);


        // 电信登记核实
        try {

            if (StringUtil.isNotNull(businessCard.getCardTel())) {
                String companyNamel = Tool.FilterString(businessCard.getCardCompany()).replace(" ", "");
                TelephoneCompanyname telephoneCompanyname = new TelephoneCompanyname();
                telephoneCompanyname.setCompanyName(companyNamel);
                List<TelephoneCompanyname> telephoneCompanynames = telephoneCompanynameMapper.selectSeletive(telephoneCompanyname);
                if (telephoneCompanynames.size() > 0) {
                    for (int i = 0; i < telephoneCompanynames.size(); i++) {
                        TelephoneCompanyname tel = telephoneCompanynames.get(0);
                        weight = VerifycationUtil.telInfo_hx_cache(businessCard, weight, verificationResult, tel);
                        break;
                    }
                } else {
                    String score = VerifycationUtil.telInfo_hx(businessCard, weight, verificationResult);
                    JSONObject jsons = JSONObject.parseObject(score);
                    weight = jsons.getInteger("weight");
                    String companyName = jsons.getString("companyName");
                    String areaCode = jsons.getString("areaCode");
                    String addRess = jsons.getString("addRess");
                    BusinessCard businessCard1 = new BusinessCard();
                    businessCard1.setCardCompany(companyName);
                    businessCard1.setAreaCode(areaCode);
                    businessCard1.setCardAddress(addRess);
                    //添加信息到缓存库
                    getMobiledAche(businessCard1, "", "", 1);
                }
            }

        } catch (Exception e) {
            logger.error("翰信接口异常,未查到任何数据！"+e.getMessage());
            e.printStackTrace();
        }

        //其他-网站和邮箱
            Integer weight_wangzhanyouxiang = VerifycationUtil.otherInfo(businessCard, weight, verificationResult);
            complexScore = complexScore + (weight_wangzhanyouxiang - weight);
            weight = weight_wangzhanyouxiang;



        // 手机
        try {
            if (StringUtil.isNotNull(businessCard.getCardPhone()) && StringUtil.isNotNull(businessCard.getCardName())) {
                MobilephoneName mobilephoneName = new MobilephoneName();
                mobilephoneName.setPhone(businessCard.getCardPhone());
                mobilephoneName.setPersonName(businessCard.getCardName());
                List<MobilephoneName> mobilephoneNames = mobilephoneNameMapper.selectSeletive(mobilephoneName);
                if (mobilephoneNames.size() > 0) {
                    for (int i = 0; i < mobilephoneNames.size(); i++) {
                        MobilephoneName mobile = mobilephoneNames.get(0);
                        //缓存库
                        weight = VerifycationUtil.mobliePhone_hx_cache(businessCard, weight, verificationResult, mobile);
                        break;
                    }
                } else {
                    //翰信验证手机
                    String score = VerifycationUtil.mobliePhone_hx(businessCard, weight, verificationResult);
                    JSONObject jsons = JSONObject.parseObject(score);
                    String content = jsons.getString("content");
                    weight = jsons.getInteger("weight");
                    if (StringUtil.isNotNull(content)) {
                        //添加信息到缓存库
                        getMobiledAche(businessCard, content, "", 2);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("域赢手机接口异常,未查到任何数据！"+e.getMessage());
            e.printStackTrace();
        }

        //手机在网时长
        try {
            if (StringUtil.isNotNull(businessCard.getCardPhone())) {
                MobilephoneName mobilephoneName = new MobilephoneName();
                mobilephoneName.setPhone(businessCard.getCardPhone());
                List<MobilephoneName> mobilephoneNames = mobilephoneNameMapper.selectSeletive(mobilephoneName);
                if (mobilephoneNames.size() > 0 && StringUtil.isNotNull(mobilephoneNames.get(0).getNote())) {
                    for (int i = 0; i < mobilephoneNames.size(); i++) {
                        MobilephoneName mobile = mobilephoneNames.get(0);
                        //缓存库
                        Integer weight_zaiwangshichang = VerifycationUtil.mobilePhone_mpTime_hx_cache(businessCard.getCardPhone(), weight, mobile);
                        complexScore = complexScore + (weight_zaiwangshichang - weight);
                        weight = weight_zaiwangshichang;
                        break;
                    }
                } else {
                    //在线时长接口
                    String score = VerifycationUtil.mobilePhone_mpTime_hx(businessCard.getCardPhone(), weight);
                    JSONObject jsons = JSONObject.parseObject(score);
                    Integer weight_score = jsons.getInteger("weight");
                    String note = jsons.getString("content");
                    if (StringUtil.isNotNull(note)) {
                        //添加信息到缓存库
                        getMobiledAche(businessCard, "", note, 2);
                    }
                    complexScore = complexScore + (weight_score - weight);
                    weight = weight_score;
                }
            }
        } catch (Exception e) {
            logger.error("域赢手机在网时长接口异常,未查到任何数据!"+e.getMessage());
            e.printStackTrace();
        }

        //其他计算(法人、管理层、股东)
        if (StringUtil.isNotNull(businessCard.getCardName())) {
            Integer weight_otherInfo = VerifycationUtil.other_information(businessCard.getCardName(), fullReport, verificationResult, weight);
            complexScore = complexScore + (weight_otherInfo - weight);
            weight = weight_otherInfo;
        }


        verificationResult.setTotalScore(weight);
        verificationResult.setOtherInfoResult(complexScore + "");
        verificationResultResponseResult.setContent(verificationResult);
        verificationResultResponseResult.setCode(true);
        logger.debug("改名片id为"+businessCard.getId()+"的用户，核实总分为："+weight+",其他综合评估分值为"+complexScore);
        return verificationResultResponseResult;

    }

    //信用评估--全球鹰使用  分数转换为safe的百分制
    public String transSafeNumber(String score){
        int Score = 0;
        int returnScore = 0;
        double dScore = 0D;
        Score = Integer.parseInt(StringUtil.isIndex(score));
        if(Score>=100 && Score <=193){
            dScore = 193-Score;
            dScore = dScore / 93;
            dScore = dScore * (101-68-1);
            returnScore = (int) (dScore  + 68);
        }
        if(Score>=194 && Score <=294){
            dScore = 294-Score;
            dScore = dScore / 100;
            dScore = dScore * (68-52-1);
            returnScore = (int) (dScore  + 52);
        }
        if(Score>=295 && Score <=353){
            dScore = 353-Score;
            dScore = dScore / 58;
            dScore = dScore * (52-42-1);
            returnScore = (int) (dScore  + 42);
        }
        if(Score>=354 && Score <=439){
            dScore = 439-Score;
            dScore = dScore / 85;
            dScore = dScore * (42-28-1);
            returnScore = (int) (dScore  + 28);
        }
        if(Score>=440 && Score <=600){
            dScore = 600-Score;
            dScore = dScore / 160;
            dScore = dScore * (28-1-1);
            returnScore = (int) (dScore  + 1);
        }
        return returnScore+"";
    }





    public void getMobiledAche(BusinessCard businessCard, String content, String note, int type) {
        if (type == 1) {
            TelephoneCompanyname telephoneCompanyname = new TelephoneCompanyname();
            if (StringUtil.isNotNull(businessCard.getCardAddress())) {
                telephoneCompanyname.setAddress(businessCard.getCardAddress());
            }
            if (StringUtil.isNotNull(businessCard.getAreaCode())) {
                telephoneCompanyname.setAreaCode(businessCard.getAreaCode());
            }
            if (StringUtil.isNotNull(businessCard.getCardCompany())) {
                telephoneCompanyname.setCompanyName(businessCard.getCardCompany());
                logger.debug("查询电信固话缓存库"+ JSON.toJSONString(telephoneCompanyname));
                List<TelephoneCompanyname> seletiveTel = telephoneCompanynameMapper.selectSeletive(telephoneCompanyname);
                if (seletiveTel.size() > 0) {
                    logger.debug("更新电信固话信息到缓存库"+JSON.toJSONString(telephoneCompanyname));
                    telephoneCompanynameMapper.updateByPrimaryKeySelective(telephoneCompanyname);
                } else {
                    logger.debug("插入电信固话到缓存库"+JSON.toJSONString(telephoneCompanyname));
                    telephoneCompanynameMapper.insertSelective(telephoneCompanyname);
                }

            }
        }
        if (type == 2) {
            MobilephoneName mobilephoneName = new MobilephoneName();
            mobilephoneName.setPhone(businessCard.getCardPhone());
            logger.debug("查询手机信息缓存库"+JSON.toJSONString(mobilephoneName));
            List<MobilephoneName> mobilephoneNames = mobilephoneNameMapper.selectSeletive(mobilephoneName);
            if (mobilephoneNames.size() > 0) {
                if (StringUtil.isNotNull(content)) {
                    mobilephoneName.setTimeScore(content);
                }
                if (StringUtil.isNotNull(note)) {
                    mobilephoneName.setNote(note);
                }
                mobilephoneName.setPersonName(businessCard.getCardName());
                mobilephoneName.setTimeScore(content);
                logger.debug("更新手机信息到缓存库"+JSON.toJSONString(mobilephoneName));
                mobilephoneNameMapper.updateByPrimaryKeySelective(mobilephoneName);
            } else {
                if (StringUtil.isNotNull(content)) {
                    mobilephoneName.setTimeScore(content);
                }
                if (StringUtil.isNotNull(note)) {
                    mobilephoneName.setNote(note);
                }
                mobilephoneName.setPersonName(businessCard.getCardName());
                logger.debug("插入手机信息到缓存库"+JSON.toJSONString(mobilephoneName));
                mobilephoneNameMapper.insertSelective(mobilephoneName);
            }

        }
    }
}
