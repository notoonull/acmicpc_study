package acmicpc_10845;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static CustomQueue q = new CustomQueue();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cm = st.nextToken();
			int param = (st.hasMoreTokens()) ? (Integer.parseInt(st.nextToken())) : (0);
			executeCommand(cm, param);
		}
	}

	static void executeCommand(String command, int param) {
		switch (command) {
		case "push":
			q.push(param);
			break;
		case "pop":
			System.out.println(q.pop());
			break;
		case "size":
			System.out.println(q.size());
			break;
		case "empty":
			System.out.println(q.empty());
			break;
		case "front":
			System.out.println(q.front());
			break;
		case "back":
			System.out.println(q.back());
			break;
		}
	}
}

class CustomQueue {
	LinkedList<Integer> storage;

	CustomQueue() {
		storage = new LinkedList<Integer>();
	}

	void push(int param) {
		storage.add(param);
	}

	int pop() {
		if (this.empty() == 1)
			return -1;
		return storage.removeFirst();
	}

	int size() {
		return storage.size();
	}

	int empty() {
		if (storage.isEmpty())
			return 1;
		return 0;
	}

	int front() {
		if (this.empty() == 1)
			return -1;
		return storage.getFirst();
	}

	int back() {
		if (this.empty() == 1)
			return -1;
		return storage.getLast();
	}
}