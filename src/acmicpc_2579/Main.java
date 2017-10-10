package acmicpc_2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int memoAdjacent[];
	static int memoNotAdjacent[];
	static int value[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		value = new int[N];
		memoAdjacent = new int[N];
		memoNotAdjacent = new int[N];
		Arrays.fill(memoAdjacent, Integer.MIN_VALUE);
		Arrays.fill(memoNotAdjacent, Integer.MIN_VALUE);

		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(br.readLine().trim());
		}

		System.out.println(value[N - 1]
				+ Math.max(dp(N - 1, N - 2), dp(N - 1, N - 3)));
	}

	public static int dp(int parent, int index) {
		if (index < 0) {
			return 0;
		}

		if (parent - index == 1) {
			if (memoNotAdjacent[index] == Integer.MIN_VALUE) {
				memoNotAdjacent[index] = value[index] + dp(index, index - 2);
			}
			return memoNotAdjacent[index];
		} else {
			if (memoAdjacent[index] == Integer.MIN_VALUE) {
				memoAdjacent[index] = value[index] + dp(index, index - 1);
			}
			if (memoNotAdjacent[index] == Integer.MIN_VALUE) {
				memoNotAdjacent[index] = value[index] + dp(index, index - 2);
			}
			return Math.max(memoAdjacent[index], memoNotAdjacent[index]);
		}
	}
}
