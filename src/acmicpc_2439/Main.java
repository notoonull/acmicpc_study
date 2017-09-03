package acmicpc_2439;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main_version_001(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = N; j > 0; j--) {
				if (j > i)
					sb.append(" ");
				else
					sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
