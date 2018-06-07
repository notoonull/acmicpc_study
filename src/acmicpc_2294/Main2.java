package acmicpc_2294;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
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
		value = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int coin = Integer.parseInt(br.readLine());
			value[i] = coin;
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = value[i]; j <= K; j++) {				
				dp[j] = (dp[j - value[i]] == Integer.MAX_VALUE) ? (dp[j]) : (Math.min(dp[j], dp[j - value[i]] + 1));
			}
		}
		if (dp[K] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}
	}
}
