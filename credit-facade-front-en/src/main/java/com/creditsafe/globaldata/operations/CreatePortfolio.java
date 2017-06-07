
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
 *         &lt;element name="settings" type="{http://www.creditsafe.com/globaldata/datatypes}PortfolioSettings" minOccurs="0"/&gt;
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
    "settings"
})
@XmlRootElement(name = "CreatePortfolio")
public class CreatePortfolio {

    @XmlElementRef(name = "settings", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<PortfolioSettings> settings;

    /**
     * 获取settings属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PortfolioSettings }{@code >}
     *     
     */
    public JAXBElement<PortfolioSettings> getSettings() {
        return settings;
    }

    /**
     * 设置settings属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PortfolioSettings }{@code >}
     *     
     */
    public void setSettings(JAXBElement<PortfolioSettings> value) {
        this.settings = value;
    }

}
