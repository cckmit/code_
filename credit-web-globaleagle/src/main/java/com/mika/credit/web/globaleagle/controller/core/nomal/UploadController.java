package com.mika.credit.web.globaleagle.controller.core.nomal;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.fastdfs.FastDFSClient;
import com.mika.credit.common.util.UtilDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller  
public class UploadController {
    private static Logger logger = Logger.getLogger(UploadController.class);
    /**
     * 上传图片
     * @param file
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/uploadPic")
    public void uploadPic(@RequestParam(value = "file") MultipartFile file,
                       HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("上传图片开始...");
        Map<String, Object> resMap = new HashMap<String,Object>();
        if (file != null) {
            //获取保存的路径，
            String realPath = request.getSession().getServletContext().getRealPath("/upload/pic");
            if (file.isEmpty()) {
                // 未选择文件
                resMap.put("status", "EMPTY");
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
                    String FastDFSPath = FastDFSClient.uploadFile(fileSave, newName);
                    if (FastDFSPath == null || FastDFSPath.equals("")){
                        System.out.println("文件上传失败");
                    } else{
                        resMap.put("status", "OK");
                        resMap.put("filePath", FastDFSPath);
                    }
                } catch (Exception e) {
                    System.out.println("文件上传失败");
                    e.printStackTrace();
                }
            }
        }
        response.setContentType("text/html");
        response.getWriter().write(JSON.toJSONString(resMap));
        return ;
    }

    /**
     * ckEditor 上传文件
     * @param file
     * @param request
     * @param response
     * @param CKEditorFuncNum
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/ckEditorUpload")
    public void ckEditorUpload(@RequestParam("upload") MultipartFile file,//
                          HttpServletRequest request, //
                          HttpServletResponse response,//
                          @RequestParam("CKEditorFuncNum") String CKEditorFuncNum)//
            throws IllegalStateException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String fileName = file.getOriginalFilename();
        String uploadContentType = file.getContentType();
        String expandedName = "";
        if (uploadContentType.equals("image/pjpeg")
                || uploadContentType.equals("image/jpeg")) {
            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
            expandedName = ".jpg";
        } else if (uploadContentType.equals("image/png")
                || uploadContentType.equals("image/x-png")) {
            // IE6上传的png图片的headimageContentType是"image/x-png"
            expandedName = ".png";
        } else if (uploadContentType.equals("image/gif")) {
            expandedName = ".gif";
        } else if (uploadContentType.equals("image/bmp")) {
            expandedName = ".bmp";
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                    + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
            out.println("</script>");
            return;
        }
        if (file.getSize() > 1024 * 1024) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                    + ",''," + "'文件大小不得大于600k');");
            out.println("</script>");
            return;
        }
        String path = request.getSession().getServletContext().getRealPath("");
        String fileSeparator = System.getProperty("file.separator");
        String subPath = fileSeparator + "upload" + fileSeparator + "ckEditor" + fileSeparator + UtilDateTime.nowYearMonthString() + fileSeparator;

        File targetFile = new File(path + subPath, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        // 返回"图像"选项卡并显示图片  request.getContextPath()为web项目名
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                + ",'" + (request.getContextPath() + subPath).replaceAll("\\\\", "/") + fileName + "','')");
        out.println("</script>");
        return;
    }
}  