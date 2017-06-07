package com.mika.credit.facade.front.cn.parse.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.util.DateUtil;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.facade.front.cn.dao.*;
import com.mika.credit.facade.front.cn.parse.Qianhai;
import com.mika.credit.facade.front.cn.service.DataTypeService;
import com.mika.credit.facade.front.cn.service.QianHaiInfoService;
import com.mika.credit.facade.front.cn.util.Tool;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.mika.credit.facade.front.cn.util.Tool.*;

/**
 * Created by dell on 2017/2/23.
 */
@SuppressWarnings("Duplicates")
@Service("qianhai")
public class QianhaiImpl implements Qianhai {

    @Autowired
    BasicInfosDao basicInfosDao;
    @Autowired
    QianHaiInfoService qianHaiInfoService;
    @Autowired
    DataTypeService dataTypeService;
    @Autowired
    BasicDataDao basicDateDao;
    @Autowired
    FrpositioninfosDao frpositioninfosDao;
    @Autowired
    EntinvinfosDao entinvinfosDao;
    @Autowired
    FrinvinfosDao frinvinfosDao;
    @Autowired
    RegistrationInfosDao registrationInfosDao;
    @Autowired
    PenaltyHisDao penaltyHisDao;
    @Autowired
    SharePledgeHisDao sharePledgeHisDao;
    @Autowired
    ShareFrozenHisDao shareFrozenHisDao;
    @Autowired
    ShareholderInfosDao shareholderInfosDao;
    @Autowired
    ManagementsDao managementsDao;
    @Autowired
    FullReportDao fullReportDao;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String updatetime = format.format(new Date());

    @Value("${qianhaiInterface}")
    private String QIANHAIURL;

    @Override
    public void getQianhaiAllLIst(FullReport report) {
        List<BasicData> currencyList = new ArrayList<BasicData>();

        String gldData = "";
        gldData = qianHaiInfoService.sendQianHaiData(report.getNameCN(), "");
        FullReport fullReports = fullReportDao.findByName(report.getNameCN());
        Integer fullReportId = 0;
        if (null != fullReports && null != fullReports.getId() && "".equals(fullReports.getId())) {
            fullReportId = fullReports.getId();
        }
        JSONObject result = JSONObject.parseObject(gldData);
        JSONObject datajson = null;
        JSONObject json = JSONObject.parseObject(gldData);
        JSONArray basicList = json.getJSONArray("records");
        datajson = basicList.getJSONObject(0);


        //先删除注册信息
        RegistrationInfos hisReg = registrationInfosDao.findByFullReportId(fullReportId);
        if (null != hisReg && !"".equals(hisReg.getCrefoNo())) {
            registrationInfosDao.deleteById(fullReportId);
        }
        //注册信息
        RegistrationInfos reg = new RegistrationInfos();
        JSONObject info = datajson.getJSONObject("basicInc");
        //企业注册信息
        if (info != null) {
            //判断企业类型和企业性质
            if (isNull(getinfoData(info, "entType"))) {
                reg.setCompanyType(getinfoData(info, "entType"));
                int ctid = 0;
                int cpid = 0;
                reg = Tool.TypeAndNature(reg.getCompanyType());
                ctid = reg.getCompanyTypesId();
                cpid = reg.getCompanyTypesId();
                reg.setCompanyTypesId(ctid);
                reg.setCompanyPropertiesId(cpid);
            }
//				reg.setEntstatus(getinfoData(info,"runStatus"));//企业现状
            if (isNull(getinfoData(info, "runStatus"))) {
                reg.setCompanyStatus(getinfoData(info, "runStatus"));
                //判断企业状态
                int entstatus = 0;
                entstatus = Tool.EnterpriseStatus(reg.getCompanyStatus());
                reg.setCompanyStatusId(entstatus);
            }
            String regCapCur = "";
            if (null != getinfoData(info, "regCapCur") && !"".equals(getinfoData(info, "regCapCur"))) {
                regCapCur = getinfoData(info, "regCapCur");
                int rcid = getIntRcid(currencyList, regCapCur);
                reg.setRegCurrencyId(rcid);//注册币种
                reg.setPaidCurrencyId(rcid);//实收币种
            }
            if (isNull(getinfoData(info, "regCapAmt"))) {
                reg.setRegCapital(Tool.SetMoneyMultiplied_YearReport(getinfoData(info, "regCapAmt")));//注册资本
                if (null != reg.getRegCapital() && "0".equals(reg.getRegCapital())) {
                    reg.setRegCapital(null);
                    reg.setRegCurrencyId(null);//实收币种
                }
            }
            if (isNull(getinfoData(info, "fctCapAmt"))) {
                reg.setPaidCapital(Tool.SetMoneyMultiplied_YearReport(getinfoData(info, "fctCapAmt")));//实收资本
                if (null != reg.getPaidCapital() && "0".equals(reg.getPaidCapital())) {
                    reg.setPaidCapital(null);
                    reg.setPaidCurrencyId(null);//实收币种
                }
            }
            if (isNull(getinfoData(info, "coCode"))) {
                reg.setChnCode(getinfoData(info, "coCode"));
            }//行业代码
            reg.setChinaIndustrycode(getinfoData(info, "coCode") + " " + getinfoData(info, "coName"));
            if (isNull(getinfoData(info, "entOrgCode"))) {
                reg.setOrg(getinfoData(info, "entOrgCode"));
            }//组织结构代码
            if (isNull(getinfoData(info, "offAreaCode"))) {
                int provinceCode = 0;
                String offAreaCode = getinfoData(info, "offAreaCode");
                if (offAreaCode.length() > 2) {
                    String str = offAreaCode.substring(0, 2);
                    if (null != str && !"".equals(str)) {
                        provinceCode = Integer.parseInt(str);
                    }
                }
                reg.setProvinceCode(provinceCode);//省份代码
            }

            if (isNull(getinfoData(info, "address"))) {
                reg.setStreetCN(getinfoData(info, "address"));
            }//街道中文名称
            if (isNull(getinfoData(info, "regOrg"))) {
                reg.setRegistrationCN(getinfoData(info, "regOrg"));
            }//注册机构
            if (isNull(getinfoData(info, "regNo"))) {
                reg.setReg(getinfoData(info, "regNo"));
            }//注册号
            reg.setNameCN(getinfoData(info, "entName"));//公司名称
            if (isNull(getinfoData(info, "creditCode"))) {
                reg.setCreditCode(getinfoData(info, "creditCode"));
            }//信用代码
            if (isNull(getinfoData(info, "openDate"))) {
                reg.setEstablishDate(getinfoData(info, "openDate"));
            }//注册时间
            if (isNull(getinfoData(info, "runDateTo"))) {
                reg.setDeadline(getinfoData(info, "runDateTo"));
            }//经营期限
            if (isNull(getinfoData(info, "userName"))) {
                reg.setLegalNameCN(getinfoData(info, "userName"));
            }//法定代表人
            if (isNull(getinfoData(info, "busiScope1"))) {
                reg.setBusinessScopeCN(getinfoData(info, "busiScope1"));
            }//经营范围
            reg.setFullReportId(fullReportId);
        }
        reg.setUpdateTime(updatetime);
        registrationInfosDao.insert(reg);

        //股东及出资信息
        List<ShareholderInfos> ShareholderInfosList = shareholderInfosDao.findByFullReportId(fullReportId);
        for (int i = 0; i < ShareholderInfosList.size(); i++) {
            shareholderInfosDao.deleteById(ShareholderInfosList.get(i).getId());
        }
        List<ShareholderInfos> shareList = new ArrayList<ShareholderInfos>();
        List<DataType> dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //法人对外投资信息
        JSONArray sharehold = datajson.getJSONArray("holderInc");
        if (null != sharehold && sharehold.size() > 0) {
            //法人对外投资信息
            for (int i = 0; i < sharehold.size(); i++) {
                ShareholderInfos share = new ShareholderInfos();
                info = sharehold.getJSONObject(i);
                share.setNameCN(Tool.getinfoData(info, "userName"));//股东名称
                share.setCountryCN(Tool.getinfoData(info, "conType"));//国别
                share.setContributionDate(Tool.getinfoData(info, "conDate"));//出资日期
                share.setContributionFrom(Tool.getinfoData(info, "conMthd"));//出资方式
                share.setSubconam(Tool.getinfoData(info, "subAmt"));//认缴出资额(万元)
                share.setCurrency(Tool.getinfoData(info, "subCur"));//认缴出资币种
                //判断注册币种
                if (null != share.getCurrency() && !"".equals(share.getCurrency().trim())) {
                    share.setContributionId(getIntRcid(currencyList, share.getCurrency()));
                }
                share.setShares(Tool.getinfoData(info, "conRate"));//出资比例
                share.setFullReportId(fullReportId);
                share.setUpdateTime(updatetime);
                shareholderInfosDao.insert(share);
                shareList.add(share);
            }
        }


        //主要管理人员信息
        List<Managements> managementsList = managementsDao.findByFullReportId(fullReportId);
        for (int i = 0; i < managementsList.size(); i++) {
            managementsDao.deleteById(managementsList.get(i).getId());
        }
        List<Managements> managementList = new ArrayList<Managements>();
        dataTypeList = dataTypeService.findByCode("Post");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //法人对外投资信息
        JSONArray manager = datajson.getJSONArray("mgrPersonInc");
        if (null != manager && manager.size() > 0) {
            //法人对外投资信息
            for (int i = 0; i < manager.size(); i++) {
                Managements manage = new Managements();
                info = manager.getJSONObject(i);
                manage.setNameCN(Tool.getinfoData(info, "userName"));//人员姓名
                manage.setPosition(Tool.getinfoData(info, "dutyInc"));//职务
                int postion = 0;
                if (null != manage.getPosition()) {
                    for (int j = 0; j < currencyList.size(); j++) {
                        BasicData basicdata = currencyList.get(j);
                        if (basicdata.getValueCN().equals(manage.getPosition())) {
                            postion = basicdata.getCode();
                        }
                    }
                }
                manage.setGender(Tool.getinfoData(info, "sex"));//性别
                //判断管理员性别
                if (null != manage.getGender() && "男".equals(manage.getGender().trim())) {
                    manage.setGender("0");
                } else if (null != manage.getGender() && "女".equals(manage.getGender().trim())) {
                    manage.setGender("1");
                } else {
                    manage.setGender("2");
                }
                manage.setPostId(postion);
                manage.setFullReportId(fullReportId);
                manage.setUpdateTime(updatetime);
                managementsDao.insert(manage);
                managementList.add(manage);
            }

        }


        //法人对外投资
        List<Frinvinfos> frinvinfosList = frinvinfosDao.findByFullReportId(fullReportId);
        for (int i = 0; i < frinvinfosList.size(); i++) {
            frinvinfosDao.deleteById(frinvinfosList.get(i).getId());
        }
        List<Frinvinfos> frinvList = new ArrayList<Frinvinfos>();
        dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //法人对外投资信息
        JSONArray frinv = datajson.getJSONArray("legInvstInc");
        if (null != frinv && frinv.size() > 0) {
            //法人对外投资信息
            for (int i = 0; i < frinv.size(); i++) {
                Frinvinfos frin = new Frinvinfos();
                info = frinv.getJSONObject(i);
                frin.setConfrom(Tool.getinfoData(info, "capMthd"));
                frin.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                frin.setEsDate(Tool.getinfoData(info, "openDate"));
                frin.setRegCapitalCurrency(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != frin.getRegCapitalCurrency() && !"".equals(frin.getRegCapitalCurrency().trim())) {
                    frin.setRegCapitalCurrency(getIntRcid(currencyList, frin.getRegCapitalCurrency()).toString());
                }
                frin.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                frin.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                int Status = 0;
                Status = Tool.EnterpriseStatus(frin.getEnterpriseStatus());
                frin.setEnterpriseStatus(Status + "");
                frin.setNameCN(Tool.getinfoData(info, "frName"));
                frin.setRevDate(Tool.getinfoData(info, "revokeDate"));
                frin.setCurrency(Tool.getinfoData(info, "subCapCur"));
                //判断注册币种
                if (null != frin.getCurrency() && !"".equals(frin.getCurrency().trim())) {
                    frin.setCurrency(getIntRcid(currencyList, frin.getCurrency()).toString());
                }
                frin.setSubconam(Tool.getinfoData(info, "subCapAmt"));
                if (null != frin.getSubconam() && !"".equals(frin.getSubconam().trim())) {
                    frin.setSubconam(Tool.SetMoneyMultiplied_YearReport(frin.getSubconam()));
                }
                frin.setFundedRatio(Tool.getinfoData(info, "capRate"));
                frin.setCancelDate(Tool.getinfoData(info, "canDate"));
                frin.setEnterpriseType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                int EntType = 0;
                EntType = Tool.TypeAndNatureOfBusiness(frin.getEnterpriseType());
                frin.setEnterpriseType(EntType + "");
                frin.setRegNo(Tool.getinfoData(info, "regNo"));
                frin.setRegCapital(Tool.getinfoData(info, "regCapAmt"));
                if (null != frin.getRegCapital() && !"".equals(frin.getRegCapital().trim())) {
                    frin.setRegCapital(Tool.SetMoneyMultiplied_YearReport(frin.getRegCapital()));
                }
                frin.setDelFlag("1");
                frin.setFullReportId(fullReportId);
                frin.setUpdateTime(updatetime);
                frinvinfosDao.insert(frin);
                frinvList.add(frin);
            }
        }


        //企业对外投资信息
        List<Entinvinfos> entinvinfosList = entinvinfosDao.findByFullReportId(fullReportId);
        for (int i = 0; i < entinvinfosList.size(); i++) {
            entinvinfosDao.deleteById(entinvinfosList.get(i).getId());
        }
        List<Entinvinfos> entList = new ArrayList<Entinvinfos>();
        dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }

