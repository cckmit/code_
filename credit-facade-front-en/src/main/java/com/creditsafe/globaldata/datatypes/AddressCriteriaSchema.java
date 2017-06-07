
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>AddressCriteriaSchema complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AddressCriteriaSchema"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SimpleValue" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.QueryStringSchema" minOccurs="0"/&gt;
 *         &lt;element name="Street" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *         &lt;element name="HouseNumber" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *         &lt;element name="City" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *         &lt;element name="PostalCode" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *         &lt;element name="Province" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressCriteriaSchema", propOrder = {
    "simpleValue",
    "street",
    "houseNumber",
    "city",
    "postalCode",
    "province"
})
public class AddressCriteriaSchema implements Serializable {

    @XmlElement(name = "SimpleValue")
    protected SearchCriteriaSchemaQueryStringSchema simpleValue;
    @XmlElement(name = "Street")
    protected SearchCriteriaSchemaValueSchemaString street;
    @XmlElement(name = "HouseNumber")
    protected SearchCriteriaSchemaValueSchemaString houseNumber;
    @XmlElement(name = "City")
    protected SearchCriteriaSchemaValueSchemaString city;
    @XmlElement(name = "PostalCode")
    protected SearchCriteriaSchemaValueSchemaString postalCode;
    @XmlElement(name = "Province")
    protected SearchCriteriaSchemaValueSchemaString province;

    /**
     * 获取simpleValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaQueryStringSchema }
     *     
     */
    public SearchCriteriaSchemaQueryStringSchema getSimpleValue() {
        return simpleValue;
    }

    /**
     * 设置simpleValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaQueryStringSchema }
     *     
     */
    public void setSimpleValue(SearchCriteriaSchemaQueryStringSchema value) {
        this.simpleValue = value;
    }

    /**
     * 获取street属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getStreet() {
        return street;
    }

    /**
     * 设置street属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setStreet(SearchCriteriaSchemaValueSchemaString value) {
        this.street = value;
    }

    /**
     * 获取houseNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getHouseNumber() {
        return houseNumber;
    }

    /**
     * 设置houseNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setHouseNumber(SearchCriteriaSchemaValueSchemaString value) {
        this.houseNumber = value;
    }

    /**
     * 获取city属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getCity() {
        return city;
    }

    /**
     * 设置city属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setCity(SearchCriteriaSchemaValueSchemaString value) {
        this.city = value;
    }

    /**
     * 获取postalCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getPostalCode() {
        return postalCode;
    }

    /**
     * 设置postalCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setPostalCode(SearchCriteriaSchemaValueSchemaString value) {
        this.postalCode = value;
    }

    /**
     * 获取province属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public SearchCriteriaSchemaValueSchemaString getProvince() {
        return province;
    }

    /**
     * 设置province属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaSchemaValueSchemaString }
     *     
     */
    public void setProvince(SearchCriteriaSchemaValueSchemaString value) {
        this.province = value;
    }

}
