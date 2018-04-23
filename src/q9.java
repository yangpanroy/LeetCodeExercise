import java.util.ArrayList;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 进阶:

 你能不将整数转为字符串来解决这个问题吗？
 */
public class q9 {
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return str.equals(sb.toString());
    }

    public static boolean isPalindrome2(int x) {
        //不使用字符串的方法
        if (x < 0) return false;
        else if (x < 10) return true;
        ArrayList<Integer> xarray = new ArrayList<>();
        int i = 0;
        while (x != 0){
            xarray.add(x % 10);
            x /= 10;
        }
        int len = xarray.size();
        i = 0;
        while (i <= len/2){
            if (xarray.get(i) != xarray.get(len - 1 - i)) return false;
            else i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int x1 = 121, x2 = -121, x3 = 10;
        System.out.println(isPalindrome2(x1) ? "True" : "False");
        System.out.println(isPalindrome2(x2) ? "True" : "False");
        System.out.println(isPalindrome2(x3) ? "True" : "False");
    }
}
