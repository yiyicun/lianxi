package alg;

import java.util.Scanner;

//2、找出空格分割的字符串里，最大单词长度。例如：'this is a word'，结果为4。
public class Test2 {

    public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个数：");
            String str = scanner.next();
            String[] ss = str.split(" ");
            int[] strLenth =  new int[ss.length];
            for (int i = 0; i < ss.length; i++) {
                strLenth[i] = ss[i].length();
            }
            //最大长度
            int max = 0;
            for (int i = 0; i < strLenth.length; i++) {
                if(strLenth[i] > max) {
                    max = strLenth[i];
                }
            }
            System.out.println(max);

    }




}
