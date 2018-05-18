package acmicpc_11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Tree tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new Tree(N);
		StringTokenizer st;
		int node1;
		int node2;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			tree.insertEdge(node1, node2);
		}
		tree.generateParentTable();
		tree.printParentTable();
	}
}

class Node {
	ArrayList<Integer> children;

	Node() {
		children = new ArrayList<Integer>();
	}

	void addChild(int child) {
		children.add(child);
	}
}

class Tree {
	int max;

	Node[] nodes;
	int[] parentTable;
	boolean[] visit;

	Tree(int N) {
		max = N;
		parentTable = new int[N + 1];

		nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node();
		}
	}

	void insertEdge(int node1, int node2) {
		nodes[node1].addChild(node2);
		nodes[node2].addChild(node1);
	}

	void generateParentTable() {
		visit = new boolean[max + 1];

		Queue<Integer> q = new LinkedList<Integer>();
		visit[1] = true;
		q.offer(1);
		while (!q.isEmpty()) {
			int parent = q.poll();
			ArrayList<Integer> children = nodes[parent].children;
			Iterator<Integer> it = children.iterator();
			while(it.hasNext()) {
				int child = it.next();
				if (!visit[child]) {
					parentTable[child] = parent;
					visit[child] =true;
					q.offer(child);
				}
			}
		}
	}

	void printParentTable() {
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= max; i++) {
			sb.append(parentTable[i] + "\n");
		}
		System.out.println(sb.toString());
	}
}