import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dolls = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int ryanCount = 0;
        int minSize = Integer.MAX_VALUE;

        for(int right=0; right<N; right++) {
            if(dolls[right] == 1) {
                ryanCount++;
            }

            while(ryanCount >= K) {
                minSize = Math.min(minSize, right-left+1);

                if(dolls[left] == 1) {
                    ryanCount--;
                }
                left++;
            }
        }
        System.out.println(minSize == Integer.MAX_VALUE ? -1 : minSize);
    
    }
}
