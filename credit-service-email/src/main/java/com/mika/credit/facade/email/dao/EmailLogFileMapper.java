package com.mika.credit.facade.email.dao;

import com.mika.credit.facade.email.model.EmailLogFile;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailLogFileMapper {

    EmailLogFile selectByPrimaryKey(Integer id);

    int insertSelective(EmailLogFile emailDetail);
}