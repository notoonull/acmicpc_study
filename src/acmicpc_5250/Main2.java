//package acmicpc_5250;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//// timeout
//public class Main2 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		int a = Integer.parseInt(st.nextToken());
//		int b = Integer.parseInt(st.nextToken());
//
//		Graph g = new Graph(n, m, a, b);
//		int u, v, w;
//		for (int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine());
//			u = Integer.parseInt(st.nextToken());
//			v = Integer.parseInt(st.nextToken());
//			w = Integer.parseInt(st.nextToken());
//			g.addEdge(u, v, w);
//			g.addEdge(v, u, w);
//		}
//		st = new StringTokenizer(br.readLine());
//		int k = Integer.parseInt(st.nextToken());
//		int[] path = new int[k];
//		for (int i = 0; i < k; i++) {
//			path[i] = Integer.parseInt(st.nextToken());
//		}
//		g.addPath(path);
//		g.calculateResults();
//		g.printResults();
//	}
//}
//
//class Graph {
//	int n, m;
//	int a, b;
//	Node[] nodes;
//	int[] path;
//	int phase;
//	int[] results;
//
//	Graph(int n, int m, int a, int b) {
//		this.n = n;
//		this.m = m;
//		this.a = a;
//		this.b = b;
//		nodes = new Node[n + 1];
//		for (int i = 1; i <= n; i++) {
//			nodes[i] = new Node(i);
//		}
//		this.phase = 0;
//	}
//
//	void addEdge(int u, int v, int w) {
//		nodes[u].addEdge(v, w);
//	}
//
//	void addPath(int[] path) {
//		this.path = path;
//	}
//
//	void calculateResults() {
//		int k = this.path.length;
//		results = new int[k - 1];
//		for (int i = 0; i < k - 1; i++) {
//			this.phase = i;
//			dijkstra(a);
//			results[i] = nodes[b].distance;
//		}
//	}
//
//	void printResults() {
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < this.results.length; i++) {
//			int result = this.results[i];
//			if (result == Integer.MAX_VALUE) {
//				sb.append(-1 + "\n");
//			} else {
//				sb.append(result + "\n");
//			}
//		}
//		System.out.println(sb.toString());
//	}
//
//	void dijkstra(int start) {
//		for (int i = 1; i <= n; i++) {
//			nodes[i].distance = Integer.MAX_VALUE;
//		}
//		nodes[start].distance = 0;
//
//		PriorityQueue<Node> q = new PriorityQueue<Node>();
//		q.offer(nodes[start]);
//		while (!q.isEmpty()) {
//			Node target = q.poll();
//			Iterator<Edge> it = target.edges.iterator();
//			while (it.hasNext()) {
//				Edge e = it.next();
//				if (canGo(target.number, e.destination)) {
//					int d = target.distance + e.weight;
//					if (d >= 0 && nodes[e.destination].distance > d) {
//						nodes[e.destination].distance = d;
//						q.offer(nodes[e.destination]);
//					}
//				}
//			}
//		}
//	}
//
//	boolean canGo(int u, int v) {
//		if (this.path[this.phase] == u && this.path[this.phase + 1] == v) {
//			return false;
//		}
//		return true;
//	}
//}
//
//class Node implements Comparable<Node> {
//	ArrayList<Edge> edges;
//	int number;
//	int distance;
//
//	Node(int number) {
//		this.number = number;
//		this.distance = Integer.MAX_VALUE;
//		edges = new ArrayList<Edge>();
//	}
//
//	void addEdge(int v, int w) {
//		edges.add(new Edge(v, w));
//	}
//
//	@Override
//	public int compareTo(Node o) {
//		if (this.distance < o.distance) {
//			return -1;
//		}
//		if (this.distance > o.distance) {
//			return 1;
//		}
//		return 0;
//	}
//}
//
//class Edge {
//	int destination;
//	int weight;
//
//	Edge(int destination, int weight) {
//		this.destination = destination;
//		this.weight = weight;
//	}
//}