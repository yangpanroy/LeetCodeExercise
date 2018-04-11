/**
 * 有两个大小为 m 和 n 的排序数组 nums1 和 nums2 。

 请找出两个排序数组的中位数并且总的运行时间复杂度为 O(log (m+n)) 。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 中位数是 2.0


 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 中位数是 (2 + 3)/2 = 2.5
 */
public class q4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //由于两数组是有序数组，所以使用归并排序，并根据两数组长度，在排序好的长数组中根据下标找计算中位数
        int len1 = nums1.length;
        int len2 = nums2.length;
        double ans;
        int[] nums = mergeSort(nums1, nums2, len1, len2);
        if ((len1 + len2) % 2 == 0){
            ans =  (nums[(len1 + len2) / 2] + nums[(len1 + len2) / 2 - 1]) / 2.0;
        }else {
            ans =  nums[(len1 + len2) / 2];
        }
        return ans;
    }

    private static int[] mergeSort(int[] nums1, int[] nums2, int len1, int len2) {
        int len = len1 + len2;
        int[] nums = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < len){
            if (j >= len1){
                nums[i++] = nums2[k++];
            }else if (k >= len2){
                nums[i++] = nums1[j++];
            }
            if (j < len1 && k < len2){
                if (nums1[j] <= nums2[k]){
                    nums[i++] = nums1[j++];
                }else {
                    nums[i++] = nums2[k++];
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        int[] nums3 = new int[]{1,2};
        int[] nums4 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums3, nums4));
    }
}
