
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.SimpleResult;

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
 *         &lt;element name="SetMonitoringRulesResult" type="{http://www.creditsafe.com/globaldata/datatypes}SimpleResult" minOccurs="0"/&gt;
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
    "setMonitoringRulesResult"
})
@XmlRootElement(name = "SetMonitoringRulesResponse")
public class SetMonitoringRulesResponse {

    @XmlElementRef(name = "SetMonitoringRulesResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<SimpleResult> setMonitoringRulesResult;

    /**
     * 获取setMonitoringRulesResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}
     *     
     */
    public JAXBElement<SimpleResult> getSetMonitoringRulesResult() {
        return setMonitoringRulesResult;
    }

    /**
     * 设置setMonitoringRulesResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}
     *     
     */
    public void setSetMonitoringRulesResult(JAXBElement<SimpleResult> value) {
        this.setMonitoringRulesResult = value;
    }

}