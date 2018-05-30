import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 2 : abc  3 : def  4 : ghi 5 : jkl  6 : mno  7 : pqrs  8 : tuv  9 : wxyz
 */

public class q17 {


    public static void main(String[] args) {
        String str = "23";
        System.out.print("[");
        for (String letter:letterCombinations(str)) {
            System.out.print("\"" + letter + "\", ");
        }
        System.out.print("]");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        // 这里采用递归的思想，将 digits 分为第一个数字和后面的部分，第一个数字进行查询哈希表操作，返回所有可能
        // 后面的部分递归调用本函数，直至后面部分为空字符串为止
        if (digits.length() == 0) {
            return result;
        }
        char firstLetter = digits.charAt(0);
        String latter = digits.substring(1);
        String currentStr = map.get(firstLetter);
        for (int i = 0; i < currentStr.length(); i++) {
            char currentLetter = currentStr.charAt(i);
            if (latter.length() != 0) {
                for (String latterSting : letterCombinations(latter)) {
                    result.add(currentLetter + latterSting);
                }
            } else {
                result.add(String.valueOf(currentLetter));
            }
        }
        return result;
    }
}
