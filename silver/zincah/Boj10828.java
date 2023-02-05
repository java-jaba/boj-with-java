package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 10828. 스택
public class Boj10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        /**
         * 입력으로 주어지는 명령
         * 1. push X : 정수 X를 stack에 넣는 연산
         * 2. pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에 -1 출력
         * 3. size : 스택에 들어있는 정수의 개수를 출력
         * 4. empty : 스택이 비어있으면 1, 아니면 0스
         * 5. top : 스택의 가장 위에 있는 정수를 출력, 없으면 -1 출력
         */

        for(int i=0; i<N; i++){
            String input = br.readLine();

            switch (input){
                case "pop":
                    if(stack.empty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(stack.peek());
                        stack.pop();
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.empty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "top":
                    if(stack.empty()) System.out.println("-1");
                    else System.out.println(stack.peek());
                    break;
                default:
                    // push인 경우 배열로 저장해서 stack에 값을 넣어준다.
                    String[] inputs = input.split(" ");
                    stack.push(Integer.parseInt(inputs[1]));
                    break;
            }

        }

    }
}
