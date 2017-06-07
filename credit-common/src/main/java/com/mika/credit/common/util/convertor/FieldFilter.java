package com.mika.credit.common.util.convertor;

import java.lang.reflect.Field;

/**
 * Created by dell on 2017/1/23.
 */
public interface FieldFilter
{
    boolean accept(Field field);
}
