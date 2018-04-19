import java.util.Arrays;
import java.util.Scanner;

public class q20180102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        int[] nums = new int[13];
        for (int i = 0; i < 13; i++) {
            nums[i] = Integer.valueOf(numStr.split(" ")[i]);
        }
        int times = sc.nextInt();
        sc.nextLine();
        numStr = sc.nextLine();
        int[] m = new int[times];
        for (int i = 0; i < times; i++) {
            m[i] = Integer.valueOf(numStr.split(" ")[i]);
        }
        String result = shuffle(nums, times, m);
        System.out.println(result);
    }

    private static String shuffle(int[] nums, int times, int[] m) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            int[] l_nums = Arrays.copyOfRange(nums, 0, m[i]);
            int[] r_nums = Arrays.copyOfRange(nums, m[i], 13);
            nums = shuffleStep(l_nums, r_nums);
        }
        for (int num : nums) {
            result.append(num);
            result.append(' ');
        }
        return result.deleteCharAt(result.length()-1).toString();
    }

    private static int[] shuffleStep(int[] l_nums, int[] r_nums) {
        int[] result = new int[13];
        int idx_l = l_nums.length - 1;
        int idx_r = r_nums.length - 1;
        for (int i = 12; i >= 0; i--) {
            if (i % 2 == 0){
                if (idx_l >= 0) result[i] = l_nums[idx_l--];
                else result[i] = r_nums[idx_r--];
            }else {
                if (idx_r >= 0) result[i] = r_nums[idx_r--];
                else result[i] = l_nums[idx_l--];
            }

        }
        return result;
    }
}
