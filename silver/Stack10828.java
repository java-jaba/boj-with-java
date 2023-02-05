import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 10828. 스택
public class Stack10828 {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        stack = new int[n];

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(pop()).append('\n');
                    break;
                case "size" :
                    sb.append(size()).append('\n');
                    break;
                case "empty" :
                    sb.append(empty()).append('\n');
                    break;
                case "top" :
                    sb.append(top()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

    }

    /* 정수를 스택에 넣기 */
    public static void push(int num) {
        stack[size] = num;
        size++;
    }

    /* 스택에서 가장 위에 있는 정수를 빼서 출력 (스택이 빈 경우 -1 출력) */
    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int result = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return result;
        }
    }

    /* 스택에 들어있는 정수의 개수 출력 */
    public static int size() {
        return size;
    }

    /* 스택이 비어있으면 1, 아니면 0을 출력 */
    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /* 스택의 가장 위에 있는 정수를 출력 (스택이 빈 경우에는 -1출력) */
    public static int top() {
        if (size == 0) {
            return -1;
        } else {
            return stack[size - 1];
        }
    }
}
