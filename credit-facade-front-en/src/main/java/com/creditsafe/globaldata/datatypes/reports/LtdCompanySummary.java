
package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.CountryCode;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>LtdCompanySummary complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdCompanySummary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BusinessName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Country" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode"/&gt;
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CompanyRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MainActivity" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyActivity" minOccurs="0"/&gt;
 *         &lt;element name="CompanyStatus" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyStatusDescription" minOccurs="0"/&gt;
 *         &lt;element name="LatestTurnoverFigure" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="LatestShareholdersEquityFigure" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="CreditRating" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CreditRating"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LtdCompanySummary", propOrder = {
    "businessName",
    "country",
    "number",
    "companyRegistrationNumber",
    "mainActivity",
    "companyStatus",
    "latestTurnoverFigure",
    "latestShareholdersEquityFigure",
    "creditRating"
})
public class LtdCompanySummary implements Serializable {

    @XmlElement(name = "BusinessName", required = true)
    protected String businessName;
    @XmlElement(name = "Country", required = true)
    @XmlSchemaType(name = "string")
    protected CountryCode country;
    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "CompanyRegistrationNumber")
    protected String companyRegistrationNumber;
    @XmlElement(name = "MainActivity")
    protected CompanyActivity mainActivity;
    @XmlElement(name = "CompanyStatus")
    protected CompanyStatusDescription companyStatus;
    @XmlElement(name = "LatestTurnoverFigure")
    protected FinancialValueDecimal latestTurnoverFigure;
    @XmlElement(name = "LatestShareholdersEquityFigure")
    protected FinancialValueDecimal latestShareholdersEquityFigure;
    @XmlElement(name = "CreditRating", required = true)
    protected CreditRating creditRating;

    /**
     * 获取businessName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 设置businessName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessName(String value) {
        this.businessName = value;
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
     * 获取number属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置number属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * 获取companyRegistrationNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    /**
     * 设置companyRegistrationNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyRegistrationNumber(String value) {
        this.companyRegistrationNumber = value;
    }

    /**
     * 获取mainActivity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CompanyActivity }
     *     
     */
    public CompanyActivity getMainActivity() {
        return mainActivity;
    }

    /**
     * 设置mainActivity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyActivity }
     *     
     */
    public void setMainActivity(CompanyActivity value) {
        this.mainActivity = value;
    }

    /**
     * 获取companyStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CompanyStatusDescription }
     *     
     */
    public CompanyStatusDescription getCompanyStatus() {
        return companyStatus;
    }

    /**
     * 设置companyStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyStatusDescription }
     *     
     */
    public void setCompanyStatus(CompanyStatusDescription value) {
        this.companyStatus = value;
    }

    /**
     * 获取latestTurnoverFigure属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getLatestTurnoverFigure() {
        return latestTurnoverFigure;
    }

    /**
     * 设置latestTurnoverFigure属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setLatestTurnoverFigure(FinancialValueDecimal value) {
        this.latestTurnoverFigure = value;
    }

    /**
     * 获取latestShareholdersEquityFigure属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getLatestShareholdersEquityFigure() {
        return latestShareholdersEquityFigure;
    }

    /**
     * 设置latestShareholdersEquityFigure属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setLatestShareholdersEquityFigure(FinancialValueDecimal value) {
        this.latestShareholdersEquityFigure = value;
    }

    /**
     * 获取creditRating属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditRating }
     *     
     */
    public CreditRating getCreditRating() {
        return creditRating;
    }

    /**
     * 设置creditRating属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditRating }
     *     
     */
    public void setCreditRating(CreditRating value) {
        this.creditRating = value;
    }

}
