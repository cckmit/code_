
package systemtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>System.ServiceModel.HttpProxyCredentialType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="System.ServiceModel.HttpProxyCredentialType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="Basic"/&gt;
 *     &lt;enumeration value="Digest"/&gt;
 *     &lt;enumeration value="Ntlm"/&gt;
 *     &lt;enumeration value="Windows"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "System.ServiceModel.HttpProxyCredentialType", namespace = "systemtypes")
@XmlEnum
public enum SystemServiceModelHttpProxyCredentialType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Basic")
    BASIC("Basic"),
    @XmlEnumValue("Digest")
    DIGEST("Digest"),
    @XmlEnumValue("Ntlm")
    NTLM("Ntlm"),
    @XmlEnumValue("Windows")
    WINDOWS("Windows");
    private final String value;

    SystemServiceModelHttpProxyCredentialType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemServiceModelHttpProxyCredentialType fromValue(String v) {
        for (SystemServiceModelHttpProxyCredentialType c: SystemServiceModelHttpProxyCredentialType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
