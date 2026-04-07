import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ice = new int[1000001];
        int maxPos = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int amount = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            ice[pos] = amount;
            maxPos = Math.max(maxPos, pos);
        }

        long sum = 0;
        int windowSize = 2*K+1;

        for(int i=0; i<=Math.min(2*K, maxPos); i++) {
            sum += ice[i];
        }

        long maxSum = sum;

        for(int i=2*K+1; i<=maxPos + 2*K; i++) {
            if(i <= maxPos) {
                sum += ice[i];
            }
            if(i - windowSize >= 0) {
                sum -= ice[i - windowSize];
            }

            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    
    }
}
