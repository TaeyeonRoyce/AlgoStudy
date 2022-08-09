package Royce.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_8896 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			System.out.println(solution(br));
		}
	}

	private static int solution(BufferedReader br) throws IOException {
		int N = Integer.parseInt(br.readLine());
		boolean[] defeatRobot = new boolean[N];
		
		char[][] RSPInfo = new char[N][30];
		for (int i = 0; i < N; i++) {
			RSPInfo[i] = br.readLine().toCharArray();
		}
		int k = RSPInfo[0].length;

		for (int i = 0; i < k; i++) {
			char[] singleGame = new char[N];
			boolean[] RSP = new boolean[3];

			for (int j = 0; j < N; j++) {
				if (defeatRobot[j]) {
					continue;
				}
				char game = RSPInfo[j][i];
				if (game == 'R') {
					RSP[0] = true;
				} else if (game == 'S') {
					RSP[1] = true;
				} else if (game == 'P') {
					RSP[2] = true;
				}

				singleGame[j] = game;
			}

			int cnt = 0;
			for (boolean b : RSP) {
				if (b == false) {
					cnt++;
				}
			}

			//승패가 난 경우
			if (cnt == 1) {
				if (RSP[0] && RSP[1]) { //Rock, Scissor
					for (int j = 0; j < N; j++) {
						if (RSPInfo[j][i] == 'R') {
							continue;
						} else {
							defeatRobot[j] = true;
						}
					}
				} else if (RSP[0] && RSP[2]) { //Rock, Paper
					for (int j = 0; j < N; j++) {
						if (RSPInfo[j][i] == 'P') {
							continue;
						} else {
							defeatRobot[j] = true;
						}
					}
				} else if (RSP[1] && RSP[2]) { //Scissor, Paper
					for (int j = 0; j < N; j++) {
						if (RSPInfo[j][i] == 'S') {
							continue;
						} else {
							defeatRobot[j] = true;
						}
					}
				}
			} else {
				continue;
			}
		}

		int winnerRobot = 0;
		for (int i = 0; i < N; i++) {
			if (!defeatRobot[i] && winnerRobot == 0) {
				winnerRobot = i + 1;
			} else if (!defeatRobot[i] && winnerRobot != 0) {
				return 0;
			}
		}

		return winnerRobot;
	}
}
