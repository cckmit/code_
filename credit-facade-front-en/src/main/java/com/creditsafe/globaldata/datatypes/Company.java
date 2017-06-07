
package com.creditsafe.globaldata.datatypes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Company complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Company"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}CompanyData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AvailableReportTypes"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AvailableReportType" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyReportType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AvailableLanguages"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AvailableLanguage" type="{http://www.creditsafe.com/globaldata/datatypes}Language" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AdditionalData" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AdditionalDataItem" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DateOfLatestAccounts" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="OnlineReports" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="Monitoring" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Company", propOrder = {
    "availableReportTypes",
    "availableLanguages",
    "additionalData"
})
public class Company
    extends CompanyData implements Serializable
{

    @XmlElement(name = "AvailableReportTypes", required = true)
    protected AvailableReportTypes availableReportTypes;
    @XmlElement(name = "AvailableLanguages", required = true)
    protected AvailableLanguages availableLanguages;
    @XmlElement(name = "AdditionalData")
    protected AdditionalData additionalData;
    @XmlAttribute(name = "DateOfLatestAccounts")
    protected String dateOfLatestAccounts;
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
     * 获取additionalData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AdditionalData }
     *     
     */
    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    /**
     * 设置additionalData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalData }
     *     
     */
    public void setAdditionalData(AdditionalData value) {
        this.additionalData = value;
    }

    /**
     * 获取dateOfLatestAccounts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfLatestAccounts() {
        return dateOfLatestAccounts;
    }

    /**
     * 设置dateOfLatestAccounts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfLatestAccounts(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.dateOfLatestAccounts = jsonObject.getString("year");
            this.dateOfLatestAccounts = value.substring(0,10);

        }else{
            this.dateOfLatestAccounts = value;
        }
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
     *         &lt;element name="AdditionalDataItem" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "additionalDataItem"
    })
    public static class AdditionalData implements Serializable{

        @XmlElement(name = "AdditionalDataItem")
        protected List<AdditionalDataItem> additionalDataItem;

        /**
         * Gets the value of the additionalDataItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the additionalDataItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdditionalDataItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AdditionalDataItem }
         * 
         * 
         */
        public List<AdditionalDataItem> getAdditionalDataItem() {
            if (additionalDataItem == null) {
                additionalDataItem = new ArrayList<AdditionalDataItem>();
            }
            return this.additionalDataItem;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class AdditionalDataItem implements Serializable{

            @XmlValue
            protected String value;
            @XmlAttribute(name = "key", required = true)
            protected String key;

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
             * 获取key属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * 设置key属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

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
     *         &lt;element name="AvailableLanguage" type="{http://www.creditsafe.com/globaldata/datatypes}Language" maxOccurs="unbounded"/&gt;
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
    public static class AvailableLanguages implements Serializable{

        @XmlElement(name = "AvailableLanguage", required = true)
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
     *         &lt;element name="AvailableReportType" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyReportType" maxOccurs="unbounded"/&gt;
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
    public static class AvailableReportTypes implements Serializable{

        @XmlElement(name = "AvailableReportType", required = true)
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
