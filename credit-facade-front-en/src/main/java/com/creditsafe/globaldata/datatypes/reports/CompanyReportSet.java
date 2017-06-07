
package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.ServiceResponse;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>CompanyReportSet complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CompanyReportSet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Reports" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Report" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyReport" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ChargeReference" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyReportSet", propOrder = {
    "reports"
})
public class CompanyReportSet
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "Reports")
    protected Reports reports;
    @XmlAttribute(name = "ChargeReference")
    protected String chargeReference;

    /**
     * 获取reports属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Reports }
     *     
     */
    public Reports getReports() {
        return reports;
    }

    /**
     * 设置reports属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Reports }
     *     
     */
    public void setReports(Reports value) {
        this.reports = value;
    }

    /**
     * 获取chargeReference属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeReference() {
        return chargeReference;
    }

    /**
     * 设置chargeReference属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeReference(String value) {
        this.chargeReference = value;
    }


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
     *         &lt;element name="Report" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyReport" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "report"
    })
    public static class Reports {

        @XmlElement(name = "Report")
        protected List<CompanyReport> report;

        /**
         * Gets the value of the report property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the report property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReport().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CompanyReport }
         * 
         * 
         */
        public List<CompanyReport> getReport() {
            if (report == null) {
                report = new ArrayList<CompanyReport>();
            }
            return this.report;
        }

    }

}
