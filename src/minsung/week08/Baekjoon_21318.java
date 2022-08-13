package minsung.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] result = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        result[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i - 1];
            }
        }
        if (arr[n - 1] > arr[n]) {
            result[n] = result[n - 1] + 1;
        } else {
            result[n] = result[n - 1];
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] arr2 = br.readLine().split(" ");
            int x = Integer.parseInt(arr2[0]);
            int y = Integer.parseInt(arr2[1]);

            int answer = result[y] - result[x];

            System.out.println(answer);
        }

    }
}
