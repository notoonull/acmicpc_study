package acmicpc_2293;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K;
	static int[] value;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[K + 1];
		value = new int[N];
		for (int i = 0; i < N; i++) {
			int coinValue = Integer.parseInt(br.readLine());
			value[i] = coinValue;
		}

		dp[0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = value[i]; j <= K; j++) {
				dp[j] = dp[j] + dp[j - value[i]];
			}
		}
		System.out.println(dp[K]);
	}
}
