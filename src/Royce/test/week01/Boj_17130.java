package Royce.test.week01;

//2023.07.02
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/17130

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17130 {

    private static final char DOOR = 'R';
    private static final char WALL = '#';
    private static final char CARROT = 'C';
    private static final char OUTDOOR = 'O';
    private static int N;
    private static int M;

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer NM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());

        boolean noExit = true;
        final int[][] memo = new int[N][M];
        final char[][] board = new char[N][M];
        final List<int[]> outdoorPositions = new ArrayList<>();
        int startRow = 0;
        int startColumn = 0;

        for (int i = 0; i < N; i++) {
            final char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                final char letter = chars[j];
                if (letter == OUTDOOR) {
                    if (noExit) {
                        noExit = false;
                    }

                    outdoorPositions.add(new int[]{i, j});
                }

                if (letter == DOOR) {
                    startRow = i;
                    startColumn = j;
                    memo[startRow][startColumn] = 1;
                }

                board[i][j] = letter;
            }
        }

        if (noExit) {
            System.out.println(-1);
            return;
        }

        for (int i = startColumn; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[j][i] == WALL) {
                    continue;
                }
                for (final Move move : Move.values()) {
                    final int prevRow = j - move.rowMove;
                    final int prevColumn = i - move.columnMove;
                    if (prevRow < 0 || prevRow > N - 1
                            || prevColumn < 0 || prevColumn > M - 1
                            || memo[prevRow][prevColumn] < 1) {
                        continue;
                    }

                    if (board[j][i] == CARROT) {
                        memo[j][i] = Math.max(memo[prevRow][prevColumn] + 1, memo[j][i]);
                        continue;
                    }

                    memo[j][i] = Math.max(memo[prevRow][prevColumn], memo[j][i]);
                }
            }
        }

        int answer = 0;
        for (final int[] outdoorPosition : outdoorPositions) {
            final int row = outdoorPosition[0];
            final int column = outdoorPosition[1];

            answer = Math.max(memo[row][column], answer);
        }

        if (answer == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer - 1);
    }

    private enum Move {
        LEFT(0, 1),
        LEFT_UP(-1, 1),
        LEFT_DOWN(1, 1),
        ;

        private final int rowMove;
        private final int columnMove;

        Move(final int rowMove, final int columnMove) {
            this.rowMove = rowMove;
            this.columnMove = columnMove;
        }
    }
}
