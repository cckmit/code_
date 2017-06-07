
package com.creditsafe.globaldata.datatypes.reports;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.creditsafe.globaldata.datatypes.Currency;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>FinancialYearReport complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FinancialYearReport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="YearEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="NumberOfWeeks" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="Currency" type="{http://www.creditsafe.com/globaldata/datatypes}Currency"/&gt;
 *         &lt;element name="ConsolidatedAccounts" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialYearReport", propOrder = {
    "yearEndDate",
    "numberOfWeeks",
    "currency",
    "consolidatedAccounts"
})
@XmlSeeAlso({
    LtdFinancialStatement.class
})
public class FinancialYearReport implements Serializable {

    @XmlElement(name = "YearEndDate", required = true)
    protected String yearEndDate;
    @XmlElement(name = "NumberOfWeeks")
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberOfWeeks;
    @XmlElement(name = "Currency", required = true)
    @XmlSchemaType(name = "string")
    protected Currency currency;
    @XmlElement(name = "ConsolidatedAccounts")
    protected Boolean consolidatedAccounts;

    /**
     * 获取yearEndDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYearEndDate() {
        return yearEndDate;
    }

    /**
     * 设置yearEndDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYearEndDate(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.yearEndDate = jsonObject.getString("year");
            this.yearEndDate = value.substring(0,10);
        }else{
            this.yearEndDate = value;
        }
    }

    /**
     * 获取numberOfWeeks属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumberOfWeeks() {
        return numberOfWeeks;
    }

    /**
     * 设置numberOfWeeks属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumberOfWeeks(Long value) {
        this.numberOfWeeks = value;
    }

    /**
     * 获取currency属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * 设置currency属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCurrency(Currency value) {
        this.currency = value;
    }

    /**
     * 获取consolidatedAccounts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConsolidatedAccounts() {
        return consolidatedAccounts;
    }

    /**
     * 设置consolidatedAccounts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConsolidatedAccounts(Boolean value) {
        this.consolidatedAccounts = value;
    }

}
