package algorithms.week02;

public class Programmers_FineSquare {
	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}

	public static long solution(int w, int h) {
		//to Long Type
		// w <= 100,000,000 , h <= 100,000,000
		long longW = (long) w;
		long longH = (long) h;
		long wholeSquareCnt = longW * longH;

		//"w" should always be bigger than "h"
		if (longW < longH) {
			long tmp = longW;
			longW = longH;
			longH = tmp;
		}

		long gcd = findGCD(longW, longH);
		return wholeSquareCnt - (longW + longH - gcd);
	}

	private static long findGCD(long a, long b) {
		if (b == 0) {
			return a;
		}

		return findGCD(b, a % b);
	}
}
