import java.util.Scanner;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 注意：你不能倾斜容器，n 至少是2。
 */
public class q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一共有几个垂线（至少为2）：");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("最大的面积为：" + maxArea2(nums));
    }

    public static int maxArea(int[] height) {
        //复杂度超时
        int max_Area = 0;
        for (int i = 0; i < height.length; i++) {
            int j = height.length - 1;
            while (i < j){
                if (height[i] <= height[j]) max_Area = Math.max(max_Area, height[i] * (j-- - i));
                else max_Area = Math.max(max_Area, height[j] * (j-- - i));
            }

        }
        return max_Area;
    }

    public static int maxArea2(int[] height) {
        //我们采用两个指针，一个在开始处，另一个在数组末尾，构成行的长度。
        // 而且，我们保持一个可变的maxarea来存储迄今为止获得的最大面积。
        // 在每一步中，我们找出它们之间形成的区域，更新maxarea并将指针指向朝向另一端的较短行一步。
        int maxarea = 0;
        int i = 0, j = height.length-1;
        while (i < j){
            maxarea = Math.max(maxarea, height[i]<height[j] ? height[i]*(j-i) : height[j]*(j-i));
            if (height[i]<height[j]) i++;
            else j--;
        }
        return maxarea;
    }

}
