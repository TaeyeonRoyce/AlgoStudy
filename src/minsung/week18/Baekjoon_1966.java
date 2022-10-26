package minsung.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int idx = 0;
            Deque<int[]> dq = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int value = Integer.parseInt(st.nextToken());
                int[] tmp = new int[] {idx, value};
                dq.addLast(tmp);
                idx++;
            }

            while(!dq.isEmpty()){
                if(isMax(dq)){
                    int[] printedPaper = dq.pollFirst();
                    cnt++;
                    if(printedPaper[0] == k){
                        break;
                    }
                }else{
                    dq.addLast(dq.pollFirst());
                }
            }

            System.out.println(cnt);

        }
    }

    public static boolean isMax(Deque<int[]> dq){
        for (int[] data : dq) {
            if(dq.peekFirst()[1] < data[1]){
                return false;
            }
        }
        return true;
    }
}
