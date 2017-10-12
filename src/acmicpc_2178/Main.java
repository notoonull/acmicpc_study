package acmicpc_2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static Point distance[][];
	static boolean inQueue[][];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int map[][] = new int[N][M];
		distance = new Point[N][M];
		inQueue = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (int) (line.charAt(j) - '0');
			}
		}

		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				distance[i][j] = new Point(i, j, Integer.MAX_VALUE);				
			}
		}
		distance[0][0].value = 1;
		pq.offer(distance[0][0]);
		inQueue[0][0] = true;
		while (!pq.isEmpty()) {
			Point target = pq.poll();
			
			int x = target.x;
			int y = target.y;
			if(x-1>=0 && map[x-1][y] == 1 && distance[x-1][y].value > distance[x][y].value + 1 && distance[x][y].value != Integer.MAX_VALUE) {
				distance[x-1][y].value = distance[x][y].value + 1;
				if(!inQueue[x-1][y]) {
					pq.offer(distance[x-1][y]);
					inQueue[x-1][y] = true;
				}
			}
		
			if(x+1<N && map[x+1][y] == 1 && distance[x+1][y].value > distance[x][y].value + 1 && distance[x][y].value != Integer.MAX_VALUE) {
				distance[x+1][y].value = distance[x][y].value + 1;
				if(!inQueue[x+1][y]) {
					pq.offer(distance[x+1][y]);
					inQueue[x+1][y] = true;
				}
			}
			
			if(y-1>=0 && map[x][y-1] == 1 && distance[x][y-1].value > distance[x][y].value + 1 && distance[x][y].value != Integer.MAX_VALUE) {
				distance[x][y-1].value = distance[x][y].value + 1;
				if(!inQueue[x][y-1]) {
					pq.offer(distance[x][y-1]);
					inQueue[x][y-1] = true;
				}
			}
			
			if(y+1<M && map[x][y+1] == 1 && distance[x][y+1].value > distance[x][y].value + 1 && distance[x][y].value != Integer.MAX_VALUE) {
				distance[x][y+1].value = distance[x][y].value + 1;
				if(!inQueue[x][y+1]) {
					pq.offer(distance[x][y+1]);
					inQueue[x][y+1] = true;
				}
			}			
		}
		System.out.println(distance[N-1][M-1].value);
	}
}

class Point implements Comparable<Point> {
	public int x;
	public int y;
	public int value;

	public Point(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Point p) {
		if (this.value < p.value) {
			return -1;
		} else if (this.value > p.value) {
			return 1;
		}
		return 0;
	}
}
