package acmicpc_10871;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp < X) sb.append(temp + " ");
		}
		
		System.out.println(sb.toString().trim());
	}

	public static void main_version_002(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp < X)
				sb.append(temp + " ");
		}

		if(sb.length() > 0 && sb.charAt(sb.length()-1) == ' ') {
			sb.deleteCharAt(sb.length()-1);
		}
		
		System.out.println(sb);
	}
	
	public static void main_version_001(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp < X)
				list.add(temp);
		}

		StringBuilder sb = new StringBuilder(list.get(0).toString());

		Iterator<Integer> iterator = list.iterator();
		iterator.next();
		while (iterator.hasNext()) {
			sb.append(" " + iterator.next());
		}

		System.out.println(sb);
	}
}
