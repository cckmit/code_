package com.mika.credit.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Gavin on 2017/4/14.
 * 反射简单封装
 */
public class UtilReflect {
    public static Object invoke(Object obj, String method, Class[] paramTypes, Object[] params) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class clazz = obj.getClass();
        Method methodObj = clazz.getMethod(method, paramTypes);
        return methodObj.invoke(obj, params);
    }
    public static Object getInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(className);
        return getInstance(clazz);
    }

    public static Object getInstance(Class clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static Class getReturnType(Object bean, String name) throws NoSuchMethodException {
        String getName = "get" + UtilString.upFirst(name);
        return bean.getClass().getMethod(getName).getReturnType();
    }

    public static Object getProperty(Object bean, String name) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String setName = "get" + UtilString.upFirst(name);
        return UtilReflect.invoke(bean, setName, null, null);
    }

    public static void setProperty(Object bean, String name, Class className, Object value) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if(value == null){
            return;
        }
        System.out.println(name + "--" + value);
        String setName = "set" + UtilString.upFirst(name);
        UtilReflect.invoke(bean, setName, new Class[]{className}, new Object[] {value});
    }
}
