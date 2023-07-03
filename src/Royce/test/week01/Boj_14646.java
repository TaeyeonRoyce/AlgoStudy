package Royce.test.week01;

//2023.07.02
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/14646

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_14646 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final Set<Integer> stickerSet = new HashSet<>();
        int answer = 0;
        int currentSize = 0;
        while (st.hasMoreTokens()) {
            final int menuNumber = Integer.parseInt(st.nextToken());
            if (stickerSet.contains(menuNumber)) {
                currentSize -= 1;
                stickerSet.remove(menuNumber);
                continue;
            }

            stickerSet.add(menuNumber);
            currentSize += 1;

            if (currentSize > answer) {
                answer = currentSize;
            }
        }

        System.out.println(answer);
    }
}
