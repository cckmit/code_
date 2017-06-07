
package com.creditsafe.globaldata.datatypes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * <p>ReportOrder complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReportOrder"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CompanyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReportType" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyReportType" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{http://www.creditsafe.com/globaldata/datatypes}Language" minOccurs="0"/&gt;
 *         &lt;element name="PlacementDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="ApproxWaitingTime" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" /&gt;
 *       &lt;attribute name="ChargeReference" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportOrder", propOrder = {
    "companyId",
    "reportType",
    "language",
    "placementDate",
    "approxWaitingTime"
})
public class ReportOrder
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "CompanyId")
    protected String companyId;
    @XmlElement(name = "ReportType")
    @XmlSchemaType(name = "string")
    protected CompanyReportType reportType;
    @XmlElement(name = "Language")
    @XmlSchemaType(name = "string")
    protected Language language;
    @XmlElement(name = "PlacementDate")
    protected String placementDate;
    @XmlElement(name = "ApproxWaitingTime")
    protected Duration approxWaitingTime;
    @XmlAttribute(name = "OrderNumber")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger orderNumber;
    @XmlAttribute(name = "ChargeReference")
    protected String chargeReference;

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
     * 获取language属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Language }
     *     
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * 设置language属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Language }
     *     
     */
    public void setLanguage(Language value) {
        this.language = value;
    }

    /**
     * 获取placementDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacementDate() {
        return placementDate;
    }

    /**
     * 设置placementDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacementDate(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.placementDate = jsonObject.getString("year");
            this.placementDate = value.substring(0,10);

        }else{
            this.placementDate = value;
        }
    }

    /**
     * 获取approxWaitingTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getApproxWaitingTime() {
        return approxWaitingTime;
    }

    /**
     * 设置approxWaitingTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setApproxWaitingTime(Duration value) {
        this.approxWaitingTime = value;
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
     * 获取chargeReference属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeReference() {
        return chargeReference;
    }

    /**
     * 设置chargeReference属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeReference(String value) {
        this.chargeReference = value;
    }

}
