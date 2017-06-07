package com.mika.credit.facade.front.cn.parse.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.core.service.BaseService;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.util.DateUtil;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.facade.front.cn.dao.*;
import com.mika.credit.facade.front.cn.parse.QiXinBaoParser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by dell on 2017/4/8.
 */
@SuppressWarnings("Duplicates")
@Service("qiXinBaoParser")
public class QiXinBaoParserImpl implements QiXinBaoParser {
    @Autowired
    private ChangeInfosDao changeInfosDao;
    @Autowired
    private ManagementsDao managementsDao;
    @Autowired
    private RegistrationInfosDao registrationInfosDao;
    @Autowired
    private ShareholderInfosDao shareholderInfosDao;
    @Autowired
    private BrandsDao brandsDao;
    @Autowired
    private MediaRecordsDao mediaRecordsDao;
    @Autowired
    private IcpWebsiteDao icpWebsiteDao;
    @Autowired
    private FullReportDao fullReportDao;
    @Autowired
    private BasicInfosDao basicInfosDao;
    @Autowired
    private OperationAbnormalInfosDao abnormalInfosDao;
    @Value("${qixinbaoInterface}")
    private String QIXINBAOURL;

    @Override
    public void saveBusiness(FullReport report) {
        if (report != null && report.getId() != null) {
            Integer insertId = report.getId();
            String companyName = report.getNameCN();
            //report = this.getQiXinBaoReport(companyName);
            FullReport fullReport = fullReportDao.findByName(companyName);
            Integer fullReportId = null;
            if (fullReport != null) {
                fullReportId = fullReport.getId();
            }

            //工商注册变更
            List<ChangeInfos> changeInfosList = report.getChangeInfosList();
            if (CollectionUtils.isNotEmpty(changeInfosList)) {
                //先删除数据库已有的注册变更数据
                if (fullReportId != null) {
                    List<ChangeInfos> changeList = changeInfosDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(changeList)) {
                        for (ChangeInfos aChangeList : changeList) {
                            changeInfosDao.deleteById(aChangeList.getId());
                        }
                    }
                }
                for (ChangeInfos changeInfos : changeInfosList) {
                    changeInfos.setFullReportId(insertId);
                    changeInfos.setUpdateTime(DateUtil.getCurrentDate());
                    changeInfosDao.insert(changeInfos);
                }
            }


            //管理者信息
            List<Managements> managementsList = report.getManagementsList();
            if (CollectionUtils.isNotEmpty(managementsList)) {
                //先删除数据库已有的管理信息数据
                if (fullReportId != null) {
                    List<Managements> managementses = managementsDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(managementses)) {
                        for (Managements management : managementses) {
                            managementsDao.deleteById(management.getId());
                        }
                    }
                }
                for (Managements managements : managementsList) {
                    managements.setFullReportId(insertId);
                    managements.setUpdateTime(DateUtil.getCurrentDate());
                    managementsDao.insert(managements);
                }
            }


            //企业注册信息
            RegistrationInfos infos = report.getRegistrationInfos();
            if (infos != null) {
                if (fullReportId != null) {
                    RegistrationInfos registrationInfos = registrationInfosDao.findByFullReportId(fullReportId);
                    if (registrationInfos != null && registrationInfos.getId() != null) {
                        registrationInfosDao.deleteById(registrationInfos.getId());
                    }
                }
                infos.setFullReportId(insertId);
                infos.setUpdateTime(DateUtil.getCurrentDate());
                registrationInfosDao.insert(infos);
            }


