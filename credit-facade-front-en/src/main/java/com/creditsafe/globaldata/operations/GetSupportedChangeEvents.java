
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.CountryCode;
import com.creditsafe.globaldata.datatypes.Language;

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
 *         &lt;element name="country" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode" minOccurs="0"/&gt;
 *         &lt;element name="language" type="{http://www.creditsafe.com/globaldata/datatypes}Language" minOccurs="0"/&gt;
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
    "country",
    "language"
})
@XmlRootElement(name = "GetSupportedChangeEvents")
public class GetSupportedChangeEvents {

    @XmlElementRef(name = "country", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<CountryCode> country;
    @XmlSchemaType(name = "string")
    protected Language language;

    /**
     * 获取country属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CountryCode }{@code >}
     *     
     */
    public JAXBElement<CountryCode> getCountry() {
        return country;
    }

    /**
     * 设置country属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CountryCode }{@code >}
     *     
     */
    public void setCountry(JAXBElement<CountryCode> value) {
        this.country = value;
    }

    /**
     * 获取language属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Language }
     *     
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * 设置language属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Language }
     *     
     */
    public void setLanguage(Language value) {
        this.language = value;
    }

}
