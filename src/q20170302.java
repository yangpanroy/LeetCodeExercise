import java.util.ArrayList;
import java.util.Scanner;

public class q20170302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String numStr = sc.nextLine();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.valueOf(numStr.split(" ")[i]);
        }
        int rangeNum = minRangeNum(nums, len);
        System.out.println(rangeNum);
    }

    private static int minRangeNum(int[] nums, int len) {
        int rangeNum = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (temp.size() == 0) temp.add(nums[i]);
            else {
                int idx = temp.size() - 1;
                if (nums[i] - temp.get(idx) == 1) temp.add(nums[i]);
                else {
                    rangeNum++;
                    temp.clear();
                    temp.add(nums[i]);
                }
            }
        }
        return rangeNum;
    }
}
