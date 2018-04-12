/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 长度最长为1000。

 示例:

 输入: "babad"

 输出: "bab"

 注意: "aba"也是有效答案


 示例:

 输入: "cbbd"

 输出: "bb"
 */
public class q5 {
    public static String longestPalindrome(String s) {
        // 本题思路是遍历字符串，以每个字符为中心，向外镜像寻找回文字符串（如aba、abcba等）
        // 或者以两字符间隙为中心，向外寻找回文字符串（如aa、abba）
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //遍历字符串
            int len1 = expandAroundCenter(s, i, i); //以每个字符为中心，向外镜像寻找回文字符串，返回这个中心的最长回文字符串长度
            int len2 = expandAroundCenter(s, i, i + 1); //以两字符间隙为中心，向外寻找回文字符串，返回这个中心的最长回文字符串长度
            int len = Math.max(len1, len2);
            if (len > end - start) {
                //记录当前最长回文字符串起止索引
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            //左右扩展寻找最长回文子串
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
    }
}
