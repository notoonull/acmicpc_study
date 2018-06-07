package acmicpc_2294;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K;
	static int[] value;
	static int count;
	static int size;
	static Stack<Integer> array;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		size = Integer.MAX_VALUE;
		count = 0;
		value = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int coinValue = Integer.parseInt(br.readLine());
			value[i] = coinValue;
		}

		array = new Stack<Integer>();
		find(0, 0);		
		System.out.println(count);
		System.out.println(size);
	}

	static void find(int sum, int coin) {
		if (sum + coin == K) {
			array.push(coin);
			System.out.println(array.toString());
			int stackSize = array.size();
			if (size > array.size()) {
				size = stackSize;
			}
			count++;
			array.pop();
		}
		if (sum + coin < K) {
			for (int i = 1; i <= N; i++) {
				if (value[i] >= coin) {
					if (coin != 0) {
						array.push(coin);
					}

					find(sum + coin, value[i]);

					if (coin != 0) {
						array.pop();
					}
				}
			}
		}
	}
}
