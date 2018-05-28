package acmicpc_11404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		StringTokenizer st;
		distance = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					distance[i][j] = 0;
				} else {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (distance[a][b] > c) {
				distance[a][b] = c;	
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
						int d = distance[i][k] + distance[k][j];
						if (distance[i][j] > d) {
							distance[i][j] = d;
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (distance[i][j] == Integer.MAX_VALUE) {
					sb.append("0 ");
				} else {
					sb.append(distance[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
}
