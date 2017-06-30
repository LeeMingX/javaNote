import java.util.Arrays;

/**
 * Created by lxghost on 2017/6/30.
 */
public class ClassTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "小花";
        person.age = 15;
        person.sex = 1;

        person.study();
        person.showAge();
        person.addAge();
        person.showAge();

        Circle aCircle = new Circle();
        aCircle.radius = 3;
        System.out.println("This circle's area is " + Math.round(aCircle.calCircleArea()));

        int[] testArray = {3, 5, 13, 2, 4, 6};
        ArrayUtil au = new ArrayUtil();
        int[] sortedArray = au.sortArray(testArray);
        int[] reversedArray = au.reverse(testArray);
        double sum = au.avg(testArray);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
        System.out.println(sum);

    }
}

class Person {
    String name;
    int age;
    int sex;

    public void study() {
        System.out.println("studying");
    }

    public void showAge() {
        System.out.println(age);
    }

    public int addAge() {
        return age += 2;
    }
}

class Circle {
    double radius;

    public double calCircleArea() {
        double result = Math.PI * Math.pow(radius,2);
        return result;
    }
}

class ArrayUtil {
//    求数组的最大值
    public int getMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max)
                max = i;
        }
        return max;
    }
//    求数组的最小值
    public int getMin(int[] arr) {
        int min = 0;
        for (int i : arr) {
            if (i < min)
                min = i;
        }
        return min;
    }
//    遍历数组元素
    public void printArray(int[] arr) {
        System.out.println("数组中包含元素：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
//    求数组的平均数
    public double avg(int[] arr) {
        double sum = getSum(arr);
        return sum/arr.length;
    }
//    求数组的总和
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
//    数组的反转
    public int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1];
            arr[arr.length-1] = temp;
        }
        return arr;
    }
//    实现数组的复制
    public int[] arrayCopy(int[] arr) {
        int[] copiedArray = new int[arr.length];
        System.arraycopy(arr, 0, copiedArray, 0, arr.length);
        return copiedArray;
    }
//    对数组进行排序
    public int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}