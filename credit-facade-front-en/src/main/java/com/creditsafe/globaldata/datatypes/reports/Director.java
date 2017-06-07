
package com.creditsafe.globaldata.datatypes.reports;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Director complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Director"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes/reports}Entity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Gender" type="{http://www.creditsafe.com/globaldata/datatypes/reports}Gender"/&gt;
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="Position" type="{http://www.creditsafe.com/globaldata/datatypes/reports}CorporatePosition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Director", propOrder = {
    "gender",
    "dateOfBirth",
    "position"
})
@XmlSeeAlso({
    PreviousDirector.class
})
public class Director
    extends Entity implements Serializable
{

    @XmlElement(name = "Gender")
    @XmlSchemaType(name = "unsignedInt")
    protected long gender;
    @XmlElement(name = "DateOfBirth")
    protected String dateOfBirth;
    @XmlElement(name = "Position")
    protected List<CorporatePosition> position;

    /**
     * 获取gender属性的值。
     * 
     */
    public long getGender() {
        return gender;
    }

    /**
     * 设置gender属性的值。
     * 
     */
    public void setGender(long value) {
        this.gender = value;
    }

    /**
     * 获取dateOfBirth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 设置dateOfBirth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBirth(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.dateOfBirth = jsonObject.getString("year");
            this.dateOfBirth = value.substring(0,10);
        }else{
            this.dateOfBirth = value;
        }
    }

    /**
     * Gets the value of the position property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the position property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CorporatePosition }
     * 
     * 
     */
    public List<CorporatePosition> getPosition() {
        if (position == null) {
            position = new ArrayList<CorporatePosition>();
        }
        return this.position;
    }

}
