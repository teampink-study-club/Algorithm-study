import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x < k) {
                arr[i] = 0;
            } else if (x < 2 * k) {
                arr[i] = x - k;
            } else {
                arr[i] = x - 2 * k;
            }

            max = Math.max(arr[i], max);
        }

        if(max == 0) {
            System.out.println(-1);
            return;
        }

        int left = 1;
        int right = max;
        int answer = -1;
        
        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for(int len : arr) {
                count += len / mid;
            }

            if(count >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
