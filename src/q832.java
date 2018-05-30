/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 *
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */

public class q832 {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        for (int[] row : flipAndInvertImage(A)) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println(",");
        }
        A = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        for (int[] row : flipAndInvertImage(A)) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println(",");
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        // 分为水平翻转和反转两个部分，拆分成两个函数写出来
        A = flipImage(A);
        A = invertImage(A);
        return A;
    }

    private static int[][] flipImage(int[][] a) {
        int temp;
        // 水平反转主要是对每行进行翻转
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length / 2; j++) {
                temp = a[i][j];
                a[i][j] = a[i][a.length-1-j];
                a[i][a.length-1-j] = temp;
            }
        }
        return a;
    }

    private static int[][] invertImage(int[][] a) {
        //反转主要是 0 替换成 1 ， 1 替换成 0
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = Math.abs(a[i][j] - 1);
            }
        }
        return a;
    }
}
