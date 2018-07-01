package acmicpc_11057;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static BufferedReader br;
	static int N;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new long[N + 1][10];

		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			long sum = 0;
			for (int j = 0; j <= 9; j++) {
				sum = (sum + dp[i - 1][j]);
			}
			
			dp[i][0] = sum;
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = (dp[i][j - 1] - dp[i - 1][j - 1]);
			}
		}

		long result = 0;
		for (int i = 0; i <= 9; i++) {
			result = (result + dp[N][i]) % 10007;
		}
		System.out.println(result);
		printDP();
	}

	static void printDP() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

}
