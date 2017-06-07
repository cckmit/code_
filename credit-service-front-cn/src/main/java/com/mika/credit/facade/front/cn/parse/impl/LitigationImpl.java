package com.mika.credit.facade.front.cn.parse.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.util.DateUtil;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.common.util.Page;
import com.mika.credit.facade.front.cn.dao.*;
import com.mika.credit.facade.front.cn.parse.Litigation;
import com.mika.credit.facade.front.cn.service.FaHaiInfoService;
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

import static com.mika.credit.facade.front.cn.util.Tool.getinfoData;

/**
 * Created by dong jian hua on 2017/2/18.
 */
@SuppressWarnings("Duplicates")
@Service("litigationImpl")
public class LitigationImpl implements Litigation {

    @Autowired
    BasicInfosDao basicInfosDao;
    @Autowired
    KtggDao ktggDao;
    @Autowired
    ExecutiveDao executiveDao;
    @Autowired
    RulingdocumentsDao rulingdocumentsDao;
    @Autowired
    SxggDao sxggDao;
    @Autowired
    FyggDao fyggDao;
    @Autowired
    WdhmdDao wdhmdDao;
    @Autowired
    AjlcDao ajlcDao;
    @Autowired
    BgtDao bgtDao;
    @Autowired
    FullReportDao fullReportDao;

    @Autowired
    FaHaiInfoService faHaiInfoService;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String updatetime = format.format(new Date());

    @Value("${fahaiInterface}")
    private String FAHAIURL;

