import java.util.Scanner;

/**
 * 一个完整的括号字符串定义规则如下:
 * 1、空字符串是完整的。
 * 2、如果s是完整的字符串，那么(s)也是完整的。
 * 3、如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
 * 例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")"是不完整的括号字符串。
 * 牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化为一个完整的括号字符串。请问牛牛至少需要添加多少个括号。
 */

public class q20170303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int num = minAddCharNum(input);
        System.out.println(num);
    }

    private static int minAddCharNum(String input) {
        int num = 0;
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == '(') sb.append('(');
            else if (input.charAt(i) == ')'){
                if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
                else num++;
            }
        }
        if (sb.length() != 0) num += sb.length();
        return num;
    }
}
