package Royce.practice;

//2023.06.16
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=java

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Programmers_138476 {

    public static void main(final String[] args) {
        final TestCase testCase = TestCase.FIRST;

        final int result = solution(testCase.k, testCase.tangerine);
        System.out.println(result);
    }

    private static int solution(int k, final int[] tangerine) {
        final Map<Integer, Integer> amountByTangerineSize = new HashMap<>();
        for (final int size : tangerine) {
            final Integer count = amountByTangerineSize.getOrDefault(size, 0) + 1;
            amountByTangerineSize.put(size, count);
        }

        final List<Integer> sizeList = amountByTangerineSize.values()
                .stream()
                .sorted(((o1, o2) -> o2 - o1))
                .collect(Collectors.toList());

        int answer = 0;
        for (final int size : sizeList) {
            answer += 1;
            if (size >= k) {
                return answer;
            }

            k -= size;
        }

        return answer;
    }

    private enum TestCase {
        FIRST(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}),
        SECOND(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}),
        THIRD(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}),
        ;

        private final int k;
        private final int[] tangerine;

        TestCase(final int k, final int[] tangerine) {
            this.k = k;
            this.tangerine = tangerine;
        }

        public int getK() {
            return k;
        }

        public int[] getTangerine() {
            return tangerine;
        }
    }
}
