
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.CountryCode;
import com.creditsafe.globaldata.datatypes.SearchCriteria;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ActivityLogBrowsingEntry complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ActivityLogBrowsingEntry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogEntry"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Countries"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Country" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SearchCriteria" type="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteria"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityLogBrowsingEntry", propOrder = {
    "countries",
    "searchCriteria"
})
public class ActivityLogBrowsingEntry
    extends ActivityLogEntry implements Serializable
{

    @XmlElement(name = "Countries", required = true)
    protected Countries countries;
    @XmlElement(name = "SearchCriteria", required = true)
    protected SearchCriteria searchCriteria;

    /**
     * 获取countries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Countries }
     *     
     */
    public Countries getCountries() {
        return countries;
    }

    /**
     * 设置countries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Countries }
     *     
     */
    public void setCountries(Countries value) {
        this.countries = value;
    }

    /**
     * 获取searchCriteria属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteria }
     *     
     */
    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * 设置searchCriteria属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteria }
     *     
     */
    public void setSearchCriteria(SearchCriteria value) {
        this.searchCriteria = value;
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
     *         &lt;element name="Country" type="{http://www.creditsafe.com/globaldata/datatypes}CountryCode" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "country"
    })
    public static class Countries {

        @XmlElement(name = "Country")
        @XmlSchemaType(name = "string")
        protected List<CountryCode> country;

        /**
         * Gets the value of the country property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the country property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCountry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CountryCode }
         * 
         * 
         */
        public List<CountryCode> getCountry() {
            if (country == null) {
                country = new ArrayList<CountryCode>();
            }
            return this.country;
        }

    }

}
