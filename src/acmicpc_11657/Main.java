package acmicpc_11657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static ArrayList<Edge> edges;
	static int[] distance;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		edges = new ArrayList<Edge>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges.add(new Edge(A, B, C));
		}

		boolean updated = false;
		for (int i = 0; i < N; i++) {
			updated = false;
			Iterator<Edge> it = edges.iterator();
			while (it.hasNext()) {
				Edge e = it.next();
				int start = e.start;
				int end = e.end;
				int weight = e.weight;

				if (distance[start] != Integer.MAX_VALUE) {
					if (distance[end] > distance[start] + weight) {
						distance[end] = distance[start] + weight;
						updated = true;
					}
				}
			}

			if (!updated)
				break;
		}

		if (updated) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				if (distance[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				} else {
					System.out.println(distance[i]);
				}
			}
		}

	}

	static class Edge {
		int start;
		int end;
		int weight;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
}