
package systemtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>System.ServiceModel.HttpClientCredentialType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="System.ServiceModel.HttpClientCredentialType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="Basic"/&gt;
 *     &lt;enumeration value="Digest"/&gt;
 *     &lt;enumeration value="Ntlm"/&gt;
 *     &lt;enumeration value="Windows"/&gt;
 *     &lt;enumeration value="Certificate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "System.ServiceModel.HttpClientCredentialType", namespace = "systemtypes")
@XmlEnum
public enum SystemServiceModelHttpClientCredentialType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Basic")
    BASIC("Basic"),
    @XmlEnumValue("Digest")
    DIGEST("Digest"),
    @XmlEnumValue("Ntlm")
    NTLM("Ntlm"),
    @XmlEnumValue("Windows")
    WINDOWS("Windows"),
    @XmlEnumValue("Certificate")
    CERTIFICATE("Certificate");
    private final String value;

    SystemServiceModelHttpClientCredentialType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemServiceModelHttpClientCredentialType fromValue(String v) {
        for (SystemServiceModelHttpClientCredentialType c: SystemServiceModelHttpClientCredentialType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
