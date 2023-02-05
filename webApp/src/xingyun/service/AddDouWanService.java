package xingyun.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import xingyun.dao.DouWanDAO;



import xingyun.model.DouWan;
import xingyun.model.Jndeb;

import xingyun.tools.DouwanHtml;

public class AddDouWanService {

    // private static String touzhu28[] = { "100", "300", "600", "1000",
    // "1500","2100", "2800", "3600", "4500", "5500", "6300", "6900",
    // "7300","7500", "7500", "7300", "6900", "6300", "5500", "4500",
    // "3600","2800", "2100", "1500", "1000", "600", "300", "100" };
    private static String touzhu28[] = { "10", "30", "60", "100", "150", "210",
            "280", "360", "450", "550", "630", "690", "730", "750", "750",
            "730", "690", "630", "550", "450", "360", "280", "210", "150",
            "100", "60", "30", "10" };
    private static String touzhuPK10[] = { "0", "20000", "20000", "20000",
            "20000", "20000", "20000", "20000", "20000", "20000", "20000" };
    private static String touzhu28_b[] = { "100", "300", "600", "1000",
            "1500", "2100", "2800", "3600", "4500", "5500", "0", "0", "0",
            "0", "0", "0", "0", "0", "5500", "4500", "3600", "2800", "2100",
            "1500", "1000", "600", "300", "100" };
    private static String touzhu28_z[] = { "0", "0", "0", "0", "0", "0", "0",
            "0", "0", "0", "6300", "6900", "7300", "7500", "7500", "7300",
            "6900", "6300", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
    private static String touzhu28_j[] = { "0", "600", "0", "2000", "0",
            "4200", "0", "7200", "0", "11000", "0", "13800", "0", "15000", "0",
            "14600", "0", "12600", "0", "9000", "0", "5600", "0", "3000", "0",
            "1200", "0", "200" };
    private static String touzhu28_o[] = { "200", "0", "1200", "0", "3000",
            "0", "5600", "0", "9000", "0", "12600", "0", "14600", "0", "15000",
            "0", "13800", "0", "11000", "0", "7200", "0", "4200", "0", "2000",
            "0", "600", "0" };
    private static String touzhu28_x[] = { "100", "300", "600", "1000", "1500",
            "2100", "2800", "3600", "4500", "5500", "6300", "6900", "7300",
            "7500", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
            "0", "0" };
    private static String touzhu28_d[] = { "0", "0", "0", "0", "0", "0", "0",
            "0", "0", "0", "0", "0", "0", "0", "7500", "7300", "6900", "6300",
            "5500", "4500", "3600", "2800", "2100", "1500", "1000", "600",
            "300", "100" };
    private static String touzhu28_q[] = { "200", "600", "1200", "2000",
            "3000", "4200", "5600", "7200", "9000", "11000", "12600", "13800",
            "14600", "15000", "15000", "14600", "13800", "12600", "11000",
            "9000", "7200", "5600", "4200", "3000", "2000", "1000", "600",
            "200" };
    private static String touzhu28_q1[] = { "2", "6", "12", "20", "30", "42",
            "56", "72", "90", "110", "126", "138", "146", "150", "150", "146",
            "138", "126", "110", "90", "72", "56", "42", "30", "20", "10", "6",
            "2" };
    private static String touzhu28_1[] = { "1", "3", "6", "10", "15", "21",
            "28", "36", "45", "55", "63", "69", "73", "75", "75", "73", "69",
            "63", "55", "45", "36", "28", "21", "15", "10", "6", "3", "1" };

    static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
    static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdfdata = new SimpleDateFormat("yyyy-MM-dd");
    public static String session = "Hm_lvt_3b05fb412042bba733e1916f29cb67f6=1473772935,1474133395,1475664330; tencentSig=5212793856; _qddaz=QD.qdnmqd.9vvx4e.itogh2yc; usersid=15298; PHPSESSID=39i8hdflhuor0v5d99oadpvkf0; IESESSION=alive; Hm_lpvt_3b05fb412042bba733e1916f29cb67f6=1475667803; _qddab=4-lhu9bf.itwsfwnk; showid=0; issond=0";

    public static int stopFlat = 0;
    public static int issue = 345262;

    private static String biaopei[] = { "1000", "333.33", "166.67", "100",
            "66.67", "47.62", "35.71", "27.78", "22.22", "18.18", "15.87",
            "14.49", "13.7", "13.33", "13.33", "13.7", "14.49", "15.87",
            "18.18", "22.22", "27.78", "35.71", "47.62", "66.67", "100",
            "166.67", "333.33", "1000" };
    private static float biaopeif[] = { 1000f, 333.33f, 166.67f, 100f, 66.67f,
            47.62f, 35.71f, 27.78f, 22.22f, 18.18f, 15.87f, 14.49f, 13.7f,
            13.33f, 13.33f, 13.7f, 14.49f, 15.87f, 18.18f, 22.22f, 27.78f,
            35.71f, 47.62f, 66.67f, 100f, 166.67f, 333.33f, 1000f };
    public static int count = 0;
    public static float beiflat = 1;
    public static float beiflatJnd = 1;
    public static int type = 1;

    private static List<Integer> tou = new ArrayList<Integer>();

    // 获取赔率
    public String[] getJsEbPeilv(String gbsession) throws URISyntaxException {

        DouWanDAO dao = new DouWanDAO();
        DouwanHtml gebi = new DouwanHtml();
        String ss1 = "";
        String thisissue = "", issueString = "", r = "";

        Double d = Math.random();
        String tString = d.toString();

        try {

            ss1 = gebi.keepsession(
                    "http://116.62.88.254/sgame.php?act=0&c=1&t="
                            + tString, "",session,
                    "http://116.62.88.254/game.php");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc1 = Jsoup.parse(ss1);
        String coin = "0";

        Element table = doc1.select("table.table_list").eq(0).first();
//		coin = doc1.select("i#iPoints").eq(0).text();
//		 coin = coin.replace(",", "");
        int ren =100;
        long touzhue = 1000000000;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        Element tr = table.select("tr").eq(4).first();

        if (tr.select("td").eq(3).first().text().equals("")) {
            Element td = table.select("tr").eq(5).first().select("td").eq(0)
                    .first();
            thisissue = td.text();
        } else {
            Element td = tr.select("td").eq(0).first();
            thisissue = td.text();

            Element td1 = tr.select("td").eq(3).first();
            String t = td1.text().replace(",", "");
            if(t!=null&& !t.equals("")){
                touzhue = Long.valueOf(t);
            }

            Element td2 = tr.select("td").eq(4).first();
            String rens = td2.text();
            rens = rens.substring(rens.indexOf("/")+1);
            if(rens!= null){
                ren = Integer.valueOf(rens);
            }
        }

        // issueString = td.select("a").eq(0).attr("href");
        // issueString =
        // issueString.substring(issueString.indexOf("=")+1,issueString.indexOf("&"));
        System.out.println("当前:" + thisissue);
        String ss = "";
        String[] peiString = new String[33];
        peiString[28] = thisissue;
        peiString[29] = coin;
        peiString[30] = thisissue;
        peiString[31] = String.valueOf(touzhue);
        peiString[32] =  String.valueOf(ren);
        System.out.println("金币:" + coin+" "+issueString);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            ss = gebi.keepsession(
                    "http://116.62.88.254/spress.php?act=0&no="
                            + thisissue, "",session,
                    "http://116.62.88.254/game.php");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(ss);
        Element div = doc.select("table.table_list").eq(0).first();
        for (int i = 0; i < 14; i++) {
            Element tr1 = div.select("tr").eq(i+1).first();

            peiString[i] = tr1.select("td").eq(1).text();
            if (peiString[i].contains(",")) {
                peiString[i] = peiString[i].replace(",", "");
            }
        }
        Element div2 = doc.select("table.table_list").eq(1).first();

        for (int i = 0; i < 14; i++) {
            Element tr2 = div2.select("tr").eq(i+1).first();
            peiString[i+14] = tr2.select("td").eq(1).text();
            if (peiString[i+14].contains(",")) {
                peiString[i+14] = peiString[i].replace(",", "");
            }
        }

        for (int i = 0; i < peiString.length; i++) {
            //System.out.println(peiString[i]);
        }
        return peiString;


    }

    // 获取PC赔率和当前期
    public String[] getPcPeilv(String gbsession) throws URISyntaxException {

        DouWanDAO dao = new DouWanDAO();
        DouwanHtml gebi = new DouwanHtml();
        String ss1 = "";
        String thisissue = "", issueString = "", r = "";

        try {

            ss1 = gebi
                    .keepsession(
                            "http://116.62.88.254/game/dd28/index.aspx",
                            gbsession,"",
                            "http://116.62.88.254/game/dd28/index.aspx");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        String coin = "0";
        Document doc1 = Jsoup.parse(ss1);
        coin = doc1.select("div.likebody").eq(1).select("a").eq(3).text();
        coin = coin.replace(",", "");
        System.out.println(coin);
        Element table = doc1.select("table.gamecontable").eq(0).first();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }

        Element tr = table.select("tr").eq(5).first();
        Element td = tr.select("td").eq(6).first();
        thisissue = td.attr("id");
        thisissue = thisissue.substring(6);
        issueString = td.select("a").eq(0).attr("href");
        issueString = issueString.substring(issueString.indexOf("=") + 1,
                issueString.indexOf("&"));
        System.out.println("当前:" + thisissue + " 投注期号:" + issueString);
        String ss = "";
        String[] peiString = new String[31];
        peiString[28] = thisissue;
        peiString[29] = coin;
        peiString[30] = issueString;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            ss = gebi.keepsession(
                    "http://116.62.88.254/game/dd28/insert.aspx?lot="
                            + issueString + "&pl=jc","", gbsession,
                    "http://116.62.88.254/game/dd28/index.aspx");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(ss);

        Element div = doc.select("tbody#mytztbody").eq(0).first();
        for (int i = 0; i < 14; i++) {
            Element tr1 = div.select("tr").eq(i).first();
            peiString[i] = tr1.select("td").eq(1).text();
        }
        Element div2 = doc.select("tbody#Tbody2").eq(0).first();

        for (int i = 0; i < 14; i++) {
            Element tr2 = div2.select("tr").eq(i).first();
            peiString[i + 14] = tr2.select("td").eq(1).text();
        }

        return peiString;

    }

    // 获取PC赔率和当前期
    public String[] getBj16(String gbsession) throws URISyntaxException {

        DouWanDAO dao = new DouWanDAO();
        DouwanHtml gebi = new DouwanHtml();
        String ss1 = "";
        String thisissue = "", issueString = "", r = "";
        try {

            ss1 = gebi
                    .keepsession(
                            "http://116.62.88.254/game/bj16/index.aspx",
                            gbsession,"",
                            "http://116.62.88.254/game/bj16/index.aspx");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc1 = Jsoup.parse(ss1);
        String coin = "0";
        Element table = doc1.select("table.gamecontable").eq(0).first();
        coin = doc1.select("a").eq(7).text();
        coin = coin.replace(",", "");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }

        Element tr = table.select("tr").eq(5).first();

        Element td = tr.select("td").eq(0).first();

        Element td_ = tr.select("td").eq(6).first();
        String td__ = td_.select("a").eq(0).first().attr("href");
        td__ = td__.substring(td__.indexOf("=") + 1, td__.indexOf("&"));
        thisissue = td.text();
        issueString = td__;

        // thisissue = thisissue.substring(6);
        // issueString = td.select("a").eq(0).attr("href");
        // issueString =
        // issueString.substring(issueString.indexOf("=")+1,issueString.indexOf("&"));
        System.out.println("当前:" + thisissue + " 投注期号:" + issueString);
        String ss = "";
        String[] peiString = new String[32];
        peiString[28] = thisissue;
        peiString[29] = coin;
        peiString[30] = issueString;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            ss = gebi.keepsession(
                    "http://116.62.88.254/game/bj16/insert.aspx?lot="
                            + issueString + "&pl=jc","", gbsession,
                    "http://116.62.88.254/game/bj16/index.aspx");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parse(ss);

        Element div = doc.select("table.gamecontable").eq(0).first();

        for (int i = 1; i < 9; i++) {
            Element tr1 = div.select("tr").eq(i).first();
            peiString[i - 1] = tr1.select("td").eq(1).text();
            peiString[i - 1] = peiString[i - 1].replace("/", "");
        }
        Element div2 = doc.select("table.gamecontable").eq(1).first();

        for (int i = 1; i < 9; i++) {
            Element tr2 = div2.select("tr").eq(i).first();
            peiString[i + 7] = tr2.select("td").eq(1).text();
            peiString[i + 7] = peiString[i - 1].replace("/", "");
        }

        return peiString;

    }

    public String[] getBj28Peilv(String gbsession) throws URISyntaxException {

        DouWanDAO dao = new DouWanDAO();
        DouwanHtml gebi = new DouwanHtml();
        String ss1 = "";
        String thisissue = "", issueString = "", r = "";

        Double d = Math.random();
        String tString = d.toString();

        try {

            ss1 = gebi.keepsession(
                    "https://dthmjx.com/game.php/sgame.php?act=4&c=1&t="
                            + tString,"", gbsession,
                    "https://dthmjx.com/game.php/game.php");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc1 = Jsoup.parse(ss1);
        String coin = "0";
        Element table = doc1.select("table.table_list").eq(0).first();
        // coin = doc1.select("i#iPoints").eq(0).text();
        // coin = coin.replace(",", "");
        // System.out.println(coin);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        Element tr = table.select("tr").eq(4).first();

        if (tr.select("td").eq(2).first().text().equals("")) {
            Element td = table.select("tr").eq(5).first().select("td").eq(0)
                    .first();
            thisissue = td.text();
        } else {
            Element td = tr.select("td").eq(0).first();
            thisissue = td.text();
        }

        // issueString = td.select("a").eq(0).attr("href");
        // issueString =
        // issueString.substring(issueString.indexOf("=")+1,issueString.indexOf("&"));
        System.out.println("当前:" + thisissue);
        String ss = "";
        String[] peiString = new String[32];
        peiString[28] = thisissue;
        peiString[29] = coin;
        peiString[30] = issueString;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            ss = gebi.keepsession(
                    "http://116.62.88.254/spress.php?act=4&no="
                            + thisissue,"", session,
                    "http://116.62.88.254/game.php");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(ss);

        Element div = doc.select("table.table_list").eq(0).first();

        for (int i = 1; i < 15; i++) {
            Element tr1 = div.select("tr").eq(i).first();
            peiString[i - 1] = tr1.select("td").eq(1).text();
            peiString[i - 1] = peiString[i - 1].replace("/", "");
            if (peiString[i - 1].contains(",")) {
                peiString[i - 1] = peiString[i - 1].replace(",", "");
            }
        }
        Element div2 = doc.select("table.table_list").eq(1).first();

        for (int i = 1; i < 15; i++) {
            Element tr2 = div2.select("tr").eq(i).first();
            peiString[i + 13] = tr2.select("td").eq(1).text();
            peiString[i + 13] = peiString[i - 1].replace("/", "");
            if (peiString[i + 13].contains(",")) {
                peiString[i + 13] = peiString[i + 13].replace(",", "");
            }
        }

        return peiString;
    }

    public String[] getPc28Peilv(String gbsession) throws URISyntaxException {

        DouWanDAO dao = new DouWanDAO();
        DouwanHtml gebi = new DouwanHtml();
        String ss1 = "";
        String thisissue = "", issueString = "", r = "";

        Double d = Math.random();
        String tString = d.toString();

        try {

            ss1 = gebi.keepsession(
                    "http://116.62.88.254/sgame.php?act=3&c=1&t="
                            + tString, "",session,
                    "http://116.62.88.254/game.php");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc1 = Jsoup.parse(ss1);
        String coin = "0";
        Element table = doc1.select("table.table_list").eq(0).first();
        // coin = doc1.select("i#iPoints").eq(0).text();
        // coin = coin.replace(",", "");
        // System.out.println(coin);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        Element tr = table.select("tr").eq(4).first();

        if (tr.select("td").eq(2).first().text().equals("")) {
            Element td = table.select("tr").eq(4).first().select("td").eq(0)
                    .first();
            thisissue = td.text();
        } else {
            Element td = tr.select("td").eq(0).first();
            thisissue = td.text();
        }

        // issueString = td.select("a").eq(0).attr("href");
        // issueString =
        // issueString.substring(issueString.indexOf("=")+1,issueString.indexOf("&"));
        System.out.println("当前:" + thisissue);
        String ss = "";
        String[] peiString = new String[32];
        peiString[28] = thisissue;
        peiString[29] = coin;
        peiString[30] = issueString;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            ss = gebi.keepsession(
                    "http://116.62.88.254/spress.php?act=3&no="
                            + thisissue, "",session,
                    "http://116.62.88.254/game.php");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(ss);
        Element div = doc.select("table.table_list").eq(0).first();

        for (int i = 1; i < 15; i++) {
            Element tr1 = div.select("tr").eq(i).first();
            peiString[i - 1] = tr1.select("td").eq(1).text();
            if (peiString[i - 1].contains(",")) {
                peiString[i - 1] = peiString[i - 1].replace(",", "");
            }
        }
        Element div2 = doc.select("table.table_list").eq(1).first();

        for (int i = 1; i < 15; i++) {
            Element tr2 = div2.select("tr").eq(i).first();
            peiString[i + 13] = tr2.select("td").eq(1).text();
            if (peiString[i + 13].contains(",")) {
                peiString[i + 13] = peiString[i + 13].replace(",", "");
            }
        }

        return peiString;
    }

    // 旧版
    /*
     * public String[] getBj28Peilv(String gbsession) throws URISyntaxException
     * {
     *
     * DouWanDAO dao = new DouWanDAO(); DouwanHtml gebi = new DouwanHtml();
     * String ss1 = ""; String thisissue = "",issueString = "", r = ""; try {
     *
     * ss1 = gebi.keepsession( "http://116.62.88.254/play/bj28", session,
     * "http://116.62.88.254/play/bj28"); } catch (ClientProtocolException
     * e1) { e1.printStackTrace(); } catch (IOException e1) {
     * e1.printStackTrace(); } Document doc1 = Jsoup.parse(ss1); String coin
     * ="0"; Element table = doc1.select("table#Table111").eq(0).first(); coin =
     * doc1.select("table").eq(2).select("font").eq(5).text(); coin =
     * coin.replace(",", ""); System.out.println(coin);
     *
     *
     * try { Thread.sleep(500); } catch (InterruptedException e1) {
     *
     * e1.printStackTrace(); }
     *
     *
     *
     * Element tr = table.select("tr").eq(12).first(); Element td =
     * tr.select("td").eq(0).first();
     *
     * thisissue = td.text(); issueString = thisissue;
     * System.out.println(thisissue); //thisissue = thisissue.substring(6);
     * //issueString = td.select("a").eq(0).attr("href"); //issueString =
     * issueString
     * .substring(issueString.indexOf("=")+1,issueString.indexOf("&"));
     * System.out.println("当前:" + thisissue+ " 投注期号:"+thisissue); String ss =
     * ""; String[] peiString = new String[32]; peiString[28] = thisissue;
     * peiString[29] = coin;
     *
     * try { Thread.sleep(500); } catch (InterruptedException e1) {
     * e1.printStackTrace(); } try { ss = gebi.keepsession(
     * "http://116.62.88.254/play/bj28/insertbet.aspx?bnumber=" +
     * thisissue, session, "http://116.62.88.254/play/bj28/index.aspx"); }
     * catch (ClientProtocolException e) { e.printStackTrace(); } catch
     * (IOException e) { e.printStackTrace(); } Document doc = Jsoup.parse(ss);
     * Element state = doc.select("input").eq(2).first(); String __VIEWSTATE =
     * state.attr("value");
     *
     * Element state1 = doc.select("input").eq(3).first(); String
     * __VIEWSTATEGENERATOR = state1.attr("value");
     *
     * Element div = doc.select("table#Table111").eq(0).first(); peiString[30] =
     * __VIEWSTATE; peiString[31] = __VIEWSTATEGENERATOR; for (int i = 1; i <
     * 15; i++) { Element tr1 = div.select("tr").eq(i).first(); peiString[i-1] =
     * tr1.select("td").eq(1).text(); if( peiString[i-1].contains(",") ) {
     * peiString[i-1] = peiString[i-1].replace(",", ""); } } Element div2 =
     * doc.select("table#Table111").eq(1).first();
     *
     * for (int i = 1; i < 15; i++) { Element tr2 =
     * div2.select("tr").eq(i).first(); peiString[i+13] =
     * tr2.select("td").eq(1).text(); if( peiString[i+13].contains(",") ) {
     * peiString[i+13] = peiString[i+13].replace(",", ""); } }
     *
     *
     *
     * return peiString; }
     */

    public String[] getJnd28Peilv(String session) throws URISyntaxException {

        DouWanDAO dao = new DouWanDAO();
        DouwanHtml gebi = new DouwanHtml();
        String ss1 = "";
        String thisissue = "", issueString = "", r = "";

        Double d = Math.random();
        String tString = d.toString();

        try {

            ss1 = gebi.keepsession(
                    "http://116.62.88.254/sgame.php?act=8&c=1&t="
                            + tString,"", session,
                    "http://116.62.88.254/game.php");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc1 = Jsoup.parse(ss1);
        String coin = "0";
        Element table = doc1.select("table.table_list").eq(0).first();
        // coin = doc1.select("i#iPoints").eq(0).text();
        // coin = coin.replace(",", "");
        // System.out.println(coin);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        Element tr = table.select("tr").eq(4).first();

        if (tr.select("td").eq(2).first().text().equals("")) {
            Element td = table.select("tr").eq(5).first().select("td").eq(0)
                    .first();
            thisissue = td.text();
        } else {
            Element td = tr.select("td").eq(0).first();
            thisissue = td.text();
        }

        // issueString = td.select("a").eq(0).attr("href");
        // issueString =
        // issueString.substring(issueString.indexOf("=")+1,issueString.indexOf("&"));
        System.out.println("当前:" + thisissue);
        String ss = "";
        String[] peiString = new String[32];
        peiString[28] = thisissue;
        peiString[29] = coin;
        peiString[30] = issueString;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            ss = gebi.keepsession(
                    "http://116.62.88.254/spress.php?act=8&no="
                            + thisissue, "",session,
                    "http://116.62.88.254/game.php");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(ss);
        Element div = doc.select("table.table_list").eq(0).first();

        for (int i = 1; i < 15; i++) {
            Element tr1 = div.select("tr").eq(i).first();
            peiString[i - 1] = tr1.select("td").eq(1).text();
            if (peiString[i - 1].contains(",")) {
                peiString[i - 1] = peiString[i - 1].replace(",", "");
            }
        }
        Element div2 = doc.select("table.table_list").eq(1).first();

        for (int i = 1; i < 15; i++) {
            Element tr2 = div2.select("tr").eq(i).first();
            peiString[i + 13] = tr2.select("td").eq(1).text();
            if (peiString[i + 13].contains(",")) {
                peiString[i + 13] = peiString[i + 13].replace(",", "");
            }
        }

        return peiString;

    }

    public String[] getJnd16Peilv(String gbsession) throws URISyntaxException {

        DouWanDAO dao = new DouWanDAO();
        DouwanHtml gebi = new DouwanHtml();
        String ss1 = "";
        String thisissue = "", issueString = "", r = "";
        try {

            ss1 = gebi
                    .keepsession(
                            "http://116.62.88.254/game/jj16/index.aspx","",
                            gbsession,
                            "http://116.62.88.254/game/jj16/index.aspx");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc1 = Jsoup.parse(ss1);
        String coin = "0";
        Element table = doc1.select("table.gamecontable").eq(0).first();
        coin = doc1.select("a").eq(7).text();
        coin = coin.replace(",", "");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }

        Element tr = table.select("tr").eq(3).first();

        Element td = tr.select("td").eq(0).first();

        Element td_ = tr.select("td").eq(6).first();
        String td__ = td_.select("a").eq(0).first().attr("href");
        td__ = td__.substring(td__.indexOf("=") + 1, td__.indexOf("&"));
        thisissue = td.text();
        issueString = td__;

        // thisissue = thisissue.substring(6);
        // issueString = td.select("a").eq(0).attr("href");
        // issueString =
        // issueString.substring(issueString.indexOf("=")+1,issueString.indexOf("&"));
        System.out.println("当前:" + thisissue + " 投注期号:" + issueString);
        String ss = "";
        String[] peiString = new String[32];
        peiString[28] = thisissue;
        peiString[29] = coin;
        peiString[30] = issueString;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            ss = gebi.keepsession(
                    "http://116.62.88.254/game/jj16/insert.aspx?lot="
                            + issueString + "&pl=jc","", gbsession,
                    "http://116.62.88.254/game/jj16/index.aspx");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parse(ss);

        Element div = doc.select("table.gamecontable").eq(0).first();

        for (int i = 1; i < 9; i++) {
            Element tr1 = div.select("tr").eq(i).first();
            peiString[i - 1] = tr1.select("td").eq(1).text();
            peiString[i - 1] = peiString[i - 1].replace("/", "");
        }
        Element div2 = doc.select("table.gamecontable").eq(1).first();

        for (int i = 1; i < 9; i++) {
            Element tr2 = div2.select("tr").eq(i).first();
            peiString[i + 7] = tr2.select("td").eq(1).text();
            peiString[i + 7] = peiString[i - 1].replace("/", "");
        }

        return peiString;

    }

    public String[] addJisuEb(String session) {

        DouWanDAO dao = new DouWanDAO();
        Long max = Long.valueOf(dao.findMaxJiSuErbaerba());
        DouwanHtml gebi = new DouwanHtml();
        String[] returnIssue = new String[2];

        Calendar a = Calendar.getInstance();
        int year = a.get(Calendar.YEAR);
        String yearString = String.valueOf(year);

        List<DouWan> list = new ArrayList<DouWan>();
        String ss = "";
        String time, issue, r1, r2, r3, issueString = null, thisissue = null;
        Long issueLong = 0l, flat = 0l;

        Double d = Math.random();
        String tString = d.toString();
        System.out.println(max);
        label: for (int i = 1; i < 660; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("第" + i + "页");


                ss = gebi.keepsession(
                        "https://haochehq.com/sgame.php?c=1&act=0&page=" + i
                                + "&t=" + tString, "",session,
                        "https://haochehq.com/game.php");
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
            }

            Document doc1 = Jsoup.parse(ss);
            Element table = doc1.select("table.table_list").eq(0).first();

            String coin = doc1.select("em").eq(2).first().text();
            coin = coin.replace(",", "");
            returnIssue[1] = coin;
            System.out.println(coin);


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {

                e1.printStackTrace();
            }

            for (int j = 1; j < 21; j++) {
                DouWan l1 = new DouWan();
                Element tr = table.select("tr").eq(j).first();
                Elements f = tr.select("td").eq(2).select("i");
                if (f.first() == null) {
                    continue;
                } else {
                    Element td = tr.select("td").eq(0).first();
                    thisissue = td.text();
                }

                issueLong = Long.valueOf(thisissue);
                //
                //
                time = tr.select("td").eq(1).first().text();
                r1 = f.eq(0).attr("class");
                r1 = r1.substring(r1.indexOf("_") + 1);
                r2 = f.eq(2).attr("class");
                r2 = r2.substring(r2.indexOf("_") + 1);
                r3 = f.eq(4).attr("class");
                r3 = r3.substring(r3.indexOf("_") + 1);

                int r = 0;
                try {
                    r = Integer.valueOf(r1) + Integer.valueOf(r2)
                            + Integer.valueOf(r3);
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                    break label;
                }
                if (i > 1 && flat.equals(issueLong)) {
                    System.out.println(thisissue + "比较" + flat);
                    continue;
                }

                flat = issueLong;
                if (issueLong > max) {
                    l1.setIssue(Long.valueOf(thisissue));
                    try {
                        l1.setTime(new Timestamp(sdf2.parse(
                                yearString + "-" + time).getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    l1.setResult(Byte.valueOf(String.valueOf(r)));
                    l1.setR1(Byte.valueOf(r1));
                    l1.setR2(Byte.valueOf(r2));
                    l1.setR3(Byte.valueOf(r3));
                    list.add(0, l1);
                    // System.out.println(list.get(0).getIssue());
                } else {
                    break label;
                }
            }
        }

        if (list.size() > 0) {
            System.out.println("最后一期为:" + list.get(0).getIssue());
            System.out.println("最大期数为:" + max);
            Long last = list.get(0).getIssue() - 1l;
            max = Long.valueOf(dao.findMaxJiSuErbaerba());
            if (max.equals(last)) {
                dao.addJiSuErba(list);
                System.out.println("已成功添加了" + list.size() + "条数据");
            } else {
                System.out.println("期数错误");
                returnIssue[0] = "-1";
            }
            returnIssue[0] = String.valueOf(list.get(list.size() - 1)
                    .getIssue());

        }

        return returnIssue;

    }


    synchronized public String[] addJnd28(String session,String url,String host,String referer) {

        DouWanDAO dao = new DouWanDAO();
        Long max = Long.valueOf(dao.findMaxJnd28());
        System.out.println(max);
        DouwanHtml gebi = new DouwanHtml();
        String[] returnIssue = new String[2];

        Calendar a = Calendar.getInstance();
        int year = a.get(Calendar.YEAR);
        String yearString = String.valueOf(year);

        List<Jndeb> list = new ArrayList<Jndeb>();
        String ss = "";
        String time, issue, r1, r2, r3, issueString = null, thisissue = null;
        Long issueLong = 0l, flat = 0l;

        Double d = Math.random();
        String tString = d.toString();

        label: for (int i = 1; i < 160; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("第" + i + "页");
                String url1 = url+"?act=8&page="+i+"&t=" + tString;
                ss = gebi.keepsession(url1,host, session
                        ,referer);


            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
            }
            Document doc1 = Jsoup.parse(ss);
            Element table = doc1.select("table.table_list").eq(0).first();

            String coin = doc1.select("em").eq(2).first().text();
            coin = coin.replace(",", "");
            returnIssue[1] = coin;
            System.out.println(coin);


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {

                e1.printStackTrace();
            }

            for (int j = 1; j < 21; j++) {
                Jndeb l1 = new Jndeb();
                Element tr = table.select("tr").eq(j).first();
                Elements f = tr.select("td").eq(2).select("i");
                if (f.first() == null) {
                    continue;
                } else {
                    Element td = tr.select("td").eq(0).first();
                    thisissue = td.text();
                }

                issueLong = Long.valueOf(thisissue);
                //
                //
                time = tr.select("td").eq(1).first().text();
                r1 = f.eq(0).attr("class");
                r1 = r1.substring(r1.indexOf("_") + 1);
                r2 = f.eq(2).attr("class");
                r2 = r2.substring(r2.indexOf("_") + 1);
                r3 = f.eq(4).attr("class");
                r3 = r3.substring(r3.indexOf("_") + 1);

                int r = 0;
                try {
                    r = Integer.valueOf(r1) + Integer.valueOf(r2)
                            + Integer.valueOf(r3);
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                    break label;
                }
                if (i > 1 && flat.equals(issueLong)) {
                    continue;
                }

                flat = issueLong;

                if (issueLong > max) {
                    l1.setIssue(Long.valueOf(thisissue));
                    try {
                        l1.setTime(new Timestamp(sdf2.parse(
                                yearString + "-" + time).getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    l1.setResult(Byte.valueOf(String.valueOf(r)));
                    l1.setR1(Byte.valueOf(r1));
                    l1.setR2(Byte.valueOf(r2));
                    l1.setR3(Byte.valueOf(r3));
                    list.add(0, l1);
                    // System.out.println(list.get(0).getIssue());
                } else {
                    break label;
                }
            }
        }

        if (list.size() > 0) {
            System.out.println("最后一期为:" + list.get(0).getIssue());
            System.out.println("最大期数为:" + max);
            Long last = list.get(0).getIssue() - 1l;

            if (max.equals(last)) {
                dao.addJndeb(list);
                System.out.println("已成功添加了" + list.size() + "条数据");
            } else {
                System.out.println("期数错误");
                returnIssue[0] = "-1";
            }
            returnIssue[0] = String.valueOf(list.get(list.size() - 1)
                    .getIssue());

        }

        return returnIssue;

    }



    //加拿大28 by agpc28
    public String addJndebByYuce(String cookString) throws InterruptedException, ClientProtocolException, IOException, URISyntaxException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DouwanHtml douwanHtml = new DouwanHtml();
        Calendar cal = Calendar.getInstance();
        DouWanDAO dwDAO = new DouWanDAO();
        Long max = Long.valueOf(dwDAO.findMaxJiSuErbaerba());
        List<DouWan> list = new ArrayList<DouWan>();
        List<DouWan> list1 = new ArrayList<DouWan>();
        String html = "";
        HttpClient httpclient = new DefaultHttpClient();
        cal.add(Calendar.DAY_OF_MONTH,-1);


        //cal.add(Calendar.MONTH, -1);
        label:for (int t = 0; t < 300; t++) {

            //减一天
            //if( t > 0 ){
            cal.add(Calendar.DAY_OF_MONTH,-1);
            //}
            String dataString  = sdfdata.format(cal.getTime());
            System.out.println("t:"+dataString);

            HttpGet httpget1 = douwanHtml.getHttpGetByYuce("http://www.yuce28.com/xy28.aspx?T=85&day="+dataString,cookString,"http://www.yuce28.com/xy28.aspx");
            HttpResponse response1 = httpclient.execute(httpget1);
            //获取响应实体
            HttpEntity entity1 = response1.getEntity();
            //打印响应状态
            System.out.println(response1.getStatusLine());
            if (entity1 != null) {
                //打印响应内容
                html = EntityUtils.toString(entity1, "utf-8");
            }
            System.out.println(html);

            String s = cookString.substring(cookString.indexOf("AJSTAT_ok_pages=")+16,cookString.indexOf("AJSTAT_ok_pages=")+18);
            System.out.println(s);
            int a = Integer.valueOf(s);
            a = a+1;
            cookString = cookString.substring(0,cookString.indexOf("AJSTAT_ok_pages=")+16)+String.valueOf(a)+cookString.substring(cookString.indexOf("AJSTAT_ok_pages=")+18);
            System.out.println(cookString);


            HttpGet httpget = douwanHtml.getHttpGetByYuce("http://www.yuce28.com/action/Handler.ashx?cmd=getdatac&t=85&c=100&d="+dataString+"&_=1492163846959",cookString,"http://www.yuce28.com/xy28.aspx?T=85&day="+dataString);
            //执行get请求.
            HttpResponse response = httpclient.execute(httpget);
            //获取响应实体
            HttpEntity entity = response.getEntity();
            //打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                //打印响应内容
                html = EntityUtils.toString(entity, "utf-8");
            }
            Document doc = Jsoup.parse(html);

            Element trs = doc.getElementById("dc-ssc");
            for (int j = 1; j< 400; j++) {
                DouWan l1 = new DouWan();
                Elements tr = trs.select("tr").eq(j);

                if( tr.select("td").eq(0).text() == null || tr.select("td").eq(0).text().equals("")){
                    break;
                }

                Long issue = Long.valueOf(tr.select("td").eq(0).text());
                //System.out.print("issue~~~~~~~~~~~~~:"+issue+" ");

                String result = tr.select("td").eq(1).text();
                //System.out.println(result);

                String r1 = result.substring(0,result.indexOf("+")).trim();
                String r2 = result.substring(result.indexOf("+")+1,result.lastIndexOf("+")).trim();
                String r3 = result.substring(result.lastIndexOf("+")+1,result.lastIndexOf("=")).trim();
                String r = result.substring(result.lastIndexOf("=")+1).trim();


//								if (resultString.equals("--") ) {
//									continue;
//								}

                try {
                    if (issue > max) {
                        l1.setIssue(issue.longValue());
                        l1.setResult(Byte.valueOf(r));
                        l1.setR1(Byte.valueOf(r1));
                        l1.setR2(Byte.valueOf(r2));
                        l1.setR3(Byte.valueOf(r3));
                        list1.add(0,l1);
                    } else {
                        break ;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break label;
                }

            }

            //补充时间
            if(list1.size() > 0 && list1.size() > 200 ) {
                cal.set(Calendar.MINUTE,3);
                cal.set(Calendar.HOUR_OF_DAY,0);
                cal.set(Calendar.SECOND,0);
                for (int i = 0; i < 343; i++) {

                    Date d  = cal.getTime();
                    //System.out.println(list.get(i).getIssue()+" "+list.get(i).getResult()+" "+sdf1.format(d));
                    list1.get(i).setTime(new Timestamp(d.getTime()));
                    if (list1.get(i).getIssue()<= max) {
                        break;
                    }
                    cal.add(Calendar.SECOND, 30);
                    cal.add(Calendar.MINUTE, 3);
                }
                cal.set(Calendar.MINUTE,59);
                cal.set(Calendar.HOUR_OF_DAY,23);
                cal.set(Calendar.SECOND,30);
                for (int j1 = list1.size(); j1 > 0; j1--) {

                    Date d  = cal.getTime();
                    //System.out.println(list.get(j1-1).getIssue()+" "+list.get(j1-1).getResult()+" "+sdf1.format(d));
                    list1.get(j1-1).setTime(new Timestamp(d.getTime()));
                    if( list1.get(j1-2).getTime() != null ) {
                        System.out.println("if"+d.getTime());
                        break;
                    }
                    cal.add(Calendar.SECOND, -30);
                    cal.add(Calendar.MINUTE, -3);
                }
                list.addAll(0,list1);
                if (max.equals(list1.get(0).getIssue()-1)) {
                    break label;
                }
                list1.clear();
            } else if( list1.size() > 0) {
                cal.set(Calendar.MINUTE,59);
                cal.set(Calendar.HOUR_OF_DAY,23);
                cal.set(Calendar.SECOND,30);
                for (int j1 = list1.size(); j1 > 0; j1--) {

                    Date d  = cal.getTime();
                    //System.out.println(list.get(j1-1).getIssue()+" "+list.get(j1-1).getResult()+" "+sdf1.format(d));
                    list1.get(j1-1).setTime(new Timestamp(d.getTime()));

                    cal.add(Calendar.SECOND, -30);
                    cal.add(Calendar.MINUTE, -3);
                    if (max.equals(list1.get(j1-1).getIssue()-1)) {
                        list.addAll(0,list1);
                        list1.clear();
                        break label;
                    }
                }

            }
        }
        for (DouWan douwan : list) {
            System.out.println(douwan.getIssue()+" "+douwan.getResult()+" "+douwan.getTime());
        }

        if( list.size() > 0){
            Long last = list.get(0).getIssue() - 1l;
            System.out.println(last);
            if ( max.equals(last) ) {
                dwDAO.addJiSuErba(list);
                System.out.println("已成功添加了" + list.size() + "条数据");
                System.out.println("1");
            } else {
                System.out.println("期数错误");
                return "-1";
            }
        }
        return "0";
    }


    // 单投 急速28 轨迹
    public static String dantouJseb3() {

        String[] addIssue = null;
        DouWan[] sz = null;
        AddDouWanService addService = new AddDouWanService();
        DouwanHtml yiyi = new DouwanHtml();
        DouWanDAO dao = new DouWanDAO();
        String[] zmZuizhong = new String[28];
        int[] weiList = new int[6];
        int step1 = 0;
        int step2 = 0;
        int temp = 0;

        addIssue = addService.addJisuEb(session);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }
        sz = dao.findFive();
        System.out.println("当前" + sz[0].getIssue());
        System.out.println("返回" + addIssue[0]);
        if (addIssue[0].equals(String.valueOf(sz[0].getIssue()))) {
            DouWan kleb = sz[0];
            int jieguo = kleb.getResult() % 10;
            int[] guiji = { 0, 47, 158, 269, 370, 481, 592, 603, 714, 825, 936 };
            int weizhi = 1;

            for (int i = 1; i < guiji.length; i++) {
                if (guiji[i] % 10 == jieguo) {
                    weizhi = i;
                }
            }
            System.out.print(" 位置:" + weizhi + " ");
            int a1 = 0, a2 = 0;

            if (weizhi == 10) {
                a1 = 47;
                a2 = guiji[9];
            } else if (weizhi == 1) {
                a1 = guiji[2];
                a2 = guiji[10];
            } else {
                a1 = guiji[weizhi + 1];
                a2 = guiji[weizhi - 1];
            }

            System.out.print(" " + a1 + " " + a2 + " ");

            weiList[0] = a1 % 10;
            weiList[1] = a1 / 10 % 10;
            weiList[2] = a1 / 100;

            weiList[3] = a2 % 10;
            weiList[4] = a2 / 10 % 10;
            weiList[5] = a2 / 100;

            int flat = 0;
            System.out.print(" 集合: ");

            // 正向
            for (Integer i : weiList) {

                if (i < 8) {
                    zmZuizhong[i] = touzhu28[i];
                    zmZuizhong[i + 10] = touzhu28[i + 10];
                    zmZuizhong[i + 20] = touzhu28[i + 20];
                } else {
                    zmZuizhong[i] = touzhu28[i];
                    zmZuizhong[i + 10] = touzhu28[i + 10];
                }
            }

            System.out.println("");
            System.out.print("投注   ");
            for (int i = 0; i < zmZuizhong.length; i++) {
                if (zmZuizhong[i] == null) {
                    zmZuizhong[i] = "0";
                }
                System.out.print(zmZuizhong[i] + " ");
            }
            System.out.println("");
            String[] touIssue = null;

            try {
                String ss = yiyi.keepsessionPost(
                        "http://vip.geibi.net/game/doinsert.aspx?xJB=0",
                        session, addIssue[1], zmZuizhong,
                        "http://vip.geibi.net/game/luck28/index.aspx", "8");
                ss = ss.substring(ss.indexOf(":") + 1, ss.indexOf(","));
                System.out.println("投注结果:" + ss);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {

                e.printStackTrace();
            }

        } else {
            System.out.println("添加期数有误");
        }

        return null;

    }

    // 单投加拿大28-五期尾
    public static String dantouJseb_wuqi() {

        String[] addIssue = null;
        DouWan[] sz = null;
        AddDouWanService addService = new AddDouWanService();
        DouwanHtml gebi = new DouwanHtml();
        DouWanDAO dao = new DouWanDAO();
        String[] zmZuizhong = new String[28];
        String ss = "0";

        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        int w4 = 0;
        int w5 = 0;
        addIssue = addService.addJisuEb(session);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }
        sz = dao.findFive();
        System.out.println("当前" + sz[0].getIssue());
        System.out.println("返回" + addIssue[0]);
        if (addIssue[0].equals(String.valueOf(sz[0].getIssue()))) {
            Set<Integer> set = new HashSet<Integer>();
            List<Integer> weiList = new ArrayList<Integer>();
            w1 = sz[4].getResult() % 10;
            w2 = sz[3].getResult() % 10;
            w3 = sz[2].getResult() % 10;
            w4 = sz[1].getResult() % 10;
            w5 = sz[0].getResult() % 10;
            weiList.add(w1);
            weiList.add(w2);
            weiList.add(w3);
            weiList.add(w4);
            weiList.add(w5);
            System.out.print(sz[0].getTime() + ":  " + w1 + "  " + w2 + "  "
                    + w3 + "  " + w4 + "  " + w5);
            set.addAll(weiList);
            // 正向
            for (Integer i : set) {

                if (i < 8) {
                    zmZuizhong[i] = touzhu28[i];
                    zmZuizhong[i + 10] = touzhu28[i + 10];
                    zmZuizhong[i + 20] = touzhu28[i + 20];
                } else {
                    zmZuizhong[i] = touzhu28[i];
                    zmZuizhong[i + 10] = touzhu28[i + 10];
                }
            }

            // //反向
            // for (int i = 0; i < 10; i++) {
            // if( !set.contains(i)) {
            // if( i < 8 ) {
            // zmZuizhong[i] = touzhu28[i];
            // zmZuizhong[i+10] = touzhu28[i+10];
            // zmZuizhong[i+20] = touzhu28[i+20];
            // } else {
            // zmZuizhong[i] = touzhu28[i];
            // zmZuizhong[i+10] = touzhu28[i+10];
            // }
            // }
            // }

            System.out.println("");
            System.out.print("投注   ");
            for (int i = 0; i < zmZuizhong.length; i++) {
                if (zmZuizhong[i] == null) {
                    zmZuizhong[i] = "0";
                }
                System.out.print(zmZuizhong[i] + " ");
            }
            System.out.println(addIssue[1] + " ");
            try {
                // 投注
                ss = gebi.keepsessionPost(
                        "http://vip.geibi.net/game/doinsert.aspx?xJB=0",
                        session, addIssue[1], zmZuizhong,
                        "http://vip.geibi.net/game/luck28/index.aspx", "8");
                ss = ss.substring(ss.indexOf(":") + 1, ss.indexOf(","));
                System.out.println("投注结果:" + ss);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {

                e.printStackTrace();
            }

        } else {
            System.out.println("添加期数有误");
        }

        return ss;

    }


    // 单投加拿大28-五期尾
    public static String dantouJseb_shiqi() {

        String[] addIssue = null;
        DouWan[] sz = null;
        AddDouWanService addService = new AddDouWanService();
        DouwanHtml gebi = new DouwanHtml();
        DouWanDAO dao = new DouWanDAO();
        String[] zmZuizhong = new String[28];
        String ss = "0";

        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        int w4 = 0;
        int w5 = 0;
        addIssue = addService.addJisuEb(session);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }
        sz = dao.findFive();
        System.out.println("当前" + sz[0].getIssue());
        System.out.println("返回" + addIssue[0]);
        if (addIssue[0].equals(String.valueOf(sz[0].getIssue()))) {
            Set<Integer> set = new HashSet<Integer>();
            List<Integer> weiList = new ArrayList<Integer>();
            w1 = sz[4].getResult() % 10;
            w2 = sz[3].getResult() % 10;
            w3 = sz[2].getResult() % 10;
            w4 = sz[1].getResult() % 10;
            w5 = sz[0].getResult() % 10;
            weiList.add(w1);
            weiList.add(w2);
            weiList.add(w3);
            weiList.add(w4);
            weiList.add(w5);
            System.out.print(sz[0].getTime() + ":  " + w1 + "  " + w2 + "  "
                    + w3 + "  " + w4 + "  " + w5);
            set.addAll(weiList);
            // 正向
            for (Integer i : set) {

                if (i < 8) {
                    zmZuizhong[i] = touzhu28[i];
                    zmZuizhong[i + 10] = touzhu28[i + 10];
                    zmZuizhong[i + 20] = touzhu28[i + 20];
                } else {
                    zmZuizhong[i] = touzhu28[i];
                    zmZuizhong[i + 10] = touzhu28[i + 10];
                }
            }

            // //反向
            // for (int i = 0; i < 10; i++) {
            // if( !set.contains(i)) {
            // if( i < 8 ) {
            // zmZuizhong[i] = touzhu28[i];
            // zmZuizhong[i+10] = touzhu28[i+10];
            // zmZuizhong[i+20] = touzhu28[i+20];
            // } else {
            // zmZuizhong[i] = touzhu28[i];
            // zmZuizhong[i+10] = touzhu28[i+10];
            // }
            // }
            // }

            System.out.println("");
            System.out.print("投注   ");
            for (int i = 0; i < zmZuizhong.length; i++) {
                if (zmZuizhong[i] == null) {
                    zmZuizhong[i] = "0";
                }
                System.out.print(zmZuizhong[i] + " ");
            }
            System.out.println(addIssue[1] + " ");
            try {
                // 投注
                ss = gebi.keepsessionPost(
                        "http://vip.geibi.net/game/doinsert.aspx?xJB=0",
                        session, addIssue[1], zmZuizhong,
                        "http://vip.geibi.net/game/luck28/index.aspx", "8");
                ss = ss.substring(ss.indexOf(":") + 1, ss.indexOf(","));
                System.out.println("投注结果:" + ss);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {

                e.printStackTrace();
            }

        } else {
            System.out.println("添加期数有误");
        }

        return ss;

    }







    // 单投急速28-50期概率
    public static String dantouPK10Gj() {

        DouWanDAO dao = new DouWanDAO();
        DouwanHtml gebi = new DouwanHtml();
        String ss1 = "";
        try {
            ss1 = gebi.keepsession(
                    "http://vip.geibi.net/game/gj10/index.aspx?pid=" + 1,"",
                    session, "http://vip.geibi.net/game/gj10/index.aspx");
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Document doc1 = Jsoup.parse(ss1);
        String coin = doc1.select("a").get(2).text();
        coin = coin.replace(",", "");
        Element trs1 = doc1.select("div.warp1000").get(4);

        Elements tr1_last = trs1.select("li").eq(6);
        String thisissue_last = tr1_last.select("span").eq(0).text();
        Element a_last = tr1_last.select("span").eq(2).first();

        Element a5_ = a_last.select("a").eq(4).first();
        String a5 = a5_.attr("style");
        a5 = a5.substring(a5.lastIndexOf("/") + 1, a5.lastIndexOf("."));

        Element a2_ = a_last.select("a").eq(1).first();
        String a2 = a2_.attr("style");
        a2 = a2.substring(a2.lastIndexOf("/") + 1, a2.lastIndexOf("."));

        Element a6_ = a_last.select("a").eq(5).first();
        String a6 = a6_.attr("style");
        a6 = a6.substring(a6.lastIndexOf("/") + 1, a6.lastIndexOf("."));

        Element a7_ = a_last.select("a").eq(6).first();
        String a7 = a7_.attr("style");
        a7 = a7.substring(a7.lastIndexOf("/") + 1, a7.lastIndexOf("."));

        System.out.println(a2 + " " + a5 + " " + a6 + " " + a7 + " ");
        System.out.println("上期:" + thisissue_last);

        Elements tr1 = trs1.select("li").eq(5);
        String thisissue = tr1.select("span").eq(0).text();
        Element qihao = tr1.select("a").eq(0).first();
        String issueString = qihao.attr("href");
        issueString = issueString.substring(issueString.indexOf("=") + 1);
        System.out.println("当前:" + thisissue + " 投注期号:" + issueString);

        String[] toupkZuizhong = new String[11];
        for (int i = 1; i < 11; i++) {
            if (i == Integer.valueOf(a2) || i == Integer.valueOf(a5)
                    || i == Integer.valueOf(a6) || i == Integer.valueOf(a7)) {
                toupkZuizhong[i] = "0";
            } else {
                toupkZuizhong[i] = touzhuPK10[i];
            }
        }
        // 投注
        try {
            String ss = gebi.keepsessionPostPK10(
                    "http://vip.geibi.net/game/doinsert.aspx?xJB=0", session,
                    issueString, toupkZuizhong);
            ss = ss.substring(ss.indexOf(":") + 1, ss.indexOf(","));
            System.out.println("投注结果:" + ss);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    // 投注PC
    public String touPc(String pcsession, String tou[], String pcissue,
                        String rel) {

        // AddGeiBiService addService = new AddGeiBiService();
        DouwanHtml gebi = new DouwanHtml();
        String ss = "-1";
        try {
            ss = gebi.keepsessionPost(
                    "http://vip.geibi.net/game/doinsert.aspx?xJB=0", pcsession,
                    pcissue, tou, rel, "8");
            ss = ss.substring(ss.indexOf(":") + 1, ss.indexOf(","));

            return ss;
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }

    // 投注PC
    public String tou16(String pcsession, String tou[], String pcissue,
                        String rel) {

        // AddGeiBiService addService = new AddGeiBiService();
        DouwanHtml gebi = new DouwanHtml();
        String ss = "-1";
        try {
            ss = gebi.keepsessionPost16(
                    "http://vip.geibi.net/game/doinsert.aspx?xJB=0", pcsession,
                    pcissue, tou, rel);
            ss = ss.substring(ss.indexOf(":") + 1, ss.indexOf(","));

            return ss;
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }

    // 投注加拿大28
    public void touJndeb(String pcsession, String tou[], String pcissue,
                         String rel) {

        // AddGeiBiService addService = new AddGeiBiService();
        DouwanHtml gebi = new DouwanHtml();
        String ss = "-1";
        try {
            ss = gebi.keepsessionPost(
                    "http://vip.geibi.net/game/doinsert.aspx?xJB=0", pcsession,
                    pcissue, tou, rel, "8");
            ss = ss.substring(ss.indexOf(":") + 1, ss.indexOf(","));
            System.out.println("投注结果" + ss);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 投注加拿大16
    public void touJndsl(String pcsession, String tou[], String pcissue,
                         String rel) {

        // AddGeiBiService addService = new AddGeiBiService();
        DouwanHtml gebi = new DouwanHtml();
        String ss = "-1";
        try {
            ss = gebi.keepsessionPost(
                    "http://vip.geibi.net/game/doinsert.aspx?xJB=0", pcsession,
                    pcissue, tou, rel, "8");
            ss = ss.substring(ss.indexOf(":") + 1, ss.indexOf(","));
            System.out.println("投注结果" + ss);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 五期结果
    public void getWuQI_Jseb(String time) throws ParseException {

        DouWanDAO dao = new DouWanDAO();
        List<DouWan> list = dao.findResultLast(time);
        Map<String, Integer> map = new HashMap<String, Integer>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeString = time.substring(0, 10) + " 23:59:59"; // 输入的起始日
        java.util.Date date = df1.parse(timeString);
        Calendar dayCal = Calendar.getInstance();
        dayCal.setTime(date);
        java.util.Date dayDate = dayCal.getTime();

        int flat = 0;
        int zq_ = 0;
        int yin_z = 0;
        int yin_t = 0;

        Set<Integer> set = new HashSet<Integer>();
        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        int w4 = 0;
        int w5 = 0;
        DouWan last1 = null;
        DouWan last2 = null;
        DouWan last3 = null;
        DouWan last4 = null;
        DouWan last5 = null;
        DouWan kleb = null;

        for (int k = 0; k < list.size(); k++) {
            flat++;
            if (k == 0) {
                last1 = list.get(k);
                continue;
            } else if (k == 1) {
                last2 = list.get(k);
                continue;
            } else if (k == 2) {
                last3 = list.get(k);
                continue;
            } else if (k == 3) {
                last4 = list.get(k);
                continue;
            } else if (k == 4) {
                last5 = list.get(k);
                continue;
            } else if (k > 4) {
                List<Integer> weiList = new ArrayList<Integer>();
                kleb = list.get(k);
                w1 = last1.getResult() % 10;
                w2 = last2.getResult() % 10;
                w3 = last3.getResult() % 10;
                w4 = last4.getResult() % 10;
                w5 = last5.getResult() % 10;
                weiList.add(w1);
                weiList.add(w2);
                weiList.add(w3);
                weiList.add(w4);
                weiList.add(w5);
                System.out.print(kleb.getIssue() + "  " + w1 + "  " + w2 + "  "
                        + w3 + "  " + w4 + "  " + w5);
                set.addAll(weiList);
                int t = kleb.getResult() % 10;
                if (weiList.contains(t)) {
                    zq_++;
                    int size = set.size() * 100;
                    int t11 = 1000 - size;
                    System.out.print(" " + t + "  set: " + set.size() + "  y "
                            + t11);
                    yin_z += t11;
                    yin_t += t11;
                } else {
                    yin_z += -1 * set.size() * 100;
                    yin_t += -1 * set.size() * 100;
                    System.out.print("              " + set.size() * 100 * -1);
                }
                System.out.println("");
                set.clear();

                Timestamp today = kleb.getTime();

                int ct = today.compareTo(dayDate);
                if (ct > 0) {
                    map.put(df.format(dayDate), yin_t);
                    yin_t = 0;
                    dayCal.add(Calendar.DATE, 1);
                    dayDate = dayCal.getTime();
                } else if (k == list.size() - 1) {
                    map.put(df.format(today), yin_t);
                }

            }
            last1 = last2;
            last2 = last3;
            last3 = last4;
            last4 = last5;
            last5 = kleb;
        }
        System.out.println("共" + list.size() + "条记录");
        float pj = (float) zq_ / list.size();
        float zql = (float) (Math.round(pj * 100)) / 100;
        System.out.println("准确比例:" + zql);
        System.out.println("总盈利:" + yin_z);

        // 升序排序
        List<Map.Entry<String, Integer>> list1 = new ArrayList<Map.Entry<String, Integer>>(
                map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1,
                               Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Map.Entry<String, Integer> mapping : list1) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }

    }

    public static String[] touType(int type) {

        String[] ss = touzhu28_z;
        switch (type) {
            case 1:
                ss = touzhu28_d;
                break;
            case 2:
                ss = touzhu28_x;
                break;
            case 3:
                ss = touzhu28_z;
                break;
            case 4:
                ss = touzhu28_b;
                break;
            case 5:
                ss = touzhu28_j;
            case 6:
                ss = touzhu28_o;
                break;
            default:
                break;
        }
        return ss;

    }

    public static void main(String args[]) throws URISyntaxException, ClientProtocolException, InterruptedException, IOException, ParseException {

        AddDouWanService service = new AddDouWanService();
        // service.addErba("duobay%2Ecn=710644; ASPSESSIONIDQSQDAABD=DILBGEACOPFGAIPEFPIMGMMA; CurGetCode=8640; user%5Flogin%5Fcowwwies=2013080311314530731; Duobay%2EcnLogin=710644%2Cbe061492563abbe740c1937b991ef7b1; pageeasy7_2132_sid=YMBgBk; zSR7_2132_lastact=1482157877%09home.php%09misc; CNZZDATA1253756768=1437384693-1482154156-http%253A%252F%252Fwww.yuce28.com%252F%7C1482154156";
        String session ="Hm_lvt_838220786a21d838ea5d27656b5c12f5=1494791054,1495331655; PHPSESSID=8glgvce0036j33sh3roggclgm5;Hm_lpvt_838220786a21d838ea5d27656b5c12f5=1495331706";
        // {"1","3","6","10","15","21","28","36","45","55","63","69","73","75","75","73","69","63","55","45","36","28","21","15","10","6","3","1"};
        // String zmTouzhu[] =
        // {"5","15","30","50","75","105","125","135","135","125","105","75","50","30","15","5"};
        // service.peilv("ASPSESSIONIDSSSDRSAB=MDNNOGBBDPEOEKIEKDJIIMJK;CurGetCode=1460;Duobay%2EcnLogin=710644%2Cbe061492563abbe740c1937b991ef7b1;duobay%2Ecn=710644;Visit%5Fips=0%2E116%2E25%2E213%2E104;lzstat_ss=2644485541_34_1401651001_3002425;lzstat_uv=38492509241920976789|3002425;pageeasy=on;user%5Flogin%5Fcookies=2014060118195118231;",1);
        // String s[] = service.getBj16(session);

        // service.tou16(session,zmTouzhu,"1921772");
        // service.addKlerbaLs(session);
        // service.dantouKleb();
        //service.dantouJseb5();
        //service.dantouJseb2();
        //service.addJisuEb(session);
        service.addJndebByYuce(session);
        //service.getJnd28Peilv(session);
        // PcDandanDAO pcDandanDAO = new PcDandanDAO();
        // String dan_issue = service.addPcErba(session);
        // service.addJisuPeilv(session);
        // service.getBj16(session);
        // service.addJisuEb(session);
        // service.getJnd28Peilv(session);
        // service.getJnd28Peilv(session);
        // AddGeiBiService.dantouPK10Gj();
        // service.getJnd16Peilv(session);
        // String ss = service.dantouJseb2();
        //String[] peilv = {"995.0030", "331.6647", "165.8338", "99.4994", "66.3335", "47.3806", "35.5358", "27.6387", "22.1111", "18.0908", "15.7937", "14.4202", "13.6301", "13.2665", "13.2667", "13.6301", "14.4203", "15.7936", "18.0909", "22.1110", "27.6389", "35.5356", "47.3810", "66.3332", "99.5003", "165.8331", "331.6676", "994.9991", "860608", "0", "860608"};
        //service.getPeilvMAX(peilv);

    }


    public List<Map.Entry<String,Float>> getPeilvMAX(String[] peilv){

        Map<String,Float> maoMap = new HashMap<String, Float>();
        for (int i = 0; i < 28; i++) {
            float  f1 = Float.valueOf(peilv[i]);
            float  f2 = Float.valueOf(biaopei[i]);
            maoMap.put(String.valueOf(i), Math.abs((f1-f2))/f2);
        }
        List<Map.Entry<String,Float>> mappingList = null;


        mappingList = new ArrayList<Map.Entry<String,Float>>(maoMap.entrySet());

        Collections.sort(mappingList, new Comparator<Map.Entry<String,Float>>(){
            public int compare(Map.Entry<String,Float> mapping1,Map.Entry<String,Float> mapping2){
                return mapping1.getValue().compareTo(mapping2.getValue());
            }
        });

        for(Map.Entry<String,Float> mapping:mappingList){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
        return mappingList;
    }

    public void bu(List<Map.Entry<String,Float>> mapLists ,String[] zuizhong,float sum1,float sum){

        for (int i = 13; i > -1; i--) {
            if(sum1 <= sum){
                int j1 = Integer.valueOf(mapLists.get(i).getKey());
                zuizhong[j1]  = String.valueOf(Integer.valueOf(touzhu28[j1])/10);
                sum1 += Float.valueOf(zuizhong[j1]);
            }
        }

        for (String string : zuizhong) {
            System.out.print(string+" ");
        }

    }



}