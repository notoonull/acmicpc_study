package acmicpc_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static int N;
	static int[] memo;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		memo = new int[N + 1];
		memo[1] = 0;
		for (int i = 2; i <= N; i++) {
			memo[i] = memo[i-1] + 1;
			if (i%2 == 0) {
				memo[i] = Math.min(memo[i], memo[i/2] + 1);	
			}			
			if (i%3 == 0) {
				memo[i] = Math.min(memo[i], memo[i/3] + 1);
			}
		}
		System.out.println(memo[N]);
	}
}