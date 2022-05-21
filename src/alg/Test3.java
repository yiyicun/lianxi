package alg;//3、合并两个从小到大排好序的数组，合并结果保持从小到大顺序。要求算法复杂度为O(m+n)。例如：[1, 3, 8]，[2, 3, 9]合并结果为：[1, 2, 3, 8, 9]

import java.util.Arrays;

public class Test3 {

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int[] a = new int[]{1,3,8};
        int[] b = new int[]{2,3,9};
        test3.merge(a,b);
    }


    public static void merge(int[] arr1, int[] arr2){

        int i = 0;
        int j = 0;
        int k = 0;
        int len = arr1.length + arr2.length;
        int[] arr = new int[len];
        while(i<arr1.length && j<arr2.length) {
            if(arr1[i]<=arr2[j]) {
                arr[k++] = arr1[i++];
            }else {
                arr[k++] = arr2[j++];
            }
        }
        if(i==arr1.length && j<arr2.length) {
            while(j<arr2.length) {
                arr[k++] = arr2[j++];
            }
        }
        if(j==arr2.length && i<arr1.length) {
            while(i < arr1.length) {
                arr[k++] = arr1[i++];
            }
        }
        String str = Arrays.toString(arr);
        System.out.println(str);

    }


}
