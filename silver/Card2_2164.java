import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        
        // 1~n까지의 숫자를 큐에 넣기
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        
        // 앞 장을 버리고 다음 장을 맨 뒤에 넣기 반복
        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        
        // 한 장 남았을 때 맨 앞의 장을 출력
        System.out.println(queue.poll());

    }
}
