
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.ServiceResponse;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>UserAccountActivityLog complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UserAccountActivityLog"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Browsing" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="LogEntry" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogBrowsingEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *                   &lt;element name="LogEntry" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogReportEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *                   &lt;element name="LogEntry" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogReportEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *                   &lt;element name="LogEntry" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogMonitoringEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccountActivityLog", propOrder = {
    "browsing",
    "onlineReports",
    "offlineReports",
    "monitoring"
})
public class UserAccountActivityLog
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "Browsing")
    protected Browsing browsing;
    @XmlElement(name = "OnlineReports")
    protected OnlineReports onlineReports;
    @XmlElement(name = "OfflineReports")
    protected OfflineReports offlineReports;
    @XmlElement(name = "Monitoring")
    protected Monitoring monitoring;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long id;

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
     * 获取id属性的值。
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     */
    public void setId(long value) {
        this.id = value;
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
     *         &lt;element name="LogEntry" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogBrowsingEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "logEntry"
    })
    public static class Browsing {

        @XmlElement(name = "LogEntry")
        protected List<ActivityLogBrowsingEntry> logEntry;

        /**
         * Gets the value of the logEntry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the logEntry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLogEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ActivityLogBrowsingEntry }
         * 
         * 
         */
        public List<ActivityLogBrowsingEntry> getLogEntry() {
            if (logEntry == null) {
                logEntry = new ArrayList<ActivityLogBrowsingEntry>();
            }
            return this.logEntry;
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
     *         &lt;element name="LogEntry" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogMonitoringEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "logEntry"
    })
    public static class Monitoring {

        @XmlElement(name = "LogEntry")
        protected List<ActivityLogMonitoringEntry> logEntry;

        /**
         * Gets the value of the logEntry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the logEntry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLogEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ActivityLogMonitoringEntry }
         * 
         * 
         */
        public List<ActivityLogMonitoringEntry> getLogEntry() {
            if (logEntry == null) {
                logEntry = new ArrayList<ActivityLogMonitoringEntry>();
            }
            return this.logEntry;
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
     *         &lt;element name="LogEntry" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogReportEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "logEntry"
    })
    public static class OfflineReports {

        @XmlElement(name = "LogEntry")
        protected List<ActivityLogReportEntry> logEntry;

        /**
         * Gets the value of the logEntry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the logEntry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLogEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ActivityLogReportEntry }
         * 
         * 
         */
        public List<ActivityLogReportEntry> getLogEntry() {
            if (logEntry == null) {
                logEntry = new ArrayList<ActivityLogReportEntry>();
            }
            return this.logEntry;
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
     *         &lt;element name="LogEntry" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ActivityLogReportEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "logEntry"
    })
    public static class OnlineReports {

        @XmlElement(name = "LogEntry")
        protected List<ActivityLogReportEntry> logEntry;

        /**
         * Gets the value of the logEntry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the logEntry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLogEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ActivityLogReportEntry }
         * 
         * 
         */
        public List<ActivityLogReportEntry> getLogEntry() {
            if (logEntry == null) {
                logEntry = new ArrayList<ActivityLogReportEntry>();
            }
            return this.logEntry;
        }

    }

}
