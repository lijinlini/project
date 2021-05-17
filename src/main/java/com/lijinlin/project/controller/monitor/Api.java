package com.lijinlin.project.controller.monitor;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: hm.guo(hm.guo @ zuche.com)
 * @Date: 2021-04-19 14:20
 * @Version: 1.0
 */
public class Api {

    static final AuthResponse AUTH_RESPONSE;

    //application/json
    //application/x-www-form-urlencoded

    //身份认证
    static final String AUTH = "https://api2.hik-cloud.com/oauth/token";

    /**
     * 门店列表
     */
    static final String DEPART_LIST = "https://api2.hik-cloud.com/v1/customization/storeInfo";

    /**
     * 设备列表
     */
    static final String DEVICE_LIST = "https://api2.hik-cloud.com/v1/customization/cameraList";


    /**
     * 通过门店编号查询设备通道列表
     */
    static final String DEVICE_LIST_BY_DEPTNO = "https://api2.hik-cloud.com/v1/customization/store/cameraList";

    /**
     * 取消认证
     */
    static final String IO_FETCH = "https://api2.hik-cloud.com/v1/ezviz/account/info";

    //开通标准流预览  POST application/x-www-form-urlencoded json格式 { "channelIds": "8c06808799394814880a706761e35800"}
    static final String LIVE_VIDEO_OPEN = "https://api2.hik-cloud.com/api/v1/open/basic/channels/actions/live/video/open";

    static final String LIVI_OPEN = "https://api2.hik-cloud.com/v1/customization/liveVideoOpen";

    static final String LIVE_ADDRESS = "https://api2.hik-cloud.com/v1/customization/liveAddress";

    static final String client_id = "7edafb1974674c539b15adb46291f0ad";

    static final String client_secret = "892233316c8142498db75d91ae3a845c";

    static {
        try {
            AUTH_RESPONSE = auth();
        } catch (Exception e) {
            throw new RuntimeException("获取token失败", e);
        }
        System.out.println(AUTH_RESPONSE.getAccess_token());
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(fetchStream());
        //1获取身份认证
        AuthResponse res = auth();


        //2根据部门编号获取设备信息 主要获取deviceId 、deviceSerial、channelNo
        String deptNoStrs = getDepartList();
        JSONObject jsonObject = JSON.parseObject(deptNoStrs);
        Object data = jsonObject.get("data");
       // System.out.println(data);
        //storeNo S003349
        String deviceStrs = getDeviceListByDeptNo("S003349");
        System.out.println(JSON.parseObject(deviceStrs));
        //通过标准流预览
        Map<String,Object> param = new HashMap<>();
        param.put("channelIds","62bf52d94863449ba5600c7db4e79283");
        String str = doPost(LIVI_OPEN, param);
        System.out.println("-------" + str);

        String str1 = doGet(LIVE_ADDRESS, new HashMap<String, Object>() {{
            put("channelId", "bbe9a79682fe419d8c36afd371f7835c");
        }});
        System.out.println("-------" + str1);
        //-------{"code":200,"message":"操作成功","data":[{"deviceSerial":"D77907823","channelNo":19,"ret":"200","desc":"开通成功!"}]}

    }

    public static String doPost(String url, String contentType, String jsonString) throws Exception {
        return doPost(url, jsonString, contentType, "UTF-8");
    }

