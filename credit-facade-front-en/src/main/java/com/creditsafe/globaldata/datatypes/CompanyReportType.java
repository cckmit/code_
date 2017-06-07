
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>CompanyReportType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="CompanyReportType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="Basic"/&gt;
 *     &lt;enumeration value="Full"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CompanyReportType")
@XmlEnum
public enum CompanyReportType implements Serializable {

    @XmlEnumValue("Basic")
    BASIC("Basic"),
    @XmlEnumValue("Full")
    FULL("Full");
    private final String value;

    CompanyReportType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CompanyReportType fromValue(String v) {
        for (CompanyReportType c: CompanyReportType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
