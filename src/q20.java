/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */

public class q20 {
    public static void main(String[] args) {
        String s1 = "]";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        System.out.println(isValid(s1) ? "True" : "False");
        System.out.println(isValid(s2) ? "True" : "False");
        System.out.println(isValid(s3) ? "True" : "False");
        System.out.println(isValid(s4) ? "True" : "False");
        System.out.println(isValid(s5) ? "True" : "False");
    }

    public static boolean isValid(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') builder.append(s.charAt(i));
            else if (s.charAt(i) == ')'){
                if (builder.length() == 0) return false;
                if (builder.charAt(builder.length()-1) != '(') return false;
                else builder.deleteCharAt(builder.length()-1);
            }else if (s.charAt(i) == ']'){
                if (builder.length() == 0) return false;
                if (builder.charAt(builder.length()-1) != '[') return false;
                else builder.deleteCharAt(builder.length()-1);
            }else if (s.charAt(i) == '}'){
                if (builder.length() == 0) return false;
                if (builder.charAt(builder.length()-1) != '{') return false;
                else builder.deleteCharAt(builder.length()-1);
            }
        }
        return builder.length() == 0;
    }
}
