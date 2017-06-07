
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.ServiceResponse;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>SystemStatusSummary complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SystemStatusSummary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Overview" type="{http://www.creditsafe.com/globaldata/datatypes/administration}StatusOverview" minOccurs="0"/&gt;
 *         &lt;element name="Subsystems" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Subsystem" type="{http://www.creditsafe.com/globaldata/datatypes/administration}SystemStatusSummary.SubsystemReport" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "SystemStatusSummary", propOrder = {
    "overview",
    "subsystems"
})
@XmlSeeAlso({
    SystemStatusSummarySubsystemReport.class
})
public class SystemStatusSummary
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "Overview")
    protected StatusOverview overview;
    @XmlElement(name = "Subsystems")
    protected Subsystems subsystems;

    /**
     * 获取overview属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StatusOverview }
     *     
     */
    public StatusOverview getOverview() {
        return overview;
    }

    /**
     * 设置overview属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StatusOverview }
     *     
     */
    public void setOverview(StatusOverview value) {
        this.overview = value;
    }

    /**
     * 获取subsystems属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Subsystems }
     *     
     */
    public Subsystems getSubsystems() {
        return subsystems;
    }

    /**
     * 设置subsystems属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Subsystems }
     *     
     */
    public void setSubsystems(Subsystems value) {
        this.subsystems = value;
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
     *         &lt;element name="Subsystem" type="{http://www.creditsafe.com/globaldata/datatypes/administration}SystemStatusSummary.SubsystemReport" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "subsystem"
    })
    public static class Subsystems {

        @XmlElement(name = "Subsystem")
        protected List<SystemStatusSummarySubsystemReport> subsystem;

        /**
         * Gets the value of the subsystem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the subsystem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSubsystem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SystemStatusSummarySubsystemReport }
         * 
         * 
         */
        public List<SystemStatusSummarySubsystemReport> getSubsystem() {
            if (subsystem == null) {
                subsystem = new ArrayList<SystemStatusSummarySubsystemReport>();
            }
            return this.subsystem;
        }

    }

}
