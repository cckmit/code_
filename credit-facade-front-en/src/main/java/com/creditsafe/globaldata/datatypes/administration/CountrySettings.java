
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.CountryCode;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>CountrySettings complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CountrySettings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReportPricing" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ReportPricing" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CountryCode" use="required" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode" /&gt;
 *       &lt;attribute name="Enabled" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountrySettings", propOrder = {
    "reportPricing"
})
public class CountrySettings implements Serializable {

    @XmlElement(name = "ReportPricing")
    protected ReportPricing reportPricing;
    @XmlAttribute(name = "CountryCode", required = true)
    protected CountryCode countryCode;
    @XmlAttribute(name = "Enabled", required = true)
    protected boolean enabled;

    /**
     * 获取reportPricing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReportPricing }
     *     
     */
    public ReportPricing getReportPricing() {
        return reportPricing;
    }

    /**
     * 设置reportPricing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReportPricing }
     *     
     */
    public void setReportPricing(ReportPricing value) {
        this.reportPricing = value;
    }

    /**
     * 获取countryCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CountryCode }
     *     
     */
    public CountryCode getCountryCode() {
        return countryCode;
    }

    /**
     * 设置countryCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CountryCode }
     *     
     */
    public void setCountryCode(CountryCode value) {
        this.countryCode = value;
    }

    /**
     * 获取enabled属性的值。
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置enabled属性的值。
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

}
