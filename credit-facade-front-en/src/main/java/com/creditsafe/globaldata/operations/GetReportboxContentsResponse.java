
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.ReportboxContents;

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
 *         &lt;element name="GetReportboxContentsResult" type="{http://www.creditsafe.com/globaldata/datatypes}ReportboxContents" minOccurs="0"/&gt;
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
    "getReportboxContentsResult"
})
@XmlRootElement(name = "GetReportboxContentsResponse")
public class GetReportboxContentsResponse {

    @XmlElementRef(name = "GetReportboxContentsResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<ReportboxContents> getReportboxContentsResult;

    /**
     * 获取getReportboxContentsResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReportboxContents }{@code >}
     *     
     */
    public JAXBElement<ReportboxContents> getGetReportboxContentsResult() {
        return getReportboxContentsResult;
    }

    /**
     * 设置getReportboxContentsResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReportboxContents }{@code >}
     *     
     */
    public void setGetReportboxContentsResult(JAXBElement<ReportboxContents> value) {
        this.getReportboxContentsResult = value;
    }

}
