package minsung.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int x1, y1, r1, x2, y2, r2;
        int result = 0;

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            int radiusSum = r1 + r2;
            int radiusSub = Math.abs(r1 - r2);
            double distance = getDistance(x1, y1, x2, y2);

            if (distance > radiusSum) {
                result = 0;
            } else if (distance < radiusSum) {
                if (distance == 0) {
                    if (r1 == r2) {
                        result = -1;
                    } else {
                        result = 0;
                    }
                } else {
                    result = 2;
                }
            } else if (distance == radiusSum || distance == radiusSub) {
                result = 1;
            }

            System.out.println(result);
        }


    }

    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
