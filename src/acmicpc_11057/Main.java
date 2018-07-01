package acmicpc_11057;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[10];
		dp[9] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 8; j >= 0; j--) {
				dp[j] = (dp[j] + dp[j + 1]) % 10007;
			}
		}

		int sum = 0;
		for (int j = 0; j <= 9; j++) {
			sum = (sum + dp[j]) % 10007;
		}
		System.out.println(sum);
	}

	static void printDP() {
		for (int j = 0; j < 10; j++) {
			System.out.print(dp[j] + " ");
		}
		System.out.println();
	}
}
