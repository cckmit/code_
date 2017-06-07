
package com.creditsafe.globaldata.datatypes.reports;

import com.creditsafe.globaldata.datatypes.CompanyData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LtdGroupStructure complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdGroupStructure"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UltimateParent" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyData" minOccurs="0"/&gt;
 *         &lt;element name="ImmediateParent" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyData" minOccurs="0"/&gt;
 *         &lt;element name="SubsidiaryCompanies" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Subsidiary" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AffiliatedCompanies" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AffiliatedCompany" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LtdGroupStructure", propOrder = {
    "ultimateParent",
    "immediateParent",
    "subsidiaryCompanies",
    "affiliatedCompanies"
})
public class LtdGroupStructure implements Serializable {

    @XmlElement(name = "UltimateParent")
    protected CompanyData ultimateParent;
    @XmlElement(name = "ImmediateParent")
    protected CompanyData immediateParent;
    @XmlElement(name = "SubsidiaryCompanies")
    protected SubsidiaryCompanies subsidiaryCompanies;
    @XmlElement(name = "AffiliatedCompanies")
    protected AffiliatedCompanies affiliatedCompanies;

    /**
     * 获取ultimateParent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CompanyData }
     *     
     */
    public CompanyData getUltimateParent() {
        return ultimateParent;
    }

    /**
     * 设置ultimateParent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyData }
     *     
     */
    public void setUltimateParent(CompanyData value) {
        this.ultimateParent = value;
    }

    /**
     * 获取immediateParent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CompanyData }
     *     
     */
    public CompanyData getImmediateParent() {
        return immediateParent;
    }

    /**
     * 设置immediateParent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyData }
     *     
     */
    public void setImmediateParent(CompanyData value) {
        this.immediateParent = value;
    }

    /**
     * 获取subsidiaryCompanies属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SubsidiaryCompanies }
     *     
     */
    public SubsidiaryCompanies getSubsidiaryCompanies() {
        return subsidiaryCompanies;
    }

    /**
     * 设置subsidiaryCompanies属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SubsidiaryCompanies }
     *     
     */
    public void setSubsidiaryCompanies(SubsidiaryCompanies value) {
        this.subsidiaryCompanies = value;
    }

    /**
     * 获取affiliatedCompanies属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AffiliatedCompanies }
     *     
     */
    public AffiliatedCompanies getAffiliatedCompanies() {
        return affiliatedCompanies;
    }

    /**
     * 设置affiliatedCompanies属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AffiliatedCompanies }
     *     
     */
    public void setAffiliatedCompanies(AffiliatedCompanies value) {
        this.affiliatedCompanies = value;
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
     *         &lt;element name="AffiliatedCompany" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyData" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "affiliatedCompany"
    })
    public static class AffiliatedCompanies implements Serializable{

        @XmlElement(name = "AffiliatedCompany")
        protected List<CompanyData> affiliatedCompany;

        /**
         * Gets the value of the affiliatedCompany property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the affiliatedCompany property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAffiliatedCompany().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CompanyData }
         * 
         * 
         */
        public List<CompanyData> getAffiliatedCompany() {
            if (affiliatedCompany == null) {
                affiliatedCompany = new ArrayList<CompanyData>();
            }
            return this.affiliatedCompany;
        }

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
     *         &lt;element name="Subsidiary" type="{http://www.creditsafe.com/globaldata/datatypes}CompanyData" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "subsidiary"
    })
    public static class SubsidiaryCompanies implements Serializable{

        @XmlElement(name = "Subsidiary")
        protected List<CompanyData> subsidiary;

        /**
         * Gets the value of the subsidiary property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the subsidiary property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSubsidiary().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CompanyData }
         * 
         * 
         */
        public List<CompanyData> getSubsidiary() {
            if (subsidiary == null) {
                subsidiary = new ArrayList<CompanyData>();
            }
            return this.subsidiary;
        }

    }

}
