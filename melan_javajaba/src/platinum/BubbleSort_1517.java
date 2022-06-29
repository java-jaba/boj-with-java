package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BubbleSort_1517 {
		
	static long Answer; // swap 횟수
    static int arrcopy[]; // 배열의 복사본
    static int arr[]; // 배열
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 배열의 길이 받기
        int N = Integer.parseInt(br.readLine());
        
        // 길이에 맞는 배열 생성해서 입력값으로 채우기
        arr = new int[N];
        arrcopy = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Answer = 0;
        merge(0, N - 1); 
        System.out.println(Answer);
        
        Arrays.sort(arr);
    }
    public static void merge(int left, int right) { 
 
        if (left != right) {
            int mid = (left + right) / 2; 
          
            merge(left, mid); 
 
            merge(mid + 1, right); 
      
            mergeSort(left, right);
        }
    }
 
    private static void mergeSort(int left, int right) { 
        int mid = (left + right) / 2; 	
        int i = left; 					
        int j = mid + 1; 				
        int k = left; 					
 
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) { 
                arrcopy[k++] = arr[j++];
                Answer+= mid -i+1;
            } else { 
                arrcopy[k++] = arr[i++];
 
            }
        }
 
        if (i > mid) {
            while (j <= right) {
                arrcopy[k++] = arr[j++];
            }
        } else {
            while (i <= mid) {
                arrcopy[k++] = arr[i++];
            }
        }
 
        for (k = left; k <= right; k++) {
            arr[k] = arrcopy[k];
        }
    }

}
