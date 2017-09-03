package acmicpc_2577;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int flag[] = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine().trim());
		int B = Integer.parseInt(br.readLine().trim());
		int C = Integer.parseInt(br.readLine().trim());
		int result = A * B * C;
		
		while (result != 0) {
			flag[result % 10]++;
			result /= 10;
		}
		for (int i = 0; i < flag.length; i++) {
			System.out.println(flag[i]);
		}
	}
}
