import java.util.Scanner;
// 1436. 영화감독 숌
public class Shomm1436 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int title = 666;

        while (count != n) {
            title++;
            if (String.valueOf(title).contains("666")) {
                count++;
            }
        }
        System.out.println(title);

    }
}
