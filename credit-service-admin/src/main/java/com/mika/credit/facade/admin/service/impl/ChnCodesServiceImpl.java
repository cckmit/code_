package com.mika.credit.facade.admin.service.impl;


import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.dao.admin.ChnCodesMapper;
import com.mika.credit.facade.admin.dao.ge.GEContinentMapper;
import com.mika.credit.facade.admin.model.ChnCodes;
import com.mika.credit.facade.admin.service.ChnCodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("chnCodesService")
public class ChnCodesServiceImpl implements ChnCodesService{

	@Autowired
	private ChnCodesMapper chnCodesMapper;
	@Override
	public ResponseResult<ChnCodes> findChnCodes(ChnCodes chnCodes) {
	    ResponseResult<ChnCodes> result=new ResponseResult<>();
        List<ChnCodes> chnCodes1 = chnCodesMapper.selectByPrimaryKey(chnCodes);
        if (chnCodes1.size()>0){
            result.setCode(true);
            result.setResult(chnCodes1);
            result.setMsg("查询成功");
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        return result;
	}

	@Override
	public ResponseResult<ChnCodes> findChnCodesByIntCode(String intCode) {
		return null;
	}
}
