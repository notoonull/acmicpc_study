package acmicpc_11719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void main_version_001(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
}
