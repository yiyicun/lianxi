package alg;

import java.util.Scanner;
//把给定数字进行质因式分解，例如：数字6分解结果为2*3。
public class Test4 {

    public static void main(String[] args) {
        /**
         * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
         *
         * 实现思路
         * 1.输入一个正整数，判断是否合格数据，不合格继续让用户输入
         * 2.用循环求它的质因数，找到打印输出
         */

        //1.输入一个正整数，判断是否合格数据，不合格继续让用户输入
        Scanner input = new Scanner(System.in);

        //提示用户输入
        System.out.println("请输入一个大于2的正整数");

        int num = input.nextInt();

        //判断是否合格数据，不合格继续让用户输入
        while(num<=2) { //20
            System.out.println("输入错误，请重新输入一个大于2的正整数");
            num=input.nextInt();
        }

        //如果是一个素数(质数)  //方法
        while(isPrimeNumber(num)==true) {
            System.out.println("输入错误，"+num+"是一个素数，请重新输入一个大于2的非素数的正整数");
            num=input.nextInt();
        }


        //2.用循环求它的质因数，找到打印输出
        System.out.print(num+"=");
        int halfnum = num/2; //10
        for (int i = 2; i <= halfnum; i++) {
            if(num>i) {
                if(num%i==0) {
                    System.out.print(i+"*");
                    num = num/i;
                    i--;
                    continue;
                }
            }
            else {
                System.out.print(i);
                break;
            }
        }
    }

    /**
     * 判断是否是一个素数
     * @param num
     * @return
     */
    public static boolean isPrimeNumber(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0)
                return false;
        }
        return true;

    }

}
