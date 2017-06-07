package com.mika.credit.facade.admin.service;


import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.UsCodes;

/**
 * 美国行业代码
 * @author michael
 * 			2017/5/15
 */
public interface UsCodesService {

    /**
	 * 根据用户输入的信息查询美国行业代码相关数据
	 * @param usCodes	 美国行业代码信息
	 * @return
	 */
	ResponseResult<UsCodes> findIntCodes(UsCodes usCodes);

	/**
	 * 根据国际代码查询美国行业代码相关数据
	 * @param intCodes 国际代码
	 * @return
	 */
	ResponseResult<UsCodes> findUsCodesByIntCode(String intCodes);






}
