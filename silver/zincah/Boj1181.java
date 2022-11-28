package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            // key 값 : 단어, value 값 : 단어 길이
            // key 값이 동일할 경우 한가지만 저장되기에 같은 단어는 1개만 출력하라는 조건을 만족시킬 수 있다.
            map.put(str, str.length());
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        // Comparator 사용 (오름차순 : -1, 동일 : 0, 내림차순 : 1)
        // 1. value 값이 같은 경우 key 정렬
        // 2. value 값이 다른 경우 value 정렬
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {

            int ret = 0;
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                // 1. value 값이 같은 경우
                if(o1.getValue()==o2.getValue()){

                    // key 값으로 오름차순 정렬
                    if(o1.getKey().compareTo(o2.getKey()) < 0){
                        return -1;
                    }else if(o1.getKey().compareTo(o2.getKey()) > 0){
                        return 1;
                    }
                }

                // 2. value 값이 다른 경우 value 값으로 오름차순 정렬
                return o1.getValue() - o2.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry : entryList){
            System.out.println(entry.getKey());
        }
    }
}
