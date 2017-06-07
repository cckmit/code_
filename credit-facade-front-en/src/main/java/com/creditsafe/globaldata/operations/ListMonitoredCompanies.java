
package com.creditsafe.globaldata.operations;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfunsignedInt;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="portfolioIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfunsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="changedOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="changedSince" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="firstPosition" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/&gt;
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
    "portfolioIds",
    "changedOnly",
    "changedSince",
    "firstPosition",
    "pageSize"
})
@XmlRootElement(name = "ListMonitoredCompanies")
public class ListMonitoredCompanies {

    @XmlElementRef(name = "portfolioIds", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfunsignedInt> portfolioIds;
    protected Boolean changedOnly;
    @XmlElementRef(name = "changedSince", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> changedSince;
    @XmlSchemaType(name = "unsignedInt")
    protected Long firstPosition;
    @XmlSchemaType(name = "unsignedInt")
    protected Long pageSize;

    /**
     * 获取portfolioIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}
     *     
     */
    public JAXBElement<ArrayOfunsignedInt> getPortfolioIds() {
        return portfolioIds;
    }

    /**
     * 设置portfolioIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}
     *     
     */
    public void setPortfolioIds(JAXBElement<ArrayOfunsignedInt> value) {
        this.portfolioIds = value;
    }

    /**
     * 获取changedOnly属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChangedOnly() {
        return changedOnly;
    }

    /**
     * 设置changedOnly属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChangedOnly(Boolean value) {
        this.changedOnly = value;
    }

    /**
     * 获取changedSince属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getChangedSince() {
        return changedSince;
    }

    /**
     * 设置changedSince属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChangedSince(JAXBElement<XMLGregorianCalendar> value) {
        this.changedSince = value;
    }

    /**
     * 获取firstPosition属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFirstPosition() {
        return firstPosition;
    }

    /**
     * 设置firstPosition属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFirstPosition(Long value) {
        this.firstPosition = value;
    }

    /**
     * 获取pageSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPageSize() {
        return pageSize;
    }

    /**
     * 设置pageSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPageSize(Long value) {
        this.pageSize = value;
    }

}
