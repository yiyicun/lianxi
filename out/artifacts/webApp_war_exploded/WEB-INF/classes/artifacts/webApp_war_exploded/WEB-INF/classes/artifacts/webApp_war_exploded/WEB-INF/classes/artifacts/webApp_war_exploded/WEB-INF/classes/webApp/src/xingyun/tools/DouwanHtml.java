package xingyun.tools;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.util.EntityUtils;

public class DouwanHtml {
	

	public static void main(String[] args) throws URISyntaxException {

		String session = "PHPSESSID=jcstalun90e4gb4c10j00dsse6; usersid=15298; sound=on; tab-menu=jianada; issond=0; showid=8; tab-button=game_8; Hm_lvt_3b05fb412042bba733e1916f29cb67f6=1627297725,1627308758; Hm_lpvt_3b05fb412042bba733e1916f29cb67f6=1627308761";
        String[] paras =  {"1","3","6","10","15","21","28","36","45","55","63","69","73","75","75","73","69","63","55","45","36","28","21","15","10","6","3","1"};
	

		try {
			DouwanHtml zmxx = new DouwanHtml();

			Double d = Math.random();
	    	String tString = d.toString();
		String ss = zmxx.keepsession("https://haochehq.com/sgame.php?act=8&page=1&t="+tString,"",session,"https://haochehq.com/game.php");
	

		                               
			                      
			System.out.println(ss);
		} catch (RuntimeException e) {

			e.printStackTrace();
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	//获取
	public String keepsession(String url,String host, String session,String rel)
			throws ClientProtocolException, IOException, URISyntaxException {

		HttpClient httpclient = new DefaultHttpClient();

		HttpResponse response;
		HttpEntity entity;
		String html = "";

		try {

			//在JDK1.7客户端代码中指定使用的协议
			//System.setProperty("https.protocols", "TLSv1.2");
			// 创建httpget
			HttpGet httpGet = getHttpGet(url,host, session,rel);
			// 执行get请求.
			response = httpclient.execute(httpGet);
			// 获取响应实体
			entity = response.getEntity();

			// 打印响应状态
			System.out.println(response.getStatusLine());
			if (entity != null) {
				
				// 打印响应内容
				html = EntityUtils.toString(entity, "utf-8");
				
			}
			return html;

		} catch (IOException e) {

			e.printStackTrace();
			return null;
		} finally {
			// 关闭连接,释放资源
			httpclient.getConnectionManager().shutdown();

		}

	}
	
	//获取
		public String keepsessionbYYuce(String url,String session,String rel)
				throws ClientProtocolException, IOException, URISyntaxException {

			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response;
			HttpEntity entity;
			String html = "";

			try {
				// 创建httpget
				HttpGet httpGet = getHttpGetByYuce(url,session,rel);
				// 执行get请求.
				response = httpclient.execute(httpGet);
				// 获取响应实体
				entity = response.getEntity();

				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					
					// 打印响应内容
					html = EntityUtils.toString(entity, "utf-8");
					
				}
				return html;

			} catch (IOException e) {

				e.printStackTrace();
				return null;
			} finally {
				// 关闭连接,释放资源
				httpclient.getConnectionManager().shutdown();

			}

		}
	
	//获取
	public String keepsessionPeilv(String url, String session,String issue)
			throws ClientProtocolException, IOException, URISyntaxException {

		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet();
		HttpResponse response;
		HttpEntity entity;
		String html = "";

		try {
			// 创建httpget
			httpGet = getHttpGetPeilv(httpGet, url, session,issue);
			// 执行get请求.
			response = httpclient.execute(httpGet);
			// 获取响应实体
			entity = response.getEntity();
			// 打印响应状态
			System.out.println(response.getStatusLine());
			if (entity != null) {
				// 打印响应内容
				html = EntityUtils.toString(entity, "gb2312");
			}
			return html;

		} catch (IOException e) {

			e.printStackTrace();
			return null;
		} finally {
			// 关闭连接,释放资源
			httpclient.getConnectionManager().shutdown();

		}

	}
	
	
	//提交数据post
	public String keepsessionPost(String url, String session, String issue,
			String paras[],String rel,String type) throws ClientProtocolException, IOException,
			URISyntaxException {
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost();
		String html = "-1";
		try {
			// 创建httpget
			httpPost = getHttpPost(httpPost, url, session, issue, paras,rel,type);
			// 执行get请求.
			HttpResponse response = httpclient.execute(httpPost);
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			// 打印响应状态
			String ss = response.getStatusLine().toString();
			if (entity != null) {
				html = EntityUtils.toString(entity, "utf-8");
				
			}
			return ss;

		} catch (IOException e) {

			e.printStackTrace();
			return "-1";
		} finally {
			// 关闭连接,释放资源
			httpclient.getConnectionManager().shutdown();

		}

	}
	
	//提交数据post
	public String keepsessionPost16(String url, String session, String issue,
			String paras[],String rel) throws ClientProtocolException, IOException,
			URISyntaxException {

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost();
		String html = "";
		try {
			// 创建httpget
			httpPost = getHttpPost16(httpPost, url, session, issue, paras,rel);
			// 执行get请求.
			HttpResponse response = httpclient.execute(httpPost);
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			// 打印响应状态
			System.out.println("给币16投:"+response.getStatusLine());
			if (entity != null) {
				html = EntityUtils.toString(entity, "utf-8");
				
			}
			return html;

		} catch (IOException e) {

			e.printStackTrace();
			return "-1";
		} finally {
			// 关闭连接,释放资源
			httpclient.getConnectionManager().shutdown();

		}

	}

	
	
	//PK10提交数据post
	public String keepsessionPostPK10(String url, String session, String issue,
			String paras[]) throws ClientProtocolException, IOException,
			URISyntaxException {

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost();
		String html = "";
		try {
			// 创建httpget
			httpPost = getHttpPostPK10(httpPost, url, session, issue, paras);
			// 执行get请求.
			HttpResponse response = httpclient.execute(httpPost);
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			// 打印响应状态
			System.out.println(response.getStatusLine());
			if (entity != null) {
				html = EntityUtils.toString(entity, "utf-8");
				
			}
			return html;

		} catch (IOException e) {

			e.printStackTrace();
			return "-1";
		} finally {
			// 关闭连接,释放资源
			httpclient.getConnectionManager().shutdown();

		}

	}

	
	//get设置
	public static HttpGet getHttpGet(String url,String host,
			String sessionString,String rel) throws URISyntaxException {

		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("Accept","*/*");
		//httpget.setHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; {D9D54F49-E51C-445e-92F2-1EE3C2313240}; .NET4.0C; .NET4.0E)");
		
		httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
		//httpget.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpget.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
		httpget.setHeader("Host", host);
		httpget.setHeader("Connection", "keep-alive");
		httpget.setHeader("Referer", rel);
		httpget.setHeader("Cookie", sessionString);
		
		
	
		
		
		return httpget;
		
		
		
	}
	
	//get设置
		public static HttpGet getHttpGetByYuce(String host,String sessionString,
				String rel) throws URISyntaxException {

			HttpGet httpget = new HttpGet(host);
			//httpget.setHeader("Accept","*/*");
			//httpget.setHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; {D9D54F49-E51C-445e-92F2-1EE3C2313240}; .NET4.0C; .NET4.0E)");
			
			httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			httpget.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
			httpget.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
			httpget.setHeader("Host", "47.75.107.11:5397");
			httpget.setHeader("Connection", "keep-alive");
			httpget.setHeader("Referer", rel);
			httpget.setHeader("Cookie", sessionString);
			
			return httpget;
			
			
			
		}
	
	//get设置
	public static HttpGet getHttpGetPeilv(HttpGet httpget, String host,
			String sessionString,String issue) throws URISyntaxException {

		httpget.setURI(new URI(host.toString()));
		httpget.setHeader("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		httpget.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpget.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
		httpget.setHeader("Host", "47.75.107.11:5397");
		httpget.setHeader("Connection", "keep-alive");
		httpget.setHeader("Referer", host);
		httpget.setHeader("Cookie", sessionString);
		return httpget;
	}
	
	//post设置
	public static HttpPost getHttpPost(HttpPost httpPost, String host,
			String sessionString, String issue, String paras[],String rel,String type)
			throws UnsupportedEncodingException, URISyntaxException {

		httpPost.setURI(new URI(host.toString()));
		httpPost.setHeader("Accept","application/json, text/javascript, */*");
		httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
		httpPost.setHeader("Host", "47.75.107.11:5397");
		httpPost.setHeader("Connection", "keep-alive");
		httpPost.setHeader("Referer", rel);
		httpPost.setHeader("Cookie", sessionString);
		httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
		
		int sum = 0;
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < paras.length; i++) {
			if( !paras[i].equals("0")) {
				string.append(paras[i]);
				string.append(",");
				sum += Integer.valueOf(paras[i]);
			} else {
				string.append(",");
			}
		}
		string.append(",");
		string.deleteCharAt(string.length()-1);
		formparams.add(new BasicNameValuePair("act","savepress"));
		formparams.add(new BasicNameValuePair("gtype",type));
		formparams.add(new BasicNameValuePair("no",issue));
		formparams.add(new BasicNameValuePair("press",string.toString()));
		formparams.add(new BasicNameValuePair("total",String.valueOf(sum)));
		
		
		
		
		
		
		
		
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams);
		httpPost.setEntity(uefEntity);

		return httpPost;
	}
	
	
	//post设置
	public static HttpPost getHttpPost16(HttpPost httpPost, String host,
			String sessionString, String issue, String paras[],String rel)
			throws UnsupportedEncodingException, URISyntaxException {

		httpPost.setURI(new URI(host.toString()));
		httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpPost.setHeader("Accept-Language", "zh-CN");
		httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:38.0) Gecko/20100101 Firefox/38.0");
		//httpPost.setHeader("Host", "112.90.18.6");
		httpPost.setHeader("Host", "47.75.107.11:5397");
		httpPost.setHeader("Connection", "keep-alive");
		httpPost.setHeader("Referer",host);
		httpPost.setHeader("Cookie",sessionString);
		httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < paras.length; i++) {
			if( !paras[i].equals("0")) {
				sb.append("ztcount");
				sb.append(i+3);
				sb.append(":");
				sb.append(paras[i]);
				sb.append(",");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		formparams.add(new BasicNameValuePair("insertval",sb.toString()));
		formparams.add(new BasicNameValuePair("lot",issue));
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams);
		httpPost.setEntity(uefEntity);
		return httpPost;
	}
	
	
	//post设置
	public static HttpPost getHttpPostPK10(HttpPost httpPost, String host,
			String sessionString, String issue, String paras[])
			throws UnsupportedEncodingException, URISyntaxException {

		httpPost.setURI(new URI(host.toString()));
		httpPost.setHeader("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		httpPost.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:37.0) Gecko/20100101 Firefox/37.0");
		httpPost.setHeader("Host", "47.75.107.11:5397");
		httpPost.setHeader("Connection", "keep-alive");
		httpPost.setHeader("Cookie", sessionString);
		httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		String ztcount = "ztcount";
		StringBuilder sb = new StringBuilder();
		formparams.add(new BasicNameValuePair("insertval", ""));
		for (int i = 1; i < paras.length; i++) {
			if( !paras[i].equals("0") ) {
				sb.append(ztcount);
				sb.append(i);
				sb.append(":");
				sb.append(paras[i]);
				sb.append(",");
			}
		}
		if( sb.length() > 0 ) {
			sb.deleteCharAt(sb.length()-1);
		}
		
		formparams.add(new BasicNameValuePair("insertval", sb.toString()));
		String m = String.valueOf(Math.random());
		formparams.add(new BasicNameValuePair("lot", issue));
		formparams.add(new BasicNameValuePair("rad", m));
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams,"utf-8");
		httpPost.setEntity(uefEntity);

		return httpPost;
	}
}
