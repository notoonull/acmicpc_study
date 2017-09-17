package acmicpc_1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char array[][];
	static StringBuilder sbPre = new StringBuilder();
	static StringBuilder sbIn = new StringBuilder();
	static StringBuilder sbPost = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		array = new char[N][2];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			array[(line.charAt(0) - 'A')][0] = line.charAt(2);
			array[(line.charAt(0) - 'A')][1] = line.charAt(4);
		}

		preorder('A'); System.out.println(sbPre);
		inorder('A'); System.out.println(sbIn);
		postorder('A'); System.out.println(sbPost);
	}

	public static void preorder(char node) {
		if (node != '.') {
			sbPre.append(node);
			preorder(array[(node - 'A')][0]);
			preorder(array[(node - 'A')][1]);
		}
	}
	
	public static void inorder(char node) {
		if (node != '.') {
			inorder(array[(node - 'A')][0]);
			sbIn.append(node);
			inorder(array[(node - 'A')][1]);
		}
	}
	
	public static void postorder(char node) {
		if (node != '.') {			
			postorder(array[(node - 'A')][0]);
			postorder(array[(node - 'A')][1]);
			sbPost.append(node);
		}
	}
}


