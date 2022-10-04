package minsung.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9663 {
    static int n;
    static int[][] board;
    static boolean[][] canAttack;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        canAttack = new boolean[n][n];

        dfs(0);
        System.out.println(cnt);

    }

    public static void dfs(int k){
        if(k == n){
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!canAttack[k][i]){
                canAttack[k][i] = true;
                board[k][i] = 1;

                checkAttackablePos(k,i);

                dfs(k + 1);

                board[k][i] = 0;

                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        canAttack[j][l] = false;
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        if(board[j][l] == 1){
                            checkAttackablePos(j, l);
                        }
                    }
                }
            }
        }
    }

    public static void checkAttackablePos(int x, int y){
        for (int i = x; i < n; i++) {
            canAttack[i][y] = true;
        }

        int posX = x;
        int posY = y;

        while(true) {
            if(posX < 0 || posY < 0 || posX >= n || posY >= n){
                break;
            }
            canAttack[posX++][posY--] = true;
        }

        while(true){
            if(x < 0 || y < 0 || x >= n || y >= n){
                break;
            }
            canAttack[x++][y++] = true;
        }
    }
}
