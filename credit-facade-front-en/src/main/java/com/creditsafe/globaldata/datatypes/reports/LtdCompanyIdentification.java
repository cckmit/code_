
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LtdCompanyIdentification complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdCompanyIdentification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BasicInformation" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdCompanyBasicInformation"/&gt;
 *         &lt;element name="Activities" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Activity" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyActivity" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PreviousNames" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PreviousName" type="{http://www.creditsafe.com/globaldata/datatypes/reports}PreviousName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PreviousLegalForms" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PreviousLegalForm" type="{http://www.creditsafe.com/globaldata/datatypes/reports}PreviousLegalForm" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "LtdCompanyIdentification", propOrder = {
    "basicInformation",
    "activities",
    "previousNames",
    "previousLegalForms"
})
public class LtdCompanyIdentification implements Serializable {

    @XmlElement(name = "BasicInformation", required = true)
    protected LtdCompanyBasicInformation basicInformation;
    @XmlElement(name = "Activities")
    protected Activities activities;
    @XmlElement(name = "PreviousNames")
    protected PreviousNames previousNames;
    @XmlElement(name = "PreviousLegalForms")
    protected PreviousLegalForms previousLegalForms;

    /**
     * 获取basicInformation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdCompanyBasicInformation }
     *     
     */
    public LtdCompanyBasicInformation getBasicInformation() {
        return basicInformation;
    }

    /**
     * 设置basicInformation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdCompanyBasicInformation }
     *     
     */
    public void setBasicInformation(LtdCompanyBasicInformation value) {
        this.basicInformation = value;
    }

    /**
     * 获取activities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Activities }
     *     
     */
    public Activities getActivities() {
        return activities;
    }

    /**
     * 设置activities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Activities }
     *     
     */
    public void setActivities(Activities value) {
        this.activities = value;
    }

    /**
     * 获取previousNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PreviousNames }
     *     
     */
    public PreviousNames getPreviousNames() {
        return previousNames;
    }

    /**
     * 设置previousNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousNames }
     *     
     */
    public void setPreviousNames(PreviousNames value) {
        this.previousNames = value;
    }

    /**
     * 获取previousLegalForms属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PreviousLegalForms }
     *     
     */
    public PreviousLegalForms getPreviousLegalForms() {
        return previousLegalForms;
    }

    /**
     * 设置previousLegalForms属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousLegalForms }
     *     
     */
    public void setPreviousLegalForms(PreviousLegalForms value) {
        this.previousLegalForms = value;
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
     *         &lt;element name="Activity" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyActivity" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "activity"
    })
    public static class Activities implements Serializable{

        @XmlElement(name = "Activity")
        protected List<CompanyActivity> activity;

        /**
         * Gets the value of the activity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the activity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getActivity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CompanyActivity }
         * 
         * 
         */
        public List<CompanyActivity> getActivity() {
            if (activity == null) {
                activity = new ArrayList<CompanyActivity>();
            }
            return this.activity;
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
     *         &lt;element name="PreviousLegalForm" type="{http://www.creditsafe.com/globaldata/datatypes/reports}PreviousLegalForm" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "previousLegalForm"
    })
    public static class PreviousLegalForms implements Serializable{

        @XmlElement(name = "PreviousLegalForm")
        protected List<PreviousLegalForm> previousLegalForm;

        /**
         * Gets the value of the previousLegalForm property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the previousLegalForm property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPreviousLegalForm().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PreviousLegalForm }
         * 
         * 
         */
        public List<PreviousLegalForm> getPreviousLegalForm() {
            if (previousLegalForm == null) {
                previousLegalForm = new ArrayList<PreviousLegalForm>();
            }
            return this.previousLegalForm;
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
     *         &lt;element name="PreviousName" type="{http://www.creditsafe.com/globaldata/datatypes/reports}PreviousName" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "previousName"
    })
    public static class PreviousNames implements Serializable{

        @XmlElement(name = "PreviousName")
        protected List<PreviousName> previousName;

        /**
         * Gets the value of the previousName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the previousName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPreviousName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PreviousName }
         * 
         * 
         */
        public List<PreviousName> getPreviousName() {
            if (previousName == null) {
                previousName = new ArrayList<PreviousName>();
            }
            return this.previousName;
        }

    }

}
