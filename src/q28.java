/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

public class q28 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";
        System.out.println(strStr(s1, s2));
        s1 = "aaaaa";
        s2 = "bba";
        System.out.println(strStr(s1, s2));
        s1 = "";
        s2 = "";
        System.out.println(strStr(s1, s2));
        s1 = "";
        s2 = "a";
        System.out.println(strStr(s1, s2));
        s1 = "mississippi";
        s2 = "issipi";
        System.out.println(strStr(s1, s2));
        s1 = "mississippi";
        s2 = "pi";
        System.out.println(strStr(s1, s2));
    }

    public static int strStr(String haystack, String needle) {
        int result = 0;
        int idx_h = 0, idx_n = 0;
        int offset = 0;
        if (haystack.length() < needle.length()) return -1;
        while (idx_h + offset < haystack.length()) {
            if (offset == needle.length()) {
                result = idx_h;
                break;
            }
            if (haystack.charAt(idx_h + offset) == needle.charAt(idx_n + offset)) {
                offset++;
            } else {
                idx_h++;
                offset = 0;
                idx_n = 0;
            }
        }
        if (idx_h == haystack.length()) {
            result = -1;
            if (needle.length() == 0) {
                return 0;
            }
        }
        if (idx_n + offset < needle.length()) {
            return -1;
        }else if (idx_n + offset == needle.length()) {
            result = idx_h;
        }
        return result;
    }
}
