package Royce.test.week02;

//2023.07.08
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/21921

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_21921 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer NX = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(NX.nextToken());
        final int X = Integer.parseInt(NX.nextToken());

        final int[] viewCounts = new int[N];
        final StringTokenizer viewCountSt = new StringTokenizer(br.readLine());

        final Map<Integer, Integer> amountByViewCount = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < X; i++) {
            final int viewCount = Integer.parseInt(viewCountSt.nextToken());
            viewCounts[i] = viewCount;
            sum += viewCount;
        }
        int maxViewCount = sum;
        amountByViewCount.put(maxViewCount, 1);

        for (int i = X; i < N; i++) {
            viewCounts[i] = Integer.parseInt(viewCountSt.nextToken());
            sum -= viewCounts[i - X];
            sum += viewCounts[i];

            if (sum >= maxViewCount) {
                maxViewCount = sum;
                amountByViewCount.merge(maxViewCount, 1, Integer::sum);
            }
        }

        if (maxViewCount == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(maxViewCount);
        System.out.println(amountByViewCount.get(maxViewCount));
    }
}
