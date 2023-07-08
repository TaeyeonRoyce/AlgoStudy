package Royce.test.week02;

//2023.07.08
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/17478

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17478 {

    private static final String A = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    private static final String B = "\"재귀함수가 뭔가요?\"";
    private static final String C = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    private static final String D = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    private static final String E = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    private static final String F = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    private static final String G = "라고 답변하였지.";
    private static final String H = "____";

    private static int N;

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(A);
        print(0);
    }

    private static void print(final int depth) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append(H);
        }
        final String prefix = sb.toString();
        System.out.println(prefix + B);
        if (depth == N) {
            System.out.println(prefix + F);
            System.out.println(prefix + G);
            return;
        }

        System.out.println(prefix + C);
        System.out.println(prefix + D);
        System.out.println(prefix + E);

        print(depth + 1);

        System.out.println(prefix + G);
    }
}
