package acmicpc_1316;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean pass[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (isGroupWord(word))
				count++;
		}
		System.out.println(count);
	}

	public static boolean isGroupWord(String word) {
		boolean isGroupWord = true;
		pass = new boolean[123];

		for (int i = 0; i < word.length() - 1; i++) {
			if (word.charAt(i) != word.charAt(i + 1)) {
				if (pass[word.charAt(i)]) {
					isGroupWord = false;
					break;
				} else {
					pass[word.charAt(i)] = true;
				}
			}
		}
		if (pass[word.charAt(word.length() - 1)])
			isGroupWord = false;

		return isGroupWord;
	}
}
