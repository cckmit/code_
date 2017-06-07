
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.reports.CompanyReportSet;

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
 *         &lt;element name="GetReportboxReportsResult" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyReportSet" minOccurs="0"/&gt;
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
    "getReportboxReportsResult"
})
@XmlRootElement(name = "GetReportboxReportsResponse")
public class GetReportboxReportsResponse {

    @XmlElementRef(name = "GetReportboxReportsResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<CompanyReportSet> getReportboxReportsResult;

    /**
     * 获取getReportboxReportsResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CompanyReportSet }{@code >}
     *     
     */
    public JAXBElement<CompanyReportSet> getGetReportboxReportsResult() {
        return getReportboxReportsResult;
    }

    /**
     * 设置getReportboxReportsResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CompanyReportSet }{@code >}
     *     
     */
    public void setGetReportboxReportsResult(JAXBElement<CompanyReportSet> value) {
        this.getReportboxReportsResult = value;
    }

}
