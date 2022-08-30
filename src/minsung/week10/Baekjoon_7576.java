package minsung.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];
        ArrayList<int[]> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(box[i][j] == 1){
                    int[] tmp = {j, i};
                    points.add(tmp);
                }
            }
        }

        bfs(points, box);

        int result = box[0][0];

        loop1:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    result = 0;
                    break loop1;
                }
                if (box[i][j] > result) {
                    result = box[i][j];
                }
            }
        }

        System.out.println(result - 1);
    }

    public static void bfs(ArrayList<int[]> points, int[][] box) {
        int n = box.length;
        int m = box[0].length;
        int len = points.size();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            dq.add(points.get(i));
        }

        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if(box[ny][nx] == 0){
                    int[] tmp2 = {nx, ny};
                    dq.add(tmp2);
                    box[ny][nx] = box[y][x] + 1;
                }
            }
        }
    }


}
