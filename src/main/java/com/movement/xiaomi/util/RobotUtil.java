package com.movement.xiaomi.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.URLEncoder;


/**
 * server酱机器人
 * 推送到微信
 */
public class RobotUtil {
   final static String key = "SCU103469T03605dc67ebcac33855fd708308f45365efb09aed848d";
   final static String url= "https://sc.ftqq.com/";

    public static String get(String title,String context){
        String url = RobotUtil.url+key+".send?text="+title+"&desp="+context;
        String result = "";
        HttpGet get = new HttpGet(url);

        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpResponse response = httpClient.execute(get);
            result = getHttpEntityContent(response);

            if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
                result = "服务器异常";
            }
        } catch (Exception e){
            System.out.println("请求异常");
            throw new RuntimeException(e);
        } finally{
            get.abort();
        }
        return result;
    }

    /**
     * post提交
     * @param path
     * @param name
     * @param time
     * @param temperature
     * @return
     */
    public static String sendPost(String path,String name,String time,String temperature,String phone) throws UnsupportedEncodingException {
        name = URLEncoder.encode(name, "UTF-8");
        time = URLEncoder.encode(time, "UTF-8");
        temperature = URLEncoder.encode(temperature, "UTF-8");
        phone = URLEncoder.encode(phone, "UTF-8");

        String url = ""+path+"?name="+name+"&time="+time+"&temperature="+temperature+"&phone="+phone+"";

        String result = "";
        HttpPost get = new  HttpPost(url);
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpResponse response = httpClient.execute(get);
            result = getHttpEntityContent(response);

            if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
                result = "服务器异常";
            }
        } catch (Exception e){
            System.out.println("请求异常");
            throw new RuntimeException(e);
        } finally{
            get.abort();
        }
        return result;
    }

    public static String getHttpEntityContent(HttpResponse response) throws UnsupportedOperationException, IOException{
        String result = "";
        HttpEntity entity = response.getEntity();
        if(entity != null){
            InputStream in = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder strber= new StringBuilder();
            String line = null;
            while((line = br.readLine())!=null){
                strber.append(line+'\n');
            }
            br.close();
            in.close();
            result = strber.toString();
        }

        return result;

    }

}
