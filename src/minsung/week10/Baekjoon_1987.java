package minsung.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon_1987 {
    static int r, c;
    static char[][] board;
    static HashSet<Character> isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        isVisited = new HashSet<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        dfs(0,0,0);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt) {
        if (isVisited.contains(board[x][y])) {
            max = Math.max(max, cnt);

        } else {
            isVisited.add(board[x][y]);
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }

                dfs(nx, ny, cnt + 1);
            }
            isVisited.remove(board[x][y]);
        }
    }
}
