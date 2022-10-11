package Royce.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//2022.10.10
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/16928
public class Boj_16928 {


	private static int[] visited;
	private static Map<Integer, Integer> ladders;
	private static Map<Integer, Integer> snakes;

	private static int[] diceValues = new int[] {1, 2, 3, 4, 5, 6};
	public static void main(String[] args) throws IOException {
		visited = new int[101];
		ladders = new HashMap<>();
		snakes = new HashMap<>();
		for (int i = 1; i < 101; i++) {
			visited[i] = Integer.MAX_VALUE;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[] {0, 1}); //횟수, 위치

		while (!deque.isEmpty()) {
			int[] poll = deque.poll();
			for (int i = 0; i < 6; i++) {
				int count = poll[0] + 1;
				int nextLocation = poll[1] + diceValues[i];

				if (nextLocation > 100 || nextLocation < 1) {
					continue;
				}

				if (ladders.containsKey(nextLocation)) {
					nextLocation = ladders.get(nextLocation);
				} else if (snakes.containsKey(nextLocation)) {
					nextLocation = snakes.get(nextLocation);
				}

				if (nextLocation == 100) {
					System.out.println(count);
					return;
				}

				if (count < visited[nextLocation]) {
					visited[nextLocation] = count;
					deque.add(new int[] {count, nextLocation});
				}

			}
		}
	}
}
