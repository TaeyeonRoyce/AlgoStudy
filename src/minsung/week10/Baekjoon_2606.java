package minsung.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baekjoon_2606 {
    static int n;
    static int m;
    static int[][] edge;
    static boolean[] isVisited;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edge = new int[n + 1][n + 1];
        isVisited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a][b] = edge[b][a] = 1;
        }

        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int x){
        isVisited[x] = true;

        for (int i = 0; i < n + 1; i++) {
            if(!isVisited[i] && edge[x][i] == 1){
                dfs(i);
                cnt++;
            }
        }
    }

}
