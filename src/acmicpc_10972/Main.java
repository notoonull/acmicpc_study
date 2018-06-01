package acmicpc_10972;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] numbers;
	static int[] remain;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int prepareNum = -1;
		for (int i = N - 1; i > 0; i--) {
			if (numbers[i - 1] < numbers[i]) {
				prepareNum = i - 1;
				break;
			}
		}

		if (prepareNum == -1) {
			System.out.println(-1);
		} else {
			int diff = Integer.MAX_VALUE;
			int nextNumIndex = -1;
			int target = numbers[prepareNum];
			for (int i = prepareNum + 1; i < N; i++) {
				if (numbers[i] > target && numbers[i] - target < diff) {
					diff = numbers[i] - target;
					nextNumIndex = i;
				}
			}
			if (nextNumIndex != -1) {
				numbers[prepareNum] = numbers[nextNumIndex];
				numbers[nextNumIndex] = target;
			}

			int remainNum = numbers.length - prepareNum - 1;
			remain = new int[remainNum];
			System.arraycopy(numbers, prepareNum + 1, remain, 0, remainNum);
			Arrays.sort(remain);
			System.arraycopy(remain, 0, numbers, prepareNum + 1, remainNum);
			printResults();
		}
	}

	static void printResults() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(numbers[i] + " ");
		}
		System.out.println(sb);
	}
}