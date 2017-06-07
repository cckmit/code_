
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>EndpointIdentityType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="EndpointIdentityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="Dns"/&gt;
 *     &lt;enumeration value="Rsa"/&gt;
 *     &lt;enumeration value="Spn"/&gt;
 *     &lt;enumeration value="Upn"/&gt;
 *     &lt;enumeration value="X509"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EndpointIdentityType")
@XmlEnum
public enum EndpointIdentityType implements Serializable {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Dns")
    DNS("Dns"),
    @XmlEnumValue("Rsa")
    RSA("Rsa"),
    @XmlEnumValue("Spn")
    SPN("Spn"),
    @XmlEnumValue("Upn")
    UPN("Upn"),
    @XmlEnumValue("X509")
    X_509("X509");
    private final String value;

    EndpointIdentityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EndpointIdentityType fromValue(String v) {
        for (EndpointIdentityType c: EndpointIdentityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
