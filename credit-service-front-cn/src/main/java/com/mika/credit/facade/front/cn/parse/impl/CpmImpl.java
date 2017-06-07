package com.mika.credit.facade.front.cn.parse.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.util.DateUtil;
import com.mika.credit.facade.front.cn.dao.*;
import com.mika.credit.facade.front.cn.parse.Cpm;
import com.mika.credit.facade.front.cn.service.BankInfosService;
import com.mika.credit.facade.front.cn.util.HttpUtil;
import com.mika.credit.facade.front.cn.util.Tool;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by dong jian hua on 2017/2/18.
 */
@SuppressWarnings("Duplicates")
@Service("cpm")
public class CpmImpl implements Cpm {

    @Autowired
    BasicInfosDao basicInfosDao;
    @Autowired
    RegistrationInfosDao registrationInfosDao;
    @Autowired
    ChangeInfosDao changeInfosDao;
    @Autowired
    ShareholderInfosDao shareholderInfosDao;
    @Autowired
    ManagementsDao managementsDao;
    @Autowired
    EntinvinfosDao entinvinfosDao;
    @Autowired
    FrinvinfosDao frinvinfosDao;
    @Autowired
    FrpositioninfosDao frpositioninfosDao;
    @Autowired
    FinancialStatementDao financialStatementDao;
    @Autowired
    FinancialFiguresDao financialFiguresDao;
    @Autowired
    RulingdocumentsDao rulingdocumentsDao;
    @Autowired
    ExecutiveDao executiveDao;
    @Autowired
    SxggDao sxggDao;
    @Autowired
    BrandsDao brandsDao;
    @Autowired
    IcpWebsiteDao icpWebsiteDao;
    @Autowired
    FinancialRatiosDao financialRatiosDao;
    @Autowired
    RelatedCompaniesDao relatedCompaniesDao;
    @Autowired
    OperatingsDao operatingsDao;
    @Autowired
    BankInfosService bankInfosService;
    @Autowired
    PaymentHistoriesDao paymentHistoriesDao;
    @Autowired
    TradeReferencesDao tradeReferencesDao;
    @Autowired
    KtggDao ktggDao;
    @Autowired
    OtherInfosDao otherInfosDao;
    @Autowired
    FullReportDao fullReportDao;
    @Autowired
    CustomHouseDao customHouseDao;

    //Cpm数据
    String cpmData = "";

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String updatetime = format.format(new Date());

