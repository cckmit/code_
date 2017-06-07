
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.CompanyReportType;
import com.creditsafe.globaldata.datatypes.CustomData;
import com.creditsafe.globaldata.datatypes.Language;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfunsignedInt;

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
 *         &lt;element name="companyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reportType" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyReportType" minOccurs="0"/&gt;
 *         &lt;element name="language" type="{http://www.creditsafe.com/globaldata/datatypes}Language" minOccurs="0"/&gt;
 *         &lt;element name="customData" type="{http://www.creditsafe.com/globaldata/datatypes}CustomData" minOccurs="0"/&gt;
 *         &lt;element name="chargeReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="storeInReportbox" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="portfolioIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfunsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="monitoringReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "companyId",
    "reportType",
    "language",
    "customData",
    "chargeReference",
    "storeInReportbox",
    "portfolioIds",
    "monitoringReference"
})
@XmlRootElement(name = "RetrieveCompanyOnlineReport")
public class RetrieveCompanyOnlineReport {

    @XmlElementRef(name = "companyId", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<String> companyId;
    @XmlSchemaType(name = "string")
    protected CompanyReportType reportType;
    @XmlSchemaType(name = "string")
    protected Language language;
    @XmlElementRef(name = "customData", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<CustomData> customData;
    @XmlElementRef(name = "chargeReference", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<String> chargeReference;
    protected Boolean storeInReportbox;
    @XmlElementRef(name = "portfolioIds", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfunsignedInt> portfolioIds;
    @XmlElementRef(name = "monitoringReference", namespace = "http://www.creditsafe.com/globaldata/operations", type = JAXBElement.class, required = false)
    protected JAXBElement<String> monitoringReference;

    /**
     * 获取companyId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyId() {
        return companyId;
    }

    /**
     * 设置companyId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyId(JAXBElement<String> value) {
        this.companyId = value;
    }

    /**
     * 获取reportType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CompanyReportType }
     *     
     */
    public CompanyReportType getReportType() {
        return reportType;
    }

    /**
     * 设置reportType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyReportType }
     *     
     */
    public void setReportType(CompanyReportType value) {
        this.reportType = value;
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

    /**
     * 获取storeInReportbox属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStoreInReportbox() {
        return storeInReportbox;
    }

    /**
     * 设置storeInReportbox属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStoreInReportbox(Boolean value) {
        this.storeInReportbox = value;
    }

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
     * 获取monitoringReference属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMonitoringReference() {
        return monitoringReference;
    }

    /**
     * 设置monitoringReference属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMonitoringReference(JAXBElement<String> value) {
        this.monitoringReference = value;
    }

}
