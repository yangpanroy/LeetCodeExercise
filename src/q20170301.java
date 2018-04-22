import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛牛有4根木棍,长度分别为a,b,c,d。
 * 羊羊家提供改变木棍长度的服务,如果牛牛支付一个硬币就可以让一根木棍的长度加一或者减一。
 * 牛牛需要用这四根木棍拼凑一个正方形出来,牛牛最少需要支付多少硬币才能让这四根木棍拼凑出正方形。
 */

public class q20170301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.valueOf(numStr.split(" ")[i]);
        }
        int cost = minCost(nums);
        System.out.println(cost);
    }

    private static int minCost(int[] nums) {
        int[] cost = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j){
                    cost[i] += Math.abs(nums[i] - nums[j]);
                }
            }
        }
        Arrays.sort(cost);
        return cost[0];
    }
}
