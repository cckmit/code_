
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LtdOtherInformation complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdOtherInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Bankers" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Banker" type="{http://www.creditsafe.com/globaldata/datatypes/reports}Banker" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Advisors" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Advisor" type="{http://www.creditsafe.com/globaldata/datatypes/reports}Advisor" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="EmployeesInformation" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="EmployeeInformation" type="{http://www.creditsafe.com/globaldata/datatypes/reports}EmployeeInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "LtdOtherInformation", propOrder = {
    "bankers",
    "advisors",
    "employeesInformation"
})
public class LtdOtherInformation implements Serializable {

    @XmlElement(name = "Bankers")
    protected Bankers bankers;
    @XmlElement(name = "Advisors")
    protected Advisors advisors;
    @XmlElement(name = "EmployeesInformation")
    protected EmployeesInformation employeesInformation;

    /**
     * 获取bankers属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Bankers }
     *     
     */
    public Bankers getBankers() {
        return bankers;
    }

    /**
     * 设置bankers属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Bankers }
     *     
     */
    public void setBankers(Bankers value) {
        this.bankers = value;
    }

    /**
     * 获取advisors属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Advisors }
     *     
     */
    public Advisors getAdvisors() {
        return advisors;
    }

    /**
     * 设置advisors属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Advisors }
     *     
     */
    public void setAdvisors(Advisors value) {
        this.advisors = value;
    }

    /**
     * 获取employeesInformation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EmployeesInformation }
     *     
     */
    public EmployeesInformation getEmployeesInformation() {
        return employeesInformation;
    }

    /**
     * 设置employeesInformation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeesInformation }
     *     
     */
    public void setEmployeesInformation(EmployeesInformation value) {
        this.employeesInformation = value;
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
     *         &lt;element name="Advisor" type="{http://www.creditsafe.com/globaldata/datatypes/reports}Advisor" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "advisor"
    })
    public static class Advisors implements Serializable{

        @XmlElement(name = "Advisor")
        protected List<Advisor> advisor;

        /**
         * Gets the value of the advisor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the advisor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdvisor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Advisor }
         * 
         * 
         */
        public List<Advisor> getAdvisor() {
            if (advisor == null) {
                advisor = new ArrayList<Advisor>();
            }
            return this.advisor;
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
     *         &lt;element name="Banker" type="{http://www.creditsafe.com/globaldata/datatypes/reports}Banker" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "banker"
    })
    public static class Bankers implements Serializable{

        @XmlElement(name = "Banker")
        protected List<Banker> banker;

        /**
         * Gets the value of the banker property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the banker property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBanker().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Banker }
         * 
         * 
         */
        public List<Banker> getBanker() {
            if (banker == null) {
                banker = new ArrayList<Banker>();
            }
            return this.banker;
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
     *         &lt;element name="EmployeeInformation" type="{http://www.creditsafe.com/globaldata/datatypes/reports}EmployeeInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "employeeInformation"
    })
    public static class EmployeesInformation implements Serializable{

        @XmlElement(name = "EmployeeInformation")
        protected List<EmployeeInformation> employeeInformation;

        /**
         * Gets the value of the employeeInformation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the employeeInformation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEmployeeInformation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EmployeeInformation }
         * 
         * 
         */
        public List<EmployeeInformation> getEmployeeInformation() {
            if (employeeInformation == null) {
                employeeInformation = new ArrayList<EmployeeInformation>();
            }
            return this.employeeInformation;
        }

    }

}
