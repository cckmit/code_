
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
 *         &lt;element name="ImportCompaniesToPortfolioResult" type="{http://www.creditsafe.com/globaldata/datatypes}PortfolioCompanyAdditionResult" minOccurs="0"/&gt;
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
    "importCompaniesToPortfolioResult"
})
@XmlRootElement(name = "ImportCompaniesToPortfolioResponse")
public class ImportCompaniesToPortfolioResponse {

    @XmlElementRef(name = "ImportCompaniesToPortfolioResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<PortfolioCompanyAdditionResult> importCompaniesToPortfolioResult;

    /**
     * 获取importCompaniesToPortfolioResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PortfolioCompanyAdditionResult }{@code >}
     *     
     */
    public JAXBElement<PortfolioCompanyAdditionResult> getImportCompaniesToPortfolioResult() {
        return importCompaniesToPortfolioResult;
    }

    /**
     * 设置importCompaniesToPortfolioResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PortfolioCompanyAdditionResult }{@code >}
     *     
     */
    public void setImportCompaniesToPortfolioResult(JAXBElement<PortfolioCompanyAdditionResult> value) {
        this.importCompaniesToPortfolioResult = value;
    }

}
