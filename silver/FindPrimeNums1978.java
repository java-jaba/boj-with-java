import java.util.ArrayList;
import java.util.Scanner;
// 1978. 소수 찾기
public class FindPrimeNums1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (aliquot(num) == 2) { // 소수는 약수가 1과 자기 자신뿐인 수이므로
                count++;
            }
        }
        System.out.println(count);

    }

    public static int aliquot(int num) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            if (!list.contains(i) && num % i == 0) { // 중복되지 않는 나누어떨어지는 수만 모으기
                list.add(i);
            }
        }

        return list.size(); // 약수개수 반환
    }
}
