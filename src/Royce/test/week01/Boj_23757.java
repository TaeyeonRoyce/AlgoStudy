package Royce.test.week01;

//2023.07.02
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/23757

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_23757 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer NM = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(NM.nextToken());
        final int M = Integer.parseInt(NM.nextToken());

        final PriorityQueue<Integer> boxAmount = new PriorityQueue<>((o1, o2) -> o2 - o1);

        final StringTokenizer boxAmountSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            boxAmount.add(Integer.parseInt(boxAmountSt.nextToken()));
        }

        final StringTokenizer needAmountSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            final int requirement = Integer.parseInt(needAmountSt.nextToken());
            final int provide = boxAmount.poll();

            if (provide > requirement) {
                boxAmount.add(provide - requirement);
            }

            if (provide < requirement) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
