package xingyun.service;


import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;


import xingyun.dao.JndebDAO;
import xingyun.dao.JndebResultDAO;

import xingyun.model.Jndeb;
import xingyun.model.JndebResult;



 
public class InfoMxJndebService {
	private static SimpleDateFormat sdf ;
	private JndebDAO jndebDAO;
	private JndebResultDAO jndebResultDAO;

	private static String biaopei[] = {"1000","333.33","166.66","100","66.66","47.61","35.71","27.77","22.22","18.18","15.87","14.49","13.69","13.33","13.33","13.69","14.49","15.87","18.18","22.22","27.77","35.71","47.61","66.66","100","166.66","333.33","1000"};
	private static String peilv[] = {"1000","3000","6000","10000","15000","21000","28000","36000","45000","55000","63000","69000","73000","75000","75000","73000","69000","63000","55000","45000","36000","28000","21000","15000","10000","6000","3000","1000"};
	private static String gailv[] = {"0.1","0.3","0.6","1","1.5","2.1","2.8","3.6","4.5","5.5","6.3","6.9","7.3","7.5","7.5","7.3","6.9","6.3","5.5","4.5","3.6","2.8","2.1","1.5","1","0.6","0.3","0.1"};
	private static Byte zuiduo[] = {0,0,0,0,0,0,0,7,0,0,0,11,12,0,0,0,0,17,18,19,20,21,22,23,0,25,26,27};
	private static Byte  zuiduo_2012[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,-1,-1,15,16,17,18,19,2-1,21,22,23,24,25,26,0};
	private static float[] biaogl = {0.001f,0.003f,0.006f,0.01f,0.015f,0.021f,0.028f,0.036f,0.045f,0.055f,0.063f,0.069f,0.073f,0.075f,0.075f,0.073f,0.069f,0.063f,0.055f,0.045f,0.036f,0.028f,0.021f,0.015f,0.010f,0.006f,0.003f,0.001f};
	private static String[] biaotou = {"1","3","6","10","15","21","28","36","45","55","63","69","73","75","75","73","69","63","55","45","36","28","21","15","10","6","3","1"};

	
	private static int[][] nextTouzhu = {{3,4,5,6,11,14,16,17,18,20,21,24,25},
		{3,4,5,6,9,11,15,16,19,21,22,23},
		{3,6,11,13,15,16,17,18,19,25},
		{6,8,14,17,18,19,23,24,25,27},
		{1,2,4,5,8,12,14,15,16,19,20,21,22,24},
		{2,5,7,9,10,15,19,20,21,22,25,26,27},
		{5,7,9,10,12,15,17,18,20,22,23,24,25,27},
		{4,9,10,12,14,15,17,18,19,21,22,25,27},
		{3,4,5,8,11,14,16,17,18,20,22,25,26},
		{4,7,8,12,13,18,19,20,21,22,27},
		{10,11,12,16,17,19,20,21,23,26}, 
		{3,11,12,13,14,15,17,19,20,22,23,26,27},
		{10,11,12,13,17,18,19,20,23,24,25,26,27},
		{7,8,11,12,14,16,17,18,19,20,22,23,25,26,27},
		{3,4,12,16,17,18,19,20,21,22,24},
		{5,7,8,10,12,14,17,18,19,20,21,22,24,25,26,27},
		{10,12,13,15,17,18,19,20,22,25,26},
		{5,7,8,10,13,14,15,16,18,22,23,24,26,27},
		{2,3,9,15,16,17,18,19,20,21,22,24,26,27},
		{5,7,12,13,15,16,17,19,20,21,22,23,25,27},
		{2,8,9,11,12,17,18,19,23,25,26,27},
		{0,5,6,10,13,15,16,17,18,19,20,22,23,24,25,27},
		{0,3,4,5,8,11,13,14,15,17,20,24,25},
		{6,7,9,10,11,15,16,17,19,21,25,26},
		{0,3,7,8,11,12,13,14,16,17,19,22,25,26},
		{2,3,6,9,12,13,20,21},
		{1,2,3,4,6,8,9,10,11,14,19,22,23,26},
		{3,7,9,10,14,16,18,20,21,22,24,26}};
		
	
	
	public InfoMxJndebService(){
		jndebDAO =  new JndebDAO();
		jndebResultDAO = new JndebResultDAO();
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
	}
	
