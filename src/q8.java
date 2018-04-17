/**
 * 实现 atoi，将字符串转为整数。

 在找到第一个非空字符之前，函数需尽可能移除掉空格字符。然后从这个非空字符开始，选取一个可选的正号或负号，并将正号或负号与后面尽可能多的连续的数字组合起来，这部分字符即为数字的值。

 字符串可以在形成整数数字的字符后面包括多余的非数字字符，将这些字符忽略，这些对于函数没有影响。

 如果字符串中的第一个非空字符不是有效的整数，字符串为空，或字符串仅包含空白字符，则不进行转换。

 如果不能执行有效的转换，则返回 0。

 说明：

 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。

 示例 1:

 输入: "42"
 输出: 42
 示例 2:

 输入: "   -42"
 输出: -42
 解释: 第一个非空白字符为 '-', 它是一个负号。
 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 示例 3:

 输入: "4193 with words"
 输出: 4193
 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 示例 4:

 输入: "words and 987"
 输出: 0
 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 因此无法执行有效的转换。
 示例 5:

 输入: "-91283472332"
 输出: -2147483648
 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 因此返回 INT_MIN (−2^31) 。
 */
public class q8 {
    public static int myAtoi(String str) {
        long result;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= '0') && (c <= '9')){
                sb.append(c);
            }else if (c == '-' && sb.length() == 0){
                sb.append(c);
            }else if (c == '+' && sb.length() == 0){
                sb.append(c);
            }else if ((c == ' ') && (sb.length() == 0)){
                continue;
            }else {
                break;
            }
        }
        if (sb.length() == 0){
            return 0;
        }else {
            if (sb.length() > 11){
                return sb.charAt(0)=='-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (sb.length() == 1 && (sb.charAt(0) == '-' || sb.charAt(0) == '+')){
                return 0;
            }
            result = Long.valueOf(sb.toString());
        }
        if (result > Integer.MAX_VALUE){
            result = Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        String s1 = "   - 321";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
    }
}
