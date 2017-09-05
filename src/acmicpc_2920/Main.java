package acmicpc_2920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		System.out.println(checkOrder(list));
	}

	public static String checkOrder(ArrayList<Integer> list) {
		if(list.size() <= 1) return "mixed";
		boolean isAscending = (list.get(0) < list.get(0 + 1));
		boolean checkFlag = isAscending;
		for (int i = 1; i < list.size() - 1; i++) {
			checkFlag = (list.get(i) < list.get(i + 1));
			if (isAscending != checkFlag) break;
		}

		// ascending, descending, mixed
		return (isAscending == checkFlag) ? ((isAscending) ? ("ascending") : ("descending")) : ("mixed");
	}
}
