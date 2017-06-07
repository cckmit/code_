
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>QueryMatchType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="QueryMatchType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="MatchBeginning"/&gt;
 *     &lt;enumeration value="MatchBlock"/&gt;
 *     &lt;enumeration value="MatchAnyParts"/&gt;
 *     &lt;enumeration value="MatchWords"/&gt;
 *     &lt;enumeration value="MatchBlockOrWords"/&gt;
 *     &lt;enumeration value="ExactValue"/&gt;
 *     &lt;enumeration value="ClosestKeywords"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "QueryMatchType")
@XmlEnum
public enum QueryMatchType implements Serializable {

    @XmlEnumValue("MatchBeginning")
    MATCH_BEGINNING("MatchBeginning"),
    @XmlEnumValue("MatchBlock")
    MATCH_BLOCK("MatchBlock"),
    @XmlEnumValue("MatchAnyParts")
    MATCH_ANY_PARTS("MatchAnyParts"),
    @XmlEnumValue("MatchWords")
    MATCH_WORDS("MatchWords"),
    @XmlEnumValue("MatchBlockOrWords")
    MATCH_BLOCK_OR_WORDS("MatchBlockOrWords"),
    @XmlEnumValue("ExactValue")
    EXACT_VALUE("ExactValue"),
    @XmlEnumValue("ClosestKeywords")
    CLOSEST_KEYWORDS("ClosestKeywords");
    private final String value;

    QueryMatchType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QueryMatchType fromValue(String v) {
        for (QueryMatchType c: QueryMatchType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
