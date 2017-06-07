package com.mika.credit.facade.globalsearch.core.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.model.History;


/**
 * Created by mika on 2016/7/28.
 */
public interface HistoryService {
    BootGrid<History> getHistories(History history);

    ResponseResult<History> addCart(History history);

    ResponseResult<History> deleteCart(int id);
}
