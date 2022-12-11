package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 7568. 덩치
public class Boj7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력값을 2차원 배열으로 저장
        int[][] arr = new int[N][2];

        String[] str;
        for(int i=0; i<N; i++){
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        for(int i=0; i<N; i++){
            int rank = 1;

            for(int j=0; j<N; j++){
                if(i == j){ // i == j 인경우 pass
                    continue;
                }

                // 몸무게와 키가 다른 값보다 작을 경우 rank를 1증가시킨다.
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    rank++;
                }
            }

            System.out.println(rank);
        }

    }
}
