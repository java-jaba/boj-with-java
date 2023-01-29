import java.util.Scanner;
import java.util.Stack;
// 10773. 제로
public class Zero10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        Stack<Integer> stack = new Stack<>(); // 합산할 값 담을 스택 만들기
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp == 0) { // 0이면 가장 최근 값 빼기
                stack.pop();
            } else { // 0 아니면 넣기
                stack.push(temp);
            }
        }

        // stack에 있는 값 전부 더하기
        for (int s : stack) {
            answer += s;
        }
        System.out.println(answer);
    }
}
