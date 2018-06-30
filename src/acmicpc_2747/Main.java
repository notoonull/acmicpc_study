package acmicpc_2747;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static int N;
	static int memo[];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		memo = new int[N + 1];
		memo[0] = 0;
		memo[1] = 1;

		for (int i = 2; i <= N; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		System.out.println(memo[N]);
	}
}
