package Royce.week14;

//2022.09.22
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1389

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Boj_1389 {

	private static HashSet<Integer>[] listArr;
	private static int minKevinBaconCount = Integer.MAX_VALUE;
	private static int answer = 0;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		listArr = new HashSet[N + 1];
		for (int i = 1; i < N + 1; i++) {
			listArr[i] = new HashSet<>();
		}

		for (int i = 0; i < M; i++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);
			listArr[A].add(B);
			listArr[B].add(A);
		}

		for (int i = 1; i < N + 1; i++) {
			Deque<Integer[]> deque = new ArrayDeque<>();
			deque.offer(new Integer[] {i, 0});
			visited = new boolean[N + 1];
			int kevinBaconCount = 0;

			while (!deque.isEmpty()) {
				Integer[] poll = deque.poll();
				int index = poll[0];
				int weight = poll[1];
				kevinBaconCount += weight;
				HashSet<Integer> friends = listArr[index];
				if (friends.isEmpty()) {
					continue;
				}

				for (Integer friend : friends) {
					if (visited[friend]) {
						continue;
					}
					visited[friend] = true;
					deque.offer(new Integer[] {friend, weight + 1});
				}
			}

			if (kevinBaconCount < minKevinBaconCount) {
				minKevinBaconCount = kevinBaconCount;
				answer = i;
			}
		}

		System.out.println(answer);
	}
}