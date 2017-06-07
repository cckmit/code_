package com.mika.credit.facade.record.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.record.model.CompanyTrack;
import com.mika.credit.facade.record.model.CompanyTrackQuery;


/**
 * Created by Mike on 2017/6/6.
 */
public interface CompanyTrackService {
    /**
     *  根据id判断是否新增/修改
     * @param companyTrack
     * @return
     */
    ResponseResult<CompanyTrack> saveCompanyTrack(CompanyTrack companyTrack);

    /**
     * 删除
     * @param companyTrack
     * @return
     */
    ResponseResult<CompanyTrack> delCompanyTrack(CompanyTrack companyTrack);

    /**
     * 按条件查询/分页
     * @param companyTrack
     * @return
     */
    BootGrid<CompanyTrackQuery> selSecCompanyTrack(CompanyTrackQuery companyTrack);

    /**
     * 根据Id查
     * @param companyTrackId
     * @return
     */
    ResponseResult<CompanyTrack> selByIdCompanyTrack(Integer companyTrackId);


}
