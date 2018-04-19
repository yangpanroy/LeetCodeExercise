import java.util.Scanner;

/**
 * Created by Roy on 2018/4/18.
 */
public class q20170203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] n = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(isNiuWin(n[i]) ? "niu" : "yang");
        }
    }

    private static boolean isNiuWin(int i) {
        boolean result = true;
        int rmd = i % 5;
        switch (rmd){
            case 0:
                result = false;
                break;
            case 1:
                result = true;
                break;
            case 2:
                result = false;
                break;
            case 3:
                result = true;
                break;
            case 4:
                result = true;
                break;
        }
        return result;
    }
}
