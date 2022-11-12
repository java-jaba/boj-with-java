package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2609 {

    // 최대공약수, 최소공배수
    // 최소공배수는 두 수의 곱에서 최대 공약수로 나누면 나오는 값이다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray = br.readLine().split(" ");

        int first = Integer.parseInt(strArray[0]);
        int second = Integer.parseInt(strArray[1]);

        //int min = (first < second) ? first : second;
        int min = Math.min(first, second);
        int gcd = 0;
        int lcm = 0;
        for(int i=1; i<=min; i++){
            if(first%i == 0 && second%i == 0){
                // 최대공약수 : i로 나누었을 때 0으로 나누어 떨어지게 하는 i중 가장 큰 수
                gcd = i; // 최대공약수
            }
        }
        lcm = first*second/gcd; // 최소공배수 = 첫번째 수 * 두번째 수 / 최대공약수

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
