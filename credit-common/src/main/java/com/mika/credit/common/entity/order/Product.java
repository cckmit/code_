package com.mika.credit.common.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 产品实体类
 *
 * @author zj001
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 产品id
     */
    private Integer id;
    /**
     * 产品号
     */
    private String no;
    /**
     * 产品名
     */
    private String name;
    /**
     * 产品描述
     */
    private String desc;
    /**
     * 产品类型 1:中国报告,2:外国报告,3:自定义报告
     */
    private Byte productType;
    /**
     * 产品类型中文名
     */
    private String productTypeNameCN;
    /**
     * 产品类型英文名
     */
    private String productTypeNameEN;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createPerson;
    /**
     * 最近更新时间
     */
    private Date lastUpdateTime;
    /**
     * 最近更新人
     */
    private String lastUpdatePerson;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 产品来源 0：通用 1：全球鹰 2：全搜 3：估估 4：CPM
     */
    private Byte source;
    /**
     * 产品来源中文名
     */
    private String sourceNameCN;
    /**
     * 产品来源英文名
     */
    private String sourceNameEN;
    /**
     * 产品是否可用
     */
    private Boolean enable;
    /**
     * 币种,取3位国际编码
     */
    private String currency;
    /**
     * 样本url
     */
    private String modelUrl;
    /**
     * 制作时间，以小时为单位
     */
    private Integer expectHour;
    /**
     * 产品等级
     */
    private Byte level;
    /**
     * 是否加急
     */
    private Boolean isExpress;
    /**
     * 是否订购过该报告(标识,不存库)
     */
    private boolean hasOrder;

    private List<ProductModule> productModules;

    // String json = "productModules:[{},{},{}]"


    public String getProductTypeNameCN() {
        return ProductTypeEnum.getNameCN(this.productType);
    }

    public String getProductTypeNameEN() {
        return ProductTypeEnum.getNameEN(this.productType);
    }

    public String getSourceNameCN() {
        return SourceEnum.getNameCN(this.source);
    }

    public String getSourceNameEN() {
        return SourceEnum.getNameEN(this.source);
    }


    public boolean getHasOrder() {
        return hasOrder;
    }

    public void setHasOrder(boolean hasOrder) {
        this.hasOrder = hasOrder;
    }

    public Boolean getExpress() {
        return isExpress;
    }

    public void setExpress(Boolean express) {
        isExpress = express;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getModelUrl() {
        return modelUrl;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
    }

    public Integer getExpectHour() {
        return expectHour;
    }

    public void setExpectHour(Integer expectHour) {
        this.expectHour = expectHour;
    }

    public List<ProductModule> getProductModules() {
        return productModules;
    }

    public void setProductModules(List<ProductModule> productModules) {
        this.productModules = productModules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdatePerson() {
        return lastUpdatePerson;
    }

    public void setLastUpdatePerson(String lastUpdatePerson) {
        this.lastUpdatePerson = lastUpdatePerson;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
