package acmicpc_2292;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) - 1;
		int index = 1; while (N > 0) { N -= (6 * index++); }
		System.out.println(index);
	}
}
