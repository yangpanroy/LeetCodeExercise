import java.util.Arrays;
import java.util.Scanner;

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
