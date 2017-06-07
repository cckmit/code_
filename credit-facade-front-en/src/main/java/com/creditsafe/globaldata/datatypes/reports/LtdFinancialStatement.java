
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>LtdFinancialStatement complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdFinancialStatement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialYearReport"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProfitAndLoss" type="{http://www.creditsafe.com/globaldata/datatypes/reports}ProfitAndLossFigures" minOccurs="0"/&gt;
 *         &lt;element name="BalanceSheet" type="{http://www.creditsafe.com/globaldata/datatypes/reports}BalanceSheet" minOccurs="0"/&gt;
 *         &lt;element name="OtherFinancials" type="{http://www.creditsafe.com/globaldata/datatypes/reports}OtherFinancials" minOccurs="0"/&gt;
 *         &lt;element name="Ratios" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialRatios" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LtdFinancialStatement", propOrder = {
    "profitAndLoss",
    "balanceSheet",
    "otherFinancials",
    "ratios"
})
public class LtdFinancialStatement
    extends FinancialYearReport implements Serializable
{

    @XmlElement(name = "ProfitAndLoss")
    protected ProfitAndLossFigures profitAndLoss;
    @XmlElement(name = "BalanceSheet")
    protected BalanceSheet balanceSheet;
    @XmlElement(name = "OtherFinancials")
    protected OtherFinancials otherFinancials;
    @XmlElement(name = "Ratios")
    protected FinancialRatios ratios;

    /**
     * 获取profitAndLoss属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ProfitAndLossFigures }
     *     
     */
    public ProfitAndLossFigures getProfitAndLoss() {
        return profitAndLoss;
    }

    /**
     * 设置profitAndLoss属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ProfitAndLossFigures }
     *     
     */
    public void setProfitAndLoss(ProfitAndLossFigures value) {
        this.profitAndLoss = value;
    }

    /**
     * 获取balanceSheet属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BalanceSheet }
     *     
     */
    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    /**
     * 设置balanceSheet属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSheet }
     *     
     */
    public void setBalanceSheet(BalanceSheet value) {
        this.balanceSheet = value;
    }

    /**
     * 获取otherFinancials属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OtherFinancials }
     *     
     */
    public OtherFinancials getOtherFinancials() {
        return otherFinancials;
    }

    /**
     * 设置otherFinancials属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OtherFinancials }
     *     
     */
    public void setOtherFinancials(OtherFinancials value) {
        this.otherFinancials = value;
    }

    /**
     * 获取ratios属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialRatios }
     *     
     */
    public FinancialRatios getRatios() {
        return ratios;
    }

    /**
     * 设置ratios属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialRatios }
     *     
     */
    public void setRatios(FinancialRatios value) {
        this.ratios = value;
    }

}
