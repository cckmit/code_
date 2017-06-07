package com.mika.credit.facade.front.cn.parse.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.facade.front.cn.dao.*;
import com.mika.credit.facade.front.cn.parse.ParseGrande;
import com.mika.credit.facade.front.cn.service.DataTypeService;
import com.mika.credit.facade.front.cn.service.GrandeInfoService;
import com.mika.credit.facade.front.cn.util.Tool;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.mika.credit.facade.front.cn.util.Tool.getinfoData;

/**
 * Created by dell on 2017/2/16.
 */
@Service("parseGrande")
public class ParseGrandeImpl implements ParseGrande {
    @Autowired
    AssetsAnnualDao assetsAnnualDao;
    @Autowired
    BasicAnnuaDao baiscAnnuaDao;
    @Autowired
    BrandsDao brandsDao;
    @Autowired
    GuaranteeAnnualDao guaranteeAnnualDao;
    @Autowired
    IcpWebsiteDao icpWebsiteDao;
    @Autowired
    OperationAbnormalInfosDao operationAbnormalInfosDao;
    @Autowired
    ChangeInfosDao changeInfosDao;
    @Autowired
    RegistrationInfosDao registrationInfosDao;
    @Autowired
    ManagementsDao managementsDao;
    @Autowired
    DataTypeDao dataTypeDao;
    @Autowired
    BasicInfosDao basicInfosDao;
    @Autowired
    MediaRecordsDao mediaRecordsDao;
    @Autowired
    ShareholderInfosDao shareholderInfosDao;
    @Autowired
    DataTypeService dataTypeService;
    @Autowired
    BasicDataDao basicDateDao;
    @Autowired
    GrandeInfoService grandeInfoService;
    @Autowired
    FullReportDao fullReportDao;
    @Autowired
    EnterpriseShareholderDao enterpriseShareholderDao;

    //格兰德json数据
    String gldData = "";

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String updatetime = format.format(new Date());

    @Override
    public void SaveBusiness(FullReport report) {
        gldData = "";
        gldData = grandeInfoService.sendGLDOrgData(Tool.replaceSymbolCN(report.getNameCN()));
        JSONObject result = JSONObject.parseObject(gldData);
        JSONObject saxPublicInfoBean = result.getJSONObject("saxPublicInfoBean");
        BasicInfos basics = new BasicInfos();
        FullReport fullReports = fullReportDao.findByName(report.getNameCN());
        Integer fullReportId = 0;
        if(null != fullReports && null != fullReports.getId() ){
            fullReportId = fullReports.getId();
        }
        if(null!=saxPublicInfoBean && saxPublicInfoBean.size()>0){
            JSONArray saxNBQTBeans = saxPublicInfoBean.getJSONArray("saxNBQTBeans");
            if (null!=saxNBQTBeans && saxNBQTBeans.size()>0) {
                //取年报最后一年
                for (int i = saxNBQTBeans.size()-1;i<saxNBQTBeans.size();i++){
                    JSONObject saxZCZKBeansobject = saxNBQTBeans.getJSONObject(i);
                    JSONObject reportBaseObject = saxZCZKBeansobject.getJSONObject("reportBase");
                    String reportBaseStr = reportBaseObject.toJSONString();
                    reportBaseStr=reportBaseStr.replace("zch","reg");//注册号
                    reportBaseStr=reportBaseStr.replace("qymc","nameCN");//企业名称
                    reportBaseStr=reportBaseStr.replace("lxdh","tel");//企业联系电话
                    reportBaseStr=reportBaseStr.replace("yzbm","managezip");//邮政编码
                    reportBaseStr=reportBaseStr.replace("txdz","streetCN");//企业通信地址
                    reportBaseStr=reportBaseStr.replace("dzyx","email");//电子邮箱
                    basics = JSON.parseObject(reportBaseStr,BasicInfos.class);
                }
            }
        }


        //企业年报信息
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray basicInfosArray = saxPublicInfoBean.getJSONArray("saxLLXXBeans");
            if (null!=basicInfosArray && basicInfosArray.size()>0) {
                for (int i = 0; i < basicInfosArray.size(); i++) {
                    JSONObject info = basicInfosArray.getJSONObject(i);
                    //取电话，邮箱，邮政编码，地址
                    JSONArray saxContactBeans = info.getJSONArray("saxContactBeans");
                    if (saxContactBeans.size() > 0) {
                        JSONObject saxContactBean = saxContactBeans.getJSONObject(saxContactBeans.size() - 1);
                        basics.setTel(getinfoData(saxContactBean, "dh"));
                        basics.setEmail(getinfoData(saxContactBean, "yx"));
                        basics.setZip(getinfoData(saxContactBean, "yzbm"));
                        basics.setStreetCN(getinfoData(saxContactBean, "dz"));
                    }
                    //取网址
                    try {
                        JSONArray websiteList = info.getJSONArray("webSiteList");
                        for (int j = 0; j < websiteList.size(); j++) {
                            JSONObject website = websiteList.getJSONObject(j);
                            basics.setWebsite(getinfoData(website, "wz"));
                        }
                    } catch (Exception e) {
                        // e.printStackTrace();
                    }
                }
            }
        }

