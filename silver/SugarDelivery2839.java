import java.util.Scanner;

public class SugarDelivery2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;
        while (true) {
            if (n % 5 == 0) { // 5의 배수라면 바로 끝내기
                System.out.println(n / 5 + cnt);
                break;
            } else if (n < 0) { // 정확히 만들 수 없다면 -1 출력
                System.out.println(-1);
                break;
            }
            n-= 3; // 5의 배수가 아니라면 3씩 빼서 구하기
            cnt++;
        }


    }
}
