
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>OfficeType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="OfficeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="Registered"/&gt;
 *     &lt;enumeration value="Trading"/&gt;
 *     &lt;enumeration value="HeadOffice"/&gt;
 *     &lt;enumeration value="Branch"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OfficeType")
@XmlEnum
public enum OfficeType implements Serializable {

    @XmlEnumValue("Registered")
    REGISTERED("Registered"),
    @XmlEnumValue("Trading")
    TRADING("Trading"),
    @XmlEnumValue("HeadOffice")
    HEAD_OFFICE("HeadOffice"),
    @XmlEnumValue("Branch")
    BRANCH("Branch");
    private final String value;

    OfficeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OfficeType fromValue(String v) {
        for (OfficeType c: OfficeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
