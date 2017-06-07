
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>OtherFinancials complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OtherFinancials"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ContingentLiabilities" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WorkingCapital" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="NetWorth" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherFinancials", propOrder = {
    "contingentLiabilities",
    "workingCapital",
    "netWorth"
})
public class OtherFinancials implements Serializable {

    @XmlElement(name = "ContingentLiabilities")
    protected String contingentLiabilities;
    @XmlElement(name = "WorkingCapital")
    protected FinancialValueDecimal workingCapital;
    @XmlElement(name = "NetWorth")
    protected FinancialValueDecimal netWorth;

    /**
     * 获取contingentLiabilities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContingentLiabilities() {
        return contingentLiabilities;
    }

    /**
     * 设置contingentLiabilities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContingentLiabilities(String value) {
        this.contingentLiabilities = value;
    }

    /**
     * 获取workingCapital属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getWorkingCapital() {
        return workingCapital;
    }

    /**
     * 设置workingCapital属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setWorkingCapital(FinancialValueDecimal value) {
        this.workingCapital = value;
    }

    /**
     * 获取netWorth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getNetWorth() {
        return netWorth;
    }

    /**
     * 设置netWorth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setNetWorth(FinancialValueDecimal value) {
        this.netWorth = value;
    }

}
