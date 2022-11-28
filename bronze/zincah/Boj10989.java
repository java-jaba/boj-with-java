package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10989 {

    public static void main(String[] args) throws IOException {
        /**
         * 정렬 알고리즘 사용 : 1. Arrays.sort() / 2. 카운팅 정렬
         */

        // 1. Arrays.sort() : dual-piviot 퀵 정렬 알고리즘 사용
        // 시간복잡도 : 평균 O(nlogn), 최악의 경우 O(n^2)
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int a : arr){
            sb.append(a).append("\n");
        }

        System.out.println(sb);*/

        // 2. 카운팅 정렬
        // 시간복잡도 : O(N+K)
        // - K는 자리수를 의미하는데 입력데이터가 K보다 훨씬 큰 경우, 즉 데이터가 많으면 많을 수록 O(N)에 가깝기 때문에
        // - 이상적으로 O(N)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 범위 (0 ~ 10000)
        int[] count = new int[10001];

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            // 입력값을 인덱스로 입력받아서 값을 1 증가시킨다.
            count[Integer.parseInt(br.readLine())] ++;
        }

        br.close();
        StringBuilder sb = new StringBuilder();
        // 0은 입력범위에 없으므로 1부터 출력 시작
        for(int i=1; i<10001; i++){
            // i값이 개수가 0이 될때까지 출력
            while(count[i] > 0){// 출력값이 0이 아닐 경우 출력
                sb.append(i).append("\n");
                count[i]--;
            }
        }
        System.out.println(sb);
    }
}
