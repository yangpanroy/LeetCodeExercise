import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛牛有一个长度为n的整数序列,牛牛想对这个序列进行重排为一个非严格升序序列。
 * 牛牛比较懒惰,他想移动尽量少的数就完成重排,请你帮他计算一下他最少需要移动多少个序列中的元素。
 * (当一个元素不在它原来所在的位置,这个元素就是被移动了的)
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
