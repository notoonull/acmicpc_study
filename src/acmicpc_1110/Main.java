package acmicpc_1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int N = input;
		int count = 0;
		do {
			int a = N / 10;
			int b = N % 10;
			int newB = (a + b) % 10;
			int newA = b;
			N = newA * 10 + newB;
			count++;
		} while (N != input);
		System.out.println(count);
	}
}
