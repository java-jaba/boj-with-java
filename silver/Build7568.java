import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Build7568 {
    public static void main(String[] args) throws IOException {
        // 7568. 덩치

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        String[] str;
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]); // 몸무게
            arr[i][1] = Integer.parseInt(str[1]); // 키
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int j = 0; j < n; j++) {
                if (i == j) { continue; }
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }

            sb.append(rank).append(' ');
        }
        System.out.println(sb);
    }
}
