package com.mika.credit.facade.verify.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.VerificationResult;
import com.mika.credit.facade.verify.model.MobilephoneName;
import com.mika.credit.facade.verify.model.TelephoneCompanyname;

import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dong jian hua on 2017/4/19.
 */
public class VerifycationUtil {

    final static String[] opearting = new String[]{"在业", "在营开业", "在营开业企业", "存续",
            "存续在营开业在册", "存续在营开业在册", "开业", "正常", "登记成立", "个体转企业"};
    final static String[] unusual = new String[]{"停业", "停业个体工商户使用", "吊销", "吊销企业",
            "吊销未注销", "吊销已注销", "吊销未注销", "已吊销", "已撤销企业", "已注销", "拟注销",
            "未办理注销登记手续", "注吊销", "注销", "清算中"};
    final static String[] other = new String[]{"不明", "已迁出企业", "待迁入", "经营期限届满", "迁出",
            "迁移异地"};


    //经营状态
    public final static Integer operatingStatus1 = 10;
    public final static Integer operatingStatus2 = 2;
    public final static Integer operatingStatus3 = 0;

    //成立年限
    public final static Integer establishDate1 = 5;
    public final static Integer establishDate2 = 3;
    public final static Integer establishDate3 = 1;

    //注册资金
    public final static Integer regCapital1 = 10;
    public final static Integer regCapital2 = 5;
    public final static Integer regCapital3 = 3;

    //翰鑫固定电话
    public final static Integer telCompanyName1 = 8;

    //电话地址
    public final static Integer telCompanyAddress1 = 8;
    public final static Integer telCompanyAddress2 = 3;

    //ICP
    public final static Integer icp1 = 4;

    //域赢手机是否存在认证
    public final static Integer mobilePhoneName1 = 10;
    public final static Integer mobilePhoneName2 = 3;

    //手机在线时长
    public final static Integer mobilePhoneTime1 = 10;
    public final static Integer mobilePhoneTime2 = 8;
    public final static Integer mobilePhoneTime3 = 5;
    public final static Integer mobilePhoneTime4 = 2;


    //网站
    public final static Integer websiteEmail1 = 5;

    //人名和公司名
    public final static Integer CardNameCompanyName1 = 20;
    public final static Integer CardNameCompanyName2 = 0;



    /**
     * 企业状态
     *
     * @param val
     * @param weight
     * @param vr
     * @return
     */
    public static Integer OperatingStatus(Object val, Integer weight, VerificationResult vr) {
        Integer score = 0;
        if (null != val && !val.toString().equals("")) {
            boolean b = false;
            val = Tool.FilterString(val + "");
            for (String object : opearting) {
                if (val.toString().contains(object)) {
                    score = operatingStatus1;
                    b = true;
                    break;
                }

            }

            if (!b) {
                for (String object : unusual) {
                    if (val.toString().contains(object)) {
                        score = operatingStatus3;
                        b = true;
                        break;
                    }
                }
            }

            if (!b) {
                for (String object : other) {
                    if (val.toString().contains(object)) {
                        score = operatingStatus2;
                        b = true;
                        break;
                    }
                }
            }


            vr.setCompanyStatusResult(val.toString());

        } else {
            score = 2;//营业状态不存在
            vr.setCompanyStatusResult("不详");
        }

        weight = weight + score;

        return weight;
    }

    /**
     * 成立年限
     *
     * @param establishmentDate
     * @param weight
     * @return
     */
    public static Integer otherInfo(Date establishmentDate, Integer weight) {
        //TODO 成立日期(1年以内，1-5,5-10,10以上)
        DateUtil dateUtil = new DateUtil();
        int year = dateUtil.conversionTimeToYear(new Date(), establishmentDate);
        if (1 < year && year <= 3) {
            weight = weight + establishDate3;
        } else if (3 < year && year <= 10) {
            weight = weight + establishDate2;
        } else if (10 < year) {
            weight = weight + establishDate1;
        }

        return weight;
    }

