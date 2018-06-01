package acmicpc_3665;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	static int N, M;
	static int[] original;
	static int[] hash;
	static boolean[][] map;
	static int[] inDegree;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int __t = 0; __t < T; __t++) {
			sb = new StringBuilder();

			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			// init map, inDegree
			inDegree = new int[N + 1];
			map = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = i + 1; j <= N; j++) {
					map[i][j] = true;
				}
				inDegree[i] = i - 1;
			}

			// read teams
			original = new int[N + 1];
			hash = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				hash[num] = i;
				original[i] = num;
				sb.append(num + " ");
			}

			// read M
			M = Integer.parseInt(br.readLine());
			if (M == 0) {
				System.out.println(sb);
			} else {
				sb = new StringBuilder();

				// read edges
				int start, end;
				for (int i = 0; i < M; i++) {
					st = new StringTokenizer(br.readLine());
					int team1 = Integer.parseInt(st.nextToken());
					int team2 = Integer.parseInt(st.nextToken());

					if (hash[team1] < hash[team2]) {
						start = hash[team2];
						end = hash[team1];
					} else {
						start = hash[team1];
						end = hash[team2];
					}

					map[start][end] = true;
					inDegree[end]++;
					map[end][start] = false;
					inDegree[start]--;
				}

				// check inDegree
				Queue<Integer> q = new LinkedList<Integer>();
				for (int i = 1; i <= N; i++) {
					if (inDegree[i] == 0) {
						q.offer(i);
					}
				}

				boolean unsortable = false;
				int count = 0;
				while (!q.isEmpty()) {
					if (q.size() != 1) {
						unsortable = true;
						break;
					} else {
						count++;
						int current = q.poll();
						sb.append(original[current] + " ");
						for (int i = 1; i <= N; i++) {
							if (map[current][i]) {
								map[current][i] = false;
								inDegree[i]--;
								if (inDegree[i] == 0) {
									q.offer(i);
								}
							}
						}
					}
				}

				if (unsortable) {
					System.out.println("?");
				} else if (count != N) {
					System.out.println("IMPOSSIBLE");
				} else {
					System.out.println(sb.toString());
				}
			}
		}
	}
}
