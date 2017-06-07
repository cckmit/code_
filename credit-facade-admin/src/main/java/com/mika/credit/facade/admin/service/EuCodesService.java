package com.mika.credit.facade.admin.service;


import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.EuCodes;

/**
 * 欧盟行业代码
 * @author michael
 * 			2017/5/15
 */
public interface EuCodesService {

    /**
	 * 根据用户输入的信息查询欧盟行业代码相关数据
	 * @param euCodes	欧盟行业代码信息
	 * @return
	 */
	ResponseResult<EuCodes> findEuCodes(EuCodes euCodes);


	/**
	 * 根据国际代码查询欧盟行业代码相关数据
	 * @param intCode 国际代码
	 * @return
	 */
	ResponseResult<EuCodes> findEuCodesByIntCode(String intCode);






}
