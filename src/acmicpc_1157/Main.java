package acmicpc_1157;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int count[] = new int[91];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().toUpperCase();
		// 'A' ~ 'Z' : 65 ~ 90
		for (int i = 0; i < line.length(); i++) {
			count[line.charAt(i)]++;
		}

		int max = getMaxIndex();
		if (hasMultiAnswer(max)) {
			System.out.println("?");
		} else {
			System.out.println((char) max);
		}
	}

	public static int getMaxIndex() {
		int max = 65;
		for (int i = 66; i <= 90; i++) {
			if (count[max] < count[i]) {
				max = i;
			}
		}
		return max;
	}

	public static boolean hasMultiAnswer(int max) {
		boolean multiFlag = false;
		for (int i = 65; i <= 90; i++) {
			if (i != max && count[max] == count[i]) {
				multiFlag = true;
				break;
			}
		}
		return multiFlag;
	}
}
