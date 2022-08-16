package minsung.week08;

// 백준 1010 - 다리놓기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(combination(n, m));
        }
    }

    public static long combination(int n, int m) {
        if (m / 2 < n) {
            n = m - n;
        }

        long tmpM = 1;
        long tmpN = 1;
        int cnt = 0;

        while (true) {
            if (cnt == n) {
                break;
            }
            tmpM = tmpM * m;
            m--;
            cnt++;
        }

        for (int i = 1; i < n + 1; i++) {
            tmpN *= i;
        }

        long result = tmpM / tmpN;
        return result;
    }
}