    /**
     * 注册资金
     *
     * @param regCapital
     * @param weight
     * @return
     */
    public static Integer otherInfo(Long regCapital, Integer weight) {
        //TODO 注册资金(50万以内，50-200,200以上)
        if (50 > regCapital) {
            weight = weight + regCapital3;
        } else if (50 < regCapital && regCapital <= 200) {
            weight = weight + regCapital2;
        } else if (200 < regCapital) {
            weight = weight + regCapital1;
        }

        return weight;
    }

    /**
     * 注册地区
     *
     * @param regArea
     * @param weight
     * @return
     */
    public static Integer otherInfo(Integer regArea, Integer weight) {
        //TODO 注册省份(三挡)
        String[] area1 = new String[]{"31", "11", "44", "33", "32"};
        String[] area2 = new String[]{"63", "65", "54", "15", "62", "52", "23"};
        Integer score = 0;
        if (null != regArea) {
            boolean b = false;
            for (String object : area1) {
                if (regArea.toString().contains(object)) {
                    score = 10;
                    b = true;
                    break;
                }

            }

            if (!b) {
                for (String object : area2) {
                    if (regArea.toString().contains(object)) {
                        score = 6;
                        b = true;
                        break;
                    }
                }
            }

            if (!b) {
                score = 8;
            }
        }
        weight = weight + score;

        return weight;
    }

    /**
     * ICP备份
     *
     * @param websiteList
     * @param weight
     * @param vr
     * @return
     */
    public static Integer IcpwebsiteStatus(String web, List<IcpWebsite> websiteList, Integer weight, VerificationResult vr) {
        Integer score = 0;

        if (null != websiteList && null != web && !web.equals("")) {
            for (IcpWebsite icpWebsite : websiteList) {
                if (null != icpWebsite) {
                    if (null != web && !web.equals("")) {
                        String dwmc = icpWebsite.getWebsite();
                        if (null != dwmc && !dwmc.equals("")) {
                            web = web.replace("(", "");
                            web = web.replace(")", "");
                            web = web.replace("（", "");
                            web = web.replace("）", "");
                            dwmc = dwmc.replace("(", "");
                            dwmc = dwmc.replace(")", "");
                            dwmc = dwmc.replace("（", "");
                            dwmc = dwmc.replace("）", "");
                            if (dwmc.contains(web)) {
                                score = icp1;
                                vr.setCompanyNameIcpNameResult("一致");
                                break;
                            }

                        }

                    }

                }

            }
        }
        if (score == 0) {
            vr.setCompanyNameIcpNameResult("不详");
        }

        System.out.println("进入website=" + score);
        weight = weight + score;

        return weight;
    }

