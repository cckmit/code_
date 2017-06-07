package com.mika.credit.facade.verify.service;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.CreditCertification;
import com.mika.credit.facade.gugu.model.VerificationResult;

import java.util.List;

/**
 * Created by dong jian hua on 2017/4/17.
 */
public interface VerifyInfoService {

    /**
     * gugu认证的计算(诉讼、注册资本、实缴资本等.)
     * @return creditCertification
     */
    ResponseResult<CreditCertification> getCreditCertification(FullReport fr);

    /**
     * gugu核实
     * @param businessCard
     * @param fr
     * @return
     */
    ResponseResult<VerificationResult> getVerifyInfoModel(BusinessCard businessCard, FullReport fr);

    /**
     * cpm信用评分转换
     * @param score
     * @return
     */
    String transSafeNumber(String score);

    }
