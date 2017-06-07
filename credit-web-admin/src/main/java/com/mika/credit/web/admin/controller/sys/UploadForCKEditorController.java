package com.mika.credit.web.admin.controller.sys;

import com.mika.credit.common.util.UtilDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yugp on 2016/6/17.
 */
@Controller
public class UploadForCKEditorController {
    @RequestMapping("/basic/uploadForCKEditor")
    public void uplodaImg(@RequestParam("upload") MultipartFile file,//
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
        String subPath = fileSeparator + "upload" + fileSeparator + UtilDateTime.nowYearMonthString() + fileSeparator;

        File targetFile = new File(path + subPath, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        // 返回"图像"选项卡并显示图片  request.getContextPath()为web项目名
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                + ",'" + subPath.replaceAll("\\\\", "/") + fileName + "','')");
        out.println("</script>");
        return;
    }
}
