import java.util.Scanner;

/**
 * Created by lxghost on 2017/6/28.
 */
public class ArrayTest {
    public static void main(String[] args) {

        /*
        定义类Pritimive，在类中定义一个有3个元素的boolean类型的数组t作为其成员变量
        数组元素未赋值
        定义类Array1，在Array1的main()方法中创建Pritimive对象d，输出其成员变量t的三个元素值
        给对象d的成员变量t赋值为(true, true, true)，并输出t的三个元素值
         */
        Pritimive d = new Pritimive();

        for (int i = 0; i < d.t.length; i++) {
            d.t[i] = true;
//            System.out.println(d.t[i]);
        }

        for (int i = 0; i < d.t.length; i++) {
            System.out.println(d.t[i]);
        }
        /*
        定义类Student，包含三个属性：学号number(int),年级state(int),成绩score(int)
        创建20个学生对象，学号为1-20。年级和成绩都由随机数确定，打印出3年级的学生信息
         */
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].number = i + 1;
            students[i].state = (int) Math.ceil(Math.random()*3);
            students[i].score = (int) Math.ceil(Math.random()*100);
        }

        for (Student i : students) {
            if (i.state == 3)
                System.out.println("学生学号为：" + i.number + " 学生年级为：3 学生成绩为：" + i.score);
        }

        /*
        从键盘读入学生成绩，找出最高分，并输出学生等级
        成绩>=最高分-10 'A'
        成绩>=最高分-20 'B'
        成绩>=最高分-30 'C'
        其余 'D'
         */
        /*
        int num, maxGrade = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生人数：");
        num = sc.nextInt();
        Student[] students1 = new Student[num];

        for (int i = 0; i < students1.length; i++) {
            students1[i] = new Student();
            System.out.print("请输入第" + (i+1) + "个同学的成绩:");
            students1[i].number = i + 1;
            students1[i].score = sc.nextInt();
            maxGrade = (maxGrade >= students1[i].score) ? maxGrade : students1[i].score;
        }
        sc.close();

        System.out.println("最高成绩是：" + maxGrade);
        for (int i = 0; i < students1.length; i++) {
            if (students1[i].score >= maxGrade - 10)
                System.out.println("student " + students1[i].number + " score is " +
                students1[i].score + " grade is A");
            else if (students1[i].score >= maxGrade - 20)
                System.out.println("student " + students1[i].number + " score is " +
                        students1[i].score + " grade is B");
            else if (students1[i].score >= maxGrade - 30)
                System.out.println("student " + students1[i].number + " score is " +
                        students1[i].score + " grade is C");
            else
                System.out.println("student " + students1[i].number + " score is " +
                        students1[i].score + " grade is D");
        }
        */

        /*
        获取arr数组中所有元素的和，使用for循环嵌套
        3，8，2
        2，7
        9，0，1，6
         */
        int[][] arr = {{3, 8, 2}, {2, 7}, {9, 0, 1, 6}};

        int sum = 0;
        for (int[] i : arr) {
            for (int j : i) {
                sum += j;
            }
        }

        System.out.println("arr数组中所有元素的和为：" + sum);

        /*
        打印杨辉三角
        1. 第一行有1个元素，第n行有n个元素
        2. 每一行的第一个元素和最后一个元素都是1
        3. 从第三行开始，对于非第一个元素和最后一个元素的元素：
        yanghui[i][j] = yanghui[i-1][j-1]+yanghui[i-1][j]
         */
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你要打印的杨辉三角行数：");
        int row = sc.nextInt();
        int[][] yh = new int[row][];

        for (int i = 0; i < yh.length; i++) {
            yh[i] = new int[i+1];
        }

        switch (row) {
            case 1:
                yh[0][0] = 1;
                break;
            case 2:
                yh[0][0] = 1;
                yh[1][0] = 1;
                yh[1][1] = 1;
                break;
            default:
                yh[0][0] = 1;
                yh[1][0] = 1;
                yh[1][1] = 1;
                for (int i = 2; i < row; i++) {
                    yh[i][0] = 1;
                    yh[i][i] = 1;
                    for (int j = 1; j < yh[i].length - 1; j++) {
                        yh[i][j] = yh[i-1][j-1] + yh[i-1][j];
                    }
                }
                break;
        }

        for (int[] i : yh) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
        */
        /*
        1. 声明array1和array2两个变量，它们都是int[]类型的数组
        2. 使用大括号，把array1初始化为8个素数。2，3，5，7，11，13，17，19
        3. 显示array1的内容
        4. 赋值array2变量等于array1，修改array2中的偶索引元素，使其等于索引值
        打印array1

        array1的反转
         */
        int[] array1 = {2, 3, 5, 7, 11, 13, 17, 19}, array2 = new int[8];
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
//        System.arraycopy(array1, 0, array2,0, array1.length);
//        array2 = array1.clone();

        for (int i = 0; i < array1.length/2; i++) {
            int temp;
            temp = array1[i];
            array1[i] = array1[array1.length - i - 1];
            array1[array1.length - i - 1] = temp;
        }

        for (int i : array1) {
            System.out.print(i + " ");
        }
    }
}

class Pritimive {
    boolean[] t = new boolean[3];
}

class Student {
    int number;
    int state;
    int score;
}
