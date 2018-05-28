package acmicpc_1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int result;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		result = 0;
		
		parents = new int[V+1];
		for (int i=1;i<=V;i++) {
			parents[i] = i;
		}
		
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			Edge e = new Edge(A, B, C);
			q.offer(e);
		}

		while (!q.isEmpty()) {
			Edge e = q.poll();
			int start = e.start;
			int end = e.end;
			
			int rootStart = find(start);
			int rootEnd = find(end);
			
			if (rootStart != rootEnd) {
				parents[rootStart] = rootEnd;
				result += e.weight;
			}
		}
		
		System.out.println(result);
	}
	
	static int find(int p) {
		if (parents[p] == p) return parents[p];
		else return find(parents[p]);
	}
}

class Edge implements Comparable<Edge> {
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
		if (this.weight < o.weight) {
			return -1;
		}
		if (this.weight > o.weight) {
			return 1;
		}
		return 0;
	}
}
