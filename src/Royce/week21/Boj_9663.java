package Royce.week21;

//2022.11.14
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/9663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9663 {
    private static int N;
    public static int[] board;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];
        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int queen) {
        if (queen == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[queen] = i;
            if (isPlaced(queen)) {
                nQueen(queen + 1);
            }
        }
    }

    private static boolean isPlaced(int col) {
        for (int i = 0; i < col; i++) {
            if (board[col] == board[i]) {
                return false;
            }
            else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
