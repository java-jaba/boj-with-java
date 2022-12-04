package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1978 {

    // 백준 1978 : 소수 찾기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);
        int[] intArr = new int[N];
        for(int i=0; i<intArr.length; i++){
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0; // 소수 개수

        for(int i=0; i<intArr.length; i++){
            for(int j=1; j<=intArr[i]; j++){
                if(j!=1 && j!=intArr[i] && intArr[i]%j == 0){
                    break;
                }
                if(j!=1 && j==intArr[i]){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
