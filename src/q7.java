/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class q7 {
    public static int reverse(int x) {
        long result;
        String input = String.valueOf(x);
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = len-1; i >= 0 ; i--) {
            sb.append(input.charAt(i));
        }
        if (x >= 0){
            result = Long.valueOf(sb.toString());
        }else {
            result = Long.valueOf(sb.toString().substring(0, len-1)) * -1;
        }
        if ((result > Math.pow(2, 31) - 1) || (result < -1 * Math.pow(2, 31))){
            result = 0;
        }
        return (int) result;
    }

    public static int reverse2(int x){
        long result = 0;
        while (x > 0){
            int rmd = x % 10;
            result = result * 10 + rmd;
            x = x / 10;
        }
        if ((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE)){
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int x1 = 0;
        int x2 = -123;
        int x3 = 120;
        System.out.println(reverse2(x1));
        System.out.println(reverse(x2));
        System.out.println(reverse2(x3));
    }

}
