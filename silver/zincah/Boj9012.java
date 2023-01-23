package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 9012. 괄호
public class Boj9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            sb.append(solve(br.readLine()) + "\n");
        }

        System.out.println(sb);

    }

    public static String solve(String str){

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){

            // 문자열에서 괄호를 하나씩 입력받는다.
            char ch = str.charAt(i);

            // 1. 괄호가 여는 괄호일 경우 스택에 저장한다.
            if(ch == '('){
                stack.push(ch);
            }

            // 2. stack 안이 비었을 경우 stack에 여는 괄호를 추가하고 break한다.
            else if(stack.empty()){
                return "NO";
            }

            // 3. 괄호가 닫는 괄호일 경우 스택에서 하나 삭제한다.
            else {
                stack.pop();
            }

        }

        // 4. 검증을 종료하고 stack이 비었을 경우에는 "YES" 저장
        //      stack 안에 원소가 있을 경우에는 "NO" 저장
        if(stack.empty()){
            return "YES";
        }else{
            return "NO";
        }

    }
}
