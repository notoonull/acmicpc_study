package acmicpc_7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int tomato[][];
	static Queue<Point> q;
	static int zeroCount;

	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];

		q = new LinkedList<Point>();

		zeroCount = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					q.add(new Point(i, j));
				}
				if (value == 0) {
					zeroCount++;
				}
				tomato[i][j] = value;
			}
		}

		if (zeroCount == 0) {
			System.out.println(0);
		} else {
			while (!q.isEmpty()) {
				Point here = q.poll();
				int x = here.x;
				int y = here.y;

				for (int i = 0; i < 4; i++) {
					int _x = x + dx[i];
					int _y = y + dy[i];
					
					if (_x >= 0 && _x < N && _y >= 0 && _y < M) {
						if (tomato[_x][_y] == 0) {
							tomato[_x][_y] = tomato[x][y] + 1;
							q.add(new Point(_x, _y));
						}
					}
				}
			}
			System.out.println(getDay());
		}
	}

	static int getDay() {
		int max = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					return -1;
				}

				if (tomato[i][j] > max) {
					max = tomato[i][j];
				}
			}
		}
		return max - 1;
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
