package acmicpc_2293;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws Exception {
		Solver s = new Solver();
		s.solve();
	}
	
	static class Solver {
		BufferedReader br;
		StringTokenizer st;
		int N, K;
		int[] value;
		int[] dp;

		void solve() throws Exception {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			value = new int[N + 1];
			dp = new int[K + 1];

			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int coinValue = Integer.parseInt(br.readLine());
				value[i] = coinValue;
				if (min > coinValue) {
					min = coinValue;
				}
			}

			if (min > K) {
				System.out.println(0);
			} else if (min == K) {
				System.out.println(1);
			} else {
				dp[0] = 1;
				for (int i = 1; i <= N; i++) {
					for (int j = value[i]; j <= K; j++) {
						dp[j] += dp[j - value[i]];
					}
				}
				System.out.println(dp[K]);
			}
		}
	}
}


