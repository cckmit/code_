
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.AddressData;
import com.creditsafe.globaldata.datatypes.CountryCode;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>CustomerSettings complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustomerSettings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="OwningEntity" type="{http://www.creditsafe.com/globaldata/datatypes/administration}CreditsafeEntity"/&gt;
 *         &lt;element name="AccountManager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.creditsafe.com/globaldata/datatypes/administration}CustomerStatus"/&gt;
 *         &lt;element name="Country" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{http://www.creditsafe.com/globaldata/datatypes}AddressData" minOccurs="0"/&gt;
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FrontSystemNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BackOfficeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsReseller" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ContractStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="ContractEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerSettings", propOrder = {
    "name",
    "owningEntity",
    "accountManager",
    "status",
    "country",
    "address",
    "phoneNumber",
    "frontSystemNumber",
    "backOfficeId",
    "isReseller",
    "contractStartDate",
    "contractEndDate"
})
@XmlSeeAlso({
    CustomerData.class
})
public class CustomerSettings implements Serializable {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "OwningEntity", required = true)
    @XmlSchemaType(name = "string")
    protected CreditsafeEntity owningEntity;
    @XmlElement(name = "AccountManager")
    protected String accountManager;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "string")
    protected CustomerStatus status;
    @XmlElement(name = "Country")
    @XmlSchemaType(name = "string")
    protected CountryCode country;
    @XmlElement(name = "Address")
    protected AddressData address;
    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;
    @XmlElement(name = "FrontSystemNumber")
    protected String frontSystemNumber;
    @XmlElement(name = "BackOfficeId")
    protected String backOfficeId;
    @XmlElement(name = "IsReseller")
    protected boolean isReseller;
    @XmlElement(name = "ContractStartDate")
    protected String contractStartDate;
    @XmlElement(name = "ContractEndDate")
    protected String contractEndDate;

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取owningEntity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditsafeEntity }
     *     
     */
    public CreditsafeEntity getOwningEntity() {
        return owningEntity;
    }

    /**
     * 设置owningEntity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditsafeEntity }
     *     
     */
    public void setOwningEntity(CreditsafeEntity value) {
        this.owningEntity = value;
    }

    /**
     * 获取accountManager属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountManager() {
        return accountManager;
    }

    /**
     * 设置accountManager属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountManager(String value) {
        this.accountManager = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustomerStatus }
     *     
     */
    public CustomerStatus getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerStatus }
     *     
     */
    public void setStatus(CustomerStatus value) {
        this.status = value;
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
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AddressData }
     *     
     */
    public AddressData getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AddressData }
     *     
     */
    public void setAddress(AddressData value) {
        this.address = value;
    }

    /**
     * 获取phoneNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置phoneNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * 获取frontSystemNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrontSystemNumber() {
        return frontSystemNumber;
    }

    /**
     * 设置frontSystemNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrontSystemNumber(String value) {
        this.frontSystemNumber = value;
    }

    /**
     * 获取backOfficeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackOfficeId() {
        return backOfficeId;
    }

    /**
     * 设置backOfficeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackOfficeId(String value) {
        this.backOfficeId = value;
    }

    /**
     * 获取isReseller属性的值。
     * 
     */
    public boolean isIsReseller() {
        return isReseller;
    }

    /**
     * 设置isReseller属性的值。
     * 
     */
    public void setIsReseller(boolean value) {
        this.isReseller = value;
    }

    /**
     * 获取contractStartDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractStartDate() {
        return contractStartDate;
    }

    /**
     * 设置contractStartDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractStartDate(String value) {
        this.contractStartDate = value;
    }

    /**
     * 获取contractEndDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractEndDate() {
        return contractEndDate;
    }

    /**
     * 设置contractEndDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractEndDate(String value) {
        this.contractEndDate = value;
    }

}
