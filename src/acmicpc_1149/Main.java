package acmicpc_1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int memo[][];
	static int cost[][];

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine().trim());
		initCost(N);
		initMemo(N);
		start(N);
	}

	public static void initCost(int N) throws Exception {
		cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
	}

	public static void initMemo(int N) {
		memo = new int[N][3];
		memo[0][0] = min(cost[0][1], cost[0][2]);
		memo[0][1] = min(cost[0][0], cost[0][2]);
		memo[0][2] = min(cost[0][0], cost[0][1]);
	}

	public static void start(int N) {
		int result;
		if (N == 0) {
			result = 0;
		} else if (N == 1) {
			result = min(cost[0][0], cost[0][1], cost[0][2]);
		} else {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				int dpRet = cost[N - 1][i] + dp(N - 1, i);
				if (dpRet < min)
					min = dpRet;
			}
			result = min;
		}
		System.out.println(result);
	}

	public static int dp(int index, int choose) {
		if (memo[index - 1][choose] == 0) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				if (i == choose)
					continue;
				int dpRet = cost[index - 1][i] + dp(index - 1, i);
				if (dpRet < min)
					min = dpRet;
			}
			memo[index - 1][choose] = min;
		}
		return memo[index - 1][choose];
	}

	public static int min(int a, int b) {
		return (a < b) ? (a) : (b);
	}

	public static int min(int... numbers) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		Collections.sort(list);
		return list.get(0);
	}
}
