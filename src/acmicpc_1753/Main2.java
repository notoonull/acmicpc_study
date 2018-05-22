//package acmicpc_1753;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Main2 {
//	static BufferedReader br;
//	static StringTokenizer st;
//
//	static int V;
//	static int E;
//	static int K;
//	static int[] d;
//
//	public static void main(String[] args) throws Exception {
//		br = new BufferedReader(new InputStreamReader(System.in));
//		st = new StringTokenizer(br.readLine());
//		V = Integer.parseInt(st.nextToken());
//		E = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(br.readLine());
//
//		Graph g = new Graph(V, E);
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//			int u = Integer.parseInt(st.nextToken());
//			int v = Integer.parseInt(st.nextToken());
//			int w = Integer.parseInt(st.nextToken());
//			g.addEdge(u, v, w);
//		}
//		g.dijkstra(K);
//		g.printDistance();
//	}
//}
//
//class Graph {
//	int V, E;
//	Node[] nodes;
//	int[] distance;
//
//	Graph(int V, int E) {
//		this.V = V;
//		this.E = E;
//		nodes = new Node[V + 1];
//		for (int i = 1; i <= V; i++) {
//			nodes[i] = new Node();
//		}
//	}
//
//	void addEdge(int u, int v, int w) {
//		nodes[u].addEdge(new Edge(v, w));
//	}
//
//	void dijkstra(int start) {
//		distance = new int[V + 1];
//		for (int i = 1; i <= V; i++) {
//			distance[i] = Integer.MAX_VALUE;
//		}
//		distance[start] = 0;
//
//		PriorityQueue<Distance> q = new PriorityQueue<Distance>();
//		q.offer(new Distance(start, 0));
//
//		Distance target;
//		int curr;
//		while (!q.isEmpty()) {
//			target = q.poll();
//			curr = target.node;
//
//			Iterator<Edge> it = nodes[curr].edges.iterator();
//			while (it.hasNext()) {
//				Edge e = it.next();
//				int linked = e.dest;
//
//				int d = distance[curr] + e.cost;
//				if (distance[linked] > d) {
//					if (d >= 0) {
//						distance[linked] = distance[curr] + e.cost;
//						q.offer(new Distance(linked, distance[linked]));
//					}
//				}
//			}
//		}
//	}
//
//	void printDistance() {
//		StringBuilder sb = new StringBuilder();
//		for (int i = 1; i <= V; i++) {
//			int _d = distance[i];
//			if (_d == Integer.MAX_VALUE) {
//				sb.append("INF\n");
//			} else {
//				sb.append(distance[i] + "\n");
//			}
//		}
//		System.out.println(sb);
//	}
//}
//
//class Node {
//	ArrayList<Edge> edges;
//
//	Node() {
//		edges = new ArrayList<Edge>();
//	}
//
//	void addEdge(Edge e) {
//		edges.add(e);
//	}
//}
//
//class Edge {
//	int dest;
//	int cost;
//
//	Edge(int dest, int cost) {
//		this.dest = dest;
//		this.cost = cost;
//	}
//}
//
//class Distance implements Comparable<Distance> {
//	int node;
//	int distance;
//
//	Distance(int node, int distance) {
//		this.node = node;
//		this.distance = distance;
//	}
//
//	@Override
//	public int compareTo(Distance o) {
//		if (this.distance > o.distance) {
//			return 1;
//		} else if (this.distance < o.distance) {
//			return -1;
//		}
//		return 0;
//	}
//}