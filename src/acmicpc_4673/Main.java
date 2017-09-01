package acmicpc_4673;

public class Main {
	static boolean[] flag = new boolean[10001];

	public static void main(String[] args) {
		for (int i = 1; i <= 10000; i++) {
			if (!flag[i]) {
				d_traverse(i);
			}
		}
		for (int i = 1; i <= 10000; i++) {
			if (!flag[i]) {
				System.out.println(i);
			}
		}
	}

	static void d_traverse(int start) {
		int temp = start;
		int sum = start;
		while (temp != 0) {
			sum += (temp % 10);
			temp /= 10;
		}
		if (sum <= 10000) {
			flag[sum] = true;
			d_traverse(sum);
		}
	}
}
