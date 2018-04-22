import java.util.ArrayList;
import java.util.Scanner;

/**
 * 如果一个整数只能被1和自己整除,就称这个数是素数。
 * 如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
 * 如果一个数字既是素数也是回文数,就称这个数是回文素数
 * 牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
 */
public class q20170201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = new int[2];
        nums[0] = Integer.valueOf(input.split(" ")[0]);
        nums[1] = Integer.valueOf(input.split(" ")[1]);
        int hwss = getHwssNum(nums);
        System.out.println(hwss);
    }

    private static int getHwssNum(int[] nums) {
        ArrayList hwList = getHwList(nums);
        return getSsNum(hwList);
    }

    private static int getSsNum(ArrayList hwList) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < hwList.size(); i++) {
            int temp = Integer.valueOf(hwList.get(i).toString());
            for (int j = 2; j < temp; j++) {
                if (temp % j == 0){
                    count++;
                }
            }
            if (count == 0){
                if (temp != 1) result++;
            }
            count = 0;
        }
        return result;
    }

    private static ArrayList getHwList(int[] nums) {
        ArrayList hwList = new ArrayList();
        for (int i = nums[0]; i <= nums[1]; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            int temp = Integer.valueOf(sb.reverse().toString());
            if (i == temp) hwList.add(i);
        }
        return hwList;
    }
}
