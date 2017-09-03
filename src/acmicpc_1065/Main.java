package acmicpc_1065;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int count = 0;
		if (X < 100) {
			count = X;
		} else {
			count = 99;
			for (int i = 100; i <= X; i++) {
				if (isSatisfied(i))
					count++;
			}
		}
		System.out.println(count);
	}

	public static boolean isSatisfied(int X) {
		boolean result = true;
		if (X == 1000) {
			result = false;
		} else if (X >= 100) {
			int a = X % 10;
			int b = (X % 100) / 10;
			int c = (X % 1000) / 100;
			result = ((a - b) == (b - c));
		}
		return result;
	}
}
