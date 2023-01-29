package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj10816_hash {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /**
         * hashmap 사용
         * key = 입력되는 원소
         * value = 원소의 개수(=중복 입력 된 원소의 수)
         */
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int key = Integer.parseInt(st.nextToken());

            // getOrDefault : key값이 존재하면 +1, 존재하지 않으면 0
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(key, 0) + " ");
        }

        System.out.println(sb);
    }
}
