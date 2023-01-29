package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10816_counting {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] counting = new int[20000001]; // int 범위 내로 배열이 생성되어야 한다.

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            // counting 배열에서 주어진 값으로 인덱스의 값을 증가시킨다.
            counting[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            // counting 배열 인덱스로 값을 찾아서 출력한다.
            sb.append(counting[Integer.parseInt(st.nextToken()) + 10000000] + " ");
        }

        System.out.println(sb);
    }
}
