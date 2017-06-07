package com.mika.credit.common.entity.order;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单明细实体类
 *
 * @author zj001
 */
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 450660121080582557L;
    /**
     * 订单明细id
     */
    private Long id;
    /**
     *
     */
    private String crefoNo;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 公司中文名(适用全搜中国报告)
     */
    private String companyNameCN;
    /**
     * 公司编号
     */
    private String companyNo;
    /**
     * 应付金额,根据product产品的价格
     */
    private BigDecimal price;
    /**
     * 实付金额
     */
    private BigDecimal priceActual;
    /**
     * 产品Id
     */
    private Integer productId;
    /**
     * 报告语言 1：中文 2：英文
     */
    private Byte reportLang;
    /**
     * 报告语言中文名
     */
    private String reportLangNameCN;
    /**
     * 报告语言英文名
     */
    private String reportLangNameEN;
    /**
     * 明细状态: 1 待支付 2 调查中 3 待分配 4 制作中 5 待审核 6 审核中 7 待发布 8 完成 0 取消
     */
    private Byte status;
    /**
     * 明细状态中文名
     */
    private String statusNameCN;
    /**
     * 明细状态英文名
     */
    private String statusNameEN;
    /**
     * 国家Id
     */
    private Integer countryId;
    /**
     * 国家名
     */
    private String countryName;
    /**
     * 报告文件实体
     */
    private File file;
    /**
     * 上传文件地址
     */
    private String pathFile;
    /**
     * json格式数据
     */
    private String data;
    /**
     * 数据TXT文件保存路径
     */
    private String pathData;
    /**
     * 由数据生成的file实体
     */
    private File dataFile;
    /**
     * 由数据生成的file实体保存路径
     */
    private String pathDataFile;

    /**
     * 外部接口数据保存标识
     */
    private Boolean dbIsUpDate;
    /**
     * cpm数据保存标识
     */
    private Boolean cpmIsUpdate;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 制作期限，以支付时间开始算，以小时为单位
     */
    private Integer expectHour;
    /**
     * 应交付日期，根据期限计算出来（-法定节日，+加班日）的日期
     */
    private Date expectTime;
    /**
     * 完成时间，发布时间
     */
    private Date finishTime;
    /**
     * 供应商制作期限
     */
    private Integer supplierExpectHour;
    /**
     * 供应商应交付日期
     */
    private Date supplierExpectTime;
    /**
     * 供应商ID ==== BasicData
     */
    private Integer supplierId;
    /**
     * 报告制作人员==== Users
     */
    private Integer reportUserId;
    /**
     * 审核人员==== Users
     */
    private Integer checkUserId;
    /**
     * 负责人ID ==== Users
     */
    private Integer chargeUserId;
    /**
     * 是否特殊订单
     */
    private Boolean isSpecial;
    /**
     * 是否加急
     */
    private Boolean isExpress;
    /**
     * 备注
     */
    private String remark;

    public Boolean getDbIsUpDate() {
        return dbIsUpDate;
    }

    public void setDbIsUpDate(Boolean dbIsUpDate) {
        this.dbIsUpDate = dbIsUpDate;
    }

    public Boolean getCpmIsUpdate() {
        return cpmIsUpdate;
    }

    public void setCpmIsUpdate(Boolean cpmIsUpdate) {
        this.cpmIsUpdate = cpmIsUpdate;
    }

    public String getReportLangNameCN() {
        return ReportLangEnum.getNameCN(this.reportLang);
    }

    public String getReportLangNameEN() {
        return ReportLangEnum.getNameEN(this.reportLang);
    }

    public String getStatusNameCN() {
        return OrderDetailStatusEnum.getNameCN(this.status);
    }

    public String getStatusNameEN() {
        return OrderDetailStatusEnum.getNameEN(this.status);
    }

    public String getCompanyNameCN() {
        return companyNameCN;
    }

    public void setCompanyNameCN(String companyNameCN) {
        this.companyNameCN = companyNameCN;
    }

    public File getDataFile() {
        return dataFile;
    }

    public void setDataFile(File dataFile) {
        this.dataFile = dataFile;
    }

    public String getPathDataFile() {
        return pathDataFile;
    }

    public void setPathDataFile(String pathDataFile) {
        this.pathDataFile = pathDataFile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getSpecial() {
        return isSpecial;
    }

    public void setSpecial(Boolean special) {
        this.isSpecial = special;
    }

    public Boolean getExpress() {
        return isExpress;
    }

    public void setExpress(Boolean express) {
        this.isExpress = express;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo == null ? null : crefoNo.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceActual() {
        return priceActual;
    }

    public void setPriceActual(BigDecimal priceActual) {
        this.priceActual = priceActual;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Byte getReportLang() {
        return reportLang;
    }

    public void setReportLang(Byte reportLang) {
        this.reportLang = reportLang;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile == null ? null : pathFile.trim();
    }

    public String getPathData() {
        return pathData;
    }

    public void setPathData(String pathData) {
        this.pathData = pathData == null ? null : pathData.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getExpectHour() {
        return expectHour;
    }

    public void setExpectHour(Integer expectHour) {
        this.expectHour = expectHour;
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getSupplierExpectHour() {
        return supplierExpectHour;
    }

    public void setSupplierExpectHour(Integer supplierExpectHour) {
        this.supplierExpectHour = supplierExpectHour;
    }

    public Date getSupplierExpectTime() {
        return supplierExpectTime;
    }

    public void setSupplierExpectTime(Date supplierExpectTime) {
        this.supplierExpectTime = supplierExpectTime;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(Integer reportUserId) {
        this.reportUserId = reportUserId;
    }

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Integer getChargeUserId() {
        return chargeUserId;
    }

    public void setChargeUserId(Integer chargeUserId) {
        this.chargeUserId = chargeUserId;
    }

    public Boolean getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public Boolean getIsExpress() {
        return isExpress;
    }

    public void setIsExpress(Boolean isExpress) {
        this.isExpress = isExpress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}