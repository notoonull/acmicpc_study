package acmicpc_4344;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) throws Exception {
		int C = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int score[] = new int[N];
			int sum = 0;
			for (int j = 0; j < N; j++) {
				score[j] = Integer.parseInt(st.nextToken());
				sum += score[j];
			}
			double average = (double) sum / N;

			int count = 0;
			for (int k = 0; k < score.length; k++) {
				if (average < score[k]) {
					count++;
				}
			}
			sb.append(String.format("%.3f", ((double) count / N) * 100) + "%\n");
		}
		System.out.println(sb);
	}
}