    @Override
    public void getCpmAllList(FullReport report) {
        String basicName = report.getNameCN();
        String url = Tool.loadUrl("cpmUrl");
        url += report.getNameCN();
        String data = HttpUtil.syncData(url);
        JSONObject result = JSONObject.parseObject(data);
        JSONObject dataObject = result.getJSONObject("data");
        report.setNameCN(Tool.replaceSymbol(report.getNameCN()));
        FullReport fullReport = fullReportDao.findByName(report.getNameCN());
        int fid = 0;
        if (null != fullReport && null != fullReport.getId()) {
            fid = fullReport.getId();
        }

        BasicInfos historyBasic = basicInfosDao.findByNameCN(report.getNameCN());
        //企业基本信息
        BasicInfos basics = new BasicInfos();
        JSONArray basicinfosList = dataObject.getJSONArray("basicinfos");
        if (null != basicinfosList && basicinfosList.size() > 0) {
            for (int i = 0; i < basicinfosList.size(); i++) {
                JSONObject basicsObject = basicinfosList.getJSONObject(i);
                String basicsStr = basicsObject.toJSONString();
                basics = JSON.parseObject(basicsStr, BasicInfos.class);
                basics.setNameCN(Tool.replaceSymbol(basics.getNameCN()));
                basics.setUpdateTime(updatetime);
                if (null != historyBasic && null != historyBasic.getId()) {
                    basics.setFullReportId(fid);
                    basics.setId(historyBasic.getId());
                    basicInfosDao.update(basics);
                } else {
                    basicInfosDao.insert(basics);
                    historyBasic = basicInfosDao.findByNameCN(report.getNameCN());
                    fid = historyBasic.getId();
                }
            }
        }

        //企业注册信息
        //先删除数据库已有的企业注册信息数据
        RegistrationInfos hisReginfos = registrationInfosDao.findByFullReportId(fid);
        if (null != hisReginfos && null != hisReginfos.getId()) {
            registrationInfosDao.deleteById(hisReginfos.getId());
        }

        //企业注册信息
        RegistrationInfos reginfos = new RegistrationInfos();
        JSONArray reginfosArr = dataObject.getJSONArray("reginfos");
        if (null != reginfosArr && reginfosArr.size() > 0) {
            for (int i = 0; i < reginfosArr.size(); i++) {
                JSONObject reginfosObject = reginfosArr.getJSONObject(i);
                String reginfosStr = reginfosObject.toJSONString();
                reginfos = JSON.parseObject(reginfosStr, RegistrationInfos.class);
                reginfos.setFullReportId(fid);
                reginfos.setUpdateTime(updatetime);
                registrationInfosDao.insert(reginfos);
            }
        }

        //工商注册变更
        //先删除数据库已有的工商注册变更数据
        List<ChangeInfos> changginfosList = changeInfosDao.findByFullReportId(fid);
        for (int i = 0; i < changginfosList.size(); i++) {
            changeInfosDao.deleteById(changginfosList.get(i).getId());
        }

        //工商注册变更
        ChangeInfos changginfos = new ChangeInfos();
        JSONArray changginfosArr = dataObject.getJSONArray("changginfos");
        if (null != changginfosArr && changginfosArr.size() > 0) {
            for (int i = 0; i < changginfosArr.size(); i++) {
                JSONObject changginfosObject = changginfosArr.getJSONObject(i);
                String changginfosStr = changginfosObject.toJSONString();
                changginfos = JSON.parseObject(changginfosStr, ChangeInfos.class);
                changginfos.setId(fid);
                changginfos.setUpdateTime(updatetime);
                changeInfosDao.insert(changginfos);
            }
        }

        //股东信息
        //先删除数据库已有的股东信息数据
        List<ShareholderInfos> shareInfosList = shareholderInfosDao.findByFullReportId(fid);
        for (int i = 0; i < shareInfosList.size(); i++) {
            shareholderInfosDao.deleteById(shareInfosList.get(i).getId());
        }
        //股东信息
        ShareholderInfos shareInfos = new ShareholderInfos();
        JSONArray shareInfosArr = dataObject.getJSONArray("shareInfos");
        if (null != shareInfosArr && shareInfosArr.size() > 0) {
            for (int i = 0; i < shareInfosArr.size(); i++) {
                JSONObject shareInfosObject = shareInfosArr.getJSONObject(i);
                String shareInfosStr = shareInfosObject.toJSONString();
                shareInfos = JSON.parseObject(shareInfosStr, ShareholderInfos.class);
                shareInfos.setId(fid);
                shareInfos.setUpdateTime(updatetime);
                shareholderInfosDao.insert(shareInfos);
            }
        }

        //管理者信息
        //先删除数据库已有的管理者信息数据
        List<Managements> manageInfosList = managementsDao.findByFullReportId(fid);
        for (int i = 0; i < manageInfosList.size(); i++) {
            managementsDao.deleteById(manageInfosList.get(i).getId());
        }

        //管理者信息
        Managements manageInfos = new Managements();
        JSONArray manageInfosArr = dataObject.getJSONArray("manageInfos");
        if (null != manageInfosArr && manageInfosArr.size() > 0) {
            for (int i = 0; i < manageInfosArr.size(); i++) {
                JSONObject manageInfosObject = manageInfosArr.getJSONObject(i);
                String manageInfosStr = manageInfosObject.toJSONString();
                manageInfos = JSON.parseObject(manageInfosStr, Managements.class);
                manageInfos.setId(fid);
                manageInfos.setUpdateTime(updatetime);
                managementsDao.insert(manageInfos);
            }
        }

        //企业对外投资
        //先删除数据库已有的企业对外投资数据
//        List<Entinvinfos> entinvInfosList = entinvinfosDao.findByFullReportId(crefoNos);
//        for (int i =0;i<entinvInfosList.size();i++){
//            entinvinfosDao.delete(entinvInfosList.get(i));
//        }

        //todo
        //企业对外投资
//        Entinvinfos entinvInfos = new Entinvinfos();
//        JSONArray entinvInfosArr = dataObject.getJSONArray("entinvInfos");
//        if(null != entinvInfosArr && entinvInfosArr.size()>0) {
//            for(int i=0; i<entinvInfosArr.size(); i++){
//                JSONObject entinvInfosObject = entinvInfosArr.getJSONObject(i);
//                String entinvInfosStr = entinvInfosObject.toJSONString();
//                entinvInfos = JSON.parseObject(entinvInfosStr,Entinvinfos.class);
//                entinvInfos.setId(crefoNos);
//                entinvinfosDao.insert(entinvInfos);
//            }
//        }

        //法人对外投资
        //先删除数据库已有的法人对外投资数据
        List<Frinvinfos> frinvInfosList = frinvinfosDao.findByFullReportId(fid);
        for (int i = 0; i < frinvInfosList.size(); i++) {
            frinvinfosDao.deleteById(frinvInfosList.get(i).getId());
        }

        //todo
//            //法人对外投资
//        Frinvinfos frinvInfos = new Frinvinfos();
//        JSONArray frinvInfosArr = dataObject.getJSONArray("frinvInfos");
//        if(null != frinvInfosArr && frinvInfosArr.size()>0) {
//            for(int i=0; i<frinvInfosArr.size(); i++){
//                JSONObject frinvInfosObject = frinvInfosArr.getJSONObject(i);
//                String frinvInfosStr = frinvInfosObject.toJSONString();
//                frinvInfos = JSON.parseObject(frinvInfosStr,Frinvinfos.class);
//                frinvInfos.setId(crefoNos);
//                frinvinfosDao.insert(frinvInfos);
//            }
//        }

        //法人在外任职
        //先删除数据库已有的法人在外任职数据
//        List<Frpositioninfos> frpositInfosList = frpositioninfosDao.findByFullReportId(crefoNos);
//        for (int i =0;i<frpositInfosList.size();i++){
//            frpositioninfosDao.delete(frpositInfosList.get(i));
//        }

        //法人在外任职
//        Frpositioninfos frpositInfos = new Frpositioninfos();
//        JSONArray frpositInfosArr = dataObject.getJSONArray("frpositInfos");
//        if(null != frpositInfosArr && frpositInfosArr.size()>0) {
//            for (int i = 0; i < frpositInfosArr.size(); i++) {
//                JSONObject frpositInfosObject = frpositInfosArr.getJSONObject(i);
//                String manageInfosStr = frpositInfosObject.toJSONString();
//                frpositInfos = JSON.parseObject(manageInfosStr, Frpositioninfos.class);
//                frpositInfos.setId(crefoNos);
//                frpositioninfosDao.insert(frpositInfos);
//            }
//        }

        //财务数据
        //先删除数据库已有的财务数据
        List<FinancialStatement> finanInfosList = financialStatementDao.findByFullReportId(fid);
        for (int i = 0; i < finanInfosList.size(); i++) {
            financialStatementDao.deleteById(finanInfosList.get(i).getId());
        }

        //财务数据
        FinancialStatement finanInfos = new FinancialStatement();
        JSONArray finanInfosArr = dataObject.getJSONArray("finanInfos");
        if (null != finanInfosArr && finanInfosArr.size() > 0) {
            for (int i = 0; i < finanInfosArr.size(); i++) {
                JSONObject finanInfosObject = finanInfosArr.getJSONObject(i);
                String finanInfosStr = finanInfosObject.toJSONString();
                finanInfos = JSON.parseObject(finanInfosStr, FinancialStatement.class);
                finanInfos.setId(fid);
                finanInfos.setUpdateTime(updatetime);
                financialStatementDao.insert(finanInfos);
            }
        }

        //财务分析
        //先删除数据库已有的财务分析数据
        List<FinancialRatios> ratioinfosList = financialRatiosDao.findByFullReportId(fid);
        for (int i = 0; i < ratioinfosList.size(); i++) {
            financialRatiosDao.deleteById(ratioinfosList.get(i).getId());
        }

        //财务分析数据
        FinancialRatios ratioinfos = new FinancialRatios();
        JSONArray ratioinfosArr = dataObject.getJSONArray("ratioinfos");
        if (null != ratioinfosArr && ratioinfosArr.size() > 0) {
            for (int i = 0; i < ratioinfosArr.size(); i++) {
                JSONObject ratioinfosObject = ratioinfosArr.getJSONObject(i);
                String ratioinfosStr = ratioinfosObject.toJSONString();
                ratioinfos = JSON.parseObject(ratioinfosStr, FinancialRatios.class);
                ratioinfos.setId(fid);
                ratioinfos.setUpdateTime(updatetime);
                financialRatiosDao.insert(ratioinfos);
            }
        }

        //裁判文书
        //先删除数据库已有的裁判文书数据
        List<Rulingdocuments> rulingdocumentinfosList = rulingdocumentsDao.findByFullReportId(fid);
        for (int i = 0; i < rulingdocumentinfosList.size(); i++) {
            rulingdocumentsDao.deleteById(rulingdocumentinfosList.get(i).getId());
        }
        //裁判文书
        Rulingdocuments rulingdocumentinfos = new Rulingdocuments();
        JSONArray rulingdocumentinfosArr = dataObject.getJSONArray("rulingdocumentinfos");
        if (null != rulingdocumentinfosArr && rulingdocumentinfosArr.size() > 0) {
            for (int i = 0; i < rulingdocumentinfosArr.size(); i++) {
                JSONObject rulingdocumentinfosObject = rulingdocumentinfosArr.getJSONObject(i);
                String rulingdocumentinfosStr = rulingdocumentinfosObject.toJSONString();
                rulingdocumentinfos = JSON.parseObject(rulingdocumentinfosStr, Rulingdocuments.class);
                rulingdocumentinfos.setId(fid);
                rulingdocumentinfos.setUpdateTime(updatetime);
                rulingdocumentsDao.insert(rulingdocumentinfos);
            }
        }

        //执行记录
        //先删除数据库已有的执行记录数据
        List<Executive> executiveinfosList = executiveDao.findByFullReportId(fid);
        for (int i = 0; i < executiveinfosList.size(); i++) {
            executiveDao.deleteById(executiveinfosList.get(i).getId());
        }
        //执行记录
        Executive executiveinfos = new Executive();
        JSONArray executiveinfosArr = dataObject.getJSONArray("executiveinfos");
        if (null != executiveinfosArr && executiveinfosArr.size() > 0) {
            for (int i = 0; i < executiveinfosArr.size(); i++) {
                JSONObject executiveinfosObject = executiveinfosArr.getJSONObject(i);
                String executiveinfosStr = executiveinfosObject.toJSONString();
                executiveinfos = JSON.parseObject(executiveinfosStr, Executive.class);
                executiveinfos.setId(fid);
                executiveinfos.setUpdateTime(updatetime);
                executiveDao.insert(executiveinfos);
            }
        }


        //失信记录
        //先删除数据库已有的失信记录数据
//        List<Sxgg> sxggInfosList = sxggDao.findByFullReportId(crefoNos);
//        for (int i =0;i<sxggInfosList.size();i++){
//            sxggDao.delete(sxggInfosList.get(i));
//        }
//            //失信记录
//            Sxgg sxggInfos = new Sxgg();
//            JSONArray sxggInfosArr = dataObject.getJSONArray("sxggInfos");
//            if(null != sxggInfosArr && sxggInfosArr.size()>0) {
//                for (int i = 0; i < sxggInfosArr.size(); i++) {
//                    JSONObject sxggInfosObject = sxggInfosArr.getJSONObject(i);
//                    String sxggInfosStr = sxggInfosObject.toJSONString();
//                    sxggInfos = JSON.parseObject(sxggInfosStr, Sxgg.class);
//                    sxggInfos.setId(crefoNos);
//                    sxggDao.insert(sxggInfos);
//                }
//            }


        //品牌专利
        //先删除数据库已有的品牌专利数据
//        List<Brands> brandsInfosList = brandsDao.findByFullReportId(crefoNos);
//        for (int i =0;i<brandsInfosList.size();i++){
//            brandsDao.delete(brandsInfosList.get(i));
//        }

//
//            //品牌专利
//            Brands brandsInfos = new Brands();
//            JSONArray brandsInfosArr = dataObject.getJSONArray("brandsInfos");
//            if(null != brandsInfosArr && brandsInfosArr.size() > 0){
//              for(int i=0; i<brandsInfosArr.size(); i++){
//                  JSONObject brandsInfosObject = brandsInfosArr.getJSONObject(i);
//                  String brandsInfosStr = brandsInfosObject.toJSONString();
//                  brandsInfos = JSON.parseObject(brandsInfosStr,Brands.class);
//                  brandsInfos.setId(crefoNos);
//                  brandsDao.insert(brandsInfos);
//              }
//            }
//
//
//


        //互联网登记
        //先删除数据库已有的互联网登记数据
//        List<IcpWebsite> icpWebsiteInfosList = icpWebsiteDao.findByFullReportId(crefoNos);
//        for (int i =0;i<icpWebsiteInfosList.size();i++){
//            icpWebsiteDao.delete(icpWebsiteInfosList.get(i));
//        }
       /*
        //互联网登记
        IcpWebsite icpWebsiteInfos = new IcpWebsite();
        JSONArray icpWebsiteInfosArr = dataObject.getJSONArray("icpWebsiteInfos");
        if(null != icpWebsiteInfosArr && icpWebsiteInfosArr.size() > 0){
            for(int i=0; i<icpWebsiteInfosArr.size(); i++){
                JSONObject icpWebsiteInfosObject = icpWebsiteInfosArr.getJSONObject(i);
                String brandsInfosStr = icpWebsiteInfosObject.toJSONString();
                icpWebsiteInfos = JSON.parseObject(brandsInfosStr,IcpWebsite.class);
                icpWebsiteInfos.setId(crefoNos);
                icpWebsiteDao.insert(icpWebsiteInfos);
            }
        }
        */


        //关联公司
        //先删除数据库已有的关联公司数据
        List<RelatedCompanies> relatedinfosList = relatedCompaniesDao.findByFullReportId(fid);
        for (int i = 0; i < relatedinfosList.size(); i++) {
            relatedCompaniesDao.deleteById(relatedinfosList.get(i).getId());
        }

        //关联公司数据
        RelatedCompanies relatedinfos = new RelatedCompanies();
        JSONArray relatedinfosArr = dataObject.getJSONArray("relatedinfos");
        if (null != relatedinfosArr && relatedinfosArr.size() > 0) {
            for (int i = 0; i < relatedinfosArr.size(); i++) {
                JSONObject relatedinfosObject = relatedinfosArr.getJSONObject(i);
                String relatedinfosStr = relatedinfosObject.toJSONString();
                relatedinfos = JSON.parseObject(relatedinfosStr, RelatedCompanies.class);
                relatedinfos.setId(fid);
                relatedinfos.setUpdateTime(updatetime);
                relatedCompaniesDao.insert(relatedinfos);
            }
        }


        //经营现状
        //先删除数据库已有的经营现状数据
        List<Operatings> operatingsinfosList = operatingsDao.findByFullReportId(fid);
        for (int i = 0; i < operatingsinfosList.size(); i++) {
            operatingsDao.deleteById(operatingsinfosList.get(i).getId());
        }

        //经营现状数据
        Operatings operatingsinfos = new Operatings();
        JSONArray operatingsinfosArr = dataObject.getJSONArray("operatingsinfos");
        if (null != operatingsinfosArr && operatingsinfosArr.size() > 0) {
            for (int i = 0; i < operatingsinfosArr.size(); i++) {
                JSONObject operatingsinfosObject = operatingsinfosArr.getJSONObject(i);
                String operatingsinfosStr = operatingsinfosObject.toJSONString();
                operatingsinfos = JSON.parseObject(operatingsinfosStr, Operatings.class);
                operatingsinfos.setId(fid);
                operatingsinfos.setUpdateTime(updatetime);
                operatingsDao.insert(operatingsinfos);
            }
        }

        //银行信息
        //先删除数据库已有的银行信息数据
        List<BankInfos> bankinfosList = bankInfosService.findByFullReportId(fid);
        for (int i = 0; i < bankinfosList.size(); i++) {
            bankInfosService.deleteById(bankinfosList.get(i));
        }

        //银行信息数据
        BankInfos bankinfos = new BankInfos();
        JSONArray bankinfosArr = dataObject.getJSONArray("bankinfos");
        if (null != bankinfosArr && bankinfosArr.size() > 0) {
            for (int i = 0; i < bankinfosArr.size(); i++) {
                JSONObject bankinfosObject = bankinfosArr.getJSONObject(i);
                String bankinfosStr = bankinfosObject.toJSONString();
                bankinfos = JSON.parseObject(bankinfosStr, BankInfos.class);
                bankinfos.setId(fid);
                bankinfos.setUpdateTime(updatetime);
                bankInfosService.insert(bankinfos);
            }
        }

        //支付款记录
        //先删除数据库已有的支付款记录数据
        List<PaymentHistories> paymentHistoriesinfosList = paymentHistoriesDao.findByFullReportId(fid);
        for (int i = 0; i < paymentHistoriesinfosList.size(); i++) {
            paymentHistoriesDao.deleteById(paymentHistoriesinfosList.get(i).getId());
        }

        //支付款记录数据
        PaymentHistories paymentHistoriesinfos = new PaymentHistories();
        JSONArray paymentHistoriesinfosArr = dataObject.getJSONArray("paymentHistoriesinfos");
        if (null != paymentHistoriesinfosArr && paymentHistoriesinfosArr.size() > 0) {
            for (int i = 0; i < paymentHistoriesinfosArr.size(); i++) {
                JSONObject paymentHistoriesinfosObject = paymentHistoriesinfosArr.getJSONObject(i);
                String paymentHistoriesinfosStr = paymentHistoriesinfosObject.toJSONString();
                paymentHistoriesinfos = JSON.parseObject(paymentHistoriesinfosStr, PaymentHistories.class);
                paymentHistoriesinfos.setId(fid);
                paymentHistoriesinfos.setUpdateTime(updatetime);
                paymentHistoriesDao.insert(paymentHistoriesinfos);
            }
        }


        //贸易参考
        //先删除数据库已有的贸易参考数据
        List<TradeReferences> tradeReferencesList = tradeReferencesDao.findByFullReportId(fid);
        for (int i = 0; i < tradeReferencesList.size(); i++) {
            tradeReferencesDao.deleteById(tradeReferencesList.get(i).getId());
        }

        //贸易参考数据(供应商flag：0)
        TradeReferences suppliersinfos = new TradeReferences();
        JSONArray suppliersinfosArr = dataObject.getJSONArray("suppliersinfos");
        if (null != suppliersinfosArr && suppliersinfosArr.size() > 0) {
            for (int i = 0; i < suppliersinfosArr.size(); i++) {
                JSONObject suppliersinfosObject = suppliersinfosArr.getJSONObject(i);
                String suppliersinfosStr = suppliersinfosObject.toJSONString();
                suppliersinfos = JSON.parseObject(suppliersinfosStr, TradeReferences.class);
                suppliersinfos.setId(fid);
                suppliersinfos.setFlag("0");
                suppliersinfos.setUpdateTime(updatetime);
                tradeReferencesDao.insert(suppliersinfos);
            }
        }

        //贸易参考数据(客户flag：1)
        TradeReferences clientinfos = new TradeReferences();
        JSONArray clientinfosArr = dataObject.getJSONArray("clientinfos");
        if (null != clientinfosArr && clientinfosArr.size() > 0) {
            for (int i = 0; i < clientinfosArr.size(); i++) {
                JSONObject clientinfosObject = clientinfosArr.getJSONObject(i);
                String clientinfosStr = clientinfosObject.toJSONString();
                clientinfos = JSON.parseObject(clientinfosStr, TradeReferences.class);
                clientinfos.setId(fid);
                clientinfos.setFlag("1");
                clientinfos.setUpdateTime(updatetime);
                tradeReferencesDao.insert(clientinfos);
            }
        }


        //开庭公告
        //先删除数据库已有的开庭公告数据
        List<Ktgg> ktgginfosList = ktggDao.findByFullReportId(fid);
        for (int i = 0; i < ktgginfosList.size(); i++) {
            ktggDao.deleteById(ktgginfosList.get(i).getId());
        }

        //开庭公告数据
        Ktgg ktgginfos = new Ktgg();
        JSONArray ktgginfosArr = dataObject.getJSONArray("ktgginfos");
        if (null != ktgginfosArr && ktgginfosArr.size() > 0) {
            for (int i = 0; i < ktgginfosArr.size(); i++) {
                JSONObject ktgginfosObject = ktgginfosArr.getJSONObject(i);
                String ktgginfosStr = ktgginfosObject.toJSONString();
                ktgginfos = JSON.parseObject(ktgginfosStr, Ktgg.class);
                ktgginfos.setId(fid);
                ktgginfos.setUpdateTime(updatetime);
                ktggDao.insert(ktgginfos);
            }
        }


        //财物说明
        //先删除数据库已有的财物说明数据
        List<FinancialFigures> financialFigureinfosList = financialFiguresDao.findByFullReportId(fid);
        for (int i = 0; i < financialFigureinfosList.size(); i++) {
            financialFiguresDao.deleteById(financialFigureinfosList.get(i).getId());
        }

        //财物说明
        FinancialFigures financialFigureinfos = new FinancialFigures();
        JSONArray financialFigureinfosArr = dataObject.getJSONArray("financialFigureinfos");
        if (null != financialFigureinfosArr && financialFigureinfosArr.size() > 0) {
            for (int i = 0; i < financialFigureinfosArr.size(); i++) {
                JSONObject financialFigureinfosObject = financialFigureinfosArr.getJSONObject(i);
                String financialFigureinfosStr = financialFigureinfosObject.toJSONString();
                financialFigureinfos = JSON.parseObject(financialFigureinfosStr, FinancialFigures.class);
                financialFigureinfos.setId(fid);
                financialFigureinfos.setUpdateTime(updatetime);
                financialFiguresDao.insert(financialFigureinfos);
            }
        }


        //其他信息
        //先删除数据库已有的其他信息数据
        List<OtherInfos> otherinfosList = otherInfosDao.findByFullReportId(fid);
        for (int i = 0; i < otherinfosList.size(); i++) {
            otherInfosDao.deleteById(otherinfosList.get(i).getId());
        }

        //其他信息
        OtherInfos otherinfos = new OtherInfos();
        JSONArray otherinfosArr = dataObject.getJSONArray("otherinfos");
        if (null != otherinfosArr && otherinfosArr.size() > 0) {
            for (int i = 0; i < otherinfosArr.size(); i++) {
                JSONObject otherinfosObject = otherinfosArr.getJSONObject(i);
                String otherinfosStr = otherinfosObject.toJSONString();
                otherinfos = JSON.parseObject(otherinfosStr, OtherInfos.class);
                otherinfos.setId(fid);
                otherinfos.setUpdateTime(updatetime);
                otherInfosDao.insert(otherinfos);
            }
        }

        //海关信息
        //先删除数据库已有的海关信息数据
        List<CustomHouse> customHouseList = customHouseDao.findByFullReportId(fid);
        for (int i = 0; i < customHouseList.size(); i++) {
            customHouseDao.deleteById(customHouseList.get(i).getId());
        }
        JSONArray customHouseArr = dataObject.getJSONArray("customeinfos");
        if (null != customHouseArr && customHouseArr.size() > 0) {
            for (int i = 0; i < customHouseArr.size(); i++) {
                JSONObject customHouseObject = customHouseArr.getJSONObject(i);
                String customHouseStr = customHouseObject.toJSONString();
                CustomHouse customHouses = JSON.parseObject(customHouseStr, CustomHouse.class);
                customHouses.setUpdateTime(updatetime);
                customHouseDao.insert(customHouses);
            }
        }


    }

