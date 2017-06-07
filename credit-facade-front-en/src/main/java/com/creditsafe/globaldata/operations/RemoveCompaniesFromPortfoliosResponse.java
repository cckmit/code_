
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.PortfolioCompanyRemovalResult;

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
 *         &lt;element name="RemoveCompaniesFromPortfoliosResult" type="{http://www.creditsafe.com/globaldata/datatypes}PortfolioCompanyRemovalResult" minOccurs="0"/&gt;
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
    "removeCompaniesFromPortfoliosResult"
})
@XmlRootElement(name = "RemoveCompaniesFromPortfoliosResponse")
public class RemoveCompaniesFromPortfoliosResponse {

    @XmlElementRef(name = "RemoveCompaniesFromPortfoliosResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<PortfolioCompanyRemovalResult> removeCompaniesFromPortfoliosResult;

    /**
     * 获取removeCompaniesFromPortfoliosResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PortfolioCompanyRemovalResult }{@code >}
     *     
     */
    public JAXBElement<PortfolioCompanyRemovalResult> getRemoveCompaniesFromPortfoliosResult() {
        return removeCompaniesFromPortfoliosResult;
    }

    /**
     * 设置removeCompaniesFromPortfoliosResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PortfolioCompanyRemovalResult }{@code >}
     *     
     */
    public void setRemoveCompaniesFromPortfoliosResult(JAXBElement<PortfolioCompanyRemovalResult> value) {
        this.removeCompaniesFromPortfoliosResult = value;
    }

}
