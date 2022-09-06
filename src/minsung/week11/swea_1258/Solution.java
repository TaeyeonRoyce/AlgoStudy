package minsung.week11.swea_1258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Solution {
    static int n;
    static int[][] matrix;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<ReturnValue> returnValues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            matrix = new int[n + 1][n + 1];
            isVisited = new boolean[n + 1][n + 1];
            returnValues = new ArrayList<>();
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                String[] tmp = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = Integer.parseInt(tmp[j - 1]);
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i][j] > 0 && !isVisited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            Collections.sort(returnValues);

            System.out.print("#" + t + " " + cnt + " ");
            for (int i = 0; i < returnValues.size(); i++) {
                System.out.print(returnValues.get(i).row + " " + returnValues.get(i).column + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {
        Deque<Node> dq = new ArrayDeque<>();
        isVisited[x][y] = true;
        matrix[x][y] = 0;
        int x1 = x;
        int y1 = y;
        int x2 = x;
        int y2 = y;

        dq.add(new Node(x, y));

        while (!dq.isEmpty()) {
            Node node = dq.poll();
            x = node.x;
            y = node.y;
            x2 = x;
            y2 = y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
                    continue;
                }

                if (matrix[nx][ny] > 0 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    matrix[nx][ny] = 0;
                    dq.add(new Node(nx, ny));
                }
            }
        }
        returnValues.add(new ReturnValue(x2 - x1, y2 - y1));
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ReturnValue implements Comparable<ReturnValue> {
    int row;
    int column;
    int size;

    ReturnValue(int row, int column) {
        this.row = row + 1;
        this.column = column + 1;
        this.size = this.row * this.column;
    }

    @Override
    public int compareTo(ReturnValue rv) {
        if (this.size > rv.size) {
            return 1;
        } else if (this.size < rv.size) {
            return -1;
        } else {
            if (this.row > rv.row) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}