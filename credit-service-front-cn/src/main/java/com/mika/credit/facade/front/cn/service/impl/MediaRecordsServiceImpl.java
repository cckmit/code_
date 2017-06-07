package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.MediaRecords;
import com.mika.credit.facade.front.cn.dao.MediaRecordsDao;
import com.mika.credit.facade.front.cn.service.MediaRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("mediaRecordsService")
public class MediaRecordsServiceImpl implements MediaRecordsService {
    @Autowired
    MediaRecordsDao mediaRecordsDao;


    @Override
    public MediaRecords findById(Integer id) {
        return mediaRecordsDao.findById(id);
    }

    @Override
    public List<MediaRecords> findByFullReportId(Integer fullReportId) {
        return mediaRecordsDao.findByFullReportId(fullReportId);
    }
}
