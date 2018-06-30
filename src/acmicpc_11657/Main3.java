//package acmicpc_11657;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.StringTokenizer;
//
//public class Main3 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N, M;
//		int A, B, C;
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		Graph g = new Graph(N, M);
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			A = Integer.parseInt(st.nextToken());
//			B = Integer.parseInt(st.nextToken());
//			C = Integer.parseInt(st.nextToken());
//			g.addEdge(A, B, C);
//		}
//		g.bellman_ford(1);
//		g.printResults();
//
//	}
//}
//
//class Graph {
//	int N, M;
//	Node[] nodes;
//	boolean hasCycle;
//
//	Graph(int N, int M) {
//		this.N = N;
//		this.M = M;
//		nodes = new Node[N + 1];
//		for (int i = 1; i <= N; i++) {
//			nodes[i] = new Node(i);
//		}
//	}
//
//	void addEdge(int u, int v, int w) {
//		nodes[u].addEdge(v, w);
//	}
//
//	void bellman_ford(int start) {
//		for (int i = 1; i <= N; i++) {
//			nodes[i].distance = Integer.MAX_VALUE;
//		}
//		nodes[start].distance = 0;
//		hasCycle = false;
//
//		boolean updated = false;
//		for (int k = 0; k < N; k++) {
//			updated = false;
//			for (int i = 1; i <= N; i++) {
//				Iterator<Edge> it = nodes[i].edges.iterator();
//				while (it.hasNext()) {
//					Edge e = it.next();
//					if (nodes[i].distance != Integer.MAX_VALUE) {
//						if (nodes[e.v].distance > nodes[i].distance + e.w) {
//							nodes[e.v].distance = nodes[i].distance + e.w;
//							updated = true;
//						}
//					}
//				}
//			}
//			if (!updated)
//				break;
//		}
//		hasCycle = updated;
//	}
//
//	void printResults() {
//		StringBuilder sb = new StringBuilder();
//		if (hasCycle) {
//			sb.append("-1\n");
//		} else {
//			for (int i = 2; i <= N; i++) {
//				if (nodes[i].distance == Integer.MAX_VALUE) {
//					sb.append("-1\n");
//				} else {
//					sb.append(nodes[i].distance + "\n");
//				}
//			}
//		}
//		System.out.println(sb.toString());
//	}
//}
//
//class Node {
//	int number;
//	ArrayList<Edge> edges;
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
//}
//
//class Edge {
//	int v, w;
//
//	Edge(int v, int w) {
//		this.v = v;
//		this.w = w;
//	}
//}