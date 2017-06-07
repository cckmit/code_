
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LtdContactInformation complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdContactInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MainAddress" type="{http://www.creditsafe.com/globaldata/datatypes/reports}StreetAddressWithTelephone"/&gt;
 *         &lt;element name="OtherAddresses" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="OtherAddress" type="{http://www.creditsafe.com/globaldata/datatypes/reports}StreetAddressWithTelephone" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PreviousAddresses" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PreviousAddress" type="{http://www.creditsafe.com/globaldata/datatypes/reports}StreetAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="EmailAddresses" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Websites" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Website" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "LtdContactInformation", propOrder = {
    "mainAddress",
    "otherAddresses",
    "previousAddresses",
    "emailAddresses",
    "websites"
})
public class LtdContactInformation implements Serializable {

    @XmlElement(name = "MainAddress", required = true)
    protected StreetAddressWithTelephone mainAddress;
    @XmlElement(name = "OtherAddresses")
    protected OtherAddresses otherAddresses;
    @XmlElement(name = "PreviousAddresses")
    protected PreviousAddresses previousAddresses;
    @XmlElement(name = "EmailAddresses")
    protected EmailAddresses emailAddresses;
    @XmlElement(name = "Websites")
    protected Websites websites;

    /**
     * 获取mainAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StreetAddressWithTelephone }
     *     
     */
    public StreetAddressWithTelephone getMainAddress() {
        return mainAddress;
    }

    /**
     * 设置mainAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StreetAddressWithTelephone }
     *     
     */
    public void setMainAddress(StreetAddressWithTelephone value) {
        this.mainAddress = value;
    }

    /**
     * 获取otherAddresses属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OtherAddresses }
     *     
     */
    public OtherAddresses getOtherAddresses() {
        return otherAddresses;
    }

    /**
     * 设置otherAddresses属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OtherAddresses }
     *     
     */
    public void setOtherAddresses(OtherAddresses value) {
        this.otherAddresses = value;
    }

    /**
     * 获取previousAddresses属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PreviousAddresses }
     *     
     */
    public PreviousAddresses getPreviousAddresses() {
        return previousAddresses;
    }

    /**
     * 设置previousAddresses属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousAddresses }
     *     
     */
    public void setPreviousAddresses(PreviousAddresses value) {
        this.previousAddresses = value;
    }

    /**
     * 获取emailAddresses属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EmailAddresses }
     *     
     */
    public EmailAddresses getEmailAddresses() {
        return emailAddresses;
    }

    /**
     * 设置emailAddresses属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EmailAddresses }
     *     
     */
    public void setEmailAddresses(EmailAddresses value) {
        this.emailAddresses = value;
    }

    /**
     * 获取websites属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Websites }
     *     
     */
    public Websites getWebsites() {
        return websites;
    }

    /**
     * 设置websites属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Websites }
     *     
     */
    public void setWebsites(Websites value) {
        this.websites = value;
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
     *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "emailAddress"
    })
    public static class EmailAddresses implements Serializable{

        @XmlElement(name = "EmailAddress")
        protected List<String> emailAddress;

        /**
         * Gets the value of the emailAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the emailAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEmailAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getEmailAddress() {
            if (emailAddress == null) {
                emailAddress = new ArrayList<String>();
            }
            return this.emailAddress;
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
     *         &lt;element name="OtherAddress" type="{http://www.creditsafe.com/globaldata/datatypes/reports}StreetAddressWithTelephone" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "otherAddress"
    })
    public static class OtherAddresses implements Serializable{

        @XmlElement(name = "OtherAddress")
        protected List<StreetAddressWithTelephone> otherAddress;

        /**
         * Gets the value of the otherAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the otherAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOtherAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StreetAddressWithTelephone }
         * 
         * 
         */
        public List<StreetAddressWithTelephone> getOtherAddress() {
            if (otherAddress == null) {
                otherAddress = new ArrayList<StreetAddressWithTelephone>();
            }
            return this.otherAddress;
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
     *         &lt;element name="PreviousAddress" type="{http://www.creditsafe.com/globaldata/datatypes/reports}StreetAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "previousAddress"
    })
    public static class PreviousAddresses implements Serializable{

        @XmlElement(name = "PreviousAddress")
        protected List<StreetAddress> previousAddress;

        /**
         * Gets the value of the previousAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the previousAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPreviousAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StreetAddress }
         * 
         * 
         */
        public List<StreetAddress> getPreviousAddress() {
            if (previousAddress == null) {
                previousAddress = new ArrayList<StreetAddress>();
            }
            return this.previousAddress;
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
     *         &lt;element name="Website" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "website"
    })
    public static class Websites implements Serializable{

        @XmlElement(name = "Website")
        protected List<String> website;

        /**
         * Gets the value of the website property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the website property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWebsite().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getWebsite() {
            if (website == null) {
                website = new ArrayList<String>();
            }
            return this.website;
        }

    }

}
