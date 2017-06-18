/**
 * Created by lxghost on 2017/6/18.
 */
public class BitOperation {
    public static void main(String[] args) {
        int m = 12;
        int n = 5;

        //不使用临时变量交换两个变量的值,m、n较大时，可能会超出取值范围
        m = m + n;
        n = m - n;
        m = m - n;
        System.out.println("m = " + m + " n = " + n);

        //没有缺点
        m = m^n;
        n = m^n;
        m = m^n;
        System.out.println("m = " + m + " n = " + n);

        //手动方式输出60的16进制
        int i = 1920;
        char[] digits = {
                '0', '1', '2', '3', '4', '5',
                '6', '7', '8', '9', 'a', 'b',
                'c', 'd', 'e', 'f'
        };
        String result = "";
        do {
            if (i <= 16) {
                result = Character.toString(digits[i]) + result;
                break;
            }
            int remainder = i % 16;
            i >>= 4;
            result = Character.toString(digits[remainder]) + result;
        } while (true);

        //60的二进制形式可以通过按位与操作提取出4位
        System.out.println((char)('a' + 2));
        String testNumber = toManualHexString(1920);
        String testNumber2 = toManualOctalString(1920);

        System.out.println("i的16进制形式为：" + "0x" + testNumber);
        System.out.println("i的8进制形式为：" + testNumber2);
    }

    /*
    * 一个数的二进制形式，可以用按位与运算提取特定的位数
    * 例如：3 -> 0110。提取后两位可以和0011做按位与运算：
    * 0110 & 0011 = 0010
    * 按照这个规律可以计算一个数的16进制
    * 同理可以计算一个数的8进制
    * */
    static String toManualHexString(int num) {
        String result = "";
        do {
            int remainder = num & 15;
            if(remainder < 9) {
                result = Integer.toString(remainder) + result;
            } else {
                result = Integer.toString(remainder-10+'a') + result;
            }
            num >>= 4;
        } while (num != 0);
        return result;
    }

    static String toManualOctalString(int num) {
        String result = "";
        do {
            int remainder = num & 7;
            result = Integer.toString(remainder) + result;
            num >>= 3;
        } while (num != 0);
        return result;
    }
}
