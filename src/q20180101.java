import java.util.Scanner;

public class q20180101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int count = 0;
        int i = 0;
        while (i < input.length()-1){
            if (input.charAt(i) == input.charAt(i+1)){
                count++;
                i = i + 2;
            }else {
                i++;
            }
        }
        System.out.println(count);
    }
}
