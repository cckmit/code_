
package com.creditsafe.globaldata.datatypes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.util.StringUtil;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>CurrentPortfolioSettings complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CurrentPortfolioSettings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Settings" type="{http://www.creditsafe.com/globaldata/datatypes}PortfolioSettings" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PortfolioId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="CreationDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="LastSettingsChangeDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentPortfolioSettings", propOrder = {
    "settings"
})
public class CurrentPortfolioSettings
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "Settings")
    protected PortfolioSettings settings;
    @XmlAttribute(name = "PortfolioId")
    @XmlSchemaType(name = "unsignedInt")
    protected Long portfolioId;
    @XmlAttribute(name = "CreationDate", required = true)
    protected String creationDate;
    @XmlAttribute(name = "LastSettingsChangeDate", required = true)
    protected String lastSettingsChangeDate;

    /**
     * 获取settings属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PortfolioSettings }
     *     
     */
    public PortfolioSettings getSettings() {
        return settings;
    }

    /**
     * 设置settings属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PortfolioSettings }
     *     
     */
    public void setSettings(PortfolioSettings value) {
        this.settings = value;
    }

    /**
     * 获取portfolioId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPortfolioId() {
        return portfolioId;
    }

    /**
     * 设置portfolioId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPortfolioId(Long value) {
        this.portfolioId = value;
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
