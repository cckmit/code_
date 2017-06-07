
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>Language的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Language"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="OM"/&gt;
 *     &lt;enumeration value="AB"/&gt;
 *     &lt;enumeration value="AA"/&gt;
 *     &lt;enumeration value="AF"/&gt;
 *     &lt;enumeration value="SQ"/&gt;
 *     &lt;enumeration value="AM"/&gt;
 *     &lt;enumeration value="AR"/&gt;
 *     &lt;enumeration value="HY"/&gt;
 *     &lt;enumeration value="AS"/&gt;
 *     &lt;enumeration value="AY"/&gt;
 *     &lt;enumeration value="AZ"/&gt;
 *     &lt;enumeration value="BA"/&gt;
 *     &lt;enumeration value="EU"/&gt;
 *     &lt;enumeration value="BN"/&gt;
 *     &lt;enumeration value="DZ"/&gt;
 *     &lt;enumeration value="BH"/&gt;
 *     &lt;enumeration value="BI"/&gt;
 *     &lt;enumeration value="BR"/&gt;
 *     &lt;enumeration value="BG"/&gt;
 *     &lt;enumeration value="MY"/&gt;
 *     &lt;enumeration value="BE"/&gt;
 *     &lt;enumeration value="KM"/&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="ZH"/&gt;
 *     &lt;enumeration value="CO"/&gt;
 *     &lt;enumeration value="HR"/&gt;
 *     &lt;enumeration value="CS"/&gt;
 *     &lt;enumeration value="DA"/&gt;
 *     &lt;enumeration value="NL"/&gt;
 *     &lt;enumeration value="EN"/&gt;
 *     &lt;enumeration value="EO"/&gt;
 *     &lt;enumeration value="ET"/&gt;
 *     &lt;enumeration value="FO"/&gt;
 *     &lt;enumeration value="FJ"/&gt;
 *     &lt;enumeration value="FI"/&gt;
 *     &lt;enumeration value="FR"/&gt;
 *     &lt;enumeration value="FY"/&gt;
 *     &lt;enumeration value="GL"/&gt;
 *     &lt;enumeration value="KA"/&gt;
 *     &lt;enumeration value="DE"/&gt;
 *     &lt;enumeration value="EL"/&gt;
 *     &lt;enumeration value="KL"/&gt;
 *     &lt;enumeration value="GN"/&gt;
 *     &lt;enumeration value="GU"/&gt;
 *     &lt;enumeration value="HA"/&gt;
 *     &lt;enumeration value="HE"/&gt;
 *     &lt;enumeration value="HI"/&gt;
 *     &lt;enumeration value="HU"/&gt;
 *     &lt;enumeration value="IS"/&gt;
 *     &lt;enumeration value="ID"/&gt;
 *     &lt;enumeration value="IA"/&gt;
 *     &lt;enumeration value="IE"/&gt;
 *     &lt;enumeration value="IK"/&gt;
 *     &lt;enumeration value="IU"/&gt;
 *     &lt;enumeration value="GA"/&gt;
 *     &lt;enumeration value="IT"/&gt;
 *     &lt;enumeration value="JA"/&gt;
 *     &lt;enumeration value="JW"/&gt;
 *     &lt;enumeration value="KN"/&gt;
 *     &lt;enumeration value="KS"/&gt;
 *     &lt;enumeration value="KK"/&gt;
 *     &lt;enumeration value="RW"/&gt;
 *     &lt;enumeration value="KY"/&gt;
 *     &lt;enumeration value="RN"/&gt;
 *     &lt;enumeration value="KO"/&gt;
 *     &lt;enumeration value="KU"/&gt;
 *     &lt;enumeration value="LO"/&gt;
 *     &lt;enumeration value="LA"/&gt;
 *     &lt;enumeration value="LV"/&gt;
 *     &lt;enumeration value="LN"/&gt;
 *     &lt;enumeration value="LT"/&gt;
 *     &lt;enumeration value="MK"/&gt;
 *     &lt;enumeration value="MG"/&gt;
 *     &lt;enumeration value="MS"/&gt;
 *     &lt;enumeration value="ML"/&gt;
 *     &lt;enumeration value="MT"/&gt;
 *     &lt;enumeration value="MI"/&gt;
 *     &lt;enumeration value="MR"/&gt;
 *     &lt;enumeration value="MO"/&gt;
 *     &lt;enumeration value="MN"/&gt;
 *     &lt;enumeration value="NA"/&gt;
 *     &lt;enumeration value="NE"/&gt;
 *     &lt;enumeration value="NO"/&gt;
 *     &lt;enumeration value="OC"/&gt;
 *     &lt;enumeration value="OR"/&gt;
 *     &lt;enumeration value="PS"/&gt;
 *     &lt;enumeration value="FA"/&gt;
 *     &lt;enumeration value="PL"/&gt;
 *     &lt;enumeration value="PT"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *     &lt;enumeration value="QU"/&gt;
 *     &lt;enumeration value="RM"/&gt;
 *     &lt;enumeration value="RO"/&gt;
 *     &lt;enumeration value="RU"/&gt;
 *     &lt;enumeration value="SM"/&gt;
 *     &lt;enumeration value="SG"/&gt;
 *     &lt;enumeration value="SA"/&gt;
 *     &lt;enumeration value="GD"/&gt;
 *     &lt;enumeration value="SR"/&gt;
 *     &lt;enumeration value="SH"/&gt;
 *     &lt;enumeration value="ST"/&gt;
 *     &lt;enumeration value="TN"/&gt;
 *     &lt;enumeration value="SN"/&gt;
 *     &lt;enumeration value="SD"/&gt;
 *     &lt;enumeration value="SI"/&gt;
 *     &lt;enumeration value="SS"/&gt;
 *     &lt;enumeration value="SK"/&gt;
 *     &lt;enumeration value="SL"/&gt;
 *     &lt;enumeration value="SO"/&gt;
 *     &lt;enumeration value="ES"/&gt;
 *     &lt;enumeration value="SU"/&gt;
 *     &lt;enumeration value="SW"/&gt;
 *     &lt;enumeration value="SV"/&gt;
 *     &lt;enumeration value="TL"/&gt;
 *     &lt;enumeration value="TG"/&gt;
 *     &lt;enumeration value="TA"/&gt;
 *     &lt;enumeration value="TT"/&gt;
 *     &lt;enumeration value="TE"/&gt;
 *     &lt;enumeration value="TH"/&gt;
 *     &lt;enumeration value="BO"/&gt;
 *     &lt;enumeration value="TI"/&gt;
 *     &lt;enumeration value="TO"/&gt;
 *     &lt;enumeration value="TS"/&gt;
 *     &lt;enumeration value="TR"/&gt;
 *     &lt;enumeration value="TK"/&gt;
 *     &lt;enumeration value="TW"/&gt;
 *     &lt;enumeration value="UG"/&gt;
 *     &lt;enumeration value="UK"/&gt;
 *     &lt;enumeration value="UR"/&gt;
 *     &lt;enumeration value="UZ"/&gt;
 *     &lt;enumeration value="VI"/&gt;
 *     &lt;enumeration value="VO"/&gt;
 *     &lt;enumeration value="CY"/&gt;
 *     &lt;enumeration value="WO"/&gt;
 *     &lt;enumeration value="XH"/&gt;
 *     &lt;enumeration value="YI"/&gt;
 *     &lt;enumeration value="YO"/&gt;
 *     &lt;enumeration value="ZA"/&gt;
 *     &lt;enumeration value="ZU"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Language")
