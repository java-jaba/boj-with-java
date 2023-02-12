package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// 백준 10866. 덱 -> 맞았지만 직접 구현해서 풀이하는 것으로 수정해야함
public class Boj10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i<N; i++){
            String[] inputs = br.readLine().split(" ");
            switch (inputs[0]){
                case "push_front":
                    list.addFirst(Integer.parseInt(inputs[1]));
                    break;
                case "push_back":
                    list.add(Integer.parseInt(inputs[1]));
                    break;
                case "pop_front":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.get(0));
                        list.removeFirst();
                    }
                    break;
                case "pop_back":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.get(list.size()-1));
                        list.removeLast();
                    }
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    if(list.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.getFirst());
                    }
                    break;
                case "back":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.getLast());
                    }
                default:
                    break;
            }
        }
    }
}
