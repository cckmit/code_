
package com.creditsafe.globaldata.datatypes.administration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>CreditsafeEntity的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="CreditsafeEntity"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="INT"/&gt;
 *     &lt;enumeration value="CSUK"/&gt;
 *     &lt;enumeration value="CSDE"/&gt;
 *     &lt;enumeration value="CSFR"/&gt;
 *     &lt;enumeration value="CSNL"/&gt;
 *     &lt;enumeration value="CSBE"/&gt;
 *     &lt;enumeration value="CSIE"/&gt;
 *     &lt;enumeration value="CSSE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CreditsafeEntity")
@XmlEnum
public enum CreditsafeEntity implements Serializable {

    INT,
    CSUK,
    CSDE,
    CSFR,
    CSNL,
    CSBE,
    CSIE,
    CSSE;

    public String value() {
        return name();
    }

    public static CreditsafeEntity fromValue(String v) {
        return valueOf(v);
    }

}
