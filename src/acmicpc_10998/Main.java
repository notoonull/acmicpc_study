package acmicpc_10998;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
	}
	
	public static void main_version_001(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextInt() * sc.nextInt());
		sc.close();
	}
}
