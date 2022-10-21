package Royce.week18;

//2022.10.21
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/18352

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Boj_18352 {

	private static List<Integer>[] nodes;
	private static boolean[] visited;

	private static List<Integer> answerList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMKX = br.readLine().split(" ");
		int N = Integer.parseInt(NMKX[0]);
		int M = Integer.parseInt(NMKX[1]);
		int K = Integer.parseInt(NMKX[2]);
		int X = Integer.parseInt(NMKX[3]);

		nodes = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		answerList = new ArrayList<>();

		for (int i = 1; i < N + 1; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] roadInfo = br.readLine().split(" ");
			int from = Integer.parseInt(roadInfo[0]);
			int to = Integer.parseInt(roadInfo[1]);

			nodes[from].add(to);
		}

		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] {X, 0});
		visited[X] = true;
		while (!deque.isEmpty()) {
			int[] poll = deque.poll();
			int city = poll[0];
			int distance = poll[1];

			if (distance == K) {
				answerList.add(city);
			}


			List<Integer> node = nodes[city];
			for (Integer integer : node) {
				if (visited[integer]) {
					continue;
				}
				visited[integer] = true;
				deque.add(new int[] {integer, distance + 1});
			}
		}

		if (answerList.isEmpty()) {
			System.out.println(-1);
		}

		Collections.sort(answerList);
		for (Integer integer : answerList) {
			System.out.println(integer);
		}
	}
}
