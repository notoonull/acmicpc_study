package acmicpc_1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int memo[][] = new int[41][2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int N[] = new int[T];
		for (int i = 0; i < T; i++) {
			N[i] = Integer.parseInt(br.readLine().trim());
		}

		// init
		initMemo();

		StringBuilder sb = new StringBuilder();
		// start_dp
		for (int i = 0; i < T; i++) {
			int data[] = fibo_dp(N[i]);
			// Actually, these values are the same with Fibonacci numbers..
			// However, I am studying about DP.
			sb.append(data[0] + " " + data[1] + "\n");			
		}
		System.out.println(sb);
	}

	public static void initMemo() {
		for (int i = 0; i < 41; i++) {
			memo[i][0] = -1;
			memo[i][1] = -1;
		}
		memo[0][0] = 1;
		memo[0][1] = 0;
		memo[1][0] = 0;
		memo[1][1] = 1;
	}

	// Is this DP with Memoization?
	public static int[] fibo_dp(int N) {
		if (memo[N][0] != -1 && memo[N][1] != -1) {
			return memo[N];
		}

		memo[N][0] = fibo_dp(N - 1)[0] + fibo_dp(N - 2)[0];
		memo[N][1] = fibo_dp(N - 1)[1] + fibo_dp(N - 2)[1];
		return memo[N];
	}
}
