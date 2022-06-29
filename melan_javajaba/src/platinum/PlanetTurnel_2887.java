package platinum;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PlanetTurnel_2887 {
	
	static int n; // 행성의 개수
	static PriorityQueue<Edge> q; // 엣지정보 우선순위 큐
	static int[] parent; // 대표노드 저장배열
	static int result; // 정답
	static Planet[] planet; // 행성배열
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 행성의 개수 입력받기
		
		planet = new Planet[n]; // 행성 개수만큼 행성 객체 생성
		
		for (int i = 0; i < n; i++) { // 각 행성의 (x, y, z) 좌표값 채우기
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			planet[i] = new Planet(i, x, y, z);
		}
		
		q = new PriorityQueue<>();
		
		// x좌표 순서대로 오름차순 정렬 후 작은 값부터 q에 edge 정보 저장
		Arrays.sort(planet, (o1, o2) -> o1.x - o2.x); // x변수를 기준으로 정렬
		for (int i = 0; i < n - 1; i++) {
			q.offer(new Edge(planet[i].num, planet[i+1].num, Math.abs(planet[i].x - planet[i+1].x)));
		}
		
		// y좌표 순서대로 오름차순 정렬 후 작은 값부터 q에 edge 정보 저장
		Arrays.sort(planet, (o1, o2) -> o1.y - o2.y); // y변수를 기준으로 정렬
		for (int i = 0; i < n - 1; i++) {
			q.offer(new Edge(planet[i].num, planet[i+1].num, Math.abs(planet[i].y - planet[i+1].y)));
		}
		
		// z좌표 순서대로 오름차순 정렬 후 작은 값부터 q에 edge 정보 저장
		Arrays.sort(planet, (o1, o2) -> o1.z - o2.z); // z변수를 기준으로 정렬
		for (int i = 0; i < n - 1; i++) {
			q.offer(new Edge(planet[i].num, planet[i+1].num, Math.abs(planet[i].z - planet[i+1].z)));
		}		
		
		parent = new int[n];
		kruskal();
		System.out.println(result);
		
	}
	
	/* 행성 */
	public static class Planet {
		
		int num; 	// 행성 번호
		int x; 		// x좌표
		int y; 		// y좌표
		int z; 		// z좌표
		
		public Planet(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	
	}
	
	/* 엣지 */
	public static class Edge implements Comparable<Edge> {
		
		int s;
		int e;
		int cost;
		
		public Edge(int s, int e, int cost) {
			super();
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}

	}
	
	public static void kruskal() {
		for (int i = 0; i < n; i++) { // 대표노드 배열 초기화
			parent[i] = i;
		}
		
		while (!q.isEmpty()) { // 큐가 빌 때까지
			Edge edge = q.poll(); // 우선순위 높은 엣지 뽑아서
			int p1 = find(edge.s); // 대표노드 찾고
			int p2 = find(edge.e);
			
			if (p1 != p2) { // 비교해서 다르면 
				union(p1, p2); // 유니온 연산 실행 
				result += edge.cost; // 정답 변수에 가중치 추가
			}
		}
	}
	
	public static void union(int a, int b) {
		parent[a] = b;
	}
	
	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}
	
}
