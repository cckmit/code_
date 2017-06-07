
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>MonitoredCompaniesList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MonitoredCompaniesList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Portfolios" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Portfolio" type="{http://www.creditsafe.com/globaldata/datatypes}PortfolioCompanies" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Results" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="FirstPosition" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="TotalResults" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="PageSize" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonitoredCompaniesList", propOrder = {
    "portfolios"
})
public class MonitoredCompaniesList
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "Portfolios")
    protected Portfolios portfolios;
    @XmlAttribute(name = "Results", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long results;
    @XmlAttribute(name = "FirstPosition", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long firstPosition;
    @XmlAttribute(name = "TotalResults", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long totalResults;
    @XmlAttribute(name = "PageSize", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long pageSize;

    /**
     * 获取portfolios属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Portfolios }
     *     
     */
    public Portfolios getPortfolios() {
        return portfolios;
    }

    /**
     * 设置portfolios属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Portfolios }
     *     
     */
    public void setPortfolios(Portfolios value) {
        this.portfolios = value;
    }

    /**
     * 获取results属性的值。
     * 
     */
    public long getResults() {
        return results;
    }

    /**
     * 设置results属性的值。
     * 
     */
    public void setResults(long value) {
        this.results = value;
    }

    /**
     * 获取firstPosition属性的值。
     * 
     */
    public long getFirstPosition() {
        return firstPosition;
    }

    /**
     * 设置firstPosition属性的值。
     * 
     */
    public void setFirstPosition(long value) {
        this.firstPosition = value;
    }

    /**
     * 获取totalResults属性的值。
     * 
     */
    public long getTotalResults() {
        return totalResults;
    }

    /**
     * 设置totalResults属性的值。
     * 
     */
    public void setTotalResults(long value) {
        this.totalResults = value;
    }

    /**
     * 获取pageSize属性的值。
     * 
     */
    public long getPageSize() {
        return pageSize;
    }

    /**
     * 设置pageSize属性的值。
     * 
     */
    public void setPageSize(long value) {
        this.pageSize = value;
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
     *         &lt;element name="Portfolio" type="{http://www.creditsafe.com/globaldata/datatypes}PortfolioCompanies" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "portfolio"
    })
    public static class Portfolios {

        @XmlElement(name = "Portfolio")
        protected List<PortfolioCompanies> portfolio;

        /**
         * Gets the value of the portfolio property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the portfolio property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPortfolio().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PortfolioCompanies }
         * 
         * 
         */
        public List<PortfolioCompanies> getPortfolio() {
            if (portfolio == null) {
                portfolio = new ArrayList<PortfolioCompanies>();
            }
            return this.portfolio;
        }

    }

}
