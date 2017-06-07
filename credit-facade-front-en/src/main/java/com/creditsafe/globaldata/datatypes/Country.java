
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Country complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Country"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AvailableReportTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AvailableReportType" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyReportType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AvailableLanguages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AvailableLanguage" type="{http://www.creditsafe.com/globaldata/datatypes}Language" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Code" use="required" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode" /&gt;
 *       &lt;attribute name="OnlineReports" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="Monitoring" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Country", propOrder = {
    "availableReportTypes",
    "availableLanguages"
})
public class Country implements Serializable {

    @XmlElement(name = "AvailableReportTypes")
    protected AvailableReportTypes availableReportTypes;
    @XmlElement(name = "AvailableLanguages")
    protected AvailableLanguages availableLanguages;
    @XmlAttribute(name = "Code", required = true)
    protected CountryCode code;
    @XmlAttribute(name = "OnlineReports", required = true)
    protected boolean onlineReports;
    @XmlAttribute(name = "Monitoring", required = true)
    protected boolean monitoring;

    /**
     * 获取availableReportTypes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AvailableReportTypes }
     *     
     */
    public AvailableReportTypes getAvailableReportTypes() {
        return availableReportTypes;
    }

    /**
     * 设置availableReportTypes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AvailableReportTypes }
     *     
     */
    public void setAvailableReportTypes(AvailableReportTypes value) {
        this.availableReportTypes = value;
    }

    /**
     * 获取availableLanguages属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AvailableLanguages }
     *     
     */
    public AvailableLanguages getAvailableLanguages() {
        return availableLanguages;
    }

    /**
     * 设置availableLanguages属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AvailableLanguages }
     *     
     */
    public void setAvailableLanguages(AvailableLanguages value) {
        this.availableLanguages = value;
    }

    /**
     * 获取code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CountryCode }
     *     
     */
    public CountryCode getCode() {
        return code;
    }

    /**
     * 设置code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CountryCode }
     *     
     */
    public void setCode(CountryCode value) {
        this.code = value;
    }

    /**
     * 获取onlineReports属性的值。
     * 
     */
    public boolean isOnlineReports() {
        return onlineReports;
    }

    /**
     * 设置onlineReports属性的值。
     * 
     */
    public void setOnlineReports(boolean value) {
        this.onlineReports = value;
    }

    /**
     * 获取monitoring属性的值。
     * 
     */
    public boolean isMonitoring() {
        return monitoring;
    }

    /**
     * 设置monitoring属性的值。
     * 
     */
    public void setMonitoring(boolean value) {
        this.monitoring = value;
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
     *         &lt;element name="AvailableLanguage" type="{http://www.creditsafe.com/globaldata/datatypes}Language" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "availableLanguage"
    })
    public static class AvailableLanguages {

        @XmlElement(name = "AvailableLanguage")
        @XmlSchemaType(name = "string")
        protected List<Language> availableLanguage;

        /**
         * Gets the value of the availableLanguage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the availableLanguage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAvailableLanguage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Language }
         * 
         * 
         */
        public List<Language> getAvailableLanguage() {
            if (availableLanguage == null) {
                availableLanguage = new ArrayList<Language>();
            }
            return this.availableLanguage;
        }

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
     *         &lt;element name="AvailableReportType" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyReportType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "availableReportType"
    })
    public static class AvailableReportTypes {

        @XmlElement(name = "AvailableReportType")
        @XmlSchemaType(name = "string")
        protected List<CompanyReportType> availableReportType;

        /**
         * Gets the value of the availableReportType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the availableReportType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAvailableReportType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CompanyReportType }
         * 
         * 
         */
        public List<CompanyReportType> getAvailableReportType() {
            if (availableReportType == null) {
                availableReportType = new ArrayList<CompanyReportType>();
            }
            return this.availableReportType;
        }

    }

}