    /**
     * 翰鑫固定电话
     *
     * @param weight
     * @param vr
     * @return
     * @throws Exception
     */
    public static String telInfo_hx(BusinessCard businessCard, Integer weight, VerificationResult vr) throws Exception {
        Integer score = weight;
        JSONObject jsons = new JSONObject();
        String tel_companyName = "";
        String tel_areaCode = "";
        String tel_address = "";
        try{

            Boolean code = false;
            String areaCode = "";
            String card_companyName = businessCard.getCardCompany();
            String card_areaCode = businessCard.getAreaCode();
            String card_address = businessCard.getCardAddress();
            String card_Tel = businessCard.getCardTel();

            vr.setCompanyNameTelNameResult("不详");
            vr.setCompanyAddressTelAddressResult("不详");

            if (StringUtil.isNotNull(card_areaCode)) {
                areaCode = card_areaCode;
                String[] arr = new String[]{"+", "+86", "86"};
                for (int i = 0; i < arr.length; i++) {
                    areaCode = areaCode.replace(arr[i], "");
                }

                if (areaCode.length() < 4) {
                    String str = areaCode.substring(0, 1);
                    if (!str.equals("0")) {
                        areaCode = "0" + areaCode;
                    }

                }
            }

            String url = Tool.loadCommonUrl("hanxinTelephoneInfo")+"telephone="+(card_areaCode+card_Tel)+"&name="+card_companyName;
            String json = HttpClientUtils.httpClient(url);
            JSONObject json_tel = JSONObject.parseObject(json);
            code = json_tel.getBoolean("code");
            if (code) {
                JSONObject jsonObject = json_tel.getJSONObject("content");
                JSONObject cisReport = jsonObject.getJSONObject("cisReport");
                JSONObject entTelCheckInfo = cisReport.getJSONObject("entTelCheckInfo");

                if(null != entTelCheckInfo){
                    JSONArray arr_matchInfo = entTelCheckInfo.getJSONArray("matchItem");

                        Iterator<Object> it = arr_matchInfo.iterator();
                        boolean telNameFlag = false;
                        while (it.hasNext()) {
                            JSONObject json_matchInfo = (JSONObject) it.next();

                            tel_companyName = json_matchInfo.get("ownerName")+"";
                            tel_areaCode = json_matchInfo.get("areaDesc")+"";
                            tel_address = json_matchInfo.get("address")+"";

                            //TODO 过滤掉特殊字符
                            if(null != tel_companyName && !tel_companyName.trim().equals("")){
                                String cardCompany = Tool.FilterString(card_companyName).replace(" ", "");
                                if(tel_companyName.trim().contains(cardCompany.trim().replace("股份","")) || cardCompany.trim().replace("股份","").contains(tel_companyName.trim())){
                                    vr.setCompanyNameTelNameResult("一致");
                                    telNameFlag = true;
                                }else{
                                    vr.setCompanyNameTelNameResult("不一致");
                                }
                            }else{
                                //TODO 电话登记名称和名称都不相等
                                vr.setCompanyNameTelNameResult("不详");
                            }


                            //TODO　公司地址对比(电话登记地址和名片地址对比)
                            if(null != tel_address && !tel_address.trim().equals("")){
                                //经营地址
                                if(null != tel_areaCode && !tel_areaCode.trim().equals("")){
                                    //添加地区
                                    tel_address = tel_areaCode + tel_address;
                                }
                                Integer compareWeight = addressGPS(tel_address, card_address, weight, telCompanyAddress1);
                                if(compareWeight == weight){
                                    //TODO 电话地址和注册，经营地址都不符合
                                    compareWeight = 3;
                                    vr.setCompanyAddressTelAddressResult("不一致");
                                }else{
                                    weight = compareWeight;
                                    vr.setCompanyAddressTelAddressResult("一致");
                                }
                            }else{
                                //TODO 电话登记地址数据不存在
                                vr.setCompanyAddressTelAddressResult("不详");
                            }

                        }
                        if(telNameFlag){
                            weight += telCompanyName1;
                        }
                }

            }
            jsons.put("companyName",tel_companyName);
            jsons.put("tel_areaCode",tel_areaCode);
            jsons.put("tel_address",tel_address);
            jsons.put("weight",weight);
            return jsons.toJSONString();

        }catch (Exception e){
            e.printStackTrace();
            weight = score;
        }

        jsons.put("companyName",tel_companyName);
        jsons.put("areaCode",tel_areaCode);
        jsons.put("addRess",tel_address);
        jsons.put("weight",weight);
        return jsons.toJSONString();
    }

