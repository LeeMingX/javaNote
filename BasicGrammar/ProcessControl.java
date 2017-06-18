import java.util.Scanner;

/**
 * Created by lxghost on 2017/6/18.
 */
public class ProcessControl {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
/*
        表示从键盘获取一个字符串

        System.out.println("请输入小明的期末成绩：");
        int score = s.nextInt();
        if (score >= 0 && score <= 100) {
            if (score == 100)
                System.out.println("奖励一辆BMW");
            else if (score > 80)
                System.out.println("奖励一台iPhone5s");
            else if (score >= 60)
                System.out.println("奖励一本参考书");
            else
                System.out.println("奖励一句MMP");
        } else
            System.out.println("输入错误");
*/
/*
        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("输入一个整数：");
            num[i] = s.nextInt();
        }

        if (num[0] <= num[1]) {
            if (num[0] <= num[2]) {
                System.out.print(num[0] + " ");
                if (num[1] <= num[2])
                    System.out.print(num[1] + " " + num[2]);
                else
                    System.out.print(num[2] + " " + num[1]);
            } else
                System.out.println(num[2] + " " + num[0] + " " + num[1]);
        } else {
            if (num[0] > num[2]) {
                if (num[1] <= num[2])
                    System.out.println(num[1] + " " + num[2] + " " + num[0]);
                else
                    System.out.println(num[2] + " " + num[1] + " " + num[0]);
            } else
                System.out.println(num[1] + " " + num[0] + " " + num[2]);
        }
*/
/*
        float height = 0, wealth = 0;
        boolean isHandsome = true;
        System.out.println("身高（cm）：");
        height = s.nextFloat();
        System.out.println("财富（千万）：");
        wealth = s.nextFloat();
        System.out.println("相貌（帅true／不帅false）：");
        isHandsome = s.nextBoolean();
        if (height >= 180 && wealth >= 1 && isHandsome)
            System.out.println("嫁！");
        else if (height >= 180 || wealth >= 1 || isHandsome)
            System.out.println("可嫁！");
        else
            System.out.println("不嫁！");
        s.close();
*/
//      使用switch把小写类型的char转为大写，只转换a,b,c,d,e,其他输出"other"
/*
        System.out.println("输入字母：");
        String lowerCase = s.next();
        switch (lowerCase) {
            case "a":
                System.out.println("A");
                break;
            case "b":
                System.out.println("B");
                break;
            case "c":
                System.out.println("C");
                break;
            case "d":
                System.out.println("D");
                break;
            case "e":
                System.out.println("E");
                break;
            default:
                System.out.println("Other");
        }
*/
//      学生成绩大于60输出"合格"，低于60输出不合格
/*
        System.out.println("输入学生成绩：");
        int score = s.nextInt();
        if (score > 60)
            System.out.println("合格");
        if (score < 60)
            System.out.println("不合格");
*/
//      根据指定月份，打印该月份所属的季节
/*
        System.out.println("输入月份：");
        int month = s.nextInt();
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("非法输入");
        }
*/
//      输入2014年的"month"和"day"，输出日期为2014年的第几天
//      可以通过switch-case倒序累加来进行日期计算
        int year,month, day, sum = 0;
        System.out.println("请输入年份：");
        year = s.nextInt();
        System.out.println("请输入月份：");
        month = s.nextInt();
        System.out.println("请输入日：");
        day = s.nextInt();
        switch (month) {
            case 12:
                sum += 30;
                if (0 >= day && day > 31) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 11:
                sum += 31;
                if (0 >= day && day > 30) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 10:
                sum += 30;
                if (0 >= day && day > 31) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 9:
                sum += 31;
                if (0 >= day && day > 30) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 8:
                sum += 31;
                if (0 >= day && day > 31) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 7:
                sum += 30;
                if (0 >= day && day > 31) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 6:
                sum += 31;
                if (0 >= day && day > 30) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 5:
                sum += 30;
                if (0 >= day && day > 31) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 4:
                sum += 31;
                if (0 >= day && day > 30) {
                    System.out.println("输入的日期不合法");
                    break;
                }
            case 3:
                if (isLeapYear(year)) {
                    sum += 29;
                    if (0 >= day && day > 31) {
                        System.out.println("输入的日期不合法");
                        break;
                    }
                } else {
                    sum += 28;
                    if (0 >= day && day > 31) {
                        System.out.println("输入的日期不合法");
                        break;
                    }
                }

            case 2:
                sum += 31;
                if (isLeapYear(year)) {
                    if (0 >= day && day > 29) {
                        System.out.println("输入的日期不合法");
                        break;
                    }
                } else {
                    if (0 >= day && day > 28) {
                        System.out.println("输入的日期不合法");
                        break;
                    }
                }
            case 1:
                sum += day;
                if (0 >= day && day > 31) {
                    System.out.println("输入的日期不合法");
                    break;
                } else
                    System.out.println("这是2014年的第" + sum + "天");
                break;
            default:
                System.out.println("输入的日期不合法");
        }
        s.close();
    }

    static boolean isLeapYear(int year) {
        if (year%400 == 0 || (year%4==0&&year%100!=0))
            return true;
        else
            return false;
    }
}
