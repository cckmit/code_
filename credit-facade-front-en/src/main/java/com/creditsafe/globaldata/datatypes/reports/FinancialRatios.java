
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * <p>FinancialRatios complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FinancialRatios"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PreTaxProfitMargin" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="ReturnOnCapitalEmployed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="ReturnOnTotalAssetsEmployed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="ReturnOnNetAssetsEmployed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="SalesOrNetWorkingCapital" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="StockTurnoverRatio" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="DebtorDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="CreditorDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="CurrentRatio" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="LiquidityRatioOrAcidTest" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="CurrentDebtRatio" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Gearing" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="EquityInPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalDebtRatio" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialRatios", propOrder = {
    "preTaxProfitMargin",
    "returnOnCapitalEmployed",
    "returnOnTotalAssetsEmployed",
    "returnOnNetAssetsEmployed",
    "salesOrNetWorkingCapital",
    "stockTurnoverRatio",
    "debtorDays",
    "creditorDays",
    "currentRatio",
    "liquidityRatioOrAcidTest",
    "currentDebtRatio",
    "gearing",
    "equityInPercentage",
    "totalDebtRatio"
})
public class FinancialRatios implements Serializable {

    @XmlElement(name = "PreTaxProfitMargin")
    protected BigDecimal preTaxProfitMargin;
    @XmlElement(name = "ReturnOnCapitalEmployed")
    protected BigDecimal returnOnCapitalEmployed;
    @XmlElement(name = "ReturnOnTotalAssetsEmployed")
    protected BigDecimal returnOnTotalAssetsEmployed;
    @XmlElement(name = "ReturnOnNetAssetsEmployed")
    protected BigDecimal returnOnNetAssetsEmployed;
    @XmlElement(name = "SalesOrNetWorkingCapital")
    protected BigDecimal salesOrNetWorkingCapital;
    @XmlElement(name = "StockTurnoverRatio")
    protected BigDecimal stockTurnoverRatio;
    @XmlElement(name = "DebtorDays")
    protected BigDecimal debtorDays;
    @XmlElement(name = "CreditorDays")
    protected BigDecimal creditorDays;
    @XmlElement(name = "CurrentRatio")
    protected BigDecimal currentRatio;
    @XmlElement(name = "LiquidityRatioOrAcidTest")
    protected BigDecimal liquidityRatioOrAcidTest;
    @XmlElement(name = "CurrentDebtRatio")
    protected BigDecimal currentDebtRatio;
    @XmlElement(name = "Gearing")
    protected BigDecimal gearing;
    @XmlElement(name = "EquityInPercentage")
    protected BigDecimal equityInPercentage;
    @XmlElement(name = "TotalDebtRatio")
    protected BigDecimal totalDebtRatio;

    /**
     * 获取preTaxProfitMargin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPreTaxProfitMargin() {
        return preTaxProfitMargin;
    }

    /**
     * 设置preTaxProfitMargin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPreTaxProfitMargin(BigDecimal value) {
        this.preTaxProfitMargin = value;
    }

    /**
     * 获取returnOnCapitalEmployed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReturnOnCapitalEmployed() {
        return returnOnCapitalEmployed;
    }

    /**
     * 设置returnOnCapitalEmployed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReturnOnCapitalEmployed(BigDecimal value) {
        this.returnOnCapitalEmployed = value;
    }

    /**
     * 获取returnOnTotalAssetsEmployed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReturnOnTotalAssetsEmployed() {
        return returnOnTotalAssetsEmployed;
    }

    /**
     * 设置returnOnTotalAssetsEmployed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReturnOnTotalAssetsEmployed(BigDecimal value) {
        this.returnOnTotalAssetsEmployed = value;
    }

    /**
     * 获取returnOnNetAssetsEmployed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReturnOnNetAssetsEmployed() {
        return returnOnNetAssetsEmployed;
    }

    /**
     * 设置returnOnNetAssetsEmployed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReturnOnNetAssetsEmployed(BigDecimal value) {
        this.returnOnNetAssetsEmployed = value;
    }

    /**
     * 获取salesOrNetWorkingCapital属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSalesOrNetWorkingCapital() {
        return salesOrNetWorkingCapital;
    }

    /**
     * 设置salesOrNetWorkingCapital属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSalesOrNetWorkingCapital(BigDecimal value) {
        this.salesOrNetWorkingCapital = value;
    }

    /**
     * 获取stockTurnoverRatio属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStockTurnoverRatio() {
        return stockTurnoverRatio;
    }

    /**
     * 设置stockTurnoverRatio属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStockTurnoverRatio(BigDecimal value) {
        this.stockTurnoverRatio = value;
    }

    /**
     * 获取debtorDays属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebtorDays() {
        return debtorDays;
    }

    /**
     * 设置debtorDays属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebtorDays(BigDecimal value) {
        this.debtorDays = value;
    }

    /**
     * 获取creditorDays属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditorDays() {
        return creditorDays;
    }

    /**
     * 设置creditorDays属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditorDays(BigDecimal value) {
        this.creditorDays = value;
    }

    /**
     * 获取currentRatio属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentRatio() {
        return currentRatio;
    }

    /**
     * 设置currentRatio属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentRatio(BigDecimal value) {
        this.currentRatio = value;
    }

    /**
     * 获取liquidityRatioOrAcidTest属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLiquidityRatioOrAcidTest() {
        return liquidityRatioOrAcidTest;
    }

    /**
     * 设置liquidityRatioOrAcidTest属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLiquidityRatioOrAcidTest(BigDecimal value) {
        this.liquidityRatioOrAcidTest = value;
    }

    /**
     * 获取currentDebtRatio属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentDebtRatio() {
        return currentDebtRatio;
    }

    /**
     * 设置currentDebtRatio属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentDebtRatio(BigDecimal value) {
        this.currentDebtRatio = value;
    }

    /**
     * 获取gearing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGearing() {
        return gearing;
    }

    /**
     * 设置gearing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGearing(BigDecimal value) {
        this.gearing = value;
    }

    /**
     * 获取equityInPercentage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEquityInPercentage() {
        return equityInPercentage;
    }

    /**
     * 设置equityInPercentage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEquityInPercentage(BigDecimal value) {
        this.equityInPercentage = value;
    }

    /**
     * 获取totalDebtRatio属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDebtRatio() {
        return totalDebtRatio;
    }

    /**
     * 设置totalDebtRatio属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDebtRatio(BigDecimal value) {
        this.totalDebtRatio = value;
    }

}
