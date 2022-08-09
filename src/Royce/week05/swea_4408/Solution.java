package Royce.week05.swea_4408;

//2022.07.25
//Created by TaeyeonRoyce
//Link - https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcJ2sapZMDFAV8


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	private static List<RoomFromTo> infos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = solution(br);
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static int solution(BufferedReader br) throws IOException {
		int N = Integer.parseInt(br.readLine());
		infos = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] fromTo = br.readLine().split(" ");
			int from = Integer.parseInt(fromTo[0]);
			int to = Integer.parseInt(fromTo[1]);
			if (from > to) {
				infos.add(new RoomFromTo(to, from));
			} else {
				infos.add(new RoomFromTo(from, to));
			}
		}

		Collections.sort(infos);

		int answer = 0;
		int to = 0;
		for (int i = 0; i < N; i++) {
			if (!infos.get(i).finished) {
				RoomFromTo roomFromTo = infos.get(i);
				roomFromTo.finished = true;
				for (int j = i + 1; j < N; j++) {
					RoomFromTo roomFromToNext = infos.get(j);
					to = ((int) (roomFromTo.to + 1) / 2) * 2;
					if (to < roomFromToNext.from && !roomFromToNext.finished) {
						roomFromToNext.finished = true;
						roomFromTo = roomFromToNext;
					}
				}
				answer += 1;
			}
		}

		return answer;
	}
}

class RoomFromTo implements Comparable<RoomFromTo> {

	int from;
	int to;

	boolean finished = false;

	public RoomFromTo(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(RoomFromTo o) {
		return from - o.from;
	}

}
