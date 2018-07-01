package acmicpc_11048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int[] dn = { 1, 0, 1 };
	static int[] dm = { 0, 1, 1 };

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N + 1][M + 1];
		fillDP(-1);
		dp[N][M] = map[N][M];

		System.out.println(find(1, 1));
	}

	static void fillDP(int num) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = num;
			}
		}
	}

	static int find(int n, int m) {
		if (dp[n][m] != -1) {
			return dp[n][m];
		}

		int max = 0;
		for (int i = 0; i < 3; i++) {
			int nextN = n + dn[i];
			int nextM = m + dm[i];
			if (nextN >= 1 && nextN <= N && nextM >= 1 && nextM <= M) {
				int value = dp[nextN][nextM];
				if (value == -1) {
					value = find(nextN, nextM);
				}
				if (value > max) {
					max = value;
				}
			}
		}		
		return dp[n][m] = max + map[n][m];
	}

	static void printDP() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
