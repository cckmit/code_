package com.mika.credit.facade.admin.service;


import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.ChnCodes;

/**
 * 中国行业代码
 * @author michael
 * 			2017/5/15
 */
public interface ChnCodesService {

	/**
	 * 根据用户输入的信息查询中国行业代码相关数据
	 * @param chnCodes 中国行业代码信息
	 * @return
	 */
	ResponseResult<ChnCodes> findChnCodes(ChnCodes chnCodes);


	/**
	 * 根据国际代码查询中国行业代码相关数据
	 * @param intCode 国际代码
	 * @return
	 */
	ResponseResult<ChnCodes> findChnCodesByIntCode(String intCode);





}
