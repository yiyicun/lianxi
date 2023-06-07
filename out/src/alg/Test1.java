package alg;

import java.util.Scanner;
//1、把一个整数的每一位找出来，放数组里。例如；12465的结果为[1，2，4，6，5]
public class Test1 {

    public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个数：");
            int a = scanner.nextInt();
            String str = String.valueOf(a);
            int[] array = new int[str.length()];
            char[] ch = str.toCharArray();
            for (int i = ch.length - 1; i >= 0; i --){
                array[i] = ch[i]-48;
            }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }




}
