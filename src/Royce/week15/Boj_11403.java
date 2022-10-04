package Royce.week15;

//2022.10.04
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/11403

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11403 {
	private static List<Integer>[] nodes;
	private static int[][] answerBoard;
	private static boolean[] visited;
	private static int startNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodes = new ArrayList[N];
		answerBoard = new int[N][N];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int to = Integer.parseInt(st.nextToken());
				if (to == 1) {
					nodes[i].add(j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			startNode = i;
			visited = new boolean[N];
			dfs(i);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%d ", answerBoard[i][j]);
			}
			System.out.println();
		}
	}

	private static void dfs(int i) {
		if (visited[i]) {
			return;
		}

		if (nodes[i].isEmpty()) {
			return;
		}

		List<Integer> children = nodes[i];
		for (Integer child : children) {
			visited[i] = true;
			dfs(child);
			answerBoard[startNode][child] = 1;
		}
	}
}
