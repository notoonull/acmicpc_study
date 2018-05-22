package acmicpc_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		Graph g = new Graph(V, E);
		int u, v, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			g.addEdge(u, v, w);
		}
		g.dijkstra(K);
		g.printDistance();
	}
}

class Graph {
	int V, E;
	Node[] nodes;

	Graph(int V, int E) {
		this.V = V;
		this.E = E;
		nodes = new Node[V + 1];
		for (int i = 1; i <= V; i++) {
			nodes[i] = new Node();
		}
	}

	void addEdge(int u, int v, int w) {
		nodes[u].addEdge(new Edge(v, w));
	}

	void dijkstra(int start) {
		nodes[start].distance = 0;

		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.offer(nodes[start]);

		Node target;
		int linked, d;
		while (!q.isEmpty()) {
			target = q.poll();

			Iterator<Edge> it = target.edges.iterator();
			while (it.hasNext()) {
				Edge e = it.next();
				linked = e.destination;

				d = target.distance + e.cost;
				if (nodes[linked].distance > d) {
					if (d >= 0) {
						nodes[linked].distance = d;
						q.offer(nodes[linked]);
					}
				}
			}
		}
	}

	void printDistance() {
		StringBuilder sb = new StringBuilder();
		int d;
		for (int i = 1; i <= V; i++) {
			d = nodes[i].distance;
			if (d == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(d + "\n");
			}
		}
		System.out.println(sb);
	}
}

class Node implements Comparable<Node> {
	int distance;
	ArrayList<Edge> edges;

	Node() {
		this.distance = Integer.MAX_VALUE;
		edges = new ArrayList<Edge>();
	}

	void addEdge(Edge e) {
		edges.add(e);
	}

	@Override
	public int compareTo(Node n) {
		if (this.distance < n.distance) {
			return -1;
		}
		if (this.distance > n.distance) {
			return 1;
		}
		return 0;
	}
}

class Edge {
	int destination;
	int cost;

	Edge(int destination, int cost) {
		this.destination = destination;
		this.cost = cost;
	}
}