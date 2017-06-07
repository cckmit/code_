
package com.creditsafe.globaldata.operations;

import org.datacontract.schemas._2004._07.creditsafe.ArrayOfCountryCode;

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
 *         &lt;element name="countries" type="{http://schemas.datacontract.org/2004/07/Creditsafe.GlobalData}ArrayOfCountryCode" minOccurs="0"/&gt;
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
    "countries"
})
@XmlRootElement(name = "GetPossibleSearchCriteria")
public class GetPossibleSearchCriteria {

    @XmlElementRef(name = "countries", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCountryCode> countries;

    /**
     * 获取countries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCountryCode }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCountryCode> getCountries() {
        return countries;
    }

    /**
     * 设置countries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCountryCode }{@code >}
     *     
     */
    public void setCountries(JAXBElement<ArrayOfCountryCode> value) {
        this.countries = value;
    }

}
