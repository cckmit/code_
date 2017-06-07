
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>ContractType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ContractType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="PrePaid"/&gt;
 *     &lt;enumeration value="PayAsYouGo"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ContractType")
@XmlEnum
public enum ContractType implements Serializable {

    @XmlEnumValue("PrePaid")
    PRE_PAID("PrePaid"),
    @XmlEnumValue("PayAsYouGo")
    PAY_AS_YOU_GO("PayAsYouGo");
    private final String value;

    ContractType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContractType fromValue(String v) {
        for (ContractType c: ContractType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
