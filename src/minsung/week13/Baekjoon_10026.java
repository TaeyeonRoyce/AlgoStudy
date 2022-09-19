package minsung.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon_10026 {
    static int n;
    static char[][] arr;
    static boolean[][] isVisited;
    static Deque<int[]> dq;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String tmpStr = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmpStr.charAt(j);
            }
        }

        char[][] arr1 = getCopyArr(arr);
        char[][] arr2 = getCopyArr(arr);

        Person p1 = new Person(arr1, false);
        Person p2 = new Person(arr2, true);


        executeBfs(p1);
        isVisited = new boolean[n][n];
        executeBfs(p2);
        System.out.println(p1.cnt + " " + p2.cnt);

    }

    public static void executeBfs(Person p2) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!isVisited[i][j]){
                    bfs(i, j, p2.arr);
                    p2.cnt++;
                }
            }
        }
    }

    public static void bfs(int x, int y, char[][] arr){
        dq = new ArrayDeque<>();
        int[] pos = {x,y};
        dq.add(pos);
        isVisited[x][y] = true;

        while(!dq.isEmpty()){
            int[] tmp = dq.poll();
            x = tmp[0];
            y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                    continue;
                }
                if(isVisited[nx][ny]){
                    continue;
                }
                if(arr[x][y] != arr[nx][ny]){
                    continue;
                }

                if(arr[x][y] == arr[nx][ny]){
                    isVisited[nx][ny] = true;
                    int[] tmp2 = {nx, ny};
                    dq.add(tmp2);
                }
            }
        }
    }

    public static char[][] getCopyArr(char[][] arr){
        char[][] copyArr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        return copyArr;
    }

    static class Person{
        char[][] arr;
        int cnt = 0;

        public Person(char[][] arr, boolean isRedGreenBlindness) {
            if(isRedGreenBlindness){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(arr[i][j] == 'R'){
                            arr[i][j] = 'G';
                        }
                    }
                }
            }
            this.arr = arr;
        }
    }
}
