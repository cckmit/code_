
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LtdCompanyFullReport complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdCompanyFullReport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes/reports}CompanyReport"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CompanySummary" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdCompanySummary"/&gt;
 *         &lt;element name="CompanyIdentification" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdCompanyIdentification"/&gt;
 *         &lt;element name="CreditScore" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdCreditScore"/&gt;
 *         &lt;element name="ContactInformation" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdContactInformation"/&gt;
 *         &lt;element name="ShareCapitalStructure" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdShareCapitalStructure" minOccurs="0"/&gt;
 *         &lt;element name="Directors" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdDirectors" minOccurs="0"/&gt;
 *         &lt;element name="OtherInformation" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdOtherInformation" minOccurs="0"/&gt;
 *         &lt;element name="GroupStructure" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdGroupStructure" minOccurs="0"/&gt;
 *         &lt;element name="FinancialStatements" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="FinancialStatement" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdFinancialStatement" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AdditionalInformation" type="{http://www.creditsafe.com/globaldata/datatypes/reports/additional}AdditionalInformation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LtdCompanyFullReport", propOrder = {
    "companySummary",
    "companyIdentification",
    "creditScore",
    "contactInformation",
    "shareCapitalStructure",
    "directors",
    "otherInformation",
    "groupStructure",
    "financialStatements",
    "additionalInformation"
})
public class LtdCompanyFullReport
    extends CompanyReport implements Serializable
{

    @XmlElement(name = "CompanySummary", required = true)
    protected LtdCompanySummary companySummary;           //公司摘要
    @XmlElement(name = "CompanyIdentification", required = true)
    protected LtdCompanyIdentification companyIdentification;     //公司识别
    @XmlElement(name = "CreditScore", required = true)
    protected LtdCreditScore creditScore;        //信用评价
    @XmlElement(name = "ContactInformation", required = true)
    protected LtdContactInformation contactInformation;     //联系信息
    @XmlElement(name = "ShareCapitalStructure")
    protected LtdShareCapitalStructure shareCapitalStructure;   //省会结构共享
    @XmlElement(name = "Directors")
    protected LtdDirectors directors;       //主管
    @XmlElement(name = "OtherInformation")
    protected LtdOtherInformation otherInformation;         //其他信息
    @XmlElement(name = "GroupStructure")
    protected LtdGroupStructure groupStructure;      //分组结构
    @XmlElement(name = "FinancialStatements")
    protected FinancialStatements financialStatements;     //财务报告
    @XmlElement(name = "AdditionalInformation")
    protected AdditionalInformation additionalInformation;      //额外信息

    /**
     * 获取companySummary属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdCompanySummary }
     *     
     */
    public LtdCompanySummary getCompanySummary() {
        return companySummary;
    }

    /**
     * 设置companySummary属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdCompanySummary }
     *     
     */
    public void setCompanySummary(LtdCompanySummary value) {
        this.companySummary = value;
    }

    /**
     * 获取companyIdentification属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdCompanyIdentification }
     *     
     */
    public LtdCompanyIdentification getCompanyIdentification() {
        return companyIdentification;
    }

    /**
     * 设置companyIdentification属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdCompanyIdentification }
     *     
     */
    public void setCompanyIdentification(LtdCompanyIdentification value) {
        this.companyIdentification = value;
    }

    /**
     * 获取creditScore属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdCreditScore }
     *     
     */
    public LtdCreditScore getCreditScore() {
        return creditScore;
    }

    /**
     * 设置creditScore属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdCreditScore }
     *     
     */
    public void setCreditScore(LtdCreditScore value) {
        this.creditScore = value;
    }

    /**
     * 获取contactInformation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdContactInformation }
     *     
     */
    public LtdContactInformation getContactInformation() {
        return contactInformation;
    }

    /**
     * 设置contactInformation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdContactInformation }
     *     
     */
    public void setContactInformation(LtdContactInformation value) {
        this.contactInformation = value;
    }

    /**
     * 获取shareCapitalStructure属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdShareCapitalStructure }
     *     
     */
    public LtdShareCapitalStructure getShareCapitalStructure() {
        return shareCapitalStructure;
    }

    /**
     * 设置shareCapitalStructure属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdShareCapitalStructure }
     *     
     */
    public void setShareCapitalStructure(LtdShareCapitalStructure value) {
        this.shareCapitalStructure = value;
    }

    /**
     * 获取directors属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdDirectors }
     *     
     */
    public LtdDirectors getDirectors() {
        return directors;
    }

    /**
     * 设置directors属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdDirectors }
     *     
     */
    public void setDirectors(LtdDirectors value) {
        this.directors = value;
    }

    /**
     * 获取otherInformation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdOtherInformation }
     *     
     */
    public LtdOtherInformation getOtherInformation() {
        return otherInformation;
    }

    /**
     * 设置otherInformation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdOtherInformation }
     *     
     */
    public void setOtherInformation(LtdOtherInformation value) {
        this.otherInformation = value;
    }

    /**
     * 获取groupStructure属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LtdGroupStructure }
     *     
     */
    public LtdGroupStructure getGroupStructure() {
        return groupStructure;
    }

    /**
     * 设置groupStructure属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LtdGroupStructure }
     *     
     */
    public void setGroupStructure(LtdGroupStructure value) {
        this.groupStructure = value;
    }

    /**
     * 获取financialStatements属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialStatements }
     *     
     */
    public FinancialStatements getFinancialStatements() {
        return financialStatements;
    }

    /**
     * 设置financialStatements属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialStatements }
     *     
     */
    public void setFinancialStatements(FinancialStatements value) {
        this.financialStatements = value;
    }

    /**
     * 获取additionalInformation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AdditionalInformation }
     *     
     */
    public AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * 设置additionalInformation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalInformation }
     *     
     */
    public void setAdditionalInformation(AdditionalInformation value) {
        this.additionalInformation = value;
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
     *         &lt;element name="FinancialStatement" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LtdFinancialStatement" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "financialStatement"
    })
    public static class FinancialStatements implements Serializable{

        @XmlElement(name = "FinancialStatement")
        protected List<LtdFinancialStatement> financialStatement;

        /**
         * Gets the value of the financialStatement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the financialStatement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFinancialStatement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LtdFinancialStatement }
         * 
         * 
         */
        public List<LtdFinancialStatement> getFinancialStatement() {
            if (financialStatement == null) {
                financialStatement = new ArrayList<LtdFinancialStatement>();
            }
            return this.financialStatement;
        }

    }

}