        //企业对外投资信息
        JSONArray entinv = datajson.getJSONArray("entInvstInc");
        if (null != entinv && entinv.size() > 0) {
            //企业对外投资信息
            for (int i = 0; i < entinv.size(); i++) {
                Entinvinfos ent = new Entinvinfos();
                info = entinv.getJSONObject(i);
                ent.setConfrom(Tool.getinfoData(info, "capMthd"));
                ent.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                ent.setEsDate(Tool.getinfoData(info, "openDate"));
                ent.setRegCapCur(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != ent.getRegCapCur() && !"".equals(ent.getRegCapCur().trim())) {
                    ent.setRegCapCur(getIntRcid(currencyList, ent.getRegCapCur()).toString());
                }
                ent.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                ent.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                int Status = 0;
                Status = Tool.EnterpriseStatus(ent.getEnterpriseStatus());
                ent.setEnterpriseStatus(Status + "");
                ent.setNameCN("");
                ent.setRevDate(Tool.getinfoData(info, "revokeDate"));
                ent.setCurrency(Tool.getinfoData(info, "subCapCur"));
                if (null != ent.getCurrency() && !"".equals(ent.getCurrency().trim())) {
                    ent.setCurrency(getIntRcid(currencyList, ent.getCurrency()).toString());
                }
                ent.setSubconam(Tool.getinfoData(info, "subCapAmt"));
                if (null != ent.getSubconam() && !"".equals(ent.getSubconam().trim())) {
                    ent.setSubconam(Tool.SetMoneyMultiplied_YearReport(ent.getSubconam()));
                }
                ent.setFundedRatio(Tool.getinfoData(info, "capRate"));
                ent.setCanDate(Tool.getinfoData(info, "canDate"));
                ent.setEntType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                int EntType = 0;
                EntType = Tool.TypeAndNatureOfBusiness(ent.getEntType());
                ent.setEntType(EntType + "");
                ent.setRegNo(Tool.getinfoData(info, "regNo"));
                ent.setRegCap(Tool.getinfoData(info, "regCapAmt"));
                if (null != ent.getRegCap() && !"".equals(ent.getRegCap().trim())) {
                    ent.setRegCap(Tool.SetMoneyMultiplied_YearReport(ent.getRegCap()));
                }
                ent.setDelFlag("1");
                ent.setFullReportId(fullReportId);
                ent.setUpdateTime(updatetime);
                entinvinfosDao.insert(ent);
                entList.add(ent);
            }
        }

