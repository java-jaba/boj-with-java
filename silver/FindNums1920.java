import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNums1920 {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 배열 저장
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 배열 정렬
        Arrays.sort(arr);

        // 3. 이진 탐색
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< m; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int binarySearch(int key) {
        int left = 0; // 탐색 범위의 왼쪽 끝 인덱스
        int right = arr.length-1; // 탐색 범위의 오른쪽 끝 인덱스

        while (left <= right) {
            int mid = (left + right) / 2;

            if (key < arr[mid]) { // key이 mid보다 작다면
                right = mid - 1;
            } else if (key > arr[mid]) { // key가 mid보다 크다면
                left = mid + 1;
            } else { // key와 mid가 같다면
                return mid;
            }
        }
        return -1; // 찾는 key가 없다면
    }
}
