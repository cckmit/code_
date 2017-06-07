package com.mika.credit.facade.gugu.service;

/**
 * Created by dong jian hua on 2017/4/18.
 */
public interface GongShangService {

    /**
     * 获取工商信息
     *
     * @param data
     * @return
     */
    String gongShangInfo(String data);

    /**
     * 更新工商信息
     *
     * @param data
     * @return
     */
    String updateGongshang(String data);

    /**
     * 工商变更
     *
     * @param data
     * @return
     */
    String gongShangList(String data);

    /**
     * 工商股东列表
     *
     * @param data
     * @return
     */
    String shareholderList(String data);

    /**
     *工商管理层列表
     * @param data
     * @return
     */
    String gongShangManagements(String data);

    /**
     * 工商法院公告
     * @param data
     * @return
     */
    String gongShangLegalNotic(String data);

    /**
     * 工商裁判文书
     * @param data
     * @return
     */
    String gongShangAdjudicationInfo(String data);

    /**
     * 工商被执行人列表
     * @param data
     * @return
     */
    String gongShangEnforce(String data);

    /**
     * 工商失信被执行人列表
     * @param data
     * @return
     */
    String gongShangUncreditEnforce(String data);

    /**
     * 工商失经营异常列表
     * @param data
     * @return
     */
    String gongShangBusinessAbnormity(String data);

    /**
     * 工商新闻列表
     * @param data
     * @return
     */
    String gongShangNews(String data);

    /**
     * 工商专利列表
     * @param data
     * @return
     */
    String gongShangPatent(String data);

    /**
     * 工商注册列表
     * @param data
     * @return
     */
    String gongShangRegistrationinfo(String data);

    /**
     * 工商网站列表
     * @param data
     * @return
     */
    String gongShangWebSite(String data);

    /**
     * 工商年报列表
     * @param data
     * @return
     */
    String gongShangFinancial(String data);



}


