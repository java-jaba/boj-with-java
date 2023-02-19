import java.util.*;

// 백준 1966. 프린터 큐
public class PrinterQueue1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt(); // 테스트케이스의 개수

        while (t-- > 0) {
            int n = sc.nextInt(); // 문서의 개수
            int m = sc.nextInt(); // 궁금한 문서의 위치
            LinkedList<int[]> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                queue.offer(new int[] { i, sc.nextInt() }); // {초기 위치, 중요도}로 넣기
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                int[] front = queue.poll(); // 가장 첫 번째 원소 꺼내기
                boolean isMax = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (front[1] < queue.get(i)[1]) { // 중요도가 더 높은 다른 원소가 있다면
                        queue.offer(front); // 큐 뒤에 넣기
                        for (int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }
                        isMax = false; // front 원소가 가장 중요한 문서 아니었으므로 false
                        break;
                    }
                }
                if (!isMax) { // 다음으로 넘어가기
                    continue;
                }
                cnt++; // 가장 중요한 문서였으므로 출력해야 함
                if (front[0] == m) { // 찾고자 하는 문서라면 테스트케이스 종료
                    break;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);


    }
}