@XmlEnum
public enum Language implements Serializable {

    OM,
    AB,
    AA,
    AF,
    SQ,
    AM,
    AR,
    HY,
    AS,
    AY,
    AZ,
    BA,
    EU,
    BN,
    DZ,
    BH,
    BI,
    BR,
    BG,
    MY,
    BE,
    KM,
    CA,
    ZH,
    CO,
    HR,
    CS,
    DA,
    NL,
    EN,
    EO,
    ET,
    FO,
    FJ,
    FI,
    FR,
    FY,
    GL,
    KA,
    DE,
    EL,
    KL,
    GN,
    GU,
    HA,
    HE,
    HI,
    HU,
    IS,
    ID,
    IA,
    IE,
    IK,
    IU,
    GA,
    IT,
    JA,
    JW,
    KN,
    KS,
    KK,
    RW,
    KY,
    RN,
    KO,
    KU,
    LO,
    LA,
    LV,
    LN,
    LT,
    MK,
    MG,
    MS,
    ML,
    MT,
    MI,
    MR,
    MO,
    MN,
    NA,
    NE,
    NO,
    OC,
    OR,
    PS,
    FA,
    PL,
    PT,
    PA,
    QU,
    RM,
    RO,
    RU,
    SM,
    SG,
    SA,
    GD,
    SR,
    SH,
    ST,
    TN,
    SN,
    SD,
    SI,
    SS,
    SK,
    SL,
    SO,
    ES,
    SU,
    SW,
    SV,
    TL,
    TG,
    TA,
    TT,
    TE,
    TH,
    BO,
    TI,
    TO,
    TS,
    TR,
    TK,
    TW,
    UG,
    UK,
    UR,
    UZ,
    VI,
    VO,
    CY,
    WO,
    XH,
    YI,
    YO,
    ZA,
    ZU;

    public String value() {
        return name();
    }

    public static Language fromValue(String v) {
        return valueOf(v);
    }

}
