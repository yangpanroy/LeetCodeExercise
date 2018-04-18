import java.util.Scanner;

/**
 * 一个合法的括号匹配序列有以下定义:
 1、空串""是一个合法的括号匹配序列
 2、如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
 3、如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
 4、每个合法的括号序列都可以由以上规则生成。
 例如: "","()","()()","((()))"都是合法的括号序列
 对于一个合法的括号序列我们又有以下定义它的深度:
 1、空串""的深度是0
 2、如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y) 3、如果"X"的深度是x,那么字符串"(X)"的深度是x+1
 例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
 */
public class q20170103 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        String s = "(((((((()(()((()))))))))))";
        System.out.println(getDepth(s));
    }

    private static int getDepth(String s) {
        int depth = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') temp++;
            else {
                depth = Math.max(depth, temp);
                temp --;
            }
        }
        return depth;
    }
}
