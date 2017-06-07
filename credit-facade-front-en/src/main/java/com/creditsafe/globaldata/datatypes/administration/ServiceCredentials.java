
package com.creditsafe.globaldata.datatypes.administration;

import systemtypes.SystemServiceModelSecurityX509CertificateValidationMode;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>ServiceCredentials complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServiceCredentials"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClientCertificate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceCertificateValidationMode" type="{systemtypes}System.ServiceModel.Security.X509CertificateValidationMode" minOccurs="0"/&gt;
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceCredentials", propOrder = {
    "clientCertificate",
    "serviceCertificateValidationMode",
    "userName",
    "password"
})
public class ServiceCredentials implements Serializable {

    @XmlElement(name = "ClientCertificate")
    protected String clientCertificate;
    @XmlElement(name = "ServiceCertificateValidationMode")
    @XmlSchemaType(name = "string")
    protected SystemServiceModelSecurityX509CertificateValidationMode serviceCertificateValidationMode;
    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElement(name = "Password")
    protected String password;

    /**
     * 获取clientCertificate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientCertificate() {
        return clientCertificate;
    }

    /**
     * 设置clientCertificate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientCertificate(String value) {
        this.clientCertificate = value;
    }

    /**
     * 获取serviceCertificateValidationMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemServiceModelSecurityX509CertificateValidationMode }
     *     
     */
    public SystemServiceModelSecurityX509CertificateValidationMode getServiceCertificateValidationMode() {
        return serviceCertificateValidationMode;
    }

    /**
     * 设置serviceCertificateValidationMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemServiceModelSecurityX509CertificateValidationMode }
     *     
     */
    public void setServiceCertificateValidationMode(SystemServiceModelSecurityX509CertificateValidationMode value) {
        this.serviceCertificateValidationMode = value;
    }

    /**
     * 获取userName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置userName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
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

}
