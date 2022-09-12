package minsung.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon_4963 {
    static int w;
    static int h;
    static int[][] map;
    static int nx;
    static int ny;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    static Deque<int[]> dq;
    static int cnt;

    static String[] tmpArr;
    static String[] tmpArr2;
    static int[] tmpPos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            tmpArr = br.readLine().split(" ");
            w = Integer.parseInt(tmpArr[0]);
            h = Integer.parseInt(tmpArr[1]);
            map = new int[h][w];
            cnt = 0;

            if (w == 0 && h == 0) {
                break;
            }

            for (int i = 0; i < h; i++) {
                tmpArr2 = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(tmpArr2[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    public static void bfs(int x, int y) {
        int[] startPos = {x, y};

        dq = new ArrayDeque();
        dq.add(startPos);

        while (!dq.isEmpty()){
            tmpPos = dq.poll();

            x = tmpPos[0];
            y = tmpPos[1];

            for (int i = 0; i < 8; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w){
                    continue;
                }

                if(map[nx][ny] == 0){
                    continue;
                }

                if(map[nx][ny] == 1){
                    tmpPos = new int[] {nx, ny};
                    dq.add(tmpPos);
                    map[nx][ny] = 0;
                }
            }
        }

    }
}
