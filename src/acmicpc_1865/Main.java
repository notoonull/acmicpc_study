package acmicpc_1865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int T;
	static int N, M, W;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int __t = 0; __t < T; __t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			list = new ArrayList<ArrayList<Integer>>();
			list.add(null);
			for (int i = 1; i <= N; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			// temp
			
		} // END TEST
	}// END MAIN

}
