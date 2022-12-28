package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// 백준 11866. 요세푸스 문제 0
public class Boj11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        int num = Integer.parseInt(strArr[0]); // 총 수
        int cycle = Integer.parseInt(strArr[1]); // 반복 주기

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=1; i<=num; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int cycleCheck = 0;

        while(list.size() != 0){

            // index로 값을 구하는 것이므로 반복주기에서 1을 뺀값으로 계산한다.
            cycleCheck += cycle - 1;

            // 반복주기가 리스트의 사이즈보다 크거나 같을 때에는 리스트의 사이즈를 빼준다.
            while(cycleCheck >= list.size()){
                cycleCheck -= list.size();
            }

            sb.append(list.get(cycleCheck).toString());
            if(list.size() != 1) sb.append(", ");

            list.remove(cycleCheck);
        }

        sb.append(">");

        System.out.println(sb);
    }


}
