
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.ServiceResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>DataSourcesReport complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DataSourcesReport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DataSources"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DataSource" type="{http://www.creditsafe.com/globaldata/datatypes/administration}DataSource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Priorities" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Priority" type="{http://www.creditsafe.com/globaldata/datatypes/administration}DataSourcePriorities" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "DataSourcesReport", propOrder = {
    "dataSources",
    "priorities"
})
public class DataSourcesReport
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "DataSources", required = true)
    protected DataSources dataSources;
    @XmlElement(name = "Priorities")
    protected Priorities priorities;

    /**
     * 获取dataSources属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DataSources }
     *     
     */
    public DataSources getDataSources() {
        return dataSources;
    }

    /**
     * 设置dataSources属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DataSources }
     *     
     */
    public void setDataSources(DataSources value) {
        this.dataSources = value;
    }

    /**
     * 获取priorities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Priorities }
     *     
     */
    public Priorities getPriorities() {
        return priorities;
    }

    /**
     * 设置priorities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Priorities }
     *     
     */
    public void setPriorities(Priorities value) {
        this.priorities = value;
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
     *         &lt;element name="DataSource" type="{http://www.creditsafe.com/globaldata/datatypes/administration}DataSource" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "dataSource"
    })
    public static class DataSources {

        @XmlElement(name = "DataSource")
        protected List<DataSource> dataSource;

        /**
         * Gets the value of the dataSource property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataSource property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataSource().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DataSource }
         * 
         * 
         */
        public List<DataSource> getDataSource() {
            if (dataSource == null) {
                dataSource = new ArrayList<DataSource>();
            }
            return this.dataSource;
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
     *         &lt;element name="Priority" type="{http://www.creditsafe.com/globaldata/datatypes/administration}DataSourcePriorities" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "priority"
    })
    public static class Priorities {

        @XmlElement(name = "Priority")
        protected List<DataSourcePriorities> priority;

        /**
         * Gets the value of the priority property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the priority property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPriority().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DataSourcePriorities }
         * 
         * 
         */
        public List<DataSourcePriorities> getPriority() {
            if (priority == null) {
                priority = new ArrayList<DataSourcePriorities>();
            }
            return this.priority;
        }

    }

}
