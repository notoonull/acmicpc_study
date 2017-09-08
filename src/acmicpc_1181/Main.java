package acmicpc_1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeSet<String> set[] = new TreeSet[51];
		// TreeSet Array init
		for (int i = 0; i < set.length; i++) {
			set[i] = new TreeSet<String>();
		}

		// Add data to TreeSet
		for (int i = 0; i < N; i++) {
			String line = br.readLine().trim();
			set[line.length()].add(line);
		}

		// Result
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < set.length; i++) {
			Iterator<String> it = set[i].iterator();
			while (it.hasNext()) {
				sb.append(it.next() + "\n");
			}
		}
		System.out.println(sb);
	}
}
