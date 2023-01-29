package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 10773. 제로
public class Boj10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++){
            int N = Integer.parseInt(br.readLine());

            if(N==0){
                // N이 0인 경우 stack에서 제거
                stack.pop();
            }else{
                // N이 0이 아닌 경우 stack에 추가
                stack.push(N);
            }
        }

        int hap = 0;
        for(int i : stack) hap+=i;

        System.out.println(hap);
    }
}
