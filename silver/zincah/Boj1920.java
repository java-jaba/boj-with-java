package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1920. 수 찾기
public class Boj1920 {

    public static int[] nArr;
    public static int[] mArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nArr = new int[N];
        int n = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        while (st1.hasMoreTokens()) {
            nArr[n++] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(nArr); // nArr 오름차순으로 정렬 : 이분정렬에서 쉽게 값을 찾아나가게 하기 위함

        int M = Integer.parseInt(br.readLine());

        mArr = new int[M];
        int m = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        while (st2.hasMoreTokens()) {
            mArr[m++] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < M; i++) {
            /**
             * 재귀로 이분 탐색을 구현하여
             * 찾는 값이 있는 경우 1리턴
             * 찾는 값이 없는 경우 0리턴
             */
            int result = checkArr(mArr[i], 0, N - 1);
            System.out.println(result);
        }
    }

    public static int checkArr(int target, int left, int right) { // 재귀로 구현
        if (left > right) return 0;

        int mid = (left + right) / 2;

        if (nArr[mid] < target) {
            return checkArr(target, mid + 1, right);
        } else if (nArr[mid] > target) {
            return checkArr(target, left, mid - 1);
        } else {
            // nArr[mid] == target 일 경우
            return 1;
        }
    }
}
