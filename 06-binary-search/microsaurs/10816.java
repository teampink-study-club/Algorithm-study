import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(m-- > 0) {
            int target = Integer.parseInt(st.nextToken());

            int lower = lowerBound(arr, target);
            int upper = upperBound(arr, target);

            sb.append(upper - lower).append(" ");
        }

        System.out.println(sb);
    }

    // 처음 등장 위치
    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] > target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
