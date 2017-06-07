
package systemtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>System.ServiceModel.SecurityMode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="System.ServiceModel.SecurityMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="Transport"/&gt;
 *     &lt;enumeration value="Message"/&gt;
 *     &lt;enumeration value="TransportWithMessageCredential"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "System.ServiceModel.SecurityMode", namespace = "systemtypes")
@XmlEnum
public enum SystemServiceModelSecurityMode {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Transport")
    TRANSPORT("Transport"),
    @XmlEnumValue("Message")
    MESSAGE("Message"),
    @XmlEnumValue("TransportWithMessageCredential")
    TRANSPORT_WITH_MESSAGE_CREDENTIAL("TransportWithMessageCredential");
    private final String value;

    SystemServiceModelSecurityMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemServiceModelSecurityMode fromValue(String v) {
        for (SystemServiceModelSecurityMode c: SystemServiceModelSecurityMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
