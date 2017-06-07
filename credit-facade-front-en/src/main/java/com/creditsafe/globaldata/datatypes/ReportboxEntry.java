
package com.creditsafe.globaldata.datatypes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * <p>ReportboxEntry complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReportboxEntry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReportType" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyReportType"/&gt;
 *         &lt;element name="OrderedOn" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Company" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyData"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="OrderNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" /&gt;
 *       &lt;attribute name="Realised" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportboxEntry", propOrder = {
    "reportType",
    "orderedOn",
    "company"
})
public class ReportboxEntry implements Serializable {

    @XmlElement(name = "ReportType", required = true)
    @XmlSchemaType(name = "string")
    protected CompanyReportType reportType;
    @XmlElement(name = "OrderedOn", required = true)
    protected String orderedOn;
    @XmlElement(name = "Company", required = true)
    protected CompanyData company;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long id;
    @XmlAttribute(name = "OrderNumber", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger orderNumber;
    @XmlAttribute(name = "Realised", required = true)
    protected boolean realised;

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
     * 获取orderedOn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderedOn() {
        return orderedOn;
    }

    /**
     * 设置orderedOn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderedOn(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.orderedOn = jsonObject.getString("year");
            this.orderedOn = value.substring(0,10);

        }else{
            this.orderedOn = value;
        }
    }

    /**
     * 获取company属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CompanyData }
     *     
     */
    public CompanyData getCompany() {
        return company;
    }

    /**
     * 设置company属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyData }
     *     
     */
    public void setCompany(CompanyData value) {
        this.company = value;
    }

    /**
     * 获取id属性的值。
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     */
    public void setId(long value) {
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
     * 获取realised属性的值。
     * 
     */
    public boolean isRealised() {
        return realised;
    }

    /**
     * 设置realised属性的值。
     * 
     */
    public void setRealised(boolean value) {
        this.realised = value;
    }

}
