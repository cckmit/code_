
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Message complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Message"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="Type" use="required" type="{http://www.creditsafe.com/globaldata/datatypes}MessageType" /&gt;
 *       &lt;attribute name="Code" use="required" type="{http://www.creditsafe.com/globaldata/datatypes}MessageCode" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", propOrder = {
    "value"
})
public class Message implements Serializable {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Type", required = true)
    protected MessageType type;
    @XmlAttribute(name = "Code", required = true)
    protected long code;

    /**
     * 获取value属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置value属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取type属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MessageType }
     *     
     */
    public MessageType getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MessageType }
     *     
     */
    public void setType(MessageType value) {
        this.type = value;
    }

    /**
     * 获取code属性的值。
     * 
     */
    public long getCode() {
        return code;
    }

    /**
     * 设置code属性的值。
     * 
     */
    public void setCode(long value) {
        this.code = value;
    }

}
