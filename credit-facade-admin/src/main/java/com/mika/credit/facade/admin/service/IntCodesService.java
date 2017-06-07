package com.mika.credit.facade.admin.service;


import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.IntCodes;

/**
 * 国际行业代码
 * @author michael
 * 			2017/5/15
 */
public interface IntCodesService {

    /**
	 * 根据用户输入的信息查询国际行业代码相关数据
	 * @param intCodes	 国际行业代码信息
	 * @return
	 */
	ResponseResult<IntCodes> findIntCodes(IntCodes intCodes);


	/**
	 * 根据国际代码查询国际行业代码相关数据
	 * @param intCodes 国际代码
	 * @return
	 */
	ResponseResult<IntCodes> findEuCodesByIntCode(String intCodes);






}