    @Override
    public void getFHLitigationAllList(FullReport report) {
        String nameCN = report.getNameCN();
        int fid = report.getId();
        int ktggCount = 0;
        int ktggPageNum = 0;
        int cpwsCount = 0;
        int cpwsPageNum = 0;
        int zxggCount = 0;
        int zxggPageNum = 0;
        int fyggCount = 0;
        int fyggPageNum = 0;
        int ajlcCount = 0;
        int ajlcPageNum = 0;
        int sxggCount = 0;
        int sxggPageNum = 0;
        int wdhmdCount = 0;
        int wdhmdPageNum = 0;
        int bgtCount = 0;
        int bgtPageNum = 0;
        String url = "";
        String data = "";
        JSONObject json = null;


        try {
           /* nameCN = nameCN.trim();
            nameCN = nameCN.replace("（", "(");
            nameCN = nameCN.replace("）", ")");
            basicName = basicName.replace("(", "（");
            basicName = basicName.replace(")", "）");
            nameCN = java.net.URLEncoder.encode(nameCN, "UTF-8");
            url = commerceIp + "ssm_dc/fahaiData.do?method=query&q="+nameCN;*/
            Map param = new HashMap();
            param.put("q", nameCN);
            param.put("query", "query");
            data = faHaiInfoService.sendfahaiDataOrderData(param);
            //data = HttpUtil.syncData(url);
            json = JSONObject.parseObject(data);
            //获取各个模块司法数据的条数，用于判断该模块有没有数据
            ktggCount = Tool.StringToInt(json.getString("ktggCount"));
            ktggPageNum = Tool.StringToInt(json.getString("ktggPageNum"));
            cpwsCount = Tool.StringToInt(json.getString("cpwsCount"));
            cpwsPageNum = Tool.StringToInt(json.getString("cpwsPageNum"));
            zxggCount = Tool.StringToInt(json.getString("zxggCount"));
            zxggPageNum = Tool.StringToInt(json.getString("zxggPageNum"));
            fyggCount = Tool.StringToInt(json.getString("fyggCount"));
            fyggPageNum = Tool.StringToInt(json.getString("fyggPageNum"));
            ajlcCount = Tool.StringToInt(json.getString("ajlcCount"));
            ajlcPageNum = Tool.StringToInt(json.getString("ajlcPageNum"));
            sxggCount = Tool.StringToInt(json.getString("shixinCount"));
            sxggPageNum = Tool.StringToInt(json.getString("shixinPageNum"));
            bgtCount = Tool.StringToInt(json.getString("bgtCount"));
            bgtPageNum = Tool.StringToInt(json.getString("bgtPageNum"));
            wdhmdCount = Tool.StringToInt(json.getString("wdhmdCount"));
            wdhmdPageNum = Tool.StringToInt(json.getString("wdhmdPageNum"));
        } catch (Exception e) {
        }

        try {
            //开庭公告
            //先删除数据库已有的开庭公告数据
            List<Ktgg> ktggsList = ktggDao.findByFullReportId(fid);
            for (int i = 0; i < ktggsList.size(); i++) {
                ktggDao.deleteById(ktggsList.get(i).getId());
            }
            if (ktggCount > 0) {
                for (int i = 0; i < ktggPageNum; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "ktgg");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                       /* url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=ktgg&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray ktggList = json.getJSONArray("ktggList");
                        for (int s = 0; s < ktggList.size(); s++) {
                            Ktgg ktgg = new Ktgg();
                            JSONObject ktggObject = ktggList.getJSONObject(s);
                            try {
                                String ktggStr = ktggObject.toJSONString();
                                ktggStr = ktggStr.replace("plaintiff", "plaintiffCN");//原告
                                ktggStr = ktggStr.replace("courtroom", "courtroomCN");//法庭名称
                                ktggStr = ktggStr.replace("party", "parties");//当事人
                                ktggStr = ktggStr.replace("caseCause", "caseCauseCN");//案由
                                ktggStr = ktggStr.replace("judge", "chiefJusticeCN");//法官
                                ktggStr = ktggStr.replace("caseCause", "caseCauseCN");//案由
                                ktggStr = ktggStr.replace("caseNo", "docketNoCN");//案号
                                ktggStr = ktggStr.replace("defendant", "defendantCN");//被告
                                ktgg = JSON.parseObject(ktggStr, Ktgg.class);
                                ktgg.setFullReportId(fid);
                                ktgg.setUpdateTime(updatetime);
                                ktggDao.insert(ktgg);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //执行公告
            //先删除数据库已有的执行公告数据
            List<Executive> zxggsList = executiveDao.findByFullReportId(fid);
            for (int i = 0; i < zxggsList.size(); i++) {
                executiveDao.deleteById(zxggsList.get(i).getId());
            }
            if (zxggCount > 0) {
                for (int i = 0; i < zxggPageNum; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "zxgg");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                       /* url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=zxgg&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray zxggList = json.getJSONArray("zxggList");
                        for (int s = 0; s < zxggList.size(); s++) {
                            Executive zxgg = new Executive();
                            JSONObject zxggObject = zxggList.getJSONObject(s);
                            try {
                                String zxggStr = zxggObject.toJSONString();
                                zxggStr = zxggStr.replace("pname", "enforceeNameCn");//被执行人姓名
                                zxggStr = zxggStr.replace("court", "entCourtNameCn");//执行法院名称
                                zxggStr = zxggStr.replace("proposer", "applyName");//申请人
                                zxggStr = zxggStr.replace("caseNo", "docketNoCN");//案号
                                zxggStr = zxggStr.replace("caseState", "caseStatusCN");//案件状态
                                zxggStr = zxggStr.replace("idcardNo", "organizerCode");//身份证/组织机构代码
                                zxggStr = zxggStr.replace("execMoney", "amount");//执行标的
                                zxgg = JSON.parseObject(zxggStr, Executive.class);
                                zxgg.setFullReportId(fid);
                                zxgg.setUpdateTime(updatetime);
                                executiveDao.insert(zxgg);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //裁判文书
            //先删除数据库已有的裁判文书数据
            List<Rulingdocuments> cpwssList = rulingdocumentsDao.findByFullReportId(fid);
            for (int i = 0; i < cpwssList.size(); i++) {
                rulingdocumentsDao.deleteById(cpwssList.get(i).getId());
            }
            if (cpwsCount > 0) {
                for (int i = 0; i < cpwsPageNum; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "cpws");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);

                       /* url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=cpws&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray cpwsList = json.getJSONArray("cpwsList");
                        for (int s = 0; s < cpwsList.size(); s++) {
                            Rulingdocuments cpws = new Rulingdocuments();
                            JSONObject cpwsObject = cpwsList.getJSONObject(s);
                            try {
                                String cpwsStr = cpwsObject.toJSONString();
                                String plaintiffCN = "";//原告
                                String defendantCN = "";//被告
                                JSONArray partys = cpwsObject.getJSONArray("partys");
                                for (int j = 0; j < partys.size(); j++) {
                                    JSONObject party = partys.getJSONObject(j);
                                    String pname = getinfoData(party, "pname");
                                    String title = getinfoData(party, "title");
                                    //取原告,被告
                                    if (title.equals("原告")) {
                                        if (null == plaintiffCN || "".equals(plaintiffCN)) {
                                            plaintiffCN = pname;
                                        } else {
                                            plaintiffCN = plaintiffCN + "," + pname;
                                        }
                                    }
                                    if (title.equals("被告")) {
                                        if (null == defendantCN || "".equals(defendantCN)) {
                                            defendantCN = pname;
                                        } else {
                                            defendantCN = defendantCN + "," + pname;
                                        }
                                    }
                                }
                                cpwsStr = cpwsStr.replace("cpwsyId", "cpwsId");//裁判文书ID
                                cpwsStr = cpwsStr.replace("caseType", "caseTypeCN");//文书类型（案件类型）
                                cpwsStr = cpwsStr.replace("body", "content");//内容
                                cpwsStr = cpwsStr.replace("court", "CourtNameCN");//法院名称
                                cpwsStr = cpwsStr.replace("title", "titleCn");//文书标题
                                cpwsStr = cpwsStr.replace("caseNo", "docketNoCn");//案号
                                cpwsStr = cpwsStr.replace("anyou", "caseCauseId");//案由编码
                                cpwsStr = cpwsStr.replace("anyouType", "caseCauseType");//案由编码类型
                                cpwsStr = cpwsStr.replace("yiju", "reason");//依据
                                cpws = JSON.parseObject(cpwsStr, Rulingdocuments.class);
                                cpws.setPlaintiffCN(plaintiffCN);
                                cpws.setDefendantCN(defendantCN);
                                cpws.setFullReportId(fid);
                                cpws.setUpdateTime(updatetime);
                                rulingdocumentsDao.insert(cpws);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //失信被执行人
            //先删除数据库已有的失信被执行人数据
            List<Sxgg> sxggsList = sxggDao.findByFullReportId(fid);
            for (int i = 0; i < sxggsList.size(); i++) {
                sxggDao.deleteById(sxggsList.get(i).getId());
            }
            if (sxggCount > 0) {
                for (int i = 0; i < sxggPageNum; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "sxgg");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=sxgg&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray sxggList = json.getJSONArray("sxggList");
                        for (int s = 0; s < sxggList.size(); s++) {
                            Sxgg sxgg = new Sxgg();
                            JSONObject sxggObject = sxggList.getJSONObject(s);
                            try {
                                String sxggStr = sxggObject.toJSONString();
                                sxggStr = sxggStr.replace("lxqk", "enforceePerformCN");//被执行人的履行情况
                                sxggStr = sxggStr.replace("yjCode", "enforcementBasisNumberCN");//执行依据文号
                                sxggStr = sxggStr.replace("court", "entCourtNameCn");//执行法院名称
                                sxggStr = sxggStr.replace("yjdw", "basisUnitCN");//做出执行依据单位
                                sxggStr = sxggStr.replace("jtqx", "specificCircumstanceCN");//失信被执行人行为具体情形
                                sxggStr = sxggStr.replace("yiwu", "effectiveObligationCN");//生效法律文书确定的义务
                                sxggStr = sxggStr.replace("pname", "enforceeNameCn");//被执行人姓名
                                sxggStr = sxggStr.replace("province", "provinceCN");//被执行人姓名
                                sxggStr = sxggStr.replace("caseNo", "docketNoCN");//案号
                                sxggStr = sxggStr.replace("postTime", "finishDate");//发布日期
                                sxgg = JSON.parseObject(sxggStr, Sxgg.class);
                                sxgg.setFullReportId(fid);
                                sxgg.setUpdateTime(updatetime);
                                sxggDao.insert(sxgg);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //法院公告
            //先删除数据库已有的法院公告数据
            List<Fygg> fyggsList = fyggDao.findByFullReportId(fid);
            for (int i = 0; i < fyggsList.size(); i++) {
                fyggDao.deleteById(fyggsList.get(i).getId());
            }
            if (fyggCount > 0) {
                for (int i = 0; i < fyggPageNum; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "fygg");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=fygg&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray fyggList = json.getJSONArray("fyggList");
                        for (int s = 0; s < fyggList.size(); s++) {
                            Fygg fygg = new Fygg();
                            JSONObject fyggObject = fyggList.getJSONObject(s);
                            try {
                                String fyggStr = fyggObject.toJSONString();
                                fyggStr = fyggStr.replace("sortTime", "sortTime");
                                fyggStr = fyggStr.replace("body", "body");
                                fyggStr = fyggStr.replace("fyggId", "fyggId");
                                fyggStr = fyggStr.replace("layout", "layout");
                                fyggStr = fyggStr.replace("relatedParty", "relatedParty");
                                fyggStr = fyggStr.replace("pname", "pname");
                                fyggStr = fyggStr.replace("court", "court");
                                fyggStr = fyggStr.replace("ggType", "noticeType");
                                fygg = JSON.parseObject(fyggStr, Fygg.class);
                                fygg.setFullReportId(fid);
                                fygg.setUpdateTime(updatetime);
                                fyggDao.insert(fygg);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //网贷黑名单
            //先删除数据库已有的网贷黑名单数据
            List<Wdhmd> wdhmdsList = wdhmdDao.findByFullReportId(fid);
            for (int i = 0; i < wdhmdsList.size(); i++) {
                wdhmdDao.deleteById(wdhmdsList.get(i).getId());
            }
            if (wdhmdCount > 0) {
                for (int i = 0; i < wdhmdPageNum; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "wdhmd");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=wdhmd&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray wdhmdList = json.getJSONArray("wdhmdList");
                        for (int s = 0; s < wdhmdList.size(); s++) {
                            Wdhmd wdhmd = new Wdhmd();
                            JSONObject wdhmdObject = wdhmdList.getJSONObject(s);
                            try {
                                String wdhmdStr = wdhmdObject.toJSONString();
                                wdhmdStr = wdhmdStr.replace("sortTime", "sortTime");
                                wdhmdStr = wdhmdStr.replace("body", "body");
                                wdhmdStr = wdhmdStr.replace("sex", "sex");
                                wdhmdStr = wdhmdStr.replace("phone", "phone");
                                wdhmdStr = wdhmdStr.replace("updateTime", "updateTime");
                                wdhmdStr = wdhmdStr.replace("execCourt", "execCourt");
                                wdhmdStr = wdhmdStr.replace("relatedParty", "relatedParty");
                                wdhmdStr = wdhmdStr.replace("whfx", "whfx");
                                wdhmdStr = wdhmdStr.replace("idcardNo", "idcardNo");
                                wdhmdStr = wdhmdStr.replace("birthPlace", "birthPlace");
                                wdhmdStr = wdhmdStr.replace("bjbx", "bjbx");
                                wdhmdStr = wdhmdStr.replace("caseCode", "caseCode");
                                wdhmdStr = wdhmdStr.replace("address", "address");
                                wdhmdStr = wdhmdStr.replace("email", "email");
                                wdhmdStr = wdhmdStr.replace("sourceName", "sourceName");
                                wdhmdStr = wdhmdStr.replace("age", "age");
                                wdhmdStr = wdhmdStr.replace("pname", "pname");
                                wdhmdStr = wdhmdStr.replace("wdhmdId", "wdhmdId");
                                wdhmdStr = wdhmdStr.replace("datasource", "datasource");
                                wdhmdStr = wdhmdStr.replace("yhje", "yhje");
                                wdhmdStr = wdhmdStr.replace("mobile", "mobile");
                                wdhmd = JSON.parseObject(wdhmdStr, Wdhmd.class);
                                wdhmd.setFullReportId(fid);
                                wdhmd.setUpdateTime(updatetime);
                                wdhmdDao.insert(wdhmd);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //案件流程信息
            //先删除数据库已有的案件流程信息数据
            List<Ajlc> ajlcsList = ajlcDao.findByFullReportId(fid);
            for (int i = 0; i < ajlcsList.size(); i++) {
                ajlcDao.deleteById(ajlcsList.get(i).getId());
            }
            if (ajlcCount > 0) {
                for (int i = 0; i < ajlcPageNum; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "ajlc");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=ajlc&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray ajlcList = json.getJSONArray("ajlcList");
                        for (int s = 0; s < ajlcList.size(); s++) {
                            Ajlc ajlc = new Ajlc();
                            JSONObject ajlcObject = ajlcList.getJSONObject(s);
                            try {
                                String ajlcStr = ajlcObject.toJSONString();
                                ajlcStr = ajlcStr.replace("member", "member");
                                ajlcStr = ajlcStr.replace("sortTime", "sortTime");
                                ajlcStr = ajlcStr.replace("clerkPhone", "clerkPhone");
                                ajlcStr = ajlcStr.replace("caseType", "caseType");
                                ajlcStr = ajlcStr.replace("body", "body");
                                ajlcStr = ajlcStr.replace("trialProcedure", "trialProcedure");
                                ajlcStr = ajlcStr.replace("ajlcId", "ajlcId");
                                ajlcStr = ajlcStr.replace("sentencingDate", "sentencingDate");
                                ajlcStr = ajlcStr.replace("status", "status");
                                ajlcStr = ajlcStr.replace("caseStatus", "caseStatus");
                                ajlcStr = ajlcStr.replace("organizer", "organizer");
                                ajlcStr = ajlcStr.replace("filingDate", "filingDate");
                                ajlcStr = ajlcStr.replace("court", "court");
                                ajlcStr = ajlcStr.replace("ajlcStatus", "ajlcStatus");
                                ajlcStr = ajlcStr.replace("chiefJudge", "chiefJudge");
                                ajlcStr = ajlcStr.replace("caseCause", "caseCause");
                                ajlcStr = ajlcStr.replace("trialLimitDate", "trialLimitDate");
                                ajlcStr = ajlcStr.replace("clerk", "clerk");
                                ajlcStr = ajlcStr.replace("judge", "judge");
                                ajlcStr = ajlcStr.replace("actionObject", "actionObject");
                                ajlcStr = ajlcStr.replace("pname", "pname");
                                ajlcStr = ajlcStr.replace("caseNo", "caseNo");
                                ajlcStr = ajlcStr.replace("effectiveDate", "effectiveDate");
                                ajlc = JSON.parseObject(ajlcStr, Ajlc.class);
                                ajlc.setFullReportId(fid);
                                ajlc.setUpdateTime(updatetime);
                                ajlcDao.insert(ajlc);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //曝光台
            //先删除数据库已有的案件流程信息数据
            List<Bgt> bgtsList = bgtDao.findByFullReportId(fid);
            for (int i = 0; i < bgtsList.size(); i++) {
                bgtDao.deleteById(bgtsList.get(i).getId());
            }
            if (bgtCount > 0) {
                for (int i = 0; i < bgtPageNum; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "bgt");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=bgt&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray bgtList = json.getJSONArray("bgtList");
                        for (int s = 0; s < bgtList.size(); s++) {
                            Bgt bgt = new Bgt();
                            JSONObject bgtObject = bgtList.getJSONObject(s);
                            try {
                                String bgtStr = bgtObject.toJSONString();
                                bgtStr = bgtStr.replace("sortTime", "sortTime");
                                bgtStr = bgtStr.replace("body", "body");
                                bgtStr = bgtStr.replace("bgDate", "bgDate");
                                bgtStr = bgtStr.replace("partyType", "partyType");
                                bgtStr = bgtStr.replace("court", "court");
                                bgtStr = bgtStr.replace("proposer", "proposer");
                                bgtStr = bgtStr.replace("idcardNo", "idcardNo");
                                bgtStr = bgtStr.replace("bgtId", "bgtId");
                                bgtStr = bgtStr.replace("caseCause", "caseCause");
                                bgtStr = bgtStr.replace("unnexeMoney", "unexecMoney");
                                bgtStr = bgtStr.replace("address", "address");
                                bgtStr = bgtStr.replace("pname", "pname");
                                bgtStr = bgtStr.replace("caseNo", "caseNo");
                                bgtStr = bgtStr.replace("yiju", "yiju");
                                bgtStr = bgtStr.replace("execMoney", "execMoney");
                                bgt = JSON.parseObject(bgtStr, Bgt.class);
                                bgt.setFullReportId(fid);
                                bgt.setUpdateTime(updatetime);
                                bgtDao.insert(bgt);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

        } catch (Exception ex) {

        }


    }

    public void getFHLitigationList(FullReport report) {
        String nameCN = report.getNameCN();
        int fid = report.getId();
        int ktggCount = 0;
        int ktggPageNum = 0;
        int cpwsCount = 0;
        int cpwsPageNum = 0;
        int zxggCount = 0;
        int zxggPageNum = 0;
        int fyggCount = 0;
        int fyggPageNum = 0;
        int ajlcCount = 0;
        int ajlcPageNum = 0;
        int sxggCount = 0;
        int sxggPageNum = 0;
        int wdhmdCount = 0;
        int wdhmdPageNum = 0;
        int bgtCount = 0;
        int bgtPageNum = 0;
        String url = "";
        String data = "";
        JSONObject json = null;


        try {
            Map param = new HashMap();
            param.put("q", nameCN);
            param.put("query", "query");
            data = faHaiInfoService.sendfahaiDataOrderData(param);
            json = JSONObject.parseObject(data);
            //获取各个模块司法数据的条数，用于判断该模块有没有数据
            ktggCount = Tool.StringToInt(json.getString("ktggCount"));
            ktggPageNum = Tool.StringToInt(json.getString("ktggPageNum"));
            cpwsCount = Tool.StringToInt(json.getString("cpwsCount"));
            cpwsPageNum = Tool.StringToInt(json.getString("cpwsPageNum"));
            zxggCount = Tool.StringToInt(json.getString("zxggCount"));
            zxggPageNum = Tool.StringToInt(json.getString("zxggPageNum"));
            fyggCount = Tool.StringToInt(json.getString("fyggCount"));
            fyggPageNum = Tool.StringToInt(json.getString("fyggPageNum"));
            ajlcCount = Tool.StringToInt(json.getString("ajlcCount"));
            ajlcPageNum = Tool.StringToInt(json.getString("ajlcPageNum"));
            sxggCount = Tool.StringToInt(json.getString("shixinCount"));
            sxggPageNum = Tool.StringToInt(json.getString("shixinPageNum"));
            bgtCount = Tool.StringToInt(json.getString("bgtCount"));
            bgtPageNum = Tool.StringToInt(json.getString("bgtPageNum"));
            wdhmdCount = Tool.StringToInt(json.getString("wdhmdCount"));
            wdhmdPageNum = Tool.StringToInt(json.getString("wdhmdPageNum"));
        } catch (Exception e) {
        }

        try {
            //开庭公告
            //先删除数据库已有的开庭公告数据
            List<Ktgg> ktggsList = ktggDao.findByFullReportId(fid);
            for (int i = 0; i < ktggsList.size(); i++) {
                ktggDao.deleteById(ktggsList.get(i).getId());
            }

            if (ktggCount > 0) {
                for (int i = 0; i < ktggPageNum && i < 1; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "ktgg");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        JSONArray ktggList = json.getJSONArray("ktggList");
                        for (int s = 0; s < ktggList.size(); s++) {
                            Ktgg ktgg = new Ktgg();
                            JSONObject ktggObject = ktggList.getJSONObject(s);
                            try {
                                String ktggStr = ktggObject.toJSONString();
                                ktggStr = ktggStr.replace("plaintiff", "plaintiffCN");//原告
                                ktggStr = ktggStr.replace("courtroom", "courtroomCN");//法庭名称
                                ktggStr = ktggStr.replace("party", "parties");//当事人
                                ktggStr = ktggStr.replace("caseCause", "caseCauseCN");//案由
                                ktggStr = ktggStr.replace("judge", "chiefJusticeCN");//法官
                                ktggStr = ktggStr.replace("caseCause", "caseCauseCN");//案由
                                ktggStr = ktggStr.replace("caseNo", "docketNoCN");//案号
                                ktggStr = ktggStr.replace("defendant", "defendantCN");//被告
                                ktgg = JSON.parseObject(ktggStr, Ktgg.class);
                                ktgg.setFullReportId(fid);
                                ktgg.setUpdateTime(updatetime);
                                ktggDao.insert(ktgg);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //执行公告
            //先删除数据库已有的执行公告数据
            List<Executive> zxggsList = executiveDao.findByFullReportId(fid);
            for (int i = 0; i < zxggsList.size(); i++) {
                executiveDao.deleteById(zxggsList.get(i).getId());
            }
            if (zxggCount > 0) {
                for (int i = 0; i < zxggPageNum && i < 1; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "zxgg");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                       /* url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=zxgg&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray zxggList = json.getJSONArray("zxggList");
                        for (int s = 0; s < zxggList.size(); s++) {
                            Executive zxgg = new Executive();
                            JSONObject zxggObject = zxggList.getJSONObject(s);
                            try {
                                String zxggStr = zxggObject.toJSONString();
                                zxggStr = zxggStr.replace("pname", "enforceeNameCn");//被执行人姓名
                                zxggStr = zxggStr.replace("court", "entCourtNameCn");//执行法院名称
                                zxggStr = zxggStr.replace("proposer", "applyName");//申请人
                                zxggStr = zxggStr.replace("caseNo", "docketNoCN");//案号
                                zxggStr = zxggStr.replace("caseState", "caseStatusCN");//案件状态
                                zxggStr = zxggStr.replace("idcardNo", "organizerCode");//身份证/组织机构代码
                                zxggStr = zxggStr.replace("execMoney", "amount");//执行标的
                                zxgg = JSON.parseObject(zxggStr, Executive.class);
                                zxgg.setFullReportId(fid);
                                zxgg.setUpdateTime(updatetime);
                                executiveDao.insert(zxgg);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //裁判文书
            //先删除数据库已有的裁判文书数据
            List<Rulingdocuments> cpwssList = rulingdocumentsDao.findByFullReportId(fid);
            for (int i = 0; i < cpwssList.size(); i++) {
                rulingdocumentsDao.deleteById(cpwssList.get(i).getId());
            }
            if (cpwsCount > 0) {
                for (int i = 0; i < cpwsPageNum && i < 1; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "cpws");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                       /* url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=cpws&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray cpwsList = json.getJSONArray("cpwsList");
                        for (int s = 0; s < cpwsList.size(); s++) {
                            Rulingdocuments cpws = new Rulingdocuments();
                            JSONObject cpwsObject = cpwsList.getJSONObject(s);
                            try {
                                String cpwsStr = cpwsObject.toJSONString();
                                String plaintiffCN = "";//原告
                                String defendantCN = "";//被告
                                JSONArray partys = cpwsObject.getJSONArray("partys");
                                for (int j = 0; j < partys.size(); j++) {
                                    JSONObject party = partys.getJSONObject(j);
                                    String pname = getinfoData(party, "pname");
                                    String title = getinfoData(party, "title");
                                    //取原告,被告
                                    if (title.equals("原告")) {
                                        if (null == plaintiffCN || "".equals(plaintiffCN)) {
                                            plaintiffCN = pname;
                                        } else {
                                            plaintiffCN = plaintiffCN + "," + pname;
                                        }
                                    }
                                    if (title.equals("被告")) {
                                        if (null == defendantCN || "".equals(defendantCN)) {
                                            defendantCN = pname;
                                        } else {
                                            defendantCN = defendantCN + "," + pname;
                                        }
                                    }
                                }
                                cpwsStr = cpwsStr.replace("cpwsyId", "cpwsId");//裁判文书ID
                                cpwsStr = cpwsStr.replace("caseType", "caseTypeCN");//文书类型（案件类型）
                                cpwsStr = cpwsStr.replace("body", "content");//内容
                                cpwsStr = cpwsStr.replace("court", "CourtNameCN");//法院名称
                                cpwsStr = cpwsStr.replace("title", "titleCn");//文书标题
                                cpwsStr = cpwsStr.replace("caseNo", "docketNoCn");//案号
                                cpwsStr = cpwsStr.replace("anyou", "caseCauseId");//案由编码
                                cpwsStr = cpwsStr.replace("anyouType", "caseCauseType");//案由编码类型
                                cpwsStr = cpwsStr.replace("yiju", "reason");//依据
                                cpws = JSON.parseObject(cpwsStr, Rulingdocuments.class);
                                cpws.setPlaintiffCN(plaintiffCN);
                                cpws.setDefendantCN(defendantCN);
                                cpws.setFullReportId(fid);
                                cpws.setUpdateTime(updatetime);
                                rulingdocumentsDao.insert(cpws);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //失信被执行人
            //先删除数据库已有的失信被执行人数据
            List<Sxgg> sxggsList = sxggDao.findByFullReportId(fid);
            for (int i = 0; i < sxggsList.size(); i++) {
                sxggDao.deleteById(sxggsList.get(i).getId());
            }
            if (sxggCount > 0) {
                for (int i = 0; i < sxggPageNum && i < 1; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "sxgg");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=sxgg&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray sxggList = json.getJSONArray("sxggList");
                        for (int s = 0; s < sxggList.size(); s++) {
                            Sxgg sxgg = new Sxgg();
                            JSONObject sxggObject = sxggList.getJSONObject(s);
                            try {
                                String sxggStr = sxggObject.toJSONString();
                                sxggStr = sxggStr.replace("lxqk", "enforceePerformCN");//被执行人的履行情况
                                sxggStr = sxggStr.replace("yjCode", "enforcementBasisNumberCN");//执行依据文号
                                sxggStr = sxggStr.replace("court", "entCourtNameCn");//执行法院名称
                                sxggStr = sxggStr.replace("yjdw", "basisUnitCN");//做出执行依据单位
                                sxggStr = sxggStr.replace("jtqx", "specificCircumstanceCN");//失信被执行人行为具体情形
                                sxggStr = sxggStr.replace("yiwu", "effectiveObligationCN");//生效法律文书确定的义务
                                sxggStr = sxggStr.replace("pname", "enforceeNameCn");//被执行人姓名
                                sxggStr = sxggStr.replace("province", "provinceCN");//被执行人姓名
                                sxggStr = sxggStr.replace("caseNo", "docketNoCN");//案号
                                sxggStr = sxggStr.replace("postTime", "finishDate");//发布日期
                                sxgg = JSON.parseObject(sxggStr, Sxgg.class);
                                sxgg.setFullReportId(fid);
                                sxgg.setUpdateTime(updatetime);
                                sxggDao.insert(sxgg);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //法院公告
            //先删除数据库已有的法院公告数据
            List<Fygg> fyggsList = fyggDao.findByFullReportId(fid);
            for (int i = 0; i < fyggsList.size(); i++) {
                fyggDao.deleteById(fyggsList.get(i).getId());
            }
            if (fyggCount > 0) {
                for (int i = 0; i < fyggPageNum && i < 1; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "fygg");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=fygg&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray fyggList = json.getJSONArray("fyggList");
                        for (int s = 0; s < fyggList.size(); s++) {
                            Fygg fygg = new Fygg();
                            JSONObject fyggObject = fyggList.getJSONObject(s);
                            try {
                                String fyggStr = fyggObject.toJSONString();
                                fyggStr = fyggStr.replace("sortTime", "sortTime");
                                fyggStr = fyggStr.replace("body", "body");
                                fyggStr = fyggStr.replace("fyggId", "fyggId");
                                fyggStr = fyggStr.replace("layout", "layout");
                                fyggStr = fyggStr.replace("relatedParty", "relatedParty");
                                fyggStr = fyggStr.replace("pname", "pname");
                                fyggStr = fyggStr.replace("court", "court");
                                fyggStr = fyggStr.replace("ggType", "ggType");
                                fygg = JSON.parseObject(fyggStr, Fygg.class);
                                fygg.setFullReportId(fid);
                                fygg.setUpdateTime(updatetime);
                                fyggDao.insert(fygg);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //网贷黑名单
            //先删除数据库已有的网贷黑名单数据
            List<Wdhmd> wdhmdsList = wdhmdDao.findByFullReportId(fid);
            for (int i = 0; i < wdhmdsList.size(); i++) {
                wdhmdDao.deleteById(wdhmdsList.get(i).getId());
            }
            if (wdhmdCount > 0) {
                for (int i = 0; i < wdhmdPageNum && i < 1; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "wdhmd");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=wdhmd&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray wdhmdList = json.getJSONArray("wdhmdList");
                        for (int s = 0; s < wdhmdList.size(); s++) {
                            Wdhmd wdhmd = new Wdhmd();
                            JSONObject wdhmdObject = wdhmdList.getJSONObject(s);
                            try {
                                String wdhmdStr = wdhmdObject.toJSONString();
                                wdhmdStr = wdhmdStr.replace("sortTime", "sortTime");
                                wdhmdStr = wdhmdStr.replace("body", "body");
                                wdhmdStr = wdhmdStr.replace("sex", "sex");
                                wdhmdStr = wdhmdStr.replace("phone", "phone");
                                wdhmdStr = wdhmdStr.replace("updateTime", "updateTime");
                                wdhmdStr = wdhmdStr.replace("execCourt", "execCourt");
                                wdhmdStr = wdhmdStr.replace("relatedParty", "relatedParty");
                                wdhmdStr = wdhmdStr.replace("whfx", "whfx");
                                wdhmdStr = wdhmdStr.replace("idcardNo", "idcardNo");
                                wdhmdStr = wdhmdStr.replace("birthPlace", "birthPlace");
                                wdhmdStr = wdhmdStr.replace("bjbx", "bjbx");
                                wdhmdStr = wdhmdStr.replace("caseCode", "caseCode");
                                wdhmdStr = wdhmdStr.replace("address", "address");
                                wdhmdStr = wdhmdStr.replace("email", "email");
                                wdhmdStr = wdhmdStr.replace("sourceName", "sourceName");
                                wdhmdStr = wdhmdStr.replace("age", "age");
                                wdhmdStr = wdhmdStr.replace("pname", "pname");
                                wdhmdStr = wdhmdStr.replace("wdhmdId", "wdhmdId");
                                wdhmdStr = wdhmdStr.replace("datasource", "datasource");
                                wdhmdStr = wdhmdStr.replace("yhje", "yhje");
                                wdhmdStr = wdhmdStr.replace("mobile", "mobile");
                                wdhmd = JSON.parseObject(wdhmdStr, Wdhmd.class);
                                wdhmd.setFullReportId(fid);
                                wdhmd.setUpdateTime(updatetime);
                                wdhmdDao.insert(wdhmd);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //案件流程信息
            //先删除数据库已有的案件流程信息数据
            List<Ajlc> ajlcsList = ajlcDao.findByFullReportId(fid);
            for (int i = 0; i < ajlcsList.size(); i++) {
                ajlcDao.deleteById(ajlcsList.get(i).getId());
            }
            if (ajlcCount > 0) {
                for (int i = 0; i < ajlcPageNum && i < 1; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "ajlc");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        json = JSONObject.parseObject(data);
                        JSONArray ajlcList = json.getJSONArray("ajlcList");
                        for (int s = 0; s < ajlcList.size(); s++) {
                            Ajlc ajlc = new Ajlc();
                            JSONObject ajlcObject = ajlcList.getJSONObject(s);
                            try {
                                String ajlcStr = ajlcObject.toJSONString();
                                ajlcStr = ajlcStr.replace("member", "member");
                                ajlcStr = ajlcStr.replace("sortTime", "sortTime");
                                ajlcStr = ajlcStr.replace("clerkPhone", "clerkPhone");
                                ajlcStr = ajlcStr.replace("caseType", "caseType");
                                ajlcStr = ajlcStr.replace("body", "body");
                                ajlcStr = ajlcStr.replace("trialProcedure", "trialProcedure");
                                ajlcStr = ajlcStr.replace("ajlcId", "ajlcId");
                                ajlcStr = ajlcStr.replace("sentencingDate", "sentencingDate");
                                ajlcStr = ajlcStr.replace("status", "status");
                                ajlcStr = ajlcStr.replace("caseStatus", "caseStatus");
                                ajlcStr = ajlcStr.replace("organizer", "organizer");
                                ajlcStr = ajlcStr.replace("filingDate", "filingDate");
                                ajlcStr = ajlcStr.replace("court", "court");
                                ajlcStr = ajlcStr.replace("ajlcStatus", "ajlcStatus");
                                ajlcStr = ajlcStr.replace("chiefJudge", "chiefJudge");
                                ajlcStr = ajlcStr.replace("caseCause", "caseCause");
                                ajlcStr = ajlcStr.replace("trialLimitDate", "trialLimitDate");
                                ajlcStr = ajlcStr.replace("clerk", "clerk");
                                ajlcStr = ajlcStr.replace("judge", "judge");
                                ajlcStr = ajlcStr.replace("actionObject", "actionObject");
                                ajlcStr = ajlcStr.replace("pname", "pname");
                                ajlcStr = ajlcStr.replace("caseNo", "caseNo");
                                ajlcStr = ajlcStr.replace("effectiveDate", "effectiveDate");
                                ajlc = JSON.parseObject(ajlcStr, Ajlc.class);
                                ajlc.setFullReportId(fid);
                                ajlc.setUpdateTime(updatetime);
                                ajlcDao.insert(ajlc);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            //曝光台
            //先删除数据库已有的案件流程信息数据
            List<Bgt> bgtsList = bgtDao.findByFullReportId(fid);
            for (int i = 0; i < bgtsList.size(); i++) {
                bgtDao.deleteById(bgtsList.get(i).getId());
            }
            if (bgtCount > 0) {
                for (int i = 0; i < bgtPageNum && i < 1; i++) {
                    try {
                        Map param = new HashMap();
                        param.put("q", nameCN);
                        param.put("datatype", "bgt");
                        param.put("pageno", (i + 1));
                        param.put("query", "query");
                        data = faHaiInfoService.sendfahaiDataOrderData(param);
                        /*url = commerceIp + "ssm_dc/fahaiData.do?method=query&datatype=bgt&q="+nameCN+"&pageno="+(i+1);
                        data = HttpUtil.syncData(url);*/
                        json = JSONObject.parseObject(data);
                        JSONArray bgtList = json.getJSONArray("bgtList");
                        for (int s = 0; s < bgtList.size(); s++) {
                            Bgt bgt = new Bgt();
                            JSONObject bgtObject = bgtList.getJSONObject(s);
                            try {
                                String bgtStr = bgtObject.toJSONString();
                                bgtStr = bgtStr.replace("sortTime", "sortTime");
                                bgtStr = bgtStr.replace("body", "body");
                                bgtStr = bgtStr.replace("bgDate", "bgDate");
                                bgtStr = bgtStr.replace("partyType", "partyType");
                                bgtStr = bgtStr.replace("court", "court");
                                bgtStr = bgtStr.replace("proposer", "proposer");
                                bgtStr = bgtStr.replace("idcardNo", "idcardNo");
                                bgtStr = bgtStr.replace("bgtId", "bgtId");
                                bgtStr = bgtStr.replace("caseCause", "caseCause");
                                bgtStr = bgtStr.replace("unnexeMoney", "unnexeMoney");
                                bgtStr = bgtStr.replace("address", "address");
                                bgtStr = bgtStr.replace("pname", "pname");
                                bgtStr = bgtStr.replace("caseNo", "caseNo");
                                bgtStr = bgtStr.replace("yiju", "yiju");
                                bgtStr = bgtStr.replace("execMoney", "execMoney");
                                bgt = JSON.parseObject(bgtStr, Bgt.class);
                                bgt.setFullReportId(fid);
                                bgt.setUpdateTime(updatetime);
                                bgtDao.insert(bgt);
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

        } catch (Exception ex) {

        }


    }


    @Override
    public Page getGlobalLitigationList(FullReport report) {
        Page page = new Page();
        int pageNo = 1;
        int ktggCount = 0;
        int ktggPageNum = 0;
        int cpwsCount = 0;
        int cpwsPageNum = 0;
        int zxggCount = 0;
        int zxggPageNum = 0;
        int fyggCount = 0;
        int fyggPageNum = 0;
        int ajlcCount = 0;
        int ajlcPageNum = 0;
        int sxggCount = 0;
        int sxggPageNum = 0;
        int wdhmdCount = 0;
        int wdhmdPageNum = 0;
        int bgtCount = 0;
        int bgtPageNum = 0;
        String url = "";
        String data = "";
        JSONObject json = null;


        try {
            Map param = new HashMap();
            param.put("q", report.getNameCN());
            param.put("query", "query");
            data = faHaiInfoService.sendfahaiDataOrderData(param);
            json = JSONObject.parseObject(data);
            //获取各个模块司法数据的条数，用于判断该模块有没有数据
            ktggCount = Tool.StringToInt(json.getString("ktggCount"));
            ktggPageNum = Tool.StringToInt(json.getString("ktggPageNum"));
            cpwsCount = Tool.StringToInt(json.getString("cpwsCount"));
            cpwsPageNum = Tool.StringToInt(json.getString("cpwsPageNum"));
            zxggCount = Tool.StringToInt(json.getString("zxggCount"));
            zxggPageNum = Tool.StringToInt(json.getString("zxggPageNum"));
            fyggCount = Tool.StringToInt(json.getString("fyggCount"));
            fyggPageNum = Tool.StringToInt(json.getString("fyggPageNum"));
            ajlcCount = Tool.StringToInt(json.getString("ajlcCount"));
            ajlcPageNum = Tool.StringToInt(json.getString("ajlcPageNum"));
            sxggCount = Tool.StringToInt(json.getString("shixinCount"));
            sxggPageNum = Tool.StringToInt(json.getString("shixinPageNum"));
            bgtCount = Tool.StringToInt(json.getString("bgtCount"));
            bgtPageNum = Tool.StringToInt(json.getString("bgtPageNum"));
            wdhmdCount = Tool.StringToInt(json.getString("wdhmdCount"));
            wdhmdPageNum = Tool.StringToInt(json.getString("wdhmdPageNum"));
        } catch (Exception e) {
        }
        List<Zxgg> list = new ArrayList<>();
        //开庭公告
        if (ktggCount > 0) {
            if (pageNo <= ktggPageNum) {
                try {
                    Map param = new HashMap();
                    param.put("q", report.getNameCN());
                    param.put("datatype", "ktgg");
                    param.put("pageno", pageNo);
                    param.put("query", "query");
                    data = faHaiInfoService.sendfahaiDataOrderData(param);
                    json = JSONObject.parseObject(data);
                    JSONArray ktggList = json.getJSONArray("ktggList");
                    for (int s = 0; s < ktggList.size(); s++) {
                        JSONObject info = ktggList.getJSONObject(s);
                        String strs = info.toString();
                        Zxgg zxgg = new Zxgg();
                        try {
                            zxgg = JSONObject.parseObject(strs, Zxgg.class);
                            zxgg.setSortTimeString(zxgg.getSortTimeString());
                            zxgg.setSortTimes(zxgg.getSortTime());
                            zxgg.setDataType("开庭公告");
                            zxgg.setUpdateTime(updatetime);
                            list.add(zxgg);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        //执行公告
        if (zxggCount > 0) {
            if (pageNo <= zxggPageNum) {
                try {
                    Map param = new HashMap();
                    param.put("q", report.getNameCN());
                    param.put("datatype", "zxgg");
                    param.put("pageno", pageNo);
                    param.put("query", "query");
                    data = faHaiInfoService.sendfahaiDataOrderData(param);
                    json = JSONObject.parseObject(data);
                    JSONArray ktggList = json.getJSONArray("zxggList");
                    for (int s = 0; s < ktggList.size(); s++) {
                        Zxgg zxgg = new Zxgg();
                        JSONObject info = ktggList.getJSONObject(s);
                        String strs = info.toString();
                        try {
                            zxgg = JSONObject.parseObject(strs, Zxgg.class);
                            zxgg.setSortTimeString(zxgg.getSortTimeString());
                            zxgg.setSortTimes(zxgg.getSortTime());
                            zxgg.setDataType("执行公告");
                            zxgg.setUpdateTime(updatetime);
                            list.add(zxgg);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        //裁判文书
        if (cpwsCount > 0) {
            if (pageNo <= cpwsPageNum) {
                try {
                    Map param = new HashMap();
                    param.put("q", report.getNameCN());
                    param.put("datatype", "ktgg");
                    param.put("pageno", pageNo);
                    param.put("query", "query");
                    data = faHaiInfoService.sendfahaiDataOrderData(param);
                    json = JSONObject.parseObject(data);
                    JSONArray ktggList = json.getJSONArray("cpwsList");
                    for (int s = 0; s < ktggList.size(); s++) {
                        Zxgg zxgg = new Zxgg();
                        JSONObject info = ktggList.getJSONObject(s);
                        String strs = info.toString();
                        try {
                            zxgg = JSONObject.parseObject(strs, Zxgg.class);
                            String plaintiffCN = "";//原告
                            String defendantCN = "";//被告
                            JSONArray partys = info.getJSONArray("partys");
                            for (int j = 0; j < partys.size(); j++) {
                                JSONObject party = partys.getJSONObject(j);
                                String pname = getinfoData(party, "pname");
                                String title = getinfoData(party, "title");
                                //取原告,被告
                                if (title.equals("原告")) {
                                    if (null == plaintiffCN || "".equals(plaintiffCN)) {
                                        plaintiffCN = pname;
                                    } else {
                                        plaintiffCN = plaintiffCN + "," + pname;
                                    }
                                }
                                if (title.equals("被告")) {
                                    if (null == defendantCN || "".equals(defendantCN)) {
                                        defendantCN = pname;
                                    } else {
                                        defendantCN = defendantCN + "," + pname;
                                    }
                                }
                            }
                            zxgg.setPlaintiff(plaintiffCN);
                            zxgg.setDefendant(defendantCN);
                            zxgg.setSortTimeString(zxgg.getSortTimeString());
                            zxgg.setSortTimes(zxgg.getSortTime());
                            zxgg.setDataType("裁判文书");
                            list.add(zxgg);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        //法院公告
        if (fyggCount > 0) {
            if (pageNo <= fyggPageNum) {
                try {
                    Map param = new HashMap();
                    param.put("q", report.getNameCN());
                    param.put("datatype", "ktgg");
                    param.put("pageno", pageNo);
                    param.put("query", "query");
                    data = faHaiInfoService.sendfahaiDataOrderData(param);
                    json = JSONObject.parseObject(data);
                    JSONArray ktggList = json.getJSONArray("fyggList");
                    for (int s = 0; s < ktggList.size(); s++) {
                        Zxgg zxgg = new Zxgg();
                        JSONObject info = ktggList.getJSONObject(s);
                        String strs = info.toString();
                        try {
                            zxgg = JSONObject.parseObject(strs, Zxgg.class);
                            zxgg.setSortTimeString(zxgg.getSortTimeString());
                            zxgg.setSortTimes(zxgg.getSortTime());
                            zxgg.setDataType("法院公告");
                            list.add(zxgg);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
                /*for (int i = 0;i<fyggPageNum; i++) {

				}*/
        }
        //案件流程
        if (ajlcCount > 0) {
            if (pageNo <= ajlcPageNum) {
                try {
                    Map param = new HashMap();
                    param.put("q", report.getNameCN());
                    param.put("datatype", "ktgg");
                    param.put("pageno", pageNo);
                    param.put("query", "query");
                    data = faHaiInfoService.sendfahaiDataOrderData(param);
                    json = JSONObject.parseObject(data);
                    JSONArray ktggList = json.getJSONArray("ajlcList");
                    for (int s = 0; s < ktggList.size(); s++) {
                        Zxgg zxgg = new Zxgg();
                        JSONObject info = ktggList.getJSONObject(s);
                        String strs = info.toString();
                        try {
                            zxgg = JSONObject.parseObject(strs, Zxgg.class);
                            zxgg.setSortTimeString(zxgg.getSortTimeString());
                            zxgg.setSortTimes(zxgg.getSortTime());
                            zxgg.setDataType("案件流程");
                            list.add(zxgg);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        //list再排序
        Collections.sort(list, new Comparator<Zxgg>() {
            public int compare(Zxgg o1, Zxgg o2) {
                if (o2.getSortTimes() > o1.getSortTimes()) {
                    return 1;
                }
                if (o1.getSortTimes() == o2.getSortTimes()) {
                    return 0;
                }
                return -1;
            }
        });
        //list
        page.setData(list);
        //总页数
        Integer[] a = {ktggPageNum, cpwsPageNum, zxggPageNum, fyggPageNum, ajlcPageNum};
        int totalPageNum = page.getMaxPageNumber(a);
        page.setTotalPageNum(totalPageNum);
        //总记录数
        page.setTotalCount(ktggCount + cpwsCount + zxggCount + fyggCount + ajlcCount);

        return page;
    }

    @Override
    public Page getGlobaBadList(FullReport report) {
        Page page = new Page();
        int pageNo = 1;
        int wdhmdCount = 0;
        int wdhmdPageNum = 0;
        int shixinCount = 0;
        int shixinPageNum = 0;
        int bgtCount = 0;
        int bgtPageNum = 0;
        String url = "";
        String data = "";
        JSONObject json = null;


        try {
            Map param = new HashMap();
            param.put("q", report.getNameCN());
            param.put("query", "query");
            data = faHaiInfoService.sendfahaiDataOrderData(param);
            json = JSONObject.parseObject(data);
            //获取各个模块司法数据的条数，用于判断该模块有没有数据
            shixinCount = Tool.StringToInt(json.getString("shixinCount"));
            shixinPageNum = Tool.StringToInt(json.getString("shixinPageNum"));
            bgtCount = Tool.StringToInt(json.getString("bgtCount"));
            bgtPageNum = Tool.StringToInt(json.getString("bgtPageNum"));
            wdhmdCount = Tool.StringToInt(json.getString("wdhmdCount"));
            wdhmdPageNum = Tool.StringToInt(json.getString("wdhmdPageNum"));
        } catch (Exception e) {
        }
        List<Sxgg> list = new ArrayList<>();
        //网贷黑名单
        if (wdhmdCount > 0) {
            if (pageNo <= wdhmdPageNum) {
                try {
                    Map param = new HashMap();
                    param.put("q", report.getNameCN());
                    param.put("datatype", "wdhmd");
                    param.put("pageno", pageNo);
                    param.put("query", "query");
                    data = faHaiInfoService.sendfahaiDataOrderData(param);
                    json = JSONObject.parseObject(data);
                    JSONArray ktggList = json.getJSONArray("wdhmdList");
                    for (int s = 0; s < ktggList.size(); s++) {
                        Sxgg sxgg = new Sxgg();
                        JSONObject info = ktggList.getJSONObject(s);
                        String strs = info.toString();
                        try {
                            sxgg = JSONObject.parseObject(strs, Sxgg.class);
                            sxgg.setSortTimeString(sxgg.getSortTimeString());
                            sxgg.setSortTimes(sxgg.getSortTime());
                            list.add(sxgg);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        //失信公告
        if (shixinCount > 0) {
            for (int i = 0; i < shixinPageNum; i++) {
                try {
                    Map param = new HashMap();
                    param.put("q", report.getNameCN());
                    param.put("datatype", "sxgg");
                    param.put("pageno", pageNo);
                    param.put("query", "query");
                    data = faHaiInfoService.sendfahaiDataOrderData(param);
                    json = JSONObject.parseObject(data);
                    JSONArray ktggList = json.getJSONArray("sxggList");
                    for (int s = 0; s < ktggList.size(); s++) {
                        Sxgg sxgg = new Sxgg();
                        JSONObject info = ktggList.getJSONObject(s);
                        String strs = info.toString();
                        try {
                            sxgg = JSONObject.parseObject(strs, Sxgg.class);
                            sxgg.setSortTimeString(sxgg.getSortTimeString());
                            sxgg.setSortTimes(sxgg.getSortTime());
                            list.add(sxgg);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        //曝光台
        if (bgtCount > 0) {
            for (int i = 0; i < bgtPageNum; i++) {
                try {
                    Map param = new HashMap();
                    param.put("q", report.getNameCN());
                    param.put("datatype", "sxgg");
                    param.put("pageno", pageNo);
                    param.put("query", "query");
                    data = faHaiInfoService.sendfahaiDataOrderData(param);
                    json = JSONObject.parseObject(data);
                    JSONArray ktggList = json.getJSONArray("bgtList");
                    for (int s = 0; s < ktggList.size(); s++) {
                        Sxgg sxgg = new Sxgg();
                        JSONObject info = ktggList.getJSONObject(s);
                        String strs = info.toString();
                        try {
                            sxgg = JSONObject.parseObject(strs, Sxgg.class);
                            sxgg.setSortTimeString(sxgg.getSortTimeString());
                            sxgg.setSortTimes(sxgg.getSortTime());
                            list.add(sxgg);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        //list再排序
        Collections.sort(list, new Comparator<Sxgg>() {
            public int compare(Sxgg o1, Sxgg o2) {
                if (o2.getSortTimes() > o1.getSortTimes()) {
                    return 1;
                }
                if (o1.getSortTimes() == o2.getSortTimes()) {
                    return 0;
                }
                return -1;
            }
        });
        //list
        page.setData(list);
        //总页数
        Integer[] a = {wdhmdPageNum, shixinPageNum, bgtPageNum};
        int totalPageNum = page.getMaxPageNumber(a);
        page.setTotalPageNum(totalPageNum);
        //总记录数
        page.setTotalCount(wdhmdCount + shixinCount + bgtCount);
        page.setWdhmdCount(wdhmdCount);
        page.setShixinCount(shixinCount);
        page.setBgtCount(bgtCount);
        return page;
    }


    @Override
    public void saveBusiness(FullReport report) {
        if (report != null && report.getId() != null) {
            Integer fid = report.getId();
            //report = this.getFaHaiReport(report);//需要存库的数据
            Integer fullReportId = null;
            FullReport byName = fullReportDao.findByName(report.getNameCN());
            if (byName != null) {
                fullReportId = byName.getId();
            }
            List<Ktgg> ktggs = report.getKtggList();
            if (CollectionUtils.isNotEmpty(ktggs)) {
                //开庭公告
                if (fullReportId != null) {
                    List<Ktgg> ktggsList = ktggDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < ktggsList.size(); i++) {
                        ktggDao.deleteById(ktggsList.get(i).getId());
                    }
                }
                for (Ktgg ktgg : ktggs) {
                    ktgg.setFullReportId(fid);
                    ktgg.setUpdateTime(DateUtil.getCurrentDate());
                    ktggDao.insert(ktgg);
                }

            }
            List<Executive> executives = report.getExecutiveList();
            if (CollectionUtils.isNotEmpty(executives)) {
                //执行公告
                if (fullReportId != null) {
                    List<Executive> zxggsList = executiveDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < zxggsList.size(); i++) {
                        executiveDao.deleteById(zxggsList.get(i).getId());
                    }
                }
                for (Executive executive : executives) {
                    executive.setFullReportId(fid);
                    executive.setUpdateTime(DateUtil.getCurrentDate());
                    executiveDao.insert(executive);
                }
            }

            List<Rulingdocuments> rulingdocumentses = report.getRulingdocumentsList();
            if (CollectionUtils.isNotEmpty(rulingdocumentses)) {
                //裁判文书
                if (fullReportId != null) {
                    List<Rulingdocuments> cpwssList = rulingdocumentsDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < cpwssList.size(); i++) {
                        rulingdocumentsDao.deleteById(cpwssList.get(i).getId());
                    }
                }
                for (Rulingdocuments rulingdocuments : rulingdocumentses) {
                    rulingdocuments.setFullReportId(fid);
                    rulingdocuments.setUpdateTime(DateUtil.getCurrentDate());
                    rulingdocumentsDao.insert(rulingdocuments);
                }
            }
            List<Sxgg> sxggs = report.getSxggList();
            if (CollectionUtils.isNotEmpty(sxggs)) {
                //失信被执行人
                if (fullReportId != null) {
                    List<Sxgg> sxggsList = sxggDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < sxggsList.size(); i++) {
                        sxggDao.deleteById(sxggsList.get(i).getId());
                    }
                }
                for (Sxgg sxgg : sxggs) {
                    sxgg.setFullReportId(fid);
                    sxgg.setUpdateTime(DateUtil.getCurrentDate());
                    sxggDao.insert(sxgg);
                }
            }

            List<Fygg> fyggList = report.getFyggList();
            if (CollectionUtils.isNotEmpty(fyggList)) {
                //法院公告
                if (fullReportId != null) {
                    List<Fygg> fyggsList = fyggDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < fyggsList.size(); i++) {
                        fyggDao.deleteById(fyggsList.get(i).getId());
                    }
                }
                for (Fygg fygg : fyggList) {
                    fygg.setFullReportId(fid);
                    fygg.setUpdateTime(DateUtil.getCurrentDate());
                    fyggDao.insert(fygg);
                }
            }

            List<Wdhmd> wdhmds = report.getWdhmdList();
            if (CollectionUtils.isNotEmpty(wdhmds)) {
                //网贷黑名单
                if (fullReportId != null) {
                    List<Wdhmd> wdhmdsList = wdhmdDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < wdhmdsList.size(); i++) {
                        wdhmdDao.deleteById(wdhmdsList.get(i).getId());
                    }
                }
                for (Wdhmd wdhmd : wdhmds) {
                    wdhmd.setFullReportId(fid);
                    wdhmd.setUpdateTime(DateUtil.getCurrentDate());
                    wdhmdDao.insert(wdhmd);
                }
            }
            List<Ajlc> ajlcs = report.getAjlcList();
            if (CollectionUtils.isNotEmpty(ajlcs)) {
                //案件流程信息
                if (fullReportId != null) {
                    List<Ajlc> ajlcsList = ajlcDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < ajlcsList.size(); i++) {
                        ajlcDao.deleteById(ajlcsList.get(i).getId());
                    }
                }
                for (Ajlc ajlc : ajlcs) {
                    ajlc.setFullReportId(fid);
                    ajlc.setUpdateTime(DateUtil.getCurrentDate());
                    ajlcDao.insert(ajlc);
                }
            }
            List<Bgt> bgts = report.getBgtList();
            if (CollectionUtils.isNotEmpty(bgts)) {
                //曝光台
                if (fullReportId != null) {
                    List<Bgt> bgtsList = bgtDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < bgtsList.size(); i++) {
                        bgtDao.deleteById(bgtsList.get(i).getId());
                    }
                }
                for (Bgt bgt : bgts) {
                    bgt.setFullReportId(fid);
                    bgt.setUpdateTime(DateUtil.getCurrentDate());
                    bgtDao.insert(bgt);
                }
            }

        }
    }

    @Override
    public FullReport getFaHaiReport(FullReport report) {
        if (report != null && StringUtils.isNotBlank(report.getNameCN())) {
            String qixinbaoUrl = null;
            Integer fullReportId = report.getId();
            String companyName = report.getNameCN();
            try {
                qixinbaoUrl = FAHAIURL + "?companyName=" + URLEncoder.encode(companyName, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String qixinbaoData = HttpUtil.syncData(qixinbaoUrl);
            JSONObject qixinbaoObject = JSON.parseObject(qixinbaoData);
            Boolean qixinbaoCode = qixinbaoObject.getBoolean("code");
            if (qixinbaoCode) {
                report = qixinbaoObject.getObject("content", FullReport.class);
                report.setId(fullReportId);
                report.setNameCN(companyName);
                report.setUpdateTime(DateUtil.getCurrentDate());
                report.setLitigationUpdateTime(DateUtil.getCurrentDate());
            }

        }
        return report;

    }

    @Override
    public FullReport copyFullreport(FullReport report) {
        if (report != null) {
            FullReport faHaiReport = this.getFaHaiReport(report);
            if (faHaiReport != null) {
                List<Ajlc> ajlcList = faHaiReport.getAjlcList();
                if (CollectionUtils.isNotEmpty(ajlcList)) {
                    report.setAjlcList(ajlcList);
                }
                List<Executive> executiveList = faHaiReport.getExecutiveList();
                if (CollectionUtils.isNotEmpty(executiveList)) {
                    report.setExecutiveList(executiveList);
                }
                List<Fygg> fyggList = faHaiReport.getFyggList();
                if (CollectionUtils.isNotEmpty(fyggList)) {
                    report.setFyggList(fyggList);
                }
                List<Ktgg> ktggList = faHaiReport.getKtggList();
                if (CollectionUtils.isNotEmpty(ktggList)) {
                    report.setKtggList(ktggList);
                }
                List<Rulingdocuments> rulingdocumentses = faHaiReport.getRulingdocumentsList();
                if (CollectionUtils.isNotEmpty(rulingdocumentses)) {
                    report.setRulingdocumentsList(rulingdocumentses);
                }
                List<Sxgg> sxggList = faHaiReport.getSxggList();
                if (CollectionUtils.isNotEmpty(sxggList)) {
                    report.setSxggList(sxggList);
                }
                List<Bgt> bgtList = faHaiReport.getBgtList();
                if (CollectionUtils.isNotEmpty(bgtList)) {
                    report.setBgtList(bgtList);
                }
                List<Wdhmd> wdhmdList = faHaiReport.getWdhmdList();
                if (CollectionUtils.isNotEmpty(wdhmdList)) {
                    report.setWdhmdList(wdhmdList);
                }
            }

        }
        return report;
    }
}
