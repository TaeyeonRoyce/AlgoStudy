package Royce.test.week03;

//2023.07.17
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/10164

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10164 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer NMK = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(NMK.nextToken());
        final int M = Integer.parseInt(NMK.nextToken());
        final int K = Integer.parseInt(NMK.nextToken());

        int checkRow = (K / M) + 1;
        int checkCol = K % M;
        if (K % M == 0) {
            checkRow -= 1;
            checkCol = M;
        }

        int[][] board = new int[N][M];
        int answer = 0;
        int preStep = 1;
        if (K != 0) {
            final int[][] secondaryBoard = new int[checkRow][checkCol];
            for (int i = 0; i < checkRow; i++) {
                secondaryBoard[i][0] = 1;
            }
            for (int i = 0; i < checkCol; i++) {
                secondaryBoard[0][i] = 1;
            }

            for (int i = 1; i < checkRow; i++) {
                for (int j = 1; j < checkCol; j++) {
                    secondaryBoard[i][j] = secondaryBoard[i - 1][j] + secondaryBoard[i][j - 1];
                }
            }

            answer += secondaryBoard[checkRow - 1][checkCol - 1];
            preStep = secondaryBoard[checkRow - 1][checkCol - 1];
            board = new int[N - checkRow + 1][M - checkCol + 1];
        }

        final int boardRow = board.length;
        final int boardCol = board[0].length;

        for (int i = 0; i < boardRow; i++) {
            board[i][0] = preStep;
        }
        for (int i = 0; i < boardCol; i++) {
            board[0][i] = preStep;
        }

        for (int i = 1; i < boardRow; i++) {
            for (int j = 1; j < boardCol; j++) {
                board[i][j] = board[i - 1][j] + board[i][j - 1];
            }
        }

        System.out.println(board[boardRow - 1][boardCol - 1]);
    }
}
