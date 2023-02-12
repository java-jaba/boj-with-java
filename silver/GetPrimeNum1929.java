import java.util.Scanner;
// 1929. 소수 구하기
public class GetPrimeNum1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) { // 소수라면
                sb.append(i).append('\n'); // 출력목록에 추가
            }
        }
        System.out.println(sb);
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        boolean answer = true;
        for (int i = 2; i <= Math.sqrt(num); i++) { // 에라토스테네스의 체 방법 이용
            if (num % i == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
