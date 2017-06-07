
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.ServiceResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>CurrentProviderServicesSettings complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CurrentProviderServicesSettings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Settings" type="{http://www.creditsafe.com/globaldata/datatypes/administration}ProviderServicesSettings" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentProviderServicesSettings", propOrder = {
    "settings"
})
public class CurrentProviderServicesSettings
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "Settings")
    protected ProviderServicesSettings settings;

    /**
     * 获取settings属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ProviderServicesSettings }
     *     
     */
    public ProviderServicesSettings getSettings() {
        return settings;
    }

    /**
     * 设置settings属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderServicesSettings }
     *     
     */
    public void setSettings(ProviderServicesSettings value) {
        this.settings = value;
    }

}
