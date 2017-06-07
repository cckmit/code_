
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>CompanyChangesList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CompanyChangesList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Companies" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Company" type="{http://www.creditsafe.com/globaldata/datatypes}MonitoredCompany" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="MoreResults" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="NextIterationToken" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyChangesList", propOrder = {
    "companies"
})
public class CompanyChangesList
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "Companies")
    protected Companies companies;
    @XmlAttribute(name = "MoreResults", required = true)
    protected boolean moreResults;
    @XmlAttribute(name = "NextIterationToken")
    protected String nextIterationToken;

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
     * 获取moreResults属性的值。
     * 
     */
    public boolean isMoreResults() {
        return moreResults;
    }

    /**
     * 设置moreResults属性的值。
     * 
     */
    public void setMoreResults(boolean value) {
        this.moreResults = value;
    }

    /**
     * 获取nextIterationToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextIterationToken() {
        return nextIterationToken;
    }

    /**
     * 设置nextIterationToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextIterationToken(String value) {
        this.nextIterationToken = value;
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
     *         &lt;element name="Company" type="{http://www.creditsafe.com/globaldata/datatypes}MonitoredCompany" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        protected List<MonitoredCompany> company;

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
         * {@link MonitoredCompany }
         * 
         * 
         */
        public List<MonitoredCompany> getCompany() {
            if (company == null) {
                company = new ArrayList<MonitoredCompany>();
            }
            return this.company;
        }

    }

}
