package minsung.week08;

// 백준 2869 - 달팽이는 올라가고 싶다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int result = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0) {
            result++;
        }

        System.out.println(result);
    }
}
