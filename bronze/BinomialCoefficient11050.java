import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11050. 이항계수1
public class BinomialCoefficient11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(factorial(n) / (factorial(n-k) * factorial(k)));

    }

    static int factorial(int n) {
        // factorial(0) == 1
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n-1);    }
}
