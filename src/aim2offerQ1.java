/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class aim2offerQ1 {
    public static void main(String[] args) {
        int target = 6;
        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Find(target, array) ? "True" : "False");
    }

    public static boolean Find(int target, int [][] array) {
        boolean result = false;
        int row = array.length;
        int col = array[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (target == array[i][j]) {
                    result = true;
                    break;
                }
                else if (target < array[i][j]) break;
            }
        }
        return result;
    }

    public boolean Find2(int target, int [][] array) {
        /**
         * 从左下角元素往上查找，右边元素是比这个元素大，上边是的元素比这个元素小。
         * 于是，target比这个元素小就往上找，比这个元素大就往右找。
         * 如果出了边界，则说明二维数组中不存在target元素。
         */
        int rows = array.length;
        int cols = array[0].length;
        int i=rows-1,j=0;
        while(i>=0 && j<cols){
            if(target<array[i][j])
                i--;
            else if(target>array[i][j])
                j++;
            else
                return true;
        }
        return false;
    }
}
