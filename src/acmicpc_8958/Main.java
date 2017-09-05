package acmicpc_8958;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String input = br.readLine().trim();

			int total = 0;
			int cumulative = 1;
			for (int k = 0; k < input.length(); k++) {
				if (input.charAt(k) == 'O') {
					total += (cumulative++);
				} else {
					cumulative = 1;
				}
			}
			sb.append(total + "\n");
		}
		System.out.println(sb);
	}
}
