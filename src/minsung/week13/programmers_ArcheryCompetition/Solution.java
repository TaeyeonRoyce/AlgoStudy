package minsung.week13.programmers_ArcheryCompetition;

public class Solution {
    static int[] result = {-1};
    static int[] ryan;
    static int max = -1000;
    static final int MAX_ARR_LEN = 11;

    public static void main(String[] args) {
        int n = 10;
        int[] info = {0,0,0,0,0,0,0,0,3,4,3};

        int[] arr = solution(n, info);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] solution(int n, int[] info) {
        ryan = new int[MAX_ARR_LEN];
        dfs(info, 1, n);
        return result;
    }

    public static void dfs(int[] info, int cnt, int n) {
        if (cnt == n + 1) {
            int aScore = 0;
            int rScore = 0;

            for (int i = 0; i < MAX_ARR_LEN; i++) {
                if(info[i] != 0 || ryan[i] != 0){
                    if(info[i] < ryan[i]){
                        rScore +=  10 - i;
                    }else{
                        aScore += 10 - i;
                    }
                }
            }
            if(rScore > aScore){
                if(rScore - aScore >= max){
                    result = ryan.clone();
                    max = rScore - aScore;
                }
            }
            return;
        }
        for (int i = 0; i < MAX_ARR_LEN && ryan[i] <= info[i]; i++) {
            ryan[i]++;
            dfs(info, cnt+1, n);
            ryan[i]--;
        }
    }

}
