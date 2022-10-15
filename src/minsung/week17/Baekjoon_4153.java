package minsung.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x = 0;
        int y = 0;
        int z = 0;

        while (true){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            if(a == 0 && b == 0 && c == 0){
                break;
            }

            if(a > b && a > c){
                x = a;
                y = b;
                z = c;
            }else if(b > a && b > c){
                x = b;
                y = a;
                z = c;
            }else if(c > a && c > b){
                x = c;
                y = a;
                z = b;
            }

            if(isRightTriangle(x, y, z)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }

        }
    }

    public static boolean isRightTriangle(int a, int b, int c){
        if(Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)){
            return true;
        } else{
            return false;
        }
    }
}
