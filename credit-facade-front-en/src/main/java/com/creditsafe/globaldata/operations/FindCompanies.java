
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.CustomData;
import com.creditsafe.globaldata.datatypes.SearchCriteria;
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
 *         &lt;element name="searchCriteria" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteria" minOccurs="0"/&gt;
 *         &lt;element name="customData" type="{http://www.creditsafe.com/globaldata/datatypes}CustomData" minOccurs="0"/&gt;
 *         &lt;element name="chargeReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "countries",
    "searchCriteria",
    "customData",
    "chargeReference"
})
@XmlRootElement(name = "FindCompanies")
public class FindCompanies {

    @XmlElementRef(name = "countries", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCountryCode> countries;
    @XmlElementRef(name = "searchCriteria", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<SearchCriteria> searchCriteria;
    @XmlElementRef(name = "customData", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<CustomData> customData;
    @XmlElementRef(name = "chargeReference", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<String> chargeReference;

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

    /**
     * 获取searchCriteria属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SearchCriteria }{@code >}
     *     
     */
    public JAXBElement<SearchCriteria> getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * 设置searchCriteria属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SearchCriteria }{@code >}
     *     
     */
    public void setSearchCriteria(JAXBElement<SearchCriteria> value) {
        this.searchCriteria = value;
    }

    /**
     * 获取customData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CustomData }{@code >}
     *     
     */
    public JAXBElement<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 设置customData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CustomData }{@code >}
     *     
     */
    public void setCustomData(JAXBElement<CustomData> value) {
        this.customData = value;
    }

    /**
     * 获取chargeReference属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChargeReference() {
        return chargeReference;
    }

    /**
     * 设置chargeReference属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChargeReference(JAXBElement<String> value) {
        this.chargeReference = value;
    }

}
