package acmicpc_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int resultBasedThree = getCount(N, 3, 5);
		int resultBasedFive = getCount(N, 5, 3);
		
		int result = -1;
		if (resultBasedThree * resultBasedFive < 0) {
			result = Math.max(resultBasedThree, resultBasedFive);
		} else {
			result = Math.min(resultBasedThree, resultBasedFive);
		}
		System.out.println(result);
	}

	public static int getCount(int N, int base, int subBase) {
		int result = -1;
		int count = 0;
		while (N >= 3) {
			if (N % base == 0) {
				result = (N / base) + count;
				break;
			}
			N -= subBase;
			count++;
		}
		return result;
	}
}
