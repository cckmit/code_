
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>BalanceSheet complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BalanceSheet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LandAndBuildings" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="PlantAndMachinery" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherTangibleAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalTangibleAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="Goodwill" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherIntangibleAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalIntangibleAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="Investments" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="LoansToGroup" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherLoans" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="MiscellaneousFixedAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalOtherFixedAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalFixedAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="RawMaterials" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="WorkInProgress" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="FinishedGoods" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherInventories" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalInventories" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TradeReceivables" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="GroupReceivables" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="ReceivablesDueAfter1Year" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="MiscellaneousReceivables" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalReceivables" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="Cash" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherCurrentAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalCurrentAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalAssets" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TradePayables" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="BankLiabilities" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherLoansOrFinance" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="GroupPayables" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="MiscellaneousLiabilities" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalCurrentLiabilities" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TradePayablesDueAfter1Year" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="BankLiabilitiesDueAfter1Year" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherLoansOrFinanceDueAfter1Year" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="GroupPayablesDueAfter1Year" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="MiscellaneousLiabilitiesDueAfter1Year" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalLongTermLiabilities" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalLiabilities" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="CalledUpShareCapital" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="SharePremium" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="RevenueReserves" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="OtherReserves" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="TotalShareholdersEquity" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceSheet", propOrder = {
    "landAndBuildings",
    "plantAndMachinery",
    "otherTangibleAssets",
    "totalTangibleAssets",
    "goodwill",
    "otherIntangibleAssets",
    "totalIntangibleAssets",
    "investments",
    "loansToGroup",
    "otherLoans",
    "miscellaneousFixedAssets",
    "totalOtherFixedAssets",
    "totalFixedAssets",
    "rawMaterials",
    "workInProgress",
    "finishedGoods",
    "otherInventories",
    "totalInventories",
    "tradeReceivables",
    "groupReceivables",
    "receivablesDueAfter1Year",
    "miscellaneousReceivables",
    "totalReceivables",
    "cash",
    "otherCurrentAssets",
    "totalCurrentAssets",
    "totalAssets",
    "tradePayables",
    "bankLiabilities",
    "otherLoansOrFinance",
    "groupPayables",
    "miscellaneousLiabilities",
    "totalCurrentLiabilities",
    "tradePayablesDueAfter1Year",
    "bankLiabilitiesDueAfter1Year",
    "otherLoansOrFinanceDueAfter1Year",
    "groupPayablesDueAfter1Year",
    "miscellaneousLiabilitiesDueAfter1Year",
    "totalLongTermLiabilities",
    "totalLiabilities",
    "calledUpShareCapital",
    "sharePremium",
    "revenueReserves",
    "otherReserves",
    "totalShareholdersEquity"
})
public class BalanceSheet implements Serializable {

