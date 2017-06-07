
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LtdShareCapitalStructure complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdShareCapitalStructure"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NominalShareCapital" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="IssuedShareCapital" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="ShareHolders" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ShareHolder" type="{http://www.creditsafe.com/globaldata/datatypes/reports}ShareHolder" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "LtdShareCapitalStructure", propOrder = {
    "nominalShareCapital",
    "issuedShareCapital",
    "shareHolders"
})
public class LtdShareCapitalStructure implements Serializable {

    @XmlElement(name = "NominalShareCapital")
    protected FinancialValueDecimal nominalShareCapital;
    @XmlElement(name = "IssuedShareCapital")
    protected FinancialValueDecimal issuedShareCapital;
    @XmlElement(name = "ShareHolders")
    protected ShareHolders shareHolders;

    /**
     * 获取nominalShareCapital属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getNominalShareCapital() {
        return nominalShareCapital;
    }

    /**
     * 设置nominalShareCapital属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setNominalShareCapital(FinancialValueDecimal value) {
        this.nominalShareCapital = value;
    }

    /**
     * 获取issuedShareCapital属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getIssuedShareCapital() {
        return issuedShareCapital;
    }

    /**
     * 设置issuedShareCapital属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setIssuedShareCapital(FinancialValueDecimal value) {
        this.issuedShareCapital = value;
    }

    /**
     * 获取shareHolders属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ShareHolders }
     *     
     */
    public ShareHolders getShareHolders() {
        return shareHolders;
    }

    /**
     * 设置shareHolders属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ShareHolders }
     *     
     */
    public void setShareHolders(ShareHolders value) {
        this.shareHolders = value;
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
     *         &lt;element name="ShareHolder" type="{http://www.creditsafe.com/globaldata/datatypes/reports}ShareHolder" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "shareHolder"
    })
    public static class ShareHolders implements Serializable{

        @XmlElement(name = "ShareHolder")
        protected List<ShareHolder> shareHolder;

        /**
         * Gets the value of the shareHolder property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the shareHolder property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getShareHolder().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ShareHolder }
         * 
         * 
         */
        public List<ShareHolder> getShareHolder() {
            if (shareHolder == null) {
                shareHolder = new ArrayList<ShareHolder>();
            }
            return this.shareHolder;
        }

    }

}
