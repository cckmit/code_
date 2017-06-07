
package com.creditsafe.globaldata.datatypes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>Portfolio complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Portfolio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChangedCompanies" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="MonitoredCompanies" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="Enabled" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CreationDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="LastSettingsChangeDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Portfolio", propOrder = {
    "changedCompanies",
    "monitoredCompanies"
})
public class Portfolio implements Serializable {

    @XmlElement(name = "ChangedCompanies")
    @XmlSchemaType(name = "unsignedInt")
    protected long changedCompanies;
    @XmlElement(name = "MonitoredCompanies")
    @XmlSchemaType(name = "unsignedInt")
    protected long monitoredCompanies;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long id;
    @XmlAttribute(name = "Enabled", required = true)
    protected boolean enabled;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "CreationDate", required = true)
    protected String creationDate;
    @XmlAttribute(name = "LastSettingsChangeDate", required = true)
    protected String lastSettingsChangeDate;

    /**
     * 获取changedCompanies属性的值。
     * 
     */
    public long getChangedCompanies() {
        return changedCompanies;
    }

    /**
     * 设置changedCompanies属性的值。
     * 
     */
    public void setChangedCompanies(long value) {
        this.changedCompanies = value;
    }

    /**
     * 获取monitoredCompanies属性的值。
     * 
     */
    public long getMonitoredCompanies() {
        return monitoredCompanies;
    }

    /**
     * 设置monitoredCompanies属性的值。
     * 
     */
    public void setMonitoredCompanies(long value) {
        this.monitoredCompanies = value;
    }

    /**
     * 获取id属性的值。
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * 获取enabled属性的值。
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置enabled属性的值。
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取creationDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * 设置creationDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.creationDate = jsonObject.getString("year");
            this.creationDate = value.substring(0,10);

        }else{
            this.creationDate = value;
        }
    }

    /**
     * 获取lastSettingsChangeDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastSettingsChangeDate() {
        return lastSettingsChangeDate;
    }

    /**
     * 设置lastSettingsChangeDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastSettingsChangeDate(String value) {
        if (StringUtil.isNotNull(value)){
//            JSONObject jsonObject = JSON.parseObject(value);
//            this.lastSettingsChangeDate = jsonObject.getString("year");
            this.lastSettingsChangeDate = value.substring(0,10);

        }else{
            this.lastSettingsChangeDate = value;
        }
    }

}
