package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 10816. 숫자 카드2
// 이분탐색 활용
public class Boj10816_binary {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상근이가 가지고 있는 숫자 카드 개수 및 리스트
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] card = new int[N];

        for(int i=0; i<N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        // 주어진 카드에서 상근이의 카드에 몇개가 존재하는지 맞춰야하는 카드 개수 및 리스트
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(rightStep(card, key) - leftStep(card, key) + " ");
        }

        System.out.println(sb);
    }

    public static int leftStep(int[] arr, int key){
        int left = 0;
        int right = arr.length;

        while(left < right){

            int mid = (left + right)/2;

            // key 값이 중간 위치의 값보다 같거나 작을 경우 왼쪽으로 탐색하도록 한다.
            // left에 key값의 시작위치를 저장한다.
            if(key <= arr[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public static int rightStep(int[] arr, int key){
        int left = 0;
        int right = arr.length;

        while(left < right){

            int mid = (left + right)/2;

            // key값이 중간 위치의 값보다 작을 경우 right 에 중간값을 저장한다.
            // left에 key값이 끝나는 위치보다 1 더한 값을 저장한다.
            if(key < arr[mid]){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
    }
}
