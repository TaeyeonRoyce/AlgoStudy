package Royce.week12;

public class Programmers_PrimeNumberFromK {

	public static void main(String[] args) {
		PrimeNumberFromKSolution solution = new PrimeNumberFromKSolution();
		int answer = solution.solution(1111111, 10);
		System.out.println(answer);
	}


}

class PrimeNumberFromKSolution {
	public int solution(int n, int k) {
		int answer = 0;
		String nString = Long.toString(n, k);
		String[] numbers = nString.split("0");
		for (String number : numbers) {
			if (number.isBlank()) {
				continue;
			}
			if (isPrimeNumber(Long.parseLong(number))) {
				answer += 1;
			}
		}

		return answer;
	}

	private boolean isPrimeNumber(Long number) {
		if (number <= 1) {
			return false;
		}

		long geometricHalf = (long)Math.sqrt(number) + 1;

		for (int i = 2; i < geometricHalf; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
