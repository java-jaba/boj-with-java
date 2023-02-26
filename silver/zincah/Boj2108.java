package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2108 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] counting = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mid = 10000;
        int many = 10000;

        for(int i=0; i<N; i++){
            int val = Integer.parseInt(br.readLine());
            sum += val;
            counting[val+4000]++;

            if(max < val){
                max = val;
            }

            if(min > val){
                min = val;
            }
        }

        int count = 0; // 중앙값 빈도 누적 수
        int many_max = 0; // 최빈값의 최댓값

        // 이전의 동일한 최빈값이 1번만 등장했을 경우 true, 아닐경우 false
        boolean flag = false;

        for(int i=min+4000; i<=max+4000; i++){

            if(counting[i] > 0){

                // 중앙값
                if(count < (N+1)/2){
                    count += counting[i];
                    mid = i - 4000;
                }

                // 최빈값
                if(many_max < counting[i]){
                    many_max = counting[i];
                    many = i - 4000;
                    flag = true;
                }else if(many_max == counting[i] && flag == true){
                    many = i - 4000;
                    flag = false;
                }
            }

        }

        System.out.println((int)Math.round((double) sum/N));
        System.out.println(mid);
        System.out.println(many);
        System.out.println(max-min);




    }
}
