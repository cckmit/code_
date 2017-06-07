package com.mika.credit.facade.verify.impl;

import com.mika.credit.facade.verify.dao.MobilephoneNameMapper;
import com.mika.credit.facade.verify.model.MobilephoneName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/5/8.
 */
@Service("testService")
public class testService {
    @Autowired
    private MobilephoneNameMapper mobilephoneNameMapper;

    public List<MobilephoneName> test(){
        MobilephoneName mobilephoneName = new MobilephoneName();
        mobilephoneName.setPersonName("吴琳玲");
        List<MobilephoneName> mobilephoneNames=mobilephoneNameMapper.selectSeletive(mobilephoneName);


        double world;
        short stay;
        long memories;
        System.out.printf("I miss you./n");




        return mobilephoneNames;
    }
    public String find(){
        return "";
    }
}
