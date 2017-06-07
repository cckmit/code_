
package com.creditsafe.globaldata.datatypes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>NotificationSettings complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NotificationSettings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="NotificationIntervalDays" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="LastNotificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationSettings")
@XmlSeeAlso({
    HttpNotificationSettings.class,
    FtpNotificationSettings.class,
    EmailNotificationSettings.class
})
public abstract class NotificationSettings implements Serializable {

    @XmlAttribute(name = "NotificationIntervalDays")
    @XmlSchemaType(name = "unsignedInt")
    protected Long notificationIntervalDays;
    @XmlAttribute(name = "LastNotificationDate")
    protected String lastNotificationDate;

    /**
     * 获取notificationIntervalDays属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNotificationIntervalDays() {
        return notificationIntervalDays;
    }

    /**
     * 设置notificationIntervalDays属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNotificationIntervalDays(Long value) {
        this.notificationIntervalDays = value;
    }

    /**
     * 获取lastNotificationDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastNotificationDate() {
        return lastNotificationDate;
    }

    /**
     * 设置lastNotificationDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastNotificationDate(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.lastNotificationDate = jsonObject.getString("year");
            this.lastNotificationDate = value.substring(0,10);

        }else{
            this.lastNotificationDate = value;
        }
    }

}
