package niuke.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//HJ2 计算某字符出现次数
//描述
//        写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
//
//        数据范围： 1 \le n \le 1000 \1≤n≤1000
//        输入描述：
//        第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
//
//        输出描述：
//        输出输入字符串中含有该字符的个数。（不区分大小写字母）
public class HJ2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();// 读第一行
        char[] chars = str.toLowerCase().toCharArray();
        char c = br.readLine().toLowerCase().charAt(0);
        int count = 0;
        for(char cTmp:chars){
            if(c == cTmp ){
                count++;
            }
        }
        System.out.println(count);

    }
}
