
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>UserAccountAccessRights complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UserAccountAccessRights"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Browsing" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ACE" type="{http://www.creditsafe.com/globaldata/datatypes/administration}AccessControlEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="OnlineReports" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ACE" type="{http://www.creditsafe.com/globaldata/datatypes/administration}AccessControlEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="OfflineReports" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ACE" type="{http://www.creditsafe.com/globaldata/datatypes/administration}AccessControlEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Monitoring" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ACE" type="{http://www.creditsafe.com/globaldata/datatypes/administration}AccessControlEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "UserAccountAccessRights", propOrder = {
    "browsing",
    "onlineReports",
    "offlineReports",
    "monitoring"
})
public class UserAccountAccessRights implements Serializable {

    @XmlElement(name = "Browsing")
    protected Browsing browsing;
    @XmlElement(name = "OnlineReports")
    protected OnlineReports onlineReports;
    @XmlElement(name = "OfflineReports")
    protected OfflineReports offlineReports;
    @XmlElement(name = "Monitoring")
    protected Monitoring monitoring;

    /**
     * 获取browsing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Browsing }
     *     
     */
    public Browsing getBrowsing() {
        return browsing;
    }

    /**
     * 设置browsing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Browsing }
     *     
     */
    public void setBrowsing(Browsing value) {
        this.browsing = value;
    }

    /**
     * 获取onlineReports属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OnlineReports }
     *     
     */
    public OnlineReports getOnlineReports() {
        return onlineReports;
    }

    /**
     * 设置onlineReports属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OnlineReports }
     *     
     */
    public void setOnlineReports(OnlineReports value) {
        this.onlineReports = value;
    }

    /**
     * 获取offlineReports属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OfflineReports }
     *     
     */
    public OfflineReports getOfflineReports() {
        return offlineReports;
    }

    /**
     * 设置offlineReports属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OfflineReports }
     *     
     */
    public void setOfflineReports(OfflineReports value) {
        this.offlineReports = value;
    }

    /**
     * 获取monitoring属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Monitoring }
     *     
     */
    public Monitoring getMonitoring() {
        return monitoring;
    }

    /**
     * 设置monitoring属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Monitoring }
     *     
     */
    public void setMonitoring(Monitoring value) {
        this.monitoring = value;
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
     *         &lt;element name="ACE" type="{http://www.creditsafe.com/globaldata/datatypes/administration}AccessControlEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "ace"
    })
    public static class Browsing {

        @XmlElement(name = "ACE")
        protected List<AccessControlEntry> ace;

        /**
         * Gets the value of the ace property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ace property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getACE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AccessControlEntry }
         * 
         * 
         */
        public List<AccessControlEntry> getACE() {
            if (ace == null) {
                ace = new ArrayList<AccessControlEntry>();
            }
            return this.ace;
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
     *         &lt;element name="ACE" type="{http://www.creditsafe.com/globaldata/datatypes/administration}AccessControlEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "ace"
    })
    public static class Monitoring {

        @XmlElement(name = "ACE")
        protected List<AccessControlEntry> ace;

        /**
         * Gets the value of the ace property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ace property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getACE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AccessControlEntry }
         * 
         * 
         */
        public List<AccessControlEntry> getACE() {
            if (ace == null) {
                ace = new ArrayList<AccessControlEntry>();
            }
            return this.ace;
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
     *         &lt;element name="ACE" type="{http://www.creditsafe.com/globaldata/datatypes/administration}AccessControlEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "ace"
    })
    public static class OfflineReports {

        @XmlElement(name = "ACE")
        protected List<AccessControlEntry> ace;

        /**
         * Gets the value of the ace property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ace property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getACE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AccessControlEntry }
         * 
         * 
         */
        public List<AccessControlEntry> getACE() {
            if (ace == null) {
                ace = new ArrayList<AccessControlEntry>();
            }
            return this.ace;
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
     *         &lt;element name="ACE" type="{http://www.creditsafe.com/globaldata/datatypes/administration}AccessControlEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "ace"
    })
    public static class OnlineReports {

        @XmlElement(name = "ACE")
        protected List<AccessControlEntry> ace;

        /**
         * Gets the value of the ace property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ace property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getACE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AccessControlEntry }
         * 
         * 
         */
        public List<AccessControlEntry> getACE() {
            if (ace == null) {
                ace = new ArrayList<AccessControlEntry>();
            }
            return this.ace;
        }

    }

}
