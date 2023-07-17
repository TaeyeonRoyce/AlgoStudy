package Royce.test.week03;

//2023.07.17
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/5545

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_5545 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer AB = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(AB.nextToken());
        final int B = Integer.parseInt(AB.nextToken());
        final int C = Integer.parseInt(br.readLine());
        final int[] clas = new int[N];

        for (int i = 0; i < N; i++) {
            clas[i] = Integer.parseInt(br.readLine());
        }

        final List<Integer> clasReversedOrder = Arrays.stream(clas)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        int cal = C;
        int price = A;

        int answer = C / A;

        for (final int calories : clasReversedOrder) {
            final int calCandidate = cal + calories;
            final int priceCandidate = price + B;
            final int answerCandidate = calCandidate / priceCandidate;
            if (answerCandidate >= answer) {
                cal = calCandidate;
                price = priceCandidate;
                answer = answerCandidate;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }
}
