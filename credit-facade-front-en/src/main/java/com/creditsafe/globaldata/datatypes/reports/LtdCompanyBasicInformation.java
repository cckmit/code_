
package com.creditsafe.globaldata.datatypes.reports;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.creditsafe.globaldata.datatypes.AddressData;
import com.creditsafe.globaldata.datatypes.CountryCode;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>LtdCompanyBasicInformation complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdCompanyBasicInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BusinessName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="RegisteredCompanyName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CompanyRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Country" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode"/&gt;
 *         &lt;element name="VatRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VatRegistrationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="DateofCompanyRegistration" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="DateofStartingOperations" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="CommercialCourt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LegalForm" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LegalForm" minOccurs="0"/&gt;
 *         &lt;element name="TypeofOwnership" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CompanyStatus" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyStatusDescription" minOccurs="0"/&gt;
 *         &lt;element name="PrincipalActivity" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyActivity" minOccurs="0"/&gt;
 *         &lt;element name="ContactAddress" type="{http://www.creditsafe.com/globaldata/datatypes}AddressData" minOccurs="0"/&gt;
 *         &lt;element name="ContactTelephoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LtdCompanyBasicInformation", propOrder = {
    "businessName",
    "registeredCompanyName",
    "companyRegistrationNumber",
    "country",
    "vatRegistrationNumber",
    "vatRegistrationDate",
    "dateofCompanyRegistration",
    "dateofStartingOperations",
    "commercialCourt",
    "legalForm",
    "typeofOwnership",
    "companyStatus",
    "principalActivity",
    "contactAddress",
    "contactTelephoneNumber"
})
public class LtdCompanyBasicInformation implements Serializable {

    @XmlElement(name = "BusinessName", required = true)
    protected String businessName;
    @XmlElement(name = "RegisteredCompanyName", required = true)
    protected String registeredCompanyName;
    @XmlElement(name = "CompanyRegistrationNumber")
    protected String companyRegistrationNumber;
    @XmlElement(name = "Country", required = true)
    @XmlSchemaType(name = "string")
    protected CountryCode country;
    @XmlElement(name = "VatRegistrationNumber")
    protected String vatRegistrationNumber;
    @XmlElement(name = "VatRegistrationDate")
    protected String vatRegistrationDate;
    @XmlElement(name = "DateofCompanyRegistration")
    protected String dateofCompanyRegistration;
    @XmlElement(name = "DateofStartingOperations")
    protected String dateofStartingOperations;
    @XmlElement(name = "CommercialCourt")
    protected String commercialCourt;
    @XmlElement(name = "LegalForm")
    protected LegalForm legalForm;
    @XmlElement(name = "TypeofOwnership")
    protected String typeofOwnership;
    @XmlElement(name = "CompanyStatus")
    protected CompanyStatusDescription companyStatus;
    @XmlElement(name = "PrincipalActivity")
    protected CompanyActivity principalActivity;
    @XmlElement(name = "ContactAddress")
    protected AddressData contactAddress;
    @XmlElement(name = "ContactTelephoneNumber")
    protected String contactTelephoneNumber;

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
     * 获取registeredCompanyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredCompanyName() {
        return registeredCompanyName;
    }

    /**
     * 设置registeredCompanyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredCompanyName(String value) {
        this.registeredCompanyName = value;
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
     * 获取vatRegistrationNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatRegistrationNumber() {
        return vatRegistrationNumber;
    }

    /**
     * 设置vatRegistrationNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatRegistrationNumber(String value) {
        this.vatRegistrationNumber = value;
    }

    /**
     * 获取vatRegistrationDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatRegistrationDate() {
        return vatRegistrationDate;
    }

    /**
     * 设置vatRegistrationDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatRegistrationDate(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.vatRegistrationDate = jsonObject.getString("year");
            this.vatRegistrationDate = value.substring(0,10);
        }else{
            this.vatRegistrationDate = value;
        }
    }

    /**
     * 获取dateofCompanyRegistration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateofCompanyRegistration() {
        return dateofCompanyRegistration;
    }

    /**
     * 设置dateofCompanyRegistration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateofCompanyRegistration(String value) {
        if (StringUtil.isNotNull(value.trim())){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.dateofCompanyRegistration = jsonObject.getString("year");
            this.dateofCompanyRegistration = value.substring(0,10);

        }else{
            this.dateofCompanyRegistration = value;
        }
    }

    /**
     * 获取dateofStartingOperations属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateofStartingOperations() {
        return dateofStartingOperations;
    }

    /**
     * 设置dateofStartingOperations属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateofStartingOperations(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.dateofStartingOperations = jsonObject.getString("year");
            this.dateofStartingOperations = value.substring(0,10);
        }else{
            this.dateofStartingOperations = value;
        }
    }

    /**
     * 获取commercialCourt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommercialCourt() {
        return commercialCourt;
    }

    /**
     * 设置commercialCourt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommercialCourt(String value) {
        this.commercialCourt = value;
    }

    /**
     * 获取legalForm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LegalForm }
     *     
     */
    public LegalForm getLegalForm() {
        return legalForm;
    }

    /**
     * 设置legalForm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LegalForm }
     *     
     */
    public void setLegalForm(LegalForm value) {
        this.legalForm = value;
    }

    /**
     * 获取typeofOwnership属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeofOwnership() {
        return typeofOwnership;
    }

    /**
     * 设置typeofOwnership属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeofOwnership(String value) {
        this.typeofOwnership = value;
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
     * 获取principalActivity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CompanyActivity }
     *     
     */
    public CompanyActivity getPrincipalActivity() {
        return principalActivity;
    }

    /**
     * 设置principalActivity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyActivity }
     *     
     */
    public void setPrincipalActivity(CompanyActivity value) {
        this.principalActivity = value;
    }

    /**
     * 获取contactAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AddressData }
     *     
     */
    public AddressData getContactAddress() {
        return contactAddress;
    }

    /**
     * 设置contactAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AddressData }
     *     
     */
    public void setContactAddress(AddressData value) {
        this.contactAddress = value;
    }

    /**
     * 获取contactTelephoneNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactTelephoneNumber() {
        return contactTelephoneNumber;
    }

    /**
     * 设置contactTelephoneNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactTelephoneNumber(String value) {
        this.contactTelephoneNumber = value;
    }

}
