import java.util.Arrays;
import java.util.List;

/**
 * Created by Roy on 2018/4/10.
 */
public class q5 {
    public static boolean containsDuplicate(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++){
            int t = nums[i];
            for (int j = 0; j < l; j++){
                if(i != j){
                    if(t == nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int l = nums.length;
        double[] average = new double[l-k+1];
        for(int i = 0; i <= l-k; i++){
            int sub[] = Arrays.copyOfRange(nums, i, i+k);
            int sum = 0;
            for (int elem:sub){
                sum += elem;
            }
            average[i] = sum*1.0/k;
        }
        Arrays.sort(average);
        return average[l-k];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5};
//        if (containsDuplicate(nums)){
//            System.out.println("true");
//        }
//        else{
//            System.out.println("false");
//        }
        double avg = findMaxAverage(nums, 1);
        System.out.println(avg);
    }
}
