
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>FileFormat的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="FileFormat"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="Xml"/&gt;
 *     &lt;enumeration value="Csv"/&gt;
 *     &lt;enumeration value="Json"/&gt;
 *     &lt;enumeration value="Xls"/&gt;
 *     &lt;enumeration value="Pdf"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FileFormat")
@XmlEnum
public enum FileFormat implements Serializable {

    @XmlEnumValue("Xml")
    XML("Xml"),
    @XmlEnumValue("Csv")
    CSV("Csv"),
    @XmlEnumValue("Json")
    JSON("Json"),
    @XmlEnumValue("Xls")
    XLS("Xls"),
    @XmlEnumValue("Pdf")
    PDF("Pdf");
    private final String value;

    FileFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FileFormat fromValue(String v) {
        for (FileFormat c: FileFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
