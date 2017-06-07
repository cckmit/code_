
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.Duration;
import java.io.Serializable;


/**
 * <p>Endpoint complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Endpoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Binding" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ServiceBinding"/&gt;
 *         &lt;element name="Details" type="{http://www.creditsafe.com/globaldata/datatypes/administration}EndpointDetails"/&gt;
 *         &lt;element name="ClientCredentials" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ServiceCredentials"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Type" use="required" type="{http://www.creditsafe.com/globaldata/datatypes/administration}EndpointType" /&gt;
 *       &lt;attribute name="Timeout" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Endpoint", propOrder = {
    "binding",
    "details",
    "clientCredentials"
})
public class Endpoint implements Serializable {

    @XmlElement(name = "Binding", required = true)
    protected ServiceBinding binding;
    @XmlElement(name = "Details", required = true)
    protected EndpointDetails details;
    @XmlElement(name = "ClientCredentials", required = true)
    protected ServiceCredentials clientCredentials;
    @XmlAttribute(name = "Type", required = true)
    protected String type;
    @XmlAttribute(name = "Timeout", required = true)
    protected Duration timeout;

    /**
     * 获取binding属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ServiceBinding }
     *     
     */
    public ServiceBinding getBinding() {
        return binding;
    }

    /**
     * 设置binding属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceBinding }
     *     
     */
    public void setBinding(ServiceBinding value) {
        this.binding = value;
    }

    /**
     * 获取details属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EndpointDetails }
     *     
     */
    public EndpointDetails getDetails() {
        return details;
    }

    /**
     * 设置details属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EndpointDetails }
     *     
     */
    public void setDetails(EndpointDetails value) {
        this.details = value;
    }

    /**
     * 获取clientCredentials属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ServiceCredentials }
     *     
     */
    public ServiceCredentials getClientCredentials() {
        return clientCredentials;
    }

    /**
     * 设置clientCredentials属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCredentials }
     *     
     */
    public void setClientCredentials(ServiceCredentials value) {
        this.clientCredentials = value;
    }

    /**
     * 获取type属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * 获取timeout属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * 设置timeout属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTimeout(Duration value) {
        this.timeout = value;
    }

}