    public static String doPost(String url, String jsonString, String contentType, String charset) throws Exception {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            addHeader(httpPost);
            //httpPost.setHeader("Content-type",contentType);
            //设置参数
            StringEntity entity = new StringEntity(jsonString, charset);
            entity.setContentType(contentType);
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
            System.out.println("入参: " + jsonString);
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public static String doPost(String url, Map<String, Object> requestMap) throws Exception {
        return doPost(url, requestMap, "UTF-8");
    }

    public static String doPost(String url, Map<String, Object> map, String charset) throws Exception {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            addHeader(httpPost);
            //设置参数
            List<NameValuePair> list = swapRequestParam(map);

            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            System.out.println(httpPost);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public static String doGet(String url, Map<String, Object> requestMap) throws Exception {
        return doGet(url, requestMap, "UTF-8");
    }

    public static String doGet(String url, Map<String, Object> map, String charset) throws Exception {
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            String requestUrl = url + "?" + swapHttpGetParam(map);
            httpGet = new HttpGet(requestUrl);
            addHeader(httpGet);
            //设置参数
            HttpResponse response = httpClient.execute(httpGet);
            System.out.println(response.getStatusLine());
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public static void addHeader(HttpGet httpGet) {
        if (null != AUTH_RESPONSE) {
            httpGet.setHeader("Authorization", "bearer " + AUTH_RESPONSE.getAccess_token());
        }
    }

    public static String fetchStream() throws Exception {
        return doGet(IO_FETCH,new HashMap<String, Object>());
    }

    public static void addHeader(HttpPost httpPost) {
        if (null != AUTH_RESPONSE) {
            httpPost.setHeader("Authorization", "bearer " + AUTH_RESPONSE.getAccess_token());
        }
    }

    public static String getDeviceListByDeptNo(final String storeNo) throws Exception {
        return doGet(DEVICE_LIST_BY_DEPTNO, new HashMap<String, Object>() {{
            put("pageNo", 1);
            put("pageSize", 100);
            put("storeNo", storeNo);
        }});
    }
    public static String swapHttpGetParam(Map<String, Object> paramMap) {
        StringBuilder sb = new StringBuilder();
        if (null == paramMap) {
            return sb.toString();
        }
        Iterator iterator = paramMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> elem = (Map.Entry<String, Object>) iterator.next();
            sb.append(elem.getKey()).append("=").append(String.valueOf(elem.getValue())).append("&");
        }
        System.out.println(sb.toString());
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        System.out.println(sb.toString());

        return sb.toString();

    }

    public static List<NameValuePair> swapRequestParam(Map<String, Object> paramMap) {
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        if (null == paramMap) {
            return list;
        }
        Iterator iterator = paramMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> elem = (Map.Entry<String, Object>) iterator.next();
            list.add(new BasicNameValuePair(elem.getKey(), String.valueOf(elem.getValue())));
        }
        return list;
    }

    static class SSLClient extends DefaultHttpClient {

        public SSLClient() throws Exception {
            super();
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = this.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", 443, ssf));
        }

    }

    public static AuthResponse auth() throws Exception {
        String authResponse = doPost(AUTH, new HashMap<String, Object>() {
            {
                put("client_id", client_id);
                put("client_secret", client_secret);
                put("grant_type", "client_credentials");
                put("scope", "");
            }
        }, null);
        System.out.println(authResponse);
        return JSON.parseObject(authResponse, AuthResponse.class);
    }

    public static String getDepartList() throws Exception {
        return doGet(DEPART_LIST, new HashMap<String, Object>() {
            {
                put("pageNo", 1);
                put("pageSize", 100);

            }
        });
    }

    public static String getDeviceList(final String storeId) throws Exception {
        return doGet(DEVICE_LIST, new HashMap<String, Object>() {
            {
                put("pageNo", 1);
                put("pageSize", 100);
                put("storeId", storeId);
            }
        });
    }

    public static String openStandAble() throws Exception {
        ;
        Map<String,Object> param = new HashMap<>();
        param.put("deviceSerial","D70432509");
        param.put("channelNos",Arrays.asList(21));
        String jsonParam = JSONObject.toJSONString(param);
        //application/json
        //application/x-www-form-urlencoded
        String str = doPost(LIVE_VIDEO_OPEN, "application/json",jsonParam);
        System.out.println("-------" + str);
        return str;
    }

    public static String openStand() throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("channelIds","8cc1cc4912824c5f93a9481633c33e79");
        String jsonParam = JSONObject.toJSONString(param);
        //application/json
        //application/x-www-form-urlencoded
        String str = doPost(LIVI_OPEN, param);
        System.out.println("-------" + str);
        return str;
    }


    //批量获取标准流预览地址
    public static String getStandStreamUrl() throws Exception {
        String str = doGet(LIVE_ADDRESS, new HashMap<String, Object>() {{
            put("channelId", "8cc1cc4912824c5f93a9481633c33e79");
        }});
        return str;
    }
}
