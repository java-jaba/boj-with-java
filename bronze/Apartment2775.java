import java.util.Scanner;

public class Apartment2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int FLOORS = 14;
        final int DOORS = 14;

        // 아파트 배열 만들기
        int[][] apartment = new int[FLOORS+1][DOORS+1];

        // 초기화
        for (int i = 0; i < FLOORS+1; i++) {
            apartment[i][1] = 1; // i층 1호
            apartment[0][i] = i; // 0층 i호
        }

        // 각 층-호에 인원 채우기
        for (int a = 1; a < FLOORS+1; a++) {
            for (int b = 2; b < DOORS+1; b++) {
                apartment[a][b] = apartment[a][b-1] + apartment[a-1][b];
            }
        }

        // 문제풀기
        int testCases = sc.nextInt();

        for(int i = 0; i < testCases; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(apartment[k][n]);
        }

    }
}
