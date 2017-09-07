package acmicpc_11721;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line.length(); i++) {
			sb.append(line.charAt(i));
			count++;
			
			if(count == 10) {
				sb.append("\n");
				count = 0;
			}
		}
		System.out.println(sb);
	}
}
