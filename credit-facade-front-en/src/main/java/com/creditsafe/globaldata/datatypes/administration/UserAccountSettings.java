
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>UserAccountSettings complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UserAccountSettings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="CustomerId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContractType" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ContractType" minOccurs="0"/&gt;
 *         &lt;element name="ParentProduct" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ExternalProduct" minOccurs="0"/&gt;
 *         &lt;element name="BannedTill" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccountSettings", propOrder = {
    "username",
    "password",
    "enabled",
    "customerId",
    "email",
    "contractType",
    "parentProduct",
    "bannedTill",
    "notes"
})
public class UserAccountSettings implements Serializable {

    @XmlElement(name = "Username")
    protected String username;
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "Enabled")
    protected boolean enabled;
    @XmlElement(name = "CustomerId")
    @XmlSchemaType(name = "unsignedInt")
    protected Long customerId;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "ContractType")
    @XmlSchemaType(name = "string")
    protected ContractType contractType;
    @XmlElement(name = "ParentProduct")
    @XmlSchemaType(name = "string")
    protected ExternalProduct parentProduct;
    @XmlElement(name = "BannedTill")
    protected String bannedTill;
    @XmlElement(name = "Notes")
    protected String notes;

    /**
     * 获取username属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置username属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * 获取password属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置password属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * 获取enabled属性的值。
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置enabled属性的值。
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * 获取customerId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置customerId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerId(Long value) {
        this.customerId = value;
    }

    /**
     * 获取email属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * 获取contractType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getContractType() {
        return contractType;
    }

    /**
     * 设置contractType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setContractType(ContractType value) {
        this.contractType = value;
    }

    /**
     * 获取parentProduct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ExternalProduct }
     *     
     */
    public ExternalProduct getParentProduct() {
        return parentProduct;
    }

    /**
     * 设置parentProduct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalProduct }
     *     
     */
    public void setParentProduct(ExternalProduct value) {
        this.parentProduct = value;
    }

    /**
     * 获取bannedTill属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBannedTill() {
        return bannedTill;
    }

    /**
     * 设置bannedTill属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBannedTill(String value) {
        this.bannedTill = value;
    }

    /**
     * 获取notes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置notes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

}
