package acmicpc_1546;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int max = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			int buffer = sc.nextInt();
			sum += buffer;
			if (buffer > max) {
				max = buffer;
			}
		}
		System.out.printf("%.2f",
				(Math.round((((double) sum / count) / max) * 10000d) / 100d));
	}
}
