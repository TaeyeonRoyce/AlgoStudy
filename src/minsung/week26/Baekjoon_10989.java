package minsung.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx]++;
        }

        for (int i = 1; i < 10001; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.println(i);
            }
        }
    }
}
