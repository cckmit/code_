
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>CompanyType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="CompanyType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="Ltd"/&gt;
 *     &lt;enumeration value="NonLtd"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CompanyType")
@XmlEnum
public enum CompanyType implements Serializable {

    @XmlEnumValue("Ltd")
    LTD("Ltd"),
    @XmlEnumValue("NonLtd")
    NON_LTD("NonLtd");
    private final String value;

    CompanyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CompanyType fromValue(String v) {
        for (CompanyType c: CompanyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
