package acmicpc_1193;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine().trim());

		int numerator;
		int denominator;
		int fractionSum = 1;
		while (X > 0) {
			X -= (fractionSum++);
		}
		
		int rowIndex = (fractionSum - 1);
		if (rowIndex % 2 == 0) {
			numerator = rowIndex + X;
			denominator = fractionSum - numerator;
		} else {
			denominator = rowIndex + X;
			numerator = fractionSum - denominator;
		}
		System.out.println(numerator + "/" + denominator);
	}
}
