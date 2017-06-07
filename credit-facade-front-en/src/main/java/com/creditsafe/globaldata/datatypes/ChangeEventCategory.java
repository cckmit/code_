
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>ChangeEventCategory的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ChangeEventCategory"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="SimpleEvent"/&gt;
 *     &lt;enumeration value="TextValueChangeEvent"/&gt;
 *     &lt;enumeration value="NumericValueChangeEvent"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ChangeEventCategory")
@XmlEnum
public enum ChangeEventCategory implements Serializable {

    @XmlEnumValue("SimpleEvent")
    SIMPLE_EVENT("SimpleEvent"),
    @XmlEnumValue("TextValueChangeEvent")
    TEXT_VALUE_CHANGE_EVENT("TextValueChangeEvent"),
    @XmlEnumValue("NumericValueChangeEvent")
    NUMERIC_VALUE_CHANGE_EVENT("NumericValueChangeEvent");
    private final String value;

    ChangeEventCategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChangeEventCategory fromValue(String v) {
        for (ChangeEventCategory c: ChangeEventCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
