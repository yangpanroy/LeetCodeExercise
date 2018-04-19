import java.util.Scanner;

public class q20180103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = Integer.valueOf(input.split(" ")[0]);
        int m = Integer.valueOf(input.split(" ")[1]);
        int[][] n_limits = new int[n][2];
        for (int i = 0; i < n; i++) {
            input = sc.nextLine();
            n_limits[i][0] = Integer.valueOf(input.split(" ")[0]);
            n_limits[i][1] = Integer.valueOf(input.split(" ")[1]);
        }
        Long result = getSolutions(n, m, n_limits, 0);
        System.out.println(result);
    }

    private static Long getSolutions(int n, int m, int[][] n_limits, int idx) {
        Long result = 0L;
        if (n == 1){
            if (m >= n_limits[idx][0] && m <= n_limits[idx][1]) return 1L;
        }else {
            for (int i = n_limits[idx][0]; i <= n_limits[idx][1]; i++) {
                result += getSolutions(n-1, m-i, n_limits, idx+1);
            }
        }
        return result;
    }
}
