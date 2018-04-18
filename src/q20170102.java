import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,并且牛牛还希望这个三角形的周长越大越好。
 */
public class q20170102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = new int[3];
        int i = 0;
        for (String item:input.split(" ")) {
            nums[i++] = Integer.valueOf(item);
        }
        System.out.println(maxLenth(nums[0], nums[1], nums[2]));
        System.out.println(maxLenth2(nums));
    }

    private static int maxLenth2(int[] nums) {
        Arrays.sort(nums);
        while (nums[0] + nums[1] <= nums[2]) nums[2]--;
        return nums[0] + nums[1] + nums[2];
    }

    private static int maxLenth(int num, int num1, int num2) {
        HashMap info = getDetAndSum(num, num1, num2);
        while (Integer.valueOf(info.get("sum1").toString()) <= num2) info = getDetAndSum(num, num1, --num2);
        while (Integer.valueOf(info.get("sum2").toString()) <= num1) info = getDetAndSum(num, --num1, num2);
        while (Integer.valueOf(info.get("sum3").toString()) <= num) info = getDetAndSum(--num, num1, num2);
        while (Integer.valueOf(info.get("det1").toString()) >= num2){
            if (num > num1) num--;
            else num1--;
            info = getDetAndSum(num, num1, num2);
        }
        while (Integer.valueOf(info.get("det2").toString()) >= num1){
            if (num > num2) num--;
            else num2--;
            info = getDetAndSum(num, num1, num2);
        }
        while (Integer.valueOf(info.get("det3").toString()) >= num){
            if (num1 > num2) num1--;
            else num2--;
            info = getDetAndSum(num, num1, num2);
        }
        return num+num1+num2;
    }

    private static HashMap getDetAndSum(int num, int num1, int num2) {
        HashMap info = new HashMap();
        int det1 = Math.abs(num - num1);
        int det2 = Math.abs(num - num2);
        int det3 = Math.abs(num1 - num2);
        int sum1 = num + num1;
        int sum2 = num + num2;
        int sum3 = num1 + num2;
        info.put("det1", det1);
        info.put("det2", det2);
        info.put("det3", det3);
        info.put("sum1", sum1);
        info.put("sum2", sum2);
        info.put("sum3", sum3);
        return info;
    }
}
