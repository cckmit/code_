
package com.creditsafe.globaldata.datatypes;

import com.creditsafe.globaldata.datatypes.administration.*;
import com.creditsafe.globaldata.datatypes.reports.CompanyReportSet;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ServiceResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServiceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Messages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Message" type="{http://www.creditsafe.com/globaldata/datatypes}Message" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceResponse", propOrder = {
    "messages"
})
@XmlSeeAlso({
    CompanyReportSet.class,
    PortfoliosList.class,
    MonitoredCompaniesList.class,
    SimpleResult.class,
    CurrentPortfolioSettings.class,
    PortfolioCompanyAdditionResult.class,
    PortfolioCompanyRemovalResult.class,
    SupportedChangeEventsList.class,
    CurrentPortfolioMonitoringRules.class,
    ReportOrder.class,
    ReportboxContents.class,
    CountriesList.class,
    SearchCriteriaSchemaSet.class,
    CompaniesList.class,
    CustomDataSchema.class,
    ChangeEventsBasicParamsList.class,
    PortfolioRemovalResult.class,
    CompanyChangesList.class,
    CurrentUserAccountAccessRights.class,
    CurrentProviderServicesSettings.class,
    CurrentDataSourceSettings.class,
    UserAccountActivityLog.class,
    DataSourcesReport.class,
    CurrentCustomerSettings.class,
    UserAccountsList.class,
    CustomersList.class,
    CurrentUserAccountSettings.class,
    SystemStatusSummary.class,
    FullSystemReport.class
})
public abstract class ServiceResponse implements Serializable {

    @XmlElement(name = "Messages")
    protected Messages messages;

    /**
     * 获取messages属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Messages }
     *     
     */
    public Messages getMessages() {
        return messages;
    }

    /**
     * 设置messages属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Messages }
     *     
     */
    public void setMessages(Messages value) {
        this.messages = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Message" type="{http://www.creditsafe.com/globaldata/datatypes}Message" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "message"
    })
    public static class Messages implements Serializable{

        @XmlElement(name = "Message")
        protected List<Message> message;

        /**
         * Gets the value of the message property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the message property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMessage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Message }
         * 
         * 
         */
        public List<Message> getMessage() {
            if (message == null) {
                message = new ArrayList<Message>();
            }
            return this.message;
        }

    }

}
