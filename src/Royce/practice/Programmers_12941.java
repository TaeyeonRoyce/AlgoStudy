package Royce.practice;

//2023.06.20
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/12941?language=java

import java.util.Arrays;

public class Programmers_12941 {

    public static void main(final String[] args) {
        final TestCase testCase = TestCase.SECOND;

        final int result = solution(testCase.firstArr, testCase.secondArr);
        System.out.println(result);
    }

    private static int solution(final int[] A, final int[] B) {
        final int size = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for (int i = 0; i < size; i++) {
            answer += A[i] * B[size - i - 1];
        }

        return answer;
    }

    private enum TestCase {
        FIRST(new int[]{1, 4, 2}, new int[]{5, 4, 4}),
        SECOND(new int[]{1, 2}, new int[]{3, 4}),
        ;

        private final int[] firstArr;
        private final int[] secondArr;

        TestCase(final int[] firstArr, final int[] secondArr) {
            this.firstArr = firstArr;
            this.secondArr = secondArr;
        }
    }
}
