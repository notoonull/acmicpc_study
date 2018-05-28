package acmicpc_2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br;
	static int[][] graph;
	static int N;
	static int count;
	static boolean[][] visited;
	static int[] group_count;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine().trim();
			int length = line.length();
			for (int j = 1; j <= length; j++) {
				graph[i][j] = (line.charAt(j - 1) == '1') ? (1) : (0);
			}
		}

		group_count = new int[(N * N) / 2 + 1];
		visited = new boolean[N + 1][N + 1];
		count = 1;

		Queue<Point> q = new LinkedList<Point>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 1 && !visited[i][j]) {
					count++;
					q.offer(new Point(i, j));
				}

				while (!q.isEmpty()) {
					Point p = q.poll();
					int x = p.x;
					int y = p.y;
					if (!visited[x][y]) {
						visited[x][y] = true;
						graph[x][y] = count;
						group_count[count - 2]++;

						if (y != 1 && graph[x][y - 1] == 1 && !visited[x][y - 1]) {
							q.offer(new Point(x, y - 1));
						}
						if (y != N && graph[x][y + 1] == 1 && !visited[x][y + 1]) {
							q.offer(new Point(x, y + 1));
						}
						if (x != 1 && graph[x - 1][y] == 1 && !visited[x - 1][y]) {
							q.offer(new Point(x - 1, y));
						}
						if (x != N && graph[x + 1][y] == 1 && !visited[x + 1][y]) {
							q.offer(new Point(x + 1, y));
						}
					}
				}
			}
		}

		// printGraph();

		sb = new StringBuilder();
		sb.append(count - 1);
		sb.append("\n");

		int[] results = new int[count - 1];
		System.arraycopy(group_count, 0, results, 0, count - 1);
		Arrays.sort(results);

		for (int i = 0; i < count - 1; i++) {
			sb.append(results[i] + "\n");
		}
		System.out.println(sb);
	}

	static void printGraph() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
