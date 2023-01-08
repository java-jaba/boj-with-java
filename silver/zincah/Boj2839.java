package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2839. 설탕배달
public class Boj2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 값이 들어오면 5로 나누어 떨어지는 지 검증하고 나누어 떨어지면 몫 리턴
        // 2. 나누어 떨어지지 않으면 5로 나눈 몫이 0인지 아닌지를 검증
        // 3-1. 5로 나눈 몫이 0인 경우 3으로 나누어 떨어지면 3으로 나눈 몫을 리턴 아니면 -1리턴
        // 3-2. 5로 나눈 몫이 0이 아닌 경우 0까지 다음과 같은 과정을 반복한다.
        //      5로 나눈 나머지를 rest 변수에 저장
        //      rest 변수가 3으로 나누어 떨어지면 결과값에 5로 나눌 때의 몫과 나머지가 3으로 나누어 떨어진 몫을 더해서 리턴
        //      나누어 떨어지지 않으면 나누어 떨어질 때까지 반복
        // 4. 3의 과정에서 결과값이 구해지지 않았을 경우 -1리턴

        int result = 0;

        if (N % 5 == 0) { // 1.
            result = N / 5;
        } else { // 2.
            if (N / 5 == 0) { // 3-1.
                if (N % 3 == 0) {
                    result = N / 3;
                } else {
                    result = -1;
                }
            } else { // 3-2.

                boolean check = false;
                int share = N / 5;
                for (int i = share; i >= 0; i--) { // 3-2.
                    int rest = N - i * 5;
                    if (rest % 3 == 0) {
                        result = rest / 3;
                        result = result + i;
                        check = true;
                        break;
                    }
                }

                if (check == false) { // 4.
                    result = -1;
                }
            }
        }

        System.out.println(result);
    }
}
