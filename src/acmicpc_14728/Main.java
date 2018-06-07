package acmicpc_14728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, T;
	static int[] studyTime;
	static int[] value;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		studyTime = new int[N];
		value = new int[N];
		dp = new int[T + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			studyTime[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = T; j >= studyTime[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - studyTime[i]] + value[i]);
			}
		}
		System.out.println(dp[T]);
	}
}
