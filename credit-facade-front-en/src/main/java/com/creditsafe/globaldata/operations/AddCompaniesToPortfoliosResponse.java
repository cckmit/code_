
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.PortfolioCompanyAdditionResult;

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
 *         &lt;element name="AddCompaniesToPortfoliosResult" type="{http://www.creditsafe.com/globaldata/datatypes}PortfolioCompanyAdditionResult" minOccurs="0"/&gt;
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
    "addCompaniesToPortfoliosResult"
})
@XmlRootElement(name = "AddCompaniesToPortfoliosResponse")
public class AddCompaniesToPortfoliosResponse {

    @XmlElementRef(name = "AddCompaniesToPortfoliosResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<PortfolioCompanyAdditionResult> addCompaniesToPortfoliosResult;

    /**
     * 获取addCompaniesToPortfoliosResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PortfolioCompanyAdditionResult }{@code >}
     *     
     */
    public JAXBElement<PortfolioCompanyAdditionResult> getAddCompaniesToPortfoliosResult() {
        return addCompaniesToPortfoliosResult;
    }

    /**
     * 设置addCompaniesToPortfoliosResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PortfolioCompanyAdditionResult }{@code >}
     *     
     */
    public void setAddCompaniesToPortfoliosResult(JAXBElement<PortfolioCompanyAdditionResult> value) {
        this.addCompaniesToPortfoliosResult = value;
    }

}
