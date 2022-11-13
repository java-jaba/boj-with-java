import java.util.Scanner;

public class GCD_LCM2609 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 최대공약수
        int GCD = 0;

        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                GCD = i;
            }
        }

        // 최소공배수
        int LCM = (a*b)/GCD;

        System.out.println(GCD);
        System.out.println(LCM);
    }



}
