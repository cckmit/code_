
package systemtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>System.ServiceModel.MessageCredentialType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="System.ServiceModel.MessageCredentialType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="Windows"/&gt;
 *     &lt;enumeration value="UserName"/&gt;
 *     &lt;enumeration value="Certificate"/&gt;
 *     &lt;enumeration value="IssuedToken"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "System.ServiceModel.MessageCredentialType", namespace = "systemtypes")
@XmlEnum
public enum SystemServiceModelMessageCredentialType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Windows")
    WINDOWS("Windows"),
    @XmlEnumValue("UserName")
    USER_NAME("UserName"),
    @XmlEnumValue("Certificate")
    CERTIFICATE("Certificate"),
    @XmlEnumValue("IssuedToken")
    ISSUED_TOKEN("IssuedToken");
    private final String value;

    SystemServiceModelMessageCredentialType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemServiceModelMessageCredentialType fromValue(String v) {
        for (SystemServiceModelMessageCredentialType c: SystemServiceModelMessageCredentialType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
