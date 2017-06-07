
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>SearchCriteriaSchema.QueryStringSchema complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SearchCriteriaSchema.QueryStringSchema"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}SearchCriteriaSchema.ValueSchema_String"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AllowedMatchTypes"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AllowedMatchType" type="{http://www.creditsafe.com/globaldata/datatypes}QueryMatchType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchCriteriaSchema.QueryStringSchema", propOrder = {
    "allowedMatchTypes"
})
public class SearchCriteriaSchemaQueryStringSchema
    extends SearchCriteriaSchemaValueSchemaString implements Serializable
{

    @XmlElement(name = "AllowedMatchTypes", required = true)
    protected AllowedMatchTypes allowedMatchTypes;

    /**
     * 获取allowedMatchTypes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AllowedMatchTypes }
     *     
     */
    public AllowedMatchTypes getAllowedMatchTypes() {
        return allowedMatchTypes;
    }

    /**
     * 设置allowedMatchTypes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedMatchTypes }
     *     
     */
    public void setAllowedMatchTypes(AllowedMatchTypes value) {
        this.allowedMatchTypes = value;
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
     *         &lt;element name="AllowedMatchType" type="{http://www.creditsafe.com/globaldata/datatypes}QueryMatchType" maxOccurs="unbounded"/&gt;
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
        "allowedMatchType"
    })
    public static class AllowedMatchTypes {

        @XmlElement(name = "AllowedMatchType", required = true)
        @XmlSchemaType(name = "string")
        protected List<QueryMatchType> allowedMatchType;

        /**
         * Gets the value of the allowedMatchType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the allowedMatchType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAllowedMatchType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QueryMatchType }
         * 
         * 
         */
        public List<QueryMatchType> getAllowedMatchType() {
            if (allowedMatchType == null) {
                allowedMatchType = new ArrayList<QueryMatchType>();
            }
            return this.allowedMatchType;
        }

    }

}
