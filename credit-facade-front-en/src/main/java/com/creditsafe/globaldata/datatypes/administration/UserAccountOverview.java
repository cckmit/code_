
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>UserAccountOverview complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UserAccountOverview"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContractType" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ContractType" minOccurs="0"/&gt;
 *         &lt;element name="ParentProduct" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ExternalProduct" minOccurs="0"/&gt;
 *         &lt;element name="LastLogin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="BannedTill" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="Enabled" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="CustomerId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccountOverview", propOrder = {
    "username",
    "email",
    "contractType",
    "parentProduct",
    "lastLogin",
    "bannedTill",
    "notes"
})
public class UserAccountOverview implements Serializable {

    @XmlElement(name = "Username", required = true)
    protected String username;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "ContractType")
    @XmlSchemaType(name = "string")
    protected ContractType contractType;
    @XmlElement(name = "ParentProduct")
    @XmlSchemaType(name = "string")
    protected ExternalProduct parentProduct;
    @XmlElement(name = "LastLogin")
    protected String lastLogin;
    @XmlElement(name = "BannedTill")
    protected String bannedTill;
    @XmlElement(name = "Notes")
    protected String notes;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long id;
    @XmlAttribute(name = "Enabled", required = true)
    protected boolean enabled;
    @XmlAttribute(name = "CustomerId")
    @XmlSchemaType(name = "unsignedInt")
    protected Long customerId;

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
     * 获取lastLogin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastLogin() {
        return lastLogin;
    }

    /**
     * 设置lastLogin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastLogin(String value) {
        this.lastLogin = value;
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

}
