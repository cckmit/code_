//package com.mika.credit.facade.gugu.service.impl;
//
//import com.mika.credit.common.entity.report.cn.*;
//import com.mika.credit.common.util.DateUtil;
//import com.mika.credit.facade.cn.dao.*;
//import com.mika.credit.facade.gugu.util.Tool;
//import com.mika.credit.facade.gugu.service.FullReportLocalService;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by dong jian hua on 2017/4/18.
// */
//@Service("fullReportLocalService")
//public class FullReportLocalServiceImpl implements FullReportLocalService {
//    private static Logger logger = Logger.getLogger(FullReportLocalServiceImpl.class);
//
//    @Autowired
//    private FullReportMapper fullReportMapper;
//
//    @Autowired
//    private ChangeInfosMapper changeInfosMapper;
//
//    @Autowired
//    private ShareholderInfosMapper shareholderInfosMapper;
//
//    @Autowired
//    private ManagementsMapper managementsMapper;
//
//    @Autowired
//    private RulingdocumentsMapper rulingdocumentsMapper;
//
//    @Autowired
//    private OperationAbnormalInfosMapper operationAbnormalInfosMapper;
//
//    @Autowired
//    private FyggMapper fyggMapper;
//
//    @Autowired
//    private SxggMapper sxggMapper;
//
//    @Autowired
//    private BrandsMapper brandsMapper;
//
//    @Autowired
//    private MediaRecordsMapper mediaRecordsMapper;
//
//    @Autowired
//    private ExecutiveMapper executiveMapper;
//
//    @Autowired
//    private IcpWebsiteMapper icpWebsiteMapper;
//
//    @Autowired
//    private RegistrationInfosMapper registrationInfosMapper;
//
//    @Override
//    public FullReport getFullReport(FullReport report) {
//        FullReport fullReport = new FullReport();
//        //替换中英文括号
//        report.setNameCN(Tool.replaceSymbol(report.getNameCN()));
//        fullReport = fullReportMapper.findByName(report.getNameCN());
//        if (null != fullReport && null != fullReport.getId()) {//有记录
//            report = getAllFullReport(report);
//        }
//        return report;
//    }
//
//    @Override
//    public void saveFullReport(FullReport report) {
//        if (report != null) {
//            //替换中英文括号
//            report.setNameCN(Tool.replaceSymbol(report.getNameCN()));
//            FullReport fullReport = fullReportMapper.findByName(report.getNameCN());
//            //先判断数据库有没有这条记录
//            if (null== fullReport) {
//                //没有记录生成fid
//                fullReport = new FullReport();
//                fullReport.setNameCN(report.getNameCN());
//                fullReport.setUpdateTime(DateUtil.getCurrentDate());
//                fullReportMapper.insert(fullReport);
//            }
//        }
//    }
//
//    @Override
//    public FullReport getAllFullReport(FullReport report) {
//        FullReport fullReport = new FullReport();
//        fullReport = fullReportMapper.findByName(report.getNameCN());
//        Integer fid = report.getId();
//        report.setId(fid);
//
//        //工商信息
//        RegistrationInfos registrationInfos = registrationInfosMapper.findByFullReportId(fid);
//        if(null != registrationInfos){
//            report.setRegistrationInfos(registrationInfos);
//        }
//
//        //工商变更
//        List<ChangeInfos> changeInfoss =  changeInfosMapper.findByFullReportId(fid);
//        if(changeInfoss.size()>0){
//            report.setChangeInfosList(changeInfoss);
//        }
//
//        //工商股东信息
//        List<ShareholderInfos> shareholderInfoss = shareholderInfosMapper.findByFullReportId(fid);
//        if(shareholderInfoss.size()>0){
//            report.setShareholderInfosList(shareholderInfoss);
//        }
//
//        //工商管理层信息
//        List<Managements> managementss = managementsMapper.findByFullReportId(fid);
//        if(managementss.size()>0){
//            report.setManagementsList(managementss);
//        }
//
//        //工商裁判文书
//        List<Rulingdocuments> rulingdocuments = rulingdocumentsMapper.findByFullReportId(fid);
//        if(rulingdocuments.size()>0){
//            report.setRulingdocumentsList(rulingdocuments);
//        }
//
//        //工商经营异常信息
//        List<OperationAbnormalInfos> operationAbnormalInfos = operationAbnormalInfosMapper.findByFullReportId(fid);
//        if(operationAbnormalInfos.size()>0){
//            report.setOperationAbnormalInfosList(operationAbnormalInfos);
//        }
//
//        //工商被法院公告信息
//        List<Fygg> fygg = fyggMapper.findByFullReportId(fid);
//        if(fygg.size()>0){
//            report.setFyggList(fygg);
//        }
//
//        //工商专利信息
//        List<Brands> brands = brandsMapper.findByFullReportId(fid);
//        if(brands.size()>0){
//            report.setBrandsList(brands);
//        }
//
//        //工商失信被执行人信息
//        List<Sxgg> sxgg = sxggMapper.findByFullReportId(fid);
//        if(sxgg.size()>0){
//            report.setSxggList(sxgg);
//        }
//
//        //新闻(媒体记录)
//        List<MediaRecords> mediaRecordss = mediaRecordsMapper.findByFullReportId(fid);
//        if(mediaRecordss.size()>0){
//            report.setMediaRecordsList(mediaRecordss);
//        }
//
//
//        //工商被执行人信息
//        List<Executive> executives = executiveMapper.findByFullReportId(fid);
//        if(executives.size()>0){
//            report.setExecutiveList(executives);
//        }
//
//        //工商网站
//        List<IcpWebsite> icpWebsites = icpWebsiteMapper.findByFullReportId(fid);
//        if(icpWebsites.size()>0){
//            report.setIcpWebsiteList(icpWebsites);
//        }
//
//        return report;
//    }
//
//}
