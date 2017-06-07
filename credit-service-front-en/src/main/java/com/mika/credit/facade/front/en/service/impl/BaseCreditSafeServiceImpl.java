package com.mika.credit.facade.front.en.service.impl;

import com.creditsafe.globaldata.operations.GlobalDataService;
import org.apache.log4j.Logger;
import org.tempuri.MainServiceBasic;


/**
 * Created by mika on 2016/5/19.
 */
public class BaseCreditSafeServiceImpl{

    private static Logger logger = Logger.getLogger(BaseCreditSafeServiceImpl.class);

    private static MainServiceBasic mainServiceBasic;

    public static MainServiceBasic getMainServiceBasic() {
        if (mainServiceBasic == null) {
            mainServiceBasic = new MainServiceBasic();
        }
        return mainServiceBasic;
    }
    public GlobalDataService getGlobalDataService(){
        logger.debug("getGlobalDataService 开始");
        GlobalDataService globalDataService;
        globalDataService = getMainServiceBasic().getBasicHttpBindingGlobalDataService();
        if(globalDataService == null){
            logger.info("getGlobalDataService 获取失败");
        }
        else{
            logger.info("getGlobalDataService 获取成功");
        }
        logger.debug("getGlobalDataService 结束");
        return globalDataService;
    }
}
