package Royce.test.week03;

//2023.07.17
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/26069

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_26069 {

    public static final String CHONG = "ChongChong";

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final Set<String> dance = new HashSet<>();
        dance.add(CHONG);
        for (int i = 0; i < N; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final String from = st.nextToken();
            final String to = st.nextToken();

            if (dance.contains(from) || dance.contains(to)) {
                dance.add(from);
                dance.add(to);
            }
        }

        System.out.println(dance.size());
    }
}
