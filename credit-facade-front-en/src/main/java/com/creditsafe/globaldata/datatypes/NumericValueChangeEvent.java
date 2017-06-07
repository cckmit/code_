
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * <p>NumericValueChangeEvent complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NumericValueChangeEvent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ChangeEvent"&gt;
 *       &lt;attribute name="PreviousValue" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="NewValue" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumericValueChangeEvent")
public class NumericValueChangeEvent
    extends ChangeEvent implements Serializable
{

    @XmlAttribute(name = "PreviousValue")
    protected BigDecimal previousValue;
    @XmlAttribute(name = "NewValue")
    protected BigDecimal newValue;

    /**
     * 获取previousValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPreviousValue() {
        return previousValue;
    }

    /**
     * 设置previousValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPreviousValue(BigDecimal value) {
        this.previousValue = value;
    }

    /**
     * 获取newValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNewValue() {
        return newValue;
    }

    /**
     * 设置newValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNewValue(BigDecimal value) {
        this.newValue = value;
    }

}
