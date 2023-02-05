package jvm;

public class Intern {
    public static void main(String[] args) {
        Intern intern = new Intern();
        //intern.test07();
        intern.test09();
        // intern.test04();
        // intern.test05();
    }

    void test03() {
        StringBuilder s1 = new StringBuilder("xyz");
        String s2 = s1.toString().intern();
        String s3 = "xyz";
        System.out.println(s2 == s3); // true
    }

    void test04() {
        StringBuilder s1 = new StringBuilder("xyz");
        String s2 = s1.toString();
        String s3 = "xyz";
        System.out.println(s2 == s3); // false
    }

    /* new String之后使用 + 在Java中会进行编译优化，编译成字节码指令后，会将 + 优化成 先new Stringbuilder对象，然后调用append方法进行拼接。
     * 因此这里s1最终创建的时候，xyzz字符串并没有在常量池创建，只是在堆中创建了，因为就如同上面的test03()一样，是new Stringbuilder操作。
     * 所以在调用intern操作后，将其堆中的引用放入常量池并返回。
     * 所以后面的结果都是true，因为至始至终都是堆中的一个对象。
     */
    void test05() {
        String s1 = new String("xyz") + new String("z");
        String s2 = s1.intern();
        String s3 = "xyzz";
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // true
        System.out.println(s2 == s3); // true
    }

    void test07() {
        String s1 = new String("xyz") + new String("z");
        String s2 = "xyzz";
        s1.intern();
        System.out.println(s1 == s2); // false
    }

    void test08() {
        String s1 = new String("xyz") + new String("z");
        s1.intern();
        String s2 = "xyzz";
        System.out.println(s1 == s2); // false
    }

    void test09() {
        String s1 = new String("xyz") + new String("z");
        s1.intern();
        String s2 = "xyzz";
        System.out.println(s1 == s2); // false
        s1 = s1.intern();
        System.out.println(s1 == s2); // true
    }

}
