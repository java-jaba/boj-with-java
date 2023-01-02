import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yosephus11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // 큐 생성해서 값 채워주기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 출력할 문자열 시작
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 마지막 괄호(<)는 한 번만 출력해야 하므로 그전까지만 반복
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) { // 안쪽 반복문은 k보다 하나 앞까지만 반복하기
                int val = queue.poll(); // 맨 앞의 값 반환 후 삭제
                queue.offer(val); // 맨 뒤에 붙이기
            }
            sb.append(queue.poll()).append(", "); // 맨 앞의 값 출력하고 삭제
        }
        
        // 마지막 괄호 붙이기
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
