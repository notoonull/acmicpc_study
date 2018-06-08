package acmicpc_1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static BufferedReader br;
	static StringTokenizer st;
	static int T, N, K;
	static int[] D;
	static int[] inDegree;
	static Queue<Integer> q;
	static ArrayList<ArrayList<Integer>> list;
	static int W;
	static int Time[];
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int __t = 1; __t <= T; __t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			D = new int[N + 1];
			inDegree = new int[N + 1];
			list = new ArrayList<ArrayList<Integer>>();
			list.add(null);

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
				list.add(new ArrayList<Integer>());
			}

			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				list.get(X).add(Y);
				inDegree[Y]++;
			}

			W = Integer.parseInt(br.readLine());

			// logic start
			Time = new int[N+1];			
			q = new LinkedList<Integer>();
			for (int i = 1; i <= N; i++) {				
				if (inDegree[i] == 0) {
					Time[i] = D[i];
					q.add(i);					
				}
			}
			
			boolean finish = false;
			while (!q.isEmpty() && !finish) {
				int here = q.poll();		
				
				Iterator<Integer> it = list.get(here).iterator();
				while(it.hasNext()) {
					int there = it.next();					
					Time[there] = Math.max(Time[there], Time[here] + D[there]);
					
					inDegree[there]--;
					if (inDegree[there] == 0) {
						if (there == W) {
							finish = true;
							break;
						} else if (list.get(there).size() > 0){
							q.add(there);
						}
					}
				}
			}
			
			System.out.println(Time[W]);

//			printList();
//			printInDegree();
		} // Test End
	} // Main End

	static void printList() {
		for (int i = 1; i <= K; i++) {
			Iterator<Integer> it = list.get(i).iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
	}
	
	static void printInDegree() {
		for (int i = 1; i <= N; i++) {
			System.out.println(inDegree[i]);
		}
	}
}