    @XmlElement(name = "LandAndBuildings")
    protected FinancialValueDecimal landAndBuildings;
    @XmlElement(name = "PlantAndMachinery")
    protected FinancialValueDecimal plantAndMachinery;
    @XmlElement(name = "OtherTangibleAssets")
    protected FinancialValueDecimal otherTangibleAssets;
    @XmlElement(name = "TotalTangibleAssets")
    protected FinancialValueDecimal totalTangibleAssets;
    @XmlElement(name = "Goodwill")
    protected FinancialValueDecimal goodwill;
    @XmlElement(name = "OtherIntangibleAssets")
    protected FinancialValueDecimal otherIntangibleAssets;
    @XmlElement(name = "TotalIntangibleAssets")
    protected FinancialValueDecimal totalIntangibleAssets;
    @XmlElement(name = "Investments")
    protected FinancialValueDecimal investments;
    @XmlElement(name = "LoansToGroup")
    protected FinancialValueDecimal loansToGroup;
    @XmlElement(name = "OtherLoans")
    protected FinancialValueDecimal otherLoans;
    @XmlElement(name = "MiscellaneousFixedAssets")
    protected FinancialValueDecimal miscellaneousFixedAssets;
    @XmlElement(name = "TotalOtherFixedAssets")
    protected FinancialValueDecimal totalOtherFixedAssets;
    @XmlElement(name = "TotalFixedAssets")
    protected FinancialValueDecimal totalFixedAssets;
    @XmlElement(name = "RawMaterials")
    protected FinancialValueDecimal rawMaterials;
    @XmlElement(name = "WorkInProgress")
    protected FinancialValueDecimal workInProgress;
    @XmlElement(name = "FinishedGoods")
    protected FinancialValueDecimal finishedGoods;
    @XmlElement(name = "OtherInventories")
    protected FinancialValueDecimal otherInventories;
    @XmlElement(name = "TotalInventories")
    protected FinancialValueDecimal totalInventories;
    @XmlElement(name = "TradeReceivables")
    protected FinancialValueDecimal tradeReceivables;
    @XmlElement(name = "GroupReceivables")
    protected FinancialValueDecimal groupReceivables;
    @XmlElement(name = "ReceivablesDueAfter1Year")
    protected FinancialValueDecimal receivablesDueAfter1Year;
    @XmlElement(name = "MiscellaneousReceivables")
    protected FinancialValueDecimal miscellaneousReceivables;
    @XmlElement(name = "TotalReceivables")
    protected FinancialValueDecimal totalReceivables;
    @XmlElement(name = "Cash")
    protected FinancialValueDecimal cash;
    @XmlElement(name = "OtherCurrentAssets")
    protected FinancialValueDecimal otherCurrentAssets;
    @XmlElement(name = "TotalCurrentAssets")
    protected FinancialValueDecimal totalCurrentAssets;
    @XmlElement(name = "TotalAssets")
    protected FinancialValueDecimal totalAssets;
    @XmlElement(name = "TradePayables")
    protected FinancialValueDecimal tradePayables;
    @XmlElement(name = "BankLiabilities")
    protected FinancialValueDecimal bankLiabilities;
    @XmlElement(name = "OtherLoansOrFinance")
    protected FinancialValueDecimal otherLoansOrFinance;
    @XmlElement(name = "GroupPayables")
    protected FinancialValueDecimal groupPayables;
    @XmlElement(name = "MiscellaneousLiabilities")
    protected FinancialValueDecimal miscellaneousLiabilities;
    @XmlElement(name = "TotalCurrentLiabilities")
    protected FinancialValueDecimal totalCurrentLiabilities;
    @XmlElement(name = "TradePayablesDueAfter1Year")
    protected FinancialValueDecimal tradePayablesDueAfter1Year;
    @XmlElement(name = "BankLiabilitiesDueAfter1Year")
    protected FinancialValueDecimal bankLiabilitiesDueAfter1Year;
    @XmlElement(name = "OtherLoansOrFinanceDueAfter1Year")
    protected FinancialValueDecimal otherLoansOrFinanceDueAfter1Year;
    @XmlElement(name = "GroupPayablesDueAfter1Year")
    protected FinancialValueDecimal groupPayablesDueAfter1Year;
    @XmlElement(name = "MiscellaneousLiabilitiesDueAfter1Year")
    protected FinancialValueDecimal miscellaneousLiabilitiesDueAfter1Year;
    @XmlElement(name = "TotalLongTermLiabilities")
    protected FinancialValueDecimal totalLongTermLiabilities;
    @XmlElement(name = "TotalLiabilities")
    protected FinancialValueDecimal totalLiabilities;
    @XmlElement(name = "CalledUpShareCapital")
    protected FinancialValueDecimal calledUpShareCapital;
    @XmlElement(name = "SharePremium")
    protected FinancialValueDecimal sharePremium;
    @XmlElement(name = "RevenueReserves")
    protected FinancialValueDecimal revenueReserves;
    @XmlElement(name = "OtherReserves")
    protected FinancialValueDecimal otherReserves;
    @XmlElement(name = "TotalShareholdersEquity")
    protected FinancialValueDecimal totalShareholdersEquity;

