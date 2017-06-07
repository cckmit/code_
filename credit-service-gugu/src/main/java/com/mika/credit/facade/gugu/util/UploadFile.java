package com.mika.credit.facade.gugu.util;

import com.mika.credit.common.fastdfs.FastDFSClient;
import com.mika.credit.common.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

/**
 * Created by Mike on 2017/4/15.
 */
public class UploadFile {

    /**
     * 上传分布式文件系统
     *
     * @param file
     * @return
     */
    public static String uploadMufile(MultipartFile file) {
        String path = null;
        if (file != null) {
            //获取保存的路径，
            String realPath =  UploadFile.class.getClass().getResource("/").getPath();;
            if (file.isEmpty()) {
            } else{
                String originalFilename = file.getOriginalFilename();
                int offset = originalFilename.lastIndexOf(".");
                int length = originalFilename.length();
                String extName = originalFilename.substring(offset, length);
                String newName = new Date().getTime() + extName;
                try {
                    //这里使用Apache的FileUtils方法来进行保存
                    FileUtils.copyInputStreamToFile(file.getInputStream(),
                            new File(realPath, newName));
                    File fileSave = new File(realPath, newName);
                    path = FastDFSClient.uploadFile(fileSave, newName);
                    if (StringUtil.isNotNull(path)){
                        delFile(realPath+newName);
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return path;
    }

    /**
     * 删除文件
     * @param filePath
     */
    public static void delFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile()) {
            file.delete();
        }
    }
}
