package Royce.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//2022.07.20
//Created by TaeyeonRoyce

//Link https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14zIwqAHwCFAYD
public class SWEA_LinkedListCommand {

	private static final String INSERT = "I";
	private static final String DELETE = "D";
	private static final String ADD = "A";

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.printf("#%d ", test_case);
			int[] answer = solution(br);
			for (int i : answer) {
				System.out.printf("%d ", i);
			}
			System.out.println();
		}
	}

	private static int[] solution(BufferedReader br) throws IOException {
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> codes = new LinkedList<>();
		StringTokenizer codeSt = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			codes.add(Integer.parseInt(codeSt.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		StringTokenizer commandSt = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {

			String command = commandSt.nextToken();
			if (command.equals(INSERT)) {
				int x = Integer.parseInt(commandSt.nextToken());
				int y = Integer.parseInt(commandSt.nextToken());
				for (int j = 0; j < y; j++) {
					codes.add(x + j, Integer.parseInt(commandSt.nextToken()));
				}
			} else if (command.equals(DELETE)) {
				int x = Integer.parseInt(commandSt.nextToken());
				int y = Integer.parseInt(commandSt.nextToken());
				for (int j = 0; j < y; j++) {
					codes.remove(x);
				}
			} else if (command.equals(ADD)) {
				int y = Integer.parseInt(commandSt.nextToken());
				for (int j = 0; j < y; j++) {
					int s = Integer.parseInt(commandSt.nextToken());
					codes.add(s);
				}
			}
		}

		int[] answer = new int[10];
		for (int i = 0; i < 10; i++) {
			answer[i] = codes.get(i);
		}

		return answer;
	}
}
