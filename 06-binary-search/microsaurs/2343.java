import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        // 가장 긴 강의 길이
        int left = 0;
        // 강의 길이 총합
        int right = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int answer = right;

        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 1; // 블루레이 개수
            int sum = 0;

            for(int i=0; i<n; i++) {
                if(sum + arr[i] > mid) {
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }

            if(count <= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
