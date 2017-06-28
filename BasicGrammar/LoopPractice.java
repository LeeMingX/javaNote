import java.util.Scanner;

/**
 * Created by lxghost on 2017/6/19.
 */
public class LoopPractice {
    public static void main(String[] args) {
//      输出100以内的所有偶数以及偶数之和以及偶数的个数
        /*
        int sum = 0, count = 0;
        for (int i = 2; i <=100; i += 2) {
            System.out.println(i);
            sum += i;
            count++;
        }
        System.out.println("100以内所有偶数之和为：" + sum);
        System.out.println("100以内所有偶数个数为：" + count);
        */
//      从1循环到150，3的倍数打印"foo"，5的倍数打印"biz"，7的倍数打印"baz"
        /*
        for (int i = 1; i <= 150; i++) {
            System.out.print(i + " ");
            if (i%3 == 0)
                System.out.print("foo ");
            if (i%5 == 0)
                System.out.print("biz ");
            if (i%7 == 0)
                System.out.print("baz ");
            System.out.print("\n");
        }
        */
//      打印1～100之间所有奇数的和
        /*
        int sum = 0;
        for (int i = 1; i <= 100; ++i) {
            if (i%2 != 0)
                sum += i;
        }
        System.out.print("1～100之间所有奇数的和:" + sum);
        */
//      打印所有的水仙花数
        /*
        for (int i = 100; i < 1000; ++i) {
            int hundred, ten, single;
            hundred = i/100;
            single = i%10;
            ten = i%100/10;
            if (i == (int)(Math.pow(hundred,3)+Math.pow(ten,3)+Math.pow(single,3)))
                System.out.println(i);
        }
        */
//      键盘读入个数不确定的整数，输出读入的正数和负数的个数
        /*
        Scanner s = new Scanner(System.in);
        System.out.println("输入一个整数：");
        int input = s.nextInt();
        int num = 0,negativeNum = 0;
        while (input != 0) {
            if (input > 0)
                num++;
            if (input < 0)
                negativeNum++;
            input = s.nextInt();
        }
        System.out.println("输入的正数个数：" + num);
        System.out.println("输入的负数个数：" + negativeNum);

        s.close();
        */
//      九九乘法表
        /*
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i*j + "\t");
            }
            System.out.println();
        }
        */
//      1~100中的所有质数
        /*
        优化思路1：只要有一个数可以整除就跳出循环
        优化思路2：只需要除到√i即可
        可以使用带标签的中断循环关键字

        long start = System.currentTimeMillis();
        loop:for (int i = 1; i <= 100; i++) {
            int j = 1;
            while ((double)j < Math.pow(i, 0.5)) {
                if (i%j == 0 && j != 1)
                    continue loop;
                j++;
            }
            if (j > Math.pow(i, 0.5) && j != 1)
                System.out.print(i + " ");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.print("耗时：" + time);
        */
//      打印两个数的最大公约数和最小公倍数
        /*
        int i = 12, j = 18;
        int remainder, result;
        do {
            remainder = j%i;
            if (remainder == 0) {
                result = i;
                System.out.println("最大公约数是：" + result);
            } else {
                remainder = j%i;
                j = i;
                i = remainder;
            }
        } while (remainder != 0);

        System.out.println("最小公倍数是：" + (18+12)/result);
        */
    }

}
