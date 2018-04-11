import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。

 示例：

 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 */
public class q3 {
    public static int lengthOfLongestSubstring(String s) {
        int j = 0, i = 0, ans = 0; //ans用于记录目前最长的子串长度
        int len = s.length();
        HashSet set = new HashSet<>();
        while (i<len && j<len){
            if (!set.contains(s.charAt(j))){
                //若未重复则加入到 hashset 中，右游标右移
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i); //比较并记录最长子串长度
            }else {
                set.remove(s.charAt(i)); //左游标右移
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }
}
