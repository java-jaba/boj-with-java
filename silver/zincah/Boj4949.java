package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 4949. 균형잡힌세상
public class Boj4949 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){

            String str = br.readLine();
            if(str.equals(".")){ // . 문자열을 만나면 break
                break;
            }

            sb.append(check(str) + "\n");

        }

        System.out.println(sb);



    }

    public static String check(String str){

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);

            // 1. 여는 괄호 '(' 또는 '[' 일 경우 stack 에 저장한다.
            if(ch == '(' || ch == '['){
                stack.push(ch);
            }

            // 2. 닫는 괄호 중 ')' 일 경우
            else if(ch == ')'){
                // stack이 비었거나 대응되는 괄호('(')가 없을 경우
                if(stack.empty() || stack.peek() != '('){
                    return "no";
                }else{
                    stack.pop();
                }
            }

            // 3. 닫는 괄호 중 ']' 일 경우
            else if(ch == ']'){
                // stack 이 비었거나 대응되는 괄호 ('[')가 없을 경우
                if(stack.empty() || stack.peek() != '[') {
                    return "no";
                }else{
                    stack.pop();
                }
            }

            // 4. 그 외 나머지 경우는 다른 문자열이 있는 경우이기에 skip한다.

        }

        if(stack.empty()){
            return "yes";
        }else{
            return "no";
        }

    }

}
