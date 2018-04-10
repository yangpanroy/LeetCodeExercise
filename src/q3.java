import java.util.Arrays;

/**
 * Created by Roy on 2018/4/10.
 */
public class q3 {

    public static int[] rotate(int[] nums, int k) {
        int l = nums.length;
        if (k > l) k = k - l;
        while (k > 0){
            int temp = nums[l-1];
            for (int i = l-1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int k = 1;
        System.out.println(Arrays.toString(rotate(nums, k)));
    }

}
