
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * <p>ChangeRangeCondition complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ChangeRangeCondition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ValueBasedCondition"&gt;
 *       &lt;attribute name="MinChange" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="MaxChange" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeRangeCondition")
public class ChangeRangeCondition
    extends ValueBasedCondition implements Serializable
{

    @XmlAttribute(name = "MinChange")
    protected BigDecimal minChange;
    @XmlAttribute(name = "MaxChange")
    protected BigDecimal maxChange;

    /**
     * 获取minChange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinChange() {
        return minChange;
    }

    /**
     * 设置minChange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinChange(BigDecimal value) {
        this.minChange = value;
    }

    /**
     * 获取maxChange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxChange() {
        return maxChange;
    }

    /**
     * 设置maxChange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxChange(BigDecimal value) {
        this.maxChange = value;
    }

}
