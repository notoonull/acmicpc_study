package acmicpc_11047;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int K;
	static int[] n;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		n = new int[N];
		for (int i = 0; i < N; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (K >= n[i]) {
				count += (K / n[i]);
				K %= n[i];
			}
		}
		System.out.println(count);
	}
}
