package acmicpc_1546;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		for (int i = 0; i < count; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp > max)
				max = temp;
			sum += temp;
		}
		System.out.printf("%.2f", ((double) sum / count) / max * 100d);
	}

	public static void main_version_001(String[] args) {
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
		sc.close();
	}
}
