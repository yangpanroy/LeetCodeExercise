import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 注意：
 *
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 *
 * 示例 1:
 *
 * 输入: [1,2,3], [1,1]
 *
 * 输出: 1
 *
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 *
 * 输入: [1,2], [1,2,3]
 *
 * 输出: 2
 *
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 */

public class q455 {
    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        System.out.println(findContentChildren(g, s));
        g = new int[]{1, 2};
        s = new int[]{1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int result = 0;
        // 先对 g 和 s 进行排序，然后从大到小遍历
        // 如果 s 当前元素大于等于 g 当前元素，则满足，双方均向前继续遍历
        // 如果 s 当前元素小于 g 当前元素，则 s 不动，继续向前遍历 g
        Arrays.sort(g);
        Arrays.sort(s);
        int idx_g = g.length - 1;
        int idx_s = s.length - 1;
        while (idx_s >= 0 && idx_g >= 0) {
            if (s[idx_s] >= g[idx_g]) {
                result++;
                idx_s--;
                idx_g--;
            } else {
                idx_g--;
            }
        }
        return result;
    }
}
