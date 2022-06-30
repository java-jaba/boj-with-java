package test01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


class Point{
	int num;
	int x;
	int y;
	int z;
	
	Point(int num, int x, int y, int z) {
		
		this.num = num;
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
}

class Edge implements Comparable<Edge>{
	// comparable -> 정렬
	int start;
	int end;
	int weight;
	
	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}
	
}

public class PlanetTurnel_2887 {
	
	// 크루스칼 알고리즘 과정
	// 1. 간선의 가중치를 오름차순으로 정렬
	// 2. 정렬된 간선 중에서 순서대로(가중치가 낮은 순으로)간선을 조회한다.
	// 2-1. 간선을 선택할 시, 사이클이 형성되면 다음 간선으로 넘어간다.
	// 2-2. 사이클이 형성되지 않으면 해당 간선을 선택한다.
	// 3. 정점의 개수가 N일때, N-1만큼 간선을 뽑았다면 반복문을 종료한다.
	
	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 입력
		
		Point[] points = new Point[N];
		
		for(int i=0; i<N; i++) { // 입력
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(i, x, y, z);
		}
		
		edgeList = new ArrayList<Edge>();
		
		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
		for(int i=0; i<N-1; i++) {
			int weight = Math.abs(points[i].x - points[i+1].x); // x좌표 절댓값
			edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
		}
		
		Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
		for(int i=0; i<N-1; i++) {
			int weight = Math.abs(points[i].y - points[i+1].y); // y좌표 절댓값
			edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
		}
		
		Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
		for(int i=0; i<N-1; i++) {
			int weight = Math.abs(points[i].z - points[i+1].z); // z좌표 절댓값
			edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
		}
		
		parent = new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(edgeList);
		
		int ans = 0;
		for(int i=0; i<edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			// 사이클 발생 간선 제외
			if(find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
			
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	// union : 서로 다른 두개의 집합을 병합
	// find : 원소가 어느 집합에 속해있는지 찾는다.
	
	public static int find(int x) {
		if(x == parent[x]) { // 자기 자신을 가르키면 부모
			return x;
		}
		
		return parent[x] = find(parent[x]); // 재귀
	}
	
	public static void union(int x, int y) {
		x = find(x); // 부모를 찾아주는 과정
		y = find(y); // 부모를 찾아주는 과정
		
		if(x != y) {
			parent[y] = x; // 부모를 x로 맞춰준다.
		}
	}
}
