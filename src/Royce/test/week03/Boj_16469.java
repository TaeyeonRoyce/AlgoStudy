package Royce.test.week03;

//2023.07.17
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/16469

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_16469 {
    /*
    5 5
    00011
    01011
    00110
    00001
    10100
    1 1
    5 5
    5 2
     */
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer NM = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(NM.nextToken());
        final int M = Integer.parseInt(NM.nextToken());

        final boolean[][] board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            final String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("1")) {
                    board[i][j] = true;
                }
            }
        }

        final int[][][] infos = new int[N][M][3];
        for (int i = 0; i < 3; i++) {
            final StringTokenizer rowCol = new StringTokenizer(br.readLine());
            final int R = Integer.parseInt(rowCol.nextToken()) - 1;
            final int C = Integer.parseInt(rowCol.nextToken()) - 1;
            final Deque<int[]> deque = new ArrayDeque<>();
            deque.offer(new int[]{R, C, 1});
            infos[R][C][i] = 1;
            while (!deque.isEmpty()) {
                final int[] poll = deque.poll();
                final int row = poll[0];
                final int col = poll[1];
                final int moves = poll[2];

                for (final Move move : Move.values()) {
                    final int nextRow = row + move.rowMove;
                    final int nextCol = col + move.columnMove;

                    if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1
                            || board[nextRow][nextCol]
                            || infos[nextRow][nextCol][i] != 0) {
                        continue;
                    }

                    deque.offer(new int[]{nextRow, nextCol, moves + 1});
                    infos[nextRow][nextCol][i] = moves + 1;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int amount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (infos[i][j][0] == 0
                        || infos[i][j][1] == 0
                        || infos[i][j][2] == 0) {
                    continue;
                }

                final int max = Math.max(Math.max(infos[i][j][0], infos[i][j][1]), infos[i][j][2]);
                if (max < answer) {
                    answer = max;
                    amount = 1;
                    continue;
                }
                if (max == answer) {
                    amount += 1;
                }

            }
        }

        if (amount == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer - 1);
        System.out.println(amount);
    }

    private enum Move {
        LEFT(0, -1),
        RIGHT(0, 1),
        UP(-1, 0),
        DOWN(1, 0),
        ;

        private final int rowMove;
        private final int columnMove;

        Move(final int rowMove, final int columnMove) {
            this.rowMove = rowMove;
            this.columnMove = columnMove;
        }
    }
}