    /**
     * 翰鑫固定电话  缓存库
     *
     * @param weight
     * @param vr
     * @return
     * @throws Exception
     */
    public static Integer telInfo_hx_cache(BusinessCard businessCard, Integer weight, VerificationResult vr,TelephoneCompanyname tel) throws Exception {
            if(StringUtil.isNotNull(tel.getCompanyName()) || StringUtil.isNotNull(tel.getAreaCode()) || StringUtil.isNotNull(tel.getAddress())){

                boolean telNameFlag = false;
                    Integer compareWeight = addressGPS(businessCard.getCardAddress(), tel.getAddress(), weight, telCompanyAddress1);
                    if(compareWeight == weight){
                        //电话地址和注册，经营地址都不符合
                        weight += telCompanyAddress2;
                        vr.setCompanyAddressTelAddressResult("不一致");
                    }else{
                        weight = compareWeight;
                        vr.setCompanyAddressTelAddressResult("一致");
                    }

                    if(StringUtil.isNotNull(businessCard.getAreaCode()) && StringUtil.isNotNull(businessCard.getCardTel())){
                        String cardCompany = Tool.FilterString(businessCard.getCardCompany()).replace(" ", "");
                        if(StringUtil.isNotNull(tel.getTel()) && tel.getTel().equals(businessCard.getAreaCode()+businessCard.getCardTel())){
                            if(StringUtil.isNotNull(cardCompany) && cardCompany.equals(tel.getCompanyName())){
                                vr.setCompanyNameTelNameResult("一致");
                                telNameFlag = true;
                            }
                        }
                    }else{
                        vr.setCompanyNameTelNameResult("不一致");
                    }

                    if(telNameFlag){
                        weight += telCompanyName1;
                    }

            } else{
                //电话登记名称和名称都不相等
                vr.setCompanyAddressTelAddressResult("不详");
                //固定电话+手机号 不详
                vr.setCompanyNameTelNameResult("不详");
            }

            return weight;

    }


    /**
     * 地理位置匹配
     * @param value1
     * @param value2
     * @param weight
     * @param score
     * @return
     */
    public static Integer addressGPS(Object value1, Object value2, Integer weight, Integer score){
        double lng_1 = 0;
        double lat_1 = 0;
        double check_lng = 0;
        double check_lat = 0;

        if(null != value1 && !value1.equals("")){
            value1 = URLEncoder.encode((String) value1);
        }

        if(null != value2 && !value2.equals("")){
            value2 = URLEncoder.encode((String) value2);
        }

        String json_dgdz_badidu = HttpClientUtils.httpClient(Tool.loadCommonUrl("baiduAddress")+"address=" +value1 + "&output=json&ak=HUkBhiAEHu7FGlmBHqCTeIC6");
        JSONObject json_dgdz = JSONObject.parseObject(json_dgdz_badidu);
        JSONObject json_dgdz_result = json_dgdz.getJSONObject("result");
        if(null != json_dgdz && null != json_dgdz_result && json_dgdz_result.containsKey("location")){
            JSONObject local = json_dgdz_result.getJSONObject("location");
            if (null != local){
                lng_1 = local.getDouble("lng");
                lat_1 = local.getDouble("lat");
            }
        }


        String json_check_baidu = HttpClientUtils.httpClient(Tool.loadCommonUrl("baiduAddress")+"address=" +value2 +"&output=json&ak=HUkBhiAEHu7FGlmBHqCTeIC6");
        JSONObject json_check = JSONObject.parseObject(json_check_baidu);
        JSONObject json_check_result = json_check.getJSONObject("result");
        if(null != json_check && null != json_check_result ){
            JSONObject local = json_check_result.getJSONObject("location");
            if(null != local){
                check_lng = local.getDouble("lng");
                check_lat = local.getDouble("lat");
            }
        }


        DecimalFormat df = new DecimalFormat("######0.00");
        lng_1 = Double.parseDouble(df.format(lng_1));
        lat_1 = Double.parseDouble(df.format(lat_1));

        check_lng = Double.parseDouble(df.format(check_lng));
        check_lat =Double.parseDouble(df.format(check_lat));

        // 经纬度比较绝对值误差在0.001
        boolean lng_b = false;
        double result_lng = Math.abs(lng_1 - check_lng);
        if (result_lng <= 0.001) {
            lng_b = true;
        }

        boolean lat_b = false;
        double result_lat = Math.abs(lat_1 - check_lat);
        if (result_lat <= 0.001) {
            lat_b= true;
        }
        if (lng_b && lat_b) {
            weight += score;
        }

        return weight;
    }

