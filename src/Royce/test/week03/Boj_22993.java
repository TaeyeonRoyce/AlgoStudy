package Royce.test.week03;

//2023.07.17
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/22993

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_22993 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int[] powers = new int[N - 1];
        final StringTokenizer st = new StringTokenizer(br.readLine());
        long devPower = Long.parseLong(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            powers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(powers);

        for (final long power : powers) {
            if (devPower > power) {
                devPower += power;
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
