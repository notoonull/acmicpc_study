package acmicpc_1924;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int month = Integer.parseInt(st.nextToken());
		int date = Integer.parseInt(st.nextToken());
		
		String day = getDay(month, date);
		System.out.println(day);
	}

	public static String getDay(int month, int date) {
		String day = "SUN";
		int totalDate = getAccumulativeDays(month, date);
		switch (totalDate % 7) {
		case 1:
			day = "MON";
			break;
		case 2:
			day = "TUE";
			break;
		case 3:
			day = "WED";
			break;
		case 4:
			day = "THU";
			break;
		case 5:
			day = "FRI";
			break;
		case 6:
			day = "SAT";
			break;
		}
		return day;
	}

	public static int getAccumulativeDays(int month, int date) {
		int accumulativeDate = 0;
		for (int i = 1; i < month; i++) {
			accumulativeDate += getDateCount(i);
		}
		accumulativeDate += date;
		return accumulativeDate;
	}

	public static int getDateCount(int month) {
		int dateCount = 31;
		switch (month) {
		case 2:
			dateCount = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dateCount = 30;
			break;
		}
		return dateCount;
	}
}
