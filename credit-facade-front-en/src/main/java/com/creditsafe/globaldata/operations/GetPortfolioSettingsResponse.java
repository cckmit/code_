
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.CurrentPortfolioSettings;

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
 *         &lt;element name="GetPortfolioSettingsResult" type="{http://www.creditsafe.com/globaldata/datatypes}CurrentPortfolioSettings" minOccurs="0"/&gt;
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
    "getPortfolioSettingsResult"
})
@XmlRootElement(name = "GetPortfolioSettingsResponse")
public class GetPortfolioSettingsResponse {

    @XmlElementRef(name = "GetPortfolioSettingsResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<CurrentPortfolioSettings> getPortfolioSettingsResult;

    /**
     * 获取getPortfolioSettingsResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CurrentPortfolioSettings }{@code >}
     *     
     */
    public JAXBElement<CurrentPortfolioSettings> getGetPortfolioSettingsResult() {
        return getPortfolioSettingsResult;
    }

    /**
     * 设置getPortfolioSettingsResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CurrentPortfolioSettings }{@code >}
     *     
     */
    public void setGetPortfolioSettingsResult(JAXBElement<CurrentPortfolioSettings> value) {
        this.getPortfolioSettingsResult = value;
    }

}
