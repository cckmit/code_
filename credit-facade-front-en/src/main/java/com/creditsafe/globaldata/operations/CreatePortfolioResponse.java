
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.PortfoliosList;

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
 *         &lt;element name="CreatePortfolioResult" type="{http://www.creditsafe.com/globaldata/datatypes}PortfoliosList" minOccurs="0"/&gt;
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
    "createPortfolioResult"
})
@XmlRootElement(name = "CreatePortfolioResponse")
public class CreatePortfolioResponse {

    @XmlElementRef(name = "CreatePortfolioResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<PortfoliosList> createPortfolioResult;

    /**
     * 获取createPortfolioResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PortfoliosList }{@code >}
     *     
     */
    public JAXBElement<PortfoliosList> getCreatePortfolioResult() {
        return createPortfolioResult;
    }

    /**
     * 设置createPortfolioResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PortfoliosList }{@code >}
     *     
     */
    public void setCreatePortfolioResult(JAXBElement<PortfoliosList> value) {
        this.createPortfolioResult = value;
    }

}
