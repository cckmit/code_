package com.mika.credit.web.gugu.controller;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.service.*;
import com.mika.credit.web.gugu.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

/**
 * Created by Mike on 2017/4/12.
 */
@Controller
public class GuGuController {
    @Autowired
    BusinessCardService businessCardService;
    @Autowired
    CardNoteService cardNoteService;
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    IconRecordService iconRecordService;
    @Autowired
    InformService informService;
    @Autowired
    RegionService regionService;
    @Autowired
    ShareRecordService shareRecordService;
    @Autowired
    UserService userService;
    @Autowired
    VersionService versionService;
    @Autowired
    ScanningCardService scanningCardService;
    @Autowired
    IndexDetailService indexDetailService;
    @Autowired
    CertificationService certificationService;
    @Autowired
    VerificationResultService verificationResultService;
    @Autowired
    GongShangService gongShangService;
    @Autowired
    OrderInfoService orderInfoService;
    @Autowired
    RechargeService rechargeService;
    @Autowired
    PublicizeService publicizeService;
    @Autowired
    FinancingService financingService;
    @Autowired
    private MessageQuestionService messageQuestionService;

    @RequestMapping(value = "/appServiceForUser")
    public String appServiceForUser(HttpServletRequest request, HttpServletResponse response,String methodCode , String data, ModelMap map) {
        String json = null;
        //判断参数
        if (StringUtil.isNotNull(methodCode)&&StringUtil.isNotNull(data)){
            if (methodCode.equals("001")){
                //登录
                json = userService.userLogin(data);
            }else if (methodCode.equals("002")){
                //注册
                json = userService.userRegister(data);
            }else if (methodCode.equals("701")){
                //发送验证码
                json = userService.sendVerificationCode(data);
            }else if (methodCode.equals("702")){
                //核实验证码
                json = userService.verifyVerificationCode(data);
            }else if (methodCode.equals("703")){
                //通过username修改密码
                json = userService.changeUserPwd(data);
            }else if (methodCode.equals("704")){
                //通过手机号获取用户信息
                json = userService.getUser(data);
            }
            map.addAttribute("content",json);
        }else{
            ResponseResult<String> result = new ResponseResult<>();
            result.setCode(false);
            result.setMsg("参数错误！");
            map.addAttribute("content",JSON.toJSONString(result));
        }
        return "/content";
    }

