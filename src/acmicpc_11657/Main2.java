//package acmicpc_11657;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main2 {
//	static int distance[];
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//
//		Edge edges[] = new Edge[M];
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			int weight = Integer.parseInt(st.nextToken());
//			edges[i] = new Edge(start, end, weight);
//		}
//
//		distance = new int[N + 1];
//		distance[1] = 0;
//		for (int i = 2; i <= N; i++) {
//			distance[i] = Integer.MAX_VALUE;
//		}
//
//		boolean updated = false;
//		for (int k = 0; k < N; k++) {
//			updated = false;
//			for (int i = 0; i < M; i++) {
//				if (distance[edges[i].start] != Integer.MAX_VALUE) {
//					int currentDistance = distance[edges[i].start] + edges[i].weight;
//					if (distance[edges[i].end] > currentDistance) {
//						distance[edges[i].end] = currentDistance;
//						updated = true;
//					}
//				}
//			}
//			if (!updated) break;
//		}
//
//		int result;
//		if (updated) {
//			result = -1;
//			System.out.println(result);
//		} else {
//			for (int i = 2; i <= N; i++) {
//				if (distance[i] == Integer.MAX_VALUE) {
//					result = -1;
//				} else {
//					result = distance[i];
//				}
//				System.out.println(result);
//			}
//		}
//	}
//}
//
//class Edge {
//	int start;
//	int end;
//	int weight;
//
//	public Edge(int start, int end, int weight) {
//		this.start = start;
//		this.end = end;
//		this.weight = weight;
//	}
//}
