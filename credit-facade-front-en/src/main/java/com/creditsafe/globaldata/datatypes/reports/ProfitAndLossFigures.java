
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>ProfitAndLossFigures complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ProfitAndLossFigures"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Revenue" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OperatingCosts" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OperatingProfit" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="WagesAndSalaries" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="PensionCosts" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="Depreciation" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="Amortisation" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="FinancialIncome" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="FinancialExpenses" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="ExtraordinaryIncome" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="ExtraordinaryCosts" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="ProfitBeforeTax" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="Tax" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="ProfitAfterTax" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="Dividends" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="MinorityInterests" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherAppropriations" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="RetainedProfit" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfitAndLossFigures", propOrder = {
    "revenue",
    "operatingCosts",
    "operatingProfit",
    "wagesAndSalaries",
    "pensionCosts",
    "depreciation",
    "amortisation",
    "financialIncome",
    "financialExpenses",
    "extraordinaryIncome",
    "extraordinaryCosts",
    "profitBeforeTax",
    "tax",
    "profitAfterTax",
    "dividends",
    "minorityInterests",
    "otherAppropriations",
    "retainedProfit"
})
public class ProfitAndLossFigures implements Serializable {

    @XmlElement(name = "Revenue")
    protected FinancialValueDecimal revenue;
    @XmlElement(name = "OperatingCosts")
    protected FinancialValueDecimal operatingCosts;
    @XmlElement(name = "OperatingProfit")
    protected FinancialValueDecimal operatingProfit;
    @XmlElement(name = "WagesAndSalaries")
    protected FinancialValueDecimal wagesAndSalaries;
    @XmlElement(name = "PensionCosts")
    protected FinancialValueDecimal pensionCosts;
    @XmlElement(name = "Depreciation")
    protected FinancialValueDecimal depreciation;
    @XmlElement(name = "Amortisation")
    protected FinancialValueDecimal amortisation;
    @XmlElement(name = "FinancialIncome")
    protected FinancialValueDecimal financialIncome;
    @XmlElement(name = "FinancialExpenses")
    protected FinancialValueDecimal financialExpenses;
    @XmlElement(name = "ExtraordinaryIncome")
    protected FinancialValueDecimal extraordinaryIncome;
    @XmlElement(name = "ExtraordinaryCosts")
    protected FinancialValueDecimal extraordinaryCosts;
    @XmlElement(name = "ProfitBeforeTax")
    protected FinancialValueDecimal profitBeforeTax;
    @XmlElement(name = "Tax")
    protected FinancialValueDecimal tax;
    @XmlElement(name = "ProfitAfterTax")
    protected FinancialValueDecimal profitAfterTax;
    @XmlElement(name = "Dividends")
    protected FinancialValueDecimal dividends;
    @XmlElement(name = "MinorityInterests")
    protected FinancialValueDecimal minorityInterests;
    @XmlElement(name = "OtherAppropriations")
    protected FinancialValueDecimal otherAppropriations;
    @XmlElement(name = "RetainedProfit")
    protected FinancialValueDecimal retainedProfit;

    /**
     * 获取revenue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getRevenue() {
        return revenue;
    }

    /**
     * 设置revenue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setRevenue(FinancialValueDecimal value) {
        this.revenue = value;
    }

    /**
     * 获取operatingCosts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOperatingCosts() {
        return operatingCosts;
    }

    /**
     * 设置operatingCosts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOperatingCosts(FinancialValueDecimal value) {
        this.operatingCosts = value;
    }

    /**
     * 获取operatingProfit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOperatingProfit() {
        return operatingProfit;
    }

    /**
     * 设置operatingProfit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOperatingProfit(FinancialValueDecimal value) {
        this.operatingProfit = value;
    }

    /**
     * 获取wagesAndSalaries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getWagesAndSalaries() {
        return wagesAndSalaries;
    }

    /**
     * 设置wagesAndSalaries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setWagesAndSalaries(FinancialValueDecimal value) {
        this.wagesAndSalaries = value;
    }

    /**
     * 获取pensionCosts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getPensionCosts() {
        return pensionCosts;
    }

    /**
     * 设置pensionCosts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setPensionCosts(FinancialValueDecimal value) {
        this.pensionCosts = value;
    }

    /**
     * 获取depreciation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getDepreciation() {
        return depreciation;
    }

    /**
     * 设置depreciation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setDepreciation(FinancialValueDecimal value) {
        this.depreciation = value;
    }

    /**
     * 获取amortisation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getAmortisation() {
        return amortisation;
    }

    /**
     * 设置amortisation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setAmortisation(FinancialValueDecimal value) {
        this.amortisation = value;
    }

    /**
     * 获取financialIncome属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getFinancialIncome() {
        return financialIncome;
    }

    /**
     * 设置financialIncome属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setFinancialIncome(FinancialValueDecimal value) {
        this.financialIncome = value;
    }

    /**
     * 获取financialExpenses属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getFinancialExpenses() {
        return financialExpenses;
    }

    /**
     * 设置financialExpenses属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setFinancialExpenses(FinancialValueDecimal value) {
        this.financialExpenses = value;
    }

    /**
     * 获取extraordinaryIncome属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getExtraordinaryIncome() {
        return extraordinaryIncome;
    }

    /**
     * 设置extraordinaryIncome属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setExtraordinaryIncome(FinancialValueDecimal value) {
        this.extraordinaryIncome = value;
    }

    /**
     * 获取extraordinaryCosts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getExtraordinaryCosts() {
        return extraordinaryCosts;
    }

    /**
     * 设置extraordinaryCosts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setExtraordinaryCosts(FinancialValueDecimal value) {
        this.extraordinaryCosts = value;
    }

    /**
     * 获取profitBeforeTax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getProfitBeforeTax() {
        return profitBeforeTax;
    }

    /**
     * 设置profitBeforeTax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setProfitBeforeTax(FinancialValueDecimal value) {
        this.profitBeforeTax = value;
    }

    /**
     * 获取tax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTax() {
        return tax;
    }

    /**
     * 设置tax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTax(FinancialValueDecimal value) {
        this.tax = value;
    }

    /**
     * 获取profitAfterTax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getProfitAfterTax() {
        return profitAfterTax;
    }

    /**
     * 设置profitAfterTax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setProfitAfterTax(FinancialValueDecimal value) {
        this.profitAfterTax = value;
    }

    /**
     * 获取dividends属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getDividends() {
        return dividends;
    }

    /**
     * 设置dividends属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setDividends(FinancialValueDecimal value) {
        this.dividends = value;
    }

    /**
     * 获取minorityInterests属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getMinorityInterests() {
        return minorityInterests;
    }

    /**
     * 设置minorityInterests属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setMinorityInterests(FinancialValueDecimal value) {
        this.minorityInterests = value;
    }

    /**
     * 获取otherAppropriations属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherAppropriations() {
        return otherAppropriations;
    }

    /**
     * 设置otherAppropriations属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherAppropriations(FinancialValueDecimal value) {
        this.otherAppropriations = value;
    }

    /**
     * 获取retainedProfit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getRetainedProfit() {
        return retainedProfit;
    }

    /**
     * 设置retainedProfit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setRetainedProfit(FinancialValueDecimal value) {
        this.retainedProfit = value;
    }

}