    /**
     * 邮箱后缀匹配网站
     * @param weight
     * @param vr
     * @return
     */
    public static  Integer otherInfo(BusinessCard businessCard, Integer weight, VerificationResult vr ){
        String email = businessCard.getCardEmail();
        String website = businessCard.getCardWebsite();

        //TODO 邮箱后缀匹配网站(网站包含邮箱后缀)

        if(null != email && !email.equals("") && null != website && !website.equals("")){
            //截取@后面的第一个点的位置
            int startIndex = email.indexOf('@');
            if(startIndex<1){
                return weight;
            }
            String str1 = email.substring(startIndex);
            int endIndex = str1.indexOf(".");

            String domain = email.substring(startIndex+1 , startIndex+endIndex);
            if(website.toLowerCase().contains(domain.toLowerCase())){
                weight = weight + websiteEmail1;
                vr.setOtherInfoResult(weight+"");
            }
        }

        return weight;
    }

    /**
     * 域赢手机是否存在验证
     * @param weight
     * @param vr
     * @return
     */
    public static String  mobliePhone_hx(BusinessCard businessCard, Integer weight, VerificationResult vr){
        String phone = businessCard.getCardPhone();
        String personName = businessCard.getCardName();
        Integer score = 0;
        JSONObject jsons = new JSONObject();
        vr.setCardNameMobileName("不详");
        if(StringUtil.isNotNull(phone) && StringUtil.isNotNull(personName)){
            phone = Tool.formatePhone(phone);
            //调用翰信手机是否存在接口地址
            String url = Tool.loadCommonUrl("hanxinMobileInfo")+"name="+personName+"&mobile="+phone;
            String json = HttpClientUtils.httpClient(url);
            JSONObject json_phone = JSONObject.parseObject(json);
            Boolean code = json_phone.getBoolean("code");
            if(code){
                if(null != json_phone && !json_phone.equals("")){
                    String content = json_phone.getString("content");
                    if(StringUtil.isNotNull(content)){
                        jsons.put("content",content);
                    }
                    if(StringUtil.isNotNull(content) && content.equals("T")){
                        score = mobilePhoneName1;
                        vr.setCardNameMobileName("一致");
                    }else if(StringUtil.isNotNull(content) && content.equals("F")){
                        score = mobilePhoneName2;
                        vr.setCardNameMobileName("不一致");
                    } else{
                        vr.setCardNameMobileName("不详");
                    }
                }
            }
        }

        weight = weight + score;
        jsons.put("weight",weight);
        return jsons.toJSONString();
    }

    /**
     * 域赢手机是否存在验证 缓存库
     * @param weight
     * @param vr
     * @return
     */
    public static Integer mobliePhone_hx_cache(BusinessCard businessCard, Integer weight, VerificationResult vr,MobilephoneName mobile){
        String phone = businessCard.getCardPhone();
        String personName = businessCard.getCardName();
        Integer score = 0;

        vr.setCardNameMobileName("不详");
        if(StringUtil.isNotNull(phone) && StringUtil.isNotNull(personName)  && StringUtil.isNotNull(mobile.getTimeScore())){

            if(mobile.getTimeScore().equals("T")){
                score = mobilePhoneName1;
                vr.setCardNameMobileName("一致");
            }else if(mobile.getTimeScore().equals("T")){
                score = mobilePhoneName2;
                vr.setCardNameMobileName("不一致");

            } else{
                vr.setCardNameMobileName("不详");
            }
        }

        weight = weight + score;

        return weight;
    }



