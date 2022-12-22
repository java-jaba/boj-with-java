import java.util.Arrays;
import java.util.Scanner;

public class CoordinateSorting11650 {

    public static void main(String[] args) {
        // 11650. 좌표 정렬하기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        // 배열에 입력값 넣기
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // Comparator를 람다식으로 구현 (정렬 기준 설정)
        Arrays.sort(arr, (c1, c2) -> {
            if (c1[0] == c2[0]) { // c1, c2의 x좌표가 같으면
                return c1[1] - c2[1]; // y좌표로 비교
            } else { // c1, c2의 x좌표가 다르면
                return c1[0] - c2[0]; // x좌표로 비교
            }
        });

        // StringBuilder에 붙여서 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append('\n');
        }
        System.out.println(sb);

    }
}