    /**
     * 获取landAndBuildings属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getLandAndBuildings() {
        return landAndBuildings;
    }

    /**
     * 设置landAndBuildings属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setLandAndBuildings(FinancialValueDecimal value) {
        this.landAndBuildings = value;
    }

    /**
     * 获取plantAndMachinery属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getPlantAndMachinery() {
        return plantAndMachinery;
    }

    /**
     * 设置plantAndMachinery属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setPlantAndMachinery(FinancialValueDecimal value) {
        this.plantAndMachinery = value;
    }

    /**
     * 获取otherTangibleAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherTangibleAssets() {
        return otherTangibleAssets;
    }

    /**
     * 设置otherTangibleAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherTangibleAssets(FinancialValueDecimal value) {
        this.otherTangibleAssets = value;
    }

    /**
     * 获取totalTangibleAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalTangibleAssets() {
        return totalTangibleAssets;
    }

    /**
     * 设置totalTangibleAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalTangibleAssets(FinancialValueDecimal value) {
        this.totalTangibleAssets = value;
    }

    /**
     * 获取goodwill属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getGoodwill() {
        return goodwill;
    }

    /**
     * 设置goodwill属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setGoodwill(FinancialValueDecimal value) {
        this.goodwill = value;
    }

    /**
     * 获取otherIntangibleAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherIntangibleAssets() {
        return otherIntangibleAssets;
    }

    /**
     * 设置otherIntangibleAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherIntangibleAssets(FinancialValueDecimal value) {
        this.otherIntangibleAssets = value;
    }

    /**
     * 获取totalIntangibleAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalIntangibleAssets() {
        return totalIntangibleAssets;
    }

    /**
     * 设置totalIntangibleAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalIntangibleAssets(FinancialValueDecimal value) {
        this.totalIntangibleAssets = value;
    }

    /**
     * 获取investments属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getInvestments() {
        return investments;
    }

    /**
     * 设置investments属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setInvestments(FinancialValueDecimal value) {
        this.investments = value;
    }

    /**
     * 获取loansToGroup属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getLoansToGroup() {
        return loansToGroup;
    }

    /**
     * 设置loansToGroup属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setLoansToGroup(FinancialValueDecimal value) {
        this.loansToGroup = value;
    }

    /**
     * 获取otherLoans属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherLoans() {
        return otherLoans;
    }

    /**
     * 设置otherLoans属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherLoans(FinancialValueDecimal value) {
        this.otherLoans = value;
    }

    /**
     * 获取miscellaneousFixedAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getMiscellaneousFixedAssets() {
        return miscellaneousFixedAssets;
    }

    /**
     * 设置miscellaneousFixedAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setMiscellaneousFixedAssets(FinancialValueDecimal value) {
        this.miscellaneousFixedAssets = value;
    }

    /**
     * 获取totalOtherFixedAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalOtherFixedAssets() {
        return totalOtherFixedAssets;
    }

    /**
     * 设置totalOtherFixedAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalOtherFixedAssets(FinancialValueDecimal value) {
        this.totalOtherFixedAssets = value;
    }

    /**
     * 获取totalFixedAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalFixedAssets() {
        return totalFixedAssets;
    }

    /**
     * 设置totalFixedAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalFixedAssets(FinancialValueDecimal value) {
        this.totalFixedAssets = value;
    }

    /**
     * 获取rawMaterials属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getRawMaterials() {
        return rawMaterials;
    }

    /**
     * 设置rawMaterials属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setRawMaterials(FinancialValueDecimal value) {
        this.rawMaterials = value;
    }

    /**
     * 获取workInProgress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getWorkInProgress() {
        return workInProgress;
    }

    /**
     * 设置workInProgress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setWorkInProgress(FinancialValueDecimal value) {
        this.workInProgress = value;
    }

    /**
     * 获取finishedGoods属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getFinishedGoods() {
        return finishedGoods;
    }

    /**
     * 设置finishedGoods属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setFinishedGoods(FinancialValueDecimal value) {
        this.finishedGoods = value;
    }

    /**
     * 获取otherInventories属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherInventories() {
        return otherInventories;
    }

    /**
     * 设置otherInventories属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherInventories(FinancialValueDecimal value) {
        this.otherInventories = value;
    }

    /**
     * 获取totalInventories属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalInventories() {
        return totalInventories;
    }

    /**
     * 设置totalInventories属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalInventories(FinancialValueDecimal value) {
        this.totalInventories = value;
    }

    /**
     * 获取tradeReceivables属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTradeReceivables() {
        return tradeReceivables;
    }

    /**
     * 设置tradeReceivables属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTradeReceivables(FinancialValueDecimal value) {
        this.tradeReceivables = value;
    }

    /**
     * 获取groupReceivables属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getGroupReceivables() {
        return groupReceivables;
    }

    /**
     * 设置groupReceivables属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setGroupReceivables(FinancialValueDecimal value) {
        this.groupReceivables = value;
    }

    /**
     * 获取receivablesDueAfter1Year属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getReceivablesDueAfter1Year() {
        return receivablesDueAfter1Year;
    }

    /**
     * 设置receivablesDueAfter1Year属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setReceivablesDueAfter1Year(FinancialValueDecimal value) {
        this.receivablesDueAfter1Year = value;
    }

    /**
     * 获取miscellaneousReceivables属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getMiscellaneousReceivables() {
        return miscellaneousReceivables;
    }

    /**
     * 设置miscellaneousReceivables属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setMiscellaneousReceivables(FinancialValueDecimal value) {
        this.miscellaneousReceivables = value;
    }

    /**
     * 获取totalReceivables属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalReceivables() {
        return totalReceivables;
    }

    /**
     * 设置totalReceivables属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalReceivables(FinancialValueDecimal value) {
        this.totalReceivables = value;
    }

    /**
     * 获取cash属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getCash() {
        return cash;
    }

    /**
     * 设置cash属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setCash(FinancialValueDecimal value) {
        this.cash = value;
    }

    /**
     * 获取otherCurrentAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherCurrentAssets() {
        return otherCurrentAssets;
    }

    /**
     * 设置otherCurrentAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherCurrentAssets(FinancialValueDecimal value) {
        this.otherCurrentAssets = value;
    }

    /**
     * 获取totalCurrentAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalCurrentAssets() {
        return totalCurrentAssets;
    }

    /**
     * 设置totalCurrentAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalCurrentAssets(FinancialValueDecimal value) {
        this.totalCurrentAssets = value;
    }

    /**
     * 获取totalAssets属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalAssets() {
        return totalAssets;
    }

    /**
     * 设置totalAssets属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalAssets(FinancialValueDecimal value) {
        this.totalAssets = value;
    }

    /**
     * 获取tradePayables属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTradePayables() {
        return tradePayables;
    }

    /**
     * 设置tradePayables属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTradePayables(FinancialValueDecimal value) {
        this.tradePayables = value;
    }

    /**
     * 获取bankLiabilities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getBankLiabilities() {
        return bankLiabilities;
    }

    /**
     * 设置bankLiabilities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setBankLiabilities(FinancialValueDecimal value) {
        this.bankLiabilities = value;
    }

    /**
     * 获取otherLoansOrFinance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherLoansOrFinance() {
        return otherLoansOrFinance;
    }

    /**
     * 设置otherLoansOrFinance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherLoansOrFinance(FinancialValueDecimal value) {
        this.otherLoansOrFinance = value;
    }

    /**
     * 获取groupPayables属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getGroupPayables() {
        return groupPayables;
    }

    /**
     * 设置groupPayables属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setGroupPayables(FinancialValueDecimal value) {
        this.groupPayables = value;
    }

    /**
     * 获取miscellaneousLiabilities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getMiscellaneousLiabilities() {
        return miscellaneousLiabilities;
    }

    /**
     * 设置miscellaneousLiabilities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setMiscellaneousLiabilities(FinancialValueDecimal value) {
        this.miscellaneousLiabilities = value;
    }

    /**
     * 获取totalCurrentLiabilities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalCurrentLiabilities() {
        return totalCurrentLiabilities;
    }

    /**
     * 设置totalCurrentLiabilities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalCurrentLiabilities(FinancialValueDecimal value) {
        this.totalCurrentLiabilities = value;
    }

    /**
     * 获取tradePayablesDueAfter1Year属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTradePayablesDueAfter1Year() {
        return tradePayablesDueAfter1Year;
    }

    /**
     * 设置tradePayablesDueAfter1Year属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTradePayablesDueAfter1Year(FinancialValueDecimal value) {
        this.tradePayablesDueAfter1Year = value;
    }

    /**
     * 获取bankLiabilitiesDueAfter1Year属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getBankLiabilitiesDueAfter1Year() {
        return bankLiabilitiesDueAfter1Year;
    }

    /**
     * 设置bankLiabilitiesDueAfter1Year属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setBankLiabilitiesDueAfter1Year(FinancialValueDecimal value) {
        this.bankLiabilitiesDueAfter1Year = value;
    }

    /**
     * 获取otherLoansOrFinanceDueAfter1Year属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherLoansOrFinanceDueAfter1Year() {
        return otherLoansOrFinanceDueAfter1Year;
    }

    /**
     * 设置otherLoansOrFinanceDueAfter1Year属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherLoansOrFinanceDueAfter1Year(FinancialValueDecimal value) {
        this.otherLoansOrFinanceDueAfter1Year = value;
    }

    /**
     * 获取groupPayablesDueAfter1Year属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getGroupPayablesDueAfter1Year() {
        return groupPayablesDueAfter1Year;
    }

    /**
     * 设置groupPayablesDueAfter1Year属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setGroupPayablesDueAfter1Year(FinancialValueDecimal value) {
        this.groupPayablesDueAfter1Year = value;
    }

    /**
     * 获取miscellaneousLiabilitiesDueAfter1Year属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getMiscellaneousLiabilitiesDueAfter1Year() {
        return miscellaneousLiabilitiesDueAfter1Year;
    }

    /**
     * 设置miscellaneousLiabilitiesDueAfter1Year属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setMiscellaneousLiabilitiesDueAfter1Year(FinancialValueDecimal value) {
        this.miscellaneousLiabilitiesDueAfter1Year = value;
    }

    /**
     * 获取totalLongTermLiabilities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalLongTermLiabilities() {
        return totalLongTermLiabilities;
    }

    /**
     * 设置totalLongTermLiabilities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalLongTermLiabilities(FinancialValueDecimal value) {
        this.totalLongTermLiabilities = value;
    }

    /**
     * 获取totalLiabilities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    /**
     * 设置totalLiabilities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalLiabilities(FinancialValueDecimal value) {
        this.totalLiabilities = value;
    }

    /**
     * 获取calledUpShareCapital属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getCalledUpShareCapital() {
        return calledUpShareCapital;
    }

    /**
     * 设置calledUpShareCapital属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setCalledUpShareCapital(FinancialValueDecimal value) {
        this.calledUpShareCapital = value;
    }

    /**
     * 获取sharePremium属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getSharePremium() {
        return sharePremium;
    }

    /**
     * 设置sharePremium属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setSharePremium(FinancialValueDecimal value) {
        this.sharePremium = value;
    }

    /**
     * 获取revenueReserves属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getRevenueReserves() {
        return revenueReserves;
    }

    /**
     * 设置revenueReserves属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setRevenueReserves(FinancialValueDecimal value) {
        this.revenueReserves = value;
    }

    /**
     * 获取otherReserves属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getOtherReserves() {
        return otherReserves;
    }

    /**
     * 设置otherReserves属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setOtherReserves(FinancialValueDecimal value) {
        this.otherReserves = value;
    }

    /**
     * 获取totalShareholdersEquity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getTotalShareholdersEquity() {
        return totalShareholdersEquity;
    }

    /**
     * 设置totalShareholdersEquity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setTotalShareholdersEquity(FinancialValueDecimal value) {
        this.totalShareholdersEquity = value;
    }

}
