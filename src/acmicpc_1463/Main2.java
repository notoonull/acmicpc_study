package acmicpc_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static BufferedReader br;
	static int N;
	static int[] memo;
	static int result;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		memo = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			memo[i] = Integer.MAX_VALUE;
		}
		memo[1] = 0;
		if (N > 1) {
			memo[2] = 1;
		}
		if (N > 2) {
			memo[3] = 1;
		}

		result = min(N);
		System.out.println(result);
	}

	static int min(int target) {
		if (memo[target] != Integer.MAX_VALUE) {
			return memo[target];
		}

		int result1 = Integer.MAX_VALUE;
		int result2 = Integer.MAX_VALUE;
		int result3 = min(target - 1) + 1;

		if (target % 3 == 0) {
			result1 = min(target / 3) + 1;
		}
		if (target % 2 == 0) {
			result2 = min(target / 2) + 1;
		}

		memo[target] = Math.min(result1, Math.min(result2, result3));

		return memo[target];
	}
}