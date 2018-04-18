import java.util.Scanner;

/**
 * 牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。牛牛想知道他最少需要涂染几个正方形。
 如样例所示: s = RGRGR
 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
 */
public class q20170101 {
    public static int minPaintNum(String s){
        int len = s.length();
        int result = len;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append('G');
        }
        for (int i = 1; i <= len; i++) {
            int temp = 0;
            for (int j = 0; j < len; j++) {
                if (sb.charAt(j) != s.charAt(j)) temp++;
            }
            result = Math.min(result, temp);
            sb.replace(i-1, i, "R");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minPaintNum(s));
    }
}
