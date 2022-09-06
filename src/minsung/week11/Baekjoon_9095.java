package minsung.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9095 {
    static int[] dp = new int[12];

    public static void main(String[] args) throws IOException {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(getCnt(n));
        }

    }

    public static int getCnt(int n){
        if(dp[n] == 0){
            dp[n] = getCnt(n - 1) + getCnt(n - 2) + getCnt(n - 3);
        }

        return dp[n];
    }
}
