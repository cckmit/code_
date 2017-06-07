package com.mika.credit.facade.admin.model;

import java.io.Serializable;

/**
 * 国家
 * @author dhl007
 */
public class Country implements Serializable{

    /**
     * 国家编号
     */
    private Integer id;

    /**
     * 编码
     */
    private String code;

    /**
     *中文名称名称
     */
    private String cnName;

    /**
     *英文名称
     */
    private String enName;

    /**
     *在线报告价格(人民币)
     */
    private Float onlineOrderCnyPrice;

    /**
     *在线报告价格(美元)
     */
    private Float onlineOrderUsdPrice;

    /**
     *在线报告价格(欧元)
     */
    private Float onlineOrderEurPrice;

    /**
     *在线报告普通制作时间
     */
    private Integer onlineNormailDeliveryDays;

    /**
     *在线报告加急制作时间
     */
    private Integer onlineExpressDeliveryDays;

    /**
     *线上报告加急人民币价格
     */
    private Float onlineExpressDeliveryCnyPrice;

    /**
     *线上报告加急美元价格
     */
    private Float onlineExpressDeliveryUsdPrice;

    /**
     *线上报告加急欧元价格
     */
    private Float onlineExpressDeliveryEurPrice;

    /**
     *在线报告价格(人民币)
     */
    private Float onlineFullOrderCnyPrice;

    /**
     *在线报告价格(美元)
     */
    private Float onlineFullOrderUsdPrice;

    /**
     *在线报告价格(欧元)
     */
    private Float onlineFullOrderEurPrice;

    /**
     *在线报告普通制作时间
     */
    private Integer onlineFullNormailDeliveryDays;

    /**
     *在线报告加急制作时间
     */
    private Integer onlineFullExpressDeliveryDays;

    /**
     *线上报告加急人民币价格
     */
    private Float onlineFullExpressDeliveryCnyPrice;

    /**
     *线上报告加急美元价格
     */
    private Float onlineFullExpressDeliveryUsdPrice;

    /**
     *线上报告加急欧元价格
     */
    private Float onlineFullExpressDeliveryEurPrice;

    /**
     *离线报告价格(人名币)
     */
    private Float offlineOrderCnyPrice;

    /**
     *离线报告价格(美元)
     */
    private Float offlineOrderUsdPrice;

    /**
     *离线报告价格(欧元)
     */
    private Float offlineOrderEurPrice;

    /**
     *离线报告普通制作时间
     */
    private Integer offlineNormailDeliveryDays;

    /**
     *离线报告加急制作时间
     */
    private Integer offlineExpressDeliveryDays;

    /**
     *离线报告制作加急人民币费用
     */
    private Float offlineExpressDeliveryCnyPrice;

    /**
     *离线报告制作加急美元费用
     */
    private Float offlineExpressDeliveryUsdPrice;

    /**
     *离线报告制作加急欧元费用
     */
    private Float offlineExpressDeliveryEurPrice;

    /**
     * 是否启用
     */
    private String isEnable;

    /**
     * 洲的id
     */
    private int continentId;

    /**
     * 对应的洲
     */
    private Continent continent;

    public Float getOnlineFullOrderCnyPrice() {
        return onlineFullOrderCnyPrice;
    }

    public void setOnlineFullOrderCnyPrice(Float onlineFullOrderCnyPrice) {
        this.onlineFullOrderCnyPrice = onlineFullOrderCnyPrice;
    }

    public Float getOnlineFullOrderUsdPrice() {
        return onlineFullOrderUsdPrice;
    }

    public void setOnlineFullOrderUsdPrice(Float onlineFullOrderUsdPrice) {
        this.onlineFullOrderUsdPrice = onlineFullOrderUsdPrice;
    }

    public Float getOnlineFullOrderEurPrice() {
        return onlineFullOrderEurPrice;
    }

    public void setOnlineFullOrderEurPrice(Float onlineFullOrderEurPrice) {
        this.onlineFullOrderEurPrice = onlineFullOrderEurPrice;
    }

    public Integer getOnlineFullNormailDeliveryDays() {
        return onlineFullNormailDeliveryDays;
    }

    public void setOnlineFullNormailDeliveryDays(Integer onlineFullNormailDeliveryDays) {
        this.onlineFullNormailDeliveryDays = onlineFullNormailDeliveryDays;
    }

    public Integer getOnlineFullExpressDeliveryDays() {
        return onlineFullExpressDeliveryDays;
    }

    public void setOnlineFullExpressDeliveryDays(Integer onlineFullExpressDeliveryDays) {
        this.onlineFullExpressDeliveryDays = onlineFullExpressDeliveryDays;
    }

    public Float getOnlineFullExpressDeliveryCnyPrice() {
        return onlineFullExpressDeliveryCnyPrice;
    }

    public void setOnlineFullExpressDeliveryCnyPrice(Float onlineFullExpressDeliveryCnyPrice) {
        this.onlineFullExpressDeliveryCnyPrice = onlineFullExpressDeliveryCnyPrice;
    }

    public Float getOnlineFullExpressDeliveryUsdPrice() {
        return onlineFullExpressDeliveryUsdPrice;
    }

    public void setOnlineFullExpressDeliveryUsdPrice(Float onlineFullExpressDeliveryUsdPrice) {
        this.onlineFullExpressDeliveryUsdPrice = onlineFullExpressDeliveryUsdPrice;
    }

