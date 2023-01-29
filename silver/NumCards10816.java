import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
// 10816. 숫자 카드2
public class NumCards10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        HashMap<Integer, Integer> map = new HashMap<>(); // (카드번호, 카드갯수)
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        StringBuilder sb = new StringBuilder(); // 정답으로 출력할 sb
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < m; j++) {
            int tmp = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(tmp, 0)).append(' '); // 있으면 그 값, 없으면 0 출력
        }
        System.out.println(sb);

    }
}
