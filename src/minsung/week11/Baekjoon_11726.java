package minsung.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11726 {
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(getCnt(n));

    }

    public static int getCnt(int n){
        if(dp[n] == 0){
            dp[n] = (getCnt(n-1) + getCnt(n-2)) % 10007;
        }

        return dp[n];
    }
}
