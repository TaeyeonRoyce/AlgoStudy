package minsung.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Baekjoon_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new ArrayDeque<>();
            boolean isReversed = false;
            boolean isError = false;

            StringTokenizer st = new StringTokenizer(br.readLine(), "[|,|]");
            while (st.hasMoreTokens()) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    if (isReversed) {
                        isReversed = false;
                    } else {
                        isReversed = true;
                    }
                } else if (p.charAt(j) == 'D') {
                    if (isReversed) {
                        if (dq.pollLast() == null) {
                            isError = true;
                            break;
                        }
                    } else {
                        if (dq.poll() == null) {
                            isError = true;
                            break;
                        }
                    }
                }
            }

            StringJoiner sj = new StringJoiner(",","[","]");
            if(getRCount(p)%2 == 0){
                while(!dq.isEmpty()){
                    sj.add(dq.poll()+"");
                }
            }else{
                while(!dq.isEmpty()){
                    sj.add(dq.pollLast()+"");
                }
            }

            System.out.println(isError ? "error" : sj.toString());
        }
    }

    public static int getRCount(String p){
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == 'R'){
                cnt++;
            }
        }
        return cnt;
    }
}
