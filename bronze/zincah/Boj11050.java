package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11050 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        /**
         * 이항계수 : N!/((N-K)!*K!)
         */
        int result = factorial(N) / (factorial(K) * factorial(N-K));
        System.out.println(result);
    }

    public static int factorial(int N){
        if(N == 0){
            return 1;
        }

        return N * factorial(N-1);
    }
}
