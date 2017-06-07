
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>PortfolioCompanyAdditionResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PortfolioCompanyAdditionResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes}ServiceResponse"&gt;
 *       &lt;attribute name="TotalCompanies" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="SuccessfullyAddedCompanies" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *       &lt;attribute name="NewCompanies" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PortfolioCompanyAdditionResult")
public class PortfolioCompanyAdditionResult
    extends ServiceResponse implements Serializable
{

    @XmlAttribute(name = "TotalCompanies", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long totalCompanies;
    @XmlAttribute(name = "SuccessfullyAddedCompanies", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long successfullyAddedCompanies;
    @XmlAttribute(name = "NewCompanies", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long newCompanies;

    /**
     * 获取totalCompanies属性的值。
     * 
     */
    public long getTotalCompanies() {
        return totalCompanies;
    }

    /**
     * 设置totalCompanies属性的值。
     * 
     */
    public void setTotalCompanies(long value) {
        this.totalCompanies = value;
    }

    /**
     * 获取successfullyAddedCompanies属性的值。
     * 
     */
    public long getSuccessfullyAddedCompanies() {
        return successfullyAddedCompanies;
    }

    /**
     * 设置successfullyAddedCompanies属性的值。
     * 
     */
    public void setSuccessfullyAddedCompanies(long value) {
        this.successfullyAddedCompanies = value;
    }

    /**
     * 获取newCompanies属性的值。
     * 
     */
    public long getNewCompanies() {
        return newCompanies;
    }

    /**
     * 设置newCompanies属性的值。
     * 
     */
    public void setNewCompanies(long value) {
        this.newCompanies = value;
    }

}
