package com.mika.credit.facade.gugu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScanningCard {
    private Integer id;

    private Integer userId;

    private Integer carduuId;

    private String name;

    private String position;

    private String mobile1;

    private String mobile2;

    private String email;

    private String tel1;

    private String tel2;

    private String fax;

    private String companyName;

    private String address;

    private String website;

    private String logo;

    private Date createTime;

    private Date updateTime;

    private String fields;

    private String audit;

    private String delFlag;

    private String areacode1;

    private String areacode2;

    private String photoPath;

    private String path;

    private String bCardFlag;

    private String zip;

    private String heaSculpturePath;

    private String shwoHeaSculpturePath;

    private String nameCoordinate;

    private String positionCoordinate;

    private String mobile1Coordinate;

    private String mobile2Coordinate;

    private String emailCoordinate;

    private String tel1Coordinate;

    private String tel2Coordinate;

    private String faxCoordinate;

    private String companyNameCoordinate;

    private String addressCoordinate;

    private String websiteCoordinate;

    private String areaCode1Coordinate;

    private String areaCode2Coordinate;

    private String zipCoordinate;

    private String correctCoordinate;

    private List<ScanningCardExtend> scanningCardExtends=new ArrayList<>();

    public List<ScanningCardExtend> getScanningCardExtends() {
        return scanningCardExtends;
    }

    public void setScanningCardExtends(List<ScanningCardExtend> scanningCardExtends) {
        this.scanningCardExtends = scanningCardExtends;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarduuId() {
        return carduuId;
    }

    public void setCarduuId(Integer carduuId) {
        this.carduuId = carduuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1 == null ? null : mobile1.trim();
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2 == null ? null : mobile2.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1 == null ? null : tel1.trim();
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2 == null ? null : tel2.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields == null ? null : fields.trim();
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit == null ? null : audit.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getAreacode1() {
        return areacode1;
    }

    public void setAreacode1(String areacode1) {
        this.areacode1 = areacode1 == null ? null : areacode1.trim();
    }

    public String getAreacode2() {
        return areacode2;
    }

    public void setAreacode2(String areacode2) {
        this.areacode2 = areacode2 == null ? null : areacode2.trim();
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getbCardFlag() {
        return bCardFlag;
    }

    public void setbCardFlag(String bCardFlag) {
        this.bCardFlag = bCardFlag == null ? null : bCardFlag.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getHeaSculpturePath() {
        return heaSculpturePath;
    }

    public void setHeaSculpturePath(String heaSculpturePath) {
        this.heaSculpturePath = heaSculpturePath == null ? null : heaSculpturePath.trim();
    }

    public String getShwoHeaSculpturePath() {
        return shwoHeaSculpturePath;
    }

    public void setShwoHeaSculpturePath(String shwoHeaSculpturePath) {
        this.shwoHeaSculpturePath = shwoHeaSculpturePath == null ? null : shwoHeaSculpturePath.trim();
    }

    public String getNameCoordinate() {
        return nameCoordinate;
    }

    public void setNameCoordinate(String nameCoordinate) {
        this.nameCoordinate = nameCoordinate == null ? null : nameCoordinate.trim();
    }

    public String getPositionCoordinate() {
        return positionCoordinate;
    }

    public void setPositionCoordinate(String positionCoordinate) {
        this.positionCoordinate = positionCoordinate == null ? null : positionCoordinate.trim();
    }

    public String getMobile1Coordinate() {
        return mobile1Coordinate;
    }

    public void setMobile1Coordinate(String mobile1Coordinate) {
        this.mobile1Coordinate = mobile1Coordinate == null ? null : mobile1Coordinate.trim();
    }

    public String getMobile2Coordinate() {
        return mobile2Coordinate;
    }

    public void setMobile2Coordinate(String mobile2Coordinate) {
        this.mobile2Coordinate = mobile2Coordinate == null ? null : mobile2Coordinate.trim();
    }

    public String getEmailCoordinate() {
        return emailCoordinate;
    }

    public void setEmailCoordinate(String emailCoordinate) {
        this.emailCoordinate = emailCoordinate == null ? null : emailCoordinate.trim();
    }

    public String getTel1Coordinate() {
        return tel1Coordinate;
    }

    public void setTel1Coordinate(String tel1Coordinate) {
        this.tel1Coordinate = tel1Coordinate == null ? null : tel1Coordinate.trim();
    }

    public String getTel2Coordinate() {
        return tel2Coordinate;
    }

    public void setTel2Coordinate(String tel2Coordinate) {
        this.tel2Coordinate = tel2Coordinate == null ? null : tel2Coordinate.trim();
    }

    public String getFaxCoordinate() {
        return faxCoordinate;
    }

    public void setFaxCoordinate(String faxCoordinate) {
        this.faxCoordinate = faxCoordinate == null ? null : faxCoordinate.trim();
    }

    public String getCompanyNameCoordinate() {
        return companyNameCoordinate;
    }

    public void setCompanyNameCoordinate(String companyNameCoordinate) {
        this.companyNameCoordinate = companyNameCoordinate == null ? null : companyNameCoordinate.trim();
    }

    public String getAddressCoordinate() {
        return addressCoordinate;
    }

    public void setAddressCoordinate(String addressCoordinate) {
        this.addressCoordinate = addressCoordinate == null ? null : addressCoordinate.trim();
    }

    public String getWebsiteCoordinate() {
        return websiteCoordinate;
    }

    public void setWebsiteCoordinate(String websiteCoordinate) {
        this.websiteCoordinate = websiteCoordinate == null ? null : websiteCoordinate.trim();
    }

    public String getAreaCode1Coordinate() {
        return areaCode1Coordinate;
    }

    public void setAreaCode1Coordinate(String areaCode1Coordinate) {
        this.areaCode1Coordinate = areaCode1Coordinate == null ? null : areaCode1Coordinate.trim();
    }

    public String getAreaCode2Coordinate() {
        return areaCode2Coordinate;
    }

    public void setAreaCode2Coordinate(String areaCode2Coordinate) {
        this.areaCode2Coordinate = areaCode2Coordinate == null ? null : areaCode2Coordinate.trim();
    }

    public String getZipCoordinate() {
        return zipCoordinate;
    }

    public void setZipCoordinate(String zipCoordinate) {
        this.zipCoordinate = zipCoordinate == null ? null : zipCoordinate.trim();
    }

    public String getCorrectCoordinate() {
        return correctCoordinate;
    }

    public void setCorrectCoordinate(String correctCoordinate) {
        this.correctCoordinate = correctCoordinate == null ? null : correctCoordinate.trim();
    }
}