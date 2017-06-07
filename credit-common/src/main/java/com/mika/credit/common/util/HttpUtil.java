package com.mika.credit.common.util;

import org.apache.commons.collections.MapUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class HttpUtil {

    static String GET_URL = "http://122.144.131.78:8080/ssm_dc/gldorgdata.do?&saxNum=93600010&comName=%E5%9B%BD%E7%BD%91%E6%B2%B3%E5%8C%97%E7%9C%81%E7%94%B5%E5%8A%9B%E5%85%AC%E5%8F%B8";

    static String POST_URL = "http://122.144.131.78:8080/ssm_dc/gldorgdata.do?&saxNum=93600010&comName=%E5%9B%BD%E7%BD%91%E6%B2%B3%E5%8C%97%E7%9C%81%E7%94%B5%E5%8A%9B%E5%85%AC%E5%8F%B8";

    /**
     * �ӿڵ��� GET
     *
     * @return
     */
    public static String httpURLConectionGET(String Stringurl) {
        try {
            URL url = new URL(Stringurl);    // ���ַ���ת��ΪURL�����ַ
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// ������
            connection.connect();// ���ӻỰ
            // ��ȡ������
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// ѭ����ȡ��
                sb.append(line);
            }
            br.close();// �ر���
            connection.disconnect();// �Ͽ�����
            System.out.println(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ʧ��!");
        }
        return null;
    }

    /**
     * �ӿڵ���  POST
     */
    public static String httpURLConnectionPOST(String Stringurl) {
        try {
            URL url = new URL(Stringurl);

            // ��url �� open�������ص�urlConnection  ����ǿתΪHttpURLConnection����  (��ʶһ��url�����õ�Զ�̶�������)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// ��ʱcnnectionֻ��Ϊһ�����Ӷ���,��������

            // �������������Ϊtrue,Ĭ��false (post �����������ķ�ʽ��ʽ�Ĵ��ݲ���)
            connection.setDoOutput(true);

            // ��������������Ϊtrue
            connection.setDoInput(true);

            // ��������ʽΪpost
            connection.setRequestMethod("POST");

            // post���󻺴���Ϊfalse
            connection.setUseCaches(false);

            // ���ø�HttpURLConnectionʵ���Ƿ��Զ�ִ���ض���
            connection.setInstanceFollowRedirects(true);

            // ��������ͷ����ĸ������� (����Ϊ�������ݵ�����,����Ϊ����urlEncoded�������from����)
            // application/x-javascript text/xml->xml���� application/x-javascript->json���� application/x-www-form-urlencoded->������
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // �������� (����δ��ʼ,ֱ��connection.getInputStream()��������ʱ�ŷ���,���ϸ��������������ڴ˷���֮ǰ����)
            connection.connect();

            // �������������,�����������������Я���Ĳ���,(�������Ϊ?���������)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
            String parm = "storeId=" + URLEncoder.encode("32", "utf-8"); //URLEncoder.encode()����  Ϊ�ַ������б���

            // ���������������
            dataout.writeBytes(parm);

            // �����ɺ�ˢ�²��ر���
            dataout.flush();
            dataout.close(); // ��Ҫ���׺��Բ��� (�ر���,�м�!) 

            System.out.println(connection.getResponseCode());

            // ���ӷ�������,�����������Ӧ  (�����ӻ�ȡ������������װΪbufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder(); // �����洢��Ӧ����

            // ѭ����ȡ��,��������β��
            while ((line = bf.readLine()) != null) {
                sb.append(bf.readLine());
            }
            bf.close();    // ��Ҫ���׺��Բ��� (�ر���,�м�!) 
            connection.disconnect(); // ��������
            System.out.println(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String syncDataWithContentType(String Stringurl, Map<String, String> param) {
        String strReturn = "";
        String strContent = "";
        String strHttpUrl = Stringurl;
//    	"http://122.144.131.79:8090/ssmdc/ywcourt?Param=zxgg&keyWord=�ӱ�ʢ���������޹�˾";
        try {
            /**
             * ��֯�ӿڵ�URL һ����URL ����Ӹ�id��������ֵ�費ͬ(��ȡһ�����ֵ)����Ҫ����
             ����
             */
            java.net.URL url = new java.net.URL(strHttpUrl);
            /**
             * ��ȡһ��HttpURLConnection ���Ӷ���
             */
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
//    	connsetConnectTimeout(30000); //���ó�ʱʱ��
//    	connsetReadTimeout(30000);
            /**
             * ��post ��ʽ��������
             */
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            if (MapUtils.isNotEmpty(param)) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    conn.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            java.io.OutputStream out = conn.getOutputStream();
            /**
             * д���ݵ��������
             */
            out.write(strContent.getBytes("UTF-8"));
            out.flush();
            out.close();
            /**
             * �ӿڵ��ú���������
             */
            java.io.InputStream ins2 = conn.getInputStream();
            /**
             * ���ӿڷ��ص���ת��Ϊ�ַ���String
             */
            strReturn = convertStreamToString(ins2);
            ins2.close();
        } catch (Exception e) {
            System.out.println("���յ�URL" + strHttpUrl + "����ȷ, ����ʧ��!");
            e.printStackTrace();
        }
        System.out.println("data==" + strReturn);
        return strReturn;
    }


    public static String syncData(String Stringurl) {
        String strReturn = "";
        String strContent = "";
        String strHttpUrl = Stringurl;
//    	"http://122.144.131.79:8090/ssmdc/ywcourt?Param=zxgg&keyWord=�ӱ�ʢ���������޹�˾";
        try {
            /**
             * ��֯�ӿڵ�URL һ����URL ����Ӹ�id��������ֵ�費ͬ(��ȡһ�����ֵ)����Ҫ����
             ����
             */
            java.net.URL url = new java.net.URL(strHttpUrl);
            /**
             * ��ȡһ��HttpURLConnection ���Ӷ���
             */
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
//    	connsetConnectTimeout(30000); //���ó�ʱʱ��
//    	connsetReadTimeout(30000);
            /**
             * ��post ��ʽ��������
             */
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            java.io.OutputStream out = conn.getOutputStream();
            /**
             * д���ݵ��������
             */
            out.write(strContent.getBytes("UTF-8"));
            out.flush();
            out.close();
            /**
             * �ӿڵ��ú���������
             */
            java.io.InputStream ins2 = conn.getInputStream();
            /**
             * ���ӿڷ��ص���ת��Ϊ�ַ���String
             */
            strReturn = convertStreamToString(ins2);
            ins2.close();
        } catch (Exception e) {
            System.out.println("���յ�URL" + strHttpUrl + "����ȷ, ����ʧ��!");
            e.printStackTrace();
        }
        System.out.println("data==" + strReturn);
        return strReturn;
    }

    /*
     索引（新增用户名密码）
     */
    public static String syncData(String Stringurl, Map<String, String> params, String username, String passwd) {
        String strReturn = "";
        String strHttpUrl = Stringurl;
//    	"http://122.144.131.79:8090/ssmdc/ywcourt?Param=zxgg&keyWord=河北盛华化工有限公司";
        try {
            /**
             * 组织接口的URL 一般在URL 后面加个id参数，其值需不同(可取一个随机值)，主要用于
             并发
             */
            java.net.URL url = new java.net.URL(strHttpUrl);
            /**
             * 获取一个HttpURLConnection 链接对象
             */
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String author = "Basic " + UtilBase64.encode((username + ":" + passwd).getBytes());
            conn.setRequestProperty("Authorization", author);
            /**
             * 写内容到输出流中
             */
            String content = "1=1";
            Set<String> keys = params.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                content += "&" + key + "=" + URLEncoder.encode(params.get(key), "UTF-8");
            }
            PrintWriter pw = new PrintWriter(conn.getOutputStream());
            pw.print(content);
            pw.flush();
            pw.close();
            /**
             * 接口调用后获得输入流
             */
            java.io.InputStream ins2 = conn.getInputStream();
            /**
             * 将接口返回的流转换为字符串String
             */
            try {
                strReturn = convertStreamToString(ins2);
            } catch (Exception ex) {
                strReturn = null;
            }


            ins2.close();
        } catch (Exception e) {
            System.out.println("接收的URL" + strHttpUrl + "不正确, 发送失败!");
            e.printStackTrace();
        }
//    	System.out.println("data=="+strReturn);
        return strReturn;
    }


    /**
     * ��ת��
     *
     * @param ins
     * @return
     */
    private static String convertStreamToString(InputStream ins) {
        String strRet = "";
        try {
            StringBuffer sbuf = new StringBuffer();
            InputStreamReader reader = new InputStreamReader(ins, "UTF-8");
            Reader buf = new BufferedReader(reader);
            int ch;
            int iCharNum = 0;
            while ((ch = buf.read()) > -1) {
                iCharNum += 1;
                sbuf.append((char) ch);
            }
            buf.close();
            strRet = sbuf.toString();
            sbuf.delete(0, sbuf.length());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return strRet;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(syncData(POST_URL));
//      httpURLConectionGET(POST_URL);
//      httpURLConnectionPOST(POST_URL);
    }

}
