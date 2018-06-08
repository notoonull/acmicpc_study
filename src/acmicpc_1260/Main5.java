package acmicpc_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static int V;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		list = new ArrayList<ArrayList<Integer>>();
		list.add(null);

		for (int i = 1; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}

		dfs();
		System.out.println();
		bfs();
	}

	static void dfs() {
		visited = new boolean[N + 1];
		_dfs(V);		
	}
	
	static void _dfs(int here) {
		visited[here] = true;
		System.out.print(here + " ");
		Iterator<Integer> it = list.get(here).iterator();
		while(it.hasNext()) {
			int there = it.next();
			if (!visited[there]) {
				_dfs(there);
			}
		}
	}

	static void bfs() {
		visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[V] = true;		
		q.offer(V);

		while (!q.isEmpty()) {
			int here = q.poll();			
			System.out.print(here + " ");
			Iterator<Integer> it = list.get(here).iterator();
			while(it.hasNext()) {
				int there = it.next();
				if (!visited[there]) {
					visited[there] = true;					
					q.offer(there);
				}
			}
		}
	}
}
