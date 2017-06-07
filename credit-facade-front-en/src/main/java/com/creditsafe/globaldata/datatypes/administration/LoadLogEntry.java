
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>LoadLogEntry complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LoadLogEntry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="HitsSincePrevious" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="Time" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadLogEntry")
public class LoadLogEntry implements Serializable {

    @XmlAttribute(name = "HitsSincePrevious", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long hitsSincePrevious;
    @XmlAttribute(name = "Time", required = true)
    protected String time;

    /**
     * 获取hitsSincePrevious属性的值。
     * 
     */
    public long getHitsSincePrevious() {
        return hitsSincePrevious;
    }

    /**
     * 设置hitsSincePrevious属性的值。
     * 
     */
    public void setHitsSincePrevious(long value) {
        this.hitsSincePrevious = value;
    }

    /**
     * 获取time属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置time属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

}
