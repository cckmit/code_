
package com.creditsafe.globaldata.datatypes.reports;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>PreviousDirector complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PreviousDirector"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes/reports}Director"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResignationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreviousDirector", propOrder = {
    "resignationDate"
})
public class PreviousDirector
    extends Director implements Serializable
{

    @XmlElement(name = "ResignationDate")
    protected String resignationDate;

    /**
     * 获取resignationDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResignationDate() {
        return resignationDate;
    }

    /**
     * 设置resignationDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResignationDate(String value) {
        if (StringUtil.isNotNull(value)){
            this.resignationDate = value.substring(0,10);

//            JSONObject jsonObject = JSON.parseObject(value);
//            this.resignationDate = jsonObject.getString("year");
        }else{
            this.resignationDate = value;
        }
    }

}
