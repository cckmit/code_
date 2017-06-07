
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.CompaniesList;

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
 *         &lt;element name="FindCompaniesResult" type="{http://www.creditsafe.com/globaldata/datatypes}CompaniesList" minOccurs="0"/&gt;
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
    "findCompaniesResult"
})
@XmlRootElement(name = "FindCompaniesResponse")
public class FindCompaniesResponse {

    @XmlElementRef(name = "FindCompaniesResult", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<CompaniesList> findCompaniesResult;

    /**
     * 获取findCompaniesResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CompaniesList }{@code >}
     *     
     */
    public JAXBElement<CompaniesList> getFindCompaniesResult() {
        return findCompaniesResult;
    }

    /**
     * 设置findCompaniesResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CompaniesList }{@code >}
     *     
     */
    public void setFindCompaniesResult(JAXBElement<CompaniesList> value) {
        this.findCompaniesResult = value;
    }

}
