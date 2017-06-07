
package com.creditsafe.globaldata.datatypes.reports;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>LtdCreditScore complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LtdCreditScore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CurrentCreditRating" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CreditRating"/&gt;
 *         &lt;element name="CurrentContractLimit" type="{http://www.creditsafe.com/globaldata/datatypes/reports}FinancialValue_Decimal" minOccurs="0"/&gt;
 *         &lt;element name="PreviousCreditRating" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CreditRating" minOccurs="0"/&gt;
 *         &lt;element name="DateOfLatestRatingChange" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LtdCreditScore", propOrder = {
    "currentCreditRating",
    "currentContractLimit",
    "previousCreditRating",
    "dateOfLatestRatingChange"
})
public class LtdCreditScore implements Serializable {

    @XmlElement(name = "CurrentCreditRating", required = true)
    protected CreditRating currentCreditRating;
    @XmlElement(name = "CurrentContractLimit")
    protected FinancialValueDecimal currentContractLimit;
    @XmlElement(name = "PreviousCreditRating")
    protected CreditRating previousCreditRating;
    @XmlElement(name = "DateOfLatestRatingChange")
    protected String dateOfLatestRatingChange;

    /**
     * 获取currentCreditRating属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditRating }
     *     
     */
    public CreditRating getCurrentCreditRating() {
        return currentCreditRating;
    }

    /**
     * 设置currentCreditRating属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditRating }
     *     
     */
    public void setCurrentCreditRating(CreditRating value) {
        this.currentCreditRating = value;
    }

    /**
     * 获取currentContractLimit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public FinancialValueDecimal getCurrentContractLimit() {
        return currentContractLimit;
    }

    /**
     * 设置currentContractLimit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialValueDecimal }
     *     
     */
    public void setCurrentContractLimit(FinancialValueDecimal value) {
        this.currentContractLimit = value;
    }

    /**
     * 获取previousCreditRating属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditRating }
     *     
     */
    public CreditRating getPreviousCreditRating() {
        return previousCreditRating;
    }

    /**
     * 设置previousCreditRating属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditRating }
     *     
     */
    public void setPreviousCreditRating(CreditRating value) {
        this.previousCreditRating = value;
    }

    /**
     * 获取dateOfLatestRatingChange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfLatestRatingChange() {
        return dateOfLatestRatingChange;
    }

    /**
     * 设置dateOfLatestRatingChange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfLatestRatingChange(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.dateOfLatestRatingChange = jsonObject.getString("year");
            this.dateOfLatestRatingChange = value.substring(0,10);

        }else{
            this.dateOfLatestRatingChange = value;
        }
    }

}
