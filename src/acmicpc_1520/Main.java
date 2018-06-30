package acmicpc_1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int M, N;
	static int[][] map;
	static int[][] dp;
	static int[] dm = { 0, 0, -1, 1 };
	static int[] dn = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}		
		
		dp[M-1][N-1] = 1;
		System.out.println(find(0, 0));

		// printDP();
	}

	public static int find(int m, int n) {
		if (dp[m][n] > -1) {
			return dp[m][n];
		}
		
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int nextM = m + dm[i];
			int nextN = n + dn[i];
			if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N) {
				if (map[m][n] > map[nextM][nextN]) {
					sum += find(nextM, nextN);
				}
			}
		}
		return dp[m][n] = sum;
	}

	public static void printDP() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}

