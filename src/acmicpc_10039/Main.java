package acmicpc_10039;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();

		String line;
		while ((line = br.readLine()) != null) {
			if (line.length() == 0) break;
			list.add(Integer.parseInt(line.trim()));
		}

		System.out.println(calcAverage(list));
	}

	public static int calcAverage(ArrayList<Integer> list) {
		if (list.size() == 0) return 0;		
		int sum = 0;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int score = it.next();
			sum += ((score >= 40) ? (score) : (40));
		}
		return (sum / list.size());
	}
}
