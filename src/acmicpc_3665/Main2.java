package acmicpc_3665;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static int T;
	static int n;
	static Team[] team;
	static int m;
	static ArrayList<ArrayList<Integer>> nodes;
	static int[] inDegree;
	static int changeStart, changeEnd;
	static boolean impossible;
	static boolean strange;
	static ArrayList<Integer> original;
	static Queue<Integer> results;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int __t = 0; __t < T; __t++) {
			results = new LinkedList<Integer>();
			impossible = false;
			strange = false;
			sb = new StringBuilder();

			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			original = new ArrayList<Integer>();
			original.add(null);

			changeStart = -1;
			changeEnd = -1;
			inDegree = new int[n + 1];
			team = new Team[n + 1];
			for (int i = 1; i <= n; i++) {
				int teamNum = Integer.parseInt(st.nextToken());
				team[teamNum] = new Team(teamNum, i);
				original.add(teamNum);
			}

			nodes = new ArrayList<ArrayList<Integer>>();
			nodes.add(null);
			for (int i = 1; i <= n; i++) {
				nodes.add(new ArrayList<Integer>());
			}

			m = Integer.parseInt(br.readLine());
			if (m == 0) {
				for (int i = 1; i <= n; i++) {
					sb.append(original.get(i) + " ");
				}
			} else {
				for (int i = 0; i < m; i++) {
					st = new StringTokenizer(br.readLine());
					int start = Integer.parseInt(st.nextToken());
					int end = Integer.parseInt(st.nextToken());

					team[start].changed = true;
					team[end].changed = true;

					nodes.get(start).add(end);
					inDegree[end]++;
				}
				printNodes();
				printInDegree();

				boolean __start = false;
				boolean __end = false;
				int changedCount = 0;
				for (int i = 1; i <= n; i++) {

					if (!__start && team[original.get(i)].changed) {
						__start = true;
						changeStart = i;
					}
					if (__start && !team[original.get(i)].changed) {
						__end = true;
						changeEnd = i - 1;
					}
					if (team[original.get(i)].changed) {
						changedCount++;
					}
					if (__start && __end && team[original.get(i)].changed) {
						impossible = true;
						break;
					}
				}

				if (!impossible) {
					PriorityQueue<Team> q = new PriorityQueue<Team>();
					for (int i = 1; i <= n; i++) {
						if (team[i].changed && inDegree[team[i].num] == 0) {
							q.offer(team[i]);
						}
					}
					int count = 0;
					while (!q.isEmpty()) {
						count++;
						Team tt = q.poll();
						int nodeNum = tt.num;
						// sb.append(nodeNum + " ");
						results.offer(nodeNum);
						ArrayList<Integer> edges = nodes.get(nodeNum);
						int childrenSize = edges.size();
						for (int j = 0; j < childrenSize; j++) {
							int linked = edges.get(j);
							if (--inDegree[linked] == 0) {
								q.offer(team[linked]);
							}
						}
					}
					if (count != changedCount) {
						strange = true;
					}
				}
			}
			if (m == 0) {
				System.out.println(sb);
			} else if (strange) {
				System.out.println("?");
			} else if (impossible) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (int i = 1; i < changeStart; i++) {
					if (!team[original.get(i)].changed) {
						sb.append(team[original.get(i)].num + " ");
					}
				}

				while (!results.isEmpty()) {
					sb.append(results.poll() + " ");
				}

				for (int i = changeEnd; i <= n; i++) {
					if (!team[original.get(i)].changed) {
						sb.append(team[original.get(i)].num + " ");
					}
				}

				System.out.println(sb);
			}
		}
	}

	static void printNodes() {
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
			ArrayList<Integer> edges = nodes.get(i);
			int childrenSize = edges.size();
			for (int j = 0; j < childrenSize; j++) {
				System.out.print(edges.get(j));
			}
			System.out.println();
		}
	}

	static void printInDegree() {
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " " + inDegree[i]);
		}
	}

	static class Team implements Comparable<Team> {
		int num, last;
		boolean changed;

		Team(int num, int last) {
			this.num = num;
			this.last = last;
			this.changed = false;
		}

		@Override
		public int compareTo(Team o) {
			if (this.last < o.last) {
				return -1;
			}

			if (this.last > o.last) {
				return 1;
			}

			return 0;
		}
	}
}
