package acmicpc_11720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		String numbers = br.readLine();
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += ((int) numbers.charAt(i) - 48);
		}
		System.out.println(sum);
	}

	public static void main_version_001(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		String numbers = sc.next();
		int result = 0;
		for (int i = 0; i < count; i++) {
			result += ((int) numbers.charAt(i) - 48);
		}
		System.out.println(result);
		sc.close();
	}
}
