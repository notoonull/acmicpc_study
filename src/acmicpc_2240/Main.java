package acmicpc_2240;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int T, W;
	static int[][] items;
	static int[][] dp;
	static int index;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		items = new int[T + 1][2];
		dp = new int[T + 1][W + 1];

		int current = Integer.parseInt(br.readLine());
		int count = 1;
		index = 1;
		for (int i = 2; i <= T; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == current) {
				count++;
			} else {
				items[index][current - 1] = count;
				index++;
				current = num;
				count = 1;
			}
		}
		items[index][current - 1] = count;

		dp[1][0] = items[1][0];
		dp[1][1] = items[1][1];
		
		int result = Math.max(dp[1][0], dp[1][1]);
		for (int i = 2; i <= index; i++) {
			dp[i][0] = dp[i - 1][0] + items[i][0];
			result = Math.max(result, dp[i][0]);
			
			for (int j = 1; j <= W; j++) {
				if (i >= j) {
					if (j % 2 == 0) {
						dp[i][j] = Math.max(dp[i - 1][j] + items[i][0], dp[i - 1][j - 1] + items[i][0]);
					} else {
						dp[i][j] = Math.max(dp[i - 1][j] + items[i][1], dp[i - 1][j - 1] + items[i][1]);
					}
				}
				result = Math.max(result, dp[i][j]);
			}
		}

		// printItems();
		// printDP();
		System.out.println(result);
	}

	static void printItems() {
		for (int i = 1; i <= index; i++) {
			System.out.println(items[i][0] + " " + items[i][1]);
		}
	}

	static void printDP() {
		for (int i = 1; i <= index; i++) {
			for (int j = 0; j <= W; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

}