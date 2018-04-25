import java.util.ArrayList;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。
 */
public class q14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length-1; i++) {
            int idx = 0, idx2 = 0;
            while (idx < strs[i].length() && idx2 < strs[i+1].length()){
                if (strs[i].charAt(idx) == strs[i+1].charAt(idx2)){
                    sb.append(strs[i].charAt(idx));
                }
                else break;
                idx++;
                idx2++;
            }
            strs[i] = sb.toString();
            strs[i+1] = sb.toString();
            sb = new StringBuilder();
        }
        return strs[strs.length-1];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
