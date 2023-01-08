package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 백준 2164. :  카드
public class Boj2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 제일 위에 있는 카드를 삭제하고
        // 삭제 후 맨 뒤로 보내는 작업을 하기 때문에
        // queue를 활용한다.
        Queue<Integer> cards = new LinkedList<>();
        for(int i=1; i<=N; i++){
            cards.add(i);
        }

        /**
         * 첫 카드는 삭제
         * 두번째 카드는 다른 변수에 저장한뒤 삭제 후, 맨 뒤에 추가
         * queue의 사이즈가 1이 될때까지 반복한다.
         */
        while(cards.size() > 1){

            cards.remove();
            int moveInt = cards.peek();
            cards.remove();
            cards.offer(moveInt);

        }

        System.out.println(cards.peek());

    }
}
