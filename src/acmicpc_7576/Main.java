package acmicpc_7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Point> queue = new ArrayList<Point>();
	static ArrayList<Point> queueBuffer = new ArrayList<Point>();
	static ArrayList<Point> visited = new ArrayList<Point>();
	static int tomato[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];

		int emptyCount = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					Point temp = new Point(j, i);
					queue.add(temp);
					visited.add(temp);
				}
				else if(tomato[i][j] == -1) {
					emptyCount++;
				}
			}
		}

		int day = 0;
		while (!queue.isEmpty() && visited.size() != (M * N - emptyCount)) {
			for (int i = 0; i < queue.size(); i++) {
				int x = queue.get(i).x;
				int y = queue.get(i).y;

				if (x - 1 >= 0) {
					if (tomato[y][x - 1] == 0) {
						Point temp = new Point(x - 1, y);
						queueBuffer.add(temp);
						visited.add(temp);
						tomato[y][x - 1] = 1;
					}
				}

				if (x + 1 < M) {
					if (tomato[y][x + 1] == 0) {
						Point temp = new Point(x + 1, y);
						queueBuffer.add(temp);
						visited.add(temp);
						tomato[y][x + 1] = 1;
					}
				}

				if (y - 1 >= 0) {
					if (tomato[y - 1][x] == 0) {
						Point temp = new Point(x, y - 1);
						queueBuffer.add(temp);
						visited.add(temp);
						tomato[y - 1][x] = 1;
					}
				}

				if (y + 1 < N) {
					if (tomato[y + 1][x] == 0) {
						Point temp = new Point(x, y + 1);
						queueBuffer.add(temp);
						visited.add(temp);
						tomato[y + 1][x] = 1;
					}
				}
			}
			queue.clear();
			queue = (ArrayList<Point>) queueBuffer.clone();
			queueBuffer.clear();
			day++;
		}

		if (!checkTomato(tomato)) {
			day = -1;
		}
		System.out.println(day);
	}

	public static boolean checkTomato(int tomato[][]) {
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[i].length; j++) {
				if (tomato[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}