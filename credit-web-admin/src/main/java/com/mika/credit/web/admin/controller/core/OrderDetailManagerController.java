package com.mika.credit.web.admin.controller.core;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.OrderDetailQuery;
import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.order.OrderDetailViewQuery;
import com.mika.credit.common.fastdfs.FastDFSClient;
import com.mika.credit.facade.order.service.OrderDetailViewService;
import com.mika.credit.facade.order.service.OrderService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderDetailManagerController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailViewService orderDetailViewService;


//	@Autowired
//	private SearchDetailService searchDetailService;


//	@Autowired
//	private CustomerService customerService;


	/**
	 * 报告页面 AJAX
	 * @param grid
	 * @return
	 */
	@RequestMapping(value = "/core/orderDetailList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	 public @ResponseBody String customOrderDetailList(BootGrid<OrderDetailView> grid, OrderDetailViewQuery example) {
		BootGrid<OrderDetailView> result;
		result = orderDetailViewService.findByExample(grid,example);
		return JSON.toJSONString(result);
	}

//	/**
//	 *
//	 * 英语报告
//	 * @param request
//	 * @param companyId
//	 * @param orderDetailId
//	 * @param orderId
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping(value = "/manager/requestCompanyDetail")
//	public String showReport(HttpServletRequest request, String companyId, String orderDetailId, String orderId, ModelMap map) {
//		OrderDetail od = orderDetailService.getOrderDetailById(Integer.parseInt(orderDetailId));
//		LtdCompanyFullReport report = searchDetailService.getOrderDetailJsonById(companyId,od.getId());
//		Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
//		String countryCnName = "";
//		if (companyId != null) {
//			Order o = orderService.getOrderById(Integer.parseInt(orderId));
//			List<Country> countryList = countryService.getCountries().getRows();
//			for (Country c : countryList) {
//				if (c.getId().intValue()== od.getCountryId().intValue()) {
//					countryCnName=c.getCnName();
//					map.put("countryId", od.getCountryId().intValue());
//					map.put("cnName",countryCnName );
//					map.put("enName", c.getEnName());
//					map.put("countryCode", c.getCode());
//				}
//			}
//			map.put("order", o);
//			map.put("email", o.getSendEmail());
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			map.put("crefoNo", companyId);
//			map.put("orderDetail", od);
//			map.put("companyName", od.getCompanyName());
//			map.put("createDate", dateFormat.format(od.getCreateDate()));
//			if (report != null) {
//				map.addAttribute("searchDetail",report);
//			}else{
//				map.addAttribute("message", "false");
//			}
//		} else {
//			map.addAttribute("message", "公司编号不能为空");
//		}
//
//
//		//帮助相关
//		Help helpCondition = new Help();
//		HelpCate helpcate = new HelpCate();
//		helpcate.setId(3);
//		helpCondition.setCate(helpcate);
//		BootGrid<Help> grid = new BootGrid<>();
//		helpservice.getHelps(helpCondition, grid);
//		map.put("helpListReport", grid.getRows());
//		if (countryCnName.equals("美国") || countryCnName == "美国") {
//			return "creditsafe/reports/report_US";
//		}
//		if (countryCnName.equals("英国") || countryCnName == "英国") {
//			return "creditsafe/reports/report_GB";
//		}
//		if (countryCnName.equals("德国") || countryCnName == "德国") {
//			return "creditsafe/reports/report_DE";
//		}
//		if (countryCnName.equals("法国") || countryCnName == "法国") {
//			return "creditsafe/reports/report_FR";
//		}
//		if (countryCnName.equals("卢森堡") || countryCnName == "卢森堡") {
//			return "creditsafe/reports/report_LU";
//		}
//		if (countryCnName.equals("挪威") || countryCnName == "挪威") {
//			return "creditsafe/reports/report_NO";
//		}
//		if (countryCnName.equals("西班牙") || countryCnName == "西班牙") {
//			return "creditsafe/reports/report_ES";
//		}
//		if (countryCnName.equals("荷兰") || countryCnName == "荷兰") {
//			return "creditsafe/reports/report_NL";
//		}
//		if (countryCnName.equals("比利时") || countryCnName == "比利时") {
//			return "creditsafe/reports/report_BE";
//		}
//		if (countryCnName.equals("丹麦") || countryCnName == "丹麦") {
//			return "creditsafe/reports/report_DK";
//		}
//		if (countryCnName.equals("意大利") || countryCnName == "意大利") {
//			return "creditsafe/reports/report_IT";
//		}
//		if (countryCnName.equals("墨西哥") || countryCnName == "墨西哥") {
//			return "creditsafe/reports/report_MX";
//		}
//		if (countryCnName.equals("瑞典") || countryCnName == "瑞典") {
//			return "creditsafe/reports/report_SE";
//		}
//		if (countryCnName.equals("韩国") || countryCnName == "韩国") {
//			return "creditsafe/reports/report_KR";
//		}
//		if (countryCnName.equals("葡萄牙") || countryCnName == "葡萄牙") {
//			return "creditsafe/reports/report_PT";
//		}
//		return "creditsafe/requestCompanyDetail2";
//	}
//	/**
//	 * 中文报告 2.0
//	 * @param request
//	 * @param response
//	 * @param map
//	 * @param crefoNo
//	 * @param orderDetailId
//	 * @param orderId
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/manager/viewReportV1.do")
//	public String financialFigure(HttpServletRequest request, HttpServletResponse response, ModelMap map, String crefoNo, String orderDetailId, String orderId) throws Exception {
//		boolean flag = true;
//		OrderDetail od = orderService.getOrderDetailById(Integer.parseInt(orderDetailId));
//		String jsonData = orderService.getOrderDetailJsonById(Integer.parseInt(orderDetailId));
//		Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
//		response.setContentType("text/html; charset=UTF-8");
//		response.setCharacterEncoding("utf-8");
//		Order o = orderService.getOrderById(Integer.parseInt(orderId));
//		for (Country c : countryService.getCountries().getRows()) {
//			if (c.getId() == od.getCountryId()) {
//				map.put("cnName", c.getCnName());
//				map.put("enName", c.getEnName());
//			}
//		}
//		map.put("level",od.getOrderLevel());
//		if(customer==null){
//			map.addAttribute("message", "请登录");
//			return "simplePage/login";
//		}else{
//			map.put("customerId", customer.getEmail());
//		}
//		map.put("email", o.getSendEmail());
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		map.put("companyName", od.getCompanyName());
//		map.put("createDate", dateFormat.format(od.getCreateDate()));
//		map.put("email", o.getSendEmail());
//		map.put("crefoNo", crefoNo);
//		map.put("orderDetailId",orderDetailId);
//		map.put("orderId",orderId);
//		//帮助相关
//		Help helpCondition = new Help();
//		HelpCate helpcate = new HelpCate();
//		helpcate.setId(3);
//		helpCondition.setCate(helpcate);
//		BootGrid<Help> grid = new BootGrid<>();
//		helpservice.getHelps(helpCondition, grid);
//		map.put("helpListReport", grid.getRows());
//
//		//从数据库中提取艾哥数据
//		if (jsonData==null){
//			map.addAttribute("message", "false");
//		}else{
//			Map<String, Object> jsonResult = JSON.parseObject(jsonData, Map.class);
//			map.putAll(jsonResult);
//			if (flag) {
//				od.setOnlineDataJson(JSON.toJSONString(map));
//				int a = orderDetailService.modifyOrderDetail(od);
//				if (a < 0) {
//					map.addAttribute("message", "报告缓存数据错误");
//				}
//			}}
//		return "simplePage/cpm/report";
//	}


	@RequestMapping(value = "/core/reGetOrderDatail",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String reGetOrderDatail(String id) {
//		Customer customer = new Customer();
//		customer.setEmail("service@3acredit.com");
//		customer.setPasswd("888888");
//		SimpleResult<Customer> customerResult = customerService.getLoginInfo(customer);
//		request.getSession().setAttribute("customerInfo",customerResult.getResultcontent());
//		try{
//			customerName = URLDecoder.decode(customerName,"UTF-8");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		ResponseResult<OrderDetail> result = new ResponseResult();
//		List<Map<String, String>> companyInfos = new ArrayList<>();
//		Integer primaryId = 0;
//		if(id == null || "".equals(id)){
//			result.setCode(false);
//			result.setMsg("报告id不能为空");
//			return JSON.toJSONString(result);
//		}else{
//			primaryId = Integer.parseInt(id);
//		}
//		if(customerName == null || "".equals(customerName)){
//			result.setCode(false);
//			result.setMsg("报告客户信息不能为空");
//			return JSON.toJSONString(result);
//		}
//		OrderDetail details = orderService.findOrderDetailById(Long.parseLong(primaryId+""));
//		Map<String, String> companyInfo = new HashMap();
//		companyInfo.put("id", details.getId().toString());
//		companyInfo.put("email", customerName);
//		companyInfo.put("companyName",details.getCompanyName());
//		companyInfos.add(companyInfo);
		orderService.reloadData(Long.parseLong(id+""));
		return JSON.toJSONString(result);
	}
	
	/**
	 * 删除订单详情
	 *
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/core/delOrderDetail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String delOrderDetail(OrderDetail orderDetail) {
		ResponseResult<OrderDetail> result;
		result = orderService.deleteOrderDetailPhysical(orderDetail.getId());
		return JSON.toJSONString(result);
	}


	/**
	 * 上传PDF文件
	 *
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/core/updateUpload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void updateUpload(@RequestParam(value = "multfile")MultipartFile multfile, HttpServletRequest request, HttpServletResponse response,OrderDetail orderDetail)throws IOException {
		ResponseResult<OrderDetail> result=null;
		Map<String,Object> resMap = new HashMap<String,Object>();
		if (multfile != null) {
			//获取保存的路径，
			String realPath = request.getSession().getServletContext().getRealPath("/upload/pic");
			if (multfile.isEmpty()) {
				// 未选择文件
				resMap.put("status", "EMPTY");
			} else{
				String originalFilename = multfile.getOriginalFilename();
				String img = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
				String newName=realPath+System.currentTimeMillis()+img;
				try {
					//这里使用Apache的FileUtils方法来进行保存
//					FileUtils.copyInputStreamToFile(multfile.getInputStream(),
//							new File(realPath, newName));
//					File fileSave = new File(realPath, newName);

					File fileSave = new File(newName);

					FileUtils.copyInputStreamToFile(multfile.getInputStream(), fileSave);


					String FastDFSPath = FastDFSClient.uploadFile(fileSave,newName);
					if (FastDFSPath==null||FastDFSPath.equals("")){
						System.out.println("文件上传失败！");
						resMap.put("msg", "文件上传失败！");
						resMap.put("code", false);
					}else{
						orderDetail.setPathFile(FastDFSPath);
						result = orderService.updateUpload(orderDetail);
						resMap.put("msg", "报告文件上传成功！");
						resMap.put("code", true);
						resMap.put("status", "OK");
						resMap.put("filePath",FastDFSPath);
					}
				} catch (Exception e) {
					System.out.println("文件上传失败!");
					resMap.put("msg", "文件上传失败");
					resMap.put("code", false);
					e.printStackTrace();
				}
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(JSON.toJSONString(resMap));
		return;
//					CommonsMultipartFile cf= (CommonsMultipartFile)multfile;
//					DiskFileItem fi = (DiskFileItem)cf.getFileItem();
//					File fileSave = fi.getStoreLocation();
//					//手动创建临时文件
//					if(fileSave.length() < CommonConstants.MIN_FILE_SIZE){
//						File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
//								fileSave.getName());
//						multfile.transferTo(tmpFile);
//					}
//		return JSON.toJSONString(result);
	}


//	/**l
//	 * 修改报告支付状态
//	 * @param grid
//	 * @param condition
//	 * @param customer
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping(value = "/manager/orderDetailListIsPayAndNotCancel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
//	public @ResponseBody String customOrderDetailListIsPayAndNotCancel(BootGrid<OrderDetail> grid,OrderDetailQuery condition, @SessionAttribute("customerInfo") Customer customer,ModelMap map) {
//		String msg = "";
//		if(condition.getCompanyName()!=null && !condition.getCompanyName().equals("")){
//			msg+="公司名不能为空";
//		}
//		if(condition.getCountryId()!=null ){
//			msg+="国家不能为空";
//		}
//		if(condition.getOrderStatusId()!=null){
//			msg+="订单状态不能为空";
//		}
//		if(condition.getOrderLevel()!=null ){
//			msg+="订单类别不能为空";
//		}
//		if(condition.getOrderId()!=null){
//			msg+="订单id不能为空";
//		}
//		condition.setCustomerId(customer.getId());
//		condition.setIsPay("是");
//		BootGrid<OrderDetail> result;
//		if(msg.equals("")){
//			result = new BootGrid<>();
//		}
//		else{
//			result = orderService.getOrderDetails(grid,condition);
//		}
//		return JSON.toJSONString(result);
//	}



//	/**
//	 * excel下载对账单
//	 * @param
//	 * @param
//	 * @param
//	 * @param
//	 * @return
//	 */
//	@RequestMapping(value = "/manager/orderDetailListExcelDown",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//	public @ResponseBody void orderDetailListExcelDown(HttpServletResponse response,@SessionAttribute("customerInfo") Customer customer,OrderDetailQuery condition) {
//		if (customer ==null){
//		}else {
//			HSSFWorkbook workbook = orderService.getStatementExcelDown(customer,condition);
//			String fileName = UtilGenerateID.generateID("GlobalEagleStatement") + ".xls";
//			//清空response
//			response.reset();
//			// 设置response的Header
//			response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
//			try {
//				workbook.write(response.getOutputStream());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}



}