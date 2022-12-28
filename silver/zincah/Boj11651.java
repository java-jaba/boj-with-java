package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 백준 11651. 좌표 정렬하기2
public class Boj11651 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] strArr = br.readLine().split(" ");
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(strArr[0]);
            arr[1] = Integer.parseInt(strArr[1]);
            list.add(arr);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                // y좌표가 같을 경우 x좌표 오름차순
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                // y좌표 오름차순
                return o1[1] - o2[1];
            }
        });

        // 출력
        for(int i=0; i<N; i++){
            int[] arr = list.get(i);
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}
