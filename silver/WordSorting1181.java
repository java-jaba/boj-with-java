import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
// 백준 1181. 단어 정렬
public class WordSorting1181 {
    public static void main(String[] args) throws IOException {

        // 입력받아서 배열에 답기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        // 배열 정렬하기
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 단어가 같을 경우 사전순으로 나열
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                // 그 외의 경우 짧은 순으로 나열
                } else {
                    return a.length() - b.length();
                }
            }
        });

        // 다시 배열한 단어들을 합치기
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append('\n');

        for (int i = 1; i < n; i++) {
            // 중복제거
            if (!words[i].equals(words[i-1])) {
                sb.append(words[i]).append('\n');
            }
        }
        System.out.println(sb);

    }
}
