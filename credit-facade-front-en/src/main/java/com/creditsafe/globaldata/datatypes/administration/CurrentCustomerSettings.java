
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.ServiceResponse;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>CurrentCustomerSettings complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CurrentCustomerSettings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Settings" type="{http://www.creditsafe.com/globaldata/datatypes/administration}CustomerSettings" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentCustomerSettings", propOrder = {
    "settings"
})
public class CurrentCustomerSettings
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "Settings")
    protected CustomerSettings settings;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long id;

    /**
     * 获取settings属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustomerSettings }
     *     
     */
    public CustomerSettings getSettings() {
        return settings;
    }

    /**
     * 设置settings属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerSettings }
     *     
     */
    public void setSettings(CustomerSettings value) {
        this.settings = value;
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

}
