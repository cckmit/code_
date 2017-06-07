
package systemtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>System.ServiceModel.Security.X509CertificateValidationMode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="System.ServiceModel.Security.X509CertificateValidationMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="PeerTrust"/&gt;
 *     &lt;enumeration value="ChainTrust"/&gt;
 *     &lt;enumeration value="PeerOrChainTrust"/&gt;
 *     &lt;enumeration value="Custom"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "System.ServiceModel.Security.X509CertificateValidationMode", namespace = "systemtypes")
@XmlEnum
public enum SystemServiceModelSecurityX509CertificateValidationMode {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("PeerTrust")
    PEER_TRUST("PeerTrust"),
    @XmlEnumValue("ChainTrust")
    CHAIN_TRUST("ChainTrust"),
    @XmlEnumValue("PeerOrChainTrust")
    PEER_OR_CHAIN_TRUST("PeerOrChainTrust"),
    @XmlEnumValue("Custom")
    CUSTOM("Custom");
    private final String value;

    SystemServiceModelSecurityX509CertificateValidationMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemServiceModelSecurityX509CertificateValidationMode fromValue(String v) {
        for (SystemServiceModelSecurityX509CertificateValidationMode c: SystemServiceModelSecurityX509CertificateValidationMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
