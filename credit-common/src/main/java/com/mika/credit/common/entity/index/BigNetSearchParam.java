package com.mika.credit.common.entity.index;

/**
 * Created by dell on 2017/4/26.
 */
public class BigNetSearchParam extends BaseSearchParam {
    private static final long serialVersionUID = -2245945959676276104L;
    /**
     * 所在街道
     */
    private String streetEN;
    /**
     * 所在城市
     */
    private String cityEN;
    /**
     * 邮编
     */
    private String postcode;
    /**
     * 所在地区
     */
    private String areaEN;
    /**
     * 所属国家代码
     */
    private String countryCode;
    /**
     * Tax number 税号
     */
    private String TAX;
    /**
     * VAT(value added tax) number 增值税号
     */
    private String VAT;
    /**
     * registration number 注册号
     */
    private String RGD;
    /**
     * SIREN number
     */
    private String RCS;
    /**
     * ICO number
     */
    private String ICO;
    /**
     * statistics number 统计数量
     */
    private String STA;
    /**
     * chamber of commerce number 商会编号
     */
    private String CHA;
    /**
     * isin number 国际证券识别编码
     */
    private String ISI;
    /**
     * legal entity identifier 全球法人机构识别编码
     */
    private String LEI;
    /**
     * 类似crefoNo,企业唯一标识
     */
    private String crefoNo;
    /**
     * 类似crefoNo,企业唯一标识
     */
    private String globalIdentificationNumber;

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }

    public String getGlobalIdentificationNumber() {
        return globalIdentificationNumber;
    }

    public void setGlobalIdentificationNumber(String globalIdentificationNumber) {
        this.globalIdentificationNumber = globalIdentificationNumber;
    }

    public String getStreetEN() {
        return streetEN;
    }

    public void setStreetEN(String streetEN) {
        this.streetEN = streetEN;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAreaEN() {
        return areaEN;
    }

    public void setAreaEN(String areaEN) {
        this.areaEN = areaEN;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTAX() {
        return TAX;
    }

    public void setTAX(String TAX) {
        this.TAX = TAX;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getRGD() {
        return RGD;
    }

    public void setRGD(String RGD) {
        this.RGD = RGD;
    }

    public String getRCS() {
        return RCS;
    }

    public void setRCS(String RCS) {
        this.RCS = RCS;
    }

    public String getICO() {
        return ICO;
    }

    public void setICO(String ICO) {
        this.ICO = ICO;
    }

    public String getSTA() {
        return STA;
    }

    public void setSTA(String STA) {
        this.STA = STA;
    }

    public String getCHA() {
        return CHA;
    }

    public void setCHA(String CHA) {
        this.CHA = CHA;
    }

    public String getISI() {
        return ISI;
    }

    public void setISI(String ISI) {
        this.ISI = ISI;
    }

    public String getLEI() {
        return LEI;
    }

    public void setLEI(String LEI) {
        this.LEI = LEI;
    }
}
