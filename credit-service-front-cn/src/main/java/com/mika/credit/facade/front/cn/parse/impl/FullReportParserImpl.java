package com.mika.credit.facade.front.cn.parse.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.facade.front.cn.dao.FullReportDao;
import com.mika.credit.facade.front.cn.parse.FullReportParser;
import com.mika.credit.facade.front.cn.parse.Litigation;
import com.mika.credit.facade.front.cn.parse.QiXinBaoParser;
import com.mika.credit.facade.front.cn.parse.Qianhai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

/**
 * Created by Zhu Jun on 2017/4/10.
 */
@Service
public class FullReportParserImpl implements FullReportParser {

    @Autowired
    private FullReportDao fullReportDao;
    @Autowired
    private Qianhai qianhai;
    @Autowired
    private QiXinBaoParser qiXinBaoParser;
    @Autowired
    private Litigation litigation;

    @Value("${qianhaiInterface}")
    private String QIANHAIURL;
    @Value("${fahaiInterface}")
    private String FAHAIURL;
    @Value("${qixinbaoInterface}")
    private String QIXINBAOURL;

    @Override
    public void parseAll(String companyName) throws Exception {
        FullReport fullReport = new FullReport();
        String qianhaiUrl = QIANHAIURL + "?companyName=" + URLEncoder.encode(companyName, "utf-8");
        String fahaiUrl = FAHAIURL + "?companyName=" + URLEncoder.encode(companyName, "utf-8");
        String qixinbaoUrl = QIXINBAOURL + "?companyName=" + URLEncoder.encode(companyName, "utf-8");
        String qianhaiData = HttpUtil.syncData(qianhaiUrl);
        String fahaiData = HttpUtil.syncData(fahaiUrl);
        String qixinbaoData = HttpUtil.syncData(qixinbaoUrl);

        JSONObject qianhaiObject = JSON.parseObject(qianhaiData);
        JSONObject fahaiObject = JSON.parseObject(fahaiData);
        JSONObject qixinbaoObject = JSON.parseObject(qixinbaoData);
        Boolean qianhaiCode = qianhaiObject.getBoolean("code");
        fullReport.setNameCN(companyName);
        FullReport qianhaiContent = null;
        FullReport fahaiContent = null;
        FullReport qixinbaoContent = null;
        if (qianhaiCode) {
            qianhaiContent = qianhaiObject.getObject("content", FullReport.class);
            fullReport.setQianHaiUpdateTime(qianhaiContent.getQianHaiUpdateTime());
        }
        Boolean fahaiCode = fahaiObject.getBoolean("code");
        if (fahaiCode) {
            fahaiContent = fahaiObject.getObject("content", FullReport.class);
            fullReport.setLitigationUpdateTime(fahaiContent.getLitigationUpdateTime());
        }
        Boolean qixinbaoCode = qixinbaoObject.getBoolean("code");
        if (qixinbaoCode) {
            qixinbaoContent = qixinbaoObject.getObject("content", FullReport.class);
        }
        FullReport byName = fullReportDao.findByName(companyName);
        if (byName != null) {
            fullReport.setId(byName.getId());
        } else {
            this.fullReportDao.insert(fullReport);
        }
        int fullReportId = fullReport.getId();
        if (qianhaiContent != null) {
            qianhaiContent.setId(fullReportId);
            qianhai.saveBusiness(qianhaiContent);
        }
        if (qixinbaoContent != null) {
            qixinbaoContent.setId(fullReportId);
            qiXinBaoParser.saveBusiness(qixinbaoContent);
        }
        if (fahaiContent != null) {
            fahaiContent.setId(fullReportId);
            litigation.saveBusiness(fahaiContent);
        }
    }

}
