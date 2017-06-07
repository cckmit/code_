package com.mika.credit.facade.translate.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Tool {
	
	public static String reportFilePath = "";
	
	public static String imagePath = "";
	
	public static String htmlCNUrl = "";
	public static String htmlENUrl = "";
	
	public static String htmeImages = "";
	
	public static String yunpan = "";
	
	public static String cpmurl = "";
	
	public static String cpmSpaceName = "";
	
	public static Integer intshare[];
	
	public static String eufilePath = "";
	
	public static String commerceIp;//接口IP
	
	public static String winrarPath;//winrar压缩文件工具安装路径
	
	public static String scNewsFtpPath;//尚诚新闻舆情地址
	
	public static String scLawFtpPath;//商诚司法地址
	
	
	static DecimalFormat df = new DecimalFormat("########0.00");
	public static Double formatDouble(Double value){
		String str = df.format(value);
		System.out.println(str);
		return Double.parseDouble(str);
	}
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringNull(String str){
		if(null!=str && !"".equals(str.trim()) ){
			str = str.replace("&", "&amp;");
			str = str.replace("<", "&lt;");
			str = str.replace(">", "&gt;");	
			if("".equals(str.trim())){
				str ="-"; 						
			}
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"-";
		}
	} 
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringRN(String str){
		if(null!=str && !"".equals(str.trim()) ){			
			str = str.replace(",", "，");
			if("".equals(str.trim())){
				str =""; 						
			}
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"";
		}
	} 
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringNullZXB(String str){
		if(null!=str && !"".equals(str.trim()) ){
			str = str.replace("&", "&amp;");	
			str = str.replace("<", "&lt;");
			str = str.replace(">", "&gt;");	
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"";
		}
	} 
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringNullPicc(String str){
		if(null!=str && !"".equals(str.trim()) ){
			str = str.replace("&", "&amp;");
			str = str.replace("<", "&lt;");
			str = str.replace(">", "&gt;");	
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"";
		}
	} 
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringEH(String str){
		if(null!=str && !"".equals(str.trim()) ){
			str = str.replace("&", "&amp;");
			str = str.replace("<", "&lt;");
			str = str.replace(">", "&gt;");	
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"";
		}
	} 
	
	
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringXml(String str){
		if(null!=str && !"".equals(str.trim()) ){
			str = str.replace("&", "&amp;");
			str = str.replace("<", "&lt;");
			str = str.replace(">", "&gt;");	
			str = str.replace('"', ' ');	
			str = str.replace("“", "");	
			str = str.replace("”", "");
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"";
		}
	} 
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringSafe(String str){
		if(null!=str && !"".equals(str.trim()) ){			
			str = str.replace("&lt;", "<");
			str = str.replace("&gt;", ">");	
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"";
		}
	} 
	
	/**
	 * 中英文符号转换
	 * */
	public static String Symbolconversion(String str){
		if(null!=str && !"".equals(str.trim()) ){			
			str = str.replace("，", ",");
			str = str.replace("！", "!");
			str = str.replace("？", "?");	
			str = str.replace("；", ";");
			str = str.replace("。", ".");	
			str = str.replace("【", "[");
			str = str.replace("】", "]");	
			str = str.replace("（", "(");
			str = str.replace("）", ")");	
			str = str.replace('“', '"');
			str = str.replace('”', '"');
			str = str.replace("‘", "'");
			str = str.replace("’", "'");
			str = str.replace("：", ":");
			str = str.replace("《", "<");
			str = str.replace("》", ">");
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"";
		}	
	}
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringNullPdf(String str){
		return null!=str && !"".equals(str.trim()) ?str:"-";
	} 
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringfinan(String str){
		return null!=str && !"".equals(str) ?str:"";
	} 
	
	/**
	 * 判断字符是否为null
	 * */
	public static String isStringBasf(String str){
		if(null!=str && !"".equals(str.trim()) ){
			str = str.replace("&", "&amp;");		
			return str;
		}else{
			return null!=str && !"".equals(str.trim()) ?str:"";
		}
	} 
	
	//格式化注册资金	
	public static String formatMoney(String value) throws Exception{
		try {
			if(value != null && value.length()!=0 && !value.trim().equals("") && !value.trim().equals("null")){
				boolean bool = value.contains(".");
				Double b = Double.parseDouble(value.trim());
				BigDecimal  a = new BigDecimal(b);
				DecimalFormat format = null ;
				if(bool){
					format = new DecimalFormat("##,###,###,###,###,###.00");
				}else{
					format = new DecimalFormat("##,###,###,###,###,###");
				}				
				value=format.format(a);
				return value;
			}else{
				return " ";
			}		
		} catch (Exception e) {
			throw new Exception("格式化数值有问题-"+value);
		}
	}

	
	public int[] Sequenceto(int a[]){
		int i, j, n, temp;

		  // 数组的长度

		  n = a.length;

		  for (j = 0; j < n; j++) {

		  for (i = 0; i < n - j; i++) {

		  try {

		  // 把最小的交换到最后面去

		  if (a[i] < a[i + 1]) {

		  temp = a[i];

		  a[i] = a[i + 1];

		  a[i + 1] = temp;

		  }

		  } catch (Exception e) { 
		  }
		  }
		  }
		return a;
	}
	
	//判断是否包含中文字符
	public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
	
	/** 
	 *  根据路径删除指定的目录或文件，无论存在与否 
	 *@param sPath  要删除的目录或文件 
	 *@return 删除成功返回 true，否则返回 false。 
	 */  
	public static  boolean DeleteFolder(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 判断目录或文件是否存在  
	    if (!file.exists()) {  // 不存在返回 false  
	        return flag;  
	    } else {  
	        // 判断是否为文件  
	        if (file.isFile()) {  // 为文件时调用删除文件方法  
	            return deleteFile(sPath);  
	        } else {  // 为目录时调用删除目录方法  
	            return deleteDirectory(sPath);  
	        }  
	    }  
	}  
	
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(String sPath) {  
		boolean flag = false;  
		File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 
	
	/** 
	 * 删除目录（文件夹）以及目录下的文件 
	 * @param   sPath 被删除目录的文件路径 
	 * @return  目录删除成功返回true，否则返回false 
	 */  
	public static boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}  

	/**
	 * HTML地址
	 * @return String
	 */
	public static  String loadhtmlCNUrl(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			htmlCNUrl = p.getProperty("htmlCNUrl");//常数
			System.out.println("下载htmlCNUrl==="+htmlCNUrl);
			return htmlCNUrl;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	
	
	/**
	 * CPM Service address
	 * @return String
	 */
	public static  String loadCpmurl(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			cpmurl = p.getProperty("cpmurl");//常数
			System.out.println("cpmurl==="+cpmurl);
			return cpmurl;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	/**
	 * cpmSpaceName Service address
	 * @return String
	 */
	public static  String loadCpmSpaceName(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			cpmSpaceName = p.getProperty("cpmSpaceName");//常数
			System.out.println("cpmSpaceName==="+cpmSpaceName);
			return cpmSpaceName;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	/**
	 * HTML地址
	 * @return String
	 */
	public static  String loadhtmlENUrl(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			htmlENUrl = p.getProperty("htmlENUrl");//常数
			System.out.println("下载htmlENUrl==="+htmlENUrl);
			return htmlENUrl;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	/**
	 * html格式报告图片存放路径
	 * @return String
	 */
	public static  String loadhtmeImages(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			htmeImages = p.getProperty("htmeImages");//常数
			System.out.println("html格式报告图片存放路径==="+htmeImages);
			return htmeImages;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	/**
	 * html格式报告图片存放路径
	 * @return String
	 */
	public static  String loadeufilePath(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			eufilePath = p.getProperty("eufilePath");//常数
			System.out.println("eu==="+eufilePath);
			return eufilePath;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	/**
	 * 报告下载路径
	 * @return String
	 */
	public static  String loadreportFilePath(){
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			reportFilePath = p.getProperty("reportFilePath");//常数
//			reportFilePath = "D:/Lucene_Test/exportReport/";
			System.out.println("报告下载路径==="+reportFilePath);
			return reportFilePath;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		}catch(Exception e){}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	/**
	 * 服务器路径
	 * @return String
	 */
	public static  String loadimagePath(){
//		return imagePath="D:/diviner/work/workspace/Export/WebRoot/";
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			imagePath = p.getProperty("imagePath");//常数
			System.out.println("服务器路径==="+imagePath);
			return imagePath;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	/**
	 * 服务器路径
	 * @return String
	 */
	public static  String loadwinrarPath(){
//		return imagePath="D:/diviner/work/workspace/Export/WebRoot/";
		Properties p = new Properties();;
		InputStream in = null;
		try {
			in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
			p.load(in);  
			in.close();  
			winrarPath = p.getProperty("winrarPath");//常数
			System.out.println("winrar工具安装路径==="+winrarPath);
			return winrarPath;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	
	/**
	 * 判断字符是否为date日期格式
	 * */
	public static boolean isValidDate(String str) {
		 boolean convertSuccess=true;
	      // 指定日期格式为四位年-两位月份-两位日期，注意yyyy-MM-dd区分大小写；
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	       try {
	    	   // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007-02-29会被接受，并转换成2007-03-01
	           format.setLenient(false);
	          format.parse(str);
	        } catch (ParseException e) {
	           // e.printStackTrace();
	        	// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	           convertSuccess=false;
	       } 
//	     System.out.println(convertSuccess);
		return convertSuccess;
	}
	
	/**
	 * @author aixingwen
	 * @param strName 
	 * @return Boolean
	 * @判断是否为中文
	 * */
	public static boolean isChinese(String strName) {  
		  
        char[] ch = strName.toCharArray();  
  
        for (int i = 0; i < ch.length; i++) {  
            char c = ch[i];
            if (isChinese(c) == true) { 
                return true;   
            }
        }
        return false;
	}
	
	public static boolean isChinese(char c) {  
		  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
  
            return true;  
  
        }  
  
        return false;  
  
    } 
	
	
	/**
	 * 样式设置
	 * @param style
	 * @param align 单元格水平 0 普通 1 左对齐 2 居中 3 右对齐 4 填充 5 正当 6 居中选择 
	 * @param VerticalAlignment 单元格垂直 0 居上 1 居中 2 居下 3 正当 
	 * @param borderBottom 单元格下边框为细线
	 * @param bottomBorderColor 设置下边框颜色
	 * @param borderLeft 单元格左边框
	 * @param leftBorderColor 单元格左边框颜色
	 * @param borderRight 单元格右边框
	 * @param rightBorderColor 单元格右边框颜色
	 * @param borderTop 单元格上边框
	 * @param topBorderColor 单元格上边框颜色
	 * @param fillForegroundColor 设置前景颜色
	 * @param FillPattern 设置单元格填充样式
	 * @return HSSFCellStyle
	 */
	public static HSSFCellStyle setStyle(HSSFCellStyle style, Short align, Short VerticalAlignment, Short borderBottom,
			Short bottomBorderColor, Short borderLeft, Short leftBorderColor, Short borderRight, Short rightBorderColor,
			Short borderTop, Short topBorderColor, Short FillPattern, Short fillForegroundColor){
		
		if(null != align )
			style.setAlignment(align);
		if(null != VerticalAlignment )
			style.setVerticalAlignment(VerticalAlignment);
		if(null != borderBottom )
			style.setBorderBottom(borderBottom);
		if(null != bottomBorderColor )
			style.setBottomBorderColor(bottomBorderColor);
		if(null != borderLeft )
			style.setBorderLeft(borderLeft);
		if(null != leftBorderColor )
			style.setLeftBorderColor(leftBorderColor);
		if(null != borderRight )
			style.setBorderRight(borderRight);
		if(null != rightBorderColor )
			style.setRightBorderColor(rightBorderColor);
		if(null != borderTop )
			style.setBorderTop(borderTop);
		if(null != topBorderColor )
			style.setTopBorderColor(topBorderColor);
		if(null != FillPattern)
			style.setFillPattern(FillPattern);
		if(null != fillForegroundColor )
			style.setFillForegroundColor(fillForegroundColor);
		
		return style;
	}
	
	
	
	
	/**
	 * 样式设置
	 * @param style
	 * @param font 字体类
	 * @return
	 */
	public static HSSFCellStyle setStyle(HSSFCellStyle style, HSSFFont font){
		if(null != font )
			style.setFont(font);
		
		return style;
	}
	
	
	
	
	/**
	 * 字体设置
	 * @param font
	 * @param fontHeightInPoints 设定字体高度
	 * @param italic 设定为斜体
	 * @param boldweight 设定文字粗小宽度
	 * @param color 字体颜色
	 * @param fontName 字体
	 * @return HSSFFont
	 */
	public static HSSFFont setFont(HSSFFont font, Short fontHeightInPoints, Boolean italic, Boolean strikeout, 
			Short boldweight, Short color, String fontName){
		
		if(null != fontHeightInPoints )
			font.setFontHeightInPoints(fontHeightInPoints);
		if(null != italic)
			font.setItalic(italic);
		if(null != strikeout)
			font.setStrikeout(strikeout);
		if(null != boldweight)
			font.setBoldweight(boldweight);
		if(null != color)
			font.setColor(color);
		if(null != fontName)
			font.setFontName(fontName);
		
		return font;
	}
	
	/**
	 * 如果不使用POI提供的默认颜色，就需要自定颜色索引：
	 * 自定义字体颜色(设置颜色的索引只能是 8 ~ 64，在此之外的索引无效，也不会报错。以下三种方式都可以设置成功。
	 *  palette.setColorAtIndex((short)9, (byte) (0xff & 251), (byte) (0xff & 161), (byte) (0xff & 161));
   	 *  palette.setColorAtIndex((short)10, (byte) (0x66), (byte) (0xcd), (byte) (0xaa));
   	 *  palette.setColorAtIndex((short)11, (byte) (255), (byte) (165), (byte) (0));
   	 *  )
	 * @param book
	 * @param red
	 * @param green
	 * @param blue
	 * @return HSSFColor
	 */
	public static void setFontColor(HSSFWorkbook book, short index, byte red, byte green, byte blue){
		 HSSFPalette customPalette = book.getCustomPalette();  
		 //HSSFColor newColor = customPalette.addColor((byte) red, (byte) green, (byte) blue);  
		 customPalette.setColorAtIndex(index,
				 (byte) red, //RGB 红色 (取值0-255)  
				 (byte) green,    //RGB 绿色  
				(byte) blue     //RGB 蓝色  
				);
		//return newColor;
	}
	

	/**
	 * 
	 * @param row 行
	 * @param style 样式
	 * @param numFormat 数字格式
	 * @param cellNum 列
	 * @param value 值
	 * @return HSSFCell
	 */
	public static HSSFCell createCell(HSSFRow row, HSSFCellStyle style, HSSFDataFormat numFormat, int cellNum, Object value){
		
		
		HSSFCell cell = row.createCell(cellNum);
		style.setDataFormat(numFormat.getFormat("#,#0")); 
		if(null != value && !value.equals("")){
			if(null != numFormat){
				style.setDataFormat(numFormat.getFormat("#,#0")); //数据格式只显示整数，如果是小数点后保留两位，可以写contentStyle.setDataFormat(df.getFormat("#,#0.00"));  
			}
			cell.setCellValue(Double.parseDouble(value.toString()));//创建第二列
			
		}
		
		cell.setCellStyle(style);
		
		return cell;
	}
	
	 /**
     * 资金*10000
     * */
    public static String SetMoneyMultiplied(String money){
    	double price = 0;
//    	System.out.println("money=="+money);
    	money = money.replace(" ", "");
//    	String replaceStr = trimStr.replace(" ", "");
//    	money = money.trim();
//    	System.out.println("money2=="+money);
    	if(null!=money&&!"".equals(money.trim())){
    		try {
    			/*if(money.contains(".")&&money.contains("万")){
    				money = money.substring(0,money.lastIndexOf("万"));
    				price = Double.valueOf(money.trim());
					price = price*10000;
					int i = (int) price;
					money = i+"";
    			}else if(money.contains("万")){
    				money = money.substring(0,money.lastIndexOf("万"));
    				price = Double.valueOf(money.trim());
					price = price*10000;
					int i = (int) price;
					money = i+"";
    			}else if(money.contains(",")){
    				money = money.substring(0,money.lastIndexOf(","));
    				price = Double.valueOf(money.trim());
					price = price*10000;
					int i = (int) price;
					money = i+"";
    			}else{	
    				if(money.length()>2){
    					String lstr = money.substring(money.lastIndexOf(".")+1,money.length());
	    				money = money.substring(0,money.lastIndexOf("."));
	    				System.out.println(lstr);
	    				if(lstr.length()==0){
	    					lstr = "0000";
	    				}else if(lstr.length()==1){
	    					lstr = lstr + "000";
	    				}else if(lstr.length()==2){
	    					lstr = lstr +  "00";
	    				}else if(lstr.length()==3){
	    					lstr = lstr +  "0";
	    				}if(lstr.length()==3){
	    					lstr = lstr;
	    				}else if(lstr.length()>4){
	    					lstr = lstr.substring(0,4);
	    				}
	    				money = money + lstr;
    				}else{
    					price = Double.valueOf(money.trim());
    					price = price*10000;
    					int i = (int) price;
    					money = i+"";
    				}
    				
//    				money = money.substring(0,money.lastIndexOf("."));
//    				money = money + "0000";
    			}*/
    			if(money.contains("万")){
    				money = money.replace("万元人民币", "");
        			money = money.replace(",", "");
        			money = money.replace("万元", "");
        			money = money.replace("万", "");    			
        			price = Double.valueOf(money.trim());
        			price = price*10000;
        			int i = (int) price;
        			money = i+"";
    			}else{
    				price = Double.valueOf(money.trim());
    				int i = (int) price;
        			money = i+"";
    			}
    			
    			
				/*price = Double.valueOf(money.trim());
				price = price*10000;
				int i = (int) price;
				money = i+"";*/
				return money;
			} catch (NumberFormatException e) {
				money = "";
				return money;
			}
    	}else{
    		return money;
    	}	    	
    }
    
    public static String SetMoneyMultiplied_qqy(String money){
    	double price = 0;
    	money = money.replace(" ", "");
    	if(null!=money&&!"".equals(money.trim())){
    		try {
				price = Double.valueOf(money.trim());
				price = price*10000;
				int i = (int) price;
				money = i+"";
				return money;
			} catch (NumberFormatException e) {
				money = "";
				return money;
			}
    	}else{
    		return money;
    	}	    	
    }
	
    
	/**
	 * js弹出
	 * @return
	 */
	public static String alertMsg(String str){
		StringBuffer msg = new StringBuffer( "<script> alert('");
		msg.append(str);
		msg.append("');");
		msg.append("</script>");
		return msg.toString();
	}
	
	public static int morethanthe(int i){		
		if(i<1){
			i=1;
		}
		return i;
	}
	
	public static String formatMoneyNotDecimalpoint(String value) throws Exception{
		try {
			if(value != null && value.length()!=0 && !value.trim().equals("") && !value.trim().equals("null")){
				boolean bool = value.contains(".");
				Double b = Double.parseDouble(value.trim());
				BigDecimal  a = new BigDecimal(b);
				DecimalFormat format = null ;
				if(bool){
					format = new DecimalFormat("##,###,###,###,###,###");
				}else{
					format = new DecimalFormat("##,###,###,###,###,###");
				}				
				value=format.format(a);
				return value;
			}else{
				return " ";
			}		
		} catch (Exception e) {
			throw new Exception("格式化数值有问题-"+value);
		}
	}
	 
	public static String CompareYear(String str) throws ParseException{
		if(null!=str && !"".equals(str.trim())){
			try {
				Date start  = new SimpleDateFormat("yyyy-MM-dd").parse(str);
				Date data = new Date();
				String end = new SimpleDateFormat("yyyy-MM-dd").format(data);
				Date enddata  = new SimpleDateFormat("yyyy-MM-dd").parse(end);
				Calendar c1 = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();
				c1.setTime(start);
				c2.setTime(enddata);
				int year1 = c1.get(Calendar.YEAR);
				int year2 = c2.get(Calendar.YEAR);
				int month1 = c1.get(Calendar.MONTH)+1;
				int month2 = c2.get(Calendar.MONTH)+1;
				int day1 = c1.get(Calendar.DAY_OF_MONTH);
				int day2 = c2.get(Calendar.DAY_OF_MONTH);			
				int year = Math.abs(year1 - year2);
				if(month2 - month1>0){
					year = year;
				}else if(month2 - month1==0){
					if(day1 - day2>0){
						year = year-1;
					}
				}
				return year+" years";
			} catch (Exception e) {
				if(str.length()>4){
					Date data = new Date();
					String end = new SimpleDateFormat("yyyy-MM-dd").format(data);
					Date enddata  = new SimpleDateFormat("yyyy-MM-dd").parse(end);					
					Calendar c2 = Calendar.getInstance();						
					c2.setTime(enddata);
					int year2 = c2.get(Calendar.YEAR);
					String countyear = str.substring(0, 4);
					int year1 = Integer.parseInt(countyear);
					int year = Math.abs(year1 - year2);
					return year+" years";
				}
				
				return "-";
			}
		}else{
			return str;
		}		
	}
	
	public static String CompareYearCN(String str) throws ParseException{
		if(null!=str && !"".equals(str.trim())){
			try {
				Date start  = new SimpleDateFormat("yyyy-MM-dd").parse(str);
				Date data = new Date();
				String end = new SimpleDateFormat("yyyy-MM-dd").format(data);
				Date enddata  = new SimpleDateFormat("yyyy-MM-dd").parse(end);
				Calendar c1 = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();
				c1.setTime(start);
				c2.setTime(enddata);
				int year1 = c1.get(Calendar.YEAR);
				int year2 = c2.get(Calendar.YEAR);
				int month1 = c1.get(Calendar.MONTH)+1;
				int month2 = c2.get(Calendar.MONTH)+1;
				int day1 = c1.get(Calendar.DAY_OF_MONTH);
				int day2 = c2.get(Calendar.DAY_OF_MONTH);			
				int year = Math.abs(year1 - year2);
				if(month2 - month1>0){
					year = year;
				}else if(month2 - month1==0){
					if(day1 - day2>0){
						year = year-1;
					}
				}
				return year+" 年";
			} catch (Exception e) {
				if(str.length()>4){
					Date data = new Date();
					String end = new SimpleDateFormat("yyyy-MM-dd").format(data);
					Date enddata  = new SimpleDateFormat("yyyy-MM-dd").parse(end);					
					Calendar c2 = Calendar.getInstance();						
					c2.setTime(enddata);
					int year2 = c2.get(Calendar.YEAR);
					String countyear = str.substring(0, 4);
					int year1 = Integer.parseInt(countyear);
					int year = Math.abs(year1 - year2);
					return year+" 年";
				}
				
				return "-";
			}
		}else{
			return str;
		}		
	}
	
	public static boolean compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return true;
            } else if (dt1.getTime() < dt2.getTime()){
                System.out.println("dt1在dt2后");
                return false;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		return false;
    }


	/**
	* 接口IP
	* @return String
	 */
	public static  String loadcommerceIp(){
			Properties p = new Properties();;
			InputStream in = null;
			try {
				in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
				p.load(in);  
				in.close();  
				commerceIp = p.getProperty("commerceIp");//常数
				System.out.println("接口地址==="+commerceIp);
				return commerceIp;
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return "";
		}
		
	public static String moneyMultiply(String money){
		/*if(null!=money&&!"".equals(money)){
			double dmoney = 0;
			dmoney = Double.parseDouble(money);
			int price = (int) (dmoney*1000);
			money = price + "";
		}
		*/
		return money;
	}
	
	/**
	 * 日期格式转换
	 * */
	public static String FormatData(String sortTimeString){
		try{
			sortTimeString = sortTimeString.replace("年", "-");
			sortTimeString = sortTimeString.replace("月", "-");
			sortTimeString = sortTimeString.replace("日", "");
		}catch(Exception ex){
			
		}
		return sortTimeString;
	}
	
	//文件压缩为rar文件
	/**
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static int fileToRar(String aimpath,String realPath) throws InterruptedException{
		System.out.println("aimpath=="+aimpath+"---realPath=="+realPath);
	//	Tool.loadwinrarPath();
//		winrarPath = "c:/Program Files (x86)/WinRAR/Rar.exe";
		StringBuffer cmd= new StringBuffer("c:/Program Files (x86)/WinRAR/Rar.exe");//安装的winrar路径
		cmd.append(" a -ep ");
		cmd.append(aimpath);
		cmd.append(realPath);
		Process proc;
		try {
			proc = Runtime.getRuntime().exec(cmd.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "gbk"));
			 String line;   
			  while ((line = br.readLine()) != null) {
			    //System.out.println(line);   
			  }   
			  
			  br = new BufferedReader(new InputStreamReader(proc.getErrorStream(), "gbk"));   
			  while ((line = br.readLine()) != null) {   
			    //System.err.println(line);   
			  }   
			  // 当前线程等待该process结束，既挂起主线程     
			  proc.waitFor(); 
			  return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		
	}
	 
	
	/**
	 * String类型转数值类型
	 * */
	public static int StringToInt(String str){
		int count = 0;
		try{
			count = Integer.parseInt(str);
		}catch(Exception ex){
			
		}
		return count;
	}	
	
	/**
	 * String类型转数值类型
	 * */
	public static double StringToDouble(String str){
		double count = 0;
		try{
			count = Double.parseDouble(str);
		}catch(Exception ex){
			
		}
		return count;
	}	
	
	
	/**
	* 尚诚新闻舆情地址
	* @return String
	 */
	public static  String loadScNewsFtpPath(){
			Properties p = new Properties();;
			InputStream in = null;
			try {
				in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
				p.load(in);  
				in.close();  
				scNewsFtpPath = p.getProperty("scNewsFtpPath");//常数
				System.out.println("尚诚新闻舆情地址==="+scNewsFtpPath);
				return scNewsFtpPath;
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return "";
		}
	
	/**
	* 商诚司法地址
	* @return String
	 */
	public static  String loadScLawFtpPath(){
			Properties p = new Properties();;
			InputStream in = null;
			try {
				in=Tool.class.getClassLoader().getResourceAsStream("/jdbc.properties");  
				p.load(in);  
				in.close();  
				scLawFtpPath = p.getProperty("scLawFtpPath");//常数
				System.out.println("商诚司法地址==="+scLawFtpPath);
				return scLawFtpPath;
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return "";
		}
		
	public static String getinfoData(JSONObject info, String data){
		try{
			String str = info.getString(data);
			return null!=str && !"".equals(str.trim()) && !"null".equals(str.trim())  ?str:"";
		}catch (Exception e){
			return "";
		}
		
	 }

	/**
	 * 传过来的值是字符串，如果为null 返回空字符
	 * @param value
	 * @return
	 */

	public static String isNull(String value){
		if(value != null && !value.trim().equals("") && !value.trim().equals("null")){
			return value;
		}else if(value == null || value.trim().equals("") || value.trim().equals("null")){
			return "";
		}else{
			return "";
		}
	}
	
}
