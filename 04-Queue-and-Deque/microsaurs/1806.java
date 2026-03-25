import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for(int right=0; right < n; right++) {
            sum += arr[right];

            while(sum >= s) {
                answer = Math.min(answer, right-left+1);
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
