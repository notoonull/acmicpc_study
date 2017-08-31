package acmicpc_11720;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		String numbers = sc.next();
		int result = 0;
		for(int i=0;i<count;i++) {
			result += ((int)numbers.charAt(i)-48);
		}
		System.out.println(result);
	}
}
