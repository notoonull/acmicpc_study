package acmicpc_10817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numbers[] = new int[3];
		for (int i = 0; i < 3; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int minIndex = 0;
		for (int i = 1; i < 3; i++) {
			if (numbers[minIndex] > numbers[i])
				minIndex = i;
		}
		if (minIndex != 0) {
			int temp = numbers[minIndex];
			numbers[minIndex] = numbers[0];
			numbers[0] = temp;
		}
		
		System.out.println((numbers[1] > numbers[2])?(numbers[2]):(numbers[1]));
	}
}
