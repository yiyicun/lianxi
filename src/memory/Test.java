package memory;

public class Test {

    public static void main(String[] args) {
        long start = Runtime.getRuntime().freeMemory();
        System.out.println(start);
        String[] a = new String[100000000];
        for (int i = 0; i < a.length; i++) {
             a[i] = "1111";
        }
        long end = Runtime.getRuntime().freeMemory();
        System.out.println(end);
        System.out.println(  (start-end)/1024/1024);
    }
}
