
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.PortfolioSettings;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="portfolioId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="newSettings" type="{http://www.creditsafe.com/globaldata/datatypes}PortfolioSettings" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "portfolioId",
    "newSettings"
})
@XmlRootElement(name = "SetPortfolioSettings")
public class SetPortfolioSettings {

    @XmlSchemaType(name = "unsignedInt")
    protected Long portfolioId;
    @XmlElementRef(name = "newSettings", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<PortfolioSettings> newSettings;

    /**
     * 获取portfolioId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPortfolioId() {
        return portfolioId;
    }

    /**
     * 设置portfolioId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPortfolioId(Long value) {
        this.portfolioId = value;
    }

    /**
     * 获取newSettings属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PortfolioSettings }{@code >}
     *     
     */
    public JAXBElement<PortfolioSettings> getNewSettings() {
        return newSettings;
    }

    /**
     * 设置newSettings属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PortfolioSettings }{@code >}
     *     
     */
    public void setNewSettings(JAXBElement<PortfolioSettings> value) {
        this.newSettings = value;
    }

}