    @Override
    public void getCpmList(FullReport report) {
        String basicName = report.getNameCN();
        String url = Tool.loadUrl("cpmUrl");
        try {
            url += URLEncoder.encode(report.getNameCN(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String data = HttpUtil.syncData(url);
        JSONObject result = JSONObject.parseObject(data);

        JSONObject dataObject = result.getJSONObject("data");

        int fid = report.getId();
        String updatetime = format.format(new Date());

        BasicInfos historyBasic = basicInfosDao.findByFullReportId(fid);
        //企业基本信息
        BasicInfos basics = new BasicInfos();
        JSONArray basicinfosList = dataObject.getJSONArray("basicinfos");
        if (null != basicinfosList && basicinfosList.size() > 0) {
            for (int i = 0; i < basicinfosList.size(); i++) {
                JSONObject basicsObject = basicinfosList.getJSONObject(i);
                String basicsStr = basicsObject.toJSONString();
                basics = JSON.parseObject(basicsStr, BasicInfos.class);
                if (null != historyBasic && null != historyBasic.getId()) {
//                    fid = historyBasic.getId();
                    basics.setFullReportId(fid);
                    basics.setId(historyBasic.getId());
                    if (Tool.isNull(historyBasic.getReg())) {
                        historyBasic.setReg(basics.getReg());
                    }
                    if (Tool.isNull(historyBasic.getNameCN())) {
                        historyBasic.setReg(basics.getNameCN());
                    }
                    if (Tool.isNull(historyBasic.getTel())) {
                        historyBasic.setReg(basics.getTel());
                    }
                    if (Tool.isNull(historyBasic.getManageZip())) {
                        historyBasic.setReg(basics.getManageZip());
                    }
                    if (Tool.isNull(historyBasic.getStreetCN())) {
                        historyBasic.setReg(basics.getStreetCN());
                    }
                    if (Tool.isNull(historyBasic.getEmail())) {
                        historyBasic.setReg(basics.getEmail());
                    }
                    if (Tool.isNull(historyBasic.getZip())) {
                        historyBasic.setReg(basics.getZip());
                    }
                    if (Tool.isNull(historyBasic.getWebsite())) {
                        historyBasic.setReg(basics.getWebsite());
                    }
                    basics.setUpdateTime(updatetime);
                    basicInfosDao.update(basics);
                }
            }
        }

        //企业注册信息
        //先删除数据库已有的企业注册信息数据
        RegistrationInfos hisReginfos = registrationInfosDao.findByFullReportId(fid);
        if (null != hisReginfos && null != hisReginfos.getId()) {
            registrationInfosDao.deleteById(hisReginfos.getId());
        }

        //企业注册信息
        RegistrationInfos reginfos = new RegistrationInfos();
        RegistrationInfos historyReg = registrationInfosDao.findByFullReportId(fid);
        JSONArray reginfosArr = dataObject.getJSONArray("reginfos");
        if (null != reginfosArr && reginfosArr.size() > 0) {
            for (int i = 0; i < reginfosArr.size(); i++) {
                JSONObject reginfosObject = reginfosArr.getJSONObject(i);
                String reginfosStr = reginfosObject.toJSONString();
                reginfos = JSON.parseObject(reginfosStr, RegistrationInfos.class);
                if (null != historyReg && null != historyReg.getCrefoNo()) {
                    fid = historyReg.getId();
                    reginfos.setFullReportId(fid);
                    reginfos.setId(historyReg.getId());
                    if (Tool.isNull(historyReg.getReg())) {
                        reginfos.setReg(historyReg.getReg());
                    }
                    if (Tool.isNull(historyReg.getNameCN())) {
                        reginfos.setReg(historyReg.getNameCN());
                    }
                    if (Tool.isNull(historyReg.getCompanyType())) {
                        reginfos.setReg(historyReg.getCompanyType());
                    }
                    if (Tool.isNull(historyReg.getLegalNameCN())) {
                        reginfos.setReg(historyReg.getLegalNameCN());
                    }
                    if (Tool.isNull(historyReg.getRegCapital())) {
                        reginfos.setReg(historyReg.getRegCapital());
                    }
                    if (Tool.isNull(historyReg.getRegCurrency())) {
                        reginfos.setReg(historyReg.getRegCurrency());
                    }
                    if (Tool.isNull(historyReg.getEstablishDate())) {
                        reginfos.setReg(historyReg.getEstablishDate());
                    }
                    if (Tool.isNull(historyReg.getStreetCN())) {
                        reginfos.setReg(historyReg.getStreetCN());
                    }
                    if (Tool.isNull(historyReg.getDelistDate())) {
                        reginfos.setReg(historyReg.getDelistDate());
                    }
                    if (Tool.isNull(historyReg.getBusinessScopeCN())) {
                        reginfos.setReg(historyReg.getBusinessScopeCN());
                    }
                    if (Tool.isNull(historyReg.getRegistrationCN())) {
                        reginfos.setReg(historyReg.getRegistrationCN());
                    }
                    if (Tool.isNull(historyReg.getProvinceCode() + "")) {
                        reginfos.setReg(historyReg.getProvinceCode() + "");
                    }
                    if (Tool.isNull(historyReg.getCompanyStatus())) {
                        reginfos.setReg(historyReg.getCompanyStatus());
                    }
                    if (Tool.isNull(historyReg.getRegCurrencyId() + "")) {
                        reginfos.setReg(historyReg.getRegCurrencyId() + "");
                    }
                    if (Tool.isNull(historyReg.getPaidCurrencyId() + "")) {
                        reginfos.setReg(historyReg.getPaidCurrencyId() + "");
                    }
                    if (Tool.isNull(historyReg.getCompanyTypesId() + "")) {
                        reginfos.setReg(historyReg.getCompanyTypesId() + "");
                    }
                    if (Tool.isNull(historyReg.getCompanyPropertiesId() + "")) {
                        reginfos.setReg(historyReg.getCompanyPropertiesId() + "");
                    }
                    if (Tool.isNull(historyReg.getCompanyStatusId() + "")) {
                        reginfos.setReg(historyReg.getCompanyStatusId() + "");
                    }
                    reginfos.setUpdateTime(updatetime);
                    registrationInfosDao.insert(reginfos);
                }
            }
        }


        //财务数据
        //先删除数据库已有的财务数据
        List<FinancialStatement> finanInfosList = financialStatementDao.findByFullReportId(fid);
        for (int i = 0; i < finanInfosList.size(); i++) {
            financialStatementDao.deleteById(finanInfosList.get(i).getId());
        }


        //企业注册信息
        String marketCode = "";
        reginfos = new RegistrationInfos();
        reginfosArr = dataObject.getJSONArray("reginfos");
        if (null != reginfosArr && reginfosArr.size() > 0) {
            for (int i = 0; i < reginfosArr.size(); i++) {
                JSONObject reginfosObject = reginfosArr.getJSONObject(i);
                String reginfosStr = reginfosObject.toJSONString();
                reginfos = JSON.parseObject(reginfosStr, RegistrationInfos.class);
                if (null != reginfos && null != reginfos.getMarketCode() && !"".equals(reginfos.getMarketCode())) {
                    marketCode = reginfos.getMarketCode();
                }
                reginfos.setFullReportId(fid);
            }
        }

        if (null != marketCode && !"".equals(marketCode)) {
            String marketUrl = Tool.loadUrl("marketUrl");
            marketUrl += marketCode;
            data = HttpUtil.syncData(marketUrl);
            result = JSONObject.parseObject(data);
            if (null != result) {
                JSONArray basicList = result.getJSONArray("data");
                if (null != basicList && basicList.size() > 0) {
                    for (int i = 0; i < basicList.size(); i++) {
                        JSONObject info = basicList.getJSONObject(i);
                        String str = info.toString();
                        FinancialStatement financial = JSON.parseObject(str, FinancialStatement.class);
                        if (null != financial.getEmployee() && "0".equals(financial.getEmployee())) {
                            financial.setEmployee(null);
                        }
                        Long currentAssets = null;
                        //其他  =  所有者权益（或股东权益）合计-实收资本（或股本）-资本公积-盈余公积-未分配利润
                        //所有者权益
                        if (null != financial.getTotalShareholdersEquity() && !financial.getTotalShareholdersEquity().trim().equals("")) {
                            currentAssets = Long.parseLong(financial.getTotalShareholdersEquity());
                        }
                        //实收资本
                        if (null != financial.getPaidUpCapital() && !financial.getPaidUpCapital().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getPaidUpCapital());
                            }
                        }
                        //资本公积
                        if (null != financial.getCapitalReserve() && !financial.getCapitalReserve().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getCapitalReserve());
                            }
                        }
                        //盈余公积
                        if (null != financial.getSurplusReserve() && !financial.getSurplusReserve().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getSurplusReserve());
                            }
                        }
                        //未分配利润
                        if (null != financial.getUndistributedProfit() && !financial.getUndistributedProfit().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getUndistributedProfit());
                            }
                        }
                        //其他
                        if (null != currentAssets) {
                            financial.setOtherEquity(currentAssets + "");
                        }
                        currentAssets = null;
                        //主营业务利润  =  营业收入-减：营业成本-营业税金及附加
                        //主营业务收入
                        if (null != financial.getTurnover() && !financial.getTurnover().trim().equals("")) {
                            currentAssets = Long.parseLong(financial.getTurnover());
                        }
                        //减：营业成本
                        if (null != financial.getCostsOfGoodsSold() && !financial.getCostsOfGoodsSold().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getCostsOfGoodsSold());
                            }
                        }
                        //营业税金及附加
                        if (null != financial.getSalesTax() && !financial.getSalesTax().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getSalesTax());
                            }
                        }
                        //主营业务利润
                        if (null != currentAssets) {
                            financial.setGrossProfit(currentAssets + "");
                        }
                        //主营业务利润  =  销售费用-管理费用-财务费用
                        //主营业务利润
                        if (null != financial.getGrossProfit() && !financial.getGrossProfit().trim().equals("")) {
                            currentAssets = Long.parseLong(financial.getGrossProfit());
                        }
                        //销售费用
                        if (null != financial.getSalesExpense() && !financial.getSalesExpense().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getSalesExpense());
                            }
                        }
                        //管理费用
                        if (null != financial.getManagementExpense() && !financial.getManagementExpense().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getManagementExpense());
                            }
                        }
                        //财务费用
                        if (null != financial.getFinanceExpense() && !financial.getFinanceExpense().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getFinanceExpense());
                            }
                        }
                        //营业利润
                        if (null != currentAssets) {
                            financial.setOperatingProfit(currentAssets + "");
                        }
                        financial.setFullReportId(fid);
                        financial.setUpdateTime(updatetime);
                        financialStatementDao.insert(financial);
                    }
                }
            }
        } else {
            FinancialStatement finanInfos = new FinancialStatement();
            JSONArray finanInfosArr = dataObject.getJSONArray("finanInfos");
            if (null != finanInfosArr && finanInfosArr.size() > 0) {
                for (int i = 0; i < finanInfosArr.size(); i++) {
                    JSONObject finanInfosObject = finanInfosArr.getJSONObject(i);
                    String finanInfosStr = finanInfosObject.toJSONString();
                    finanInfos = JSON.parseObject(finanInfosStr, FinancialStatement.class);
                    finanInfos.setFullReportId(fid);
                    finanInfos.setUpdateTime(updatetime);
                    financialStatementDao.insert(finanInfos);
                }
            }
            //财务分析
            //先删除数据库已有的财务分析数据
            List<FinancialRatios> ratioinfosList = financialRatiosDao.findByFullReportId(fid);
            for (int i = 0; i < ratioinfosList.size(); i++) {
                financialRatiosDao.deleteById(ratioinfosList.get(i).getId());
            }

            //财务分析数据
            FinancialRatios ratioinfos = new FinancialRatios();
            JSONArray ratioinfosArr = dataObject.getJSONArray("ratioinfos");
            if (null != ratioinfosArr && ratioinfosArr.size() > 0) {
                for (int i = 0; i < ratioinfosArr.size(); i++) {
                    JSONObject ratioinfosObject = ratioinfosArr.getJSONObject(i);
                    String ratioinfosStr = ratioinfosObject.toJSONString();
                    ratioinfos = JSON.parseObject(ratioinfosStr, FinancialRatios.class);
                    ratioinfos.setFullReportId(fid);
                    ratioinfos.setUpdateTime(updatetime);
                    financialRatiosDao.insert(ratioinfos);
                }
            }
        }


        //关联公司
        //先删除数据库已有的关联公司数据
        List<RelatedCompanies> relatedinfosList = relatedCompaniesDao.findByFullReportId(fid);
        for (int i = 0; i < relatedinfosList.size(); i++) {
            relatedCompaniesDao.deleteById(relatedinfosList.get(i).getId());
        }

        //关联公司数据
        RelatedCompanies relatedinfos = new RelatedCompanies();
        JSONArray relatedinfosArr = dataObject.getJSONArray("relatedinfos");
        if (null != relatedinfosArr && relatedinfosArr.size() > 0) {
            for (int i = 0; i < relatedinfosArr.size(); i++) {
                JSONObject relatedinfosObject = relatedinfosArr.getJSONObject(i);
                String relatedinfosStr = relatedinfosObject.toJSONString();
                relatedinfos = JSON.parseObject(relatedinfosStr, RelatedCompanies.class);
                relatedinfos.setFullReportId(fid);
                relatedinfos.setUpdateTime(updatetime);
                relatedCompaniesDao.insert(relatedinfos);
            }
        }


        //海关信息
        //先删除数据库已有的海关信息数据
        List<CustomHouse> customHouseList = customHouseDao.findByFullReportId(fid);
        if (null != customHouseList) {
            for (int i = 0; i < customHouseList.size(); i++) {
                customHouseDao.deleteById(customHouseList.get(i).getId());
            }
        }
        JSONArray customHouseArr = dataObject.getJSONArray("customeinfos");
        if (null != customHouseArr && customHouseArr.size() > 0) {
            for (int i = 0; i < customHouseArr.size(); i++) {
                JSONObject customHouseObject = customHouseArr.getJSONObject(i);
                String customHouseStr = customHouseObject.toJSONString();
                CustomHouse customHouses = JSON.parseObject(customHouseStr, CustomHouse.class);
                customHouses.setUpdateTime(updatetime);
                customHouses.setFullReportId(fid);
                customHouseDao.insert(customHouses);
            }
        }

        //经营现状
        //先删除数据库已有的经营现状数据
        List<Operatings> operatingsinfosList = operatingsDao.findByFullReportId(fid);
        for (int i = 0; i < operatingsinfosList.size(); i++) {
            operatingsDao.deleteById(operatingsinfosList.get(i).getId());
        }

        //经营现状数据
        Operatings operatingsinfos = new Operatings();
        JSONArray operatingsinfosArr = dataObject.getJSONArray("operatingsinfos");
        if (null != operatingsinfosArr && operatingsinfosArr.size() > 0) {
            for (int i = 0; i < operatingsinfosArr.size(); i++) {
                JSONObject operatingsinfosObject = operatingsinfosArr.getJSONObject(i);
                String operatingsinfosStr = operatingsinfosObject.toJSONString();
                operatingsinfos = JSON.parseObject(operatingsinfosStr, Operatings.class);
                operatingsinfos.setFullReportId(fid);
                operatingsinfos.setUpdateTime(updatetime);
                operatingsDao.insert(operatingsinfos);
            }
        }

        //银行信息
        //先删除数据库已有的银行信息数据
        List<BankInfos> bankinfosList = bankInfosService.findByFullReportId(fid);
        for (int i = 0; i < bankinfosList.size(); i++) {
            bankInfosService.deleteById(bankinfosList.get(i));
        }

        //银行信息数据
        BankInfos bankinfos = new BankInfos();
        JSONArray bankinfosArr = dataObject.getJSONArray("bankinfos");
        if (null != bankinfosArr && bankinfosArr.size() > 0) {
            for (int i = 0; i < bankinfosArr.size(); i++) {
                JSONObject bankinfosObject = bankinfosArr.getJSONObject(i);
                String bankinfosStr = bankinfosObject.toJSONString();
                bankinfos = JSON.parseObject(bankinfosStr, BankInfos.class);
                bankinfos.setFullReportId(fid);
                bankinfos.setUpdateTime(updatetime);
                bankInfosService.insert(bankinfos);
            }
        }

        //支付款记录
        //先删除数据库已有的支付款记录数据
        List<PaymentHistories> paymentHistoriesinfosList = paymentHistoriesDao.findByFullReportId(fid);
        for (int i = 0; i < paymentHistoriesinfosList.size(); i++) {
            paymentHistoriesDao.deleteById(paymentHistoriesinfosList.get(i).getId());
        }

        //支付款记录数据
        PaymentHistories paymentHistoriesinfos = new PaymentHistories();
        JSONArray paymentHistoriesinfosArr = dataObject.getJSONArray("paymentHistoriesinfos");
        if (null != paymentHistoriesinfosArr && paymentHistoriesinfosArr.size() > 0) {
            for (int i = 0; i < paymentHistoriesinfosArr.size(); i++) {
                JSONObject paymentHistoriesinfosObject = paymentHistoriesinfosArr.getJSONObject(i);
                String paymentHistoriesinfosStr = paymentHistoriesinfosObject.toJSONString();
                paymentHistoriesinfos = JSON.parseObject(paymentHistoriesinfosStr, PaymentHistories.class);
                paymentHistoriesinfos.setFullReportId(fid);
                paymentHistoriesinfos.setUpdateTime(updatetime);
                paymentHistoriesDao.insert(paymentHistoriesinfos);
            }
        }


        //贸易参考
        //先删除数据库已有的贸易参考数据
        List<TradeReferences> tradeReferencesList = tradeReferencesDao.findByFullReportId(fid);
        for (int i = 0; i < tradeReferencesList.size(); i++) {
            tradeReferencesDao.deleteById(tradeReferencesList.get(i).getId());
        }

        //贸易参考数据(供应商flag：0)
        TradeReferences suppliersinfos = new TradeReferences();
        JSONArray suppliersinfosArr = dataObject.getJSONArray("suppliersinfos");
        if (null != suppliersinfosArr && suppliersinfosArr.size() > 0) {
            for (int i = 0; i < suppliersinfosArr.size(); i++) {
                JSONObject suppliersinfosObject = suppliersinfosArr.getJSONObject(i);
                String suppliersinfosStr = suppliersinfosObject.toJSONString();
                suppliersinfos = JSON.parseObject(suppliersinfosStr, TradeReferences.class);
                suppliersinfos.setFullReportId(fid);
                suppliersinfos.setFlag("0");
                suppliersinfos.setUpdateTime(updatetime);
                tradeReferencesDao.insert(suppliersinfos);
            }
        }

        //贸易参考数据(客户flag：1)
        TradeReferences clientinfos = new TradeReferences();
        JSONArray clientinfosArr = dataObject.getJSONArray("clientinfos");
        if (null != clientinfosArr && clientinfosArr.size() > 0) {
            for (int i = 0; i < clientinfosArr.size(); i++) {
                JSONObject clientinfosObject = clientinfosArr.getJSONObject(i);
                String clientinfosStr = clientinfosObject.toJSONString();
                clientinfos = JSON.parseObject(clientinfosStr, TradeReferences.class);
                clientinfos.setFullReportId(fid);
                clientinfos.setFlag("1");
                clientinfos.setUpdateTime(updatetime);
                tradeReferencesDao.insert(clientinfos);
            }
        }


        //财物说明
        //先删除数据库已有的财物说明数据
        List<FinancialFigures> financialFigureinfosList = financialFiguresDao.findByFullReportId(fid);
        for (int i = 0; i < financialFigureinfosList.size(); i++) {
            financialFiguresDao.deleteById(financialFigureinfosList.get(i).getId());
        }

        //财物说明
        FinancialFigures financialFigureinfos = new FinancialFigures();
        JSONArray financialFigureinfosArr = dataObject.getJSONArray("financialFigureinfos");
        if (null != financialFigureinfosArr && financialFigureinfosArr.size() > 0) {
            for (int i = 0; i < financialFigureinfosArr.size(); i++) {
                JSONObject financialFigureinfosObject = financialFigureinfosArr.getJSONObject(i);
                String financialFigureinfosStr = financialFigureinfosObject.toJSONString();
                financialFigureinfos = JSON.parseObject(financialFigureinfosStr, FinancialFigures.class);
                financialFigureinfos.setFullReportId(fid);
                financialFigureinfos.setUpdateTime(updatetime);
                financialFiguresDao.insert(financialFigureinfos);
            }
        }


        //其他信息
        //先删除数据库已有的其他信息数据
        List<OtherInfos> otherinfosList = otherInfosDao.findByFullReportId(fid);
        for (int i = 0; i < otherinfosList.size(); i++) {
            otherInfosDao.deleteById(otherinfosList.get(i).getId());
        }

        //其他信息
        OtherInfos otherinfos = new OtherInfos();
        JSONArray otherinfosArr = dataObject.getJSONArray("otherinfos");
        if (null != otherinfosArr && otherinfosArr.size() > 0) {
            for (int i = 0; i < otherinfosArr.size(); i++) {
                JSONObject otherinfosObject = otherinfosArr.getJSONObject(i);
                String otherinfosStr = otherinfosObject.toJSONString();
                otherinfos = JSON.parseObject(otherinfosStr, OtherInfos.class);
                otherinfos.setFullReportId(fid);
                otherinfos.setUpdateTime(updatetime);
                otherInfosDao.insert(otherinfos);
            }
        }


    }

    @Override
    public FullReport getGlobalReport(FullReport report) {
        String basicName = report.getNameCN();
        String url = Tool.loadUrl("cpmUrl");
        url += report.getNameCN();
        String data = HttpUtil.syncData(url);
        JSONObject result = JSONObject.parseObject(data);
        JSONObject dataObject = result.getJSONObject("data");
        BasicInfos historyBasic = report.getBasicInfos();
        //企业基本信息  从接口拿数据
        BasicInfos basics = new BasicInfos();
        JSONArray basicinfosList = dataObject.getJSONArray("basicinfos");
        if (null != basicinfosList && basicinfosList.size() > 0) {
            for (int i = 0; i < basicinfosList.size(); i++) {
                JSONObject basicsObject = basicinfosList.getJSONObject(i);
                String basicsStr = basicsObject.toJSONString();
                basics = JSON.parseObject(basicsStr, BasicInfos.class);
                if (null != historyBasic && null != historyBasic.getNameCN()) {
                    if (Tool.isNull(historyBasic.getReg())) {
                        historyBasic.setReg(basics.getReg());
                    }
                    if (Tool.isNull(historyBasic.getNameCN())) {
                        historyBasic.setReg(basics.getNameCN());
                    }
                    if (Tool.isNull(historyBasic.getTel())) {
                        historyBasic.setReg(basics.getTel());
                    }
                    if (Tool.isNull(historyBasic.getManageZip())) {
                        historyBasic.setReg(basics.getManageZip());
                    }
                    if (Tool.isNull(historyBasic.getStreetCN())) {
                        historyBasic.setReg(basics.getStreetCN());
                    }
                    if (Tool.isNull(historyBasic.getEmail())) {
                        historyBasic.setReg(basics.getEmail());
                    }
                    if (Tool.isNull(historyBasic.getZip())) {
                        historyBasic.setReg(basics.getZip());
                    }
                    if (Tool.isNull(historyBasic.getWebsite())) {
                        historyBasic.setReg(basics.getWebsite());
                    }
                    report.setBasicInfos(basics);
                }
            }
        }

        //企业注册信息
        RegistrationInfos reginfos = new RegistrationInfos();
        RegistrationInfos historyReg = report.getRegistrationInfos();
        JSONArray reginfosArr = dataObject.getJSONArray("reginfos");
        if (null != reginfosArr && reginfosArr.size() > 0) {
            for (int i = 0; i < reginfosArr.size(); i++) {
                JSONObject reginfosObject = reginfosArr.getJSONObject(i);
                String reginfosStr = reginfosObject.toJSONString();
                reginfosStr = reginfosStr.replace("cpid", "companyPropertiesId");//企业性质
                reginfosStr = reginfosStr.replace("ctid", "companyTypesId");//企业类型
                reginfosStr = reginfosStr.replace("cid", "competitionId");//企业竞争力
                reginfosStr = reginfosStr.replace("rcid", "regCurrencyId");//注册货币
                reginfosStr = reginfosStr.replace("pcid", "paidCurrencyId");//实收货币
                reginfosStr = reginfosStr.replace("csid", "companyStatusId");//公司状态
                reginfosStr = reginfosStr.replace("mcid", "marketCitiesId");//上市地址
                reginfos = JSON.parseObject(reginfosStr, RegistrationInfos.class);
                if (null != historyReg && null != historyReg.getNameCN()) {
                    if (Tool.isNull(historyReg.getReg())) {
                        reginfos.setReg(historyReg.getReg());
                    }
                    if (Tool.isNull(historyReg.getNameCN())) {
                        reginfos.setReg(historyReg.getNameCN());
                    }
                    if (Tool.isNull(historyReg.getCompanyType())) {
                        reginfos.setReg(historyReg.getCompanyType());
                    }
                    if (Tool.isNull(historyReg.getLegalNameCN())) {
                        reginfos.setReg(historyReg.getLegalNameCN());
                    }
                    if (Tool.isNull(historyReg.getRegCapital())) {
                        reginfos.setReg(historyReg.getRegCapital());
                    }
                    if (Tool.isNull(historyReg.getRegCurrency())) {
                        reginfos.setReg(historyReg.getRegCurrency());
                    }
                    if (Tool.isNull(historyReg.getEstablishDate())) {
                        reginfos.setReg(historyReg.getEstablishDate());
                    }
                    if (Tool.isNull(historyReg.getStreetCN())) {
                        reginfos.setReg(historyReg.getStreetCN());
                    }
                    if (Tool.isNull(historyReg.getDelistDate())) {
                        reginfos.setReg(historyReg.getDelistDate());
                    }
                    if (Tool.isNull(historyReg.getBusinessScopeCN())) {
                        reginfos.setReg(historyReg.getBusinessScopeCN());
                    }
                    if (Tool.isNull(historyReg.getRegistrationCN())) {
                        reginfos.setReg(historyReg.getRegistrationCN());
                    }
                    if (Tool.isNull(historyReg.getProvinceCode() + "")) {
                        reginfos.setReg(historyReg.getProvinceCode() + "");
                    }
                    if (Tool.isNull(historyReg.getCompanyStatus())) {
                        reginfos.setReg(historyReg.getCompanyStatus());
                    }
                    if (Tool.isNull(historyReg.getRegCurrencyId() + "")) {
                        reginfos.setReg(historyReg.getRegCurrencyId() + "");
                    }
                    if (Tool.isNull(historyReg.getPaidCurrencyId() + "")) {
                        reginfos.setReg(historyReg.getPaidCurrencyId() + "");
                    }
                    if (Tool.isNull(historyReg.getCompanyTypesId() + "")) {
                        reginfos.setReg(historyReg.getCompanyTypesId() + "");
                    }
                    if (Tool.isNull(historyReg.getCompanyPropertiesId() + "")) {
                        reginfos.setReg(historyReg.getCompanyPropertiesId() + "");
                    }
                    if (Tool.isNull(historyReg.getCompanyStatusId() + "")) {
                        reginfos.setReg(historyReg.getCompanyStatusId() + "");
                    }
                    report.setRegistrationInfos(reginfos);
                }
            }
        }

        //企业注册信息
        String marketCode = "";
        reginfos = new RegistrationInfos();
        reginfosArr = dataObject.getJSONArray("reginfos");
        if (null != reginfosArr && reginfosArr.size() > 0) {
            for (int i = 0; i < reginfosArr.size(); i++) {
                JSONObject reginfosObject = reginfosArr.getJSONObject(i);
                String reginfosStr = reginfosObject.toJSONString();
                reginfos = JSON.parseObject(reginfosStr, RegistrationInfos.class);
                if (null != reginfos && null != reginfos.getMarketCode() && !"".equals(reginfos.getMarketCode())) {
                    marketCode = reginfos.getMarketCode();
                }
            }
        }
        List<FinancialStatement> financialStatementList = new ArrayList<FinancialStatement>();
        if (null != marketCode && !"".equals(marketCode)) {
            String marketUrl = Tool.loadUrl("marketUrl");
            marketUrl += marketCode;
            data = HttpUtil.syncData(marketUrl);
            result = JSONObject.parseObject(data);
            if (null != result) {
                JSONArray basicList = result.getJSONArray("data");
                if (null != basicList && basicList.size() > 0) {
                    for (int i = 0; i < basicList.size(); i++) {
                        JSONObject info = basicList.getJSONObject(i);
                        String str = info.toString();
                        str = str.replace("fsId", "financialSourceId");//财务来源
                        FinancialStatement financial = JSON.parseObject(str, FinancialStatement.class);
                        if (null != financial.getEmployee() && "0".equals(financial.getEmployee())) {
                            financial.setEmployee(null);
                        }
                        Long currentAssets = null;
                        //其他  =  所有者权益（或股东权益）合计-实收资本（或股本）-资本公积-盈余公积-未分配利润
                        //所有者权益
                        if (null != financial.getTotalShareholdersEquity() && !financial.getTotalShareholdersEquity().trim().equals("")) {
                            currentAssets = Long.parseLong(financial.getTotalShareholdersEquity());
                        }
                        //实收资本
                        if (null != financial.getPaidUpCapital() && !financial.getPaidUpCapital().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getPaidUpCapital());
                            }
                        }
                        //资本公积
                        if (null != financial.getCapitalReserve() && !financial.getCapitalReserve().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getCapitalReserve());
                            }
                        }
                        //盈余公积
                        if (null != financial.getSurplusReserve() && !financial.getSurplusReserve().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getSurplusReserve());
                            }
                        }
                        //未分配利润
                        if (null != financial.getUndistributedProfit() && !financial.getUndistributedProfit().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getUndistributedProfit());
                            }
                        }
                        //其他
                        if (null != currentAssets) {
                            financial.setOtherEquity(currentAssets + "");
                        }
                        currentAssets = null;
                        //主营业务利润  =  营业收入-减：营业成本-营业税金及附加
                        //主营业务收入
                        if (null != financial.getTurnover() && !financial.getTurnover().trim().equals("")) {
                            currentAssets = Long.parseLong(financial.getTurnover());
                        }
                        //减：营业成本
                        if (null != financial.getCostsOfGoodsSold() && !financial.getCostsOfGoodsSold().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getCostsOfGoodsSold());
                            }
                        }
                        //营业税金及附加
                        if (null != financial.getSalesTax() && !financial.getSalesTax().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getSalesTax());
                            }
                        }
                        //主营业务利润
                        if (null != currentAssets) {
                            financial.setGrossProfit(currentAssets + "");
                        }
                        //主营业务利润  =  销售费用-管理费用-财务费用
                        //主营业务利润
                        if (null != financial.getGrossProfit() && !financial.getGrossProfit().trim().equals("")) {
                            currentAssets = Long.parseLong(financial.getGrossProfit());
                        }
                        //销售费用
                        if (null != financial.getSalesExpense() && !financial.getSalesExpense().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getSalesExpense());
                            }
                        }
                        //管理费用
                        if (null != financial.getManagementExpense() && !financial.getManagementExpense().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getManagementExpense());
                            }
                        }
                        //财务费用
                        if (null != financial.getFinanceExpense() && !financial.getFinanceExpense().trim().equals("")) {
                            if (null != currentAssets) {
                                currentAssets = currentAssets - Long.parseLong(financial.getFinanceExpense());
                            }
                        }
                        //营业利润
                        if (null != currentAssets) {
                            financial.setOperatingProfit(currentAssets + "");
                        }
                        financialStatementList.add(financial);
                    }
                }
            }
        } else {
            JSONArray finanInfosArr = dataObject.getJSONArray("finanInfos");
            if (null != finanInfosArr && finanInfosArr.size() > 0) {
                for (int i = 0; i < finanInfosArr.size(); i++) {
                    JSONObject finanInfosObject = finanInfosArr.getJSONObject(i);
                    String finanInfosStr = finanInfosObject.toJSONString();
                    FinancialStatement finanInfos = JSON.parseObject(finanInfosStr, FinancialStatement.class);
                    financialStatementList.add(finanInfos);
                }
            }
            //财务分析数据
            List<FinancialRatios> financialRatiosList = new ArrayList<FinancialRatios>();
            JSONArray ratioinfosArr = dataObject.getJSONArray("ratioinfos");
            if (null != ratioinfosArr && ratioinfosArr.size() > 0) {
                for (int i = 0; i < ratioinfosArr.size(); i++) {
                    JSONObject ratioinfosObject = ratioinfosArr.getJSONObject(i);
                    String ratioinfosStr = ratioinfosObject.toJSONString();
                    FinancialRatios ratioinfos = JSON.parseObject(ratioinfosStr, FinancialRatios.class);
                    financialRatiosList.add(ratioinfos);
                }
            }
        }
        report.setFinancialStatementList(financialStatementList);
        //关联公司数据
        List<RelatedCompanies> relatedCompaniesList = new ArrayList<RelatedCompanies>();
        JSONArray relatedinfosArr = dataObject.getJSONArray("relatedinfos");
        if (null != relatedinfosArr && relatedinfosArr.size() > 0) {
            for (int i = 0; i < relatedinfosArr.size(); i++) {
                JSONObject relatedinfosObject = relatedinfosArr.getJSONObject(i);
                String relatedinfosStr = relatedinfosObject.toJSONString();
                relatedinfosStr = relatedinfosStr.replace("rid", "relationId");//关系
                relatedinfosStr = relatedinfosStr.replace("cpid", "companyPropertiesId");//企业性质
                relatedinfosStr = relatedinfosStr.replace("csid", "companyStatusId");//公司状态
                relatedinfosStr = relatedinfosStr.replace("brprincipal", "principal");//负责人
                RelatedCompanies relatedinfos = JSON.parseObject(relatedinfosStr, RelatedCompanies.class);
                relatedCompaniesList.add(relatedinfos);
            }
            report.setRelatedCompaniesList(relatedCompaniesList);
        }

        //经营现状数据
        Operatings operatingsinfos = new Operatings();
        JSONArray operatingsinfosArr = dataObject.getJSONArray("operatingsinfos");
        if (null != operatingsinfosArr && operatingsinfosArr.size() > 0) {
            for (int i = 0; i < operatingsinfosArr.size(); i++) {
                JSONObject operatingsinfosObject = operatingsinfosArr.getJSONObject(i);
                String operatingsinfosStr = operatingsinfosObject.toJSONString();
                operatingsinfosStr = operatingsinfosStr.replace("csid", "companySizeId");//企业大小
                operatingsinfosStr = operatingsinfosStr.replace("psid", "operationalStatusId");//经营企业状态
                operatingsinfosStr = operatingsinfosStr.replace("ltid", "locationTypeId");//地理位置
                operatingsinfosStr = operatingsinfosStr.replace("oid", "ownershipId");//所有制
                operatingsinfos = JSON.parseObject(operatingsinfosStr, Operatings.class);
                report.setOperatings(operatingsinfos);
            }
        }

        //海关信息
        List<CustomHouse> customHouseList = new ArrayList<CustomHouse>();
        JSONArray customHouseArr = dataObject.getJSONArray("customeinfos");
        if (null != customHouseArr && customHouseArr.size() > 0) {
            for (int i = 0; i < customHouseArr.size(); i++) {
                JSONObject customHouseObject = customHouseArr.getJSONObject(i);
                String customHouseStr = customHouseObject.toJSONString();
                CustomHouse customHouses = JSON.parseObject(customHouseStr, CustomHouse.class);
                customHouseList.add(customHouses);
            }
            report.setCustomHouseList(customHouseList);
        }

        //银行信息数据
        List<BankInfos> bankInfosList = new ArrayList<BankInfos>();
        JSONArray bankinfosArr = dataObject.getJSONArray("bankinfos");
        if (null != bankinfosArr && bankinfosArr.size() > 0) {
            for (int i = 0; i < bankinfosArr.size(); i++) {
                JSONObject bankinfosObject = bankinfosArr.getJSONObject(i);
                String bankinfosStr = bankinfosObject.toJSONString();
                BankInfos bankinfos = JSON.parseObject(bankinfosStr, BankInfos.class);
                bankInfosList.add(bankinfos);
            }
            report.setBankInfosList(bankInfosList);
        }
        //支付款记录数据
        List<PaymentHistories> paymentHistoriesList = new ArrayList<PaymentHistories>();
        JSONArray paymentHistoriesinfosArr = dataObject.getJSONArray("paymentHistoriesinfos");
        if (null != paymentHistoriesinfosArr && paymentHistoriesinfosArr.size() > 0) {
            for (int i = 0; i < paymentHistoriesinfosArr.size(); i++) {
                JSONObject paymentHistoriesinfosObject = paymentHistoriesinfosArr.getJSONObject(i);
                String paymentHistoriesinfosStr = paymentHistoriesinfosObject.toJSONString();
                paymentHistoriesinfosStr = paymentHistoriesinfosStr.replace("ppid", "paymentPatternId");//支付模式
                paymentHistoriesinfosStr = paymentHistoriesinfosStr.replace("ptid", "paymentTermsId");//支付方式
                PaymentHistories paymentHistoriesinfos = JSON.parseObject(paymentHistoriesinfosStr, PaymentHistories.class);
                paymentHistoriesList.add(paymentHistoriesinfos);
            }
            report.setPaymentHistoriesList(paymentHistoriesList);
        }
        //贸易参考数据(供应商flag：0)
        List<TradeReferences> tradeReferencesList = new ArrayList<TradeReferences>();
        JSONArray suppliersinfosArr = dataObject.getJSONArray("suppliersinfos");
        if (null != suppliersinfosArr && suppliersinfosArr.size() > 0) {
            for (int i = 0; i < suppliersinfosArr.size(); i++) {
                JSONObject suppliersinfosObject = suppliersinfosArr.getJSONObject(i);
                String suppliersinfosStr = suppliersinfosObject.toJSONString();
                suppliersinfosStr = suppliersinfosStr.replace("cpid", "companyPropertiesId");//企业性质
                suppliersinfosStr = suppliersinfosStr.replace("csid", "companyStatusId");//公司状态
                TradeReferences suppliersinfos = JSON.parseObject(suppliersinfosStr, TradeReferences.class);
                suppliersinfos.setFlag("0");
                tradeReferencesList.add(suppliersinfos);
            }
        }
        report.setSuppliersinfosList(tradeReferencesList);
        //贸易参考数据(客户flag：1)
        List<TradeReferences> clientList = new ArrayList<>();
        JSONArray clientinfosArr = dataObject.getJSONArray("clientinfos");
        if (null != clientinfosArr && clientinfosArr.size() > 0) {
            for (int i = 0; i < clientinfosArr.size(); i++) {
                JSONObject clientinfosObject = clientinfosArr.getJSONObject(i);
                String clientinfosStr = clientinfosObject.toJSONString();
                clientinfosStr = clientinfosStr.replace("cpid", "companyPropertiesId");//企业性质
                clientinfosStr = clientinfosStr.replace("csid", "companyStatusId");//公司状态
                TradeReferences clientinfos = JSON.parseObject(clientinfosStr, TradeReferences.class);
                clientinfos.setFlag("1");
                tradeReferencesList.add(clientinfos);
                clientList.add(clientinfos);
            }
        }
        report.setClientinfosList(clientList);
        report.setTradeReferencesList(tradeReferencesList);

        //财物说明
        List<FinancialFigures> financialFiguresList = new ArrayList<FinancialFigures>();
        JSONArray financialFigureinfosArr = dataObject.getJSONArray("financialFigureinfos");
        if (null != financialFigureinfosArr && financialFigureinfosArr.size() > 0) {
            for (int i = 0; i < financialFigureinfosArr.size(); i++) {
                JSONObject financialFigureinfosObject = financialFigureinfosArr.getJSONObject(i);
                String financialFigureinfosStr = financialFigureinfosObject.toJSONString();
                financialFigureinfosStr = financialFigureinfosStr.replace("isid", "informationSourceId");//信息来源
                FinancialFigures financialFigureinfos = JSON.parseObject(financialFigureinfosStr, FinancialFigures.class);
                financialFiguresList.add(financialFigureinfos);
            }
            report.setFinancialFiguresList(financialFiguresList);
        }

        //其他信息
        List<OtherInfos> otherInfosList = new ArrayList<OtherInfos>();
        JSONArray otherinfosArr = dataObject.getJSONArray("otherinfos");
        if (null != otherinfosArr && otherinfosArr.size() > 0) {
            for (int i = 0; i < otherinfosArr.size(); i++) {
                JSONObject otherinfosObject = otherinfosArr.getJSONObject(i);
                String otherinfosStr = otherinfosObject.toJSONString();
                OtherInfos otherinfos = JSON.parseObject(otherinfosStr, OtherInfos.class);
                otherInfosList.add(otherinfos);
            }
            report.setOtherInfosList(otherInfosList);
        }

        return report;

    }

    @Override
    public FullReport copyFullReport(FullReport report) {
        if (report != null && report.getId() != null){

            RegistrationInfos registrationInfos = registrationInfosDao.findByFullReportId(report.getId());
            String marketCode = "";
            if (registrationInfos != null && StringUtils.isNotBlank(registrationInfos.getMarketCode())) {
                marketCode = registrationInfos.getMarketCode();
            } else if (report.getRegistrationInfos() != null) {
                marketCode = report.getRegistrationInfos().getMarketCode();
            }
            if (null != marketCode && !"".equals(marketCode)) {
                List<FinancialStatement> financialStatementList = new ArrayList<>();
                report.setFinancialStatementList(financialStatementList);
                String marketUrl = Tool.loadUrl("marketUrl");
                marketUrl += marketCode;
                String data = HttpUtil.syncData(marketUrl);
                JSONObject result = JSONObject.parseObject(data);
                if (null != result) {
                    JSONArray basicList = result.getJSONArray("data");
                    if (null != basicList && basicList.size() > 0) {
                        for (int i = 0; i < basicList.size(); i++) {
                            JSONObject info = basicList.getJSONObject(i);
                            String str = info.toString();
                            str = str.replace("fsId", "financialSourceId");//财务来源
                            FinancialStatement financial = JSON.parseObject(str, FinancialStatement.class);
                            if (null != financial.getEmployee() && "0".equals(financial.getEmployee())) {
                                financial.setEmployee(null);
                            }
                            Long currentAssets = null;
                            //其他  =  所有者权益（或股东权益）合计-实收资本（或股本）-资本公积-盈余公积-未分配利润
                            //所有者权益
                            if (null != financial.getTotalShareholdersEquity() && !financial.getTotalShareholdersEquity().trim().equals("")) {
                                currentAssets = Long.parseLong(financial.getTotalShareholdersEquity());
                            }
                            //实收资本
                            if (null != financial.getPaidUpCapital() && !financial.getPaidUpCapital().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getPaidUpCapital());
                                }
                            }
                            //资本公积
                            if (null != financial.getCapitalReserve() && !financial.getCapitalReserve().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getCapitalReserve());
                                }
                            }
                            //盈余公积
                            if (null != financial.getSurplusReserve() && !financial.getSurplusReserve().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getSurplusReserve());
                                }
                            }
                            //未分配利润
                            if (null != financial.getUndistributedProfit() && !financial.getUndistributedProfit().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getUndistributedProfit());
                                }
                            }
                            //其他
                            if (null != currentAssets) {
                                financial.setOtherEquity(currentAssets + "");
                            }
                            currentAssets = null;
                            //主营业务利润  =  营业收入-减：营业成本-营业税金及附加
                            //主营业务收入
                            if (null != financial.getTurnover() && !financial.getTurnover().trim().equals("")) {
                                currentAssets = Long.parseLong(financial.getTurnover());
                            }
                            //减：营业成本
                            if (null != financial.getCostsOfGoodsSold() && !financial.getCostsOfGoodsSold().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getCostsOfGoodsSold());
                                }
                            }
                            //营业税金及附加
                            if (null != financial.getSalesTax() && !financial.getSalesTax().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getSalesTax());
                                }
                            }
                            //主营业务利润
                            if (null != currentAssets) {
                                financial.setGrossProfit(currentAssets + "");
                            }
                            //主营业务利润  =  销售费用-管理费用-财务费用
                            //主营业务利润
                            if (null != financial.getGrossProfit() && !financial.getGrossProfit().trim().equals("")) {
                                currentAssets = Long.parseLong(financial.getGrossProfit());
                            }
                            //销售费用
                            if (null != financial.getSalesExpense() && !financial.getSalesExpense().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getSalesExpense());
                                }
                            }
                            //管理费用
                            if (null != financial.getManagementExpense() && !financial.getManagementExpense().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getManagementExpense());
                                }
                            }
                            //财务费用
                            if (null != financial.getFinanceExpense() && !financial.getFinanceExpense().trim().equals("")) {
                                if (null != currentAssets) {
                                    currentAssets = currentAssets - Long.parseLong(financial.getFinanceExpense());
                                }
                            }
                            //营业利润
                            if (null != currentAssets) {
                                financial.setOperatingProfit(currentAssets + "");
                            }
                            financialStatementList.add(financial);
                        }
                    }
                }
            }
        }
        return report;
    }

    @Override
    public void saveBusiness(FullReport report) {
        if (report != null && report.getId() != null) {
            Integer insertId = report.getId();
            String companyName = report.getNameCN();
            FullReport fullReport = fullReportDao.findByName(companyName);
            Integer fullReportId = null;
            if (fullReport != null) {
                fullReportId = fullReport.getId();
            }
            List<FinancialStatement> statements = report.getFinancialStatementList();
            if (CollectionUtils.isNotEmpty(statements)) {
                if (fullReportId != null) {
                    List<FinancialStatement> statementList = financialStatementDao.findByFullReportId(fullReportId);
                    for (FinancialStatement financialStatement : statementList) {
                        financialStatementDao.deleteById(financialStatement.getId());
                    }
                }
                for (FinancialStatement statement : statements) {
                    statement.setFullReportId(insertId);
                    statement.setUpdateTime(DateUtil.getCurrentDate());
                    financialStatementDao.insert(statement);
                }
            }
        }
    }

}
