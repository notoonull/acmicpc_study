package acmicpc_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static int V;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		Node[] nodes = new Node[N + 1];
		initNode(nodes);
		linkNode(nodes);

		Graph g = new Graph(nodes);
		System.out.println(g.DFS(V));
		System.out.println(g.BFS(V));
	}

	static void initNode(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}
	}

	static void linkNode(Node[] nodes) throws Exception {
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			nodes[u].link(v);
			nodes[v].link(u);
		}
	}
}

class Graph {
	Node[] nodes;
	static boolean[] visit;
	static StringBuilder sb;
	static Queue<Integer> q;

	Graph(Node[] nodes) {
		this.nodes = nodes;
	}

	String DFS(int start) {
		visit = new boolean[this.nodes.length + 1];
		sb = new StringBuilder();

		_dfs(start);

		return sb.toString().trim();
	}

	void _dfs(int target) {
		visit[target] = true;
		sb.append(target + " ");

		Iterator<Integer> it = this.nodes[target].linkedNode.iterator();
		while (it.hasNext()) {
			int nextNode = it.next();
			if (!visit[nextNode]) {
				_dfs(nextNode);
			}
		}
	}

	String BFS(int start) {
		visit = new boolean[this.nodes.length + 1];
		sb = new StringBuilder();

		q = new LinkedList<Integer>();

		_bfs(start);

		return sb.toString().trim();
	}

	void _bfs(int target) {
		visit[target] = true;
		sb.append(target + " ");
		q.offer(target);

		while (!q.isEmpty()) {
			int nextNode = q.poll();

			Iterator<Integer> it = this.nodes[nextNode].linkedNode.iterator();
			while (it.hasNext()) {
				int linkedNode = it.next();
				if (!visit[linkedNode]) {
					visit[linkedNode] = true;
					sb.append(linkedNode + " ");
					q.offer(linkedNode);
				}
			}
		}
	}
}

class Node {
	int number;
	TreeSet<Integer> linkedNode = new TreeSet<Integer>();

	Node(int number) {
		this.number = number;
	}

	void link(int node) {
		linkedNode.add(node);
	}
}