	//从time开始连小情况
	public void getLianxiao(String time) throws ParseException{
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int i = 0;
		int j = 0;
		int c[][] = new int[18][1];
		int qi = 0;
		int da = 0;
		int t = tianshu(time);
		
		if (Integer.valueOf(list.get(0)[1]) < 14) {
			c[0][0]++;
		}

		for (int k = 0; k < list.size(); k++) {
			int a = Integer.valueOf(list.get(k)[1]);
			if (a < 14 && i > 13) {
				j = 1;
			}
			if (a < 14 && k > 0 && i < 14) {
				j++;
			}
			if (a > 13 && i < 14 && j == 1) {
				c[0][0]++;
			}
			if (a > 13 && i < 14 && j > 1) {
				c[j - 1][0]++;
				j = 0;
			}
			if (a > 13) {
				da++;
			}
			i = a;

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("大小比:" + da + "次:" + (list.size() - da) + "次");
		for (int l = 0; l < c.length; l++) {
			System.out.println((l + 1) + "连次数:" + c[l][0]);
			if (l > 4) {
				qi = qi + c[l][0];
			}
		}
		System.out.println("6连以上:" + qi + "次");
		float pj = (float) qi/t ;
	    float rijun = (float) (Math.round(pj*100))/100;
	    System.err.println("日均连:"+rijun );
	}

	//从time开始连小情况
	public void getLianda(String time) {
		
		
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int qi = 0;
		int i = 0;
		int j = 0;
		int da = 0;
		int c[][] = new int[19][1];
		int t = tianshu(time);

		
		for (int k = 0; k < list.size(); k++) {

			int a = Integer.valueOf(list.get(k)[1]);

			if ( (a > 14 || a == 12) && a != 27 ) {
				
				da++;
			}
			

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("大小比:" +da + "次:" +  (list.size() - da) + "次");
		
	}

	public void getLianji(String time) {
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int i = 0;
		int j = 0;
		int c[][] = new int[15][1];
		int ou = Integer.valueOf(list.get(0)[1]);
		int shuang = 0;

		if (ou % 2 != 0) {
			c[0][0]++;
		}

		for (int k = 0; k < list.size(); k++) {

			int a = Integer.valueOf(list.get(k)[1]);

			if ((a % 2 != 0) && (i % 2 == 0)) {
				j = 1;
			}
			if ((a % 2 != 0) && k > 0 && (i % 2 != 0)) {
				j++;
			}
			if ((a % 2 == 0) && (i % 2 != 0) && j == 1) {

				c[0][0]++;
			}
			if ((a % 2 == 0) && (i % 2 != 0) && j > 1) {
				c[j - 1][0]++;
				j = 0;
			}

			if ((a % 2 == 0)) {

				shuang++;
			}
			i = a;

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("单双比:" + (list.size() - shuang) + "次:" + shuang
				+ "次");
		for (int l = 0; l < c.length; l++) {
			System.out.println((l + 1) + "连次数:" + c[l][0]);
		}
	}

	public void getLianou(String time) {
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int i = 0;
		int j = 0;
		int c[][] = new int[15][1];
		int ou = Integer.valueOf(list.get(0)[1]);
		int ji = 0;

		if (ou % 2 == 0) {
			c[0][0]++;
		}

		for (int k = 0; k < list.size(); k++) {

			int a = Integer.valueOf(list.get(k)[1]);

			if ((a % 2 == 0) && (i % 2 != 0)) {
				j = 1;
			}
			if ((a % 2 == 0) && k > 0 && (i % 2 == 0)) {
				j++;
			}
			if ((a % 2 != 0) && (i % 2 == 0) && j == 1) {

				c[0][0]++;
			}
			if ((a % 2 != 0) && (i % 2 == 0) && j > 1) {
				c[j - 1][0]++;
				j = 0;
			}
			if ((a % 2 != 0)) {

				ji++;
			}
			i = a;

		 }
		System.out.println("共" + list.size() + "条记录");
		System.out.println("单双比:" + ji + "次:" + (list.size() - ji) + "次");
		for (int l = 0; l < c.length; l++) {
			System.out.println((l + 1) + "连次数:" + c[l][0]);
		}
	}

	public void getLianxiaowei(String time) {
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int i = 0;
		int j = 0;
		int c[][] = new int[15][1];
		int ou = Integer.valueOf(list.get(0)[1]);
		int dawei = 0;

		if (ou % 10 < 5) {
			c[0][0]++;
		}

		for (int k = 0; k < list.size(); k++) {

			int a = Integer.valueOf(list.get(k)[1]);

			if ((a % 10 < 5) && (i % 10 > 4)) {
				j = 1;
			}
			if ((a % 10 < 5) && k > 0 && (i % 10 < 5)) {
				j++;
			}
			if ((a % 10 > 4) && (i % 10 < 5) && j == 1) {

				c[0][0]++;
			}
			if ((a % 10 > 4) && (i % 10 < 5) && j > 1) {
				c[j - 1][0]++;
				j = 0;
			}
			if (a % 10 > 4) {

				dawei++;
			}
			i = a;

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("大小比:" + dawei + "次:" + (list.size() - dawei) + "次");
		for (int l = 0; l < c.length; l++) {
			System.out.println((l + 1) + "连次数:" + c[l][0]);
		}
	}

	
	//从time开始连大尾情况
	public void getLiandawei(String time) {
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int i = 0;
		int j = 0;
		int c[][] = new int[15][1];
		int ou = Integer.valueOf(list.get(0)[1]);
		int dawei = 0;
		if (ou % 10 > 4) {
			c[0][0]++;
		}

		for (int k = 0; k < list.size(); k++) {

			int a = Integer.valueOf(list.get(k)[1]);

			if ((a % 10 > 4) && (i % 10 < 5)) {
				j = 1;
			}
			if ((a % 10 > 4) && k > 0 && (i % 10 > 4)) {
				j++;
			}
			if ((a % 10 < 5) && (i % 10 > 4) && j == 1) {

				c[0][0]++;
			}
			if ((a % 10 < 5) && (i % 10 > 4) && j > 1) {
				c[j - 1][0]++;
				j = 0;
			}
			if (a % 10 < 5) {

				dawei++;
			}
			i = a;

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("大小比:" + (list.size() - dawei) + "次:" + dawei + "次");
		for (int l = 0; l < c.length; l++) {
			System.out.println((l + 1) + "连次数:" + c[l][0]);
		}
	}

	public void getLianzhong(String time) {
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int i = 0;
		int j = 0;
		int c[][] = new int[20][1];
		int z = Integer.valueOf(list.get(0)[1]);
		int bian = 0;

		if (z > 9 && z < 18) {
			c[0][0]++;
		}

		for (int k = 0; k < list.size(); k++) {

			int a = Integer.valueOf(list.get(k)[1]);

			if ((a > 9 && a < 18) && (i < 10 || i > 17)) {
				j = 1;
			}
			if ((a > 9 && a < 18) && k > 0 && (i > 9 && i < 18)) {
				j++;
			}
			if ((a < 10 || a > 17) && (i > 9 && i < 18) && j == 1) {

				c[0][0]++;
			}
			if ((a < 10 || a > 17) && (i > 9 && i < 18) && j > 1) {
				c[j - 1][0]++;
				j = 0;
			}
			if (a < 10 || a > 17) {

				bian++;
			}
			i = a;

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("中边比:" + (list.size() - bian) + "次:" + bian + "次");
		for (int l = 0; l < c.length; l++) {
			System.out.println((l + 1) + "连次数:" + c[l][0]);
		}
	}
    
	//截止到time连边情况
	public void getLianbian(String time) {
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int i = 0;
		int j = 0;
		int c[][] = new int[15][1];
		int z = Integer.valueOf(list.get(0)[1]);
		int zhong = 0;
		int total = 0;

		if ((z < 10 || z > 17)) {
			c[0][0]++;
		}

		for (int k = 0; k < list.size(); k++) {

			int a = Integer.valueOf(list.get(k)[1]);

			if ((a < 10 || a > 17) && (i > 9 && i < 18)) {
				j = 1;
			}
			if ((a < 10 || a > 17) && k > 0 && (i < 10 || i > 17)) {
				j++;
			}
			if ((a > 9 && a < 18) && (i < 10 || i > 17) && j == 1) {

				c[0][0]++;
			}
			if ((a > 9 && a < 18) && (i < 10 || i > 17) && j > 1) {
				c[j - 1][0]++;
				j = 0;
			}
			if (a > 9 && a < 18) {

				zhong++;
			}
			i = a;

		}
		System.out.println("共" + list.size() + "条记录");
		float bili = (float) zhong/(float)(list.size()-zhong);
		float  b   =  (float)(Math.round(bili*100))/100;
		System.out.println("中边比:" + zhong + "次:" + (list.size() - zhong) + "次  "+b);
		for (int l = 0; l < c.length; l++) {
			System.out.println((l + 1) + "次数:" + c[l][0]);
			if (l > 4) {
				total += c[l][0];
			}
		}
		System.out.println("大于连5次数:" + total);
	}
	
	//从time开始连边情况
	public void getLianbianLast(String time) {
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int i = 0;
		int j = 0;
		int c[][] = new int[15][1];
		int z = Integer.valueOf(list.get(0)[1]);
		int zhong = 0;
		int total = 0;

		if ((z < 10 || z > 17)) {
			c[0][0]++;
		}

		for (int k = 0; k < list.size(); k++) {

			int a = Integer.valueOf(list.get(k)[1]);

			if ((a < 10 || a > 17) && (i > 9 && i < 18)) {
				j = 1;
			}
			if ((a < 10 || a > 17) && k > 0 && (i < 10 || i > 17)) {
				j++;
			}
			if ((a > 9 && a < 18) && (i < 10 || i > 17) && j == 1) {

				c[0][0]++;
			}
			if ((a > 9 && a < 18) && (i < 10 || i > 17) && j > 1) {
				c[j - 1][0]++;
				j = 0;
			}
			if (a > 9 && a < 18) {

				zhong++;
			}
			i = a;

		}
		System.out.println("共" + list.size() + "条记录");
		float bili = (float) zhong/(float)(list.size()-zhong);
		float  b   =  (float)(Math.round(bili*100))/100;
		System.out.println("中边比:" + zhong + "次:" + (list.size() - zhong) + "次  "+b);
		for (int l = 0; l < c.length; l++) {
			System.out.println((l + 1) + "次数:" + c[l][0]);
			if (l > 4) {
				total += c[l][0];
			}
		}
		System.out.println("大于连5次数:" + total);
	}
	
	//每期走势-中边
	public String getZhongbyone(String time) {
		List<String[]> list = jndebDAO.findResultByIssue(time);
		int flat = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
        int count = list.size();
        int zhong = 0;
        sbDate.append("\"");
		sbDate.append(0);
		sbDate.append("\",");
		sbTotal.append(8);
		sbTotal.append(",");
		for (int k = 0; k < list.size(); k++) {
			count--;
			String data = list.get(k)[0];
			int a = Integer.valueOf(list.get(k)[1]);
			if( a > 9 && a < 18){
				flat = 2;
				zhong++;
			}else {
				flat = 1;
			}
			sbDate.append("\"");
			sbDate.append(data+":"+String.valueOf(k+1));
			sbDate.append("\"");
			sbTotal.append(flat);

			if ( count > 0 ) {
				sbDate.append(",");
				sbTotal.append(",");
			}

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("中边比:" + zhong + "次:" + (list.size() - zhong) + "次");
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	//每期走势-大小
	public String getDabyone(String time) {
		
		List<String[]> list = jndebDAO.findResultByIssue(time);
		int flat = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
        int count = list.size();
        int da = 0;
        sbDate.append("\"");
		sbDate.append(0);
		sbDate.append("\",");
		sbTotal.append(3);
		sbTotal.append(",");

		for (int k = 0; k < list.size(); k++) {
			count--;
			String data = list.get(k)[0];
			int a = Integer.valueOf(list.get(k)[1]);
			if( a > 13){
				flat = 2;
				da++;
			}else {
				flat = 1;
			}
			sbDate.append("\"");
			sbDate.append(data+":"+String.valueOf(k+1));
			sbDate.append("\"");
			sbTotal.append(flat);

			if ( count > 0 ) {
				sbDate.append(",");
				sbTotal.append(",");
			}

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("大小比:" + da + "次:" + (list.size() - da) + "次");
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	//每期走势-单双
	public String getDanbyone(String time) {
		
		List<String[]> list = jndebDAO.findResultByIssue(time);
		int flat = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
        int count = list.size();
        int dan = 0;
        sbDate.append("\"");
		sbDate.append(0);
		sbDate.append("\",");
		sbTotal.append(3);
		sbTotal.append(",");

		for (int k = 0; k < list.size(); k++) {
			count--;
			String data = list.get(k)[0];
			int a = Integer.valueOf(list.get(k)[1]);
			if( a%2 != 0){
				flat = 2;
				dan++;
			}else {
				flat = 1;
			}
			sbDate.append("\"");
			sbDate.append(data+":"+String.valueOf(k+1));
			sbDate.append("\"");
			sbTotal.append(flat);

			if ( count > 0 ) {
				sbDate.append(",");
				sbTotal.append(",");
			}

		}
		System.out.println("共" + list.size() + "条记录");
		System.out.println("单双比:" + dan + "次:" + (list.size() - dan) + "次");
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	//日均统计中边比情况
	public String getBilizbByDate(String time1) throws ParseException {

		String ss = time1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(ss);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);                         //计算起始日期
		int t = tianshu(time1);		                //与数据库相隔天数 
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int xunhuan = t;
		int count = 0;
		int total = 0;
		
		for (int n = 0; n < t; n++) {
			
			cal1.add(Calendar.DATE, 1);
			date = cal1.getTime();
			String time2 = sdf.format(date);
			List<String[]> list = jndebDAO.findAllResultByDate(time1, time2);
			count = count + list.size();
			xunhuan--;
			if (list.size() != 0) {
				
				System.out.println(list.size());
				
				int zhong = 0;
				for (int k = 0; k < list.size(); k++) {
					int z = Integer.valueOf(list.get(k)[1]);
					if ((z > 9 && z < 18)) {
						zhong++;
					}
					
				}
				
				float bili = (float) zhong/(float)(list.size()-zhong);
				float  b   =  (float)(Math.round(bili*100))/100;
				System.out.println("中边比:" + zhong + "次:" + (list.size() - zhong) + "次  "+b);
				int bian = (list.size() - zhong);
				total += bian;
				sbDate.append("\"");
				sbDate.append(sdf.format(date));
				sbDate.append("\"");
				sbTotal.append(b);

				if ( xunhuan > 0 ) {
					sbDate.append(",");
					sbTotal.append(",");
				}
			} else {
				break;
			}
			
		}
		System.out.println("共" + count + "条记录");
        System.out.println("日数为"+t);
        float totalbili = (float) (count - total)/(float)total;
		float  totalb   =  (float)(Math.round( totalbili*100) )/100;
		System.out.println("总数中边比:" + (count-total) + "次:" + total  + "次  "+totalb);
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	//日均统计大小比情况
	public String getBilidxByDate(String time1) throws ParseException {

		String ss = time1;
		Date date = sdf.parse(ss);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		int t = tianshu(time1);
		System.out.println(t);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int xunhuan = t;
		int count = 0;
		int total = 0;
		
		for (int n = 0; n < t; n++) {
			
			cal1.add(Calendar.DATE, 1);
			date = cal1.getTime();
			String time2 = sdf.format(date);
			List<String[]> list = jndebDAO.findAllResultByDate(time1, time2);
			count = count + list.size();
			xunhuan--;
			if (list.size() != 0) {
				System.out.println(list.size());
				int da = 0;
				for (int k = 0; k < list.size(); k++) {
					int z = Integer.valueOf(list.get(k)[1]);
					if ((z > 13)) {
						da++;
					}
				}
				float bili = (float) da/(float)(list.size()-da);
				float  b   =  (float)(Math.round(bili*100))/100;
				int xiao = (list.size() - da);
				total += xiao;
				System.out.println("大小比:" + da + "次:" + xiao  + "次  "+b);
				sbDate.append("\"");
				sbDate.append(sdf.format(date));
				sbDate.append("\"");
				sbTotal.append(b);
				if ( xunhuan > 0 ) {
					sbDate.append(",");
					sbTotal.append(",");
				}
			} else {
				break;
			}
			
		}
		System.out.println("共" + count + "条记录");
		float totalbili = (float) (count - total)/(float)total;
		float  totalb   =  (float)(Math.round( totalbili*100) )/100;
		System.out.println("总数大小比:" + (count-total) + "次:" + total  + "次  "+totalb);
        System.out.println("日数为"+t);
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	//日均统计奇偶比情况
	public String getBilijoByDate(String time1) throws ParseException {

		Date date = sdf.parse(time1);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		int t = tianshu(time1);
		System.out.println(t);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int xunhuan = t;
		int count = 0;
		int total = 0;
		
		for (int n = 0; n < t; n++) {
			
			cal1.add(Calendar.DATE, 1);
			date = cal1.getTime();
			String time2 = sdf.format(date);
			List<String[]> list = jndebDAO.findAllResultByDate(time1, time2);
			count = count + list.size();
			xunhuan--;
			if (list.size() != 0) {
				
				System.out.println(list.size());
				
				int ji = 0;
			
				for (int k = 0; k < list.size(); k++) {
					int z = Integer.valueOf(list.get(k)[1]);
					if ((z %2 != 0 )) {
						ji++;
					}
					
				}
				
				float bili = (float) ji/(float)(list.size()-ji);
				float  b   =  (float)(Math.round(bili*100))/100;
				System.out.println("奇偶比:" + ji + "次:" + (list.size() - ji) + "次  "+b);
				int ou = (list.size() - ji);
				total += ou;
				sbDate.append("\"");
				sbDate.append(sdf.format(date));
				sbDate.append("\"");
				sbTotal.append(b);

				if ( xunhuan > 0 ) {
					sbDate.append(",");
					sbTotal.append(",");
				}
			} else {
				break;
			}
			
		}
		System.out.println("共" + count + "条记录");
        System.out.println("日数为"+t);
        float totalbili = (float) (count - total)/(float)total;
		float  totalb   =  (float)(Math.round( totalbili*100) )/100;
		System.out.println("总数奇偶比:" + (count-total) + "次:" + total  + "次  "+totalb);
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	//日均统计连单情况
	public String getLianjiByDate(String time) throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time+" 23:59:59";       //起始日
		Calendar endCal = Calendar.getInstance();   //数据库最大日期
		endCal.setTime(jndebDAO.findMaxTimeErba());
		Date date = df.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int count = 0;          //连号总数
		int t = 1;              //天数

		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		if (list.size() != 0) {
			System.out.println(list.size());
			int i = 0;
			int j = 0;
			int c[][] = new int[19][1];
			int ji = 0;
			int total = 0;
			for (int k = 0; k < list.size(); k++) {

				Timestamp timestamp = list.get(k).getTime();
				int ct = timestamp.compareTo(dayDate);
				int a = list.get(k).getResult();
				//连号存入数组
				if (a % 2 != 0) {
					j++;
					ji++;
				}
				if (a % 2 == 0 && i % 2 != 0) {  
					c[j][0]++;
					j = 0;
				}
				i = a;
				//每日统计
				if (ct > 0 && j == 0) {
					t++;
					//计算n连
					for (int l = 0; l < c.length; l++) {

						if (l > 5) { // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate)); 
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
					//第二天置0
					i = 0;
					j = 0;
					ji = 0;
					total = 0;
					for (int l = 0; l < c.length; l++) {
						c[l][0] = 0;
					}
					
				}
			} 
			//补计最后一天
			if( endCal.get(Calendar.YEAR) == dayCal.get(Calendar.YEAR) && 
					endCal.get(Calendar.MONTH) == dayCal.get(Calendar.MONTH) &&
					endCal.get(Calendar.DATE) == dayCal.get(Calendar.DATE) ) {
					
					for (int l = 0; l < c.length; l++) {
						if (l > 5) { // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
					
				}
			sbDate.deleteCharAt(sbDate.length()-1);
			sbTotal.deleteCharAt(sbTotal.length()-1);
		}       
		//输出
        System.out.println("日数为"+t);
        float pj = (float) count/t ;
        float rijun = (float) (Math.round(pj*100))/100;
        System.out.println("日均连单:"+rijun );
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();

	}
	
	
	// 日均统计连双情况
	public String getLianouByDate(String time) throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time+" 23:59:59";       //起始日
		Calendar endCal = Calendar.getInstance();   //数据库最大日期
		endCal.setTime(jndebDAO.findMaxTimeErba());
		Date date = df.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int count = 0;          //连号总数
		int t = 1;              //天数

		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		if (list.size() != 0) {
			System.out.println(list.size());
			int i = 0;
			int j = 0;
			int c[][] = new int[20][1];
			int ou = 0;
			int total = 0;
			for (int k = 0; k < list.size(); k++) {

				Timestamp timestamp = list.get(k).getTime();
				int ct = timestamp.compareTo(dayDate);
				int a = list.get(k).getResult();
				//连号存入数组
				if (a % 2 == 0) {
					j++;
					ou++;
				}
				if (a % 2 != 0 && i % 2 == 0) {
					c[j][0]++;
					j = 0;
				}
				i = a;
				//每日统计
				if (ct > 0 && j == 0) {
					t++;
					//计算n连
					for (int l = 0; l < c.length; l++) {

						if (l > 5) { // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
					//第二天置0
					i = 0;
					j = 0;
					ou = 0;
					total = 0;
					for (int l = 0; l < c.length; l++) {
						c[l][0] = 0;
					}
				
				}
			}
			//补计最后一天
			if( endCal.get(Calendar.YEAR) == dayCal.get(Calendar.YEAR) && 
					endCal.get(Calendar.MONTH) == dayCal.get(Calendar.MONTH) &&
					endCal.get(Calendar.DATE) == dayCal.get(Calendar.DATE) ) {
					
					for (int l = 0; l < c.length; l++) {
						if (l > 5) { // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
				}
			sbDate.deleteCharAt(sbDate.length()-1);
			sbTotal.deleteCharAt(sbTotal.length()-1);
		}
		//输出
		
        System.out.println("日数为"+t);
        float pj = (float) count/t ;
        float rijun = (float) (Math.round(pj*100))/100;
        System.out.println("日均连双:"+rijun );
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();

	}
	
	
	
	//日均统计连大情况
	public String getLiandaByDate(String time) throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time+" 23:59:59";        //输入的起始日
		Calendar endCal = Calendar.getInstance();  
		endCal.setTime(jndebDAO.findMaxTimeErba()); //数据库最大日期
		Date date = df.parse(timeString);  //起始日
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);                        //起始日Calendar格式
		Date dayDate = dayCal.getTime();   //起始日Date格式
		StringBuilder sb = new StringBuilder();      //字符串
		StringBuilder sbDate = new StringBuilder();  //日记录字符串
		StringBuilder sbTotal = new StringBuilder(); //连次数记录字符串
		int count = 0;          //连号总数
		int t = 1;              //天数
		List<Jndeb> list = jndebDAO.findAllResultStart(time);//取得大于输入日的结果集合 
		
		if (list.size() != 0) {
		
			int i = -1;
			int j = 0;
			int c[][] = new int[20][1];        //连次数组
			int da = 0;                        //大计数	
			int total = 0;                     //总数
			for (int k = 0; k < list.size(); k++) {

				Timestamp timestamp = list.get(k).getTime();
				int ct = timestamp.compareTo(dayDate);    //日期比较
				int a = list.get(k).getResult();          //当前期的结构
				//连号存入数组
				if (a > 13) {
					j++;
					da++;
				}
				//断连
				if (a < 14  && i > 13) {
					c[j][0]++;
					j = 0;
					
				}
				i = a;                              //赋值作为上期
				//每日统计
				
				if (ct > 0 && j == 0 ||( k == list.size() -1 )) {
					
					t++;
					//计算n连
					
					for (int l = 0; l < c.length; l++) {
						if (l > 5) {               // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;  // 总数
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
					
					dayCal.add(Calendar.DATE, 1); //下一天
					dayDate = dayCal.getTime();   
					//第二天置0
					i = 0;
					j = 0;
					da = 0;
					total = 0;
					//清空
					for (int l = 0; l < c.length; l++) {
						c[l][0] = 0;                 
					}
				
				}
			}
			sbDate.deleteCharAt(sbDate.length()-1);
			sbTotal.deleteCharAt(sbTotal.length()-1);
		}
		//输出
		
        System.out.println("日数为"+t);
        System.out.println("为"+count);
        float pj = (float) count/t ;
        float rijun = (float) (Math.round(pj*100))/100;
        System.out.println("日均连大:"+rijun );
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();

	}
	
	
	
	
	
	public String getBilidxByhour(String time1) throws ParseException {

		DecimalFormat decimalFormat = new DecimalFormat("0.000");//构造方法的字符格式这里如果小数不足2位,会以0补足.
	
		List<String[]> list = jndebDAO.hourda(time1);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
			
		for (int k = 0; k < list.size(); k++) {
				String date = list.get(k)[0];	
				int da = Integer.valueOf(list.get(k)[1]);
				int xiao = Integer.valueOf(list.get(k)[2]);
				float f = (float) da/xiao;
				if( Float.isInfinite(f) ) {
					f = 0f;
				}
				//float b = (float)(Math.round(f*1000)/1000);
				String b = decimalFormat.format(f);//format 返回的是字符串
				//System.out.println(""+da+"  "+xiao+"  日期"+date+"  大小比:" + b);
				sbDate.append("\"");
				sbDate.append(date);
				sbDate.append("\"");
				sbTotal.append(b);
				if ( k != list.size() - 1 ) {
					sbDate.append(",");
					sbTotal.append(",");
				}
			
			}
	
		System.out.println("共" + list.size() + "条记录");
		sb.append("{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public String getZbByDay(String time1) throws ParseException {

		
	
		List<String[]> issueList = jndebDAO.dayAndIssue(time1);
		Map<String, String> map = new HashMap<String, String>();
		int sum = 0;
		for (String[] strings : issueList) {
			map.put(strings[1], strings[0]);
			
		}
		
	
		
		if( map.size() > 0 && map.get(issueList.get(0)[1] )  != null ) {
			List<String[]> list = jndebDAO.dayzhong(issueList.get(0)[1]);
			StringBuilder sb = new StringBuilder();
			StringBuilder sbDate = new StringBuilder();
			StringBuilder sbTotal = new StringBuilder();
				
			for (int k = 0; k < list.size(); k++) {
					String start = list.get(k)[0];	
					int total = Integer.valueOf(list.get(k)[3]);
					sum += total;
				
				
					sbDate.append("\"");
					sbDate.append(map.get(start));
					sbDate.append("\"");
					sbTotal.append(total);
					if ( k != list.size() - 1 ) {
						sbDate.append(",");
						sbTotal.append(",");
					}
				
			}
			int junxian = (int)sum/map.size();
			System.out.println("共" + list.size() + "条记录");
			sb.append("{");
			sb.append("\"dates\":[");
			sb.append(sbDate.toString());
			sb.append("]");
			sb.append(",\"total\":[");
			sb.append(sbTotal.toString());
			sb.append("]");
			sb.append(",\"junxian\":");
			sb.append(junxian);
			sb.append("}");
			System.out.println(sb.toString());
			return sb.toString();
		}
		
		return null;
		
		
	}
	

	//小时统计单双比情况
	public String getBilidsByhour(String time1) throws ParseException {

		DecimalFormat decimalFormat = new DecimalFormat("0.000");//构造方法的字符格式这里如果小数不足2位,会以0补足.
	
		List<String[]> list = jndebDAO.hourji(time1);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
			
		for (int k = 0; k < list.size(); k++) {
				String date = list.get(k)[0];	
				int ji = Integer.valueOf(list.get(k)[1]);
				int ou = Integer.valueOf(list.get(k)[2]);
				float f = (float) ji/ou;
				if( Float.isInfinite(f) ) {
					f = 0f;
				}
				String b = decimalFormat.format(f);//format 返回的是字符串
				System.out.println(""+ji+"  "+ou+"  日期"+date+"  单双比:" + b);
				sbDate.append("\"");
				sbDate.append(date);
				sbDate.append("\"");
				sbTotal.append(b);
				if ( k != list.size() - 1 ) {
					sbDate.append(",");
					sbTotal.append(",");
				}
			
			}
	
		System.out.println("共" + list.size() + "条记录");
		sb.append("{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	
	
	//小时统计中边比情况
	public String getBilizbByhour(String time1) throws ParseException {

		DecimalFormat decimalFormat = new DecimalFormat("0.000");//构造方法的字符格式这里如果小数不足2位,会以0补足.
	
		List<String[]> list = jndebDAO.hourzhong(time1);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
			
		for (int k = 0; k < list.size(); k++) {
				String date = list.get(k)[0];	
				int ji = Integer.valueOf(list.get(k)[1]);
				int ou = Integer.valueOf(list.get(k)[2]);
				float f = (float) ji/ou;
				if( Float.isInfinite(f) ) {
					f = 0f;
				}
				System.out.println(f);
				String b = decimalFormat.format(f);//format 返回的是字符串
				//System.out.println(""+ji+"  "+ou+"  日期"+date+"  中边比:" + b);
				sbDate.append("\"");
				sbDate.append(date);
				sbDate.append("\"");
				sbTotal.append(b);
				if ( k != list.size() - 1 ) {
					sbDate.append(",");
					sbTotal.append(",");
				}
			
			}
	
		System.out.println("共" + list.size() + "条记录");
		sb.append("{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	// 日均统计连小情况
	public String getLianxiaoByDate(String time) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time+" 23:59:59";       //起始日
		Calendar endCal = Calendar.getInstance();   //数据库最大日期
		endCal.setTime(jndebDAO.findMaxTimeErba());
		Date date = df.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int count = 0;          //连号总数
		int t = 1;              //天数
		

		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		if (list.size() != 0) {
			System.out.println(list.size());
		
			int i = 0;
			int j = 0;
			int c[][] = new int[30][1];
			int xiao = 0;
			int total = 0;
			for (int k = 0; k < list.size(); k++) {

				Timestamp timestamp = list.get(k).getTime();
				int ct = timestamp.compareTo(dayDate);
				int a = list.get(k).getResult();
		
				//连号存入数组
				if (a < 14) {
					j++;
					xiao++;
				}
				if (a > 13 && i < 14) {
					c[j][0]++;
					j = 0;
				}
				i = a;
				//每日统计
				
				if (ct > 0 && j == 0) {
					t++;
					//计算n连
					for (int l = 0; l < c.length; l++) {
						if (l >5){ // l为连号次数
							total += c[l][0];
						}
					}
				
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
					//第二天置0
					i = 0;
					j = 0;
					xiao = 0;
					total = 0;
					for (int l = 0; l < c.length; l++) {
						c[l][0] = 0;
					}
					//补计第一期
				} 
			}
			
			//补计最后一天
			if( endCal.get(Calendar.YEAR) == dayCal.get(Calendar.YEAR) && 
					endCal.get(Calendar.MONTH) == dayCal.get(Calendar.MONTH) &&
					endCal.get(Calendar.DATE) == dayCal.get(Calendar.DATE) ) {
					for (int l = 0; l < c.length; l++) {
						if (l > 5) { // l为连号次数
							
							total += c[l][0];
						}
					}
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
					count = count + total;
				}
			sbDate.deleteCharAt(sbDate.length()-1);
			sbTotal.deleteCharAt(sbTotal.length()-1);
		}
		//输出
	
        System.out.println("日数为"+t);
        
        float pj = (float) (count)/t ;
        float rijun = (float) (Math.round(pj*100))/100;
        System.out.println("日均连小:"+rijun );
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();

	}
	
	// 日均统计连中情况
	public String getLianzhongByDate(String time) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time+" 23:59:59";       //起始日
		Calendar endCal = Calendar.getInstance();   //数据库最大日期
		endCal.setTime(jndebDAO.findMaxTimeErba());
		Date date = df.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int count = 0;          //连号总数
		int t = 1;              //天数

		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		if (list.size() != 0) {
			System.out.println(list.size());
			int i = 0;
			int j = 0;
			int c[][] = new int[25][1];
			int xiao = 0;
			int total = 0;
			for (int k = 0; k < list.size(); k++) {

				Timestamp timestamp = list.get(k).getTime();
				int ct = timestamp.compareTo(dayDate);
				int a = list.get(k).getResult();
		
				//连号存入数组
				if (a > 9 & a < 18) {
					j++;
					xiao++;
				}
				if ( (a < 10 || a > 17 ) && (i > 9 & i < 18) ) {
					c[j][0]++;
					j = 0;
				}
				i = a;
				//每日统计
				if (ct > 0 && j == 0 ) {
					t++;
					//计算n连
					for (int l = 0; l < c.length; l++) {
						if (l > 5) { // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
					//第二天置0
					i = 0;
					j = 0;
					xiao = 0;
					total = 0;
					for (int l = 0; l < c.length; l++) {
						c[l][0] = 0;
					}
					
				}
			}
			//补计最后一天
			if( endCal.get(Calendar.YEAR) == dayCal.get(Calendar.YEAR) && 
					endCal.get(Calendar.MONTH) == dayCal.get(Calendar.MONTH) &&
					endCal.get(Calendar.DATE) == dayCal.get(Calendar.DATE) ) {
					for (int l = 0; l < c.length; l++) {
						if (l >5) { // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
				}
			sbDate.deleteCharAt(sbDate.length()-1);
			sbTotal.deleteCharAt(sbTotal.length()-1);
		}
		//输出
		
        System.out.println("日数为"+t);
        float pj = (float) count/t ;
        float rijun = (float) (Math.round(pj*100))/100;
        System.out.println("日均连中:"+rijun );
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();

	}
	
	
	// 日均统计连中情况
	public String getLianbianByDate(String time) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time+" 23:59:59";       //起始日
		Calendar endCal = Calendar.getInstance();   //数据库最大日期
		endCal.setTime(jndebDAO.findMaxTimeErba());
		Date date = df.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int count = 0;          //连号总数
		int t = 1;              //天数

		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		if (list.size() != 0) {
			System.out.println(list.size());
			int i = 0;
			int j = 0;
			int c[][] = new int[25][1];
			int xiao = 0;
			int total = 0;
			for (int k = 0; k < list.size(); k++) {

				Timestamp timestamp = list.get(k).getTime();
				int ct = timestamp.compareTo(dayDate);
				int a = list.get(k).getResult();
		
				//连号存入数组
				if (a < 10 || a > 17) {
					j++;
					xiao++;
				}
				if ( (a > 9 && a < 18 ) && (i < 10 || i > 17) ) {
					c[j][0]++;
					j = 0;
				}
				i = a;
				//每日统计
				if (ct > 0 && j == 0 ) {
					t++;
					//计算n连
					for (int l = 0; l < c.length; l++) {
						if (l > 4) { // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
					//第二天置0
					i = 0;
					j = 0;
					xiao = 0;
					total = 0;
					for (int l = 0; l < c.length; l++) {
						c[l][0] = 0;
					}
					
				}
			}
			//补计最后一天
			if( endCal.get(Calendar.YEAR) == dayCal.get(Calendar.YEAR) && 
					endCal.get(Calendar.MONTH) == dayCal.get(Calendar.MONTH) &&
					endCal.get(Calendar.DATE) == dayCal.get(Calendar.DATE) ) {
					for (int l = 0; l < c.length; l++) {
						if (l > 4) { // l为连号次数
							total += c[l][0];
						}
					}
					count = count + total;
					sbDate.append("\"");
					sbDate.append(sdf.format(dayDate));
					sbDate.append("\"");
					sbDate.append(",");
					sbTotal.append(total);
					sbTotal.append(",");
				}
			sbDate.deleteCharAt(sbDate.length()-1);
			sbTotal.deleteCharAt(sbTotal.length()-1);
		}
		//输出
		
        System.out.println("日数为"+t);
        float pj = (float) count/t ;
        float rijun = (float) (Math.round(pj*100))/100;
        System.out.println("日均连边:"+rijun );
		sb.append("[{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}]");
		System.out.println(sb.toString());
		return sb.toString();

	}
	
	// 下一条 
	public int[] getNext(String time1,String time2, Byte bb) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time1+" 23:59:59";       //起始日
		Calendar endCal = Calendar.getInstance();   //数据库最大日期
		endCal.setTime(jndebDAO.findMaxTimeErba());
		Date date = df.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		int[][] results = new int[28][1];
		List<Byte> ids = new ArrayList<Byte>();
		List<Jndeb> list = jndebDAO.findAllResultScope(time1,time2);
		float countGailv = 0;
		float countshiji = 0;
		if (list.size() != 0) {
			//System.out.println(list.size());
			for (int k = 0; k < list.size(); k++) {
				Byte a = list.get(k).getResult();
				if( a == bb ) {
					if( k != list.size()-1 ) {
						ids.add(list.get(k+1).getResult()); 
					}
				}
			}
			int size = ids.size ();
			for (Byte b1 : ids) {
					int j = Integer.valueOf(b1);
					results[j][0]++;
			}
		    List<Integer> idresult = new ArrayList<Integer>(); 
			for (int j = 0; j < 28; j++) {
				float f1 = (float)results[j][0]/size;
				float jun = (float) (Math.round(f1*10000))/100;
				float gl = Float.valueOf(gailv[j]);
				String dayu = "";
				if ( jun > gl ) {
					dayu = "大于 ";
					idresult.add(j);
					countGailv += gl;
					countshiji += jun;
				}
				//System.out.println(j+": "+results[j][0] +"  "+jun+"  标准 "+gailv[j]+"  "+dayu);
			}
			//System.out.print(bb+":  ");
			int[] result_array = new int[idresult.size()];
			for (int i = 0; i < idresult.size(); i++) {
				//System.out.print(idresult.get(i));
				result_array[i]  =  idresult.get(i);
				if( i != idresult.size() -1 ) {
					//System.out.print(",");
					
				}
			}
			
			return result_array;
		}
			return null;

	}
	
	// 当日第一期
	public String getOneDay(String time) throws ParseException {

		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		Byte a = 0;
		Byte a_ = 0;
		String d;
		int da = 0;
		int xiao = 0;
		int cha = 0;
		Map<String,String> map = new TreeMap<String,String>();
		
		if (list.size() != 0) {
			
			
			for (int k = 0; k < list.size(); k++) {
				 a = list.get(k).getResult();
				 d = list.get(k).getTime().toString();
				
				 
				 if( d.contains("09:00:00.0") ) { 
					 a_ = a;
				 }
				 if( a > 13 ) {
					 da++;
				 } else {
					 xiao++;
				 }
				 if ( d.contains("01:00:00.0")) {
				
					cha = da - xiao;
					String ss = a_+","+cha;
					map.put(d,ss);
					da = 0;
					xiao = 0;
					cha = 0;
					a_ = 0;
				 }
			}
//			for( Entry<String, String> e : map.entrySet())   { 
//				   System.out.print(e.getKey()+":   ");
//				   String value = e.getValue();
//				   System.out.print(value);
//				   System.out.println("");
//		    }
		
			for( Iterator<Entry<String, String>> i = map.entrySet().iterator();i.hasNext(); ) { 
					Entry<String, String> e = i.next();
					System.out.print(e.getKey().substring(0,10)+"  ");
					System.out.println(e.getValue());
			}
		}
	
		return null;
	}
	
	
	public int jianyan(String time)  {
		
		List<Jndeb> list = jndebDAO.findAllResultScope("2012-01-01","2013-08-01");
		Byte a = 0;
		int size = list.size();
		int[] shuzi = new int[28];
		int mz = 0;
		for (int i = 0; i < list.size(); i++) {
			a = list.get(i).getResult();
			for (int j = 0  ; j< 28 ; j++) {
				if( a ==  j ) {
					shuzi[j]++;
				}
			}
		}
		
		System.out.println("共"+size);
//		System.out.println("命中:"+mz);
//		int no = size -mz ;
//		System.out.println("获得:"+mz*549);
//		System.out.println("花费:"+no*451);
//		System.out.println((mz*549*0.98)-(no*451) );
		System.out.print("号码:");
		for (int j = 0  ; j < 28 ; j++) {
			System.out.print(j+"   ");
		}
		System.out.println("");
		System.out.print("实际:");
		for (int j = 0  ; j < 28 ; j++) {
			System.out.print(shuzi[j]+" ");
		}
		System.out.println("");
		System.out.print("标准:");
		for (int i = 0; i < 28; i++) {
			float f = Float.valueOf(gailv[i]);
			int jun = (int) (Math.round(f*size/100));
			System.out.print(jun+" ");
		}
	
		return 0;
	}
	
	public int jianyan2(String time)  {
		
		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		Byte a = 0;
		int size = list.size();
		int mz = 0;
		for (int i = 0; i < list.size(); i++) {
			a = list.get(i).getResult();
			
				if(  (a > 14 && a != 27 ) || a == 12 ) {
					mz++;
				}
		}
		
		System.out.println("共:"+size);
		System.out.println("命中:"+mz);
		System.out.println("不中:"+(size-mz));
		int no = size -mz ;
		System.out.println("获得:"+mz*503);
		System.out.println("花费:"+no*497);
		System.out.println((mz*503)-(no*497) );
	
	
		return 0;
	}
	
	

	public void getbulou(String time1 ,String time2) {

		int[] a = new int[28];
		String[] biaozhun = {"0.1%","0.3%","0.6%","1%","1.5%","2.1%","2.8%","3.6%","4.5%","5.5%","6.3%","6.9%","7.3%","7.5%","7.5%","7.3%","6.9%","6.3%","5.5%","4.5%","3.6%","2.8%","2.1%","1.5%","1%","0.6%","0.3%","0.1%"};
		List<String[]> list = jndebDAO.findAllResultFromTo(time1, time2);
		int total = list.size();
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);

		for (String[] strings : list) {

			int b = Integer.valueOf(strings[1]);
			a[b]++;
		}
		System.out.println("共" + list.size() + "条记录");
		for (int i = 0; i < a.length; i++) {

			String probability = numberFormat.format((float) a[i]
					/ (float) total * 100);
			System.out.println(i + ":出现" + a[i] + "次,概率为:" + probability + "%"+"; 标准为:"+biaozhun[i]);

		}

	}
	
	public void getbulouLast(String time) {

		int[] a = new int[28];
		String[] biaozhun = {"0.1%","0.3%","0.6%","1%","1.5%","2.1%","2.8%","3.6%","4.5%","5.5%","6.3%","6.9%","7.3%","7.5%","7.5%","7.3%","6.9%","6.3%","5.5%","4.5%","3.6%","2.8%","2.1%","1.5%","1%","0.6%","0.3%","0.1%"};
		List<String[]> list = jndebDAO.findAllResultLast(time);
		int total = list.size();
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);

		for (String[] strings : list) {

			int b = Integer.valueOf(strings[1]);
			a[b]++;
		}
		System.out.println("共" + list.size() + "条记录");
		for (int i = 0; i < a.length; i++) {

			String probability = numberFormat.format((float) a[i]
					/ (float) total * 100);
			System.out.println(i + ":出现" + a[i] + "次,概率为:" + probability + "%"+"; 标准为:"+biaozhun[i]);

		}

	}
	
	
	public  String  hourResult(String time, int t) {
		
		List<String[]> list;
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
			if( t ==1 ){
				list = jndebDAO.hourZhongResult(time);
			} if( t == 2 ){
				list = jndebDAO.hourDaResult(time);
			} else {
				list = jndebDAO.hourdanResult(time);
			}
			System.out.println("list~~~~~~~~~~~~~~~~~~~~~~~~~~"+list.size());
			int count = list.size();
			if (count != 0) {
				for (int i = 0; i < list.size(); i++) {
					count--;
					String dataString = list.get(i)[0];
					int da = Integer.valueOf(list.get(i)[1]);
					int xiao = Integer.valueOf(list.get(i)[2]);
					System.out.println(dataString+"~~~~~~"+da+"~~~~~~~"+xiao);
					if ( xiao == 0) {
						xiao = 1 ;
					}
					float pj = (float) da/xiao ;
					float rijun = (float) (Math.round(pj*100))/100;
					sbDate.append("\"");
					sbDate.append(dataString);
					sbDate.append("\"");
					sbTotal.append(rijun);
					if ( count > 0 ) {
						System.out.println("count~~~~~~~~~~~~~~~~"+count);
						sbDate.append(",");
						sbTotal.append(",");
					}
				}
			} 
			System.out.println("次数为"+list.size());
			sb.append("[{");
			sb.append("\"dates\":[");
			sb.append(sbDate.toString());
			sb.append("]");
			sb.append(",\"total\":[");
			sb.append(sbTotal.toString());
			sb.append("]}]");
			System.out.println(sb.toString());
			return sb.toString();
		
		
	}
		
		
	
	public int tianshu(String time){
		
		int t = 0;
		try {
			JndebDAO jndebDAO = new JndebDAO();
			String sString= time;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(sString);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date);
			//int t1 = cal1.get(Calendar.DAY_OF_YEAR);  //所选日期在一年内的位置
			Calendar cal2 = Calendar.getInstance();   //数据库最大日期
			cal2.setTime(jndebDAO.findMaxTimeErba());
			//int t2 = cal2.get(Calendar.DAY_OF_YEAR);  //数据库最大日期在一年内的位置
			long s1 = cal1.getTimeInMillis(); 
			long s2 = cal2.getTimeInMillis(); 
			long t1 = s2-s1;
			return (int)(t1/(1000*60*60*24)+1); 

		} catch (ParseException e) {
			e.printStackTrace();
			return t;
		}
		
	}
	
	//走势图
		public String trend(int page,int rows) {
			
			List<Jndeb> list = jndebDAO.trend(page, rows);
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if( list.size() > 0 ) {
				for (Jndeb jnd : list) {
					sb.append("{\"issue\":");
					sb.append(jnd.getIssue());
					sb.append(",\"time\":\"");
					sb.append(sdf.format(jnd.getTime()));
					sb.append("\",\"result\":\"");
					sb.append(jnd.getR1()+",");
					sb.append(jnd.getR2()+",");
					sb.append(jnd.getR3()+",");
					sb.append(jnd.getResult());
					sb.append("\"}");
					sb.append(",");
				}	
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append("]");
			return (sb.toString());
			
	}
		
		//统计
		public String stats(int length) {
			
			List<Jndeb> list = jndebDAO.findAllByLength(length);
			StringBuilder sb = new StringBuilder();
			int sum = 0;
			sb.append("[");
			int da = 0;  int xiao = 0;
			int dan = 0 ; int shuang = 0 ; 
			int zhong = 0; int bian =0 ;
		
			if( list.size() > 0 ) {
				for (Jndeb kuaileEB : list) {
					sum = kuaileEB.getResult();
						//大小
		        		if( sum > 13 ){
		        			da++;
		        		}  else {
		        			xiao++;
		        		}
		        		
		        		if( sum%2 == 1 ){
		        			dan++;
		        		} else {
		        			shuang++;
		        		}
		        		
		        		if( sum > 9 && sum < 18){
		        			zhong++;
		        		} else {
		        			bian++;
		        		}
		        		
		        	
				 }
				
						sb.append("{\"da\":\"");
						sb.append(da);
						sb.append("\",\"xiao\":\"");
						sb.append(xiao);
						
						sb.append("\",\"dan\":\"");
						sb.append(dan);
						sb.append("\",\"shuang\":\"");
						sb.append(shuang);
					
						sb.append("\",\"zhong\":\"");
						sb.append(zhong);
						sb.append("\",\"bian\":\"");
						sb.append(bian);
						
						sb.append("\"}");
				}
				sb.append("]");
				
				return sb.toString();
		}
	
	//五期结果
	public void getWuQI_Jndeb(String time) throws ParseException {
		
		JndebDAO jndebDAO = new JndebDAO();
		List<Jndeb> list = jndebDAO.findResultLast(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		int flat = 0;
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		int w1 = 0;	int w2 = 0;	int w3 = 0;	int w4 = 0;	int w5 = 0;
		Jndeb last1 = null;
		Jndeb last2 = null;
		Jndeb last3 = null;
		Jndeb last4 = null;
		Jndeb last5 = null;
		Jndeb kleb = null;
		
		for (int k = 0; k < list.size(); k++) {
			flat++;
			if( k == 0 ) {
				last1 = list.get(k);
				continue;
			} else if( k == 1 ) {
				last2 = list.get(k);
				continue;
			} else if ( k == 2) {
				last3 = list.get(k);
				continue;
			} else if ( k == 3) {
				last4 = list.get(k);
				continue;
			} else if ( k == 4) {
				last5 = list.get(k);
				continue;
			}   else if( k > 4) {
				List<Integer> weiList = new ArrayList<Integer>();
				kleb =  list.get(k);
				w1 = last1.getResult()%10;
				w2 = last2.getResult()%10;
				w3 = last3.getResult()%10;
				w4 = last4.getResult()%10;
				w5 = last5.getResult()%10;
				weiList.add(w1);
				weiList.add(w2);
				weiList.add(w3);
				weiList.add(w4);
				weiList.add(w5);
				System.out.print(kleb.getIssue()+"  "+w1+"  "+w2+"  "+w3+"  "+w4+"  "+w5);
				set.addAll(weiList);
				int t = kleb.getResult()%10;
				if( weiList.contains(t) ) {
					zq_++;
					int size = set.size()*100;
					int t11 = 1000-size;
					System.out.print(" "+t+"  set: "+set.size()+"  y "+t11);
					yin_z +=t11;
					yin_t +=t11;
				} else {
					yin_z +=-1*set.size()*100;
					yin_t +=-1*set.size()*100;
					System.out.print("              "+set.size()*100*-1);
				}
				System.out.println("");
				set.clear();
				
				Timestamp today = kleb.getTime();
				
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			}
			last1 = last2;
			last2 = last3;
			last3 = last4;
			last4 = last5;
			last5 = kleb;
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
		System.out.println("总盈利:"+yin_z);
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
			
	}
	
	
	//十期结果
	public void getShiqi_Jndeb(String time) throws ParseException {
		
		JndebDAO jndebDAO = new JndebDAO();
		List<Jndeb> list = jndebDAO.findResultLast(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		int flat = 0;
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		int w1 = 0;	int w2 = 0;	int w3 = 0;	int w4 = 0;	int w5 = 0;
		int w6 = 0;	int w7 = 0;	int w8 = 0;	int w9 = 0;	int w10 = 0;
		Jndeb last1 = null;
		Jndeb last2 = null;
		Jndeb last3 = null;
		Jndeb last4 = null;
		Jndeb last5 = null;
		Jndeb last6 = null;
		Jndeb last7 = null;
		Jndeb last8 = null;
		Jndeb last9 = null;
		Jndeb last10 = null;
		Jndeb kleb = null;
		
		for (int k = 0; k < list.size(); k++) {
			flat++;
			if( k == 0 ) {
				last1 = list.get(k);
				continue;
			} else if( k == 1 ) {
				last2 = list.get(k);
				continue;
			} else if ( k == 2) {
				last3 = list.get(k);
				continue;
			} else if ( k == 3) {
				last4 = list.get(k);
				continue;
			} else if ( k == 4) {
				last5 = list.get(k);
				continue;
			} else if ( k == 5) {
				last6 = list.get(k);
				continue;
			} else if ( k == 6) {
				last7 = list.get(k);
				continue;
			} else if ( k == 7) {
				last8 = list.get(k);
				continue;
			} else if ( k == 8) {
				last9 = list.get(k);
				continue;
			} else if ( k == 9) {
				last10 = list.get(k);
				continue;
			} else if( k > 4) {
				List<Integer> weiList = new ArrayList<Integer>();
				kleb =  list.get(k);
				w1 = last1.getResult()%10;
				w2 = last2.getResult()%10;
				w3 = last3.getResult()%10;
				w4 = last4.getResult()%10;
				w5 = last5.getResult()%10;
				w6 = last6.getResult()%10;
				w7 = last7.getResult()%10;
				w8 = last8.getResult()%10;
				w9 = last9.getResult()%10;
				w10 = last10.getResult()%10;
				weiList.add(w1);
				weiList.add(w2);
				weiList.add(w3);
				weiList.add(w4);
				weiList.add(w5);
				weiList.add(w6);
				weiList.add(w7);
				weiList.add(w8);
				weiList.add(w9);
				weiList.add(w10);
				System.out.print(kleb.getIssue()+"  "+w1+"  "+w2+"  "+w3+"  "+w4+"  "+w5+"  "+w6+"  "+w7+"  "+w8+"  "+w9+"  "+w10);
				set.addAll(weiList);
				int t = kleb.getResult()%10;
				if( weiList.contains(t) ) {
					zq_++;
					int size = set.size()*100;
					int t11 = 1000-size;
					System.out.print(" "+t+"  set: "+set.size()+"  y "+t11);
					yin_z +=t11;
					yin_t +=t11;
				} else {
					yin_z +=-1*set.size()*100;
					yin_t +=-1*set.size()*100;
					System.out.print("              "+set.size()*100*-1);
				}
				System.out.println("");
				set.clear();
				
				Timestamp today = kleb.getTime();
				
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			}
			last1 = last2;
			last2 = last3;
			last3 = last4;
			last4 = last5;
			last5 = last6;
			last6 = last7;
			last7 = last8;
			last8 = last9;
			last9 = last10;
			last10 = kleb;
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
		System.out.println("总盈利:"+yin_z);
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
			
	}
	
	
	//五期结果
	public void getWuQI_eb(String time) throws ParseException {
		
		List<Jndeb> list = jndebDAO.findResultLast(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		int flat = 0;
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		int w1 = 0;	int w2 = 0;	int w3 = 0;	int w4 = 0;	int w5 = 0;
		Jndeb last1 = null;
		Jndeb last2 = null;
		Jndeb last3 = null;
		Jndeb last4 = null;
		Jndeb last5 = null;
		Jndeb kleb = null;
		
		for (int k = 0; k < list.size(); k++) {
			flat++;
			if( k == 0 ) {
				last1 = list.get(k);
				continue;
			} else if( k == 1 ) {
				last2 = list.get(k);
				continue;
			} else if ( k == 2) {
				last3 = list.get(k);
				continue;
			} else if ( k == 3) {
				last4 = list.get(k);
				continue;
			} else if ( k == 4) {
				last5 = list.get(k);
				continue;
			}   else if( k > 4) {
				List<Integer> weiList = new ArrayList<Integer>();
				kleb =  list.get(k);
				w1 = last1.getResult()%10;
				w2 = last2.getResult()%10;
				w3 = last3.getResult()%10;
				w4 = last4.getResult()%10;
				w5 = last5.getResult()%10;
				weiList.add(w1);
				weiList.add(w2);
				weiList.add(w3);
				weiList.add(w4);
				weiList.add(w5);
				System.out.print(kleb.getIssue()+"  "+w1+"  "+w2+"  "+w3+"  "+w4+"  "+w5);
				set.addAll(weiList);
				int t = kleb.getResult()%10;
				if( weiList.contains(t) ) {
					zq_++;
					int size = set.size()*100;
					int t11 = 1000-size;
					System.out.print(" "+t+"  set: "+set.size()+"  y "+t11);
					yin_z +=t11;
					yin_t +=t11;
				} else {
					yin_z +=-1*set.size()*100;
					yin_t +=-1*set.size()*100;
					System.out.print("              "+set.size()*100*-1);
				}
				System.out.println("");
				set.clear();
				
				Timestamp today = kleb.getTime();
				
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			}
			last1 = last2;
			last2 = last3;
			last3 = last4;
			last4 = last5;
			last5 = kleb;
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
		System.out.println("总盈利:"+yin_z);
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
			
			
	}
	
	
	//三期结果-尾-快乐
	public void getWuQI_Kleb_wei(String time) throws ParseException {
		
		
		List<Jndeb> list = jndebDAO.findResultLast(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		int flat = 0;
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		int w1 = 0;	int w2 = 0;	int w3 = 0;	
		Jndeb last1 = null;
		Jndeb last2 = null;
		Jndeb last3 = null;
		Jndeb kleb = null;
		
		for (int k = 0; k < list.size(); k++) {
			flat++;
			if( k == 0 ) {
				last1 = list.get(k);
				continue;
			} else if( k == 1 ) {
				last2 = list.get(k);
				continue;
			} else if ( k == 2) {
				last3 = list.get(k);
				continue;
			}   else if( k > 2) {
				kleb =  list.get(k);
				w1 = last1.getR2();
				w2 = last2.getR2();
				w3 = last3.getR2();
				int a = (w1+w2+w3)%10;
				int t = kleb.getResult()%10;
				System.out.print(kleb.getIssue()+"   ");
				if(  (t < 5 && a < 5 )   ||  ( t > 4 && a > 4  ) ) {
					zq_++;
					yin_z += 500;
					yin_t += 500;
					System.out.print("500");
				} else {
					yin_z += -1*500;
					yin_t += -1*500;
					System.out.print("-500");
				}
				System.out.println("");
				set.clear();
				
				Timestamp today = kleb.getTime();
				
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			}
			last1 = last2;
			last2 = last3;
			last3 = kleb;
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
		System.out.println("总盈利:"+yin_z);
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
			
	}
	
	//四期单双
	public void getSiqi_ds(String time) throws ParseException {
		
		List<Jndeb> list = jndebDAO.findResultLast(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		int flat = 0;
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		
		int step1 = 0;
		int step2 = 0;
		int temp = 0;
		
		Set<Integer> set = new HashSet<Integer>();
	
		Jndeb last1 = null;
		Jndeb last2 = null;
		Jndeb last3 = null;
		Jndeb last4 = null;
	
		Jndeb kleb = null;
		
		for (int k = 0; k < list.size(); k++) {
			flat++;
			if( k == 0 ) {
				last1 = list.get(k);
				continue;
			} else if( k == 1 ) {
				last2 = list.get(k);
				continue;
			} else if ( k == 2) {
				last3 = list.get(k);
				continue;
			} else if ( k == 3) {
				last4 = list.get(k);
				continue;
			}   else if( k > 3) {
				kleb =  list.get(k);
				step1  = last1.getR1()+last1.getR3()+last2.getR2();
				step2 = last3.getR1()+last3.getR3()+last4.getR2();
				System.out.print(kleb.getIssue()+"  "+(step2-step1));
				//temp = step2 +step1;
				temp = (step2 -step1)%2;
				if( ( temp == 0 ) && ( kleb.getResult()%2 == 0 ) || ( temp != 0 ) && ( kleb.getResult()%2 != 0 ) ) {
				//if( ( temp > 27 &&  kleb.getResult() > 13 ) || ( temp < 28 &&  kleb.getResult() < 14)  ) {
					zq_++;
					System.out.print(" "+500);
					yin_z += 500;
					yin_t += 500;
				} else {
					yin_z += -500;
					yin_t += -500;
					System.out.print(" -500");
				}
				System.out.println("");
				set.clear();
				
				Timestamp today = kleb.getTime();
				
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			}
			last1 = last2;
			last2 = last3;
			last3 = last4;
			last4 = kleb;
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
		System.out.println("总盈利:"+yin_z);
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
			
		
	
			
	}
	
	
	//四期大小
	public void getSiqi_dx(String time) throws ParseException {
		
		List<Jndeb> list = jndebDAO.findResultLast(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		int flat = 0;
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		
		int step1 = 0;
		int step2 = 0;
		int temp = 0;
		
		Set<Integer> set = new HashSet<Integer>();
	
		Jndeb last1 = null;
		Jndeb last2 = null;
		Jndeb last3 = null;
		Jndeb last4 = null;
	
		Jndeb kleb = null;
		
		for (int k = 0; k < list.size(); k++) {
			flat++;
			if( k == 0 ) {
				last1 = list.get(k);
				continue;
			} else if( k == 1 ) {
				last2 = list.get(k);
				continue;
			} else if ( k == 2) {
				last3 = list.get(k);
				continue;
			} else if ( k == 3) {
				last4 = list.get(k);
				continue;
			}   else if( k > 3) {
				kleb =  list.get(k);
				step1  = last1.getR1()+last1.getR3()+last2.getR2();
				step2 = last3.getR1()+last3.getR3()+last4.getR2();
				System.out.print(kleb.getIssue()+"  "+(step2-step1));
				//temp = step2 +step1;
				temp = (step2 + step1);
				//if( ( temp > 27 &&  kleb.getResult() > 13  ) ||  ( temp < 28  && kleb.getResult() < 14 ) ) {
				if( (  (temp > 19 && temp < 37 ) &&  (kleb.getResult() > 9 && kleb.getResult() < 18 )  )  ) {
					zq_++;
					System.out.print(" "+440);
					yin_z += 440;
					yin_t += 440;
				} else if(  (temp <  20 || temp > 36 ) &&  (kleb.getResult() < 10 || kleb.getResult() > 17 ) ) {
					System.out.print(" "+560);
					yin_z += 560;
					yin_t += 560;
					
				}	else if ( (temp > 19 && temp < 37 ) ){
					yin_z += -560;
					yin_t += -560;
					System.out.print(" -560");
				}	else if ( (temp <  20 || temp > 36 ) ){
					yin_z += -440;
					yin_t += -440;
					System.out.print(" -440");
				}
				System.out.println("");
				set.clear();
				
				Timestamp today = kleb.getTime();
				
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			}
			last1 = last2;
			last2 = last3;
			last3 = last4;
			last4 = kleb;
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
		System.out.println("总盈利:"+yin_z);
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
			
		
	
			
	}
	
	
	public List<Integer> getPeilv(long issue) {
		
		List<Jndeb> list = jndebDAO.findResultFromByIssue(issue);
		List<Integer> tou = new ArrayList<Integer>();
		int[] sj = new int[28];
		float[] fl = new float[28];
		for (Jndeb eeeb : list) {
			int a = Integer.valueOf(eeeb.getResult());
			sj[a]++;
		}
		for (int i = 0; i < sj.length; i++) {
			float c = (float)sj[i]/50;
			fl[i] = c;
			
		}
	
		for (int i = 0; i < fl.length; i++) {
			
			if(biaogl[i] <= fl[i]) {
				tou.add(i);
			}

		}
		int sum = 0;
		
		for (int a: tou) {
			sum+= Integer.valueOf(biaotou[a]);
			System.out.print(a+" ");
		}
		
		System.out.println("共:  "+sum);
		return tou;
	}
	
	
	public void yan_getPeilv(String time,int g1, int g2) throws ParseException {
		
		  String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		  SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Date date = df1.parse(timeString);
		  Calendar dayCal = Calendar.getInstance();
		  dayCal.setTime(date);
		  Date dayDate = dayCal.getTime();
		  Long issue = jndebDAO.findIssueByTime(time);	
		  System.out.println(issue);
		  List<Jndeb> list = jndebDAO.findResultFrom(issue);
		  Map<String,Integer> map = new HashMap<String,Integer>();
		  System.out.println(list.size());
		  List<Integer> tou = getPeilv(issue-100);
		  int yingli = 0;
		  int sum = 0;
		  int yin_t =0;
		   
		  for (int i = 0; i < list.size(); i++) {
			  
			  
			  //参数投注
			  if( i%8 == 0  ) {
				  tou.clear(); 
					 sum = 0;
					 List<Jndeb> list2  = jndebDAO.findResultFromToByIssue(list.get(i).getIssue()-g1,list.get(i).getIssue());
					 int[] sj = new int[28];
					 float[] fl = new float[28];
					 for (Jndeb eeeb : list2) {
							int a = Integer.valueOf(eeeb.getResult());
							sj[a]++;
					 }
					 for (int j = 0;j < sj.length; j++) {
							float c = (float)sj[j]/g2;
							fl[j] = c;
							
					 }
					 for (int k = 0; k < fl.length; k++) {
							if(biaogl[k] <= fl[k]) {
								tou.add(k);
							}

					  }
					  System.out.print(list.get(i).getTime()+"  ");
					  for (Integer integer : tou) {
						  System.out.print(integer+" ");
						  sum+= Integer.valueOf(biaotou[integer]);
					}
					System.out.println("投："+sum);  
					 System.out.println(yingli);
				
			  }
			  
			  //判断有无
			  int a = list.get(i).getResult();
			  int flat = 0;
			  for ( int b : tou) {
				   if( a == b) {
					   flat = 1;
					   break;
				   }
			   }
			   
			
			  
			   //盈利
			   if( flat == 0 ){
				   yingli -= sum;
				   yin_t -= sum;
			   } else {
				   yingli += (1000-sum);
				   yin_t += (1000-sum);
			   }
			 
			   //按天统计
				  Timestamp today = list.get(i).getTime();
				  int ct = today.compareTo(dayDate);
				  if( ct > 0 ) {		
						map.put(df.format(dayDate),yin_t);
						yin_t = 0;
						dayCal.add(Calendar.DATE, 1);
						dayDate = dayCal.getTime();
				   } else if( i == list.size()-1 ){
						map.put(df.format(today),yin_t);
				   }
			   
			}

		    System.out.println("总:"+yingli);
		    
		  //升序排序
			List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
	        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
	            public int compare(Entry<String, Integer> o1,
	                    Entry<String, Integer> o2) {
	                return o1.getKey().compareTo(o2.getKey());
	            }
	        });
	        for(Entry<String,Integer> mapping:list1){
	               System.out.println(mapping.getKey()+": "+mapping.getValue());
	          } 
			     
		
		}
	
	
	//三期单双
	public void getSanqi_ds(String time) throws ParseException {
		
		List<Jndeb> list = jndebDAO.findResultLast(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		int flat = 0;
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		
		int step1 = 0;
		int step2 = 0;
		int temp = 0;
		
		Set<Integer> set = new HashSet<Integer>();
	
		Jndeb last1 = null;
		Jndeb last2 = null;
		Jndeb last3 = null;
	
	
		Jndeb kleb = null;
		
		for (int k = 0; k < list.size(); k++) {
			flat++;
			if( k == 0 ) {
				last1 = list.get(k);
				continue;
			} else if( k == 1 ) {
				last2 = list.get(k);
				continue;
			} else if ( k == 2) {
				last3 = list.get(k);
				continue;

			}   else if( k > 2) {
				kleb =  list.get(k);
				step1  = last1.getR1()+last2.getR2()+last2.getR2();
				step2 = last3.getR3()+last2.getR1();
				System.out.print(kleb.getIssue()+"  "+(step2-step1));
				//temp = step2 +step1;
				temp = (step2+step1-last2.getR2())%2;
				if( ( temp == 0 ) && ( kleb.getResult()%2 == 0 ) || ( temp != 0 ) && ( kleb.getResult()%2 != 0 ) ) {
				//if( ( temp > 27 &&  kleb.getResult() > 13 ) || ( temp < 28 &&  kleb.getResult() < 14)  ) {
					zq_++;
					//System.out.print(" "+500);
					yin_z += 500;
					yin_t += 500;
				} else {
					yin_z += -500;
					yin_t += -500;
					//System.out.print(" -500");
				}
				//System.out.println("");
				set.clear();
				
				Timestamp today = kleb.getTime();
				
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			}
			last1 = last2;
			last2 = last3;
			last3 = kleb;
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
			
        System.out.println("总盈利:"+yin_z);
		
	
			
	}
	
	//去尾-幸运28
	public void quwei_xyeb(String time) throws ParseException {
		
		
		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		Jndeb kleb = null;
		
		
		for (int k = 0; k < list.size(); k++) {
			
				kleb =  list.get(k);
				int t = kleb.getResult()%10;
				int flat = 0;
				if( t == 2 || t == 3 || t == 7 ||  t == 9) {
				//if( t == 1 || t == 2 || t == 4 ||  t == 7) {
					flat = 1;
				} else {
					flat = 0;
				}
				System.out.print(kleb.getTime()+" ");
				if( flat == 1 ) {
					zq_++;
					yin_z += 600;
					yin_t += 600;
					System.out.print("600");
				} else {
					yin_z += -1*400;
					yin_t += -1*400;
					System.out.print("-400");
				}
				System.out.println(" "+yin_z);
			
				Timestamp today = kleb.getTime();
				
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
	
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
    	System.out.println("总盈利:"+yin_z);
	}
	
	//轨迹尾-PK10
	public void guiji_wei(String time) throws ParseException {
		
		
		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
	
		
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		Jndeb kleb = list.get(0);
		Jndeb thisPk10 = null;
		int[] weiList = new int[6];
		int[] guiji = {0,47,158,269,370,481,592,603,714,825,936};

		for (int k = 1; k < list.size(); k++) {
				thisPk10 = list.get(k);
				int jieguo = kleb.getResult()%10;
				System.out.print(thisPk10.getIssue()+" "+thisPk10.getTime()+" 尾巴:"+jieguo+" 开:"+thisPk10.getResult());
				int weizhi = 1;
				for (int i = 1; i < guiji.length; i++) {
					if( guiji[i]%10 == jieguo ) {
						weizhi = i;
					}
				}
				System.out.print(" 位置:"+weizhi+" ");
				int a1 = 0 , a2 = 0;
				if( weizhi == 10 ) {
					a1 = 47;
					a2 = guiji[9];
				} else if ( weizhi == 1) {
					a1 = guiji[2];
					a2 = guiji[10];
				} else {
					a1 = guiji[weizhi+1];
					a2 = guiji[weizhi-1];
				}
			    System.out.print(" "+a1+" "+a2+" ");    
				weiList[0] = a1%10;
				weiList[1] = a1/10%10;
				weiList[2] = a1/100;
				
				weiList[3] = a2%10;
				weiList[4] = a2/10%10;
				weiList[5] = a2/100;
			  
				int flat = 0;
				System.out.print(" 集合: ");
			    for (int i : weiList) {
					System.out.print(i+" ");
					if( thisPk10.getResult()%10 == (byte)i ) {
						flat = 1;
					}
				}
				
				int sumzhu = 0;
				for (int i = 0; i < weiList.length; i++) {
					for (int j = 0; j < 28; j++) {
						  if( j%10 == weiList[i]) {	
							  sumzhu+= Integer.valueOf(biaotou[j]);
						  }
					}
				}
				//int touzhue = 1000-sumzhu;
				int touzhue = sumzhu;
				if( flat == 1 ) {
					zq_++;
					
					yin_z += 1000-touzhue;
					yin_t += 1000-touzhue;
					System.out.print(" "+(1000-touzhue));
				} else {
					yin_z -= touzhue;
					yin_t -= touzhue;
					System.out.print("-"+touzhue);
					
				}
				System.out.println(" "+yin_z);
			
				Timestamp today = kleb.getTime();
				kleb = thisPk10;
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
				
			
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
	
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
    	System.out.println("总盈利:"+yin_z);
	}
	
	//八进制
	public void bajinzhi(String time) throws ParseException {
		
		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		Map<String,Integer> map = new HashMap<String,Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
		Date date = df1.parse(timeString);
		Calendar dayCal = Calendar.getInstance();
		dayCal.setTime(date);
		Date dayDate = dayCal.getTime();
		
		int zq_ = 0;
		int yin_z = 0;
		int yin_t = 0;
		Jndeb thisPk10 = null;
		Jndeb lastBjPK10 = list.get(0);
		int last = 0;
		Set<Integer> ids = new HashSet<Integer>();
	
		for (int k = 1; k < list.size(); k++) {
				
				ids.clear();
				thisPk10 = list.get(k);
				int flat = 1;
				System.out.print(thisPk10.getTime()+" 上期");
				int shi = lastBjPK10.getR1()%10*100+lastBjPK10.getR2()%10*10+lastBjPK10.getR3()%10;
				System.out.print(shi+" ");
				String ba = Integer.toOctalString(shi);
				System.out.print("转八进制  "+ba+"");
				if( ba.length() > 3) {
					ids.add(Integer.valueOf(ba.substring(0,1)));
					ids.add(Integer.valueOf(ba.substring(1,2)));
					//ids.add(Integer.valueOf(ba.substring(2,3)));
					//ids.add(Integer.valueOf(ba.substring(3,4)));
					int jia = Integer.valueOf(ba.substring(2,3))+Integer.valueOf(ba.substring(3));
					if ( jia == 10 ) {
						jia = 0;
					}
					//ids.add(jia);
				} else if ( ba.length() == 3 ) {
					ids.add(Integer.valueOf(ba.substring(0,1)));
					ids.add(Integer.valueOf(ba.substring(1,2)));
					ids.add(Integer.valueOf(ba.substring(2)));
				} else if ( ba.length() == 2 ){
					ids.add(Integer.valueOf(ba.substring(0,1)));
					ids.add(Integer.valueOf(ba.substring(1)));
				} else {
					ids.add(Integer.valueOf(ba));
				}
				System.out.print("  集合:");
				for (Integer integer : ids) {
					System.out.print(integer+" ");
				}
				
				if( ids.size() == 0 ) {
					continue;	
				}
				
				int r = thisPk10.getResult()%10;
				int sum = 0;
				
				for (Integer integer : ids) {
					  if ( integer < 8) {
						  sum+= Integer.valueOf(biaotou[integer]);
						  sum+= Integer.valueOf(biaotou[integer+10]);
						  sum+= Integer.valueOf(biaotou[integer+20]);
					  } else {
						  sum+= Integer.valueOf(biaotou[integer]);
						  sum+= Integer.valueOf(biaotou[integer+10]);
					  }
				}
				
				for (Integer integer : ids) {
					int i = integer%10;
					if( i == r ) {
					  flat = 0;
					  break;
					}
				}
				if( flat == 1 ) {
					zq_++;
					yin_z +=  sum;
					yin_t +=  sum;
					System.out.print(" "+sum);
				} else {
					yin_z -= 1000-sum;
					yin_t -= 1000-sum;
					System.out.print(" -"+(1000-sum));
				}
				System.out.println(" ");
				Timestamp today = thisPk10.getTime();
				lastBjPK10 = thisPk10;
				int ct = today.compareTo(dayDate);
				if( ct > 0 ) {		
					map.put(df.format(dayDate),yin_t);
					yin_t = 0;
					dayCal.add(Calendar.DATE, 1);
					dayDate = dayCal.getTime();
				} else if( k == list.size()-1 ){
					map.put(df.format(today),yin_t);
				}
		}
		System.out.println("共" + list.size() + "条记录");
	    float pj = (float) zq_/list.size() ;
	    float zql = (float) (Math.round(pj*100))/100;
		System.out.println("准确比例:"+zql);
	
		
		//升序排序
		List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Entry<String,Integer> mapping:list1){
               System.out.println(mapping.getKey()+": "+mapping.getValue());
          } 
    	System.out.println("总盈利:"+yin_z);
	}
	
	public void tongji_wei(String time) {

		int[] a = new int[28];
		String[] biaozhun = {"0.1%","0.3%","0.6%","1%","1.5%","2.1%","2.8%","3.6%","4.5%","5.5%","6.3%","6.9%","7.3%","7.5%","7.5%","7.3%","6.9%","6.3%","5.5%","4.5%","3.6%","2.8%","2.1%","1.5%","1%","0.6%","0.3%","0.1%"};
		int c[][] = new int[10][1];
		List<Jndeb> list = jndebDAO.findAllResultStart(time);
		
		for (Jndeb string : list) {
			int b= Integer.valueOf(string.getResult()%10);
			c[b][0]++;
		}
		for (int i = 0; i < c.length; i++) {
			System.out.println(i+":"+c[i][0]);
		}

	}

	//小时统计单双比情况
	public String diejiazbByhour(String time1) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH");
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
		List<Jndeb> list = jndebDAO.findAllResultLast1(time1);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int qi = 0;
		float z_jie = 0;
		float last_sum = 0;
		for (int k = 0; k < list.size(); k++) {
				
				Jndeb eeeb = list.get(k);
				Byte result = eeeb.getResult();
				qi++;
				if( result > 9 && result < 18 ) {
					z_jie++;
				} else {
					z_jie = z_jie - 1.272f;
				}
				if( k%5 == 0 ) {
					last_sum = z_jie;
					if (  (( result > 9 && result < 18 ) && z_jie > last_sum )  ||  ( ( result < 10 && result > 17 ) && z_jie < last_sum )    ) {
						continue;
					}
				}
				if ( ( z_jie > 4 ||  z_jie < -4 ) && qi > 49   || k == list.size()-1  ) {
					sbDate.append("\"");
					sbDate.append(sdf.format(eeeb.getTime()));
					sbDate.append("\"");
					sbTotal.append(decimalFormat.format(z_jie));
					sbDate.append(",");
					sbTotal.append(",");
					qi = 0;
					z_jie = 0;
					last_sum = 0;
				}
				
			}
	
		System.out.println("共" + list.size() + "条记录");
		sbDate.deleteCharAt(sbDate.length()-1);
		sbTotal.deleteCharAt(sbTotal.length()-1);
		sb.append("{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	//小时统计单双比情况
	public String diejiadsByhour(String time1) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH");
	
		List<Jndeb> list = jndebDAO.findAllResultLast1(time1);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int qi = 0;
		int z_jie = 0;
		int last_sum = 0;
		for (int k = 0; k < list.size(); k++) {
				
			Jndeb eeeb = list.get(k);
				Byte result = eeeb.getResult();
				qi++;
				if( result%2 != 0 ) {
					z_jie++;
				} else {
					z_jie--;
				}
				
				if( k%5 == 0 ) {
					last_sum = z_jie;
					if ( ( result%2 != 0 && z_jie > last_sum )  ||  (result%2==0 && z_jie < last_sum )    ) {
						continue;
					}
				
				}
				System.out.println(z_jie);
				if ( ( z_jie > 5 ||  z_jie < -5 ) && qi > 49  || k == list.size()-1  ) {
					sbDate.append("\"");
					sbDate.append(sdf.format(eeeb.getTime()));
					sbDate.append("\"");
					sbTotal.append(z_jie);
					sbDate.append(",");
					sbTotal.append(",");
					qi = 0;
					z_jie = 0;
					last_sum = 0;
				}
				
			}
	
		System.out.println("共" + list.size() + "条记录");
		sbDate.deleteCharAt(sbDate.length()-1);
		sbTotal.deleteCharAt(sbTotal.length()-1);
		sb.append("{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	//小时统计单双比情况
	public String diejiadxByhour(String time1) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH");
	
		List<Jndeb> list = jndebDAO.findAllResultLast1(time1);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbTotal = new StringBuilder();
		int qi = 0;
		int z_jie = 0;
		int last_sum = 0;
		for (int k = 0; k < list.size(); k++) {
				
			Jndeb eeeb = list.get(k);
				Byte result = eeeb.getResult();
				qi++;
				if( result > 13  ) {
					z_jie++;
				} else {
					z_jie--;
				}
				
				if( k%5 == 0 ) {
					last_sum = z_jie;
					if ( ( result > 13   && z_jie > last_sum )  ||  (result < 14 && z_jie < last_sum )    ) {
						continue;
					}
				
				}
				
				if ( ( z_jie > 5||  z_jie < -5 ) && qi > 49 || k == list.size()-1   ) {
					sbDate.append("\"");
					sbDate.append(sdf.format(eeeb.getTime()));
					sbDate.append("\"");
					sbTotal.append(z_jie);
					sbDate.append(",");
					sbTotal.append(",");
					qi = 0;
					z_jie = 0;
					last_sum = 0;
				}
				
			}
	
		System.out.println("共" + list.size() + "条记录");
		sbDate.deleteCharAt(sbDate.length()-1);
		sbTotal.deleteCharAt(sbTotal.length()-1);
		sb.append("{");
		sb.append("\"dates\":[");
		sb.append(sbDate.toString());
		sb.append("]");
		sb.append(",\"total\":[");
		sb.append(sbTotal.toString());
		sb.append("]}");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	//四期单双
	public void getsanqi_yu(String time) throws ParseException {
			
			List<Jndeb> list = jndebDAO.findResultLast(time);
			Map<String,Integer> map = new HashMap<String,Integer>();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeString = time.substring(0, 10)+" 23:59:59";        //输入的起始日
			Date date = df1.parse(timeString);
			Calendar dayCal = Calendar.getInstance();
			dayCal.setTime(date);
			Date dayDate = dayCal.getTime();
			Set<Integer> tou = new HashSet<Integer>();
			int zq_ = 0;
			int yin_z = 0;
			int yin_t = 0;
			
			int step1 = 0;
			
			Set<Integer> set = new HashSet<Integer>();
		
			Jndeb last1 = null;
			Jndeb last2 = null;
			Jndeb last3 = null;
			
		
			Jndeb kleb = null;
			
			for (int k = 0; k < list.size(); k++) {
				if( k == 0 ) {
					last1 = list.get(k);
					continue;
				} else if( k == 1 ) {
					last2 = list.get(k);
					continue;
				} else if ( k == 2) {
					last3 = list.get(k);
					continue;
				}  else if( k > 2) {
					kleb =  list.get(k);
					int g1 = last1.getResult()%10;
			        int g2 = last2.getResult()%10;
			        int g3 = last3.getResult()%10;
					step1  = (g1+g2+g3)%10;
					
					int yu = (g1+g2+g3)%3;
					int zon = 0;
					System.out.print(kleb.getTime()+" "+kleb.getResult()+"  余数:"+step1+"   选：");
					for (int i = 0; i < 28; i++) {
						if( i%10 != step1  && i%3 != yu ) {
							System.out.print(i+",");
							tou.add(i);
							zon+=Integer.valueOf(biaotou[i]);
						}
					}
					System.out.print(" 投："+zon);
					if( ( kleb.getResult()%10 != step1 ) && ( kleb.getResult()%3 != yu ) ) {
						zq_++;
						yin_z += 1000-zon;
						yin_t += 1000-zon;
						System.out.print("   433");
					} else {
						yin_z += -1*zon;
						yin_t += -1*zon;
						System.out.print("   567");
					}
					System.out.println("");
					set.clear();
					
					Timestamp today = kleb.getTime();
					
					int ct = today.compareTo(dayDate);
					if( ct > 0 ) {		
						map.put(df.format(dayDate),yin_t);
						yin_t = 0;
						dayCal.add(Calendar.DATE, 1);
						dayDate = dayCal.getTime();
					} else if( k == list.size()-1 ){
						map.put(df.format(today),yin_t);
					}
					
				}
				last1 = last2;
				last2 = last3;
				last3 = kleb;
				
			}
			System.out.println("共" + list.size() + "条记录");
		    float pj = (float) zq_/list.size() ;
		    float zql = (float) (Math.round(pj*100))/100;
			System.out.println("准确比例:"+zql);
			System.out.println("总盈利:"+yin_z);
			
			//升序排序
			List<Entry<String,Integer>> list1 = new ArrayList<Entry<String,Integer>>(map.entrySet());
	        Collections.sort(list1,new Comparator<Entry<String,Integer>>() {
	            public int compare(Entry<String, Integer> o1,
	                    Entry<String, Integer> o2) {
	                return o1.getKey().compareTo(o2.getKey());
	            }
	        });
	        for(Entry<String,Integer> mapping:list1){
	               System.out.println(mapping.getKey()+": "+mapping.getValue());
	          } 
				
			
		
				
		}
	
//
//	public String gjuntou() throws ParseException {
//		//获取前70天日期
//		Calendar cal=Calendar.getInstance();
//		cal.add(Calendar.DATE,-62);
//		Date time=cal.getTime();
//		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
//
//		//获取对应期数
//		long start = jndebDAO.findIssueByTimeMin(date);
//
//
//		//
//		List<JndebResult> list = jndebResultDAO.findAllByStart(start);
//
//
//		int kuodu =  30;
//		List<JndebResult> list1 = new ArrayList<JndebResult>();
//		int size = list.size();
//		ResultDO avgStart = new ResultDO();
//		int total = 0;
//		int dxTotal = 0;
//		int oeTotal = 0;
//		int low = 0;
//		int high = 0;
//
//		//计算起点均值
//		for (int i = 0; i < size; i++) {
//			if( i < kuodu) {
//				JndebResult result = list.get(i);
//				total += result.getTotal();
//				dxTotal += result.getTotalsize();
//				oeTotal += result.getTotaloddeven();
//			} else {
//				avgStart.setSum(total);
//				avgStart.setOeSum(oeTotal);
//				avgStart.setDxSum(dxTotal);
//				break;
//			}
//		}
//
//
//		//组数据
//		for (int i = kuodu; i < size; i++) {
//			JndebResult result = list.get(i);
//
//
//			List<Jndeb> ebList =  jndebDAO.findResultFromToByIssue(result.getStart(),result.getEnd());
//
//			int[] maxmin = MathTools.getMaxMin(ebList);
//
//
//
//			int sum = avgStart.getSum();
//			int dxSum = avgStart.getDxSum();
//			int oeSum = avgStart.getOeSum();
//			sum = sum + result.getTotal() - list.get(i-kuodu).getTotal();
//			dxSum = dxSum + result.getDxavg() - list.get(i-kuodu).getDxavg();
//			oeSum = oeSum + result.getOeavg() - list.get(i-kuodu).getOeavg();
//			avgStart.setSum(sum);
//			avgStart.setDxSum(dxSum);
//			avgStart.setOeSum(oeSum);
//			int avg = sum / kuodu;
//			int dxAvg = dxSum / kuodu;
//			int oeAvg = oeSum / kuodu;
//			result.setAvg(avg);
//			result.setDxavg(dxAvg);
//			result.setOeavg(oeAvg);
//			result.setHigh(maxmin[0]);
//			result.setLow(maxmin[1]);
//
//			list1.add(result);
//		}
//
//
//
//
//		for (JndebResult jndebResult : list1) {
//			System.out.println(jndebResult.getId()+" 中边："+jndebResult.getTotal()
//					+ "比较均线" +  jndebResult.getAvg() + " 偏移范围：" + (jndebResult.getTotal()-jndebResult.getAvg())
//					+" 最大："+jndebResult.getHigh()+"  最小"+jndebResult.getLow()
//					+"       单双:"+jndebResult.getTotaloddeven()+"比较均线"+jndebResult.getOeavg()+" 偏移范围" + (jndebResult.getTotaloddeven()-jndebResult.getOeavg())
//					+" 大小:"+jndebResult.getTotalsize()+"比较均线"+jndebResult.getDxavg()+" 偏移范围" + (jndebResult.getTotalsize()-jndebResult.getDxavg()));
//		}https://nbics7ld.vgtiekcw.com/f/Y4nuGREtS
//
//
//		int size1 = list1.size();
//		int sum = 0;//收益
//		int t_n = 0;
//
//		//投入策略 小于偏移-105 投中
//		for (int i = 0; i < size1; i++) {
//			JndebResult result = list1.get(i);
//			if(result.getTotal()- result.getAvg() < -58
//					&&  i < size1-1){
//				sum += list1.get(i+1).getTotal()-result.getTotal();
//				t_n++;
//				System.out.println("投:"+ result.getId()+" "+sum +" 投入次数："+t_n +" 当天"+(list1.get(i+1).getTotal()-result.getTotal()));
//			} else {
//				System.out.println("不投:"+ result.getId()+" "+sum);
//			}
//
//		}
//		System.out.println("");
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
////		//投入策略 小于偏移220 投边
//		for (int i = 0; i < size1; i++) {
//			JndebResult result = list1.get(i);
//			if(result.getTotal()- result.getAvg() > -50 &&  i < size1-1){
//				sum += result.getTotal()-list1.get(i+1).getTotal();
//				t_n++;
//				System.out.println("投:"+ result.getId()+" "+sum +" 投入次数："+t_n);
//			} else {
//				System.out.println("不投:"+ result.getId()+" "+sum);
//			}
//
//		}
////
////
		
		
		//	//投入策略  大于偏移-145 投双
//		for (int i = 0; i < size1; i++) {
//			JndebResult result = list1.get(i);
//			if(result.getTotaloddeven()- result.getOeavg() > -20 &&  i < size1-1){
//				sum += result.getTotaloddeven()-list1.get(i+1).getTotaloddeven();
//				t_n++;
//				System.out.println("投:"+ result.getId()+" "+sum +" 投入次数："+t_n);
//			} else {
//				System.out.println("不投:"+ result.getId()+" "+sum);
//			}
//			
//		}
//		
		//投入策略  大于偏移  投
//		for (int i = 0; i < size1; i++) {
//					JndebResult result = list1.get(i);
//					if(result.getTotalsize()- result.getDxavg() > 0 &&  i < size1-1){
//						sum += result.getTotalsize()-list1.get(i+1).getTotalsize();
//						t_n++;
//						System.out.println("投:"+ result.getId()+" "+sum +" 投入次数："+t_n);
//					} else {
//						System.out.println("不投:"+ result.getId()+" "+sum);
//					}
//					
//				}
			
	//	return "";
//	}
	
	
	public static void main(String[] args) throws ParseException {
		
		InfoMxJndebService service = new InfoMxJndebService();
		//service.getZbByDay("2021-01-01");
		//service.jianyan2("2013-01-01");
		
		
		//service.getBilizbByDate("2014-01-01");
		
		service.getLiandaByDate("2021-01-01");
		service.getLianxiaoByDate("2021-01-01");
		service.getLianzhongByDate("2021-01-01");
		service.getLianbianByDate("2021-01-01");
		service.getLianjiByDate("2021-01-01");
		service.getLianouByDate("2021-01-01");
////		
		//service.getBilizbByDate("2015-05-01");
		//service.getBilidxByDate("2015-01-01");
		//service.getBilijoByDate("2015-01-01");
		
		
		
		
		
		
		
		//service.getWuQI_Jndeb("2017-05-01");// 09-10开始
		//service.getShiqi_Jndeb("2018-01-01");
		//service.getSanqi_ds("2014-09-10");
		//service.yan_getPeilv("2016-10-01 00:02:30",20,19);
		//service.quwei_xyeb("2017-03-01");
		
		//service.getWuQI_Kleb_wei("2017-09-10");
		//service.getSiqi_ds("2015-05-01");
		//service.getSiqi_dx("2014-11-22");
		//service.yan_getPeilv("2015-10-30 00:03:00",60,55);
		//service.guiji_wei("2017-10-01");
		//service.quwei_xyeb("2015-10-01");
		//service.bajinzhi("2017-01-22");
		// System.out.println("四舍五入取整:(2)=" + new BigDecimal("2.5").setScale(0, BigDecimal.ROUND_HALF_UP)); 
		//service.tongji_wei("2017-06-01");
		//service.getsanqi_yu("2016-05-01");
		
	}	

}
