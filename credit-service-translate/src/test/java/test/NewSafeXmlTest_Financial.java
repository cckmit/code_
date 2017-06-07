package test;

public class NewSafeXmlTest_Financial {
	static String crefoNo = "9367119860";
	
	
//	public static void main(String[] args) {
////		crefoNo = "9360484868";
//		 long startTime=System.currentTimeMillis();   //获取开始时间
//		String nameCN = "",data = "",Reg = "";
//		Element root = DocumentHelper.createElement("Root");
//		Document Doc = DocumentHelper.createDocument(root);
//		TranslateBasicInfosImpl Enterprises = new TranslateBasicInfosImpl();
//		TranslateRegistrationInfosImpl register = new TranslateRegistrationInfosImpl();
//		TranslateFrinvinfosImpl frinfos = new TranslateFrinvinfosImpl();
//		TranslateRelatedCompaniesImpl relation = new TranslateRelatedCompaniesImpl();
//		TranslateShareholderImpl share = new TranslateShareholderImpl();
//		TranslateChangeInfosImpl change = new TranslateChangeInfosImpl();
//		TranslateManagementsImpl manage = new TranslateManagementsImpl();
//		TranslateOperatingsImpl operat = new TranslateOperatingsImpl();
//		TranslateBankInfoImpl bank = new TranslateBankInfoImpl();
//		TranslatePaymentHistoriesImpl record = new TranslatePaymentHistoriesImpl();
//		NewXMLIndustryConditionsImpl indestry = new NewXMLIndustryConditionsImpl();
//		TranslateTradeReferencesImpl trade = new TranslateTradeReferencesImpl();
//		TranslateExecutiveImpl publics = new TranslateExecutiveImpl();
//		NewXmlFinancialInfosImpl finan = new NewXmlFinancialInfosImpl();
//		PooledConnection conn = null;
//		try{
//			conn = DBManager.getConnection();
//			nameCN = Enterprises.getEntNameCN(conn, crefoNo);
//			Reg = Enterprises.getEntReg(conn, crefoNo);
//			if(null!=Reg && !"".equals(Reg) && Reg.length()==15){
//
//			}else{
//				data = new CommerceInterface().getCommerceInterfaceData(crefoNo,nameCN);
//			}
//			Enterprises.getEnterprisesInfo(conn, crefoNo);
//			Enterprises.getOtherEnterprisesInfo(conn, crefoNo);
//			Enterprises.getRepayIndex(conn, crefoNo);
//			if(null!=Reg && !"".equals(Reg) && Reg.length()==15){
//				register.getEnterpriseRegistrationInfo(conn, crefoNo);
//				share.getShareholdersBackground(conn, crefoNo);
////				register.getEnterpriseRegistrationInfo(data);
////				share.getShareholdersBackground(data);
//			}else{
////				register.getEnterpriseRegistrationInfo(conn, crefoNo);
////				share.getShareholdersBackground(conn, crefoNo);
//				register.getEnterpriseRegistrationInfo(data);
//				share.getShareholdersBackground(data);
//			}
//
//			frinfos.getFrinvinfos(conn, crefoNo);
//			relation.getRelationCompany(conn, crefoNo);
//			if(null!=Reg && !"".equals(Reg) && Reg.length()==15){
//				change.getHistoryBackground(conn, crefoNo);
//				manage.getManagementInfo(conn, crefoNo);
////				change.getHistoryBackground(data);
////				manage.getManagementInfo(data);
//			}else{
////				change.getHistoryBackground(conn, crefoNo);
////				manage.getManagementInfo(conn, crefoNo);
//				change.getHistoryBackground(data);
//				manage.getManagementInfo(data);
//			}
//			operat.getOperatingStatus(conn, crefoNo);
//			indestry.getIndustryConditions(conn, crefoNo);
//			bank.getBankInfo(conn, crefoNo);
//			record.getRecordPayments(conn, crefoNo);
//			trade.getTradeReference(conn, crefoNo);
//			publics.getPublicRecords(conn, crefoNo);
//			finan.getFinancialInfos_control(conn, crefoNo);
//
//			Enterprises.setEnterprisesDocument(root);
//			register.setEnterprisesDocument(root);
//			share.setShareHoldersDocument(root);
//			frinfos.setFrinvinfosDocument(root);
//			change.setHistoryDocument(root);
//			manage.setManageDocument(root);
//			relation.setRelationDocument(root);
//			operat.setOperatingStatusDocument(root);
//			indestry.setIndustryConditionsDocument(root);
//			bank.setBankInfoDocument(root);
//			record.setRecordPaymentsDocument(root);
//			trade.setTradeReferenceDocument(root);
//			publics.setPublicRecordsDocument(root);
//			finan.setFinancialDocument(root);
//
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally{
//			if(null!=conn){
//				conn.close();
//			}
//		}
//		try {
//			importxml(Doc);
//		} catch (IOException | DocumentException e) {
//			e.printStackTrace();
//		}
//
//		long endTime=System.currentTimeMillis(); //获取结束时间
//		System.out.println("新建xml耗费时间： "+(endTime-startTime)+"ms");
//
//	}
//
//
//	public static void importxml(Document Doc) throws FileNotFoundException, IOException, DocumentException{
//		OutputFormat format = new OutputFormat("    ",true);
//		format.setEncoding("UTF-8");  // 设置XML文件的编码格式 UTF-8
//		String data = getData.getTimeByCalendar();
//		String filePath = "d:/xml/"+crefoNo+"_"+data+".xml";
//		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(filePath),format);
//		xmlWriter.setEscapeText(false);//设置特殊字符  不转义1
//		xmlWriter.write(Doc);
//		xmlWriter.close();
//		System.out.println("xml生成成功！地址:"+filePath);
//	//创建SAXReader对象
//
//        SAXReader reader = new SAXReader();
//        //读取文件 转换成Document
//        Document document = reader.read(new File(filePath));
//
//      //获取根节点
//        Element root = document.getRootElement();
//        //根节点转换为String字符串
//        String rootStr = root.asXML();
//        rootStr = Tool.Symbolconversion(rootStr);
//        rootStr = rootStr.replace("&amp;and&amp;", "&");
////        System.out.println("root 字符串：" + rootStr);
//
////        //读取成功删除文件
////        if(Tool.deleteFile(filePath)){
////        	System.out.println("删除"+filePath+"成功");
////        }else{
////        	System.out.println("删除失败");
////        }*/
//
////		System.out.println("文件:D:/itext/cpm.xml生成成功！！");
//        System.out.println(rootStr);
//	}

	

}
