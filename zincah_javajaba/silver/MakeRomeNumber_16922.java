package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MakeRomeNumber_16922 {

	static int N; // 사용할 수 있는 문자의 개수
	static int[] romaArray = {1, 5, 10, 50}; // 로마 숫자의 값
	static boolean[] visit; // 나왔던 수 인지 체크해주는 배열
	static int result; // 결과
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			N = Integer.parseInt(br.readLine()); // 입력
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		visit = new boolean[50 * 20 + 1]; // 50이라는 수가 20번이 나올 수 있기에 배열이 0 ~ 1000까지 존재 하도록 설계

		dfs(0,0,0); // 백트래킹
		//bruteforce();
		System.out.println(result);
	}
	
	public static void dfs(int depth, int start, int sum) {
		
		// 깊이우선탐색 방법
		
		if(depth == N) { // 깊이와 입력받은 수가 같다면 
			if(!visit[sum]) { // ex 50, 1이라는 로마 숫자의 조합을 통해 sum = 51이고 boolean 배열에 51이 false라면
				visit[sum] = true; // visit[51]을 true로 visit
				result++;
			}
			return;
		}
		
		for(int i=start; i<romaArray.length; i++) {

			// depth+1 : 깊이를 증가시켜준다. 0 -> 1 -> 2
			// sum+romaArray[i] : 깊이만큼 sum에 로마수를 더해준다.
			dfs(depth+1, i, sum+romaArray[i]); 
		}

	}
	
	public static void bruteforce() {
		
		// 브루트포스 방법
		
		for(int i=0; i<=N; i++) { // 1의 개수
			for(int j=0; j<=N-i; j++) { // 5의 개수
				for(int k=0; k<=N-i-j; k++) { // 10의 개수
					int l = N-i-j-k; // 50의 개수
					int sum = i*1 + j*5 + k*10 + l*50;
					if(!visit[sum]) {
						visit[sum]=true;
						result++;
					}
				}
			}
		}

	}

}
