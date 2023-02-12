package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1929. 소수 구하기
public class Boj1929 {

    public static boolean[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);

        array = new boolean[N+1];
        checking();

        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++){
            if(!array[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);

    }

    // 에라토스테네스의 체 사용
    public static void checking(){

        // 소수가 아닐 경우 true
        // 소수일 경우 false

        // 0과 1은 소수가 아니므로 true를 저장한다.
        array[0] = array[1] = true;

        // Math의 제곱근 함수를 사용하는 이유는 제곱근 사이에서 나누어 떨어지는 수가 있으면 소수가 아님을 이용
        for(int i=2; i<Math.sqrt(array.length); i++){
            if(array[i]) continue; // array[i]값이 true이면 pass
            for(int j=i*i; j<array.length; j+=i){
                array[j] = true;
            }
        }



    }



}
