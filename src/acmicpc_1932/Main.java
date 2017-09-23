package acmicpc_1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int memo[][];
		memo = new int[N][];

		// init value
		memo[0] = new int[1];
		st = new StringTokenizer(br.readLine());
		memo[0][0] = Integer.parseInt(st.nextToken());

		// set memo
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			memo[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				int a = (j - 1 >= 0) ? (memo[i - 1][j - 1])
						: (Integer.MIN_VALUE);
				int b = (j < i) ? (memo[i - 1][j]) : (Integer.MIN_VALUE);
				memo[i][j] = Math.max(a, b) + Integer.parseInt(st.nextToken());
			}
		}

		printMaxValue(memo[N - 1]);
	}

	public static void printMaxValue(int array[]) {
		if (array.length > 0) {
			int max = array[0];
			for (int i = 1; i < array.length; i++) {
				if (array[i] > max) {
					max = array[i];
				}
			}
			System.out.println(max);
		}
	}
}
