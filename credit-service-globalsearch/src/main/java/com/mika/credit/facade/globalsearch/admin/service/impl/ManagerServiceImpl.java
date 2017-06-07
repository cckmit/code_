package com.mika.credit.facade.globalsearch.admin.service.impl;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.globalsearch.core.dao.CustomerMapper;
import com.mika.credit.facade.globalsearch.core.dao.ManagerMapper;
import com.mika.credit.facade.globalsearch.core.model.Customer;
import com.mika.credit.facade.globalsearch.core.model.Manager;
import com.mika.credit.facade.globalsearch.core.service.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    private static final Logger logger = Logger.getLogger(ManagerServiceImpl.class);
    @Autowired
    private ManagerMapper managerMapper;
    
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 管理员登陆
     * @param manager
     * @return
     */
    @Override
    public ResponseResult<Manager> getLoginInfo(Manager manager) {
        logger.info("管理员登录方法开始...");
        ResponseResult<Manager> result = new ResponseResult<>();
        //账户密码加密
        manager.setPasswd(UtilEncode.encodeMD5(manager.getPasswd()));
        List<Manager> managers = managerMapper.selectSelective(manager);
        Manager managerResult = null;
        if(managers.size()>0){
            managerResult = managers.get(0);
        }
        if(managerResult != null){
            result.setCode(true);
            result.setMsg("Login Success");
            result.setContent(managerResult);
            return result;
        }
        else{
            result.setCode(false);
            result.setMsg("Logon failed");
            return result;
        }
    }

    /**
     * 客户充值
     * @param cBalance
     * @param customerId
     * @return
     */
    @Override
    public boolean confirmCustomerRecharge(float cBalance,int customerId){
        logger.info("客户充值方法开始...");
    	Customer c = null;
    	Customer customer = null;
    	c.setId(customerId);
    	List<Customer>cList = customerMapper.selectSelective(c);
    	if (cList.size()>0) {
    		customer = cList.get(0);
    		customer.setBalance(cBalance);
    		int updateSel = customerMapper.updateByPrimaryKeySelective(customer);
    		if (updateSel>0) {
    			return true;
			}else {
				return false;
			}
		}else{
	    	return false;
		}
    }


}
