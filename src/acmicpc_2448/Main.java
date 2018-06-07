package acmicpc_2448;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(((i < 10) ? ("0" + i) : (i)) + " ");
			
			for (int j = 1; j < N - i; j++) {
				sb.append(" ");
			}
			
			if (i % 3 == 0) {
				sb.append("*");

				int quotient = (i / 3);
				for (int j = 1; j <= quotient; j++) {
					sb.append("     ");
					sb.append("*");
				}
			}
			if (i % 3 == 1) {
				sb.append("* *");

				int quotient = (i / 3);
				for (int j = 1; j <= quotient; j++) {
					sb.append("   ");
					sb.append("* *");
				}
			}
			if (i % 3 == 2) {
				sb.append("*****");

				int quotient = (i / 3);
				for (int j = 1; j <= quotient; j++) {
					sb.append(" ");
					sb.append("*****");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
