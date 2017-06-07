package com.mika.credit.facade.order.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Gavin on 2017/3/3.
 */
public interface BaseMapper<T> {
    int save(T t);

    int save(Map<String, Object> map);

    int saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int deleteById(Object id);

    int delete(Map<String, Object> map);

    int delete(T example);

    int deleteBatch(Object[] id);

    T queryById(Object id);

    T query(T example);

    List<T> queryList(Map<String, Object> map);

    List<T> queryList(T example);

    int queryTotal(Map<String, Object> map);

    int queryTotal(T t);

    int queryTotal();
}
