package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2689 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());    // 나무 막대 높이
        int B = Integer.parseInt(st.nextToken());    // 달팽이가 낮에 올라가는 높이
        int V = Integer.parseInt(st.nextToken());    // 달팽이가 밤에 미끄러지는 높이

        // 낮에 올라가있는 높이가 나무 막대 높이보다 낮을 경우
        // 총 하루에 움직이는 높이 = 올라가는 높이 - 미끄러지는 높이
        // 따라서 미끄러지는 높이를 뺀 나무 막대 높이를
        // 총 하루에 움직이는 높이로 나눠줬을 때의 몫으로
        // 몇일이 걸리는 지를 구할 수 있다.
        int dayCount = (V-B)/(A-B);

        if((V-B)%(A-B)!=0){
            // 0으로 딱 떨어지지 않는 경우에는 하루를 남은 높이로 인해 하루를 더해준다.
            dayCount++;
        }

        System.out.println(dayCount);

    }
}
