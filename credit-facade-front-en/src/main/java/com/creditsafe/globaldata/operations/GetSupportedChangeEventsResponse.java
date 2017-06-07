
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.SupportedChangeEventsList;

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
 *         &lt;element name="GetSupportedChangeEventsResult" type="{http://www.creditsafe.com/globaldata/datatypes}SupportedChangeEventsList" minOccurs="0"/&gt;
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
    "getSupportedChangeEventsResult"
})
@XmlRootElement(name = "GetSupportedChangeEventsResponse")
public class GetSupportedChangeEventsResponse {

    @XmlElementRef(name = "GetSupportedChangeEventsResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<SupportedChangeEventsList> getSupportedChangeEventsResult;

    /**
     * 获取getSupportedChangeEventsResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SupportedChangeEventsList }{@code >}
     *     
     */
    public JAXBElement<SupportedChangeEventsList> getGetSupportedChangeEventsResult() {
        return getSupportedChangeEventsResult;
    }

    /**
     * 设置getSupportedChangeEventsResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SupportedChangeEventsList }{@code >}
     *     
     */
    public void setGetSupportedChangeEventsResult(JAXBElement<SupportedChangeEventsList> value) {
        this.getSupportedChangeEventsResult = value;
    }

}
