import java.util.ArrayList;
import java.util.Scanner;

/**
 * 牛牛的老师给出了一个区间的定义:对于x ≤ y,[x, y]表示x到y之间(包括x和y)的所有连续整数集合。
 * 例如[3,3] = {3}, [4,7] = {4,5,6,7}.牛牛现在有一个长度为n的递增序列,牛牛想知道需要多少个区间并起来等于这个序列。
 * 例如:
 * {1,2,3,4,5,6,7,8,9,10}最少只需要[1,10]这一个区间
 * {1,3,5,6,7}最少只需要[1,1],[3,3],[5,7]这三个区间
 */

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
