package acmicpc_2741;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
	
	public static void main_version_002(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}

	public static void main_version_001(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			System.out.println(i);
		}
	}
}
