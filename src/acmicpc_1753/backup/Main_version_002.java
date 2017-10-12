package acmicpc_1753.backup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_version_002 {
	static ArrayList<Edge> edges[];
	static boolean visited[];
	static DistanceInfo distance[];
	static PriorityQueue<DistanceInfo> pq;

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
		distance = new DistanceInfo[V + 1];
		for (int i = 0; i <= V; i++) {
			distance[i] = new DistanceInfo(i, Integer.MAX_VALUE);
		}
		distance[K].value = 0;
		
		pq = new PriorityQueue<DistanceInfo>();
		fillQueue(V);
		
		while (!pq.isEmpty()) {	
			DistanceInfo target = pq.poll();;
			int minNode = target.index;
			visited[minNode] = true;
			
			Iterator it = edges[minNode].iterator();
			while(it.hasNext()) {
				Edge e = (Edge)it.next();
				int updateDistance = distance[minNode].value + e.weight;
				if (updateDistance >= 0 && distance[e.end].value > updateDistance) {
					distance[e.end].value = updateDistance;
				}
			}
			fillQueue(V);
		}

		for (int i = 1; i <= V; i++) {
			System.out.println((distance[i].value == Integer.MAX_VALUE) ? ("INF") : (distance[i].value));
		}
	}
	
	public static void fillQueue(int V) {
		pq.clear();
		for (int i = 0; i <= V; i++) {
			if(!visited[i]) pq.offer(distance[i]);
		}
	}
}

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

class DistanceInfo implements Comparable<DistanceInfo> {
	public int index;
	public int value;
	
	public DistanceInfo (int index, int value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(DistanceInfo dist) {
		if(this.value < dist.value) {
			return -1;
		}
		else if (this.value > dist.value) {
			return 1;			
		}
		return 0;
	}
}