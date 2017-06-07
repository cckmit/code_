package com.mika.credit.facade.gugu.service;


import com.mika.credit.facade.gugu.model.ShareRecord;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Mike on 2017/4/13.
 */
public interface ShareRecordService {

    String shareRecord(String data,String file,String webPath);

    ShareRecord getShareRecordById(Integer id);


}
