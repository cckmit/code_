
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>SearchCriteriaSchema complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SearchCriteriaSchema"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *         &lt;element name="SafeNumber" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.QueryStringSchema" minOccurs="0"/&gt;
 *         &lt;element name="Type" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_CompanyType" minOccurs="0"/&gt;
 *         &lt;element name="OfficeType" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_OfficeType" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_CompanyStatus" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationNumber" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *         &lt;element name="VatNumber" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{http://www.creditsafe.com/globaldata/datatypes}AddressCriteriaSchema" minOccurs="0"/&gt;
 *         &lt;element name="PhoneNumber" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchCriteriaSchema", propOrder = {
    "id",
    "safeNumber",
    "name",
    "type",
    "officeType",
    "status",
    "registrationNumber",
    "vatNumber",
    "address",
    "phoneNumber"
})
public class SearchCriteriaSchema implements Serializable {

    @XmlElement(name = "Id")
    protected SearchCriteriaSchemaValueSchemaString id;
    @XmlElement(name = "SafeNumber")
    protected SearchCriteriaSchemaValueSchemaString safeNumber;
    @XmlElement(name = "Name")
    protected SearchCriteriaSchemaQueryStringSchema name;
    @XmlElement(name = "Type")
    protected SearchCriteriaSchemaValueSchemaCompanyType type;
    @XmlElement(name = "OfficeType")
    protected SearchCriteriaSchemaValueSchemaOfficeType officeType;
    @XmlElement(name = "Status")
    protected SearchCriteriaSchemaValueSchemaCompanyStatus status;
    @XmlElement(name = "RegistrationNumber")
    protected SearchCriteriaSchemaValueSchemaString registrationNumber;
    @XmlElement(name = "VatNumber")
    protected SearchCriteriaSchemaValueSchemaString vatNumber;
    @XmlElement(name = "Address")
    protected AddressCriteriaSchema address;
    @XmlElement(name = "PhoneNumber")
    protected SearchCriteriaSchemaValueSchemaString phoneNumber;

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setId(SearchCriteriaSchemaValueSchemaString value) {
        this.id = value;
    }

    /**
     * 获取safeNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getSafeNumber() {
        return safeNumber;
    }

    /**
     * 设置safeNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setSafeNumber(SearchCriteriaSchemaValueSchemaString value) {
        this.safeNumber = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaQueryStringSchema }
     *     
     */
    public SearchCriteriaSchemaQueryStringSchema getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaQueryStringSchema }
     *     
     */
    public void setName(SearchCriteriaSchemaQueryStringSchema value) {
        this.name = value;
    }

    /**
     * 获取type属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaCompanyType }
     *     
     */
    public SearchCriteriaSchemaValueSchemaCompanyType getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaCompanyType }
     *     
     */
    public void setType(SearchCriteriaSchemaValueSchemaCompanyType value) {
        this.type = value;
    }

    /**
     * 获取officeType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaOfficeType }
     *     
     */
    public SearchCriteriaSchemaValueSchemaOfficeType getOfficeType() {
        return officeType;
    }

    /**
     * 设置officeType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaOfficeType }
     *     
     */
    public void setOfficeType(SearchCriteriaSchemaValueSchemaOfficeType value) {
        this.officeType = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaCompanyStatus }
     *     
     */
    public SearchCriteriaSchemaValueSchemaCompanyStatus getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaCompanyStatus }
     *     
     */
    public void setStatus(SearchCriteriaSchemaValueSchemaCompanyStatus value) {
        this.status = value;
    }

    /**
     * 获取registrationNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * 设置registrationNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setRegistrationNumber(SearchCriteriaSchemaValueSchemaString value) {
        this.registrationNumber = value;
    }

    /**
     * 获取vatNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getVatNumber() {
        return vatNumber;
    }

    /**
     * 设置vatNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setVatNumber(SearchCriteriaSchemaValueSchemaString value) {
        this.vatNumber = value;
    }

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AddressCriteriaSchema }
     *     
     */
    public AddressCriteriaSchema getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AddressCriteriaSchema }
     *     
     */
    public void setAddress(AddressCriteriaSchema value) {
        this.address = value;
    }

    /**
     * 获取phoneNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置phoneNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setPhoneNumber(SearchCriteriaSchemaValueSchemaString value) {
        this.phoneNumber = value;
    }

}
