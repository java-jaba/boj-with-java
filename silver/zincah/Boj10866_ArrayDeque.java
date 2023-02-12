package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 백준 10866. 덱
public class Boj10866_ArrayDeque {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){

            String[] inputs = br.readLine().split(" ");
            switch(inputs[0]){

                case "push_front":
                    deque.addFirst(Integer.parseInt(inputs[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(inputs[1]));
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.pollFirst()).append('\n');
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.peek()).append('\n');
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.peekLast()).append('\n');
                    }
                    break;
            }

        }

        System.out.println(sb);

    }
}
