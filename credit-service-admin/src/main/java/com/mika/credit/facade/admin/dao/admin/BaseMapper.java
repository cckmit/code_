package com.mika.credit.facade.admin.dao.admin;

import java.util.List;

/**
 * Created by credit on 2017/3/16.
 */
public interface BaseMapper<T> {
    T queryById(Object id);
    List<T> queryAll();
    int save(T example);
    int update(T example);
    int deleteById(Object id);
}
