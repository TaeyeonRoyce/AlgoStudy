package Royce.practice;

//2023.06.22
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/12924?language=java

public class Programmers_12924 {

    public static void main(final String[] args) {
        final TestCase testCase = TestCase.SECOND;

        final int result = solution(testCase.n);
        System.out.println(result);
    }

    private static int solution(final int n) {
        int head = 1;
        int tail = 1;
        int sum = 1;
        int answer = 0;
        while (head <= n) {
            if (sum == n) {
                answer += 1;
                sum -= head;
                head += 1;
            } else if (sum < n) {
                tail += 1;
                sum += tail;
            } else {
                sum -= head;
                head += 1;
            }

        }
        return answer;
    }

    private enum TestCase {
        FIRST(15),
        SECOND(12),
        ;

        private final int n;

        TestCase(final int n) {
            this.n = n;
        }
    }
}
