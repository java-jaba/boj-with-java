import java.util.Scanner;

public class Chess1018 {

    public static boolean[][] arr;
    public static int min = 8*8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        arr = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) == 'W'; // W일 때는 true, B일 때는 false
            }
        }

        int mRow = m - 7;
        int nCol = n - 7;

        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < nCol; j++) {
                find(i, j);
            }
        }

        System.out.println(min);

    }

    public static void find(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean TF = arr[x][y]; // 첫 번째 칸의 색

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (arr[i][j] != TF) { // 올바른 색이 아닐 경우
                    count++;
                }
                TF = !TF; // 다음 칸에서 색 바꾸기
            }
            TF = !TF;
        }
        // 첫 번째 칸을 기준으로 할 때 색칠 개수, 첫 번째 칸과 반대되는 색을 기준으로 할 때 색칠 개수 중 최솟값 저장
        count = Math.min(count, 64 - count);

        // 이전까지의 경우 중 최솟값보다 현재 count 값이 더 작을 경우 최솟값을 갱신
        min = Math.min(min, count);
    }
}