            //股东信息
            List<ShareholderInfos> shareholderInfosList = report.getShareholderInfosList();
            if (CollectionUtils.isNotEmpty(shareholderInfosList)) {
                if (fullReportId != null) {
                    //先删除数据库已有的股东信息数据
                    List<ShareholderInfos> shareholderInfoses = shareholderInfosDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(shareholderInfoses)) {
                        for (ShareholderInfos shareholderInfose : shareholderInfoses) {
                            shareholderInfosDao.deleteById(shareholderInfose.getId());
                        }
                    }
                }
                for (ShareholderInfos shareholderInfos : shareholderInfosList) {
                    shareholderInfos.setFullReportId(insertId);
                    shareholderInfos.setUpdateTime(DateUtil.getCurrentDate());
                    String shares = shareholderInfos.getShares();
                    if (StringUtils.isNotBlank(shares) && !shares.contains("%")) {
                        shareholderInfos.setShares(shares + "%");
                    }
                    shareholderInfosDao.insert(shareholderInfos);
                }
            }

            //基本信息
            BasicInfos basicInfos = report.getBasicInfos();
            if (basicInfos != null) {
                if (fullReportId != null) {
                    BasicInfos basic = basicInfosDao.findByFullReportId(fullReportId);
                    if (basic != null && basic.getId() != null) {
                        basicInfosDao.deleteById(basic.getId());
                    }
                }
                basicInfos.setFullReportId(insertId);
                basicInfos.setUpdateTime(DateUtil.getCurrentDate());
                basicInfosDao.insert(basicInfos);
            }

            //经营异常信息
            List<OperationAbnormalInfos> abnormalInfoses = report.getOperationAbnormalInfosList();
            if (CollectionUtils.isNotEmpty(abnormalInfoses)) {
                if (fullReportId != null) {
                    List<OperationAbnormalInfos> abnormalInfosList = abnormalInfosDao.findByFullReportId(fullReportId);
                    for (OperationAbnormalInfos operationAbnormalInfos : abnormalInfosList) {
                        abnormalInfosDao.deleteById(operationAbnormalInfos.getId());
                    }
                }
                for (OperationAbnormalInfos abnormalInfose : abnormalInfoses) {
                    abnormalInfose.setUpdateTime(DateUtil.getCurrentDate());
                    abnormalInfose.setFullReportId(insertId);
                    abnormalInfosDao.insert(abnormalInfose);
                }
            }

            //品牌专利
            List<Brands> brandsList = report.getBrandsList();
            if (CollectionUtils.isNotEmpty(brandsList)) {
                if (fullReportId != null) {
                    //删除已有品牌专利
                    List<Brands> brandses = brandsDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(brandses)) {
                        for (Brands brandse : brandses) {
                            brandsDao.deleteById(brandse.getId());
                        }
                    }
                }
                for (Brands brands : brandsList) {
                    brands.setFullReportId(insertId);
                    brands.setUpdateTime(DateUtil.getCurrentDate());
                    brandsDao.insert(brands);
                }
            }


            //媒体记录
            List<MediaRecords> mediaRecordsList = report.getMediaRecordsList();
            if (CollectionUtils.isNotEmpty(mediaRecordsList)) {
                if (fullReportId != null) {
                    //删除已有媒体记录
                    List<MediaRecords> recordses = mediaRecordsDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(recordses)) {
                        for (MediaRecords recordse : recordses) {
                            mediaRecordsDao.deleteById(recordse.getId());
                        }
                    }
                }
                for (MediaRecords mediaRecords : mediaRecordsList) {
                    mediaRecords.setFullReportId(insertId);
                    mediaRecords.setUpdateTime(DateUtil.getCurrentDate());
                    mediaRecordsDao.insert(mediaRecords);

                }
            }
            //互联网登记
            List<IcpWebsite> icpWebsiteList = report.getIcpWebsiteList();
            if (CollectionUtils.isNotEmpty(icpWebsiteList)) {
                if (fullReportId != null) {
                    //删除已有互联网登记数据
                    List<IcpWebsite> icpWebsites = icpWebsiteDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(icpWebsites)) {
                        for (IcpWebsite icpWebsite : icpWebsites) {
                            icpWebsiteDao.deleteById(icpWebsite.getId());
                        }
                    }
                }

                for (IcpWebsite icpWebsite : icpWebsiteList) {
                    icpWebsite.setFullReportId(insertId);
                    icpWebsite.setUpdateTime(DateUtil.getCurrentDate());
                    icpWebsiteDao.insert(icpWebsite);
                }
            }

        }
    }


    @Override
    public FullReport copyFullReport(FullReport report) {
        if (report != null) {
            FullReport qiXinBaoReport = this.getQiXinBaoReport(report.getNameCN());
            if (qiXinBaoReport != null) {
                List<ChangeInfos> changeInfosList = qiXinBaoReport.getChangeInfosList();
                if (CollectionUtils.isNotEmpty(changeInfosList)) {
                    report.setChangeInfosList(changeInfosList);
                }
                List<Managements> managementsList = qiXinBaoReport.getManagementsList();
                if (CollectionUtils.isNotEmpty(managementsList)) {
                    report.setManagementsList(managementsList);
                }
                List<ShareFrozenHis> shareFrozenHisList = qiXinBaoReport.getShareFrozenHisList();
                if (CollectionUtils.isNotEmpty(shareFrozenHisList)) {
                    report.setShareFrozenHisList(shareFrozenHisList);
                }
                List<ShareholderInfos> shareholderInfosList = qiXinBaoReport.getShareholderInfosList();
                if (CollectionUtils.isNotEmpty(shareholderInfosList)) {
                    report.setShareholderInfosList(shareholderInfosList);
                }
                List<Brands> brandsList = qiXinBaoReport.getBrandsList();
                if (CollectionUtils.isNotEmpty(brandsList)) {
                    report.setBrandsList(brandsList);
                }
                List<MediaRecords> mediaRecordsList = qiXinBaoReport.getMediaRecordsList();
                if (CollectionUtils.isNotEmpty(mediaRecordsList)) {
                    report.setMediaRecordsList(mediaRecordsList);
                }
                List<IcpWebsite> icpWebsiteList = qiXinBaoReport.getIcpWebsiteList();
                if (CollectionUtils.isNotEmpty(icpWebsiteList)) {
                    report.setIcpWebsiteList(icpWebsiteList);
                }
                BasicInfos basicInfos = qiXinBaoReport.getBasicInfos();
                if (basicInfos != null) {
                    report.setBasicInfos(basicInfos);
                }
                RegistrationInfos registrationInfos = qiXinBaoReport.getRegistrationInfos();
                if (registrationInfos!=null){
                    report.setRegistrationInfos(registrationInfos);
                }
                List<OperationAbnormalInfos> abnormalInfosList = qiXinBaoReport.getOperationAbnormalInfosList();
                if (CollectionUtils.isNotEmpty(abnormalInfosList)) {
                    report.setOperationAbnormalInfosList(abnormalInfosList);
                }
            }
        }
        return report;
    }

    @Override
    public FullReport getQiXinBaoReport(String companyName) {
        String qixinbaoUrl = null;
        FullReport qixinbaoContent = null;
        if (StringUtils.isNotBlank(companyName)) {
            try {
                qixinbaoUrl = QIXINBAOURL + "?companyName=" + URLEncoder.encode(companyName, "utf-8");
                String qixinbaoData = HttpUtil.syncData(qixinbaoUrl);
                if (StringUtils.isNotBlank(qixinbaoData)) {
                    JSONObject qixinbaoObject = JSON.parseObject(qixinbaoData);
                    Boolean qixinbaoCode = qixinbaoObject.getBoolean("code");
                    if (qixinbaoCode) {
                        qixinbaoContent = qixinbaoObject.getObject("content", FullReport.class);
                        qixinbaoContent.setNameCN(companyName);
                        qixinbaoContent.setUpdateTime(DateUtil.getCurrentDate());
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return qixinbaoContent;
    }
}

