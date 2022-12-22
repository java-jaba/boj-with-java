import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AgeSorting10814 {
    public static void main(String[] args) throws IOException {
        // 백준 10814. 나이순 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 최대 나이만큼 StringBuilder 배열 생성해서 채우기
        StringBuilder[] ages = new StringBuilder[201];
        for (int i = 0; i < ages.length; i++) {
            ages[i] = new StringBuilder();
        }
        
        // 나이를 인덱스로 해서 이름 붙이기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            ages[age].append(age).append(' ').append(name).append('\n');
        }
        
        // 순서대로 출력하면 정렬되어 있음
        StringBuilder sb = new StringBuilder();
        for (StringBuilder val : ages) {
            sb.append(val);
        }

        System.out.println(sb);

    }
}
