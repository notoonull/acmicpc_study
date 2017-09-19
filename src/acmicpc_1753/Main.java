package acmicpc_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Edge> edges[];
	static boolean visited[];
	static int distance[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		visited = new boolean[V + 1];
		edges = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			edges[i] = new ArrayList<Edge>();
		}

		// init edges
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(u, v, w));
		}

		// init data

		distance = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[K] = 0;
		for (int i = 0; i < edges[K].size(); i++) {
			int updateDistance = edges[K].get(i).weight;
			if (updateDistance >= 0
					&& distance[edges[K].get(i).end] > updateDistance) {
				distance[edges[K].get(i).end] = updateDistance;
			}
		}

		visited[K] = true;
		while (!checkVisitAll(visited)) {
			int minNode = 1;
			for (int i = 1; i < distance.length; i++) {
				if (!visited[i]) {
					minNode = i;
					break;
				}
			}
			for (int i = 1; i < distance.length; i++) {
				if (!visited[i]) {
					if (distance[minNode] > distance[i]) {
						minNode = i;
					}
				}
			}

			for (int i = 0; i < edges[minNode].size(); i++) {
				int updateDistance = distance[minNode]
						+ edges[minNode].get(i).weight;
				if (updateDistance >= 0
						&& distance[edges[minNode].get(i).end] > updateDistance) {
					distance[edges[minNode].get(i).end] = updateDistance;
				}
			}
			visited[minNode] = true;
		}

		for (int i = 1; i <= V; i++) {
			System.out.println((distance[i] == Integer.MAX_VALUE) ? ("INF")
					: (distance[i]));
		}
	}

	public static boolean checkVisitAll(boolean visited[]) {
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}
}

class Edge {
	int start;
	int end;
	int weight;

	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
