package minsung.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1149 {

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        dp = new int[n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(getCost(n-1, RED), Math.min(getCost(n-1, GREEN), getCost(n-1, BLUE))));
    }

    static int getCost(int n, int color){
        if(dp[n][color] == 0){
            if(color == RED){
                dp[n][RED] = Math.min(getCost(n-1, GREEN), getCost(n-1, BLUE)) + cost[n][RED];
            } else if(color == GREEN){
                dp[n][GREEN] = Math.min(getCost(n-1, RED), getCost(n-1, BLUE)) + cost[n][GREEN];
            }else{
                dp[n][BLUE] = Math.min(getCost(n-1, GREEN), getCost(n-1, RED)) + cost[n][BLUE];
            }
        }
        return dp[n][color];
    }

}
