package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 10866. 덱
public class Boj10866_int1 { // 입력 받을 수 있는 값의 2배로 해서 구현

    static int front = 10000;
    static int back = 10000;
    static int size = 0;
    static int[] deque = new int[20001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            String[] inputs = br.readLine().split(" ");

            switch (inputs[0]){
                case "push_front":
                    push_front(Integer.parseInt(inputs[1]));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(inputs[1]));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

    }

    static void push_front(int val){
        // 원소를 넣은 뒤 front를 감소시킨다.
        deque[front] = val;
        front--;
        size++;
    }

    static void push_back(int val){
        back++;
        size++;
        deque[back] = val;
    }

    static int pop_front(){
        if(size == 0){
            return -1;
        }
        /**
         * front + 1이 front 원소이므로 해당 원소를 임시 변수에 둔다.
         * front 를 ++
         */
        int temp = deque[front + 1];
        front++;
        size--;
        return temp;
    }

    static int pop_back(){
        if(size==0){
            return -1;
        }

        int temp = deque[back];
        back--;
        size--;
        return temp;
    }

    static int size(){
        return size;
    }

    static int empty(){
        if(size == 0){
            return 1;
        }
        return 0;
    }

    static int front(){
        if(size == 0){
            return -1;
        }
        return deque[front + 1];
    }

    static int back(){
        if(size == 0){
            return -1;
        }
        return deque[back];
    }

}
