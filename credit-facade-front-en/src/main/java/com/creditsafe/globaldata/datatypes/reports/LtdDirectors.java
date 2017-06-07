
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LtdDirectors complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdDirectors"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CurrentDirectors" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Director" type="{http://www.creditsafe.com/globaldata/datatypes/reports}Director" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PreviousDirectors" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Director" type="{http://www.creditsafe.com/globaldata/datatypes/reports}PreviousDirector" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "LtdDirectors", propOrder = {
    "currentDirectors",
    "previousDirectors"
})
public class LtdDirectors implements Serializable {

    @XmlElement(name = "CurrentDirectors")
    protected CurrentDirectors currentDirectors;
    @XmlElement(name = "PreviousDirectors")
    protected PreviousDirectors previousDirectors;

    /**
     * 获取currentDirectors属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CurrentDirectors }
     *     
     */
    public CurrentDirectors getCurrentDirectors() {
        return currentDirectors;
    }

    /**
     * 设置currentDirectors属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentDirectors }
     *     
     */
    public void setCurrentDirectors(CurrentDirectors value) {
        this.currentDirectors = value;
    }

    /**
     * 获取previousDirectors属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PreviousDirectors }
     *     
     */
    public PreviousDirectors getPreviousDirectors() {
        return previousDirectors;
    }

    /**
     * 设置previousDirectors属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousDirectors }
     *     
     */
    public void setPreviousDirectors(PreviousDirectors value) {
        this.previousDirectors = value;
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
     *         &lt;element name="Director" type="{http://www.creditsafe.com/globaldata/datatypes/reports}Director" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "director"
    })
    public static class CurrentDirectors implements Serializable{

        @XmlElement(name = "Director")
        protected List<Director> director;

        /**
         * Gets the value of the director property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the director property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDirector().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Director }
         * 
         * 
         */
        public List<Director> getDirector() {
            if (director == null) {
                director = new ArrayList<Director>();
            }
            return this.director;
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
     *         &lt;element name="Director" type="{http://www.creditsafe.com/globaldata/datatypes/reports}PreviousDirector" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "director"
    })
    public static class PreviousDirectors implements Serializable{

        @XmlElement(name = "Director")
        protected List<PreviousDirector> director;

        /**
         * Gets the value of the director property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the director property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDirector().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PreviousDirector }
         * 
         * 
         */
        public List<PreviousDirector> getDirector() {
            if (director == null) {
                director = new ArrayList<PreviousDirector>();
            }
            return this.director;
        }

    }

}
