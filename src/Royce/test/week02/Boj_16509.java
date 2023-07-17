package Royce.test.week02;

//2023.07.08
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/16509

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_16509 {

    private static final int ROW_MAX = 10;
    private static final int COLUMN_MAX = 9;
    private static final int[][] memo = new int[ROW_MAX][COLUMN_MAX];

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer elephantRowColumn = new StringTokenizer(br.readLine());
        final int elephantRow = Integer.parseInt(elephantRowColumn.nextToken());
        final int elephantColumn = Integer.parseInt(elephantRowColumn.nextToken());

        final StringTokenizer kingRowColumn = new StringTokenizer(br.readLine());
        final int kingRow = Integer.parseInt(kingRowColumn.nextToken());
        final int kingColumn = Integer.parseInt(kingRowColumn.nextToken());
        for (int i = 0; i < ROW_MAX; i++) {
            for (int j = 0; j < COLUMN_MAX; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        final Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{elephantRow, elephantColumn, 0});

        while (!deque.isEmpty()) {
            final int[] pop = deque.pop();
            final int row = pop[0];
            final int column = pop[1];
            final int step = pop[2];

            for (final Move move : Move.values()) {
                int nextRow = row;
                int nextColumn = column;
                boolean isBlockedFlag = false;

                for (int i = 0; i < 3; i++) {
                    nextRow += move.directions[i].rowMove;
                    nextColumn += move.directions[i].columnMove;

                    if (nextRow == kingRow && nextColumn == kingColumn) {
                        if (i == 2) {
                            System.out.println(step + 1);
                            return;
                        }

                        isBlockedFlag = true;
                        break;
                    }
                }

                if (isBlockedFlag) {
                    continue;
                }

                if (nextRow >= ROW_MAX || nextRow < 0
                        || nextColumn >= COLUMN_MAX || nextColumn < 0) {
                    continue;
                }

                if (memo[nextRow][nextColumn] < step + 1) {
                    continue;
                }

                memo[nextRow][nextColumn] = step + 1;
                deque.offer(new int[]{nextRow, nextColumn, step + 1});
            }
        }

        System.out.println(-1);
    }

    private enum Move {
        UP_RIGHT(new Direction[]{Direction.UP, Direction.RIGHT_UP, Direction.RIGHT_UP}),
        UP_LEFT(new Direction[]{Direction.UP, Direction.LEFT_UP, Direction.LEFT_UP}),
        DOWN_RIGHT(new Direction[]{Direction.DOWN, Direction.RIGHT_DOWN, Direction.RIGHT_DOWN}),
        DOWN_LEFT(new Direction[]{Direction.DOWN, Direction.LEFT_DOWN, Direction.LEFT_DOWN}),
        LEFT_UP(new Direction[]{Direction.LEFT, Direction.LEFT_UP, Direction.LEFT_UP}),
        LEFT_DOWN(new Direction[]{Direction.LEFT, Direction.LEFT_DOWN, Direction.LEFT_DOWN}),
        RIGHT_UP(new Direction[]{Direction.RIGHT, Direction.RIGHT_UP, Direction.RIGHT_UP}),
        RIGHT_DOWN(new Direction[]{Direction.RIGHT, Direction.RIGHT_DOWN, Direction.RIGHT_DOWN}),
        ;

        private final Direction[] directions;

        Move(final Direction[] directions) {
            this.directions = directions;
        }
    }

    private enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        RIGHT(0, 1),
        LEFT(0, -1),
        LEFT_UP(-1, -1),
        LEFT_DOWN(1, -1),
        RIGHT_UP(-1, 1),
        RIGHT_DOWN(1, 1),
        ;

        private final int rowMove;
        private final int columnMove;

        Direction(final int rowMove, final int columnMove) {
            this.rowMove = rowMove;
            this.columnMove = columnMove;
        }
    }
}
