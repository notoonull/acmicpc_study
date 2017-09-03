package acmicpc_10809;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		StringBuilder sb = new StringBuilder();

		for (int i = 'a'; i <= 'z'; i++) {
			sb.append(s.indexOf(i) + " ");
		}

		System.out.println(sb);
	}
}