    public Float getOnlineFullExpressDeliveryEurPrice() {
        return onlineFullExpressDeliveryEurPrice;
    }

    public void setOnlineFullExpressDeliveryEurPrice(Float onlineFullExpressDeliveryEurPrice) {
        this.onlineFullExpressDeliveryEurPrice = onlineFullExpressDeliveryEurPrice;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public Float getOnlineOrderCnyPrice() {
        return onlineOrderCnyPrice;
    }

    public void setOnlineOrderCnyPrice(Float onlineOrderCnyPrice) {
        this.onlineOrderCnyPrice = onlineOrderCnyPrice;
    }

    public Float getOnlineOrderUsdPrice() {
        return onlineOrderUsdPrice;
    }

    public void setOnlineOrderUsdPrice(Float onlineOrderUsdPrice) {
        this.onlineOrderUsdPrice = onlineOrderUsdPrice;
    }

    public Float getOnlineOrderEurPrice() {
        return onlineOrderEurPrice;
    }

    public void setOnlineOrderEurPrice(Float onlineOrderEurPrice) {
        this.onlineOrderEurPrice = onlineOrderEurPrice;
    }

    public Integer getOnlineNormailDeliveryDays() {
        return onlineNormailDeliveryDays;
    }

    public void setOnlineNormailDeliveryDays(Integer onlineNormailDeliveryDays) {
        this.onlineNormailDeliveryDays = onlineNormailDeliveryDays;
    }

    public Integer getOnlineExpressDeliveryDays() {
        return onlineExpressDeliveryDays;
    }

    public void setOnlineExpressDeliveryDays(Integer onlineExpressDeliveryDays) {
        this.onlineExpressDeliveryDays = onlineExpressDeliveryDays;
    }

    public Float getOnlineExpressDeliveryCnyPrice() {
        return onlineExpressDeliveryCnyPrice;
    }

    public void setOnlineExpressDeliveryCnyPrice(Float onlineExpressDeliveryCnyPrice) {
        this.onlineExpressDeliveryCnyPrice = onlineExpressDeliveryCnyPrice;
    }

    public Float getOnlineExpressDeliveryUsdPrice() {
        return onlineExpressDeliveryUsdPrice;
    }

    public void setOnlineExpressDeliveryUsdPrice(Float onlineExpressDeliveryUsdPrice) {
        this.onlineExpressDeliveryUsdPrice = onlineExpressDeliveryUsdPrice;
    }

    public Float getOnlineExpressDeliveryEurPrice() {
        return onlineExpressDeliveryEurPrice;
    }

    public void setOnlineExpressDeliveryEurPrice(Float onlineExpressDeliveryEurPrice) {
        this.onlineExpressDeliveryEurPrice = onlineExpressDeliveryEurPrice;
    }

    public Float getOfflineOrderCnyPrice() {
        return offlineOrderCnyPrice;
    }

    public void setOfflineOrderCnyPrice(Float offlineOrderCnyPrice) {
        this.offlineOrderCnyPrice = offlineOrderCnyPrice;
    }

    public Float getOfflineOrderUsdPrice() {
        return offlineOrderUsdPrice;
    }

    public void setOfflineOrderUsdPrice(Float offlineOrderUsdPrice) {
        this.offlineOrderUsdPrice = offlineOrderUsdPrice;
    }

    public Float getOfflineOrderEurPrice() {
        return offlineOrderEurPrice;
    }

    public void setOfflineOrderEurPrice(Float offlineOrderEurPrice) {
        this.offlineOrderEurPrice = offlineOrderEurPrice;
    }

    public Integer getOfflineNormailDeliveryDays() {
        return offlineNormailDeliveryDays;
    }

    public void setOfflineNormailDeliveryDays(Integer offlineNormailDeliveryDays) {
        this.offlineNormailDeliveryDays = offlineNormailDeliveryDays;
    }

    public Integer getOfflineExpressDeliveryDays() {
        return offlineExpressDeliveryDays;
    }

    public void setOfflineExpressDeliveryDays(Integer offlineExpressDeliveryDays) {
        this.offlineExpressDeliveryDays = offlineExpressDeliveryDays;
    }

    public Float getOfflineExpressDeliveryCnyPrice() {
        return offlineExpressDeliveryCnyPrice;
    }

    public void setOfflineExpressDeliveryCnyPrice(Float offlineExpressDeliveryCnyPrice) {
        this.offlineExpressDeliveryCnyPrice = offlineExpressDeliveryCnyPrice;
    }

    public Float getOfflineExpressDeliveryUsdPrice() {
        return offlineExpressDeliveryUsdPrice;
    }

    public void setOfflineExpressDeliveryUsdPrice(Float offlineExpressDeliveryUsdPrice) {
        this.offlineExpressDeliveryUsdPrice = offlineExpressDeliveryUsdPrice;
    }

    public Float getOfflineExpressDeliveryEurPrice() {
        return offlineExpressDeliveryEurPrice;
    }

    public void setOfflineExpressDeliveryEurPrice(Float offlineExpressDeliveryEurPrice) {
        this.offlineExpressDeliveryEurPrice = offlineExpressDeliveryEurPrice;
    }
}