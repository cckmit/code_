
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>ChangeEventDescription complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ChangeEventDescription"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ChangeEventBasicParams"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Category" use="required" type="{http://www.creditsafe.com/globaldata/datatypes}ChangeEventCategory" /&gt;
 *       &lt;attribute name="CanBeMonitored" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeEventDescription", propOrder = {
    "description"
})
public class ChangeEventDescription
    extends ChangeEventBasicParams implements Serializable
{

    @XmlElement(name = "Description")
    protected String description;
    @XmlAttribute(name = "Category", required = true)
    protected ChangeEventCategory category;
    @XmlAttribute(name = "CanBeMonitored", required = true)
    protected boolean canBeMonitored;

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取category属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChangeEventCategory }
     *     
     */
    public ChangeEventCategory getCategory() {
        return category;
    }

    /**
     * 设置category属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeEventCategory }
     *     
     */
    public void setCategory(ChangeEventCategory value) {
        this.category = value;
    }

    /**
     * 获取canBeMonitored属性的值。
     * 
     */
    public boolean isCanBeMonitored() {
        return canBeMonitored;
    }

    /**
     * 设置canBeMonitored属性的值。
     * 
     */
    public void setCanBeMonitored(boolean value) {
        this.canBeMonitored = value;
    }

}
