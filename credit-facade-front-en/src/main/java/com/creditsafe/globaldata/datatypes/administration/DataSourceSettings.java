
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>DataSourceSettings complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DataSourceSettings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Countries"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Country" type="{http://www.creditsafe.com/globaldata/datatypes/administration}CountrySettings" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ReportPricing" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ReportPricing" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Enabled" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSourceSettings", propOrder = {
    "countries",
    "reportPricing"
})
public class DataSourceSettings implements Serializable {

    @XmlElement(name = "Countries", required = true)
    protected Countries countries;
    @XmlElement(name = "ReportPricing")
    protected ReportPricing reportPricing;
    @XmlAttribute(name = "Enabled", required = true)
    protected boolean enabled;

    /**
     * 获取countries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Countries }
     *     
     */
    public Countries getCountries() {
        return countries;
    }

    /**
     * 设置countries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Countries }
     *     
     */
    public void setCountries(Countries value) {
        this.countries = value;
    }

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


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Country" type="{http://www.creditsafe.com/globaldata/datatypes/administration}CountrySettings" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "country"
    })
    public static class Countries {

        @XmlElement(name = "Country")
        protected List<CountrySettings> country;

        /**
         * Gets the value of the country property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the country property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCountry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CountrySettings }
         * 
         * 
         */
        public List<CountrySettings> getCountry() {
            if (country == null) {
                country = new ArrayList<CountrySettings>();
            }
            return this.country;
        }

    }

}
