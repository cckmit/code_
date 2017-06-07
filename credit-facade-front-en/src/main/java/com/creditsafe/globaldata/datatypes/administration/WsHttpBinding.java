
package com.creditsafe.globaldata.datatypes.administration;

import systemtypes.SystemServiceModelHttpClientCredentialType;
import systemtypes.SystemServiceModelHttpProxyCredentialType;
import systemtypes.SystemServiceModelMessageCredentialType;
import systemtypes.SystemServiceModelSecurityMode;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>WsHttpBinding complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WsHttpBinding"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes/administration}ServiceBinding"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageClientCredentialType" type="{systemtypes}System.ServiceModel.MessageCredentialType" minOccurs="0"/&gt;
 *         &lt;element name="EstablishSecurityContext" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="NegotiateServiceCredential" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="TransportClientCredentialType" type="{systemtypes}System.ServiceModel.HttpClientCredentialType" minOccurs="0"/&gt;
 *         &lt;element name="ProxyCredentialType" type="{systemtypes}System.ServiceModel.HttpProxyCredentialType" minOccurs="0"/&gt;
 *         &lt;element name="Realm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="SecurityMode" use="required" type="{systemtypes}System.ServiceModel.SecurityMode" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsHttpBinding", propOrder = {
    "messageClientCredentialType",
    "establishSecurityContext",
    "negotiateServiceCredential",
    "transportClientCredentialType",
    "proxyCredentialType",
    "realm"
})
public class WsHttpBinding
    extends ServiceBinding implements Serializable
{

    @XmlElement(name = "MessageClientCredentialType")
    @XmlSchemaType(name = "string")
    protected SystemServiceModelMessageCredentialType messageClientCredentialType;
    @XmlElement(name = "EstablishSecurityContext")
    protected Boolean establishSecurityContext;
    @XmlElement(name = "NegotiateServiceCredential")
    protected Boolean negotiateServiceCredential;
    @XmlElement(name = "TransportClientCredentialType")
    @XmlSchemaType(name = "string")
    protected SystemServiceModelHttpClientCredentialType transportClientCredentialType;
    @XmlElement(name = "ProxyCredentialType")
    @XmlSchemaType(name = "string")
    protected SystemServiceModelHttpProxyCredentialType proxyCredentialType;
    @XmlElement(name = "Realm")
    protected String realm;
    @XmlAttribute(name = "SecurityMode", required = true)
    protected SystemServiceModelSecurityMode securityMode;

    /**
     * 获取messageClientCredentialType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemServiceModelMessageCredentialType }
     *     
     */
    public SystemServiceModelMessageCredentialType getMessageClientCredentialType() {
        return messageClientCredentialType;
    }

    /**
     * 设置messageClientCredentialType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemServiceModelMessageCredentialType }
     *     
     */
    public void setMessageClientCredentialType(SystemServiceModelMessageCredentialType value) {
        this.messageClientCredentialType = value;
    }

    /**
     * 获取establishSecurityContext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEstablishSecurityContext() {
        return establishSecurityContext;
    }

    /**
     * 设置establishSecurityContext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEstablishSecurityContext(Boolean value) {
        this.establishSecurityContext = value;
    }

    /**
     * 获取negotiateServiceCredential属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNegotiateServiceCredential() {
        return negotiateServiceCredential;
    }

    /**
     * 设置negotiateServiceCredential属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNegotiateServiceCredential(Boolean value) {
        this.negotiateServiceCredential = value;
    }

    /**
     * 获取transportClientCredentialType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemServiceModelHttpClientCredentialType }
     *     
     */
    public SystemServiceModelHttpClientCredentialType getTransportClientCredentialType() {
        return transportClientCredentialType;
    }

    /**
     * 设置transportClientCredentialType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemServiceModelHttpClientCredentialType }
     *     
     */
    public void setTransportClientCredentialType(SystemServiceModelHttpClientCredentialType value) {
        this.transportClientCredentialType = value;
    }

    /**
     * 获取proxyCredentialType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemServiceModelHttpProxyCredentialType }
     *     
     */
    public SystemServiceModelHttpProxyCredentialType getProxyCredentialType() {
        return proxyCredentialType;
    }

    /**
     * 设置proxyCredentialType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemServiceModelHttpProxyCredentialType }
     *     
     */
    public void setProxyCredentialType(SystemServiceModelHttpProxyCredentialType value) {
        this.proxyCredentialType = value;
    }

    /**
     * 获取realm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealm() {
        return realm;
    }

    /**
     * 设置realm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealm(String value) {
        this.realm = value;
    }

    /**
     * 获取securityMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemServiceModelSecurityMode }
     *     
     */
    public SystemServiceModelSecurityMode getSecurityMode() {
        return securityMode;
    }

    /**
     * 设置securityMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemServiceModelSecurityMode }
     *     
     */
    public void setSecurityMode(SystemServiceModelSecurityMode value) {
        this.securityMode = value;
    }

}
