import java.util.Scanner;

/**
 * 牛牛和羊羊都很喜欢青草。今天他们决定玩青草游戏。
 * 最初有一个装有n份青草的箱子,牛牛和羊羊依次进行,牛牛先开始。
 * 在每个回合中,每个玩家必须吃一些箱子中的青草,所吃的青草份数必须是4的x次幂,比如1,4,16,64等等。
 * 不能在箱子中吃到有效份数青草的玩家落败。假定牛牛和羊羊都是按照最佳方法进行游戏,请输出胜利者的名字。
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
