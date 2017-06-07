
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>ExternalProduct的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ExternalProduct"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="WhiteLabel"/&gt;
 *     &lt;enumeration value="Mobile"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExternalProduct")
@XmlEnum
public enum ExternalProduct implements Serializable {

    @XmlEnumValue("WhiteLabel")
    WHITE_LABEL("WhiteLabel"),
    @XmlEnumValue("Mobile")
    MOBILE("Mobile");
    private final String value;

    ExternalProduct(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExternalProduct fromValue(String v) {
        for (ExternalProduct c: ExternalProduct.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
