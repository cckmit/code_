
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ActivityLogMonitoringEntry complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ActivityLogMonitoringEntry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogEntry"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PortfolioName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Addition" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Companies" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityLogMonitoringEntry", propOrder = {
    "portfolioName",
    "addition",
    "companies"
})
public class ActivityLogMonitoringEntry
    extends ActivityLogEntry implements Serializable
{

    @XmlElement(name = "PortfolioName", required = true)
    protected String portfolioName;
    @XmlElement(name = "Addition")
    protected boolean addition;
    @XmlElement(name = "Companies")
    protected Companies companies;

    /**
     * 获取portfolioName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortfolioName() {
        return portfolioName;
    }

    /**
     * 设置portfolioName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortfolioName(String value) {
        this.portfolioName = value;
    }

    /**
     * 获取addition属性的值。
     * 
     */
    public boolean isAddition() {
        return addition;
    }

    /**
     * 设置addition属性的值。
     * 
     */
    public void setAddition(boolean value) {
        this.addition = value;
    }

    /**
     * 获取companies属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Companies }
     *     
     */
    public Companies getCompanies() {
        return companies;
    }

    /**
     * 设置companies属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Companies }
     *     
     */
    public void setCompanies(Companies value) {
        this.companies = value;
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
     *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "company"
    })
    public static class Companies {

        @XmlElement(name = "Company")
        protected List<String> company;

        /**
         * Gets the value of the company property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the company property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCompany().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCompany() {
            if (company == null) {
                company = new ArrayList<String>();
            }
            return this.company;
        }

    }

}
