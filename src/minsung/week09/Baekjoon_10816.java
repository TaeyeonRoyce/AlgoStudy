package minsung.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int max = maxBinarySearch(arr, n, arr2[i]);
            int min = minBinarySearch(arr, n, arr2[i]);
            int result = max - min;
            sb.append(result + " ");
        }
        System.out.println(sb);
    }

    public static int minBinarySearch(int[] arr, int n, int find) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= find) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int maxBinarySearch(int[] arr, int n, int find) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > find) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