        //法人其他任职信息
        List<Frpositioninfos> frpositioninfosList = frpositioninfosDao.findByFullReportId(fullReportId);
        for (int i = 0; i < frpositioninfosList.size(); i++) {
            frpositioninfosDao.deleteById(frpositioninfosList.get(i).getId());
        }
        List<Frpositioninfos> frpositionList = new ArrayList<Frpositioninfos>();
        dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //法人其他任职信息
        JSONArray frposition = datajson.getJSONArray("legOtherDutyInc");
        if (null != frposition && frposition.size() > 0) {
            //法人其他任职信息
            for (int i = 0; i < frposition.size(); i++) {
                Frpositioninfos frposit = new Frpositioninfos();
                info = frposition.getJSONObject(i);
                frposit.setPosition(Tool.getinfoData(info, "dutyInc"));
                frposit.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                frposit.setEsDate(Tool.getinfoData(info, "openDate"));
                frposit.setRegCapitalCurrency(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != frposit.getRegCapitalCurrency() && !"".equals(frposit.getRegCapitalCurrency().trim())) {
                    frposit.setRegCapitalCurrency(getIntRcid(currencyList, frposit.getRegCapitalCurrency()).toString());
                }
                frposit.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                frposit.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                int Status = 0;
                Status = Tool.EnterpriseStatus(frposit.getEnterpriseStatus());
                frposit.setEnterpriseStatus(Status + "");
                frposit.setNameCN(Tool.getinfoData(info, "frName"));
                frposit.setRevDate(Tool.getinfoData(info, "revokeDate"));
                frposit.setCancelDate(Tool.getinfoData(info, "canDate"));
                frposit.setEnterpriseType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                int EntType = 0;
                EntType = Tool.TypeAndNatureOfBusiness(frposit.getEnterpriseType());
                frposit.setEnterpriseType(EntType + "");
                frposit.setRegNo(Tool.getinfoData(info, "regNo"));
                frposit.setRegCapital(Tool.getinfoData(info, "regCapAmt"));
                if (null != frposit.getRegCapital() && !"".equals(frposit.getRegCapital().trim())) {
                    frposit.setRegCapital(Tool.SetMoneyMultiplied_YearReport(frposit.getRegCapital()));
                }
                frposit.setDelFlag("1");
                frposit.setFullReportId(fullReportId);
                frposit.setUpdateTime(updatetime);
                frpositioninfosDao.insert(frposit);
                frpositionList.add(frposit);

            }
        }

        //工商行政处罚记录
        //查询出表中所有内容
        List<PenaltyHis> penaltyHisList = penaltyHisDao.findByFullReportId(fullReportId);
        for (int i = 0; i < penaltyHisList.size(); i++) {
            //循环删除表中的所有内容
            penaltyHisDao.deleteById(fullReportId);
        }
        JSONArray penaltyHisArray = datajson.getJSONArray("penaltyHis");
        if (null != penaltyHisArray && penaltyHisArray.size() > 0) {
            for (int i = 0; i < penaltyHisArray.size(); i++) {
                PenaltyHis penaltyHis = new PenaltyHis();
                info = penaltyHisArray.getJSONObject(i);
                penaltyHis = JSON.parseObject(info.toString(), PenaltyHis.class);
                penaltyHis.setFullReportId(fullReportId);
                penaltyHis.setUpdateTime(updatetime);
                penaltyHisDao.insert(penaltyHis);
            }
        }


        //股权出质记录
        //查询出表中所有内容
        List<SharePledgeHis> sharePledgeHisList = sharePledgeHisDao.findByFullReportId(fullReportId);
        for (int i = 0; i < sharePledgeHisList.size(); i++) {
            //循环删除表中的所有内容
            sharePledgeHisDao.deleteById(sharePledgeHisList.get(i).getId());
        }

        JSONArray sharePledgeHisArray = datajson.getJSONArray("sharePledgeHis");
        if (null != sharePledgeHisArray && sharePledgeHisArray.size() > 0) {
            for (int i = 0; i < sharePledgeHisArray.size(); i++) {
                SharePledgeHis sharePledgeHis = new SharePledgeHis();
                info = sharePledgeHisArray.getJSONObject(i);
                sharePledgeHis = JSON.parseObject(info.toString(), SharePledgeHis.class);
                sharePledgeHis.setFullReportId(fullReportId);
                sharePledgeHisDao.insert(sharePledgeHis);
            }
        }


        //股权冻结记录
        // 查询出表中所有内容
        List<ShareFrozenHis> shareFrozenHisList = shareFrozenHisDao.findByFullReportId(fullReportId);
        for (int i = 0; i < shareFrozenHisList.size(); i++) {
            //循环删除表中的所有内容
            shareFrozenHisDao.deleteById(shareFrozenHisList.get(i).getId());
        }

