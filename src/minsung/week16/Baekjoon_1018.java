package minsung.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1018 {
    static char[][] board;
    static int min = 64;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int row = n - 7;
        int column = m - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
        
    }

    public static void find(int x, int y){
        int endX = x + 8;
        int endY = y + 8;
        int cnt = 0;

        char firstColor = board[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if(board[i][j] == firstColor){
                    cnt++;
                }

                if(firstColor == 'W'){
                    firstColor = 'B';
                }else if(firstColor == 'B'){
                    firstColor = 'W';
                }
            }

            if(firstColor == 'W'){
                firstColor = 'B';
            }else if(firstColor == 'B'){
                firstColor = 'W';
            }
        }

        cnt = Math.min(cnt, 64 - cnt);

        min = Math.min(min, cnt);
    }

}
