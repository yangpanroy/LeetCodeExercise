import java.util.Scanner;

public class q20170303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int num = minAddCharNum(input);
        System.out.println(num);
    }

    private static int minAddCharNum(String input) {
        int num = 0;
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == '(') sb.append('(');
            else if (input.charAt(i) == ')'){
                if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
                else num++;
            }
        }
        if (sb.length() != 0) num += sb.length();
        return num;
    }
}
