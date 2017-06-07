
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>CreditRating complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditRating"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CommonValue" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CommonRatingValue" minOccurs="0"/&gt;
 *         &lt;element name="CommonDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CreditLimit" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_String" minOccurs="0"/&gt;
 *         &lt;element name="ProviderValue" type="{http://www.creditsafe.com/globaldata/datatypes/reports}RangeDescribedValue_String" minOccurs="0"/&gt;
 *         &lt;element name="ProviderDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditRating", propOrder = {
    "commonValue",
    "commonDescription",
    "creditLimit",
    "providerValue",
    "providerDescription"
})
public class CreditRating implements Serializable {

    @XmlElement(name = "CommonValue")
    @XmlSchemaType(name = "string")
    protected CommonRatingValue commonValue;
    @XmlElement(name = "CommonDescription")
    protected String commonDescription;
    @XmlElement(name = "CreditLimit")
    protected FinancialValueString creditLimit;
    @XmlElement(name = "ProviderValue")
    protected RangeDescribedValueString providerValue;
    @XmlElement(name = "ProviderDescription")
    protected String providerDescription;

    /**
     * 获取commonValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CommonRatingValue }
     *     
     */
    public CommonRatingValue getCommonValue() {
        return commonValue;
    }

    /**
     * 设置commonValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CommonRatingValue }
     *     
     */
    public void setCommonValue(CommonRatingValue value) {
        this.commonValue = value;
    }

    /**
     * 获取commonDescription属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommonDescription() {
        return commonDescription;
    }

    /**
     * 设置commonDescription属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommonDescription(String value) {
        this.commonDescription = value;
    }

    /**
     * 获取creditLimit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueString }
     *     
     */
    public FinancialValueString getCreditLimit() {
        return creditLimit;
    }

    /**
     * 设置creditLimit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueString }
     *     
     */
    public void setCreditLimit(FinancialValueString value) {
        this.creditLimit = value;
    }

    /**
     * 获取providerValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RangeDescribedValueString }
     *     
     */
    public RangeDescribedValueString getProviderValue() {
        return providerValue;
    }

    /**
     * 设置providerValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RangeDescribedValueString }
     *     
     */
    public void setProviderValue(RangeDescribedValueString value) {
        this.providerValue = value;
    }

    /**
     * 获取providerDescription属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderDescription() {
        return providerDescription;
    }

    /**
     * 设置providerDescription属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderDescription(String value) {
        this.providerDescription = value;
    }

}
