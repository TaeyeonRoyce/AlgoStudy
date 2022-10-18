package Royce.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//2022.10.12
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1043

public class Boj_1043 {

	private static HashSet<Integer> avoidMember;
	private static int[] parentInfos;
	private static HashSet<Integer>[] partySet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		avoidMember = new HashSet<>();
		parentInfos = new int[N + 1];
		partySet = new HashSet[M];

		for (int i = 0; i < M; i++) {
			partySet[i] = new HashSet<>();
		}

		for (int i = 1; i < N + 1; i++) {
			parentInfos[i] = i;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int truthAmount = Integer.parseInt(st.nextToken());
		if (truthAmount == 0) {
			System.out.println(M);
			return;
		}

		for (int i = 0; i < truthAmount; i++) {
			avoidMember.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			String[] partyInfos = br.readLine().split(" ");
			int memberSize = Integer.parseInt(partyInfos[0]);
			if (memberSize == 1) {
				partySet[i].add(Integer.parseInt(partyInfos[1]));
				continue;
			}

			for (int j = 1; j < memberSize; j++) {
				int a = Integer.parseInt(partyInfos[j]);
				int b = Integer.parseInt(partyInfos[j + 1]);

				if (findHead(a) != findHead(b)) {
					union(a, b);
				}

				partySet[i].add(a);
				partySet[i].add(b);
			}
		}

		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (avoidMember.contains(i) && !visited[i]) {
				int head = findHead(i);
				for (int j = 0; j < parentInfos.length; j++) {
					if (findHead(j) == head) {
						avoidMember.add(j);
						visited[j] = true;
					}
				}
			}
		}

		int answer = M;
		for (HashSet<Integer> singleParty : partySet) {
			for (Integer member : singleParty) {
				if (avoidMember.contains(member)) {
					answer -= 1;
					break;
				}
			}
		}

		System.out.println(answer);
	}

	private static int findHead(int a) {
		if (parentInfos[a] == a) {
			return a;
		}
		parentInfos[a] = findHead(parentInfos[a]);
		return parentInfos[a];
	}

	private static void union(int a, int b) {
		int headB = findHead(b);
		parentInfos[headB] = a;
	}
}