        //防止格兰德没拿到数据 公司名没加入basics
        if(null!=basics && !"".equals(basics.getNameCN())){
            basics.setNameCN(Tool.replaceSymbol(basics.getNameCN()));
        }else{
            basics.setNameCN(report.getNameCN());
        }
        basics.setFullReportId(fullReportId);
        basicInfosDao.insert(basics);
        RegistrationInfos historyReg = registrationInfosDao.findByFullReportId(fullReportId);
        if(null!=historyReg && null!=historyReg.getId()){
            registrationInfosDao.deleteById(historyReg.getId());
        }
        //注册信息
        RegistrationInfos reg = new RegistrationInfos();
        List<BasicData> basicDataList = new ArrayList<BasicData>();
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONObject saxZCZKBeans = saxPublicInfoBean.getJSONObject("saxGSZMBean");
            if (null!=saxZCZKBeans && saxZCZKBeans.size()>0) {
                JSONObject publicOrgBaseBean = saxZCZKBeans.getJSONObject("publicOrgBaseBean");
                if (null!=publicOrgBaseBean && publicOrgBaseBean.size()>0) {
                    String publicOrgBaseBeanStr = publicOrgBaseBean.toJSONString();
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zch", "reg");//工商注册号
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("mc", "nameCN");//公司名称
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("lx", "entType");//企业类型
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("fddbr", "LegalNameCN");//法人
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zczb", "regCapital");//注册资本
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zcbz", "regCurrency");//注册资本币种
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("clrq", "establishDate");//注册日期
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("yycs", "streetCN");//经营地址
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("yyqxzh", "delistDate");//经营期限
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("jyfw", "businessScopeCN");//经营范围
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("djjg", "registrationCN");//注册机关
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("djzt", "entStatus");//企业状态
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("sfdm", "provinceCode");//注册省份代码
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("xydm", "creditcode");//统一征信代码
                    reg = JSON.parseObject(publicOrgBaseBeanStr, RegistrationInfos.class);
                    List<DataType> Currencylist = dataTypeService.findByCode("Currency");
                    Map<String,Object> params = new HashedMap();
                    params.put("dtid",Currencylist.get(0).getId());
                    params.put("delFlag","1");
                    if(null!=Currencylist && Currencylist.size()>0){
                        basicDataList = basicDateDao.listByDtidAndDelFlag(params);
                    }
                    reg.setRegCurrencyId(Tool.getIntRcid(basicDataList,Tool.getinfoData(publicOrgBaseBean,"zcbz")));
                    reg.setPaidCurrencyId(Tool.getIntRcid(basicDataList,Tool.getinfoData(publicOrgBaseBean,"zcbz")));
                    //判断企业类型和企业性质
                    RegistrationInfos  regs = Tool.TypeAndNature(reg.getCompanyType());
                    reg.setCompanyTypesId(regs.getCompanyTypesId());
                    reg.setCompanyPropertiesId(regs.getCompanyPropertiesId());
                    //判断企业状态
                    reg.setCompanyStatusId(Tool.EnterpriseStatus(reg.getCompanyStatus()));

                    //保存注册信息
                    reg.setFullReportId(fullReportId);
                    registrationInfosDao.insert(reg);
                }
            }

        }



        //管理层
        //先删除数据库已有的管理层数据
        List<Managements> managementList = managementsDao.findByFullReportId(fullReportId);
        for (int i =0;i<managementList.size();i++){
            managementsDao.deleteById(managementList.get(i).getId());
        }
        //职务类型
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONObject saxGSZMBean = saxPublicInfoBean.getJSONObject("saxGSZMBean");
            if (null!=saxGSZMBean && saxGSZMBean.size()>0) {
                List<DataType> list = dataTypeService.findByCode("Post");
                basicDataList = new ArrayList<BasicData>();
                Map<String,Object> params = new HashedMap();
                params.put("dtid",list.get(0).getId());
                params.put("delFlag","1");
                if(null!=list && list.size()>0){
                    basicDataList = basicDateDao.listByDtidAndDelFlag(params);
                }
                JSONArray publicOrgStaffBeans = saxGSZMBean.getJSONArray("publicOrgStaffBeans");
                if (null!=publicOrgStaffBeans && publicOrgStaffBeans.size()>0) {
                    for (int i = 0; i < publicOrgStaffBeans.size(); i++) {
                        JSONObject saxZCZKBeansobject = publicOrgStaffBeans.getJSONObject(i);
                        String reportBaseStr = saxZCZKBeansobject.toJSONString();
                        reportBaseStr = reportBaseStr.replace("xm", "nameCN");//姓名
                        reportBaseStr = reportBaseStr.replace("zw", "position");//职务
                        int postion=0;
                        if(null!=saxZCZKBeansobject.getString("dutyInc")){
                            for (int j = 0; j < basicDataList.size(); j++) {
                                BasicData basicdata = basicDataList.get(j);
                                if(basicdata.getValueCN().equals(saxZCZKBeansobject.getString("dutyInc"))){
                                    postion = basicdata.getCode();
                                }
                            }
                        }
                        reportBaseStr = reportBaseStr.replace("zjhm", "cardID");//证件号
                        Managements managements = JSON.parseObject(reportBaseStr, Managements.class);
                        //managements.setCrefoNo(basics.getCrefoNo());
                        managements.setPostId(postion);
                        managements.setFullReportId(fullReportId);
                        managementsDao.insert(managements);
                    }
                }
            }

        }


        //新闻
        //先删除数据库已有的新闻数据
        List<MediaRecords> mediaRecordsList = mediaRecordsDao.findByFullReportId(fullReportId);
        for (int i =0;i<mediaRecordsList.size();i++){
            mediaRecordsDao.deleteById(mediaRecordsList.get(i).getId());
        }
            JSONArray saxNewsBeans = result.getJSONArray("saxNewsBeans");
            if (null!=saxNewsBeans && saxNewsBeans.size()>0) {
                for (int i = 0; i < saxNewsBeans.size(); i++) {
                    JSONObject saxNewsBeansobject = saxNewsBeans.getJSONObject(i);
                    String reportBaseStr = saxNewsBeansobject.toJSONString();
                    reportBaseStr = reportBaseStr.replace("bt", "title");//标题
                    reportBaseStr = reportBaseStr.replace("ly", "source");//来源
                    reportBaseStr = reportBaseStr.replace("fbsj", "date");//发布时间
                    reportBaseStr = reportBaseStr.replace("nr", "content");//内容
                    reportBaseStr = reportBaseStr.replace("xxly", "source");//信息来源
                    reportBaseStr = reportBaseStr.replace("lj", "link");//链接
                    reportBaseStr = reportBaseStr.replace("hqrq", "getTime");//获取日期
                    reportBaseStr = reportBaseStr.replace("gxrq", "updateTime");//更新日期
                    MediaRecords mediaRecords = JSON.parseObject(reportBaseStr, MediaRecords.class);
                    //mediaRecords.setCrefoNo(basics.getCrefoNo()+"");
                    mediaRecords.setFullReportId(fullReportId);
                    mediaRecordsDao.insert(mediaRecords);
                }
            }

        List<ShareholderInfos> shareHolderlist = new ArrayList<ShareholderInfos>();
        //先删除数据库已有的股东股权数据
        List<ShareholderInfos> shareList = shareholderInfosDao.findByFullReportId(fullReportId);
        for (int i =0;i<shareList.size();i++){
            shareholderInfosDao.deleteById(shareList.get(i).getId());
        }
        //股东股权信息
        try {
            if(null!=saxPublicInfoBean&&saxPublicInfoBean.size()>0){
                JSONObject saxGSZMBean = saxPublicInfoBean.getJSONObject("saxGSZMBean");
                JSONArray shareHolderArrays = saxGSZMBean.getJSONArray("shareholdersInfos");
                for (int i = 0; i < shareHolderArrays.size(); i++) {
                    JSONObject shareholdersInfosobject = shareHolderArrays.getJSONObject(i);
                    ShareholderInfos shareholderInfos = new ShareholderInfos();
                    String gdlx = getinfoData(shareholdersInfosobject, "gdlx");
                    if (null != gdlx && "企业法人".equals(gdlx)) {
                        shareholderInfos.setType("1");
                    } else if (null != gdlx && "自然人股东".equals(gdlx)) {
                        shareholderInfos.setType("0");
                    } else {
                        shareholderInfos.setType("3");
                    }
                    shareholderInfos.setNameCN(getinfoData(shareholdersInfosobject, "gd"));
                    String zjhm = getinfoData(shareholdersInfosobject, "zjhm");
                    shareholderInfos.setIdCard(getinfoData(shareholdersInfosobject, "zjhm"));
                    shareHolderlist.add(shareholderInfos);
                }
            }

            if(null!=saxPublicInfoBean&&saxPublicInfoBean.size()>0){
                JSONArray shareHolderArray = saxPublicInfoBean.getJSONArray("saxGDCZBeans");
                List<ShareholderInfos> gdczlist = new ArrayList<ShareholderInfos>();
                Double rjCount = null;

//	                        	JSONArray shareHolderArray = JSONArray.fromObject(saxGDCZBeansObject);
                if (null != shareHolderArray) {
                    JSONObject obj = shareHolderArray.getJSONObject(shareHolderArray.size() - 1);
                    try {
                        JSONArray shareArr = obj.getJSONArray("enterpriseShareholderList");
                        for (int i = 0; i < shareArr.size(); i++) {
                            JSONObject shareObject = shareArr.getJSONObject(i);
                            ShareholderInfos share = new ShareholderInfos();
                            share.setRegCapital(shareObject.getString("rjcze"));
                            share.setNameCN(shareObject.getString("gd"));
                            gdczlist.add(share);
                        }
                    } catch (Exception e) {
                    }
                    Double gdRJ = null;
                    for (int i = 0; i < gdczlist.size(); i++) {
                        ShareholderInfos share = gdczlist.get(i);
                        gdRJ = null;
                        String share_regCapital = share.getRegCapital();
                        share_regCapital = share_regCapital.replace("元", "");
                        share_regCapital = share_regCapital.replace("人", "");
                        share_regCapital = share_regCapital.replace("民", "");
                        share_regCapital = share_regCapital.replace("美", "");
                        share_regCapital = share_regCapital.replace("币", "");
                        if (share_regCapital.contains("万")) {
                            share_regCapital = share_regCapital.replace("万", "");
                            gdRJ = Double.parseDouble(share_regCapital);
                        }else{
                            gdRJ = Double.parseDouble(share_regCapital);
                        }
                        if (null != share && null != share.getRegCapital() && !share.getRegCapital().equals("")) {
                            if (null == rjCount) {
                                rjCount = 0.0;
                                rjCount = gdRJ + rjCount;
                                share.setSubconam(gdRJ + "");
                            } else {
                                rjCount = gdRJ + rjCount;
                            }
                        }
                        gdczlist.set(i, share);
                    }
                    gdRJ = null;
                    for (ShareholderInfos sharePre : gdczlist) {
                        if (null != sharePre && null != sharePre.getRegCapital() && !sharePre.getRegCapital().equals("") && !sharePre.getRegCapital().equals("null")) {
                            String share_regCapital = sharePre.getRegCapital();
                            share_regCapital = share_regCapital.replace("元", "");
                            share_regCapital = share_regCapital.replace("人", "");
                            share_regCapital = share_regCapital.replace("民", "");
                            share_regCapital = share_regCapital.replace("美", "");
                            share_regCapital = share_regCapital.replace("币", "");
                            if (share_regCapital.contains("万")) {
                                share_regCapital = share_regCapital.replace("万", "");
                                gdRJ = Double.parseDouble(share_regCapital) * 10000;
                            }

                            gdRJ = Double.parseDouble(sharePre.getRegCapital());
                            Double rjShare = gdRJ / rjCount;
                            DecimalFormat myformat = new DecimalFormat("##0.00");
                            String rgShareResult = myformat.format(rjShare * 100);

                            int count = 0;
                            Boolean f = false;
                            for (ShareholderInfos shareBef : shareHolderlist) {
                                //只有一个股东不判断公司名
                                if (shareHolderlist.size() == 1) {
                                    shareBef.setRegCapital(new BigDecimal(gdRJ * 10000).toString());
                                    shareBef.setShares(rgShareResult);
                                    shareHolderlist.set(count, shareBef);
                                    f = true;
                                } else {
                                    if (null != sharePre.getNameCN() && !sharePre.getNameCN().equals("") && null != shareBef && null != shareBef.getNameCN() && !shareBef.getNameCN().equals("")) {
                                        if (shareBef.getNameCN().equals(sharePre.getNameCN())) {
                                            shareBef.setRegCapital(new BigDecimal(gdRJ * 10000).toString());
                                            shareBef.setShares(rgShareResult);
                                            shareHolderlist.set(count, shareBef);
                                            f = true;
                                        }
                                    }
                                }
                                if (f) {
                                    break;
                                }
                                count++;
                            }
                        }
                    }
                }
                for (int i = 0; i < shareHolderlist.size(); i++) {
                    ShareholderInfos share = shareHolderlist.get(i);
                    share.setFullReportId(fullReportId);
                    shareholderInfosDao.insert(share);
                }
            }

        } catch (Exception e) {
           // e.printStackTrace();
        }
    }

    public void SaveAssetsAnnual(FullReport report) {
        gldData = "";
        gldData = grandeInfoService.sendGLDOrgData(Tool.replaceSymbolCN(report.getNameCN()));
        JSONObject result = JSONObject.parseObject(gldData);
        JSONObject saxPublicInfoBean = result.getJSONObject("saxPublicInfoBean");
        //获取公司基本信息 取到crefoNo 用于关联企业信息
        int fullReportId = 0 ;
        if(null != report && null != report.getId()){
            fullReportId = report.getId();
        }
        //资产状况
        //先删除数据库已有的资产状况数据
        List<AssetsAnnual> assetsList = assetsAnnualDao.findByFullReportId(fullReportId);
        for (int i =0;i<assetsList.size();i++){
            assetsAnnualDao.deleteById(assetsList.get(i).getId());
        }
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray saxZCZKBeans = saxPublicInfoBean.getJSONArray("saxZCZKBeans");
            if (null!=saxZCZKBeans && saxZCZKBeans.size()>0) {
                for (int i = 0; i < saxZCZKBeans.size(); i++) {
                    JSONObject saxZCZKBeansobject = saxZCZKBeans.getJSONObject(i);
                    JSONObject industryStatusObject = saxZCZKBeansobject.getJSONObject("industryStatus");
                    String industryStatusStr = industryStatusObject.toJSONString();
                    industryStatusStr = industryStatusStr.replace("zcze", "totalAssets");//资产总额
                    industryStatusStr = industryStatusStr.replace("qyhj", "totalShareholdersEquity");//所有者权益合计
                    industryStatusStr = industryStatusStr.replace("yyzsr", "operatingProfit");//营业总收入
                    industryStatusStr = industryStatusStr.replace("lrze", "profitBeforeTax");//利润总额
                    industryStatusStr = industryStatusStr.replace("zyyw", "turnover");//营业总收入中主营业务收入
                    industryStatusStr = industryStatusStr.replace("jlr", "netIncome");//净利润
                    industryStatusStr = industryStatusStr.replace("nsze", "incomeTax");//纳税总额
                    industryStatusStr = industryStatusStr.replace("fzze", "totaLliabilities");//负债总额
                    AssetsAnnual assets = JSON.parseObject(industryStatusStr, AssetsAnnual.class);
                    assets.setYear(saxZCZKBeansobject.getString("bsrq"));
                    assets.setFullReportId(fullReportId);
                    assets.setUpdateTime(updatetime);
                    assetsAnnualDao.insert(assets);
                }
            }
        }


        //年报基本信息
        //先删除数据库已有的年报基本信息数据
        //todo
        List<BasicAnnua> basicList = baiscAnnuaDao.findByFullReportId(fullReportId);
        for (int i =0;i<basicList.size();i++){
            baiscAnnuaDao.deleteById(basicList.get(i).getId());
        }
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray saxNBQTBeans = saxPublicInfoBean.getJSONArray("saxNBQTBeans");
            if (null!=saxNBQTBeans && saxNBQTBeans.size()>0) {
                for (int i = 0; i < saxNBQTBeans.size(); i++) {
                    JSONObject saxNBQTBeansobject = saxNBQTBeans.getJSONObject(i);
                    JSONObject reportBaseStrObject = saxNBQTBeansobject.getJSONObject("reportBase");
                    String reportBaseStr = reportBaseStrObject.toJSONString();
                    reportBaseStr = reportBaseStr.replace("zch", "reg");//注册号
                    reportBaseStr = reportBaseStr.replace("qymc", "name");//企业名称
                    reportBaseStr = reportBaseStr.replace("lxdh", "tel");//企业联系电话
                    reportBaseStr = reportBaseStr.replace("yzbm", "zip");//邮政编码
                    reportBaseStr = reportBaseStr.replace("txdz", "address");//企业通信地址
                    reportBaseStr = reportBaseStr.replace("dzyx", "email");//电子邮箱
                    reportBaseStr = reportBaseStr.replace("gqzr", "equityTransfer");//有限责任公司本年度是否发生股东（发起人）股权转让
                    reportBaseStr = reportBaseStr.replace("qtgq", "isinvestment");//企业是否有投资信息或购买其他公司股权
                    reportBaseStr = reportBaseStr.replace("jyzt", "enterpriseStatus");//企业经营状态
                    reportBaseStr = reportBaseStr.replace("sfwd", "iswebsite");//是否有网站或网店
                    reportBaseStr = reportBaseStr.replace("cyrs", "employee");//从业人数
                    reportBaseStr = reportBaseStr.replace("sfdb", "isGuaranteeInfo");//是否有对外担保信息
                    reportBaseStr = reportBaseStr.replace("lsgx", "affiliation");//隶属关系
                    reportBaseStr = reportBaseStr.replace("jyzxm", "operateName");//经营者姓名
                    reportBaseStr = reportBaseStr.replace("zjse", "fundsMoney");//资金数额
                    BasicAnnua baiscAnnua = JSON.parseObject(reportBaseStr, BasicAnnua.class);
                    baiscAnnua.setYear(saxNBQTBeansobject.getString("bsrq"));
                    baiscAnnua.setFullReportId(fullReportId);
                    baiscAnnua.setUpdateTime(updatetime);
                    baiscAnnuaDao.insert(baiscAnnua);
                }
            }
        }


        JSONObject saxIprInfo = result.getJSONObject("saxIprInfo");
        //品牌专利
        //先删除数据库已有的品牌专利数据
        List<Brands> brandsList = brandsDao.findByFullReportId(fullReportId);
        for (int i =0;i<brandsList.size();i++){
            brandsDao.deleteById(brandsList.get(i).getId());
        }
        if (null!=saxIprInfo && saxIprInfo.size()>0) {
            JSONArray patentbeansArray = saxIprInfo.getJSONArray("patentbeans");
            if (null!=patentbeansArray && patentbeansArray.size()>0) {
                for (int i = 0; i < patentbeansArray.size(); i++) {
                    JSONObject patentbeansObj = patentbeansArray.getJSONObject(i);
                    String patentbeansStr = patentbeansObj.toJSONString();
                    patentbeansStr = patentbeansStr.replace("gkh", "releaseDate");//公开(公告)号
                    patentbeansStr = patentbeansStr.replace("zlmc", "patentName");//专利名称
                    patentbeansStr = patentbeansStr.replace("flh", "classificationNumber");//分类号
                    patentbeansStr = patentbeansStr.replace("zllx", "type");//专利类型(1.发明专利  2.实用新型专利  3.外观设计专利)
                    patentbeansStr = patentbeansStr.replace("gkr", "releaseDate");//公开(公告)日
                    patentbeansStr = patentbeansStr.replace("jlxz", "infoSource");//记录性质
                    patentbeansStr = patentbeansStr.replace("xxly", "equityTransfer");//信息来源
                    patentbeansStr = patentbeansStr.replace("lj", "link");//链接
                    patentbeansStr = patentbeansStr.replace("yxq", "priority");//优先权
                    patentbeansStr = patentbeansStr.replace("fmrmc", "inventorName");//发明人名称
                    patentbeansStr = patentbeansStr.replace("sqrq", "applicationDate");//申请日期
                    patentbeansStr = patentbeansStr.replace("sqr", "applyName");//申请人
                    patentbeansStr = patentbeansStr.replace("sqh", "applicationNumber");//申请号
                    patentbeansStr = patentbeansStr.replace("ajzt", "caseStatus");//案件状态
                    patentbeansStr = patentbeansStr.replace("dlxx", "proxyInfo");//代理信息
                    Brands brands = JSON.parseObject(patentbeansStr, Brands.class);
                    brands.setFullReportId(fullReportId);
                    brands.setUpdateTime(updatetime);
                    brandsDao.insert(brands);
                }
            }
        }


        //年报提供担保信息
        //先删除数据库已有的品牌专利数据
        List<GuaranteeAnnual> guaranList = guaranteeAnnualDao.findByFullReportId(fullReportId);
        for (int i =0;i<guaranList.size();i++){
            guaranteeAnnualDao.deleteById(guaranList.get(i).getId());
        }
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray saxNBQTBeans = saxPublicInfoBean.getJSONArray("saxNBQTBeans");
            if (null!=saxNBQTBeans && saxNBQTBeans.size()>0) {
                for (int i = 0; i < saxNBQTBeans.size(); i++) {
                    JSONObject saxNBQTBeansobject = saxNBQTBeans.getJSONObject(i);
                    JSONObject guaranteeListObject = saxNBQTBeansobject.getJSONObject("guaranteeList");
                    if (null!=guaranteeListObject && guaranteeListObject.size()>0) {
                        String guaranteeListStr = guaranteeListObject.toJSONString();
                        guaranteeListStr = guaranteeListStr.replace("zqr", "creditor");//债权人
                        guaranteeListStr = guaranteeListStr.replace("zwr", "debtor");//债务人
                        guaranteeListStr = guaranteeListStr.replace("zzqzl", "creditorType");//主债权种类
                        guaranteeListStr = guaranteeListStr.replace("zzqse", "creditorAmount");//主债权数额
                        guaranteeListStr = guaranteeListStr.replace("zwqx", "deadline");//履行债务的期限
                        guaranteeListStr = guaranteeListStr.replace("bzqj", "period");//保证的期间
                        guaranteeListStr = guaranteeListStr.replace("bzfsv", "manner");//保证的方式
                        guaranteeListStr = guaranteeListStr.replace("dbfw", "range");//保证担保的范围
                        GuaranteeAnnual guaranteeAnnual = JSON.parseObject(guaranteeListStr, GuaranteeAnnual.class);
                        guaranteeAnnual.setYear(saxNBQTBeansobject.getString("bsrq"));
                        guaranteeAnnual.setFullReportId(fullReportId);
                        guaranteeAnnual.setUpdateTime(updatetime);
                        guaranteeAnnualDao.insert(guaranteeAnnual);
                    }
                }
            }
        }
        //网站
        //先删除数据库已有的网站数据
        List<IcpWebsite> icpList = icpWebsiteDao.findByFullReportId(fullReportId);
        for (int i =0;i<icpList.size();i++){
            icpWebsiteDao.deleteById(icpList.get(i).getId());
        }
        if (null!=saxIprInfo && saxIprInfo.size()>0) {
            JSONArray websitebeansArray = saxIprInfo.getJSONArray("websitebeans");
            if (null!=websitebeansArray && websitebeansArray.size()>0) {
                for (int i = 0; i < websitebeansArray.size(); i++) {
                    JSONObject websitebeansObj = websitebeansArray.getJSONObject(i);
                    String websitebeansStr = websitebeansObj.toJSONString();
                    websitebeansStr = websitebeansStr.replace("wz", "website");//网址
                    websitebeansStr = websitebeansStr.replace("zcgb", "registerDifferentCountry");//注册国别
                    websitebeansStr = websitebeansStr.replace("wzzt", "websiteStatus");//网站状态
                    websitebeansStr = websitebeansStr.replace("wzmc", "websiteName");//网站名称
                    websitebeansStr = websitebeansStr.replace("dwmc", "organizerName");//主办单位名称
                    websitebeansStr = websitebeansStr.replace("dwxz", "organizerNature");//主办单位性质
                    websitebeansStr = websitebeansStr.replace("dwzl", "websiteSpecies");//网站种类
                    websitebeansStr = websitebeansStr.replace("ba", "licenseKey");//备案/许可证
                    websitebeansStr = websitebeansStr.replace("zcrm", "registerName");//注册人姓名
                    websitebeansStr = websitebeansStr.replace("lxdh", "contactTel");//联系电话
                    websitebeansStr = websitebeansStr.replace("lxdz", "contactAdd");//联系地址
                    websitebeansStr = websitebeansStr.replace("zcyx", "registerEmail");//注册邮箱
                    websitebeansStr = websitebeansStr.replace("ymmc", "domainAge");//域名年龄
                    websitebeansStr = websitebeansStr.replace("zcsj", "registrationTime");//注册时间
                    websitebeansStr = websitebeansStr.replace("dqsj", "maturityTime");//到期时间
                    websitebeansStr = websitebeansStr.replace("qtxx", "otherInfo");//其他信息
                    websitebeansStr = websitebeansStr.replace("xxly", "infoSource");//信息来源
                    websitebeansStr = websitebeansStr.replace("lj", "link");//链接
                    websitebeansStr = websitebeansStr.replace("hqrq", "getDate");//获取日期
                    websitebeansStr = websitebeansStr.replace("gxrq", "updDate");//更新日期
                    IcpWebsite icpWebsite = JSON.parseObject(websitebeansStr, IcpWebsite.class);
                    icpWebsite.setFullReportId(fullReportId);
                    icpWebsite.setUpdateTime(updatetime);
                    icpWebsiteDao.insert(icpWebsite);
                }
            }
        }
        //经营异常
        //先删除数据库已有的经营异常数据
        List<OperationAbnormalInfos> operationAbnormalInfosList = operationAbnormalInfosDao.findByFullReportId(fullReportId);
        if(null != operationAbnormalInfosList ){
            for (int i=0;i<operationAbnormalInfosList.size();i++){
                operationAbnormalInfosDao.deleteById(operationAbnormalInfosList.get(i).getId());
            }

        }
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONObject saxGSQTBean = saxPublicInfoBean.getJSONObject("saxGSQTBean");
            if (null!=saxGSQTBean && saxGSQTBean.size()>0) {
                JSONArray publicOrgBusinessAbnormityBeans = saxGSQTBean.getJSONArray("publicOrgBusinessAbnormityBeans");
                if (null!=publicOrgBusinessAbnormityBeans && publicOrgBusinessAbnormityBeans.size()>0) {
                    for (int i =0;i<publicOrgBusinessAbnormityBeans.size();i++){
                        JSONObject publicOrgBusinessAbnormityBeansObj = publicOrgBusinessAbnormityBeans.getJSONObject(i);
                        String publicOrgBusinessAbnormityBeansObjStr = publicOrgBusinessAbnormityBeansObj.toJSONString();
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("wz","website");//网址
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("zcgb","registerDifferentCountry");//注册国别
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("wzzt","websiteStatus");//网站状态
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("wzmc","websiteName");//网站名称
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("dwmc","organizerName");//主办单位名称
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("dwxz","organizerNature");//主办单位性质
                        OperationAbnormalInfos operationAbnormalInfos = JSON.parseObject(publicOrgBusinessAbnormityBeansObjStr,OperationAbnormalInfos.class);
                        operationAbnormalInfos.setFullReportId(fullReportId);
                        operationAbnormalInfos.setUpdateTime(updatetime);
                        operationAbnormalInfosDao.insert(operationAbnormalInfos);
                    }
                }
            }
        }

        //注册变更
        //先删除数据库已有的注册变更数据
        List<ChangeInfos> changeList = changeInfosDao.findByFullReportId(fullReportId);
        for (int i =0;i<changeList.size();i++){
            changeInfosDao.deleteById(changeList.get(i).getId());
        }
        if(null!=saxPublicInfoBean && saxPublicInfoBean.size()>0){
            JSONObject saxGSZMBean = saxPublicInfoBean.getJSONObject("saxGSZMBean");
            if (null!=saxGSZMBean && saxGSZMBean.size()>0){
                JSONArray publicOrgAlterationBeans = saxGSZMBean.getJSONArray("publicOrgAlterationBeans");
                if (null!=publicOrgAlterationBeans && publicOrgAlterationBeans.size()>0) {
                    for (int i =0;i<publicOrgAlterationBeans.size();i++){
                        JSONObject changeInfosBeansObj = publicOrgAlterationBeans.getJSONObject(i);
                        String changeInfosStr = changeInfosBeansObj.toJSONString();
                        changeInfosStr=changeInfosStr.replace("bgsx","changeType");//变更项目
                        changeInfosStr=changeInfosStr.replace("bgqnr","beforeCN");//变更前
                        changeInfosStr=changeInfosStr.replace("bghnr","afterCN");//变更后
                        changeInfosStr=changeInfosStr.replace("bgrq","changeDate");//变更日期
                        ChangeInfos changeInfos = JSON.parseObject(changeInfosStr,ChangeInfos.class);
                        String changeItem = changeInfosBeansObj.getString("bgsx");
                        if(null!=changeItem&&"一般经营项目变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(11);
                        }else if(null!=changeItem&&"许可经营项目变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(12);
                        }else if(null!=changeItem&&"经营范围变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营范围变更(含业务范围变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营期限(营业期限)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营范围(业务范围)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"住所变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"住所(营业场所地址)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"经营场所变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"地址变更(住所地址经营场所驻在地址等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"变更注册号".equals(changeItem)){
                            changeInfos.setCompanyTypeId(8);
                        }else if(null!=changeItem&&"公司名称变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(1);
                        }else if(null!=changeItem&&"法定代表人变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"法定代表人(负责人)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"法定代表人姓名".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"负责人变更(法定代表人负责人首席代表个体户经营者投资人合伙事务执行人等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"注册资本(金)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本(万元)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本(或外资中方认缴资本)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"投资总额变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本变更(注册资本注册资金成员出资总额等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"投资人(股权)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"企业类型变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(7);
                        }else if(null!=changeItem&&"组织机构变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"分支机构变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"经理备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"监事备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"章程备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"董事备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"章程修正案备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"其他变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"董事(理事)经理监事".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"行业代码变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"实收资本变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"境外股东发起人的境内".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"境外股东发起人的境内法律文件送达接受人备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"出资日期变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"高级管理人员备案(董事监事经理等)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"登记机关变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"有限公司股东或股份公司发起人名称变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else{
                            changeInfos.setCompanyTypeId(10);
                        }
                        changeInfos.setFullReportId(fullReportId);
                        changeInfos.setUpdateTime(updatetime);
                        changeInfosDao.insert(changeInfos);
                    }
                }
            }
        }


        List<EnterpriseShareholder> enterpriseShareholderlist = enterpriseShareholderDao.findByFullReportId(fullReportId);
        for(int i = 0;i<enterpriseShareholderlist.size();i++){
            EnterpriseShareholder enterpriseShareholder = enterpriseShareholderlist.get(i);
            enterpriseShareholderDao.deleteById(enterpriseShareholder.getId());
        }
        if (null!=saxPublicInfoBean&&saxPublicInfoBean.size()>0) {
            JSONArray saxGDCZBeans=saxPublicInfoBean.getJSONArray("saxGDCZBeans");
            for (int i = saxGDCZBeans.size()-1; i < saxGDCZBeans.size(); i++) {
                JSONObject info = saxGDCZBeans.getJSONObject(i);
                JSONArray enterpriseShareholderList = info.getJSONArray("enterpriseShareholderList");
                for (int j = 0; j < enterpriseShareholderList.size(); j++) {
                    JSONObject ent = enterpriseShareholderList.getJSONObject(j);
                    String entStr = ent.toJSONString();
                    entStr=entStr.replace("gd","shareNameCN");//股东
                    entStr=entStr.replace("sjczfs","paidInCapital");//实缴出资方式
                    entStr=entStr.replace("sjcze","paidInCapitalContribution");//实缴出资额
                    entStr=entStr.replace("sjczrq","paidInDate");//实缴出资日期
                    entStr=entStr.replace("rjczrq","subscriptionDate");//认缴出资日期
                    entStr=entStr.replace("rjczfs","subscribedInvestmentMethod");//认缴出资方式
                    entStr=entStr.replace("rjcze","subscribedCapitalContribution");//认缴出资额
                    entStr=entStr.replace("czbl","share");//出资比例
                    EnterpriseShareholder enterpriseShareholder = JSON.parseObject(entStr,EnterpriseShareholder.class);
                    if(null!=enterpriseShareholder.getPaidInCapitalContribution()&&!"".equals(enterpriseShareholder.getPaidInCapitalContribution())){
                        try{
                            enterpriseShareholder.setPaidInCapitalContribution(Tool.formatMoney(Tool.SetMoneyMultiplied(enterpriseShareholder.getPaidInCapitalContribution())));
                        }catch(Exception ex){}
                    }
                    if(null!=enterpriseShareholder.getSubscribedCapitalContribution()&&!"".equals(enterpriseShareholder.getSubscribedCapitalContribution())){
                        try{
                            enterpriseShareholder.setSubscribedCapitalContribution(Tool.formatMoney(Tool.SetMoneyMultiplied(enterpriseShareholder.getSubscribedCapitalContribution())));
                        }catch(Exception ex){}
                    }
                    enterpriseShareholder.setUpdateTime(updatetime);
                    enterpriseShareholder.setFullReportId(fullReportId);
                    enterpriseShareholderDao.insert(enterpriseShareholder);
                    //enterpriseShareholderlist.add(enterpriseShareholder);
                }
                //report.setEnterpriseShareholderList(enterpriseShareholderlist);
            }
        }

    }

    @Override
    public FullReport getGlobalReport(FullReport report) {
        gldData = "";
        gldData = grandeInfoService.sendGLDOrgData(Tool.replaceSymbolCN(report.getNameCN()));
        JSONObject result = JSONObject.parseObject(gldData);
        JSONObject saxPublicInfoBean = result.getJSONObject("saxPublicInfoBean");
        BasicInfos basics = new BasicInfos();
        //保存主表历史数据  如果查到有此公司 用来做修改操作
        BasicInfos historyBasic = new BasicInfos();
        if(null!=saxPublicInfoBean && saxPublicInfoBean.size()>0){
            JSONArray saxNBQTBeans = saxPublicInfoBean.getJSONArray("saxNBQTBeans");
            if (null!=saxNBQTBeans && saxNBQTBeans.size()>0) {
                //取年报最后一年
                for (int i = saxNBQTBeans.size()-1;i<saxNBQTBeans.size();i++){
                    JSONObject saxZCZKBeansobject = saxNBQTBeans.getJSONObject(i);
                    JSONObject reportBaseObject = saxZCZKBeansobject.getJSONObject("reportBase");
                    String reportBaseStr = reportBaseObject.toJSONString();
                    reportBaseStr=reportBaseStr.replace("zch","reg");//注册号
                    reportBaseStr=reportBaseStr.replace("qymc","nameCN");//企业名称
                    reportBaseStr=reportBaseStr.replace("lxdh","tel");//企业联系电话
                    reportBaseStr=reportBaseStr.replace("yzbm","managezip");//邮政编码
                    reportBaseStr=reportBaseStr.replace("txdz","streetCN");//企业通信地址
                    reportBaseStr=reportBaseStr.replace("dzyx","email");//电子邮箱
                    basics = JSON.parseObject(reportBaseStr,BasicInfos.class);
                }
            }
        }
        //企业年报信息
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray basicInfosArray = saxPublicInfoBean.getJSONArray("saxLLXXBeans");
            if (null!=basicInfosArray && basicInfosArray.size()>0) {
                for (int i = 0; i < basicInfosArray.size(); i++) {
                    JSONObject info = basicInfosArray.getJSONObject(i);
                    //取电话，邮箱，邮政编码，地址
                    JSONArray saxContactBeans = info.getJSONArray("saxContactBeans");
                    if (saxContactBeans.size() > 0) {
                        JSONObject saxContactBean = saxContactBeans.getJSONObject(saxContactBeans.size() - 1);
                        basics.setTel(getinfoData(saxContactBean, "dh"));
                        basics.setEmail(getinfoData(saxContactBean, "yx"));
                        basics.setZip(getinfoData(saxContactBean, "yzbm"));
                        basics.setStreetCN(getinfoData(saxContactBean, "dz"));
                    }
                    //取网址
                    try {
                        JSONArray websiteList = info.getJSONArray("webSiteList");
                        for (int j = 0; j < websiteList.size(); j++) {
                            JSONObject website = websiteList.getJSONObject(j);
                            basics.setWebsite(getinfoData(website, "wz"));
                        }
                    } catch (Exception e) {
                        // e.printStackTrace();
                    }
                }
            }
        }
        //防止格兰德没拿到数据 公司名没加入basics
        if(null!=basics && !"".equals(basics.getNameCN())){
            basics.setNameCN(Tool.replaceSymbol(basics.getNameCN()));
        }else{
            basics.setNameCN(report.getNameCN());
        }
        report.setBasicInfos(basics);


        //注册信息
        RegistrationInfos reg = new RegistrationInfos();
        List<BasicData> basicDataList = new ArrayList<BasicData>();
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONObject saxZCZKBeans = saxPublicInfoBean.getJSONObject("saxGSZMBean");
            if (null!=saxZCZKBeans && saxZCZKBeans.size()>0) {
                JSONObject publicOrgBaseBean = saxZCZKBeans.getJSONObject("publicOrgBaseBean");
                if (null!=publicOrgBaseBean && publicOrgBaseBean.size()>0) {
                    String publicOrgBaseBeanStr = publicOrgBaseBean.toJSONString();
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zch", "reg");//工商注册号
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("mc", "nameCN");//公司名称
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("lx", "entType");//企业类型
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("fddbr", "LegalNameCN");//法人
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zczb", "regCapital");//注册资本
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zcbz", "regCurrency");//注册资本币种
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("clrq", "establishDate");//注册日期
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("yycs", "streetCN");//经营地址
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("yyqxzh", "delistDate");//经营期限
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("jyfw", "businessScopeCN");//经营范围
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("djjg", "registrationCN");//注册机关
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("djzt", "entStatus");//企业状态
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("sfdm", "provinceCode");//注册省份代码
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("xydm", "creditcode");//统一征信代码
                    reg = JSON.parseObject(publicOrgBaseBeanStr, RegistrationInfos.class);
                    List<DataType> Currencylist = dataTypeService.findByCode("Currency");
                    Map<String,Object> params = new HashedMap();
                    params.put("dtid",Currencylist.get(0).getId());
                    params.put("delFlag","1");
                    if(null!=Currencylist && Currencylist.size()>0){
                        basicDataList = basicDateDao.listByDtidAndDelFlag(params);
                    }
                    reg.setRegCurrencyId(Tool.getIntRcid(basicDataList,Tool.getinfoData(publicOrgBaseBean,"zcbz")));
                    reg.setPaidCurrencyId(Tool.getIntRcid(basicDataList,Tool.getinfoData(publicOrgBaseBean,"zcbz")));
                    //判断企业类型和企业性质
                    RegistrationInfos  regs = Tool.TypeAndNature(reg.getCompanyType());
                    reg.setCompanyTypesId(regs.getCompanyTypesId());
                    reg.setCompanyPropertiesId(regs.getCompanyPropertiesId());
                    //判断企业状态
                    reg.setCompanyStatusId(Tool.EnterpriseStatus(reg.getCompanyStatus()));
                    //保存注册信息
                    reg.setCrefoNo(basics.getCrefoNo()+"");
                    report.setRegistrationInfos(reg);
                }
            }
        }
        List<Managements> managementList = new ArrayList<Managements>();
        //职务类型
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONObject saxGSZMBean = saxPublicInfoBean.getJSONObject("saxGSZMBean");
            if (null!=saxGSZMBean && saxGSZMBean.size()>0) {
                List<DataType> list = dataTypeService.findByCode("Post");
                basicDataList = new ArrayList<BasicData>();
                Map<String,Object> params = new HashedMap();
                params.put("dtid",list.get(0).getId());
                params.put("delFlag","1");
                if(null!=list && list.size()>0){
                    basicDataList = basicDateDao.listByDtidAndDelFlag(params);
                }
                JSONArray publicOrgStaffBeans = saxGSZMBean.getJSONArray("publicOrgStaffBeans");
                if (null!=publicOrgStaffBeans && publicOrgStaffBeans.size()>0) {
                    for (int i = 0; i < publicOrgStaffBeans.size(); i++) {
                        JSONObject saxZCZKBeansobject = publicOrgStaffBeans.getJSONObject(i);
                        String reportBaseStr = saxZCZKBeansobject.toJSONString();
                        reportBaseStr = reportBaseStr.replace("xm", "nameCN");//姓名
                        reportBaseStr = reportBaseStr.replace("zw", "position");//职务
                        int postion=0;
                        if(null!=saxZCZKBeansobject.getString("dutyInc")){
                            for (int j = 0; j < basicDataList.size(); j++) {
                                BasicData basicdata = basicDataList.get(j);
                                if(basicdata.getValueCN().equals(saxZCZKBeansobject.getString("dutyInc"))){
                                    postion = basicdata.getCode();
                                }
                            }
                        }
                        reportBaseStr = reportBaseStr.replace("zjhm", "cardID");//证件号
                        Managements managements = JSON.parseObject(reportBaseStr, Managements.class);
                        managements.setPostId(postion);
                        managementList.add(managements);
                    }
                }
            }
            report.setManagementsList(managementList);
        }
        List<MediaRecords> mediaRecordsList = new ArrayList<MediaRecords>();
        JSONArray saxNewsBeans = result.getJSONArray("saxNewsBeans");
        if (null!=saxNewsBeans && saxNewsBeans.size()>0) {
            for (int i = 0; i < saxNewsBeans.size(); i++) {
                JSONObject saxNewsBeansobject = saxNewsBeans.getJSONObject(i);
                String reportBaseStr = saxNewsBeansobject.toJSONString();
                reportBaseStr = reportBaseStr.replace("bt", "title");//标题
                reportBaseStr = reportBaseStr.replace("ly", "source");//来源
                reportBaseStr = reportBaseStr.replace("fbsj", "date");//发布时间
                reportBaseStr = reportBaseStr.replace("nr", "content");//内容
                reportBaseStr = reportBaseStr.replace("xxly", "source");//信息来源
                reportBaseStr = reportBaseStr.replace("lj", "link");//链接
                reportBaseStr = reportBaseStr.replace("hqrq", "getTime");//获取日期
                reportBaseStr = reportBaseStr.replace("gxrq", "updateTime");//更新日期
                MediaRecords mediaRecords = JSON.parseObject(reportBaseStr, MediaRecords.class);
                mediaRecordsList.add(mediaRecords);
            }
        }

        report.setMediaRecordsList(mediaRecordsList);
        List<ShareholderInfos> shareHolderlist = new ArrayList<ShareholderInfos>();
        //股东股权信息
        try {
            if(null!=saxPublicInfoBean){
                JSONObject saxGSZMBean = saxPublicInfoBean.getJSONObject("saxGSZMBean");
                JSONArray shareHolderArrays = saxGSZMBean.getJSONArray("shareholdersInfos");
                for (int i = 0; i < shareHolderArrays.size(); i++) {
                    JSONObject shareholdersInfosobject = shareHolderArrays.getJSONObject(i);
                    ShareholderInfos shareholderInfos = new ShareholderInfos();
                    String gdlx = getinfoData(shareholdersInfosobject, "gdlx");
                    if (null != gdlx && "企业法人".equals(gdlx)) {
                        shareholderInfos.setType("1");
                    } else if (null != gdlx && "自然人股东".equals(gdlx)) {
                        shareholderInfos.setType("0");
                    } else {
                        shareholderInfos.setType("3");
                    }
                    shareholderInfos.setNameCN(getinfoData(shareholdersInfosobject, "gd"));
                    String zjhm = getinfoData(shareholdersInfosobject, "zjhm");
                    shareholderInfos.setIdCard(getinfoData(shareholdersInfosobject, "zjhm"));
                    shareHolderlist.add(shareholderInfos);
                }
            }

            if (null!=saxPublicInfoBean&&saxPublicInfoBean.size()>0) {
                JSONArray shareHolderArray = saxPublicInfoBean.getJSONArray("saxGDCZBeans");
                List<ShareholderInfos> gdczlist = new ArrayList<ShareholderInfos>();
                Double rjCount = null;
                if (null != shareHolderArray) {
                    JSONObject obj = shareHolderArray.getJSONObject(shareHolderArray.size() - 1);
                    try {
                        JSONArray shareArr = obj.getJSONArray("enterpriseShareholderList");
                        for (int i = 0; i < shareArr.size(); i++) {
                            JSONObject shareObject = shareArr.getJSONObject(i);
                            ShareholderInfos share = new ShareholderInfos();
                            share.setRegCapital(shareObject.getString("rjcze"));
                            share.setNameCN(shareObject.getString("gd"));
                            gdczlist.add(share);
                        }
                    } catch (Exception e) {
                    }
                    Double gdRJ = null;
                    for (int i = 0; i < gdczlist.size(); i++) {
                        ShareholderInfos share = gdczlist.get(i);
                        gdRJ = null;
                        String share_regCapital = share.getRegCapital();
                        share_regCapital = share_regCapital.replace("元", "");
                        share_regCapital = share_regCapital.replace("人", "");
                        share_regCapital = share_regCapital.replace("民", "");
                        share_regCapital = share_regCapital.replace("美", "");
                        share_regCapital = share_regCapital.replace("币", "");
                        if (share_regCapital.contains("万")) {
                            share_regCapital = share_regCapital.replace("万", "");
                            gdRJ = Double.parseDouble(share_regCapital);
                        }else{
                            gdRJ = Double.parseDouble(share_regCapital);
                        }
                        if (null != share && null != share.getRegCapital() && !share.getRegCapital().equals("")) {
                            if (null == rjCount) {
                                rjCount = 0.0;
                                rjCount = gdRJ + rjCount;
                                share.setSubconam(gdRJ + "");
                            } else {
                                rjCount = gdRJ + rjCount;
                            }
                        }
                        gdczlist.set(i, share);
                    }
                    gdRJ = null;
                    for (ShareholderInfos sharePre : gdczlist) {
                        if (null != sharePre && null != sharePre.getRegCapital() && !sharePre.getRegCapital().equals("") && !sharePre.getRegCapital().equals("null")) {
                            String share_regCapital = sharePre.getRegCapital();
                            share_regCapital = share_regCapital.replace("元", "");
                            share_regCapital = share_regCapital.replace("人", "");
                            share_regCapital = share_regCapital.replace("民", "");
                            share_regCapital = share_regCapital.replace("美", "");
                            share_regCapital = share_regCapital.replace("币", "");
                            if (share_regCapital.contains("万")) {
                                share_regCapital = share_regCapital.replace("万", "");
                                gdRJ = Double.parseDouble(share_regCapital) * 10000;
                            }

                            gdRJ = Double.parseDouble(sharePre.getRegCapital());
                            Double rjShare = gdRJ / rjCount;
                            DecimalFormat myformat = new DecimalFormat("##0.00");
                            String rgShareResult = myformat.format(rjShare * 100);

                            int count = 0;
                            Boolean f = false;
                            for (ShareholderInfos shareBef : shareHolderlist) {
                                //只有一个股东不判断公司名
                                if (shareHolderlist.size() == 1) {
                                    shareBef.setRegCapital(new BigDecimal(gdRJ * 10000).toString());
                                    shareBef.setShares(rgShareResult);
                                    shareHolderlist.set(count, shareBef);
                                    f = true;
                                } else {
                                    if (null != sharePre.getNameCN() && !sharePre.getNameCN().equals("") && null != shareBef && null != shareBef.getNameCN() && !shareBef.getNameCN().equals("")) {
                                        if (shareBef.getNameCN().equals(sharePre.getNameCN())) {
                                            shareBef.setRegCapital(new BigDecimal(gdRJ * 10000).toString());
                                            shareBef.setShares(rgShareResult);
                                            shareHolderlist.set(count, shareBef);
                                            f = true;
                                        }
                                    }
                                }
                                if (f) {break;}
                                count++;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        report.setShareholderInfosList(shareHolderlist);
        List<AssetsAnnual> assetsAnnualList = new ArrayList<AssetsAnnual>();
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray saxZCZKBeans = saxPublicInfoBean.getJSONArray("saxZCZKBeans");
            if (null!=saxZCZKBeans && saxZCZKBeans.size()>0) {
                for (int i = 0; i < saxZCZKBeans.size(); i++) {
                    JSONObject saxZCZKBeansobject = saxZCZKBeans.getJSONObject(i);
                    JSONObject industryStatusObject = saxZCZKBeansobject.getJSONObject("industryStatus");
                    String industryStatusStr = industryStatusObject.toJSONString();
                    industryStatusStr = industryStatusStr.replace("zcze", "totalAssets");//资产总额
                    industryStatusStr = industryStatusStr.replace("qyhj", "totalShareholdersEquity");//所有者权益合计
                    industryStatusStr = industryStatusStr.replace("yyzsr", "operatingProfit");//营业总收入
                    industryStatusStr = industryStatusStr.replace("lrze", "profitBeforeTax");//利润总额
                    industryStatusStr = industryStatusStr.replace("zyyw", "turnover");//营业总收入中主营业务收入
                    industryStatusStr = industryStatusStr.replace("jlr", "netIncome");//净利润
                    industryStatusStr = industryStatusStr.replace("nsze", "incomeTax");//纳税总额
                    industryStatusStr = industryStatusStr.replace("fzze", "totaLliabilities");//负债总额
                    AssetsAnnual assets = JSON.parseObject(industryStatusStr, AssetsAnnual.class);
                    assets.setYear(saxZCZKBeansobject.getString("bsrq"));
                   report.setAssetsAnnualList(assetsAnnualList);
                }
            }
        }


        //年报基本信息
        //先删除数据库已有的年报基本信息数据
        List<BasicAnnua> baiscAnnuaList = new ArrayList<BasicAnnua>();
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray saxNBQTBeans = saxPublicInfoBean.getJSONArray("saxNBQTBeans");
            if (null!=saxNBQTBeans && saxNBQTBeans.size()>0) {
                for (int i = 0; i < saxNBQTBeans.size(); i++) {
                    JSONObject saxNBQTBeansobject = saxNBQTBeans.getJSONObject(i);
                    JSONObject reportBaseStrObject = saxNBQTBeansobject.getJSONObject("reportBase");
                    String reportBaseStr = reportBaseStrObject.toJSONString();
                    reportBaseStr = reportBaseStr.replace("zch", "reg");//注册号
                    reportBaseStr = reportBaseStr.replace("qymc", "name");//企业名称
                    reportBaseStr = reportBaseStr.replace("lxdh", "tel");//企业联系电话
                    reportBaseStr = reportBaseStr.replace("yzbm", "zip");//邮政编码
                    reportBaseStr = reportBaseStr.replace("txdz", "address");//企业通信地址
                    reportBaseStr = reportBaseStr.replace("dzyx", "email");//电子邮箱
                    reportBaseStr = reportBaseStr.replace("gqzr", "equityTransfer");//有限责任公司本年度是否发生股东（发起人）股权转让
                    reportBaseStr = reportBaseStr.replace("qtgq", "isinvestment");//企业是否有投资信息或购买其他公司股权
                    reportBaseStr = reportBaseStr.replace("jyzt", "entstatus");//企业经营状态
                    reportBaseStr = reportBaseStr.replace("sfwd", "iswebsite");//是否有网站或网店
                    reportBaseStr = reportBaseStr.replace("cyrs", "employee");//从业人数
                    reportBaseStr = reportBaseStr.replace("sfdb", "isGuaranteeInfo");//是否有对外担保信息
                    reportBaseStr = reportBaseStr.replace("lsgx", "affiliation");//隶属关系
                    reportBaseStr = reportBaseStr.replace("jyzxm", "operateName");//经营者姓名
                    reportBaseStr = reportBaseStr.replace("zjse", "fundsMoney");//资金数额
                    BasicAnnua baiscAnnua = JSON.parseObject(reportBaseStr, BasicAnnua.class);
                    baiscAnnua.setYear(saxNBQTBeansobject.getString("bsrq"));
                    baiscAnnuaList.add(baiscAnnua);
                    report.setBaiscAnnuaList(baiscAnnuaList);
                }
            }
        }


        JSONObject saxIprInfo = result.getJSONObject("saxIprInfo");
        List<Brands> brandsList = new ArrayList<Brands>();
        if (null!=saxIprInfo && saxIprInfo.size()>0) {
            JSONArray patentbeansArray = saxIprInfo.getJSONArray("patentbeans");
            if (null!=patentbeansArray && patentbeansArray.size()>0) {
                for (int i = 0; i < patentbeansArray.size(); i++) {
                    JSONObject patentbeansObj = patentbeansArray.getJSONObject(i);
                    String patentbeansStr = patentbeansObj.toJSONString();
                    patentbeansStr = patentbeansStr.replace("gkh", "releaseDate");//公开(公告)号
                    patentbeansStr = patentbeansStr.replace("zlmc", "patentName");//专利名称
                    patentbeansStr = patentbeansStr.replace("flh", "classificationNumber");//分类号
                    patentbeansStr = patentbeansStr.replace("zllx", "type");//专利类型(1.发明专利  2.实用新型专利  3.外观设计专利)
                    patentbeansStr = patentbeansStr.replace("gkr", "releaseDate");//公开(公告)日
                    patentbeansStr = patentbeansStr.replace("jlxz", "infoSource");//记录性质
                    patentbeansStr = patentbeansStr.replace("xxly", "equityTransfer");//信息来源
                    patentbeansStr = patentbeansStr.replace("lj", "link");//链接
                    patentbeansStr = patentbeansStr.replace("yxq", "priority");//优先权
                    patentbeansStr = patentbeansStr.replace("fmrmc", "inventorName");//发明人名称
                    patentbeansStr = patentbeansStr.replace("sqrq", "applicationDate");//申请日期
                    patentbeansStr = patentbeansStr.replace("sqr", "applyName");//申请人
                    patentbeansStr = patentbeansStr.replace("sqh", "applicationNumber");//申请号
                    patentbeansStr = patentbeansStr.replace("ajzt", "caseStatus");//案件状态
                    patentbeansStr = patentbeansStr.replace("dlxx", "proxyInfo");//代理信息
                    Brands brands = JSON.parseObject(patentbeansStr, Brands.class);
                    brandsList.add(brands);
                   report.setBrandsList(brandsList);
                }
            }
        }


        List<GuaranteeAnnual> guaranList = new ArrayList<GuaranteeAnnual>();
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray saxNBQTBeans = saxPublicInfoBean.getJSONArray("saxNBQTBeans");
            if (null!=saxNBQTBeans && saxNBQTBeans.size()>0) {
                for (int i = 0; i < saxNBQTBeans.size(); i++) {
                    JSONObject saxNBQTBeansobject = saxNBQTBeans.getJSONObject(i);
                    JSONObject guaranteeListObject = saxNBQTBeansobject.getJSONObject("guaranteeList");
                    if (null!=guaranteeListObject && guaranteeListObject.size()>0) {
                        String guaranteeListStr = guaranteeListObject.toJSONString();
                        guaranteeListStr = guaranteeListStr.replace("zqr", "creditor");//债权人
                        guaranteeListStr = guaranteeListStr.replace("zwr", "debtor");//债务人
                        guaranteeListStr = guaranteeListStr.replace("zzqzl", "creditorType");//主债权种类
                        guaranteeListStr = guaranteeListStr.replace("zzqse", "creditorAmount");//主债权数额
                        guaranteeListStr = guaranteeListStr.replace("zwqx", "deadline");//履行债务的期限
                        guaranteeListStr = guaranteeListStr.replace("bzqj", "period");//保证的期间
                        guaranteeListStr = guaranteeListStr.replace("bzfsv", "manner");//保证的方式
                        guaranteeListStr = guaranteeListStr.replace("dbfw", "range");//保证担保的范围
                        GuaranteeAnnual guaranteeAnnual = JSON.parseObject(guaranteeListStr, GuaranteeAnnual.class);
                        guaranteeAnnual.setYear(saxNBQTBeansobject.getString("bsrq"));
                        guaranList.add(guaranteeAnnual);
                        report.setGuaranteeAnnualList(guaranList);
                    }
                }
            }
        }
        List<IcpWebsite> icpList = new ArrayList<IcpWebsite>();
        if (null!=saxIprInfo && saxIprInfo.size()>0) {
            JSONArray websitebeansArray = saxIprInfo.getJSONArray("websitebeans");
            if (null!=websitebeansArray && websitebeansArray.size()>0) {
                for (int i = 0; i < websitebeansArray.size(); i++) {
                    JSONObject websitebeansObj = websitebeansArray.getJSONObject(i);
                    String websitebeansStr = websitebeansObj.toJSONString();
                    websitebeansStr = websitebeansStr.replace("wz", "website");//网址
                    websitebeansStr = websitebeansStr.replace("zcgb", "registerDifferentCountry");//注册国别
                    websitebeansStr = websitebeansStr.replace("wzzt", "websiteStatus");//网站状态
                    websitebeansStr = websitebeansStr.replace("wzmc", "websiteName");//网站名称
                    websitebeansStr = websitebeansStr.replace("dwmc", "organizerName");//主办单位名称
                    websitebeansStr = websitebeansStr.replace("dwxz", "organizerNature");//主办单位性质
                    websitebeansStr = websitebeansStr.replace("dwzl", "websiteSpecies");//网站种类
                    websitebeansStr = websitebeansStr.replace("ba", "licenseKey");//备案/许可证
                    websitebeansStr = websitebeansStr.replace("zcrm", "registerName");//注册人姓名
                    websitebeansStr = websitebeansStr.replace("lxdh", "contactTel");//联系电话
                    websitebeansStr = websitebeansStr.replace("lxdz", "contactAdd");//联系地址
                    websitebeansStr = websitebeansStr.replace("zcyx", "registerEmail");//注册邮箱
                    websitebeansStr = websitebeansStr.replace("ymmc", "domainAge");//域名年龄
                    websitebeansStr = websitebeansStr.replace("zcsj", "registrationTime");//注册时间
                    websitebeansStr = websitebeansStr.replace("dqsj", "maturityTime");//到期时间
                    websitebeansStr = websitebeansStr.replace("qtxx", "otherInfo");//其他信息
                    websitebeansStr = websitebeansStr.replace("xxly", "infoSource");//信息来源
                    websitebeansStr = websitebeansStr.replace("lj", "link");//链接
                    websitebeansStr = websitebeansStr.replace("hqrq", "getDate");//获取日期
                    websitebeansStr = websitebeansStr.replace("gxrq", "updDate");//更新日期
                    IcpWebsite icpWebsite = JSON.parseObject(websitebeansStr, IcpWebsite.class);
                    icpList.add(icpWebsite);
                    report.setIcpWebsiteList(icpList);
                }
            }
        }
        List<OperationAbnormalInfos> operationAbnormalInfosList = new ArrayList<OperationAbnormalInfos>();
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONObject saxGSQTBean = saxPublicInfoBean.getJSONObject("saxGSQTBean");
            if (null!=saxGSQTBean && saxGSQTBean.size()>0) {
                JSONArray publicOrgBusinessAbnormityBeans = saxGSQTBean.getJSONArray("publicOrgBusinessAbnormityBeans");
                if (null!=publicOrgBusinessAbnormityBeans && publicOrgBusinessAbnormityBeans.size()>0) {
                    for (int i =0;i<publicOrgBusinessAbnormityBeans.size();i++){
                        JSONObject publicOrgBusinessAbnormityBeansObj = publicOrgBusinessAbnormityBeans.getJSONObject(i);
                        String publicOrgBusinessAbnormityBeansObjStr = publicOrgBusinessAbnormityBeansObj.toJSONString();
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("wz","website");//网址
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("zcgb","registerDifferentCountry");//注册国别
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("wzzt","websiteStatus");//网站状态
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("wzmc","websiteName");//网站名称
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("dwmc","organizerName");//主办单位名称
                        publicOrgBusinessAbnormityBeansObjStr=publicOrgBusinessAbnormityBeansObjStr.replace("dwxz","organizerNature");//主办单位性质
                        OperationAbnormalInfos operationAbnormalInfos = JSON.parseObject(publicOrgBusinessAbnormityBeansObjStr,OperationAbnormalInfos.class);
                        operationAbnormalInfosList.add(operationAbnormalInfos);
                        report.setOperationAbnormalInfosList(operationAbnormalInfosList);
                    }
                }
            }
        }

        List<EnterpriseShareholder> enterpriseShareholderlist = new ArrayList<EnterpriseShareholder>();
        if(null!=saxPublicInfoBean){
            JSONArray saxGDCZBeans=saxPublicInfoBean.getJSONArray("saxGDCZBeans");
            for (int i = saxGDCZBeans.size()-1; i < saxGDCZBeans.size(); i++) {
                JSONObject info = saxGDCZBeans.getJSONObject(i);
                JSONArray enterpriseShareholderList = info.getJSONArray("enterpriseShareholderList");
                for (int j = 0; j < enterpriseShareholderList.size(); j++) {
                    JSONObject ent = enterpriseShareholderList.getJSONObject(j);
                    String entStr = ent.toJSONString();
                    entStr=entStr.replace("gd","shareNameCN");//股东
                    entStr=entStr.replace("sjczfs","paidInCapital");//实缴出资方式
                    entStr=entStr.replace("sjcze","paidInCapitalContribution");//实缴出资额
                    entStr=entStr.replace("sjczrq","paidInDate");//实缴出资日期
                    entStr=entStr.replace("rjczrq","subscriptionDate");//认缴出资日期
                    entStr=entStr.replace("rjczfs","subscribedInvestmentMethod");//认缴出资方式
                    entStr=entStr.replace("rjcze","subscribedCapitalContribution");//认缴出资额
                    entStr=entStr.replace("czbl","share");//出资比例
                    EnterpriseShareholder enterpriseShareholder = JSON.parseObject(entStr,EnterpriseShareholder.class);
                    if(null!=enterpriseShareholder.getPaidInCapitalContribution()&&!"".equals(enterpriseShareholder.getPaidInCapitalContribution())){
                        try{
                            enterpriseShareholder.setPaidInCapitalContribution(Tool.formatMoney(Tool.SetMoneyMultiplied(enterpriseShareholder.getPaidInCapitalContribution())));
                        }catch(Exception ex){}
                    }
                    if(null!=enterpriseShareholder.getSubscribedCapitalContribution()&&!"".equals(enterpriseShareholder.getSubscribedCapitalContribution())){
                        try{
                            enterpriseShareholder.setSubscribedCapitalContribution(Tool.formatMoney(Tool.SetMoneyMultiplied(enterpriseShareholder.getSubscribedCapitalContribution())));
                        }catch(Exception ex){}
                    }
                    enterpriseShareholderlist.add(enterpriseShareholder);
                }
                report.setEnterpriseShareholderList(enterpriseShareholderlist);
            }
        }









      /*  List<ChangeInfos> changeList = new ArrayList<ChangeInfos>();
        if(null!=saxPublicInfoBean && saxPublicInfoBean.size()>0){
            JSONObject saxGSZMBean = saxPublicInfoBean.getJSONObject("saxGSZMBean");
            if (null!=saxGSZMBean && saxGSZMBean.size()>0){
                JSONArray publicOrgAlterationBeans = saxGSZMBean.getJSONArray("publicOrgAlterationBeans");
                if (null!=publicOrgAlterationBeans && publicOrgAlterationBeans.size()>0) {
                    for (int i =0;i<publicOrgAlterationBeans.size();i++){
                        JSONObject changeInfosBeansObj = publicOrgAlterationBeans.getJSONObject(i);
                        String changeInfosStr = changeInfosBeansObj.toJSONString();
                        changeInfosStr=changeInfosStr.replace("bgsx","changeType");//变更项目
                        changeInfosStr=changeInfosStr.replace("bgqnr","beforeCN");//变更前
                        changeInfosStr=changeInfosStr.replace("bghnr","afterCN");//变更后
                        changeInfosStr=changeInfosStr.replace("bgrq","changeDate");//变更日期
                        ChangeInfos changeInfos = JSON.parseObject(changeInfosStr,ChangeInfos.class);
                        String changeItem = changeInfosBeansObj.getString("bgsx");
                        if(null!=changeItem&&"一般经营项目变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(11);
                        }else if(null!=changeItem&&"许可经营项目变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(12);
                        }else if(null!=changeItem&&"经营范围变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营范围变更(含业务范围变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营期限(营业期限)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营范围(业务范围)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"住所变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"住所(营业场所地址)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"经营场所变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"地址变更(住所地址经营场所驻在地址等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"变更注册号".equals(changeItem)){
                            changeInfos.setCompanyTypeId(8);
                        }else if(null!=changeItem&&"公司名称变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(1);
                        }else if(null!=changeItem&&"法定代表人变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"法定代表人(负责人)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"法定代表人姓名".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"负责人变更(法定代表人负责人首席代表个体户经营者投资人合伙事务执行人等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"注册资本(金)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本(万元)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本(或外资中方认缴资本)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"投资总额变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本变更(注册资本注册资金成员出资总额等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"投资人(股权)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"企业类型变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(7);
                        }else if(null!=changeItem&&"组织机构变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"分支机构变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"经理备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"监事备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"章程备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"董事备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"章程修正案备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"其他变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"董事(理事)经理监事".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"行业代码变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"实收资本变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"境外股东发起人的境内".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"境外股东发起人的境内法律文件送达接受人备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"出资日期变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"高级管理人员备案(董事监事经理等)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"登记机关变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"有限公司股东或股份公司发起人名称变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else{
                            changeInfos.setCompanyTypeId(10);
                        }
                        //全球鹰显示中文报告 格兰德变更记录
                        if(Tool.compare_date(changeInfos.getChangeDate(),"2012-12-31")){
                            changeList.add(changeInfos);
                        }
                    }
                }
            }
        }*/
        return report;
    }

    @Override
    public FullReport getGlobalRegReport(FullReport report) {
        gldData = "";
        gldData = grandeInfoService.sendGLDOrgData(Tool.replaceSymbolCN(report.getNameCN()));
        JSONObject result = JSONObject.parseObject(gldData);
        JSONObject saxPublicInfoBean = result.getJSONObject("saxPublicInfoBean");
        BasicInfos basics = new BasicInfos();
        if(null!=saxPublicInfoBean && saxPublicInfoBean.size()>0){
            JSONArray saxNBQTBeans = saxPublicInfoBean.getJSONArray("saxNBQTBeans");
            if (null!=saxNBQTBeans && saxNBQTBeans.size()>0) {
                //取年报最后一年
                for (int i = saxNBQTBeans.size()-1;i<saxNBQTBeans.size();i++){
                    JSONObject saxZCZKBeansobject = saxNBQTBeans.getJSONObject(i);
                    JSONObject reportBaseObject = saxZCZKBeansobject.getJSONObject("reportBase");
                    String reportBaseStr = reportBaseObject.toJSONString();
                    reportBaseStr=reportBaseStr.replace("zch","reg");//注册号
                    reportBaseStr=reportBaseStr.replace("qymc","nameCN");//企业名称
                    reportBaseStr=reportBaseStr.replace("lxdh","tel");//企业联系电话
                    reportBaseStr=reportBaseStr.replace("yzbm","managezip");//邮政编码
                    reportBaseStr=reportBaseStr.replace("txdz","streetCN");//企业通信地址
                    reportBaseStr=reportBaseStr.replace("dzyx","email");//电子邮箱
                    basics = JSON.parseObject(reportBaseStr,BasicInfos.class);
                }
            }
        }
        //企业年报信息
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONArray basicInfosArray = saxPublicInfoBean.getJSONArray("saxLLXXBeans");
            if (null!=basicInfosArray && basicInfosArray.size()>0) {
                for (int i = 0; i < basicInfosArray.size(); i++) {
                    JSONObject info = basicInfosArray.getJSONObject(i);
                    //取电话，邮箱，邮政编码，地址
                    JSONArray saxContactBeans = info.getJSONArray("saxContactBeans");
                    if (saxContactBeans.size() > 0) {
                        JSONObject saxContactBean = saxContactBeans.getJSONObject(saxContactBeans.size() - 1);
                        basics.setTel(getinfoData(saxContactBean, "dh"));
                        basics.setEmail(getinfoData(saxContactBean, "yx"));
                        basics.setZip(getinfoData(saxContactBean, "yzbm"));
                        basics.setStreetCN(getinfoData(saxContactBean, "dz"));
                    }
                    //取网址
                    try {
                        JSONArray websiteList = info.getJSONArray("webSiteList");
                        for (int j = 0; j < websiteList.size(); j++) {
                            JSONObject website = websiteList.getJSONObject(j);
                            basics.setWebsite(getinfoData(website, "wz"));
                        }
                    } catch (Exception e) {
                        // e.printStackTrace();
                    }
                }
            }
        }
        //防止格兰德没拿到数据 公司名没加入basics
        if(null!=basics && !"".equals(basics.getNameCN())){
            basics.setNameCN(Tool.replaceSymbol(basics.getNameCN()));
        }else{
            basics.setNameCN(report.getNameCN());
        }
        report.setBasicInfos(basics);

        //注册信息
        RegistrationInfos reg = new RegistrationInfos();
        List<BasicData> basicDataList = new ArrayList<BasicData>();
        if (null!=saxPublicInfoBean && saxPublicInfoBean.size()>0) {
            JSONObject saxZCZKBeans = saxPublicInfoBean.getJSONObject("saxGSZMBean");
            if (null!=saxZCZKBeans && saxZCZKBeans.size()>0) {
                JSONObject publicOrgBaseBean = saxZCZKBeans.getJSONObject("publicOrgBaseBean");
                if (null!=publicOrgBaseBean && publicOrgBaseBean.size()>0) {
                    String publicOrgBaseBeanStr = publicOrgBaseBean.toJSONString();
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zch", "reg");//工商注册号
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("mc", "nameCN");//公司名称
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("lx", "entType");//企业类型
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("fddbr", "LegalNameCN");//法人
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zczb", "regCapital");//注册资本
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("zcbz", "regCurrency");//注册资本币种
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("clrq", "establishDate");//注册日期
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("yycs", "streetCN");//经营地址
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("yyqxzh", "delistDate");//经营期限
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("jyfw", "businessScopeCN");//经营范围
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("djjg", "registrationCN");//注册机关
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("djzt", "entStatus");//企业状态
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("sfdm", "provinceCode");//注册省份代码
                    publicOrgBaseBeanStr = publicOrgBaseBeanStr.replace("xydm", "creditcode");//统一征信代码
                    reg = JSON.parseObject(publicOrgBaseBeanStr, RegistrationInfos.class);
                    List<DataType> Currencylist = dataTypeService.findByCode("Currency");
                    Map<String,Object> params = new HashedMap();
                    params.put("dtid",Currencylist.get(0).getId());
                    params.put("delFlag","1");
                    if(null!=Currencylist && Currencylist.size()>0){
                        basicDataList = basicDateDao.listByDtidAndDelFlag(params);
                    }
                    reg.setRegCurrencyId(Tool.getIntRcid(basicDataList,Tool.getinfoData(publicOrgBaseBean,"zcbz")));
                    reg.setPaidCurrencyId(Tool.getIntRcid(basicDataList,Tool.getinfoData(publicOrgBaseBean,"zcbz")));
                    //判断企业类型和企业性质
                    RegistrationInfos  regs = Tool.TypeAndNature(reg.getCompanyType());
                    reg.setCompanyTypesId(regs.getCompanyTypesId());
                    reg.setCompanyPropertiesId(regs.getCompanyPropertiesId());
                    //判断企业状态
                    reg.setCompanyStatusId(Tool.EnterpriseStatus(reg.getCompanyStatus()));
                    //保存注册信息
                    report.setRegistrationInfos(reg);
                }
            }
        }
        return report;
    }

    @Override
    public FullReport getGlobalChangeList(FullReport report) {

        gldData = "";
        gldData = grandeInfoService.sendGLDOrgData(Tool.replaceSymbolCN(report.getNameCN()));
        JSONObject result = JSONObject.parseObject(gldData);
        JSONObject saxPublicInfoBean = result.getJSONObject("saxPublicInfoBean");

        List<ChangeInfos> changeList = new ArrayList<ChangeInfos>();
        report.setChangeInfosList(changeList);
        if(null!=saxPublicInfoBean && saxPublicInfoBean.size()>0){
            JSONObject saxGSZMBean = saxPublicInfoBean.getJSONObject("saxGSZMBean");
            if (null!=saxGSZMBean && saxGSZMBean.size()>0){
                JSONArray publicOrgAlterationBeans = saxGSZMBean.getJSONArray("publicOrgAlterationBeans");
                if (null!=publicOrgAlterationBeans && publicOrgAlterationBeans.size()>0) {
                    for (int i =0;i<publicOrgAlterationBeans.size();i++){
                        JSONObject changeInfosBeansObj = publicOrgAlterationBeans.getJSONObject(i);
                        String changeInfosStr = changeInfosBeansObj.toJSONString();
                        changeInfosStr=changeInfosStr.replace("bgsx","changeType");//变更项目
                        changeInfosStr=changeInfosStr.replace("bgqnr","beforeCN");//变更前
                        changeInfosStr=changeInfosStr.replace("bghnr","afterCN");//变更后
                        changeInfosStr=changeInfosStr.replace("bgrq","changeDate");//变更日期
                        ChangeInfos changeInfos = JSON.parseObject(changeInfosStr,ChangeInfos.class);
                        String changeItem = changeInfosBeansObj.getString("bgsx");
                        if(null!=changeItem&&"一般经营项目变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(11);
                        }else if(null!=changeItem&&"许可经营项目变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(12);
                        }else if(null!=changeItem&&"经营范围变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营范围变更(含业务范围变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营期限(营业期限)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"经营范围(业务范围)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(9);
                        }else if(null!=changeItem&&"住所变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"住所(营业场所地址)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"经营场所变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"地址变更(住所地址经营场所驻在地址等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(6);
                        }else if(null!=changeItem&&"变更注册号".equals(changeItem)){
                            changeInfos.setCompanyTypeId(8);
                        }else if(null!=changeItem&&"公司名称变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(1);
                        }else if(null!=changeItem&&"法定代表人变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"法定代表人(负责人)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"法定代表人姓名".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"负责人变更(法定代表人负责人首席代表个体户经营者投资人合伙事务执行人等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(5);
                        }else if(null!=changeItem&&"注册资本(金)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本(万元)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本(或外资中方认缴资本)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"投资总额变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"注册资本变更(注册资本注册资金成员出资总额等变更)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"投资人(股权)变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(2);
                        }else if(null!=changeItem&&"企业类型变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(7);
                        }else if(null!=changeItem&&"组织机构变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"分支机构变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"经理备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"监事备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"章程备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"董事备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"章程修正案备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"其他变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"董事(理事)经理监事".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"行业代码变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"实收资本变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"境外股东发起人的境内".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"境外股东发起人的境内法律文件送达接受人备案".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"出资日期变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"高级管理人员备案(董事监事经理等)".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"登记机关变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else if(null!=changeItem&&"有限公司股东或股份公司发起人名称变更".equals(changeItem)){
                            changeInfos.setCompanyTypeId(0);
                        }else{
                            changeInfos.setCompanyTypeId(10);
                        }
                        //全球鹰显示中文报告 格兰德变更记录
                        if(Tool.compare_date(changeInfos.getChangeDate(),"2012-12-31")){
                            report.getChangeInfosList().add(changeInfos);
                           // changeList.add(changeInfos);
                        }
                    }
                }
            }
        }

        return report;
    }
}
