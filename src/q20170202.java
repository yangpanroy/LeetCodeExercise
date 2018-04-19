import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Roy on 2018/4/18.
 */
public class q20170202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String numStr = sc.nextLine();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.valueOf(numStr.split(" ")[i]);
        }
        System.out.println(minSortTime(nums, len));
    }

    private static int minSortTime(int[] nums, int len) {
        int minTime = 0;
        int[] temp = Arrays.copyOfRange(nums, 0, len);
        Arrays.sort(temp);
        for (int i = 0; i < len; i++) {
            if (temp[i] != nums[i]) minTime++;
        }
        return minTime;
    }
}
