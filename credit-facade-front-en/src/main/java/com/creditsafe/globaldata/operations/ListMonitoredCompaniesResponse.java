
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.MonitoredCompaniesList;

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
 *         &lt;element name="ListMonitoredCompaniesResult" type="{http://www.creditsafe.com/globaldata/datatypes}MonitoredCompaniesList" minOccurs="0"/&gt;
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
    "listMonitoredCompaniesResult"
})
@XmlRootElement(name = "ListMonitoredCompaniesResponse")
public class ListMonitoredCompaniesResponse {

    @XmlElementRef(name = "ListMonitoredCompaniesResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<MonitoredCompaniesList> listMonitoredCompaniesResult;

    /**
     * 获取listMonitoredCompaniesResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MonitoredCompaniesList }{@code >}
     *     
     */
    public JAXBElement<MonitoredCompaniesList> getListMonitoredCompaniesResult() {
        return listMonitoredCompaniesResult;
    }

    /**
     * 设置listMonitoredCompaniesResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MonitoredCompaniesList }{@code >}
     *     
     */
    public void setListMonitoredCompaniesResult(JAXBElement<MonitoredCompaniesList> value) {
        this.listMonitoredCompaniesResult = value;
    }

}