    /**
     * 域赢 hanxin手机在网时长
     * @param phone
     * @param weight
     * @return
     */
    public static String mobilePhone_mpTime_hx(String phone, Integer weight){
        JSONObject jsons = new JSONObject();
        if(StringUtil.isNotNull(phone)){
            phone = Tool.formatePhone(phone);

            //调用翰信手机在线时长接口地址
            String url = Tool.loadCommonUrl("hanxinMobileTime")+"mobile="+phone;
            String json = HttpClientUtils.httpClient(url);
            JSONObject json_phone = JSONObject.parseObject(json);
            Boolean code = json_phone.getBoolean("code");
            if(code){
                if(null != json_phone && !json_phone.equals("")){
                    String content = json_phone.getString("content");
                    if(null != content){
                        if(null != content && !content.equals("")){
                            if(content.equals("A")){
                                weight = weight + mobilePhoneTime4 ;
                            }
                            if(content.equals("B")){
                                weight = weight + mobilePhoneTime3;
                            }
                            if(content.equals("C")){
                                weight = weight + mobilePhoneTime2;
                            }
                            if(content.equals("D")){
                                weight = weight + mobilePhoneTime2;
                            }
                            if(content.equals("E")){
                                weight = weight + mobilePhoneTime1;
                            }
                        }
                        jsons.put("content",content);
                    }

                }
            }
        }
        jsons.put("weight",weight);
        return jsons.toJSONString();

    }

    /**
     * 域赢 hanxin手机在网时长 缓存库
     * @param phone
     * @param weight
     * @return
     */
    public static Integer mobilePhone_mpTime_hx_cache(String phone, Integer weight,MobilephoneName mobile){

        if(StringUtil.isNotNull(phone)){
                    if(mobile.getNote().equals("A")){
                        weight = weight + mobilePhoneTime4 ;
                    }
                    if(mobile.getNote().equals("B")){
                        weight = weight + mobilePhoneTime3;
                    }
                    if(mobile.getNote().equals("C")){
                        weight = weight + mobilePhoneTime2;
                    }
                    if(mobile.getNote().equals("D")){
                        weight = weight + mobilePhoneTime2;
                    }
                    if(mobile.getNote().equals("E")){
                        weight = weight + mobilePhoneTime1;
                    }
        }
        return weight;

    }


    public static Integer other_information(String nameCN,FullReport var1,VerificationResult vr,Integer weight){
        //法人信息
        List<Frpositioninfos> frpositioninfos = var1.getFrpositioninfosList();
        //管理层信息
        List<Managements> managements = var1.getManagementsList();
        //股东信息
        List<ShareholderInfos> shareholderInfos = var1.getShareholderInfosList();
        if (StringUtil.isNotNull(frpositioninfos) && StringUtil.isNotNull(managements) || StringUtil.isNotNull(shareholderInfos)){
            for (Frpositioninfos fInfo:frpositioninfos) {
                if(StringUtil.isNotNull(fInfo.getNameCN()) && fInfo.getNameCN().equals(nameCN)){
                    weight += CardNameCompanyName1;
                    vr.setPersonNameCompanyName("一致");
                    return weight;
                }else{
                    weight += CardNameCompanyName2;
                    vr.setPersonNameCompanyName("不一致");
                }
            }
            for (Managements ms : managements){
                if(StringUtil.isNotNull(ms.getNameCN()) && ms.getNameCN().equals(nameCN)){
                    weight += CardNameCompanyName1;
                    vr.setPersonNameCompanyName("一致");
                    return weight;
                }else{
                    weight += CardNameCompanyName2;
                    vr.setPersonNameCompanyName("不一致");
//                    return weight;
                }
            }
            for (ShareholderInfos sInfos:shareholderInfos) {
                if(StringUtil.isNotNull(sInfos.getNameCN()) && sInfos.getNameCN().equals(nameCN)){
                    weight += CardNameCompanyName1;
                    vr.setPersonNameCompanyName("一致");
                    return weight;
                }else{
                    weight += CardNameCompanyName2;
                    vr.setPersonNameCompanyName("不一致");
                }
            }
        }else{
            //TODO 请求外部接口进行计算 外部接口暂时没有 当前默认weight = 0
            weight = weight;
            vr.setPersonNameCompanyName("不一致");
        }


        return weight;
    }
}
