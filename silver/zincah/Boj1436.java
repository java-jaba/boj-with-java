package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1436 {

    // 백준 1436 : 영화감독 숌
    // 브루트포스 알고리즘 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 666; // 666이 최소값이기 때문에 666부터 시작
        int count = 1; // N값과 비교하기 위한 수

        while(count != N){
            num++;

            if(String.valueOf(num).contains("666")){ // 666이 포함되었을 경우
                count++;
            }
        }

        System.out.println(num);
    }
}
