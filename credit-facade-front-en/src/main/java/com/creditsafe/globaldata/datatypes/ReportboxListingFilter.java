
package com.creditsafe.globaldata.datatypes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * <p>ReportboxListingFilter complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReportboxListingFilter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/&gt;
 *         &lt;element name="CompanyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReportType" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyReportType" minOccurs="0"/&gt;
 *         &lt;element name="OrderedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="OrderedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="CompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Country" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode" minOccurs="0"/&gt;
 *         &lt;element name="Realised" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportboxListingFilter", propOrder = {
    "id",
    "orderNumber",
    "companyId",
    "reportType",
    "orderedAfter",
    "orderedBefore",
    "companyName",
    "country",
    "realised"
})
public class ReportboxListingFilter implements Serializable {

    @XmlElement(name = "Id")
    @XmlSchemaType(name = "unsignedInt")
    protected Long id;
    @XmlElement(name = "OrderNumber")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger orderNumber;
    @XmlElement(name = "CompanyId")
    protected String companyId;
    @XmlElement(name = "ReportType")
    @XmlSchemaType(name = "string")
    protected CompanyReportType reportType;
    @XmlElement(name = "OrderedAfter")
    protected String orderedAfter;
    @XmlElement(name = "OrderedBefore")
    protected String orderedBefore;
    @XmlElement(name = "CompanyName")
    protected String companyName;
    @XmlElement(name = "Country")
    @XmlSchemaType(name = "string")
    protected CountryCode country;
    @XmlElement(name = "Realised")
    protected Boolean realised;

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * 获取orderNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置orderNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderNumber(BigInteger value) {
        this.orderNumber = value;
    }

    /**
     * 获取companyId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置companyId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyId(String value) {
        this.companyId = value;
    }

    /**
     * 获取reportType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CompanyReportType }
     *     
     */
    public CompanyReportType getReportType() {
        return reportType;
    }

    /**
     * 设置reportType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyReportType }
     *     
     */
    public void setReportType(CompanyReportType value) {
        this.reportType = value;
    }

    /**
     * 获取orderedAfter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderedAfter() {
        return orderedAfter;
    }

    /**
     * 设置orderedAfter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderedAfter(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.orderedAfter = jsonObject.getString("year");
            this.orderedAfter = value.substring(0,10);

        }else{
            this.orderedAfter = value;
        }
    }

    /**
     * 获取orderedBefore属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getOrderedBefore() {
        return orderedBefore;
    }

    /**
     * 设置orderedBefore属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderedBefore(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.orderedBefore = jsonObject.getString("year");
            this.orderedBefore = value.substring(0,10);

        }else{
            this.orderedBefore = value;
        }
    }

    /**
     * 获取companyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置companyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * 获取country属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CountryCode }
     *     
     */
    public CountryCode getCountry() {
        return country;
    }

    /**
     * 设置country属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CountryCode }
     *     
     */
    public void setCountry(CountryCode value) {
        this.country = value;
    }

    /**
     * 获取realised属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRealised() {
        return realised;
    }

    /**
     * 设置realised属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRealised(Boolean value) {
        this.realised = value;
    }

}
