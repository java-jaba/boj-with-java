package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 백준 10845. 큐
public class Boj10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>(); // int 형 Queue 선언

        /**
         * 입력으로 주어지는 명령
         * 1. push X : 정수 X를 큐에 넣는 연산 -> add사용
         * 2. pop : 큐에서 가장 앞에 있는 정수를 빼고, 그 수 출력. 정수가 없는 경우 -1 출력
         * 3. size : 큐에 들어있는 정수의 개수 출력
         * 4. empty : 큐가 비어있으면 1, 아니면 0
         * 5. front : 가장 앞 정수 출력, 정수가 없는 경우 -1
         * 6. back : 가장 뒤 정수 출력, 정수가 없는 경우 -1
         */

        for(int i=0; i<N; i++){

            String input = br.readLine();

            switch (input){
                case "pop":
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(queue.peek());
                        queue.poll();
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front":
                    if(queue.isEmpty()) System.out.println("-1");
                    else System.out.println(queue.peek());
                    break;
                case "back": // 가장 뒤 정수를 출력하는 경우
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{ // 큐에 값이 있는 경우
                        for(int j=0; j<queue.size(); j++){
                            /**
                             * 큐의 사이즈만큼 반복문을 돌아서 큐의 값을 변수에 저장하고 삭제한다.
                             * 다시 큐에 넣어주면 큐의 값들이 한번 돌게된다
                             * 따라서 맨 끝의 값을 출력하고 다시 삭제해서 삽입해줌으로써
                             * 원래 큐를 만들어준다.
                             */
                            if(j == queue.size()-1){
                                System.out.println(queue.peek());
                            }
                            int move = queue.poll();
                            queue.add(move);
                        }
                    }
                    break;
                default: // push 명령어
                    String[] inputs = input.split(" ");
                    queue.add(Integer.parseInt(inputs[1]));
                    break;
            }

        }

    }
}
