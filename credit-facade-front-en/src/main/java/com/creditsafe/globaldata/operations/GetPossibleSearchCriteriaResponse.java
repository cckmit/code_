
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.SearchCriteriaSchemaSet;

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
 *         &lt;element name="GetPossibleSearchCriteriaResult" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchemaSet" minOccurs="0"/&gt;
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
    "getPossibleSearchCriteriaResult"
})
@XmlRootElement(name = "GetPossibleSearchCriteriaResponse")
public class GetPossibleSearchCriteriaResponse {

    @XmlElementRef(name = "GetPossibleSearchCriteriaResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<SearchCriteriaSchemaSet> getPossibleSearchCriteriaResult;

    /**
     * 获取getPossibleSearchCriteriaResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SearchCriteriaSchemaSet }{@code >}
     *     
     */
    public JAXBElement<SearchCriteriaSchemaSet> getGetPossibleSearchCriteriaResult() {
        return getPossibleSearchCriteriaResult;
    }

    /**
     * 设置getPossibleSearchCriteriaResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SearchCriteriaSchemaSet }{@code >}
     *     
     */
    public void setGetPossibleSearchCriteriaResult(JAXBElement<SearchCriteriaSchemaSet> value) {
        this.getPossibleSearchCriteriaResult = value;
    }

}
