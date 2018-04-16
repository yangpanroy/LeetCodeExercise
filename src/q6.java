/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：（下面这样的形状）

 P   A   H   N
 A P L S I I G
 Y   I   R
 之后按逐行顺序依次排列："PAHNAPLSIIGYIR"



 实现一个将字符串进行指定行数的转换的函数:

 string convert(string text, int numRows);
 convert("PAYPALISHIRING", 3) 应当返回 "PAHNAPLSIIGYIR" 。
 */
public class q6 {
    public static String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer(); //根据numRows为每一行新建一个stringBuffer

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // 记录垂直下降的字符串
                sb[idx].append(c[i++]);
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) // 记录倾斜上升的字符串（注意是从下往上）
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]); //将记录到的字符串合并在一起并返回
        return sb[0].toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}
