package minsung.week07;

// 2022.08.03 minsung
// 프로그래머스 - k 진수로 바꾸기

public class Programmers_FindPrimeNumber {
    public static void main(String[] args) {
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k){
        int cnt = 0;

        String kNum = Integer.toString(n,k);
        String[] arr = kNum.split("0");

        for (String data : arr) {
            if(data.equals("")) continue;
            long tmp = Long.parseLong(data);
            if(isPrimeNumber(tmp)) cnt++;
        }
        return cnt;
    }

    public static boolean isPrimeNumber(long n){
        if(n<2){
            return false;
        }

        for (int i = 2; i <= (long)Math.sqrt(n); i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
