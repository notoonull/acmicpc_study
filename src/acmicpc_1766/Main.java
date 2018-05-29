package acmicpc_1766;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M;
	static ArrayList<ArrayList<Integer>> nodes;
	static int[] inDegree;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		inDegree = new int[N];
		nodes = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			nodes.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodes.get(start - 1).add(end - 1);
			inDegree[end - 1]++;
		}

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}

		int count = 0;
		while (!q.isEmpty()) {
			count++;
			int node = q.poll();
			sb.append((node + 1)+" ");
			
			Iterator<Integer> it = nodes.get(node).iterator();
			while (it.hasNext()) {
				int linked = it.next();
				if (--inDegree[linked] == 0) {
					q.offer(linked);
				}
			}
		}
		if (count != N) System.out.println("hasCycle");
		else System.out.println(sb);		
	}
}
