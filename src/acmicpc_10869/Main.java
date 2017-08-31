package acmicpc_10869;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A, B;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());		

		int sum = A + B;
		int subtraction = A - B;
		int multiplication = A * B;
		int quotient = A / B;
		int remainder = A % B;

		System.out.println(sum);
		System.out.println(subtraction);
		System.out.println(multiplication);
		System.out.println(quotient);
		System.out.println(remainder);
	}
	
	public static void main_version_001(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B;
		A = sc.nextInt();
		B = sc.nextInt();
		sc.close();

		int sum = A + B;
		int subtraction = A - B;
		int multiplication = A * B;
		int quotient = A / B;
		int remainder = A % B;

		System.out.println(sum);
		System.out.println(subtraction);
		System.out.println(multiplication);
		System.out.println(quotient);
		System.out.println(remainder);
	}
}
