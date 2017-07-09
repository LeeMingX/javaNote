/**
 * Created by lxghost on 2017/7/9.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            method2();
        }
    }

    static void method1() {
        try {
            System.out.println("进入方法1");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("进入方法1的finally");
        }
    }

    static void method2() {
        try {
            System.out.println("进入方法2");
            return;
        } finally {
            System.out.println("进入方法2的finally");
        }
    }
}
