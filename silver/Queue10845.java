import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 10845. 큐
public class Queue10845 {

    public static int[] queue;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        queue = new int[n];

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(pop()).append("\n");
                    break;
                case "size" :
                    sb.append(size()).append("\n");
                    break;
                case "empty" :
                    sb.append(empty()).append("\n");
                    break;
                case "front" :
                    sb.append(front()).append("\n");
                    break;
                case "back" :
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    /* 정수 x를 큐에 넣기 */
    public static void push(int x) {
        queue[size] = x;
        size++;
    }

    /* 큐에서 가장 앞에 있는 정수 빼고 추출 (큐가 빈 경우 -1 출력) */
    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int result = queue[0];
            for (int i = 0; i < size-1; i++) {
                queue[i] = queue[i+1];
            }
            size--;
            return result;
        }
    }

    /* 큐에 들어있는 정수의 개수 출력 */
    public static int size() {
        return size;
    }

    /* 큐가 비어있으면 1, 아니면 0 출력 */
    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /* 큐의 가장 앞에 있는 정수 출력 (큐가 빈 경우 -1 출력) */
    public static int front() {
        if (size == 0) {
            return -1;
        } else {
            return queue[0];
        }
    }

    /* 큐의 가장 뒤에 있는 정수 출력 (큐가 빈 경우 -1 출력) */
    public static int back() {
        if (size == 0) {
            return -1;
        } else {
            return queue[size-1];
        }
    }

}
