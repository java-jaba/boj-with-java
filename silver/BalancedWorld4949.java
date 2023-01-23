import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 4949. 균형잡힌 세상
public class BalancedWorld4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while (true) {
            s = br.readLine();
            if (s.equals(".")) break;
            sb.append(solution(s)).append('\n');
        }
        System.out.println(sb);
    }

    public static String solution(String s) {
        // 1. 스택처럼 사용할 배열 만들기
        char[] stack = new char[s.length()];
        int size = 0;

        for (char val : s.toCharArray()) {
            // 2-1. 여는 괄호 -> 배열에 저장 후 size++
            if (val == '(' || val == '[') stack[size++] = val;
            // 2-2. 닫는 소괄호
            else if (val == ')') {
                // 요소가 비어있거나 pop할 원소가 소괄호랑 매칭이 안 될 때
                if (size == 0 || stack[size - 1] != '(') return "no";
                else size--;
            // 2-3. 닫는 대괄호
            } else if (val == ']') {
                // 요소가 비어있거나 pop할 원소가 대괄호랑 매칭이 안 될 때
                if (size == 0 || stack[size - 1] != '[') return "no";
                else size--;
            }
        }
        // 3. size가 0이 아니면 매칭이 안 된다는 의미
        if (size != 0) return "no";
        else return "yes";
    }
}
