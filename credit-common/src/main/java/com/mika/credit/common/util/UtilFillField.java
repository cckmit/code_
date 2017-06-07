package com.mika.credit.common.util;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

/**
 * Created by Gavin on 2017/4/14.
 * 简易对象属性填充
 */
public class UtilFillField {

    public static Object fill(Class clazz) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Object obj = UtilReflect.getInstance(clazz);
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            Class childClazz = field.getType();
            Class superClazz = childClazz.getSuperclass();
            Object childObj = null;
            try {
                if(childClazz.isInterface()){

                } else if(childClazz.equals(String.class)){
                    childObj = UtilGenerateID.generateID("FILL");
                } else if(childClazz.isEnum()){
//                    if(childClazz.isAssignableFrom(CountryCode.class)){
//                        childObj = CountryCode.CN;
//                    }else if(childClazz.isAssignableFrom(Currency.class)){
//                        childObj = Currency.CNY;
//                    }else if(childClazz.isAssignableFrom(CommonRatingValue.class)){
//                        childObj = CommonRatingValue.A;
//                    }
                } else if(superClazz.equals(Number.class)){

                } else if(childClazz.equals(XMLGregorianCalendar.class)){
                    XMLGregorianCalendar date = new XMLGregorianCalendarImpl();
                    Calendar c = Calendar.getInstance();
                    date.setYear(c.get(Calendar.YEAR));
                    date.setMonth(c.get(Calendar.MONTH));
                    date.setDay(c.get(Calendar.DATE));
                    date.setHour(c.get(Calendar.HOUR));
                    date.setMinute(c.get(Calendar.MINUTE));
                    date.setSecond(c.get(Calendar.SECOND));
                    childObj = date;
                } else {
                    childObj = fill(childClazz);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            UtilReflect.setProperty(obj, field.getName(), childClazz, childObj);
        }
        return obj;
    }

}
