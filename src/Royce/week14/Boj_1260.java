package Royce.week14;


//2022.09.26
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1260

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Boj_1260 {

	private static List<Integer>[] listArr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// 4 5 1
		// 1 2
		// 1 3
		// 1 4
		// 2 4
		// 3 4
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMV = br.readLine().split(" ");
		int N = Integer.parseInt(NMV[0]);
		int M = Integer.parseInt(NMV[1]);
		int V = Integer.parseInt(NMV[2]);
		listArr = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			listArr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);
			listArr[A].add(B);
			listArr[B].add(A);
		}

		for (List<Integer> integers : listArr) {
			Collections.sort(integers);
		}

		visited = new boolean[N + 1];
		dfs(V);

		System.out.println();
		visited = new boolean[N + 1];
		bfs(V);
	}

	private static void dfs(int at) {
		if (visited[at]) {
			return;
		}

		System.out.printf("%d ", at);
		visited[at] = true;
		List<Integer> integers = listArr[at];
		if (integers.isEmpty()) {
			return;
		}

		for (Integer integer : integers) {
			dfs(integer);
		}
	}

	private static void bfs(int at) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(at);

		visited[at] = true;
		System.out.printf("%d ", at);

		while (!deque.isEmpty()) {
			Integer poll = deque.poll();
			List<Integer> integers = listArr[poll];
			if (integers.isEmpty()) {
				continue;
			}

			for (Integer integer : integers) {
				if (visited[integer]) {
					continue;
				}
				visited[integer] = true;
				deque.offer(integer);
				System.out.printf("%d ", integer);
			}
		}
	}
}
