package acmicpc_1931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws Exception {		
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Time> q= new PriorityQueue<Time>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			q.offer(new Time(start, end));
		}
		
		int end = 0;
		int count = 0;
		while(!q.isEmpty()) {
			Time t = q.poll();
			if (t.start >= end) {
				end = t.end;
				count++;
			}
		}
		System.out.println(count);
	}
}

class Time implements Comparable<Time> {
	int start, end;

	Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		if (this.end < o.end) {
			return -1;
		}
		
		if (this.end == o.end) {
			if (this.start < o.start) {
				return -1;	
			} else {
				return 1;
			}
		}
		
		if (this.end > o.end) {
			return 1;
		}
		
		return 0;
	}	
}
