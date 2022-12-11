import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sorting2751 {
	// 2751. 수 정렬하기 2
	public static int[] A, tmp; // 정렬할 배열, 임시배열
	public static long result; // 결괏값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 정렬할 수 개수
		int N = Integer.parseInt(br.readLine());
		// 길이에 맞는 배열 생성해서 입력값으로 채우기
		A = new int[N+1];
		tmp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine()); 
		}
		
		mergeSort(1, N); // 5
		
		for (int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
		
	}
	
	private static void mergeSort(int start, int end) { // 1, 5
		// end와 start가 1 차이 라면 끝내기
		if (end - start < 1) {
			return;
		}
		
		int mid = start + (end - start) / 2; // 3
		
		mergeSort(start, mid); // 1, 3
		mergeSort(mid+1, end); // 4, 5
		
		for (int i = start; i<= end; i++) { // 1,2,3,4,5
			tmp[i] = A[i];
		}
		
		// 두 그룹을 병합
		int k = start;
		int idx1 = start; // 앞쪽 그룹 시작점
		int idx2 = mid + 1; // 뒤쪽 그룹 시작점
		
		while (idx1 <= mid && idx2 <= end) {
			if (tmp[idx1] > tmp[idx2]) { // 양쪽 그룹의 idx가 가리키는 값을 비교한후 더 작은 수를 선택해 배열에 저장
				A[k] = tmp[idx2]; // 선택된 데이터의 idx값을 오른쪽으로 한 칸 이동
				k++;
				idx2++;
			} else {
				A[k] = tmp[idx1];
				k++;
				idx1++;
			}
		}
		// 한쪽 그룹이 모두 선택된 후 남아있는 값 정리
		while (idx1 <= mid) {
			A[k] = tmp[idx1];
			k++;
			idx1++;
		}
		while (idx2 <= end) {
			A[k] = tmp[idx2];
			k++;
			idx2++;
		}
	}
}
