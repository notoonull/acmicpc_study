package acmicpc_10844;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br;
	static int N;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][10];
		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][1];
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
			dp[i][9] = dp[i - 1][8];
		}

		//printDP();

		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum = (sum + dp[N][i]) % 1000000000;
		}
		System.out.println(sum);
	}

	static void printDP() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
