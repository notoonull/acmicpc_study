package acmicpc_2750;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int array[] = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		sort(array);
		printArray(array);
	}

	public static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min])
					min = j;
			}
			if (min != i) {
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}

	public static void printArray(int arr[]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}
}
