import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
// 9012. 괄호
public class Bracket9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            sb.append(solution(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 1-1. 여는 괄호일 경우
            if (c == '(') stack.push(c);
            // 1-2. 닫는 괄호일 경우
            // 2-1. pop할 원소가 없을 경우
            else if (stack.empty()) return "NO";
            // 2-2. 그 외의 경우 pop
            else stack.pop();
        }

        // 스택에 남은 게 있으면 매칭 안 된다는 의미
        if (stack.empty()) return "YES";
        else return "NO";
    }
}