        JSONArray shareFrozenHisArray = datajson.getJSONArray("shareFrozenHis");
        if (null != shareFrozenHisArray && shareFrozenHisArray.size() > 0) {
            for (int i = 0; i < shareFrozenHisArray.size(); i++) {
                ShareFrozenHis shareFrozenHis = new ShareFrozenHis();
                info = shareFrozenHisArray.getJSONObject(i);
                shareFrozenHis = JSON.parseObject(info.toString(), ShareFrozenHis.class);
                shareFrozenHis.setFullReportId(fullReportId);
                shareFrozenHis.setUpdateTime(updatetime);
                shareFrozenHisDao.insert(shareFrozenHis);
            }
        }
    }

    @Override
    public void getQianhaiLIst(FullReport report) {
        List<BasicData> currencyList = new ArrayList<BasicData>();
        String gldData = "";
        try {
            gldData = qianHaiInfoService.sendQianHaiData(URLEncoder.encode(report.getNameCN(), "utf-8"), "");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONObject result = JSONObject.parseObject(gldData);
        FullReport fullReports = fullReportDao.findByName(report.getNameCN());
        Integer fullReportId = 0;
        if (null != fullReports && null != fullReports.getId() && "".equals(fullReports.getId())) {
            fullReportId = fullReports.getId();
        }
        JSONObject datajson = null;
        JSONObject json = JSONObject.parseObject(gldData);
        JSONArray basicList = json.getJSONArray("records");
        datajson = basicList.getJSONObject(0);

        JSONObject info = datajson.getJSONObject("basicInc");

        //股东及出资信息
        List<ShareholderInfos> ShareholderInfosList = shareholderInfosDao.findByFullReportId(fullReportId);
        for (int i = 0; i < ShareholderInfosList.size(); i++) {
            shareholderInfosDao.deleteById(ShareholderInfosList.get(i).getId());
        }
        List<ShareholderInfos> shareList = new ArrayList<ShareholderInfos>();
        List<DataType> dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //法人对外投资信息
        JSONArray sharehold = datajson.getJSONArray("holderInc");
        if (null != sharehold && sharehold.size() > 0) {
            //法人对外投资信息
            for (int i = 0; i < sharehold.size(); i++) {
                ShareholderInfos share = new ShareholderInfos();
                info = sharehold.getJSONObject(i);
                share.setNameCN(Tool.getinfoData(info, "userName"));//股东名称
                share.setCountryCN(Tool.getinfoData(info, "conType"));//国别
                share.setContributionDate(Tool.getinfoData(info, "conDate"));//出资日期
                share.setContributionFrom(Tool.getinfoData(info, "conMthd"));//出资方式
                share.setSubconam(Tool.getinfoData(info, "subAmt"));//认缴出资额(万元)
                share.setCurrency(Tool.getinfoData(info, "subCur"));//认缴出资币种
                //判断注册币种
                if (null != share.getCurrency() && !"".equals(share.getCurrency().trim())) {
                    share.setContributionId(getIntRcid(currencyList, share.getCurrency()));
                }
                share.setShares(Tool.getinfoData(info, "conRate"));//出资比例
                share.setFullReportId(fullReportId);
                share.setUpdateTime(updatetime);
                shareholderInfosDao.insert(share);
                shareList.add(share);
            }
        }

        //法人对外投资
        List<Frinvinfos> frinvinfosList = frinvinfosDao.findByFullReportId(fullReportId);
        for (int i = 0; i < frinvinfosList.size(); i++) {
            frinvinfosDao.deleteById(frinvinfosList.get(i).getId());
        }
        List<Frinvinfos> frinvList = new ArrayList<Frinvinfos>();
        dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //法人对外投资信息
        JSONArray frinv = datajson.getJSONArray("legInvstInc");
        if (null != frinv && frinv.size() > 0) {
            //法人对外投资信息
            for (int i = 0; i < frinv.size(); i++) {
                Frinvinfos frin = new Frinvinfos();
                info = frinv.getJSONObject(i);
                frin.setConfrom(Tool.getinfoData(info, "capMthd"));
                frin.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                frin.setEsDate(Tool.getinfoData(info, "openDate"));
                frin.setRegCapitalCurrency(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != frin.getRegCapitalCurrency() && !"".equals(frin.getRegCapitalCurrency().trim())) {
                    frin.setRegCapitalCurrency(getIntRcid(currencyList, frin.getRegCapitalCurrency()).toString());
                }
                frin.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                frin.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                int Status = 0;
                Status = Tool.EnterpriseStatus(frin.getEnterpriseStatus());
                frin.setEnterpriseStatus(Status + "");
                frin.setNameCN(Tool.getinfoData(info, "frName"));
                frin.setRevDate(Tool.getinfoData(info, "revokeDate"));
                frin.setCurrency(Tool.getinfoData(info, "subCapCur"));
                //判断注册币种
                if (null != frin.getCurrency() && !"".equals(frin.getCurrency().trim())) {
                    frin.setCurrency(getIntRcid(currencyList, frin.getCurrency()).toString());
                }
                frin.setSubconam(Tool.getinfoData(info, "subCapAmt"));
                if (null != frin.getSubconam() && !"".equals(frin.getSubconam().trim())) {
                    frin.setSubconam(Tool.SetMoneyMultiplied_YearReport(frin.getSubconam()));
                }
                frin.setFundedRatio(Tool.getinfoData(info, "capRate"));
                frin.setCancelDate(Tool.getinfoData(info, "canDate"));
                frin.setEnterpriseType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                int EntType = 0;
                EntType = Tool.TypeAndNatureOfBusiness(frin.getEnterpriseType());
                frin.setEnterpriseType(EntType + "");
                frin.setRegNo(Tool.getinfoData(info, "regNo"));
                frin.setRegCapital(Tool.getinfoData(info, "regCapAmt"));
                if (null != frin.getRegCapital() && !"".equals(frin.getRegCapital().trim())) {
                    frin.setRegCapital(Tool.SetMoneyMultiplied_YearReport(frin.getRegCapital()));
                }
                frin.setDelFlag("1");
                frin.setFullReportId(fullReportId);
                frin.setUpdateTime(updatetime);
                frinvinfosDao.insert(frin);
                frinvList.add(frin);
            }
        }


        //企业对外投资信息
        List<Entinvinfos> entinvinfosList = entinvinfosDao.findByFullReportId(fullReportId);
        for (int i = 0; i < entinvinfosList.size(); i++) {
            entinvinfosDao.deleteById(entinvinfosList.get(i).getId());
        }
        List<Entinvinfos> entList = new ArrayList<Entinvinfos>();
        dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }

        //企业对外投资信息
        JSONArray entinv = datajson.getJSONArray("entInvstInc");
        if (null != entinv && entinv.size() > 0) {
            //企业对外投资信息
            for (int i = 0; i < entinv.size(); i++) {
                Entinvinfos ent = new Entinvinfos();
                info = entinv.getJSONObject(i);
                ent.setConfrom(Tool.getinfoData(info, "capMthd"));
                ent.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                ent.setEsDate(Tool.getinfoData(info, "openDate"));
                ent.setRegCapCur(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != ent.getRegCapCur() && !"".equals(ent.getRegCapCur().trim())) {
                    ent.setRegCapCur(getIntRcid(currencyList, ent.getRegCapCur()).toString());
                }
                ent.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                ent.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                int Status = 0;
                Status = Tool.EnterpriseStatus(ent.getEnterpriseStatus());
                ent.setEnterpriseStatus(Status + "");
                ent.setNameCN("");
                ent.setRevDate(Tool.getinfoData(info, "revokeDate"));
                ent.setCurrency(Tool.getinfoData(info, "subCapCur"));
                if (null != ent.getCurrency() && !"".equals(ent.getCurrency().trim())) {
                    ent.setCurrency(getIntRcid(currencyList, ent.getCurrency()).toString());
                }
                ent.setSubconam(Tool.getinfoData(info, "subCapAmt"));
                if (null != ent.getSubconam() && !"".equals(ent.getSubconam().trim())) {
                    ent.setSubconam(Tool.SetMoneyMultiplied_YearReport(ent.getSubconam()));
                }
                ent.setFundedRatio(Tool.getinfoData(info, "capRate"));
                ent.setCanDate(Tool.getinfoData(info, "canDate"));
                ent.setEntType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                int EntType = 0;
                EntType = Tool.TypeAndNatureOfBusiness(ent.getEntType());
                ent.setEntType(EntType + "");
                ent.setRegNo(Tool.getinfoData(info, "regNo"));
                ent.setRegCap(Tool.getinfoData(info, "regCapAmt"));
                if (null != ent.getRegCap() && !"".equals(ent.getRegCap().trim())) {
                    ent.setRegCap(Tool.SetMoneyMultiplied_YearReport(ent.getRegCap()));
                }
                ent.setDelFlag("1");
                ent.setFullReportId(fullReportId);
                ent.setUpdateTime(updatetime);
                entinvinfosDao.insert(ent);
                entList.add(ent);
            }
        }

        //法人其他任职信息
        List<Frpositioninfos> frpositioninfosList = frpositioninfosDao.findByFullReportId(fullReportId);
        for (int i = 0; i < frpositioninfosList.size(); i++) {
            frpositioninfosDao.deleteById(frpositioninfosList.get(i).getId());
        }
        List<Frpositioninfos> frpositionList = new ArrayList<Frpositioninfos>();
        dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //法人其他任职信息
        JSONArray frposition = datajson.getJSONArray("legOtherDutyInc");
        if (null != frposition && frposition.size() > 0) {
            //法人其他任职信息
            for (int i = 0; i < frposition.size(); i++) {
                Frpositioninfos frposit = new Frpositioninfos();
                info = frposition.getJSONObject(i);
                frposit.setPosition(Tool.getinfoData(info, "dutyInc"));
                frposit.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                frposit.setEsDate(Tool.getinfoData(info, "openDate"));
                frposit.setRegCapitalCurrency(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != frposit.getRegCapitalCurrency() && !"".equals(frposit.getRegCapitalCurrency().trim())) {
                    frposit.setRegCapitalCurrency(getIntRcid(currencyList, frposit.getRegCapitalCurrency()).toString());
                }
                frposit.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                frposit.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                int Status = 0;
                Status = Tool.EnterpriseStatus(frposit.getEnterpriseStatus());
                frposit.setEnterpriseStatus(Status + "");
                frposit.setNameCN(Tool.getinfoData(info, "frName"));
                frposit.setRevDate(Tool.getinfoData(info, "revokeDate"));
                frposit.setCancelDate(Tool.getinfoData(info, "canDate"));
                frposit.setEnterpriseType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                int EntType = 0;
                EntType = Tool.TypeAndNatureOfBusiness(frposit.getEnterpriseType());
                frposit.setEnterpriseType(EntType + "");
                frposit.setRegNo(Tool.getinfoData(info, "regNo"));
                frposit.setRegCapital(Tool.getinfoData(info, "regCapAmt"));
                if (null != frposit.getRegCapital() && !"".equals(frposit.getRegCapital().trim())) {
                    frposit.setRegCapital(Tool.SetMoneyMultiplied_YearReport(frposit.getRegCapital()));
                }
                frposit.setDelFlag("1");
                frposit.setFullReportId(fullReportId);
                frposit.setUpdateTime(updatetime);
                frpositioninfosDao.insert(frposit);
                frpositionList.add(frposit);

            }
        }

        //工商行政处罚记录
        //查询出表中所有内容
        List<PenaltyHis> penaltyHisList = penaltyHisDao.findByFullReportId(fullReportId);
        for (int i = 0; i < penaltyHisList.size(); i++) {
            //循环删除表中的所有内容
            penaltyHisDao.deleteById(fullReportId);
        }
        JSONArray penaltyHisArray = datajson.getJSONArray("penaltyHis");
        if (null != penaltyHisArray && penaltyHisArray.size() > 0) {
            for (int i = 0; i < penaltyHisArray.size(); i++) {
                PenaltyHis penaltyHis = new PenaltyHis();
                info = penaltyHisArray.getJSONObject(i);
                penaltyHis = JSON.parseObject(info.toString(), PenaltyHis.class);
                penaltyHis.setFullReportId(fullReportId);
                penaltyHis.setUpdateTime(updatetime);
                penaltyHisDao.insert(penaltyHis);
            }
        }


        //股权出质记录
        //查询出表中所有内容
        List<SharePledgeHis> sharePledgeHisList = sharePledgeHisDao.findByFullReportId(fullReportId);
        for (int i = 0; i < sharePledgeHisList.size(); i++) {
            //循环删除表中的所有内容
            sharePledgeHisDao.deleteById(sharePledgeHisList.get(i).getId());
        }

        JSONArray sharePledgeHisArray = datajson.getJSONArray("sharePledgeHis");
        if (null != sharePledgeHisArray && sharePledgeHisArray.size() > 0) {
            for (int i = 0; i < sharePledgeHisArray.size(); i++) {
                SharePledgeHis sharePledgeHis = new SharePledgeHis();
                info = sharePledgeHisArray.getJSONObject(i);
                sharePledgeHis = JSON.parseObject(info.toString(), SharePledgeHis.class);
                sharePledgeHis.setFullReportId(fullReportId);
                sharePledgeHis.setUpdateTime(updatetime);
                sharePledgeHisDao.insert(sharePledgeHis);
            }
        }


        //股权冻结记录
        // 查询出表中所有内容
        List<ShareFrozenHis> shareFrozenHisList = shareFrozenHisDao.findByFullReportId(fullReportId);
        for (int i = 0; i < shareFrozenHisList.size(); i++) {
            //循环删除表中的所有内容
            shareFrozenHisDao.deleteById(shareFrozenHisList.get(i).getId());
        }

        JSONArray shareFrozenHisArray = datajson.getJSONArray("shareFrozenHis");
        if (null != shareFrozenHisArray && shareFrozenHisArray.size() > 0) {
            for (int i = 0; i < shareFrozenHisArray.size(); i++) {
                ShareFrozenHis shareFrozenHis = new ShareFrozenHis();
                info = shareFrozenHisArray.getJSONObject(i);
                shareFrozenHis = JSON.parseObject(info.toString(), ShareFrozenHis.class);
                shareFrozenHis.setFullReportId(fullReportId);
                shareFrozenHis.setUpdateTime(updatetime);
                shareFrozenHisDao.insert(shareFrozenHis);
            }
        }


    }

    @Override
    public FullReport getGlobalReport(FullReport report) {
        List<BasicData> currencyList = new ArrayList<BasicData>();
        String qhData = qianHaiInfoService.sendQianHaiData(report.getNameCN(), "");
        if (qhData == null || qhData.equals("")) {
            return report;
        }
        JSONObject result = JSONObject.parseObject(qhData);
        JSONArray basicList = result.getJSONArray("records");
        JSONObject datajson = basicList.getJSONObject(0);


        //先删除注册信息
        RegistrationInfos historyReg = report.getRegistrationInfos();
        //注册信息
        RegistrationInfos reg = new RegistrationInfos();
        JSONObject info = datajson.getJSONObject("basicInc");
        //企业注册信息
        if (info != null) {
            //判断企业类型和企业性质
            if (isNull(getinfoData(info, "entType"))) {
                reg.setCompanyType(getinfoData(info, "entType"));
                int ctid = 0;
                int cpid = 0;
                reg = Tool.TypeAndNature(reg.getCompanyType());
                ctid = reg.getCompanyTypesId();
                cpid = reg.getCompanyTypesId();
                reg.setCompanyTypesId(ctid);
                if (Tool.isNull(reg.getCompanyTypesId() + "")) {
                    reg.setCompanyPropertiesId(cpid);
                }
                if (Tool.isNull(reg.getCompanyTypesId() + "")) {
                    reg.setCompanyPropertiesId(ctid);
                }
            }
            if (isNull(getinfoData(info, "runStatus"))) {
                reg.setCompanyStatus(getinfoData(info, "runStatus"));
                //判断企业状态
                int entstatus = 0;
                entstatus = Tool.EnterpriseStatus(reg.getCompanyStatus());
                reg.setCompanyStatusId(entstatus);
            }
            String regCapCur = "";
            if (null != getinfoData(info, "regCapCur") && !"".equals(getinfoData(info, "regCapCur"))) {
                regCapCur = getinfoData(info, "regCapCur");
                int rcid = getIntRcid(currencyList, regCapCur);
                reg.setRegCurrencyId(rcid);//注册币种
                reg.setPaidCurrencyId(rcid);//实收币种
            }
            if (isNull(getinfoData(info, "regCapAmt"))) {
                reg.setRegCapital(Tool.SetMoneyMultiplied_YearReport(getinfoData(info, "regCapAmt")));//注册资本
                if (null != reg.getRegCapital() && "0".equals(reg.getRegCapital())) {
                    reg.setRegCapital(null);
                    reg.setRegCurrencyId(null);//实收币种
                }
            }
            if (isNull(getinfoData(info, "fctCapAmt"))) {
                reg.setPaidCapital(Tool.SetMoneyMultiplied_YearReport(getinfoData(info, "fctCapAmt")));//实收资本
                if (null != reg.getPaidCapital() && "0".equals(reg.getPaidCapital())) {
                    reg.setPaidCapital(null);
                    reg.setPaidCurrencyId(null);//实收币种
                }
            }
            if (isNull(getinfoData(info, "coCode"))) {
                reg.setChnCode(getinfoData(info, "coCode"));
            }//行业代码
            reg.setChinaIndustrycode(getinfoData(info, "coCode") + " " + getinfoData(info, "coName"));
            if (isNull(getinfoData(info, "entOrgCode"))) {
                reg.setOrg(getinfoData(info, "entOrgCode"));
            }//组织结构代码
            if (isNull(getinfoData(info, "offAreaCode"))) {
                int provinceCode = 0;
                String offAreaCode = getinfoData(info, "offAreaCode");
                if (offAreaCode.length() > 2) {
                    String str = offAreaCode.substring(0, 2);
                    if (null != str && !"".equals(str)) {
                        provinceCode = Integer.parseInt(str);
                    }
                }
                reg.setProvinceCode(provinceCode);//省份代码
            }

            if (isNull(getinfoData(info, "address"))) {
                reg.setStreetCN(getinfoData(info, "address"));
            }//街道中文名称
            if (isNull(getinfoData(info, "regOrg"))) {
                reg.setRegistrationCN(getinfoData(info, "regOrg"));
            }//注册机构
            if (isNull(getinfoData(info, "regNo"))) {
                reg.setReg(getinfoData(info, "regNo"));
            }//注册号
            reg.setNameCN(getinfoData(info, "entName"));//公司名称
            if (isNull(getinfoData(info, "creditCode"))) {
                reg.setCreditCode(getinfoData(info, "creditCode"));
            }//信用代码
            if (isNull(getinfoData(info, "openDate"))) {
                reg.setEstablishDate(getinfoData(info, "openDate"));
            }//注册时间
            if (isNull(getinfoData(info, "runDateTo"))) {
                reg.setDeadline(getinfoData(info, "runDateTo"));
            }//经营期限
            if (isNull(getinfoData(info, "userName"))) {
                reg.setLegalNameCN(getinfoData(info, "userName"));
            }//法定代表人
            if (isNull(getinfoData(info, "busiScope1"))) {
                reg.setBusinessScopeCN(getinfoData(info, "busiScope1"));
            }//经营范围
            report.setRegistrationInfos(reg);
        }
        //注册变更
        List<ChangeInfos> changeInfosList = new ArrayList<>();
        if (null != report.getChangeInfosList()) {
            changeInfosList = report.getChangeInfosList();
        }
        JSONArray hisChangeIncList = datajson.getJSONArray("hisChangeInc");
        if (null != hisChangeIncList && hisChangeIncList.size() > 0) {
            for (int i = 0; i < hisChangeIncList.size(); i++) {
                ChangeInfos change = new ChangeInfos();
                info = hisChangeIncList.getJSONObject(i);
                change.setChangeType(getinfoData(info, "changeItem"));
                change.setBeforeCN(getinfoData(info, "changeBefore"));
                change.setAfterCN(getinfoData(info, "changeAfter"));
                change.setChangeDate(getinfoData(info, "changeDate"));
                if (compare_date("2013-01-01", change.getChangeDate())) {
                    changeInfosList.add(change);
                }
            }
            report.setChangeInfosList(changeInfosList);
        }

        //股东及出资信息
        if (null != report.getShareholderInfosList() && report.getShareholderInfosList().size() > 0) {
            List<ShareholderInfos> shareList = new ArrayList<ShareholderInfos>();
            List<DataType> dataTypeList = dataTypeService.findByCode("Currency");
            currencyList = new ArrayList<>();
            Map<String, Object> params = new HashMap<>();
            params.put("delFlag", "1");
            if (null != dataTypeList && dataTypeList.size() > 0) {
                params.put("dictionaryId", dataTypeList.get(0).getId());

                currencyList = basicDateDao.listByDtidAndDelFlag(params);
            }
            //法人对外投资信息
            JSONArray sharehold = datajson.getJSONArray("holderInc");
            if (null != sharehold && sharehold.size() > 0) {
                //法人对外投资信息
                for (int i = 0; i < sharehold.size(); i++) {
                    ShareholderInfos share = new ShareholderInfos();
                    info = sharehold.getJSONObject(i);
                    share.setNameCN(Tool.getinfoData(info, "userName"));//股东名称
                    share.setCountryCN(Tool.getinfoData(info, "conType"));//国别
                    share.setContributionDate(Tool.getinfoData(info, "conDate"));//出资日期
                    share.setContributionFrom(Tool.getinfoData(info, "conMthd"));//出资方式
                    share.setSubconam(Tool.getinfoData(info, "subAmt"));//认缴出资额(万元)
                    share.setCurrency(Tool.getinfoData(info, "subCur"));//认缴出资币种
                    //判断注册币种
                    if (null != share.getCurrency() && !"".equals(share.getCurrency().trim())) {
                        share.setContributionId(getIntRcid(currencyList, share.getCurrency()));
                    }
                    share.setShares(Tool.getinfoData(info, "conRate"));//出资比例
                    shareList.add(share);
                }
            }
            report.setShareholderInfosList(shareList);
        }
        //主要管理人员信息
        if (null != report.getManagementsList() && report.getManagementsList().size() > 0) {
            List<Managements> managementList = new ArrayList<Managements>();
            List<DataType> dataTypeList = dataTypeService.findByCode("Post");
            currencyList = new ArrayList<>();
            Map<String, Object> params = new HashMap<>();
            params.put("delFlag", "1");
            if (null != dataTypeList && dataTypeList.size() > 0) {
                params.put("dictionaryId", dataTypeList.get(0).getId());

                currencyList = basicDateDao.listByDtidAndDelFlag(params);
            }
            JSONArray manager = datajson.getJSONArray("mgrPersonInc");
            if (null != manager && manager.size() > 0) {
                for (int i = 0; i < manager.size(); i++) {
                    Managements manage = new Managements();
                    info = manager.getJSONObject(i);
                    manage.setNameCN(Tool.getinfoData(info, "userName"));//人员姓名
                    manage.setPosition(Tool.getinfoData(info, "dutyInc"));//职务
                    int postion = 0;
                    if (null != manage.getPosition()) {
                        for (int j = 0; j < currencyList.size(); j++) {
                            BasicData basicdata = currencyList.get(j);
                            if (basicdata.getValueCN().equals(manage.getPosition())) {
                                postion = basicdata.getCode();
                            }
                        }
                    }
                    manage.setGender(Tool.getinfoData(info, "sex"));//性别
                    //判断管理员性别
                    if (null != manage.getGender() && "男".equals(manage.getGender().trim())) {
                        manage.setGender("0");
                    } else if (null != manage.getGender() && "女".equals(manage.getGender().trim())) {
                        manage.setGender("1");
                    } else {
                        manage.setGender("2");
                    }
                    manage.setPostId(postion);
                    managementList.add(manage);
                }
                report.setManagementsList(managementList);
            }
        }


        //法人对外投资
        List<Frinvinfos> frinvList = new ArrayList<Frinvinfos>();
        List<DataType> dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            currencyList = basicDateDao.listByDtidAndDelFlag(params);
            params.put("dictionaryId", dataTypeList.get(0).getId());
            params.put("delFlag", "1");
        }
        //法人对外投资信息
        JSONArray frinv = datajson.getJSONArray("legInvstInc");
        if (null != frinv && frinv.size() > 0) {
            //法人对外投资信息
            for (int i = 0; i < frinv.size(); i++) {
                Frinvinfos frin = new Frinvinfos();
                info = frinv.getJSONObject(i);
                frin.setConfrom(Tool.getinfoData(info, "capMthd"));
                frin.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                frin.setEsDate(Tool.getinfoData(info, "openDate"));
                frin.setRegCapitalCurrency(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != frin.getRegCapitalCurrency() && !"".equals(frin.getRegCapitalCurrency().trim())) {
                    frin.setRegCapitalCurrency(getStringRcid(currencyList, frin.getRegCapitalCurrency()).toString());
                }
                frin.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                frin.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                String Status = Tool.EnterpriseStatusStr(frin.getEnterpriseStatus());
                frin.setEnterpriseStatus(Status + "");
                frin.setNameCN(Tool.getinfoData(info, "frName"));
                frin.setRevDate(Tool.getinfoData(info, "revokeDate"));
                frin.setCurrency(Tool.getinfoData(info, "subCapCur"));
                //判断注册币种
                if (null != frin.getCurrency() && !"".equals(frin.getCurrency().trim())) {
                    frin.setCurrency(getStringRcid(currencyList, frin.getCurrency()).toString());
                }
                frin.setSubconam(Tool.getinfoData(info, "subCapAmt"));
                if (null != frin.getSubconam() && !"".equals(frin.getSubconam().trim())) {
                    frin.setSubconam(Tool.SetMoneyMultiplied_YearReport(frin.getSubconam()));
                }
                frin.setFundedRatio(Tool.getinfoData(info, "capRate"));
                frin.setCancelDate(Tool.getinfoData(info, "canDate"));
                frin.setEnterpriseType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                String EntType = Tool.TypeAndNatureOfBusinessStr(frin.getEnterpriseType());
                frin.setEnterpriseType(EntType + "");
                frin.setRegNo(Tool.getinfoData(info, "regNo"));
                frin.setRegCapital(Tool.getinfoData(info, "regCapAmt"));
                if (null != frin.getRegCapital() && !"".equals(frin.getRegCapital().trim())) {
                    frin.setRegCapital(Tool.SetMoneyMultiplied_YearReport(frin.getRegCapital()));
                }
                frin.setDelFlag("1");
                frinvList.add(frin);
            }
            report.setFrinvinfosList(frinvList);
        }

        List<Entinvinfos> entList = new ArrayList<Entinvinfos>();
        dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());
            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //企业对外投资信息
        JSONArray entinv = datajson.getJSONArray("entInvstInc");
        if (null != entinv && entinv.size() > 0) {
            //企业对外投资信息
            for (int i = 0; i < entinv.size(); i++) {
                Entinvinfos ent = new Entinvinfos();
                info = entinv.getJSONObject(i);
                ent.setConfrom(Tool.getinfoData(info, "capMthd"));
                ent.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                ent.setEsDate(Tool.getinfoData(info, "openDate"));
                ent.setRegCapCur(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != ent.getRegCapCur() && !"".equals(ent.getRegCapCur().trim())) {
                    ent.setRegCapCur(getStringRcid(currencyList, ent.getRegCapCur()).toString());
                }
                ent.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                ent.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                String Status = Tool.EnterpriseStatusStr(ent.getEnterpriseStatus());
                ent.setEnterpriseStatus(Status + "");
                ent.setNameCN("");
                ent.setRevDate(Tool.getinfoData(info, "revokeDate"));
                ent.setCurrency(Tool.getinfoData(info, "subCapCur"));
                if (null != ent.getCurrency() && !"".equals(ent.getCurrency().trim())) {
                    ent.setCurrency(getStringRcid(currencyList, ent.getCurrency()).toString());
                }
                ent.setSubconam(Tool.getinfoData(info, "subCapAmt"));
                if (null != ent.getSubconam() && !"".equals(ent.getSubconam().trim())) {
                    ent.setSubconam(Tool.SetMoneyMultiplied_YearReport(ent.getSubconam()));
                }
                ent.setFundedRatio(Tool.getinfoData(info, "capRate"));
                ent.setCanDate(Tool.getinfoData(info, "canDate"));
                ent.setEntType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                String EntType = Tool.TypeAndNatureOfBusinessStr(ent.getEntType());
                ent.setEntType(EntType + "");
                ent.setRegNo(Tool.getinfoData(info, "regNo"));
                ent.setRegCap(Tool.getinfoData(info, "regCapAmt"));
                if (null != ent.getRegCap() && !"".equals(ent.getRegCap().trim())) {
                    ent.setRegCap(Tool.SetMoneyMultiplied_YearReport(ent.getRegCap()));
                }
                ent.setDelFlag("1");
                entList.add(ent);
            }
            report.setEntinvinfosList(entList);
        }

        List<Frpositioninfos> frpositionList = new ArrayList<Frpositioninfos>();
        dataTypeList = dataTypeService.findByCode("Currency");
        currencyList = new ArrayList<>();
        params = new HashMap<>();
        params.put("delFlag", "1");
        if (null != dataTypeList && dataTypeList.size() > 0) {
            params.put("dictionaryId", dataTypeList.get(0).getId());

            currencyList = basicDateDao.listByDtidAndDelFlag(params);
        }
        //法人其他任职信息
        JSONArray frposition = datajson.getJSONArray("legOtherDutyInc");
        if (null != frposition && frposition.size() > 0) {
            //法人其他任职信息
            for (int i = 0; i < frposition.size(); i++) {
                Frpositioninfos frposit = new Frpositioninfos();
                info = frposition.getJSONObject(i);
                frposit.setPosition(Tool.getinfoData(info, "dutyInc"));
                frposit.setRegOrgCN(Tool.getinfoData(info, "regOrg"));
                frposit.setEsDate(Tool.getinfoData(info, "openDate"));
                frposit.setRegCapital(Tool.getinfoData(info, "regCapCur"));
                //判断注册币种
                if (null != frposit.getRegCapitalCurrency() && !"".equals(frposit.getRegCapitalCurrency().trim())) {
                    frposit.setRegCapitalCurrency(getStringRcid(currencyList, frposit.getRegCapitalCurrency()).toString());
                }
                frposit.setEnterpriseNameCN(Tool.getinfoData(info, "entName"));
                frposit.setEnterpriseStatus(Tool.getinfoData(info, "status"));
                //判断企业状态
                String Status = Tool.EnterpriseStatusStr(frposit.getEnterpriseStatus());
                frposit.setEnterpriseStatus(Status + "");
                frposit.setNameCN(Tool.getinfoData(info, "frName"));
                frposit.setRevDate(Tool.getinfoData(info, "revokeDate"));
                frposit.setCancelDate(Tool.getinfoData(info, "canDate"));
                frposit.setEnterpriseType(Tool.getinfoData(info, "entType"));
                //判断企业类型和企业性质
                String EntType = Tool.TypeAndNatureOfBusinessStr(frposit.getEnterpriseType());
                frposit.setEnterpriseType(EntType + "");
                frposit.setRegNo(Tool.getinfoData(info, "regNo"));
                frposit.setRegCapital(Tool.getinfoData(info, "regCapAmt"));
                if (null != frposit.getRegCapital() && !"".equals(frposit.getRegCapital().trim())) {
                    frposit.setRegCapital(Tool.SetMoneyMultiplied_YearReport(frposit.getRegCapital()));
                }
                frposit.setDelFlag("1");
                frpositionList.add(frposit);
            }
            report.setFrpositioninfosList(frpositionList);
        }

        //工商行政处罚记录
        List<PenaltyHis> penaltyHisList = new ArrayList<>();
        JSONArray penaltyHisArray = datajson.getJSONArray("penaltyHis");
        if (null != penaltyHisArray && penaltyHisArray.size() > 0) {
            for (int i = 0; i < penaltyHisArray.size(); i++) {
                info = penaltyHisArray.getJSONObject(i);
                PenaltyHis penaltyHis = JSON.parseObject(info.toString(), PenaltyHis.class);
                penaltyHisList.add(penaltyHis);
            }
            report.setPenaltyHisList(penaltyHisList);
        }
        //股权出质记录
        //查询出表中所有内容
        List<SharePledgeHis> sharePledgeHisList = new ArrayList<>();
        JSONArray sharePledgeHisArray = datajson.getJSONArray("sharePledgeHis");
        if (null != sharePledgeHisArray && sharePledgeHisArray.size() > 0) {
            for (int i = 0; i < sharePledgeHisArray.size(); i++) {
                info = sharePledgeHisArray.getJSONObject(i);
                SharePledgeHis sharePledgeHis = JSON.parseObject(info.toString(), SharePledgeHis.class);
                sharePledgeHisList.add(sharePledgeHis);
            }
            report.setSharePledgeHisList(sharePledgeHisList);
        }

        //股权冻结记录
        List<ShareFrozenHis> shareFrozenHisList = new ArrayList<>();
        JSONArray shareFrozenHisArray = datajson.getJSONArray("shareFrozenHis");
        if (null != shareFrozenHisArray && shareFrozenHisArray.size() > 0) {
            for (int i = 0; i < shareFrozenHisArray.size(); i++) {
                info = shareFrozenHisArray.getJSONObject(i);
                ShareFrozenHis shareFrozenHis = JSON.parseObject(info.toString(), ShareFrozenHis.class);
                shareFrozenHisList.add(shareFrozenHis);
            }
            report.setShareFrozenHisList(shareFrozenHisList);
        }

        return report;
    }


    @Override
    public void saveBusiness(FullReport report) {
        if (report != null && report.getId() != null) {
            Integer insertId = report.getId();
            Integer fullReportId = null;
            //report = this.getQianHaiReport(report);//需要存库的数据
            FullReport byName = fullReportDao.findByName(report.getNameCN());
            if (byName != null) {
                fullReportId = byName.getId();
            }
            //注册信息
            //RegistrationInfos registrationInfos = report.getRegistrationInfos();
            //if (registrationInfos != null) {
            //    if (fullReportId != null) {
            //        RegistrationInfos hisReg = registrationInfosDao.findByFullReportId(fullReportId);
            //        if (null != hisReg && hisReg.getId() != null) {
            //            registrationInfosDao.deleteById(hisReg.getId());
            //        }
            //    }
            //    registrationInfos.setFullReportId(insertId);
            //    registrationInfos.setUpdateTime(DateUtil.getCurrentDate());
            //    registrationInfosDao.insert(registrationInfos);
            //}

            //股东信息
            List<ShareholderInfos> infoses = report.getShareholderInfosList();
            if (CollectionUtils.isNotEmpty(infoses)) {
                if (fullReportId != null) {
                    List<ShareholderInfos> ShareholderInfosList = shareholderInfosDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < ShareholderInfosList.size(); i++) {
                        shareholderInfosDao.deleteById(ShareholderInfosList.get(i).getId());
                    }
                }
                for (ShareholderInfos shareholderInfos : infoses) {
                    shareholderInfos.setFullReportId(insertId);
                    shareholderInfos.setUpdateTime(DateUtil.getCurrentDate());
                    String shares = shareholderInfos.getShares();
                    if (StringUtils.isNotBlank(shares) && !shares.contains("%")) {
                        shareholderInfos.setShares(shares + "%");
                    }
                    shareholderInfosDao.insert(shareholderInfos);
                }
            }

            //管理层信息
            List<Managements> managementses = report.getManagementsList();
            if (CollectionUtils.isNotEmpty(managementses)) {
                if (fullReportId != null) {
                    List<Managements> managementsList = managementsDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < managementsList.size(); i++) {
                        managementsDao.deleteById(managementsList.get(i).getId());
                    }
                }
                for (Managements managements : managementses) {
                    managements.setFullReportId(insertId);
                    managements.setUpdateTime(DateUtil.getCurrentDate());
                    managementsDao.insert(managements);
                }
            }

            //法人对外投资信息
            List<Frinvinfos> frinvinfoses = report.getFrinvinfosList();
            if (CollectionUtils.isNotEmpty(frinvinfoses)) {
                if (fullReportId != null) {
                    List<Frinvinfos> frinvinfosList = frinvinfosDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < frinvinfosList.size(); i++) {
                        frinvinfosDao.deleteById(frinvinfosList.get(i).getId());
                    }
                }
                for (Frinvinfos frinvinfos : frinvinfoses) {
                    frinvinfos.setFullReportId(insertId);
                    frinvinfos.setUpdateTime(DateUtil.getCurrentDate());
                    frinvinfosDao.insert(frinvinfos);
                }
            }

            //企业对外投资信息
            List<Entinvinfos> entinvinfoses = report.getEntinvinfosList();
            if (CollectionUtils.isNotEmpty(entinvinfoses)) {
                if (fullReportId != null) {
                    List<Entinvinfos> entinvinfosList = entinvinfosDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < entinvinfosList.size(); i++) {
                        entinvinfosDao.deleteById(entinvinfosList.get(i).getId());
                    }
                }
                for (Entinvinfos entinvinfos : entinvinfoses) {
                    entinvinfos.setFullReportId(insertId);
                    entinvinfos.setUpdateTime(DateUtil.getCurrentDate());
                    entinvinfosDao.insert(entinvinfos);
                }
            }

            //法人其他任职信息
            List<Frpositioninfos> frpositioninfoses = report.getFrpositioninfosList();
            if (CollectionUtils.isNotEmpty(frpositioninfoses)) {
                if (fullReportId != null) {
                    List<Frpositioninfos> frpositioninfosList = frpositioninfosDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < frpositioninfosList.size(); i++) {
                        frpositioninfosDao.deleteById(frpositioninfosList.get(i).getId());
                    }
                }

                for (Frpositioninfos frpositioninfos : frpositioninfoses) {
                    frpositioninfos.setFullReportId(insertId);
                    frpositioninfos.setUpdateTime(DateUtil.getCurrentDate());
                    frpositioninfosDao.insert(frpositioninfos);
                }
            }

            //工商行政处罚记录
            List<PenaltyHis> penaltyHises = report.getPenaltyHisList();
            if (CollectionUtils.isNotEmpty(penaltyHises)) {
                if (fullReportId != null) {
                    List<PenaltyHis> penaltyHisList = penaltyHisDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < penaltyHisList.size(); i++) {
                        penaltyHisDao.deleteById(penaltyHisList.get(i).getId());
                    }
                }
                for (PenaltyHis penaltyHis : penaltyHises) {
                    penaltyHis.setFullReportId(insertId);
                    penaltyHis.setUpdateTime(DateUtil.getCurrentDate());
                    penaltyHisDao.insert(penaltyHis);
                }
            }

            //股权出质记录
            List<SharePledgeHis> pledgeHises = report.getSharePledgeHisList();
            if (CollectionUtils.isNotEmpty(pledgeHises)) {
                if (fullReportId != null) {
                    List<SharePledgeHis> sharePledgeHisList = sharePledgeHisDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < sharePledgeHisList.size(); i++) {
                        sharePledgeHisDao.deleteById(sharePledgeHisList.get(i).getId());
                    }
                }
                for (SharePledgeHis sharePledgeHis : pledgeHises) {
                    sharePledgeHis.setFullReportId(insertId);
                    sharePledgeHis.setUpdateTime(DateUtil.getCurrentDate());
                    sharePledgeHisDao.insert(sharePledgeHis);
                }
            }

            //股权冻结记录
            List<ShareFrozenHis> frozenHisList = report.getShareFrozenHisList();
            if (CollectionUtils.isNotEmpty(frozenHisList)) {
                if (fullReportId != null) {
                    List<ShareFrozenHis> shareFrozenHisList = shareFrozenHisDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < shareFrozenHisList.size(); i++) {
                        shareFrozenHisDao.deleteById(shareFrozenHisList.get(i).getId());
                    }
                }
                for (ShareFrozenHis shareFrozenHis : frozenHisList) {
                    shareFrozenHis.setFullReportId(insertId);
                    shareFrozenHis.setUpdateTime(DateUtil.getCurrentDate());
                    shareFrozenHisDao.insert(shareFrozenHis);
                }

            }

        }

    }


    @Override
    public FullReport getQianHaiReport(FullReport report) {
        if (report != null) {
            String qixinbaoUrl = null;
            Integer fullReportId = report.getId();
            String companyName = report.getNameCN();
            try {
                qixinbaoUrl = QIANHAIURL + "?companyName=" + URLEncoder.encode(companyName, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (qixinbaoUrl != null) {
                String qixinbaoData = HttpUtil.syncData(qixinbaoUrl);
                JSONObject qixinbaoObject = JSON.parseObject(qixinbaoData);
                Boolean qixinbaoCode = qixinbaoObject.getBoolean("code");
                if (qixinbaoCode) {
                    report = qixinbaoObject.getObject("content", FullReport.class);
                    report.setId(fullReportId);
                    report.setNameCN(companyName);
                    report.setUpdateTime(DateUtil.getCurrentDate());
                }
            }
        }
        return report;
    }

    @Override
    public FullReport copyFullreport(FullReport report) {
        if (report != null) {
            FullReport qianHaiReport = this.getQianHaiReport(report);
            if (qianHaiReport != null) {
                //RegistrationInfos registrationInfos = qianHaiReport.getRegistrationInfos();
                //if (registrationInfos != null) {
                //    report.setRegistrationInfos(registrationInfos);
                //}
                List<ShareholderInfos> shareholderInfoses = qianHaiReport.getShareholderInfosList();
                if (CollectionUtils.isNotEmpty(shareholderInfoses)) {
                    report.setShareholderInfosList(shareholderInfoses);
                }
                List<Managements> managementsList = qianHaiReport.getManagementsList();
                if (CollectionUtils.isNotEmpty(managementsList)) {
                    report.setManagementsList(managementsList);
                }
                List<Frinvinfos> frinvinfosList = qianHaiReport.getFrinvinfosList();
                if (CollectionUtils.isNotEmpty(frinvinfosList)) {
                    report.setFrinvinfosList(frinvinfosList);
                }
                List<Entinvinfos> entinvinfosList = qianHaiReport.getEntinvinfosList();
                if (CollectionUtils.isNotEmpty(entinvinfosList)) {
                    report.setEntinvinfosList(entinvinfosList);
                }
                List<Frpositioninfos> frpositioninfoses = qianHaiReport.getFrpositioninfosList();
                if (CollectionUtils.isNotEmpty(frpositioninfoses)) {
                    report.setFrpositioninfosList(frpositioninfoses);
                }
                List<PenaltyHis> penaltyHisList = qianHaiReport.getPenaltyHisList();
                if (CollectionUtils.isNotEmpty(penaltyHisList)) {
                    report.setPenaltyHisList(penaltyHisList);
                }
                List<SharePledgeHis> sharePledgeHisList = qianHaiReport.getSharePledgeHisList();
                if (CollectionUtils.isNotEmpty(sharePledgeHisList)) {
                    report.setSharePledgeHisList(sharePledgeHisList);
                }
                List<ShareFrozenHis> shareFrozenHisList = qianHaiReport.getShareFrozenHisList();
                if (CollectionUtils.isNotEmpty(shareFrozenHisList)) {
                    report.setShareFrozenHisList(shareFrozenHisList);
                }

            }

        }
        return report;
    }
}
