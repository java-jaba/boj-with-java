package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 백준 11650. 좌표 정렬하기
public class Boj11650 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dot = new int[N][2]; // 2차원 배열로 입력값을 받는다.

        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split(" ");
            dot[i][0] = Integer.parseInt(arr[0]);
            dot[i][1] = Integer.parseInt(arr[1]);
        }

        // Comparator을 사용하여 우선 x좌표를 오름차순으로 정렬하고
        // x좌표가 같을 경우 y좌표를 오름차순으로 정렬한다.
        Arrays.sort(dot, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(dot[i][0] + " " + dot[i][1] + "\n");
        }

        System.out.println(sb);
    }
}
