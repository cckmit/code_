
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.CountriesList;

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
 *         &lt;element name="GetCountriesResult" type="{http://www.creditsafe.com/globaldata/datatypes}CountriesList" minOccurs="0"/&gt;
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
    "getCountriesResult"
})
@XmlRootElement(name = "GetCountriesResponse")
public class GetCountriesResponse {

    @XmlElementRef(name = "GetCountriesResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<CountriesList> getCountriesResult;

    /**
     * 获取getCountriesResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CountriesList }{@code >}
     *     
     */
    public JAXBElement<CountriesList> getGetCountriesResult() {
        return getCountriesResult;
    }

    /**
     * 设置getCountriesResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CountriesList }{@code >}
     *     
     */
    public void setGetCountriesResult(JAXBElement<CountriesList> value) {
        this.getCountriesResult = value;
    }

}
