
package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>PreviousLegalForm complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PreviousLegalForm"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.creditsafe.com/globaldata/datatypes/reports}PreviousValue"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LegalForm" type="{http://www.creditsafe.com/globaldata/datatypes/reports}LegalForm"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreviousLegalForm", propOrder = {
    "legalForm"
})
public class PreviousLegalForm
    extends PreviousValue implements Serializable
{

    @XmlElement(name = "LegalForm", required = true)
    protected LegalForm legalForm;

    /**
     * 获取legalForm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LegalForm }
     *     
     */
    public LegalForm getLegalForm() {
        return legalForm;
    }

    /**
     * 设置legalForm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LegalForm }
     *     
     */
    public void setLegalForm(LegalForm value) {
        this.legalForm = value;
    }

}