    @RequestMapping(value = "/appServiceForOperation")
    public String appServiceForOperation(HttpServletRequest request, HttpServletResponse response, String methodCode , Integer userId, String token , String data,ModelMap map) {
        String json = null;
        //判断参数
        if (StringUtil.isNotNull(methodCode)&&StringUtil.isNotNull(data)&&StringUtil.isNotNull(userId)&&StringUtil.isNotNull(token)){
            //判断token
            if (!userService.judgeToken(userId,token)){
                ResponseResult<String> result = new ResponseResult<>();
                result.setCode(false);
                result.setMsg("该账户token已过期或已在其他终端登录！");
                map.addAttribute("content",JSON.toJSONString(result));
                return "/content";
            }
            if (methodCode.equals("003")){
                //获取用户资料
                json = userService.getUserInfo(data);
            }else if (methodCode.equals("004")){
                //修改用户资料
                json = userService.changeUserInfo(data);
            }else if (methodCode.equals("005")){
                //上传用户头像图片
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String path = UploadFile.uploadMufile(request,multipartFile);
                json = userService.changeUserPic(data,path);
            }else if (methodCode.equals("101")){
                //新增名片信息
                json = businessCardService.add(data);
            } else if (methodCode.equals("102")) {
                //编辑名片信息
                json = businessCardService.updateByPrimaryKeySelective(data);
            }else if (methodCode.equals("103")) {
                //根据id删除名片信息
                json = businessCardService.deleteByPrimaryKey(data);
            }else if (methodCode.equals("104")) {
                //根据id获取名片信息
                json = businessCardService.selectByPrimaryKey(data);
            }else if (methodCode.equals("105")) {
                //获取名片信息列表
                json = businessCardService.selectByPrimaryKeySelective(data);
            } else if (methodCode.equals("106")){
                //上传名片头像图片
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String path = UploadFile.uploadMufile(request,multipartFile);
                json = businessCardService.updatePic(data,path);
            }else if (methodCode.equals("107")) {
                //批量新增名片信息
                json = businessCardService.addList(data);
            }else if(methodCode.equals("201")){
                //核实名片
                json = certificationService.addVerifyOrder(data);
            }else if(methodCode.equals("202")){
                //获取名片核实信息
                json = verificationResultService.getVerificationResultInfo(data);
            }else if(methodCode.equals("203")){
                //获取工商信息
                json = gongShangService.gongShangInfo(data);
//            }else if(methodCode.equals("204")){
//                //更新工商信息
//                json = gongShangService.updateGongshang(data);
            }else if(methodCode.equals("204")){
                //工商变更
                json = gongShangService.gongShangList(data);
            }else if(methodCode.equals("205")){
                //工商股东列表
                json = gongShangService.shareholderList(data);
            }else if(methodCode.equals("206")){
                //工商管理层列表
                json = gongShangService.gongShangManagements(data);
            }else if(methodCode.equals("207")){
                //工商法院公告
                json = gongShangService.gongShangLegalNotic(data);
            }else if(methodCode.equals("208")){
                //工商裁判文书
                json = gongShangService.gongShangAdjudicationInfo(data);
            }else if(methodCode.equals("209")){
                //工商被执行人列表
                json = gongShangService.gongShangEnforce(data);
            }else if(methodCode.equals("210")){
                //工商失信被执行人列表
                json = gongShangService.gongShangUncreditEnforce(data);
            }else if(methodCode.equals("211")){
                //工商失经营异常列表
                json = gongShangService.gongShangBusinessAbnormity(data);
            }else if(methodCode.equals("212")){
                //工商新闻列表
                json = gongShangService.gongShangNews(data);
            }else if(methodCode.equals("213")){
                //工商专利列表
                json = gongShangService.gongShangPatent(data);
            }else if(methodCode.equals("214")){
                //工商注册列表
                json = gongShangService.gongShangRegistrationinfo(data);
            }else if(methodCode.equals("215")){
                //工商网站列表
                json = gongShangService.gongShangWebSite(data);
            }else if(methodCode.equals("216")){
                //工商年报列表
                json = gongShangService.gongShangFinancial(data);
            } else if(methodCode.equals("301")){
                //订单列表
                json = orderInfoService.orderList(data);
            }else if(methodCode.equals("302")){
                //订单详情
                json = orderInfoService.orderDetail(data);
            }else if(methodCode.equals("303")){
                //认购(认证)
                json = certificationService.addMobiletOrder(data);
            }else if(methodCode.equals("304")){
                //认证(根据companyName、userId)
                json = certificationService.addsubscribe(data);
            }else if(methodCode.equals("305")){
                //获取认证信息
                json = verificationResultService.authInfo(data);
            /*}else if(methodCode.equals("306")){
                //获取最新认证
                json = verificationResultService.newAuthInfo(data);*/
            }else if(methodCode.equals("306")){
                //认证列表(名片已认证)
                json = verificationResultService.cardListByCertification(data);
            }else if(methodCode.equals("307")){
                //商圈查看认证信息
                json = verificationResultService.cerificationInfo(data);
            }else if (methodCode.equals("501")){
                //新增企业推广信息
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String path = UploadFile.uploadMufile(request,multipartFile);
                json = publicizeService.addPublicize(data,path);
            } else if (methodCode.equals("502")) {
                //编辑企业推广信息
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String path = UploadFile.uploadMufile(request,multipartFile);
                json = publicizeService.updateSelectivePublicize(data,path);
            }else if (methodCode.equals("503")) {
                //删除企业推广信息
                json = publicizeService.deleteByPrimaryKeyPublicize(data);
            }else if (methodCode.equals("504")) {
                //获取企业推广信息
                json = publicizeService.selectByPrimaryKeyPublicize(data);
            }else if (methodCode.equals("505")) {
                //企业推广信息列表
                json = publicizeService.selectSelectivePublicize(data);
            }else if (methodCode.equals("506")){
                //新增企业推广标签
                json = publicizeService.addPublicizeFlag(data);
            } else if (methodCode.equals("507")) {
                //编辑企业推广标签
                json = publicizeService.updateSelectivePublicizeFlag(data);
            }else if (methodCode.equals("508")) {
                //删除企业推广标签
                json = publicizeService.deleteByPrimaryKeyPublicizeFlag(data);
            }else if (methodCode.equals("509")) {
                //获取企业推广标签
                json = publicizeService.selectByPrimaryKeyPublicizeFlag(data);
            }else if (methodCode.equals("510")) {
                //企业推广标签列表
                json = publicizeService.selectSelectivePublicizeFlag(data);
            }else if (methodCode.equals("511")){
                //上传推广图片
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String path = UploadFile.uploadMufile(request,multipartFile);
                json = publicizeService.updatePic(data,path);
            } else if (methodCode.equals("512")) {
                //删除推广图片
                json = publicizeService.deleteByPrimaryKeyPublicizePhoto(data);
            }else if (methodCode.equals("513")) {
                //获取推广图片
                json = publicizeService.selectByPrimaryKeyPublicizePhoto(data);
            }else if (methodCode.equals("514")) {
                //推广图片列表
                json = publicizeService.selectSelectivePublicizePhoto(data);
            } else if (methodCode.equals("601")){
                //通知列表
                json = informService.getInformList(data);
            }else if (methodCode.equals("602")){
                //通知标记为已阅
                json = informService.isInformRead(data);
            }else if (methodCode.equals("603")){
                //删除通知
                json = informService.deleteInform(data);
            }else if (methodCode.equals("604")){
                //获取通知信息
                json = informService.getInformInfo(data);

            }else if (methodCode.equals("801")){
                //新增名片备注
                json = cardNoteService.add(data);
            } else if (methodCode.equals("802")) {
                //编辑名片备注
                json = cardNoteService.updateByPrimaryKeySelective(data);
            }else if (methodCode.equals("803")) {
                //获取名片备注
                json = cardNoteService.selectByPrimaryKey(data);
            }else if (methodCode.equals("804")) {
                //名片备注列表
                json = cardNoteService.selectByPrimaryKeySelective(data);
            }else if (methodCode.equals("805")) {
                //删除名片备注
                json = cardNoteService.deleteByPrimaryKey(data);
            }else if (methodCode.equals("901")){
                //新增扫描名片信息
                json = scanningCardService.add(data);
            } else if (methodCode.equals("902")) {
                //更新扫描名片
                json = scanningCardService.updateByPrimaryKeySelective(data);
            }else if (methodCode.equals("903")) {
                //根据id删除扫描名片
                json = scanningCardService.deleteByPrimaryKey(data);
            }else if (methodCode.equals("904")) {
                //根据id获取扫描名片
                json = scanningCardService.selectByPrimaryKey(data);
            }else if (methodCode.equals("905")) {
                //获取扫描名片列表
                json = scanningCardService.selectByPrimaryKeySelective(data);
            } else if (methodCode.equals("906")){
                //上传扫描名片头像
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String path = UploadFile.uploadMufile(request,multipartFile);
                json = scanningCardService.updatePic(data,path);
            }else if (methodCode.equals("1001")){
                //用户已定制图标
                json = iconRecordService.getCustomIconList(data);
            }else if (methodCode.equals("1002")){
                //编辑用户定制图标
//                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//                MultipartFile multipartFile = fileMap.get("file");
//                String path = UploadFile.uploadMufile(request,multipartFile);
                String path = "";
                json = iconRecordService.saveOrUpdateCustomerIcon(data,path);
            }else if(methodCode.equals("1101")){
                //充值列表
                json = rechargeService.rechargeList(data);
            }else if(methodCode.equals("1102")){
                //充值金额
                json = rechargeService.rechargeAmount(data);
            }else if (methodCode.equals("1201")) {
                //搜索列表
                json = indexDetailService.fillCompanyIndex(data);
            }else if (methodCode.equals("1202")) {
                //目标对象详情
                json = indexDetailService.targetRegistration(data);
            }else if(methodCode.equals("1203")){
                //获取搜索目标工商信息
                json = indexDetailService.searchRegistration(data);
            }else if(methodCode.equals("1204")){
                //获取搜索目标基本信息
                json = indexDetailService.basicInfoDetail(data);
            }else if (methodCode.equals("1301")){
                //获取最新版本
                json = versionService.getVersionInfo(data);
            }else if (methodCode.equals("1401")){
                //获取国、省、市、区地区代码
                json = regionService.getRegionList(data);
            }else if (methodCode.equals("1501")){
                //新增反馈
                json = feedbackService.addFeedback(data);
            }else if (methodCode.equals("1601")){
                //在线问答发送消息message
                json = messageQuestionService.sendMessage(data);
            }else if (methodCode.equals("1602")){
                //查询消息框中的聊天内容
                json = messageQuestionService.findMessagesByUserId(data);
            }else if (methodCode.equals("1603")){
                //查询接收的对话
                json = messageQuestionService.findUnreadMessagesByToId(data);
            }else if (methodCode.equals("1604")){
                //将未读消息修改成已读消息
                json = messageQuestionService.updateMessageByFromId(data);
            }else if (methodCode.equals("1701")){
                //分享
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String filePath = UploadFile.uploadMufile(request,multipartFile);
                //获取项目路径
                String path = request.getContextPath();
                String webPath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
                json = shareRecordService.shareRecord(data,filePath,webPath);
            }else if (methodCode.equals("1801")){
                //新增融资服务
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String path = UploadFile.uploadMufile(request,multipartFile);
                json = financingService.add(data,path);
            } else if (methodCode.equals("1802")) {
                //编辑融资服务
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                MultipartFile multipartFile = fileMap.get("file");
                String path = UploadFile.uploadMufile(request,multipartFile);
                json = financingService.updateByPrimaryKeySelective(data,path);
            }else if (methodCode.equals("1803")) {
                //删除融资服务
                json = financingService.deleteByPrimaryKey(data);
            }else if (methodCode.equals("1804")) {
                //获取融资服务
                json = financingService.selectByPrimaryKey(data);
            }else if (methodCode.equals("1805")) {
                //融资服务列表
                json = financingService.selectSelective(data);
            }
            map.addAttribute("content",json);
        }else{
            ResponseResult<String> result = new ResponseResult<>();
            result.setCode(false);
            result.setMsg("参数错误！");
            map.addAttribute("content",JSON.toJSONString(result));
        }
        return "/content";
    }

}
