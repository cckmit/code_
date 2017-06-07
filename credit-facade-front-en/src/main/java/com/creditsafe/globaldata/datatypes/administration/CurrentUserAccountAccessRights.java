
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.ServiceResponse;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>CurrentUserAccountAccessRights complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CurrentUserAccountAccessRights"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccessRights" type="{http://www.creditsafe.com/globaldata/datatypes/administration}UserAccountAccessRights" minOccurs="0"/&gt;
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
@XmlType(name = "CurrentUserAccountAccessRights", propOrder = {
    "accessRights"
})
public class CurrentUserAccountAccessRights
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "AccessRights")
    protected UserAccountAccessRights accessRights;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long id;

    /**
     * 获取accessRights属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UserAccountAccessRights }
     *     
     */
    public UserAccountAccessRights getAccessRights() {
        return accessRights;
    }

    /**
     * 设置accessRights属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UserAccountAccessRights }
     *     
     */
    public void setAccessRights(UserAccountAccessRights value) {
        this.accessRights = value;
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
