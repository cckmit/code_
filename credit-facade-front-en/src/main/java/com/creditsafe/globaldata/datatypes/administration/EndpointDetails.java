
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>EndpointDetails complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="EndpointDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdentityType" type="{http://www.creditsafe.com/globaldata/datatypes/administration}EndpointIdentityType"/&gt;
 *         &lt;element name="IdentityValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Address" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndpointDetails", propOrder = {
    "identityType",
    "identityValue"
})
public class EndpointDetails implements Serializable {

    @XmlElement(name = "IdentityType", required = true)
    @XmlSchemaType(name = "string")
    protected EndpointIdentityType identityType;
    @XmlElement(name = "IdentityValue")
    protected String identityValue;
    @XmlAttribute(name = "Address", required = true)
    protected String address;

    /**
     * 获取identityType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EndpointIdentityType }
     *     
     */
    public EndpointIdentityType getIdentityType() {
        return identityType;
    }

    /**
     * 设置identityType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EndpointIdentityType }
     *     
     */
    public void setIdentityType(EndpointIdentityType value) {
        this.identityType = value;
    }

    /**
     * 获取identityValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityValue() {
        return identityValue;
    }

    /**
     * 设置identityValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityValue(String value) {
        this.identityValue = value;
    }

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

}
