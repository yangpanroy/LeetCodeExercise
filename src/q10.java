/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

 '.' 匹配任意单个字符。
 '*' 匹配零个或多个前面的元素。
 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

 说明:

 s 可能为空，且只包含从 a-z 的小写字母。
 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 示例 1:

 输入:
 s = "aa"
 p = "a"
 输出: false
 解释: "a" 无法匹配 "aa" 整个字符串。
 示例 2:

 输入:
 s = "aa"
 p = "a*"
 输出: true
 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 示例 3:

 输入:
 s = "ab"
 p = ".*"
 输出: true
 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 示例 4:

 输入:
 s = "aab"
 p = "c*a*b"
 输出: true
 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 示例 5:

 输入:
 s = "mississippi"
 p = "mis*is*p*."
 输出: false
 */
public class q10 {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "a*a";
        System.out.println(isMatch(s, p) ? "True" : "False");
    }

    public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty(); //若通配符为空，则字符串为空返回true，字符串不空返回false
        //若通配符不为空
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        //若字符串不空，则将第一个符号进行匹配检测

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            //若*并不是通配符的最后一个符号
            return (isMatch(text, pattern.substring(2)) || //此处对应循环0次的情况
                    (first_match && isMatch(text.substring(1), pattern))); //此处对应循环多次的情况

        } else {
            //若*是通配符最后一个符号（最后一组循环）
            return first_match && isMatch(text.substring(1), pattern.substring(1));
            //检测第一个符号和递归检测后面符号
        }
    }
}
