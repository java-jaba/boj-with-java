package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2차원 배열로 아파트 호수 당 몇명이 거주해야 하는지 설계한다.
        // 1 <= k, n <= 14

        int T = Integer.parseInt(br.readLine());

        // 아파트 구조 : 2차원 배열
        int[][] apart = new int[15][15];

        for(int i=0; i<15; i++){
            apart[0][i] = i; // 0층 i호 기본값 세팅
            apart[i][1] = 1; // i층 1호 = 1
        }

        // 각 호수에 인원수 배치
        // 각 호수는 그 전 호수의 인원 + 밑 층의 같은 호수의 인원
        for(int i=1; i<15; i++){
            for(int j=2; j<15; j++){
                apart[i][j] = apart[i-1][j] + apart[i][j-1];
            }
        }

        for(int i=0; i<T; i++){
            int k = Integer.parseInt(br.readLine()); // k층
            int n = Integer.parseInt(br.readLine()); // n호

            System.out.println(apart[k][n]);
        }

    }
}
