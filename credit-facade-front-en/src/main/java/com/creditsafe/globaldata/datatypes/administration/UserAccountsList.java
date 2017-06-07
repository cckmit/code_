
package com.creditsafe.globaldata.datatypes.administration;

import com.creditsafe.globaldata.datatypes.ServiceResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>UserAccountsList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UserAccountsList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UserAccount" type="{http://www.creditsafe.com/globaldata/datatypes/administration}UserAccountOverview" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccountsList", propOrder = {
    "userAccount"
})
public class UserAccountsList
    extends ServiceResponse implements Serializable
{

    @XmlElement(name = "UserAccount")
    protected List<UserAccountOverview> userAccount;

    /**
     * Gets the value of the userAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserAccountOverview }
     * 
     * 
     */
    public List<UserAccountOverview> getUserAccount() {
        if (userAccount == null) {
            userAccount = new ArrayList<UserAccountOverview>();
        }
        return this.userAccount;
    }

}
